package dev.xnlawa.staffhelper.tool;

import lombok.Getter;
import org.bukkit.entity.Player;
@Getter
public abstract class Tool {
    public final ToolType type;
    public abstract boolean performTool(Player player, String[] args);

    public Tool(ToolType type) {
        this.type = type;
    }
}
