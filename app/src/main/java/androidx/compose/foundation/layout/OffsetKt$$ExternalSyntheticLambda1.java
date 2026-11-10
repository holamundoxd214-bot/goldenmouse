package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.functions.Function1;

public final class OffsetKt$$ExternalSyntheticLambda1 implements Function1 {
    public OffsetKt$$ExternalSyntheticLambda1(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return OffsetKt.absoluteOffset$lambda$0(this.f$0, ((InspectorInfo)arg1));
    }
}

