package androidx.compose.foundation.text;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0000\u001A4\u0010\n\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u000E\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0000\u001A6\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0016H\u0002¨\u0006\u001D"}, d2={"textFieldScrollable", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "defaultTextFieldScroll", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "textFieldWidth", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldScrollKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Orientation.values().length];
            try {
                v0[Orientation.Vertical.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Orientation.Horizontal.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static float $r8$lambda$LFwDxDc3DMJLARAgRelugrFtCU8(TextFieldScrollerPosition arg0, float arg1) {
        return TextFieldScrollKt.textFieldScrollable$lambda$1$0$0(arg0, arg1);
    }

    public static final Rect access$getCursorRectInScroller(Density arg0, int arg1, TransformedText arg2, TextLayoutResult arg3, boolean arg4, int arg5) {
        return TextFieldScrollKt.getCursorRectInScroller(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Modifier defaultTextFieldScroll(Modifier arg4, TextFieldScrollerPosition arg5, TextFieldValue arg6, VisualTransformation arg7, Function0 arg8) {
        HorizontalScrollLayoutModifier v7_1;
        Orientation v0 = arg5.getOrientation();
        int v1 = arg5.getOffsetToFollow-5zc-tL8(arg6.getSelection-d9O1mEE());
        arg5.setPreviousSelection-5zc-tL8(arg6.getSelection-d9O1mEE());
        TransformedText v6 = ValidatingOffsetMappingKt.filterWithValidation(arg7, arg6.getAnnotatedString());
        int v7 = WhenMappings.$EnumSwitchMapping$0[v0.ordinal()];
        if(v7 == 1) {
            VerticalScrollLayoutModifier v7_2 = new VerticalScrollLayoutModifier(arg5, v1, v6, arg8);
        }
        else if(v7 == 2) {
            v7_1 = new HorizontalScrollLayoutModifier(arg5, v1, v6, arg8);
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        return ClipKt.clipToBounds(arg4).then(((Modifier)v7_1));
    }

    private static final Rect getCursorRectInScroller(Density arg7, int arg8, TransformedText arg9, TextLayoutResult arg10, boolean arg11, int arg12) {
        Rect v8;
        if(arg10 != null) {
            v8 = arg10.getCursorRect(arg9.getOffsetMapping().originalToTransformed(arg8));
            if(v8 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v8 = Rect.Companion.getZero();
        }

        Rect v0 = v8;
        int v7 = arg7.roundToPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness());
        float v8_1 = arg11 ? (((float)arg12)) - v0.getLeft() - (((float)v7)) : v0.getLeft();
        float v1 = v8_1;
        float v7_1 = arg11 ? (((float)arg12)) - v0.getLeft() : (((float)v7)) + v0.getLeft();
        return Rect.copy$default(v0, v1, 0f, v7_1, 0f, 10, null);
    }

    public static final Modifier textFieldScrollable(Modifier arg2, TextFieldScrollerPosition arg3, MutableInteractionSource arg4, boolean arg5, OverscrollEffect arg6) {
        TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(arg3, arg4, arg5);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v0), new TextFieldScrollKt$$ExternalSyntheticLambda1(arg3, arg5, arg6, arg4));
    }

    public static Modifier textFieldScrollable$default(Modifier arg0, TextFieldScrollerPosition arg1, MutableInteractionSource arg2, boolean arg3, OverscrollEffect arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = null;
        }

        return TextFieldScrollKt.textFieldScrollable(arg0, arg1, arg2, true, arg4);
    }

    static final Modifier textFieldScrollable$lambda$1(TextFieldScrollerPosition arg18, boolean arg19, OverscrollEffect arg20, MutableInteractionSource arg21, Modifier arg22, Composer arg23, int arg24) {
        TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 v6_2;
        TextFieldScrollKt$$ExternalSyntheticLambda0 v6_1;
        TextFieldScrollerPosition v0 = arg18;
        Composer v1 = arg23;
        int v2 = 0x8097A0A0;
        v1.startReplaceGroup(v2);
        ComposerKt.sourceInformation(v1, "C76@3265L7,78@3442L464,78@3418L488,93@4082L452:TextFieldScroll.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg24, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:76)");
        }

        ProvidableCompositionLocal v2_1 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_2 = v1.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(v1);
        v2 = v2_2 == LayoutDirection.Rtl ? 1 : 0;
        boolean v12 = v0.getOrientation() == Orientation.Vertical || v2 == 0 ? true : false;
        String v3 = "CC(remember):TextFieldScroll.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v1, 0xB9321FF0, v3);
        boolean v2_3 = v1.changed(v0);
        Object v6 = v1.rememberedValue();
        if((v2_3) || v6 == Composer.Companion.getEmpty()) {
            v6_1 = new TextFieldScrollKt$$ExternalSyntheticLambda0(v0);
            v1.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        ScrollableState v2_4 = ScrollableStateKt.rememberScrollableState(((Function1)v6_1), v1, 0);
        ComposerKt.sourceInformationMarkerStart(v1, 0xB9326FE4, v3);
        int v3_1 = v1.changed(v2_4) | v1.changed(v0);
        v6 = v1.rememberedValue();
        if(v3_1 != 0 || v6 == Composer.Companion.getEmpty()) {
            v6_2 = new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1(v2_4, v0);
            v1.updateRememberedValue(v6_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        Companion v2_5 = Modifier.Companion;
        Orientation v9 = v0.getOrientation();
        boolean v11 = !arg19 || v0.getMaximum() == 0f ? false : true;
        Modifier v0_1 = ScrollableKt.scrollable$default(v2_5, v6_2, v9, arg20, v11, v12, null, arg21, null, 0xA0, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v1.endReplaceGroup();
        return v0_1;
    }

    private static final float textFieldScrollable$lambda$1$0$0(TextFieldScrollerPosition arg2, float arg3) {
        float v0 = arg2.getOffset() + arg3;
        if(v0 > arg2.getMaximum()) {
            arg3 = arg2.getMaximum() - arg2.getOffset();
        }
        else if(v0 < 0f) {
            arg3 = -arg2.getOffset();
        }

        arg2.setOffset(arg2.getOffset() + arg3);
        return arg3;
    }
}

