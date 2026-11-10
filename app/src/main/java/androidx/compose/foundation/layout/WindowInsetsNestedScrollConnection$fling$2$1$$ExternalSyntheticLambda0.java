package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class WindowInsetsNestedScrollConnection$fling$2$1$$ExternalSyntheticLambda0 implements Function2 {
    public WindowInsetsNestedScrollConnection$fling$2$1$$ExternalSyntheticLambda0(int arg1, int arg2, WindowInsetsNestedScrollConnection arg3, FloatRef arg4, WindowInsetsAnimationController arg5, boolean arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg9, Object arg10) {
        return androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, ((Float)arg9).floatValue(), ((Float)arg10).floatValue());
    }
}

