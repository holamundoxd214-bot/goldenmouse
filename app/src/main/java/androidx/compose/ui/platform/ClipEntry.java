package androidx.compose.ui.platform;

import android.content.ClipData;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/platform/ClipEntry;", "", "clipData", "Landroid/content/ClipData;", "<init>", "(Landroid/content/ClipData;)V", "getClipData", "()Landroid/content/ClipData;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClipEntry {
    public static final int $stable = 8;
    private final ClipData clipData;

    static {
    }

    public ClipEntry(ClipData arg1) {
        super();
        this.clipData = arg1;
    }

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final ClipMetadata getClipMetadata() {
        return AndroidClipboardManager_androidKt.toClipMetadata(this.clipData.getDescription());
    }
}

