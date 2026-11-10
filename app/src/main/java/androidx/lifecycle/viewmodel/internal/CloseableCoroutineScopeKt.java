package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\f\u0010\u0004\u001A\u00020\u0003*\u00020\u0005H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"VIEW_MODEL_SCOPE_KEY", "", "createViewModelScope", "Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "asCloseable", "Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(CoroutineScope arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new CloseableCoroutineScope(arg1);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        EmptyCoroutineContext v0_1;
        MainCoroutineDispatcher v0;
        try {
            v0 = Dispatchers.getMain().getImmediate();
        }
        catch(IllegalStateException ) {
            v0_1 = EmptyCoroutineContext.INSTANCE;
        }
        catch(NotImplementedError ) {
            v0_1 = EmptyCoroutineContext.INSTANCE;
        }

        return new CloseableCoroutineScope(((CoroutineContext)v0).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}

