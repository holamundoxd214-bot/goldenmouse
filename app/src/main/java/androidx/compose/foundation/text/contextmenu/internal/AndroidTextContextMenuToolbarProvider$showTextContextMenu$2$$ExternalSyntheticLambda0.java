package androidx.compose.foundation.text.contextmenu.internal;

public final class AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda0 implements Runnable {
    public AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda0(AndroidTextContextMenuToolbarProvider arg1, TextActionModeCallback arg2, TextContextMenuSessionImpl arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        AndroidTextContextMenuToolbarProvider$showTextContextMenu$2.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

