package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020\u000F2\b\b\u0002\u0010&\u001A\u00020\u000F2\b\b\u0002\u0010\'\u001A\u00020\u00052\b\b\u0002\u0010(\u001A\u00020\u000BH\u0007¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u000B8G¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001A\u00020\u000B8G¢\u0006\u0006\u001A\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0017\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001A\u00020\u001A8G¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u001E\u0010\u0011R\u0016\u0010\u001F\u001A\u00020\u000FX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b \u0010\u0011¨\u0006+"}, d2={"Landroidx/compose/material3/BottomSheetDefaults;", "", "<init>", "()V", "HiddenShape", "Landroidx/compose/ui/graphics/Shape;", "getHiddenShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ExpandedShape", "getExpandedShape", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM$material3", "VelocityThreshold", "getVelocityThreshold-D9Ej5fM$material3", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BottomSheetDefaults {
    public static final int $stable;
    private static final float Elevation;
    public static final BottomSheetDefaults INSTANCE;
    private static final float PositionalThreshold;
    private static final float SheetMaxWidth;
    private static final float SheetPeekHeight;
    private static final float VelocityThreshold;

    static {
        BottomSheetDefaults.INSTANCE = new BottomSheetDefaults();
        BottomSheetDefaults.Elevation = SheetBottomTokens.INSTANCE.getDockedModalContainerElevation-D9Ej5fM();
        BottomSheetDefaults.SheetPeekHeight = Dp.constructor-impl(56f);
        BottomSheetDefaults.SheetMaxWidth = Dp.constructor-impl(640f);
        BottomSheetDefaults.PositionalThreshold = Dp.constructor-impl(56f);
        BottomSheetDefaults.VelocityThreshold = Dp.constructor-impl(125f);
    }

    private BottomSheetDefaults() {
        super();
    }

    public final void DragHandle-lgZ2HuY(Modifier arg23, float arg24, float arg25, Shape arg26, long arg27, Composer arg29, int arg30, int arg31) {
        float v4_1;
        Composer v19;
        BottomSheetDefaults$$ExternalSyntheticLambda0 v13_3;
        float v3_1;
        Modifier v2_1;
        int v13;
        long v11_1;
        int v11;
        Shape v10_1;
        float v9;
        int v7;
        float v6;
        Modifier v3;
        int v4;
        int v8 = arg30;
        int v0 = 0xAEAEC815;
        Composer v1 = arg29.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(DragHandle)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,shape,color:c#ui.graphics.Color)416@17418L51,419@17591L82,424@17739L74,417@17478L335:SheetDefaults.kt#uh7d8r");
        int v2 = arg31 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg23;
        }
        else if((v8 & 6) == 0) {
            v3 = arg23;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg23;
            v4 = v8;
        }

        int v5 = arg31 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg24;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg24;
        }

        v7 = arg31 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v8 & 0x180) == 0) {
            v9 = arg25;
            int v10 = v1.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_53:
            v9 = arg25;
        }

        if((v8 & 0xC00) == 0) {
            if((arg31 & 8) == 0) {
                v10_1 = arg26;
                if(v1.changed(v10_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_64;
                }
            }
            else {
                v10_1 = arg26;
            label_64:
                v11 = 0x400;
            }

            v4 |= v11;
        }
        else {
            v10_1 = arg26;
        }

        if((v8 & 0x6000) == 0) {
            if((arg31 & 16) == 0) {
                v11_1 = arg27;
                if(v1.changed(v11_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v11_1 = arg27;
            label_78:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v11_1 = arg27;
        }

        boolean v13_1 = (v4 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v13_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "413@17285L6,414@17367L5");
            int v16 = 0xFFFF1FFF;
            int v14 = 6;
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    Companion v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                if(v5 != 0) {
                    v6 = SheetBottomTokens.INSTANCE.getDockedDragHandleWidth-D9Ej5fM();
                }

                if(v7 != 0) {
                    v9 = SheetBottomTokens.INSTANCE.getDockedDragHandleHeight-D9Ej5fM();
                }

                if((arg31 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                    CornerBasedShape v10_2 = MaterialTheme.INSTANCE.getShapes(v1, v14).getExtraLarge();
                }

                if((arg31 & 16) == 0) {
                    goto label_110;
                }

                v11_1 = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), v1, v14);
                v4 &= v16;
            }
            else {
                v1.skipToGroupEnd();
                if((arg31 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg31 & 16) != 0) {
                    v4 &= v16;
                }

                v2_1 = v3;
            }

        label_110:
            v3_1 = v9;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:415)");
            }

            String v0_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_bottom_sheet_drag_handle_description), v1, 0);
            Object v9_1 = null;
            Modifier v5_1 = PaddingKt.padding-VpY3zN4$default(v2_1, 0f, SheetDefaultsKt.access$getDragHandleVerticalPadding$p(), 1, v9_1);
            ComposerKt.sourceInformationMarkerStart(v1, -1105372569, "CC(remember):SheetDefaults.kt#9igjgp");
            boolean v7_1 = v1.changed(v0_1);
            Object v13_2 = v1.rememberedValue();
            if((v7_1) || v13_2 == Composer.Companion.getEmpty()) {
                v13_3 = new BottomSheetDefaults$$ExternalSyntheticLambda0(v0_1);
                v1.updateRememberedValue(v13_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0 = v4 >> 6;
            v19 = v1;
            SurfaceKt.Surface-T9BRK9s(SemanticsModifierKt.semantics$default(v5_1, false, ((Function1)v13_3), 1, v9_1), v10_1, v11_1, 0, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0xC2095FB0, true, new BottomSheetDefaults$DragHandle$2(v6, v3_1), v1, 54), v19, v0 & 0x70 | 0xC00000 | v0 & 0x380, 120);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v3_1;
        }
        else {
            v19 = v1;
            v19.skipToGroupEnd();
            v2_1 = v3;
            v4_1 = v9;
        }

        v3_1 = v6;
        Shape v5_2 = v10_1;
        long v6_1 = v11_1;
        ScopeUpdateScope v10_3 = v19.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new BottomSheetDefaults$$ExternalSyntheticLambda1(this, v2_1, v3_1, v4_1, v5_2, v6_1, v8, arg31));
        }
    }

    static final Unit DragHandle_lgZ2HuY$lambda$1$lambda$0(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit DragHandle_lgZ2HuY$lambda$2(BottomSheetDefaults arg11, Modifier arg12, float arg13, float arg14, Shape arg15, long arg16, int arg18, int arg19, Composer arg20, int arg21) {
        arg11.DragHandle-lgZ2HuY(arg12, arg13, arg14, arg15, arg16, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x19D4C8D8;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-ContainerColor>)383@16075L5:SheetDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:383)");
        }

        long v0_1 = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getElevation-D9Ej5fM() {
        return BottomSheetDefaults.Elevation;
    }

    public final Shape getExpandedShape(Composer arg3, int arg4) {
        int v0 = 0x645C7EF6;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-ExpandedShape>)379@15912L5:SheetDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:379)");
        }

        Shape v2 = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getHiddenShape(Composer arg3, int arg4) {
        int v0 = -1971658024;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-HiddenShape>)375@15714L5:SheetDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:375)");
        }

        Shape v2 = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getPositionalThreshold-D9Ej5fM$material3() {
        return BottomSheetDefaults.PositionalThreshold;
    }

    public final long getScrimColor(Composer arg9, int arg10) {
        int v0 = -2040719176;
        ComposerKt.sourceInformationMarkerStart(arg9, v0, "C(<get-ScrimColor>)390@16359L5:SheetDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg10, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:390)");
        }

        long v0_1 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), arg9, 6), 0.32f, 0f, 0f, 0f, 14, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return v0_1;
    }

    public final float getSheetMaxWidth-D9Ej5fM() {
        return BottomSheetDefaults.SheetMaxWidth;
    }

    public final float getSheetPeekHeight-D9Ej5fM() {
        return BottomSheetDefaults.SheetPeekHeight;
    }

    public final float getVelocityThreshold-D9Ej5fM$material3() {
        return BottomSheetDefaults.VelocityThreshold;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = -511309409;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)401@16789L11:SheetDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:401)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getBottom-JoeWqyM(), WindowInsetsSides.Companion.getTop-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

