package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/layout/SupportedPosture;", "", "rawValue", "", "<init>", "(I)V", "toString", "", "equals", "", "other", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SupportedPosture {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/window/layout/SupportedPosture$Companion;", "", "<init>", "()V", "TABLETOP", "Landroidx/window/layout/SupportedPosture;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    public static final SupportedPosture TABLETOP;
    private final int rawValue;

    static {
        SupportedPosture.Companion = new Companion(null);
        SupportedPosture.TABLETOP = new SupportedPosture(0);
    }

    public SupportedPosture(int arg1) {
        super();
        this.rawValue = arg1;
    }

    public boolean equals(Object arg5) {
        if(this == (((SupportedPosture)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(arg5.getClass() != SupportedPosture.class) {
            return 0;
        }

        if(this.rawValue == ((SupportedPosture)arg5).rawValue) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.rawValue;
    }

    public String toString() {
        if(Intrinsics.areEqual(this, SupportedPosture.TABLETOP)) {
            return "TABLETOP";
        }

        return "UNKNOWN";
    }
}

