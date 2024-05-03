package org.sasha0552.server_translations.mixin;

import net.minecraft.resource.*;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.nucleoid.server.translations.impl.ServerTranslations;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(SimpleResourceReload.class)
public class MixinSimpleResourceReload {
    @Inject(method = "start", at = @At("HEAD"))
    private static void onReturn(ResourceManager manager, List<ResourceReloader> reloaders, Executor prepareExecutor, Executor applyExecutor, CompletableFuture<Unit> initialStage, boolean profiled, CallbackInfoReturnable<ResourceReload> cir) {
        reloaders.add(ServerTranslations.INSTANCE);
    }
}
