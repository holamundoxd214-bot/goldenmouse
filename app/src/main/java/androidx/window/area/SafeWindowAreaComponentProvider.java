package androidx.window.area;

import android.os.Build$VERSION;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.area.reflectionguard.WindowAreaComponentValidator;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0001H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001A\u0004\u0018\u00010\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0018\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2={"Landroidx/window/area/SafeWindowAreaComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "<init>", "(Ljava/lang/ClassLoader;)V", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "getWindowAreaComponent", "()Landroidx/window/extensions/area/WindowAreaComponent;", "isWindowAreaProviderValid", "", "windowAreaComponentClass", "Ljava/lang/Class;", "getWindowAreaComponentClass", "()Ljava/lang/Class;", "extensionWindowAreaStatusClass", "getExtensionWindowAreaStatusClass", "extensionWindowAreaPresentationClass", "getExtensionWindowAreaPresentationClass", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SafeWindowAreaComponentProvider {
    private final ClassLoader loader;
    private final WindowExtensions windowExtensions;

    public SafeWindowAreaComponentProvider(ClassLoader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "loader");
        super();
        this.loader = arg2;
        this.windowExtensions = new SafeWindowExtensionsProvider(arg2).getWindowExtensions();
    }

    private final Class getExtensionWindowAreaPresentationClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.area.ExtensionWindowAreaPresentation");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    private final Class getExtensionWindowAreaStatusClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.area.ExtensionWindowAreaStatus");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    public final WindowAreaComponent getWindowAreaComponent() {
        WindowAreaComponent v0 = null;
        try {
            WindowExtensions v1 = this.windowExtensions;
            if(v1 != null && (this.isWindowAreaProviderValid(v1)) && Build$VERSION.SDK_INT >= 29 && (WindowAreaComponentValidator.INSTANCE.isWindowAreaComponentValid$window_release(this.getWindowAreaComponentClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel())) && (WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaStatusValid$window_release(this.getExtensionWindowAreaStatusClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel())) && (WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaPresentationValid$window_release(this.getExtensionWindowAreaPresentationClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()))) {
                return this.windowExtensions.getWindowAreaComponent();
            }

            return v0;
        }
        catch(Throwable ) {
            return v0;
        }
    }

    private final Class getWindowAreaComponentClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.area.WindowAreaComponent");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    private final boolean isWindowAreaProviderValid(Object arg2) {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowAreaComponent is not valid", new SafeWindowAreaComponentProvider$$ExternalSyntheticLambda0(arg2, this));
    }

    static final boolean isWindowAreaProviderValid$lambda$0(Object arg3, SafeWindowAreaComponentProvider arg4) {
        Method v3 = arg3.getClass().getMethod("getWindowAreaComponent");
        ReflectionUtils v1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        if((v1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, arg4.getWindowAreaComponentClass()))) {
            return 1;
        }

        return 0;
    }
}

