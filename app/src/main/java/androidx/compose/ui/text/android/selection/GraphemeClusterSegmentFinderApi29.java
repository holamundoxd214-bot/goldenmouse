package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u0010\u0010\u000B\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "<init>", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;)V", "previous", "", "offset", "next", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphemeClusterSegmentFinderApi29 extends GraphemeClusterSegmentFinder {
    public static final int $stable = 8;
    private final CharSequence text;
    private final TextPaint textPaint;

    static {
    }

    public GraphemeClusterSegmentFinderApi29(CharSequence arg1, TextPaint arg2) {
        super();
        this.text = arg1;
        this.textPaint = arg2;
    }

    public int next(int arg8) {
        return this.textPaint.getTextRunCursor(this.text, 0, this.text.length(), false, arg8, 0);
    }

    public int previous(int arg8) {
        return this.textPaint.getTextRunCursor(this.text, 0, this.text.length(), false, arg8, 2);
    }
}

