package androidx.lifecycle.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B.\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BB0\b\u0016\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\rR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR%\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\b\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "T", "Landroidx/lifecycle/ViewModel;", "", "clazz", "Lkotlin/reflect/KClass;", "initializer", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Class;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "getClazz$lifecycle_viewmodel", "()Lkotlin/reflect/KClass;", "getInitializer$lifecycle_viewmodel", "()Lkotlin/jvm/functions/Function1;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelInitializer {
    private final KClass clazz;
    private final Function1 initializer;

    public ViewModelInitializer(KClass arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "clazz");
        Intrinsics.checkNotNullParameter(arg3, "initializer");
        super();
        this.clazz = arg2;
        this.initializer = arg3;
    }

    public ViewModelInitializer(Class arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "clazz");
        Intrinsics.checkNotNullParameter(arg3, "initializer");
        this(JvmClassMappingKt.getKotlinClass(arg2), arg3);
    }

    public final KClass getClazz$lifecycle_viewmodel() {
        return this.clazz;
    }

    public final Function1 getInitializer$lifecycle_viewmodel() {
        return this.initializer;
    }
}

