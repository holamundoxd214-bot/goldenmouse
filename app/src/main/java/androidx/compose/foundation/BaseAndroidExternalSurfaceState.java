package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006Ju\u0010\t\u001A\u00020\u00142f\u0010\t\u001Ab\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n¢\u0006\u0002\b\u0016H\u0016¢\u0006\u0002\u0010\u001EJO\u0010\u001F\u001A\u00020\u0014*\u00020\f2A\u0010\u001F\u001A=\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u0016H\u0016J%\u0010 \u001A\u00020\u0014*\u00020\f2\u0017\u0010 \u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u001B¢\u0006\u0002\b\u0016H\u0016J\u001E\u0010!\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010J\u001E\u0010\"\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010J\u000E\u0010#\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\fR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bRr\u0010\t\u001Ad\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\n¢\u0006\u0002\b\u0016X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0017RK\u0010\u0018\u001A?\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019¢\u0006\u0002\b\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R!\u0010\u001A\u001A\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001B¢\u0006\u0002\b\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onSurface", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "Lkotlin/ParameterName;", "name", "surface", "", "width", "height", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "onSurfaceChanged", "Lkotlin/Function3;", "onSurfaceDestroyed", "Lkotlin/Function1;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function5;)V", "onChanged", "onDestroyed", "dispatchSurfaceCreated", "dispatchSurfaceChanged", "dispatchSurfaceDestroyed", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {
    private Job job;
    private Function5 onSurface;
    private Function3 onSurfaceChanged;
    private Function1 onSurfaceDestroyed;
    private final CoroutineScope scope;

    public BaseAndroidExternalSurfaceState(CoroutineScope arg1) {
        super();
        this.scope = arg1;
    }

    public static final Job access$getJob$p(BaseAndroidExternalSurfaceState arg0) {
        return arg0.job;
    }

    public static final Function5 access$getOnSurface$p(BaseAndroidExternalSurfaceState arg0) {
        return arg0.onSurface;
    }

    public final void dispatchSurfaceChanged(Surface arg1, int arg2, int arg3) {
        Function3 v0 = this.onSurfaceChanged;
        if(v0 != null) {
            v0.invoke(arg1, Integer.valueOf(arg2), Integer.valueOf(arg3));
        }
    }

    public final void dispatchSurfaceCreated(Surface arg11, int arg12, int arg13) {
        if(this.onSurface != null) {
            this.job = BuildersKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(this, arg11, arg12, arg13, null), 1, null);
        }
    }

    public final void dispatchSurfaceDestroyed(Surface arg2) {
        Function1 v0 = this.onSurfaceDestroyed;
        if(v0 != null) {
            v0.invoke(arg2);
        }

        Job v1 = this.job;
        if(v1 != null) {
            DefaultImpls.cancel$default(v1, null, 1, null);
        }
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public void onChanged(Surface arg1, Function3 arg2) {
        this.onSurfaceChanged = arg2;
    }

    public void onDestroyed(Surface arg1, Function1 arg2) {
        this.onSurfaceDestroyed = arg2;
    }

    public void onSurface(Function5 arg1) {
        this.onSurface = arg1;
    }
}

