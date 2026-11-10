package androidx.window;

import androidx.window.core.ExtensionsUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001A\u00020\t2\b\b\u0001\u0010\n\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u000BJ\u0015\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\u000BR\u0016\u0010\u0004\u001A\u00020\u00058WX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/window/WindowSdkExtensions;", "", "<init>", "()V", "extensionVersion", "", "getExtensionVersion", "()I", "requireExtensionVersion", "", "version", "requireExtensionVersion$window_release", "range", "Lkotlin/ranges/IntRange;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class WindowSdkExtensions {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0007J\b\u0010\u000B\u001A\u00020\tH\u0007R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/window/WindowSdkExtensions$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/WindowSdkExtensions;", "decorator", "Landroidx/window/WindowSdkExtensionsDecorator;", "overrideDecorator", "", "overridingDecorator", "reset", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final WindowSdkExtensions getInstance() {
            return WindowSdkExtensions.decorator.decorate(new WindowSdkExtensions$Companion$getInstance$1());
        }

        public final void overrideDecorator(WindowSdkExtensionsDecorator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "overridingDecorator");
            WindowSdkExtensions.decorator = arg1;
        }

        public final void reset() {
            WindowSdkExtensions.decorator = EmptyDecoratorWindowSdk.INSTANCE;
        }
    }

    public static final Companion Companion;
    private static WindowSdkExtensionsDecorator decorator;
    private final int extensionVersion;

    static {
        WindowSdkExtensions.Companion = new Companion(null);
        WindowSdkExtensions.decorator = EmptyDecoratorWindowSdk.INSTANCE;
    }

    public WindowSdkExtensions() {
        super();
        this.extensionVersion = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
    }

    public static final WindowSdkExtensionsDecorator access$getDecorator$cp() {
        return WindowSdkExtensions.decorator;
    }

    public static final void access$setDecorator$cp(WindowSdkExtensionsDecorator arg0) {
        WindowSdkExtensions.decorator = arg0;
    }

    public int getExtensionVersion() {
        return this.extensionVersion;
    }

    @JvmStatic public static final WindowSdkExtensions getInstance() {
        return WindowSdkExtensions.Companion.getInstance();
    }

    public final void requireExtensionVersion$window_release(int arg4) {
        if(this.getExtensionVersion() >= arg4) {
            return;
        }

        throw new UnsupportedOperationException("This API requires extension version " + arg4 + ", but the device is on " + this.getExtensionVersion());
    }

    public final void requireExtensionVersion$window_release(IntRange arg4) {
        Intrinsics.checkNotNullParameter(arg4, "range");
        int v0 = arg4.getFirst();
        int v1 = arg4.getLast();
        int v2 = this.getExtensionVersion();
        if(v0 <= v2 && v2 <= v1) {
            return;
        }

        throw new UnsupportedOperationException("This API requires extension version " + arg4 + ", but the device is on " + this.getExtensionVersion());
    }
}

