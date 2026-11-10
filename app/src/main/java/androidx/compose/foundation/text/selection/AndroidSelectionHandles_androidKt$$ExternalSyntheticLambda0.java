package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import kotlin.jvm.functions.Function2;

public final class AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda0(OffsetProvider arg1, Alignment arg2, Function2 arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return AndroidSelectionHandles_androidKt.HandlePopup$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}

