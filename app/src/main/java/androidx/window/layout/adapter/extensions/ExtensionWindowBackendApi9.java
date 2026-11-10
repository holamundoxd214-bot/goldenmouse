package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\f"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi9;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi6;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "getCurrentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ExtensionWindowBackendApi9 extends ExtensionWindowBackendApi6 {
    public ExtensionWindowBackendApi9(WindowLayoutComponent arg2, ConsumerAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        super(arg2, arg3);
    }

    public WindowLayoutInfo getCurrentWindowLayoutInfo(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        ExtensionsWindowLayoutInfoAdapter v0 = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
        androidx.window.extensions.layout.WindowLayoutInfo v2 = this.getComponent().getCurrentWindowLayoutInfo(arg3);
        Intrinsics.checkNotNullExpressionValue(v2, "getCurrentWindowLayoutInfo(...)");
        return v0.translate$window_release(arg3, v2);
    }
}

