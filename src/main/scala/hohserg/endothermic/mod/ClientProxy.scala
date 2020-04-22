package hohserg.endothermic.mod

import hohserg.endothermic.quad.immutable.LazyUnpackedQuad
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelBakeEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.eventhandler.{EventPriority, SubscribeEvent}

import scala.collection.JavaConverters._
import scala.util.Try

class ClientProxy extends CommonProxy {

  override def preinit(event: FMLPreInitializationEvent): Unit = {
    super.preinit(event)

  }

  override def init(event: FMLInitializationEvent): Unit = {
    super.init(event)
    if (Config.enable_testing_stand)
      ClientRegistry.bindTileEntitySpecialRenderer(classOf[TestingStand.TileTestingStand], new TileTestingStandRenderer)
  }

  override def postinit(event: FMLPostInitializationEvent): Unit = {
    super.postinit(event)
  }

  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef = new GuiSelectBechmark(world.getTileEntity(new BlockPos(x, y, z)).asInstanceOf[TestingStand.TileTestingStand])

  @SubscribeEvent(priority = EventPriority.LOWEST)
  def onBakeModel(e: ModelBakeEvent): Unit = {
    val models = e.getModelRegistry.getKeys.asScala.map(e.getModelRegistry.getObject)
    val quads = models.flatMap(m =>
      EnumFacing.values().toSeq.flatMap(f =>
        Try(m.getQuads(null, f, 0).asScala.toList.map(identity)).toOption).flatten
    )
    val noneTrivialQuads = quads.map(LazyUnpackedQuad.apply).filterNot { q =>

      (q.v1_u == q.v2_u && q.v4_u == q.v3_u &&
        q.v1_v == q.v4_v && q.v2_v == q.v3_v) ||
        (q.v1_u == q.v4_u && q.v2_u == q.v3_u &&
          q.v1_v == q.v2_v && q.v4_v == q.v3_v)

    }

    println("noneTrivialQuads", noneTrivialQuads)

  }
}
