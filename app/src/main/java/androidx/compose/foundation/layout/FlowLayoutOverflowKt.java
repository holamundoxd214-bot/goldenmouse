package androidx.compose.foundation.layout;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A&\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000¨\u0006\u0007"}, d2={"lazyInt", "Lkotlin/Lazy;", "", "errorMessage", "", "initializer", "Lkotlin/Function0;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FlowLayoutOverflowKt {
    public static final Lazy lazyInt(String arg1, Function0 arg2) {
        return new LazyImpl(arg2, arg1);
    }

    public static Lazy lazyInt$default(String arg0, Function0 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = "Lazy item is not yet initialized";
        }

        return FlowLayoutOverflowKt.lazyInt(arg0, arg1);
    }
}

