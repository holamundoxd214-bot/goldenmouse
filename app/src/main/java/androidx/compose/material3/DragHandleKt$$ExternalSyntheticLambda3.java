package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.jvm.functions.Function1;

public final class DragHandleKt$$ExternalSyntheticLambda3 implements Function1 {
    public DragHandleKt$$ExternalSyntheticLambda3(DragHandleShapes arg1, State arg2, MutableState arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return DragHandleKt.VerticalDragHandle$lambda$10$lambda$9(this.f$0, this.f$1, this.f$2, ((GraphicsLayerScope)arg3));
    }
}

