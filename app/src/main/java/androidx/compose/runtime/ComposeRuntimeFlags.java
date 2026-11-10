package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/runtime/ComposeRuntimeFlags;", "", "<init>", "()V", "isLinkBufferComposerEnabled", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposeRuntimeFlags {
    public static final int $stable;
    public static final ComposeRuntimeFlags INSTANCE;
    public static boolean isLinkBufferComposerEnabled;

    static {
        ComposeRuntimeFlags.INSTANCE = new ComposeRuntimeFlags();
        ComposeRuntimeFlags.$stable = 8;
    }

    private ComposeRuntimeFlags() {
        super();
    }
}

