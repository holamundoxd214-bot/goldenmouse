package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function6;

public final class SelectionManager$$ExternalSyntheticLambda1 implements Function6 {
    public SelectionManager$$ExternalSyntheticLambda1(SelectionManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
        return Boolean.valueOf(SelectionManager._init_$lambda$3(this.f$0, ((Boolean)arg1).booleanValue(), ((LayoutCoordinates)arg2), ((Offset)arg3), ((Offset)arg4), ((Boolean)arg5).booleanValue(), ((SelectionAdjustment)arg6)));
    }
}

