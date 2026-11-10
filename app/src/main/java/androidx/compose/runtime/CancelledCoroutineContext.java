package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element$DefaultImpls;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/runtime/CancelledCoroutineContext;", "Lkotlin/coroutines/CoroutineContext$Element;", "<init>", "()V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class CancelledCoroutineContext implements Element {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/runtime/CancelledCoroutineContext$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/CancelledCoroutineContext;", "<init>", "()V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key implements kotlin.coroutines.CoroutineContext$Key {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }
    }

    public static final Key Key;

    static {
        CancelledCoroutineContext.Key = new Key(null);
    }

    public CancelledCoroutineContext() {
        super();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Element)this), arg1, arg2);
    }

    public Element get(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.get(((Element)this), arg1);
    }

    public kotlin.coroutines.CoroutineContext$Key getKey() {
        return CancelledCoroutineContext.Key;
    }

    public CoroutineContext minusKey(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.minusKey(((Element)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Element)this), arg1);
    }
}

