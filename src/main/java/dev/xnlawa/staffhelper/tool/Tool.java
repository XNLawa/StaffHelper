package dev.xnlawa.staffhelper.tool;

import lombok.Getter;
import org.bukkit.entity.Player;
@Getter
public abstract class Tool {
    //the tool type
    public final ToolType type;
    public abstract boolean performTool(Player player, String[] args);

    public Tool(ToolType type) {
        this.type = type;
    }
}
