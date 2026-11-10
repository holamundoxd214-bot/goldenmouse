package androidx.window.layout.adapter.extensions;

import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.SupportedWindowFeatures;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi6;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi2;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ExtensionWindowBackendApi6 extends ExtensionWindowBackendApi2 {
    public ExtensionWindowBackendApi6(WindowLayoutComponent arg2, ConsumerAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        super(arg2, arg3);
    }

    public List getSupportedPostures() {
        ExtensionsWindowLayoutInfoAdapter v0 = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
        SupportedWindowFeatures v2 = this.getComponent().getSupportedWindowFeatures();
        Intrinsics.checkNotNullExpressionValue(v2, "getSupportedWindowFeatures(...)");
        return v0.translate$window_release(v2);
    }
}

