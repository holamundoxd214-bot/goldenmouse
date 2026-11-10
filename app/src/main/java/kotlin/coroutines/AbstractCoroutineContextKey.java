package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B<\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0006\u001A\u001F\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u000E\u001A\u0004\u0018\u00018\u00012\u0006\u0010\n\u001A\u00020\u0002H\u0080\u0080\u0004¢\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0011\u001A\u00020\u00122\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0080\u0080\u0004¢\u0006\u0002\b\u0014R,\u0010\u0006\u001A\u001F\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractCoroutineContextKey implements Key {
    private final Function1 safeCast;
    private final Key topmostKey;

    public AbstractCoroutineContextKey(Key arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "baseKey");
        Intrinsics.checkNotNullParameter(arg3, "safeCast");
        super();
        this.safeCast = arg3;
        if((arg2 instanceof AbstractCoroutineContextKey)) {
            arg2 = ((AbstractCoroutineContextKey)arg2).topmostKey;
        }

        this.topmostKey = arg2;
    }

    public final boolean isSubKey$kotlin_stdlib(Key arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if((((AbstractCoroutineContextKey)arg2)) != this) {
            if(this.topmostKey == arg2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final Element tryCast$kotlin_stdlib(Element arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return this.safeCast.invoke(arg2);
    }
}

