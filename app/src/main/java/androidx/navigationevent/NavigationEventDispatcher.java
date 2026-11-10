package androidx.navigationevent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u0001:\u0002<=B\u001D\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0000\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001E\u0010%\u001A\u00020&2\n\u0010\'\u001A\u0006\u0012\u0002\b\u00030\u001A2\b\b\u0002\u0010(\u001A\u00020)H\u0007J\u0019\u0010*\u001A\u00020&2\n\u0010\'\u001A\u0006\u0012\u0002\b\u00030\u001AH\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001CH\u0007J\u0018\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020)H\u0007J\u0010\u0010.\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001CH\u0007J\'\u0010/\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001C2\u0006\u00100\u001A\u00020)2\b\u00101\u001A\u0004\u0018\u000102H\u0000¢\u0006\u0002\b3J%\u00104\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001C2\u0006\u00100\u001A\u00020)2\u0006\u00101\u001A\u000202H\u0000¢\u0006\u0002\b5J\u001D\u00106\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001C2\u0006\u00100\u001A\u00020)H\u0000¢\u0006\u0002\b7J\u001D\u00108\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001C2\u0006\u00100\u001A\u00020)H\u0000¢\u0006\u0002\b9J\b\u0010:\u001A\u00020&H\u0007J\b\u0010;\u001A\u00020&H\u0002R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\u00020\u000B8BX\u0082\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\fR&\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B8F@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\f\"\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00000\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001A0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001E8F¢\u0006\u0006\u001A\u0004\b \u0010!R\u0017\u0010\"\u001A\b\u0012\u0004\u0012\u00020#0\u001E8F¢\u0006\u0006\u001A\u0004\b$\u0010!¨\u0006>"}, d2={"Landroidx/navigationevent/NavigationEventDispatcher;", "", "parent", "onBackCompletedFallback", "Landroidx/navigationevent/OnBackCompletedFallback;", "<init>", "(Landroidx/navigationevent/NavigationEventDispatcher;Landroidx/navigationevent/OnBackCompletedFallback;)V", "()V", "(Landroidx/navigationevent/OnBackCompletedFallback;)V", "(Landroidx/navigationevent/NavigationEventDispatcher;)V", "isDisposed", "", "()Z", "value", "isEnabled", "setEnabled", "(Z)V", "sharedProcessor", "Landroidx/navigationevent/NavigationEventProcessor;", "getSharedProcessor$navigationevent", "()Landroidx/navigationevent/NavigationEventProcessor;", "childDispatchers", "", "getChildDispatchers$navigationevent", "()Ljava/util/Set;", "handlers", "Landroidx/navigationevent/NavigationEventHandler;", "inputs", "Landroidx/navigationevent/NavigationEventInput;", "transitionState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/navigationevent/NavigationEventTransitionState;", "getTransitionState", "()Lkotlinx/coroutines/flow/StateFlow;", "history", "Landroidx/navigationevent/NavigationEventHistory;", "getHistory", "addHandler", "", "handler", "priority", "", "removeHandler", "removeHandler$navigationevent", "addInput", "input", "removeInput", "dispatchOnStarted", "direction", "event", "Landroidx/navigationevent/NavigationEvent;", "dispatchOnStarted$navigationevent", "dispatchOnProgressed", "dispatchOnProgressed$navigationevent", "dispatchOnCompleted", "dispatchOnCompleted$navigationevent", "dispatchOnCancelled", "dispatchOnCancelled$navigationevent", "dispose", "checkInvariants", "Priority", "Companion", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationEventDispatcher {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/navigationevent/NavigationEventDispatcher$Companion;", "", "<init>", "()V", "PRIORITY_OVERLAY", "", "PRIORITY_DEFAULT", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/navigationevent/NavigationEventDispatcher$Priority;", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface Priority {
    }

    public static final Companion Companion = null;
    public static final int PRIORITY_DEFAULT = 1;
    public static final int PRIORITY_OVERLAY;
    private final Set childDispatchers;
    private final Set handlers;
    private final Set inputs;
    private boolean isDisposed;
    private boolean isEnabled;
    private final OnBackCompletedFallback onBackCompletedFallback;
    private NavigationEventDispatcher parent;
    private final NavigationEventProcessor sharedProcessor;

    static {
        NavigationEventDispatcher.Companion = new Companion(null);
    }

    public NavigationEventDispatcher(OnBackCompletedFallback arg2) {
        Intrinsics.checkNotNullParameter(arg2, "onBackCompletedFallback");
        this(null, arg2);
    }

    public NavigationEventDispatcher() {
        this(null, null);
    }

    private NavigationEventDispatcher(NavigationEventDispatcher arg1, OnBackCompletedFallback arg2) {
        NavigationEventProcessor v1;
        super();
        this.parent = arg1;
        this.onBackCompletedFallback = arg2;
        this.isEnabled = true;
        if(arg1 != null) {
            v1 = arg1.sharedProcessor;
            if(v1 == null) {
                goto label_8;
            }
        }
        else {
        label_8:
            v1 = new NavigationEventProcessor();
        }

        this.sharedProcessor = v1;
        this.childDispatchers = new LinkedHashSet();
        this.handlers = new LinkedHashSet();
        this.inputs = new LinkedHashSet();
        arg1 = this.parent;
        if(arg1 != null) {
            arg1.childDispatchers.add(this);
        }
    }

    public NavigationEventDispatcher(NavigationEventDispatcher arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        this(arg2, null);
    }

    public final void addHandler(NavigationEventHandler arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "handler");
        this.checkInvariants();
        if(this.handlers.add(arg2)) {
            this.sharedProcessor.addHandler(this, arg2, arg3);
        }
    }

    public final void addHandler(NavigationEventHandler arg4) {
        Intrinsics.checkNotNullParameter(arg4, "handler");
        NavigationEventDispatcher.addHandler$default(this, arg4, 0, 2, null);
    }

    public static void addHandler$default(NavigationEventDispatcher arg0, NavigationEventHandler arg1, int arg2, int arg3, Object arg4) {
        arg0.addHandler(arg1, 1);
    }

    public final void addInput(NavigationEventInput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        this.checkInvariants();
        if(this.inputs.add(arg3)) {
            this.sharedProcessor.addInput(this, arg3, -1);
        }
    }

    public final void addInput(NavigationEventInput arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.checkInvariants();
        if(arg3 != 1) {
            if(arg3 == 0) {
            }
            else {
                throw new IllegalArgumentException("Unsupported priority value: " + arg3.toString());
            }
        }

        if(this.inputs.add(arg2)) {
            this.sharedProcessor.addInput(this, arg2, arg3);
        }
    }

    private final void checkInvariants() {
        if(!this.isDisposed()) {
            return;
        }

        throw new IllegalStateException("This NavigationEventDispatcher has already been disposed and cannot be used.".toString());
    }

    public final void dispatchOnCancelled$navigationevent(NavigationEventInput arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.checkInvariants();
        if(!this.isEnabled()) {
            return;
        }

        this.sharedProcessor.dispatchOnCancelled(arg2, arg3);
    }

    public final void dispatchOnCompleted$navigationevent(NavigationEventInput arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.checkInvariants();
        if(!this.isEnabled()) {
            return;
        }

        this.sharedProcessor.dispatchOnCompleted(arg2, arg3, this.onBackCompletedFallback);
    }

    public final void dispatchOnProgressed$navigationevent(NavigationEventInput arg2, int arg3, NavigationEvent arg4) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg4, "event");
        this.checkInvariants();
        if(!this.isEnabled()) {
            return;
        }

        this.sharedProcessor.dispatchOnProgressed(arg2, arg3, arg4);
    }

    public final void dispatchOnStarted$navigationevent(NavigationEventInput arg2, int arg3, NavigationEvent arg4) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.checkInvariants();
        if(!this.isEnabled()) {
            return;
        }

        this.sharedProcessor.dispatchOnStarted(arg2, arg3, arg4);
    }

    public final void dispose() {
        this.checkInvariants();
        this.isDisposed = true;
        ArrayDeque v1 = new ArrayDeque();
        ArrayDeque v2 = v1;
        ((Collection)v2).add(this);
        while(!((Collection)v2).isEmpty()) {
            Object v3 = v1.removeFirst();
            ((NavigationEventDispatcher)v3).isDisposed = true;
            CollectionsKt.addAll(((Collection)v2), ((NavigationEventDispatcher)v3).childDispatchers);
            Iterator v4 = ((NavigationEventDispatcher)v3).inputs.iterator();
            while(v4.hasNext()) {
                this.sharedProcessor.removeInput(v4.next());
            }

            ((NavigationEventDispatcher)v3).inputs.clear();
            v4 = ((NavigationEventDispatcher)v3).handlers.iterator();
            while(v4.hasNext()) {
                v4.next().remove();
            }

            ((NavigationEventDispatcher)v3).handlers.clear();
            ((NavigationEventDispatcher)v3).childDispatchers.clear();
            NavigationEventDispatcher v4_1 = ((NavigationEventDispatcher)v3).parent;
            if(v4_1 != null) {
                Set v4_2 = v4_1.childDispatchers;
                if(v4_2 != null) {
                    v4_2.remove(v3);
                }
            }

            ((NavigationEventDispatcher)v3).parent = null;
        }
    }

    public final Set getChildDispatchers$navigationevent() {
        return this.childDispatchers;
    }

    public final StateFlow getHistory() {
        return this.sharedProcessor.getHistory();
    }

    public final NavigationEventProcessor getSharedProcessor$navigationevent() {
        return this.sharedProcessor;
    }

    public final StateFlow getTransitionState() {
        return this.sharedProcessor.getTransitionState();
    }

    private final boolean isDisposed() {
        NavigationEventDispatcher v0 = this.parent;
        if(v0 != null && (v0.isDisposed())) {
            return 1;
        }

        return this.isDisposed;
    }

    public final boolean isEnabled() {
        NavigationEventDispatcher v0 = this.parent;
        if(v0 != null && !v0.isEnabled()) {
            return 0;
        }

        return this.isEnabled;
    }

    public final void removeHandler$navigationevent(NavigationEventHandler arg2) {
        Intrinsics.checkNotNullParameter(arg2, "handler");
        if(this.handlers.remove(arg2)) {
            this.sharedProcessor.removeHandler(arg2);
        }
    }

    public final void removeInput(NavigationEventInput arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.checkInvariants();
        if(this.inputs.remove(arg2)) {
            this.sharedProcessor.removeInput(arg2);
        }
    }

    public final void setEnabled(boolean arg2) {
        this.checkInvariants();
        if(this.isEnabled == arg2) {
            return;
        }

        this.isEnabled = arg2;
        this.sharedProcessor.refreshEnabledHandlers();
    }
}

