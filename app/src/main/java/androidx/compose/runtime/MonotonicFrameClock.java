package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FJ7\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032!\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00030\u0005H¦@¢\u0006\u0002\u0010\nR\u0018\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2={"Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/CoroutineContext$Element;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface MonotonicFrameClock extends Element {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(MonotonicFrameClock arg0, Object arg1, Function2 arg2) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg0), arg1, arg2);
        }

        public static Element get(MonotonicFrameClock arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.get(((Element)arg0), arg1);
        }

        @Deprecated public static Key getKey(MonotonicFrameClock arg0) {
            return arg0.getKey();
        }

        public static CoroutineContext minusKey(MonotonicFrameClock arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.minusKey(((Element)arg0), arg1);
        }

        public static CoroutineContext plus(MonotonicFrameClock arg0, CoroutineContext arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg0), arg1);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/runtime/MonotonicFrameClock$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/MonotonicFrameClock;", "<init>", "()V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.compose.runtime.MonotonicFrameClock$Key implements Key {
        static {
            androidx.compose.runtime.MonotonicFrameClock$Key.$$INSTANCE = new androidx.compose.runtime.MonotonicFrameClock$Key();
        }

        private androidx.compose.runtime.MonotonicFrameClock$Key() {
            super();
        }
    }

    public static final androidx.compose.runtime.MonotonicFrameClock$Key Key;

    static {
        MonotonicFrameClock.Key = androidx.compose.runtime.MonotonicFrameClock$Key.$$INSTANCE;
    }

    static Key access$getKey$jd(MonotonicFrameClock arg0) {
        return super.getKey();
    }

    default Key getKey() {
        return MonotonicFrameClock.Key;
    }

    Object withFrameNanos(Function1 arg1, Continuation arg2);
}

