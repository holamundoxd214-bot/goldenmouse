package androidx.window.core;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078G¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/window/core/ExtensionsUtil;", "", "<init>", "()V", "TAG", "", "safeVendorApiLevel", "", "getSafeVendorApiLevel", "()I", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtensionsUtil {
    public static final ExtensionsUtil INSTANCE;
    private static final String TAG;

    static {
        ExtensionsUtil.INSTANCE = new ExtensionsUtil();
        ExtensionsUtil.TAG = Reflection.getOrCreateKotlinClass(ExtensionsUtil.class).getSimpleName();
    }

    private ExtensionsUtil() {
        super();
    }

    public final int getSafeVendorApiLevel() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        }
        catch(NullPointerException ) {
            if(BuildConfig.INSTANCE.getVerificationMode() != VerificationMode.LOG) {
                return 0;
            }

            Log.d(ExtensionsUtil.TAG, "Error with Extension implementation");
        }
        catch(UnsupportedOperationException ) {
            if(BuildConfig.INSTANCE.getVerificationMode() != VerificationMode.LOG) {
                return 0;
            }

            Log.d(ExtensionsUtil.TAG, "Stub Extension");
        }
        catch(NoClassDefFoundError ) {
            if(BuildConfig.INSTANCE.getVerificationMode() != VerificationMode.LOG) {
                return 0;
            }

            Log.d(ExtensionsUtil.TAG, "Embedding extension version not found");
        }

        return 0;
    }
}

