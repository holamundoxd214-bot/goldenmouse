package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J(\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H\u0016R \u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0017"}, d2={"Landroidx/window/area/EmptyWindowAreaControllerImpl;", "Landroidx/window/area/WindowAreaController;", "<init>", "()V", "windowAreaInfos", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/area/WindowAreaInfo;", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "transferActivityToWindowArea", "", "token", "Landroid/os/Binder;", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "windowAreaSessionCallback", "Landroidx/window/area/WindowAreaSessionCallback;", "presentContentOnWindowArea", "windowAreaPresentationSessionCallback", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmptyWindowAreaControllerImpl extends WindowAreaController {
    public EmptyWindowAreaControllerImpl() {
        super();
    }

    public Flow getWindowAreaInfos() {
        return FlowKt.flowOf(CollectionsKt.emptyList());
    }

    public void presentContentOnWindowArea(Binder arg1, Activity arg2, Executor arg3, WindowAreaPresentationSessionCallback arg4) {
        Intrinsics.checkNotNullParameter(arg1, "token");
        Intrinsics.checkNotNullParameter(arg2, "activity");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "windowAreaPresentationSessionCallback");
        arg4.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }

    public void transferActivityToWindowArea(Binder arg1, Activity arg2, Executor arg3, WindowAreaSessionCallback arg4) {
        Intrinsics.checkNotNullParameter(arg1, "token");
        Intrinsics.checkNotNullParameter(arg2, "activity");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "windowAreaSessionCallback");
        arg4.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }
}

