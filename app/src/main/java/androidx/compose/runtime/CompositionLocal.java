package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\u000E\u0010\u000E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH ¢\u0006\u0002\b\u000FR\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0018\u0010\u0010\u001A\u00028\u00008Ç\u0002¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/CompositionLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "defaultValueHolder", "Landroidx/compose/runtime/ValueHolder;", "getDefaultValueHolder$runtime", "()Landroidx/compose/runtime/ValueHolder;", "updatedStateOf", "value", "Landroidx/compose/runtime/ProvidedValue;", "previous", "updatedStateOf$runtime", "current", "getCurrent$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class CompositionLocal {
    public static final int $stable;
    private final ValueHolder defaultValueHolder;

    static {
    }

    private CompositionLocal(Function0 arg2) {
        super();
        this.defaultValueHolder = new LazyValueHolder(arg2);
    }

    public CompositionLocal(Function0 arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final Object getCurrent(Composer arg2, int arg3) {
        ComposerKt.sourceInformationMarkerStart(arg2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1 = arg2.consume(this);
        ComposerKt.sourceInformationMarkerEnd(arg2);
        return v1;
    }

    public static void getCurrent$annotations(Composer arg0, int arg1) {
    }

    public ValueHolder getDefaultValueHolder$runtime() {
        return this.defaultValueHolder;
    }

    public abstract ValueHolder updatedStateOf$runtime(ProvidedValue arg1, ValueHolder arg2);
}

