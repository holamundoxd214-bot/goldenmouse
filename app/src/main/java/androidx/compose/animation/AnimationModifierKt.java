package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\u001AV\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032:\b\u0002\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0006\u001A`\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\f\u001A\u00020\r2:\b\u0002\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0006\"\u0016\u0010\u000E\u001A\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010\"\u0018\u0010\u0012\u001A\u00020\u0013*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"animateContentSize", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "alignment", "Landroidx/compose/ui/Alignment;", "InvalidSize", "getInvalidSize", "()J", "J", "isValid", "", "isValid-ozmzZPI", "(J)Z", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimationModifierKt {
    private static final long InvalidSize;

    static {
        AnimationModifierKt.InvalidSize = IntSize.constructor-impl(-9223372034707292160L);
    }

    public static final Modifier animateContentSize(Modifier arg1, FiniteAnimationSpec arg2, Alignment arg3, Function2 arg4) {
        return ClipKt.clipToBounds(arg1).then(new SizeAnimationModifierElement(arg2, arg3, arg4));
    }

    public static final Modifier animateContentSize(Modifier arg2, FiniteAnimationSpec arg3, Function2 arg4) {
        return ClipKt.clipToBounds(arg2).then(new SizeAnimationModifierElement(arg3, Alignment.Companion.getTopStart(), arg4));
    }

    public static Modifier animateContentSize$default(Modifier arg3, FiniteAnimationSpec arg4, Alignment arg5, Function2 arg6, int arg7, Object arg8) {
        SpringSpec v4;
        Object v0 = null;
        if((arg7 & 1) != 0) {
            v4 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, v0);
        }

        if((arg7 & 2) != 0) {
            arg5 = Alignment.Companion.getTopStart();
        }

        if((arg7 & 4) != 0) {
            arg6 = ((Function2)v0);
        }

        return AnimationModifierKt.animateContentSize(arg3, ((FiniteAnimationSpec)v4), arg5, arg6);
    }

    public static Modifier animateContentSize$default(Modifier arg3, FiniteAnimationSpec arg4, Function2 arg5, int arg6, Object arg7) {
        SpringSpec v4;
        Object v0 = null;
        if((arg6 & 1) != 0) {
            v4 = AnimationSpecKt.spring$default(0f, 400f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, v0);
        }

        if((arg6 & 2) != 0) {
            arg5 = ((Function2)v0);
        }

        return AnimationModifierKt.animateContentSize(arg3, ((FiniteAnimationSpec)v4), arg5);
    }

    public static final long getInvalidSize() {
        return AnimationModifierKt.InvalidSize;
    }

    public static final boolean isValid-ozmzZPI(long arg2) {
        return IntSize.equals-impl0(arg2, AnimationModifierKt.InvalidSize) ^ 1;
    }
}

