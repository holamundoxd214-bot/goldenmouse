package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function2;

public final class BasicTooltipKt$$ExternalSyntheticLambda2 implements Function2 {
    public BasicTooltipKt$$ExternalSyntheticLambda2(String arg1, Function2 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return BasicTooltipKt.TooltipPopup$lambda$1(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

