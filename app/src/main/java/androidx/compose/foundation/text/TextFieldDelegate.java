package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString$Builder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/foundation/text/TextFieldDelegate;", "", "<init>", "()V", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldDelegate {
    @Metadata(d1={"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u000F\u0010\u0010JO\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0001¢\u0006\u0004\b!\u0010\"J7\u0010#\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010$\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u001EH\u0002¢\u0006\u0004\b&\u0010\'JE\u0010(\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\u0006\u0010\u001A\u001A\u00020\u001BH\u0001¢\u0006\u0002\b/J-\u00100\u001A\u00020\u00122\u0006\u0010+\u001A\u00020,2\u0006\u00101\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u000202H\u0001¢\u0006\u0002\b3JA\u00104\u001A\u00020\u00122\f\u00105\u001A\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001A\u0002092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\b\u0010<\u001A\u0004\u0018\u00010,H\u0001¢\u0006\u0002\b=JC\u0010>\u001A\u00020\u00122\u0006\u0010?\u001A\u00020@2\u0006\u0010\u001C\u001A\u0002022\u0006\u00108\u001A\u0002092\u0006\u0010\u001A\u001A\u00020\u001B2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0004\bA\u0010BJU\u0010C\u001A\u00020,2\u0006\u0010D\u001A\u00020E2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u00108\u001A\u0002092\u0006\u0010F\u001A\u00020G2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001A\u000E\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bJJU\u0010K\u001A\u00020,2\u0006\u0010D\u001A\u00020E2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u00108\u001A\u0002092\u0006\u0010F\u001A\u00020G2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;2\u0012\u0010H\u001A\u000E\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bLJ1\u0010M\u001A\u00020\u00122\u0006\u0010+\u001A\u00020,2\u0006\u00108\u001A\u0002092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120;H\u0001¢\u0006\u0002\bNJ\u001D\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020\u00182\u0006\u0010R\u001A\u00020P¢\u0006\u0004\bS\u0010T¨\u0006U"}, d2={"Landroidx/compose/foundation/text/TextFieldDelegate$Companion;", "", "<init>", "()V", "layout", "Lkotlin/Triple;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevResultText", "layout-_EkL_-Y$foundation", "(Landroidx/compose/foundation/text/TextDelegate;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Lkotlin/Triple;", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "selectionPreviewHighlightRange", "Landroidx/compose/ui/text/TextRange;", "deletionPreviewHighlightRange", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "draw-Q1vqE60$foundation", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/text/input/TextFieldValue;JJLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;J)V", "drawHighlight", "range", "paint", "drawHighlight-Le-punE", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Paint;)V", "notifyFocusedRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "hasFocus", "", "notifyFocusedRect$foundation", "updateTextLayoutResult", "textFieldValue", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "updateTextLayoutResult$foundation", "onEditCommand", "ops", "", "Landroidx/compose/ui/text/input/EditCommand;", "editProcessor", "Landroidx/compose/ui/text/input/EditProcessor;", "onValueChange", "Lkotlin/Function1;", "session", "onEditCommand$foundation", "setCursorOffset", "position", "Landroidx/compose/ui/geometry/Offset;", "setCursorOffset-ULxng0E$foundation", "(JLandroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/ui/text/input/EditProcessor;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/jvm/functions/Function1;)V", "restartInput", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "restartInput$foundation", "onFocus", "onFocus$foundation", "onBlur", "onBlur$foundation", "applyCompositionDecoration", "Landroidx/compose/ui/text/input/TransformedText;", "compositionRange", "transformed", "applyCompositionDecoration-72CqOWE", "(JLandroidx/compose/ui/text/input/TransformedText;)Landroidx/compose/ui/text/input/TransformedText;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TransformedText applyCompositionDecoration-72CqOWE(long arg28, TransformedText arg30) {
            int v0 = arg30.getOffsetMapping().originalToTransformed(TextRange.getStart-impl(arg28));
            int v1 = arg30.getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(arg28));
            int v2 = Math.min(v0, v1);
            v0 = Math.max(v0, v1);
            Builder v1_1 = new Builder(arg30.getText());
            v1_1.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 0xEFFF, null), v2, v0);
            return new TransformedText(v1_1.toAnnotatedString(), arg30.getOffsetMapping());
        }

        @JvmStatic public final void draw-Q1vqE60$foundation(Canvas arg9, TextFieldValue arg10, long arg11, long arg13, OffsetMapping arg15, TextLayoutResult arg16, Paint arg17, long arg18) {
            if(!TextRange.getCollapsed-impl(arg11)) {
                arg17.setColor-8_81llA(arg18);
                this.drawHighlight-Le-punE(arg9, arg11, arg15, arg16, arg17);
            }
            else if(!TextRange.getCollapsed-impl(arg13)) {
                Color v10 = Color.box-impl(arg16.getLayoutInput().getStyle().getColor-0d7_KjU());
                if(v10.unbox-impl() == 16) {
                    v10 = null;
                }

                long v10_1 = v10 != null ? v10.unbox-impl() : Color.Companion.getBlack-0d7_KjU();
                arg17.setColor-8_81llA(Color.copy-wmQWz5c$default(v10_1, Color.getAlpha-impl(v10_1) * 0.2f, 0f, 0f, 0f, 14, null));
                this.drawHighlight-Le-punE(arg9, arg13, arg15, arg16, arg17);
            }
            else {
                if(TextRange.getCollapsed-impl(arg10.getSelection-d9O1mEE())) {
                    goto label_56;
                }

                arg17.setColor-8_81llA(arg18);
                this.drawHighlight-Le-punE(arg9, arg10.getSelection-d9O1mEE(), arg15, arg16, arg17);
            }

        label_56:
            TextPainter.INSTANCE.paint(arg9, arg16);
        }

        private final void drawHighlight-Le-punE(Canvas arg1, long arg2, OffsetMapping arg4, TextLayoutResult arg5, Paint arg6) {
            int v0 = arg4.originalToTransformed(TextRange.getMin-impl(arg2));
            int v2 = arg4.originalToTransformed(TextRange.getMax-impl(arg2));
            if(v0 != v2) {
                arg1.drawPath(arg5.getPathForRange(v0, v2), arg6);
            }
        }

        @JvmStatic public final Triple layout-_EkL_-Y$foundation(TextDelegate arg3, long arg4, LayoutDirection arg6, TextLayoutResult arg7) {
            TextLayoutResult v2 = arg3.layout-NN6Ew-U(arg4, arg6, arg7);
            return new Triple(Integer.valueOf(((int)(v2.getSize-YbymL2g() >> 0x20))), Integer.valueOf(((int)(v2.getSize-YbymL2g() & 0xFFFFFFFFL))), v2);
        }

        public static Triple layout-_EkL_-Y$foundation$default(Companion arg6, TextDelegate arg7, long arg8, LayoutDirection arg10, TextLayoutResult arg11, int arg12, Object arg13) {
            if((arg12 & 8) != 0) {
                arg11 = null;
            }

            return arg6.layout-_EkL_-Y$foundation(arg7, arg8, arg10, arg11);
        }

        @JvmStatic public final void notifyFocusedRect$foundation(TextFieldValue arg1, TextDelegate arg2, TextLayoutResult arg3, LayoutCoordinates arg4, TextInputSession arg5, boolean arg6, OffsetMapping arg7) {
            if(!arg6) {
                return;
            }

            arg5.notifyFocusedRect(TextFieldDelegateKt.focusedRectInRoot(arg3, arg4, arg7.originalToTransformed(TextRange.getMax-impl(arg1.getSelection-d9O1mEE())), new TextFieldDelegate$Companion$$ExternalSyntheticLambda0(arg2)));
        }

        static final IntSize notifyFocusedRect$lambda$0(TextDelegate arg7) {
            return IntSize.box-impl(TextFieldDelegateKt.computeSizeForDefaultText$default(arg7.getStyle(), arg7.getDensity(), arg7.getFontFamilyResolver(), null, 0, 24, null));
        }

        @JvmStatic public final void onBlur$foundation(TextInputSession arg8, EditProcessor arg9, Function1 arg10) {
            arg10.invoke(TextFieldValue.copy-3r_uNRQ$default(arg9.toTextFieldValue(), null, 0, null, 3, null));
            arg8.dispose();
        }

        @JvmStatic public final void onEditCommand$foundation(List arg1, EditProcessor arg2, Function1 arg3, TextInputSession arg4) {
            TextFieldValue v0 = arg2.apply(arg1);
            if(arg4 != null) {
                arg4.updateState(null, v0);
            }

            arg3.invoke(v0);
        }

        @JvmStatic public final TextInputSession onFocus$foundation(TextInputService arg1, TextFieldValue arg2, EditProcessor arg3, ImeOptions arg4, Function1 arg5, Function1 arg6) {
            return this.restartInput$foundation(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        @JvmStatic public final TextInputSession restartInput$foundation(TextInputService arg2, TextFieldValue arg3, EditProcessor arg4, ImeOptions arg5, Function1 arg6, Function1 arg7) {
            ObjectRef v1 = new ObjectRef();
            v1.element = arg2.startInput(arg3, arg5, new TextFieldDelegate$Companion$$ExternalSyntheticLambda1(arg4, arg6, v1), arg7);
            return v1.element;
        }

        static final Unit restartInput$lambda$0(EditProcessor arg1, Function1 arg2, ObjectRef arg3, List arg4) {
            TextFieldDelegate.Companion.onEditCommand$foundation(arg4, arg1, arg2, arg3.element);
            return Unit.INSTANCE;
        }

        @JvmStatic public final void setCursorOffset-ULxng0E$foundation(long arg8, TextLayoutResultProxy arg10, EditProcessor arg11, OffsetMapping arg12, Function1 arg13) {
            arg13.invoke(TextFieldValue.copy-3r_uNRQ$default(arg11.toTextFieldValue(), null, TextRangeKt.TextRange(arg12.transformedToOriginal(TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(arg10, arg8, false, 2, null))), null, 5, null));
        }

        @JvmStatic public final void updateTextLayoutResult$foundation(TextInputSession arg9, TextFieldValue arg10, OffsetMapping arg11, TextLayoutResultProxy arg12) {
            LayoutCoordinates v8 = arg12.getInnerTextFieldCoordinates();
            if(v8 != null) {
                if(!v8.isAttached()) {
                }
                else {
                    LayoutCoordinates v0 = arg12.getDecorationBoxCoordinates();
                    if(v0 != null) {
                        arg9.updateTextLayoutResult(arg10, arg11, arg12.getValue(), new TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1(v8), SelectionManagerKt.visibleBounds(v8), v8.localBoundingBoxOf(v0, false));
                    }
                }
            }
        }
    }

    public static final int $stable;
    public static final Companion Companion;

    static {
        TextFieldDelegate.Companion = new Companion(null);
    }

    public TextFieldDelegate() {
        super();
    }

    @JvmStatic public static final void draw-Q1vqE60$foundation(Canvas arg12, TextFieldValue arg13, long arg14, long arg16, OffsetMapping arg18, TextLayoutResult arg19, Paint arg20, long arg21) {
        TextFieldDelegate.Companion.draw-Q1vqE60$foundation(arg12, arg13, arg14, arg16, arg18, arg19, arg20, arg21);
    }

    @JvmStatic public static final Triple layout-_EkL_-Y$foundation(TextDelegate arg6, long arg7, LayoutDirection arg9, TextLayoutResult arg10) {
        return TextFieldDelegate.Companion.layout-_EkL_-Y$foundation(arg6, arg7, arg9, arg10);
    }

    @JvmStatic public static final void notifyFocusedRect$foundation(TextFieldValue arg8, TextDelegate arg9, TextLayoutResult arg10, LayoutCoordinates arg11, TextInputSession arg12, boolean arg13, OffsetMapping arg14) {
        TextFieldDelegate.Companion.notifyFocusedRect$foundation(arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    @JvmStatic public static final void onBlur$foundation(TextInputSession arg1, EditProcessor arg2, Function1 arg3) {
        TextFieldDelegate.Companion.onBlur$foundation(arg1, arg2, arg3);
    }

    @JvmStatic public static final void onEditCommand$foundation(List arg1, EditProcessor arg2, Function1 arg3, TextInputSession arg4) {
        TextFieldDelegate.Companion.onEditCommand$foundation(arg1, arg2, arg3, arg4);
    }

    @JvmStatic public static final TextInputSession onFocus$foundation(TextInputService arg7, TextFieldValue arg8, EditProcessor arg9, ImeOptions arg10, Function1 arg11, Function1 arg12) {
        return TextFieldDelegate.Companion.onFocus$foundation(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    @JvmStatic public static final TextInputSession restartInput$foundation(TextInputService arg7, TextFieldValue arg8, EditProcessor arg9, ImeOptions arg10, Function1 arg11, Function1 arg12) {
        return TextFieldDelegate.Companion.restartInput$foundation(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    @JvmStatic public static final void setCursorOffset-ULxng0E$foundation(long arg7, TextLayoutResultProxy arg9, EditProcessor arg10, OffsetMapping arg11, Function1 arg12) {
        TextFieldDelegate.Companion.setCursorOffset-ULxng0E$foundation(arg7, arg9, arg10, arg11, arg12);
    }

    @JvmStatic public static final void updateTextLayoutResult$foundation(TextInputSession arg1, TextFieldValue arg2, OffsetMapping arg3, TextLayoutResultProxy arg4) {
        TextFieldDelegate.Companion.updateTextLayoutResult$foundation(arg1, arg2, arg3, arg4);
    }
}

