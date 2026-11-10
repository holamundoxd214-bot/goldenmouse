package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ2\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u001C\u0010\u0004\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H¦@¢\u0006\u0002\u0010\bR\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "Lkotlin/coroutines/CoroutineContext$Element;", "onInfiniteOperation", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface InfiniteAnimationPolicy extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(InfiniteAnimationPolicy arg0, Object arg1, Function2 arg2) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg0), arg1, arg2);
        }

        public static Element get(InfiniteAnimationPolicy arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.get(((Element)arg0), arg1);
        }

        @Deprecated public static Key getKey(InfiniteAnimationPolicy arg0) {
            return arg0.getKey();
        }

        public static CoroutineContext minusKey(InfiniteAnimationPolicy arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.minusKey(((Element)arg0), arg1);
        }

        public static CoroutineContext plus(InfiniteAnimationPolicy arg0, CoroutineContext arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg0), arg1);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.platform.InfiniteAnimationPolicy$Key implements Key {
        static {
            androidx.compose.ui.platform.InfiniteAnimationPolicy$Key.$$INSTANCE = new androidx.compose.ui.platform.InfiniteAnimationPolicy$Key();
        }

        private androidx.compose.ui.platform.InfiniteAnimationPolicy$Key() {
            super();
        }
    }

    public static final androidx.compose.ui.platform.InfiniteAnimationPolicy$Key Key;

    static {
        InfiniteAnimationPolicy.Key = androidx.compose.ui.platform.InfiniteAnimationPolicy$Key.$$INSTANCE;
    }

    static Key access$getKey$jd(InfiniteAnimationPolicy arg0) {
        return super.getKey();
    }

    default Key getKey() {
        return InfiniteAnimationPolicy.Key;
    }

    Object onInfiniteOperation(Function1 arg1, Continuation arg2);
}

