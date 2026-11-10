package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH&J\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "", "validateExtensionInterface", "", "setExtensionCallback", "", "extensionCallback", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "onWindowLayoutChangeListenerAdded", "activity", "Landroid/app/Activity;", "onWindowLayoutChangeListenerRemoved", "ExtensionCallbackInterface", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ExtensionInterfaceCompat {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "", "onWindowLayoutChanged", "", "activity", "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(Activity arg1, WindowLayoutInfo arg2);
    }

    void onWindowLayoutChangeListenerAdded(Activity arg1);

    void onWindowLayoutChangeListenerRemoved(Activity arg1);

    void setExtensionCallback(ExtensionCallbackInterface arg1);

    boolean validateExtensionInterface();
}

