package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function2;

public final class SelectionRegistrarImpl$$ExternalSyntheticLambda2 implements Function2 {
    public SelectionRegistrarImpl$$ExternalSyntheticLambda2(LayoutCoordinates arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Integer.valueOf(SelectionRegistrarImpl.sort$lambda$0(this.f$0, ((Selectable)arg1), ((Selectable)arg2)));
    }
}

