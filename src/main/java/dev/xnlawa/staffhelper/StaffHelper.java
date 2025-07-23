package dev.xnlawa.staffhelper;

import com.github.retrooper.packetevents.PacketEvents;
import dev.xnlawa.staffhelper.command.CommandListener;
import dev.xnlawa.staffhelper.listener.PacketListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffHelper extends JavaPlugin {
    private PacketListener packetListener;
    @Override
    public void onEnable() {
        // Plugin startup logic
        if (getServer().getPluginManager().getPlugin("PacketEvents") == null) {
            getLogger().severe("PacketEvents is not installed");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        PacketEvents.getAPI().load();
        PacketEvents.getAPI().init();
        packetListener = new PacketListener();

        CommandListener commandListener = new CommandListener();
        getCommand("staffhelper").setExecutor(commandListener);
        getCommand("staffhelper").setTabCompleter(commandListener);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public PacketListener getPacketListener() {
        return packetListener;
    }
}
