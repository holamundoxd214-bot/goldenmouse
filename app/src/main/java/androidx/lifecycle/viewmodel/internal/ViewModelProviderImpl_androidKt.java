package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A5\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"createViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "modelClass", "Lkotlin/reflect/KClass;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelProviderImpl_androidKt {
    public static final ViewModel createViewModel(Factory arg1, KClass arg2, CreationExtras arg3) {
        ViewModel v1;
        Intrinsics.checkNotNullParameter(arg1, "factory");
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        Intrinsics.checkNotNullParameter(arg3, "extras");
        try {
            v1 = arg1.create(arg2, arg3);
            return v1;
        }
        catch(AbstractMethodError ) {
            try {
                v1 = ((Factory)v1).create(JvmClassMappingKt.getJavaClass(arg2), arg3);
            }
            catch(AbstractMethodError ) {
                v1 = ((Factory)v1).create(JvmClassMappingKt.getJavaClass(arg2));
            }

            return v1;
        }
    }
}

