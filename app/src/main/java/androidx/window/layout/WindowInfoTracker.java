package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001A\u00020\bH&J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0017R \u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8WX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000Fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/window/layout/WindowInfoTracker;", "", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures$annotations", "()V", "getSupportedPostures", "()Ljava/util/List;", "getCurrentWindowLayoutInfo", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface WindowInfoTracker {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0007J\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0010H\u0007J\b\u0010\u0018\u001A\u00020\u0016H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001A\u0004\u0018\u00010\t8@X\u0080\u0084\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "<init>", "()V", "DEBUG", "", "TAG", "", "extensionBackend", "Landroidx/window/layout/adapter/WindowBackend;", "getExtensionBackend$window_release$annotations", "getExtensionBackend$window_release", "()Landroidx/window/layout/adapter/WindowBackend;", "extensionBackend$delegate", "Lkotlin/Lazy;", "decorator", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "getOrCreate", "Landroidx/window/layout/WindowInfoTracker;", "context", "Landroid/content/Context;", "overrideDecorator", "", "overridingDecorator", "reset", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final boolean DEBUG;
        private static final String TAG;
        private static WindowInfoTrackerDecorator decorator;
        private static final Lazy extensionBackend$delegate;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.TAG = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();
            Companion.extensionBackend$delegate = LazyKt.lazy(new WindowInfoTracker$Companion$$ExternalSyntheticLambda0());
            Companion.decorator = EmptyDecorator.INSTANCE;
        }

        private Companion() {
            super();
        }

        static final WindowBackend extensionBackend_delegate$lambda$2() {
            WindowBackend v0 = null;
            try {
                ClassLoader v1 = WindowInfoTracker.class.getClassLoader();
                SafeWindowLayoutComponentProvider v2 = v1 != null ? new SafeWindowLayoutComponentProvider(v1, new ConsumerAdapter(v1)) : ((SafeWindowLayoutComponentProvider)v0);
                if(v2 != null) {
                    WindowLayoutComponent v2_1 = v2.getWindowLayoutComponent();
                    if(v2_1 != null) {
                        v0 = ExtensionWindowBackend.Companion.newInstance(v2_1, new ConsumerAdapter(v1));
                    }
                }
            }
            catch(Throwable ) {
                if(Companion.DEBUG) {
                    Log.d(Companion.TAG, "Failed to load WindowExtensions");
                }

                return v0;
            }

            return v0;
        }

        public final WindowBackend getExtensionBackend$window_release() {
            return Companion.extensionBackend$delegate.getValue();
        }

        public static void getExtensionBackend$window_release$annotations() {
        }

        @JvmStatic public final WindowInfoTracker getOrCreate(Context arg4) {
            SidecarWindowBackend v3_1;
            Intrinsics.checkNotNullParameter(arg4, "context");
            WindowBackend v3 = this.getExtensionBackend$window_release();
            if(v3 == null) {
                v3_1 = SidecarWindowBackend.Companion.getInstance(arg4);
            }

            return Companion.decorator.decorate(new WindowInfoTrackerImpl(new WindowMetricsCalculatorCompat(null, 1, null), ((WindowBackend)v3_1), WindowSdkExtensions.Companion.getInstance()));
        }

        @JvmStatic public final void overrideDecorator(WindowInfoTrackerDecorator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "overridingDecorator");
            Companion.decorator = arg1;
        }

        @JvmStatic public final void reset() {
            Companion.decorator = EmptyDecorator.INSTANCE;
        }
    }

    public static final Companion Companion;

    static {
        WindowInfoTracker.Companion = Companion.$$INSTANCE;
    }

    default WindowLayoutInfo getCurrentWindowLayoutInfo(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        throw new NotImplementedError("Method was not implemented.");
    }

    @JvmStatic static WindowInfoTracker getOrCreate(Context arg1) {
        return WindowInfoTracker.Companion.getOrCreate(arg1);
    }

    default List getSupportedPostures() {
        throw new NotImplementedError("Method was not implemented.");
    }

    static void getSupportedPostures$annotations() {
    }

    @JvmStatic static void overrideDecorator(WindowInfoTrackerDecorator arg1) {
        WindowInfoTracker.Companion.overrideDecorator(arg1);
    }

    @JvmStatic static void reset() {
        WindowInfoTracker.Companion.reset();
    }

    Flow windowLayoutInfo(Activity arg1);

    default Flow windowLayoutInfo(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Flow v1 = null;
        if((arg3 instanceof Activity)) {
        }
        else {
            arg3 = ((Context)v1);
        }

        if(arg3 != null) {
            v1 = this.windowLayoutInfo(((Activity)arg3));
        }

        if(v1 != null) {
            return v1;
        }

        throw new NotImplementedError("Must override windowLayoutInfo(context) and provide an implementation.");
    }
}

