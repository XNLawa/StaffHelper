package dev.xnlawa.staffhelper.trick.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerUpdateHealth;
import dev.xnlawa.staffhelper.trick.Trick;
import dev.xnlawa.staffhelper.trick.TrickMethod;
import dev.xnlawa.staffhelper.util.RandomUtil;
import org.bukkit.entity.Player;

public class IllegalHealthStateTrick extends Trick {
    public IllegalHealthStateTrick() {
        super(TrickMethod.ILLEGALHEALTHSTATE);
    }

    @Override
    public void performTrick(Player player) {
        WrapperPlayServerUpdateHealth packet = new WrapperPlayServerUpdateHealth(RandomUtil.nextFloat(-200000f,-20f),
                RandomUtil.nextInt(-200000,-20),
                RandomUtil.nextFloat(-200000f,-20f));
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
