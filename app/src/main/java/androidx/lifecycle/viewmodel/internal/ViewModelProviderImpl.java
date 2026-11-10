package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$OnRequeryFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ1\u0010\f\u001A\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\r0\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/lifecycle/viewmodel/internal/ViewModelProviderImpl;", "", "store", "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "key", "", "getViewModel$lifecycle_viewmodel", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelProviderImpl {
    private final CreationExtras defaultExtras;
    private final Factory factory;
    private final SynchronizedObject lock;
    private final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore arg2, Factory arg3, CreationExtras arg4) {
        Intrinsics.checkNotNullParameter(arg2, "store");
        Intrinsics.checkNotNullParameter(arg3, "factory");
        Intrinsics.checkNotNullParameter(arg4, "defaultExtras");
        super();
        this.store = arg2;
        this.factory = arg3;
        this.defaultExtras = arg4;
        this.lock = new SynchronizedObject();
    }

    public static final CreationExtras access$getDefaultExtras$p(ViewModelProviderImpl arg0) {
        return arg0.defaultExtras;
    }

    public static final Factory access$getFactory$p(ViewModelProviderImpl arg0) {
        return arg0.factory;
    }

    public static final ViewModelStore access$getStore$p(ViewModelProviderImpl arg0) {
        return arg0.store;
    }

    public final ViewModel getViewModel$lifecycle_viewmodel(KClass arg4, String arg5) {
        ViewModel v1;
        Intrinsics.checkNotNullParameter(arg4, "modelClass");
        Intrinsics.checkNotNullParameter(arg5, "key");
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = this.store.get(arg5);
            if(arg4.isInstance(v1)) {
                if((this.factory instanceof OnRequeryFactory)) {
                    Factory v3_1 = this.factory;
                    Intrinsics.checkNotNull(v1);
                    ((OnRequeryFactory)v3_1).onRequery(v1);
                }

                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel");
            }
            else {
                MutableCreationExtras v1_1 = new MutableCreationExtras(this.defaultExtras);
                v1_1.set(ViewModelProvider.VIEW_MODEL_KEY, arg5);
                v1 = ViewModelProviderImpl_androidKt.createViewModel(this.factory, arg4, ((CreationExtras)v1_1));
                this.store.put(arg5, v1);
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return v1;
    }

    public static ViewModel getViewModel$lifecycle_viewmodel$default(ViewModelProviderImpl arg0, KClass arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel(arg1);
        }

        return arg0.getViewModel$lifecycle_viewmodel(arg1, arg2);
    }
}

