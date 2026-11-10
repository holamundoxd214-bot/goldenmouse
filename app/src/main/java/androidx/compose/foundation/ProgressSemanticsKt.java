package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001A.\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u0007H\u0007\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007¨\u0006\b"}, d2={"progressSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ProgressSemanticsKt {
    public static final Modifier progressSemantics(Modifier arg2) {
        return SemanticsModifierKt.semantics(arg2, true, new ProgressSemanticsKt$$ExternalSyntheticLambda1());
    }

    public static final Modifier progressSemantics(Modifier arg1, float arg2, ClosedFloatingPointRange arg3, int arg4) {
        return SemanticsModifierKt.semantics(arg1, true, new ProgressSemanticsKt$$ExternalSyntheticLambda0(arg2, arg3, arg4));
    }

    public static Modifier progressSemantics$default(Modifier arg0, float arg1, ClosedFloatingPointRange arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = RangesKt.rangeTo(0f, 1f);
        }

        return ProgressSemanticsKt.progressSemantics(arg0, arg1, arg2, 0);
    }

    static final Unit progressSemantics$lambda$0(float arg1, ClosedFloatingPointRange arg2, int arg3, SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.setProgressBarRangeInfo(arg4, new ProgressBarRangeInfo(RangesKt.coerceIn(Float.valueOf(arg1), arg2).floatValue(), arg2, arg3));
        return Unit.INSTANCE;
    }

    static final Unit progressSemantics$lambda$1(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setProgressBarRangeInfo(arg1, ProgressBarRangeInfo.Companion.getIndeterminate());
        return Unit.INSTANCE;
    }
}

