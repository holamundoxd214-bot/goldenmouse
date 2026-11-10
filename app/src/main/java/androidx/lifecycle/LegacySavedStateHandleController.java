package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry$AutoRecreated;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u00052\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0007J \u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0018\u0010\u0013\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "<init>", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "create", "Landroidx/lifecycle/SavedStateHandleController;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "key", "defaultArgs", "Landroid/os/Bundle;", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LegacySavedStateHandleController {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2={"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "<init>", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OnRecreation implements AutoRecreated {
        public OnRecreation() {
            super();
        }

        public void onRecreated(SavedStateRegistryOwner arg5) {
            Intrinsics.checkNotNullParameter(arg5, "owner");
            if((arg5 instanceof ViewModelStoreOwner)) {
                ViewModelStore v4 = arg5.getViewModelStore();
                SavedStateRegistry v0 = arg5.getSavedStateRegistry();
                Iterator v1 = v4.keys().iterator();
                while(v1.hasNext()) {
                    ViewModel v2 = v4.get(v1.next());
                    if(v2 == null) {
                        continue;
                    }

                    LegacySavedStateHandleController.attachHandleIfNeeded(v2, v0, arg5.getLifecycle());
                }

                if(!v4.keys().isEmpty()) {
                    v0.runOnNextRecreation(OnRecreation.class);
                }

                return;
            }

            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + arg5.toString());
        }
    }

    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    static {
        LegacySavedStateHandleController.INSTANCE = new LegacySavedStateHandleController();
    }

    private LegacySavedStateHandleController() {
        super();
    }

    @JvmStatic public static final void attachHandleIfNeeded(ViewModel arg1, SavedStateRegistry arg2, Lifecycle arg3) {
        Intrinsics.checkNotNullParameter(arg1, "viewModel");
        Intrinsics.checkNotNullParameter(arg2, "registry");
        Intrinsics.checkNotNullParameter(arg3, "lifecycle");
        AutoCloseable v1 = arg1.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if(v1 != null && !((SavedStateHandleController)v1).isAttached()) {
            ((SavedStateHandleController)v1).attachToLifecycle(arg2, arg3);
            LegacySavedStateHandleController.INSTANCE.tryToAddRecreator(arg2, arg3);
        }
    }

    @JvmStatic public static final SavedStateHandleController create(SavedStateRegistry arg2, Lifecycle arg3, String arg4, Bundle arg5) {
        Intrinsics.checkNotNullParameter(arg2, "registry");
        Intrinsics.checkNotNullParameter(arg3, "lifecycle");
        Intrinsics.checkNotNull(arg4);
        SavedStateHandleController v0 = new SavedStateHandleController(arg4, SavedStateHandle.Companion.createHandle(arg2.consumeRestoredStateForKey(arg4), arg5));
        v0.attachToLifecycle(arg2, arg3);
        LegacySavedStateHandleController.INSTANCE.tryToAddRecreator(arg2, arg3);
        return v0;
    }

    private final void tryToAddRecreator(SavedStateRegistry arg2, Lifecycle arg3) {
        State v1 = arg3.getCurrentState();
        if(v1 != State.INITIALIZED) {
            if(v1.isAtLeast(State.STARTED)) {
            }
            else {
                arg3.addObserver(new LegacySavedStateHandleController$tryToAddRecreator$1(arg3, arg2));
                return;
            }
        }

        arg2.runOnNextRecreation(OnRecreation.class);
    }
}

