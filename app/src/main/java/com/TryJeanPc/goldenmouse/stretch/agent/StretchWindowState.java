package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000F\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000F\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0012\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u00032\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\bHÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\f¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchWindowState;", "", "override", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "scaling", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "density", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;)V", "getOverride", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "getScaling", "getDensity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchWindowState {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\f\u001A\u00020\n¢\u0006\u0002\u0010\rJ\u0006\u0010\u000E\u001A\u00020\u0005J\u0016\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u0005¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchWindowState$Companion;", "", "<init>", "()V", "observed", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchWindowState;", "initial", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "base", "flags", "", "scalingMask", "density", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;ILjava/lang/Integer;I)Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchWindowState;", "unavailable", "stable", "first", "second", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StretchWindowState observed(StretchSize arg4, StretchSize arg5, int arg6, Integer arg7, int arg8) {
            Intrinsics.checkNotNullParameter(arg4, "initial");
            Intrinsics.checkNotNullParameter(arg5, "base");
            List v3 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg4.getWidth()), Integer.valueOf(arg4.getHeight()), Integer.valueOf(arg5.getWidth()), Integer.valueOf(arg5.getHeight())});
            if(!(v3 instanceof Collection) || !v3.isEmpty()) {
                Iterator v3_1 = ((Iterable)v3).iterator();
                while(true) {
                    if(v3_1.hasNext()) {
                        int v0 = v3_1.next().intValue();
                        if(1 <= v0 && v0 < 0x8001) {
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_59;
                }

            label_38:
                if(1 <= arg8 && arg8 < 10001) {
                    RecoveryDatum v4 = Intrinsics.areEqual(arg4, arg5) ? RecoveryDatum.Companion.absent(RecoverySource.INFORMATIVE_BACKEND) : RecoveryDatum.Companion.known(arg5, RecoverySource.INFORMATIVE_BACKEND);
                    return new StretchWindowState(v4, StretchOriginalEvidenceParser.INSTANCE.scaling(arg6, arg7), RecoveryDatum.Companion.known(Integer.valueOf(arg8), RecoverySource.INFORMATIVE_BACKEND));
                }
            }
            else {
                goto label_38;
            }

        label_59:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final StretchWindowState stable(StretchWindowState arg2, StretchWindowState arg3) {
            Intrinsics.checkNotNullParameter(arg2, "first");
            Intrinsics.checkNotNullParameter(arg3, "second");
            if(Intrinsics.areEqual(arg2, arg3)) {
                return arg3;
            }

            return this.unavailable();
        }

        public final StretchWindowState unavailable() {
            return new StretchWindowState(RecoveryDatum.Companion.failed(RecoverySource.INFORMATIVE_BACKEND), RecoveryDatum.Companion.failed(RecoverySource.INFORMATIVE_BACKEND), RecoveryDatum.Companion.failed(RecoverySource.INFORMATIVE_BACKEND));
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final RecoveryDatum density;
    private final RecoveryDatum override;
    private final RecoveryDatum scaling;

    static {
        StretchWindowState.Companion = new Companion(null);
    }

    public StretchWindowState(RecoveryDatum arg2, RecoveryDatum arg3, RecoveryDatum arg4) {
        Intrinsics.checkNotNullParameter(arg2, "override");
        Intrinsics.checkNotNullParameter(arg3, "scaling");
        Intrinsics.checkNotNullParameter(arg4, "density");
        super();
        this.override = arg2;
        this.scaling = arg3;
        this.density = arg4;
    }

    public final RecoveryDatum component1() {
        return this.override;
    }

    public final RecoveryDatum component2() {
        return this.scaling;
    }

    public final RecoveryDatum component3() {
        return this.density;
    }

    public final StretchWindowState copy(RecoveryDatum arg1, RecoveryDatum arg2, RecoveryDatum arg3) {
        Intrinsics.checkNotNullParameter(arg1, "override");
        Intrinsics.checkNotNullParameter(arg2, "scaling");
        Intrinsics.checkNotNullParameter(arg3, "density");
        return new StretchWindowState(arg1, arg2, arg3);
    }

    public static StretchWindowState copy$default(StretchWindowState arg0, RecoveryDatum arg1, RecoveryDatum arg2, RecoveryDatum arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.override;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.scaling;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.density;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchWindowState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchWindowState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.override, ((StretchWindowState)arg5).override)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scaling, ((StretchWindowState)arg5).scaling)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((StretchWindowState)arg5).density)) {
            return 0;
        }

        return 1;
    }

    public final RecoveryDatum getDensity() {
        return this.density;
    }

    public final RecoveryDatum getOverride() {
        return this.override;
    }

    public final RecoveryDatum getScaling() {
        return this.scaling;
    }

    public int hashCode() {
        return (this.override.hashCode() * 0x1F + this.scaling.hashCode()) * 0x1F + this.density.hashCode();
    }

    public String toString() {
        return "StretchWindowState(override=" + this.override + ", scaling=" + this.scaling + ", density=" + this.density + ")";
    }
}

