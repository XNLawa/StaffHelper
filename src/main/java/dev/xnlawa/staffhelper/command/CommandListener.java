package dev.xnlawa.staffhelper.command;

import dev.xnlawa.staffhelper.crash.CrashManager;
import dev.xnlawa.staffhelper.crash.CrashMethod;
import dev.xnlawa.staffhelper.tool.ToolManager;
import dev.xnlawa.staffhelper.tool.ToolType;
import dev.xnlawa.staffhelper.trick.TrickManager;
import dev.xnlawa.staffhelper.trick.TrickMethod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandListener implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
                             @NotNull String[] args) {
        if (!sender.hasPermission("staffhelper.use")) {
            sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
            return true;
        }
        if (args.length < 3) {
            sender.sendMessage(ChatColor.YELLOW + "用法: /staffhelper <tool|trick|crash> <player> <method>");
            return true;
        }

        String mode = args[0].toLowerCase();
        String playerName = args[1];
        String methodName = args[2];
        switch (mode){
            case "crash" -> {
                if (!sender.hasPermission("staffhelper.crash")) {
                    sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
                    return true;
                }
            }
            case "trick" -> {
                if (!sender.hasPermission("staffhelper.trick")) {
                    sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
                    return true;
                }
            }
            case "tool" -> {
                if (!sender.hasPermission("staffhelper.tool")) {
                    sender.sendMessage(ChatColor.RED + "你没有权限使用这个指令！");
                    return true;
                }
            }
            default -> {
                sender.sendMessage(ChatColor.RED + "无效模式: " + mode + "，应为 trick 或 crash");
                return true;
            }
        }
        Player target = Bukkit.getPlayerExact(playerName);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "玩家 " + playerName + " 不在线！");
            return true;
        }

        switch (mode) {
            case "crash" -> {
                CrashMethod method = getCrashMethodByName(methodName);
                if (method == null) {
                    sender.sendMessage(ChatColor.RED + "无效的 Crash 方法: " + methodName);
                    return true;
                }
                performCrash(sender, target, method);
            }
            case "trick" -> {
                TrickMethod method = getTrickMethodByName(methodName);
                if (method == null) {
                    sender.sendMessage(ChatColor.RED + "无效的 Trick 方法: " + methodName);
                    return true;
                }
                performTrick(sender, target, method);
            }
            case "tool" -> {
                ToolType type = getToolTypeByName(methodName);
                if (type == null) {
                    sender.sendMessage(ChatColor.RED + "无效的 Tool 方法: " + methodName);
                    return true;
                }
                String[] extraArgs = Arrays.copyOfRange(args, 3, args.length);
                performTool(sender, target, type, extraArgs);
            }
            default -> sender.sendMessage(ChatColor.RED + "无效模式: " + mode + "，应为 trick 或 crash");
        }

        return true;
    }

    private void performCrash(CommandSender sender, Player target, CrashMethod method) {
        sender.sendMessage(ChatColor.GREEN + "尝试执行 Crash 方法 " + method.getProperName() + " 对 " + target.getName());
        CrashManager.instance.performCrash(target, method);
    }

    private void performTrick(CommandSender sender, Player target, TrickMethod method) {
        sender.sendMessage(ChatColor.GREEN + "尝试执行 Trick 方法 " + method.getProperName() + " 对 " + target.getName());
        TrickManager.instance.performTrick(target, method);
    }
    private void performTool(CommandSender sender, Player target, ToolType method,String[] args) {
        sender.sendMessage(ChatColor.GREEN + "尝试执行 Tool 方法 " + method.getProperName() + " 对 " + target.getName());
        ToolManager.instance.performTool(sender, target, method, args);
    }

    private CrashMethod getCrashMethodByName(String name) {
        for (CrashMethod method : CrashMethod.values()) {
            if (method.name().equalsIgnoreCase(name) || method.getProperName().equalsIgnoreCase(name)) {
                return method;
            }
        }
        return null;
    }

    private TrickMethod getTrickMethodByName(String name) {
        for (TrickMethod method : TrickMethod.values()) {
            if (method.name().equalsIgnoreCase(name) || method.getProperName().equalsIgnoreCase(name)) {
                return method;
            }
        }
        return null;
    }
    private ToolType getToolTypeByName(String name) {
        for (ToolType method : ToolType.values()) {
            if (method.name().equalsIgnoreCase(name) || method.getProperName().equalsIgnoreCase(name)) {
                return method;
            }
        }
        return null;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
                                                @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.addAll(Arrays.asList("crash", "trick", "tool"));
        } else if (args.length == 2) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                completions.add(onlinePlayer.getName());
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("crash")) {
                for (CrashMethod method : CrashMethod.values()) {
                    completions.add(method.getProperName());
                }
            } else if (args[0].equalsIgnoreCase("trick")) {
                for (TrickMethod method : TrickMethod.values()) {
                    completions.add(method.getProperName());
                }
            } else if (args[0].equalsIgnoreCase("tool")) {
                for (ToolType method : ToolType.values()) {
                    completions.add(method.getProperName());
                }
            }
        }

        return completions;
    }
}
