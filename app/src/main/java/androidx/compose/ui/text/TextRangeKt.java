package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\u001A\u0019\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001B\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0002\u0010\u000B\u001A\u0013\u0010\u0007\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\t¢\u0006\u0002\u0010\r\u001A!\u0010\u000E\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0002¨\u0006\u0015"}, d2={"substring", "", "", "range", "Landroidx/compose/ui/text/TextRange;", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "TextRange", "start", "", "end", "(II)J", "index", "(I)J", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "packWithCheck", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextRangeKt {
    public static final long TextRange(int arg0, int arg1) {
        return TextRange.constructor-impl(TextRangeKt.packWithCheck(arg0, arg1));
    }

    public static final long TextRange(int arg2) {
        return TextRangeKt.TextRange(arg2, arg2);
    }

    public static final long coerceIn-8ffj60Q(long arg2, int arg4, int arg5) {
        int v0 = TextRange.getStart-impl(arg2);
        if(v0 < arg4) {
            v0 = arg4;
        }

        if(v0 > arg5) {
            v0 = arg5;
        }

        int v1 = TextRange.getEnd-impl(arg2);
        if(v1 < arg4) {
        }
        else {
            arg4 = v1;
        }

        if(arg4 > arg5) {
        }
        else {
            arg5 = arg4;
        }

        if(v0 == TextRange.getStart-impl(arg2)) {
            if(arg5 != TextRange.getEnd-impl(arg2)) {
            }
            else {
                return arg2;
            }
        }

        return TextRangeKt.TextRange(v0, arg5);
    }

    private static final long packWithCheck(int arg4, int arg5) {
        int v0 = arg4 < 0 || arg5 < 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start and end cannot be negative. [start: " + arg4 + ", end: " + arg5 + ']');
        }

        return (((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20;
    }

    public static final String substring-FDrldGo(CharSequence arg1, long arg2) {
        return arg1.subSequence(TextRange.getMin-impl(arg2), TextRange.getMax-impl(arg2)).toString();
    }
}

