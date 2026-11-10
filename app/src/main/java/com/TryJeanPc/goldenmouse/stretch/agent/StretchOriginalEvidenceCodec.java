package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatumState;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0007J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\u0007J\u0016\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0007J\u0016\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0007J\u0018\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0007H\u0002J\u0018\u0010\u0013\u001A\n \u0014*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u0010\u0010\u0013\u001A\u00020\u00162\u0006\u0010\u000F\u001A\u00020\rH\u0002J\u0018\u0010\u0017\u001A\n \u0014*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0010\u0010\u0017\u001A\u00020\u00192\u0006\u0010\u000F\u001A\u00020\rH\u0002J\u0018\u0010\u001A\u001A\n \u0014*\u0004\u0018\u00010\r0\r2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002J\u0010\u0010\u001A\u001A\u00020\u001C2\u0006\u0010\u000F\u001A\u00020\rH\u0002J\u0010\u0010\u001D\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\u001FH\u0002J\u0010\u0010\u001D\u001A\u00020\u001F2\u0006\u0010\u000F\u001A\u00020\rH\u0002J0\u0010 \u001A\u00020\r\"\u0004\b\u0000\u0010!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u0002H!0#2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00010%H\u0002J0\u0010 \u001A\b\u0012\u0004\u0012\u0002H!0#\"\u0004\b\u0000\u0010!2\u0006\u0010\u000F\u001A\u00020\r2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H!0%H\u0002J\u0010\u0010&\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\'H\u0002J\u0010\u0010&\u001A\u00020\'2\u0006\u0010\u000F\u001A\u00020\rH\u0002J\u000E\u0010(\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010)\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidenceCodec;", "", "<init>", "()V", "MAX_BYTES", "", "encode", "", "e", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "decode", "text", "parse", "Lorg/json/JSONObject;", "integer", "j", "key", "long", "", "size", "kotlin.jvm.PlatformType", "s", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "rect", "r", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "projection", "p", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "compositor", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "datum", "T", "d", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "value", "Lkotlin/Function1;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "json", "fromJson", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalEvidenceCodec {
    public static final int $stable = 0;
    public static final StretchOriginalEvidenceCodec INSTANCE = null;
    public static final int MAX_BYTES = 0x2000;

    static {
        StretchOriginalEvidenceCodec.INSTANCE = new StretchOriginalEvidenceCodec();
    }

    private StretchOriginalEvidenceCodec() {
        super();
    }

    public static final JSONObject access$projection(StretchOriginalEvidenceCodec arg0, StretchFullProjection arg1) {
        return arg0.projection(arg1);
    }

    public static final JSONObject access$size(StretchOriginalEvidenceCodec arg0, StretchSize arg1) {
        return arg0.size(arg1);
    }

    public static final int access$snapshot$number(Object arg0) {
        return StretchOriginalEvidenceCodec.snapshot$number(arg0);
    }

    private final StretchCompositorRead compositor(JSONObject arg10) {
        StretchCompositorState v1_1;
        if(this.integer(arg10, "version") == 1) {
            String v0 = "stable";
            if((arg10.get(v0) instanceof Boolean)) {
                String v1 = "state";
                if(arg10.isNull(v1)) {
                    v1_1 = null;
                }
                else {
                    JSONObject v1_2 = arg10.getJSONObject(v1);
                    StretchOriginalEvidenceCodec v3 = StretchOriginalEvidenceCodec.INSTANCE;
                    Intrinsics.checkNotNull(v1_2);
                    String v4 = v3.text(v1_2, "physical");
                    JSONObject v5 = v1_2.getJSONObject("projection");
                    Intrinsics.checkNotNullExpressionValue(v5, "getJSONObject(...)");
                    StretchFullProjection v5_1 = v3.projection(v5);
                    JSONObject v7 = v1_2.getJSONObject("display");
                    Intrinsics.checkNotNullExpressionValue(v7, "getJSONObject(...)");
                    v1_1 = new StretchCompositorState(v4, v5_1, v3.size(v7), v3.integer(v1_2, "effective"), v3.integer(v1_2, "install"));
                }

                return new StretchCompositorRead(CompositorReadCode.valueOf(this.text(arg10, "code")), v1_1, arg10.getBoolean(v0));
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final JSONObject compositor(StretchCompositorRead arg5) {
        Object v5_2;
        JSONObject v4 = new JSONObject().put("version", 1).put("code", arg5.getCode().name()).put("stable", arg5.getStable());
        StretchCompositorState v5 = arg5.getState();
        if(v5 != null) {
            JSONObject v5_1 = new JSONObject().put("physical", v5.getPhysicalIdentity()).put("projection", StretchOriginalEvidenceCodec.INSTANCE.projection(v5.getProjection())).put("display", StretchOriginalEvidenceCodec.INSTANCE.size(v5.getDisplaySize())).put("effective", v5.getEffectiveOrientation()).put("install", v5.getInstallOrientation());
            if(v5_1 == null) {
                goto label_35;
            }
        }
        else {
        label_35:
            v5_2 = JSONObject.NULL;
        }

        v4 = v4.put("state", v5_2);
        Intrinsics.checkNotNullExpressionValue(v4, "put(...)");
        return v4;
    }

    private final RecoveryDatum datum(JSONObject arg5, Function1 arg6) {
        Object v5;
        RecoveryDatumState v0 = RecoveryDatumState.valueOf(this.text(arg5, "state"));
        RecoverySource v4 = RecoverySource.valueOf(this.text(arg5, "source"));
        String v1 = "value";
        boolean v2 = arg5.has(v1);
        boolean v3 = v0 == RecoveryDatumState.KNOWN ? true : false;
        if(v2 == v3) {
            if(v0 == RecoveryDatumState.KNOWN) {
                v5 = arg5.get(v1);
                Intrinsics.checkNotNullExpressionValue(v5, "get(...)");
                v5 = arg6.invoke(v5);
            }
            else {
                v5 = null;
            }

            return new RecoveryDatum(v0, v4, v5);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final JSONObject datum(RecoveryDatum arg3, Function1 arg4) {
        JSONObject v2 = new JSONObject().put("state", arg3.getState().name()).put("source", arg3.getSource().name());
        Object v3 = arg3.getValue();
        if(v3 != null) {
            v2.put("value", arg4.invoke(v3));
        }

        Intrinsics.checkNotNullExpressionValue(v2, "also(...)");
        return v2;
    }

    public final StretchOriginalEvidence decode(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "text");
        return this.fromJson(this.parse(arg2));
    }

    public final String encode(StretchOriginalEvidence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "e");
        String v1 = this.json(arg2).toString();
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        byte[] v2 = v1.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
        if(v2.length <= 0x2000) {
            return v1;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final StretchOriginalEvidence fromJson(JSONObject arg23) {
        StretchCompositorRead v16;
        OriginalViewport v6;
        StretchOriginalEvidenceCodec v0 = this;
        JSONObject v1 = arg23;
        Intrinsics.checkNotNullParameter(v1, "j");
        String v3 = "Failed requirement.";
        int v4 = 1;
        if(v0.integer(v1, "version") == 1) {
            JSONObject v2 = v1.optJSONObject("viewport");
            String v5 = "getJSONObject(...)";
            if(v2 != null) {
                StretchOriginalEvidenceCodec v7 = StretchOriginalEvidenceCodec.INSTANCE;
                String v8 = v7.text(v2, "physical");
                JSONObject v9 = v2.getJSONObject("projection");
                Intrinsics.checkNotNullExpressionValue(v9, v5);
                StretchFullProjection v9_1 = v7.projection(v9);
                v2 = v2.getJSONObject("device");
                Intrinsics.checkNotNullExpressionValue(v2, v5);
                v6 = new OriginalViewport(v8, v9_1, v7.size(v2));
            }
            else {
                v6 = null;
            }

            v2 = v1.getJSONObject("snapshot");
            Intrinsics.checkNotNullExpressionValue(v2, v5);
            StretchRecoverySnapshot v8_1 = v0.snapshot(v2);
            String v9_2 = v0.text(v1, "agent");
            String v10 = v0.text(v1, "owner");
            OriginalViewportRead v11 = new OriginalViewportRead(OriginalReadCode.valueOf(v0.text(v1, "viewportCode")), v6);
            v2 = v1.getJSONObject("scaling");
            Intrinsics.checkNotNullExpressionValue(v2, v5);
            RecoveryDatum v12 = v0.datum(v2, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda12());
            v2 = v1.getJSONObject("override");
            Intrinsics.checkNotNullExpressionValue(v2, v5);
            RecoveryDatum v13 = v0.datum(v2, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda13());
            OriginalReadCode v14 = OriginalReadCode.valueOf(v0.text(v1, "windowRead"));
            boolean v15 = v1.getBoolean("stable");
            String v2_1 = "compositor";
            if(v1.has(v2_1)) {
                v2 = v1.getJSONObject(v2_1);
                Intrinsics.checkNotNullExpressionValue(v2, v5);
                v16 = v0.compositor(v2);
            }
            else {
                v16 = new StretchCompositorRead(null, null, false, 7, null);
            }

            StretchOriginalEvidence v7_1 = new StretchOriginalEvidence(v8_1, v9_2, v10, v11, v12, v13, v14, v15, v16);
            if((Intrinsics.areEqual(v7_1.getSnapshotDigest(), v0.text(v1, "digest"))) && (StretchAgentProtocolKt.validAgentText(v7_1.getAgentGeneration())) && (StretchAgentProtocolKt.validAgentText(v7_1.getOwnerGeneration()))) {
                int v1_1 = v6 != null ? 1 : 0;
                if(v7_1.getViewport().getCode() == OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY) {
                }
                else {
                    v4 = 0;
                }

                if(v1_1 == v4) {
                    StretchCompositorState v0_1 = v7_1.getCompositor().getState();
                    if(v0_1 != null) {
                        if(Intrinsics.areEqual(v0_1.getPhysicalIdentity(), v7_1.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
                        }
                        else {
                            throw new IllegalArgumentException(v3.toString());
                        }
                    }

                    if(v7_1.getCompositor().getStable()) {
                        if(v7_1.getStable()) {
                        }
                        else {
                            throw new IllegalArgumentException(v3.toString());
                        }
                    }

                    if(v6 != null) {
                        if(Intrinsics.areEqual(v6.getPhysicalIdentity(), v7_1.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
                            int v0_2 = v6.getProjection().getRotation();
                            if(v0_2 >= 0 && v0_2 < 4) {
                                if(new GoldenStretchGeometryCalculator().validateRectangle(v6.getProjection().getDestination(), v6.getDeviceSize()) == null) {
                                    if(v6.getProjection().getSource().getLeft() >= 0 && v6.getProjection().getSource().getTop() >= 0 && v6.getProjection().getSource().getRight() > v6.getProjection().getSource().getLeft() && v6.getProjection().getSource().getBottom() > v6.getProjection().getSource().getTop()) {
                                        return v7_1;
                                    }

                                    throw new IllegalArgumentException(v3.toString());
                                }
                                else {
                                    throw new IllegalArgumentException(v3.toString());
                                }
                            }
                        }

                        throw new IllegalArgumentException(v3.toString());
                    }

                    return v7_1;
                }

                throw new IllegalArgumentException(v3.toString());
            }

            throw new IllegalArgumentException(v3.toString());
        }

        throw new IllegalArgumentException(v3.toString());
    }

    static final StretchScaling fromJson$lambda$30(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchScaling.valueOf(((String)arg1));
    }

    static final StretchSize fromJson$lambda$31(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchOriginalEvidenceCodec.INSTANCE.size(((JSONObject)arg1));
    }

    public final int integer(JSONObject arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "j");
        Intrinsics.checkNotNullParameter(arg3, "key");
        return Math.toIntExact(this.long(arg2, arg3));
    }

    public final JSONObject json(StretchOriginalEvidence arg7) {
        Object v1_2;
        Intrinsics.checkNotNullParameter(arg7, "e");
        JSONObject v0 = new JSONObject().put("version", 1).put("snapshot", this.snapshot(arg7.getSnapshot())).put("agent", arg7.getAgentGeneration()).put("owner", arg7.getOwnerGeneration()).put("digest", arg7.getSnapshotDigest()).put("viewportCode", arg7.getViewport().getCode().name());
        OriginalViewport v1 = arg7.getViewport().getViewport();
        if(v1 != null) {
            JSONObject v1_1 = new JSONObject().put("physical", v1.getPhysicalIdentity()).put("projection", StretchOriginalEvidenceCodec.INSTANCE.projection(v1.getProjection())).put("device", StretchOriginalEvidenceCodec.INSTANCE.size(v1.getDeviceSize()));
            if(v1_1 == null) {
                goto label_43;
            }
        }
        else {
        label_43:
            v1_2 = JSONObject.NULL;
        }

        JSONObject v6 = v0.put("viewport", v1_2).put("scaling", this.datum(arg7.getScaling(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda14())).put("override", this.datum(arg7.getSizeOverride(), new StretchOriginalEvidenceCodec$json$3(this))).put("windowRead", arg7.getWindowRead().name()).put("stable", arg7.getStable()).put("compositor", this.compositor(arg7.getCompositor()));
        Intrinsics.checkNotNullExpressionValue(v6, "put(...)");
        return v6;
    }

    static final Object json$lambda$28(StretchScaling arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.name();
    }

    public final long long(JSONObject arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "j");
        Intrinsics.checkNotNullParameter(arg2, "key");
        Object v0 = arg1.get(arg2);
        if(!(v0 instanceof Integer)) {
            if((v0 instanceof Long)) {
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Number");
        return ((Number)v0).longValue();
    }

    public final JSONObject parse(String arg11) {
        Intrinsics.checkNotNullParameter(arg11, "text");
        byte[] v10 = arg11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v10, "getBytes(...)");
        String v1 = "Failed requirement.";
        if(v10.length <= 0x2000) {
            int v10_1 = arg11.length();
            int v2 = 0;
            int v3 = 0;
            int v4 = 0;
            int v5 = 0;
            while(v2 < v10_1) {
                int v6 = arg11.charAt(v2);
                int v7 = 34;
                if(v4 != 0) {
                    if(v5 != 0) {
                        v5 = 0;
                    }
                    else if(v6 == 92) {
                        v5 = 1;
                    }
                    else if(v6 == v7) {
                        v4 = 0;
                    }
                }
                else if(v6 != v7) {
                    if(v6 != 91) {
                        if(v6 != 93) {
                            if(v6 == 0x7B) {
                                goto label_48;
                            }
                            else if(v6 != 0x7D) {
                                goto label_57;
                            }
                        }

                        --v3;
                        if(v3 >= 0) {
                            goto label_57;
                        }

                        throw new IllegalArgumentException(v1.toString());
                    }

                label_48:
                    ++v3;
                    if(v3 <= 12) {
                        goto label_57;
                    }

                    throw new IllegalArgumentException(v1.toString());
                }
                else {
                    v4 = 1;
                }

            label_57:
                ++v2;
            }

            if(v3 == 0 && v4 == 0) {
                return new JSONObject(arg11);
            }

            throw new IllegalArgumentException(v1.toString());
        }

        throw new IllegalArgumentException(v1.toString());
    }

    private final JSONObject projection(StretchFullProjection arg4) {
        return new JSONObject().put("source", this.rect(arg4.getSource())).put("destination", this.rect(arg4.getDestination())).put("rotation", arg4.getRotation());
    }

    private final StretchFullProjection projection(JSONObject arg5) {
        JSONObject v1 = arg5.getJSONObject("source");
        Intrinsics.checkNotNullExpressionValue(v1, "getJSONObject(...)");
        StretchRect v1_1 = this.rect(v1);
        JSONObject v3 = arg5.getJSONObject("destination");
        Intrinsics.checkNotNullExpressionValue(v3, "getJSONObject(...)");
        StretchFullProjection v0 = new StretchFullProjection(v1_1, this.rect(v3), this.integer(arg5, "rotation"));
        int v4 = v0.getRotation();
        if(v4 >= 0 && v4 < 4) {
            return v0;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final StretchRect rect(JSONObject arg6) {
        StretchRect v0 = new StretchRect(this.integer(arg6, "l"), this.integer(arg6, "t"), this.integer(arg6, "r"), this.integer(arg6, "b"));
        if(v0.getLeft() >= 0 && v0.getTop() >= 0 && v0.getRight() > v0.getLeft() && v0.getBottom() > v0.getTop()) {
            return v0;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final JSONObject rect(StretchRect arg3) {
        return new JSONObject().put("l", arg3.getLeft()).put("t", arg3.getTop()).put("r", arg3.getRight()).put("b", arg3.getBottom());
    }

    private final JSONObject size(StretchSize arg3) {
        return new JSONObject().put("w", arg3.getWidth()).put("h", arg3.getHeight());
    }

    private final StretchSize size(JSONObject arg4) {
        StretchSize v0 = new StretchSize(this.integer(arg4, "w"), this.integer(arg4, "h"));
        if(v0.getWidth() > 0 && v0.getHeight() > 0) {
            return v0;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final StretchRecoverySnapshot snapshot(JSONObject arg15) {
        String v1 = "Failed requirement.";
        int v2 = 1;
        if(this.integer(arg15, "version") != 1) {
            goto label_126;
        }

        JSONObject v0 = arg15.getJSONObject("original");
        JSONObject v4 = v0.getJSONObject("logicalIdentity");
        Intrinsics.checkNotNullExpressionValue(v4, "getJSONObject(...)");
        RecoveryDatum v4_1 = this.datum(v4, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda0());
        JSONObject v6 = v0.getJSONObject("physicalIdentity");
        Intrinsics.checkNotNullExpressionValue(v6, "getJSONObject(...)");
        RecoveryDatum v6_1 = this.datum(v6, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda6());
        JSONObject v7 = v0.getJSONObject("logicalSize");
        Intrinsics.checkNotNullExpressionValue(v7, "getJSONObject(...)");
        RecoveryDatum v7_1 = this.datum(v7, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda7());
        JSONObject v8 = v0.getJSONObject("override");
        Intrinsics.checkNotNullExpressionValue(v8, "getJSONObject(...)");
        RecoveryDatum v8_1 = this.datum(v8, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda8());
        JSONObject v9 = v0.getJSONObject("scaling");
        Intrinsics.checkNotNullExpressionValue(v9, "getJSONObject(...)");
        RecoveryDatum v9_1 = this.datum(v9, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda9());
        JSONObject v10 = v0.getJSONObject("density");
        Intrinsics.checkNotNullExpressionValue(v10, "getJSONObject(...)");
        RecoveryDatum v10_1 = this.datum(v10, StretchOriginalEvidenceCodec$snapshot$original$15.INSTANCE);
        JSONObject v11 = v0.getJSONObject("rotation");
        Intrinsics.checkNotNullExpressionValue(v11, "getJSONObject(...)");
        RecoveryDatum v11_1 = this.datum(v11, StretchOriginalEvidenceCodec$snapshot$original$16.INSTANCE);
        JSONObject v12 = v0.getJSONObject("reference");
        Intrinsics.checkNotNullExpressionValue(v12, "getJSONObject(...)");
        RecoveryDatum v12_1 = this.datum(v12, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda10());
        v0 = v0.getJSONObject("projection");
        Intrinsics.checkNotNullExpressionValue(v0, "getJSONObject(...)");
        StretchOriginalDisplayState v3 = new StretchOriginalDisplayState(v4_1, v6_1, v7_1, v8_1, v9_1, v10_1, v11_1, v12_1, this.datum(v0, new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda11()));
        Object v0_1 = v3.getLogicalIdentity().getValue();
        if(v0_1 == null || ((StretchDisplayIdentity)v0_1).getLogicalId() == 0) {
            v2 = 0;
        }

        if(v2 != 0) {
            goto label_122;
        }

        v0_1 = v3.getRotation().getValue();
        if(v0_1 != null) {
            int v0_2 = ((Number)v0_1).intValue();
            if(v0_2 >= 0 && v0_2 < 4) {
                goto label_85;
            }
        }
        else {
        label_85:
            v0_1 = v3.getDensity().getValue();
            if(v0_1 != null) {
                if(((Number)v0_1).intValue() > 0) {
                }
                else {
                    goto label_91;
                }
            }

            goto label_95;
        }

    label_91:
        throw new IllegalArgumentException(v1.toString());
    label_95:
        StretchRecoverySnapshot v3_1 = new StretchRecoverySnapshot(1, this.text(arg15, "session"), this.integer(arg15, "api"), StretchBackendType.valueOf(this.text(arg15, "backend")), this.long(arg15, "wall"), RecoverySource.valueOf(this.text(arg15, "source")), v3);
        if((StretchAgentProtocolKt.validAgentText(v3_1.getSessionId())) && v3_1.getAndroidApi() >= 26) {
            return v3_1;
        }

        throw new IllegalArgumentException(v1.toString());
    label_122:
        throw new IllegalArgumentException(v1.toString());
    label_126:
        throw new IllegalArgumentException(v1.toString());
    }

    private final JSONObject snapshot(StretchRecoverySnapshot arg5) {
        StretchOriginalDisplayState v0 = arg5.getOriginal();
        JSONObject v4 = new JSONObject().put("version", arg5.getSchemaVersion()).put("session", arg5.getSessionId()).put("api", arg5.getAndroidApi()).put("backend", arg5.getBackend().name()).put("wall", arg5.getCapturedAtWallMillis()).put("source", arg5.getCaptureSource().name()).put("original", new JSONObject().put("logicalIdentity", this.datum(v0.getLogicalIdentity(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda1())).put("physicalIdentity", this.datum(v0.getPhysicalIdentity(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda2())).put("logicalSize", this.datum(v0.getLogicalSize(), new StretchOriginalEvidenceCodec$snapshot$original$3(this))).put("override", this.datum(v0.getSizeOverride(), new StretchOriginalEvidenceCodec$snapshot$original$4(this))).put("scaling", this.datum(v0.getScaling(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda3())).put("density", this.datum(v0.getDensity(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda4())).put("rotation", this.datum(v0.getRotation(), new StretchOriginalEvidenceCodec$$ExternalSyntheticLambda5())).put("reference", this.datum(v0.getReferenceSize(), new StretchOriginalEvidenceCodec$snapshot$original$8(this))).put("projection", this.datum(v0.getProjection(), new StretchOriginalEvidenceCodec$snapshot$original$9(this))));
        Intrinsics.checkNotNullExpressionValue(v4, "put(...)");
        return v4;
    }

    static final Object snapshot$lambda$10(StretchDisplayIdentity arg3) {
        Object v3_1;
        Intrinsics.checkNotNullParameter(arg3, "it");
        JSONObject v0 = new JSONObject().put("id", arg3.getLogicalId());
        String v3 = arg3.getName();
        if(v3 == null) {
            v3_1 = JSONObject.NULL;
        }

        JSONObject v3_2 = v0.put("name", v3_1);
        Intrinsics.checkNotNullExpressionValue(v3_2, "put(...)");
        return v3_2;
    }

    static final Object snapshot$lambda$11(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1;
    }

    static final Object snapshot$lambda$12(StretchScaling arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.name();
    }

    static final Object snapshot$lambda$13(int arg0) {
        return Integer.valueOf(arg0);
    }

    static final Object snapshot$lambda$14(int arg0) {
        return Integer.valueOf(arg0);
    }

    static final StretchDisplayIdentity snapshot$lambda$15(Object arg5) {
        Intrinsics.checkNotNullParameter(arg5, "v");
        StretchOriginalEvidenceCodec v1 = StretchOriginalEvidenceCodec.INSTANCE;
        int v2 = v1.integer(((JSONObject)arg5), "id");
        String v3 = "name";
        String v5 = ((JSONObject)arg5).isNull(v3) ? null : v1.text(((JSONObject)arg5), v3);
        return new StretchDisplayIdentity(v2, v5);
    }

    static final String snapshot$lambda$17(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        if(StretchAgentProtocolKt.validAgentText(((String)arg1))) {
            return arg1;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    static final StretchSize snapshot$lambda$18(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchOriginalEvidenceCodec.INSTANCE.size(((JSONObject)arg1));
    }

    static final StretchSize snapshot$lambda$19(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchOriginalEvidenceCodec.INSTANCE.size(((JSONObject)arg1));
    }

    static final StretchScaling snapshot$lambda$20(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchScaling.valueOf(((String)arg1));
    }

    static final StretchSize snapshot$lambda$21(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchOriginalEvidenceCodec.INSTANCE.size(((JSONObject)arg1));
    }

    static final StretchFullProjection snapshot$lambda$22(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchOriginalEvidenceCodec.INSTANCE.projection(((JSONObject)arg1));
    }

    private static final int snapshot$number(Object arg2) {
        if(!(arg2 instanceof Integer)) {
            if((arg2 instanceof Long)) {
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.Number");
        return Math.toIntExact(((Number)arg2).longValue());
    }

    private final String text(JSONObject arg2, String arg3) {
        String v1 = arg2.getString(arg3);
        if(v1.length() <= 0x80) {
            Intrinsics.checkNotNull(v1);
            String v2 = v1;
            int v3 = 0;
            while(true) {
                if(v3 >= ((CharSequence)v2).length()) {
                    break;
                }
                else if(!Character.isISOControl(((CharSequence)v2).charAt(v3))) {
                    ++v3;
                    continue;
                }

                goto label_17;
            }

            Intrinsics.checkNotNullExpressionValue(v1, "also(...)");
            return v1;
        }

    label_17:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

