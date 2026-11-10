package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.geometry.Rect;

public final class SharedBoundsNode$$ExternalSyntheticLambda0 implements BoundsTransform {
    public SharedBoundsNode$$ExternalSyntheticLambda0() {
        super();
    }

    public final FiniteAnimationSpec createAnimationSpec(Rect arg1, Rect arg2) {
        return SharedBoundsNode.approachPlaceMatchInTransition$lambda$0(arg1, arg2);
    }
}

