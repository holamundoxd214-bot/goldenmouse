package androidx.compose.foundation.text.input.internal.selection;

import android.content.ClipDescription;
import androidx.compose.ui.platform.Clipboard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000E\u001A\u00020\u000FH\u0086@¢\u0006\u0002\u0010\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/ui/platform/Clipboard;)V", "_hasClip", "", "_hasText", "hasText", "getHasText", "()Z", "hasClip", "getHasClip", "update", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClipboardPasteState {
    public static final int $stable = 8;
    private boolean _hasClip;
    private boolean _hasText;
    private final Clipboard clipboard;

    static {
    }

    public ClipboardPasteState(Clipboard arg1) {
        super();
        this.clipboard = arg1;
    }

    public final boolean getHasClip() {
        return this._hasClip;
    }

    public final boolean getHasText() {
        return this._hasText;
    }

    public final Object update(Continuation arg2) {
        boolean v0;
        boolean v2 = this.clipboard.getNativeClipboard().hasPrimaryClip();
        this._hasClip = v2;
        if(v2) {
            ClipDescription v2_1 = this.clipboard.getNativeClipboard().getPrimaryClipDescription();
            if(v2_1 != null) {
                v0 = true;
                if(v2_1.hasMimeType("text/*")) {
                }
                else {
                    goto label_14;
                }
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            v0 = false;
        }

        this._hasText = v0;
        return Unit.INSTANCE;
    }
}

