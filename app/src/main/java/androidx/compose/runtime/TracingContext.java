package androidx.compose.runtime;

import androidx.compose.runtime.internal.Trace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext$Element$DefaultImpls;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0012B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u001D\u0010\u000F\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001A\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/TracingContext;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlinx/coroutines/ThreadContextElement;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "oldState", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/Unit;)V", "Key", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class TracingContext implements Element, ThreadContextElement {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/runtime/TracingContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/TracingContext;", "<init>", "()V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key implements kotlin.coroutines.CoroutineContext$Key {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }
    }

    public static final int $stable;
    public static final Key Key;
    private final String name;

    static {
        TracingContext.Key = new Key(null);
    }

    public TracingContext(String arg1) {
        super();
        this.name = arg1;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Element)this), arg1, arg2);
    }

    public Element get(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.get(((Element)this), arg1);
    }

    public kotlin.coroutines.CoroutineContext$Key getKey() {
        return TracingContext.Key;
    }

    public CoroutineContext minusKey(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.minusKey(((Element)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Element)this), arg1);
    }

    public void restoreThreadContext(CoroutineContext arg1, Object arg2) {
        this.restoreThreadContext(arg1, ((Unit)arg2));
    }

    public void restoreThreadContext(CoroutineContext arg1, Unit arg2) {
        Trace.INSTANCE.endSection(Unit.INSTANCE);
    }

    public Object updateThreadContext(CoroutineContext arg1) {
        this.updateThreadContext(arg1);
        return Unit.INSTANCE;
    }

    public void updateThreadContext(CoroutineContext arg1) {
        Trace.INSTANCE.beginSection(this.name);
    }
}

