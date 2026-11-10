package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\fÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryTransport;", "", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "open", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchQueryTransport {
    StretchBackendType getBackend();

    StretchQueryChannel open(StretchQuery arg1);

    StretchBackendStatus status();
}

