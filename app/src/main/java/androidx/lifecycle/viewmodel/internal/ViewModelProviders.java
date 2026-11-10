package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0006\u001A\u00020\u0005\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00070\nH\u0000¢\u0006\u0002\b\u000BJ\u0019\u0010\f\u001A\u0002H\r\"\b\b\u0000\u0010\r*\u00020\bH\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0010\u001A\u00020\u00112\u0010\u0010\u0012\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0000¢\u0006\u0002\b\u0015J+\u0010\u0010\u001A\u00020\u00112\u001A\u0010\u0012\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0016\"\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0017JK\u0010\u0018\u001A\u0002H\r\"\b\b\u0000\u0010\r*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\r0\n2\u0006\u0010\u0019\u001A\u00020\u001A2\u001A\u0010\u0012\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0016\"\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u001B\u0010\u001CR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/lifecycle/viewmodel/internal/ViewModelProviders;", "", "<init>", "()V", "VIEW_MODEL_PROVIDER_DEFAULT_KEY", "", "getDefaultKey", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "getDefaultKey$lifecycle_viewmodel", "unsupportedCreateViewModel", "VM", "unsupportedCreateViewModel$lifecycle_viewmodel", "()Landroidx/lifecycle/ViewModel;", "createInitializerFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "createInitializerFactory$lifecycle_viewmodel", "", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "createViewModelFromInitializers", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "createViewModelFromInitializers$lifecycle_viewmodel", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;[Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelProviders {
    public static final ViewModelProviders INSTANCE = null;
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    static {
        ViewModelProviders.INSTANCE = new ViewModelProviders();
    }

    private ViewModelProviders() {
        super();
    }

    public final Factory createInitializerFactory$lifecycle_viewmodel(ViewModelInitializer[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializers");
        return new InitializerViewModelFactory(Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    public final Factory createInitializerFactory$lifecycle_viewmodel(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializers");
        Object[] v2 = arg2.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory(Arrays.copyOf(v2, v2.length));
    }

    public final ViewModel createViewModelFromInitializers$lifecycle_viewmodel(KClass arg5, CreationExtras arg6, ViewModelInitializer[] arg7) {
        ViewModelInitializer v2;
        Object v1;
        Intrinsics.checkNotNullParameter(arg5, "modelClass");
        Intrinsics.checkNotNullParameter(arg6, "extras");
        Intrinsics.checkNotNullParameter(arg7, "initializers");
        int v4 = arg7.length;
        int v0 = 0;
        while(true) {
            v1 = null;
            if(v0 < v4) {
                v2 = arg7[v0];
                if(Intrinsics.areEqual(v2.getClazz$lifecycle_viewmodel(), arg5)) {
                }
                else {
                    ++v0;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_18;
        }

        v2 = ((ViewModelInitializer)v1);
    label_18:
        if(v2 != null) {
            Function1 v4_1 = v2.getInitializer$lifecycle_viewmodel();
            if(v4_1 != null) {
                v1 = v4_1.invoke(arg6);
            }
        }

        if(v1 != null) {
            return ((ViewModel)v1);
        }

        throw new IllegalArgumentException("No initializer set for given class " + CanonicalName_jvmKt.getCanonicalName(arg5).toString());
    }

    public final String getDefaultKey$lifecycle_viewmodel(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        String v1 = CanonicalName_jvmKt.getCanonicalName(arg2);
        if(v1 != null) {
            return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + v1;
        }

        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public final ViewModel unsupportedCreateViewModel$lifecycle_viewmodel() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}

