package androidx.compose.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A7\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001A\u0018\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0002\u001A\u0019\u0010\u0016\u001A\u00020\t*\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u000FH\u0000¢\u0006\u0002\u0010\u0018\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001A\u00020\u000F*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2={"SharedTransitionDebug", "", "updateTargetData", "", "targetData", "Landroidx/compose/animation/TargetData;", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "targetBoundsProviderChanged", "updateTargetData-BGTQxF0", "(Landroidx/compose/animation/TargetData;JJJZ)V", "obtainBoundsFromLastTarget", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/SharedElement;", "lastTargetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "targetBounds", "getTargetBounds", "(Landroidx/compose/animation/TargetData;)Landroidx/compose/ui/geometry/Rect;", "calculateOffsetFromDirectManipulation", "animatedBounds", "(Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)J", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SharedTransitionStateMachineKt {
    public static final boolean SharedTransitionDebug = false;

    public static final Rect access$obtainBoundsFromLastTarget(SharedElement arg0, BoundsProvider arg1) {
        return SharedTransitionStateMachineKt.obtainBoundsFromLastTarget(arg0, arg1);
    }

    public static final void access$updateTargetData-BGTQxF0(TargetData arg0, long arg1, long arg3, long arg5, boolean arg7) {
        SharedTransitionStateMachineKt.updateTargetData-BGTQxF0(arg0, arg1, arg3, arg5, arg7);
    }

    public static final long calculateOffsetFromDirectManipulation(TargetData arg4, Rect arg5) {
        return Offset.plus-MK-Hz9U(Offset.minus-MK-Hz9U(arg5.getTopLeft-F1C5BW0(), arg4.getInitialMfrOffset-F1C5BW0()), arg4.getCurrentMfrOffset-F1C5BW0());
    }

    public static final Rect getTargetBounds(TargetData arg4) {
        return RectKt.Rect-tz77jQw(Offset.plus-MK-Hz9U(arg4.getInitialMfrOffset-F1C5BW0(), arg4.getTargetStructuralOffset-F1C5BW0()), arg4.getSize-NH-jbRc());
    }

    private static final Rect obtainBoundsFromLastTarget(SharedElement arg3, BoundsProvider arg4) {
        if(arg4 != null) {
            List v3 = arg3.getAllEntries();
            int v0 = v3.size();
            int v1 = 0;
            while(v1 < v0) {
                if(Intrinsics.areEqual(v3.get(v1).getBoundsProvider(), arg4)) {
                    return arg4.getLastBoundsInSharedTransitionScope();
                }
                else {
                    ++v1;
                    continue;
                }

                return null;
            }
        }

        return null;
    }

    private static final void updateTargetData-BGTQxF0(TargetData arg4, long arg5, long arg7, long arg9, boolean arg11) {
        if(!Offset.equals-impl0(arg4.getTargetStructuralOffset-F1C5BW0(), arg9) || !Size.equals-impl0(arg4.getSize-NH-jbRc(), arg5) || (arg11)) {
            arg4.setSize-uvyYCjk(arg5);
            arg4.setTargetStructuralOffset-k-4lQ0M(arg9);
            if(arg11) {
                arg4.setInitialMfrOffset-k-4lQ0M(Offset.minus-MK-Hz9U(Offset.minus-MK-Hz9U(arg7, arg9), Offset.minus-MK-Hz9U(arg4.getCurrentMfrOffset-F1C5BW0(), arg4.getInitialMfrOffset-F1C5BW0())));
            }
        }

        arg4.setCurrentMfrOffset-k-4lQ0M(Offset.minus-MK-Hz9U(arg7, arg9));
    }
}

