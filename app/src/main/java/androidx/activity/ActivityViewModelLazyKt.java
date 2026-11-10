package androidx.activity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001AF\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2={"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActivityViewModelLazyKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Superseded by viewModels that takes a CreationExtras") public static final Lazy viewModels(ComponentActivity arg4, Function0 arg5) {
        ActivityViewModelLazyKt$viewModels$factoryPromise$1 v5;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg5 == null) {
            v5 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(arg4);
        }

        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(arg4), ((Function0)v5), new ActivityViewModelLazyKt$viewModels$2(arg4));
    }

    public static final Lazy viewModels(ComponentActivity arg4, Function0 arg5, Function0 arg6) {
        ActivityViewModelLazyKt$viewModels$factoryPromise$2 v6;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg6 == null) {
            v6 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(arg4);
        }

        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(arg4), ((Function0)v6), new ActivityViewModelLazyKt$viewModels$4(arg5, arg4));
    }

    public static Lazy viewModels$default(ComponentActivity arg2, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg3 = null;
        }

        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(0 == 0) {
            ActivityViewModelLazyKt$viewModels$factoryPromise$1 v3 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(arg2);
        }

        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(arg2), arg3, new ActivityViewModelLazyKt$viewModels$2(arg2));
    }

    public static Lazy viewModels$default(ComponentActivity arg2, Function0 arg3, Function0 arg4, int arg5, Object arg6) {
        ActivityViewModelLazyKt$viewModels$factoryPromise$2 v4;
        Function0 v0 = null;
        if((arg5 & 1) != 0) {
            arg3 = v0;
        }

        if((arg5 & 2) != 0) {
            arg4 = v0;
        }

        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg4 == null) {
            v4 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(arg2);
        }

        Intrinsics.reifiedOperationMarker(4, "VM");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(arg2), ((Function0)v4), new ActivityViewModelLazyKt$viewModels$4(arg3, arg2));
    }
}

