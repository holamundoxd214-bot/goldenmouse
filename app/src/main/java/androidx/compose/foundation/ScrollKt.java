package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001A2\u0010\u0005\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\t\u001A<\u0010\u0005\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\t\u001A2\u0010\u000F\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\t\u001A<\u0010\u000F\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\t\u001AJ\u0010\u0010\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\t2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0002¨\u0006\u0014"}, d2={"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "verticalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "horizontalScroll", "scroll", "isScrollable", "isVertical", "useLocalOverscrollFactory", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollKt {
    public static ScrollState $r8$lambda$MvjEdKN_U2wrNSiUXmYsThAugWY(int arg0) {
        return ScrollKt.rememberScrollState$lambda$0$0(arg0);
    }

    public static final Modifier horizontalScroll(Modifier arg8, ScrollState arg9, OverscrollEffect arg10, boolean arg11, FlingBehavior arg12, boolean arg13) {
        return ScrollKt.scroll(arg8, arg9, arg13, arg12, arg11, false, false, arg10);
    }

    public static final Modifier horizontalScroll(Modifier arg10, ScrollState arg11, boolean arg12, FlingBehavior arg13, boolean arg14) {
        return ScrollKt.scroll$default(arg10, arg11, arg14, arg13, arg12, false, true, null, 0x40, null);
    }

    public static Modifier horizontalScroll$default(Modifier arg6, ScrollState arg7, OverscrollEffect arg8, boolean arg9, FlingBehavior arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        return ScrollKt.horizontalScroll(arg6, arg7, arg8, true, arg10, false);
    }

    public static Modifier horizontalScroll$default(Modifier arg0, ScrollState arg1, boolean arg2, FlingBehavior arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return ScrollKt.horizontalScroll(arg0, arg1, true, arg3, false);
    }

    public static final ScrollState rememberScrollState(int arg5, Composer arg6, int arg7, int arg8) {
        ScrollKt$$ExternalSyntheticLambda0 v7_1;
        int v1 = 0xA8B93939;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(rememberScrollState)N(initial)71@3346L34,71@3302L78:Scroll.kt#71ulvw");
        int v0 = 1;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:70)");
        }

        Object[] v8 = new Object[0];
        Saver v1_1 = ScrollState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x5F4FDD1B, "CC(remember):Scroll.kt#9igjgp");
        int v4 = 4;
        if((arg7 & 14 ^ 6) <= v4 || !arg6.changed(0)) {
            if((arg7 & 6) == v4) {
            }
            else {
                v0 = 0;
            }
        }

        Object v7 = arg6.rememberedValue();
        if(v0 != 0 || v7 == Composer.Companion.getEmpty()) {
            v7_1 = new ScrollKt$$ExternalSyntheticLambda0(0);
            arg6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        Object v5 = RememberSaveableKt.rememberSaveable(v8, v1_1, ((Function0)v7_1), arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return ((ScrollState)v5);
    }

    private static final ScrollState rememberScrollState$lambda$0$0(int arg1) {
        return new ScrollState(arg1);
    }

    private static final Modifier scroll(Modifier arg13, ScrollState arg14, boolean arg15, FlingBehavior arg16, boolean arg17, boolean arg18, boolean arg19, OverscrollEffect arg20) {
        boolean v0 = arg18;
        Orientation v1 = v0 ? Orientation.Vertical : Orientation.Horizontal;
        Orientation v4 = v1;
        arg13 = arg19 ? ScrollableAreaKt.scrollableArea$default(arg13, arg14, v4, arg17, arg15, arg16, arg14.getInternalInteractionSource$foundation(), null, 0x40, null) : ScrollableAreaKt.scrollableArea$default(arg13, arg14, v4, arg20, arg17, arg15, arg16, arg14.getInternalInteractionSource$foundation(), null, 0x80, null);
        return arg13.then(new ScrollingLayoutElement(arg14, arg15, v0));
    }

    static Modifier scroll$default(Modifier arg9, ScrollState arg10, boolean arg11, FlingBehavior arg12, boolean arg13, boolean arg14, boolean arg15, OverscrollEffect arg16, int arg17, Object arg18) {
        OverscrollEffect v8 = (arg17 & 0x40) != 0 ? null : arg16;
        return ScrollKt.scroll(arg9, arg10, arg11, arg12, arg13, arg14, arg15, v8);
    }

    public static final Modifier verticalScroll(Modifier arg8, ScrollState arg9, OverscrollEffect arg10, boolean arg11, FlingBehavior arg12, boolean arg13) {
        return ScrollKt.scroll(arg8, arg9, arg13, arg12, arg11, true, false, arg10);
    }

    public static final Modifier verticalScroll(Modifier arg10, ScrollState arg11, boolean arg12, FlingBehavior arg13, boolean arg14) {
        return ScrollKt.scroll$default(arg10, arg11, arg14, arg13, arg12, true, true, null, 0x40, null);
    }

    public static Modifier verticalScroll$default(Modifier arg6, ScrollState arg7, OverscrollEffect arg8, boolean arg9, FlingBehavior arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        return ScrollKt.verticalScroll(arg6, arg7, arg8, true, arg10, false);
    }

    public static Modifier verticalScroll$default(Modifier arg0, ScrollState arg1, boolean arg2, FlingBehavior arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return ScrollKt.verticalScroll(arg0, arg1, true, arg3, false);
    }
}

