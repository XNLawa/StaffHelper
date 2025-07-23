package dev.xnlawa.staffhelper.trick;

import lombok.Getter;

@Getter
public enum TrickMethod {
    ILLEGALHEALTHSTATE("IllegalHealthState"),
    DEMOMODE("DemoMode"),
    DEMOMESSAGE("DemoMessage");
    private final String properName;

    TrickMethod(String properName) {
        this.properName = properName;
    }
}
