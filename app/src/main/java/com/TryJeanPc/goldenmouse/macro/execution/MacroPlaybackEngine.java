package com.TryJeanPc.goldenmouse.macro.execution;

import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerLease;
import com.TryJeanPc.goldenmouse.injector.TouchInjector$PointerOwner;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.macro.editor.MacroActionType;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditAction;
import com.TryJeanPc.goldenmouse.macro.editor.MacroPoint;
import com.TryJeanPc.goldenmouse.macro.editor.MacroRunMode;
import com.TryJeanPc.goldenmouse.mapper.MappedControlBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000E\b\u0007\u0018\u0000 S2\u00020\u0001:\u0004PQRSBI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0004\b\u000F\u0010\u0010J\u000E\u0010%\u001A\u00020\u000E2\u0006\u0010&\u001A\u00020\rJ\u000E\u0010\'\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u001EJ\u001C\u0010)\u001A\u00020\u000E2\u0006\u0010*\u001A\u00020\r2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020-0,J\u000E\u0010.\u001A\u00020\u001E2\u0006\u0010/\u001A\u00020\bJ\u0016\u00100\u001A\u00020\u000E2\u0006\u00101\u001A\u00020-2\u0006\u00102\u001A\u00020\u001EJ\f\u00103\u001A\b\u0012\u0004\u0012\u00020504J\u0006\u00106\u001A\u00020\u001EJ\u0006\u00107\u001A\u00020\u000EJ\u0010\u00108\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u0019H\u0002J\u0010\u0010:\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u0019H\u0002J\u0018\u0010;\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u00192\u0006\u0010<\u001A\u00020\rH\u0002J\u0010\u0010=\u001A\u00020\u000E2\u0006\u0010>\u001A\u00020\bH\u0002J\u0010\u0010?\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u0019H\u0002J\u0018\u0010@\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u00192\u0006\u0010A\u001A\u00020BH\u0002J\u0010\u0010C\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u0019H\u0002J \u0010D\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u00192\u0006\u0010A\u001A\u00020B2\u0006\u0010E\u001A\u00020FH\u0002J[\u0010G\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u00192\b\u0010A\u001A\u0004\u0018\u00010B2\u0006\u0010H\u001A\u00020\r2\u0006\u0010I\u001A\u00020\b2\b\u0010J\u001A\u0004\u0018\u00010\b2\u0006\u0010K\u001A\u00020\b2\u0006\u0010L\u001A\u00020\u001E2\u0006\u0010<\u001A\u00020\r2\b\b\u0002\u0010M\u001A\u00020\u001EH\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001A\u00020\u000EH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R*\u0010\u0017\u001A\u001E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\u0018j\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0019`\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\r0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006T"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine;", "", "injector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "scheduler", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroScheduler;", "now", "Lkotlin/Function0;", "", "timing", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingSink;", "onError", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroScheduler;Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingSink;Lkotlin/jvm/functions/Function1;)V", "definitions", "", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "profile", "session", "nextExecution", "runs", "Ljava/util/LinkedHashMap;", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Run;", "Lkotlin/collections/LinkedHashMap;", "pressed", "", "enabled", "", "admission", "Ljava/util/concurrent/atomic/AtomicLong;", "wake", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTask;", "wakeGeneration", "closed", "reportError", "message", "setGamingEnabled", "value", "applyProfile", "packageName", "bindings", "", "Lcom/TryJeanPc/goldenmouse/mapper/MappedControlBinding;", "beginSession", "id", "setPressed", "binding", "down", "activeExecutions", "", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "cancelAll", "close", "valid", "run", "cancel", "fail", "reason", "tick", "generation", "advance", "releaseContact", "contact", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Contact;", "drainExpiredTaps", "move", "progress", "", "trace", "event", "scheduled", "sent", "ack", "accepted", "summary", "(Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Run;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Contact;Ljava/lang/String;JLjava/lang/Long;JZLjava/lang/String;Z)V", "scheduleNext", "Identity", "Contact", "Run", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroPlaybackEngine {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Companion;", "", "<init>", "()V", "MOVE_STEP_MS", "", "MAX_TIMING_RECORDS", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\u0007\u0012\b\b\u0002\u0010\r\u001A\u00020\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0005HÆ\u0003J\t\u0010$\u001A\u00020\u0007HÆ\u0003J\t\u0010%\u001A\u00020\u0007HÆ\u0003J\t\u0010&\u001A\u00020\u0007HÆ\u0003J\t\u0010\'\u001A\u00020\u000BHÆ\u0003J\t\u0010(\u001A\u00020\u0007HÆ\u0003J\t\u0010)\u001A\u00020\u0007HÆ\u0003JY\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\u0007HÆ\u0001J\u0013\u0010+\u001A\u00020\u000B2\b\u0010,\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001A\u00020.HÖ\u0001J\t\u0010/\u001A\u000200HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\b\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001A\u0010\t\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0015\"\u0004\b\u001B\u0010\u0017R\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0011\u0010\f\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0015R\u0011\u0010\r\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0015¨\u00061"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Contact;", "", "action", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "lease", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "downAt", "", "endAt", "nextMoveAt", "downAccepted", "", "reserveStartMs", "reserveEndMs", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;JJJZJJ)V", "getAction", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "getLease", "()Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "getDownAt", "()J", "setDownAt", "(J)V", "getEndAt", "setEndAt", "getNextMoveAt", "setNextMoveAt", "getDownAccepted", "()Z", "setDownAccepted", "(Z)V", "getReserveStartMs", "getReserveEndMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Contact {
        private final MacroEditAction action;
        private boolean downAccepted;
        private long downAt;
        private long endAt;
        private final PointerLease lease;
        private long nextMoveAt;
        private final long reserveEndMs;
        private final long reserveStartMs;

        public Contact(MacroEditAction arg17, PointerLease arg18, long arg19, long arg21, long arg23, boolean arg25, long arg26, long arg28, int arg30, DefaultConstructorMarker arg31) {
            int v0 = arg30;
            boolean v11 = (v0 & 0x20) != 0 ? false : arg25;
            long v12 = (v0 & 0x40) != 0 ? arg19 : arg26;
            long v5 = arg19;
            long v14 = (v0 & 0x80) != 0 ? v5 : arg28;
            this(arg17, arg18, v5, arg21, arg23, v11, v12, v14);
        }

        public Contact(MacroEditAction arg2, PointerLease arg3, long arg4, long arg6, long arg8, boolean arg10, long arg11, long arg13) {
            Intrinsics.checkNotNullParameter(arg2, "action");
            Intrinsics.checkNotNullParameter(arg3, "lease");
            super();
            this.action = arg2;
            this.lease = arg3;
            this.downAt = arg4;
            this.endAt = arg6;
            this.nextMoveAt = arg8;
            this.downAccepted = arg10;
            this.reserveStartMs = arg11;
            this.reserveEndMs = arg13;
        }

        public final MacroEditAction component1() {
            return this.action;
        }

        public final PointerLease component2() {
            return this.lease;
        }

        public final long component3() {
            return this.downAt;
        }

        public final long component4() {
            return this.endAt;
        }

        public final long component5() {
            return this.nextMoveAt;
        }

        public final boolean component6() {
            return this.downAccepted;
        }

        public final long component7() {
            return this.reserveStartMs;
        }

        public final long component8() {
            return this.reserveEndMs;
        }

        public final Contact copy(MacroEditAction arg15, PointerLease arg16, long arg17, long arg19, long arg21, boolean arg23, long arg24, long arg26) {
            Intrinsics.checkNotNullParameter(arg15, "action");
            Intrinsics.checkNotNullParameter(arg16, "lease");
            return new Contact(arg15, arg16, arg17, arg19, arg21, arg23, arg24, arg26);
        }

        public static Contact copy$default(Contact arg14, MacroEditAction arg15, PointerLease arg16, long arg17, long arg19, long arg21, boolean arg23, long arg24, long arg26, int arg28, Object arg29) {
            int v0 = arg28;
            MacroEditAction v1 = (v0 & 1) != 0 ? arg14.action : arg15;
            PointerLease v2 = (v0 & 2) != 0 ? arg14.lease : arg16;
            long v3 = (v0 & 4) != 0 ? arg14.downAt : arg17;
            long v5 = (v0 & 8) != 0 ? arg14.endAt : arg19;
            long v7 = (v0 & 16) != 0 ? arg14.nextMoveAt : arg21;
            boolean v9 = (v0 & 0x20) != 0 ? arg14.downAccepted : arg23;
            long v10 = (v0 & 0x40) != 0 ? arg14.reserveStartMs : arg24;
            long v27 = (v0 & 0x80) != 0 ? arg14.reserveEndMs : arg26;
            return arg14.copy(v1, v2, v3, v5, v7, v9, v10, v27);
        }

        public boolean equals(Object arg8) {
            if(this == (((Contact)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Contact)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.action, ((Contact)arg8).action)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.lease, ((Contact)arg8).lease)) {
                return 0;
            }

            if(this.downAt != ((Contact)arg8).downAt) {
                return 0;
            }

            if(this.endAt != ((Contact)arg8).endAt) {
                return 0;
            }

            if(this.nextMoveAt != ((Contact)arg8).nextMoveAt) {
                return 0;
            }

            if(this.downAccepted != ((Contact)arg8).downAccepted) {
                return 0;
            }

            if(this.reserveStartMs != ((Contact)arg8).reserveStartMs) {
                return 0;
            }

            if(this.reserveEndMs != ((Contact)arg8).reserveEndMs) {
                return 0;
            }

            return 1;
        }

        public final MacroEditAction getAction() {
            return this.action;
        }

        public final boolean getDownAccepted() {
            return this.downAccepted;
        }

        public final long getDownAt() {
            return this.downAt;
        }

        public final long getEndAt() {
            return this.endAt;
        }

        public final PointerLease getLease() {
            return this.lease;
        }

        public final long getNextMoveAt() {
            return this.nextMoveAt;
        }

        public final long getReserveEndMs() {
            return this.reserveEndMs;
        }

        public final long getReserveStartMs() {
            return this.reserveStartMs;
        }

        public int hashCode() {
            return ((((((this.action.hashCode() * 0x1F + this.lease.hashCode()) * 0x1F + Long.hashCode(this.downAt)) * 0x1F + Long.hashCode(this.endAt)) * 0x1F + Long.hashCode(this.nextMoveAt)) * 0x1F + Boolean.hashCode(this.downAccepted)) * 0x1F + Long.hashCode(this.reserveStartMs)) * 0x1F + Long.hashCode(this.reserveEndMs);
        }

        public final void setDownAccepted(boolean arg1) {
            this.downAccepted = arg1;
        }

        public final void setDownAt(long arg1) {
            this.downAt = arg1;
        }

        public final void setEndAt(long arg1) {
            this.endAt = arg1;
        }

        public final void setNextMoveAt(long arg1) {
            this.nextMoveAt = arg1;
        }

        public String toString() {
            return "Contact(action=" + this.action + ", lease=" + this.lease + ", downAt=" + this.downAt + ", endAt=" + this.endAt + ", nextMoveAt=" + this.nextMoveAt + ", downAccepted=" + this.downAccepted + ", reserveStartMs=" + this.reserveStartMs + ", reserveEndMs=" + this.reserveEndMs + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0006HÆ\u0003J1\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000E¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "", "profile", "", "component", "session", "", "execution", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getProfile", "()Ljava/lang/String;", "getComponent", "getSession", "()J", "getExecution", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Identity {
        public static final int $stable;
        private final String component;
        private final long execution;
        private final String profile;
        private final long session;

        static {
        }

        public Identity(String arg2, String arg3, long arg4, long arg6) {
            Intrinsics.checkNotNullParameter(arg2, "profile");
            Intrinsics.checkNotNullParameter(arg3, "component");
            super();
            this.profile = arg2;
            this.component = arg3;
            this.session = arg4;
            this.execution = arg6;
        }

        public final String component1() {
            return this.profile;
        }

        public final String component2() {
            return this.component;
        }

        public final long component3() {
            return this.session;
        }

        public final long component4() {
            return this.execution;
        }

        public final Identity copy(String arg8, String arg9, long arg10, long arg12) {
            Intrinsics.checkNotNullParameter(arg8, "profile");
            Intrinsics.checkNotNullParameter(arg9, "component");
            return new Identity(arg8, arg9, arg10, arg12);
        }

        public static Identity copy$default(Identity arg0, String arg1, String arg2, long arg3, long arg5, int arg7, Object arg8) {
            if((arg7 & 1) != 0) {
                arg1 = arg0.profile;
            }

            if((arg7 & 2) != 0) {
                arg2 = arg0.component;
            }

            if((arg7 & 4) != 0) {
                arg3 = arg0.session;
            }

            if((arg7 & 8) != 0) {
                arg5 = arg0.execution;
            }

            return arg0.copy(arg1, arg2, arg3, arg5);
        }

        public boolean equals(Object arg8) {
            if(this == (((Identity)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Identity)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.profile, ((Identity)arg8).profile)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.component, ((Identity)arg8).component)) {
                return 0;
            }

            if(this.session != ((Identity)arg8).session) {
                return 0;
            }

            if(this.execution != ((Identity)arg8).execution) {
                return 0;
            }

            return 1;
        }

        public final String getComponent() {
            return this.component;
        }

        public final long getExecution() {
            return this.execution;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final long getSession() {
            return this.session;
        }

        public int hashCode() {
            return ((this.profile.hashCode() * 0x1F + this.component.hashCode()) * 0x1F + Long.hashCode(this.session)) * 0x1F + Long.hashCode(this.execution);
        }

        public String toString() {
            return "Identity(profile=" + this.profile + ", component=" + this.component + ", session=" + this.session + ", execution=" + this.execution + ")";
        }
    }

    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\b\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R-\u0010\u0017\u001A\u001E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u0018j\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0019`\u001A¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0010\"\u0004\b\u001F\u0010\u0013R\u001A\u0010 \u001A\u00020!X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R-\u0010&\u001A\u001E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\'0\u0018j\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\'`\u001A¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u001C¨\u0006)"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Run;", "", "identity", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "program", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "admission", "", "origin", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;JJ)V", "getIdentity", "()Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Identity;", "getProgram", "()Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "getAdmission", "()J", "getOrigin", "setOrigin", "(J)V", "capacityKey", "getCapacityKey", "()Ljava/lang/Object;", "pending", "Ljava/util/LinkedHashMap;", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "Lkotlin/collections/LinkedHashMap;", "getPending", "()Ljava/util/LinkedHashMap;", "completed", "getCompleted", "setCompleted", "timingRecords", "", "getTimingRecords", "()I", "setTimingRecords", "(I)V", "contacts", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine$Contact;", "getContacts", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Run {
        private final long admission;
        private final Object capacityKey;
        private long completed;
        private final LinkedHashMap contacts;
        private final Identity identity;
        private long origin;
        private final LinkedHashMap pending;
        private final MacroProgram program;
        private int timingRecords;

        public Run(Identity arg2, MacroProgram arg3, long arg4, long arg6) {
            Intrinsics.checkNotNullParameter(arg2, "identity");
            Intrinsics.checkNotNullParameter(arg3, "program");
            super();
            this.identity = arg2;
            this.program = arg3;
            this.admission = arg4;
            this.origin = arg6;
            this.capacityKey = new Object();
            List v2 = arg3.getContacts();
            LinkedHashMap v3 = new LinkedHashMap();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                Object v4 = v2_1.next();
                ((Map)v3).put(Long.valueOf(v4.getId()), v4);
            }

            this.pending = v3;
            this.contacts = new LinkedHashMap();
        }

        public final long getAdmission() {
            return this.admission;
        }

        public final Object getCapacityKey() {
            return this.capacityKey;
        }

        public final long getCompleted() {
            return this.completed;
        }

        public final LinkedHashMap getContacts() {
            return this.contacts;
        }

        public final Identity getIdentity() {
            return this.identity;
        }

        public final long getOrigin() {
            return this.origin;
        }

        public final LinkedHashMap getPending() {
            return this.pending;
        }

        public final MacroProgram getProgram() {
            return this.program;
        }

        public final int getTimingRecords() {
            return this.timingRecords;
        }

        public final void setCompleted(long arg1) {
            this.completed = arg1;
        }

        public final void setOrigin(long arg1) {
            this.origin = arg1;
        }

        public final void setTimingRecords(int arg1) {
            this.timingRecords = arg1;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[MacroRunMode.values().length];
            try {
                v0[MacroRunMode.ONCE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[MacroRunMode.LOOP.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[MacroRunMode.HOLD.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[MacroRunMode.PRESS_RELEASE.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int MAX_TIMING_RECORDS = 0x40;
    private static final long MOVE_STEP_MS = 16;
    private final AtomicLong admission;
    private boolean closed;
    private Map definitions;
    private volatile boolean enabled;
    private final TouchInjector injector;
    private long nextExecution;
    private final Function0 now;
    private final Function1 onError;
    private final Set pressed;
    private String profile;
    private final LinkedHashMap runs;
    private final MacroScheduler scheduler;
    private long session;
    private final MacroTimingSink timing;
    private MacroTask wake;
    private long wakeGeneration;

    static {
        MacroPlaybackEngine.Companion = new Companion(null);
        MacroPlaybackEngine.$stable = 8;
    }

    public MacroPlaybackEngine(TouchInjector arg7, MacroScheduler arg8, Function0 arg9, MacroTimingSink arg10, Function1 arg11, int arg12, DefaultConstructorMarker arg13) {
        MacroPlaybackEngine$$ExternalSyntheticLambda1 v11;
        MacroTimingDiagnostics v10;
        com.TryJeanPc.goldenmouse.macro.execution.MacroPlaybackEngine$1 v9;
        TimedMacroScheduler v8;
        if((arg12 & 2) != 0) {
            v8 = new TimedMacroScheduler();
        }

        MacroScheduler v2 = ((MacroScheduler)v8);
        if((arg12 & 4) != 0) {
            v9 = com.TryJeanPc.goldenmouse.macro.execution.MacroPlaybackEngine$1.INSTANCE;
        }

        Function0 v3 = ((Function0)v9);
        if((arg12 & 8) != 0) {
            v10 = MacroTimingDiagnostics.INSTANCE;
        }

        MacroTimingSink v4 = ((MacroTimingSink)v10);
        if((arg12 & 16) != 0) {
            v11 = new MacroPlaybackEngine$$ExternalSyntheticLambda1();
        }

        this(arg7, v2, v3, v4, ((Function1)v11));
    }

    public MacroPlaybackEngine(TouchInjector arg2, MacroScheduler arg3, Function0 arg4, MacroTimingSink arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "injector");
        Intrinsics.checkNotNullParameter(arg3, "scheduler");
        Intrinsics.checkNotNullParameter(arg4, "now");
        Intrinsics.checkNotNullParameter(arg5, "timing");
        Intrinsics.checkNotNullParameter(arg6, "onError");
        super();
        this.injector = arg2;
        this.scheduler = arg3;
        this.now = arg4;
        this.timing = arg5;
        this.onError = arg6;
        this.definitions = MapsKt.emptyMap();
        this.profile = "";
        this.runs = new LinkedHashMap();
        this.pressed = new LinkedHashSet();
        this.enabled = true;
        this.admission = new AtomicLong();
    }

    static final Unit _init_$lambda$0(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public final Set activeExecutions() {
        __monitor_enter(this);
        try {
            Collection v0_1 = this.runs.values();
            Intrinsics.checkNotNullExpressionValue(v0_1, "<get-values>(...)");
            LinkedHashSet v1 = new LinkedHashSet();
            Iterator v0_2 = ((Iterable)v0_1).iterator();
            while(v0_2.hasNext()) {
                ((Collection)v1).add(v0_2.next().getIdentity());
            }

            __monitor_exit(this);
            return ((Set)v1);
        }
        catch(Throwable v0) {
            try {
            label_17:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_17;
            }

            throw v0;
        }
    }

    private final void advance(Run arg38) {
        boolean v3_2;
        Object v20;
        Object v2_2;
        long v4;
        long v16;
        String v15;
        MacroPlaybackEngine v0 = this;
        Run v1 = arg38;
        Collection v2 = v1.getContacts().values();
        String v14 = "<get-values>(...)";
        Intrinsics.checkNotNullExpressionValue(v2, v14);
        Iterator v2_1 = CollectionsKt.toList(((Iterable)v2)).iterator();
        while(true) {
            v15 = "next(...)";
            v16 = 16;
            if(v2_1.hasNext()) {
                Object v3 = v2_1.next();
                Intrinsics.checkNotNullExpressionValue(v3, v15);
                if(!this.valid(arg38)) {
                    this.cancel(arg38);
                    return;
                }
                else {
                    v4 = v0.now.invoke().longValue();
                    float v7 = 1f;
                    if(Long.compare(v4, ((Contact)v3).getEndAt()) >= 0) {
                        if(((Contact)v3).getAction().getType() == MacroActionType.SWIPE && !v0.move(v1, ((Contact)v3), v7)) {
                            return;
                        }

                        if(!this.valid(arg38)) {
                            this.cancel(arg38);
                            return;
                        }

                        if(v0.releaseContact(v1, ((Contact)v3))) {
                            continue;
                        }
                    }
                    else {
                        if(((Contact)v3).getAction().getType() != MacroActionType.SWIPE) {
                            continue;
                        }

                        if(v4 < ((Contact)v3).getNextMoveAt()) {
                            continue;
                        }

                        if(!v0.move(v1, ((Contact)v3), RangesKt.coerceIn(((float)((((double)(v4 - ((Contact)v3).getDownAt()))) / (((double)((Contact)v3).getAction().getDurationMs())))), 0f, v7))) {
                            return;
                        }

                        ((Contact)v3).setNextMoveAt(v0.now.invoke().longValue() + v16);
                        continue;
                    }
                }
            }
            else {
                break;
            }

            return;
        }

        Iterator v18 = v1.getPending().values().iterator();
        while(true) {
        label_67:
            if(v18.hasNext()) {
                v2_2 = v18.next();
                Intrinsics.checkNotNullExpressionValue(v2_2, v15);
                v20 = v2_2;
                if(!this.valid(arg38)) {
                    this.cancel(arg38);
                    return;
                }
                else if(!this.drainExpiredTaps(arg38)) {
                    return;
                }
                else if(!this.valid(arg38)) {
                    this.cancel(arg38);
                    return;
                }
                else if(v0.now.invoke().longValue() >= v1.getOrigin() + ((MacroEditAction)v20).getStartMs()) {
                    v2 = v1.getContacts().values();
                    Intrinsics.checkNotNullExpressionValue(v2, v14);
                    if(v2.isEmpty()) {
                    }
                    else {
                        v2_1 = ((Iterable)v2).iterator();
                        do {
                            if(v2_1.hasNext()) {
                                if(!Intrinsics.areEqual(v2_1.next().getAction().getTrack(), ((MacroEditAction)v20).getTrack())) {
                                    continue;
                                }

                                break;
                            }

                            goto label_108;
                        }
                        while(true);

                        continue;
                    }

                    break;
                }
            }

            goto label_248;
        }

    label_108:
        v4 = v1.getOrigin() + ((MacroEditAction)v20).getEndMs();
        if(((MacroEditAction)v20).getType() == MacroActionType.TAP && v0.now.invoke().longValue() >= v4) {
            MacroPlaybackEngine.trace$default(v0, v1, null, "MISSED_TAP", v1.getOrigin() + ((MacroEditAction)v20).getStartMs(), null, v0.now.invoke().longValue(), false, "action=" + ((MacroEditAction)v20).getId() + " endMs=" + v4, false, 0x100, null);
            v0.fail(v1, "Toque " + ((MacroEditAction)v20).getId() + ": ventana temporal vencida; secuencia detenida");
            return;
        }

        PointerOwner v6 = new PointerOwner(v1.getIdentity().getComponent(), ((MacroEditAction)v20).getId(), v1.getIdentity().getSession(), v1.getCapacityKey());
        long v29 = v0.now.invoke().longValue();
        PointerLease v21 = v0.injector.reserveMacroPointer(v6);
        long v31 = v0.now.invoke().longValue();
        if(v21 == null) {
            v0.fail(v1, "sin contactos disponibles (reservas o límite simultáneo)");
            return;
        }

        v2_2 = CollectionsKt.first(((MacroEditAction)v20).getPoints());
        long v22 = v0.now.invoke().longValue();
        if(((MacroEditAction)v20).getType() == MacroActionType.TAP) {
        }
        else {
            v4 = v22 + ((MacroEditAction)v20).getDurationMs();
        }

        Contact v19 = new Contact(((MacroEditAction)v20), v21, v22, v4, v22 + v16, false, v29, v31, 0x20, null);
        Object v5 = v2_2;
        Contact v2_3 = v19;
        PointerLease v4_1 = v21;
        v1.getContacts().put(Long.valueOf(((MacroEditAction)v20).getId()), v2_3);
        if(!this.valid(arg38)) {
            this.cancel(arg38);
            return;
        }

        long v6_1 = v0.now.invoke().longValue();
        boolean v9 = v0.injector.macroDown(v4_1, ((MacroPoint)v5).getX(), ((MacroPoint)v5).getY());
        v4 = v0.now.invoke().longValue();
        long v10 = v1.getOrigin() + ((MacroEditAction)v20).getStartMs();
        Long v6_2 = Long.valueOf(v6_1);
        long v7_1 = v4;
        String v21_1 = v14;
        MacroPlaybackEngine.trace$default(v0, v1, v2_3, "DOWN", v10, v6_2, v7_1, v9, "reserved", false, 0x100, null);
        if(!v9) {
            v0.fail(v1, "DOWN no confirmado");
            return;
        }

        v2_3.setDownAccepted(true);
        if(((MacroEditAction)v20).getType() != MacroActionType.TAP) {
            v2_3.setDownAt(v7_1);
            v2_3.setEndAt(v2_3.getDownAt() + ((MacroEditAction)v20).getDurationMs());
            v2_3.setNextMoveAt(v2_3.getDownAt() + v16);
        }

        v18.remove();
        v14 = v21_1;
        goto label_67;
    label_248:
        if(!this.valid(arg38)) {
            this.cancel(arg38);
            return;
        }

        if(this.drainExpiredTaps(arg38)) {
            if(!this.valid(arg38)) {
                this.cancel(arg38);
                return;
            }

            if(!v1.getPending().isEmpty()) {
                return;
            }

            if(!v1.getContacts().isEmpty()) {
                return;
            }

            if(v0.now.invoke().longValue() < v1.getOrigin() + v1.getProgram().getDurationMs()) {
                return;
            }

            v1.setCompleted(v1.getCompleted() + 1);
            MacroDraft v2_4 = v1.getProgram().getDraft();
            int v3_1 = WhenMappings.$EnumSwitchMapping$0[v2_4.getMode().ordinal()];
            if(v3_1 != 1) {
                if(v3_1 != 2) {
                    if(v3_1 == 3) {
                        v3_2 = v0.pressed.contains(v1.getIdentity().getComponent());
                        goto label_310;
                    }
                    else if(v3_1 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                else if(v2_4.getRepetitions() != 0) {
                    if(v1.getCompleted() < (((long)v2_4.getRepetitions()))) {
                    }
                    else {
                        goto label_309;
                    }
                }

                v3_2 = true;
            }
            else {
            label_309:
                v3_2 = false;
            }

        label_310:
            if(v3_2) {
                Iterator v3_3 = v1.getProgram().getContacts().iterator();
                while(v3_3.hasNext()) {
                    Object v4_2 = v3_3.next();
                    v1.getPending().put(Long.valueOf(((MacroEditAction)v4_2).getId()), v4_2);
                }

                long v3_4 = v0.now.invoke().longValue();
                long v5_1 = v2_4.getMode() == MacroRunMode.LOOP ? v2_4.getIntervalMs() : 0;
                v1.setOrigin(v3_4 + v5_1);
                return;
            }

            v0.trace(v1, null, "FINISH", v1.getProgram().getDurationMs() + v1.getOrigin(), null, v0.now.invoke().longValue(), true, "completed", true);
            v0.runs.remove(arg38.getIdentity().getComponent());
            v0.injector.releaseCapacity(arg38.getCapacityKey());
        }
    }

    public final void applyProfile(String arg3, List arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "packageName");
            Intrinsics.checkNotNullParameter(arg4, "bindings");
            this.cancelAll();
            this.profile = arg3;
            ArrayList v3_1 = new ArrayList();
            Iterator v4 = ((Iterable)arg4).iterator();
            while(v4.hasNext()) {
                Object v0 = v4.next();
                MacroProgram v1 = ((MappedControlBinding)v0).getMacro();
                Pair v0_1 = v1 != null ? TuplesKt.to(((MappedControlBinding)v0).getControlId(), v1) : null;
                if(v0_1 == null) {
                    continue;
                }

                ((Collection)v3_1).add(v0_1);
            }

            this.definitions = MapsKt.toMap(((Iterable)v3_1));
        }
        catch(Throwable v3) {
            goto label_27;
        }

        __monitor_exit(this);
        return;
        try {
        label_27:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_27;
        }

        throw v3;
    }

    public final boolean beginSession(long arg2) {
        boolean v0;
        __monitor_enter(this);
        try {
            v0 = this.cancelAll();
            this.session = arg2;
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v0;
    }

    private final boolean cancel(Run arg22) {
        boolean v9;
        boolean v16;
        MacroPlaybackEngine v0 = this;
        v0.runs.remove(arg22.getIdentity().getComponent());
        Collection v1 = arg22.getContacts().values();
        Intrinsics.checkNotNullExpressionValue(v1, "<get-values>(...)");
        Iterator v14 = CollectionsKt.toList(((Iterable)v1)).iterator();
        while(true) {
        label_12:
            v16 = true;
            while(true) {
            label_13:
                if(!v14.hasNext()) {
                    goto label_70;
                }

                Object v2 = v14.next();
                int v1_1 = !((Contact)v2).getDownAccepted() || !v0.injector.ownsPointer(((Contact)v2).getLease()) || (v0.injector.uncertainMappedPointerIds().contains(Integer.valueOf(((Contact)v2).getLease().getPointerId()))) ? 0 : 1;
                long v3 = v0.now.invoke().longValue();
                v9 = v0.injector.releaseOwner(((Contact)v2).getLease().getOwner());
                String v5 = v1_1 != 0 ? "UP" : "RELEASE";
                long v6 = ((Contact)v2).getEndAt();
                Long v1_2 = v1_1 != 0 ? Long.valueOf(v3) : null;
                MacroPlaybackEngine.trace$default(v0, arg22, ((Contact)v2), v5, v6, v1_2, v0.now.invoke().longValue(), v9, "cancel", false, 0x100, null);
                if((v9) && (v16)) {
                    goto label_12;
                }

                break;
            }
        }

        v16 = false;
        goto label_13;
    label_70:
        arg22.getContacts().clear();
        v0.injector.releaseCapacity(arg22.getCapacityKey());
        v9 = v16;
        v0.trace(arg22, null, "CANCEL", arg22.getOrigin() + arg22.getProgram().getDurationMs(), null, v0.now.invoke().longValue(), v9, "cleanup", true);
        if(!v9) {
            v0.onError.invoke(arg22.getProgram().getDraft().getName() + ": contacto incierto; requiere CANCEL de sesión confirmado");
        }

        return v9;
    }

    public final boolean cancelAll() {
        boolean v2;
        __monitor_enter(this);
        try {
            this.admission.incrementAndGet();
            MacroTask v0_1 = this.wake;
            if(v0_1 != null) {
                v0_1.cancel();
            }

            this.wake = null;
            ++this.wakeGeneration;
            this.pressed.clear();
            Collection v0_2 = this.runs.values();
            Intrinsics.checkNotNullExpressionValue(v0_2, "<get-values>(...)");
            Iterator v0_3 = CollectionsKt.toList(((Iterable)v0_2)).iterator();
            while(true) {
            label_21:
                v2 = true;
                while(true) {
                label_22:
                    if(!v0_3.hasNext()) {
                        goto label_32;
                    }

                    Object v3 = v0_3.next();
                    Intrinsics.checkNotNull(v3);
                    if(this.cancel(((Run)v3))) {
                        break;
                    }

                    goto label_30;
                }
            }
        }
        catch(Throwable v0) {
            goto label_35;
        }

        if(v2) {
            goto label_21;
        }

    label_30:
        v2 = false;
        goto label_22;
    label_32:
        __monitor_exit(this);
        return v2;
        try {
        label_35:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_35;
        }

        throw v0;
    }

    public final void close() {
        __monitor_enter(this);
        try {
            this.setGamingEnabled(false);
            this.cancelAll();
            this.definitions = MapsKt.emptyMap();
            this.closed = true;
            this.scheduler.close();
        }
        catch(Throwable v0) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_13;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    private final boolean drainExpiredTaps(Run arg7) {
        Collection v0 = arg7.getContacts().values();
        Intrinsics.checkNotNullExpressionValue(v0, "<get-values>(...)");
        Iterator v0_1 = CollectionsKt.toList(((Iterable)v0)).iterator();
        do {
        label_6:
            if(!v0_1.hasNext()) {
                return 1;
            }

            Object v1 = v0_1.next();
            Intrinsics.checkNotNullExpressionValue(v1, "next(...)");
            if(((Contact)v1).getAction().getType() != MacroActionType.TAP) {
                goto label_6;
            }

            if(this.now.invoke().longValue() < ((Contact)v1).getEndAt()) {
                goto label_6;
            }
        }
        while(this.releaseContact(arg7, ((Contact)v1)));

        return 0;
    }

    private final void fail(Run arg4, String arg5) {
        this.onError.invoke(arg4.getProgram().getDraft().getName() + ": " + arg5);
        this.cancel(arg4);
    }

    private final boolean move(Run arg9, Contact arg10, float arg11) {
        if(!this.valid(arg9)) {
            this.cancel(arg9);
            return 0;
        }

        Object v0 = arg10.getAction().getPoints().get(0);
        Object v2 = arg10.getAction().getPoints().get(1);
        if(!this.injector.macroMove(arg10.getLease(), ((MacroPoint)v0).getX() + (((MacroPoint)v2).getX() - ((MacroPoint)v0).getX()) * arg11, ((MacroPoint)v0).getY() + (((MacroPoint)v2).getY() - ((MacroPoint)v0).getY()) * arg11)) {
            this.fail(arg9, "MOVE no confirmado");
            return 0;
        }

        return 1;
    }

    private final boolean releaseContact(Run arg16, Contact arg17) {
        if(!this.valid(arg16)) {
            this.cancel(arg16);
            return 0;
        }

        long v1 = this.now.invoke().longValue();
        boolean v9 = this.injector.pointerUp(arg17.getLease());
        MacroPlaybackEngine.trace$default(this, arg16, arg17, "UP", arg17.getEndAt(), Long.valueOf(v1), this.now.invoke().longValue(), v9, "deadline", false, 0x100, null);
        if(!v9) {
            this.fail(arg16, "UP no confirmado");
            return 0;
        }

        arg16.getContacts().remove(Long.valueOf(arg17.getAction().getId()));
        return 1;
    }

    public final void reportError(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        this.onError.invoke(arg2);
    }

    private final void scheduleNext() {
        long v24;
        Long v5_2;
        long v5_1;
        Object v5;
        Object v4_2;
        Long v4_1;
        Iterator v1_3;
        Collection v1_2;
        Object v21;
        Object v16;
        Iterator v15_1;
        Collection v15;
        long v11;
        Object v1_1;
        long v13;
        Iterator v9;
        long v22;
        MacroPlaybackEngine v0 = this;
        MacroTask v1 = v0.wake;
        if(v1 != null) {
            v1.cancel();
        }

        v0.wake = null;
        long v2 = v0.wakeGeneration + 1;
        v0.wakeGeneration = v2;
        if(!v0.closed) {
            if(v0.runs.isEmpty()) {
            }
            else {
                long v4 = v0.now.invoke().longValue();
                Collection v6 = v0.runs.values();
                String v7 = "<get-values>(...)";
                Intrinsics.checkNotNullExpressionValue(v6, v7);
                Iterator v6_1 = ((Iterable)v6).iterator();
                if(v6_1.hasNext()) {
                    Object v8 = v6_1.next();
                    Intrinsics.checkNotNull(v8);
                    String v10 = "next(...)";
                    if(!v0.valid(((Run)v8))) {
                        v22 = v4;
                        v9 = v6_1;
                    }
                    else {
                        v9 = ((Run)v8).getPending().values().iterator();
                        v13 = 0x7FFFFFFFFFFFFFFFL;
                        while(v9.hasNext()) {
                            v1_1 = v9.next();
                            Intrinsics.checkNotNullExpressionValue(v1_1, v10);
                            v11 = ((Run)v8).getOrigin() + ((MacroEditAction)v1_1).getStartMs();
                            if(v11 >= v13) {
                                break;
                            }

                            v15 = ((Run)v8).getContacts().values();
                            Intrinsics.checkNotNullExpressionValue(v15, v7);
                            v15_1 = ((Iterable)v15).iterator();
                            while(true) {
                                if(v15_1.hasNext()) {
                                    v16 = v15_1.next();
                                    v21 = v1_1;
                                    v22 = v4;
                                    if(Intrinsics.areEqual(v16.getAction().getTrack(), ((MacroEditAction)v21).getTrack())) {
                                    }
                                    else {
                                        v1_1 = v21;
                                        v4 = v22;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_67;
                            }

                            v22 = v4;
                            v16 = null;
                        label_67:
                            v4 = v16 != null ? ((Contact)v16).getEndAt() : 0;
                            v13 = Math.min(v13, Math.max(v11, v4));
                            v4 = v22;
                        }

                        v22 = v4;
                        v1_2 = ((Run)v8).getContacts().values();
                        Intrinsics.checkNotNullExpressionValue(v1_2, v7);
                        v1_3 = ((Iterable)v1_2).iterator();
                        if(!v1_3.hasNext()) {
                            v4_1 = null;
                        }
                        else {
                            v4_2 = v1_3.next();
                            v4 = ((Contact)v4_2).getAction().getType() == MacroActionType.SWIPE ? Math.min(((Contact)v4_2).getEndAt(), ((Contact)v4_2).getNextMoveAt()) : ((Contact)v4_2).getEndAt();
                            v4_1 = Long.valueOf(v4);
                            while(v1_3.hasNext()) {
                                v5 = v1_3.next();
                                if(((Contact)v5).getAction().getType() == MacroActionType.SWIPE) {
                                    v9 = v6_1;
                                    v5_1 = Math.min(((Contact)v5).getEndAt(), ((Contact)v5).getNextMoveAt());
                                }
                                else {
                                    v9 = v6_1;
                                    v5_1 = ((Contact)v5).getEndAt();
                                }

                                v5_2 = Long.valueOf(v5_1);
                                if(((Comparable)v4_1).compareTo(v5_2) > 0) {
                                    v4_1 = v5_2;
                                }

                                v6_1 = v9;
                            }
                        }

                        v9 = v6_1;
                        v4 = v4_1 != null ? v4_1.longValue() : 0x7FFFFFFFFFFFFFFFL;
                        v11 = !((Run)v8).getPending().isEmpty() || !((Run)v8).getContacts().isEmpty() ? 0x7FFFFFFFFFFFFFFFL : ((Run)v8).getOrigin() + ((Run)v8).getProgram().getDurationMs();
                        v4 = Math.min(v13, Math.min(v4, v11));
                    }

                    while(v9.hasNext()) {
                        v1_1 = v9.next();
                        Intrinsics.checkNotNull(v1_1);
                        if(!v0.valid(((Run)v1_1))) {
                            v24 = v4;
                            v4 = v22;
                        }
                        else {
                            v6_1 = ((Run)v1_1).getPending().values().iterator();
                            v11 = 0x7FFFFFFFFFFFFFFFL;
                            while(v6_1.hasNext()) {
                                v8 = v6_1.next();
                                Intrinsics.checkNotNullExpressionValue(v8, v10);
                                v13 = ((Run)v1_1).getOrigin() + ((MacroEditAction)v8).getStartMs();
                                if(v13 >= v11) {
                                    break;
                                }

                                v15 = ((Run)v1_1).getContacts().values();
                                Intrinsics.checkNotNullExpressionValue(v15, v7);
                                v15_1 = ((Iterable)v15).iterator();
                                while(true) {
                                    if(v15_1.hasNext()) {
                                        v16 = v15_1.next();
                                        v21 = v1_1;
                                        v24 = v4;
                                        if(Intrinsics.areEqual(v16.getAction().getTrack(), ((MacroEditAction)v8).getTrack())) {
                                        }
                                        else {
                                            v1_1 = v21;
                                            v4 = v24;
                                            continue;
                                        }
                                    }
                                    else {
                                        break;
                                    }

                                    goto label_178;
                                }

                                v21 = v1_1;
                                v24 = v4;
                                v16 = null;
                            label_178:
                                v4 = v16 != null ? ((Contact)v16).getEndAt() : 0;
                                v11 = Math.min(v11, Math.max(v13, v4));
                                v1_1 = v21;
                                v4 = v24;
                            }

                            v21 = v1_1;
                            v24 = v4;
                            v1_2 = ((Run)v21).getContacts().values();
                            Intrinsics.checkNotNullExpressionValue(v1_2, v7);
                            v1_3 = ((Iterable)v1_2).iterator();
                            if(!v1_3.hasNext()) {
                                v4_1 = null;
                            }
                            else {
                                v4_2 = v1_3.next();
                                v4 = ((Contact)v4_2).getAction().getType() == MacroActionType.SWIPE ? Math.min(((Contact)v4_2).getEndAt(), ((Contact)v4_2).getNextMoveAt()) : ((Contact)v4_2).getEndAt();
                                for(v4_1 = Long.valueOf(v4); v1_3.hasNext(); v4_1 = v5_2) {
                                    v5 = v1_3.next();
                                    v5_1 = ((Contact)v5).getAction().getType() == MacroActionType.SWIPE ? Math.min(((Contact)v5).getEndAt(), ((Contact)v5).getNextMoveAt()) : ((Contact)v5).getEndAt();
                                    v5_2 = Long.valueOf(v5_1);
                                    if(((Comparable)v4_1).compareTo(v5_2) <= 0) {
                                        continue;
                                    }
                                }
                            }

                            v4 = v4_1 != null ? v4_1.longValue() : 0x7FFFFFFFFFFFFFFFL;
                            v13 = !((Run)v21).getPending().isEmpty() || !((Run)v21).getContacts().isEmpty() ? 0x7FFFFFFFFFFFFFFFL : ((Run)v21).getOrigin() + ((Run)v21).getProgram().getDurationMs();
                            v4 = Math.min(v11, Math.min(v4, v13));
                        }

                        if(v24 > v4) {
                            continue;
                        }

                        v4 = v24;
                    }

                    v0.wake = v0.scheduler.schedule(RangesKt.coerceAtLeast(v4 - v22, 0), new MacroPlaybackEngine$$ExternalSyntheticLambda0(v0, v2));
                    return;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
        }
    }

    static final Unit scheduleNext$lambda$12(MacroPlaybackEngine arg0, long arg1) {
        arg0.tick(arg1);
        return Unit.INSTANCE;
    }

    public final void setGamingEnabled(boolean arg2) {
        if(!arg2) {
            this.admission.incrementAndGet();
        }

        this.enabled = arg2;
    }

    public final void setPressed(MappedControlBinding arg18, boolean arg19) {
        Run v2_1;
        Object v9_1;
        Object v2;
        String v6;
        MappedControlBinding v3;
        MacroPlaybackEngine v1 = this;
        String v0 = "input=";
        __monitor_enter(this);
        try {
            v3 = arg18;
            Intrinsics.checkNotNullParameter(v3, "binding");
            if(!v1.closed) {
                goto label_10;
            }
        }
        catch(Throwable v0_1) {
            goto label_126;
        }

        __monitor_exit(this);
        return;
        try {
        label_10:
            v6 = v3.getControlId();
            v2 = v1.definitions.get(v6);
            if(v2 != null) {
                goto label_16;
            }
        }
        catch(Throwable v0_1) {
            goto label_126;
        }

        __monitor_exit(this);
        return;
        try {
        label_16:
            if(v3.getMacro() == v2) {
                goto label_20;
            }
        }
        catch(Throwable v0_1) {
            goto label_126;
        }

        __monitor_exit(this);
        return;
    label_20:
        if(arg19) {
            try {
                if(v1.enabled) {
                    if(!v1.pressed.add(v6)) {
                    }
                    else {
                        Object v4 = v1.runs.get(v6);
                        if(v4 != null) {
                            if(((MacroProgram)v2).getDraft().getMode() != MacroRunMode.PRESS_RELEASE) {
                                if(((MacroProgram)v2).getDraft().getMode() != MacroRunMode.LOOP) {
                                }
                                else if(((MacroProgram)v2).getDraft().getRepetitions() == 0) {
                                    goto label_41;
                                }

                                goto label_122;
                            }

                        label_41:
                            v1.cancel(((Run)v4));
                            goto label_122;
                        }
                        else {
                            String v5 = v1.profile;
                            long v7 = v1.session;
                            long v9 = v1.nextExecution + 1;
                            v1.nextExecution = v9;
                            Identity v4_1 = new Identity(v5, v6, v7, v9);
                            v9_1 = v2;
                            v2_1 = new Run(v4_1, ((MacroProgram)v9_1), v1.admission.get(), v1.now.invoke().longValue());
                            if(v1.injector.reserveCapacity(v2_1.getCapacityKey(), ((MacroProgram)v9_1).getContactQuota())) {
                                goto label_86;
                            }

                            v1.onError.invoke(((MacroProgram)v9_1).getDraft().getName() + ": sin contactos disponibles para la ejecución (necesita " + ((MacroProgram)v9_1).getContactQuota() + ")");
                            goto label_84;
                        }
                    }
                }

                goto label_106;
            }
            catch(Throwable v0_1) {
                goto label_126;
            }

        label_84:
            __monitor_exit(this);
            return;
            try {
            label_86:
                v1.runs.put(v6, v2_1);
                MacroPlaybackEngine.trace$default(v1, v2_1, null, "TRIGGER_DOWN", v2_1.getOrigin(), Long.valueOf(v2_1.getOrigin()), v2_1.getOrigin(), true, v0 + v3.getInput().getNormalizedCode(), false, 0x100, null);
                goto label_122;
            }
            catch(Throwable v0_1) {
                goto label_126;
            }

        label_106:
            __monitor_exit(this);
            return;
        }
        else {
            v9_1 = v2;
            try {
                if(v1.pressed.remove(v6)) {
                    goto label_114;
                }
            }
            catch(Throwable v0_1) {
                goto label_126;
            }

            __monitor_exit(this);
            return;
            try {
            label_114:
                if(((MacroProgram)v9_1).getDraft().getMode() == MacroRunMode.HOLD) {
                    Object v0_2 = v1.runs.get(v6);
                    if(v0_2 == null) {
                        goto label_122;
                    }

                    v1.cancel(((Run)v0_2));
                }

            label_122:
                v1.scheduleNext();
                goto label_123;
            }
            catch(Throwable v0_1) {
                try {
                label_126:
                    __monitor_exit(this);
                }
                catch(Throwable v0_1) {
                    goto label_126;
                }

                throw v0_1;
            }
        }

        goto label_122;
    label_123:
        __monitor_exit(this);
    }

    private final void tick(long arg3) {
        __monitor_enter(this);
        try {
            if(arg3 == this.wakeGeneration) {
                if(this.closed) {
                }
                else {
                    this.wake = null;
                    Collection v3_1 = this.runs.values();
                    Intrinsics.checkNotNullExpressionValue(v3_1, "<get-values>(...)");
                    Iterator v3_2 = CollectionsKt.toList(((Iterable)v3_1)).iterator();
                    while(v3_2.hasNext()) {
                        Object v4 = v3_2.next();
                        Intrinsics.checkNotNullExpressionValue(v4, "next(...)");
                        if(!this.valid(((Run)v4))) {
                            this.cancel(((Run)v4));
                        }
                        else {
                            this.advance(((Run)v4));
                        }
                    }

                    this.scheduleNext();
                    goto label_26;
                }
            }

            goto label_28;
        }
        catch(Throwable v3) {
            goto label_31;
        }

    label_26:
        __monitor_exit(this);
        return;
        try {
        label_31:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_31;
        }

        throw v3;
    label_28:
        __monitor_exit(this);
    }

    private final void trace(Run arg23, Contact arg24, String arg25, long arg26, Long arg28, long arg29, boolean arg31, String arg32, boolean arg33) {
        Long v9;
        String v4;
        MacroPlaybackEngine v0 = this;
        if((v0.timing.enabled()) && ((arg33) || arg23.getTimingRecords() < 0x40)) {
            Run v2 = arg23;
            v2.setTimingRecords(arg23.getTimingRecords() + 1);
            Long v1 = null;
            PointerLease v3 = arg24 != null ? arg24.getLease() : ((PointerLease)v1);
            if(v3 == null) {
                v4 = "NONE";
            }
            else if(v0.injector.uncertainMappedPointerIds().contains(Integer.valueOf(v3.getPointerId()))) {
                v4 = "UNCERTAIN";
            }
            else if(v0.injector.ownsPointer(v3)) {
                v4 = "OWNED";
            }
            else {
                v4 = "RELEASED";
            }

            String v17 = v4;
            MacroTimingSink v0_1 = v0.timing;
            Identity v6 = v2.getIdentity();
            String v10 = arg25;
            boolean v4_1 = Intrinsics.areEqual(v10, "FINISH");
            long v7 = v2.getCompleted();
            if(v4_1) {
            }
            else {
                ++v7;
            }

            if(arg24 != null) {
                MacroEditAction v2_1 = arg24.getAction();
                if(v2_1 != null) {
                    v9 = Long.valueOf(v2_1.getId());
                }
                else {
                    goto label_55;
                }
            }
            else {
            label_55:
                v9 = v1;
            }

            Integer v16 = v3 != null ? Integer.valueOf(v3.getPointerId()) : ((Integer)v1);
            Long v20 = arg24 != null ? Long.valueOf(arg24.getReserveStartMs()) : v1;
            if(arg24 != null) {
                v1 = Long.valueOf(arg24.getReserveEndMs());
            }

            v0_1.record(new MacroTimingRecord(v6, v7, v9, v10, arg26, arg28, arg29, v16, v17, arg31, arg32, v20, v1));
        }
    }

    static void trace$default(MacroPlaybackEngine arg13, Run arg14, Contact arg15, String arg16, long arg17, Long arg19, long arg20, boolean arg22, String arg23, boolean arg24, int arg25, Object arg26) {
        boolean v12 = (arg25 & 0x100) != 0 ? false : arg24;
        arg13.trace(arg14, arg15, arg16, arg17, arg19, arg20, arg22, arg23, v12);
    }

    private final boolean valid(Run arg5) {
        if((this.enabled) && !this.closed && arg5.getAdmission() == this.admission.get() && this.runs.get(arg5.getIdentity().getComponent()) == arg5 && arg5.getIdentity().getSession() == this.session && (Intrinsics.areEqual(arg5.getIdentity().getProfile(), this.profile))) {
            return 1;
        }

        return 0;
    }
}

