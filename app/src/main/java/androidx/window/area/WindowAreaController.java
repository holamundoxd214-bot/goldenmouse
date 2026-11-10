package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.window.core.BuildConfig;
import androidx.window.core.ExtensionsUtil;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.WindowAreaComponent;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H&J(\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H&R\u001E\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0018"}, d2={"Landroidx/window/area/WindowAreaController;", "", "<init>", "()V", "windowAreaInfos", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/area/WindowAreaInfo;", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "transferActivityToWindowArea", "", "token", "Landroid/os/Binder;", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "windowAreaSessionCallback", "Landroidx/window/area/WindowAreaSessionCallback;", "presentContentOnWindowArea", "windowAreaPresentationSessionCallback", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class WindowAreaController {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000E\u001A\u00020\tH\u0007J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0007H\u0007J\b\u0010\u0012\u001A\u00020\u0010H\u0007R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\b\u001A\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/window/area/WindowAreaController$Companion;", "", "<init>", "()V", "TAG", "", "decorator", "Landroidx/window/area/WindowAreaControllerDecorator;", "windowAreaController", "Landroidx/window/area/WindowAreaController;", "getWindowAreaController", "()Landroidx/window/area/WindowAreaController;", "windowAreaController$delegate", "Lkotlin/Lazy;", "getOrCreate", "overrideDecorator", "", "overridingDecorator", "reset", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final WindowAreaController getOrCreate() {
            return WindowAreaController.decorator.decorate(this.getWindowAreaController());
        }

        private final WindowAreaController getWindowAreaController() {
            return WindowAreaController.windowAreaController$delegate.getValue();
        }

        @JvmStatic public final void overrideDecorator(WindowAreaControllerDecorator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "overridingDecorator");
            WindowAreaController.decorator = arg1;
        }

        @JvmStatic public final void reset() {
            WindowAreaController.decorator = EmptyDecorator.INSTANCE;
        }
    }

    public static final Companion Companion;
    private static final String TAG;
    private static WindowAreaControllerDecorator decorator;
    private static final Lazy windowAreaController$delegate;

    static {
        WindowAreaController.Companion = new Companion(null);
        WindowAreaController.TAG = Reflection.getOrCreateKotlinClass(WindowAreaController.class).getSimpleName();
        WindowAreaController.decorator = EmptyDecorator.INSTANCE;
        WindowAreaController.windowAreaController$delegate = LazyKt.lazy(new WindowAreaController$$ExternalSyntheticLambda0());
    }

    public WindowAreaController() {
        super();
    }

    public static final WindowAreaControllerDecorator access$getDecorator$cp() {
        return WindowAreaController.decorator;
    }

    public static final Lazy access$getWindowAreaController$delegate$cp() {
        return WindowAreaController.windowAreaController$delegate;
    }

    public static final void access$setDecorator$cp(WindowAreaControllerDecorator arg0) {
        WindowAreaController.decorator = arg0;
    }

    @JvmStatic public static final WindowAreaController getOrCreate() {
        return WindowAreaController.Companion.getOrCreate();
    }

    public abstract Flow getWindowAreaInfos();

    @JvmStatic public static final void overrideDecorator(WindowAreaControllerDecorator arg1) {
        WindowAreaController.Companion.overrideDecorator(arg1);
    }

    public abstract void presentContentOnWindowArea(Binder arg1, Activity arg2, Executor arg3, WindowAreaPresentationSessionCallback arg4);

    @JvmStatic public static final void reset() {
        WindowAreaController.Companion.reset();
    }

    public abstract void transferActivityToWindowArea(Binder arg1, Activity arg2, Executor arg3, WindowAreaSessionCallback arg4);

    static final WindowAreaController windowAreaController_delegate$lambda$1() {
        WindowAreaControllerImpl v1_1;
        WindowAreaComponent v0 = null;
        try {
            ClassLoader v1 = WindowAreaController.Companion.getClass().getClassLoader();
            if(v1 == null) {
                goto label_16;
            }

            v0 = new SafeWindowAreaComponentProvider(v1).getWindowAreaComponent();
        }
        catch(Throwable ) {
            if(BuildConfig.INSTANCE.getVerificationMode() != VerificationMode.LOG) {
                goto label_16;
            }

            Log.d(WindowAreaController.TAG, "Failed to load WindowExtensions");
        }

    label_16:
        if(Build$VERSION.SDK_INT <= 29 || v0 == null || ExtensionsUtil.INSTANCE.getSafeVendorApiLevel() < 3) {
            EmptyWindowAreaControllerImpl v1_2 = new EmptyWindowAreaControllerImpl();
        }
        else {
            Intrinsics.checkNotNull(v0);
            v1_1 = new WindowAreaControllerImpl(v0);
        }

        return ((WindowAreaController)v1_1);
    }
}

