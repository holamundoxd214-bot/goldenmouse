package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000B\u001A\u00028\u0000H\u0010¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/DynamicProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DynamicProvidableCompositionLocal extends ProvidableCompositionLocal {
    public static final int $stable;
    private final SnapshotMutationPolicy policy;

    static {
    }

    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy arg1, Function0 arg2) {
        super(arg2);
        this.policy = arg1;
    }

    public ProvidedValue defaultProvidedValue$runtime(Object arg9) {
        DynamicProvidableCompositionLocal v1 = this;
        boolean v2 = arg9 == null ? true : false;
        return new ProvidedValue(((CompositionLocal)v1), arg9, v2, this.policy, null, null, true);
    }
}

