package androidx.window.area.utils;

import android.view.Window;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¨\u0006\n"}, d2={"Landroidx/window/area/utils/PresentationWindowCompatUtils;", "", "<init>", "()V", "getWindowBeforeVendorApiLevel4", "Landroid/view/Window;", "extensionPresentation", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "getWindowMethod", "Ljava/lang/reflect/Method;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PresentationWindowCompatUtils {
    public static final PresentationWindowCompatUtils INSTANCE;

    static {
        PresentationWindowCompatUtils.INSTANCE = new PresentationWindowCompatUtils();
    }

    private PresentationWindowCompatUtils() {
        super();
    }

    public final Window getWindowBeforeVendorApiLevel4(ExtensionWindowAreaPresentation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "extensionPresentation");
        Method v1 = this.getWindowMethod(arg2);
        if(v1 == null) {
            return null;
        }

        return v1.invoke(arg2);
    }

    private final Method getWindowMethod(ExtensionWindowAreaPresentation arg6) {
        Object v1;
        Method[] v5 = arg6.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(v5, "getMethods(...)");
        int v6 = v5.length;
        int v0 = 0;
        while(true) {
            v1 = null;
            if(v0 < v6) {
                Method v2 = v5[v0];
                Method v3 = v2;
                if(v3 != null) {
                    String v1_1 = v3.getName();
                }

                if((Intrinsics.areEqual(v1, "getWindow")) && (Intrinsics.areEqual(v3.getReturnType(), Window.class))) {
                    Method v1_2 = v2;
                    break;
                }

                ++v0;
                continue;
            }

            break;
        }

        return ((Method)v1);
    }
}

