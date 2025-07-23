package dev.xnlawa.staffhelper.crash;

import lombok.Getter;

@Getter
public enum CrashMethod {
    EXPLOSION("Explosion"),
    INFPOSITION("InfPosition"),
    INFVELOCITY("InfVelocity"),
    BADVELOCITYPACKET("BadVelocityPacket"),
    DESTROYPLAYERA("DestroyPlayerA"),
    DESTROYPLAYERB("DestroyPlayerB"),
    FAKEDEATH("FakeDeath"),
    BADSTATE("BadState"),
    PARTICLE("Particle"),
    ENTITY_FLOOD("EntityFlood"),
    PAYLOAD_OVERFLOW("PayloadOverflow");

    private final String properName;

    CrashMethod(String properName) {
        this.properName = properName;
    }
}
