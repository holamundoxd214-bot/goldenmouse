package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0000\u001A\u001C\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A8\u0010\n\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u001A\b\u0002\u0010\u000B\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u000E0\rj\u0002`\u000F\u0018\u00010\fH\u0000\u001A\u001C\u0010\u0010\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0006H\u0000\u001A\u001C\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0006H\u0000\u001A\f\u0010\u0014\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\u001C\u0010\u0015\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A\u0018\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0002\u001A$\u0010\u001B\u001A\u00020\u0001*\u00020\u001C2\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u001DH\u0001\u001A\u001C\u0010\u001E\u001A\u00020\u0001*\u00020\u001C2\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0001¨\u0006\u001F"}, d2={"commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "setComposingRegion", "start", "end", "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "setSelection", "isSurrogatePair", "", "high", "", "low", "imeReplace", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "imeDelete", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ImeEditCommand_androidKt {
    public static final void commitText(ImeEditCommandScope arg1, String arg2, int arg3) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda3(arg2, arg3));
    }

    static final Unit commitText$lambda$0(String arg4, int arg5, TextFieldBuffer arg6) {
        TextRange v0 = arg6.getComposition-MzsxiRA$foundation();
        if(v0 != null) {
            ImeEditCommand_androidKt.imeReplace(arg6, TextRange.getStart-impl(v0.unbox-impl()), TextRange.getEnd-impl(v0.unbox-impl()), arg4);
        }
        else {
            ImeEditCommand_androidKt.imeReplace(arg6, TextRange.getStart-impl(arg6.getSelection-d9O1mEE()), TextRange.getEnd-impl(arg6.getSelection-d9O1mEE()), arg4);
        }

        int v0_1 = TextRange.getStart-impl(arg6.getSelection-d9O1mEE());
        v0_1 = arg5 > 0 ? v0_1 + arg5 - 1 : v0_1 + arg5 - arg4.length();
        arg6.setSelection-5zc-tL8(TextRangeKt.TextRange(RangesKt.coerceIn(v0_1, 0, arg6.getLength())));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingText(ImeEditCommandScope arg1, int arg2, int arg3) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda4(arg2, arg3, arg1));
    }

    static final Unit deleteSurroundingText$lambda$0(int arg5, int arg6, ImeEditCommandScope arg7, TextFieldBuffer arg8) {
        int v1 = arg5 < 0 || arg6 < 0 ? 0 : 1;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + arg5 + " and " + arg6 + " respectively.");
        }

        long v1_1 = arg7.mapToTransformed-GEjPoXI(arg8.getSelection-d9O1mEE());
        int v3 = TextRange.getEnd-impl(v1_1);
        int v4 = v3 + arg6;
        if(((arg6 ^ v4) & (v3 ^ v4)) < 0) {
            v4 = arg8.getLength();
        }

        long v3_1 = arg7.mapFromTransformed-GEjPoXI(TextRangeKt.TextRange(TextRange.getEnd-impl(v1_1), Math.min(v4, arg8.getLength())));
        ImeEditCommand_androidKt.imeDelete(arg8, TextRange.getMin-impl(v3_1), TextRange.getMax-impl(v3_1));
        arg6 = TextRange.getStart-impl(v1_1);
        v3 = arg6 - arg5;
        if(((arg5 ^ arg6) & (arg6 ^ v3)) < 0) {
            v3 = 0;
        }

        long v5 = arg7.mapFromTransformed-GEjPoXI(TextRangeKt.TextRange(Math.max(0, v3), TextRange.getStart-impl(v1_1)));
        ImeEditCommand_androidKt.imeDelete(arg8, TextRange.getMin-impl(v5), TextRange.getMax-impl(v5));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope arg1, int arg2, int arg3) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda0(arg2, arg3));
    }

    static final Unit deleteSurroundingTextInCodePoints$lambda$0(int arg9, int arg10, TextFieldBuffer arg11) {
        int v0 = 0;
        int v2 = arg9 < 0 || arg10 < 0 ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + arg9 + " and " + arg10 + " respectively.");
        }

        v2 = 0;
        int v3 = 0;
        while(true) {
            if(v2 < arg9) {
                int v4 = v3 + 1;
                if(TextRange.getStart-impl(arg11.getSelection-d9O1mEE()) > v4) {
                    if(ImeEditCommand_androidKt.isSurrogatePair(arg11.asCharSequence().charAt(TextRange.getStart-impl(arg11.getSelection-d9O1mEE()) - v4 - 1), arg11.asCharSequence().charAt(TextRange.getStart-impl(arg11.getSelection-d9O1mEE()) - v4))) {
                        v3 += 2;
                    }
                    else {
                        v3 = v4;
                    }

                    ++v2;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_46;
        }

        v3 = TextRange.getStart-impl(arg11.getSelection-d9O1mEE());
    label_46:
        arg9 = 0;
        while(true) {
            if(v0 < arg10) {
                v2 = arg9 + 1;
                if(TextRange.getEnd-impl(arg11.getSelection-d9O1mEE()) + v2 < arg11.getLength()) {
                    if(ImeEditCommand_androidKt.isSurrogatePair(arg11.asCharSequence().charAt(TextRange.getEnd-impl(arg11.getSelection-d9O1mEE()) + v2 - 1), arg11.asCharSequence().charAt(TextRange.getEnd-impl(arg11.getSelection-d9O1mEE()) + v2))) {
                        arg9 += 2;
                    }
                    else {
                        arg9 = v2;
                    }

                    ++v0;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_76;
        }

        arg9 = arg11.getLength() - TextRange.getEnd-impl(arg11.getSelection-d9O1mEE());
    label_76:
        ImeEditCommand_androidKt.imeDelete(arg11, TextRange.getEnd-impl(arg11.getSelection-d9O1mEE()), TextRange.getEnd-impl(arg11.getSelection-d9O1mEE()) + arg9);
        ImeEditCommand_androidKt.imeDelete(arg11, TextRange.getStart-impl(arg11.getSelection-d9O1mEE()) - v3, TextRange.getStart-impl(arg11.getSelection-d9O1mEE()));
        return Unit.INSTANCE;
    }

    public static final void finishComposingText(ImeEditCommandScope arg1) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda5());
    }

    static final Unit finishComposingText$lambda$0(TextFieldBuffer arg0) {
        arg0.commitComposition$foundation();
        return Unit.INSTANCE;
    }

    public static final void imeDelete(TextFieldBuffer arg7, int arg8, int arg9) {
        TextRange v0 = arg7.getComposition-MzsxiRA$foundation();
        int v1 = Math.min(arg8, arg9);
        arg8 = Math.max(arg8, arg9);
        TextFieldBufferKt.delete(arg7, v1, arg8);
        if(v0 != null) {
            v0.unbox-impl();
            long v8 = TextFieldBufferKt.adjustTextRange-vJH6DeI(v0.unbox-impl(), v1, arg8, 0);
            if(TextRange.getCollapsed-impl(v8)) {
                arg7.commitComposition$foundation();
                return;
            }
            else {
                TextFieldBuffer.setComposition$foundation$default(arg7, TextRange.getMin-impl(v8), TextRange.getMax-impl(v8), null, 4, null);
            }
        }
    }

    public static final void imeReplace(TextFieldBuffer arg6, int arg7, int arg8, CharSequence arg9) {
        int v0 = Math.min(arg7, arg8);
        arg7 = Math.max(arg7, arg8);
        arg8 = 0;
        int v1;
        for(v1 = v0; v1 < arg7; ++v1) {
            if(arg8 >= arg9.length()) {
                break;
            }

            if(arg9.charAt(arg8) != arg6.asCharSequence().charAt(v1)) {
                break;
            }

            ++arg8;
        }

        int v2 = arg9.length();
        while(arg7 > v1) {
            if(v2 <= arg8) {
                break;
            }

            if(arg9.charAt(v2 - 1) != arg6.asCharSequence().charAt(arg7 - 1)) {
                break;
            }

            --v2;
            --arg7;
        }

        if(v1 != arg7 || arg8 != v2) {
            arg6.replace(v1, arg7, arg9.subSequence(arg8, v2));
        }
        else {
            arg6.commitComposition$foundation();
            arg6.clearHighlight$foundation();
        }

        arg6.setSelection-5zc-tL8(TextRangeKt.TextRange(v0 + arg9.length()));
    }

    private static final boolean isSurrogatePair(char arg0, char arg1) {
        if((Character.isHighSurrogate(arg0)) && (Character.isLowSurrogate(arg1))) {
            return 1;
        }

        return 0;
    }

    public static final void setComposingRegion(ImeEditCommandScope arg1, int arg2, int arg3) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda6(arg2, arg3));
    }

    static final Unit setComposingRegion$lambda$0(int arg9, int arg10, TextFieldBuffer arg11) {
        if(arg11.hasComposition$foundation()) {
            arg11.commitComposition$foundation();
        }

        int v3 = RangesKt.coerceIn(arg9, 0, arg11.getLength());
        int v4 = RangesKt.coerceIn(arg10, 0, arg11.getLength());
        if(v3 != v4) {
            if(v3 < v4) {
                TextFieldBuffer.setComposition$foundation$default(arg11, v3, v4, null, 4, null);
            }
            else {
                TextFieldBuffer.setComposition$foundation$default(arg11, v4, v3, null, 4, null);
            }
        }

        return Unit.INSTANCE;
    }

    public static final void setComposingText(ImeEditCommandScope arg1, String arg2, int arg3, List arg4) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda2(arg2, arg4, arg3));
    }

    public static void setComposingText$default(ImeEditCommandScope arg0, String arg1, int arg2, List arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        ImeEditCommand_androidKt.setComposingText(arg0, arg1, arg2, arg3);
    }

    static final Unit setComposingText$lambda$0(String arg4, List arg5, int arg6, TextFieldBuffer arg7) {
        TextRange v0 = arg7.getComposition-MzsxiRA$foundation();
        if(v0 != null) {
            ImeEditCommand_androidKt.imeReplace(arg7, TextRange.getStart-impl(v0.unbox-impl()), TextRange.getEnd-impl(v0.unbox-impl()), arg4);
            if(arg4.length() > 0) {
                arg7.setComposition$foundation(TextRange.getStart-impl(v0.unbox-impl()), TextRange.getStart-impl(v0.unbox-impl()) + arg4.length(), arg5);
            }
        }
        else {
            int v0_1 = TextRange.getStart-impl(arg7.getSelection-d9O1mEE());
            ImeEditCommand_androidKt.imeReplace(arg7, v0_1, TextRange.getEnd-impl(arg7.getSelection-d9O1mEE()), arg4);
            if(arg4.length() > 0) {
                arg7.setComposition$foundation(v0_1, arg4.length() + v0_1, arg5);
            }
        }

        int v5 = TextRange.getStart-impl(arg7.getSelection-d9O1mEE());
        v5 = arg6 > 0 ? v5 + arg6 - 1 : v5 + arg6 - arg4.length();
        arg7.setSelection-5zc-tL8(TextRangeKt.TextRange(RangesKt.coerceIn(v5, 0, arg7.getLength())));
        return Unit.INSTANCE;
    }

    public static final void setSelection(ImeEditCommandScope arg1, int arg2, int arg3) {
        arg1.edit(new ImeEditCommand_androidKt$$ExternalSyntheticLambda1(arg1, arg2, arg3));
    }

    static final Unit setSelection$lambda$0(ImeEditCommandScope arg4, int arg5, int arg6, TextFieldBuffer arg7) {
        long v0 = arg4.mapToTransformed-GEjPoXI(TextRangeKt.TextRange(0, arg7.getLength()));
        int v2 = TextRange.getMin-impl(v0);
        int v3 = TextRange.getMax-impl(v0);
        if(arg5 < v2) {
            arg5 = v2;
        }

        if(arg5 > v3) {
        }
        else {
            v3 = arg5;
        }

        arg5 = TextRange.getMin-impl(v0);
        int v0_1 = TextRange.getMax-impl(v0);
        if(arg6 < arg5) {
            arg6 = arg5;
        }

        if(arg6 > v0_1) {
        }
        else {
            v0_1 = arg6;
        }

        arg7.setSelection-5zc-tL8(arg4.mapFromTransformed-GEjPoXI(TextRangeKt.TextRange(v3, v0_1)));
        return Unit.INSTANCE;
    }
}

