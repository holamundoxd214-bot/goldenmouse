package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0002\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0001H\u0002\u001A\u0010\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\f\u0010\u0006\u001A\u00020\u0001*\u00020\u0003H\u0002\u001A\f\u0010\u0007\u001A\u00020\u0001*\u00020\u0001H\u0002\u001A/\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u0013\u0010\u0011\u001A\u00020\u0003*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001B\u0010\u0016\u001A\u00020\u0003*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u001B\u0010\u001C\u001A\u0017\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 H\u0007¢\u0006\u0002\u0010!\"\u000E\u0010\u0015\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0016\u001A\u00020\u0003*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2={"ceilAwayFromZero", "", "extractIntegerPixels", "", "composeToViewOffset", "offset", "reverseAxis", "toViewVelocity", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "dx", "dy", "consumed", "", "available", "toOffset-moWRBKg", "(II[IJ)J", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "ScrollingAxesThreshold", "scrollAxes", "getScrollAxes-k-4lQ0M", "(J)I", "Landroidx/compose/ui/unit/Velocity;", "minFlingVelocity", "scrollAxes-sF-c-tU", "(JF)I", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NestedScrollInteropConnectionKt {
    private static final float ScrollingAxesThreshold = 0.5f;

    public static final int access$getScrollAxes-k-4lQ0M(long arg0) {
        return NestedScrollInteropConnectionKt.getScrollAxes-k-4lQ0M(arg0);
    }

    public static final long access$toOffset-moWRBKg(int arg0, int arg1, int[] arg2, long arg3) {
        return NestedScrollInteropConnectionKt.toOffset-moWRBKg(arg0, arg1, arg2, arg3);
    }

    public static final int access$toViewType-GyEprt8(int arg0) {
        return NestedScrollInteropConnectionKt.toViewType-GyEprt8(arg0);
    }

    public static final float access$toViewVelocity(float arg0) {
        return NestedScrollInteropConnectionKt.toViewVelocity(arg0);
    }

    private static final float ceilAwayFromZero(float arg2) {
        double v0 = arg2 >= 0f ? Math.ceil(((double)arg2)) : Math.floor(((double)arg2));
        return ((float)v0);
    }

    public static final int composeToViewOffset(float arg1) {
        int v1 = ComposeUiFlags.isNestedScrollInteropIntegerPropagationEnabled ? NestedScrollInteropConnectionKt.extractIntegerPixels(arg1) : ((int)NestedScrollInteropConnectionKt.ceilAwayFromZero(arg1));
        return v1 * -1;
    }

    private static final int extractIntegerPixels(float arg0) {
        return MathKt.roundToInt(arg0);
    }

    private static final int getScrollAxes-k-4lQ0M(long arg4) {
        float v1 = 0.5f;
        int v0 = Math.abs(Float.intBitsToFloat(((int)(arg4 >> 0x20)))) >= v1 ? 1 : 0;
        if(Math.abs(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL)))) >= v1) {
            return v0 | 2;
        }

        return v0;
    }

    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View arg4, Composer arg5, int arg6, int arg7) {
        Object v4_1;
        int v1 = 0x40209863;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(rememberNestedScrollInteropConnection)291@10973L7,293@11060L7,294@11079L133:NestedScrollInteropConnection.android.kt#itgzvw");
        String v0 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        int v2 = 0x789C5F52;
        if((arg7 & 1) != 0) {
            ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg5, v2, v0);
            v4_1 = arg5.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg5);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:292)");
        }

        ProvidableCompositionLocal v6 = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg5, v2, v0);
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0xBA5C22A8, "CC(remember):NestedScrollInteropConnection.android.kt#9igjgp");
        arg7 = arg5.changed(v4_1) | arg5.changed(v6_1);
        Object v0_1 = arg5.rememberedValue();
        if(arg7 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            NestedScrollInteropConnection v0_2 = new NestedScrollInteropConnection(((View)v4_1), ((ViewConfiguration)v6_1).getMinimumFlingVelocity());
            arg5.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((NestedScrollConnection)v0_1);
    }

    private static final float reverseAxis(int arg1) {
        return (((float)arg1)) * -1f;
    }

    private static final int scrollAxes-sF-c-tU(long arg1, float arg3) {
        int v0 = Math.abs(Velocity.getX-impl(arg1)) >= arg3 ? 1 : 0;
        if(Math.abs(Velocity.getY-impl(arg1)) >= arg3) {
            return v0 | 2;
        }

        return v0;
    }

    private static final long toOffset-moWRBKg(int arg9, int arg10, int[] arg11, long arg12) {
        int v1 = 0x20;
        float v0 = !ComposeUiFlags.isNestedScrollInteropIntegerPropagationEnabled || Math.abs(arg11[0]) == 0 ? 0f : Float.intBitsToFloat(((int)(arg12 >> v1))) - NestedScrollInteropConnectionKt.reverseAxis(arg9);
        long v4 = 0xFFFFFFFFL;
        float v9 = !ComposeUiFlags.isNestedScrollInteropIntegerPropagationEnabled || Math.abs(arg11[1]) == 0 ? 0f : Float.intBitsToFloat(((int)(arg12 & v4))) - NestedScrollInteropConnectionKt.reverseAxis(arg10);
        arg10 = ((int)(arg12 >> v1));
        float v10 = Float.intBitsToFloat(arg10) >= 0f ? RangesKt.coerceAtMost(NestedScrollInteropConnectionKt.reverseAxis(arg11[0]) + v0, Float.intBitsToFloat(arg10)) : RangesKt.coerceAtLeast(NestedScrollInteropConnectionKt.reverseAxis(arg11[0]) + v0, Float.intBitsToFloat(arg10));
        int v12 = ((int)(arg12 & v4));
        v9 = Float.intBitsToFloat(v12) >= 0f ? RangesKt.coerceAtMost(NestedScrollInteropConnectionKt.reverseAxis(arg11[1]) + v9, Float.intBitsToFloat(v12)) : RangesKt.coerceAtLeast(NestedScrollInteropConnectionKt.reverseAxis(arg11[1]) + v9, Float.intBitsToFloat(v12));
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v10))) << v1 | (((long)Float.floatToRawIntBits(v9))) & v4);
    }

    private static final int toViewType-GyEprt8(int arg1) {
        return NestedScrollSource.equals-impl0(arg1, NestedScrollSource.Companion.getUserInput-WNlRxjI()) ^ 1;
    }

    private static final float toViewVelocity(float arg1) {
        return arg1 * -1f;
    }
}

