package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\u0007"}, d2={"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ViewCompositionStrategy_androidKt {
    public static final Function0 access$installForLifecycle(AbstractComposeView arg0, Lifecycle arg1) {
        return ViewCompositionStrategy_androidKt.installForLifecycle(arg0, arg1);
    }

    private static final Function0 installForLifecycle(AbstractComposeView arg2, Lifecycle arg3) {
        if(arg3.getCurrentState().compareTo(State.DESTROYED) > 0) {
            ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 v0 = new ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(arg2);
            arg3.addObserver(v0);
            return new ViewCompositionStrategy_androidKt$installForLifecycle$2(arg3, ((LifecycleEventObserver)v0));
        }

        throw new IllegalStateException("Cannot configure " + arg2 + " to disposeComposition at Lifecycle ON_DESTROY: " + arg3 + "is already destroyed".toString());
    }

    static final void installForLifecycle$lambda$1(AbstractComposeView arg0, LifecycleOwner arg1, Event arg2) {
        if(arg2 == Event.ON_DESTROY) {
            arg0.disposeComposition();
        }
    }
}

