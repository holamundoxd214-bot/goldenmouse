package androidx.compose.ui.text.android.selection;

import android.os.Build$VERSION;
import android.text.TextPaint;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"createGraphemeClusterSegmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SegmentFinder_androidKt {
    public static final SegmentFinder createGraphemeClusterSegmentFinder(CharSequence arg2, TextPaint arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            return new GraphemeClusterSegmentFinderApi29(arg2, arg3);
        }

        return new GraphemeClusterSegmentFinderUnderApi29(arg2);
    }
}

