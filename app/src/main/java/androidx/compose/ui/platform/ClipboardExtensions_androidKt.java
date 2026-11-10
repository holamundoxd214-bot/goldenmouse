package androidx.compose.ui.platform;

import android.net.Uri;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2={"firstUriOrNull", "Landroid/net/Uri;", "Landroidx/compose/ui/platform/ClipEntry;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ClipboardExtensions_androidKt {
    public static final Uri firstUriOrNull(ClipEntry arg3) {
        int v0 = arg3.getClipData().getItemCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Uri v2 = arg3.getClipData().getItemAt(v1).getUri();
            if(v2 != null) {
                return v2;
            }
        }

        return null;
    }
}

