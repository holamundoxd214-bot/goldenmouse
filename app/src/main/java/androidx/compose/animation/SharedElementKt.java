package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u001A\u0013\u0010\u0007\u001A\u00020\u0006*\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"hasVisibleContent", "", "", "Landroidx/compose/animation/SharedElementEntry;", "DefaultMomentumSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "toOffset", "Landroidx/compose/ui/unit/Velocity;", "toOffset-TH1AsA0", "(J)J", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SharedElementKt {
    private static final SpringSpec DefaultMomentumSpring;

    static {
        SharedElementKt.DefaultMomentumSpring = AnimationSpecKt.spring$default(0f, 400f, Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(3f))) << 0x20 | (((long)Float.floatToRawIntBits(3f))) & 0xFFFFFFFFL)), 1, null);
    }

    public static final SpringSpec access$getDefaultMomentumSpring$p() {
        return SharedElementKt.DefaultMomentumSpring;
    }

    public static final boolean access$hasVisibleContent(List arg0) {
        return SharedElementKt.hasVisibleContent(arg0);
    }

    private static final boolean hasVisibleContent(List arg4) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(arg4.get(v2).getBoundsAnimation().getTarget()) {
                return 1;
            }
        }

        return 0;
    }

    public static final long toOffset-TH1AsA0(long arg4) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Velocity.getY-impl(arg4)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Velocity.getX-impl(arg4)))) << 0x20);
    }
}

