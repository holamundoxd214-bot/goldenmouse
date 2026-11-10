package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class LazyDslKt$$ExternalSyntheticLambda1 implements Function2 {
    public LazyDslKt$$ExternalSyntheticLambda1(Modifier arg1, LazyListState arg2, PaddingValues arg3, boolean arg4, Vertical arg5, Horizontal arg6, FlingBehavior arg7, Function1 arg8, int arg9, int arg10) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
        this.f$8 = arg9;
        this.f$9 = arg10;
    }

    public final Object invoke(Object arg13, Object arg14) {
        return LazyDslKt.LazyColumn$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, arg13, ((Integer)arg14).intValue());
    }
}

