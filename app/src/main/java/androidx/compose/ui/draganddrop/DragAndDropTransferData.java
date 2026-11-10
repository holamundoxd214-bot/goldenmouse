package androidx.compose.ui.draganddrop;

import android.content.ClipData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "", "clipData", "Landroid/content/ClipData;", "localState", "flags", "", "<init>", "(Landroid/content/ClipData;Ljava/lang/Object;I)V", "getClipData", "()Landroid/content/ClipData;", "getLocalState", "()Ljava/lang/Object;", "getFlags", "()I", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragAndDropTransferData {
    public static final int $stable = 8;
    private final ClipData clipData;
    private final int flags;
    private final Object localState;

    static {
    }

    public DragAndDropTransferData(ClipData arg1, Object arg2, int arg3) {
        super();
        this.clipData = arg1;
        this.localState = arg2;
        this.flags = arg3;
    }

    public DragAndDropTransferData(ClipData arg1, Object arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, 0);
    }

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final Object getLocalState() {
        return this.localState;
    }
}

