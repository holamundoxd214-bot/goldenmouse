package com.TryJeanPc.goldenmouse.aim;

import android.util.Log;
import com.TryJeanPc.goldenmouse.injector.GgPerformanceDiagnostics;
import com.TryJeanPc.goldenmouse.injector.InjectionDiagnostics;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001IB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010,\u001A\u00020\'2\u0006\u0010\u0006\u001A\u00020\u0007J\u0016\u0010\u0010\u001A\u00020\'2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020.J\u0016\u0010\u0014\u001A\u00020\'2\u0006\u00100\u001A\u00020#2\u0006\u00101\u001A\u00020#J\u0006\u00102\u001A\u00020\'J\u000E\u00103\u001A\u00020\'2\u0006\u00104\u001A\u000205J\u0016\u00106\u001A\u00020\'2\u0006\u00104\u001A\u00020\u00052\u0006\u00107\u001A\u00020\u0011J\u0016\u00108\u001A\u00020\'2\u0006\u00109\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\u0011J\u001E\u0010 \u001A\u00020\'2\u0006\u0010;\u001A\u00020\u00052\u0006\u0010<\u001A\u00020\u00072\u0006\u0010=\u001A\u00020\u0007J\u0016\u0010>\u001A\u00020\'2\u0006\u0010?\u001A\u00020\u00072\u0006\u0010@\u001A\u00020#J\u0016\u0010\u001F\u001A\u00020\'2\u0006\u0010A\u001A\u00020\u00052\u0006\u0010B\u001A\u00020\u0007J\u000E\u0010C\u001A\u00020\'2\u0006\u0010\u0006\u001A\u00020\u0005J\u001E\u0010D\u001A\u00020\'2\b\b\u0002\u0010E\u001A\u00020\u00112\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00050FJ\b\u0010G\u001A\u00020\u0005H\u0002J\u0006\u0010H\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00050\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\'0&X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006J"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/CameraDiagnostics;", "", "<init>", "()V", "TAG", "", "value", "", "enabled", "getEnabled", "()Z", "rejected", "", "events", "Ljava/util/ArrayDeque;", "samples", "raw", "", "rawX", "rawY", "transformed", "transformedX", "", "transformedY", "cursorReports", "discardedReports", "discardOperations", "backendOffers", "backendAccepted", "session", "revision", "contact", "backend", "sniperHeld", "sniperFactor", "", "lastSample", "emit", "Lkotlin/Function1;", "", "getEmit$app", "()Lkotlin/jvm/functions/Function1;", "setEmit$app", "(Lkotlin/jvm/functions/Function1;)V", "setEnabled", "dx", "", "dy", "x", "y", "cursor", "reject", "reason", "Lcom/TryJeanPc/goldenmouse/aim/CameraDiagnostics$Rejection;", "discarded", "reports", "context", "id", "cameraRevision", "name", "ready", "cleanup", "sniper", "held", "factor", "state", "accepted", "event", "sample", "now", "Lkotlin/Function0;", "totals", "snapshot", "Rejection", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CameraDiagnostics {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000B\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/CameraDiagnostics$Rejection;", "", "<init>", "(Ljava/lang/String;I)V", "RAW_INACTIVE", "ENGINE_INACTIVE", "DISABLED", "SESSION", "ANCHOR", "NONFINITE", "STALE_COMMAND", "BACKEND", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Rejection {
        public static final enum Rejection ANCHOR;
        public static final enum Rejection BACKEND;
        public static final enum Rejection DISABLED;
        public static final enum Rejection ENGINE_INACTIVE;
        public static final enum Rejection NONFINITE;
        public static final enum Rejection RAW_INACTIVE;
        public static final enum Rejection SESSION;
        public static final enum Rejection STALE_COMMAND;

        private static final Rejection[] $values() {
            return new Rejection[]{Rejection.RAW_INACTIVE, Rejection.ENGINE_INACTIVE, Rejection.DISABLED, Rejection.SESSION, Rejection.ANCHOR, Rejection.NONFINITE, Rejection.STALE_COMMAND, Rejection.BACKEND};
        }

        static {
            Rejection.RAW_INACTIVE = new Rejection("RAW_INACTIVE", 0);
            Rejection.ENGINE_INACTIVE = new Rejection("ENGINE_INACTIVE", 1);
            Rejection.DISABLED = new Rejection("DISABLED", 2);
            Rejection.SESSION = new Rejection("SESSION", 3);
            Rejection.ANCHOR = new Rejection("ANCHOR", 4);
            Rejection.NONFINITE = new Rejection("NONFINITE", 5);
            Rejection.STALE_COMMAND = new Rejection("STALE_COMMAND", 6);
            Rejection.BACKEND = new Rejection("BACKEND", 7);
            Rejection[] v0 = Rejection.$values();
            Rejection.$VALUES = v0;
            Rejection.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Rejection(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Rejection.$ENTRIES;
        }

        public static Rejection valueOf(String arg1) {
            return Enum.valueOf(Rejection.class, arg1);
        }

        public static Rejection[] values() {
            return Rejection.$VALUES.clone();
        }
    }

    public static final int $stable = 0;
    public static final CameraDiagnostics INSTANCE = null;
    public static final String TAG = "GOLDEN_CAMERA_TRACE";
    private static String backend;
    private static long backendAccepted;
    private static long backendOffers;
    private static String contact;
    private static long cursorReports;
    private static long discardOperations;
    private static long discardedReports;
    private static Function1 emit;
    private static volatile boolean enabled;
    private static final ArrayDeque events;
    private static long lastSample;
    private static long raw;
    private static long rawX;
    private static long rawY;
    private static final long[] rejected;
    private static long revision;
    private static final ArrayDeque samples;
    private static long session;
    private static float sniperFactor;
    private static boolean sniperHeld;
    private static long transformed;
    private static double transformedX;
    private static double transformedY;

    static {
        CameraDiagnostics.INSTANCE = new CameraDiagnostics();
        CameraDiagnostics.rejected = new long[Rejection.getEntries().size()];
        CameraDiagnostics.events = new ArrayDeque();
        CameraDiagnostics.samples = new ArrayDeque();
        CameraDiagnostics.session = -1;
        CameraDiagnostics.revision = -1;
        CameraDiagnostics.contact = "unknown";
        CameraDiagnostics.backend = "unknown";
        CameraDiagnostics.sniperFactor = 1f;
        CameraDiagnostics.lastSample = -9223372036854775808L;
        CameraDiagnostics.emit = new CameraDiagnostics$$ExternalSyntheticLambda1();
        CameraDiagnostics.$stable = 8;
    }

    private CameraDiagnostics() {
        super();
    }

    public final void backend(String arg2, boolean arg3, boolean arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "name");
            if(CameraDiagnostics.enabled) {
                goto label_7;
            }
        }
        catch(Throwable v2) {
            goto label_23;
        }

        __monitor_exit(this);
        return;
        try {
        label_7:
            CameraDiagnostics.backend = arg2 + " ready=" + arg3 + " cleanupPending=" + arg4;
            GgPerformanceDiagnostics.INSTANCE.reportIfDue();
        }
        catch(Throwable v2) {
            try {
            label_23:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_23;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final void contact(String arg9, boolean arg10) {
        CameraDiagnostics v1;
        String v0 = "contact=";
        Intrinsics.checkNotNullParameter(arg9, "state");
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            v1 = CameraDiagnostics.INSTANCE;
            if(CameraDiagnostics.enabled) {
                goto label_12;
            }
        }
        catch(Throwable v9) {
            goto label_49;
        }

        __monitor_exit(this);
        return;
        try {
        label_12:
            CameraDiagnostics.contact = arg9 + " accepted=" + arg10;
            long v2 = 1;
            if(!arg10) {
                long[] v4 = CameraDiagnostics.rejected;
                int v5 = Rejection.BACKEND.ordinal();
                v4[v5] += v2;
            }

            if(Intrinsics.areEqual(arg9, "MOVE_OFFER")) {
                CameraDiagnostics.backendOffers += v2;
                if(arg10) {
                    CameraDiagnostics.backendAccepted += v2;
                }
            }
            else {
                v1.event(v0 + CameraDiagnostics.contact);
            }
        }
        catch(Throwable v9) {
        label_49:
            __monitor_exit(this);
            throw v9;
        }

        __monitor_exit(this);
    }

    public final void context(long arg3, long arg5) {
        String v0 = "session=";
        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled) {
                goto label_6;
            }
        }
        catch(Throwable v3) {
            goto label_19;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            CameraDiagnostics.session = arg3;
            CameraDiagnostics.revision = arg5;
            this.event(v0 + arg3 + " revision=" + arg5);
        }
        catch(Throwable v3) {
            try {
            label_19:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_19;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    public final void cursor() {
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled) {
                ++CameraDiagnostics.cursorReports;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }

    public final void discarded(String arg8, long arg9) {
        String v0 = "discard reason=";
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg8, "reason");
            if(CameraDiagnostics.enabled) {
                goto label_8;
            }
        }
        catch(Throwable v8) {
            goto label_31;
        }

        __monitor_exit(this);
        return;
        try {
        label_8:
            ++CameraDiagnostics.discardOperations;
            CameraDiagnostics.discardedReports += RangesKt.coerceAtLeast(arg9, 0);
            if(arg9 > 0) {
                this.event(v0 + StringsKt.take(arg8, 80) + " reports=" + arg9);
            }
        }
        catch(Throwable v8) {
            try {
            label_31:
                __monitor_exit(this);
            }
            catch(Throwable v8) {
                goto label_31;
            }

            throw v8;
        }

        __monitor_exit(this);
    }

    static final Unit emit$lambda$0(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        Log.i("GOLDEN_CAMERA_TRACE", arg1);
        return Unit.INSTANCE;
    }

    public final void event(String arg5) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg5, "value");
            if(CameraDiagnostics.enabled) {
                goto label_7;
            }
        }
        catch(Throwable v5) {
            goto label_26;
        }

        __monitor_exit(this);
        return;
        try {
        label_7:
            ArrayDeque v0 = CameraDiagnostics.events;
            if(v0.size() == 0x20) {
                v0.removeFirst();
            }

            v0.addLast(System.nanoTime() + " " + StringsKt.take(arg5, 700));
        }
        catch(Throwable v5) {
            try {
            label_26:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_26;
            }

            throw v5;
        }

        __monitor_exit(this);
    }

    public final Function1 getEmit$app() {
        return CameraDiagnostics.emit;
    }

    public final boolean getEnabled() {
        return CameraDiagnostics.enabled;
    }

    public final void raw(int arg5, int arg6) {
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled) {
                ++CameraDiagnostics.raw;
                CameraDiagnostics.rawX += ((long)arg5);
                CameraDiagnostics.rawY += ((long)arg6);
            }
        }
        catch(Throwable v5) {
            __monitor_exit(this);
            throw v5;
        }

        __monitor_exit(this);
    }

    public final void reject(Rejection arg6) {
        Intrinsics.checkNotNullParameter(arg6, "reason");
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled) {
                long[] v0 = CameraDiagnostics.rejected;
                int v6_1 = arg6.ordinal();
                ++v0[v6_1];
            }
        }
        catch(Throwable v6) {
            __monitor_exit(this);
            throw v6;
        }

        __monitor_exit(this);
    }

    public final void sample(long arg12, Function0 arg14) {
        String v12_1;
        String v0 = "timeNs=";
        Intrinsics.checkNotNullParameter(arg14, "state");
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            CameraDiagnostics v1 = CameraDiagnostics.INSTANCE;
            if(CameraDiagnostics.enabled) {
                long v2 = CameraDiagnostics.lastSample;
                if(v2 != -9223372036854775808L && arg12 - v2 < 1000000000) {
                    goto label_66;
                }

                CameraDiagnostics.lastSample = arg12;
                ArrayDeque v2_1 = CameraDiagnostics.samples;
                if(v2_1.size() == 16) {
                    v2_1.removeFirst();
                }

                v12_1 = v0 + arg12 + " session=" + CameraDiagnostics.session + " revision=" + CameraDiagnostics.revision + " contact=" + CameraDiagnostics.contact + " sniperHeld=" + CameraDiagnostics.sniperHeld + " sniperFactor=" + CameraDiagnostics.sniperFactor + " " + StringsKt.take(arg14.invoke(), 1400);
                v2_1.addLast(v12_1);
                v12_1 = v12_1 + " " + v1.totals();
                goto label_62;
            }

            goto label_66;
        }
        catch(Throwable v12) {
            __monitor_exit(this);
            throw v12;
        }

    label_62:
        __monitor_exit(this);
        CameraDiagnostics.emit.invoke(v12_1);
        return;
    label_66:
        __monitor_exit(this);
    }

    public static void sample$default(CameraDiagnostics arg0, long arg1, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = System.nanoTime();
        }

        arg0.sample(arg1, arg3);
    }

    public final void setEmit$app(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<set-?>");
        CameraDiagnostics.emit = arg1;
    }

    public final void setEnabled(boolean arg10) {
        String v0 = "diagnostic=";
        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled != arg10) {
                goto label_6;
            }
        }
        catch(Throwable v0_1) {
            goto label_49;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            CameraDiagnostics.enabled = arg10;
            GgPerformanceDiagnostics.INSTANCE.setEnabled(arg10);
            if(arg10) {
                ArraysKt.fill$default(CameraDiagnostics.rejected, 0, 0, 0, 6, null);
                CameraDiagnostics.events.clear();
                CameraDiagnostics.samples.clear();
                CameraDiagnostics.raw = 0;
                CameraDiagnostics.rawX = 0;
                CameraDiagnostics.rawY = 0;
                CameraDiagnostics.transformed = 0;
                CameraDiagnostics.transformedX = 0;
                CameraDiagnostics.transformedY = 0;
                CameraDiagnostics.cursorReports = 0;
                CameraDiagnostics.discardedReports = 0;
                CameraDiagnostics.discardOperations = 0;
                CameraDiagnostics.backendOffers = 0;
                CameraDiagnostics.backendAccepted = 0;
                CameraDiagnostics.session = -1;
                CameraDiagnostics.revision = -1;
                CameraDiagnostics.contact = "unknown";
                CameraDiagnostics.lastSample = -9223372036854775808L;
            }

            this.event(v0 + arg10);
        }
        catch(Throwable v0_1) {
        label_49:
            Throwable v10 = v0_1;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_49;
            }

            throw v10;
        }

        __monitor_exit(this);
    }

    public final String snapshot() {
        String v0 = "backend=";
        String v1 = "enabled=";
        __monitor_enter(this);
        try {
            StringBuilder v2 = new StringBuilder();
            CameraDiagnostics v3 = CameraDiagnostics.INSTANCE;
            boolean v4 = CameraDiagnostics.enabled;
            long v5 = CameraDiagnostics.session;
            long v7 = CameraDiagnostics.revision;
            String v9 = CameraDiagnostics.contact;
            boolean v10 = CameraDiagnostics.sniperHeld;
            float v11 = CameraDiagnostics.sniperFactor;
            StringBuilder v1_1 = new StringBuilder(v1).append(v4);
            char v4_1 = '\n';
            v2.append(v1_1.append(" session=").append(v5).append(" revision=").append(v7).append(" contact=").append(v9).append(" sniperHeld=").append(v10).append(" sniperFactor=").append(v11).toString()).append(v4_1);
            v2.append("MOVE admitted is transport admission, not confirmation from the game. rawCore includes cursor reports.").append(v4_1);
            v2.append(v0 + CameraDiagnostics.backend).append(v4_1);
            v2.append(v3.totals()).append(v4_1);
            v2.append(InjectionDiagnostics.INSTANCE.cameraSnapshot$app()).append(v4_1);
            v2.append(GgPerformanceDiagnostics.INSTANCE.snapshot()).append(v4_1);
            v2.append("SAMPLES (max16)").append(v4_1);
            Iterator v0_2 = CameraDiagnostics.samples.iterator();
            while(v0_2.hasNext()) {
                v2.append(v0_2.next()).append(v4_1);
            }

            v2.append("EVENTS (max32)").append(v4_1);
            v0_2 = CameraDiagnostics.events.iterator();
            while(v0_2.hasNext()) {
                v2.append(v0_2.next()).append(v4_1);
            }

            v0 = v2.toString();
        }
        catch(Throwable v0_1) {
            goto label_81;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_81:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_81;
        }

        throw v0_1;
    }

    public final void sniper(boolean arg3, float arg4) {
        String v0 = "sniperHeld=";
        __monitor_enter(this);
        try {
            CameraDiagnostics.sniperHeld = arg3;
            CameraDiagnostics.sniperFactor = arg4;
            if(CameraDiagnostics.enabled) {
                this.event(v0 + arg3 + " factor=" + arg4);
            }
        }
        catch(Throwable v3) {
            try {
            label_17:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_17;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    private final String totals() {
        return "rawCore=" + CameraDiagnostics.raw + " rawX=" + CameraDiagnostics.rawX + " rawY=" + CameraDiagnostics.rawY + " ggMoves=" + CameraDiagnostics.transformed + " ggMoveX=" + CameraDiagnostics.transformedX + " ggMoveY=" + CameraDiagnostics.transformedY + " cursorReports=" + CameraDiagnostics.cursorReports + " discardedKnownReports=" + CameraDiagnostics.discardedReports + " discardOperations=" + CameraDiagnostics.discardOperations + " backendMoveOffers=" + CameraDiagnostics.backendOffers + " backendMoveAdmitted=" + CameraDiagnostics.backendAccepted + " rejected=" + CollectionsKt.joinToString$default(Rejection.getEntries(), ",", null, null, 0, null, new CameraDiagnostics$$ExternalSyntheticLambda0(), 30, null);
    }

    static final CharSequence totals$lambda$7(Rejection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        return arg4.name() + ":" + CameraDiagnostics.rejected[arg4.ordinal()];
    }

    public final void transformed(float arg5, float arg6) {
        if(!CameraDiagnostics.enabled) {
            return;
        }

        __monitor_enter(this);
        try {
            if(CameraDiagnostics.enabled) {
                ++CameraDiagnostics.transformed;
                CameraDiagnostics.transformedX += ((double)arg5);
                CameraDiagnostics.transformedY += ((double)arg6);
            }
        }
        catch(Throwable v5) {
            __monitor_exit(this);
            throw v5;
        }

        __monitor_exit(this);
    }
}

