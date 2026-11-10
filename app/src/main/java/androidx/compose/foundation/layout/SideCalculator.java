package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bc\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H&J\u0018\u0010\n\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0018\u0010\u000B\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0018\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0003H&J\u0017\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001AÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/SideCalculator;", "", "valueOf", "", "insets", "Landroid/graphics/Insets;", "motionOf", "", "x", "y", "showMotion", "hideMotion", "adjustInsets", "oldInsets", "newValue", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "consumedVelocity-QWom1Mo", "(JF)J", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) interface SideCalculator {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0004\r\u0010\u0013\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BR\u0010\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u0010\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/SideCalculator$Companion;", "", "<init>", "()V", "chooseCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "chooseCalculator-ni1skBw", "(ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/layout/SideCalculator;", "LeftSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1;", "TopSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1;", "RightSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1;", "BottomSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator;
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator;
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator;
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.LeftSideCalculator = new SideCalculator$Companion$LeftSideCalculator$1();
            Companion.TopSideCalculator = new SideCalculator$Companion$TopSideCalculator$1();
            Companion.RightSideCalculator = new SideCalculator$Companion$RightSideCalculator$1();
            Companion.BottomSideCalculator = new SideCalculator$Companion$BottomSideCalculator$1();
        }

        private Companion() {
            super();
        }

        public final SideCalculator chooseCalculator-ni1skBw(int arg1, LayoutDirection arg2) {
            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getLeft-JoeWqyM())) {
                return Companion.LeftSideCalculator;
            }

            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getTop-JoeWqyM())) {
                return Companion.TopSideCalculator;
            }

            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getRight-JoeWqyM())) {
                return Companion.RightSideCalculator;
            }

            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getBottom-JoeWqyM())) {
                return Companion.BottomSideCalculator;
            }

            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getStart-JoeWqyM())) {
                if(arg2 == LayoutDirection.Ltr) {
                    return Companion.LeftSideCalculator;
                }

                return Companion.RightSideCalculator;
            }

            if(WindowInsetsSides.equals-impl0(arg1, WindowInsetsSides.Companion.getEnd-JoeWqyM())) {
                if(arg2 == LayoutDirection.Ltr) {
                    return Companion.RightSideCalculator;
                }

                return Companion.LeftSideCalculator;
            }

            throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
        }
    }

    public static final Companion Companion;

    static {
        SideCalculator.Companion = Companion.$$INSTANCE;
    }

    Insets adjustInsets(Insets arg1, int arg2);

    long consumedOffsets-MK-Hz9U(long arg1);

    long consumedVelocity-QWom1Mo(long arg1, float arg2);

    default float hideMotion(float arg1, float arg2) {
        return RangesKt.coerceAtMost(this.motionOf(arg1, arg2), 0f);
    }

    float motionOf(float arg1, float arg2);

    default float showMotion(float arg1, float arg2) {
        return RangesKt.coerceAtLeast(this.motionOf(arg1, arg2), 0f);
    }

    int valueOf(Insets arg1);
}

