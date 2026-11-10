package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.jvm.functions.Function2;

public final class AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda3 implements Function2 {
    public AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda3(ViewConfiguration arg1, long arg2, boolean arg4, Modifier arg5, OffsetProvider arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
    }

    public final Object invoke(Object arg9, Object arg10) {
        return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, arg9, ((Integer)arg10).intValue());
    }
}

