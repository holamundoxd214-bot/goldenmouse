package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element$DefaultImpls;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "<init>", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class UndispatchedMarker implements Element, Key {
    public static final UndispatchedMarker INSTANCE;

    static {
        UndispatchedMarker.INSTANCE = new UndispatchedMarker();
    }

    private UndispatchedMarker() {
        super();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Element)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((Element)this), arg1);
    }

    public Key getKey() {
        return this;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((Element)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Element)this), arg1);
    }
}

