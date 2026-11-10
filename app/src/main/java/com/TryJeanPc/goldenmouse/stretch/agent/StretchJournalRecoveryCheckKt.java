package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"runStretchJournalRecoveryCheck", "", "context", "Landroid/content/Context;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchJournalRecoveryCheckKt {
    public static final String runStretchJournalRecoveryCheck(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        return StretchReadOnlyPreflightKt.runExclusiveStretchCheck(new StretchJournalRecoveryCheckKt$$ExternalSyntheticLambda0(), new StretchJournalRecoveryCheckKt$$ExternalSyntheticLambda1(arg3, new ObjectRef()));
    }

    static final String runStretchJournalRecoveryCheck$lambda$0() {
        return "outcome: FAIL\ncause: BUSY\nphysicalMutationAllowed: false";
    }

    static final String runStretchJournalRecoveryCheck$lambda$5(Context arg4, ObjectRef arg5) {
        return new StretchJournalRecoveryCheck(Process.myUid(), new StretchJournalRecoveryCheckKt$$ExternalSyntheticLambda2(arg4, arg5), new StretchJournalRecoveryCheckKt$$ExternalSyntheticLambda3(arg5), new StretchJournalRecoveryCheckKt$$ExternalSyntheticLambda4(arg4)).run();
    }

    static final StretchAgentClient runStretchJournalRecoveryCheck$lambda$5$lambda$2(Context arg4, ObjectRef arg5) {
        arg4 = arg4.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(arg4, "getApplicationContext(...)");
        ShizukuStretchAgentConnection v0 = new ShizukuStretchAgentConnection(arg4, false, 2, null);
        arg5.element = v0;
        Object v4 = v0.connect().get(14, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(v4, "get(...)");
        return ((StretchAgentClient)v4);
    }

    static final boolean runStretchJournalRecoveryCheck$lambda$5$lambda$3(ObjectRef arg0, boolean arg1) {
        Object v0 = arg0.element;
        if(arg1) {
            if(v0 != null) {
                return ((ShizukuStretchAgentConnection)v0).closeAndAwaitAgentDeath$app();
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }

        if(v0 != null) {
            ((ShizukuStretchAgentConnection)v0).close();
        }

        return 1;
    }

    static final CandidateJournalRead runStretchJournalRecoveryCheck$lambda$5$lambda$4(Context arg2) {
        AndroidStretchCandidateJournal v0 = AndroidStretchCandidateJournal.INSTANCE;
        arg2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(arg2, "getApplicationContext(...)");
        return v0.inspectExisting(arg2);
    }
}

