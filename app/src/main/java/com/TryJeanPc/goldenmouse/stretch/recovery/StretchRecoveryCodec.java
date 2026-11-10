package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001A\u00020\t2\u0017\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\u000EH\u0002J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012J\u000E\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0015J\u000E\u0010\u0016\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\tJ\u0014\u0010\u0017\u001A\u00020\r*\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0010H\u0002J\f\u0010\u0017\u001A\u00020\u0010*\u00020\u0019H\u0002J\u0018\u0010\u001A\u001A\u00020\r*\u00020\f2\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u001BH\u0002J$\u0010\u001A\u001A\u0002H\u001C\"\u0010\b\u0000\u0010\u001C\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u001C0\u001B*\u00020\u0019H\u0082\b¢\u0006\u0002\u0010\u001DJ@\u0010\u001E\u001A\u00020\r\"\u0004\b\u0000\u0010\u001C*\u00020\f2\b\u0010\u0018\u001A\u0004\u0018\u0001H\u001C2\u001D\u0010\n\u001A\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\r0\u001F¢\u0006\u0002\b\u000EH\u0002¢\u0006\u0002\u0010 J2\u0010\u001E\u001A\u0004\u0018\u0001H\u001C\"\u0004\b\u0000\u0010\u001C*\u00020\u00192\u0017\u0010!\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u001C0\u000B¢\u0006\u0002\b\u000EH\u0002¢\u0006\u0002\u0010\"J?\u0010#\u001A\u00020\r\"\u0004\b\u0000\u0010\u001C*\u00020\f2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u001C0%2\u001D\u0010\n\u001A\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\r0\u001F¢\u0006\u0002\b\u000EH\u0002J1\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u001C0%\"\u0004\b\u0000\u0010\u001C*\u00020\u00192\u0017\u0010!\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u001C0\u000B¢\u0006\u0002\b\u000EH\u0002J?\u0010&\u001A\u00020\r\"\u0004\b\u0000\u0010\u001C*\u00020\f2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u001C0\'2\u001D\u0010\n\u001A\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u00020\r0\u001F¢\u0006\u0002\b\u000EH\u0002J1\u0010&\u001A\b\u0012\u0004\u0012\u0002H\u001C0\'\"\u0004\b\u0000\u0010\u001C*\u00020\u00192\u0017\u0010!\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u001C0\u000B¢\u0006\u0002\b\u000EH\u0002J\u0014\u0010(\u001A\u00020\r*\u00020\f2\u0006\u0010\u0018\u001A\u00020)H\u0002J\f\u0010(\u001A\u00020)*\u00020\u0019H\u0002J\u0014\u0010*\u001A\u00020\r*\u00020\f2\u0006\u0010\u0018\u001A\u00020+H\u0002J\f\u0010*\u001A\u00020+*\u00020\u0019H\u0002J\u0014\u0010,\u001A\u00020\r*\u00020\f2\u0006\u0010-\u001A\u00020.H\u0002J\f\u0010,\u001A\u00020.*\u00020\u0019H\u0002J\u0014\u0010\u0011\u001A\u00020\r*\u00020\f2\u0006\u0010-\u001A\u00020\u0012H\u0002J\f\u0010\u0011\u001A\u00020\u0012*\u00020\u0019H\u0002J\u0014\u0010/\u001A\u00020\r*\u00020\f2\u0006\u0010-\u001A\u000200H\u0002J\f\u0010/\u001A\u000200*\u00020\u0019H\u0002J\u0014\u00101\u001A\u00020\r*\u00020\f2\u0006\u00102\u001A\u000203H\u0002J\f\u00101\u001A\u000203*\u00020\u0019H\u0002J\u0014\u00104\u001A\u00020\r*\u00020\f2\u0006\u00105\u001A\u000206H\u0002J\f\u00104\u001A\u000206*\u00020\u0019H\u0002J\u0014\u0010\u0014\u001A\u00020\r*\u00020\f2\u0006\u00105\u001A\u00020\u0015H\u0002J\f\u0010\u0014\u001A\u00020\u0015*\u00020\u0019H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryCodec;", "", "<init>", "()V", "SCHEMA_VERSION", "", "MAX_BYTES", "MAGIC", "bytes", "", "write", "Lkotlin/Function1;", "Ljava/io/DataOutputStream;", "", "Lkotlin/ExtensionFunctionType;", "snapshotDigest", "", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "encode", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "decode", "text", "value", "Ljava/io/DataInputStream;", "enum", "", "T", "(Ljava/io/DataInputStream;)Ljava/lang/Enum;", "optional", "Lkotlin/Function2;", "(Ljava/io/DataOutputStream;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "read", "(Ljava/io/DataInputStream;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "list", "values", "", "datum", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "size", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "rect", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "original", "s", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "strategy", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "ticket", "t", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "result", "r", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "UnsupportedVersion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryCodec {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryCodec$UnsupportedVersion;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class UnsupportedVersion extends Exception {
        public static final int $stable = 8;

        static {
        }

        public UnsupportedVersion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final StretchRecoveryCodec INSTANCE = null;
    private static final int MAGIC = 0x47535233;
    public static final int MAX_BYTES = 0x10000;
    public static final int SCHEMA_VERSION = 1;

    static {
        StretchRecoveryCodec.INSTANCE = new StretchRecoveryCodec();
    }

    private StretchRecoveryCodec() {
        super();
    }

    private final byte[] bytes(Function1 arg3) {
        ByteArrayOutputStream v2 = new ByteArrayOutputStream();
        DataOutputStream v0 = new DataOutputStream(v2);
        try {
            arg3.invoke(v0);
        }
        catch(Throwable v2_1) {
            try {
                throw v2_1;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v0), v2_1);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        byte[] v2_2 = v2.toByteArray();
        Intrinsics.checkNotNullExpressionValue(v2_2, "toByteArray(...)");
        return v2_2;
    }

    private final RecoveryDatum datum(DataInputStream arg4, Function1 arg5) {
        RecoveryDatumState v0 = RecoveryDatumState.valueOf(this.text(arg4));
        RecoverySource v3 = RecoverySource.valueOf(this.text(arg4));
        Object v4 = v0 == RecoveryDatumState.KNOWN ? arg5.invoke(arg4) : null;
        return new RecoveryDatum(v0, v3, v4);
    }

    private final void datum(DataOutputStream arg2, RecoveryDatum arg3, Function2 arg4) {
        this.enum(arg2, arg3.getState());
        this.enum(arg2, arg3.getSource());
        Object v1 = arg3.getValue();
        if(v1 != null) {
            arg4.invoke(arg2, v1);
        }
    }

    public final StretchRecoveryRecord decode(byte[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "bytes");
        int v0 = arg6.length;
        String v1 = "Failed requirement.";
        int v2 = 44;
        if(v2 <= v0 && v0 < 0x10001) {
            DataInputStream v0_1 = new DataInputStream(new ByteArrayInputStream(arg6));
            if(v0_1.readInt() != 0x47535233) {
                throw new IllegalArgumentException(v1.toString());
            }
            else if(v0_1.readInt() == 1) {
                int v3 = v0_1.readInt();
                if(v3 == arg6.length - v2) {
                    arg6 = new byte[v3];
                    v0_1.readFully(arg6);
                    byte[] v2_1 = new byte[0x20];
                    v0_1.readFully(v2_1);
                    if(MessageDigest.isEqual(v2_1, MessageDigest.getInstance("SHA-256").digest(arg6))) {
                        v0_1 = new DataInputStream(new ByteArrayInputStream(arg6));
                        StretchRecoveryRecord v5 = this.record(v0_1);
                        if(v0_1.available() == 0 && (StretchRecoveryValidationKt.validRecoveryRecord(v5))) {
                            return v5;
                        }

                        throw new IllegalArgumentException(v1.toString());
                    }
                    else {
                        throw new IllegalArgumentException(v1.toString());
                    }
                }
                else {
                    throw new IllegalArgumentException(v1.toString());
                }
            }
            else {
                throw new UnsupportedVersion();
            }
        }

        throw new IllegalArgumentException(v1.toString());
    }

    public final byte[] encode(StretchRecoveryRecord arg4) {
        Intrinsics.checkNotNullParameter(arg4, "record");
        String v1 = "Failed requirement.";
        if(StretchRecoveryValidationKt.validRecoveryRecord(arg4)) {
            byte[] v4 = this.bytes(new StretchRecoveryCodec$$ExternalSyntheticLambda25(arg4));
            if(v4.length <= 0xFFD4) {
                return this.bytes(new StretchRecoveryCodec$$ExternalSyntheticLambda26(v4));
            }

            throw new IllegalArgumentException(v1.toString());
        }

        throw new IllegalArgumentException(v1.toString());
    }

    static final Unit encode$lambda$4(StretchRecoveryRecord arg1, DataOutputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$bytes");
        StretchRecoveryCodec.INSTANCE.record(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit encode$lambda$5(byte[] arg1, DataOutputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$bytes");
        arg2.writeInt(0x47535233);
        arg2.writeInt(1);
        arg2.writeInt(arg1.length);
        arg2.write(arg1);
        arg2.write(MessageDigest.getInstance("SHA-256").digest(arg1));
        return Unit.INSTANCE;
    }

    private final void enum(DataOutputStream arg1, Enum arg2) {
        this.text(arg1, arg2.name());
    }

    private final Enum enum(DataInputStream arg2) {
        String v1 = this.text(arg2);
        Intrinsics.reifiedOperationMarker(5, "T");
        return Enum.valueOf(null, v1);
    }

    private final List list(DataInputStream arg4, Function1 arg5) {
        int v3 = arg4.readInt();
        if(v3 >= 0 && v3 < 4) {
            ArrayList v0 = new ArrayList(v3);
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                v0.add(arg5.invoke(arg4));
            }

            return ((List)v0);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void list(DataOutputStream arg2, List arg3, Function2 arg4) {
        if(arg3.size() <= 3) {
            arg2.writeInt(arg3.size());
            Iterator v1 = ((Iterable)arg3).iterator();
            while(v1.hasNext()) {
                arg4.invoke(arg2, v1.next());
            }

            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final Object optional(DataInputStream arg1, Function1 arg2) {
        if(arg1.readBoolean()) {
            return arg2.invoke(arg1);
        }

        return null;
    }

    private final void optional(DataOutputStream arg1, Object arg2, Function2 arg3) {
        boolean v0 = arg2 != null ? true : false;
        arg1.writeBoolean(v0);
        if(arg2 != null) {
            arg3.invoke(arg1, arg2);
        }
    }

    private final StretchOriginalDisplayState original(DataInputStream arg11) {
        return new StretchOriginalDisplayState(this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda15()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda16()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda17()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda18()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda19()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda20()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda21()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda23()), this.datum(arg11, new StretchRecoveryCodec$$ExternalSyntheticLambda24()));
    }

    private final void original(DataOutputStream arg3, StretchOriginalDisplayState arg4) {
        this.datum(arg3, arg4.getLogicalIdentity(), new StretchRecoveryCodec$$ExternalSyntheticLambda30());
        this.datum(arg3, arg4.getPhysicalIdentity(), new StretchRecoveryCodec$$ExternalSyntheticLambda31());
        this.datum(arg3, arg4.getLogicalSize(), new StretchRecoveryCodec$$ExternalSyntheticLambda32());
        this.datum(arg3, arg4.getSizeOverride(), new StretchRecoveryCodec$$ExternalSyntheticLambda34());
        this.datum(arg3, arg4.getScaling(), new StretchRecoveryCodec$$ExternalSyntheticLambda35());
        this.datum(arg3, arg4.getDensity(), new StretchRecoveryCodec$$ExternalSyntheticLambda36());
        this.datum(arg3, arg4.getRotation(), new StretchRecoveryCodec$$ExternalSyntheticLambda37());
        this.datum(arg3, arg4.getReferenceSize(), new StretchRecoveryCodec$$ExternalSyntheticLambda38());
        this.datum(arg3, arg4.getProjection(), new StretchRecoveryCodec$$ExternalSyntheticLambda39());
    }

    static final Unit original$lambda$12(DataOutputStream arg2, StretchDisplayIdentity arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$datum");
        Intrinsics.checkNotNullParameter(arg3, "it");
        arg2.writeInt(arg3.getLogicalId());
        StretchRecoveryCodec.INSTANCE.optional(arg2, arg3.getName(), new StretchRecoveryCodec$$ExternalSyntheticLambda45());
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$12$lambda$11(DataOutputStream arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.text(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$13(DataOutputStream arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.text(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$14(DataOutputStream arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$15(DataOutputStream arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$16(DataOutputStream arg1, StretchScaling arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$17(DataOutputStream arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        arg1.writeInt(arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$18(DataOutputStream arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        arg1.writeInt(arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$19(DataOutputStream arg1, StretchSize arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.size(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit original$lambda$20(DataOutputStream arg2, StretchFullProjection arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$datum");
        Intrinsics.checkNotNullParameter(arg3, "it");
        StretchRecoveryCodec v0 = StretchRecoveryCodec.INSTANCE;
        v0.rect(arg2, arg3.getSource());
        v0.rect(arg2, arg3.getDestination());
        arg2.writeInt(arg3.getRotation());
        return Unit.INSTANCE;
    }

    static final StretchDisplayIdentity original$lambda$22(DataInputStream arg4) {
        Intrinsics.checkNotNullParameter(arg4, "$this$datum");
        return new StretchDisplayIdentity(arg4.readInt(), StretchRecoveryCodec.INSTANCE.optional(arg4, new StretchRecoveryCodec$$ExternalSyntheticLambda29()));
    }

    static final String original$lambda$22$lambda$21(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        return StretchRecoveryCodec.INSTANCE.text(arg1);
    }

    static final String original$lambda$23(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return StretchRecoveryCodec.INSTANCE.text(arg1);
    }

    static final StretchSize original$lambda$24(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return StretchRecoveryCodec.INSTANCE.size(arg1);
    }

    static final StretchSize original$lambda$25(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return StretchRecoveryCodec.INSTANCE.size(arg1);
    }

    static final StretchScaling original$lambda$26(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return StretchScaling.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    static final int original$lambda$27(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return arg1.readInt();
    }

    static final int original$lambda$28(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return arg1.readInt();
    }

    static final StretchSize original$lambda$29(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$datum");
        return StretchRecoveryCodec.INSTANCE.size(arg1);
    }

    static final StretchFullProjection original$lambda$30(DataInputStream arg3) {
        Intrinsics.checkNotNullParameter(arg3, "$this$datum");
        return new StretchFullProjection(StretchRecoveryCodec.INSTANCE.rect(arg3), StretchRecoveryCodec.INSTANCE.rect(arg3), arg3.readInt());
    }

    private final void record(DataOutputStream arg3, StretchRecoveryRecord arg4) {
        arg3.writeLong(arg4.getRevision());
        this.snapshot(arg3, arg4.getSnapshot());
        this.strategy(arg3, arg4.getStrategy());
        this.list(arg3, arg4.getIntendedSteps(), new StretchRecoveryCodec$$ExternalSyntheticLambda0());
        this.enum(arg3, arg4.getPhase());
        this.list(arg3, arg4.getSteps(), new StretchRecoveryCodec$$ExternalSyntheticLambda11());
        this.optional(arg3, arg4.getConfirmation(), new StretchRecoveryCodec$$ExternalSyntheticLambda22());
        this.optional(arg3, arg4.getConfirmedAtElapsedMillis(), new StretchRecoveryCodec$$ExternalSyntheticLambda33());
        this.list(arg3, arg4.getRestores(), new StretchRecoveryCodec$$ExternalSyntheticLambda42());
        this.optional(arg3, arg4.getError(), new StretchRecoveryCodec$$ExternalSyntheticLambda43());
        this.optional(arg3, arg4.getResolution(), new StretchRecoveryCodec$$ExternalSyntheticLambda44());
    }

    private final StretchRecoveryRecord record(DataInputStream arg14) {
        long v1 = arg14.readLong();
        StretchRecoverySnapshot v3 = this.snapshot(arg14);
        return new StretchRecoveryRecord(v1, v3, this.strategy(arg14), this.list(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda46()), RecoveryPhase.valueOf(this.text(arg14)), this.list(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda47()), this.optional(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda1()), this.optional(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda2()), this.list(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda3(v3)), this.optional(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda4()), this.optional(arg14, new StretchRecoveryCodec$$ExternalSyntheticLambda5()));
    }

    static final Unit record$lambda$37(DataOutputStream arg1, RecoveryStep arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$38(DataOutputStream arg2, RecoveryStepRecord arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$list");
        Intrinsics.checkNotNullParameter(arg3, "it");
        StretchRecoveryCodec v0 = StretchRecoveryCodec.INSTANCE;
        v0.enum(arg2, arg3.getStep());
        v0.ticket(arg2, arg3.getTicket());
        v0.enum(arg2, arg3.getOutcome());
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$39(DataOutputStream arg2, RecoveryConfirmation arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$optional");
        Intrinsics.checkNotNullParameter(arg3, "it");
        StretchRecoveryCodec.INSTANCE.text(arg2, arg3.getId());
        arg2.writeLong(arg3.getStartedElapsedMillis());
        arg2.writeLong(arg3.getExpiresElapsedMillis());
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$40(DataOutputStream arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        arg1.writeLong(arg2);
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$43(DataOutputStream arg3, RecoveryRestoreAttempt arg4) {
        Intrinsics.checkNotNullParameter(arg3, "$this$list");
        Intrinsics.checkNotNullParameter(arg4, "it");
        StretchRecoveryCodec v0 = StretchRecoveryCodec.INSTANCE;
        v0.ticket(arg3, arg4.getRequest().getTicket());
        v0.list(arg3, arg4.getRequest().getSteps(), new StretchRecoveryCodec$$ExternalSyntheticLambda13());
        v0.optional(arg3, arg4.getResult(), new StretchRecoveryCodec$$ExternalSyntheticLambda14());
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$43$lambda$41(DataOutputStream arg1, RecoveryStep arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$43$lambda$42(DataOutputStream arg1, StretchRestoreResult arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.result(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$44(DataOutputStream arg1, RecoveryError arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final Unit record$lambda$45(DataOutputStream arg1, RecoveryResolution arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final RecoveryStep record$lambda$46(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        return RecoveryStep.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    static final RecoveryStepRecord record$lambda$47(DataInputStream arg4) {
        Intrinsics.checkNotNullParameter(arg4, "$this$list");
        return new RecoveryStepRecord(RecoveryStep.valueOf(StretchRecoveryCodec.INSTANCE.text(arg4)), StretchRecoveryCodec.INSTANCE.ticket(arg4), RecoveryStepOutcome.valueOf(StretchRecoveryCodec.INSTANCE.text(arg4)));
    }

    static final RecoveryConfirmation record$lambda$48(DataInputStream arg7) {
        Intrinsics.checkNotNullParameter(arg7, "$this$optional");
        return new RecoveryConfirmation(StretchRecoveryCodec.INSTANCE.text(arg7), arg7.readLong(), arg7.readLong());
    }

    static final long record$lambda$49(DataInputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$optional");
        return arg2.readLong();
    }

    static final RecoveryRestoreAttempt record$lambda$52(StretchRecoverySnapshot arg5, DataInputStream arg6) {
        Intrinsics.checkNotNullParameter(arg6, "$this$list");
        return new RecoveryRestoreAttempt(new StretchRestoreRequest(StretchRecoveryCodec.INSTANCE.ticket(arg6), arg5, StretchRecoveryCodec.INSTANCE.list(arg6, new StretchRecoveryCodec$$ExternalSyntheticLambda40())), StretchRecoveryCodec.INSTANCE.optional(arg6, new StretchRecoveryCodec$$ExternalSyntheticLambda41()));
    }

    static final RecoveryStep record$lambda$52$lambda$50(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        return RecoveryStep.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    static final StretchRestoreResult record$lambda$52$lambda$51(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        return StretchRecoveryCodec.INSTANCE.result(arg1);
    }

    static final RecoveryError record$lambda$53(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        return RecoveryError.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    static final RecoveryResolution record$lambda$54(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        return RecoveryResolution.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    private final void rect(DataOutputStream arg1, StretchRect arg2) {
        arg1.writeInt(arg2.getLeft());
        arg1.writeInt(arg2.getTop());
        arg1.writeInt(arg2.getRight());
        arg1.writeInt(arg2.getBottom());
    }

    private final StretchRect rect(DataInputStream arg4) {
        return new StretchRect(arg4.readInt(), arg4.readInt(), arg4.readInt(), arg4.readInt());
    }

    private final void result(DataOutputStream arg3, StretchRestoreResult arg4) {
        this.ticket(arg3, arg4.getTicket());
        this.enum(arg3, arg4.getStatus());
        this.list(arg3, arg4.getSteps(), new StretchRecoveryCodec$$ExternalSyntheticLambda10());
        this.optional(arg3, arg4.getObservedOriginal(), new StretchRecoveryCodec$$ExternalSyntheticLambda12());
        arg3.writeBoolean(arg4.getExecutionStopped());
    }

    private final StretchRestoreResult result(DataInputStream arg7) {
        return new StretchRestoreResult(this.ticket(arg7), StretchRestoreStatus.valueOf(this.text(arg7)), this.list(arg7, new StretchRecoveryCodec$$ExternalSyntheticLambda27()), this.optional(arg7, new StretchRecoveryCodec$$ExternalSyntheticLambda28()), arg7.readBoolean());
    }

    static final Unit result$lambda$33(DataOutputStream arg2, RecoveryRestoredStep arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$list");
        Intrinsics.checkNotNullParameter(arg3, "it");
        StretchRecoveryCodec v0 = StretchRecoveryCodec.INSTANCE;
        v0.enum(arg2, arg3.getStep());
        v0.enum(arg2, arg3.getOutcome());
        return Unit.INSTANCE;
    }

    static final Unit result$lambda$34(DataOutputStream arg1, StretchOriginalDisplayState arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.original(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final RecoveryRestoredStep result$lambda$35(DataInputStream arg3) {
        Intrinsics.checkNotNullParameter(arg3, "$this$list");
        return new RecoveryRestoredStep(RecoveryStep.valueOf(StretchRecoveryCodec.INSTANCE.text(arg3)), RecoveryStepOutcome.valueOf(StretchRecoveryCodec.INSTANCE.text(arg3)));
    }

    static final StretchOriginalDisplayState result$lambda$36(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$optional");
        return StretchRecoveryCodec.INSTANCE.original(arg1);
    }

    private final void size(DataOutputStream arg1, StretchSize arg2) {
        arg1.writeInt(arg2.getWidth());
        arg1.writeInt(arg2.getHeight());
    }

    private final StretchSize size(DataInputStream arg2) {
        return new StretchSize(arg2.readInt(), arg2.readInt());
    }

    private final StretchRecoverySnapshot snapshot(DataInputStream arg10) {
        return new StretchRecoverySnapshot(arg10.readInt(), this.text(arg10), arg10.readInt(), StretchBackendType.valueOf(this.text(arg10)), arg10.readLong(), RecoverySource.valueOf(this.text(arg10)), this.original(arg10));
    }

    private final void snapshot(DataOutputStream arg3, StretchRecoverySnapshot arg4) {
        arg3.writeInt(arg4.getSchemaVersion());
        this.text(arg3, arg4.getSessionId());
        arg3.writeInt(arg4.getAndroidApi());
        this.enum(arg3, arg4.getBackend());
        arg3.writeLong(arg4.getCapturedAtWallMillis());
        this.enum(arg3, arg4.getCaptureSource());
        this.original(arg3, arg4.getOriginal());
    }

    public final String snapshotDigest(StretchRecoverySnapshot arg11) {
        Intrinsics.checkNotNullParameter(arg11, "snapshot");
        byte[] v1 = MessageDigest.getInstance("SHA-256").digest(this.bytes(new StretchRecoveryCodec$$ExternalSyntheticLambda7(arg11)));
        Intrinsics.checkNotNullExpressionValue(v1, "digest(...)");
        return ArraysKt.joinToString$default(v1, "", null, null, 0, null, new StretchRecoveryCodec$$ExternalSyntheticLambda8(), 30, null);
    }

    static final Unit snapshotDigest$lambda$2(StretchRecoverySnapshot arg1, DataOutputStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$bytes");
        StretchRecoveryCodec.INSTANCE.snapshot(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final CharSequence snapshotDigest$lambda$3(byte arg1) {
        String v1 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(arg1 & 0xFF)}, 1));
        Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
        return ((CharSequence)v1);
    }

    private final StretchRecoveryStrategy strategy(DataInputStream arg8) {
        return new StretchRecoveryStrategy(this.text(arg8), this.text(arg8), this.text(arg8), this.list(arg8, new StretchRecoveryCodec$$ExternalSyntheticLambda9()), arg8.readBoolean(), RecoveryScope.valueOf(this.text(arg8)));
    }

    private final void strategy(DataOutputStream arg3, StretchRecoveryStrategy arg4) {
        this.text(arg3, arg4.getId());
        this.text(arg3, arg4.getSnapshotDigest());
        this.text(arg3, arg4.getPhysicalIdentity());
        this.list(arg3, arg4.getSupportedSteps(), new StretchRecoveryCodec$$ExternalSyntheticLambda6());
        arg3.writeBoolean(arg4.getIdempotent());
        this.enum(arg3, arg4.getScope());
    }

    static final Unit strategy$lambda$31(DataOutputStream arg1, RecoveryStep arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        Intrinsics.checkNotNullParameter(arg2, "it");
        StretchRecoveryCodec.INSTANCE.enum(arg1, ((Enum)arg2));
        return Unit.INSTANCE;
    }

    static final RecoveryStep strategy$lambda$32(DataInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$list");
        return RecoveryStep.valueOf(StretchRecoveryCodec.INSTANCE.text(arg1));
    }

    private final String text(DataInputStream arg2) {
        String v1 = arg2.readUTF();
        if(v1.length() <= 0x80) {
            Intrinsics.checkNotNullExpressionValue(v1, "also(...)");
            return v1;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void text(DataOutputStream arg2, String arg3) {
        if(arg3.length() <= 0x80) {
            arg2.writeUTF(arg3);
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void ticket(DataOutputStream arg3, RecoveryTicket arg4) {
        this.text(arg3, arg4.getSessionId());
        this.text(arg3, arg4.getOperationId());
        arg3.writeLong(arg4.getRevision());
        arg3.writeInt(arg4.getLogicalDisplayId());
        this.text(arg3, arg4.getPhysicalIdentity());
        this.text(arg3, arg4.getSnapshotDigest());
        this.enum(arg3, arg4.getScope());
    }

    private final RecoveryTicket ticket(DataInputStream arg10) {
        return new RecoveryTicket(this.text(arg10), this.text(arg10), arg10.readLong(), arg10.readInt(), this.text(arg10), this.text(arg10), RecoveryScope.valueOf(this.text(arg10)));
    }
}

