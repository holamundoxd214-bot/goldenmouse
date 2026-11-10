package androidx.activity.compose;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A.\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0011\u0010\u0005\u001A\r\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\b\u001A\f\u0010\u000B\u001A\u00020\u0001*\u00020\u0002H\u0002\"\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"setContent", "", "Landroidx/activity/ComponentActivity;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setOwners", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComponentActivityKt {
    private static final ViewGroup$LayoutParams DefaultActivityContentLayoutParams;

    static {
        ComponentActivityKt.DefaultActivityContentLayoutParams = new ViewGroup$LayoutParams(-2, -2);
    }

    public static final void setContent(ComponentActivity arg7, CompositionContext arg8, Function2 arg9) {
        View v0 = arg7.getWindow().getDecorView().findViewById(0x1020002).getChildAt(0);
        if((v0 instanceof ComposeView)) {
        }
        else {
            v0 = null;
        }

        if(v0 != null) {
            ((ComposeView)v0).setParentCompositionContext(arg8);
            ((ComposeView)v0).setContent(arg9);
            return;
        }

        ComposeView v1 = new ComposeView(arg7, null, 0, 6, null);
        v1.setParentCompositionContext(arg8);
        v1.setContent(arg9);
        ComponentActivityKt.setOwners(arg7);
        arg7.setContentView(((View)v1), ComponentActivityKt.DefaultActivityContentLayoutParams);
    }

    public static void setContent$default(ComponentActivity arg0, CompositionContext arg1, Function2 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        ComponentActivityKt.setContent(arg0, arg1, arg2);
    }

    private static final void setOwners(ComponentActivity arg2) {
        View v0 = arg2.getWindow().getDecorView();
        if(ViewTreeLifecycleOwner.get(v0) == null) {
            ViewTreeLifecycleOwner.set(v0, arg2);
        }

        if(ViewTreeViewModelStoreOwner.get(v0) == null) {
            ViewTreeViewModelStoreOwner.set(v0, arg2);
        }

        if(ViewTreeSavedStateRegistryOwner.get(v0) == null) {
            ViewTreeSavedStateRegistryOwner.set(v0, ((SavedStateRegistryOwner)arg2));
        }
    }
}

