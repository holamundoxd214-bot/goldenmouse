package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras$Key;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001F\u0010\u0003\u001A\u00020\u0004\"\f\b\u0000\u0010\u0005*\u00020\u0006*\u00020\u0007*\u0002H\u0005H\u0007¢\u0006\u0002\u0010\b\u001A0\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u00012\u000E\u0010\u000E\u001A\n\u0018\u00010\u000Fj\u0004\u0018\u0001`\u0010H\u0002\u001A\f\u0010\t\u001A\u00020\n*\u00020\u0011H\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0012\u001A\u00020\u0013*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0016\u001A\u00020\u0017*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00060\u001B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00070\u001B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u001D\u001A\f\u0012\b\u0012\u00060\u000Fj\u0002`\u00100\u001B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"VIEWMODEL_KEY", "", "SAVED_STATE_KEY", "enableSavedStateHandles", "", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", "key", "defaultArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "VIEW_MODEL_STORE_OWNER_KEY", "DEFAULT_ARGS_KEY", "lifecycle-viewmodel-savedstate"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandleSupport {
    public static final Key DEFAULT_ARGS_KEY = null;
    public static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final Key SAVED_STATE_REGISTRY_OWNER_KEY = null;
    public static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final Key VIEW_MODEL_STORE_OWNER_KEY;

    static {
        SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$special$$inlined$Key$1();
        SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$special$$inlined$Key$2();
        SavedStateHandleSupport.DEFAULT_ARGS_KEY = new SavedStateHandleSupport$special$$inlined$Key$3();
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Object v0 = arg4.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY);
        if(v0 != null) {
            Object v1 = arg4.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY);
            if(v1 != null) {
                Object v2 = arg4.get(SavedStateHandleSupport.DEFAULT_ARGS_KEY);
                Object v4 = arg4.get(ViewModelProvider.VIEW_MODEL_KEY);
                if(v4 != null) {
                    return SavedStateHandleSupport.createSavedStateHandle(((SavedStateRegistryOwner)v0), ((ViewModelStoreOwner)v1), ((String)v4), ((Bundle)v2));
                }

                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }

            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }

        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner arg1, ViewModelStoreOwner arg2, String arg3, Bundle arg4) {
        SavedStateHandlesProvider v1 = SavedStateHandleSupport.getSavedStateHandlesProvider(arg1);
        SavedStateHandlesVM v2 = SavedStateHandleSupport.getSavedStateHandlesVM(arg2);
        Object v0 = v2.getHandles().get(arg3);
        if(v0 == null) {
            SavedStateHandle v1_1 = SavedStateHandle.Companion.createHandle(v1.consumeRestoredStateForKey(arg3), arg4);
            v2.getHandles().put(arg3, v1_1);
            return v1_1;
        }

        return ((SavedStateHandle)v0);
    }

    public static final void enableSavedStateHandles(SavedStateRegistryOwner arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        SavedStateRegistryOwner v0 = arg5;
        State v1 = ((LifecycleOwner)v0).getLifecycle().getCurrentState();
        if(v1 != State.INITIALIZED) {
            if(v1 == State.CREATED) {
            }
            else {
                throw new IllegalArgumentException("Failed to enable `SavedStateHandle` for `" + arg5 + "`. The `Lifecycle.State` must be `INITIALIZED` or `CREATED`, but was `" + v1 + "`. You must call `enableSavedStateHandles()` before the `Lifecycle.State` moves to `STARTED`.".toString());
            }
        }

        String v2 = "androidx.lifecycle.internal.SavedStateHandlesProvider";
        if(arg5.getSavedStateRegistry().getSavedStateProvider(v2) == null) {
            SavedStateHandlesProvider v1_1 = new SavedStateHandlesProvider(arg5.getSavedStateRegistry(), arg5);
            arg5.getSavedStateRegistry().registerSavedStateProvider(v2, v1_1);
            ((LifecycleOwner)v0).getLifecycle().addObserver(new SavedStateHandleAttacher(v1_1));
        }
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        SavedStateProvider v1 = arg1.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if((v1 instanceof SavedStateHandlesProvider)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((SavedStateHandlesProvider)v1);
        }

        throw new IllegalStateException("enableSavedStateHandles() wasn\'t called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        return Companion.create$default(ViewModelProvider.Companion, arg7, new SavedStateHandleSupport$savedStateHandlesVM$1(), null, 4, null).get("androidx.lifecycle.internal.SavedStateHandlesVM", Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class));
    }
}

