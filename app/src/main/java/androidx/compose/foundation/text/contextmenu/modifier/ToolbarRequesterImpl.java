package androidx.compose.foundation.text.contextmenu.modifier;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0005H\u0016¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequesterImpl;", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "<init>", "()V", "show", "", "hide", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ToolbarRequesterImpl extends ToolbarRequester {
    public static final int $stable = 8;

    static {
    }

    public ToolbarRequesterImpl() {
        super();
    }

    public void hide() {
        TextContextMenuToolbarHandlerNode v0 = this.getToolbarHandlerNode$foundation();
        if(v0 != null) {
            v0.hide();
        }
    }

    public void show() {
        TextContextMenuToolbarHandlerNode v0 = this.requireInitialized$foundation();
        if(v0 != null) {
            v0.show();
        }
    }
}

