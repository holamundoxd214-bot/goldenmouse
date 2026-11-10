package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\fR\u001E\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\n\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "", "<init>", "()V", "cachedX", "", "getCachedX", "()Ljava/lang/Float;", "setCachedX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "resetCachedX", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextPreparedSelectionState {
    public static final int $stable = 8;
    private Float cachedX;

    static {
    }

    public TextPreparedSelectionState() {
        super();
    }

    public final Float getCachedX() {
        return this.cachedX;
    }

    public final void resetCachedX() {
        this.cachedX = null;
    }

    public final void setCachedX(Float arg1) {
        this.cachedX = arg1;
    }
}

