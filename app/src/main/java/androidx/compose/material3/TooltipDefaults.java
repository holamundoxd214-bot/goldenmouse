package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001C\u001A\u00020\u001DJ\u0017\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u001E\u0010\u001FJ\r\u0010 \u001A\u00020!H\u0007¢\u0006\u0002\u0010\"J7\u0010 \u001A\u00020!2\b\b\u0002\u0010#\u001A\u00020\t2\b\b\u0002\u0010$\u001A\u00020\t2\b\b\u0002\u0010%\u001A\u00020\t2\b\b\u0002\u0010&\u001A\u00020\tH\u0007¢\u0006\u0004\b\'\u0010(J\u0019\u0010-\u001A\u00020.2\b\b\u0002\u0010/\u001A\u00020\u0016H\u0007¢\u0006\u0004\b0\u00101J\u0019\u00102\u001A\u00020.2\b\b\u0002\u0010/\u001A\u00020\u0016H\u0007¢\u0006\u0004\b3\u00101J\u0019\u00104\u001A\u00020.2\b\b\u0002\u0010/\u001A\u00020\u0016H\u0007¢\u0006\u0004\b5\u00101J!\u00104\u001A\u00020.2\u0006\u00106\u001A\u0002072\b\b\u0002\u0010/\u001A\u00020\u0016H\u0007¢\u0006\u0004\b8\u00109R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0007R\u0013\u0010\u0010\u001A\u00020\u0011¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001A\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001A\u001A\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001B\u0010\u0018R\u0018\u0010)\u001A\u00020!*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,R\u0014\u0010:\u001A\u00020\u001DX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b;\u0010<¨\u0006="}, d2={"Landroidx/compose/material3/TooltipDefaults;", "", "<init>", "()V", "plainTooltipContainerShape", "Landroidx/compose/ui/graphics/Shape;", "getPlainTooltipContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "plainTooltipContainerColor", "Landroidx/compose/ui/graphics/Color;", "getPlainTooltipContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "plainTooltipContentColor", "getPlainTooltipContentColor", "richTooltipContainerShape", "getRichTooltipContainerShape", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "getCaretSize-MYxV2XQ", "()J", "J", "plainTooltipMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getPlainTooltipMaxWidth-D9Ej5fM", "()F", "F", "richTooltipMaxWidth", "getRichTooltipMaxWidth-D9Ej5fM", "caretShape", "Landroidx/compose/material3/DefaultTooltipCaretShape;", "caretShape-EaSLcWc", "(J)Landroidx/compose/ui/graphics/Shape;", "richTooltipColors", "Landroidx/compose/material3/RichTooltipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RichTooltipColors;", "containerColor", "contentColor", "titleContentColor", "actionContentColor", "richTooltipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RichTooltipColors;", "defaultRichTooltipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRichTooltipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RichTooltipColors;", "rememberPlainTooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "spacingBetweenTooltipAndAnchor", "rememberPlainTooltipPositionProvider-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "rememberRichTooltipPositionProvider", "rememberRichTooltipPositionProvider-kHDZbjc", "rememberTooltipPositionProvider", "rememberTooltipPositionProvider-kHDZbjc", "positioning", "Landroidx/compose/material3/TooltipAnchorPosition;", "rememberTooltipPositionProvider-Hu5FAss", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "DefaultCaretShape", "getDefaultCaretShape$material3", "()Landroidx/compose/material3/DefaultTooltipCaretShape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TooltipDefaults {
    public static final int $stable;
    private static final DefaultTooltipCaretShape DefaultCaretShape;
    public static final TooltipDefaults INSTANCE;
    private static final long caretSize;
    private static final float plainTooltipMaxWidth;
    private static final float richTooltipMaxWidth;

    static {
        TooltipDefaults.INSTANCE = new TooltipDefaults();
        long v0 = DpKt.DpSize-YgX7TsA(Dp.constructor-impl(16f), Dp.constructor-impl(8f));
        TooltipDefaults.caretSize = v0;
        TooltipDefaults.plainTooltipMaxWidth = Dp.constructor-impl(200f);
        TooltipDefaults.richTooltipMaxWidth = Dp.constructor-impl(320f);
        TooltipDefaults.DefaultCaretShape = new DefaultTooltipCaretShape(v0, null);
    }

    private TooltipDefaults() {
        super();
    }

    public final DefaultTooltipCaretShape caretShape() {
        return TooltipDefaults.DefaultCaretShape;
    }

    public final Shape caretShape-EaSLcWc(long arg2) {
        return new DefaultTooltipCaretShape(arg2, null);
    }

    public static Shape caretShape-EaSLcWc$default(TooltipDefaults arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = TooltipDefaults.caretSize;
        }

        return arg0.caretShape-EaSLcWc(arg1);
    }

    public final long getCaretSize-MYxV2XQ() {
        return TooltipDefaults.caretSize;
    }

    public final DefaultTooltipCaretShape getDefaultCaretShape$material3() {
        return TooltipDefaults.DefaultCaretShape;
    }

    public final RichTooltipColors getDefaultRichTooltipColors$material3(ColorScheme arg11) {
        RichTooltipColors v10 = arg11.getDefaultRichTooltipColorsCached$material3();
        if(v10 == null) {
            RichTooltipColors v0 = new RichTooltipColors(ColorSchemeKt.fromToken(arg11, RichTooltipTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(arg11, RichTooltipTokens.INSTANCE.getSupportingTextColor()), ColorSchemeKt.fromToken(arg11, RichTooltipTokens.INSTANCE.getSubheadColor()), ColorSchemeKt.fromToken(arg11, RichTooltipTokens.INSTANCE.getActionLabelTextColor()), null);
            arg11.setDefaultRichTooltipColorsCached$material3(v0);
            return v0;
        }

        return v10;
    }

    public final long getPlainTooltipContainerColor(Composer arg3, int arg4) {
        int v0 = 0x61F0517;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-plainTooltipContainerColor>)626@25776L5:Tooltip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:626)");
        }

        long v0_1 = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final Shape getPlainTooltipContainerShape(Composer arg3, int arg4) {
        int v0 = 0x2F46215;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-plainTooltipContainerShape>)622@25600L5:Tooltip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:622)");
        }

        Shape v2 = ShapesKt.getValue(PlainTooltipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final long getPlainTooltipContentColor(Composer arg3, int arg4) {
        int v0 = 0x89CEE7D7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-plainTooltipContentColor>)630@25964L5:Tooltip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:630)");
        }

        long v0_1 = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getPlainTooltipMaxWidth-D9Ej5fM() {
        return TooltipDefaults.plainTooltipMaxWidth;
    }

    public final Shape getRichTooltipContainerShape(Composer arg3, int arg4) {
        int v0 = 0x43DF5517;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-richTooltipContainerShape>)634@26137L5:Tooltip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:634)");
        }

        Shape v2 = ShapesKt.getValue(RichTooltipTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getRichTooltipMaxWidth-D9Ej5fM() {
        return TooltipDefaults.richTooltipMaxWidth;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith="<_subannotation>") public final PopupPositionProvider rememberPlainTooltipPositionProvider-kHDZbjc(float arg2, Composer arg3, int arg4, int arg5) {
        int v0 = 1047866909;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(rememberPlainTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)709@29147L7,710@29218L898:Tooltip.kt#uh7d8r");
        if((arg5 & 1) != 0) {
            arg2 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:707)");
        }

        ProvidableCompositionLocal v1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg3.consume(((CompositionLocal)v1));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        int v1_2 = ((Density)v1_1).roundToPx-0680j_4(arg2);
        ComposerKt.sourceInformationMarkerStart(arg3, 0x75E2633F, "CC(remember):Tooltip.kt#9igjgp");
        boolean v2 = arg3.changed(v1_2);
        Object v4 = arg3.rememberedValue();
        if((v2) || v4 == Composer.Companion.getEmpty()) {
            TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 v4_1 = new TooltipDefaults$rememberPlainTooltipPositionProvider$1$1(v1_2);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PopupPositionProvider)v4);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith="<_subannotation>") public final PopupPositionProvider rememberRichTooltipPositionProvider-kHDZbjc(float arg2, Composer arg3, int arg4, int arg5) {
        int v0 = 0xA447ABF5;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(rememberRichTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)748@30878L7,749@30949L1458:Tooltip.kt#uh7d8r");
        if((arg5 & 1) != 0) {
            arg2 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:746)");
        }

        ProvidableCompositionLocal v1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg3.consume(((CompositionLocal)v1));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        int v1_2 = ((Density)v1_1).roundToPx-0680j_4(arg2);
        ComposerKt.sourceInformationMarkerStart(arg3, 0xB10CCD27, "CC(remember):Tooltip.kt#9igjgp");
        boolean v2 = arg3.changed(v1_2);
        Object v4 = arg3.rememberedValue();
        if((v2) || v4 == Composer.Companion.getEmpty()) {
            TooltipDefaults$rememberRichTooltipPositionProvider$1$1 v4_1 = new TooltipDefaults$rememberRichTooltipPositionProvider$1$1(v1_2);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PopupPositionProvider)v4);
    }

    public final PopupPositionProvider rememberTooltipPositionProvider-Hu5FAss(int arg2, float arg3, Composer arg4, int arg5, int arg6) {
        int v0 = -573803578;
        ComposerKt.sourceInformationMarkerStart(arg4, v0, "C(rememberTooltipPositionProvider)N(positioning:c#material3.TooltipAnchorPosition,spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)851@35822L7,852@35893L130:Tooltip.kt#uh7d8r");
        if((arg6 & 2) != 0) {
            arg3 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:849)");
        }

        ProvidableCompositionLocal v1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg4.consume(((CompositionLocal)v1));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        int v1_2 = ((Density)v1_1).roundToPx-0680j_4(arg3);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x9C7EC568, "CC(remember):Tooltip.kt#9igjgp");
        boolean v3 = arg4.changed(v1_2);
        v0 = 4;
        arg5 = (arg5 & 14 ^ 6) > v0 && (arg4.changed(arg2)) || (arg5 & 6) == v0 ? 1 : 0;
        int v3_1 = (((int)v3)) | arg5;
        Object v5 = arg4.rememberedValue();
        if(v3_1 != 0 || v5 == Composer.Companion.getEmpty()) {
            TooltipPositionProviderImpl v5_1 = new TooltipPositionProviderImpl(arg2, v1_2, null);
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((PopupPositionProvider)v5);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of rememberTooltipPositionProvider API that takes a preferred positioning. Please use rememberTooltipPositionProvider with TooltipAnchorPosition.Above if this same behavior is desired.", replaceWith="<_subannotation>") public final PopupPositionProvider rememberTooltipPositionProvider-kHDZbjc(float arg2, Composer arg3, int arg4, int arg5) {
        TooltipDefaults$rememberTooltipPositionProvider$1$1 v4_1;
        int v0 = 0x9FCDEDF1;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(rememberTooltipPositionProvider)N(spacingBetweenTooltipAndAnchor:c#ui.unit.Dp)801@33428L7,802@33499L1618:Tooltip.kt#uh7d8r");
        if((arg5 & 1) != 0) {
            arg2 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:799)");
        }

        ProvidableCompositionLocal v1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg3.consume(((CompositionLocal)v1));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        int v1_2 = ((Density)v1_1).roundToPx-0680j_4(arg2);
        ComposerKt.sourceInformationMarkerStart(arg3, 0xE40A9E03, "CC(remember):Tooltip.kt#9igjgp");
        boolean v2 = arg3.changed(v1_2);
        Object v4 = arg3.rememberedValue();
        if((v2) || v4 == Composer.Companion.getEmpty()) {
            v4_1 = new TooltipDefaults$rememberTooltipPositionProvider$1$1(v1_2);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PopupPositionProvider)v4_1);
    }

    public final RichTooltipColors richTooltipColors(Composer arg4, int arg5) {
        int v1 = 0x9F4D7B33;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(richTooltipColors)660@27031L11:Tooltip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:660)");
        }

        RichTooltipColors v3 = this.getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final RichTooltipColors richTooltipColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = 1498555081;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(richTooltipColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color)673@27513L11:Tooltip.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:673)");
        }

        RichTooltipColors v12 = this.getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }
}

