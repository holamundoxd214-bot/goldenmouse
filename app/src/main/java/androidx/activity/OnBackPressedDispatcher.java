package androidx.activity;

import android.window.OnBackInvokedDispatcher;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import androidx.navigationevent.OnBackInvokedOverlayInput;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B!\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0007J\u0010\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u001BH\u0007J\u0018\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001A\u001A\u00020\u001BH\u0007J\b\u0010\n\u001A\u00020\u0006H\u0007J\u0010\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020 H\u0007J\u0010\u0010!\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020 H\u0007J\b\u0010\"\u001A\u00020\u0016H\u0007J\b\u0010#\u001A\u00020\u0016H\u0007R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010\u000B\u001A\u00060\fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0011\u001A\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2={"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "<init>", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "(Ljava/lang/Runnable;)V", "hasEnabledCallbacks", "eventInput", "Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "getEventInput", "()Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "eventInput$delegate", "Lkotlin/Lazy;", "eventDispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getEventDispatcher$activity", "()Landroidx/navigationevent/NavigationEventDispatcher;", "setOnBackInvokedDispatcher", "", "invoker", "Landroid/window/OnBackInvokedDispatcher;", "addCallback", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "dispatchOnBackStarted", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackProgressed", "onBackPressed", "dispatchOnBackCancelled", "OnBackPressedEventInput", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OnBackPressedDispatcher {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0014J\u000E\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u000F\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000EJ\u0006\u0010\u0010\u001A\u00020\tJ\u0006\u0010\u0011\u001A\u00020\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "Landroidx/navigationevent/NavigationEventInput;", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;)V", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher", "()Landroidx/navigationevent/NavigationEventDispatcher;", "onHasEnabledHandlersChanged", "", "hasEnabledHandlers", "", "backStarted", "event", "Landroidx/navigationevent/NavigationEvent;", "backProgressed", "backCancelled", "backCompleted", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class OnBackPressedEventInput extends NavigationEventInput {
        private final NavigationEventDispatcher dispatcher;

        public OnBackPressedEventInput(OnBackPressedDispatcher arg3) {
            OnBackPressedDispatcher.this = arg3;
            super();
            NavigationEventDispatcher v0 = new NavigationEventDispatcher(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(arg3));
            v0.addInput(this);
            this.dispatcher = v0;
        }

        public final void backCancelled() {
            this.dispatchOnBackCancelled();
        }

        public final void backCompleted() {
            this.dispatchOnBackCompleted();
        }

        public final void backProgressed(NavigationEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            this.dispatchOnBackProgressed(arg2);
        }

        public final void backStarted(NavigationEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            this.dispatchOnBackStarted(arg2);
        }

        static final void dispatcher$lambda$0(OnBackPressedDispatcher arg0) {
            Runnable v0 = arg0.fallbackOnBackPressed;
            if(v0 != null) {
                v0.run();
            }
        }

        public final NavigationEventDispatcher getDispatcher() {
            return this.dispatcher;
        }

        protected void onHasEnabledHandlersChanged(boolean arg2) {
            OnBackPressedDispatcher.this.hasEnabledCallbacks = arg2;
            Consumer v1 = OnBackPressedDispatcher.this.onHasEnabledCallbacksChanged;
            if(v1 != null) {
                v1.accept(Boolean.valueOf(arg2));
            }
        }
    }

    private final Lazy eventInput$delegate;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private final Consumer onHasEnabledCallbacksChanged;

    public OnBackPressedDispatcher(Runnable arg2) {
        this(arg2, null);
    }

    public OnBackPressedDispatcher() {
        this(null, 1, null);
    }

    public OnBackPressedDispatcher(Runnable arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public OnBackPressedDispatcher(Runnable arg1, Consumer arg2) {
        super();
        this.fallbackOnBackPressed = arg1;
        this.onHasEnabledCallbacksChanged = arg2;
        this.eventInput$delegate = LazyKt.lazy(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(this));
    }

    public static final Runnable access$getFallbackOnBackPressed$p(OnBackPressedDispatcher arg0) {
        return arg0.fallbackOnBackPressed;
    }

    public static final Consumer access$getOnHasEnabledCallbacksChanged$p(OnBackPressedDispatcher arg0) {
        return arg0.onHasEnabledCallbacksChanged;
    }

    public static final void access$setHasEnabledCallbacks$p(OnBackPressedDispatcher arg0, boolean arg1) {
        arg0.hasEnabledCallbacks = arg1;
    }

    public final void addCallback(OnBackPressedCallback arg4) {
        Intrinsics.checkNotNullParameter(arg4, "onBackPressedCallback");
        NavigationEventDispatcher.addHandler$default(this.getEventDispatcher$activity(), arg4.createNavigationEventHandler$activity(new OnBackPressedCallbackInfo(arg4, null, 2, null)), 0, 2, null);
    }

    public final void addCallback(LifecycleOwner arg7, OnBackPressedCallback arg8) {
        Intrinsics.checkNotNullParameter(arg7, "owner");
        Intrinsics.checkNotNullParameter(arg8, "onBackPressedCallback");
        Lifecycle v0 = arg7.getLifecycle();
        if(v0.getCurrentState() == State.DESTROYED) {
            return;
        }

        OnBackPressedEventHandler v7 = arg8.createNavigationEventHandler$activity(new OnBackPressedCallbackInfo(arg8, arg7));
        if(ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
            v7.setLifecycleActive(false);
            NavigationEventDispatcher.addHandler$default(this.getEventDispatcher$activity(), v7, 0, 2, null);
        }

        OnBackPressedDispatcher$addCallback$observer$1 v1 = new OnBackPressedDispatcher$addCallback$observer$1(v7, this, v0);
        v0.addObserver(v1);
        arg8.addCloseable$activity(new OnBackPressedDispatcher$$ExternalSyntheticLambda1(v0, v1));
    }

    static final void addCallback$lambda$0(Lifecycle arg0, OnBackPressedDispatcher$addCallback$observer$1 arg1) {
        arg0.removeObserver(((LifecycleObserver)arg1));
    }

    public final void dispatchOnBackCancelled() {
        this.getEventInput().backCancelled();
    }

    public final void dispatchOnBackProgressed(BackEventCompat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backEvent");
        this.getEventInput().backProgressed(arg2.toNavigationEvent());
    }

    public final void dispatchOnBackStarted(BackEventCompat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backEvent");
        this.getEventInput().backStarted(arg2.toNavigationEvent());
    }

    static final OnBackPressedEventInput eventInput_delegate$lambda$0(OnBackPressedDispatcher arg1) {
        return new OnBackPressedEventInput(arg1);
    }

    public final NavigationEventDispatcher getEventDispatcher$activity() {
        return this.getEventInput().getDispatcher();
    }

    private final OnBackPressedEventInput getEventInput() {
        return this.eventInput$delegate.getValue();
    }

    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public final void onBackPressed() {
        this.getEventInput().backCompleted();
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher arg4) {
        Intrinsics.checkNotNullParameter(arg4, "invoker");
        this.getEventDispatcher$activity().addInput(new OnBackInvokedDefaultInput(arg4), 1);
        this.getEventDispatcher$activity().addInput(new OnBackInvokedOverlayInput(arg4), 0);
    }
}

