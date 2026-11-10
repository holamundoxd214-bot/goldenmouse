package com.TryJeanPc.goldenmouse.stretch.recovery;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/AndroidRecoverySupport;", "", "<init>", "()V", "privateJournal", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryJournal;", "context", "Landroid/content/Context;", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "getClock", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidRecoverySupport {
    public static final int $stable;
    public static final AndroidRecoverySupport INSTANCE;
    private static final RecoveryClock clock;

    static {
        AndroidRecoverySupport.INSTANCE = new AndroidRecoverySupport();
        AndroidRecoverySupport.clock = new AndroidRecoverySupport$clock$1();
        AndroidRecoverySupport.$stable = 8;
    }

    private AndroidRecoverySupport() {
        super();
    }

    public final RecoveryClock getClock() {
        return AndroidRecoverySupport.clock;
    }

    public final StretchRecoveryJournal privateJournal(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        return new StretchRecoveryJournal(new File(arg3.getFilesDir(), "golden_stretch_recovery"), null, 2, null);
    }
}

