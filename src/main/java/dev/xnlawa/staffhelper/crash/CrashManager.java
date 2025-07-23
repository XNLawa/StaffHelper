package dev.xnlawa.staffhelper.crash;

import dev.xnlawa.staffhelper.crash.impl.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CrashManager {
    public static CrashManager instance = new CrashManager();
    public List<Crash> crashes = new ArrayList<>();
    public CrashManager() {
        addCrash(new ExplosionCrash());
        addCrash(new InfPositionCrash());
        addCrash(new InfVelocityCrash());
        addCrash(new DestroyPlayerACrash());
        addCrash(new DestroyPlayerBCrash());
        addCrash(new FakeDeathCrash());
        addCrash(new BadStateCrash());
        addCrash(new ParticleCrash());
        addCrash(new BadVelocityPacketCrash());
        addCrash(new PayloadOverflowCrash());
        addCrash(new EntityFloodCrash());

    }
    public void addCrash(Crash crash) {
        crashes.add(crash);
    }
    public Crash getCrash(CrashMethod method) {
        for (Crash crash : crashes) {
            if (crash.getMethod() == method) {
                return crash;
            }
        }
        return null;
    }
    public void performCrash(Player player, CrashMethod method) {
        Crash crash = getCrash(method);
        if (crash != null) {
            crash.performCrash(player);
        }
    }
}
