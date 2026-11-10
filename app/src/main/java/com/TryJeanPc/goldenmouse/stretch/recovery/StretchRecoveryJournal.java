package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0013H\u0002J\u0018\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0018\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u0018H\u0002J\b\u0010\u001E\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryJournal;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;", "directory", "Ljava/io/File;", "writeStage", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryWriteStage;", "", "<init>", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "recordFile", "temporary", "channel", "Ljava/nio/channels/FileChannel;", "lease", "Ljava/nio/channels/FileLock;", "closed", "", "load", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalRead;", "readHeld", "commit", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite;", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "expectedRevision", "", "preservesHistory", "old", "next", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryJournal implements StretchRecoveryStore {
    public static final int $stable = 8;
    private FileChannel channel;
    private boolean closed;
    private final File directory;
    private FileLock lease;
    private final File recordFile;
    private final File temporary;
    private final Function1 writeStage;

    static {
    }

    public StretchRecoveryJournal(File arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        StretchRecoveryJournal$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new StretchRecoveryJournal$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function1)v2));
    }

    public StretchRecoveryJournal(File arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "directory");
        Intrinsics.checkNotNullParameter(arg3, "writeStage");
        super();
        this.directory = arg2;
        this.writeStage = arg3;
        this.recordFile = new File(arg2, "recovery.bin");
        this.temporary = new File(arg2, "recovery.tmp");
    }

    static final Unit _init_$lambda$0(RecoveryWriteStage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public void close() {
        FileLock v0_1;
        __monitor_enter(this);
        try {
            if(!this.closed) {
                goto label_6;
            }
        }
        catch(Throwable v0) {
            goto label_26;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            this.closed = true;
            v0_1 = null;
        }
        catch(Throwable v0) {
            goto label_26;
        }

        try {
            FileLock v1_1 = this.lease;
            if(v1_1 != null) {
                v1_1.release();
            }

            goto label_11;
        }
        catch(Throwable v1) {
            try {
                this.lease = v0_1;
                FileChannel v2 = this.channel;
                if(v2 != null) {
                    v2.close();
                }

                this.channel = ((FileChannel)v0_1);
                throw v1;
            label_11:
                this.lease = v0_1;
                FileChannel v1_2 = this.channel;
                if(v1_2 != null) {
                    v1_2.close();
                }

                this.channel = ((FileChannel)v0_1);
                goto label_16;
            label_26:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_26;
            }
        }

        throw v0;
    label_16:
        __monitor_exit(this);
    }

    public RecoveryJournalWrite commit(StretchRecoveryRecord arg6, long arg7) {
        Rejected v6_2;
        Committed v6_1;
        FileChannel v7_3;
        FileOutputStream v3_2;
        byte[] v1_2;
        Throwable v2;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg6, "record");
            if(!this.closed && this.lease != null && (StretchRecoveryValidationKt.validRecoveryRecord(arg6)) && arg7 != 0x7FFFFFFFFFFFFFFFL) {
                if(arg6.getRevision() != 1 + arg7) {
                }
                else {
                    RecoveryJournalRead v0 = this.readHeld();
                    v2 = null;
                    RecoveryJournalRead v1 = (v0 instanceof Present) ? v0 : ((RecoveryJournalRead)v2);
                    StretchRecoveryRecord v1_1 = v1 != null ? ((Present)v1).getRecord() : ((StretchRecoveryRecord)v2);
                    if(!(v0 instanceof Blocked)) {
                        long v3 = v1_1 != null ? v1_1.getRevision() : 0;
                        if(v3 != arg7) {
                            goto label_200;
                        }

                        if(v1_1 != null || arg6.getPhase() == RecoveryPhase.PREPARING) {
                            if(v1_1 != null) {
                                if(!StretchRecoveryStateMachine.INSTANCE.canTransition(v1_1.getPhase(), arg6.getPhase())) {
                                    goto label_59;
                                }
                                else if(Intrinsics.areEqual(v1_1.getSnapshot().getSessionId(), arg6.getSnapshot().getSessionId())) {
                                    if(!Intrinsics.areEqual(v1_1.getStrategy(), arg6.getStrategy())) {
                                        goto label_59;
                                    }
                                    else if(!Intrinsics.areEqual(v1_1.getIntendedSteps(), arg6.getIntendedSteps())) {
                                        goto label_59;
                                    }
                                }
                            }

                            goto label_64;
                        }

                    label_59:
                        __monitor_exit(this);
                        return new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                    }

                    goto label_200;
                }
            }

            goto label_205;
        }
        catch(Throwable v6) {
            goto label_211;
        }

    label_64:
        int v7 = 2;
        if(v1_1 != null) {
            try {
                if(!Intrinsics.areEqual(v1_1.getSnapshot().getSessionId(), arg6.getSnapshot().getSessionId()) || (Intrinsics.areEqual(v1_1.getSnapshot(), arg6.getSnapshot()))) {
                    if(Intrinsics.areEqual(v1_1.getSnapshot().getSessionId(), arg6.getSnapshot().getSessionId())) {
                        goto label_104;
                    }
                    else if(v1_1.getPhase() != RecoveryPhase.RECOVERED) {
                        RecoveryPhase[] v3_1 = new RecoveryPhase[v7];
                        v3_1[0] = RecoveryPhase.FAILED;
                        v3_1[1] = RecoveryPhase.NOT_RECOVERABLE;
                        if(SetsKt.setOf(((Object[])v3_1)).contains(v1_1.getPhase())) {
                            if(!v1_1.getSteps().isEmpty()) {
                                goto label_99;
                            }

                            goto label_104;
                        }
                    }
                    else {
                        goto label_104;
                    }
                }

            label_99:
                __monitor_exit(this);
                return new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
            }
            catch(Throwable v6) {
                goto label_211;
            }
        }

    label_104:
        if(v1_1 != null) {
            try {
                if((Intrinsics.areEqual(v1_1.getSnapshot().getSessionId(), arg6.getSnapshot().getSessionId())) && !this.preservesHistory(v1_1, arg6)) {
                    __monitor_exit(this);
                    return new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                }
            }
            catch(Throwable v6) {
                goto label_211;
            }
        }

        try {
            v1_2 = StretchRecoveryCodec.INSTANCE.encode(arg6);
            this.writeStage.invoke(RecoveryWriteStage.BEFORE_WRITE);
            if(Files.isSymbolicLink(this.temporary.toPath())) {
                goto label_190;
            }

            v3_2 = new FileOutputStream(this.temporary);
        }
        catch(Exception ) {
            goto label_195;
        }
        catch(Throwable v6) {
            goto label_211;
        }

        FileOutputStream v4 = v3_2;
        try {
            v4.write(v1_2);
            v4.getFD().sync();
            goto label_135;
        }
        catch(Throwable v6) {
            try {
                throw v6;
            }
            catch(Throwable v7_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)v3_2), v6);
                    throw v7_1;
                label_135:
                    CloseableKt.closeFinally(((Closeable)v3_2), v2);
                    this.writeStage.invoke(RecoveryWriteStage.AFTER_FILE_SYNC);
                    Path v1_3 = this.temporary.toPath();
                    Path v3_3 = this.recordFile.toPath();
                    CopyOption[] v7_2 = new CopyOption[v7];
                    v7_2[0] = StandardCopyOption.ATOMIC_MOVE;
                    v7_2[1] = StandardCopyOption.REPLACE_EXISTING;
                    Files.move(v1_3, v3_3, v7_2);
                    this.writeStage.invoke(RecoveryWriteStage.AFTER_RENAME);
                    v7_3 = FileChannel.open(this.directory.toPath(), new OpenOption[]{StandardOpenOption.READ});
                }
                catch(Exception ) {
                    goto label_195;
                }
                catch(Throwable v6) {
                    goto label_211;
                }
            }
        }

        FileChannel v8 = v7_3;
        try {
            v8.force(true);
            goto label_161;
        }
        catch(Throwable v6) {
            try {
                throw v6;
            }
            catch(Throwable v8_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)v7_3), v6);
                    throw v8_1;
                label_161:
                    CloseableKt.closeFinally(((Closeable)v7_3), v2);
                    this.writeStage.invoke(RecoveryWriteStage.AFTER_DIRECTORY_SYNC);
                    RecoveryJournalRead v7_4 = this.readHeld();
                    if((v7_4 instanceof Present)) {
                    }
                    else {
                        v7_4 = ((RecoveryJournalRead)v2);
                    }

                    if(v7_4 != null) {
                        StretchRecoveryRecord v2_1 = ((Present)v7_4).getRecord();
                    }

                    if(Intrinsics.areEqual(v2, arg6)) {
                        v6_1 = Committed.INSTANCE;
                        goto label_198;
                    }

                    v6_2 = new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                    goto label_198;
                label_190:
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                catch(Throwable v6) {
                }
                catch(Exception ) {
                    try {
                    label_195:
                        v6_2 = new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                    label_198:
                        __monitor_exit(this);
                        return ((RecoveryJournalWrite)v6_1);
                    label_200:
                        __monitor_exit(this);
                        return new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                    label_205:
                        __monitor_exit(this);
                        return new Rejected(RecoveryError.JOURNAL_WRITE_FAILED);
                    }
                    catch(Throwable v6) {
                        try {
                        label_211:
                            __monitor_exit(this);
                        }
                        catch(Throwable v6) {
                            goto label_211;
                        }

                        throw v6;
                    }
                }
            }
        }
    }

    public RecoveryJournalRead load() {
        RecoveryJournalRead v0_1;
        FileChannel v1;
        __monitor_enter(this);
        try {
            if(this.closed) {
                __monitor_exit(this);
                return new Blocked(RecoveryError.CLOSED);
            }

            if(this.lease == null) {
                goto label_10;
            }

            goto label_94;
        }
        catch(Throwable v0) {
            goto label_98;
        }

    label_10:
        v0 = null;
        try {
            Files.createDirectories(this.directory.toPath(), new FileAttribute[0]);
            if(!Files.isSymbolicLink(this.directory.toPath())) {
                v1 = FileChannel.open(this.directory.toPath().toAbsolutePath().getParent(), new OpenOption[]{StandardOpenOption.READ});
            }
            else {
                goto label_71;
            }
        }
        catch(OverlappingFileLockException ) {
            goto label_85;
        }
        catch(Exception ) {
            goto label_76;
        }
        catch(Throwable v0) {
            goto label_98;
        }

        FileChannel v4 = v1;
        try {
            v4.force(true);
            goto label_32;
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                try {
                    CloseableKt.closeFinally(((Closeable)v1), v2);
                    throw v3;
                label_32:
                    CloseableKt.closeFinally(((Closeable)v1), v0);
                    Path v1_1 = new File(this.directory, "recovery.lock").toPath();
                    if(!Files.isSymbolicLink(v1_1)) {
                        v1 = FileChannel.open(v1_1, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE});
                        this.channel = v1;
                        Intrinsics.checkNotNull(v1);
                        FileLock v1_2 = v1.tryLock();
                        this.lease = v1_2;
                        if(v1_2 == null) {
                            v1 = this.channel;
                            if(v1 != null) {
                                v1.close();
                            }

                            this.channel = ((FileChannel)v0);
                            __monitor_exit(this);
                            return new Blocked(RecoveryError.JOURNAL_BUSY);
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    label_71:
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }

                    goto label_94;
                }
                catch(Throwable v0) {
                }
                catch(Exception ) {
                }
                catch(OverlappingFileLockException ) {
                    try {
                    label_85:
                        v1 = this.channel;
                        if(v1 != null) {
                            v1.close();
                        }

                        this.channel = ((FileChannel)v0);
                        __monitor_exit(this);
                        return new Blocked(RecoveryError.JOURNAL_BUSY);
                    label_76:
                        v1 = this.channel;
                        if(v1 != null) {
                            v1.close();
                        }

                        this.channel = ((FileChannel)v0);
                        __monitor_exit(this);
                        return new Blocked(RecoveryError.JOURNAL_READ_FAILED);
                    label_94:
                        v0_1 = this.readHeld();
                    }
                    catch(Throwable v0) {
                        try {
                        label_98:
                            __monitor_exit(this);
                        }
                        catch(Throwable v0) {
                            goto label_98;
                        }

                        throw v0;
                    }
                }
            }
        }

        __monitor_exit(this);
        return v0_1;
    }

    private final boolean preservesHistory(StretchRecoveryRecord arg14, StretchRecoveryRecord arg15) {
        Object v0_1;
        int v0;
        Iterator v13_1;
        if(arg15.getSteps().size() >= arg14.getSteps().size() && arg15.getRestores().size() >= arg14.getRestores().size() && (arg14.getConfirmation() == null || (Intrinsics.areEqual(arg14.getConfirmation(), arg15.getConfirmation()))) && (arg14.getConfirmedAtElapsedMillis() == null || (Intrinsics.areEqual(arg14.getConfirmedAtElapsedMillis(), arg15.getConfirmedAtElapsedMillis())))) {
            IntRange v13 = CollectionsKt.getIndices(arg14.getSteps());
            if(!(v13 instanceof Collection) || !v13.isEmpty()) {
                v13_1 = ((Iterable)v13).iterator();
                do {
                    if(v13_1.hasNext()) {
                        v0 = v13_1.nextInt();
                        Object v2 = arg14.getSteps().get(v0);
                        v0_1 = arg15.getSteps().get(v0);
                        if(((RecoveryStepRecord)v2).getStep() == ((RecoveryStepRecord)v0_1).getStep() && (Intrinsics.areEqual(((RecoveryStepRecord)v2).getTicket(), ((RecoveryStepRecord)v0_1).getTicket()))) {
                            if(((RecoveryStepRecord)v2).getOutcome() == RecoveryStepOutcome.REQUESTED) {
                                continue;
                            }

                            if(((RecoveryStepRecord)v2).getOutcome() == ((RecoveryStepRecord)v0_1).getOutcome()) {
                                continue;
                            }
                        }

                        return 0;
                    }

                    goto label_55;
                }
                while(true);

                return 0;
            }
            else {
            }

        label_55:
            v13 = CollectionsKt.getIndices(arg14.getRestores());
            if(((v13 instanceof Collection)) && (v13.isEmpty())) {
                return 1;
            }

            v13_1 = ((Iterable)v13).iterator();
            while(true) {
                if(!v13_1.hasNext()) {
                    return 1;
                }

                v0 = v13_1.nextInt();
                Object v3 = arg14.getRestores().get(v0);
                v0_1 = arg15.getRestores().get(v0);
                if(Intrinsics.areEqual(((RecoveryRestoreAttempt)v3).getRequest(), ((RecoveryRestoreAttempt)v0_1).getRequest())) {
                    if(((RecoveryRestoreAttempt)v3).getResult() == null) {
                        continue;
                    }

                    if(Intrinsics.areEqual(((RecoveryRestoreAttempt)v3).getResult(), ((RecoveryRestoreAttempt)v0_1).getResult())) {
                        continue;
                    }

                    if(!((RecoveryRestoreAttempt)v3).getResult().getExecutionStopped() && (Intrinsics.areEqual(StretchRestoreResult.copy$default(((RecoveryRestoreAttempt)v3).getResult(), null, null, null, null, true, 15, null), ((RecoveryRestoreAttempt)v0_1).getResult()))) {
                        continue;
                    }
                }

                return 0;
            }

            return 0;
        }

        return 0;
    }

    private final RecoveryJournalRead readHeld() {
        Blocked v4;
        try {
            if(this.temporary.exists()) {
                return new Blocked(RecoveryError.JOURNAL_CORRUPT);
            }

            if(!this.recordFile.exists()) {
                return Missing.INSTANCE;
            }

            if(!Files.isSymbolicLink(this.recordFile.toPath())) {
                long v0 = this.recordFile.length();
                if(44 <= v0 && v0 < 0x10001) {
                    return new Present(StretchRecoveryCodec.INSTANCE.decode(FilesKt.readBytes(this.recordFile)));
                }
            }

            return new Blocked(RecoveryError.JOURNAL_CORRUPT);
        }
        catch(Exception ) {
            v4 = new Blocked(RecoveryError.JOURNAL_CORRUPT);
        }
        catch(UnsupportedVersion ) {
            v4 = new Blocked(RecoveryError.JOURNAL_VERSION);
        }

        return ((RecoveryJournalRead)v4);
    }
}

