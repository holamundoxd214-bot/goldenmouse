package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bJ\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J\u000E\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J\u000E\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0014J(\u0010\u0018\u001A\u0002H\u0019\"\u0010\b\u0000\u0010\u0019\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00190\u001A2\u0006\u0010\u0017\u001A\u00020\u0014H\u0082\b¢\u0006\u0002\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001A\u00020\u0014H\u0002J\u001A\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\b\u0010\u001D\u001A\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u001E\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020 J\u000E\u0010!\u001A\u00020 2\u0006\u0010\u0017\u001A\u00020\u0014J8\u0010\"\u001A\u00020\u0012\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0017\u001A\u00020\u00142\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00190#2\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120%H\u0002J*\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00190#\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0017\u001A\u00020\u00142\f\u0010&\u001A\b\u0012\u0004\u0012\u0002H\u00190\'H\u0002J\u0018\u0010(\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020)H\u0002J\u0010\u0010(\u001A\u00020)2\u0006\u0010\u0017\u001A\u00020\u0014H\u0002J\u0018\u0010*\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020+H\u0002J\u0010\u0010*\u001A\u00020+2\u0006\u0010\u0017\u001A\u00020\u0014H\u0002J\u0018\u0010,\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010-\u001A\u00020.H\u0002J\u0010\u0010,\u001A\u00020.2\u0006\u0010\u0017\u001A\u00020\u0014H\u0002J\u0016\u0010/\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u000200J\u000E\u00101\u001A\u0002002\u0006\u0010\u0017\u001A\u00020\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentWire;", "", "<init>", "()V", "DESCRIPTOR", "", "CALLBACK", "ATTEST", "", "REQUEST", "DESTROY", "MAX_BYTES", "TF_ACCEPT_FDS", "FLAG_COLLECT_NOTED_APP_OPS", "isSynchronousTransport", "", "flags", "bounded", "", "parcel", "Landroid/os/Parcel;", "exhausted", "text", "p", "enum", "T", "", "(Landroid/os/Parcel;)Ljava/lang/Enum;", "optionalText", "value", "writeRequest", "r", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "readRequest", "datum", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "write", "Lkotlin/Function1;", "read", "Lkotlin/Function0;", "size", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "rect", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "snapshot", "s", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "writeReply", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "readReply", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentWire {
    public static final int $stable = 0;
    public static final int ATTEST = 1;
    public static final String CALLBACK = "com.TryJeanPc.goldenmouse.stretch.agent.v2.peer";
    public static final String DESCRIPTOR = "com.TryJeanPc.goldenmouse.stretch.agent.v2";
    public static final int DESTROY = 0xFFFF9B;
    private static final int FLAG_COLLECT_NOTED_APP_OPS = 2;
    public static final StretchAgentWire INSTANCE = null;
    public static final int MAX_BYTES = 0x4000;
    public static final int REQUEST = 2;
    private static final int TF_ACCEPT_FDS = 16;

    static {
        StretchAgentWire.INSTANCE = new StretchAgentWire();
    }

    private StretchAgentWire() {
        super();
    }

    public final void bounded(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "parcel");
        int v0 = arg1.dataSize();
        if(v0 >= 0 && v0 < 0x4001) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final RecoveryDatum datum(Parcel arg4, Function0 arg5) {
        RecoveryDatumState[] v3 = RecoveryDatumState.values();
        int v0 = arg4.readInt();
        String v1 = "Failed requirement.";
        if(v0 >= 0 && v0 < v3.length) {
            RecoveryDatumState v3_1 = v3[v0];
            RecoverySource[] v0_1 = RecoverySource.values();
            int v4 = arg4.readInt();
            if(v4 >= 0 && v4 < v0_1.length) {
                RecoverySource v4_1 = v0_1[v4];
                Object v5 = v3_1 == RecoveryDatumState.KNOWN ? arg5.invoke() : null;
                return new RecoveryDatum(v3_1, v4_1, v5);
            }

            throw new IllegalArgumentException(v1.toString());
        }

        throw new IllegalArgumentException(v1.toString());
    }

    private final void datum(Parcel arg1, RecoveryDatum arg2, Function1 arg3) {
        arg1.writeInt(arg2.getState().ordinal());
        arg1.writeInt(arg2.getSource().ordinal());
        Object v0 = arg2.getValue();
        if(v0 != null) {
            arg3.invoke(v0);
        }
    }

    private final Enum enum(Parcel arg2) {
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum[] v1 = new Enum[0];
        int v2 = arg2.readInt();
        if(v2 >= 0 && v2 < v1.length) {
            return v1[v2];
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void exhausted(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "parcel");
        if(arg1.dataAvail() == 0) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean isSynchronousTransport(int arg1) {
        if((arg1 & -19) == 0) {
            return 1;
        }

        return 0;
    }

    private final String optionalText(Parcel arg3) {
        int v0 = arg3.readInt();
        if(v0 != 0) {
            if(v0 == 1) {
                return this.text(arg3);
            }

            throw new IllegalStateException("Invalid optional".toString());
        }

        return null;
    }

    private final void optionalText(Parcel arg1, String arg2) {
        int v0 = arg2 == null ? 0 : 1;
        arg1.writeInt(v0);
        if(arg2 != null) {
            arg1.writeString(arg2);
        }
    }

    public final StretchAgentReply readReply(Parcel arg12) {
        StretchAgentBaseline v1_2;
        Intrinsics.checkNotNullParameter(arg12, "p");
        String v2 = this.text(arg12);
        String v3 = this.text(arg12);
        StretchAgentCode[] v0 = StretchAgentCode.values();
        int v1 = arg12.readInt();
        String v4 = "Failed requirement.";
        if(v1 >= 0 && v1 < v0.length) {
            StretchAgentCode v0_1 = v0[v1];
            StretchAgentPhase[] v1_1 = StretchAgentPhase.values();
            int v5 = arg12.readInt();
            if(v5 >= 0 && v5 < v1_1.length) {
                StretchAgentPhase v5_1 = v1_1[v5];
                v1 = arg12.readInt();
                if(v1 == 0) {
                    v1_2 = null;
                }
                else if(v1 == 1) {
                    StretchRecoverySnapshot v11 = this.snapshot(arg12);
                    StretchProbeEvidence[] v7 = StretchProbeEvidence.values();
                    int v8 = arg12.readInt();
                    if(v8 >= 0 && v8 < v7.length) {
                        StretchProbeEvidence v7_1 = v7[v8];
                        StretchProbeEvidence[] v8_1 = StretchProbeEvidence.values();
                        int v9 = arg12.readInt();
                        if(v9 >= 0 && v9 < v8_1.length) {
                            StretchProbeEvidence v8_2 = v8_1[v9];
                            StretchProbeEvidence[] v9_1 = StretchProbeEvidence.values();
                            int v12 = arg12.readInt();
                            if(v12 >= 0 && v12 < v9_1.length) {
                                v1_2 = new StretchAgentBaseline(v11, new StretchProjectionProbe(v7_1, v8_2, v9_1[v12]));
                                goto label_64;
                            }

                            throw new IllegalArgumentException(v4.toString());
                        }

                        throw new IllegalArgumentException(v4.toString());
                    }

                    throw new IllegalArgumentException(v4.toString());
                }
                else {
                    throw new IllegalStateException("Invalid baseline".toString());
                }

            label_64:
                return new StretchAgentReply(v2, v3, v0_1, v5_1, v1_2, null, 0x20, null);
            }

            throw new IllegalArgumentException(v4.toString());
        }

        throw new IllegalArgumentException(v4.toString());
    }

    public final StretchAgentRequest readRequest(Parcel arg16) {
        Intrinsics.checkNotNullParameter(arg16, "p");
        int v2 = arg16.readInt();
        String v3 = this.text(arg16);
        String v4 = this.text(arg16);
        String v5 = this.text(arg16);
        String v6 = this.text(arg16);
        int v7 = arg16.readInt();
        StretchAgentAction[] v0 = StretchAgentAction.values();
        int v8 = arg16.readInt();
        if(v8 >= 0 && v8 < v0.length) {
            return new StretchAgentRequest(v2, v3, v4, v5, v6, v7, v0[v8], this.optionalText(arg16), this.optionalText(arg16), arg16.readInt(), null, 0x400, null);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final StretchRect rect(Parcel arg4) {
        return new StretchRect(arg4.readInt(), arg4.readInt(), arg4.readInt(), arg4.readInt());
    }

    private final void rect(Parcel arg1, StretchRect arg2) {
        arg1.writeInt(arg2.getLeft());
        arg1.writeInt(arg2.getTop());
        arg1.writeInt(arg2.getRight());
        arg1.writeInt(arg2.getBottom());
    }

    private final StretchSize size(Parcel arg2) {
        return new StretchSize(arg2.readInt(), arg2.readInt());
    }

    private final void size(Parcel arg1, StretchSize arg2) {
        arg1.writeInt(arg2.getWidth());
        arg1.writeInt(arg2.getHeight());
    }

    private final StretchRecoverySnapshot snapshot(Parcel arg22) {
        StretchAgentWire v0 = this;
        Parcel v1 = arg22;
        int v2 = v1.readInt();
        String v4 = "Failed requirement.";
        if(v2 == 1) {
            int v3 = v2;
            String v2_1 = this.text(arg22);
            int v5 = v3;
            v3 = v1.readInt();
            StretchBackendType[] v6 = StretchBackendType.values();
            int v7 = v1.readInt();
            if(v7 >= 0 && v7 < v6.length) {
                StretchBackendType v6_1 = v6[v7];
                String v8 = v4;
                v7 = v5;
                StretchBackendType v4_1 = v6_1;
                long v5_1 = v1.readLong();
                RecoverySource[] v9 = RecoverySource.values();
                int v10 = v1.readInt();
                if(v10 >= 0 && v10 < v9.length) {
                    return new StretchRecoverySnapshot(v7, v2_1, v3, v4_1, v5_1, v9[v10], new StretchOriginalDisplayState(v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda17(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda1(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda2(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda3(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda4(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda5(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda6(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda7(v1)), v0.datum(v1, new StretchAgentWire$$ExternalSyntheticLambda8(v1))));
                }

                throw new IllegalArgumentException(v8.toString());
            }

            throw new IllegalArgumentException(v4.toString());
        }

        throw new IllegalArgumentException(v4.toString());
    }

    private final void snapshot(Parcel arg3, StretchRecoverySnapshot arg4) {
        arg3.writeInt(arg4.getSchemaVersion());
        arg3.writeString(arg4.getSessionId());
        arg3.writeInt(arg4.getAndroidApi());
        arg3.writeInt(arg4.getBackend().ordinal());
        arg3.writeLong(arg4.getCapturedAtWallMillis());
        arg3.writeInt(arg4.getCaptureSource().ordinal());
        StretchOriginalDisplayState v4 = arg4.getOriginal();
        this.datum(arg3, v4.getLogicalIdentity(), new StretchAgentWire$$ExternalSyntheticLambda0(arg3));
        this.datum(arg3, v4.getPhysicalIdentity(), new StretchAgentWire$$ExternalSyntheticLambda9(arg3));
        this.datum(arg3, v4.getLogicalSize(), new StretchAgentWire$$ExternalSyntheticLambda10(arg3));
        this.datum(arg3, v4.getSizeOverride(), new StretchAgentWire$$ExternalSyntheticLambda11(arg3));
        this.datum(arg3, v4.getScaling(), new StretchAgentWire$$ExternalSyntheticLambda12(arg3));
        this.datum(arg3, v4.getDensity(), new StretchAgentWire$$ExternalSyntheticLambda13(arg3));
        this.datum(arg3, v4.getRotation(), new StretchAgentWire$$ExternalSyntheticLambda14(arg3));
        this.datum(arg3, v4.getReferenceSize(), new StretchAgentWire$$ExternalSyntheticLambda15(arg3));
        this.datum(arg3, v4.getProjection(), new StretchAgentWire$$ExternalSyntheticLambda16(arg3));
    }

    static final Unit snapshot$lambda$10(Parcel arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchAgentWire.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$11(Parcel arg2, StretchFullProjection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        StretchAgentWire v0 = StretchAgentWire.INSTANCE;
        v0.rect(arg2, arg3.getSource());
        v0.rect(arg2, arg3.getDestination());
        arg2.writeInt(arg3.getRotation());
        return Unit.INSTANCE;
    }

    static final StretchDisplayIdentity snapshot$lambda$12(Parcel arg3) {
        return new StretchDisplayIdentity(arg3.readInt(), StretchAgentWire.INSTANCE.optionalText(arg3));
    }

    static final String snapshot$lambda$13(Parcel arg1) {
        return StretchAgentWire.INSTANCE.text(arg1);
    }

    static final StretchSize snapshot$lambda$14(Parcel arg1) {
        return StretchAgentWire.INSTANCE.size(arg1);
    }

    static final StretchSize snapshot$lambda$15(Parcel arg1) {
        return StretchAgentWire.INSTANCE.size(arg1);
    }

    static final StretchScaling snapshot$lambda$16(Parcel arg2) {
        StretchScaling[] v0 = StretchScaling.values();
        int v2 = arg2.readInt();
        if(v2 >= 0 && v2 < v0.length) {
            return v0[v2];
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    static final int snapshot$lambda$17(Parcel arg0) {
        return arg0.readInt();
    }

    static final int snapshot$lambda$18(Parcel arg0) {
        return arg0.readInt();
    }

    static final StretchSize snapshot$lambda$19(Parcel arg1) {
        return StretchAgentWire.INSTANCE.size(arg1);
    }

    static final StretchFullProjection snapshot$lambda$20(Parcel arg3) {
        return new StretchFullProjection(StretchAgentWire.INSTANCE.rect(arg3), StretchAgentWire.INSTANCE.rect(arg3), arg3.readInt());
    }

    static final Unit snapshot$lambda$3(Parcel arg1, StretchDisplayIdentity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.writeInt(arg2.getLogicalId());
        StretchAgentWire.INSTANCE.optionalText(arg1, arg2.getName());
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$4(Parcel arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.writeString(arg2);
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$5(Parcel arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchAgentWire.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$6(Parcel arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchAgentWire.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$7(Parcel arg1, StretchScaling arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.writeInt(arg2.ordinal());
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$8(Parcel arg0, int arg1) {
        arg0.writeInt(arg1);
        return Unit.INSTANCE;
    }

    static final Unit snapshot$lambda$9(Parcel arg0, int arg1) {
        arg0.writeInt(arg1);
        return Unit.INSTANCE;
    }

    public final String text(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "p");
        String v0 = arg1.readString();
        if(v0 != null) {
            if(StretchAgentProtocolKt.validAgentText(v0)) {
                return v0;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void writeReply(Parcel arg2, StretchAgentReply arg3) {
        Intrinsics.checkNotNullParameter(arg2, "p");
        Intrinsics.checkNotNullParameter(arg3, "r");
        arg2.writeString(arg3.getOperationId());
        arg2.writeString(arg3.getAgentGeneration());
        arg2.writeInt(arg3.getCode().ordinal());
        arg2.writeInt(arg3.getPhase().ordinal());
        int v1 = arg3.getBaseline() == null ? 0 : 1;
        arg2.writeInt(v1);
        StretchAgentBaseline v1_1 = arg3.getBaseline();
        if(v1_1 != null) {
            StretchAgentWire.INSTANCE.snapshot(arg2, v1_1.getSnapshot());
            arg2.writeInt(v1_1.getProjection().getToken().ordinal());
            arg2.writeInt(v1_1.getProjection().getTransactionMethod().ordinal());
            arg2.writeInt(v1_1.getProjection().getOriginalProjection().ordinal());
        }
    }

    public final void writeRequest(Parcel arg2, StretchAgentRequest arg3) {
        Intrinsics.checkNotNullParameter(arg2, "p");
        Intrinsics.checkNotNullParameter(arg3, "r");
        arg2.writeInt(arg3.getProtocol());
        arg2.writeString(arg3.getSessionId());
        arg2.writeString(arg3.getOperationId());
        arg2.writeString(arg3.getOwnerGeneration());
        arg2.writeString(arg3.getAgentGeneration());
        arg2.writeInt(arg3.getLogicalDisplayId());
        arg2.writeInt(arg3.getAction().ordinal());
        this.optionalText(arg2, arg3.getSnapshotDigest());
        this.optionalText(arg2, arg3.getPhysicalIdentity());
        arg2.writeInt(arg3.getFactorHundredths());
    }
}

