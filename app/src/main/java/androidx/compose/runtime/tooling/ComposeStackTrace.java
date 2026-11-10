package androidx.compose.runtime.tooling;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/runtime/tooling/ComposeStackTrace;", "", "frames", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "hasSourceInformation", "", "<init>", "(Ljava/util/List;Z)V", "getFrames", "()Ljava/util/List;", "getHasSourceInformation", "()Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposeStackTrace {
    public static final int $stable = 8;
    private final List frames;
    private final boolean hasSourceInformation;

    static {
    }

    public ComposeStackTrace(List arg1, boolean arg2) {
        super();
        this.frames = arg1;
        this.hasSourceInformation = arg2;
    }

    public final List getFrames() {
        return this.frames;
    }

    public final boolean getHasSourceInformation() {
        return this.hasSourceInformation;
    }
}

