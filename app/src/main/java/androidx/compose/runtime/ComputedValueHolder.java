package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0002\u0010\u000EJ\u001C\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u001A\u0010\u0013\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006HÆ\u0003J*\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0019\b\u0002\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006HÆ\u0001J\u0014\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001A\u00020\u001AHÖ\u0081\u0004J\n\u0010\u001B\u001A\u00020\u001CHÖ\u0081\u0004R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/ComputedValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getCompute", "()Lkotlin/jvm/functions/Function1;", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComputedValueHolder implements ValueHolder {
    public static final int $stable;
    private final Function1 compute;

    static {
    }

    public ComputedValueHolder(Function1 arg1) {
        super();
        this.compute = arg1;
    }

    public final Function1 component1() {
        return this.compute;
    }

    public final ComputedValueHolder copy(Function1 arg1) {
        return new ComputedValueHolder(arg1);
    }

    public static ComputedValueHolder copy$default(ComputedValueHolder arg0, Function1 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.compute;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((ComputedValueHolder)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ComputedValueHolder)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.compute, ((ComputedValueHolder)arg4).compute)) {
            return 0;
        }

        return 1;
    }

    public final Function1 getCompute() {
        return this.compute;
    }

    public int hashCode() {
        return this.compute.hashCode();
    }

    public Object readValue(PersistentCompositionLocalMap arg1) {
        return this.compute.invoke(arg1);
    }

    public ProvidedValue toProvided(CompositionLocal arg9) {
        return new ProvidedValue(arg9, null, false, null, null, this.compute, false);
    }

    public String toString() {
        return "ComputedValueHolder(compute=" + this.compute + ')';
    }
}

