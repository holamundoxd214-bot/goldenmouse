package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001A\u00028\u0000H\u0010¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/runtime/StaticProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StaticProvidableCompositionLocal extends ProvidableCompositionLocal {
    public static final int $stable;

    static {
    }

    public StaticProvidableCompositionLocal(Function0 arg1) {
        super(arg1);
    }

    public ProvidedValue defaultProvidedValue$runtime(Object arg9) {
        StaticProvidableCompositionLocal v1 = this;
        boolean v8 = arg9 == null ? true : false;
        return new ProvidedValue(((CompositionLocal)v1), arg9, v8, null, null, null, false);
    }
}

