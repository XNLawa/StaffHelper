package dev.xnlawa.staffhelper.tool;

import dev.xnlawa.staffhelper.crash.Crash;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.tool.impl.VelocityTool;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ToolManager {
    public static ToolManager instance = new ToolManager();
    public List<Tool> tools = new ArrayList<>();
    public ToolManager(){
        addTool(new VelocityTool());
    }
    public void addTool(Tool crash) {
        tools.add(crash);
    }
    public Tool getTool(ToolType type) {
        for (Tool tool : tools) {
            if (tool.getType() == type) {
                return tool;
            }
        }
        return null;
    }
    public void performTool(CommandSender sender, Player target, ToolType method, String[] args) {
        Tool tool = getTool(method);
        if (tool != null) {
            boolean result = tool.performTool(target, args);
            if (!result) {
                sender.sendMessage("§cExecuting Tool: " + method.name() + "failed.");
                //TODO: Tab Complete args
            }
        }
    }
}
