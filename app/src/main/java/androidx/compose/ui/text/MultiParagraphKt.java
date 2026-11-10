package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u001E\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u001E\u0010\u0006\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001A\u00020\bH\u0000\u001A9\u0010\t\u001A\u00020\n2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u000EH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u001E\u0010\u0011\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001A\u00020\u0001H\u0000\u001A-\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u00032\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00010\u000EH\u0082\b¨\u0006\u0016"}, d2={"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByY", "y", "", "findParagraphsByRange", "", "range", "Landroidx/compose/ui/text/TextRange;", "action", "Lkotlin/Function1;", "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLkotlin/jvm/functions/Function1;)V", "findParagraphByLineIndex", "lineIndex", "fastBinarySearch", "T", "comparison", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MultiParagraphKt {
    public static CharSequence $r8$lambda$bLCwxSdGMc8HhOHdC5nKm2_zQzM(ParagraphInfo arg0) {
        return MultiParagraphKt.findParagraphByIndex$lambda$2$0(arg0);
    }

    private static final int fastBinarySearch(List arg4, Function1 arg5) {
        int v2;
        int v0 = arg4.size() - 1;
        int v1 = 0;
        while(true) {
            if(v1 > v0) {
                goto label_16;
            }

            v2 = v1 + v0 >>> 1;
            int v3 = arg5.invoke(arg4.get(v2)).intValue();
            if(v3 < 0) {
                v1 = v2 + 1;
                continue;
            }

            if(v3 <= 0) {
                return v2;
            }

            v0 = v2 - 1;
        }

        return v2;
    label_16:
        return -(v1 + 1);
    }

    public static final int findParagraphByIndex(List arg14, int arg15) {
        int v5_1;
        int v4;
        int v0 = CollectionsKt.last(arg14).getEndIndex();
        int v2 = 0;
        int v1 = arg15 <= CollectionsKt.last(arg14).getEndIndex() ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Index " + arg15 + " should be less or equal than last line\'s end " + v0);
        }

        v0 = arg14.size() - 1;
        v1 = 0;
        while(v1 <= v0) {
            v4 = v1 + v0 >>> 1;
            Object v5 = arg14.get(v4);
            if(((ParagraphInfo)v5).getStartIndex() > arg15) {
                v5_1 = 1;
            }
            else if(((ParagraphInfo)v5).getEndIndex() <= arg15) {
                v5_1 = -1;
            }
            else {
                v5_1 = 0;
            }

            if(v5_1 < 0) {
                v1 = v4 + 1;
                continue;
            }

            if(v5_1 <= 0) {
                goto label_44;
            }

            v0 = v4 - 1;
        }

        v4 = -(v1 + 1);
    label_44:
        if(v4 >= 0 && v4 < arg14.size()) {
            v2 = 1;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Found paragraph index " + v4 + " should be in range [0, " + arg14.size() + ").\nDebug info: index=" + arg15 + ", paragraphs=[" + ListUtilsKt.fastJoinToString$default(arg14, null, null, null, 0, null, new MultiParagraphKt$$ExternalSyntheticLambda0(), 0x1F, null) + ']');
        }

        return v4;
    }

    private static final CharSequence findParagraphByIndex$lambda$2$0(ParagraphInfo arg2) {
        return "[" + arg2.getStartIndex() + ", " + arg2.getEndIndex() + ')';
    }

    public static final int findParagraphByLineIndex(List arg7, int arg8) {
        int v5_1;
        int v4;
        int v0 = arg7.size() - 1;
        int v3 = 0;
        while(true) {
            if(v3 > v0) {
                goto label_25;
            }

            v4 = v3 + v0 >>> 1;
            Object v5 = arg7.get(v4);
            if(((ParagraphInfo)v5).getStartLineIndex() > arg8) {
                v5_1 = 1;
            }
            else if(((ParagraphInfo)v5).getEndLineIndex() <= arg8) {
                v5_1 = -1;
            }
            else {
                v5_1 = 0;
            }

            if(v5_1 < 0) {
                v3 = v4 + 1;
                continue;
            }

            if(v5_1 <= 0) {
                return v4;
            }

            v0 = v4 - 1;
        }

        return v4;
    label_25:
        return -(v3 + 1);
    }

    public static final int findParagraphByY(List arg7, float arg8) {
        int v5_1;
        int v4;
        if(Float.compare(arg8, 0f) <= 0) {
            return 0;
        }

        if(arg8 >= CollectionsKt.last(arg7).getBottom()) {
            return CollectionsKt.getLastIndex(arg7);
        }

        int v0 = arg7.size() - 1;
        int v3 = 0;
        while(true) {
            if(v3 > v0) {
                goto label_34;
            }

            v4 = v3 + v0 >>> 1;
            Object v5 = arg7.get(v4);
            if(((ParagraphInfo)v5).getTop() > arg8) {
                v5_1 = 1;
            }
            else if(((ParagraphInfo)v5).getBottom() <= arg8) {
                v5_1 = -1;
            }
            else {
                v5_1 = 0;
            }

            if(v5_1 < 0) {
                v3 = v4 + 1;
                continue;
            }

            if(v5_1 <= 0) {
                return v4;
            }

            v0 = v4 - 1;
        }

        return v4;
    label_34:
        return -(v3 + 1);
    }

    public static final void findParagraphsByRange-Sb-Bc2M(List arg5, long arg6, Function1 arg8) {
        int v0 = MultiParagraphKt.findParagraphByIndex(arg5, TextRange.getMin-impl(arg6));
        int v1 = arg5.size();
        while(v0 < v1) {
            Object v2 = arg5.get(v0);
            if(((ParagraphInfo)v2).getStartIndex() >= TextRange.getMax-impl(arg6)) {
                return;
            }

            if(((ParagraphInfo)v2).getStartIndex() != ((ParagraphInfo)v2).getEndIndex()) {
                arg8.invoke(v2);
            }

            ++v0;
        }
    }
}

