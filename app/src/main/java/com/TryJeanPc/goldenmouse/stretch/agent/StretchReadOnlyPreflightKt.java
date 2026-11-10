package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Process;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\b\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u0016\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\tH\u0000\u001A/\u0010\n\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u000B0\tH\u0000¢\u0006\u0002\u0010\r\u001A\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0010\u001A\u0014\u0010\u0011\u001A\u00020\u00122\n\u0010\u0013\u001A\u00060\u0014j\u0002`\u0015H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"preflightInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "beginStretchOperation", "", "endStretchOperation", "", "runExclusiveStretchPreflight", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPreflightReport;", "action", "Lkotlin/Function0;", "runExclusiveStretchCheck", "T", "busy", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runStretchReadOnlyPreflight", "context", "Landroid/content/Context;", "preflightErrorType", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchReadOnlyPreflightKt {
    private static final AtomicBoolean preflightInProgress;

    static {
        StretchReadOnlyPreflightKt.preflightInProgress = new AtomicBoolean();
    }

    public static final boolean beginStretchOperation() {
        return StretchReadOnlyPreflightKt.preflightInProgress.compareAndSet(false, true);
    }

    public static final void endStretchOperation() {
        StretchReadOnlyPreflightKt.preflightInProgress.set(false);
    }

    public static final String preflightErrorType(Exception arg3) {
        Throwable v3;
        Intrinsics.checkNotNullParameter(arg3, "error");
        int v0;
        for(v0 = 0; v0 < 4; ++v0) {
            if(((arg3 instanceof ExecutionException)) || ((arg3 instanceof CompletionException))) {
                Throwable v1 = arg3.getCause();
                if(v1 != null) {
                    v3 = v1;
                }
            }
        }

        String v3_1 = v3.getClass().getSimpleName();
        Intrinsics.checkNotNull(v3_1);
        if(new Regex("[A-Za-z0-9_]{1,80}").matches(v3_1)) {
        }
        else {
            v3_1 = null;
        }

        if(v3_1 == null) {
            v3_1 = "READ_FAILED";
        }

        return v3_1;
    }

    public static final Object runExclusiveStretchCheck(Function0 arg1, Function0 arg2) {
        Object v1_1;
        Intrinsics.checkNotNullParameter(arg1, "busy");
        Intrinsics.checkNotNullParameter(arg2, "action");
        if(!StretchReadOnlyPreflightKt.beginStretchOperation()) {
            return arg1.invoke();
        }

        try {
            v1_1 = arg2.invoke();
        }
        catch(Throwable v1) {
            StretchReadOnlyPreflightKt.endStretchOperation();
            throw v1;
        }

        StretchReadOnlyPreflightKt.endStretchOperation();
        return v1_1;
    }

    public static final StretchPreflightReport runExclusiveStretchPreflight(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "action");
        return StretchReadOnlyPreflightKt.runExclusiveStretchCheck(new StretchReadOnlyPreflightKt$$ExternalSyntheticLambda0(), arg1);
    }

    static final StretchPreflightReport runExclusiveStretchPreflight$lambda$0() {
        return new StretchPreflightReport(MapsKt.mapOf(TuplesKt.to("outcome", "BUSY")));
    }

    public static final StretchPreflightReport runStretchReadOnlyPreflight(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        return StretchReadOnlyPreflightKt.runExclusiveStretchPreflight(new StretchReadOnlyPreflightKt$$ExternalSyntheticLambda1(arg1));
    }

    static final StretchPreflightReport runStretchReadOnlyPreflight$lambda$3(Context arg14) {
        String v0 = "shizukuBinder";
        LinkedHashMap v1 = new LinkedHashMap();
        try {
            v1.put(v0, String.valueOf(Shizuku.pingBinder()));
            if(!Intrinsics.areEqual(v1.get(v0), "true")) {
                goto label_35;
            }

            v1.put("shizukuVersion", String.valueOf(Shizuku.getVersion()));
            v1.put("shizukuUid", String.valueOf(Shizuku.getUid()));
            LinkedHashMap v0_2 = v1;
            String v2 = "shizukuPermission";
            String v3 = Shizuku.checkSelfPermission() == 0 ? "GRANTED" : "DENIED";
            ((Map)v0_2).put(v2, v3);
        }
        catch(Exception v0_1) {
            v1.put("shizukuReadError", StretchReadOnlyPreflightKt.preflightErrorType(v0_1));
        }

    label_35:
        Context v2_1 = arg14.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2_1, "getApplicationContext(...)");
        ShizukuStretchAgentConnection v0_3 = new ShizukuStretchAgentConnection(v2_1, false, 2, null);
        return new StretchReadOnlyPreflight(Build$VERSION.SDK_INT, Process.myUid(), new StretchReadOnlyPreflightKt$$ExternalSyntheticLambda2(v0_3), new StretchReadOnlyPreflightKt$$ExternalSyntheticLambda3(arg14), new StretchReadOnlyPreflightKt$runStretchReadOnlyPreflight$1$3(v0_3), v1, new StretchReadOnlyPreflightKt$runStretchReadOnlyPreflight$1$4(v0_3)).run();
    }

    static final StretchAgentClient runStretchReadOnlyPreflight$lambda$3$lambda$1(ShizukuStretchAgentConnection arg3) {
        Object v3 = arg3.connect().get(14, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(v3, "get(...)");
        return ((StretchAgentClient)v3);
    }

    static final CandidateJournalRead runStretchReadOnlyPreflight$lambda$3$lambda$2(Context arg2) {
        AndroidStretchCandidateJournal v0 = AndroidStretchCandidateJournal.INSTANCE;
        arg2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(arg2, "getApplicationContext(...)");
        return v0.inspectExisting(arg2);
    }
}

