package androidx.navigationevent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\b\u000FJ\u0010\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u0005H\u0015J\r\u0010\u0011\u001A\u00020\u000EH\u0001¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001A\u00020\u000EH\u0015J\u0015\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u000BH\u0015J\u0015\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u001AH\u0001¢\u0006\u0002\b\u001BJ\u0010\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u001AH\u0015J\u0010\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u001FH\u0005J\u0010\u0010 \u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u001FH\u0005J\b\u0010!\u001A\u00020\u000EH\u0005J\b\u0010\"\u001A\u00020\u000EH\u0005J\u0010\u0010#\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u001FH\u0005J\u0010\u0010$\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u001FH\u0005J\b\u0010%\u001A\u00020\u000EH\u0005J\b\u0010&\u001A\u00020\u000EH\u0005R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Landroidx/navigationevent/NavigationEventInput;", "", "<init>", "()V", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher$navigationevent", "()Landroidx/navigationevent/NavigationEventDispatcher;", "setDispatcher$navigationevent", "(Landroidx/navigationevent/NavigationEventDispatcher;)V", "isPredictiveBackInProgress", "", "isPredictiveForwardInProgress", "doOnAdded", "", "doOnAdded$navigationevent", "onAdded", "doOnRemoved", "doOnRemoved$navigationevent", "onRemoved", "doOnHasEnabledHandlersChanged", "hasEnabledHandlers", "doOnHasEnabledHandlersChanged$navigationevent", "onHasEnabledHandlersChanged", "doOnHistoryChanged", "history", "Landroidx/navigationevent/NavigationEventHistory;", "doOnHistoryChanged$navigationevent", "onHistoryChanged", "dispatchOnBackStarted", "event", "Landroidx/navigationevent/NavigationEvent;", "dispatchOnBackProgressed", "dispatchOnBackCancelled", "dispatchOnBackCompleted", "dispatchOnForwardStarted", "dispatchOnForwardProgressed", "dispatchOnForwardCancelled", "dispatchOnForwardCompleted", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class NavigationEventInput {
    private NavigationEventDispatcher dispatcher;
    private boolean isPredictiveBackInProgress;
    private boolean isPredictiveForwardInProgress;

    public NavigationEventInput() {
        super();
    }

    protected final void dispatchOnBackCancelled() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            int v2 = -1;
            if(!this.isPredictiveBackInProgress) {
                v0.dispatchOnStarted$navigationevent(this, v2, null);
            }

            v0.dispatchOnCancelled$navigationevent(this, v2);
            this.isPredictiveBackInProgress = false;
            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnBackCompleted() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            int v2 = -1;
            if(!this.isPredictiveBackInProgress) {
                v0.dispatchOnStarted$navigationevent(this, v2, null);
            }

            v0.dispatchOnCompleted$navigationevent(this, v2);
            this.isPredictiveBackInProgress = false;
            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnBackProgressed(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(this.isPredictiveBackInProgress) {
                v0.dispatchOnProgressed$navigationevent(this, -1, arg3);
            }

            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnBackStarted(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(!this.isPredictiveBackInProgress) {
                v0.dispatchOnStarted$navigationevent(this, -1, arg3);
                this.isPredictiveBackInProgress = true;
            }

            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnForwardCancelled() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(!this.isPredictiveForwardInProgress) {
                v0.dispatchOnStarted$navigationevent(this, 1, null);
            }

            v0.dispatchOnCancelled$navigationevent(this, 1);
            this.isPredictiveForwardInProgress = false;
            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnForwardCompleted() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(!this.isPredictiveForwardInProgress) {
                v0.dispatchOnStarted$navigationevent(this, 1, null);
            }

            v0.dispatchOnCompleted$navigationevent(this, 1);
            this.isPredictiveForwardInProgress = false;
            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnForwardProgressed(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(this.isPredictiveForwardInProgress) {
                v0.dispatchOnProgressed$navigationevent(this, 1, arg3);
            }

            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    protected final void dispatchOnForwardStarted(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            if(!this.isPredictiveForwardInProgress) {
                v0.dispatchOnStarted$navigationevent(this, 1, arg3);
                this.isPredictiveForwardInProgress = true;
            }

            return;
        }

        throw new IllegalStateException("This input is not added to any dispatcher.".toString());
    }

    public final void doOnAdded$navigationevent(NavigationEventDispatcher arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dispatcher");
        this.onAdded(arg2);
    }

    public final void doOnHasEnabledHandlersChanged$navigationevent(boolean arg1) {
        this.onHasEnabledHandlersChanged(arg1);
    }

    public final void doOnHistoryChanged$navigationevent(NavigationEventHistory arg2) {
        Intrinsics.checkNotNullParameter(arg2, "history");
        this.onHistoryChanged(arg2);
    }

    public final void doOnRemoved$navigationevent() {
        this.onRemoved();
    }

    public final NavigationEventDispatcher getDispatcher$navigationevent() {
        return this.dispatcher;
    }

    protected void onAdded(NavigationEventDispatcher arg1) {
        Intrinsics.checkNotNullParameter(arg1, "dispatcher");
    }

    protected void onHasEnabledHandlersChanged(boolean arg1) {
    }

    protected void onHistoryChanged(NavigationEventHistory arg1) {
        Intrinsics.checkNotNullParameter(arg1, "history");
    }

    protected void onRemoved() {
    }

    public final void setDispatcher$navigationevent(NavigationEventDispatcher arg1) {
        this.dispatcher = arg1;
    }
}

