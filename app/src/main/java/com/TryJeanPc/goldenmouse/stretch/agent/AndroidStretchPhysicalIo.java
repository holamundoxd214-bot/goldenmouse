package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.physical.AndroidStretchPhysicalCommands;
import com.TryJeanPc.goldenmouse.stretch.physical.StretchPhysicalCommandPermit;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0014\u001A\u00020\u0005H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0002J\u0012\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0018\u0010\"\u001A\u00020\u00182\u0006\u0010#\u001A\u00020$2\u0006\u0010\u001C\u001A\u00020%H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0014\u0010\u0012\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000FR\u001E\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001C\u001A\u00020\u001E@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchPhysicalIo;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;", "context", "Landroid/content/Context;", "original", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "restoration", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "permit", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit;", "<init>", "(Landroid/content/Context;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchPhysicalCommandPermit;)V", "recoveryWithoutUiVerified", "", "getRecoveryWithoutUiVerified", "()Z", "canApply", "getCanApply", "canRestore", "getCanRestore", "read", "liveTarget", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "size", "", "override", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "scaling", "value", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "", "projectionApplyMillis", "getProjectionApplyMillis", "()J", "projection", "identity", "", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchPhysicalIo implements StretchPhysicalIo {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchPhysicalIo$Companion;", "", "<init>", "()V", "requireSameTarget", "", "expected", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "live", "requireSameTarget$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void requireSameTarget$app(StretchOriginalDisplayState arg2, StretchOriginalDisplayState arg3) {
            Intrinsics.checkNotNullParameter(arg2, "expected");
            Intrinsics.checkNotNullParameter(arg3, "live");
            Object v1 = arg2.getLogicalIdentity().getValue();
            if(v1 != null && ((StretchDisplayIdentity)v1).getLogicalId() == 0) {
                v1 = arg3.getLogicalIdentity().getValue();
                if(v1 != null && ((StretchDisplayIdentity)v1).getLogicalId() == 0 && arg2.getPhysicalIdentity().getValue() != null && (Intrinsics.areEqual(arg2.getPhysicalIdentity(), arg3.getPhysicalIdentity())) && arg2.getReferenceSize().getValue() != null && (Intrinsics.areEqual(arg2.getReferenceSize(), arg3.getReferenceSize()))) {
                    return;
                }
            }

            throw new StretchCompatibilityFailure("DISPLAY_TARGET_CHANGED", null, 2, null);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Context context;
    private final StretchOriginalEvidence original;
    private final StretchPhysicalCommandPermit permit;
    private long projectionApplyMillis;
    private final StretchRestorationIdentity restoration;

    static {
        AndroidStretchPhysicalIo.Companion = new Companion(null);
        AndroidStretchPhysicalIo.$stable = 8;
    }

    public AndroidStretchPhysicalIo(Context arg2, StretchOriginalEvidence arg3, StretchRestorationIdentity arg4, StretchPhysicalCommandPermit arg5) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "original");
        super();
        this.context = arg2;
        this.original = arg3;
        this.restoration = arg4;
        this.permit = arg5;
        this.projectionApplyMillis = -1;
    }

    public AndroidStretchPhysicalIo(Context arg2, StretchOriginalEvidence arg3, StretchRestorationIdentity arg4, StretchPhysicalCommandPermit arg5, int arg6, DefaultConstructorMarker arg7) {
        StretchRestorationIdentity v0 = null;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((StretchPhysicalCommandPermit)v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public boolean getCanApply() {
        StretchPhysicalCommandPermit v2 = this.permit;
        if(v2 != null && !v2.getRestoreOnly() && (v2.active())) {
            return 1;
        }

        return 0;
    }

    public boolean getCanRestore() {
        StretchPhysicalCommandPermit v2 = this.permit;
        if(v2 != null && (v2.getRestoreOnly()) && (v2.active())) {
            return 1;
        }

        return 0;
    }

    public long getProjectionApplyMillis() {
        return this.projectionApplyMillis;
    }

    public boolean getRecoveryWithoutUiVerified() {
        return 0;
    }

    private final StretchOriginalDisplayState liveTarget() {
        StretchOriginalDisplayState v0 = new AndroidStretchBaselineProbe(this.context).capture(this.original.getSnapshot().getSessionId()).getSnapshot().getOriginal();
        AndroidStretchPhysicalIo.Companion.requireSameTarget$app(this.original.getSnapshot().getOriginal(), v0);
        return v0;
    }

    public void projection(String arg4, StretchFullProjection arg5) {
        Intrinsics.checkNotNullParameter(arg4, "identity");
        Intrinsics.checkNotNullParameter(arg5, "value");
        StretchOriginalDisplayState v0 = this.liveTarget();
        Object v1 = v0.getRotation().getValue();
        int v2 = arg5.getRotation();
        if(v1 != null && ((Integer)v1).intValue() == v2 && (Intrinsics.areEqual(v0.getPhysicalIdentity().getValue(), arg4)) && (Intrinsics.areEqual(v0.getReferenceSize(), this.original.getSnapshot().getOriginal().getReferenceSize()))) {
            this.projectionApplyMillis = AndroidStretchPhysicalCommands.INSTANCE.projection(arg4, arg5, this.permit);
            return;
        }

        throw new IllegalStateException("PROJECTION_TARGET_CHANGED".toString());
    }

    public StretchOriginalEvidence read() {
        StretchOriginalEvidence v8;
        String v0_2;
        StretchAgentBaseline v3 = new AndroidStretchBaselineProbe(this.context).capture(this.original.getSnapshot().getSessionId());
        AndroidStretchOriginalReader v1 = new AndroidStretchOriginalReader(this.context);
        try {
            AndroidStretchOriginalReader v2 = v1;
            StretchRestorationIdentity v0_1 = this.restoration;
            if(v0_1 != null) {
                v0_2 = v0_1.getAgentGeneration();
                if(v0_2 == null) {
                    goto label_16;
                }
            }
            else {
            label_16:
                v0_2 = this.original.getAgentGeneration();
            }

            String v4 = v0_2;
            v0_1 = this.restoration;
            if(v0_1 != null) {
                v0_2 = v0_1.getOwnerGeneration();
                if(v0_2 == null) {
                    goto label_23;
                }
            }
            else {
            label_23:
                v0_2 = this.original.getOwnerGeneration();
            }

            v8 = v2.capture(v3, v4, v0_2, new StretchOriginalAgentProgress(new AndroidStretchPhysicalIo$$ExternalSyntheticLambda0()), false);
        }
        catch(Throwable v0) {
            Throwable v8_1 = v0;
            try {
                throw v8_1;
            }
            catch(Throwable v0) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v1), v8_1);
                throw v0;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v1), null);
        return v8;
    }

    static final Unit read$lambda$3$lambda$2(StretchOriginalAgentStep arg0, boolean arg1) {
        Intrinsics.checkNotNullParameter(arg0, "<unused var>");
        return Unit.INSTANCE;
    }

    public void scaling(StretchScaling arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.liveTarget();
        AndroidStretchPhysicalCommands.INSTANCE.scaling(arg2, this.permit);
    }

    public void size(StretchSize arg2) {
        this.liveTarget();
        AndroidStretchPhysicalCommands.INSTANCE.size(arg2, this.permit);
    }
}

