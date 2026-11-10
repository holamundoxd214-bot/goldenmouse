package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&J\u0010\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016J\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¨\u0006\f"}, d2={"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "<init>", "()V", "previous", "", "offset", "next", "previousStartBoundary", "previousEndBoundary", "nextStartBoundary", "nextEndBoundary", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    public static final int $stable;

    static {
    }

    public GraphemeClusterSegmentFinder() {
        super();
    }

    public abstract int next(int arg1);

    public int nextEndBoundary(int arg1) {
        return this.next(arg1);
    }

    public int nextStartBoundary(int arg2) {
        arg2 = this.next(arg2);
        int v0 = -1;
        if(arg2 == v0) {
            return v0;
        }

        if(this.next(arg2) == v0) {
            return v0;
        }

        return arg2;
    }

    public abstract int previous(int arg1);

    public int previousEndBoundary(int arg2) {
        arg2 = this.previous(arg2);
        int v0 = -1;
        if(arg2 == v0) {
            return v0;
        }

        if(this.previous(arg2) == v0) {
            return v0;
        }

        return arg2;
    }

    public int previousStartBoundary(int arg1) {
        return this.previous(arg1);
    }
}

