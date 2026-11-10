package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001A\u00020\u0013H&J\b\u0010\u0014\u001A\u00020\u0013H&R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "", "<init>", "()V", "toolbarHandlerNode", "Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "getToolbarHandlerNode$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "setToolbarHandlerNode$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;)V", "toolbarHandlerState", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarHandlerState;", "getToolbarHandlerState$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarHandlerState;", "setToolbarHandlerState$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarHandlerState;)V", "requireInitialized", "requireInitialized$foundation", "show", "", "hide", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ToolbarRequester {
    public static final int $stable = 8;
    private TextContextMenuToolbarHandlerNode toolbarHandlerNode;
    private ToolbarHandlerState toolbarHandlerState;

    static {
    }

    public ToolbarRequester() {
        super();
        this.toolbarHandlerState = ToolbarHandlerState.Uninitialized;
    }

    public final TextContextMenuToolbarHandlerNode getToolbarHandlerNode$foundation() {
        return this.toolbarHandlerNode;
    }

    public final ToolbarHandlerState getToolbarHandlerState$foundation() {
        return this.toolbarHandlerState;
    }

    public abstract void hide();

    public final TextContextMenuToolbarHandlerNode requireInitialized$foundation() {
        int v0 = this.toolbarHandlerState != ToolbarHandlerState.Uninitialized ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("ToolbarRequester is not initialized.");
        }

        return this.toolbarHandlerNode;
    }

    public final void setToolbarHandlerNode$foundation(TextContextMenuToolbarHandlerNode arg1) {
        this.toolbarHandlerNode = arg1;
    }

    public final void setToolbarHandlerState$foundation(ToolbarHandlerState arg1) {
        this.toolbarHandlerState = arg1;
    }

    public abstract void show();
}

