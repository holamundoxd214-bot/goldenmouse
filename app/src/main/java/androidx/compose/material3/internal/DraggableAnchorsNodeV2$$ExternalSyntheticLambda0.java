package androidx.compose.material3.internal;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.functions.Function1;

public final class DraggableAnchorsNodeV2$$ExternalSyntheticLambda0 implements Function1 {
    public DraggableAnchorsNodeV2$$ExternalSyntheticLambda0(MeasureScope arg1, DraggableAnchorsNodeV2 arg2, Placeable arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return DraggableAnchorsNodeV2.measure_3p2s80s$lambda$1(this.f$0, this.f$1, this.f$2, ((PlacementScope)arg3));
    }
}

