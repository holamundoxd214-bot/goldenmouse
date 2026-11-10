package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ \u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u0004H\u0016R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038WX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getScrollAnimationSpec$annotations", "()V", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", "offset", "size", "containerSize", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BringIntoViewSpec {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0006H\u0000¢\u0006\u0002\b\u0011R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/gestures/BringIntoViewSpec$Companion;", "", "<init>", "()V", "DefaultScrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDefaultScrollAnimationSpec$foundation", "()Landroidx/compose/animation/core/AnimationSpec;", "DefaultBringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getDefaultBringIntoViewSpec$foundation", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "defaultCalculateScrollDistance", "offset", "size", "containerSize", "defaultCalculateScrollDistance$foundation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final BringIntoViewSpec DefaultBringIntoViewSpec;
        private static final AnimationSpec DefaultScrollAnimationSpec;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.DefaultScrollAnimationSpec = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
            Companion.DefaultBringIntoViewSpec = new BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1();
        }

        private Companion() {
            super();
        }

        public final float defaultCalculateScrollDistance$foundation(float arg2, float arg3, float arg4) {
            arg3 += arg2;
            if(arg2 >= 0f && arg3 <= arg4) {
                return 0;
            }

            if(arg2 < 0f && arg3 > arg4) {
                return 0;
            }

            arg3 -= arg4;
            if(Math.abs(arg2) < Math.abs(arg3)) {
                return arg2;
            }

            return arg3;
        }

        public final BringIntoViewSpec getDefaultBringIntoViewSpec$foundation() {
            return Companion.DefaultBringIntoViewSpec;
        }

        public final AnimationSpec getDefaultScrollAnimationSpec$foundation() {
            return Companion.DefaultScrollAnimationSpec;
        }
    }

    public static final Companion Companion;

    static {
        BringIntoViewSpec.Companion = Companion.$$INSTANCE;
    }

    default float calculateScrollDistance(float arg1, float arg2, float arg3) {
        return BringIntoViewSpec.Companion.defaultCalculateScrollDistance$foundation(arg1, arg2, arg3);
    }

    @Deprecated(message="Animation spec customization is no longer supported.") default AnimationSpec getScrollAnimationSpec() {
        return BringIntoViewSpec.Companion.getDefaultScrollAnimationSpec$foundation();
    }

    @Deprecated(message="Animation spec customization is no longer supported.") static void getScrollAnimationSpec$annotations() {
    }
}

