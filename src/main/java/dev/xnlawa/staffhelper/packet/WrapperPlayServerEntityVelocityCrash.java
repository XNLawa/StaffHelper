package dev.xnlawa.staffhelper.packet;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.packettype.PacketType.Play.Server;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayServerEntityVelocityCrash extends PacketWrapper<WrapperPlayServerEntityVelocityCrash> {
    private static final double PRECISION_LOSS_FIX = 1.0E-11;
    private int entityID;
    private Vector3d velocity;

    public WrapperPlayServerEntityVelocityCrash(PacketSendEvent event) {
        super(event);
    }

    public WrapperPlayServerEntityVelocityCrash(int entityID, Vector3d velocity) {
        super(Server.ENTITY_VELOCITY);
        this.entityID = entityID;
        this.velocity = velocity;
    }

    public void read() {
        if (this.serverVersion == ServerVersion.V_1_7_10) {
            this.entityID = this.readInt();
        } else {
            this.entityID = this.readVarInt();
        }

        double velX = (double)this.readShort() / 8000.0;
        double velY = (double)this.readShort() / 8000.0;
        double velZ = (double)this.readShort() / 8000.0;
        this.velocity = new Vector3d(velX, velY, velZ);
    }

    public void write() {
        if (this.serverVersion == ServerVersion.V_1_7_10) {
            this.writeInt(this.entityID);
            this.writeShort(Short.MAX_VALUE);
            this.writeShort(Short.MAX_VALUE);
            this.writeShort(Short.MAX_VALUE);
        } else {
            this.writeVarInt(this.entityID);
            this.writeInt(Integer.MAX_VALUE);
            this.writeInt(Integer.MAX_VALUE);
            this.writeInt(Integer.MAX_VALUE);
        }
    }

    public void copy(WrapperPlayServerEntityVelocityCrash wrapper) {
        this.entityID = wrapper.entityID;
        this.velocity = wrapper.velocity;
    }

    public int getEntityId() {
        return this.entityID;
    }

    public void setEntityId(int entityID) {
        this.entityID = entityID;
    }

    public Vector3d getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }
}
