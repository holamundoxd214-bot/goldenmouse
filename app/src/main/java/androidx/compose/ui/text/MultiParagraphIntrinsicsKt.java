package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002¨\u0006\u0007"}, d2={"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MultiParagraphIntrinsicsKt {
    public static final List access$getLocalPlaceholders(List arg0, int arg1, int arg2) {
        return MultiParagraphIntrinsicsKt.getLocalPlaceholders(arg0, arg1, arg2);
    }

    private static final List getLocalPlaceholders(List arg9, int arg10, int arg11) {
        ArrayList v0 = new ArrayList(arg9.size());
        int v1 = arg9.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = arg9.get(v3);
            if(AnnotatedStringKt.intersect(arg10, arg11, ((Range)v4).getStart(), ((Range)v4).getEnd())) {
                ArrayList v5 = v0;
                int v6 = arg10 > ((Range)v4).getStart() || ((Range)v4).getEnd() > arg11 ? 0 : 1;
                if(v6 == 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("placeholder can not overlap with paragraph.");
                }

                ((Collection)v5).add(new Range(((Range)v4).getItem(), ((Range)v4).getStart() - arg10, ((Range)v4).getEnd() - arg10));
            }
        }

        return ((List)v0);
    }
}

