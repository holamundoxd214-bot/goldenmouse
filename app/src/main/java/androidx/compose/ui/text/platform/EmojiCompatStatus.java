package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\b\rR\u000E\u0010\u0004\u001A\u00020\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/platform/EmojiCompatStatus;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "<init>", "()V", "delegate", "fontLoaded", "Landroidx/compose/runtime/State;", "", "getFontLoaded", "()Landroidx/compose/runtime/State;", "setDelegateForTesting", "", "newDelegate", "setDelegateForTesting$ui_text", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmojiCompatStatus implements EmojiCompatStatusDelegate {
    public static final int $stable;
    public static final EmojiCompatStatus INSTANCE;
    private static EmojiCompatStatusDelegate delegate;

    static {
        EmojiCompatStatus.INSTANCE = new EmojiCompatStatus();
        EmojiCompatStatus.delegate = new DefaultImpl();
        EmojiCompatStatus.$stable = 8;
    }

    private EmojiCompatStatus() {
        super();
    }

    public State getFontLoaded() {
        return EmojiCompatStatus.delegate.getFontLoaded();
    }

    public final void setDelegateForTesting$ui_text(EmojiCompatStatusDelegate arg1) {
        DefaultImpl v1;
        if(arg1 == null) {
            v1 = new DefaultImpl();
        }

        EmojiCompatStatus.delegate = ((EmojiCompatStatusDelegate)v1);
    }
}

