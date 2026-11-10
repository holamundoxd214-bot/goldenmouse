package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\tJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "", "state", "Landroidx/compose/runtime/MutableState;", "", "constructor-impl", "(Landroidx/compose/runtime/MutableState;)Landroidx/compose/runtime/MutableState;", "attachToScope", "attachToScope-impl", "(Landroidx/compose/runtime/MutableState;)V", "invalidateScope", "invalidateScope-impl", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ObservableScopeInvalidator {
    private final MutableState state;

    private ObservableScopeInvalidator(MutableState arg1) {
        super();
        this.state = arg1;
    }

    public static final void attachToScope-impl(MutableState arg0) {
        arg0.getValue();
    }

    public static final ObservableScopeInvalidator box-impl(MutableState arg1) {
        return new ObservableScopeInvalidator(arg1);
    }

    public static MutableState constructor-impl(MutableState arg0) {
        return arg0;
    }

    public static MutableState constructor-impl$default(MutableState arg0, int arg1, DefaultConstructorMarker arg2) {
        if((arg1 & 1) != 0) {
            arg0 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        }

        return ObservableScopeInvalidator.constructor-impl(arg0);
    }

    public boolean equals(Object arg1) {
        return ObservableScopeInvalidator.equals-impl(this.state, arg1);
    }

    public static boolean equals-impl(MutableState arg2, Object arg3) {
        if(!(arg3 instanceof ObservableScopeInvalidator)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ObservableScopeInvalidator)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(MutableState arg0, MutableState arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public int hashCode() {
        return ObservableScopeInvalidator.hashCode-impl(this.state);
    }

    public static int hashCode-impl(MutableState arg0) {
        return arg0.hashCode();
    }

    public static final void invalidateScope-impl(MutableState arg1) {
        arg1.setValue(Unit.INSTANCE);
    }

    public String toString() {
        return ObservableScopeInvalidator.toString-impl(this.state);
    }

    public static String toString-impl(MutableState arg2) {
        return "ObservableScopeInvalidator(state=" + arg2 + ')';
    }

    public final MutableState unbox-impl() {
        return this.state;
    }
}

