package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryStep;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0002J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fJ\u0016\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fJ\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0011R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecordCodec;", "", "<init>", "()V", "SCOPE", "", "unsimulated", "", "e", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "valid", "r", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "preserves", "old", "next", "encode", "", "decode", "bytes", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCandidateRecordCodec {
    public static final int $stable = 0;
    public static final StretchCandidateRecordCodec INSTANCE = null;
    public static final String SCOPE = "PHYSICAL_CANDIDATE_UNVERIFIED";

    static {
        StretchCandidateRecordCodec.INSTANCE = new StretchCandidateRecordCodec();
    }

    private StretchCandidateRecordCodec() {
        super();
    }

    public final StretchCandidateRecord decode(byte[] arg22) {
        StretchRestorationIdentity v18;
        CandidateExecutorProbe v1_3;
        StretchRestorationIdentity v16_1;
        StretchRecoveryCustody v15;
        String v1_1;
        String v4;
        Intrinsics.checkNotNullParameter(arg22, "bytes");
        JSONObject v0 = StretchOriginalEvidenceCodec.INSTANCE.parse(new String(arg22, Charsets.UTF_8));
        String v2 = "version";
        String v3 = "Failed requirement.";
        if(StretchOriginalEvidenceCodec.INSTANCE.integer(v0, v2) == 1 && (Intrinsics.areEqual(v0.getString("scope"), "PHYSICAL_CANDIDATE_UNVERIFIED"))) {
            JSONArray v1 = v0.getJSONArray("intentions");
            if(v1.length() <= 3) {
                long v8 = StretchOriginalEvidenceCodec.INSTANCE.long(v0, "revision");
                int v10 = StretchOriginalEvidenceCodec.INSTANCE.integer(v0, "ownerUid");
                StretchOriginalEvidenceCodec v5 = StretchOriginalEvidenceCodec.INSTANCE;
                JSONObject v6 = v0.getJSONObject("evidence");
                Intrinsics.checkNotNullExpressionValue(v6, "getJSONObject(...)");
                StretchOriginalEvidence v11 = v5.fromJson(v6);
                String v5_1 = v0.getString("phase");
                String v6_1 = "getString(...)";
                Intrinsics.checkNotNullExpressionValue(v5_1, v6_1);
                CandidatePhase v12 = CandidatePhase.valueOf(v5_1);
                int v5_2 = v1.length();
                ArrayList v7 = new ArrayList(v5_2);
                int v13 = 0;
                while(v13 < v5_2) {
                    JSONObject v14 = v1.getJSONObject(v13);
                    v4 = v14.getString("id");
                    Intrinsics.checkNotNullExpressionValue(v4, v6_1);
                    JSONArray v16 = v1;
                    v1_1 = v14.getString("step");
                    Intrinsics.checkNotNullExpressionValue(v1_1, v6_1);
                    v7.add(new CandidateIntent(v4, RecoveryStep.valueOf(v1_1)));
                    ++v13;
                    v1 = v16;
                }

                ArrayList v13_1 = v7;
                JSONObject v1_2 = v0.optJSONObject("readback");
                StretchOriginalEvidence v14_1 = v1_2 != null ? StretchOriginalEvidenceCodec.INSTANCE.fromJson(v1_2) : null;
                v1_1 = "custody";
                if(!v0.has(v1_1) || (v0.isNull(v1_1))) {
                    v15 = null;
                }
                else {
                    v1_2 = v0.getJSONObject(v1_1);
                    v5 = StretchOriginalEvidenceCodec.INSTANCE;
                    Intrinsics.checkNotNull(v1_2);
                    if(v5.integer(v1_2, v2) == 1) {
                        v2 = v1_2.getString("boot");
                        Intrinsics.checkNotNullExpressionValue(v2, v6_1);
                        v15 = new StretchRecoveryCustody(v2, StretchOriginalEvidenceCodec.INSTANCE.long(v1_2, "started"), StretchOriginalEvidenceCodec.INSTANCE.long(v1_2, "expires"));
                    }
                    else {
                        throw new IllegalArgumentException(v3.toString());
                    }
                }

                v1_2 = v0.optJSONObject("restorationIdentity");
                v2 = "owner";
                v5_1 = "agent";
                if(v1_2 != null) {
                    v4 = v1_2.getString(v5_1);
                    Intrinsics.checkNotNullExpressionValue(v4, v6_1);
                    v1_1 = v1_2.getString(v2);
                    Intrinsics.checkNotNullExpressionValue(v1_1, v6_1);
                    v16_1 = new StretchRestorationIdentity(v4, v1_1);
                }
                else {
                    v16_1 = null;
                }

                v1_1 = "executorProbe";
                if(v0.has(v1_1)) {
                    v1_1 = v0.getString(v1_1);
                    Intrinsics.checkNotNullExpressionValue(v1_1, v6_1);
                    v1_3 = CandidateExecutorProbe.valueOf(v1_1);
                }
                else {
                    v1_3 = CandidateExecutorProbe.NONE;
                }

                CandidateExecutorProbe v17 = v1_3;
                v1_2 = v0.optJSONObject("verifiedBy");
                if(v1_2 != null) {
                    v5_1 = v1_2.getString(v5_1);
                    Intrinsics.checkNotNullExpressionValue(v5_1, v6_1);
                    v1_1 = v1_2.getString(v2);
                    Intrinsics.checkNotNullExpressionValue(v1_1, v6_1);
                    v18 = new StretchRestorationIdentity(v5_1, v1_1);
                }
                else {
                    v18 = null;
                }

                v1_1 = "activeFactor";
                Integer v19 = !v0.has(v1_1) || (v0.isNull(v1_1)) ? null : Integer.valueOf(StretchOriginalEvidenceCodec.INSTANCE.integer(v0, v1_1));
                StretchCandidateRecord v7_1 = new StretchCandidateRecord(v8, v10, v11, v12, ((List)v13_1), v14_1, v15, v16_1, v17, v18, v19);
                if(this.valid(v7_1)) {
                    return v7_1;
                }

                throw new IllegalArgumentException(v3.toString());
            }
            else {
                throw new IllegalArgumentException(v3.toString());
            }
        }

        throw new IllegalArgumentException(v3.toString());
    }

    public final byte[] encode(StretchCandidateRecord arg10) {
        JSONObject v10_1;
        JSONObject v1_3;
        JSONObject v3_2;
        Object v1_1;
        Intrinsics.checkNotNullParameter(arg10, "r");
        String v0 = "Failed requirement.";
        if(this.valid(arg10)) {
            JSONObject v9 = new JSONObject();
            Integer v1 = arg10.getActiveFactor();
            if(v1 == null) {
                v1_1 = JSONObject.NULL;
            }

            v9 = v9.put("activeFactor", v1);
            String v1_2 = "version";
            v9 = v9.put(v1_2, 1).put("scope", "PHYSICAL_CANDIDATE_UNVERIFIED").put("revision", arg10.getRevision()).put("ownerUid", arg10.getOwnerUid()).put("evidence", StretchOriginalEvidenceCodec.INSTANCE.json(arg10.getEvidence())).put("phase", arg10.getPhase().name()).put("executorProbe", arg10.getExecutorProbe().name());
            JSONArray v3 = new JSONArray();
            Iterator v4 = arg10.getIntentions().iterator();
            while(v4.hasNext()) {
                Object v5 = v4.next();
                v3.put(new JSONObject().put("id", ((CandidateIntent)v5).getOperationId()).put("step", ((CandidateIntent)v5).getStep().name()));
            }

            v9 = v9.put("intentions", v3);
            StretchOriginalEvidence v3_1 = arg10.getReadback();
            if(v3_1 != null) {
                v3_2 = StretchOriginalEvidenceCodec.INSTANCE.json(v3_1);
                if(v3_2 == null) {
                    goto label_63;
                }
            }
            else {
            label_63:
                Object v3_3 = JSONObject.NULL;
            }

            v9 = v9.put("readback", v3_2);
            StretchRecoveryCustody v3_4 = arg10.getCustody();
            if(v3_4 != null) {
                v1_3 = new JSONObject().put(v1_2, 1).put("boot", v3_4.getBootId()).put("started", v3_4.getStartedElapsedMillis()).put("expires", v3_4.getExpiresElapsedMillis());
                if(v1_3 == null) {
                    goto label_81;
                }
            }
            else {
            label_81:
                v1_1 = JSONObject.NULL;
            }

            v9 = v9.put("custody", v1_3);
            StretchRestorationIdentity v1_4 = arg10.getRestorationIdentity();
            String v2 = "owner";
            String v3_5 = "agent";
            if(v1_4 != null) {
                v1_3 = new JSONObject().put(v3_5, v1_4.getAgentGeneration()).put(v2, v1_4.getOwnerGeneration());
                if(v1_3 == null) {
                    goto label_95;
                }
            }
            else {
            label_95:
                v1_1 = JSONObject.NULL;
            }

            v9 = v9.put("restorationIdentity", v1_3);
            StretchRestorationIdentity v10 = arg10.getVerifiedBy();
            if(v10 != null) {
                v10_1 = new JSONObject().put(v3_5, v10.getAgentGeneration()).put(v2, v10.getOwnerGeneration());
                if(v10_1 == null) {
                    goto label_107;
                }
            }
            else {
            label_107:
                Object v10_2 = JSONObject.NULL;
            }

            String v9_1 = v9.put("verifiedBy", v10_1).toString();
            Intrinsics.checkNotNullExpressionValue(v9_1, "toString(...)");
            byte[] v9_2 = v9_1.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v9_2, "getBytes(...)");
            if(v9_2.length <= 0x2000) {
                return v9_2;
            }

            throw new IllegalArgumentException(v0.toString());
        }

        throw new IllegalArgumentException(v0.toString());
    }

    public final boolean preserves(StretchCandidateRecord arg18, StretchCandidateRecord arg19) {
        CandidatePhase[] v1;
        StretchCandidateRecord v0 = arg19;
        StretchCandidateRecord v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "old");
        Intrinsics.checkNotNullParameter(v0, "next");
        if(Long.compare(v0.getRevision(), v2.getRevision() + 1) == 0) {
            if(v0.getOwnerUid() != v2.getOwnerUid()) {
            }
            else {
                if((Intrinsics.areEqual(v2.getEvidence(), v0.getEvidence())) && !Intrinsics.areEqual(v2.getCustody(), v0.getCustody())) {
                    return 0;
                }

                int v4 = 2;
                if(!Intrinsics.areEqual(v2.getEvidence(), v0.getEvidence())) {
                    v1 = new CandidatePhase[v4];
                    v1[0] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                    v1[1] = CandidatePhase.RESTORED_VERIFIED;
                    if((SetsKt.setOf(((Object[])v1)).contains(v2.getPhase())) && v0.getPhase() == CandidatePhase.CAPTURED && (v0.getIntentions().isEmpty()) && v0.getExecutorProbe() == CandidateExecutorProbe.NONE && v0.getReadback() == null && v0.getRestorationIdentity() == null && v0.getVerifiedBy() == null && v0.getActiveFactor() == null && !Intrinsics.areEqual(v2.getEvidence().getSnapshot().getSessionId(), v0.getEvidence().getSnapshot().getSessionId())) {
                        return 1;
                    }

                    return 0;
                }

                if(!Intrinsics.areEqual(v2.getActiveFactor(), v0.getActiveFactor()) && (v2.getActiveFactor() != null || v0.getPhase() != CandidatePhase.ACTIVE || v2.getPhase() != CandidatePhase.INTENT_RESERVED)) {
                    return 0;
                }

                if(v0.getPhase() == CandidatePhase.ACTIVE) {
                    v1 = new CandidatePhase[v4];
                    v1[0] = CandidatePhase.INTENT_RESERVED;
                    v1[1] = CandidatePhase.ACTIVE;
                    if(!SetsKt.setOf(((Object[])v1)).contains(v2.getPhase())) {
                        return 0;
                    }
                }

                if(v2.getPhase() == CandidatePhase.ACTIVE) {
                    v1 = new CandidatePhase[v4];
                    v1[0] = CandidatePhase.ACTIVE;
                    v1[1] = CandidatePhase.RESTORE_PENDING;
                    if(!SetsKt.setOf(((Object[])v1)).contains(v0.getPhase())) {
                        return 0;
                    }
                }

                if(!Intrinsics.areEqual(v2.getRestorationIdentity(), v0.getRestorationIdentity()) && ((v2.getIntentions().isEmpty()) && v2.getExecutorProbe() == CandidateExecutorProbe.NONE || (v2.getReadback() != null || v0.getRestorationIdentity() == null) || v0.getPhase() != CandidatePhase.RESTORE_PENDING)) {
                    return 0;
                }

                if(v2.getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                    return Intrinsics.areEqual(v0, StretchCandidateRecord.copy$default(v2, v0.getRevision(), 0, null, null, null, null, null, null, null, null, null, 0x7FE, null));
                }

                if(!Intrinsics.areEqual(arg18.getVerifiedBy(), v0.getVerifiedBy()) && v0.getPhase() != CandidatePhase.RESTORED_VERIFIED) {
                    return 0;
                }

                int v6 = 3;
                if(v0.getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                    v1 = new CandidatePhase[v6];
                    v1[0] = CandidatePhase.RESTORE_PENDING;
                    v1[1] = CandidatePhase.RESTORE_PARTIAL;
                    v1[v4] = CandidatePhase.RESTORE_UNVERIFIED;
                    if(!SetsKt.setOf(((Object[])v1)).contains(arg18.getPhase())) {
                        return 0;
                    }
                }

                if(v0.getExecutorProbe().ordinal() < arg18.getExecutorProbe().ordinal()) {
                    return 0;
                }

                if(v0.getExecutorProbe().ordinal() > arg18.getExecutorProbe().ordinal() + 1) {
                    return 0;
                }

                if(v0.getExecutorProbe() != arg18.getExecutorProbe() && (arg18.getPhase() != CandidatePhase.CAPTURED || v0.getPhase() != CandidatePhase.CAPTURED || !arg18.getIntentions().isEmpty())) {
                    return 0;
                }

                if(!Intrinsics.areEqual(CollectionsKt.take(v0.getIntentions(), arg18.getIntentions().size()), arg18.getIntentions())) {
                    return 0;
                }

                if(arg18.getReadback() != null && !Intrinsics.areEqual(arg18.getReadback(), v0.getReadback())) {
                    return 0;
                }

                if(v0.getPhase() == CandidatePhase.CAPTURED && arg18.getPhase() != CandidatePhase.CAPTURED) {
                    return 0;
                }

                if(v0.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                    v1 = new CandidatePhase[v4];
                    v1[0] = CandidatePhase.CAPTURED;
                    v1[1] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                    if(!SetsKt.setOf(((Object[])v1)).contains(arg18.getPhase())) {
                        return 0;
                    }
                }

                if(arg18.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                    if(v0.getPhase() == arg18.getPhase()) {
                        return 1;
                    }

                    return 0;
                }

                v1 = new CandidatePhase[4];
                v1[0] = CandidatePhase.RESTORE_PENDING;
                v1[1] = CandidatePhase.EXECUTION_UNKNOWN;
                v1[v4] = CandidatePhase.RESTORE_PARTIAL;
                v1[v6] = CandidatePhase.RESTORE_UNVERIFIED;
                if((SetsKt.setOf(((Object[])v1)).contains(arg18.getPhase())) && v0.getPhase() == CandidatePhase.INTENT_RESERVED) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    private final boolean unsimulated(StretchOriginalEvidence arg6) {
        StretchOriginalDisplayState v5 = arg6.getSnapshot().getOriginal();
        if(arg6.getSnapshot().getCaptureSource() == RecoverySource.INFORMATIVE_BACKEND) {
            List v5_1 = CollectionsKt.listOf(new RecoveryDatum[]{v5.getLogicalIdentity(), v5.getPhysicalIdentity(), v5.getLogicalSize(), v5.getSizeOverride(), v5.getScaling(), v5.getDensity(), v5.getRotation(), v5.getReferenceSize(), v5.getProjection(), arg6.getScaling(), arg6.getSizeOverride()});
            if(!(v5_1 instanceof Collection) || !v5_1.isEmpty()) {
                Iterator v5_2 = ((Iterable)v5_1).iterator();
                do {
                    if(v5_2.hasNext()) {
                        if(v5_2.next().getSource() != RecoverySource.SIMULATION) {
                            continue;
                        }

                        return 0;
                    }

                    return 1;
                }
                while(true);

                return 0;
            }
            else {
            }

            return 1;
        }

        return 0;
    }

    public final boolean valid(StretchCandidateRecord arg13) {
        String v1_2;
        Iterator v12_2;
        Intrinsics.checkNotNullParameter(arg13, "r");
        StretchRecoverySnapshot v0 = arg13.getEvidence().getSnapshot();
        StretchOriginalDisplayState v1 = v0.getOriginal();
        if(Long.compare(arg13.getRevision(), 1) >= 0 && arg13.getOwnerUid() >= 10000 && (StretchAgentProtocolKt.validAgentText(v0.getSessionId())) && v0.getSchemaVersion() == 1 && v0.getAndroidApi() >= 26 && v0.getCaptureSource() == RecoverySource.INFORMATIVE_BACKEND) {
            Object v2 = v1.getLogicalIdentity().getValue();
            if(v2 != null && ((StretchDisplayIdentity)v2).getLogicalId() == 0) {
                int v5 = 3;
                if(arg13.getIntentions().size() > v5) {
                }
                else if(this.unsimulated(arg13.getEvidence())) {
                    StretchOriginalEvidence v12 = arg13.getReadback();
                    if(v12 != null && (StretchCandidateRecordCodec.INSTANCE.unsimulated(v12) ^ 1) == 1) {
                        return 0;
                    }

                    List v12_1 = arg13.getIntentions();
                    if(!(v12_1 instanceof Collection) || !v12_1.isEmpty()) {
                        v12_2 = ((Iterable)v12_1).iterator();
                        do {
                            if(v12_2.hasNext()) {
                                if(StretchAgentProtocolKt.validAgentText(v12_2.next().getOperationId())) {
                                    continue;
                                }

                                return 0;
                            }

                            goto label_60;
                        }
                        while(true);

                        return 0;
                    }
                    else {
                    }

                label_60:
                    v12_1 = arg13.getIntentions();
                    int v6 = 10;
                    ArrayList v2_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v12_1), v6));
                    v12_2 = ((Iterable)v12_1).iterator();
                    while(v12_2.hasNext()) {
                        ((Collection)v2_1).add(v12_2.next().getOperationId());
                    }

                    if(CollectionsKt.distinct(((Iterable)v2_1)).size() != arg13.getIntentions().size()) {
                        return 0;
                    }

                    v12_1 = arg13.getIntentions();
                    v2_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v12_1), v6));
                    v12_2 = ((Iterable)v12_1).iterator();
                    while(v12_2.hasNext()) {
                        ((Collection)v2_1).add(v12_2.next().getStep());
                    }

                    if(CollectionsKt.distinct(((Iterable)v2_1)).size() != arg13.getIntentions().size()) {
                        return 0;
                    }

                    int v12_3 = 2;
                    CandidatePhase[] v2_2 = new CandidatePhase[v12_3];
                    v2_2[0] = CandidatePhase.CAPTURED;
                    v2_2[1] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                    if((SetsKt.setOf(((Object[])v2_2)).contains(arg13.getPhase())) && !arg13.getIntentions().isEmpty()) {
                        return 0;
                    }

                    if(arg13.getPhase() == CandidatePhase.INTENT_RESERVED && (arg13.getIntentions().isEmpty())) {
                        return 0;
                    }

                    if(arg13.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION && arg13.getExecutorProbe() != CandidateExecutorProbe.NONE) {
                        return 0;
                    }

                    if(arg13.getRestorationIdentity() != null) {
                        if(!arg13.getIntentions().isEmpty() || arg13.getExecutorProbe() != CandidateExecutorProbe.NONE) {
                            v2_2 = new CandidatePhase[v12_3];
                            v2_2[0] = CandidatePhase.CAPTURED;
                            v2_2[1] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                            if(SetsKt.setOf(((Object[])v2_2)).contains(arg13.getPhase())) {
                                return 0;
                            }

                            goto label_140;
                        }

                        return 0;
                    }

                label_140:
                    if(arg13.getActiveFactor() != null) {
                        if(new IntRange(101, 0xC7).contains(arg13.getActiveFactor().intValue())) {
                            v2_2 = new CandidatePhase[v5];
                            v2_2[0] = CandidatePhase.CAPTURED;
                            v2_2[1] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                            v2_2[v12_3] = CandidatePhase.INTENT_RESERVED;
                            if(SetsKt.setOf(((Object[])v2_2)).contains(arg13.getPhase())) {
                                return 0;
                            }

                            goto label_162;
                        }

                        return 0;
                    }

                label_162:
                    if(arg13.getPhase() == CandidatePhase.ACTIVE) {
                        if(arg13.getActiveFactor() != null && arg13.getExecutorProbe() == CandidateExecutorProbe.MATCHED && arg13.getReadback() == null && arg13.getRestorationIdentity() == null) {
                            v12_1 = arg13.getIntentions();
                            EnumEntries v2_3 = RecoveryStep.getEntries();
                            ArrayList v5_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_3), v6));
                            Iterator v2_4 = ((Iterable)v2_3).iterator();
                            while(v2_4.hasNext()) {
                                Object v6_1 = v2_4.next();
                                ((Collection)v5_1).add(new CandidateIntent("apply-" + arg13.getActiveFactor() + "-" + ((RecoveryStep)v6_1).name(), ((RecoveryStep)v6_1)));
                            }

                            if(!Intrinsics.areEqual(v12_1, v5_1)) {
                                return 0;
                            }

                            goto label_200;
                        }

                        return 0;
                    }

                label_200:
                    v12 = arg13.getReadback();
                    if(v12 != null) {
                        if((Intrinsics.areEqual(v12.getSnapshot().getSessionId(), v0.getSessionId())) && (Intrinsics.areEqual(v12.getSnapshot().getOriginal().getPhysicalIdentity(), v1.getPhysicalIdentity()))) {
                            String v0_1 = v12.getAgentGeneration();
                            StretchRestorationIdentity v1_1 = arg13.getRestorationIdentity();
                            if(v1_1 != null) {
                                v1_2 = v1_1.getAgentGeneration();
                                if(v1_2 == null) {
                                    goto label_218;
                                }
                            }
                            else {
                            label_218:
                                v1_2 = arg13.getEvidence().getAgentGeneration();
                            }

                            if(!Intrinsics.areEqual(v0_1, v1_2)) {
                                return 0;
                            }

                            v0_1 = v12.getOwnerGeneration();
                            v1_1 = arg13.getRestorationIdentity();
                            if(v1_1 != null) {
                                v1_2 = v1_1.getOwnerGeneration();
                                if(v1_2 == null) {
                                    goto label_227;
                                }
                            }
                            else {
                            label_227:
                                v1_2 = arg13.getEvidence().getOwnerGeneration();
                            }

                            if(Intrinsics.areEqual(v0_1, v1_2)) {
                                goto label_232;
                            }
                        }

                        return 0;
                    }

                label_232:
                    int v0_2 = arg13.getPhase() == CandidatePhase.RESTORED_VERIFIED ? 1 : 0;
                    int v1_3 = arg13.getVerifiedBy() != null ? 1 : 0;
                    if(v0_2 != v1_3) {
                        return 0;
                    }

                    if(arg13.getPhase() == CandidatePhase.RESTORED_VERIFIED && (v12 == null || (arg13.getIntentions().isEmpty()) && arg13.getExecutorProbe() == CandidateExecutorProbe.NONE || !StretchPhysicalPair.Companion.matchesRestored$app(arg13.getEvidence(), v12, arg13.getRestorationIdentity()))) {
                        return 0;
                    }

                    return 1;
                }
            }
        }

        return 0;
    }
}

