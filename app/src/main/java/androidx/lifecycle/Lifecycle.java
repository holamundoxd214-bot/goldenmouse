package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\'J\u0010\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\'R\"\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000F\u001A\u00020\u00108\'X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00100\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2={"Landroidx/lifecycle/Lifecycle;", "", "<init>", "()V", "internalScopeRef", "Landroidx/lifecycle/AtomicReference;", "getInternalScopeRef", "()Landroidx/lifecycle/AtomicReference;", "setInternalScopeRef", "(Landroidx/lifecycle/AtomicReference;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Event", "State", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Lifecycle {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000FB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000B\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000Ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0010"}, d2={"Landroidx/lifecycle/Lifecycle$Event;", "", "<init>", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "targetState", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "Companion", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public enum Event {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\n\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\u000B"}, d2={"Landroidx/lifecycle/Lifecycle$Event$Companion;", "", "<init>", "()V", "downFrom", "Landroidx/lifecycle/Lifecycle$Event;", "state", "Landroidx/lifecycle/Lifecycle$State;", "downTo", "upFrom", "upTo", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
            @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
                static {
                    int[] v0 = new int[State.values().length];
                    try {
                        v0[State.CREATED.ordinal()] = 1;
                        goto label_7;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_7:
                            v0[State.STARTED.ordinal()] = 2;
                            goto label_11;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_11:
                                v0[State.RESUMED.ordinal()] = 3;
                                goto label_15;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_15:
                                    v0[State.DESTROYED.ordinal()] = 4;
                                    goto label_19;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_19:
                                        v0[State.INITIALIZED.ordinal()] = 5;
                                        goto label_23;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_23:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            @JvmStatic public final Event downFrom(State arg1) {
                Intrinsics.checkNotNullParameter(arg1, "state");
                int v0 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 3) {
                            return null;
                        }

                        return Event.ON_PAUSE;
                    }

                    return Event.ON_STOP;
                }

                return Event.ON_DESTROY;
            }

            @JvmStatic public final Event downTo(State arg1) {
                Intrinsics.checkNotNullParameter(arg1, "state");
                int v0 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 4) {
                            return null;
                        }

                        return Event.ON_DESTROY;
                    }

                    return Event.ON_PAUSE;
                }

                return Event.ON_STOP;
            }

            @JvmStatic public final Event upFrom(State arg1) {
                Intrinsics.checkNotNullParameter(arg1, "state");
                int v0 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 5) {
                            return null;
                        }

                        return Event.ON_CREATE;
                    }

                    return Event.ON_RESUME;
                }

                return Event.ON_START;
            }

            @JvmStatic public final Event upTo(State arg1) {
                Intrinsics.checkNotNullParameter(arg1, "state");
                int v0 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 3) {
                            return null;
                        }

                        return Event.ON_RESUME;
                    }

                    return Event.ON_START;
                }

                return Event.ON_CREATE;
            }
        }

        @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class androidx.lifecycle.Lifecycle$Event$WhenMappings {
            static {
                int[] v0 = new int[Event.values().length];
                try {
                    v0[Event.ON_CREATE.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[Event.ON_STOP.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_11:
                            v0[Event.ON_START.ordinal()] = 3;
                            goto label_15;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_15:
                                v0[Event.ON_PAUSE.ordinal()] = 4;
                                goto label_19;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_19:
                                    v0[Event.ON_RESUME.ordinal()] = 5;
                                    goto label_23;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_23:
                                        v0[Event.ON_DESTROY.ordinal()] = 6;
                                        goto label_27;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_27:
                                            v0[Event.ON_ANY.ordinal()] = 7;
                                            goto label_31;
                                        }
                                        catch(NoSuchFieldError ) {
                                        label_31:
                                            androidx.lifecycle.Lifecycle$Event$WhenMappings.$EnumSwitchMapping$0 = v0;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public static final Companion Companion;
        public static final enum Event ON_ANY;
        public static final enum Event ON_CREATE;
        public static final enum Event ON_DESTROY;
        public static final enum Event ON_PAUSE;
        public static final enum Event ON_RESUME;
        public static final enum Event ON_START;
        public static final enum Event ON_STOP;

        private static final Event[] $values() {
            return new Event[]{Event.ON_CREATE, Event.ON_START, Event.ON_RESUME, Event.ON_PAUSE, Event.ON_STOP, Event.ON_DESTROY, Event.ON_ANY};
        }

        static {
            Event.ON_CREATE = new Event("ON_CREATE", 0);
            Event.ON_START = new Event("ON_START", 1);
            Event.ON_RESUME = new Event("ON_RESUME", 2);
            Event.ON_PAUSE = new Event("ON_PAUSE", 3);
            Event.ON_STOP = new Event("ON_STOP", 4);
            Event.ON_DESTROY = new Event("ON_DESTROY", 5);
            Event.ON_ANY = new Event("ON_ANY", 6);
            Event[] v0 = Event.$values();
            Event.$VALUES = v0;
            Event.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
            Event.Companion = new Companion(null);
        }

        private Event(String arg1, int arg2) {
            super(arg1, arg2);
        }

        @JvmStatic public static final Event downFrom(State arg1) {
            return Event.Companion.downFrom(arg1);
        }

        @JvmStatic public static final Event downTo(State arg1) {
            return Event.Companion.downTo(arg1);
        }

        public static EnumEntries getEntries() {
            return Event.$ENTRIES;
        }

        public final State getTargetState() {
            switch(androidx.lifecycle.Lifecycle$Event$WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: 
                case 2: {
                    goto label_22;
                }
                case 3: 
                case 4: {
                    goto label_20;
                }
                case 5: {
                    goto label_18;
                }
                case 6: {
                    goto label_16;
                }
                case 7: {
                    goto label_7;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_18:
            return State.RESUMED;
        label_20:
            return State.STARTED;
        label_22:
            return State.CREATED;
        label_7:
            throw new IllegalArgumentException(this + " has no target state");
        label_16:
            return State.DESTROYED;
        }

        @JvmStatic public static final Event upFrom(State arg1) {
            return Event.Companion.upFrom(arg1);
        }

        @JvmStatic public static final Event upTo(State arg1) {
            return Event.Companion.upTo(arg1);
        }

        public static Event valueOf(String arg1) {
            return Enum.valueOf(Event.class, arg1);
        }

        public static Event[] values() {
            return Event.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2={"Landroidx/lifecycle/Lifecycle$State;", "", "<init>", "(Ljava/lang/String;I)V", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "isAtLeast", "", "state", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public enum State {
        public static final enum State CREATED;
        public static final enum State DESTROYED;
        public static final enum State INITIALIZED;
        public static final enum State RESUMED;
        public static final enum State STARTED;

        private static final State[] $values() {
            return new State[]{State.DESTROYED, State.INITIALIZED, State.CREATED, State.STARTED, State.RESUMED};
        }

        static {
            State.DESTROYED = new State("DESTROYED", 0);
            State.INITIALIZED = new State("INITIALIZED", 1);
            State.CREATED = new State("CREATED", 2);
            State.STARTED = new State("STARTED", 3);
            State.RESUMED = new State("RESUMED", 4);
            State[] v0 = State.$values();
            State.$VALUES = v0;
            State.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return State.$ENTRIES;
        }

        public final boolean isAtLeast(State arg2) {
            Intrinsics.checkNotNullParameter(arg2, "state");
            if(this.compareTo(((Enum)arg2)) >= 0) {
                return 1;
            }

            return 0;
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    private AtomicReference internalScopeRef;

    public Lifecycle() {
        super();
        this.internalScopeRef = new AtomicReference(null);
    }

    static final void _get_currentStateFlow_$lambda$0(MutableStateFlow arg1, LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "event");
        arg1.setValue(arg3.getTargetState());
    }

    public abstract void addObserver(LifecycleObserver arg1);

    public abstract State getCurrentState();

    public StateFlow getCurrentStateFlow() {
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(this.getCurrentState());
        this.addObserver(new Lifecycle$$ExternalSyntheticLambda0(v0));
        return FlowKt.asStateFlow(v0);
    }

    public final AtomicReference getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public abstract void removeObserver(LifecycleObserver arg1);

    public final void setInternalScopeRef(AtomicReference arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.internalScopeRef = arg2;
    }
}

