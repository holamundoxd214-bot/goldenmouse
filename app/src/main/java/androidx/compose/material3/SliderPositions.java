package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Deprecated(message="Not necessary with the introduction of Slider state") @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R7\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER+\u0010\u0011\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00068F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001C"}, d2={"Landroidx/compose/material3/SliderPositions;", "", "initialActiveRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "initialTickFractions", "", "<init>", "(Lkotlin/ranges/ClosedFloatingPointRange;[F)V", "<set-?>", "activeRange", "getActiveRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "setActiveRange$material3", "(Lkotlin/ranges/ClosedFloatingPointRange;)V", "activeRange$delegate", "Landroidx/compose/runtime/MutableState;", "tickFractions", "getTickFractions", "()[F", "setTickFractions$material3", "([F)V", "tickFractions$delegate", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SliderPositions {
    public static final int $stable;
    private final MutableState activeRange$delegate;
    private final MutableState tickFractions$delegate;

    static {
    }

    public SliderPositions() {
        this(null, null, 3, null);
    }

    public SliderPositions(ClosedFloatingPointRange arg1, float[] arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = RangesKt.rangeTo(0f, 1f);
        }

        if((arg3 & 2) != 0) {
            arg2 = new float[0];
        }

        this(arg1, arg2);
    }

    public SliderPositions(ClosedFloatingPointRange arg3, float[] arg4) {
        super();
        this.activeRange$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
        this.tickFractions$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((SliderPositions)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SliderPositions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getActiveRange(), ((SliderPositions)arg5).getActiveRange())) {
            return 0;
        }

        if(!Arrays.equals(this.getTickFractions(), ((SliderPositions)arg5).getTickFractions())) {
            return 0;
        }

        return 1;
    }

    public final ClosedFloatingPointRange getActiveRange() {
        return this.activeRange$delegate.getValue();
    }

    public final float[] getTickFractions() {
        return this.tickFractions$delegate.getValue();
    }

    public int hashCode() {
        return this.getActiveRange().hashCode() * 0x1F + Arrays.hashCode(this.getTickFractions());
    }

    public final void setActiveRange$material3(ClosedFloatingPointRange arg1) {
        this.activeRange$delegate.setValue(arg1);
    }

    public final void setTickFractions$material3(float[] arg1) {
        this.tickFractions$delegate.setValue(arg1);
    }
}

