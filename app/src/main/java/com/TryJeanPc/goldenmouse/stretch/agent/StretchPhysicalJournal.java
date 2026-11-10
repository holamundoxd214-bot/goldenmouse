package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;", "", "load", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "commit", "", "record", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "expectedRevision", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchPhysicalJournal {
    boolean commit(StretchCandidateRecord arg1, long arg2);

    CandidateJournalRead load();
}

