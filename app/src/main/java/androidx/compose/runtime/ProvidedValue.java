package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bl\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000B\u0012\u0019\u0010\f\u001A\u0015\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\b\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\b+R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u001C\u0010\n\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\'\u0010\f\u001A\u0015\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\b\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0010\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0012\u0010\u001D\u001A\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001ER\u0017\u0010\u0005\u001A\u00028\u00008F¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R \u0010#\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00078\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001CR\u001A\u0010%\u001A\u00028\u00008@X\u0080\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001A\u0004\b\'\u0010\"R\u0014\u0010(\u001A\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\u001C¨\u0006,"}, d2={"Landroidx/compose/runtime/ProvidedValue;", "T", "", "compositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "value", "explicitNull", "", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "state", "Landroidx/compose/runtime/MutableState;", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "isDynamic", "<init>", "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;ZLandroidx/compose/runtime/SnapshotMutationPolicy;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Z)V", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "getMutationPolicy$runtime", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getState$runtime", "()Landroidx/compose/runtime/MutableState;", "getCompute$runtime", "()Lkotlin/jvm/functions/Function1;", "isDynamic$runtime", "()Z", "providedValue", "Ljava/lang/Object;", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "canOverride", "getCanOverride", "effectiveValue", "getEffectiveValue$runtime$annotations", "getEffectiveValue$runtime", "isStatic", "isStatic$runtime", "ifNotAlreadyProvided", "ifNotAlreadyProvided$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ProvidedValue {
    public static final int $stable = 8;
    private boolean canOverride;
    private final CompositionLocal compositionLocal;
    private final Function1 compute;
    private final boolean explicitNull;
    private final boolean isDynamic;
    private final SnapshotMutationPolicy mutationPolicy;
    private final Object providedValue;
    private final MutableState state;

    static {
    }

    public ProvidedValue(CompositionLocal arg1, Object arg2, boolean arg3, SnapshotMutationPolicy arg4, MutableState arg5, Function1 arg6, boolean arg7) {
        super();
        this.compositionLocal = arg1;
        this.explicitNull = arg3;
        this.mutationPolicy = arg4;
        this.state = arg5;
        this.compute = arg6;
        this.isDynamic = arg7;
        this.providedValue = arg2;
        this.canOverride = true;
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    public final CompositionLocal getCompositionLocal() {
        return this.compositionLocal;
    }

    public final Function1 getCompute$runtime() {
        return this.compute;
    }

    public final Object getEffectiveValue$runtime() {
        if(this.explicitNull) {
            return null;
        }

        MutableState v0 = this.state;
        if(v0 != null) {
            return v0.getValue();
        }

        Object v1 = this.providedValue;
        if(v1 != null) {
            return v1;
        }

        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }

    public static void getEffectiveValue$runtime$annotations() {
    }

    public final SnapshotMutationPolicy getMutationPolicy$runtime() {
        return this.mutationPolicy;
    }

    public final MutableState getState$runtime() {
        return this.state;
    }

    public final Object getValue() {
        return this.providedValue;
    }

    public static void getValue$annotations() {
    }

    public final ProvidedValue ifNotAlreadyProvided$runtime() {
        this.canOverride = false;
        return this;
    }

    public final boolean isDynamic$runtime() {
        return this.isDynamic;
    }

    public final boolean isStatic$runtime() {
        if(((this.explicitNull) || this.getValue() != null) && !this.isDynamic) {
            return 1;
        }

        return 0;
    }
}

