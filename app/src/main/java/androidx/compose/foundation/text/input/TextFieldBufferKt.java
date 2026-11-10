package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A/\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\u001A\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000E\u001A\u001A\u0010\u000F\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0004\u001A\n\u0010\u0012\u001A\u00020\n*\u00020\u000B\u001A\n\u0010\u0013\u001A\u00020\n*\u00020\u000B\u001AE\u0010\u0014\u001A\u00020\n*\u00020\u001526\u0010\u0016\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001AE\u0010\u001B\u001A\u00020\n*\u00020\u001526\u0010\u0016\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001A{\u0010\u001C\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2`\u0010 \u001A\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0!H\u0080\b\u001A\u001E\u0010&\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00042\b\b\u0002\u0010\u0011\u001A\u00020\u0004H\u0000¨\u0006\'"}, d2={"adjustTextRange", "Landroidx/compose/ui/text/TextRange;", "originalRange", "replaceStart", "", "replaceEnd", "insertedTextLength", "adjustTextRange-vJH6DeI", "(JIII)J", "insert", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "index", "text", "", "delete", "start", "end", "placeCursorAtEnd", "selectAll", "forEachChange", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "range", "forEachChangeReversed", "findCommonPrefixAndSuffix", "a", "", "b", "onFound", "Lkotlin/Function4;", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "setSelectionCoerced", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldBufferKt {
    public static final long adjustTextRange-vJH6DeI(long arg2, int arg4, int arg5, int arg6) {
        int v0 = TextRange.getMin-impl(arg2);
        int v1 = TextRange.getMax-impl(arg2);
        if(v1 < arg4) {
            return arg2;
        }

        if(v0 > arg4 || arg5 > v1) {
            if(v0 > arg4 && v1 < arg5) {
                arg4 += arg6;
                v0 = arg4;
                goto label_26;
            }

            if(v0 >= arg5) {
                arg6 -= arg5 - arg4;
            label_18:
                v0 += arg6;
                goto label_19;
            }

            if(arg4 >= v0) {
                goto label_26;
            }

            v0 = arg4 + arg6;
            arg6 -= arg5 - arg4;
        label_19:
            arg4 = v1 + arg6;
        }
        else {
            arg6 -= arg5 - arg4;
            if(v0 == v1) {
                goto label_18;
            }
            else {
                goto label_19;
            }
        }

    label_26:
        return TextRangeKt.TextRange(v0, arg4);
    }

    public static final void delete(TextFieldBuffer arg1, int arg2, int arg3) {
        arg1.replace(arg2, arg3, "");
    }

    public static final void findCommonPrefixAndSuffix(CharSequence arg9, CharSequence arg10, Function4 arg11) {
        int v4;
        int v0 = arg9.length();
        int v1 = arg10.length();
        int v3 = 0;
        if(arg9.length() <= 0 || arg10.length() <= 0) {
            v4 = 0;
        }
        else {
            int v2 = 0;
            v4 = 0;
            int v5 = 0;
            do {
            label_10:
                if(v3 == 0) {
                    if(arg9.charAt(v2) == arg10.charAt(v4)) {
                        ++v2;
                        ++v4;
                    }
                    else {
                        v3 = 1;
                    }
                }

                if(v5 == 0) {
                    if(arg9.charAt(v0 - 1) == arg10.charAt(v1 - 1)) {
                        --v0;
                        --v1;
                    }
                    else {
                        v5 = 1;
                    }
                }

                if(v2 >= v0) {
                    break;
                }

                if(v4 >= v1) {
                    break;
                }

                if(v3 == 0) {
                    goto label_10;
                }
            }
            while(v5 == 0);

            v3 = v2;
        }

        if(v3 >= v0 && v4 >= v1) {
            return;
        }

        arg11.invoke(Integer.valueOf(v3), Integer.valueOf(v0), Integer.valueOf(v4), Integer.valueOf(v1));
    }

    public static final void forEachChange(ChangeList arg4, Function2 arg5) {
        int v0;
        for(v0 = 0; v0 < arg4.getChangeCount(); ++v0) {
            arg5.invoke(TextRange.box-impl(arg4.getRange--jx7JFs(v0)), TextRange.box-impl(arg4.getOriginalRange--jx7JFs(v0)));
        }
    }

    public static final void forEachChangeReversed(ChangeList arg4, Function2 arg5) {
        int v0;
        for(v0 = arg4.getChangeCount() - 1; v0 >= 0; --v0) {
            arg5.invoke(TextRange.box-impl(arg4.getRange--jx7JFs(v0)), TextRange.box-impl(arg4.getOriginalRange--jx7JFs(v0)));
        }
    }

    public static final void insert(TextFieldBuffer arg0, int arg1, String arg2) {
        arg0.replace(arg1, arg1, ((CharSequence)arg2));
    }

    public static final void placeCursorAtEnd(TextFieldBuffer arg1) {
        arg1.placeCursorBeforeCharAt(arg1.getLength());
    }

    public static final void selectAll(TextFieldBuffer arg2) {
        arg2.setSelection-5zc-tL8(TextRangeKt.TextRange(0, arg2.getLength()));
    }

    public static final void setSelectionCoerced(TextFieldBuffer arg2, int arg3, int arg4) {
        arg2.setSelection-5zc-tL8(TextRangeKt.TextRange(RangesKt.coerceIn(arg3, 0, arg2.getLength()), RangesKt.coerceIn(arg4, 0, arg2.getLength())));
    }

    public static void setSelectionCoerced$default(TextFieldBuffer arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg1;
        }

        TextFieldBufferKt.setSelectionCoerced(arg0, arg1, arg2);
    }
}

