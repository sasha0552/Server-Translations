package org.sasha0552.server_translations.forge;

import fr.catcore.server.translations.ServerTranslationsInitializer;
import net.minecraftforge.fml.common.Mod;
import xyz.nucleoid.server.translations.impl.ServerTranslations;

@Mod("server_translations")
public class ServerTranslationsForge {
    public ServerTranslationsForge() {
        ServerTranslations.INSTANCE.onInitialize();
        ServerTranslationsInitializer.onInitialize();
    }
}
