package dev.xnlawa.staffhelper.trick;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public abstract class Trick {
    //the trick method
    private final TrickMethod method;

    public Trick(TrickMethod method) {
        this.method = method;
    }

    public abstract void performTrick(Player player);
}
