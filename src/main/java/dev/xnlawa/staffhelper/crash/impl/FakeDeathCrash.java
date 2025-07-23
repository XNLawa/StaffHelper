package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChangeGameState;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityStatus;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

public class FakeDeathCrash extends Crash {
    public FakeDeathCrash() {
        super(CrashMethod.FAKEDEATH);
    }

    @Override
    public void performCrash(Player player) {
        WrapperPlayServerEntityStatus packet = new WrapperPlayServerEntityStatus(player.getEntityId(),3);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
