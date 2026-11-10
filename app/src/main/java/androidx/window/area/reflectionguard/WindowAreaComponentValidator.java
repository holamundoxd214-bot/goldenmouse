package androidx.window.area.reflectionguard;

import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.reflection.ReflectionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\nJ!\u0010\u000B\u001A\u00020\u00052\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\rJ!\u0010\u000E\u001A\u00020\u00052\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2={"Landroidx/window/area/reflectionguard/WindowAreaComponentValidator;", "", "<init>", "()V", "isWindowAreaComponentValid", "", "windowAreaComponent", "Ljava/lang/Class;", "apiLevel", "", "isWindowAreaComponentValid$window_release", "isExtensionWindowAreaStatusValid", "extensionWindowAreaStatus", "isExtensionWindowAreaStatusValid$window_release", "isExtensionWindowAreaPresentationValid", "extensionWindowAreaPresentation", "isExtensionWindowAreaPresentationValid$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaComponentValidator {
    public static final WindowAreaComponentValidator INSTANCE;

    static {
        WindowAreaComponentValidator.INSTANCE = new WindowAreaComponentValidator();
    }

    private WindowAreaComponentValidator() {
        super();
    }

    public final boolean isExtensionWindowAreaPresentationValid$window_release(Class arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "extensionWindowAreaPresentation");
        if(arg2 <= 2) {
            return 0;
        }

        return ReflectionUtils.INSTANCE.validateImplementation$window_release(arg1, ExtensionWindowAreaPresentation.class);
    }

    public final boolean isExtensionWindowAreaStatusValid$window_release(Class arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "extensionWindowAreaStatus");
        if(arg2 <= 2) {
            return 0;
        }

        return ReflectionUtils.INSTANCE.validateImplementation$window_release(arg1, ExtensionWindowAreaStatusRequirements.class);
    }

    public final boolean isWindowAreaComponentValid$window_release(Class arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "windowAreaComponent");
        if(arg2 <= 2) {
            return 0;
        }

        return ReflectionUtils.INSTANCE.validateImplementation$window_release(arg1, WindowAreaComponentApi3Requirements.class);
    }
}

