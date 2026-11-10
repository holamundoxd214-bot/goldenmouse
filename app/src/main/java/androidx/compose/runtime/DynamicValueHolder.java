package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00028\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\fJ\u001C\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u000F\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u001F\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0014\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001A\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001A\u00020\u001AHÖ\u0081\u0004R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/DynamicValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "state", "Landroidx/compose/runtime/MutableState;", "<init>", "(Landroidx/compose/runtime/MutableState;)V", "getState", "()Landroidx/compose/runtime/MutableState;", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DynamicValueHolder implements ValueHolder {
    public static final int $stable;
    private final MutableState state;

    static {
    }

    public DynamicValueHolder(MutableState arg1) {
        super();
        this.state = arg1;
    }

    public final MutableState component1() {
        return this.state;
    }

    public final DynamicValueHolder copy(MutableState arg1) {
        return new DynamicValueHolder(arg1);
    }

    public static DynamicValueHolder copy$default(DynamicValueHolder arg0, MutableState arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.state;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((DynamicValueHolder)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof DynamicValueHolder)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((DynamicValueHolder)arg4).state)) {
            return 0;
        }

        return 1;
    }

    public final MutableState getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public Object readValue(PersistentCompositionLocalMap arg1) {
        return this.state.getValue();
    }

    public ProvidedValue toProvided(CompositionLocal arg9) {
        return new ProvidedValue(arg9, null, false, null, this.state, null, true);
    }

    public String toString() {
        return "DynamicValueHolder(state=" + this.state + ')';
    }
}

