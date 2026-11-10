package androidx.compose.ui.platform;

import android.content.ClipDescription;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/ClipMetadata;", "", "clipDescription", "Landroid/content/ClipDescription;", "<init>", "(Landroid/content/ClipDescription;)V", "getClipDescription", "()Landroid/content/ClipDescription;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClipMetadata {
    public static final int $stable = 8;
    private final ClipDescription clipDescription;

    static {
    }

    public ClipMetadata(ClipDescription arg1) {
        super();
        this.clipDescription = arg1;
    }

    public final ClipDescription getClipDescription() {
        return this.clipDescription;
    }
}

