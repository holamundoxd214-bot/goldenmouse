package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.GraphemeClusterSegmentFinder;
import android.text.SegmentFinder;
import androidx.compose.ui.text.android.selection.Api34SegmentFinder;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\rH\u0000¢\u0006\u0002\b\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/android/AndroidLayoutApi34;", "", "<init>", "()V", "getRangeForRect", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "rectF", "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect$ui_text", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidLayoutApi34 {
    public static final int $stable;
    public static final AndroidLayoutApi34 INSTANCE;

    static {
        AndroidLayoutApi34.INSTANCE = new AndroidLayoutApi34();
    }

    private AndroidLayoutApi34() {
        super();
    }

    static final boolean getRangeForRect$lambda$0(Function2 arg0, RectF arg1, RectF arg2) {
        return arg0.invoke(arg1, arg2).booleanValue();
    }

    public final int[] getRangeForRect$ui_text(TextLayout arg3, RectF arg4, int arg5, Function2 arg6) {
        GraphemeClusterSegmentFinder v2_1;
        if(arg5 == 1) {
            SegmentFinder v2 = Api34SegmentFinder.INSTANCE.toAndroidSegmentFinder$ui_text(new WordSegmentFinder(arg3.getText(), arg3.getWordIterator()));
        }
        else {
            v2_1 = new GraphemeClusterSegmentFinder(arg3.getText(), arg3.getTextPaint());
        }

        return arg3.getLayout().getRangeForRect(arg4, ((SegmentFinder)v2_1), new AndroidLayoutApi34$$ExternalSyntheticLambda0(arg6));
    }
}

