package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BC\b\u0007\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000F\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2={"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelLazy implements Lazy {
    private ViewModel cached;
    private final Function0 extrasProducer;
    private final Function0 factoryProducer;
    private final Function0 storeProducer;
    private final KClass viewModelClass;

    public ViewModelLazy(KClass arg2, Function0 arg3, Function0 arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg2, "viewModelClass");
        Intrinsics.checkNotNullParameter(arg3, "storeProducer");
        Intrinsics.checkNotNullParameter(arg4, "factoryProducer");
        Intrinsics.checkNotNullParameter(arg5, "extrasProducer");
        super();
        this.viewModelClass = arg2;
        this.storeProducer = arg3;
        this.factoryProducer = arg4;
        this.extrasProducer = arg5;
    }

    public ViewModelLazy(KClass arg9, Function0 arg10, Function0 arg11) {
        Intrinsics.checkNotNullParameter(arg9, "viewModelClass");
        Intrinsics.checkNotNullParameter(arg10, "storeProducer");
        Intrinsics.checkNotNullParameter(arg11, "factoryProducer");
        this(arg9, arg10, arg11, null, 8, null);
    }

    public ViewModelLazy(KClass arg1, Function0 arg2, Function0 arg3, Function0 arg4, int arg5, DefaultConstructorMarker arg6) {
        ViewModelLazy$$ExternalSyntheticLambda0 v4;
        if((arg5 & 8) != 0) {
            v4 = new ViewModelLazy$$ExternalSyntheticLambda0();
        }

        this(arg1, arg2, arg3, ((Function0)v4));
    }

    static final Empty _init_$lambda$0() {
        return Empty.INSTANCE;
    }

    public ViewModel getValue() {
        ViewModel v0 = this.cached;
        if(v0 == null) {
            v0 = ViewModelProvider.Companion.create(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(this.viewModelClass);
            this.cached = v0;
        }

        return v0;
    }

    public Object getValue() {
        return this.getValue();
    }

    public boolean isInitialized() {
        if(this.cached != null) {
            return 1;
        }

        return 0;
    }
}

