package com.TryJeanPc.goldenmouse.macro.execution;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u000E\u001A\u00020\b\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\b\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010+\u001A\u00020\u0003HÆ\u0003J\t\u0010,\u001A\u00020\u0005HÆ\u0003J\u0010\u0010-\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001BJ\t\u0010.\u001A\u00020\bHÆ\u0003J\t\u0010/\u001A\u00020\u0005HÆ\u0003J\u0010\u00100\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001BJ\t\u00101\u001A\u00020\u0005HÆ\u0003J\u0010\u00102\u001A\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010#J\t\u00103\u001A\u00020\bHÆ\u0003J\t\u00104\u001A\u00020\u0010HÆ\u0003J\t\u00105\u001A\u00020\bHÆ\u0003J\u0010\u00106\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001BJ\u0010\u00107\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001BJ\u009A\u0001\u00108\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00052\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\b2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001A\u00020\u00102\b\u0010;\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001A\u00020\rHÖ\u0001J\t\u0010=\u001A\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0019R\u0015\u0010\n\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b \u0010\u001BR\u0011\u0010\u000B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0019R\u0015\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010$\u001A\u0004\b\"\u0010#R\u0011\u0010\u000E\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\u001ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0011\u0010\u0011\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u001ER\u0015\u0010\u0012\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b)\u0010\u001BR\u0015\u0010\u0013\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b*\u0010\u001B¨\u0006>"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingRecord;", "", "identity", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "round", "", "actionId", "event", "", "scheduledMs", "sendMs", "ackMs", "pointerId", "", "reservation", "accepted", "", "reason", "reserveStartMs", "reserveEndMs", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getIdentity", "()Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "getRound", "()J", "getActionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEvent", "()Ljava/lang/String;", "getScheduledMs", "getSendMs", "getAckMs", "getPointerId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReservation", "getAccepted", "()Z", "getReason", "getReserveStartMs", "getReserveEndMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingRecord;", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroTimingRecord {
    public static final int $stable;
    private final boolean accepted;
    private final long ackMs;
    private final Long actionId;
    private final String event;
    private final Identity identity;
    private final Integer pointerId;
    private final String reason;
    private final String reservation;
    private final Long reserveEndMs;
    private final Long reserveStartMs;
    private final long round;
    private final long scheduledMs;
    private final Long sendMs;

    static {
    }

    public MacroTimingRecord(Identity arg3, long arg4, Long arg6, String arg7, long arg8, Long arg10, long arg11, Integer arg13, String arg14, boolean arg15, String arg16, Long arg17, Long arg18) {
        Intrinsics.checkNotNullParameter(arg3, "identity");
        Intrinsics.checkNotNullParameter(arg7, "event");
        Intrinsics.checkNotNullParameter(arg14, "reservation");
        Intrinsics.checkNotNullParameter(arg16, "reason");
        super();
        this.identity = arg3;
        this.round = arg4;
        this.actionId = arg6;
        this.event = arg7;
        this.scheduledMs = arg8;
        this.sendMs = arg10;
        this.ackMs = arg11;
        this.pointerId = arg13;
        this.reservation = arg14;
        this.accepted = arg15;
        this.reason = arg16;
        this.reserveStartMs = arg17;
        this.reserveEndMs = arg18;
    }

    public final Identity component1() {
        return this.identity;
    }

    public final boolean component10() {
        return this.accepted;
    }

    public final String component11() {
        return this.reason;
    }

    public final Long component12() {
        return this.reserveStartMs;
    }

    public final Long component13() {
        return this.reserveEndMs;
    }

    public final long component2() {
        return this.round;
    }

    public final Long component3() {
        return this.actionId;
    }

    public final String component4() {
        return this.event;
    }

    public final long component5() {
        return this.scheduledMs;
    }

    public final Long component6() {
        return this.sendMs;
    }

    public final long component7() {
        return this.ackMs;
    }

    public final Integer component8() {
        return this.pointerId;
    }

    public final String component9() {
        return this.reservation;
    }

    public final MacroTimingRecord copy(Identity arg19, long arg20, Long arg22, String arg23, long arg24, Long arg26, long arg27, Integer arg29, String arg30, boolean arg31, String arg32, Long arg33, Long arg34) {
        Intrinsics.checkNotNullParameter(arg19, "identity");
        Intrinsics.checkNotNullParameter(arg23, "event");
        Intrinsics.checkNotNullParameter(arg30, "reservation");
        Intrinsics.checkNotNullParameter(arg32, "reason");
        return new MacroTimingRecord(arg19, arg20, arg22, arg23, arg24, arg26, arg27, arg29, arg30, arg31, arg32, arg33, arg34);
    }

    public static MacroTimingRecord copy$default(MacroTimingRecord arg16, Identity arg17, long arg18, Long arg20, String arg21, long arg22, Long arg24, long arg25, Integer arg27, String arg28, boolean arg29, String arg30, Long arg31, Long arg32, int arg33, Object arg34) {
        MacroTimingRecord v0 = arg16;
        int v1 = arg33;
        Identity v2 = (v1 & 1) != 0 ? v0.identity : arg17;
        long v3 = (v1 & 2) != 0 ? v0.round : arg18;
        Long v5 = (v1 & 4) != 0 ? v0.actionId : arg20;
        String v6 = (v1 & 8) != 0 ? v0.event : arg21;
        long v7 = (v1 & 16) != 0 ? v0.scheduledMs : arg22;
        Long v9 = (v1 & 0x20) != 0 ? v0.sendMs : arg24;
        long v10 = (v1 & 0x40) != 0 ? v0.ackMs : arg25;
        Integer v12 = (v1 & 0x80) != 0 ? v0.pointerId : arg27;
        String v13 = (v1 & 0x100) != 0 ? v0.reservation : arg28;
        boolean v14 = (v1 & 0x200) != 0 ? v0.accepted : arg29;
        String v15 = (v1 & 0x400) != 0 ? v0.reason : arg30;
        arg17 = v2;
        Long v2_1 = (v1 & 0x800) != 0 ? v0.reserveStartMs : arg31;
        Long v33 = (v1 & 0x1000) != 0 ? v0.reserveEndMs : arg32;
        return v0.copy(arg17, v3, v5, v6, v7, v9, v10, v12, v13, v14, v15, v2_1, v33);
    }

    public boolean equals(Object arg8) {
        if(this == (((MacroTimingRecord)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof MacroTimingRecord)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.identity, ((MacroTimingRecord)arg8).identity)) {
            return 0;
        }

        if(this.round != ((MacroTimingRecord)arg8).round) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.actionId, ((MacroTimingRecord)arg8).actionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.event, ((MacroTimingRecord)arg8).event)) {
            return 0;
        }

        if(this.scheduledMs != ((MacroTimingRecord)arg8).scheduledMs) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sendMs, ((MacroTimingRecord)arg8).sendMs)) {
            return 0;
        }

        if(this.ackMs != ((MacroTimingRecord)arg8).ackMs) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.pointerId, ((MacroTimingRecord)arg8).pointerId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reservation, ((MacroTimingRecord)arg8).reservation)) {
            return 0;
        }

        if(this.accepted != ((MacroTimingRecord)arg8).accepted) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reason, ((MacroTimingRecord)arg8).reason)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reserveStartMs, ((MacroTimingRecord)arg8).reserveStartMs)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reserveEndMs, ((MacroTimingRecord)arg8).reserveEndMs)) {
            return 0;
        }

        return 1;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final long getAckMs() {
        return this.ackMs;
    }

    public final Long getActionId() {
        return this.actionId;
    }

    public final String getEvent() {
        return this.event;
    }

    public final Identity getIdentity() {
        return this.identity;
    }

    public final Integer getPointerId() {
        return this.pointerId;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getReservation() {
        return this.reservation;
    }

    public final Long getReserveEndMs() {
        return this.reserveEndMs;
    }

    public final Long getReserveStartMs() {
        return this.reserveStartMs;
    }

    public final long getRound() {
        return this.round;
    }

    public final long getScheduledMs() {
        return this.scheduledMs;
    }

    public final Long getSendMs() {
        return this.sendMs;
    }

    public int hashCode() {
        int v0 = (this.identity.hashCode() * 0x1F + Long.hashCode(this.round)) * 0x1F;
        Long v1 = this.actionId;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (((v0 + v1_1) * 0x1F + this.event.hashCode()) * 0x1F + Long.hashCode(this.scheduledMs)) * 0x1F;
        v1 = this.sendMs;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + Long.hashCode(this.ackMs)) * 0x1F;
        Integer v1_2 = this.pointerId;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = ((((v0 + v1_1) * 0x1F + this.reservation.hashCode()) * 0x1F + Boolean.hashCode(this.accepted)) * 0x1F + this.reason.hashCode()) * 0x1F;
        v1 = this.reserveStartMs;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Long v5 = this.reserveEndMs;
        if(v5 == null) {
        }
        else {
            v2 = v5.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "MacroTimingRecord(identity=" + this.identity + ", round=" + this.round + ", actionId=" + this.actionId + ", event=" + this.event + ", scheduledMs=" + this.scheduledMs + ", sendMs=" + this.sendMs + ", ackMs=" + this.ackMs + ", pointerId=" + this.pointerId + ", reservation=" + this.reservation + ", accepted=" + this.accepted + ", reason=" + this.reason + ", reserveStartMs=" + this.reserveStartMs + ", reserveEndMs=" + this.reserveEndMs + ")";
    }
}

