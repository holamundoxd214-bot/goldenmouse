package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

public final class LazyLayoutPagerKt$$ExternalSyntheticLambda2 implements Function2 {
    public LazyLayoutPagerKt$$ExternalSyntheticLambda2(Modifier arg1, PagerState arg2, PaddingValues arg3, boolean arg4, Orientation arg5, TargetedFlingBehavior arg6, boolean arg7, OverscrollEffect arg8, int arg9, float arg10, PageSize arg11, NestedScrollConnection arg12, Function1 arg13, Horizontal arg14, Vertical arg15, SnapPosition arg16, Function4 arg17, int arg18, int arg19, int arg20) {
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
        this.f$10 = arg11;
        this.f$11 = arg12;
        this.f$12 = arg13;
        this.f$13 = arg14;
        this.f$14 = arg15;
        this.f$15 = arg16;
        this.f$16 = arg17;
        this.f$17 = arg18;
        this.f$18 = arg19;
        this.f$19 = arg20;
    }

    public final Object invoke(Object arg24, Object arg25) {
        return LazyLayoutPagerKt.Pager_eLwUrMk$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, this.f$17, this.f$18, this.f$19, arg24, arg25.intValue());
    }
}

