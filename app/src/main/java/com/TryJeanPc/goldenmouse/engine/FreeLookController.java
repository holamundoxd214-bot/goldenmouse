package com.TryJeanPc.goldenmouse.engine;

import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerLease;
import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerOwner;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import com.TryJeanPc.goldenmouse.mapper.FreeLookBindings;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.VistaLibreMarker;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001A\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003^_`B\u0095\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006\u0012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f\u0012\u0018\u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f\u0012\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0006\u0012\u000E\b\u0002\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000E\u0010?\u001A\u00020\t2\u0006\u0010@\u001A\u00020\u0007J\u0006\u0010A\u001A\u00020\tJ&\u0010B\u001A\u00020\u00112\u0006\u0010C\u001A\u00020D2\u0006\u00100\u001A\u00020\u00142\u0006\u00101\u001A\u00020\u00142\u0006\u0010/\u001A\u00020\u0007J\u000E\u0010E\u001A\u00020\t2\u0006\u0010F\u001A\u00020GJ\u000E\u0010H\u001A\u00020\t2\u0006\u0010F\u001A\u00020GJ&\u0010I\u001A\u00020\t2\u0006\u0010J\u001A\u00020\u00142\u0006\u0010K\u001A\u00020\u00142\u0006\u0010L\u001A\u00020\u00072\u0006\u0010M\u001A\u00020\u0007J\u0010\u0010N\u001A\u00020\u00112\b\b\u0002\u0010O\u001A\u00020\tJ\u0010\u0010P\u001A\u00020\t2\b\b\u0002\u0010O\u001A\u00020\tJ\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010R\u001A\u00020\u00112\u0006\u0010O\u001A\u00020\tH\u0002J\u0012\u0010S\u001A\u00020\u00112\b\u0010T\u001A\u0004\u0018\u00010\u001EH\u0002J\u0010\u0010U\u001A\u00020\t2\u0006\u0010V\u001A\u00020&H\u0002J\b\u0010W\u001A\u00020\u0011H\u0002J\b\u0010X\u001A\u00020\tH\u0002J\u0010\u0010Y\u001A\u00020\u00112\u0006\u0010Z\u001A\u00020\u0010H\u0002J\b\u0010[\u001A\u00020\u0011H\u0002J\b\u0010\\\u001A\u00020\u0011H\u0016J\u0012\u0010]\u001A\u0004\u0018\u00010\r2\u0006\u0010F\u001A\u00020GH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001E0\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001E0$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010+\u001A\u00020*2\u0006\u0010)\u001A\u00020*@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u000E\u0010.\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00102\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00103\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00105\u001A\u0004\u0018\u000106X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00107\u001A\u0004\u0018\u000108X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u00109\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u0010:R\u000E\u0010;\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010<\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010=\u001A\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "injector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "suspendRaw", "Lkotlin/Function1;", "", "Ljava/util/concurrent/CompletableFuture;", "", "resumeRaw", "admitted", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "matches", "onFailure", "", "", "jitter", "Lkotlin/Function0;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "lock", "Ljava/lang/Object;", "queue", "Ljava/util/ArrayDeque;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work;", "held", "", "Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "priority", "", "capacityKey", "", "configurations", "", "selected", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Selection;", "consuming", "running", "value", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Phase;", "phase", "getPhase", "()Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Phase;", "generation", "sessionId", "width", "height", "current", "gesture", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookGesture;", "owner", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;", "lease", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "rawSession", "Ljava/lang/Long;", "activeSince", "failureReported", "worker", "Ljava/lang/Thread;", "beginSession", "id", "clearConfiguration", "configure", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "isConfiguredFor", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "handle", "offerRaw", "dx", "dy", "session", "timestampNanos", "cancel", "resetHeld", "cancelAndDrain", "awaitIdle", "cancelLocked", "select", "marker", "valid", "selection", "reconcile", "releaseContact", "fail", "message", "runLoop", "close", "input", "Phase", "Selection", "Work", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FreeLookController implements AutoCloseable {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "TRANSFERRING", "ACTIVE", "FAILED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Phase {
        public static final enum Phase ACTIVE;
        public static final enum Phase FAILED;
        public static final enum Phase IDLE;
        public static final enum Phase TRANSFERRING;

        private static final Phase[] $values() {
            return new Phase[]{Phase.IDLE, Phase.TRANSFERRING, Phase.ACTIVE, Phase.FAILED};
        }

        static {
            Phase.IDLE = new Phase("IDLE", 0);
            Phase.TRANSFERRING = new Phase("TRANSFERRING", 1);
            Phase.ACTIVE = new Phase("ACTIVE", 2);
            Phase.FAILED = new Phase("FAILED", 3);
            Phase[] v0 = Phase.$values();
            Phase.$VALUES = v0;
            Phase.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Phase(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Phase.$ENTRIES;
        }

        public static Phase valueOf(String arg1) {
            return Enum.valueOf(Phase.class, arg1);
        }

        public static Phase[] values() {
            return Phase.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Selection;", "", "marker", "Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "session", "", "generation", "<init>", "(Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;JJ)V", "getMarker", "()Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "getSession", "()J", "getGeneration", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Selection {
        private final long generation;
        private final VistaLibreMarker marker;
        private final long session;

        public Selection(VistaLibreMarker arg2, long arg3, long arg5) {
            Intrinsics.checkNotNullParameter(arg2, "marker");
            super();
            this.marker = arg2;
            this.session = arg3;
            this.generation = arg5;
        }

        public final VistaLibreMarker component1() {
            return this.marker;
        }

        public final long component2() {
            return this.session;
        }

        public final long component3() {
            return this.generation;
        }

        public final Selection copy(VistaLibreMarker arg7, long arg8, long arg10) {
            Intrinsics.checkNotNullParameter(arg7, "marker");
            return new Selection(arg7, arg8, arg10);
        }

        public static Selection copy$default(Selection arg0, VistaLibreMarker arg1, long arg2, long arg4, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.marker;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.session;
            }

            if((arg6 & 4) != 0) {
                arg4 = arg0.generation;
            }

            return arg0.copy(arg1, arg2, arg4);
        }

        public boolean equals(Object arg8) {
            if(this == (((Selection)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Selection)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.marker, ((Selection)arg8).marker)) {
                return 0;
            }

            if(this.session != ((Selection)arg8).session) {
                return 0;
            }

            if(this.generation != ((Selection)arg8).generation) {
                return 0;
            }

            return 1;
        }

        public final long getGeneration() {
            return this.generation;
        }

        public final VistaLibreMarker getMarker() {
            return this.marker;
        }

        public final long getSession() {
            return this.session;
        }

        public int hashCode() {
            return (this.marker.hashCode() * 0x1F + Long.hashCode(this.session)) * 0x1F + Long.hashCode(this.generation);
        }

        public String toString() {
            return "Selection(marker=" + this.marker + ", session=" + this.session + ", generation=" + this.generation + ")";
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work;", "", "Reconcile", "Motion", "Fence", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Fence;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Motion;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Reconcile;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) interface Work {
        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Fence;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work;", "completion", "Ljava/util/concurrent/CompletableFuture;", "", "<init>", "(Ljava/util/concurrent/CompletableFuture;)V", "getCompletion", "()Ljava/util/concurrent/CompletableFuture;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Fence implements Work {
            public static final int $stable = 8;
            private final CompletableFuture completion;

            static {
            }

            public Fence(CompletableFuture arg2) {
                Intrinsics.checkNotNullParameter(arg2, "completion");
                super();
                this.completion = arg2;
            }

            public final CompletableFuture component1() {
                return this.completion;
            }

            public final Fence copy(CompletableFuture arg1) {
                Intrinsics.checkNotNullParameter(arg1, "completion");
                return new Fence(arg1);
            }

            public static Fence copy$default(Fence arg0, CompletableFuture arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.completion;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((Fence)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof Fence)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.completion, ((Fence)arg4).completion)) {
                    return 0;
                }

                return 1;
            }

            public final CompletableFuture getCompletion() {
                return this.completion;
            }

            public int hashCode() {
                return this.completion.hashCode();
            }

            public String toString() {
                return "Fence(completion=" + this.completion + ")";
            }
        }

        @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Motion;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work;", "selection", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Selection;", "dx", "", "dy", "<init>", "(Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Selection;II)V", "getSelection", "()Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Selection;", "getDx", "()I", "getDy", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Motion implements Work {
            public static final int $stable;
            private final int dx;
            private final int dy;
            private final Selection selection;

            static {
            }

            public Motion(Selection arg2, int arg3, int arg4) {
                Intrinsics.checkNotNullParameter(arg2, "selection");
                super();
                this.selection = arg2;
                this.dx = arg3;
                this.dy = arg4;
            }

            public final Selection component1() {
                return this.selection;
            }

            public final int component2() {
                return this.dx;
            }

            public final int component3() {
                return this.dy;
            }

            public final Motion copy(Selection arg1, int arg2, int arg3) {
                Intrinsics.checkNotNullParameter(arg1, "selection");
                return new Motion(arg1, arg2, arg3);
            }

            public static Motion copy$default(Motion arg0, Selection arg1, int arg2, int arg3, int arg4, Object arg5) {
                if((arg4 & 1) != 0) {
                    arg1 = arg0.selection;
                }

                if((arg4 & 2) != 0) {
                    arg2 = arg0.dx;
                }

                if((arg4 & 4) != 0) {
                    arg3 = arg0.dy;
                }

                return arg0.copy(arg1, arg2, arg3);
            }

            public boolean equals(Object arg5) {
                if(this == (((Motion)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof Motion)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.selection, ((Motion)arg5).selection)) {
                    return 0;
                }

                if(this.dx != ((Motion)arg5).dx) {
                    return 0;
                }

                if(this.dy != ((Motion)arg5).dy) {
                    return 0;
                }

                return 1;
            }

            public final int getDx() {
                return this.dx;
            }

            public final int getDy() {
                return this.dy;
            }

            public final Selection getSelection() {
                return this.selection;
            }

            public int hashCode() {
                return (this.selection.hashCode() * 0x1F + Integer.hashCode(this.dx)) * 0x1F + Integer.hashCode(this.dy);
            }

            public String toString() {
                return "Motion(selection=" + this.selection + ", dx=" + this.dx + ", dy=" + this.dy + ")";
            }
        }

        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work$Reconcile;", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController$Work;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Reconcile implements Work {
            public static final int $stable;
            public static final Reconcile INSTANCE;

            static {
                Reconcile.INSTANCE = new Reconcile();
            }

            private Reconcile() {
                super();
            }

            public boolean equals(Object arg2) {
                if(this == (((Reconcile)arg2))) {
                    return 1;
                }

                if(!(arg2 instanceof Reconcile)) {
                    return 0;
                }

                return 1;
            }

            public int hashCode() {
                return 0x218468C3;
            }

            public String toString() {
                return "Reconcile";
            }
        }

    }

    public static final int $stable = 8;
    private long activeSince;
    private final Function2 admitted;
    private final Object capacityKey;
    private volatile List configurations;
    private volatile boolean consuming;
    private Selection current;
    private boolean failureReported;
    private long generation;
    private FreeLookGesture gesture;
    private int height;
    private final Map held;
    private final TouchInjector injector;
    private final Function0 jitter;
    private PointerLease lease;
    private final Object lock;
    private final Function2 matches;
    private final Function1 onFailure;
    private PointerOwner owner;
    private volatile Phase phase;
    private final List priority;
    private final ArrayDeque queue;
    private Long rawSession;
    private final Function1 resumeRaw;
    private volatile boolean running;
    private volatile Selection selected;
    private long sessionId;
    private final Function1 suspendRaw;
    private int width;
    private final Thread worker;

    public static void $r8$lambda$3Pks6ZToTURroTEYDHo97GxzXuU(FreeLookController arg0) {
        arg0.runLoop();
    }

    static {
    }

    public FreeLookController(TouchInjector arg2, Function1 arg3, Function1 arg4, Function2 arg5, Function2 arg6, Function1 arg7, Function0 arg8) {
        Intrinsics.checkNotNullParameter(arg2, "injector");
        Intrinsics.checkNotNullParameter(arg3, "suspendRaw");
        Intrinsics.checkNotNullParameter(arg4, "resumeRaw");
        Intrinsics.checkNotNullParameter(arg5, "admitted");
        Intrinsics.checkNotNullParameter(arg6, "matches");
        Intrinsics.checkNotNullParameter(arg7, "onFailure");
        Intrinsics.checkNotNullParameter(arg8, "jitter");
        super();
        this.injector = arg2;
        this.suspendRaw = arg3;
        this.resumeRaw = arg4;
        this.admitted = arg5;
        this.matches = arg6;
        this.onFailure = arg7;
        this.jitter = arg8;
        this.lock = new Object();
        this.queue = new ArrayDeque();
        this.held = new LinkedHashMap();
        this.priority = new ArrayList();
        this.capacityKey = new Object();
        this.configurations = CollectionsKt.emptyList();
        this.running = true;
        this.phase = Phase.IDLE;
        Thread v3 = new Thread(new FreeLookController$$ExternalSyntheticLambda1(this), "GoldenFreeLook");
        v3.setDaemon(true);
        v3.start();
        this.worker = v3;
    }

    public FreeLookController(TouchInjector arg10, Function1 arg11, Function1 arg12, Function2 arg13, Function2 arg14, Function1 arg15, Function0 arg16, int arg17, DefaultConstructorMarker arg18) {
        Function0 v8_1;
        if((arg17 & 0x40) != 0) {
            FreeLookController$$ExternalSyntheticLambda4 v8 = new FreeLookController$$ExternalSyntheticLambda4();
        }
        else {
            v8_1 = arg16;
        }

        this(arg10, arg11, arg12, arg13, arg14, arg15, v8_1);
    }

    static final int _init_$lambda$0() {
        return ThreadLocalRandom.current().nextInt(-10, 11);
    }

    public static final TouchInjector access$getInjector$p(FreeLookController arg0) {
        return arg0.injector;
    }

    public static final PointerLease access$getLease$p(FreeLookController arg0) {
        return arg0.lease;
    }

    public static final PointerOwner access$getOwner$p(FreeLookController arg0) {
        return arg0.owner;
    }

    public static final void access$setLease$p(FreeLookController arg0, PointerLease arg1) {
        arg0.lease = arg1;
    }

    public static final boolean access$valid(FreeLookController arg0, Selection arg1) {
        return arg0.valid(arg1);
    }

    public final CompletableFuture awaitIdle() {
        CompletableFuture v1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = new CompletableFuture();
            if(!this.running) {
                boolean v4_1 = this.owner == null ? true : false;
                v1.complete(Boolean.valueOf(v4_1));
            }
            else {
                this.queue.addLast(new Fence(v1));
                this.lock.notifyAll();
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        return v1;
    }

    public final boolean beginSession(long arg4) {
        if(!this.cancelAndDrain(true)) {
            return 0;
        }

        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            this.sessionId = arg4;
            this.failureReported = false;
        }
        catch(Throwable v3) {
            __monitor_exit(v1);
            throw v3;
        }

        __monitor_exit(v1);
        return 1;
    }

    public final void cancel(boolean arg2) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.cancelLocked(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public static void cancel$default(FreeLookController arg0, boolean arg1, int arg2, Object arg3) {
        arg0.cancel(false);
    }

    public final boolean cancelAndDrain(boolean arg3) {
        Boolean v2_2;
        Object v2_1;
        this.cancel(arg3);
        try {
            v2_1 = Result.constructor-impl(this.awaitIdle().get(2, TimeUnit.SECONDS));
        }
        catch(Throwable v2) {
            v2_1 = Result.constructor-impl(ResultKt.createFailure(v2));
        }

        Boolean v3 = Boolean.valueOf(false);
        if(Result.isFailure-impl(v2_1)) {
            v2_2 = v3;
        }

        return v2_2.booleanValue();
    }

    public static boolean cancelAndDrain$default(FreeLookController arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.cancelAndDrain(false);
    }

    private final void cancelLocked(boolean arg2) {
        this.priority.clear();
        if(arg2) {
            this.held.clear();
        }

        if(this.selected == null) {
            if(this.consuming) {
            }
            else {
                return;
            }
        }

        this.select(null);
    }

    public final boolean clearConfiguration() {
        if(!this.cancelAndDrain(true)) {
            return 0;
        }

        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            this.configurations = CollectionsKt.emptyList();
        }
        catch(Throwable v3) {
            __monitor_exit(v1);
            throw v3;
        }

        __monitor_exit(v1);
        this.injector.releaseCapacity(this.capacityKey);
        return 1;
    }

    public void close() {
        this.cancelAndDrain(true);
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.running = false;
            ArrayDeque v2 = this.queue;
            ArrayList v3 = new ArrayList();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                Object v4 = v2_1.next();
                if(!(v4 instanceof Fence)) {
                    continue;
                }

                ((Collection)v3).add(v4);
            }

            v2_1 = ((Iterable)v3).iterator();
            while(v2_1.hasNext()) {
                v2_1.next().getCompletion().complete(Boolean.valueOf(false));
            }

            this.queue.clear();
            this.lock.notifyAll();
        }
        catch(Throwable v6) {
            goto label_41;
        }

        __monitor_exit(v0);
        Thread v0_1 = Thread.currentThread();
        Thread v1 = this.worker;
        if(v0_1 != v1) {
            v1.join(2000);
        }

        this.injector.releaseCapacity(this.capacityKey);
        return;
    label_41:
        __monitor_exit(v0);
        throw v6;
    }

    public final void configure(GameProfile arg9, int arg10, int arg11, long arg12) {
        List v2_1;
        Intrinsics.checkNotNullParameter(arg9, "profile");
        boolean v0 = true;
        if(this.cancelAndDrain(true)) {
            List v1 = arg9.getVisualControls();
            ArrayList v2 = new ArrayList();
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                Object v3 = v1_1.next();
                Object v4 = v3;
                InputBinding v5 = ((VistaLibreMarker)v4).getActivationBinding();
                if(v5 == null) {
                    continue;
                }

                float v7 = 3.402823E+38f;
                if(Math.abs(((VistaLibreMarker)v4).getX()) > v7) {
                    continue;
                }

                if(Math.abs(((VistaLibreMarker)v4).getY()) > v7) {
                    continue;
                }

                int v6 = ((VistaLibreMarker)v4).getSensitivity();
                if(50 > v6) {
                    continue;
                }

                if(v6 >= 1001) {
                    continue;
                }

                if(FreeLookBindings.INSTANCE.conflict(arg9, ((VistaLibreMarker)v4).getId(), v5, this.matches) != null) {
                    continue;
                }

                ((Collection)v2).add(v3);
            }

            if(this.injector.reserveCapacity(this.capacityKey, ((List)v2).isEmpty() ^ 1)) {
                Object v9 = this.lock;
                __monitor_enter(v9);
                try {
                    this.width = arg10;
                    this.height = arg11;
                    this.sessionId = arg12;
                    if(arg10 <= 0 || arg11 <= 0) {
                        v0 = false;
                    }
                    else {
                    }

                    if(Boolean.valueOf(v0).booleanValue()) {
                    }
                    else {
                        v2 = null;
                    }

                    if(v2 == null) {
                        v2_1 = CollectionsKt.emptyList();
                    }

                    this.configurations = v2_1;
                    this.failureReported = false;
                }
                catch(Throwable v8) {
                    __monitor_exit(v9);
                    throw v8;
                }

                __monitor_exit(v9);
                return;
            }

            throw new IllegalStateException("No hay capacidad táctil para Vista libre".toString());
        }

        throw new IllegalStateException("Vista libre conserva un contacto pendiente".toString());
    }

    private final void fail(String arg5) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.priority.clear();
            this.selected = null;
            this.consuming = true;
            this.phase = Phase.FAILED;
            CollectionsKt.removeAll(this.queue, new FreeLookController$$ExternalSyntheticLambda3());
            boolean v2 = this.failureReported;
            this.failureReported = true;
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        if(!v2) {
            this.onFailure.invoke(arg5);
        }
    }

    static final boolean fail$lambda$27$lambda$25(Work arg0) {
        return arg0 instanceof Motion;
    }

    public final Phase getPhase() {
        return this.phase;
    }

    public final boolean handle(InputEvent arg9) {
        Iterator v9_1;
        Collection v9;
        Object v4;
        Object v5;
        boolean v2;
        Intrinsics.checkNotNullParameter(arg9, "event");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            InputBinding v1 = this.input(arg9);
            v2 = false;
            if(v1 == null) {
            }
            else {
                Iterator v3 = this.configurations.iterator();
                do {
                    v5 = null;
                    if(v3.hasNext()) {
                        v4 = v3.next();
                        Function2 v7 = this.matches;
                        InputBinding v6 = v4.getActivationBinding();
                        Intrinsics.checkNotNull(v6);
                        if(!v7.invoke(v6, v1).booleanValue()) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_22;
                    }
                }
                while(true);

                goto label_23;
            label_22:
                v4 = v5;
            label_23:
                if(v4 == null) {
                    goto label_113;
                }

                if(!(arg9 instanceof KeyDown)) {
                    if(((arg9 instanceof MouseButton)) && (((MouseButton)arg9).getPressed())) {
                        goto label_60;
                    }

                    if(this.held.remove(v1) == null) {
                        goto label_58;
                    }

                    v9 = this.held.values();
                    if(!(v9 instanceof Collection) || !v9.isEmpty()) {
                        v9_1 = ((Iterable)v9).iterator();
                        goto label_45;
                    }
                    else {
                    }

                    goto label_53;
                }
                else {
                label_60:
                    if(this.held.containsKey(v1)) {
                        goto label_58;
                    }

                    v9 = this.held.values();
                    if(!(v9 instanceof Collection) || !v9.isEmpty()) {
                        v9_1 = ((Iterable)v9).iterator();
                        do {
                            if(v9_1.hasNext()) {
                                if(!Intrinsics.areEqual(v9_1.next().getId(), ((VistaLibreMarker)v4).getId())) {
                                    continue;
                                }

                                break;
                            }

                            goto label_81;
                        }
                        while(true);

                        int v2_1 = 1;
                    }
                    else {
                    }

                label_81:
                    this.held.put(v1, v4);
                    if(v2) {
                        goto label_58;
                    }

                    if(this.phase == Phase.FAILED) {
                        goto label_58;
                    }

                    Function2 v9_2 = this.admitted;
                    Long v1_1 = Long.valueOf(this.sessionId);
                    InputBinding v2_2 = ((VistaLibreMarker)v4).getActivationBinding();
                    Intrinsics.checkNotNull(v2_2);
                    if(!v9_2.invoke(v1_1, v2_2).booleanValue()) {
                        goto label_58;
                    }

                    this.priority.add(v4);
                    goto label_98;
                    do {
                    label_45:
                        if(!v9_1.hasNext()) {
                            goto label_53;
                        }
                    }
                    while(!Intrinsics.areEqual(v9_1.next().getId(), ((VistaLibreMarker)v4).getId()));

                    goto label_58;
                label_53:
                    CollectionsKt.removeAll(this.priority, new FreeLookController$$ExternalSyntheticLambda2(((VistaLibreMarker)v4)));
                label_98:
                    Object v9_3 = CollectionsKt.lastOrNull(this.priority);
                    Selection v1_2 = this.selected;
                    if(v1_2 != null) {
                        VistaLibreMarker v1_3 = v1_2.getMarker();
                        if(v1_3 != null) {
                            String v1_4 = v1_3.getId();
                        }
                        else {
                            goto label_106;
                        }
                    }
                    else {
                    label_106:
                        Object v1_5 = v5;
                    }

                    if(v9_3 != null) {
                        String v5_1 = ((VistaLibreMarker)v9_3).getId();
                    }

                    if(Intrinsics.areEqual(v1_4, v5)) {
                        goto label_58;
                    }

                    this.select(((VistaLibreMarker)v9_3));
                }

            label_58:
                v2 = true;
            }
        }
        catch(Throwable v8) {
            goto label_116;
        }

    label_113:
        __monitor_exit(v0);
        return v2;
    label_116:
        __monitor_exit(v0);
        throw v8;
    }

    static final boolean handle$lambda$14$lambda$13(VistaLibreMarker arg1, VistaLibreMarker arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return Intrinsics.areEqual(arg2.getId(), arg1.getId());
    }

    private final InputBinding input(InputEvent arg1) {
        if((arg1 instanceof KeyDown)) {
            return InputBinding.Companion.keyboard(((KeyDown)arg1).getKeyName());
        }

        if((arg1 instanceof KeyUp)) {
            return InputBinding.Companion.keyboard(((KeyUp)arg1).getKeyName());
        }

        if((arg1 instanceof MouseButton)) {
            return InputBinding.Companion.mouse(((MouseButton)arg1).getButton());
        }

        return null;
    }

    public final boolean isConfiguredFor(InputEvent arg5) {
        Intrinsics.checkNotNullParameter(arg5, "event");
        InputBinding v5 = this.input(arg5);
        if(v5 == null) {
            return 0;
        }

        List v1 = this.configurations;
        if(((v1 instanceof Collection)) && (v1.isEmpty())) {
            return 0;
        }

        Iterator v1_1 = ((Iterable)v1).iterator();
        do {
            if(!v1_1.hasNext()) {
                return 0;
            }

            Object v2 = v1_1.next();
            Function2 v3 = this.matches;
            InputBinding v2_1 = ((VistaLibreMarker)v2).getActivationBinding();
            Intrinsics.checkNotNull(v2_1);
        }
        while(!v3.invoke(v2_1, v5).booleanValue());

        return 1;
    }

    public final boolean offerRaw(int arg7, int arg8, long arg9, long arg11) {
        int v2;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v2 = 0;
            if(this.consuming) {
                goto label_7;
            }
        }
        catch(Throwable v6) {
            goto label_52;
        }

        __monitor_exit(v0);
        return 0;
        try {
        label_7:
            Selection v1 = this.selected;
            if(this.phase == Phase.ACTIVE && v1 != null && this.current == v1 && arg9 == v1.getSession() && arg11 - this.activeSince >= 0) {
                Function2 v11 = this.admitted;
                Long v9 = Long.valueOf(arg9);
                InputBinding v10 = v1.getMarker().getActivationBinding();
                Intrinsics.checkNotNull(v10);
                if(!v11.invoke(v9, v10).booleanValue()) {
                }
                else {
                    if(this.queue.size() >= 0x1000) {
                        this.cancelLocked(false);
                        v2 = 1;
                    }
                    else {
                        this.queue.addLast(new Motion(v1, arg7, arg8));
                        this.lock.notifyAll();
                    }

                    goto label_44;
                }
            }

            goto label_49;
        }
        catch(Throwable v6) {
        label_52:
            __monitor_exit(v0);
            throw v6;
        }

    label_44:
        __monitor_exit(v0);
        if(v2 != 0) {
            this.fail("Cola Vista libre bloqueada");
        }

        return 1;
    label_49:
        __monitor_exit(v0);
        return 1;
    }

    private final void reconcile() {
        Object v1_1;
        Selection v0 = this.selected;
        if(this.current == v0 && this.phase == Phase.ACTIVE) {
        }
        else if(!this.releaseContact()) {
            this.fail("Liberación Vista libre no confirmada");
            return;
        }
        else {
            if(v0 != null) {
                if(!this.valid(v0)) {
                }
                else {
                    this.rawSession = Long.valueOf(v0.getSession());
                    if(!this.suspendRaw.invoke(Long.valueOf(v0.getSession())).get(2, TimeUnit.SECONDS).booleanValue()) {
                        if(this.valid(v0)) {
                            this.fail("Transferencia RAW Vista libre no confirmada");
                            return;
                        }
                        else {
                            return;
                        }
                    }
                    else if(!this.valid(v0)) {
                        return;
                    }
                    else {
                        goto label_36;
                    }
                }
            }

            goto label_94;
        }

        return;
    label_36:
        VistaLibreMarker v1 = v0.getMarker();
        this.owner = new PointerOwner(v1.getId(), v0.getGeneration(), v0.getSession(), this.capacityKey);
        FreeLookGesture v3 = new FreeLookGesture(((int)(v1.getX() + (((float)v1.getWidth())) / 2f)), ((int)(v1.getY() + (((float)v1.getHeight())) / 2f)), this.width, this.height, v1.getSensitivity(), v1.getResetOnEdge(), this.jitter, new FreeLookController$reconcile$touch$1(this, v0));
        this.gesture = v3;
        Intrinsics.checkNotNull(v3);
        if(v3.start()) {
            this.current = v0;
            v1_1 = this.lock;
            __monitor_enter(v1_1);
            try {
                if(this.valid(v0)) {
                    this.activeSince = System.nanoTime();
                    this.phase = Phase.ACTIVE;
                }
            }
            catch(Throwable v0_1) {
                __monitor_exit(v1_1);
                throw v0_1;
            }

            __monitor_exit(v1_1);
            return;
        }
        else if(this.valid(v0)) {
            this.fail("DOWN Vista libre no confirmado");
            return;
        }
        else {
            this.releaseContact();
            return;
        }

    label_94:
        Long v1_2 = this.rawSession;
        if(v1_2 != null) {
            this.resumeRaw.invoke(Long.valueOf(((Number)v1_2).longValue())).booleanValue();
        }

        this.rawSession = null;
        v1_1 = this.lock;
        __monitor_enter(v1_1);
        try {
            if(this.selected == v0) {
                this.consuming = false;
                this.phase = Phase.IDLE;
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v1_1);
            throw v0_1;
        }

        __monitor_exit(v1_1);
    }

    private final boolean releaseContact() {
        FreeLookGesture v0 = this.gesture;
        boolean v0_1 = v0 != null ? v0.stop() : true;
        FreeLookGesture v2 = null;
        this.gesture = v2;
        PointerOwner v3 = this.owner;
        boolean v3_1 = v3 != null ? this.injector.releaseOwner(v3) : true;
        this.current = ((Selection)v2);
        if(v3_1) {
            this.owner = ((PointerOwner)v2);
            this.lease = ((PointerLease)v2);
        }

        if((v0_1) && (v3_1)) {
            return 1;
        }

        return 0;
    }

    private final void runLoop() {
        Object v1;
        while(true) {
            Object v0 = this.lock;
            __monitor_enter(v0);
            try {
                while(this.running) {
                    if(!this.queue.isEmpty()) {
                        break;
                    }

                    this.lock.wait();
                }

                if(this.running) {
                    goto label_14;
                }
            }
            catch(Throwable v5) {
                goto label_83;
            }

            __monitor_exit(v0);
            return;
            try {
            label_14:
                v1 = this.queue.removeFirst();
                __monitor_exit(v0);
                v0 = null;
            }
            catch(Throwable v5) {
            label_83:
                __monitor_exit(v0);
                throw v5;
            }

            try {
                if(Intrinsics.areEqual(v1, Reconcile.INSTANCE)) {
                    this.reconcile();
                    continue;
                }

                if((v1 instanceof Motion)) {
                    if(this.current != v1.getSelection()) {
                        continue;
                    }

                    if(!this.valid(v1.getSelection())) {
                        continue;
                    }

                    FreeLookGesture v2_1 = this.gesture;
                    if(v2_1 == null) {
                        continue;
                    }

                    if(v2_1.move(((float)v1.getDx()), ((float)v1.getDy()))) {
                        continue;
                    }

                    this.fail("MOVE Vista libre rechazado");
                    continue;
                }

                if((v1 instanceof Fence)) {
                    CompletableFuture v2_2 = v1.getCompletion();
                    boolean v3 = this.owner == null || this.phase == Phase.ACTIVE ? true : false;
                    v2_2.complete(Boolean.valueOf(v3));
                    continue;
                }

                throw new NoWhenBranchMatchedException();
            }
            catch(Exception v2) {
                String v3_1 = v2.getMessage();
                if(v3_1 == null) {
                    v3_1 = v2.getClass().getSimpleName();
                }

                this.fail("Vista libre: " + v3_1);
                if(!(v1 instanceof Fence)) {
                    continue;
                }

                ((Fence)v1).getCompletion().complete(Boolean.valueOf(false));
                continue;
            }
        }
    }

    private final void select(VistaLibreMarker arg9) {
        Selection v0;
        if(arg9 != null) {
            long v2 = this.sessionId;
            long v4 = this.generation + 1;
            this.generation = v4;
            v0 = new Selection(arg9, v2, v4);
        }
        else {
            v0 = null;
        }

        this.selected = v0;
        this.consuming = true;
        this.phase = Phase.TRANSFERRING;
        CollectionsKt.removeAll(this.queue, new FreeLookController$$ExternalSyntheticLambda0());
        if(!this.queue.contains(Reconcile.INSTANCE)) {
            this.queue.addLast(Reconcile.INSTANCE);
        }

        this.lock.notifyAll();
    }

    static final boolean select$lambda$20(Work arg0) {
        return arg0 instanceof Motion;
    }

    private final boolean valid(Selection arg3) {
        if(this.selected == arg3) {
            Function2 v2 = this.admitted;
            Long v0 = Long.valueOf(arg3.getSession());
            InputBinding v3 = arg3.getMarker().getActivationBinding();
            Intrinsics.checkNotNull(v3);
            if(v2.invoke(v0, v3).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }
}

