package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000E\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&¨\u0006\b"}, d2={"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "mergeForChild", "Lkotlin/coroutines/CoroutineContext;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext$Element;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CopyableThreadContextElement extends ThreadContextElement {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(CopyableThreadContextElement arg0, Object arg1, Function2 arg2) {
            return kotlinx.coroutines.ThreadContextElement$DefaultImpls.fold(((ThreadContextElement)arg0), arg1, arg2);
        }

        public static Element get(CopyableThreadContextElement arg0, Key arg1) {
            return kotlinx.coroutines.ThreadContextElement$DefaultImpls.get(((ThreadContextElement)arg0), arg1);
        }

        public static CoroutineContext minusKey(CopyableThreadContextElement arg0, Key arg1) {
            return kotlinx.coroutines.ThreadContextElement$DefaultImpls.minusKey(((ThreadContextElement)arg0), arg1);
        }

        public static CoroutineContext plus(CopyableThreadContextElement arg0, CoroutineContext arg1) {
            return kotlinx.coroutines.ThreadContextElement$DefaultImpls.plus(((ThreadContextElement)arg0), arg1);
        }
    }

    CopyableThreadContextElement copyForChild();

    CoroutineContext mergeForChild(Element arg1);
}

