package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\t\u00101\u001A\u00020\u0003HÆ\u0003J\t\u00102\u001A\u00020\u0005HÆ\u0003J\t\u00103\u001A\u00020\u0007HÆ\u0003J\t\u00104\u001A\u00020\tHÆ\u0003J\u000F\u00105\u001A\b\u0012\u0004\u0012\u00020\f0\u000BHÆ\u0003J\u000B\u00106\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\u000B\u00107\u001A\u0004\u0018\u00010\u000FHÆ\u0003J\u000B\u00108\u001A\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00109\u001A\u00020\u0013HÆ\u0003J\u000B\u0010:\u001A\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010;\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010+J\u008C\u0001\u0010<\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001A\u00020.2\b\u0010?\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001A\u00020\u0005HÖ\u0001J\t\u0010A\u001A\u00020BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001DR\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001A\u0004\b)\u0010&R\u0015\u0010\u0015\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R\u0011\u0010-\u001A\u00020.8F¢\u0006\u0006\u001A\u0004\b/\u00100¨\u0006C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "", "revision", "", "ownerUid", "", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;", "intentions", "", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateIntent;", "readback", "custody", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustody;", "restorationIdentity", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "executorProbe", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateExecutorProbe;", "verifiedBy", "activeFactor", "<init>", "(JILcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustody;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateExecutorProbe;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Ljava/lang/Integer;)V", "getRevision", "()J", "getOwnerUid", "()I", "getEvidence", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "getPhase", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;", "getIntentions", "()Ljava/util/List;", "getReadback", "getCustody", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustody;", "getRestorationIdentity", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "getExecutorProbe", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateExecutorProbe;", "getVerifiedBy", "getActiveFactor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "permitsPhysicalMutation", "", "getPermitsPhysicalMutation", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JILcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustody;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateExecutorProbe;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "equals", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCandidateRecord {
    public static final int $stable = 8;
    private final Integer activeFactor;
    private final StretchRecoveryCustody custody;
    private final StretchOriginalEvidence evidence;
    private final CandidateExecutorProbe executorProbe;
    private final List intentions;
    private final int ownerUid;
    private final CandidatePhase phase;
    private final StretchOriginalEvidence readback;
    private final StretchRestorationIdentity restorationIdentity;
    private final long revision;
    private final StretchRestorationIdentity verifiedBy;

    static {
    }

    public StretchCandidateRecord(long arg2, int arg4, StretchOriginalEvidence arg5, CandidatePhase arg6, List arg7, StretchOriginalEvidence arg8, StretchRecoveryCustody arg9, StretchRestorationIdentity arg10, CandidateExecutorProbe arg11, StretchRestorationIdentity arg12, Integer arg13) {
        Intrinsics.checkNotNullParameter(arg5, "evidence");
        Intrinsics.checkNotNullParameter(arg6, "phase");
        Intrinsics.checkNotNullParameter(arg7, "intentions");
        Intrinsics.checkNotNullParameter(arg11, "executorProbe");
        super();
        this.revision = arg2;
        this.ownerUid = arg4;
        this.evidence = arg5;
        this.phase = arg6;
        this.intentions = arg7;
        this.readback = arg8;
        this.custody = arg9;
        this.restorationIdentity = arg10;
        this.executorProbe = arg11;
        this.verifiedBy = arg12;
        this.activeFactor = arg13;
    }

    public StretchCandidateRecord(long arg16, int arg18, StretchOriginalEvidence arg19, CandidatePhase arg20, List arg21, StretchOriginalEvidence arg22, StretchRecoveryCustody arg23, StretchRestorationIdentity arg24, CandidateExecutorProbe arg25, StretchRestorationIdentity arg26, Integer arg27, int arg28, DefaultConstructorMarker arg29) {
        StretchCandidateRecord v2_1;
        CandidatePhase v7;
        StretchOriginalEvidence v6;
        int v5;
        long v3;
        Integer v14;
        int v0 = arg28;
        List v8 = (v0 & 16) != 0 ? CollectionsKt.emptyList() : arg21;
        StretchOriginalEvidence v2 = null;
        StretchOriginalEvidence v9 = (v0 & 0x20) != 0 ? v2 : arg22;
        StretchRecoveryCustody v10 = (v0 & 0x40) != 0 ? ((StretchRecoveryCustody)v2) : arg23;
        StretchRestorationIdentity v11 = (v0 & 0x80) != 0 ? ((StretchRestorationIdentity)v2) : arg24;
        CandidateExecutorProbe v12 = (v0 & 0x100) != 0 ? CandidateExecutorProbe.NONE : arg25;
        StretchRestorationIdentity v13 = (v0 & 0x200) != 0 ? ((StretchRestorationIdentity)v2) : arg26;
        if((v0 & 0x400) != 0) {
            v14 = ((Integer)v2);
            v3 = arg16;
            v5 = arg18;
            v6 = arg19;
            v7 = arg20;
            v2_1 = this;
        }
        else {
            v14 = arg27;
            v2_1 = this;
            v3 = arg16;
            v5 = arg18;
            v6 = arg19;
            v7 = arg20;
        }

        this(v3, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14);
    }

    public final long component1() {
        return this.revision;
    }

    public final StretchRestorationIdentity component10() {
        return this.verifiedBy;
    }

    public final Integer component11() {
        return this.activeFactor;
    }

    public final int component2() {
        return this.ownerUid;
    }

    public final StretchOriginalEvidence component3() {
        return this.evidence;
    }

    public final CandidatePhase component4() {
        return this.phase;
    }

    public final List component5() {
        return this.intentions;
    }

    public final StretchOriginalEvidence component6() {
        return this.readback;
    }

    public final StretchRecoveryCustody component7() {
        return this.custody;
    }

    public final StretchRestorationIdentity component8() {
        return this.restorationIdentity;
    }

    public final CandidateExecutorProbe component9() {
        return this.executorProbe;
    }

    public final StretchCandidateRecord copy(long arg14, int arg16, StretchOriginalEvidence arg17, CandidatePhase arg18, List arg19, StretchOriginalEvidence arg20, StretchRecoveryCustody arg21, StretchRestorationIdentity arg22, CandidateExecutorProbe arg23, StretchRestorationIdentity arg24, Integer arg25) {
        Intrinsics.checkNotNullParameter(arg17, "evidence");
        Intrinsics.checkNotNullParameter(arg18, "phase");
        Intrinsics.checkNotNullParameter(arg19, "intentions");
        Intrinsics.checkNotNullParameter(arg23, "executorProbe");
        return new StretchCandidateRecord(arg14, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25);
    }

    public static StretchCandidateRecord copy$default(StretchCandidateRecord arg13, long arg14, int arg16, StretchOriginalEvidence arg17, CandidatePhase arg18, List arg19, StretchOriginalEvidence arg20, StretchRecoveryCustody arg21, StretchRestorationIdentity arg22, CandidateExecutorProbe arg23, StretchRestorationIdentity arg24, Integer arg25, int arg26, Object arg27) {
        int v0 = arg26;
        if((v0 & 1) != 0) {
            arg14 = arg13.revision;
        }

        long v1 = arg14;
        int v3 = (v0 & 2) != 0 ? arg13.ownerUid : arg16;
        StretchOriginalEvidence v4 = (v0 & 4) != 0 ? arg13.evidence : arg17;
        CandidatePhase v5 = (v0 & 8) != 0 ? arg13.phase : arg18;
        List v6 = (v0 & 16) != 0 ? arg13.intentions : arg19;
        StretchOriginalEvidence v7 = (v0 & 0x20) != 0 ? arg13.readback : arg20;
        StretchRecoveryCustody v8 = (v0 & 0x40) != 0 ? arg13.custody : arg21;
        StretchRestorationIdentity v9 = (v0 & 0x80) != 0 ? arg13.restorationIdentity : arg22;
        CandidateExecutorProbe v10 = (v0 & 0x100) != 0 ? arg13.executorProbe : arg23;
        StretchRestorationIdentity v11 = (v0 & 0x200) != 0 ? arg13.verifiedBy : arg24;
        Integer v12 = (v0 & 0x400) != 0 ? arg13.activeFactor : arg25;
        return arg13.copy(v1, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchCandidateRecord)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchCandidateRecord)) {
            return 0;
        }

        if(this.revision != ((StretchCandidateRecord)arg8).revision) {
            return 0;
        }

        if(this.ownerUid != ((StretchCandidateRecord)arg8).ownerUid) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.evidence, ((StretchCandidateRecord)arg8).evidence)) {
            return 0;
        }

        if(this.phase != ((StretchCandidateRecord)arg8).phase) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.intentions, ((StretchCandidateRecord)arg8).intentions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.readback, ((StretchCandidateRecord)arg8).readback)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.custody, ((StretchCandidateRecord)arg8).custody)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.restorationIdentity, ((StretchCandidateRecord)arg8).restorationIdentity)) {
            return 0;
        }

        if(this.executorProbe != ((StretchCandidateRecord)arg8).executorProbe) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verifiedBy, ((StretchCandidateRecord)arg8).verifiedBy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activeFactor, ((StretchCandidateRecord)arg8).activeFactor)) {
            return 0;
        }

        return 1;
    }

    public final Integer getActiveFactor() {
        return this.activeFactor;
    }

    public final StretchRecoveryCustody getCustody() {
        return this.custody;
    }

    public final StretchOriginalEvidence getEvidence() {
        return this.evidence;
    }

    public final CandidateExecutorProbe getExecutorProbe() {
        return this.executorProbe;
    }

    public final List getIntentions() {
        return this.intentions;
    }

    public final int getOwnerUid() {
        return this.ownerUid;
    }

    public final boolean getPermitsPhysicalMutation() {
        return 0;
    }

    public final CandidatePhase getPhase() {
        return this.phase;
    }

    public final StretchOriginalEvidence getReadback() {
        return this.readback;
    }

    public final StretchRestorationIdentity getRestorationIdentity() {
        return this.restorationIdentity;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final StretchRestorationIdentity getVerifiedBy() {
        return this.verifiedBy;
    }

    public int hashCode() {
        int v0 = ((((Long.hashCode(this.revision) * 0x1F + Integer.hashCode(this.ownerUid)) * 0x1F + this.evidence.hashCode()) * 0x1F + this.phase.hashCode()) * 0x1F + this.intentions.hashCode()) * 0x1F;
        StretchOriginalEvidence v1 = this.readback;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchRecoveryCustody v1_2 = this.custody;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchRestorationIdentity v1_3 = this.restorationIdentity;
        v1_1 = v1_3 == null ? 0 : v1_3.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + this.executorProbe.hashCode()) * 0x1F;
        v1_3 = this.verifiedBy;
        v1_1 = v1_3 == null ? 0 : v1_3.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Integer v3 = this.activeFactor;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchCandidateRecord(revision=" + this.revision + ", ownerUid=" + this.ownerUid + ", evidence=" + this.evidence + ", phase=" + this.phase + ", intentions=" + this.intentions + ", readback=" + this.readback + ", custody=" + this.custody + ", restorationIdentity=" + this.restorationIdentity + ", executorProbe=" + this.executorProbe + ", verifiedBy=" + this.verifiedBy + ", activeFactor=" + this.activeFactor + ")";
    }
}

