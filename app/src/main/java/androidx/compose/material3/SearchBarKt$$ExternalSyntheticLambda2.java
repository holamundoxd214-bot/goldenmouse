package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class SearchBarKt$$ExternalSyntheticLambda2 implements Function2 {
    public SearchBarKt$$ExternalSyntheticLambda2(InteractionSource arg1, Function0 arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return SearchBarKt.DetectClickFromInteractionSource$lambda$73(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

