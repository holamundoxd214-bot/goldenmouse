package androidx.compose.material3.internal;

import androidx.compose.foundation.shape.RoundedCornerShape;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.Channel;

public final class AnimatedShapeKt$$ExternalSyntheticLambda0 implements Function0 {
    public AnimatedShapeKt$$ExternalSyntheticLambda0(Channel arg1, RoundedCornerShape arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return AnimatedShapeKt.rememberAnimatedShape$lambda$4$lambda$3(this.f$0, this.f$1);
    }
}

