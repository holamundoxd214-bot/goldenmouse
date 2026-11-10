package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.CompletionStage;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H&J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001A\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchIndependentRecoveryAgent;", "", "prepare", "Ljava/util/concurrent/CompletionStage;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentAcknowledgement;", "registration", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentRegistration;", "requestEmergency", "request", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryEmergencyRequest;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchIndependentRecoveryAgent {
    CompletionStage prepare(RecoveryAgentRegistration arg1);

    CompletionStage requestEmergency(RecoveryEmergencyRequest arg1);
}

