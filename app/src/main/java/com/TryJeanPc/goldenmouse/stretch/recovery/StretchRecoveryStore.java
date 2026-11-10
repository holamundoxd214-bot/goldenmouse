package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u0003\u001A\u00020\u0004H&J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH&¨\u0006\u000BÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "load", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalRead;", "commit", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite;", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "expectedRevision", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchRecoveryStore extends AutoCloseable {
    RecoveryJournalWrite commit(StretchRecoveryRecord arg1, long arg2);

    RecoveryJournalRead load();
}

