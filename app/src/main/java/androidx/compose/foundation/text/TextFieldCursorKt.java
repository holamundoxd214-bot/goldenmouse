package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0000¨\u0006\f"}, d2={"cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldCursorKt {
    public static Unit $r8$lambda$ZohCaPWDcHAZRHGNQz1pwIeCw1A(CursorAnimationState arg0, OffsetMapping arg1, TextFieldValue arg2, LegacyTextFieldState arg3, Brush arg4, ContentDrawScope arg5) {
        return TextFieldCursorKt.cursor$lambda$0$2$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Modifier cursor(Modifier arg0, LegacyTextFieldState arg1, TextFieldValue arg2, OffsetMapping arg3, Brush arg4, boolean arg5) {
        if(arg5) {
            arg0 = ComposedModifierKt.composed$default(arg0, null, new TextFieldCursorKt$$ExternalSyntheticLambda1(arg4, arg1, arg2, arg3), 1, null);
        }

        return arg0;
    }

    static final Modifier cursor$lambda$0(Brush arg12, LegacyTextFieldState arg13, TextFieldValue arg14, OffsetMapping arg15, Modifier arg16, Composer arg17, int arg18) {
        TextFieldCursorKt$$ExternalSyntheticLambda0 v1_3;
        Companion v0_7;
        Composer v6 = arg17;
        int v0 = 0xFAF68513;
        v6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(v6, "C46@1735L7,47@1777L63,54@2290L7:TextFieldCursor.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
        }

        ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalCursorBlinkEnabled();
        int v1 = 0x789C5F52;
        String v2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v6, v1, v2);
        Object v0_2 = v6.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(v6);
        boolean v0_3 = ((Boolean)v0_2).booleanValue();
        String v4 = "CC(remember):TextFieldCursor.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v6, 0x17699912, v4);
        boolean v3 = v6.changed(v0_3);
        Object v7 = v6.rememberedValue();
        if((v3) || v7 == Composer.Companion.getEmpty()) {
            CursorAnimationState v7_1 = new CursorAnimationState(v0_3);
            v6.updateRememberedValue(v7_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        v0 = !(arg12 instanceof SolidColor) || arg12.getValue-0d7_KjU() != 16 ? 1 : 0;
        ProvidableCompositionLocal v8 = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(v6, v1, v2);
        Object v1_1 = v6.consume(((CompositionLocal)v8));
        ComposerKt.sourceInformationMarkerEnd(v6);
        if(!((WindowInfo)v1_1).isWindowFocused() || !arg13.getHasFocus() || !TextRange.getCollapsed-impl(arg14.getSelection-d9O1mEE()) || v0 == 0) {
            v6.startReplaceGroup(0xD5F35527);
            v6.endReplaceGroup();
            v0_7 = Modifier.Companion;
        }
        else {
            v6.startReplaceGroup(-707487962);
            ComposerKt.sourceInformation(v6, "58@2517L81,58@2462L136,61@2631L1888");
            AnnotatedString v0_4 = arg14.getAnnotatedString();
            TextRange v1_2 = TextRange.box-impl(arg14.getSelection-d9O1mEE());
            ComposerKt.sourceInformationMarkerStart(v6, 0x1769F5A4, v4);
            boolean v2_1 = v6.changedInstance(v7);
            Object v8_1 = v6.rememberedValue();
            if((v2_1) || v8_1 == Composer.Companion.getEmpty()) {
                TextFieldCursorKt$cursor$1$1$1 v8_2 = new TextFieldCursorKt$cursor$1$1$1(((CursorAnimationState)v7), null);
                v6.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            EffectsKt.LaunchedEffect(v0_4, v1_2, ((Function2)v8_1), v6, 0);
            ComposerKt.sourceInformationMarkerStart(v6, 0x176A0AF3, v4);
            v0 = v6.changedInstance(v7) | v6.changedInstance(arg15) | v6.changed(arg14) | v6.changedInstance(arg13) | v6.changed(arg12);
            v1_1 = v6.rememberedValue();
            if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                TextFieldCursorKt$$ExternalSyntheticLambda0 v0_5 = new TextFieldCursorKt$$ExternalSyntheticLambda0(v7, arg15, arg14, arg13, arg12);
                v6.updateRememberedValue(v0_5);
                v1_3 = v0_5;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            Modifier v0_6 = DrawModifierKt.drawWithContent(arg16, ((Function1)v1_3));
            v6.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        return ((Modifier)v0_7);
    }

    private static final Unit cursor$lambda$0$2$0(CursorAnimationState arg16, OffsetMapping arg17, TextFieldValue arg18, LegacyTextFieldState arg19, Brush arg20, ContentDrawScope arg21) {
        Rect v2_1;
        ContentDrawScope v0 = arg21;
        v0.drawContent();
        float v9 = arg16.getCursorAlpha();
        if(v9 == 0f) {
        }
        else {
            int v2 = arg17.originalToTransformed(TextRange.getStart-impl(arg18.getSelection-d9O1mEE()));
            TextLayoutResultProxy v3 = arg19.getLayoutResult();
            if(v3 != null) {
                TextLayoutResult v3_1 = v3.getValue();
                if(v3_1 != null) {
                    v2_1 = v3_1.getCursorRect(v2);
                    if(v2_1 == null) {
                        goto label_16;
                    }
                }
                else {
                    goto label_16;
                }
            }
            else {
            label_16:
                v2_1 = new Rect(0f, 0f, 0f, 0f);
            }

            float v6 = RangesKt.coerceAtLeast(((float)Math.floor(((double)v0.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())))), 1f);
            float v3_2 = v6 / 2f;
            int v7 = 0x20;
            float v1 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(v2_1.getLeft() + v3_2, Float.intBitsToFloat(((int)(v0.getSize-NH-jbRc() >> v7))) - v3_2), v3_2);
            v1 = (((int)v6)) % 2 == 1 ? (((float)Math.floor(((double)v1)))) + 0.5f : ((float)Math.rint(((double)v1)));
            DrawScope.drawLine-1RTmtNc$default(((DrawScope)v0), arg20, Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) << v7 | (((long)Float.floatToRawIntBits(v2_1.getTop()))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(v2_1.getBottom()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v1))) << v7), v6, 0, null, v9, null, 0, 0x1B0, null);
        }

        return Unit.INSTANCE;
    }
}

