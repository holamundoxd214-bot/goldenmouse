package androidx.navigationevent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001F\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\nJ\u0006\u0010$\u001A\u00020%J5\u0010&\u001A\u00020%2\u0006\u0010\f\u001A\u00028\u00002\u000E\b\u0002\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\u000E\b\u0002\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0007¢\u0006\u0002\u0010\'J\u0015\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0015J\u0015\u0010-\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0000¢\u0006\u0002\b.J\u0010\u0010/\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0015J\r\u00100\u001A\u00020%H\u0000¢\u0006\u0002\b1J\b\u00102\u001A\u00020%H\u0015J\r\u00103\u001A\u00020%H\u0000¢\u0006\u0002\b4J\b\u00105\u001A\u00020%H\u0015J\u0015\u00106\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0015J\u0015\u00109\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0000¢\u0006\u0002\b:J\u0010\u0010;\u001A\u00020%2\u0006\u0010)\u001A\u00020*H\u0015J\r\u0010<\u001A\u00020%H\u0000¢\u0006\u0002\b=J\b\u0010>\u001A\u00020%H\u0015J\r\u0010?\u001A\u00020%H\u0000¢\u0006\u0002\b@J\b\u0010A\u001A\u00020%H\u0015R \u0010\f\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u0000@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER*\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u001E\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\u0016@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u00068F@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u001A\"\u0004\b\u001B\u0010\u001CR&\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u00068F@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\u001A\"\u0004\b\u001D\u0010\u001CR\u001C\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006B"}, d2={"Landroidx/navigationevent/NavigationEventHandler;", "T", "Landroidx/navigationevent/NavigationEventInfo;", "", "initialInfo", "isBackEnabled", "", "isForwardEnabled", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;ZZ)V", "(Landroidx/navigationevent/NavigationEventInfo;Z)V", "value", "currentInfo", "getCurrentInfo", "()Landroidx/navigationevent/NavigationEventInfo;", "Landroidx/navigationevent/NavigationEventInfo;", "", "backInfo", "getBackInfo", "()Ljava/util/List;", "forwardInfo", "getForwardInfo", "Landroidx/navigationevent/NavigationEventTransitionState;", "transitionState", "getTransitionState", "()Landroidx/navigationevent/NavigationEventTransitionState;", "()Z", "setBackEnabled", "(Z)V", "setForwardEnabled", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher$navigationevent", "()Landroidx/navigationevent/NavigationEventDispatcher;", "setDispatcher$navigationevent", "(Landroidx/navigationevent/NavigationEventDispatcher;)V", "remove", "", "setInfo", "(Landroidx/navigationevent/NavigationEventInfo;Ljava/util/List;Ljava/util/List;)V", "doOnBackStarted", "event", "Landroidx/navigationevent/NavigationEvent;", "doOnBackStarted$navigationevent", "onBackStarted", "doOnBackProgressed", "doOnBackProgressed$navigationevent", "onBackProgressed", "doOnBackCompleted", "doOnBackCompleted$navigationevent", "onBackCompleted", "doOnBackCancelled", "doOnBackCancelled$navigationevent", "onBackCancelled", "doOnForwardStarted", "doOnForwardStarted$navigationevent", "onForwardStarted", "doOnForwardProgressed", "doOnForwardProgressed$navigationevent", "onForwardProgressed", "doOnForwardCompleted", "doOnForwardCompleted$navigationevent", "onForwardCompleted", "doOnForwardCancelled", "doOnForwardCancelled$navigationevent", "onForwardCancelled", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class NavigationEventHandler {
    private List backInfo;
    private NavigationEventInfo currentInfo;
    private NavigationEventDispatcher dispatcher;
    private List forwardInfo;
    private boolean isBackEnabled;
    private boolean isForwardEnabled;
    private NavigationEventTransitionState transitionState;

    public NavigationEventHandler(NavigationEventInfo arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "initialInfo");
        this(arg2, arg3, false);
    }

    public NavigationEventHandler(NavigationEventInfo arg2, boolean arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "initialInfo");
        super();
        this.currentInfo = arg2;
        this.backInfo = CollectionsKt.emptyList();
        this.forwardInfo = CollectionsKt.emptyList();
        this.transitionState = Idle.INSTANCE;
        this.isBackEnabled = arg3;
        this.isForwardEnabled = arg4;
    }

    public final void doOnBackCancelled$navigationevent() {
        this.transitionState = Idle.INSTANCE;
        this.onBackCancelled();
    }

    public final void doOnBackCompleted$navigationevent() {
        this.transitionState = Idle.INSTANCE;
        this.onBackCompleted();
    }

    public final void doOnBackProgressed$navigationevent(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        this.transitionState = new InProgress(arg3, -1);
        this.onBackProgressed(arg3);
    }

    public final void doOnBackStarted$navigationevent(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        this.transitionState = new InProgress(arg3, -1);
        this.onBackStarted(arg3);
    }

    public final void doOnForwardCancelled$navigationevent() {
        this.transitionState = Idle.INSTANCE;
        this.onForwardCancelled();
    }

    public final void doOnForwardCompleted$navigationevent() {
        this.transitionState = Idle.INSTANCE;
        this.onForwardCompleted();
    }

    public final void doOnForwardProgressed$navigationevent(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        this.transitionState = new InProgress(arg3, 1);
        this.onForwardProgressed(arg3);
    }

    public final void doOnForwardStarted$navigationevent(NavigationEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        this.transitionState = new InProgress(arg3, 1);
        this.onForwardStarted(arg3);
    }

    public final List getBackInfo() {
        return this.backInfo;
    }

    public final NavigationEventInfo getCurrentInfo() {
        return this.currentInfo;
    }

    public final NavigationEventDispatcher getDispatcher$navigationevent() {
        return this.dispatcher;
    }

    public final List getForwardInfo() {
        return this.forwardInfo;
    }

    public final NavigationEventTransitionState getTransitionState() {
        return this.transitionState;
    }

    public final boolean isBackEnabled() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null && !v0.isEnabled()) {
            return 0;
        }

        return this.isBackEnabled;
    }

    public final boolean isForwardEnabled() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null && !v0.isEnabled()) {
            return 0;
        }

        return this.isForwardEnabled;
    }

    protected void onBackCancelled() {
    }

    protected void onBackCompleted() {
        throw new UnsupportedOperationException("A handler that receives a \'backCompleted\' event must override \'onBackCompleted()\' to handle the callback.");
    }

    protected void onBackProgressed(NavigationEvent arg1) {
        Intrinsics.checkNotNullParameter(arg1, "event");
    }

    protected void onBackStarted(NavigationEvent arg1) {
        Intrinsics.checkNotNullParameter(arg1, "event");
    }

    protected void onForwardCancelled() {
    }

    protected void onForwardCompleted() {
        throw new UnsupportedOperationException("A handler that receives a \'forwardCompleted\' event must override \'onForwardCompleted()\' to handle the callback.");
    }

    protected void onForwardProgressed(NavigationEvent arg1) {
        Intrinsics.checkNotNullParameter(arg1, "event");
    }

    protected void onForwardStarted(NavigationEvent arg1) {
        Intrinsics.checkNotNullParameter(arg1, "event");
    }

    public final void remove() {
        NavigationEventDispatcher v0 = this.dispatcher;
        if(v0 != null) {
            v0.removeHandler$navigationevent(this);
        }
    }

    public final void setBackEnabled(boolean arg2) {
        if(this.isBackEnabled == arg2) {
        }
        else {
            this.isBackEnabled = arg2;
            NavigationEventDispatcher v1 = this.dispatcher;
            if(v1 != null) {
                NavigationEventProcessor v1_1 = v1.getSharedProcessor$navigationevent();
                if(v1_1 != null) {
                    v1_1.refreshEnabledHandlers();
                }
            }
        }
    }

    public final void setDispatcher$navigationevent(NavigationEventDispatcher arg1) {
        this.dispatcher = arg1;
    }

    public final void setForwardEnabled(boolean arg2) {
        if(this.isForwardEnabled == arg2) {
        }
        else {
            this.isForwardEnabled = arg2;
            NavigationEventDispatcher v1 = this.dispatcher;
            if(v1 != null) {
                NavigationEventProcessor v1_1 = v1.getSharedProcessor$navigationevent();
                if(v1_1 != null) {
                    v1_1.refreshEnabledHandlers();
                }
            }
        }
    }

    public final void setInfo(NavigationEventInfo arg2, List arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg2, "currentInfo");
        Intrinsics.checkNotNullParameter(arg3, "backInfo");
        Intrinsics.checkNotNullParameter(arg4, "forwardInfo");
        this.currentInfo = arg2;
        this.backInfo = arg3;
        this.forwardInfo = arg4;
        NavigationEventDispatcher v2 = this.dispatcher;
        if(v2 != null) {
            NavigationEventProcessor v2_1 = v2.getSharedProcessor$navigationevent();
            if(v2_1 != null) {
                v2_1.updateEnabledHandlerInfo$navigationevent(this);
            }
        }
    }

    public final void setInfo(NavigationEventInfo arg8) {
        Intrinsics.checkNotNullParameter(arg8, "currentInfo");
        NavigationEventHandler.setInfo$default(this, arg8, null, null, 6, null);
    }

    public final void setInfo(NavigationEventInfo arg8, List arg9) {
        Intrinsics.checkNotNullParameter(arg8, "currentInfo");
        Intrinsics.checkNotNullParameter(arg9, "backInfo");
        NavigationEventHandler.setInfo$default(this, arg8, arg9, null, 4, null);
    }

    public static void setInfo$default(NavigationEventHandler arg0, NavigationEventInfo arg1, List arg2, List arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = CollectionsKt.emptyList();
            }

            if((arg4 & 4) != 0) {
                arg3 = CollectionsKt.emptyList();
            }

            arg0.setInfo(arg1, arg2, arg3);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setInfo");
    }
}

