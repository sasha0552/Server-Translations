package org.sasha0552.server_translations.fabric;

import fr.catcore.server.translations.ServerTranslationsInitializer;
import net.fabricmc.api.ModInitializer;
import xyz.nucleoid.server.translations.impl.ServerTranslations;

public class ServerTranslationsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerTranslations.INSTANCE.onInitialize();
        ServerTranslationsInitializer.onInitialize();
    }
}
