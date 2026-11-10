package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;
import java.nio.file.Files;
import kotlin.Metadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0015\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\fJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\b\u001A\u00020\tJ\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchCandidateJournal;", "", "<init>", "()V", "NAME", "", "createForPreparation", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "context", "Landroid/content/Context;", "delegate", "Landroid/os/ParcelFileDescriptor;", "delegate$app", "inspectExisting", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "protected", "", "file", "Ljava/io/File;", "owner", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchCandidateJournal {
    public static final int $stable = 0;
    public static final AndroidStretchCandidateJournal INSTANCE = null;
    private static final String NAME = "golden_stretch_physical_candidate_v1.bin";

    static {
        AndroidStretchCandidateJournal.INSTANCE = new AndroidStretchCandidateJournal();
    }

    private AndroidStretchCandidateJournal() {
        super();
    }

    public final StretchCandidateJournal createForPreparation(Context arg10) {
        Intrinsics.checkNotNullParameter(arg10, "context");
        String v2 = "Failed requirement.";
        if(Process.myUid() == arg10.getApplicationInfo().uid) {
            File v10 = arg10.getNoBackupFilesDir();
            if((v10.isDirectory()) && !Files.isSymbolicLink(v10.toPath())) {
                File v4 = new File(v10, "golden_stretch_physical_candidate_v1.bin");
                if(v4.exists()) {
                    if(this.protected(v4, Process.myUid())) {
                    }
                    else {
                        throw new IllegalArgumentException(v2.toString());
                    }
                }

                StretchCandidateJournal v10_1 = Companion.host$app$default(StretchCandidateJournal.Companion, v4, null, false, 6, null);
                try {
                    if(this.protected(v4, Process.myUid())) {
                        return v10_1;
                    }

                    throw new IllegalArgumentException(v2.toString());
                }
                catch(Exception v0) {
                    v10_1.close();
                    throw v0;
                }
            }

            throw new IllegalArgumentException(v2.toString());
        }

        throw new IllegalArgumentException(v2.toString());
    }

    public final ParcelFileDescriptor delegate$app(Context arg8) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        this.createForPreparation(arg8).close();
        File v0 = new File(arg8.getNoBackupFilesDir(), "golden_stretch_physical_candidate_v1.bin");
        StructStat v8 = Os.lstat(v0.getAbsolutePath());
        ParcelFileDescriptor v1 = ParcelFileDescriptor.open(v0, 0x30000000);
        try {
            StructStat v2 = Os.fstat(v1.getFileDescriptor());
            if((this.protected(v0, Process.myUid())) && v8.st_dev == v2.st_dev && v8.st_ino == v2.st_ino) {
                Intrinsics.checkNotNull(v1);
                return v1;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Exception v7) {
            v1.close();
            throw v7;
        }
    }

    public final CandidateJournalRead inspectExisting(Context arg7) {
        CandidateJournalRead v7_1;
        StretchCandidateJournal v6;
        Intrinsics.checkNotNullParameter(arg7, "context");
        if(Process.myUid() != arg7.getApplicationInfo().uid) {
            return new Blocked(CandidateJournalError.UNPROTECTED_DESCRIPTOR);
        }

        File v1 = new File(arg7.getNoBackupFilesDir(), "golden_stretch_physical_candidate_v1.bin");
        if(!v1.exists()) {
            return Missing.INSTANCE;
        }

        if(!this.protected(v1, Process.myUid())) {
            return new Blocked(CandidateJournalError.UNPROTECTED_DESCRIPTOR);
        }

        try {
            v6 = Companion.host$app$default(StretchCandidateJournal.Companion, v1, null, true, 2, null);
        }
        catch(Exception ) {
            goto label_42;
        }

        StretchCandidateJournal v7 = v6;
        try {
            v7_1 = v7.load();
            v0 = null;
            goto label_34;
        }
        catch(Throwable v0) {
            Throwable v7_2 = v0;
            try {
                throw v7_2;
            }
            catch(Throwable v0) {
                try {
                    AutoCloseableKt.closeFinally(((AutoCloseable)v6), v7_2);
                    throw v0;
                label_34:
                    AutoCloseableKt.closeFinally(((AutoCloseable)v6), v0);
                    return v7_1;
                }
                catch(Exception ) {
                label_42:
                    return new Blocked(CandidateJournalError.BUSY);
                }
            }
        }
    }

    private final boolean protected(File arg5, int arg6) {
        boolean v4 = false;
        try {
            StructStat v5 = Os.lstat(arg5.getAbsolutePath());
            if((OsConstants.S_ISREG(v5.st_mode)) && v5.st_uid == arg6 && v5.st_nlink == 1 && (v5.st_mode & 0x1FF) == 0x180) {
                long v5_1 = v5.st_size;
                if(0 <= v5_1) {
                    goto label_18;
                }
            }
        }
        catch(Exception ) {
        }

        return v4;
    label_18:
        if(v5_1 < 0x10011) {
            v4 = true;
        }

        return v4;
    }
}

