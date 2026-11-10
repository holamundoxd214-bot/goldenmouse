package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.util.AtomicFile;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u0004\u0018\u00010\tJ\u0016\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsHistory;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Landroid/util/AtomicFile;", "read", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "begin", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "pkg", "", "source", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsHistory {
    public static final int $stable = 8;
    private final AtomicFile file;

    static {
    }

    public GraphicsHistory(Context arg4) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        super();
        this.file = new AtomicFile(new File(arg4.getNoBackupFilesDir(), "golden_graphics_attempt_v1.json"));
    }

    public final GraphicsAttemptLog begin(String arg15, String arg16) {
        Intrinsics.checkNotNullParameter(arg15, "pkg");
        Intrinsics.checkNotNullParameter(arg16, "source");
        return new GraphicsAttemptLog(new GraphicsAttempt(arg15, arg16, 0, null, null, null, 0, false, null, 508, null), new GraphicsHistory$$ExternalSyntheticLambda0(this));
    }

    static final Unit begin$lambda$0(GraphicsHistory arg2, GraphicsAttempt arg3) {
        Intrinsics.checkNotNullParameter(arg3, "attempt");
        byte[] v3 = arg3.encode().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v3, "getBytes(...)");
        if(v3.length <= 0x20000) {
            FileOutputStream v0 = arg2.file.startWrite();
            try {
                v0.write(v3);
                arg2.file.finishWrite(v0);
            }
            catch(Exception v3_1) {
                arg2.file.failWrite(v0);
                throw v3_1;
            }

            return Unit.INSTANCE;
        }

        throw new IllegalStateException("Check failed.");
    }

    public final GraphicsAttempt read() {
        if(!this.file.getBaseFile().exists() && !new File(this.file.getBaseFile().getPath() + ".bak").exists()) {
            return null;
        }

        Companion v0 = GraphicsAttempt.Companion;
        byte[] v3 = this.file.readFully();
        Intrinsics.checkNotNullExpressionValue(v3, "readFully(...)");
        return v0.decode(new String(v3, Charsets.UTF_8));
    }
}

