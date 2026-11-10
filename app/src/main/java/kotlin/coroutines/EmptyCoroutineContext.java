package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001A\u00020\tH\u0082\u0080\u0004J)\u0010\n\u001A\u0004\u0018\u0001H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0096\u0082\u0004¢\u0006\u0002\u0010\u000FJ7\u0010\u0010\u001A\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001A\u0002H\u00112\u0018\u0010\u0013\u001A\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00110\u0014H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u0001H\u0096\u0082\u0004J\u0016\u0010\u0018\u001A\u00020\u00012\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u000EH\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EmptyCoroutineContext implements Serializable, CoroutineContext {
    public static final EmptyCoroutineContext INSTANCE;
    private static final long serialVersionUID;

    static {
        EmptyCoroutineContext.INSTANCE = new EmptyCoroutineContext();
    }

    private EmptyCoroutineContext() {
        super();
    }

    public Object fold(Object arg1, Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "operation");
        return arg1;
    }

    public Element get(Key arg1) {
        Intrinsics.checkNotNullParameter(arg1, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public CoroutineContext minusKey(Key arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this;
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return arg1;
    }

    private final Object readResolve() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}

