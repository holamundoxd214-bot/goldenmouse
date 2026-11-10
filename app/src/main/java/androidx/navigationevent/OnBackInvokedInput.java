package androidx.navigationevent;

import android.os.Build$VERSION;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\rH\u0014J\u0010\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u000BH\u0014J\u0010\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u000BH\u0002J\b\u0010\u0012\u001A\u00020\tH\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2={"Landroidx/navigationevent/OnBackInvokedInput;", "Landroidx/navigationevent/NavigationEventInput;", "onBackInvokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallbackPriority", "", "<init>", "(Landroid/window/OnBackInvokedDispatcher;I)V", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "backInvokedCallbackRegistered", "", "onRemoved", "", "onHasEnabledHandlersChanged", "hasEnabledHandlers", "updateBackInvokedCallbackState", "shouldBeRegistered", "createOnBackAnimationCallback", "Landroidx/navigationevent/OnBackInvokedDefaultInput;", "Landroidx/navigationevent/OnBackInvokedOverlayInput;", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class OnBackInvokedInput extends NavigationEventInput {
    private boolean backInvokedCallbackRegistered;
    private final OnBackInvokedCallback onBackInvokedCallback;
    private final int onBackInvokedCallbackPriority;
    private final OnBackInvokedDispatcher onBackInvokedDispatcher;

    private OnBackInvokedInput(OnBackInvokedDispatcher arg1, int arg2) {
        OnBackInvokedInput$$ExternalSyntheticLambda0 v1;
        super();
        this.onBackInvokedDispatcher = arg1;
        this.onBackInvokedCallbackPriority = arg2;
        if(Build$VERSION.SDK_INT == 33) {
            v1 = new OnBackInvokedInput$$ExternalSyntheticLambda0(this);
        }
        else {
            OnBackInvokedCallback v1_1 = this.createOnBackAnimationCallback();
        }

        this.onBackInvokedCallback = ((OnBackInvokedCallback)v1);
    }

    public OnBackInvokedInput(OnBackInvokedDispatcher arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private final OnBackInvokedCallback createOnBackAnimationCallback() {
        return new OnBackInvokedInput$createOnBackAnimationCallback$1(this);
    }

    static final void onBackInvokedCallback$lambda$0(OnBackInvokedInput arg0) {
        arg0.dispatchOnBackCompleted();
    }

    protected void onHasEnabledHandlersChanged(boolean arg1) {
        this.updateBackInvokedCallbackState(arg1);
    }

    protected void onRemoved() {
        this.updateBackInvokedCallbackState(false);
    }

    private final void updateBackInvokedCallbackState(boolean arg3) {
        if((arg3) && !this.backInvokedCallbackRegistered) {
            this.onBackInvokedDispatcher.registerOnBackInvokedCallback(this.onBackInvokedCallbackPriority, this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
            return;
        }

        if(!arg3 && (this.backInvokedCallbackRegistered)) {
            this.onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }
}

