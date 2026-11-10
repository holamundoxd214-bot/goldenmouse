package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/platform/DelegatingSoftwareKeyboardController;", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "<init>", "(Landroidx/compose/ui/text/input/TextInputService;)V", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "show", "", "hide", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DelegatingSoftwareKeyboardController implements SoftwareKeyboardController {
    public static final int $stable;
    private final TextInputService textInputService;

    static {
    }

    public DelegatingSoftwareKeyboardController(TextInputService arg1) {
        super();
        this.textInputService = arg1;
    }

    public final TextInputService getTextInputService() {
        return this.textInputService;
    }

    public void hide() {
        this.textInputService.hideSoftwareKeyboard();
    }

    public void show() {
        this.textInputService.showSoftwareKeyboard();
    }
}

