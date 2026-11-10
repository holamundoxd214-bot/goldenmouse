package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class CardKt$$ExternalSyntheticLambda1 implements Function2 {
    public CardKt$$ExternalSyntheticLambda1(Modifier arg1, Shape arg2, CardColors arg3, CardElevation arg4, BorderStroke arg5, Function3 arg6, int arg7, int arg8) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
        this.f$7 = arg8;
    }

    public final Object invoke(Object arg11, Object arg12) {
        return CardKt.OutlinedCard$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, arg11, ((Integer)arg12).intValue());
    }
}

