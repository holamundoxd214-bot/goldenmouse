package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004"}, d2={"stretchConnectSecurityError", "Ljava/lang/SecurityException;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectRejection;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchAgentConnectionDiagnosticsKt {
    public static final SecurityException stretchConnectSecurityError(StretchConnectRejection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "reason");
        return new SecurityException("GOLDEN_STRETCH_4B:" + arg3.name());
    }
}

