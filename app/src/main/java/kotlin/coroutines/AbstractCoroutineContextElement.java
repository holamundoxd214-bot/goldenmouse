package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractCoroutineContextElement implements Element {
    private final Key key;

    public AbstractCoroutineContextElement(Key arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        super();
        this.key = arg2;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Element)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((Element)this), arg1);
    }

    public Key getKey() {
        return this.key;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((Element)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Element)this), arg1);
    }
}

