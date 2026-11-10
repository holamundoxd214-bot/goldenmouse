package androidx.window.layout.adapter.sidecar;

import androidx.window.layout.WindowLayoutInfo;

public final class SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(WindowLayoutChangeCallbackWrapper arg1, WindowLayoutInfo arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        WindowLayoutChangeCallbackWrapper.accept$lambda$0(this.f$0, this.f$1);
    }
}

