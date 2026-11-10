package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0019\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0007HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\nHÆ\u0003J\t\u0010\u001F\u001A\u00020\fHÆ\u0003JE\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001J\u0013\u0010!\u001A\u00020\f2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\u0003HÖ\u0001J\t\u0010$\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalCheckpoint;", "", "version", "", "challenge", "", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "sequence", "step", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "finished", "", "<init>", "(ILjava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;ILcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Z)V", "getVersion", "()I", "getChallenge", "()Ljava/lang/String;", "getRequest", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "getSequence", "getStep", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "getFinished", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalCheckpoint {
    public static final int $stable;
    private final String challenge;
    private final boolean finished;
    private final StretchAgentRequest request;
    private final int sequence;
    private final StretchOriginalAgentStep step;
    private final int version;

    static {
    }

    public StretchOriginalCheckpoint(int arg2, String arg3, StretchAgentRequest arg4, int arg5, StretchOriginalAgentStep arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg3, "challenge");
        Intrinsics.checkNotNullParameter(arg4, "request");
        Intrinsics.checkNotNullParameter(arg6, "step");
        super();
        this.version = arg2;
        this.challenge = arg3;
        this.request = arg4;
        this.sequence = arg5;
        this.step = arg6;
        this.finished = arg7;
    }

    public final int component1() {
        return this.version;
    }

    public final String component2() {
        return this.challenge;
    }

    public final StretchAgentRequest component3() {
        return this.request;
    }

    public final int component4() {
        return this.sequence;
    }

    public final StretchOriginalAgentStep component5() {
        return this.step;
    }

    public final boolean component6() {
        return this.finished;
    }

    public final StretchOriginalCheckpoint copy(int arg8, String arg9, StretchAgentRequest arg10, int arg11, StretchOriginalAgentStep arg12, boolean arg13) {
        Intrinsics.checkNotNullParameter(arg9, "challenge");
        Intrinsics.checkNotNullParameter(arg10, "request");
        Intrinsics.checkNotNullParameter(arg12, "step");
        return new StretchOriginalCheckpoint(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static StretchOriginalCheckpoint copy$default(StretchOriginalCheckpoint arg0, int arg1, String arg2, StretchAgentRequest arg3, int arg4, StretchOriginalAgentStep arg5, boolean arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.version;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.challenge;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.request;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.sequence;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.step;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.finished;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchOriginalCheckpoint)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchOriginalCheckpoint)) {
            return 0;
        }

        if(this.version != ((StretchOriginalCheckpoint)arg5).version) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.challenge, ((StretchOriginalCheckpoint)arg5).challenge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.request, ((StretchOriginalCheckpoint)arg5).request)) {
            return 0;
        }

        if(this.sequence != ((StretchOriginalCheckpoint)arg5).sequence) {
            return 0;
        }

        if(this.step != ((StretchOriginalCheckpoint)arg5).step) {
            return 0;
        }

        if(this.finished != ((StretchOriginalCheckpoint)arg5).finished) {
            return 0;
        }

        return 1;
    }

    public final String getChallenge() {
        return this.challenge;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final StretchAgentRequest getRequest() {
        return this.request;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final StretchOriginalAgentStep getStep() {
        return this.step;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return ((((Integer.hashCode(this.version) * 0x1F + this.challenge.hashCode()) * 0x1F + this.request.hashCode()) * 0x1F + Integer.hashCode(this.sequence)) * 0x1F + this.step.hashCode()) * 0x1F + Boolean.hashCode(this.finished);
    }

    public String toString() {
        return "StretchOriginalCheckpoint(version=" + this.version + ", challenge=" + this.challenge + ", request=" + this.request + ", sequence=" + this.sequence + ", step=" + this.step + ", finished=" + this.finished + ")";
    }
}

