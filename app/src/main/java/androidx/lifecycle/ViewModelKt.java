package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "VIEW_MODEL_SCOPE_LOCK", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelKt {
    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK;

    static {
        ViewModelKt.VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();
    }

    public static final CoroutineScope getViewModelScope(ViewModel arg4) {
        AutoCloseable v1;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        SynchronizedObject v0 = ViewModelKt.VIEW_MODEL_SCOPE_LOCK;
        __monitor_enter(v0);
        try {
            v1 = arg4.getCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if(v1 == null) {
                CloseableCoroutineScope v1_1 = CloseableCoroutineScopeKt.createViewModelScope();
                arg4.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", v1_1);
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        return ((CoroutineScope)v1);
    }
}

