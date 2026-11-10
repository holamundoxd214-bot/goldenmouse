package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/animation/SharedTransitionDefaults;", "", "<init>", "()V", "BoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "SharedContentConfig", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedTransitionDefaults {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/animation/SharedTransitionDefaults$SharedContentConfig;", "Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;", "<init>", "()V", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedContentConfig implements androidx.compose.animation.SharedTransitionScope$SharedContentConfig {
        public static final int $stable;
        public static final SharedContentConfig INSTANCE;

        static {
            SharedContentConfig.INSTANCE = new SharedContentConfig();
        }

        private SharedContentConfig() {
            super();
        }
    }

    public static final int $stable;
    private static final BoundsTransform BoundsTransform;
    public static final SharedTransitionDefaults INSTANCE;

    static {
        SharedTransitionDefaults.INSTANCE = new SharedTransitionDefaults();
        SharedTransitionDefaults.BoundsTransform = new SharedTransitionDefaults$$ExternalSyntheticLambda0();
        SharedTransitionDefaults.$stable = 8;
    }

    private SharedTransitionDefaults() {
        super();
    }

    static final FiniteAnimationSpec BoundsTransform$lambda$0(Rect arg0, Rect arg1) {
        return SharedTransitionScopeKt.access$getDefaultSpring$p();
    }

    public final BoundsTransform getBoundsTransform() {
        return SharedTransitionDefaults.BoundsTransform;
    }
}

