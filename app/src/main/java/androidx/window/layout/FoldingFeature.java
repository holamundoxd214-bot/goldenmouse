package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u00020\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/window/layout/FoldingFeature;", "Landroidx/window/layout/DisplayFeature;", "isSeparating", "", "()Z", "occlusionType", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$OcclusionType;", "orientation", "Landroidx/window/layout/FoldingFeature$Orientation;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$Orientation;", "state", "Landroidx/window/layout/FoldingFeature$State;", "getState", "()Landroidx/window/layout/FoldingFeature$State;", "OcclusionType", "Orientation", "State", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FoldingFeature extends DisplayFeature {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/layout/FoldingFeature$OcclusionType;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OcclusionType {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/window/layout/FoldingFeature$OcclusionType$Companion;", "", "<init>", "()V", "NONE", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "FULL", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }
        }

        public static final Companion Companion;
        public static final OcclusionType FULL;
        public static final OcclusionType NONE;
        private final String description;

        static {
            OcclusionType.Companion = new Companion(null);
            OcclusionType.NONE = new OcclusionType("NONE");
            OcclusionType.FULL = new OcclusionType("FULL");
        }

        private OcclusionType(String arg1) {
            super();
            this.description = arg1;
        }

        public String toString() {
            return this.description;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/layout/FoldingFeature$Orientation;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Orientation {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/window/layout/FoldingFeature$Orientation$Companion;", "", "<init>", "()V", "VERTICAL", "Landroidx/window/layout/FoldingFeature$Orientation;", "HORIZONTAL", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.layout.FoldingFeature$Orientation$Companion {
            public androidx.window.layout.FoldingFeature$Orientation$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.layout.FoldingFeature$Orientation$Companion() {
                super();
            }
        }

        public static final androidx.window.layout.FoldingFeature$Orientation$Companion Companion;
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;
        private final String description;

        static {
            Orientation.Companion = new androidx.window.layout.FoldingFeature$Orientation$Companion(null);
            Orientation.VERTICAL = new Orientation("VERTICAL");
            Orientation.HORIZONTAL = new Orientation("HORIZONTAL");
        }

        private Orientation(String arg1) {
            super();
            this.description = arg1;
        }

        public String toString() {
            return this.description;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/layout/FoldingFeature$State;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class State {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/window/layout/FoldingFeature$State$Companion;", "", "<init>", "()V", "FLAT", "Landroidx/window/layout/FoldingFeature$State;", "HALF_OPENED", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.layout.FoldingFeature$State$Companion {
            public androidx.window.layout.FoldingFeature$State$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.layout.FoldingFeature$State$Companion() {
                super();
            }
        }

        public static final androidx.window.layout.FoldingFeature$State$Companion Companion;
        public static final State FLAT;
        public static final State HALF_OPENED;
        private final String description;

        static {
            State.Companion = new androidx.window.layout.FoldingFeature$State$Companion(null);
            State.FLAT = new State("FLAT");
            State.HALF_OPENED = new State("HALF_OPENED");
        }

        private State(String arg1) {
            super();
            this.description = arg1;
        }

        public String toString() {
            return this.description;
        }
    }

    OcclusionType getOcclusionType();

    Orientation getOrientation();

    State getState();

    boolean isSeparating();
}

