package dev.xnlawa.staffhelper.tool.impl;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityVelocity;
import dev.xnlawa.staffhelper.tool.Tool;
import dev.xnlawa.staffhelper.tool.ToolType;
import org.bukkit.entity.Player;

public class VelocityTool extends Tool {
    public VelocityTool() {
        super(ToolType.VELOCITY);
    }

    @Override
    public boolean performTool(Player player, String[] args) {
        if(args.length != 3){
            return false;
        }
        if(!args[0].matches("-?\\d+(\\.\\d+)?") || !args[1].matches("-?\\d+(\\.\\d+)?") || !args[2].matches("-?\\d+(\\.\\d+)?")){
            return false;
        }
        WrapperPlayServerEntityVelocity packet = new WrapperPlayServerEntityVelocity(player.getEntityId(), new Vector3d(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2])));
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
        return true;
    }
}
