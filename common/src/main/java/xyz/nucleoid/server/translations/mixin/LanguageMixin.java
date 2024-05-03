package xyz.nucleoid.server.translations.mixin;

import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import xyz.nucleoid.server.translations.impl.language.SystemDelegatedLanguage;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Language.class)
public class LanguageMixin {
    @Shadow
    private static Language instance;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void stapi$init(CallbackInfo ci) {
        instance = new SystemDelegatedLanguage(instance);
    }

    @ModifyVariable(method = "setInstance", at = @At("HEAD"))
    private static Language stapi$modifyLanguage(Language language) {
        if (Platform.getEnvironment() == Env.SERVER) {
            return new SystemDelegatedLanguage(language);
        } else {
            return language;
        }
    }
}
