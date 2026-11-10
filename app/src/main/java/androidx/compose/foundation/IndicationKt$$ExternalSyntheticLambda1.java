package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function3;

public final class IndicationKt$$ExternalSyntheticLambda1 implements Function3 {
    public IndicationKt$$ExternalSyntheticLambda1(Indication arg1, InteractionSource arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return IndicationKt.indication$lambda$1(this.f$0, this.f$1, ((Modifier)arg2), ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

