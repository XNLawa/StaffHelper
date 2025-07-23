package dev.xnlawa.staffhelper.trick;

import dev.xnlawa.staffhelper.trick.impl.DemoMessageTrick;
import dev.xnlawa.staffhelper.trick.impl.DemoModeTrick;
import dev.xnlawa.staffhelper.trick.impl.IllegalHealthStateTrick;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TrickManager {
    public static TrickManager instance = new TrickManager();
    public List<Trick> tricks = new ArrayList<>();
    public TrickManager() {
//        addTrick(new ExplosionCrash());
        addTrick(new DemoModeTrick());
        addTrick(new DemoMessageTrick());
        addTrick(new IllegalHealthStateTrick());
    }
    public void addTrick(Trick crash) {
        tricks.add(crash);
    }
    public Trick getTrick(TrickMethod method) {
        for (Trick crash : tricks) {
            if (crash.getMethod() == method) {
                return crash;
            }
        }
        return null;
    }
    public void performTrick(Player player, TrickMethod method) {
        Trick crash = getTrick(method);
        if (crash != null) {
            crash.performTrick(player);
        }
    }
}
