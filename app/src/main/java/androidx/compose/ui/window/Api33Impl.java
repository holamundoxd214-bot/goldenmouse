package androidx.compose.ui.window;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u001A\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0007J\u001A\u0010\r\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/window/Api33Impl;", "", "<init>", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api33Impl {
    public static final Api33Impl INSTANCE;

    static {
        Api33Impl.INSTANCE = new Api33Impl();
    }

    private Api33Impl() {
        super();
    }

    @JvmStatic public static final OnBackInvokedCallback createBackCallback(Function0 arg1) {
        return new Api33Impl$$ExternalSyntheticLambda0(arg1);
    }

    static final void createBackCallback$lambda$0(Function0 arg0) {
        if(arg0 != null) {
            arg0.invoke();
        }
    }

    @JvmStatic public static final void maybeRegisterBackCallback(View arg1, Object arg2) {
        if((arg2 instanceof OnBackInvokedCallback)) {
            OnBackInvokedDispatcher v1 = arg1.findOnBackInvokedDispatcher();
            if(v1 != null) {
                v1.registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)arg2));
            }
        }
    }

    @JvmStatic public static final void maybeUnregisterBackCallback(View arg1, Object arg2) {
        if((arg2 instanceof OnBackInvokedCallback)) {
            OnBackInvokedDispatcher v1 = arg1.findOnBackInvokedDispatcher();
            if(v1 != null) {
                v1.unregisterOnBackInvokedCallback(((OnBackInvokedCallback)arg2));
            }
        }
    }
}

