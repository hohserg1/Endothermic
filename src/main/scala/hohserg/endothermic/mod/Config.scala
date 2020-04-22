package hohserg.endothermic.mod

import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.Config.Comment

@Config(modid = Title.modid)
object Config {
  @Comment(Array("Enable registration of testing stand block", "Useless for modpacks"))
  val enable_testing_stand = false

}
