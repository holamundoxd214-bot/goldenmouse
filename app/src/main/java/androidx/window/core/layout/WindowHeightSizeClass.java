package androidx.window.core.layout;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="WindowHeightSizeClass will not be developed further, use WindowSizeClass instead.") @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/core/layout/WindowHeightSizeClass;", "", "rawValue", "", "<init>", "(I)V", "toString", "", "equals", "", "other", "hashCode", "Companion", "window-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowHeightSizeClass {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0001¢\u0006\u0002\b\u000ER\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003¨\u0006\u000F"}, d2={"Landroidx/window/core/layout/WindowHeightSizeClass$Companion;", "", "<init>", "()V", "COMPACT", "Landroidx/window/core/layout/WindowHeightSizeClass;", "getCOMPACT$annotations", "MEDIUM", "getMEDIUM$annotations", "EXPANDED", "getEXPANDED$annotations", "compute", "dpHeight", "", "compute$window_core", "window-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @Deprecated(message="WindowHeightSizeClass not be developed further.") public final WindowHeightSizeClass compute$window_core(float arg2) {
            if(arg2 >= 0f) {
                if(arg2 < 480f) {
                    return WindowHeightSizeClass.COMPACT;
                }

                if(arg2 < 900f) {
                    return WindowHeightSizeClass.MEDIUM;
                }

                return WindowHeightSizeClass.EXPANDED;
            }

            throw new IllegalArgumentException("Height must be positive, received " + arg2.toString());
        }

        @Deprecated(message="WindowHeightSizeClass not be developed further.") public static void getCOMPACT$annotations() {
        }

        @Deprecated(message="WindowHeightSizeClass not be developed further.") public static void getEXPANDED$annotations() {
        }

        @Deprecated(message="WindowHeightSizeClass not be developed further.") public static void getMEDIUM$annotations() {
        }
    }

    public static final WindowHeightSizeClass COMPACT;
    public static final Companion Companion;
    public static final WindowHeightSizeClass EXPANDED;
    public static final WindowHeightSizeClass MEDIUM;
    private final int rawValue;

    static {
        WindowHeightSizeClass.Companion = new Companion(null);
        WindowHeightSizeClass.COMPACT = new WindowHeightSizeClass(0);
        WindowHeightSizeClass.MEDIUM = new WindowHeightSizeClass(1);
        WindowHeightSizeClass.EXPANDED = new WindowHeightSizeClass(2);
    }

    private WindowHeightSizeClass(int arg1) {
        super();
        this.rawValue = arg1;
    }

    public boolean equals(Object arg5) {
        if(this == (((WindowHeightSizeClass)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(this.rawValue == ((WindowHeightSizeClass)arg5).rawValue) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.rawValue;
    }

    public String toString() {
        String v1;
        if(Intrinsics.areEqual(this, WindowHeightSizeClass.COMPACT)) {
            v1 = "COMPACT";
        }
        else if(Intrinsics.areEqual(this, WindowHeightSizeClass.MEDIUM)) {
            v1 = "MEDIUM";
        }
        else if(Intrinsics.areEqual(this, WindowHeightSizeClass.EXPANDED)) {
            v1 = "EXPANDED";
        }
        else {
            v1 = "UNKNOWN";
        }

        return "WindowHeightSizeClass: ".concat(v1);
    }
}

