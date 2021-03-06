package hohserg.endothermic.mod

import hohserg.endothermic.example.java.{ColoredExample, SliceExample}
import hohserg.endothermic.quad.immutable.LazyUnpackedQuad
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util._
import net.minecraft.util.math.{AxisAlignedBB, BlockPos}
import net.minecraft.world.{IBlockAccess, World}
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

import scala.collection.JavaConverters._

object TestingStand extends BlockContainer(Material.GLASS) {
  setHardness(100)

  override def canRenderInLayer(state: IBlockState, layer: BlockRenderLayer): Boolean = true

  override def getCollisionBoundingBox(blockState: IBlockState, worldIn: IBlockAccess, pos: BlockPos): AxisAlignedBB = super.getCollisionBoundingBox(blockState, worldIn, pos)

  override def onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean = {
    playerIn.openGui(Title, 0, worldIn, pos.getX, pos.getY, pos.getZ)
    true
  }

  def reload(): Unit = {
    bechmarks = generateBechmarks()
    influence = generateInfluence()
  }

  var bechmarks: Map[String, List[BakedQuad]] = _
  var influence: Map[String, BakedQuad => BakedQuad] = _

  val ender_eye = "ender_eye"

  def generateBechmarks(): Map[String, List[BakedQuad]] =
    Map(
      ender_eye -> mc.getRenderItem.getItemModelWithOverrides(new ItemStack(Items.ENDER_EYE), mc.world, null).getQuads(null, null, 0).asScala.toList,
      "ender_eye_simplified" -> mc.getRenderItem.getItemModelWithOverrides(new ItemStack(Items.ENDER_EYE), mc.world, null).getQuads(null, null, 0).asScala.toList.slice(21, 22),
      "block" -> mc.getBlockRendererDispatcher.getModelForState(Blocks.DIAMOND_BLOCK.getDefaultState).getQuads(Blocks.DIAMOND_BLOCK.getDefaultState, EnumFacing.UP, 0).asScala.toList
    )

  val rotation = "rotation"
  val translation = "translation"
  val identity = "identity"

  def generateInfluence(): Map[String, BakedQuad => BakedQuad] =
    Map(
      rotation -> (q => LazyUnpackedQuad(q).rotate(Math.toRadians(-90).toFloat, 0, 1, 0).toBakedQuad),
      translation -> (q => LazyUnpackedQuad(q).translate(1, 0, 0).toBakedQuad),
      "sliceTest" -> (q =>
        LazyUnpackedQuad(q)
          .slice(
            0, 0,
            0.5f, 0,
            0.5f, 0.5f,
            0, 0.5f).toBakedQuad),
      "slice_test_java" -> new SliceExample().apply _,
      identity -> (q => q),
      "immutable_test" -> {
        q =>
          val q1 = LazyUnpackedQuad(q)
          val q2 = q1.translate(1, 1, 1)

          println(q1.v1_x, q2.v1_x)

          q1.toBakedQuad
      },
      "alloc_test1" -> new hohserg.endothermic.example.scala.ColoredExample,
      "alloc_test2" -> new ColoredExample().apply _//,
      //"alloc_test3" -> new ColoredElixXExample().apply _
    )

  override def shouldSideBeRendered(blockState: IBlockState, blockAccess: IBlockAccess, pos: BlockPos, side: EnumFacing): Boolean = true

  override def createNewTileEntity(worldIn: World, meta: Int): TileEntity = new TileTestingStand

  class TileTestingStand extends TileEntity with ITickable {

    var current = "ender_eye_simplified" -> "sliceTest"

    override def update(): Unit = {
      if (world.rand.nextInt(5) == 1)
        world.spawnParticle(EnumParticleTypes.END_ROD, pos.getX + world.rand.nextDouble() - 0.5, pos.getY + world.rand.nextDouble() + 10, pos.getZ + world.rand.nextDouble() - 0.5, 0, 0, 0, 255, 0, 0);

    }
  }

  @SideOnly(Side.CLIENT)
  def mc =
    Minecraft.getMinecraft

}
