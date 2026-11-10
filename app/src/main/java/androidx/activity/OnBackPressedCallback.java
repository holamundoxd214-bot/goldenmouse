package androidx.activity;

import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001A\u00020\u0012H\u0007J\u0010\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0017J\u0010\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0017J\b\u0010\u0017\u001A\u00020\u0012H\'J\b\u0010\u0018\u001A\u00020\u0012H\u0017J\u0019\u0010\u0019\u001A\u00020\u00122\n\u0010\u001A\u001A\u00060\u000Fj\u0002`\u0010H\u0000¢\u0006\u0002\b\u001BJ\u0019\u0010\u001C\u001A\u00020\u00122\n\u0010\u001A\u001A\u00060\u000Fj\u0002`\u0010H\u0000¢\u0006\u0002\b\u001DJ\u0015\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020 H\u0000¢\u0006\u0002\b!R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038\u0007@GX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\u0005R\u0018\u0010\r\u001A\f\u0012\b\u0012\u00060\u000Fj\u0002`\u00100\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/activity/OnBackPressedCallback;", "", "enabled", "", "<init>", "(Z)V", "eventHandlers", "", "Landroidx/activity/OnBackPressedCallback$OnBackPressedEventHandler;", "value", "isEnabled", "()Z", "setEnabled", "closeables", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "remove", "", "handleOnBackStarted", "backEvent", "Landroidx/activity/BackEventCompat;", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "addCloseable", "closeable", "addCloseable$activity", "removeCloseable", "removeCloseable$activity", "createNavigationEventHandler", "info", "Landroidx/navigationevent/NavigationEventInfo;", "createNavigationEventHandler$activity", "OnBackPressedEventHandler", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class OnBackPressedCallback {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0014J\u0010\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0014J\b\u0010\u0013\u001A\u00020\u000FH\u0014J\b\u0010\u0014\u001A\u00020\u000FH\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2={"Landroidx/activity/OnBackPressedCallback$OnBackPressedEventHandler;", "Landroidx/navigationevent/NavigationEventHandler;", "Landroidx/navigationevent/NavigationEventInfo;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "info", "<init>", "(Landroidx/activity/OnBackPressedCallback;Landroidx/navigationevent/NavigationEventInfo;)V", "value", "", "isLifecycleActive", "()Z", "setLifecycleActive", "(Z)V", "onBackStarted", "", "event", "Landroidx/navigationevent/NavigationEvent;", "onBackProgressed", "onBackCompleted", "onBackCancelled", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OnBackPressedEventHandler extends NavigationEventHandler {
        private boolean isLifecycleActive;
        private final OnBackPressedCallback onBackPressedCallback;

        public OnBackPressedEventHandler(OnBackPressedCallback arg2, NavigationEventInfo arg3) {
            Intrinsics.checkNotNullParameter(arg2, "onBackPressedCallback");
            Intrinsics.checkNotNullParameter(arg3, "info");
            super(arg3, arg2.isEnabled());
            this.onBackPressedCallback = arg2;
            this.isLifecycleActive = true;
        }

        public final boolean isLifecycleActive() {
            return this.isLifecycleActive;
        }

        protected void onBackCancelled() {
            this.onBackPressedCallback.handleOnBackCancelled();
        }

        protected void onBackCompleted() {
            this.onBackPressedCallback.handleOnBackPressed();
        }

        protected void onBackProgressed(NavigationEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            this.onBackPressedCallback.handleOnBackProgressed(new BackEventCompat(arg2));
        }

        protected void onBackStarted(NavigationEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            this.onBackPressedCallback.handleOnBackStarted(new BackEventCompat(arg2));
        }

        public final void setLifecycleActive(boolean arg1) {
            this.isLifecycleActive = arg1;
            arg1 = !arg1 || !this.onBackPressedCallback.isEnabled() ? false : true;
            this.setBackEnabled(arg1);
        }
    }

    private final CopyOnWriteArrayList closeables;
    private final List eventHandlers;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean arg2) {
        super();
        this.eventHandlers = new ArrayList();
        this.isEnabled = arg2;
        this.closeables = new CopyOnWriteArrayList();
    }

    public final void addCloseable$activity(AutoCloseable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeable");
        this.closeables.add(arg2);
    }

    public final OnBackPressedEventHandler createNavigationEventHandler$activity(NavigationEventInfo arg2) {
        Intrinsics.checkNotNullParameter(arg2, "info");
        OnBackPressedEventHandler v0 = new OnBackPressedEventHandler(this, arg2);
        this.eventHandlers.add(v0);
        return v0;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(BackEventCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "backEvent");
    }

    public void handleOnBackStarted(BackEventCompat arg1) {
        Intrinsics.checkNotNullParameter(arg1, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        Iterator v0 = this.closeables.iterator();
        Intrinsics.checkNotNullExpressionValue(v0, "iterator(...)");
        while(v0.hasNext()) {
            OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(v0.next());
        }

        this.closeables.clear();
        v0 = this.eventHandlers.iterator();
        while(v0.hasNext()) {
            v0.next().remove();
        }

        this.eventHandlers.clear();
    }

    public final void removeCloseable$activity(AutoCloseable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "closeable");
        this.closeables.remove(arg2);
    }

    public final void setEnabled(boolean arg3) {
        this.isEnabled = arg3;
        Iterator v2 = this.eventHandlers.iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            boolean v1 = !((OnBackPressedEventHandler)v0).isLifecycleActive() || !arg3 ? false : true;
            ((OnBackPressedEventHandler)v0).setBackEnabled(v1);
        }
    }
}

