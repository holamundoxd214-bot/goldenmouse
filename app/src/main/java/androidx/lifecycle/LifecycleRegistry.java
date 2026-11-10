package androidx.lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map$Entry;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0016\u0018\u0000 92\u00020\u0001:\u000289B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0015H\u0017J\u0010\u0010$\u001A\u00020\u00172\u0006\u0010%\u001A\u00020&H\u0016J\u0010\u0010\'\u001A\u00020\u00172\u0006\u0010(\u001A\u00020\u0015H\u0002J\u0010\u0010+\u001A\u00020\u00152\u0006\u0010,\u001A\u00020\u000BH\u0002J\u0010\u0010-\u001A\u00020\u00172\u0006\u0010,\u001A\u00020\u000BH\u0017J\u0010\u0010.\u001A\u00020\u00172\u0006\u0010,\u001A\u00020\u000BH\u0017J\u0010\u00102\u001A\u00020\u00172\u0006\u0010\r\u001A\u00020\u0003H\u0002J\u0010\u00103\u001A\u00020\u00172\u0006\u0010\r\u001A\u00020\u0003H\u0002J\b\u00104\u001A\u00020\u0017H\u0002J\u0010\u00105\u001A\u00020\u00172\u0006\u00106\u001A\u000207H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00158V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00150\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00150!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0014\u0010)\u001A\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b)\u0010*R\u0014\u0010/\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b0\u00101¨\u0006:"}, d2={"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "enforceMainThread", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "observerMap", "Landroidx/lifecycle/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "lifecycleOwner", "Landroidx/lifecycle/WeakReference;", "addingObserverCounter", "", "handlingEvent", "newEventOccurred", "parentStates", "", "Landroidx/lifecycle/Lifecycle$State;", "markState", "", "state", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "moveToState", "next", "isSynced", "()Z", "calculateTargetState", "observer", "addObserver", "removeObserver", "observerCount", "getObserverCount", "()I", "forwardPass", "backwardPass", "sync", "enforceMainThreadIfNeeded", "methodName", "", "ObserverWithState", "Companion", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class LifecycleRegistry extends Lifecycle {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "<init>", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final LifecycleRegistry createUnsafe(LifecycleOwner arg3) {
            Intrinsics.checkNotNullParameter(arg3, "owner");
            return new LifecycleRegistry(arg3, false, null);
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001A\u00020\u0018R\u001A\u0010\b\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2={"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private State state;

        public ObserverWithState(LifecycleObserver arg2, State arg3) {
            Intrinsics.checkNotNullParameter(arg3, "initialState");
            super();
            this.state = arg3;
            Intrinsics.checkNotNull(arg2);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(arg2);
        }

        public final void dispatchEvent(LifecycleOwner arg3, Event arg4) {
            Intrinsics.checkNotNullParameter(arg4, "event");
            State v0 = arg4.getTargetState();
            this.state = LifecycleRegistryKt.access$min(this.state, v0);
            LifecycleEventObserver v1 = this.lifecycleObserver;
            Intrinsics.checkNotNull(arg3);
            v1.onStateChanged(arg3, arg4);
            this.state = v0;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.lifecycleObserver = arg2;
        }

        public final void setState(State arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.state = arg2;
        }
    }

    public static final Companion Companion;
    private final MutableStateFlow _currentStateFlow;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap observerMap;
    private List parentStates;
    private State state;

    static {
        LifecycleRegistry.Companion = new Companion(null);
    }

    public LifecycleRegistry(LifecycleOwner arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this(arg2, true);
    }

    private LifecycleRegistry(LifecycleOwner arg1, boolean arg2) {
        super();
        this.enforceMainThread = arg2;
        this.observerMap = new FastSafeIterableMap();
        this.lifecycleOwner = new WeakReference(arg1);
        this.parentStates = new ArrayList();
        State v1 = State.INITIALIZED;
        this.state = v1;
        this._currentStateFlow = StateFlowKt.MutableStateFlow(v1);
    }

    public LifecycleRegistry(LifecycleOwner arg1, boolean arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public void addObserver(LifecycleObserver arg7) {
        Object v0_1;
        Intrinsics.checkNotNullParameter(arg7, "observer");
        this.enforceMainThreadIfNeeded("addObserver");
        State v0 = this.state == State.DESTROYED ? State.DESTROYED : State.INITIALIZED;
        ObserverWithState v1 = new ObserverWithState(arg7, v0);
        if(this.observerMap.putIfAbsent(arg7, v1) != null) {
        }
        else {
            v0_1 = this.lifecycleOwner.get();
            if(v0_1 == null) {
                return;
            }

            goto label_20;
        }

        return;
    label_20:
        int v2 = this.addingObserverCounter != 0 || (this.handlingEvent) ? 1 : 0;
        State v4 = this.calculateTargetState(arg7);
        ++this.addingObserverCounter;
        while(true) {
            if(v1.getState().compareTo(((Enum)v4)) < 0 && (this.observerMap.contains(arg7))) {
                this.parentStates.add(v1.getState());
                Event v3 = Event.Companion.upFrom(v1.getState());
                if(v3 != null) {
                    v1.dispatchEvent(((LifecycleOwner)v0_1), v3);
                    CollectionsKt.removeLastOrNull(this.parentStates);
                    v4 = this.calculateTargetState(arg7);
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_60;
        }

        throw new IllegalStateException("no event up from " + v1.getState());
    label_60:
        if(v2 == 0) {
            this.sync();
        }

        --this.addingObserverCounter;
    }

    private final void backwardPass(LifecycleOwner arg3) {
        this.observerMap.forEachReversed(new LifecycleRegistry$$ExternalSyntheticLambda0(this, arg3));
    }

    static final Unit backwardPass$lambda$0(LifecycleRegistry arg4, LifecycleOwner arg5, Map$Entry arg6) {
        Intrinsics.checkNotNullParameter(arg6, "<destruct>");
        Object v0 = arg6.getKey();
        Object v6 = arg6.getValue();
        while(true) {
            if(((ObserverWithState)v6).getState().compareTo(arg4.state) > 0 && !arg4.newEventOccurred && (arg4.observerMap.contains(v0))) {
                Event v1 = Event.Companion.downFrom(((ObserverWithState)v6).getState());
                if(v1 != null) {
                    arg4.parentStates.add(v1.getTargetState());
                    ((ObserverWithState)v6).dispatchEvent(arg5, v1);
                    CollectionsKt.removeLastOrNull(arg4.parentStates);
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_34;
        }

        throw new IllegalStateException("no event down from " + ((ObserverWithState)v6).getState().toString());
    label_34:
        return Unit.INSTANCE;
    }

    private final State calculateTargetState(LifecycleObserver arg3) {
        Object v0_1;
        State v3_2;
        Map$Entry v3 = this.observerMap.ceil(arg3);
        State v0 = null;
        if(v3 != null) {
            Object v3_1 = v3.getValue();
            if(v3_1 != null) {
                v3_2 = ((ObserverWithState)v3_1).getState();
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v3_2 = v0;
        }

        if(!this.parentStates.isEmpty()) {
            v0_1 = this.parentStates.get(this.parentStates.size() - 1);
        }

        return LifecycleRegistryKt.access$min(LifecycleRegistryKt.access$min(this.state, v3_2), ((State)v0_1));
    }

    @JvmStatic public static final LifecycleRegistry createUnsafe(LifecycleOwner arg1) {
        return LifecycleRegistry.Companion.createUnsafe(arg1);
    }

    private final void enforceMainThreadIfNeeded(String arg2) {
        if(this.enforceMainThread) {
            if(LifecycleRegistry_androidKt.isMainThread()) {
            }
            else {
                throw new IllegalStateException("Method " + arg2 + " must be called on the main thread".toString());
            }
        }
    }

    private final void forwardPass(LifecycleOwner arg3) {
        this.observerMap.forEachWithAdditions(new LifecycleRegistry$$ExternalSyntheticLambda1(this, arg3));
    }

    static final Unit forwardPass$lambda$0(LifecycleRegistry arg3, LifecycleOwner arg4, Map$Entry arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<destruct>");
        Object v0 = arg5.getKey();
        Object v5 = arg5.getValue();
        while(true) {
            if(((ObserverWithState)v5).getState().compareTo(arg3.state) < 0 && !arg3.newEventOccurred && (arg3.observerMap.contains(v0))) {
                arg3.parentStates.add(((ObserverWithState)v5).getState());
                Event v1 = Event.Companion.upFrom(((ObserverWithState)v5).getState());
                if(v1 != null) {
                    ((ObserverWithState)v5).dispatchEvent(arg4, v1);
                    CollectionsKt.removeLastOrNull(arg3.parentStates);
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_34;
        }

        throw new IllegalStateException("no event up from " + ((ObserverWithState)v5).getState().toString());
    label_34:
        return Unit.INSTANCE;
    }

    public State getCurrentState() {
        return this.state;
    }

    public StateFlow getCurrentStateFlow() {
        return FlowKt.asStateFlow(this._currentStateFlow);
    }

    public int getObserverCount() {
        this.enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(Event arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        this.enforceMainThreadIfNeeded("handleLifecycleEvent");
        this.moveToState(arg2.getTargetState());
    }

    private final boolean isSynced() {
        if(this.observerMap.size() == 0) {
            return 1;
        }

        State v0 = this.observerMap.first().getValue().getState();
        State v2 = this.observerMap.last().getValue().getState();
        if(v0 == v2 && this.state == v2) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Override [currentState].") public void markState(State arg2) {
        Intrinsics.checkNotNullParameter(arg2, "state");
        this.enforceMainThreadIfNeeded("markState");
        this.setCurrentState(arg2);
    }

    private final void moveToState(State arg3) {
        if(this.state == arg3) {
        }
        else {
            LifecycleRegistryKt.access$checkLifecycleStateTransition(this.lifecycleOwner.get(), this.state, arg3);
            this.state = arg3;
            if(!this.handlingEvent) {
                if(this.addingObserverCounter != 0) {
                }
                else {
                    this.handlingEvent = true;
                    this.sync();
                    this.handlingEvent = false;
                    if(this.state == State.DESTROYED) {
                        this.observerMap = new FastSafeIterableMap();
                    }
                    else {
                    }

                    return;
                }
            }

            goto label_25;
        }

        return;
    label_25:
        this.newEventOccurred = true;
    }

    public void removeObserver(LifecycleObserver arg2) {
        Intrinsics.checkNotNullParameter(arg2, "observer");
        this.enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(arg2);
    }

    public void setCurrentState(State arg2) {
        Intrinsics.checkNotNullParameter(arg2, "state");
        this.enforceMainThreadIfNeeded("setCurrentState");
        this.moveToState(arg2);
    }

    private final void sync() {
        Object v0 = this.lifecycleOwner.get();
        if(v0 != null) {
            while(!this.isSynced()) {
                this.newEventOccurred = false;
                if(this.state.compareTo(this.observerMap.first().getValue().getState()) < 0) {
                    this.backwardPass(((LifecycleOwner)v0));
                }

                Map$Entry v1 = this.observerMap.lastOrNull();
                if(this.newEventOccurred) {
                    continue;
                }

                if(v1 == null) {
                    continue;
                }

                if(this.state.compareTo(v1.getValue().getState()) <= 0) {
                    continue;
                }

                this.forwardPass(((LifecycleOwner)v0));
            }

            this.newEventOccurred = false;
            this._currentStateFlow.setValue(this.getCurrentState());
            return;
        }

        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.".toString());
    }
}

