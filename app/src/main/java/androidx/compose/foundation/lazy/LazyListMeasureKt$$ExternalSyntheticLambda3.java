package androidx.compose.foundation.lazy;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final class LazyListMeasureKt$$ExternalSyntheticLambda3 implements Function1 {
    public LazyListMeasureKt$$ExternalSyntheticLambda3(MutableState arg1, List arg2, List arg3, boolean arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, ((PlacementScope)arg4));
    }
}

