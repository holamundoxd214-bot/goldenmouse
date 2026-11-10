package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u0000 \r2\u00020\u0001:\u0003\u000B\f\rJ\'\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/Alignment;", "", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Horizontal", "Vertical", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Alignment {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\bR\u001C\u0010\u000F\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001A\u0004\b\u0011\u0010\bR\u001C\u0010\u0012\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001A\u0004\b\u0014\u0010\bR\u001C\u0010\u0015\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\bR\u001C\u0010\u0018\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001A\u0004\b\u001A\u0010\bR\u001C\u0010\u001B\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001C\u0010\u0003\u001A\u0004\b\u001D\u0010\bR\u001C\u0010\u001E\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001F\u0010\u0003\u001A\u0004\b \u0010\bR\u001C\u0010!\u001A\u00020\"8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b#\u0010\u0003\u001A\u0004\b$\u0010%R\u001C\u0010&\u001A\u00020\"8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\'\u0010\u0003\u001A\u0004\b(\u0010%R\u001C\u0010)\u001A\u00020\"8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b*\u0010\u0003\u001A\u0004\b+\u0010%R\u001C\u0010,\u001A\u00020-8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b.\u0010\u0003\u001A\u0004\b/\u00100R\u001C\u00101\u001A\u00020-8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b2\u0010\u0003\u001A\u0004\b3\u00100R\u001C\u00104\u001A\u00020-8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b5\u0010\u0003\u001A\u0004\b6\u00100¨\u00067"}, d2={"Landroidx/compose/ui/Alignment$Companion;", "", "<init>", "()V", "TopStart", "Landroidx/compose/ui/Alignment;", "getTopStart$annotations", "getTopStart", "()Landroidx/compose/ui/Alignment;", "TopCenter", "getTopCenter$annotations", "getTopCenter", "TopEnd", "getTopEnd$annotations", "getTopEnd", "CenterStart", "getCenterStart$annotations", "getCenterStart", "Center", "getCenter$annotations", "getCenter", "CenterEnd", "getCenterEnd$annotations", "getCenterEnd", "BottomStart", "getBottomStart$annotations", "getBottomStart", "BottomCenter", "getBottomCenter$annotations", "getBottomCenter", "BottomEnd", "getBottomEnd$annotations", "getBottomEnd", "Top", "Landroidx/compose/ui/Alignment$Vertical;", "getTop$annotations", "getTop", "()Landroidx/compose/ui/Alignment$Vertical;", "CenterVertically", "getCenterVertically$annotations", "getCenterVertically", "Bottom", "getBottom$annotations", "getBottom", "Start", "Landroidx/compose/ui/Alignment$Horizontal;", "getStart$annotations", "getStart", "()Landroidx/compose/ui/Alignment$Horizontal;", "CenterHorizontally", "getCenterHorizontally$annotations", "getCenterHorizontally", "End", "getEnd$annotations", "getEnd", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final Vertical Bottom;
        private static final Alignment BottomCenter;
        private static final Alignment BottomEnd;
        private static final Alignment BottomStart;
        private static final Alignment Center;
        private static final Alignment CenterEnd;
        private static final Horizontal CenterHorizontally;
        private static final Alignment CenterStart;
        private static final Vertical CenterVertically;
        private static final Horizontal End;
        private static final Horizontal Start;
        private static final Vertical Top;
        private static final Alignment TopCenter;
        private static final Alignment TopEnd;
        private static final Alignment TopStart;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.TopStart = new BiasAlignment(-1f, -1f);
            Companion.TopCenter = new BiasAlignment(0f, -1f);
            Companion.TopEnd = new BiasAlignment(1f, -1f);
            Companion.CenterStart = new BiasAlignment(-1f, 0f);
            Companion.Center = new BiasAlignment(0f, 0f);
            Companion.CenterEnd = new BiasAlignment(1f, 0f);
            Companion.BottomStart = new BiasAlignment(-1f, 1f);
            Companion.BottomCenter = new BiasAlignment(0f, 1f);
            Companion.BottomEnd = new BiasAlignment(1f, 1f);
            Companion.Top = new androidx.compose.ui.BiasAlignment$Vertical(-1f);
            Companion.CenterVertically = new androidx.compose.ui.BiasAlignment$Vertical(0f);
            Companion.Bottom = new androidx.compose.ui.BiasAlignment$Vertical(1f);
            Companion.Start = new androidx.compose.ui.BiasAlignment$Horizontal(-1f);
            Companion.CenterHorizontally = new androidx.compose.ui.BiasAlignment$Horizontal(0f);
            Companion.End = new androidx.compose.ui.BiasAlignment$Horizontal(1f);
        }

        private Companion() {
            super();
        }

        public final Vertical getBottom() {
            return Companion.Bottom;
        }

        public static void getBottom$annotations() {
        }

        public final Alignment getBottomCenter() {
            return Companion.BottomCenter;
        }

        public static void getBottomCenter$annotations() {
        }

        public final Alignment getBottomEnd() {
            return Companion.BottomEnd;
        }

        public static void getBottomEnd$annotations() {
        }

        public final Alignment getBottomStart() {
            return Companion.BottomStart;
        }

        public static void getBottomStart$annotations() {
        }

        public final Alignment getCenter() {
            return Companion.Center;
        }

        public static void getCenter$annotations() {
        }

        public final Alignment getCenterEnd() {
            return Companion.CenterEnd;
        }

        public static void getCenterEnd$annotations() {
        }

        public final Horizontal getCenterHorizontally() {
            return Companion.CenterHorizontally;
        }

        public static void getCenterHorizontally$annotations() {
        }

        public final Alignment getCenterStart() {
            return Companion.CenterStart;
        }

        public static void getCenterStart$annotations() {
        }

        public final Vertical getCenterVertically() {
            return Companion.CenterVertically;
        }

        public static void getCenterVertically$annotations() {
        }

        public final Horizontal getEnd() {
            return Companion.End;
        }

        public static void getEnd$annotations() {
        }

        public final Horizontal getStart() {
            return Companion.Start;
        }

        public static void getStart$annotations() {
        }

        public final Vertical getTop() {
            return Companion.Top;
        }

        public static void getTop$annotations() {
        }

        public final Alignment getTopCenter() {
            return Companion.TopCenter;
        }

        public static void getTopCenter$annotations() {
        }

        public final Alignment getTopEnd() {
            return Companion.TopEnd;
        }

        public static void getTopEnd$annotations() {
        }

        public final Alignment getTopStart() {
            return Companion.TopStart;
        }

        public static void getTopStart$annotations() {
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0011\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/Alignment$Horizontal;", "", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Vertical;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Horizontal {
        int align(int arg1, int arg2, LayoutDirection arg3);

        default Alignment plus(Vertical arg2) {
            return new CombinedAlignment(this, arg2);
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H&J\u0011\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0096\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/Alignment$Vertical;", "", "align", "", "size", "space", "plus", "Landroidx/compose/ui/Alignment;", "other", "Landroidx/compose/ui/Alignment$Horizontal;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Vertical {
        int align(int arg1, int arg2);

        default Alignment plus(Horizontal arg2) {
            return new CombinedAlignment(arg2, this);
        }
    }

    public static final Companion Companion;

    static {
        Alignment.Companion = Companion.$$INSTANCE;
    }

    long align-KFBX0sM(long arg1, long arg2, LayoutDirection arg3);
}

