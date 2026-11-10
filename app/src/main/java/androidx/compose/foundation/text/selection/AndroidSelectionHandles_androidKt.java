package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.Arrangement$Absolute;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AI\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0004\b\u000F\u0010\u0010\u001A+\u0010\u0011\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0015\u001A\"\u0010\u0016\u001A\u00020\u000E*\u00020\u000E2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001A\u00020\u0005H\u0000\u001A\u0014\u0010\u0017\u001A\u00020\u0018*\u00020\u00192\u0006\u0010\u001A\u001A\u00020\fH\u0000\u001A0\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u001E2\u0011\u0010\u001F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010!¨\u0006\""}, d2={"SelectionHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "lineHeight", "", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-wLIcFTc", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "Lkotlin/Function0;", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "drawSelectionHandle", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "HandlePopup", "positionProvider", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidSelectionHandles_androidKt {
    public static boolean $r8$lambda$2MCOkCUjf2V9hyM6MiCrQug_T4M(OffsetProvider arg0) {
        return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0$0$0$0(arg0);
    }

    public static Unit $r8$lambda$IlY2RIVLPAXZo_JUgEpXEZiM2Ac(long arg0, boolean arg2, Modifier arg3, OffsetProvider arg4, Composer arg5, int arg6) {
        return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0(arg0, arg2, arg3, arg4, arg5, arg6);
    }

    public static Unit $r8$lambda$U4PlfvTg8GNqJ5s3oUBbB4AymgQ(Function0 arg0, boolean arg1, ImageBitmap arg2, ColorFilter arg3, ContentDrawScope arg4) {
        return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0$0$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static Unit $r8$lambda$YLQYkAbVOmgr6vFIK4rqIOgnaY8(OffsetProvider arg0, boolean arg1, boolean arg2, SemanticsPropertyReceiver arg3) {
        return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static boolean $r8$lambda$aq7HYYBsd_Q1PyS9_u0psxwapUE(OffsetProvider arg0) {
        return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0$1$0(arg0);
    }

    public static DrawResult $r8$lambda$yY4vNkdTpeccOD8ga-4PtNZsLFs(long arg0, Function0 arg2, boolean arg3, CacheDrawScope arg4) {
        return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0$0$0(arg0, arg2, arg3, arg4);
    }

    public static final void HandlePopup(OffsetProvider arg19, Alignment arg20, Function2 arg21, Composer arg22, int arg23) {
        int v7;
        int v3_1;
        OffsetProvider v0 = arg19;
        Alignment v1 = arg20;
        Function2 v5 = arg21;
        int v9 = arg23;
        int v2 = 0xBF054CFE;
        Composer v6 = arg22.startRestartGroup(v2);
        ComposerKt.sourceInformation(v6, "C(HandlePopup)N(positionProvider,handleReferencePoint,content)221@8864L135,224@9004L190:AndroidSelectionHandles.android.kt#eksfi3");
        int v4 = 4;
        if((v9 & 6) == 0) {
            boolean v3 = (v9 & 8) == 0 ? v6.changed(v0) : v6.changedInstance(v0);
            v3_1 = v3 ? v4 : 2;
            v3_1 |= v9;
        }
        else {
            v3_1 = v9;
        }

        int v8 = 0x20;
        if((v9 & 0x30) == 0) {
            v7 = v6.changed(v1) ? v8 : 16;
            v3_1 |= v7;
        }

        if((v9 & 0x180) == 0) {
            v7 = v6.changedInstance(v5) ? 0x100 : 0x80;
            v3_1 |= v7;
        }

        int v11 = 0;
        boolean v7_1 = (v3_1 & 0x93) != 0x92 ? true : false;
        if(v6.shouldExecute(v7_1, v3_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v3_1, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:219)");
            }

            ComposerKt.sourceInformationMarkerStart(v6, 317070245, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            v2 = (v3_1 & 0x70) == v8 ? 1 : 0;
            if((v3_1 & 14) == v4 || (v3_1 & 8) != 0 && (v6.changed(v0))) {
                v11 = 1;
            }

            Object v4_1 = v6.rememberedValue();
            if((v2 | v11) != 0 || v4_1 == Composer.Companion.getEmpty()) {
                HandlePositionProvider v4_2 = new HandlePositionProvider(v1, v0);
                v6.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            AndroidPopup_androidKt.Popup(v4_1, null, new PopupProperties(false, false, false, null, true, false, 15, null), v5, v6, v3_1 << 3 & 0x1C00 | 0x180, 2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_106;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_106:
        ScopeUpdateScope v2_1 = v6.endRestartGroup();
        if(v2_1 != null) {
            v2_1.updateScope(new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda0(v0, v1, v5, v9));
        }
    }

    static final Unit HandlePopup$lambda$1(OffsetProvider arg0, Alignment arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        AndroidSelectionHandles_androidKt.HandlePopup(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void SelectionHandle-wLIcFTc(OffsetProvider arg18, boolean arg19, ResolvedTextDirection arg20, boolean arg21, long arg22, float arg24, Modifier arg25, Composer arg26, int arg27, int arg28) {
        long v12;
        int v3;
        int v1_1;
        OffsetProvider v6 = arg18;
        boolean v7 = arg19;
        Modifier v8 = arg25;
        int v9 = arg27;
        int v0 = -466280168;
        Composer v10 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(SelectionHandle)N(offsetProvider,isStartHandle,direction,handlesCrossed,minTouchTargetSize:c#ui.unit.DpSize,lineHeight,modifier)71@3073L394,83@3574L7,84@3678L1346,84@3586L1438:AndroidSelectionHandles.android.kt#eksfi3");
        int v2 = 4;
        if((v9 & 6) == 0) {
            boolean v1 = (v9 & 8) == 0 ? v10.changed(v6) : v10.changedInstance(v6);
            v1_1 = v1 ? v2 : 2;
            v1_1 |= v9;
        }
        else {
            v1_1 = v9;
        }

        int v4 = 0x20;
        if((v9 & 0x30) == 0) {
            v3 = v10.changed(v7) ? v4 : 16;
            v1_1 |= v3;
        }

        if((v9 & 0x180) == 0) {
            v3 = v10.changed(arg20.ordinal()) ? 0x100 : 0x80;
            v1_1 |= v3;
        }

        boolean v11 = arg21;
        if((v9 & 0xC00) == 0) {
            v3 = v10.changed(v11) ? 0x800 : 0x400;
            v1_1 |= v3;
        }

        if((v9 & 0x6000) == 0) {
            v12 = arg22;
            v3 = (arg28 & 16) != 0 || !v10.changed(v12) ? 0x2000 : 0x4000;
            v1_1 |= v3;
        }
        else {
            v12 = arg22;
        }

        if((0x180000 & v9) == 0) {
            v3 = v10.changed(v8) ? 0x100000 : 0x80000;
            v1_1 |= v3;
        }

        boolean v3_1 = (0x82493 & v1_1) != 533650 ? true : false;
        if(v10.shouldExecute(v3_1, v1_1 & 1)) {
            v10.startDefaults();
            int v5 = 0xFFFF1FFF;
            if((v9 & 1) != 0 && !v10.getDefaultsInvalid()) {
                v10.skipToGroupEnd();
                if((arg28 & 16) != 0) {
                    goto label_100;
                }
            }
            else if((arg28 & 16) != 0) {
                v12 = DpSize.Companion.getUnspecified-MYxV2XQ();
            label_100:
                v1_1 &= v5;
            }

            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:65)");
            }

            boolean v0_1 = SelectionHandlesKt.isLeftSelectionHandle(arg19, arg20, arg21);
            AbsoluteAlignment v3_2 = AbsoluteAlignment.INSTANCE;
            Alignment v3_3 = v0_1 ? v3_2.getTopRight() : v3_2.getTopLeft();
            ComposerKt.sourceInformationMarkerStart(v10, 0xAB718382, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            int v14 = v1_1 & 14;
            if(v14 != v2) {
                if((v1_1 & 8) != 0 && (v10.changedInstance(v6))) {
                    goto label_125;
                }

                v2 = 0;
            }
            else {
            label_125:
                v2 = 1;
            }

            v1_1 = (v1_1 & 0x70) == v4 ? 1 : 0;
            v1_1 = v1_1 | v2 | v10.changed(v0_1);
            Object v2_1 = v10.rememberedValue();
            if(v1_1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda2 v2_2 = new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda2(v6, v7, v0_1);
                v10.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            Modifier v5_1 = SemanticsModifierKt.semantics$default(v8, false, ((Function1)v2_1), 1, null);
            ProvidableCompositionLocal v1_2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(v10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v1_3 = v10.consume(((CompositionLocal)v1_2));
            ComposerKt.sourceInformationMarkerEnd(v10);
            long v16 = v12;
            Alignment v12_1 = v3_3;
            long v2_3 = v16;
            AndroidSelectionHandles_androidKt.HandlePopup(v6, v12_1, ComposableLambdaKt.rememberComposableLambda(0x515E2041, true, new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda3(((ViewConfiguration)v1_3), v2_3, v0_1, v5_1, v6), v10, 54), v10, v14 | 0x180);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v12 = v2_3;
        }
        else {
            v10.skipToGroupEnd();
        }

        ScopeUpdateScope v14_1 = v10.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda4(v6, v7, arg20, v11, v12, arg24, v8, v9, arg28));
        }
    }

    public static final void SelectionHandleIcon(Modifier arg5, Function0 arg6, boolean arg7, Composer arg8, int arg9) {
        int v2;
        int v1;
        int v0 = 0x7DDD909A;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(SelectionHandleIcon)N(modifier,iconVisible,isLeft)124@5167L89:AndroidSelectionHandles.android.kt#eksfi3");
        if((arg9 & 6) == 0) {
            v1 = arg8.changed(arg5) ? 4 : 2;
            v1 |= arg9;
        }
        else {
            v1 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            v2 = arg8.changedInstance(arg6) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg9 & 0x180) == 0) {
            v2 = arg8.changed(arg7) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg8.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:123)");
            }

            SpacerKt.Spacer(AndroidSelectionHandles_androidKt.drawSelectionHandle(SizeKt.size-VpY3zN4(arg5, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), arg6, arg7), arg8, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_55;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_55:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda6(arg5, arg6, arg7, arg9));
        }
    }

    static final Unit SelectionHandleIcon$lambda$0(Modifier arg0, Function0 arg1, boolean arg2, int arg3, Composer arg4, int arg5) {
        AndroidSelectionHandles_androidKt.SelectionHandleIcon(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SelectionHandle_wLIcFTc$lambda$0$0(OffsetProvider arg7, boolean arg8, boolean arg9, SemanticsPropertyReceiver arg10) {
        long v2 = arg7.provide-F1C5BW0();
        SemanticsPropertyKey v7 = SelectionHandlesKt.getSelectionHandleInfoKey();
        Handle v8 = arg8 ? Handle.SelectionStart : Handle.SelectionEnd;
        Handle v1 = v8;
        SelectionHandleAnchor v8_1 = arg9 ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right;
        SelectionHandleAnchor v4 = v8_1;
        arg8 = (0x7FFFFFFF7FFFFFFFL & v2) != 0x7FC000007FC00000L ? true : false;
        arg10.set(v7, new SelectionHandleInfo(v1, v2, v4, arg8, null));
        return Unit.INSTANCE;
    }

    static final Unit SelectionHandle_wLIcFTc$lambda$1(ViewConfiguration arg11, long arg12, boolean arg14, Modifier arg15, OffsetProvider arg16, Composer arg17, int arg18) {
        Composer v0 = arg17;
        int v1 = arg18;
        ComposerKt.sourceInformation(v0, "C85@3764L1254,85@3688L1330:AndroidSelectionHandles.android.kt#eksfi3");
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x515E2041, v1, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:85)");
            }

            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalViewConfiguration().provides(arg11), ComposableLambdaKt.rememberComposableLambda(1260045569, true, new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda5(arg12, arg14, arg15, arg16), v0, 54), v0, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_39;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0.skipToGroupEnd();
        }

    label_39:
        return Unit.INSTANCE;
    }

    private static final Unit SelectionHandle_wLIcFTc$lambda$1$0(long arg14, boolean arg16, Modifier arg17, OffsetProvider arg18, Composer arg19, int arg20) {
        boolean v0 = arg16;
        OffsetProvider v1 = arg18;
        Composer v2 = arg19;
        int v3 = arg20;
        ComposerKt.sourceInformation(v2, "C:AndroidSelectionHandles.android.kt#eksfi3");
        boolean v4 = (v3 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v4, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1260045569, v3, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:86)");
            }

            String v4_1 = "CC(remember):AndroidSelectionHandles.android.kt#9igjgp";
            if(Long.compare(arg14, 0x7FC000007FC00000L) != 0) {
                v2.startReplaceGroup(0x34C4C6);
                ComposerKt.sourceInformation(v2, "96@4179L576");
                Horizontal v3_1 = v0 ? Absolute.INSTANCE.getRight() : Absolute.INSTANCE.getLeft();
                Modifier v14 = SizeKt.requiredSizeIn-qDBjuR0$default(arg17, DpSize.getWidth-D9Ej5fM(arg14), DpSize.getHeight-D9Ej5fM(arg14), 0f, 0f, 12, null);
                ComposerKt.sourceInformationMarkerStart(v2, 0x3255A44B, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy v15 = RowKt.rowMeasurePolicy(v3_1, Alignment.Companion.getTop(), v2, 0);
                ComposerKt.sourceInformationMarkerStart(v2, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                v3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v2, 0));
                CompositionLocalMap v5 = v2.getCurrentCompositionLocalMap();
                v14 = ComposedModifierKt.materializeModifier(v2, v14);
                Function0 v6 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v2, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if(!(v2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v2.startReusableNode();
                if(v2.getInserting()) {
                    v2.createNode(v6);
                }
                else {
                    v2.useNode();
                }

                Composer v6_1 = Updater.constructor-impl(v2);
                Updater.set-impl(v6_1, v15, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v6_1, v5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(v6_1, Integer.valueOf(v3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(v6_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v6_1, v14, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v2, 0x56CCD6F5, "C101@5233L9:Row.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v2, 0x9CBCD633, "C106@4633L40,104@4529L208:AndroidSelectionHandles.android.kt#eksfi3");
                Companion v14_1 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v2, -1439191000, v4_1);
                boolean v15_1 = v2.changedInstance(v1);
                Object v3_2 = v2.rememberedValue();
                if((v15_1) || v3_2 == Composer.Companion.getEmpty()) {
                    AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda10 v3_3 = new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda10(v1);
                    v2.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                AndroidSelectionHandles_androidKt.SelectionHandleIcon(((Modifier)v14_1), ((Function0)v3_2), v0, v2, 6);
                ComposerKt.sourceInformationMarkerEnd(v2);
                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v2);
                ComposerKt.sourceInformationMarkerEnd(v2);
                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endReplaceGroup();
            }
            else {
                v2.startReplaceGroup(0x42F938);
                ComposerKt.sourceInformation(v2, "113@4898L40,111@4793L201");
                ComposerKt.sourceInformationMarkerStart(v2, 0xEF7E16A9, v4_1);
                boolean v14_2 = v2.changedInstance(v1);
                Object v15_2 = v2.rememberedValue();
                if((v14_2) || v15_2 == Composer.Companion.getEmpty()) {
                    AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda1 v15_3 = new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda1(v1);
                    v2.updateRememberedValue(v15_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                AndroidSelectionHandles_androidKt.SelectionHandleIcon(arg17, ((Function0)v15_2), v0, v2, 0);
                v2.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_143;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
        }

    label_143:
        return Unit.INSTANCE;
    }

    private static final boolean SelectionHandle_wLIcFTc$lambda$1$0$0$0$0(OffsetProvider arg4) {
        if((arg4.provide-F1C5BW0() & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    private static final boolean SelectionHandle_wLIcFTc$lambda$1$0$1$0(OffsetProvider arg4) {
        if((arg4.provide-F1C5BW0() & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    static final Unit SelectionHandle_wLIcFTc$lambda$2(OffsetProvider arg12, boolean arg13, ResolvedTextDirection arg14, boolean arg15, long arg16, float arg18, Modifier arg19, int arg20, int arg21, Composer arg22, int arg23) {
        AndroidSelectionHandles_androidKt.SelectionHandle-wLIcFTc(arg12, arg13, arg14, arg15, arg16, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope arg33, float arg34) {
        float v3 = arg34;
        int v4 = (((int)(((float)Math.ceil(((double)v3)))))) * 2;
        ImageBitmap v0 = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas v1 = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope v2 = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if(v0 == null || v1 == null || v4 > v0.getWidth() || v4 > v0.getHeight()) {
            v0 = ImageBitmapKt.ImageBitmap-x__-hDU$default(v4, v4, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
            HandleImageCache.INSTANCE.setImageBitmap(v0);
            v1 = CanvasKt.Canvas(v0);
            HandleImageCache.INSTANCE.setCanvas(v1);
        }

        ImageBitmap v12 = v0;
        Canvas v13 = v1;
        if(v2 == null) {
            v2 = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(v2);
        }

        CacheDrawScope v0_1 = arg33;
        LayoutDirection v1_1 = arg33.getLayoutDirection();
        long v4_1 = Size.constructor-impl((((long)Float.floatToRawIntBits(((float)v12.getWidth())))) << 0x20 | (((long)Float.floatToRawIntBits(((float)v12.getHeight())))) & 0xFFFFFFFFL);
        DrawParams v6 = v2.getDrawParams();
        Density v15 = v6.component1();
        LayoutDirection v7 = v6.component2();
        Canvas v8 = v6.component3();
        LayoutDirection v33 = v7;
        long v6_1 = v6.component4-NH-jbRc();
        DrawParams v11 = v2.getDrawParams();
        v11.setDensity(((Density)v0_1));
        v11.setLayoutDirection(v1_1);
        v11.setCanvas(v13);
        v11.setSize-uvyYCjk(v4_1);
        v13.save();
        DrawScope.drawRect-n-J9OG0$default(v2, Color.Companion.getBlack-0d7_KjU(), 0, v2.getSize-NH-jbRc(), 0f, null, null, BlendMode.Companion.getClear-0nO6VwU(), 58, null);
        DrawScope.drawRect-n-J9OG0$default(v2, ColorKt.Color(0xFF000000L), Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((((long)Float.floatToRawIntBits(v3))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v3))) << 0x20), 0f, null, null, 0, 120, null);
        DrawScope.drawCircle-VaOC9Bg$default(v2, ColorKt.Color(0xFF000000L), arg34, Offset.constructor-impl((((long)Float.floatToRawIntBits(v3))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v3))) << 0x20), 0f, null, null, 0, 120, null);
        v13.restore();
        DrawParams v0_2 = v2.getDrawParams();
        v0_2.setDensity(v15);
        v0_2.setLayoutDirection(v33);
        v0_2.setCanvas(v8);
        v0_2.setSize-uvyYCjk(v6_1);
        return v12;
    }

    public static final Modifier drawSelectionHandle(Modifier arg1, Function0 arg2, boolean arg3) {
        return ComposedModifierKt.composed$default(arg1, null, new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda7(arg2, arg3), 1, null);
    }

    static final Modifier drawSelectionHandle$lambda$0(Function0 arg3, boolean arg4, Modifier arg5, Composer arg6, int arg7) {
        int v0 = 0xF44568FA;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C129@5425L7,130@5472L678:AndroidSelectionHandles.android.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:129)");
        }

        ProvidableCompositionLocal v7 = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v7_1 = arg6.consume(((CompositionLocal)v7));
        ComposerKt.sourceInformationMarkerEnd(arg6);
        long v0_1 = ((TextSelectionColors)v7_1).getHandleColor-0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(arg6, 0xF88F21A0, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
        arg7 = arg6.changed(v0_1) | arg6.changed(arg3) | arg6.changed(arg4);
        Object v2 = arg6.rememberedValue();
        if(arg7 != 0 || v2 == Composer.Companion.getEmpty()) {
            AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda8 v2_1 = new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda8(v0_1, arg3, arg4);
            arg6.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        Modifier v3 = DrawModifierKt.drawWithCache(arg5, ((Function1)v2));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v3;
    }

    private static final DrawResult drawSelectionHandle$lambda$0$0$0(long arg7, Function0 arg9, boolean arg10, CacheDrawScope arg11) {
        return arg11.onDrawWithContent(new AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda9(arg9, arg10, AndroidSelectionHandles_androidKt.createHandleImage(arg11, Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() >> 0x20))) / 2f), androidx.compose.ui.graphics.ColorFilter$Companion.tint-xETnrds$default(ColorFilter.Companion, arg7, 0, 2, null)));
    }

    private static final Unit drawSelectionHandle$lambda$0$0$0$0(Function0 arg24, boolean arg25, ImageBitmap arg26, ColorFilter arg27, ContentDrawScope arg28) {
        arg28.drawContent();
        if(!arg24.invoke().booleanValue()) {
            return Unit.INSTANCE;
        }

        if(arg25) {
            ContentDrawScope v1 = arg28;
            long v2 = ((DrawScope)v1).getCenter-F1C5BW0();
            DrawContext v11 = ((DrawScope)v1).getDrawContext();
            long v12 = v11.getSize-NH-jbRc();
            v11.getCanvas().save();
            try {
                v11.getTransform().scale-0AR0LA0(-1f, 1f, v2);
                DrawScope.drawImage-gbVJVH8$default(((DrawScope)v1), arg26, 0, 0f, null, arg27, 0, 46, null);
            }
            catch(Throwable v0) {
                v11.getCanvas().restore();
                v11.setSize-uvyYCjk(v12);
                throw v0;
            }

            v11.getCanvas().restore();
            v11.setSize-uvyYCjk(v12);
        }
        else {
            DrawScope.drawImage-gbVJVH8$default(arg28, arg26, 0, 0f, null, arg27, 0, 46, null);
        }

        return Unit.INSTANCE;
    }
}

