package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0097\u0001J\t\u0010\t\u001A\u00020\nH\u0097\u0001J\'\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0096\u0001J\u0017\u0010\u0011\u001A\u00020\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0096\u0001R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00138WX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackend;", "Landroidx/window/layout/adapter/WindowBackend;", "backend", "<init>", "(Landroidx/window/layout/adapter/WindowBackend;)V", "getCurrentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "hasRegisteredListeners", "", "registerLayoutChangeCallback", "", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "unregisterLayoutChangeCallback", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtensionWindowBackend implements WindowBackend {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackend$Companion;", "", "<init>", "()V", "newInstance", "Landroidx/window/layout/adapter/WindowBackend;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final WindowBackend newInstance(WindowLayoutComponent arg2, ConsumerAdapter arg3) {
            Intrinsics.checkNotNullParameter(arg2, "component");
            Intrinsics.checkNotNullParameter(arg3, "adapter");
            int v1 = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
            if(v1 >= 9) {
                return new ExtensionWindowBackendApi9(arg2, arg3);
            }

            if(v1 >= 6) {
                return new ExtensionWindowBackendApi6(arg2, arg3);
            }

            if(v1 >= 2) {
                return new ExtensionWindowBackendApi2(arg2, arg3);
            }

            if(v1 == 1) {
                return new ExtensionWindowBackendApi1(arg2, arg3);
            }

            return new ExtensionWindowBackendApi0();
        }
    }

    public static final Companion Companion;
    private final WindowBackend backend;

    static {
        ExtensionWindowBackend.Companion = new Companion(null);
    }

    public ExtensionWindowBackend(WindowBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        super();
        this.backend = arg2;
    }

    public WindowLayoutInfo getCurrentWindowLayoutInfo(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        return this.backend.getCurrentWindowLayoutInfo(arg2);
    }

    public List getSupportedPostures() {
        return this.backend.getSupportedPostures();
    }

    public boolean hasRegisteredListeners() {
        return this.backend.hasRegisteredListeners();
    }

    public void registerLayoutChangeCallback(Context arg2, Executor arg3, Consumer arg4) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "callback");
        this.backend.registerLayoutChangeCallback(arg2, arg3, arg4);
    }

    public void unregisterLayoutChangeCallback(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        this.backend.unregisterLayoutChangeCallback(arg2);
    }
}

