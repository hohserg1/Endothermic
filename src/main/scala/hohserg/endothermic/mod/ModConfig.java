package hohserg.endothermic.mod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;

@Config(modid = "endothermic")
public class ModConfig {
    @Comment("Enable registration of testing stand block. Useless for modpacks")
    public static boolean enable_testing_stand = false;
}
