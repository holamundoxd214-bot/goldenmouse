package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function2;

public final class BoxKt$$ExternalSyntheticLambda0 implements Function2 {
    public BoxKt$$ExternalSyntheticLambda0(Modifier arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return BoxKt.Box$lambda$1(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

