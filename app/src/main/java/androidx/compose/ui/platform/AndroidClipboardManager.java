package androidx.compose.ui.platform;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Build$VERSION;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\n\u0010\r\u001A\u0004\u0018\u00010\fH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\n\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0011H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001A\u00060\u0003j\u0002`\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2={"Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroid/content/ClipboardManager;", "<init>", "(Landroid/content/ClipboardManager;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setText", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "getText", "hasText", "", "getClip", "Landroidx/compose/ui/platform/ClipEntry;", "setClip", "clipEntry", "nativeClipboard", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidClipboardManager implements ClipboardManager {
    public static final int $stable = 8;
    private final android.content.ClipboardManager clipboardManager;

    static {
    }

    public AndroidClipboardManager(Context arg2) {
        Object v2 = arg2.getSystemService("clipboard");
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.content.ClipboardManager");
        this(((android.content.ClipboardManager)v2));
    }

    public AndroidClipboardManager(android.content.ClipboardManager arg1) {
        super();
        this.clipboardManager = arg1;
    }

    public ClipEntry getClip() {
        ClipData v1 = this.clipboardManager.getPrimaryClip();
        if(v1 != null) {
            return new ClipEntry(v1);
        }

        return null;
    }

    public android.content.ClipboardManager getNativeClipboard() {
        return this.clipboardManager;
    }

    public AnnotatedString getText() {
        ClipData v2 = this.clipboardManager.getPrimaryClip();
        CharSequence v0 = null;
        if(v2 != null && v2.getItemCount() > 0) {
            ClipData$Item v2_1 = v2.getItemAt(0);
            if(v2_1 != null) {
                v0 = v2_1.getText();
            }

            return AndroidClipboardManager_androidKt.convertToAnnotatedString(v0);
        }

        return ((AnnotatedString)v0);
    }

    public boolean hasText() {
        ClipDescription v1 = this.clipboardManager.getPrimaryClipDescription();
        if(v1 != null) {
            return v1.hasMimeType("text/*");
        }

        return 0;
    }

    public void setClip(ClipEntry arg2) {
        if(arg2 == null) {
            int v2 = Build$VERSION.SDK_INT;
            android.content.ClipboardManager v1 = this.clipboardManager;
            if(v2 >= 28) {
                Api28ClipboardManagerClipClear.clearPrimaryClip(v1);
                return;
            }

            v1.setPrimaryClip(ClipData.newPlainText("", ""));
            return;
        }

        this.clipboardManager.setPrimaryClip(arg2.getClipData());
    }

    public void setText(AnnotatedString arg2) {
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText("plain text", AndroidClipboardManager_androidKt.convertToCharSequence(arg2)));
    }
}

