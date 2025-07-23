package dev.xnlawa.staffhelper.trick;

import lombok.Getter;

@Getter
public enum TrickMethod {
//    ZEROSPEED("ZeroSpeed"),
    ILLEGALHEALTHSTATE("IllegalHealthState"),
    DEMOMODE("DemoMode"),
    DEMOMESSAGE("DemoMessage");
    private final String properName;

    TrickMethod(String properName) {
        this.properName = properName;
    }
}
