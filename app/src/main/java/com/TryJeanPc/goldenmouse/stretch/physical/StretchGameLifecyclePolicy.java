package com.TryJeanPc.goldenmouse.stretch.physical;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0003456B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JM\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u00032\b\u0010\u001F\u001A\u0004\u0018\u00010\u00052\u0006\u0010 \u001A\u00020\u00112\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00112\u0006\u0010#\u001A\u00020\u00112\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00110%¢\u0006\u0002\u0010&J\u0006\u0010\'\u001A\u00020(J\u000E\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0011J\u000E\u0010,\u001A\u00020(2\u0006\u0010-\u001A\u00020\u0011J(\u0010.\u001A\u00020*2\u0006\u0010/\u001A\u00020\u00032\u0006\u00100\u001A\u00020\u00192\u0006\u00101\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0003J\b\u00102\u001A\u00020(H\u0002J\b\u00103\u001A\u00020(H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u0011@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0015\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy;", "", "target", "", "factor", "", "<init>", "(Ljava/lang/String;I)V", "getTarget", "()Ljava/lang/String;", "getFactor", "()I", "value", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$State;", "state", "getState", "()Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$State;", "", "approved", "getApproved", "()Z", "exited", "observer", "candidate", "first", "", "last", "samples", "classify", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Context;", "packageName", "activityType", "targetPresent", "ownPackage", "deliberateGoldenHome", "geometryReady", "launchable", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZZLkotlin/jvm/functions/Function0;)Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Context;", "cancel", "", "applicationFinished", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Action;", "success", "restorationFinished", "verified", "observe", "source", "at", "context", "resetCandidate", "reset", "State", "Context", "Action", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchGameLifecyclePolicy {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Action;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "CANCEL_APPLY", "RESTORE", "APPLY", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Action {
        public static final enum Action APPLY;
        public static final enum Action CANCEL_APPLY;
        public static final enum Action NONE;
        public static final enum Action RESTORE;

        private static final Action[] $values() {
            return new Action[]{Action.NONE, Action.CANCEL_APPLY, Action.RESTORE, Action.APPLY};
        }

        static {
            Action.NONE = new Action("NONE", 0);
            Action.CANCEL_APPLY = new Action("CANCEL_APPLY", 1);
            Action.RESTORE = new Action("RESTORE", 2);
            Action.APPLY = new Action("APPLY", 3);
            Action[] v0 = Action.$values();
            Action.$VALUES = v0;
            Action.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Action(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Action.$ENTRIES;
        }

        public static Action valueOf(String arg1) {
            return Enum.valueOf(Action.class, arg1);
        }

        public static Action[] values() {
            return Action.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Context;", "", "<init>", "(Ljava/lang/String;I)V", "GAME", "HOME", "OTHER_APP", "GOLDEN_HOME", "INTERRUPTION", "UNKNOWN", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Context {
        public static final enum Context GAME;
        public static final enum Context GOLDEN_HOME;
        public static final enum Context HOME;
        public static final enum Context INTERRUPTION;
        public static final enum Context OTHER_APP;
        public static final enum Context UNKNOWN;

        private static final Context[] $values() {
            return new Context[]{Context.GAME, Context.HOME, Context.OTHER_APP, Context.GOLDEN_HOME, Context.INTERRUPTION, Context.UNKNOWN};
        }

        static {
            Context.GAME = new Context("GAME", 0);
            Context.HOME = new Context("HOME", 1);
            Context.OTHER_APP = new Context("OTHER_APP", 2);
            Context.GOLDEN_HOME = new Context("GOLDEN_HOME", 3);
            Context.INTERRUPTION = new Context("INTERRUPTION", 4);
            Context.UNKNOWN = new Context("UNKNOWN", 5);
            Context[] v0 = Context.$values();
            Context.$VALUES = v0;
            Context.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Context(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Context.$ENTRIES;
        }

        public static Context valueOf(String arg1) {
            return Enum.valueOf(Context.class, arg1);
        }

        public static Context[] values() {
            return Context.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$State;", "", "<init>", "(Ljava/lang/String;I)V", "APPLYING", "ACTIVE", "RESTORING", "WAITING_RETURN", "BLOCKED", "CANCELLED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum State {
        public static final enum State ACTIVE;
        public static final enum State APPLYING;
        public static final enum State BLOCKED;
        public static final enum State CANCELLED;
        public static final enum State RESTORING;
        public static final enum State WAITING_RETURN;

        private static final State[] $values() {
            return new State[]{State.APPLYING, State.ACTIVE, State.RESTORING, State.WAITING_RETURN, State.BLOCKED, State.CANCELLED};
        }

        static {
            State.APPLYING = new State("APPLYING", 0);
            State.ACTIVE = new State("ACTIVE", 1);
            State.RESTORING = new State("RESTORING", 2);
            State.WAITING_RETURN = new State("WAITING_RETURN", 3);
            State.BLOCKED = new State("BLOCKED", 4);
            State.CANCELLED = new State("CANCELLED", 5);
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

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    public static final int $stable = 8;
    private boolean approved;
    private String candidate;
    private boolean exited;
    private final int factor;
    private long first;
    private long last;
    private String observer;
    private int samples;
    private State state;
    private final String target;

    static {
    }

    public StretchGameLifecyclePolicy(String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "target");
        super();
        this.target = arg2;
        this.factor = arg3;
        this.state = State.APPLYING;
        this.observer = "";
        this.candidate = "";
        this.last = -1;
    }

    public final Action applicationFinished(boolean arg3) {
        State v3;
        if(this.state != State.APPLYING) {
            return Action.NONE;
        }

        this.approved = arg3;
        if(this.exited) {
            v3 = State.RESTORING;
        }
        else if(arg3) {
            v3 = State.ACTIVE;
        }
        else {
            v3 = State.BLOCKED;
        }

        this.state = v3;
        this.reset();
        if(this.exited) {
            return Action.RESTORE;
        }

        return Action.NONE;
    }

    public final void cancel() {
        this.state = State.CANCELLED;
        this.reset();
    }

    public final Context classify(String arg2, Integer arg3, boolean arg4, String arg5, boolean arg6, boolean arg7, Function0 arg8) {
        Intrinsics.checkNotNullParameter(arg5, "ownPackage");
        Intrinsics.checkNotNullParameter(arg8, "launchable");
        if(arg2 == null) {
            return Context.UNKNOWN;
        }

        if(Intrinsics.areEqual(arg2, this.target)) {
            if(arg3 == null) {
            }
            else if(arg3.intValue() == 1 && (arg4) && (arg7)) {
                return Context.GAME;
            }

            return Context.INTERRUPTION;
        }

        if(Intrinsics.areEqual(arg2, arg5)) {
            if(arg6) {
                return Context.GOLDEN_HOME;
            }

            return Context.INTERRUPTION;
        }

        int v1 = 2;
        if(arg3 == null) {
        }
        else if(arg3.intValue() == v1) {
            return Context.HOME;
        }

        if(arg3 == null) {
        }
        else if(arg3.intValue() == 1) {
            String[] v3 = new String[6];
            v3[0] = "com.android.systemui";
            v3[1] = "com.android.settings";
            v3[v1] = "com.android.permissioncontroller";
            v3[3] = "com.google.android.permissioncontroller";
            v3[4] = "com.android.packageinstaller";
            v3[5] = "com.google.android.packageinstaller";
            if(!SetsKt.setOf(((Object[])v3)).contains(arg2)) {
                Object v4 = null;
                if(!StringsKt.startsWith$default(arg2, "com.samsung.android.game.", false, v1, v4) && !StringsKt.startsWith$default(arg2, "com.miui.game", false, v1, v4)) {
                    if(StringsKt.startsWith$default(arg2, "cn.nubia.game", false, v1, v4)) {
                    }
                    else if(arg8.invoke().booleanValue()) {
                        return Context.OTHER_APP;
                    }
                    else {
                        return Context.INTERRUPTION;
                    }
                }
            }
        }

        return Context.INTERRUPTION;
    }

    public final boolean getApproved() {
        return this.approved;
    }

    public final int getFactor() {
        return this.factor;
    }

    public final State getState() {
        return this.state;
    }

    public final String getTarget() {
        return this.target;
    }

    public final Action observe(String arg5, long arg6, Context arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg5, "source");
        Intrinsics.checkNotNullParameter(arg8, "context");
        if(!Intrinsics.areEqual(arg5, this.observer)) {
            this.observer = arg5;
            this.reset();
        }

        long v0 = this.last;
        if(arg6 <= v0) {
            return Action.NONE;
        }

        if(v0 >= 0 && arg6 - v0 > 1600) {
            this.reset();
        }

        this.last = arg6;
        int v5 = 2;
        Context[] v0_1 = new Context[v5];
        v0_1[0] = Context.UNKNOWN;
        v0_1[1] = Context.INTERRUPTION;
        if(SetsKt.setOf(((Object[])v0_1)).contains(arg8)) {
            this.resetCandidate();
            return Action.NONE;
        }

        String v0_2 = arg8.name() + ":" + arg9;
        if(!Intrinsics.areEqual(v0_2, this.candidate)) {
            this.candidate = v0_2;
            this.first = arg6;
            this.samples = 0;
        }

        ++this.samples;
        int v1 = 3;
        if(arg8 == Context.GAME) {
            if((Intrinsics.areEqual(arg9, this.target)) && this.state == State.WAITING_RETURN && this.samples >= v1 && arg6 - this.first >= 1500) {
                this.exited = false;
                this.state = State.APPLYING;
                this.reset();
                return Action.APPLY;
            }

            return Action.NONE;
        }

        State[] v5_1 = new State[v5];
        v5_1[0] = State.ACTIVE;
        v5_1[1] = State.APPLYING;
        if(SetsKt.setOf(((Object[])v5_1)).contains(this.state)) {
            if(this.exited) {
            }
            else {
                if(arg8 == Context.OTHER_APP) {
                    v1 = 8;
                }

                if(this.samples >= v1) {
                    if(arg6 - this.first < (((long)(v1 - 1))) * 750) {
                    }
                    else {
                        this.exited = true;
                        if(this.state == State.APPLYING) {
                            return Action.CANCEL_APPLY;
                        }
                        else {
                            this.state = State.RESTORING;
                            this.reset();
                            return Action.RESTORE;
                        }
                    }
                }

                return Action.NONE;
            }
        }

        return Action.NONE;
    }

    private final void reset() {
        this.resetCandidate();
        this.last = -1;
    }

    private final void resetCandidate() {
        this.candidate = "";
        this.samples = 0;
        this.first = 0;
    }

    public final void restorationFinished(boolean arg3) {
        if(this.state != State.RESTORING) {
            return;
        }

        State v3 = !arg3 || !this.approved ? State.BLOCKED : State.WAITING_RETURN;
        this.state = v3;
        this.reset();
    }
}

