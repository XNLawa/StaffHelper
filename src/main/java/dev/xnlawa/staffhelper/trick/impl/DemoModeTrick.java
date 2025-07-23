package dev.xnlawa.staffhelper.trick.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChangeGameState;
import dev.xnlawa.staffhelper.trick.Trick;
import dev.xnlawa.staffhelper.trick.TrickMethod;
import org.bukkit.entity.Player;

public class DemoModeTrick extends Trick {
    public DemoModeTrick() {
        super(TrickMethod.DEMOMODE);
    }

    @Override
    public void performTrick(Player player) {
        WrapperPlayServerChangeGameState packet =
                new WrapperPlayServerChangeGameState(WrapperPlayServerChangeGameState.Reason.DEMO_EVENT, 0.0F);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
