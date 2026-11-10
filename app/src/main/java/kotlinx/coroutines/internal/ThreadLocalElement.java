package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement$DefaultImpls;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\r\u001A\u00028\u00002\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0002\u0010\u0010J\u001D\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001A\u00020\u000F2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nH\u0016J(\u0010\u0016\u001A\u0004\u0018\u0001H\u0017\"\b\b\u0001\u0010\u0017*\u00020\u00182\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00170\nH\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u0010\u0010\u0003\u001A\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001C"}, d2={"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "value", "threadLocal", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "Ljava/lang/Object;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "updateThreadContext", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "restoreThreadContext", "", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "minusKey", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ThreadLocalElement implements ThreadContextElement {
    private final Key key;
    private final ThreadLocal threadLocal;
    private final Object value;

    public ThreadLocalElement(Object arg1, ThreadLocal arg2) {
        super();
        this.value = arg1;
        this.threadLocal = arg2;
        this.key = new ThreadLocalKey(arg2);
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((ThreadContextElement)this), arg1, arg2);
    }

    public Element get(Key arg2) {
        if(Intrinsics.areEqual(this.getKey(), arg2)) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
            return this;
        }

        return null;
    }

    public Key getKey() {
        return this.key;
    }

    public CoroutineContext minusKey(Key arg2) {
        if(Intrinsics.areEqual(this.getKey(), arg2)) {
            return EmptyCoroutineContext.INSTANCE;
        }

        return this;
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((ThreadContextElement)this), arg1);
    }

    public void restoreThreadContext(CoroutineContext arg1, Object arg2) {
        this.threadLocal.set(arg2);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    public Object updateThreadContext(CoroutineContext arg2) {
        Object v2 = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return v2;
    }
}

