package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/MotionDurationScale;", "Lkotlin/coroutines/CoroutineContext$Element;", "scaleFactor", "", "getScaleFactor", "()F", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MotionDurationScale extends Element {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(MotionDurationScale arg0, Object arg1, Function2 arg2) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg0), arg1, arg2);
        }

        public static Element get(MotionDurationScale arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.get(((Element)arg0), arg1);
        }

        public static CoroutineContext minusKey(MotionDurationScale arg0, Key arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.minusKey(((Element)arg0), arg1);
        }

        public static CoroutineContext plus(MotionDurationScale arg0, CoroutineContext arg1) {
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg0), arg1);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/MotionDurationScale$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.MotionDurationScale$Key implements Key {
        static {
            androidx.compose.ui.MotionDurationScale$Key.$$INSTANCE = new androidx.compose.ui.MotionDurationScale$Key();
        }

        private androidx.compose.ui.MotionDurationScale$Key() {
            super();
        }
    }

    public static final androidx.compose.ui.MotionDurationScale$Key Key;

    static {
        MotionDurationScale.Key = androidx.compose.ui.MotionDurationScale$Key.$$INSTANCE;
    }

    default Key getKey() {
        return MotionDurationScale.Key;
    }

    float getScaleFactor();
}

