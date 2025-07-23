package dev.xnlawa.staffhelper.listener;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PacketListener extends PacketListenerAbstract {

    public PacketListener() {
        PacketEvents.getAPI().getEventManager().registerListener(this);
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        var user = event.getUser();
        if (user == null || user.getUUID() == null) return;

        Player player = Bukkit.getPlayer(user.getUUID());
        if (player == null || !player.isOnline()) return;

        //may be used for future
    }
}
