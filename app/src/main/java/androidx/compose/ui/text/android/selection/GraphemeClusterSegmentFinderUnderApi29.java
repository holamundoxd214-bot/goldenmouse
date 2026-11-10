package androidx.compose.ui.text.android.selection;

import java.text.BreakIterator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016J\u0010\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderUnderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "<init>", "(Ljava/lang/CharSequence;)V", "breakIterator", "Ljava/text/BreakIterator;", "kotlin.jvm.PlatformType", "previous", "", "offset", "next", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphemeClusterSegmentFinderUnderApi29 extends GraphemeClusterSegmentFinder {
    public static final int $stable = 8;
    private final BreakIterator breakIterator;
    private final CharSequence text;

    static {
    }

    public GraphemeClusterSegmentFinderUnderApi29(CharSequence arg2) {
        super();
        this.text = arg2;
        BreakIterator v0 = BreakIterator.getCharacterInstance();
        v0.setText(arg2.toString());
        this.breakIterator = v0;
    }

    public int next(int arg1) {
        return this.breakIterator.following(arg1);
    }

    public int previous(int arg1) {
        return this.breakIterator.preceding(arg1);
    }
}

