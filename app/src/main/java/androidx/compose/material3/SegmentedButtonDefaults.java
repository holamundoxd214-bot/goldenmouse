package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u0087\u0001\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\b2\b\b\u0002\u0010\u0012\u001A\u00020\b2\b\b\u0002\u0010\u0013\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&2\b\b\u0002\u0010\u001A\u001A\u00020\u001BH\u0007¢\u0006\u0002\u0010(J\r\u0010/\u001A\u000200H\u0007¢\u0006\u0002\u00101JA\u00102\u001A\u0002002\u0006\u00103\u001A\u0002042\u0013\b\u0002\u00105\u001A\r\u0012\u0004\u0012\u00020006¢\u0006\u0002\b72\u0015\b\u0002\u00108\u001A\u000F\u0012\u0004\u0012\u000200\u0018\u000106¢\u0006\u0002\b7H\u0007¢\u0006\u0002\u00109J\u001F\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020\b2\b\b\u0002\u0010=\u001A\u00020\u001F¢\u0006\u0004\b>\u0010?R\u0018\u0010\u0016\u001A\u00020\u0005*\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u001B8G¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0013\u0010\u001E\u001A\u00020\u001F¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b \u0010!R\u0013\u0010)\u001A\u00020\u001F¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b*\u0010!R\u0011\u0010+\u001A\u00020,¢\u0006\b\n\u0000\u001A\u0004\b-\u0010.¨\u0006@"}, d2={"Landroidx/compose/material3/SegmentedButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "baseShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "BorderWidth", "Landroidx/compose/ui/unit/Dp;", "getBorderWidth-D9Ej5fM", "()F", "F", "itemShape", "Landroidx/compose/ui/graphics/Shape;", "index", "", "count", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "IconSize", "getIconSize-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ActiveIcon", "", "(Landroidx/compose/runtime/Composer;I)V", "Icon", "active", "", "activeContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "inactiveContent", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "color", "width", "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SegmentedButtonDefaults {
    public static final int $stable;
    private static final float BorderWidth;
    private static final PaddingValues ContentPadding;
    public static final SegmentedButtonDefaults INSTANCE;
    private static final float IconSize;

    static {
        SegmentedButtonDefaults.INSTANCE = new SegmentedButtonDefaults();
        SegmentedButtonDefaults.BorderWidth = OutlinedSegmentedButtonTokens.INSTANCE.getOutlineWidth-D9Ej5fM();
        SegmentedButtonDefaults.IconSize = OutlinedSegmentedButtonTokens.INSTANCE.getIconSize-D9Ej5fM();
        SegmentedButtonDefaults.ContentPadding = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
    }

    private SegmentedButtonDefaults() {
        super();
    }

    public final void ActiveIcon(Composer arg10, int arg11) {
        int v10;
        int v0 = -1273041460;
        Composer v6 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(ActiveIcon)615@27266L148:SegmentedButton.kt#uh7d8r");
        int v1 = 2;
        if((arg11 & 6) == 0) {
            v10 = v6.changed(this) ? 4 : v1;
            v10 |= arg11;
        }
        else {
            v10 = arg11;
        }

        boolean v1_1 = (v10 & 3) != v1 ? true : false;
        if(v6.shouldExecute(v1_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:614)");
            }

            IconKt.Icon-ww6aTOc(Filled.INSTANCE.getCheck$material3(), null, SizeKt.size-3ABfNKs(Modifier.Companion, SegmentedButtonDefaults.IconSize), 0, v6, 0x30, 8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_43;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_43:
        ScopeUpdateScope v10_1 = v6.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new SegmentedButtonDefaults$$ExternalSyntheticLambda0(this, arg11));
        }
    }

    static final Unit ActiveIcon$lambda$1(SegmentedButtonDefaults arg0, int arg1, Composer arg2, int arg3) {
        arg0.ActiveIcon(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public final void Icon(boolean arg17, Function2 arg18, Function2 arg19, Composer arg20, int arg21, int arg22) {
        Function2 v3_1;
        Function2 v8;
        int v7;
        Function2 v4;
        boolean v6;
        int v1;
        int v5 = arg21;
        int v0 = 0xD8CFEAD6;
        Composer v11 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(Icon)N(active,activeContent,inactiveContent):SegmentedButton.kt#uh7d8r");
        int v2 = 2;
        if((arg22 & 1) != 0) {
            v1 = v5 | 6;
            v6 = arg17;
        }
        else {
            v6 = arg17;
            if((v5 & 6) == 0) {
                v1 = v11.changed(v6) ? 4 : v2;
                v1 |= v5;
            }
            else {
                v1 = v5;
            }
        }

        int v3 = arg22 & 2;
        if(v3 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v5 & 0x30) == 0) {
            v4 = arg18;
            v7 = v11.changedInstance(v4) ? 0x20 : 16;
            v1 |= v7;
        }
        else {
        label_37:
            v4 = arg18;
        }

        v7 = arg22 & 4;
        if(v7 != 0) {
            v1 |= 0x180;
            goto label_52;
        }
        else if((v5 & 0x180) == 0) {
            v8 = arg19;
            int v9 = v11.changedInstance(v8) ? 0x100 : 0x80;
            v1 |= v9;
        }
        else {
        label_52:
            v8 = arg19;
        }

        boolean v9_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(v11.shouldExecute(v9_1, v1 & 1)) {
            v3_1 = v3 != 0 ? ComposableSingletons$SegmentedButtonKt.INSTANCE.getLambda$1863131183$material3() : v4;
            Object v4_1 = null;
            Function2 v15 = v7 != 0 ? ((Function2)v4_1) : v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.SegmentedButtonDefaults.Icon (SegmentedButton.kt:635)");
            }

            v0 = 54;
            v7 = 6;
            if(v15 == null) {
                v11.startReplaceGroup(0xAB94C1B9);
                ComposerKt.sourceInformation(v11, "642@28274L7,646@28514L7,648@28564L47,638@28088L523");
                AnimatedVisibilityKt.AnimatedVisibility(v6, null, EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v11, v7), 0f, v2, v4_1).plus(EnterExitTransitionKt.scaleIn-L8ZKh-E(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v11, v7), 0f, TransformOriginKt.TransformOrigin(0f, 1f))), ExitTransition.Companion.getNone(), null, ComposableLambdaKt.rememberComposableLambda(0x7AC2E083, true, new SegmentedButtonDefaults$Icon$1(v3_1), v11, v0), v11, v1 & 14 | 0x30000, 18);
                v11 = v11;
                v11.endReplaceGroup();
            }
            else {
                v11.startReplaceGroup(-1415695803);
                ComposerKt.sourceInformation(v11, "655@28843L7,656@28866L78,652@28641L303");
                CrossfadeKt.Crossfade(Boolean.valueOf(arg17), null, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v11, v7), null, ComposableLambdaKt.rememberComposableLambda(0x958E9353, true, new SegmentedButtonDefaults$Icon$2(v3_1, v15), v11, v0), v11, v1 & 14 | 0x6000, 10);
                v11.endReplaceGroup();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v15;
        }
        else {
            v11.skipToGroupEnd();
            v3_1 = v4;
            v4 = v8;
        }

        ScopeUpdateScope v7_1 = v11.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new SegmentedButtonDefaults$$ExternalSyntheticLambda1(this, arg17, v3_1, v4, v5, arg22));
        }
    }

    static final Unit Icon$lambda$2(SegmentedButtonDefaults arg7, boolean arg8, Function2 arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        arg7.Icon(arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public final BorderStroke borderStroke-l07J4OM(long arg1, float arg3) {
        return BorderStrokeKt.BorderStroke-cXLIe8U(arg3, arg1);
    }

    public static BorderStroke borderStroke-l07J4OM$default(SegmentedButtonDefaults arg0, long arg1, float arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg3 = SegmentedButtonDefaults.BorderWidth;
        }

        return arg0.borderStroke-l07J4OM(arg1, arg3);
    }

    public final SegmentedButtonColors colors(Composer arg4, int arg5) {
        int v1 = 0x287FB229;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)494@21063L11:SegmentedButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:494)");
        }

        SegmentedButtonColors v3 = this.getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final SegmentedButtonColors colors-XqyqHi0(long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, Composer arg52, int arg53, int arg54, int arg55) {
        Composer v0 = arg52;
        int v1 = arg55;
        int v3 = 0x7E6307D;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(activeContainerColor:c#ui.graphics.Color,activeContentColor:c#ui.graphics.Color,activeBorderColor:c#ui.graphics.Color,inactiveContainerColor:c#ui.graphics.Color,inactiveContentColor:c#ui.graphics.Color,inactiveBorderColor:c#ui.graphics.Color,disabledActiveContainerColor:c#ui.graphics.Color,disabledActiveContentColor:c#ui.graphics.Color,disabledActiveBorderColor:c#ui.graphics.Color,disabledInactiveContainerColor:c#ui.graphics.Color,disabledInactiveContentColor:c#ui.graphics.Color,disabledInactiveBorderColor:c#ui.graphics.Color)530@23230L11:SegmentedButton.kt#uh7d8r");
        long v4 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        long v6 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg30;
        long v8 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg32;
        long v10 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        long v12 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg36;
        long v14 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg38;
        long v16 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg40;
        long v18 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg42;
        long v20 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg44;
        long v22 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg46;
        long v24 = (v1 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg48;
        long v1_1 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg50;
        arg50 = v1_1;
        if(ComposerKt.isTraceInProgress()) {
            arg28 = v4;
            ComposerKt.traceEventStart(v3, arg53, arg54, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:530)");
        }
        else {
            arg28 = v4;
        }

        SegmentedButtonColors v1_2 = this.getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-2qZNXz8(arg28, v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, arg50);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final CornerBasedShape getBaseShape(Composer arg3, int arg4) {
        int v0 = 0x4B5AC6FD;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-baseShape>)578@25979L5:SegmentedButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:578)");
        }

        Shape v2 = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), arg3, 6);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((CornerBasedShape)v2);
    }

    public final float getBorderWidth-D9Ej5fM() {
        return SegmentedButtonDefaults.BorderWidth;
    }

    public final PaddingValues getContentPadding() {
        return SegmentedButtonDefaults.ContentPadding;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColors$material3(ColorScheme arg34) {
        ColorScheme v0 = arg34;
        SegmentedButtonColors v1 = v0.getDefaultSegmentedButtonColorsCached$material3();
        if(v1 == null) {
            SegmentedButtonColors v2 = new SegmentedButtonColors(ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultSegmentedButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final float getIconSize-D9Ej5fM() {
        return SegmentedButtonDefaults.IconSize;
    }

    public final Shape itemShape(int arg3, int arg4, CornerBasedShape arg5, Composer arg6, int arg7, int arg8) {
        Shape v2_1;
        CornerBasedShape v2;
        int v1 = 0xC7D91F01;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(itemShape)N(index,count,baseShape)594@26645L9:SegmentedButton.kt#uh7d8r");
        if((arg8 & 4) != 0) {
            arg5 = this.getBaseShape(arg6, arg7 >> 9 & 14);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:594)");
        }

        if(arg4 == 1) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            return arg5;
        }

        CornerSize v7 = null;
        if(arg3 == 0) {
            v2 = ShapesKt.start$default(arg5, v7, 1, v7);
        }
        else if(arg3 == arg4 - 1) {
            v2 = ShapesKt.end$default(arg5, v7, 1, v7);
        }
        else {
            v2_1 = RectangleShapeKt.getRectangleShape();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v2_1;
    }
}

