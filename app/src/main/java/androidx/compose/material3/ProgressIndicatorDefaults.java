package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010/\u001A\u0002002\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u00020\u00142\u0006\u00104\u001A\u00020\u00052\u0006\u00105\u001A\u00020\u0019¢\u0006\u0004\b6\u00107R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u001A\u0010\f\u001A\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0014¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001A\u00020\u0019¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u001D\u001A\u00020\u0019¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001E\u0010\u001BR\u0013\u0010\u001F\u001A\u00020\u0019¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b \u0010\u001BR\u001E\u0010!\u001A\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\"\u0010\u0003\u001A\u0004\b#\u0010\u0016R\u001E\u0010$\u001A\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b%\u0010\u0003\u001A\u0004\b&\u0010\u0016R\u001E\u0010\'\u001A\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b(\u0010\u0003\u001A\u0004\b)\u0010\u0016R\u0017\u0010*\u001A\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001A\u0004\b-\u0010.¨\u00068"}, d2={"Landroidx/compose/material3/ProgressIndicatorDefaults;", "", "<init>", "()V", "linearColor", "Landroidx/compose/ui/graphics/Color;", "getLinearColor", "(Landroidx/compose/runtime/Composer;I)J", "circularColor", "getCircularColor", "linearTrackColor", "getLinearTrackColor", "circularTrackColor", "getCircularTrackColor$annotations", "getCircularTrackColor", "circularDeterminateTrackColor", "getCircularDeterminateTrackColor", "circularIndeterminateTrackColor", "getCircularIndeterminateTrackColor", "CircularStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getCircularStrokeWidth-D9Ej5fM", "()F", "F", "LinearStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getLinearStrokeCap-KaPHkGw", "()I", "I", "CircularDeterminateStrokeCap", "getCircularDeterminateStrokeCap-KaPHkGw", "CircularIndeterminateStrokeCap", "getCircularIndeterminateStrokeCap-KaPHkGw", "LinearTrackStopIndicatorSize", "getLinearTrackStopIndicatorSize-D9Ej5fM$annotations", "getLinearTrackStopIndicatorSize-D9Ej5fM", "LinearIndicatorTrackGapSize", "getLinearIndicatorTrackGapSize-D9Ej5fM$annotations", "getLinearIndicatorTrackGapSize-D9Ej5fM", "CircularIndicatorTrackGapSize", "getCircularIndicatorTrackGapSize-D9Ej5fM$annotations", "getCircularIndicatorTrackGapSize-D9Ej5fM", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "drawStopIndicator", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "stopSize", "color", "strokeCap", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ProgressIndicatorDefaults {
    public static final int $stable;
    private static final int CircularDeterminateStrokeCap;
    private static final int CircularIndeterminateStrokeCap;
    private static final float CircularIndicatorTrackGapSize;
    private static final float CircularStrokeWidth;
    public static final ProgressIndicatorDefaults INSTANCE;
    private static final float LinearIndicatorTrackGapSize;
    private static final int LinearStrokeCap;
    private static final float LinearTrackStopIndicatorSize;
    private static final SpringSpec ProgressAnimationSpec;

    static {
        ProgressIndicatorDefaults.INSTANCE = new ProgressIndicatorDefaults();
        ProgressIndicatorDefaults.CircularStrokeWidth = CircularProgressIndicatorTokens.INSTANCE.getTrackThickness-D9Ej5fM();
        ProgressIndicatorDefaults.LinearStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.CircularDeterminateStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.CircularIndeterminateStrokeCap = StrokeCap.Companion.getRound-KaPHkGw();
        ProgressIndicatorDefaults.LinearTrackStopIndicatorSize = LinearProgressIndicatorTokens.INSTANCE.getStopSize-D9Ej5fM();
        ProgressIndicatorDefaults.LinearIndicatorTrackGapSize = LinearProgressIndicatorTokens.INSTANCE.getTrackActiveSpace-D9Ej5fM();
        ProgressIndicatorDefaults.CircularIndicatorTrackGapSize = CircularProgressIndicatorTokens.INSTANCE.getTrackActiveSpace-D9Ej5fM();
        ProgressIndicatorDefaults.ProgressAnimationSpec = new SpringSpec(1f, 50f, Float.valueOf(0.001f));
    }

    private ProgressIndicatorDefaults() {
        super();
    }

    public final void drawStopIndicator-EgI2THU(DrawScope arg11, float arg12, long arg13, int arg15) {
        float v8 = Math.min(arg11.toPx-0680j_4(arg12), Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() & 0xFFFFFFFFL))));
        float v10 = arg11.toPx-0680j_4(ProgressIndicatorKt.getStopIndicatorTrailingSpace());
        arg12 = (Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() & 0xFFFFFFFFL))) - v8) / 2f;
        float v9 = arg12 > v10 ? v10 : arg12;
        if(arg11.getLayoutDirection() == LayoutDirection.Rtl) {
            long v0 = arg11.getCenter-F1C5BW0();
            DrawContext v10_1 = arg11.getDrawContext();
            long v2 = v10_1.getSize-NH-jbRc();
            v10_1.getCanvas().save();
            try {
                v10_1.getTransform().scale-0AR0LA0(-1f, 1f, v0);
                ProgressIndicatorDefaults.drawStopIndicator_EgI2THU$drawIndicator(arg11, arg15, arg13, v8, v9);
            }
            catch(Throwable v0_1) {
                v10_1.getCanvas().restore();
                v10_1.setSize-uvyYCjk(v2);
                throw v0_1;
            }

            v10_1.getCanvas().restore();
            v10_1.setSize-uvyYCjk(v2);
            return;
        }

        ProgressIndicatorDefaults.drawStopIndicator_EgI2THU$drawIndicator(arg11, arg15, arg13, v8, v9);
    }

    private static final void drawStopIndicator_EgI2THU$drawIndicator(DrawScope arg30, int arg31, long arg32, float arg34, float arg35) {
        float v1 = 2f;
        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(StrokeCap.equals-impl0(arg31, StrokeCap.Companion.getRound-KaPHkGw())) {
            float v8 = arg34 / v1;
            DrawScope.drawCircle-VaOC9Bg$default(arg30, arg32, v8, Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg30.getSize-NH-jbRc() >> v4))) - v8 - arg35))) << v4 | v2 & (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg30.getSize-NH-jbRc() & v2))) / v1)))), 0f, null, null, 0, 120, null);
            return;
        }

        DrawScope.drawRect-n-J9OG0$default(arg30, arg32, Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg30.getSize-NH-jbRc() >> v4))) - arg34 - arg35))) << v4 | (((long)Float.floatToRawIntBits((Float.intBitsToFloat(((int)(arg30.getSize-NH-jbRc() & v2))) - arg34) / v1))) & v2), Size.constructor-impl((((long)Float.floatToRawIntBits(arg34))) << v4 | v2 & (((long)Float.floatToRawIntBits(arg34)))), 0f, null, null, 0, 120, null);
    }

    public final long getCircularColor(Composer arg3, int arg4) {
        int v0 = 1803349725;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-circularColor>)817@33505L5:ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:817)");
        }

        long v0_1 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final int getCircularDeterminateStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.CircularDeterminateStrokeCap;
    }

    public final long getCircularDeterminateTrackColor(Composer arg3, int arg4) {
        int v0 = 0x803889B3;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-circularDeterminateTrackColor>)834@34237L5:ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:834)");
        }

        long v0_1 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final int getCircularIndeterminateStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.CircularIndeterminateStrokeCap;
    }

    public final long getCircularIndeterminateTrackColor(Composer arg3, int arg4) {
        int v0 = -1947901123;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-circularIndeterminateTrackColor>):ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:838)");
        }

        long v0_1 = Color.Companion.getTransparent-0d7_KjU();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getCircularIndicatorTrackGapSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.CircularIndicatorTrackGapSize;
    }

    public static void getCircularIndicatorTrackGapSize-D9Ej5fM$annotations() {
    }

    public final float getCircularStrokeWidth-D9Ej5fM() {
        return ProgressIndicatorDefaults.CircularStrokeWidth;
    }

    public final long getCircularTrackColor(Composer arg3, int arg4) {
        int v0 = 0xE7E80ED9;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-circularTrackColor>):ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:830)");
        }

        long v0_1 = Color.Companion.getTransparent-0d7_KjU();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor", replaceWith="<_subannotation>") public static void getCircularTrackColor$annotations() {
    }

    public final long getLinearColor(Composer arg3, int arg4) {
        int v0 = 0xC980B0E9;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-linearColor>)813@33336L5:ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:813)");
        }

        long v0_1 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getLinearIndicatorTrackGapSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
    }

    public static void getLinearIndicatorTrackGapSize-D9Ej5fM$annotations() {
    }

    public final int getLinearStrokeCap-KaPHkGw() {
        return ProgressIndicatorDefaults.LinearStrokeCap;
    }

    public final long getLinearTrackColor(Composer arg3, int arg4) {
        int v0 = 0x63FD40D9;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-linearTrackColor>)821@33671L5:ProgressIndicator.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:821)");
        }

        long v0_1 = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getLinearTrackStopIndicatorSize-D9Ej5fM() {
        return ProgressIndicatorDefaults.LinearTrackStopIndicatorSize;
    }

    public static void getLinearTrackStopIndicatorSize-D9Ej5fM$annotations() {
    }

    public final SpringSpec getProgressAnimationSpec() {
        return ProgressIndicatorDefaults.ProgressAnimationSpec;
    }
}

