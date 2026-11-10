package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A-\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0006\u001A\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0087\u0080\u0004¨\u0006\b"}, d2={"getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CoroutineContextImplKt {
    public static final Element getPolymorphicElement(Element arg2, Key arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "key");
        Element v1 = null;
        if((arg3 instanceof AbstractCoroutineContextKey)) {
            if(((AbstractCoroutineContextKey)arg3).isSubKey$kotlin_stdlib(arg2.getKey())) {
                arg2 = ((AbstractCoroutineContextKey)arg3).tryCast$kotlin_stdlib(arg2);
                if((arg2 instanceof Element)) {
                    return arg2;
                }
            }

            return v1;
        }

        if(arg2.getKey() == arg3) {
            return arg2;
        }

        return v1;
    }

    public static final CoroutineContext minusPolymorphicKey(Element arg1, Key arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "key");
        if((arg2 instanceof AbstractCoroutineContextKey)) {
            if((((AbstractCoroutineContextKey)arg2).isSubKey$kotlin_stdlib(arg1.getKey())) && ((AbstractCoroutineContextKey)arg2).tryCast$kotlin_stdlib(arg1) != null) {
                return EmptyCoroutineContext.INSTANCE;
            }

            return arg1;
        }

        if(arg1.getKey() == arg2) {
            return EmptyCoroutineContext.INSTANCE;
        }

        return arg1;
    }
}

