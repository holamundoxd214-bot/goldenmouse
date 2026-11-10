package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&J\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&J\u0010\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/android/selection/SegmentFinder;", "", "previousStartBoundary", "", "offset", "previousEndBoundary", "nextStartBoundary", "nextEndBoundary", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SegmentFinder {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/ui/text/android/selection/SegmentFinder$Companion;", "", "<init>", "()V", "DONE", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static final int DONE = -1;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int DONE = -1;

    static {
        SegmentFinder.Companion = Companion.$$INSTANCE;
    }

    int nextEndBoundary(int arg1);

    int nextStartBoundary(int arg1);

    int previousEndBoundary(int arg1);

    int previousStartBoundary(int arg1);
}

