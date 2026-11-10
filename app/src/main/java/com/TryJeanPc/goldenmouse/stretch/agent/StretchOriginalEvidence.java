package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010*\u001A\u00020\u0003HÆ\u0003J\t\u0010+\u001A\u00020\u0005HÆ\u0003J\t\u0010,\u001A\u00020\u0005HÆ\u0003J\t\u0010-\u001A\u00020\bHÆ\u0003J\u000F\u0010.\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÆ\u0003J\u000F\u0010/\u001A\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003J\t\u00100\u001A\u00020\u000FHÆ\u0003J\t\u00101\u001A\u00020\u0011HÆ\u0003J\t\u00102\u001A\u00020\u0013HÆ\u0003Jo\u00103\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0013HÆ\u0001J\u0013\u00104\u001A\u00020\u00112\b\u00105\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001A\u000207HÖ\u0001J\t\u00108\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001ER\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010&\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\'\u0010\u0019R\u0011\u0010(\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b)\u0010#¨\u00069"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "agentGeneration", "", "ownerGeneration", "viewport", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewportRead;", "scaling", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "sizeOverride", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "windowRead", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "stable", "", "compositor", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewportRead;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;ZLcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;)V", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "getAgentGeneration", "()Ljava/lang/String;", "getOwnerGeneration", "getViewport", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewportRead;", "getScaling", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "getSizeOverride", "getWindowRead", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "getStable", "()Z", "getCompositor", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "snapshotDigest", "getSnapshotDigest", "physicalRecoveryAccredited", "getPhysicalRecoveryAccredited", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalEvidence {
    public static final int $stable;
    private final String agentGeneration;
    private final StretchCompositorRead compositor;
    private final String ownerGeneration;
    private final RecoveryDatum scaling;
    private final RecoveryDatum sizeOverride;
    private final StretchRecoverySnapshot snapshot;
    private final boolean stable;
    private final OriginalViewportRead viewport;
    private final OriginalReadCode windowRead;

    static {
    }

    public StretchOriginalEvidence(StretchRecoverySnapshot arg2, String arg3, String arg4, OriginalViewportRead arg5, RecoveryDatum arg6, RecoveryDatum arg7, OriginalReadCode arg8, boolean arg9, StretchCompositorRead arg10) {
        Intrinsics.checkNotNullParameter(arg2, "snapshot");
        Intrinsics.checkNotNullParameter(arg3, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg4, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg5, "viewport");
        Intrinsics.checkNotNullParameter(arg6, "scaling");
        Intrinsics.checkNotNullParameter(arg7, "sizeOverride");
        Intrinsics.checkNotNullParameter(arg8, "windowRead");
        Intrinsics.checkNotNullParameter(arg10, "compositor");
        super();
        this.snapshot = arg2;
        this.agentGeneration = arg3;
        this.ownerGeneration = arg4;
        this.viewport = arg5;
        this.scaling = arg6;
        this.sizeOverride = arg7;
        this.windowRead = arg8;
        this.stable = arg9;
        this.compositor = arg10;
    }

    public StretchOriginalEvidence(StretchRecoverySnapshot arg13, String arg14, String arg15, OriginalViewportRead arg16, RecoveryDatum arg17, RecoveryDatum arg18, OriginalReadCode arg19, boolean arg20, StretchCompositorRead arg21, int arg22, DefaultConstructorMarker arg23) {
        StretchCompositorRead v11 = (arg22 & 0x100) != 0 ? new StretchCompositorRead(null, null, false, 7, null) : arg21;
        this(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, v11);
    }

    public final StretchRecoverySnapshot component1() {
        return this.snapshot;
    }

    public final String component2() {
        return this.agentGeneration;
    }

    public final String component3() {
        return this.ownerGeneration;
    }

    public final OriginalViewportRead component4() {
        return this.viewport;
    }

    public final RecoveryDatum component5() {
        return this.scaling;
    }

    public final RecoveryDatum component6() {
        return this.sizeOverride;
    }

    public final OriginalReadCode component7() {
        return this.windowRead;
    }

    public final boolean component8() {
        return this.stable;
    }

    public final StretchCompositorRead component9() {
        return this.compositor;
    }

    public final StretchOriginalEvidence copy(StretchRecoverySnapshot arg11, String arg12, String arg13, OriginalViewportRead arg14, RecoveryDatum arg15, RecoveryDatum arg16, OriginalReadCode arg17, boolean arg18, StretchCompositorRead arg19) {
        Intrinsics.checkNotNullParameter(arg11, "snapshot");
        Intrinsics.checkNotNullParameter(arg12, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg13, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg14, "viewport");
        Intrinsics.checkNotNullParameter(arg15, "scaling");
        Intrinsics.checkNotNullParameter(arg16, "sizeOverride");
        Intrinsics.checkNotNullParameter(arg17, "windowRead");
        Intrinsics.checkNotNullParameter(arg19, "compositor");
        return new StretchOriginalEvidence(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    public static StretchOriginalEvidence copy$default(StretchOriginalEvidence arg0, StretchRecoverySnapshot arg1, String arg2, String arg3, OriginalViewportRead arg4, RecoveryDatum arg5, RecoveryDatum arg6, OriginalReadCode arg7, boolean arg8, StretchCompositorRead arg9, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.snapshot;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.agentGeneration;
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.ownerGeneration;
        }

        if((arg10 & 8) != 0) {
            arg4 = arg0.viewport;
        }

        if((arg10 & 16) != 0) {
            arg5 = arg0.scaling;
        }

        if((arg10 & 0x20) != 0) {
            arg6 = arg0.sizeOverride;
        }

        if((arg10 & 0x40) != 0) {
            arg7 = arg0.windowRead;
        }

        if((arg10 & 0x80) != 0) {
            arg8 = arg0.stable;
        }

        if((arg10 & 0x100) != 0) {
            arg9 = arg0.compositor;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchOriginalEvidence)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchOriginalEvidence)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((StretchOriginalEvidence)arg5).snapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agentGeneration, ((StretchOriginalEvidence)arg5).agentGeneration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ownerGeneration, ((StretchOriginalEvidence)arg5).ownerGeneration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.viewport, ((StretchOriginalEvidence)arg5).viewport)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scaling, ((StretchOriginalEvidence)arg5).scaling)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sizeOverride, ((StretchOriginalEvidence)arg5).sizeOverride)) {
            return 0;
        }

        if(this.windowRead != ((StretchOriginalEvidence)arg5).windowRead) {
            return 0;
        }

        if(this.stable != ((StretchOriginalEvidence)arg5).stable) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.compositor, ((StretchOriginalEvidence)arg5).compositor)) {
            return 0;
        }

        return 1;
    }

    public final String getAgentGeneration() {
        return this.agentGeneration;
    }

    public final StretchCompositorRead getCompositor() {
        return this.compositor;
    }

    public final String getOwnerGeneration() {
        return this.ownerGeneration;
    }

    public final boolean getPhysicalRecoveryAccredited() {
        return 0;
    }

    public final RecoveryDatum getScaling() {
        return this.scaling;
    }

    public final RecoveryDatum getSizeOverride() {
        return this.sizeOverride;
    }

    public final StretchRecoverySnapshot getSnapshot() {
        return this.snapshot;
    }

    public final String getSnapshotDigest() {
        return StretchRecoveryCodec.INSTANCE.snapshotDigest(this.snapshot);
    }

    public final boolean getStable() {
        return this.stable;
    }

    public final OriginalViewportRead getViewport() {
        return this.viewport;
    }

    public final OriginalReadCode getWindowRead() {
        return this.windowRead;
    }

    public int hashCode() {
        return (((((((this.snapshot.hashCode() * 0x1F + this.agentGeneration.hashCode()) * 0x1F + this.ownerGeneration.hashCode()) * 0x1F + this.viewport.hashCode()) * 0x1F + this.scaling.hashCode()) * 0x1F + this.sizeOverride.hashCode()) * 0x1F + this.windowRead.hashCode()) * 0x1F + Boolean.hashCode(this.stable)) * 0x1F + this.compositor.hashCode();
    }

    public String toString() {
        return "StretchOriginalEvidence(snapshot=" + this.snapshot + ", agentGeneration=" + this.agentGeneration + ", ownerGeneration=" + this.ownerGeneration + ", viewport=" + this.viewport + ", scaling=" + this.scaling + ", sizeOverride=" + this.sizeOverride + ", windowRead=" + this.windowRead + ", stable=" + this.stable + ", compositor=" + this.compositor + ")";
    }
}

