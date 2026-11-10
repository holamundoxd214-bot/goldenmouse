package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0007J\u0006\u0010\u0012\u001A\u00020\u0010J\u001E\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u0017J\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalProgressTracker;", "", "challenge", "", "<init>", "(Ljava/lang/String;)V", "expected", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "sequence", "", "current", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "finished", "", "completed", "begin", "", "request", "end", "accept", "kernelUid", "flags", "frame", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalCheckpoint;", "snapshot", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalProgressTracker {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalProgressTracker$Companion;", "", "<init>", "()V", "VERSION", "", "MAX_CHECKPOINTS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int MAX_CHECKPOINTS = 0x30;
    public static final int VERSION = 1;
    private final String challenge;
    private StretchOriginalAgentStep completed;
    private StretchOriginalAgentStep current;
    private StretchAgentRequest expected;
    private boolean finished;
    private int sequence;

    static {
        StretchOriginalProgressTracker.Companion = new Companion(null);
        StretchOriginalProgressTracker.$stable = 8;
    }

    public StretchOriginalProgressTracker(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "challenge");
        super();
        this.challenge = arg2;
    }

    public final void accept(int arg2, int arg3, StretchOriginalCheckpoint arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg4, "frame");
            if(arg2 == 2000 && (StretchAgentWire.INSTANCE.isSynchronousTransport(arg3)) && this.expected != null && arg4.getVersion() == 1 && (Intrinsics.areEqual(arg4.getChallenge(), this.challenge)) && (Intrinsics.areEqual(arg4.getRequest(), this.expected)) && arg4.getSequence() == this.sequence + 1 && arg4.getSequence() <= 0x30) {
                if(!arg4.getFinished()) {
                    arg2 = arg4.getStep().ordinal();
                    StretchOriginalAgentStep v3 = this.current;
                    arg3 = v3 != null ? v3.ordinal() : -1;
                    if(arg2 <= arg3) {
                        goto label_55;
                    }
                }
                else if(this.current != arg4.getStep()) {
                    goto label_55;
                }
                else if(!this.finished) {
                }
                else {
                    goto label_55;
                }

                this.sequence = arg4.getSequence();
                this.current = arg4.getStep();
                boolean v2_1 = arg4.getFinished();
                this.finished = v2_1;
                if(v2_1) {
                    this.completed = arg4.getStep();
                }

                goto label_53;
            }

            goto label_55;
        }
        catch(Throwable v2) {
            goto label_60;
        }

    label_53:
        __monitor_exit(this);
        return;
        try {
        label_55:
            throw new SecurityException("Untrusted original progress");
        label_60:
            __monitor_exit(this);
        }
        catch(Throwable v2) {
            goto label_60;
        }

        throw v2;
    }

    public final void begin(StretchAgentRequest arg3) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "request");
            if(this.expected != null) {
                goto label_25;
            }

            if(arg3.getProtocol() == 2 && (StretchOriginalEvidenceRpc.INSTANCE.accepts(arg3))) {
                this.expected = arg3;
                this.sequence = 0;
                this.current = null;
                this.completed = null;
                this.finished = false;
                goto label_18;
            }

            goto label_20;
        }
        catch(Throwable v3) {
            goto label_30;
        }

    label_18:
        __monitor_exit(this);
        return;
        try {
        label_20:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_25:
            throw new IllegalStateException("Check failed.");
        label_30:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_30;
        }

        throw v3;
    }

    public final void end() {
        __monitor_enter(this);
        StretchAgentRequest v0 = null;
        try {
            this.expected = v0;
        }
        catch(Throwable v0_1) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_6;
            }

            throw v0_1;
        }

        __monitor_exit(this);
    }

    public final Map snapshot() {
        Map v0_3;
        String v2_1;
        __monitor_enter(this);
        int v0 = 4;
        try {
            Pair[] v0_2 = new Pair[v0];
            String v1 = "agentOriginalStep";
            StretchOriginalAgentStep v2 = this.current;
            if(v2 != null) {
                v2_1 = v2.name();
                if(v2_1 == null) {
                    goto label_8;
                }
            }
            else {
            label_8:
                v2_1 = "UNKNOWN";
            }

            v0_2[0] = TuplesKt.to(v1, v2_1);
            v1 = "agentOriginalStepState";
            if(this.current == null) {
                v2_1 = "UNKNOWN";
            }
            else if(this.finished) {
                v2_1 = "DONE";
            }
            else {
                v2_1 = "ENTER";
            }

            v0_2[1] = TuplesKt.to(v1, v2_1);
            v1 = "agentOriginalLastCompleted";
            v2 = this.completed;
            if(v2 != null) {
                v2_1 = v2.name();
                if(v2_1 == null) {
                    goto label_30;
                }
            }
            else {
            label_30:
                v2_1 = "UNKNOWN";
            }

            v0_2[2] = TuplesKt.to(v1, v2_1);
            v0_2[3] = TuplesKt.to("agentOriginalCheckpointCount", String.valueOf(this.sequence));
            v0_3 = MapsKt.mapOf(v0_2);
        }
        catch(Throwable v0_1) {
            try {
            label_44:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_44;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v0_3;
    }
}

