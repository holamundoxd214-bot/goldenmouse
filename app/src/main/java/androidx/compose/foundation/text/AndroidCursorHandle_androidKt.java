package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A)\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u0017\u0010\u0013\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0003¢\u0006\u0002\u0010\u0014\u001A\f\u0010\u0015\u001A\u00020\u000E*\u00020\u000EH\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001A\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\b\u0010\u0005¨\u0006\u0016"}, d2={"Sqrt2", "", "CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "CursorHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-USBMPiE", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight = 0f;
    private static final float CursorHandleWidth = 0f;
    private static final float Sqrt2 = 1.414214f;

    public static Unit $r8$lambda$Jxq8ErkYpvVIzxhaXdjhwA-vQS0(float arg0, ImageBitmap arg1, ColorFilter arg2, ContentDrawScope arg3) {
        return AndroidCursorHandle_androidKt.drawCursorHandle$lambda$0$0$0$0(arg0, arg1, arg2, arg3);
    }

    public static Unit $r8$lambda$VODaROJTAYG_icyYlQqj53kmGbk(OffsetProvider arg0, SemanticsPropertyReceiver arg1) {
        return AndroidCursorHandle_androidKt.CursorHandle_USBMPiE$lambda$0$0(arg0, arg1);
    }

    public static DrawResult $r8$lambda$hFl1TmHLhmXVzmivwBJMFE1LY1M(long arg0, CacheDrawScope arg2) {
        return AndroidCursorHandle_androidKt.drawCursorHandle$lambda$0$0$0(arg0, arg2);
    }

    static {
        float v0 = Dp.constructor-impl(25f);
        AndroidCursorHandle_androidKt.CursorHandleHeight = v0;
        AndroidCursorHandle_androidKt.CursorHandleWidth = Dp.constructor-impl(Dp.constructor-impl(v0 * 2f) / 2.414214f);
    }

    public static final void CursorHandle-USBMPiE(OffsetProvider arg8, Modifier arg9, long arg10, Composer arg12, int arg13, int arg14) {
        AndroidCursorHandle_androidKt$$ExternalSyntheticLambda4 v2_2;
        int v3;
        int v1_1;
        int v0 = 1776202187;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(CursorHandle)N(offsetProvider,modifier,minTouchTargetSize:c#ui.unit.DpSize)53@2201L305,62@2602L492,62@2511L583:AndroidCursorHandle.android.kt#423gt5");
        int v2 = 4;
        if((arg13 & 6) == 0) {
            boolean v1 = (arg13 & 8) == 0 ? arg12.changed(arg8) : arg12.changedInstance(arg8);
            v1_1 = v1 ? v2 : 2;
            v1_1 |= arg13;
        }
        else {
            v1_1 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v3 = arg12.changed(arg9) ? 0x20 : 16;
            v1_1 |= v3;
        }

        if((arg13 & 0x180) == 0) {
            v3 = (arg14 & 4) != 0 || !arg12.changed(arg10) ? 0x80 : 0x100;
            v1_1 |= v3;
        }

        boolean v3_1 = (v1_1 & 0x93) != 0x92 ? true : false;
        if(arg12.shouldExecute(v3_1, v1_1 & 1)) {
            arg12.startDefaults();
            if((arg13 & 1) != 0 && !arg12.getDefaultsInvalid()) {
                arg12.skipToGroupEnd();
                if((arg14 & 4) != 0) {
                    goto label_62;
                }
            }
            else if((arg14 & 4) != 0) {
                arg10 = DpSize.Companion.getUnspecified-MYxV2XQ();
            label_62:
                v1_1 &= -897;
            }

            arg12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:51)");
            }

            ComposerKt.sourceInformationMarkerStart(arg12, 0x6CF980DC, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
            v0 = v1_1 & 14;
            if(v0 != v2) {
                if((v1_1 & 8) != 0 && (arg12.changedInstance(arg8))) {
                    goto label_81;
                }

                v1_1 = 0;
            }
            else {
            label_81:
                v1_1 = 1;
            }

            Object v2_1 = arg12.rememberedValue();
            if(v1_1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda4(arg8);
                arg12.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            AndroidSelectionHandles_androidKt.HandlePopup(arg8, Alignment.Companion.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(0x9D712E02, true, new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda5(arg10, SemanticsModifierKt.semantics$default(arg9, false, ((Function1)v2_2), 1, null)), arg12, 54), arg12, v0 | 0x1B0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_107;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_107:
        long v4 = arg10;
        ScopeUpdateScope v10 = arg12.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda6(arg8, arg9, v4, arg13, arg14));
        }
    }

    private static final Unit CursorHandle_USBMPiE$lambda$0$0(OffsetProvider arg8, SemanticsPropertyReceiver arg9) {
        arg9.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, arg8.provide-F1C5BW0(), SelectionHandleAnchor.Middle, true, null));
        return Unit.INSTANCE;
    }

    static final Unit CursorHandle_USBMPiE$lambda$1(long arg11, Modifier arg13, Composer arg14, int arg15) {
        ComposerKt.sourceInformation(arg14, "C:AndroidCursorHandle.android.kt#423gt5");
        boolean v0 = (arg15 & 3) != 2 ? true : false;
        if(arg14.shouldExecute(v0, arg15 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x9D712E02, arg15, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:63)");
            }

            if(arg11 != 0x7FC000007FC00000L) {
                arg14.startReplaceGroup(-1244013944);
                ComposerKt.sourceInformation(arg14, "64@2662L352");
                Modifier v11 = SizeKt.requiredSizeIn-qDBjuR0$default(arg13, DpSize.getWidth-D9Ej5fM(arg11), DpSize.getHeight-D9Ej5fM(arg11), 0f, 0f, 12, null);
                Alignment v12 = Alignment.Companion.getTopCenter();
                ComposerKt.sourceInformationMarkerStart(arg14, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy v12_1 = BoxKt.maybeCachedBoxMeasurePolicy(v12, false);
                ComposerKt.sourceInformationMarkerStart(arg14, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int v13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg14, 0));
                CompositionLocalMap v15 = arg14.getCurrentCompositionLocalMap();
                v11 = ComposedModifierKt.materializeModifier(arg14, v11);
                Function0 v0_1 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(arg14, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if(!(arg14.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                arg14.startReusableNode();
                if(arg14.getInserting()) {
                    arg14.createNode(v0_1);
                }
                else {
                    arg14.useNode();
                }

                Composer v0_2 = Updater.constructor-impl(arg14);
                Updater.set-impl(v0_2, v12_1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v0_2, v15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(v0_2, Integer.valueOf(v13), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(v0_2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v0_2, v11, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(arg14, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(arg14, 0x36F854ED, "C72@2979L21:AndroidCursorHandle.android.kt#423gt5");
                AndroidCursorHandle_androidKt.DefaultCursorHandle(null, arg14, 0, 1);
                ComposerKt.sourceInformationMarkerEnd(arg14);
                ComposerKt.sourceInformationMarkerEnd(arg14);
                arg14.endNode();
                ComposerKt.sourceInformationMarkerEnd(arg14);
                ComposerKt.sourceInformationMarkerEnd(arg14);
                ComposerKt.sourceInformationMarkerEnd(arg14);
                arg14.endReplaceGroup();
            }
            else {
                arg14.startReplaceGroup(0xB5DF7C46);
                ComposerKt.sourceInformation(arg14, "75@3044L34");
                AndroidCursorHandle_androidKt.DefaultCursorHandle(arg13, arg14, 0, 0);
                arg14.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_107;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg14.skipToGroupEnd();
        }

    label_107:
        return Unit.INSTANCE;
    }

    static final Unit CursorHandle_USBMPiE$lambda$2(OffsetProvider arg7, Modifier arg8, long arg9, int arg11, int arg12, Composer arg13, int arg14) {
        AndroidCursorHandle_androidKt.CursorHandle-USBMPiE(arg7, arg8, arg9, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final void DefaultCursorHandle(Modifier arg6, Composer arg7, int arg8, int arg9) {
        Companion v6;
        int v3;
        int v0 = 694251107;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(DefaultCursorHandle)N(modifier)83@3202L79:AndroidCursorHandle.android.kt#423gt5");
        int v1 = arg9 & 1;
        int v2 = 2;
        if(v1 != 0) {
            v3 = arg8 | 6;
        }
        else if((arg8 & 6) == 0) {
            v3 = arg7.changed(arg6) ? 4 : v2;
            v3 |= arg8;
        }
        else {
            v3 = arg8;
        }

        boolean v2_1 = (v3 & 3) != v2 ? true : false;
        if(arg7.shouldExecute(v2_1, v3 & 1)) {
            if(v1 != 0) {
                v6 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
            }

            SpacerKt.Spacer(AndroidCursorHandle_androidKt.drawCursorHandle(SizeKt.size-VpY3zN4(((Modifier)v6), AndroidCursorHandle_androidKt.CursorHandleWidth, AndroidCursorHandle_androidKt.CursorHandleHeight)), arg7, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_45;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_45:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(((Modifier)v6), arg8, arg9));
        }
    }

    static final Unit DefaultCursorHandle$lambda$0(Modifier arg0, int arg1, int arg2, Composer arg3, int arg4) {
        AndroidCursorHandle_androidKt.DefaultCursorHandle(arg0, arg3, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1), arg2);
        return Unit.INSTANCE;
    }

    private static final Modifier drawCursorHandle(Modifier arg3) {
        return ComposedModifierKt.composed$default(arg3, null, new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final Modifier drawCursorHandle$lambda$0(Modifier arg4, Composer arg5, int arg6) {
        AndroidCursorHandle_androidKt$$ExternalSyntheticLambda3 v3_1;
        int v0 = 0x813A1807;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C87@3385L7,89@3451L602:AndroidCursorHandle.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:87)");
        }

        ProvidableCompositionLocal v6 = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        long v0_1 = ((TextSelectionColors)v6_1).getHandleColor-0d7_KjU();
        Companion v6_2 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(arg5, 0x1B144301, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
        boolean v2 = arg5.changed(v0_1);
        Object v3 = arg5.rememberedValue();
        if((v2) || v3 == Composer.Companion.getEmpty()) {
            v3_1 = new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda3(v0_1);
            arg5.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        arg4 = arg4.then(DrawModifierKt.drawWithCache(((Modifier)v6_2), ((Function1)v3_1)));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return arg4;
    }

    private static final DrawResult drawCursorHandle$lambda$0$0$0(long arg8, CacheDrawScope arg10) {
        float v0 = Float.intBitsToFloat(((int)(arg10.getSize-NH-jbRc() >> 0x20))) / 2f;
        return arg10.onDrawWithContent(new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda2(v0, AndroidSelectionHandles_androidKt.createHandleImage(arg10, v0), androidx.compose.ui.graphics.ColorFilter$Companion.tint-xETnrds$default(ColorFilter.Companion, arg8, 0, 2, null)));
    }

    private static final Unit drawCursorHandle$lambda$0$0$0$0(float arg12, ImageBitmap arg13, ColorFilter arg14, ContentDrawScope arg15) {
        arg15.drawContent();
        ContentDrawScope v0 = arg15;
        DrawContext v15 = ((DrawScope)v0).getDrawContext();
        long v10 = v15.getSize-NH-jbRc();
        v15.getCanvas().save();
        try {
            DrawTransform v1 = v15.getTransform();
            DrawTransform.translate$default(v1, arg12, 0f, 2, null);
            v1.rotate-Uv8p0NA(45f, Offset.Companion.getZero-F1C5BW0());
            DrawScope.drawImage-gbVJVH8$default(((DrawScope)v0), arg13, 0, 0f, null, arg14, 0, 46, null);
        }
        catch(Throwable v0_1) {
            v15.getCanvas().restore();
            v15.setSize-uvyYCjk(v10);
            throw v0_1;
        }

        v15.getCanvas().restore();
        v15.setSize-uvyYCjk(v10);
        return Unit.INSTANCE;
    }

    public static final float getCursorHandleHeight() {
        return AndroidCursorHandle_androidKt.CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return AndroidCursorHandle_androidKt.CursorHandleWidth;
    }
}

