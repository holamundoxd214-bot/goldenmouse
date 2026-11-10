package androidx.compose.foundation.text.input.internal;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/text/input/internal/Api25CommitContentImpl;", "", "<init>", "()V", "commitContent", "", "inputConnection", "Landroid/view/inputmethod/InputConnection;", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "", "opts", "Landroid/os/Bundle;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api25CommitContentImpl {
    public static final Api25CommitContentImpl INSTANCE;

    static {
        Api25CommitContentImpl.INSTANCE = new Api25CommitContentImpl();
    }

    private Api25CommitContentImpl() {
        super();
    }

    public final boolean commitContent(InputConnection arg1, InputContentInfo arg2, int arg3, Bundle arg4) {
        return arg1.commitContent(arg2, arg3, arg4);
    }
}

