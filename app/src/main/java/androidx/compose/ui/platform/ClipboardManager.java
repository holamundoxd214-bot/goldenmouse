package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="Use Clipboard instead, which supports suspend functions.", replaceWith="<_subannotation>") @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\n\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001A\u00020\bH\u0016J\n\u0010\t\u001A\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000B\u001A\u00020\u00032\b\u0010\f\u001A\u0004\u0018\u00010\nH\u0016R\u0018\u0010\r\u001A\u00060\u000Ej\u0002`\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/ClipboardManager;", "", "setText", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "getText", "hasText", "", "getClip", "Landroidx/compose/ui/platform/ClipEntry;", "setClip", "clipEntry", "nativeClipboard", "Landroid/content/ClipboardManager;", "Landroidx/compose/ui/platform/NativeClipboard;", "getNativeClipboard", "()Landroid/content/ClipboardManager;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ClipboardManager {
    default ClipEntry getClip() {
        return null;
    }

    default android.content.ClipboardManager getNativeClipboard() {
        throw new UnsupportedOperationException("This platform does not offer a native Clipboard");
    }

    AnnotatedString getText();

    default boolean hasText() {
        AnnotatedString v1 = this.getText();
        if(v1 != null && ((CharSequence)v1).length() > 0) {
            return 1;
        }

        return 0;
    }

    default void setClip(ClipEntry arg1) {
    }

    void setText(AnnotatedString arg1);
}

