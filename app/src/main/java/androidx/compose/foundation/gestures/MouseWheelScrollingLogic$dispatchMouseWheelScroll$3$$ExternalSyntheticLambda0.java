package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$3$$ExternalSyntheticLambda0 implements Function1 {
    public MouseWheelScrollingLogic$dispatchMouseWheelScroll$3$$ExternalSyntheticLambda0(MouseWheelScrollingLogic arg1, ObjectRef arg2, FloatRef arg3, ScrollingLogic arg4, BooleanRef arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke(Object arg7) {
        return Boolean.valueOf(MouseWheelScrollingLogic$dispatchMouseWheelScroll$3.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, ((Float)arg7).floatValue()));
    }
}

