package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001B\b\u0016\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0003\u0010\tB%\b\u0017\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0003\u0010\fJ-\u0010\u0012\u001A\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00130\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J-\u0010\u0012\u001A\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00130\u001A2\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001BJ+\u0010\u0012\u001A\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u001C\u001A\u00020\u001D2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00130\u001A¢\u0006\u0002\u0010\u001EJ%\u0010\u0012\u001A\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00130\u001AH\u0016¢\u0006\u0002\u0010\u001FJ\u0010\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0014H\u0017R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "factory", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavedStateViewModelFactory extends OnRequeryFactory implements Factory {
    private Application application;
    private Bundle defaultArgs;
    private final Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory(Application arg2, SavedStateRegistryOwner arg3, Bundle arg4) {
        Intrinsics.checkNotNullParameter(arg3, "owner");
        super();
        this.savedStateRegistry = arg3.getSavedStateRegistry();
        this.lifecycle = arg3.getLifecycle();
        this.defaultArgs = arg4;
        this.application = arg2;
        AndroidViewModelFactory v2 = arg2 != null ? AndroidViewModelFactory.Companion.getInstance(arg2) : new AndroidViewModelFactory();
        this.factory = ((Factory)v2);
    }

    public SavedStateViewModelFactory() {
        super();
        this.factory = new AndroidViewModelFactory();
    }

    public SavedStateViewModelFactory(Application arg2, SavedStateRegistryOwner arg3) {
        Intrinsics.checkNotNullParameter(arg3, "owner");
        this(arg2, arg3, null);
    }

    public ViewModel create(Class arg2) {
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        String v0 = arg2.getCanonicalName();
        if(v0 != null) {
            return this.create(v0, arg2);
        }

        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final ViewModel create(String arg6, Class arg7) {
        ViewModel v5_1;
        Intrinsics.checkNotNullParameter(arg6, "key");
        Intrinsics.checkNotNullParameter(arg7, "modelClass");
        Lifecycle v0 = this.lifecycle;
        if(v0 != null) {
            boolean v1 = AndroidViewModel.class.isAssignableFrom(arg7);
            Constructor v2 = !v1 || this.application == null ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(arg7, SavedStateViewModelFactory_androidKt.access$getVIEWMODEL_SIGNATURE$p()) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(arg7, SavedStateViewModelFactory_androidKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
            if(v2 == null) {
                if(this.application != null) {
                    return this.factory.create(arg7);
                }

                return NewInstanceFactory.Companion.getInstance().create(arg7);
            }

            SavedStateRegistry v3 = this.savedStateRegistry;
            Intrinsics.checkNotNull(v3);
            SavedStateHandleController v6 = LegacySavedStateHandleController.create(v3, v0, arg6, this.defaultArgs);
            if(v1) {
                Application v5 = this.application;
                if(v5 != null) {
                    Intrinsics.checkNotNull(v5);
                    v5_1 = SavedStateViewModelFactory_androidKt.newInstance(arg7, v2, new Object[]{v5, v6.getHandle()});
                }
                else {
                    goto label_38;
                }
            }
            else {
            label_38:
                v5_1 = SavedStateViewModelFactory_androidKt.newInstance(arg7, v2, new Object[]{v6.getHandle()});
            }

            v5_1.addCloseable("androidx.lifecycle.savedstate.vm.tag", ((AutoCloseable)v6));
            return v5_1;
        }

        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public ViewModel create(Class arg4, CreationExtras arg5) {
        Intrinsics.checkNotNullParameter(arg4, "modelClass");
        Intrinsics.checkNotNullParameter(arg5, "extras");
        Object v0 = arg5.get(ViewModelProvider.VIEW_MODEL_KEY);
        if(v0 != null) {
            if(arg5.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && arg5.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                v0 = arg5.get(AndroidViewModelFactory.APPLICATION_KEY);
                boolean v1 = AndroidViewModel.class.isAssignableFrom(arg4);
                Constructor v2 = !v1 || v0 == null ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(arg4, SavedStateViewModelFactory_androidKt.access$getVIEWMODEL_SIGNATURE$p()) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(arg4, SavedStateViewModelFactory_androidKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
                if(v2 == null) {
                    return this.factory.create(arg4, arg5);
                }

                if((v1) && v0 != null) {
                    return SavedStateViewModelFactory_androidKt.newInstance(arg4, v2, new Object[]{v0, SavedStateHandleSupport.createSavedStateHandle(arg5)});
                }

                return SavedStateViewModelFactory_androidKt.newInstance(arg4, v2, new Object[]{SavedStateHandleSupport.createSavedStateHandle(arg5)});
            }

            if(this.lifecycle != null) {
                return this.create(((String)v0), arg4);
            }

            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }

        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    public ViewModel create(KClass arg2, CreationExtras arg3) {
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        Intrinsics.checkNotNullParameter(arg3, "extras");
        return this.create(JvmClassMappingKt.getJavaClass(arg2), arg3);
    }

    public void onRequery(ViewModel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "viewModel");
        if(this.lifecycle != null) {
            SavedStateRegistry v0 = this.savedStateRegistry;
            Intrinsics.checkNotNull(v0);
            Lifecycle v1 = this.lifecycle;
            Intrinsics.checkNotNull(v1);
            LegacySavedStateHandleController.attachHandleIfNeeded(arg2, v0, v1);
        }
    }
}

