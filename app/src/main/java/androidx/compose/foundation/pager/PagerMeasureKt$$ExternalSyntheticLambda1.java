package androidx.compose.foundation.pager;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import kotlin.jvm.functions.Function1;

public final class PagerMeasureKt$$ExternalSyntheticLambda1 implements Function1 {
    public PagerMeasureKt$$ExternalSyntheticLambda1(LazyLayoutMeasureScope arg1, long arg2, PagerLazyLayoutItemProvider arg4, long arg5, Orientation arg7, Horizontal arg8, Vertical arg9, boolean arg10, int arg11, MutableIntObjectMap arg12) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg7;
        this.f$5 = arg8;
        this.f$6 = arg9;
        this.f$7 = arg10;
        this.f$8 = arg11;
        this.f$9 = arg12;
    }

    public final Object invoke(Object arg14) {
        return PagerMeasureKt.measurePager_7L1iB3k$lambda$10(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, ((Integer)arg14).intValue());
    }
}

