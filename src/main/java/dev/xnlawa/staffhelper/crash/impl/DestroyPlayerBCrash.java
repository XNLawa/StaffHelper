package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

public class DestroyPlayerBCrash extends Crash {
    public DestroyPlayerBCrash() {
        super(CrashMethod.DESTROYPLAYERB);
    }

    @Override
    public void performCrash(Player player) {
        WrapperPlayServerDestroyEntities destroy = new WrapperPlayServerDestroyEntities(new int[]{player.getEntityId()});
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, destroy);
    }
}
