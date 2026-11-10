package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function4;

public final class SelectionManager$$ExternalSyntheticLambda13 implements Function4 {
    public SelectionManager$$ExternalSyntheticLambda13(SelectionManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return SelectionManager._init_$lambda$1(this.f$0, ((Boolean)arg1).booleanValue(), ((LayoutCoordinates)arg2), ((Offset)arg3), ((SelectionAdjustment)arg4));
    }
}

