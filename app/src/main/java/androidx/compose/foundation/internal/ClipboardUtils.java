package androidx.compose.foundation.internal;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ClipDescription;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0014\u0010\n\u001A\u0004\u0018\u00010\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\tH\u0007J\u0012\u0010\f\u001A\u00020\r2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/internal/ClipboardUtils;", "", "<init>", "()V", "readText", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "readAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "toClipEntry", "annotatedString", "hasText", "", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClipboardUtils {
    public static final int $stable;
    public static final ClipboardUtils INSTANCE;

    static {
        ClipboardUtils.INSTANCE = new ClipboardUtils();
    }

    private ClipboardUtils() {
        super();
    }

    @JvmStatic public static final boolean hasText(Clipboard arg2) {
        ClipDescription v2 = arg2.getNativeClipboard().getPrimaryClipDescription();
        if(v2 != null && (v2.hasMimeType("text/*"))) {
            return 1;
        }

        return 0;
    }

    @JvmStatic public static final boolean hasText(ClipEntry arg1) {
        if(arg1 == null) {
            return 0;
        }

        return arg1.getClipData().getDescription().hasMimeType("text/*");
    }

    @JvmStatic public static final AnnotatedString readAnnotatedString(ClipEntry arg1) {
        ClipData$Item v1 = arg1.getClipData().getItemAt(0);
        if(v1 != null) {
            CharSequence v1_1 = v1.getText();
            if(v1_1 != null) {
                return ClipboardUtils_androidKt.convertToAnnotatedString(v1_1);
            }
        }

        return null;
    }

    @JvmStatic public static final String readText(ClipEntry arg1) {
        ClipData$Item v1 = arg1.getClipData().getItemAt(0);
        if(v1 != null) {
            CharSequence v1_1 = v1.getText();
            if(v1_1 != null) {
                return v1_1.toString();
            }
        }

        return null;
    }

    @JvmStatic public static final ClipEntry toClipEntry(AnnotatedString arg2) {
        if(arg2 == null) {
            return null;
        }

        return new ClipEntry(ClipData.newPlainText("plain text", ClipboardUtils_androidKt.convertToCharSequence(arg2)));
    }
}

