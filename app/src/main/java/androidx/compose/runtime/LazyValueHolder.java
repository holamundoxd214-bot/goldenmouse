package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u000EH\u0016¢\u0006\u0002\u0010\u000FJ\u001C\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u001B\u0010\u0007\u001A\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\b\u0010\t¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/LazyValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "valueProducer", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent", "()Ljava/lang/Object;", "current$delegate", "Lkotlin/Lazy;", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LazyValueHolder implements ValueHolder {
    public static final int $stable = 8;
    private final Lazy current$delegate;

    static {
    }

    public LazyValueHolder(Function0 arg1) {
        super();
        this.current$delegate = LazyKt.lazy(arg1);
    }

    private final Object getCurrent() {
        return this.current$delegate.getValue();
    }

    public Object readValue(PersistentCompositionLocalMap arg1) {
        return this.getCurrent();
    }

    public ProvidedValue toProvided(CompositionLocal arg1) {
        ComposerKt.composeRuntimeError("Cannot produce a provider from a lazy value holder");
        throw new KotlinNothingValueException();
    }
}

