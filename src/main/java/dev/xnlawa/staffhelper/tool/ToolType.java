package dev.xnlawa.staffhelper.tool;

import lombok.Getter;

@Getter
public enum ToolType {
    VELOCITY("Velocity");

    private final String properName;

    ToolType(String properName) {
        this.properName = properName;
    }
}
