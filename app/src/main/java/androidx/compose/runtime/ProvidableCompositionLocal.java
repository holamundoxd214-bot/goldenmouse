package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001A\u00028\u0000H ¢\u0006\u0004\b\n\u0010\u000BJ\u001C\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001A\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000BJ\u001C\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001A\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000BJ(\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0017\u0010\u000F\u001A\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0002\b\u0012H\u0086\u0004J1\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0016J\u001C\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesDefault", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime", "valueHolderOf", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ProvidableCompositionLocal extends CompositionLocal {
    public static final int $stable;

    static {
    }

    public ProvidableCompositionLocal(Function0 arg2) {
        super(arg2, null);
    }

    public abstract ProvidedValue defaultProvidedValue$runtime(Object arg1);

    public final ProvidedValue provides(Object arg1) {
        return this.defaultProvidedValue$runtime(arg1);
    }

    public final ProvidedValue providesComputed(Function1 arg9) {
        return new ProvidedValue(this, null, false, null, null, arg9, false);
    }

    public final ProvidedValue providesDefault(Object arg1) {
        return this.defaultProvidedValue$runtime(arg1).ifNotAlreadyProvided$runtime();
    }

    public ValueHolder updatedStateOf$runtime(ProvidedValue arg4, ValueHolder arg5) {
        ValueHolder v1 = null;
        if((arg5 instanceof DynamicValueHolder)) {
            if(arg4.isDynamic$runtime()) {
                v1 = arg5;
                ((DynamicValueHolder)v1).getState().setValue(arg4.getEffectiveValue$runtime());
            }
        }
        else if((arg5 instanceof StaticValueHolder)) {
            if((arg4.isStatic$runtime()) && (Intrinsics.areEqual(arg4.getEffectiveValue$runtime(), ((StaticValueHolder)arg5).getValue()))) {
                v1 = arg5;
            }
        }
        else if(((arg5 instanceof ComputedValueHolder)) && arg4.getCompute$runtime() == ((ComputedValueHolder)arg5).getCompute()) {
            v1 = arg5;
        }

        if(v1 == null) {
            return this.valueHolderOf(arg4);
        }

        return v1;
    }

    private final ValueHolder valueHolderOf(ProvidedValue arg2) {
        if(arg2.isDynamic$runtime()) {
            MutableState v0 = arg2.getState$runtime();
            if(v0 == null) {
                Object v0_1 = arg2.getValue();
                SnapshotMutationPolicy v2 = arg2.getMutationPolicy$runtime();
                if(v2 == null) {
                    v2 = SnapshotStateKt.structuralEqualityPolicy();
                }

                v0 = SnapshotStateKt.mutableStateOf(v0_1, v2);
            }

            return new DynamicValueHolder(v0);
        }

        if(arg2.getCompute$runtime() != null) {
            return new ComputedValueHolder(arg2.getCompute$runtime());
        }

        if(arg2.getState$runtime() != null) {
            return new DynamicValueHolder(arg2.getState$runtime());
        }

        return new StaticValueHolder(arg2.getEffectiveValue$runtime());
    }
}

