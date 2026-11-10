package androidx.compose.material3.internal;

import androidx.compose.animation.core.SpringSpec;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/material3/internal/AnchoredDraggableDefaults;", "", "<init>", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableDefaults {
    public static final int $stable;
    private static final SpringSpec AnimationSpec;
    public static final AnchoredDraggableDefaults INSTANCE;

    static {
        AnchoredDraggableDefaults.INSTANCE = new AnchoredDraggableDefaults();
        AnchoredDraggableDefaults.AnimationSpec = new SpringSpec(0f, 0f, null, 7, null);
    }

    private AnchoredDraggableDefaults() {
        super();
    }

    public final SpringSpec getAnimationSpec() {
        return AnchoredDraggableDefaults.AnimationSpec;
    }
}

