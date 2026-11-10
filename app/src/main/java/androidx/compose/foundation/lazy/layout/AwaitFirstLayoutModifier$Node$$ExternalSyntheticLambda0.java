package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.spatial.RelativeLayoutBounds;
import kotlin.jvm.functions.Function1;

public final class AwaitFirstLayoutModifier$Node$$ExternalSyntheticLambda0 implements Function1 {
    public AwaitFirstLayoutModifier$Node$$ExternalSyntheticLambda0(Node arg1, AwaitFirstLayoutModifier arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Node.requestOnAfterLayoutCallback$lambda$0(this.f$0, this.f$1, ((RelativeLayoutBounds)arg2));
    }
}

