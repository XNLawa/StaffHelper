package dev.xnlawa.staffhelper.crash;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public abstract class Crash {
    //the method of the crash
    private final CrashMethod method;

    public Crash(CrashMethod method) {
        this.method = method;
    }

    public abstract void performCrash(Player player);
}
