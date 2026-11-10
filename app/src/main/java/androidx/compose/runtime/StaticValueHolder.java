package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00028\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\fJ\u001C\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u000E\u0010\u0011\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001E\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001A\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001A\u001A\u00020\u001BHÖ\u0081\u0004R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/StaticValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "component1", "copy", "(Ljava/lang/Object;)Landroidx/compose/runtime/StaticValueHolder;", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StaticValueHolder implements ValueHolder {
    public static final int $stable;
    private final Object value;

    static {
    }

    public StaticValueHolder(Object arg1) {
        super();
        this.value = arg1;
    }

    public final Object component1() {
        return this.value;
    }

    public final StaticValueHolder copy(Object arg1) {
        return new StaticValueHolder(arg1);
    }

    public static StaticValueHolder copy$default(StaticValueHolder arg0, Object arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.value;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((StaticValueHolder)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof StaticValueHolder)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((StaticValueHolder)arg4).value)) {
            return 0;
        }

        return 1;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object v0 = this.value;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    public Object readValue(PersistentCompositionLocalMap arg1) {
        return this.value;
    }

    public ProvidedValue toProvided(CompositionLocal arg9) {
        Object v2 = this.value;
        boolean v8 = v2 == null ? true : false;
        return new ProvidedValue(arg9, v2, v8, null, null, null, false);
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.value + ')';
    }
}

