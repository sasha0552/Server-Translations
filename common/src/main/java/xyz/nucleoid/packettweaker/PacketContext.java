package xyz.nucleoid.packettweaker;

import net.minecraft.server.network.ServerPlayerEntity;

public class PacketContext {
    public static PacketContext get() {
        throw new AssertionError();
    }

    public ServerPlayerEntity getTarget() {
        throw new AssertionError();
    }
}
