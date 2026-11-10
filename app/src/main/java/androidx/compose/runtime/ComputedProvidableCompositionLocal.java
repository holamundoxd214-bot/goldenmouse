package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\u0006\u0010\u000F\u001A\u00028\u0000H\u0010¢\u0006\u0004\b\u0010\u0010\u0011R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/ComputedProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultComputation", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "defaultValueHolder", "Landroidx/compose/runtime/ComputedValueHolder;", "getDefaultValueHolder$runtime", "()Landroidx/compose/runtime/ComputedValueHolder;", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComputedProvidableCompositionLocal extends ProvidableCompositionLocal {
    public static final int $stable;
    private final ComputedValueHolder defaultValueHolder;

    static {
    }

    public ComputedProvidableCompositionLocal(Function1 arg2) {
        super(new ComputedProvidableCompositionLocal$$ExternalSyntheticLambda0());
        this.defaultValueHolder = new ComputedValueHolder(arg2);
    }

    static final Object _init_$lambda$0() {
        ComposerKt.composeRuntimeError("Unexpected call to default provider");
        throw new KotlinNothingValueException();
    }

    public ProvidedValue defaultProvidedValue$runtime(Object arg9) {
        ComputedProvidableCompositionLocal v1 = this;
        boolean v8 = arg9 == null ? true : false;
        return new ProvidedValue(((CompositionLocal)v1), arg9, v8, null, null, null, true);
    }

    public ComputedValueHolder getDefaultValueHolder$runtime() {
        return this.defaultValueHolder;
    }

    public ValueHolder getDefaultValueHolder$runtime() {
        return this.getDefaultValueHolder$runtime();
    }
}

