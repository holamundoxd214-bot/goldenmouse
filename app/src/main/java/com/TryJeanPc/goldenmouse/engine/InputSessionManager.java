package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.input.KeyboardRouteDiagnostics$Stage;
import com.TryJeanPc.goldenmouse.input.KeyboardRouteDiagnostics;
import com.TryJeanPc.goldenmouse.mapper.FreeLookBindings;
import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 c2\u00020\u0001:\b\\]^_`abcB#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u00102\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017J$\u00103\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u00020\u001A2\u0006\u00107\u001A\u00020\u001AJ\u0014\u00108\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u00109\u001A\u00020\u0007J\u0014\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u00109\u001A\u00020\u0007J(\u0010;\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010<\u001A\u00020\u00072\u0006\u0010=\u001A\u00020\u00072\n\b\u0002\u0010>\u001A\u0004\u0018\u00010\u0015J\u001C\u0010?\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010@\u001A\u00020\u00122\u0006\u0010A\u001A\u00020\u0007J\u0014\u0010B\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010C\u001A\u00020\u0015J\u0006\u0010D\u001A\u00020EJ\u000E\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020HJ \u0010I\u001A\u00020E2\u0006\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020\u001D2\u0006\u0010M\u001A\u00020\u0007H\u0002J\u0018\u0010N\u001A\u00020E2\u0006\u0010O\u001A\u00020!2\u0006\u0010J\u001A\u00020HH\u0002J0\u0010P\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010Q\u001A\u00020R2\b\b\u0002\u0010S\u001A\u00020\u00072\f\u0010T\u001A\b\u0012\u0004\u0012\u00020E0UH\u0002J\u0010\u0010V\u001A\u00020E2\u0006\u0010W\u001A\u00020\fH\u0002J\b\u0010X\u001A\u00020\fH\u0002J\b\u0010Y\u001A\u00020\fH\u0002J\f\u0010Z\u001A\b\u0012\u0004\u0012\u00020E0\u0017J\f\u0010[\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00180\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00180)¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u0011\u0010,\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b-\u0010.R\u0011\u0010/\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b0\u00101¨\u0006d"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager;", "", "runtime", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Runtime;", "executor", "Ljava/util/concurrent/ExecutorService;", "shutdownExecutorOnStop", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Runtime;Ljava/util/concurrent/ExecutorService;Z)V", "ingress", "generation", "", "mouseModeGeneration", "closed", "desiredEditor", "observedBackend", "Lkotlin/Pair;", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "observedCapture", "Lkotlin/Triple;", "", "pendingCapture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "pendingBoundaries", "", "physicalDown", "", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$PhysicalInput;", "blockedUntilUp", "owners", "", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Route;", "requested", "desiredPaused", "failed", "model", "snapshots", "Lkotlinx/coroutines/flow/MutableStateFlow;", "snapshotFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSnapshotFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "snapshot", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "transitionPending", "getTransitionPending", "()Z", "start", "applyProfile", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "width", "height", "setEditor", "enabled", "setPaused", "captureChanged", "mouse", "keyboard", "error", "backendChanged", "backend", "ready", "injectionFailed", "message", "mouseModeChanged", "", "submit", "input", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "dispatch", "event", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Event;", "key", "down", "deliver", "route", "boundary", "state", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;", "operationOnCleanupFailure", "operation", "Lkotlin/Function0;", "publish", "id", "generationId", "mouseModeId", "awaitIdle", "stop", "State", "Backend", "Route", "Snapshot", "Event", "Runtime", "PhysicalInput", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputSessionManager {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SHIZUKU", "KADB", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Backend {
        public static final enum Backend KADB;
        public static final enum Backend NONE;
        public static final enum Backend SHIZUKU;

        private static final Backend[] $values() {
            return new Backend[]{Backend.NONE, Backend.SHIZUKU, Backend.KADB};
        }

        static {
            Backend.NONE = new Backend("NONE", 0);
            Backend.SHIZUKU = new Backend("SHIZUKU", 1);
            Backend.KADB = new Backend("KADB", 2);
            Backend[] v0 = Backend.$values();
            Backend.$VALUES = v0;
            Backend.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Backend(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Backend.$ENTRIES;
        }

        public static Backend valueOf(String arg1) {
            return Enum.valueOf(Backend.class, arg1);
        }

        public static Backend[] values() {
            return Backend.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Companion;", "", "<init>", "()V", "nextSessionId", "Ljava/util/concurrent/atomic/AtomicLong;", "getNextSessionId", "()Ljava/util/concurrent/atomic/AtomicLong;", "LEFT", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "getLEFT", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final InputBinding getLEFT() {
            return InputSessionManager.LEFT;
        }

        public final AtomicLong getNextSessionId() {
            return InputSessionManager.nextSessionId;
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Event;", "", "sessionId", "", "input", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "<init>", "(JLcom/TryJeanPc/goldenmouse/input/InputEvent;)V", "getSessionId", "()J", "getInput", "()Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Event {
        public static final int $stable;
        private final InputEvent input;
        private final long sessionId;

        static {
        }

        public Event(long arg2, InputEvent arg4) {
            Intrinsics.checkNotNullParameter(arg4, "input");
            super();
            this.sessionId = arg2;
            this.input = arg4;
        }

        public final long component1() {
            return this.sessionId;
        }

        public final InputEvent component2() {
            return this.input;
        }

        public final Event copy(long arg1, InputEvent arg3) {
            Intrinsics.checkNotNullParameter(arg3, "input");
            return new Event(arg1, arg3);
        }

        public static Event copy$default(Event arg0, long arg1, InputEvent arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.sessionId;
            }

            if((arg4 & 2) != 0) {
                arg3 = arg0.input;
            }

            return arg0.copy(arg1, arg3);
        }

        public boolean equals(Object arg8) {
            if(this == (((Event)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Event)) {
                return 0;
            }

            if(this.sessionId != ((Event)arg8).sessionId) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.input, ((Event)arg8).input)) {
                return 0;
            }

            return 1;
        }

        public final InputEvent getInput() {
            return this.input;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return Long.hashCode(this.sessionId) * 0x1F + this.input.hashCode();
        }

        public String toString() {
            return "Event(sessionId=" + this.sessionId + ", input=" + this.input + ")";
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$PhysicalInput;", "", "device", "", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;)V", "getDevice", "()Ljava/lang/String;", "getBinding", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class PhysicalInput {
        private final InputBinding binding;
        private final String device;

        public PhysicalInput(String arg2, InputBinding arg3) {
            Intrinsics.checkNotNullParameter(arg3, "binding");
            super();
            this.device = arg2;
            this.binding = arg3;
        }

        public final String component1() {
            return this.device;
        }

        public final InputBinding component2() {
            return this.binding;
        }

        public final PhysicalInput copy(String arg1, InputBinding arg2) {
            Intrinsics.checkNotNullParameter(arg2, "binding");
            return new PhysicalInput(arg1, arg2);
        }

        public static PhysicalInput copy$default(PhysicalInput arg0, String arg1, InputBinding arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.device;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.binding;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((PhysicalInput)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof PhysicalInput)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.device, ((PhysicalInput)arg5).device)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.binding, ((PhysicalInput)arg5).binding)) {
                return 0;
            }

            return 1;
        }

        public final InputBinding getBinding() {
            return this.binding;
        }

        public final String getDevice() {
            return this.device;
        }

        public int hashCode() {
            String v0 = this.device;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            return v0_1 * 0x1F + this.binding.hashCode();
        }

        public String toString() {
            return "PhysicalInput(device=" + this.device + ", binding=" + this.binding + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Route;", "", "<init>", "(Ljava/lang/String;I)V", "MAPPER", "CURSOR", "NONE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Route {
        public static final enum Route CURSOR;
        public static final enum Route MAPPER;
        public static final enum Route NONE;

        private static final Route[] $values() {
            return new Route[]{Route.MAPPER, Route.CURSOR, Route.NONE};
        }

        static {
            Route.MAPPER = new Route("MAPPER", 0);
            Route.CURSOR = new Route("CURSOR", 1);
            Route.NONE = new Route("NONE", 2);
            Route[] v0 = Route.$values();
            Route.$VALUES = v0;
            Route.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Route(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Route.$ENTRIES;
        }

        public static Route valueOf(String arg1) {
            return Enum.valueOf(Route.class, arg1);
        }

        public static Route[] values() {
            return Route.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&J \u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH&J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH&J\u0010\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011H&J\u0010\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\fH&J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H&J\u0010\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0019H&J\u0010\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H&J\u0010\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0019H&J\b\u0010\u001C\u001A\u00020\u0003H\u0016¨\u0006\u001DÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Runtime;", "", "start", "", "stop", "applyProfile", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "width", "", "height", "releaseAll", "", "sessionId", "", "backendChanged", "backend", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "setGamingEnabled", "enabled", "routeMouse", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Route;", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseButton;", "mapped", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "cursor", "captureBinding", "applyCapturePolicy", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface Runtime {
        @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
            @Deprecated public static void applyCapturePolicy(Runtime arg0) {
                arg0.applyCapturePolicy();
            }
        }

        static void access$applyCapturePolicy$jd(Runtime arg0) {
            super.applyCapturePolicy();
        }

        default void applyCapturePolicy() {
        }

        void applyProfile(GameProfile arg1, int arg2, int arg3);

        void backendChanged(Backend arg1);

        void captureBinding(InputEvent arg1);

        void cursor(MouseButton arg1);

        void mapped(InputEvent arg1);

        boolean releaseAll(long arg1);

        Route routeMouse(MouseButton arg1);

        void setGamingEnabled(boolean arg1);

        void start();

        void stop();
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B­\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\u0007\u0012\b\b\u0002\u0010\r\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001A\u00020\u0003HÆ\u0003J\t\u0010/\u001A\u00020\u0005HÆ\u0003J\t\u00100\u001A\u00020\u0007HÆ\u0003J\t\u00101\u001A\u00020\u0007HÆ\u0003J\t\u00102\u001A\u00020\u0007HÆ\u0003J\t\u00103\u001A\u00020\u0007HÆ\u0003J\t\u00104\u001A\u00020\u0007HÆ\u0003J\t\u00105\u001A\u00020\u0007HÆ\u0003J\t\u00106\u001A\u00020\u0007HÆ\u0003J\t\u00107\u001A\u00020\u000FHÆ\u0003J\t\u00108\u001A\u00020\u0007HÆ\u0003J\t\u00109\u001A\u00020\u0007HÆ\u0003J\u000B\u0010:\u001A\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010;\u001A\u00020\u0007HÆ\u0003J\u000B\u0010<\u001A\u0004\u0018\u00010\u0013HÆ\u0003J\u000B\u0010=\u001A\u0004\u0018\u00010\u0013HÆ\u0003J¯\u0001\u0010>\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\f\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00072\b\b\u0002\u0010\u0011\u001A\u00020\u00072\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00072\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u0010?\u001A\u00020\u00072\b\u0010@\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001A\u00020BHÖ\u0001J\t\u0010C\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001ER\u0011\u0010\t\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001ER\u0011\u0010\n\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001ER\u0011\u0010\u000B\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001ER\u0011\u0010\f\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u001ER\u0011\u0010\r\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001ER\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\u0010\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u001ER\u0011\u0010\u0011\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u001ER\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0011\u0010\u0014\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\u001ER\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001A\u0004\b,\u0010*R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001A\u0004\b-\u0010*¨\u0006D"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "", "sessionId", "", "state", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;", "mouseConnected", "", "keyboardConnected", "keyboardRequired", "profileLoaded", "mapperReady", "cameraReady", "injectorReady", "backend", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "editor", "cleanupPending", "targetPackage", "", "contextPaused", "error", "captureError", "<init>", "(JLcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;ZZZZZZZLcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getSessionId", "()J", "getState", "()Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;", "getMouseConnected", "()Z", "getKeyboardConnected", "getKeyboardRequired", "getProfileLoaded", "getMapperReady", "getCameraReady", "getInjectorReady", "getBackend", "()Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "getEditor", "getCleanupPending", "getTargetPackage", "()Ljava/lang/String;", "getContextPaused", "getError", "getCaptureError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Snapshot {
        public static final int $stable;
        private final Backend backend;
        private final boolean cameraReady;
        private final String captureError;
        private final boolean cleanupPending;
        private final boolean contextPaused;
        private final boolean editor;
        private final String error;
        private final boolean injectorReady;
        private final boolean keyboardConnected;
        private final boolean keyboardRequired;
        private final boolean mapperReady;
        private final boolean mouseConnected;
        private final boolean profileLoaded;
        private final long sessionId;
        private final State state;
        private final String targetPackage;

        static {
        }

        public Snapshot(long arg20, State arg22, boolean arg23, boolean arg24, boolean arg25, boolean arg26, boolean arg27, boolean arg28, boolean arg29, Backend arg30, boolean arg31, boolean arg32, String arg33, boolean arg34, String arg35, String arg36, int arg37, DefaultConstructorMarker arg38) {
            int v0 = arg37;
            long v1 = (v0 & 1) != 0 ? 0 : arg20;
            State v3 = (v0 & 2) != 0 ? State.IDLE : arg22;
            boolean v4 = (v0 & 4) != 0 ? false : arg23;
            boolean v6 = (v0 & 8) != 0 ? false : arg24;
            boolean v7 = (v0 & 16) != 0 ? false : arg25;
            boolean v8 = (v0 & 0x20) != 0 ? false : arg26;
            boolean v9 = (v0 & 0x40) != 0 ? false : arg27;
            boolean v10 = (v0 & 0x80) != 0 ? false : arg28;
            boolean v11 = (v0 & 0x100) != 0 ? false : arg29;
            Backend v12 = (v0 & 0x200) != 0 ? Backend.NONE : arg30;
            boolean v13 = (v0 & 0x400) != 0 ? false : arg31;
            boolean v14 = (v0 & 0x800) != 0 ? false : arg32;
            String v16 = null;
            String v15 = (v0 & 0x1000) != 0 ? v16 : arg33;
            boolean v5 = (v0 & 0x2000) != 0 ? false : arg34;
            long v17 = v1;
            String v1_1 = (v0 & 0x4000) != 0 ? v16 : arg35;
            String v37 = (v0 & 0x8000) != 0 ? v16 : arg36;
            this(v17, v3, v4, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v5, v1_1, v37);
        }

        public Snapshot() {
            this(0, null, false, false, false, false, false, false, false, null, false, false, null, false, null, null, 0xFFFF, null);
        }

        public Snapshot(long arg2, State arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, boolean arg9, boolean arg10, boolean arg11, Backend arg12, boolean arg13, boolean arg14, String arg15, boolean arg16, String arg17, String arg18) {
            Intrinsics.checkNotNullParameter(arg4, "state");
            Intrinsics.checkNotNullParameter(arg12, "backend");
            super();
            this.sessionId = arg2;
            this.state = arg4;
            this.mouseConnected = arg5;
            this.keyboardConnected = arg6;
            this.keyboardRequired = arg7;
            this.profileLoaded = arg8;
            this.mapperReady = arg9;
            this.cameraReady = arg10;
            this.injectorReady = arg11;
            this.backend = arg12;
            this.editor = arg13;
            this.cleanupPending = arg14;
            this.targetPackage = arg15;
            this.contextPaused = arg16;
            this.error = arg17;
            this.captureError = arg18;
        }

        public final long component1() {
            return this.sessionId;
        }

        public final Backend component10() {
            return this.backend;
        }

        public final boolean component11() {
            return this.editor;
        }

        public final boolean component12() {
            return this.cleanupPending;
        }

        public final String component13() {
            return this.targetPackage;
        }

        public final boolean component14() {
            return this.contextPaused;
        }

        public final String component15() {
            return this.error;
        }

        public final String component16() {
            return this.captureError;
        }

        public final State component2() {
            return this.state;
        }

        public final boolean component3() {
            return this.mouseConnected;
        }

        public final boolean component4() {
            return this.keyboardConnected;
        }

        public final boolean component5() {
            return this.keyboardRequired;
        }

        public final boolean component6() {
            return this.profileLoaded;
        }

        public final boolean component7() {
            return this.mapperReady;
        }

        public final boolean component8() {
            return this.cameraReady;
        }

        public final boolean component9() {
            return this.injectorReady;
        }

        public final Snapshot copy(long arg20, State arg22, boolean arg23, boolean arg24, boolean arg25, boolean arg26, boolean arg27, boolean arg28, boolean arg29, Backend arg30, boolean arg31, boolean arg32, String arg33, boolean arg34, String arg35, String arg36) {
            Intrinsics.checkNotNullParameter(arg22, "state");
            Intrinsics.checkNotNullParameter(arg30, "backend");
            return new Snapshot(arg20, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36);
        }

        public static Snapshot copy$default(Snapshot arg19, long arg20, State arg22, boolean arg23, boolean arg24, boolean arg25, boolean arg26, boolean arg27, boolean arg28, boolean arg29, Backend arg30, boolean arg31, boolean arg32, String arg33, boolean arg34, String arg35, String arg36, int arg37, Object arg38) {
            Snapshot v0 = arg19;
            int v1 = arg37;
            long v2 = (v1 & 1) != 0 ? v0.sessionId : arg20;
            State v4 = (v1 & 2) != 0 ? v0.state : arg22;
            boolean v5 = (v1 & 4) != 0 ? v0.mouseConnected : arg23;
            boolean v6 = (v1 & 8) != 0 ? v0.keyboardConnected : arg24;
            boolean v7 = (v1 & 16) != 0 ? v0.keyboardRequired : arg25;
            boolean v8 = (v1 & 0x20) != 0 ? v0.profileLoaded : arg26;
            boolean v9 = (v1 & 0x40) != 0 ? v0.mapperReady : arg27;
            boolean v10 = (v1 & 0x80) != 0 ? v0.cameraReady : arg28;
            boolean v11 = (v1 & 0x100) != 0 ? v0.injectorReady : arg29;
            Backend v12 = (v1 & 0x200) != 0 ? v0.backend : arg30;
            boolean v13 = (v1 & 0x400) != 0 ? v0.editor : arg31;
            boolean v14 = (v1 & 0x800) != 0 ? v0.cleanupPending : arg32;
            String v15 = (v1 & 0x1000) != 0 ? v0.targetPackage : arg33;
            long v16 = v2;
            boolean v2_1 = (v1 & 0x2000) != 0 ? v0.contextPaused : arg34;
            String v3 = (v1 & 0x4000) != 0 ? v0.error : arg35;
            String v37 = (v1 & 0x8000) != 0 ? v0.captureError : arg36;
            return v0.copy(v16, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v2_1, v3, v37);
        }

        public boolean equals(Object arg8) {
            if(this == (((Snapshot)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Snapshot)) {
                return 0;
            }

            if(this.sessionId != ((Snapshot)arg8).sessionId) {
                return 0;
            }

            if(this.state != ((Snapshot)arg8).state) {
                return 0;
            }

            if(this.mouseConnected != ((Snapshot)arg8).mouseConnected) {
                return 0;
            }

            if(this.keyboardConnected != ((Snapshot)arg8).keyboardConnected) {
                return 0;
            }

            if(this.keyboardRequired != ((Snapshot)arg8).keyboardRequired) {
                return 0;
            }

            if(this.profileLoaded != ((Snapshot)arg8).profileLoaded) {
                return 0;
            }

            if(this.mapperReady != ((Snapshot)arg8).mapperReady) {
                return 0;
            }

            if(this.cameraReady != ((Snapshot)arg8).cameraReady) {
                return 0;
            }

            if(this.injectorReady != ((Snapshot)arg8).injectorReady) {
                return 0;
            }

            if(this.backend != ((Snapshot)arg8).backend) {
                return 0;
            }

            if(this.editor != ((Snapshot)arg8).editor) {
                return 0;
            }

            if(this.cleanupPending != ((Snapshot)arg8).cleanupPending) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.targetPackage, ((Snapshot)arg8).targetPackage)) {
                return 0;
            }

            if(this.contextPaused != ((Snapshot)arg8).contextPaused) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.error, ((Snapshot)arg8).error)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.captureError, ((Snapshot)arg8).captureError)) {
                return 0;
            }

            return 1;
        }

        public final Backend getBackend() {
            return this.backend;
        }

        public final boolean getCameraReady() {
            return this.cameraReady;
        }

        public final String getCaptureError() {
            return this.captureError;
        }

        public final boolean getCleanupPending() {
            return this.cleanupPending;
        }

        public final boolean getContextPaused() {
            return this.contextPaused;
        }

        public final boolean getEditor() {
            return this.editor;
        }

        public final String getError() {
            return this.error;
        }

        public final boolean getInjectorReady() {
            return this.injectorReady;
        }

        public final boolean getKeyboardConnected() {
            return this.keyboardConnected;
        }

        public final boolean getKeyboardRequired() {
            return this.keyboardRequired;
        }

        public final boolean getMapperReady() {
            return this.mapperReady;
        }

        public final boolean getMouseConnected() {
            return this.mouseConnected;
        }

        public final boolean getProfileLoaded() {
            return this.profileLoaded;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public final State getState() {
            return this.state;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public int hashCode() {
            int v0 = (((((((((((Long.hashCode(this.sessionId) * 0x1F + this.state.hashCode()) * 0x1F + Boolean.hashCode(this.mouseConnected)) * 0x1F + Boolean.hashCode(this.keyboardConnected)) * 0x1F + Boolean.hashCode(this.keyboardRequired)) * 0x1F + Boolean.hashCode(this.profileLoaded)) * 0x1F + Boolean.hashCode(this.mapperReady)) * 0x1F + Boolean.hashCode(this.cameraReady)) * 0x1F + Boolean.hashCode(this.injectorReady)) * 0x1F + this.backend.hashCode()) * 0x1F + Boolean.hashCode(this.editor)) * 0x1F + Boolean.hashCode(this.cleanupPending)) * 0x1F;
            String v1 = this.targetPackage;
            int v2 = 0;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            v0 = ((v0 + v1_1) * 0x1F + Boolean.hashCode(this.contextPaused)) * 0x1F;
            v1 = this.error;
            v1_1 = v1 == null ? 0 : v1.hashCode();
            v0 = (v0 + v1_1) * 0x1F;
            String v3 = this.captureError;
            if(v3 == null) {
            }
            else {
                v2 = v3.hashCode();
            }

            return v0 + v2;
        }

        public String toString() {
            return "Snapshot(sessionId=" + this.sessionId + ", state=" + this.state + ", mouseConnected=" + this.mouseConnected + ", keyboardConnected=" + this.keyboardConnected + ", keyboardRequired=" + this.keyboardRequired + ", profileLoaded=" + this.profileLoaded + ", mapperReady=" + this.mapperReady + ", cameraReady=" + this.cameraReady + ", injectorReady=" + this.injectorReady + ", backend=" + this.backend + ", editor=" + this.editor + ", cleanupPending=" + this.cleanupPending + ", targetPackage=" + this.targetPackage + ", contextPaused=" + this.contextPaused + ", error=" + this.error + ", captureError=" + this.captureError + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "READY", "ACTIVE", "EDITOR", "PAUSED", "RECOVERING", "FAILED", "STOPPING", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum State {
        public static final enum State ACTIVE;
        public static final enum State EDITOR;
        public static final enum State FAILED;
        public static final enum State IDLE;
        public static final enum State PAUSED;
        public static final enum State READY;
        public static final enum State RECOVERING;
        public static final enum State STARTING;
        public static final enum State STOPPING;

        private static final State[] $values() {
            return new State[]{State.IDLE, State.STARTING, State.READY, State.ACTIVE, State.EDITOR, State.PAUSED, State.RECOVERING, State.FAILED, State.STOPPING};
        }

        static {
            State.IDLE = new State("IDLE", 0);
            State.STARTING = new State("STARTING", 1);
            State.READY = new State("READY", 2);
            State.ACTIVE = new State("ACTIVE", 3);
            State.EDITOR = new State("EDITOR", 4);
            State.PAUSED = new State("PAUSED", 5);
            State.RECOVERING = new State("RECOVERING", 6);
            State.FAILED = new State("FAILED", 7);
            State.STOPPING = new State("STOPPING", 8);
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

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Route.values().length];
            try {
                v0[Route.MAPPER.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Route.CURSOR.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Route.NONE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private static final InputBinding LEFT;
    private final Set blockedUntilUp;
    private boolean closed;
    private boolean desiredEditor;
    private boolean desiredPaused;
    private final ExecutorService executor;
    private boolean failed;
    private long generation;
    private final Object ingress;
    private Snapshot model;
    private long mouseModeGeneration;
    private static final AtomicLong nextSessionId;
    private Pair observedBackend;
    private Triple observedCapture;
    private final Map owners;
    private int pendingBoundaries;
    private CompletableFuture pendingCapture;
    private final Set physicalDown;
    private boolean requested;
    private final Runtime runtime;
    private final boolean shutdownExecutorOnStop;
    private final StateFlow snapshotFlow;
    private final MutableStateFlow snapshots;

    static {
        InputSessionManager.Companion = new Companion(null);
        InputSessionManager.$stable = 8;
        InputSessionManager.nextSessionId = new AtomicLong();
        InputSessionManager.LEFT = InputBinding.Companion.mouse(Button.LEFT);
    }

    public InputSessionManager(Runtime arg23, ExecutorService arg24, boolean arg25) {
        Intrinsics.checkNotNullParameter(arg23, "runtime");
        Intrinsics.checkNotNullParameter(arg24, "executor");
        super();
        this.runtime = arg23;
        this.executor = arg24;
        this.shutdownExecutorOnStop = arg25;
        this.ingress = new Object();
        this.physicalDown = new LinkedHashSet();
        this.blockedUntilUp = new LinkedHashSet();
        this.owners = new LinkedHashMap();
        Snapshot v2 = new Snapshot(0, null, false, false, false, false, false, false, false, null, false, false, null, false, null, null, 0xFFFF, null);
        this.model = v2;
        MutableStateFlow v1 = StateFlowKt.MutableStateFlow(v2);
        this.snapshots = v1;
        this.snapshotFlow = FlowKt.asStateFlow(v1);
    }

    public InputSessionManager(Runtime arg1, ExecutorService arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = Executors.newSingleThreadExecutor(new InputSessionManager$$ExternalSyntheticLambda3());
            Intrinsics.checkNotNullExpressionValue(arg2, "newSingleThreadExecutor(...)");
        }

        this(arg1, arg2, true);
    }

    static final Thread _init_$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenInputSession");
        v0.setDaemon(true);
        return v0;
    }

    public static final InputBinding access$getLEFT$cp() {
        return InputSessionManager.LEFT;
    }

    public static final AtomicLong access$getNextSessionId$cp() {
        return InputSessionManager.nextSessionId;
    }

    public final CompletableFuture applyProfile(GameProfile arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "profile");
        return InputSessionManager.boundary$default(this, null, false, new InputSessionManager$$ExternalSyntheticLambda2(this, arg8, arg9, arg10), 3, null);
    }

    static final Unit applyProfile$lambda$7(InputSessionManager arg23, GameProfile arg24, int arg25, int arg26) {
        boolean v9;
        InputSessionManager v0 = arg23;
        GameProfile v1 = arg24;
        v0.model = Snapshot.copy$default(v0.model, 0, null, false, false, false, false, false, false, false, null, false, false, null, false, null, null, 0xFF1F, null);
        v0.runtime.applyProfile(v1, arg25, arg26);
        Snapshot v3 = v0.model;
        String v17 = v1.getTargetPackage();
        List v2 = GameProfileCompiler.compile$default(GameProfileCompiler.INSTANCE, v1, null, 2, null);
        if(!(v2 instanceof Collection) || !v2.isEmpty()) {
            Iterator v2_1 = ((Iterable)v2).iterator();
            do {
                if(v2_1.hasNext()) {
                    if(v2_1.next().getInput().getSource() != InputBindingSource.KEYBOARD) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_49;
                }
            }
            while(true);

            goto label_68;
        label_49:
            List v1_1 = v1.getVisualControls();
            if(!(v1_1 instanceof Collection) || !v1_1.isEmpty()) {
                Iterator v1_2 = ((Iterable)v1_1).iterator();
                do {
                    if(v1_2.hasNext()) {
                        InputBinding v2_2 = v1_2.next().getActivationBinding();
                        if(v2_2 == null) {
                            continue;
                        }

                        if(v2_2.getSource() != InputBindingSource.KEYBOARD) {
                            continue;
                        }

                        if(!FreeLookBindings.INSTANCE.isAllowed(v2_2)) {
                            continue;
                        }

                        break;
                    }

                    goto label_71;
                }
                while(true);

            label_68:
                v9 = true;
                goto label_72;
            }
            else {
            }

        label_71:
            v9 = false;
        }
        else {
            goto label_49;
        }

    label_72:
        v0.model = Snapshot.copy$default(v3, 0, null, false, false, v9, true, true, true, false, null, false, false, v17, false, null, null, 0xEF0F, null);
        v0.failed = false;
        return Unit.INSTANCE;
    }

    public final CompletableFuture awaitIdle() {
        CompletableFuture v0 = new CompletableFuture();
        Object v1 = this.ingress;
        __monitor_enter(v1);
        try {
            if(this.closed) {
                v0.complete(Unit.INSTANCE);
            }
            else {
                this.executor.execute(new InputSessionManager$$ExternalSyntheticLambda0(v0));
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v1);
            throw v3;
        }

        __monitor_exit(v1);
        return v0;
    }

    static final void awaitIdle$lambda$38$lambda$37$lambda$36(CompletableFuture arg1) {
        arg1.complete(Unit.INSTANCE);
    }

    public final CompletableFuture backendChanged(Backend arg9, boolean arg10) {
        CompletableFuture v8;
        Intrinsics.checkNotNullParameter(arg9, "backend");
        Object v1 = this.ingress;
        __monitor_enter(v1);
        try {
            Pair v0_1 = TuplesKt.to(arg9, Boolean.valueOf(arg10));
            if(Intrinsics.areEqual(this.observedBackend, v0_1)) {
                if(this.pendingBoundaries <= 0) {
                    if(this.getSnapshot().getCleanupPending()) {
                    }
                    else if(this.getSnapshot().getInjectorReady() == arg10) {
                        goto label_17;
                    }

                    goto label_22;
                }

            label_17:
                v8 = CompletableFuture.completedFuture(this.getSnapshot());
                Intrinsics.checkNotNullExpressionValue(v8, "completedFuture(...)");
            }
            else {
            label_22:
                this.observedBackend = v0_1;
                v8 = InputSessionManager.boundary$default(this, State.RECOVERING, false, new InputSessionManager$$ExternalSyntheticLambda5(this, arg9, arg10), 2, null);
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v8;
    }

    static final Unit backendChanged$lambda$16$lambda$15(InputSessionManager arg41, Backend arg42, boolean arg43) {
        InputSessionManager v0 = arg41;
        Backend v12 = arg42;
        if(v0.model.getBackend() != v12) {
        label_12:
            v0.runtime.backendChanged(v12);
        }
        else if(arg43) {
            if(!v0.model.getInjectorReady()) {
                goto label_12;
            }
            else if(v0.model.getCleanupPending()) {
                goto label_12;
            }
        }

        Snapshot v1 = Snapshot.copy$default(v0.model, 0, null, false, false, false, false, false, false, arg43, v12, false, false, null, false, null, null, 0xFCFF, null);
        v0.model = v1;
        if(arg43) {
            v0.model = Snapshot.copy$default(v1, 0, null, false, false, false, false, false, false, false, null, false, v0.runtime.releaseAll(v1.getSessionId()) ^ 1, null, false, null, null, 0xF7FF, null);
        }

        return Unit.INSTANCE;
    }

    private final CompletableFuture boundary(State arg29, boolean arg30, Function0 arg31) {
        InputSessionManager v1 = this;
        CompletableFuture v6 = new CompletableFuture();
        Object v7 = v1.ingress;
        __monitor_enter(v7);
        try {
            if(!v1.closed) {
                goto label_11;
            }

            v6.complete(v1.getSnapshot());
        }
        catch(Throwable v0) {
            goto label_57;
        }

        __monitor_exit(v7);
        return v6;
        try {
        label_11:
            long v2 = InputSessionManager.nextSessionId.incrementAndGet();
            v1.generation = v2;
            v1.blockedUntilUp.addAll(v1.physicalDown);
            v1.snapshots.setValue(Snapshot.copy$default(v1.getSnapshot(), v2, arg29, false, false, false, false, false, false, false, null, false, true, null, v1.desiredPaused, null, null, 0xD7FC, null));
            v1.runtime.setGamingEnabled(false);
            ++v1.pendingBoundaries;
            v1.executor.execute(new InputSessionManager$$ExternalSyntheticLambda10(v1, v2, arg30, arg31, v6));
        }
        catch(Throwable v0) {
        label_57:
            __monitor_exit(v7);
            throw v0;
        }

        __monitor_exit(v7);
        return v6;
    }

    static CompletableFuture boundary$default(InputSessionManager arg0, State arg1, boolean arg2, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = State.RECOVERING;
        }

        return arg0.boundary(arg1, false, arg3);
    }

    static final void boundary$lambda$32$lambda$31(InputSessionManager arg23, long arg24, boolean arg26, Function0 arg27, CompletableFuture arg28) {
        InputSessionManager v1 = arg23;
        try {
            v1.runtime.setGamingEnabled(false);
            v1.owners.clear();
        }
        catch(Exception v0) {
            goto label_40;
        }

        try {
            v1.model = Snapshot.copy$default(v1.model, arg24, null, false, false, false, false, false, false, false, null, false, v1.runtime.releaseAll(arg24) ^ 1, null, false, null, null, 0xF7FE, null);
            if(!arg26) {
                goto label_32;
            }

            goto label_31;
        }
        catch(Throwable v0_1) {
            try {
                if(arg26) {
                    arg27.invoke();
                }

                throw v0_1;
            label_31:
                arg27.invoke();
            label_32:
                if(arg26) {
                    goto label_65;
                }

                arg27.invoke();
            }
            catch(Exception v0) {
            label_40:
                v1.failed = true;
                Snapshot v3 = v1.model;
                String v0_2 = v0.getMessage();
                if(v0_2 == null) {
                    v0_2 = "Error de sesión";
                }

                v1.model = Snapshot.copy$default(v3, 0, null, false, false, false, false, false, false, false, null, false, true, null, false, v0_2, null, 0xB7FF, null);
            }
        }

    label_65:
        Object v2 = v1.ingress;
        __monitor_enter(v2);
        try {
            --v1.pendingBoundaries;
            arg23.publish(arg24);
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2);
            throw v0_1;
        }

        __monitor_exit(v2);
        arg28.complete(v1.getSnapshot());
    }

    public final CompletableFuture captureChanged(boolean arg9, boolean arg10, String arg11) {
        CompletableFuture v2;
        Object v1 = this.ingress;
        __monitor_enter(v1);
        try {
            Triple v0_1 = new Triple(Boolean.valueOf(arg9), Boolean.valueOf(arg10), arg11);
            if(Intrinsics.areEqual(this.observedCapture, v0_1)) {
                v2 = this.pendingCapture;
                if(v2 != null && !v2.isDone()) {
                    goto label_40;
                }

                if(this.getSnapshot().getMouseConnected() != arg9) {
                    goto label_29;
                }

                if(this.getSnapshot().getKeyboardConnected() != arg10) {
                    goto label_29;
                }

                if(!Intrinsics.areEqual(this.getSnapshot().getCaptureError(), arg11)) {
                    goto label_29;
                }

                v2 = CompletableFuture.completedFuture(this.getSnapshot());
                Intrinsics.checkNotNullExpressionValue(v2, "completedFuture(...)");
            }
            else {
            label_29:
                this.observedCapture = v0_1;
                InputSessionManager v2_1 = this;
                CompletableFuture v8 = InputSessionManager.boundary$default(v2_1, State.RECOVERING, false, new InputSessionManager$$ExternalSyntheticLambda12(this, arg9, arg10, arg11), 2, null);
                v2_1.pendingCapture = v8;
                v2 = v8;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

    label_40:
        __monitor_exit(v1);
        return v2;
    }

    public static CompletableFuture captureChanged$default(InputSessionManager arg0, boolean arg1, boolean arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return arg0.captureChanged(arg1, arg2, arg3);
    }

    static final Unit captureChanged$lambda$14$lambda$12(InputSessionManager arg21, boolean arg22, boolean arg23, String arg24) {
        arg21.model = Snapshot.copy$default(arg21.model, 0, null, arg22, arg23, false, false, false, false, false, null, false, false, null, false, null, arg24, 0x7FF3, null);
        return Unit.INSTANCE;
    }

    private final void deliver(Route arg9, InputEvent arg10) {
        InputEvent v2 = arg10;
        KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DELIVER, v2, this.getSnapshot(), null, "route=" + arg9, 8, null);
        int v9 = WhenMappings.$EnumSwitchMapping$0[arg9.ordinal()];
        if(v9 != 1) {
            if(v9 != 2) {
                if(v9 == 3) {
                    return;
                }

                throw new NoWhenBranchMatchedException();
            }

            Runtime v8 = this.runtime;
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.input.InputEvent.MouseButton");
            v8.cursor(v2);
            return;
        }

        this.runtime.mapped(v2);
    }

    private final void dispatch(Event arg10, PhysicalInput arg11, boolean arg12) {
        Route v12_2;
        Object v1;
        Iterator v0_1;
        Map v0;
        if(!arg12) {
            Object v12 = this.owners.remove(arg11);
            if(v12 == null) {
                KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, arg10.getInput(), this.getSnapshot(), "UP_WITHOUT_OWNER", null, 16, null);
                return;
            }

            v0 = this.owners;
            if(v0.isEmpty()) {
            }
            else {
                v0_1 = v0.entrySet().iterator();
                do {
                    if(v0_1.hasNext()) {
                        v1 = v0_1.next();
                        Object v2 = ((Map$Entry)v1).getKey();
                        v1 = ((Map$Entry)v1).getValue();
                        if(!Intrinsics.areEqual(((PhysicalInput)v2).getBinding(), arg11.getBinding())) {
                            continue;
                        }

                        if(v1 != v12) {
                            continue;
                        }

                        return;
                    }

                    goto label_32;
                }
                while(true);

                return;
            }

        label_32:
            this.deliver(((Route)v12), arg10.getInput());
            return;
        }

        State v12_1 = this.getSnapshot().getState();
        if(v12_1 != State.ACTIVE) {
            if(v12_1 == State.EDITOR && !this.model.getCleanupPending()) {
                KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.EDITOR_CAPTURE, arg10.getInput(), this.getSnapshot(), null, null, 24, null);
                this.runtime.captureBinding(arg10.getInput());
                if(((arg10.getInput() instanceof MouseButton)) && arg10.getInput().getButton() == Button.LEFT && (this.model.getMouseConnected()) && (this.model.getInjectorReady())) {
                    v12_2 = Route.CURSOR;
                    goto label_83;
                }

                v12_2 = Route.NONE;
                goto label_83;
            }

            v12_2 = Route.NONE;
        }
        else if((arg10.getInput() instanceof MouseButton)) {
            v12_2 = this.runtime.routeMouse(arg10.getInput());
        }
        else {
            v12_2 = Route.MAPPER;
        }

    label_83:
        if(v12_2 == Route.NONE) {
            KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, arg10.getInput(), this.getSnapshot(), "NO_GAME_ROUTE", null, 16, null);
            return;
        }

        v0 = this.owners;
        int v2_1 = 0;
        if(v0.isEmpty()) {
        }
        else {
            v0_1 = v0.entrySet().iterator();
            do {
                if(v0_1.hasNext()) {
                    v1 = v0_1.next();
                    Object v3 = ((Map$Entry)v1).getKey();
                    v1 = ((Map$Entry)v1).getValue();
                    if(!Intrinsics.areEqual(((PhysicalInput)v3).getBinding(), arg11.getBinding())) {
                        continue;
                    }

                    if((((Route)v1)) != v12_2) {
                        continue;
                    }

                    break;
                }

                goto label_113;
            }
            while(true);

            v2_1 = 1;
        }

    label_113:
        this.owners.put(arg11, v12_2);
        if(v2_1 == 0) {
            this.deliver(v12_2, arg10.getInput());
        }
    }

    private final long generationId() {
        long v1;
        Object v0 = this.ingress;
        __monitor_enter(v0);
        try {
            v1 = this.generation;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return v1;
    }

    public final Snapshot getSnapshot() {
        return this.snapshots.getValue();
    }

    public final StateFlow getSnapshotFlow() {
        return this.snapshotFlow;
    }

    public final boolean getTransitionPending() {
        Object v0 = this.ingress;
        __monitor_enter(v0);
        try {
            if(this.pendingBoundaries <= 0) {
                goto label_6;
            }
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        boolean v1_1 = true;
        goto label_7;
    label_6:
        v1_1 = false;
    label_7:
        __monitor_exit(v0);
        return v1_1;
    }

    public final CompletableFuture injectionFailed(String arg8) {
        Intrinsics.checkNotNullParameter(arg8, "message");
        return InputSessionManager.boundary$default(this, State.RECOVERING, false, new InputSessionManager$$ExternalSyntheticLambda14(this, arg8), 2, null);
    }

    static final Unit injectionFailed$lambda$17(InputSessionManager arg21, String arg22) {
        arg21.model = Snapshot.copy$default(arg21.model, 0, null, false, false, false, false, false, false, false, null, false, true, null, false, arg22, null, 0xB6FF, null);
        return Unit.INSTANCE;
    }

    public final void mouseModeChanged() {
        Object v1 = this.ingress;
        __monitor_enter(v1);
        try {
            if(!this.closed) {
                long v3 = this.generation;
                long v6 = this.mouseModeGeneration + 1;
                this.mouseModeGeneration = v6;
                Set v0_1 = this.blockedUntilUp;
                Set v2 = this.physicalDown;
                ArrayList v5 = new ArrayList();
                Iterator v2_1 = ((Iterable)v2).iterator();
                while(v2_1.hasNext()) {
                    Object v8 = v2_1.next();
                    if(!Intrinsics.areEqual(v8.getBinding(), InputSessionManager.LEFT)) {
                        continue;
                    }

                    ((Collection)v5).add(v8);
                }

                v0_1.addAll(((Collection)v5));
                this.executor.execute(new InputSessionManager$$ExternalSyntheticLambda9(v3, this, v6));
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
    }

    static final void mouseModeChanged$lambda$23$lambda$22(long arg10, InputSessionManager arg12, long arg13) {
        if(arg10 == arg12.generationId() && arg13 == arg12.mouseModeId()) {
            try {
                Map v10 = arg12.owners;
                LinkedHashMap v11 = new LinkedHashMap();
                Iterator v10_1 = v10.entrySet().iterator();
                while(v10_1.hasNext()) {
                    Object v13 = v10_1.next();
                    if(!Intrinsics.areEqual(((Map$Entry)v13).getKey().getBinding(), InputSessionManager.LEFT)) {
                        continue;
                    }

                    v11.put(((Map$Entry)v13).getKey(), ((Map$Entry)v13).getValue());
                }

                Set v10_2 = CollectionsKt.toSet(((Map)v11).values());
                CollectionsKt.removeAll(arg12.owners.keySet(), new InputSessionManager$$ExternalSyntheticLambda11());
                v10_1 = ((Iterable)v10_2).iterator();
                while(v10_1.hasNext()) {
                    arg12.deliver(v10_1.next(), new MouseButton(Button.LEFT, false, 0, null, 0, 28, null));
                }
            }
            catch(Exception v0) {
                String v10_3 = v0.getMessage();
                if(v10_3 == null) {
                    v10_3 = "Error al liberar el botón izquierdo";
                }

                arg12.injectionFailed(v10_3);
            }
        }
    }

    static final boolean mouseModeChanged$lambda$23$lambda$22$lambda$20(PhysicalInput arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Intrinsics.areEqual(arg1.getBinding(), InputSessionManager.LEFT);
    }

    private final long mouseModeId() {
        long v1;
        Object v0 = this.ingress;
        __monitor_enter(v0);
        try {
            v1 = this.mouseModeGeneration;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return v1;
    }

    private final void publish(long arg24) {
        State v2;
        InputSessionManager v0 = this;
        Object v1 = v0.ingress;
        __monitor_enter(v1);
        try {
            if(v0.generation == arg24) {
                goto label_7;
            }
        }
        catch(Throwable v0_1) {
            goto label_104;
        }

        __monitor_exit(v1);
        return;
        try {
        label_7:
            if(v0.failed) {
                v2 = State.FAILED;
            }
            else if(!v0.requested) {
                v2 = State.IDLE;
            }
            else if(v0.model.getCleanupPending()) {
                v2 = State.RECOVERING;
            }
            else if(v0.desiredPaused) {
                v2 = State.PAUSED;
            }
            else if(v0.model.getEditor()) {
                v2 = State.EDITOR;
            }
            else {
                if((v0.model.getMouseConnected()) && (!v0.model.getKeyboardRequired() || (v0.model.getKeyboardConnected()))) {
                    if((v0.model.getProfileLoaded()) && (v0.model.getMapperReady()) && (v0.model.getCameraReady()) && (v0.model.getInjectorReady())) {
                        if(v0.model.getBackend() == Backend.NONE) {
                        }
                        else {
                            v2 = State.ACTIVE;
                            goto label_10;
                        }
                    }

                    v2 = State.READY;
                    goto label_10;
                }

                v2 = State.RECOVERING;
            }

        label_10:
            State v6 = v2;
            Snapshot v3 = v0.model;
            boolean v2_1 = v0.desiredPaused;
            String v4 = v6 == State.ACTIVE ? null : v0.model.getError();
            String v19 = v4;
            Snapshot v2_2 = Snapshot.copy$default(v3, arg24, v6, false, false, false, false, false, false, false, null, false, false, null, v2_1, v19, null, 0x9FFC, null);
            v0.model = v2_2;
            v0.snapshots.setValue(v2_2);
            Runtime v0_2 = v0.runtime;
            v2_1 = v6 == State.ACTIVE ? true : false;
            v0_2.setGamingEnabled(v2_1);
        }
        catch(Throwable v0_1) {
        label_104:
            __monitor_exit(v1);
            throw v0_1;
        }

        __monitor_exit(v1);
    }

    public final CompletableFuture setEditor(boolean arg9) {
        CompletableFuture v8;
        Object v1 = this.ingress;
        __monitor_enter(v1);
        try {
            if(this.desiredEditor == arg9) {
                v8 = CompletableFuture.completedFuture(this.getSnapshot());
                Intrinsics.checkNotNullExpressionValue(v8, "completedFuture(...)");
            }
            else {
                this.desiredEditor = arg9;
                State v0_1 = arg9 ? State.EDITOR : State.PAUSED;
                v8 = InputSessionManager.boundary$default(this, v0_1, false, new InputSessionManager$$ExternalSyntheticLambda4(this, arg9), 2, null);
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v8;
    }

    static final Unit setEditor$lambda$9$lambda$8(InputSessionManager arg21, boolean arg22) {
        arg21.model = Snapshot.copy$default(arg21.model, 0, null, false, false, false, false, false, false, false, null, arg22, false, null, false, null, null, 0xFBFF, null);
        return Unit.INSTANCE;
    }

    public final CompletableFuture setPaused(boolean arg4) {
        CompletableFuture v3_1;
        Object v0 = this.ingress;
        __monitor_enter(v0);
        try {
            if(this.desiredPaused == arg4) {
                v3_1 = CompletableFuture.completedFuture(this.getSnapshot());
                Intrinsics.checkNotNullExpressionValue(v3_1, "completedFuture(...)");
            }
            else {
                this.desiredPaused = arg4;
                State v4 = arg4 ? State.PAUSED : State.RECOVERING;
                v3_1 = this.boundary(v4, true, new InputSessionManager$$ExternalSyntheticLambda1(this));
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return v3_1;
    }

    static final Unit setPaused$lambda$11$lambda$10(InputSessionManager arg0) {
        arg0.runtime.applyCapturePolicy();
        return Unit.INSTANCE;
    }

    public final CompletableFuture start() {
        return InputSessionManager.boundary$default(this, State.STARTING, false, new InputSessionManager$$ExternalSyntheticLambda6(this), 2, null);
    }

    static final Unit start$lambda$3(InputSessionManager arg1) {
        if(!arg1.requested) {
            arg1.runtime.start();
            arg1.requested = true;
        }

        return Unit.INSTANCE;
    }

    public final CompletableFuture stop() {
        InputSessionManager v0 = this;
        CompletableFuture v6 = InputSessionManager.boundary$default(v0, State.STOPPING, false, new InputSessionManager$$ExternalSyntheticLambda13(this), 2, null);
        Object v1 = v0.ingress;
        __monitor_enter(v1);
        try {
            v0.closed = true;
            v0.physicalDown.clear();
            v0.blockedUntilUp.clear();
            if(v0.shutdownExecutorOnStop) {
                v0.executor.shutdown();
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v1);
            throw v0_1;
        }

        __monitor_exit(v1);
        return v6;
    }

    static final Unit stop$lambda$39(InputSessionManager arg23) {
        InputSessionManager v0 = arg23;
        v0.requested = false;
        v0.runtime.stop();
        v0.failed = false;
        long v4 = v0.generationId();
        boolean v16 = v0.model.getCleanupPending();
        String v1 = v0.model.getCleanupPending() ? "Sesión detenida con cancelación sin confirmar" : null;
        v0.model = new Snapshot(v4, null, false, false, false, false, false, false, false, null, false, v16, null, false, v1, null, 0xB7FE, null);
        return Unit.INSTANCE;
    }

    public final void submit(InputEvent arg16) {
        boolean v9;
        InputBinding v1;
        InputEvent v2 = arg16;
        Intrinsics.checkNotNullParameter(v2, "input");
        KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_INGRESS, v2, this.getSnapshot(), null, null, 24, null);
        boolean v0 = v2 instanceof KeyDown;
        if(v0) {
            v1 = InputBinding.Companion.keyboard(v2.getKeyName());
        }
        else if((v2 instanceof KeyUp)) {
            v1 = InputBinding.Companion.keyboard(v2.getKeyName());
        }
        else if((v2 instanceof MouseButton)) {
            v1 = InputBinding.Companion.mouse(v2.getButton());
        }
        else {
            return;
        }

        PhysicalInput v8 = new PhysicalInput(v2.getDevicePath(), v1);
        int v1_1 = 0;
        if(!v0) {
            if(((v2 instanceof MouseButton)) && (v2.getPressed())) {
                goto label_45;
            }

            v9 = false;
        }
        else {
        label_45:
            v9 = true;
        }

        Object v10 = this.ingress;
        __monitor_enter(v10);
        try {
            if(!this.closed) {
                goto label_60;
            }

            KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, v2, this.getSnapshot(), "CLOSED", null, 16, null);
        }
        catch(Throwable v0_1) {
            goto label_168;
        }

        __monitor_exit(v10);
        return;
        try {
        label_60:
            if((((v2 instanceof KeyDown)) || ((v2 instanceof KeyUp))) && !this.getSnapshot().getKeyboardConnected()) {
                v1_1 = 1;
            }

            if(v1_1 != 0) {
                this.executor.execute(new InputSessionManager$$ExternalSyntheticLambda7(this.generation, this));
            }
        }
        catch(Throwable v0_1) {
            goto label_168;
        }

        Set v0_2 = this.physicalDown;
        if(v9) {
            try {
                if(!v0_2.add(v8)) {
                    KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, v2, this.getSnapshot(), "REPEATED_DOWN", null, 16, null);
                }
                else {
                    goto label_88;
                }
            }
            catch(Throwable v0_1) {
                goto label_168;
            }

            __monitor_exit(v10);
            return;
            try {
            label_88:
                if(this.blockedUntilUp.contains(v8)) {
                    KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, arg16, this.getSnapshot(), "HELD_ACROSS_BOUNDARY", null, 16, null);
                }
                else {
                    goto label_102;
                }
            }
            catch(Throwable v0_1) {
                goto label_168;
            }

            __monitor_exit(v10);
            return;
            try {
            label_102:
                if(!this.getSnapshot().getCleanupPending()) {
                    if(this.getSnapshot().getState() != State.ACTIVE && this.getSnapshot().getState() != State.EDITOR) {
                        if(v1_1 == 0) {
                            goto label_121;
                        }
                        else if(this.getSnapshot().getState() != State.RECOVERING) {
                            goto label_121;
                        }
                    }

                    v2 = arg16;
                    goto label_141;
                }

            label_121:
                KeyboardRouteDiagnostics v0_3 = KeyboardRouteDiagnostics.INSTANCE;
                Stage v1_2 = Stage.SESSION_DROP;
                Snapshot v3 = this.getSnapshot();
                String v15 = this.getSnapshot().getCleanupPending() ? "CLEANUP_PENDING" : "SESSION_NOT_ACTIVE";
                KeyboardRouteDiagnostics.key$default(v0_3, v1_2, arg16, v3, v15, null, 16, null);
            }
            catch(Throwable v0_1) {
                goto label_168;
            }

            __monitor_exit(v10);
            return;
        }
        else {
            try {
                v0_2.remove(v8);
                this.blockedUntilUp.remove(v8);
            label_141:
                Event v11 = new Event(this.generation, v2);
                long v12 = this.mouseModeGeneration;
                KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_QUEUED, v2, this.getSnapshot(), null, null, 24, null);
                this.executor.execute(new InputSessionManager$$ExternalSyntheticLambda8(v11, this, arg16, v8, v12, v9));
                goto label_164;
            }
            catch(Throwable v0_1) {
            label_168:
                __monitor_exit(v10);
                throw v0_1;
            }
        }

        goto label_141;
    label_164:
        __monitor_exit(v10);
    }

    static final void submit$lambda$26$lambda$24(long arg24, InputSessionManager arg26) {
        long v0 = arg24;
        InputSessionManager v2 = arg26;
        if(v0 != v2.generationId()) {
            return;
        }

        v2.model = Snapshot.copy$default(v2.model, 0, null, false, true, false, false, false, false, false, null, false, false, null, false, null, null, 0xFFF7, null);
        v2.publish(v0);
    }

    static final void submit$lambda$26$lambda$25(Event arg15, InputSessionManager arg16, InputEvent arg17, PhysicalInput arg18, long arg19, boolean arg21) {
        if(arg15.getSessionId() != arg16.generationId()) {
            KeyboardRouteDiagnostics.INSTANCE.key(Stage.SESSION_DROP, arg17, arg16.getSnapshot(), "STALE_GENERATION", "eventSession=" + arg15.getSessionId());
            return;
        }

        InputSessionManager v3 = arg16;
        if((Intrinsics.areEqual(arg18.getBinding(), InputSessionManager.LEFT)) && arg19 != v3.mouseModeId()) {
            return;
        }

        PhysicalInput v0 = arg18;
        boolean v1 = arg21;
        try {
            v3.dispatch(arg15, v0, v1);
            return;
        }
        catch(Exception v0_1) {
            KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.SESSION_DROP, arg17, v3.getSnapshot(), "DISPATCH_EXCEPTION", null, 16, null);
            String v15 = v0_1.getMessage();
            if(v15 == null) {
                v15 = "Error al ejecutar input";
            }

            v3.injectionFailed(v15);
            return;
        }
    }
}

