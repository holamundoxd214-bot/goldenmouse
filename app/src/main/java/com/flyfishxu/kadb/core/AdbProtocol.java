package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.DelayedAckMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000B\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001A0\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001FJ\u0014\u0010 \u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001A0\u001CJ \u0010#\u001A\u00020\u00052\u0006\u0010$\u001A\u00020!2\u0006\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u0005H\u0002J*\u0010\'\u001A\u00020!2\u0006\u0010(\u001A\u00020\u00052\u0006\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u00052\b\u0010$\u001A\u0004\u0018\u00010!H\u0002J:\u0010\'\u001A\u00020!2\u0006\u0010(\u001A\u00020\u00052\u0006\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u00052\b\u0010$\u001A\u0004\u0018\u00010!2\u0006\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u0005H\u0002J\u0006\u0010+\u001A\u00020!R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"Lcom/flyfishxu/kadb/core/AdbProtocol;", "", "<init>", "()V", "ADB_HEADER_LENGTH", "", "A_STLS", "A_STLS_VERSION", "AUTH_TYPE_TOKEN", "AUTH_TYPE_SIGNATURE", "AUTH_TYPE_RSA_PUBLIC", "CMD_AUTH", "CMD_CNXN", "CMD_OPEN", "CMD_OKAY", "CMD_CLSE", "CMD_WRTE", "CMD_STLS", "A_VERSION_MIN", "A_VERSION_SKIP_CHECKSUM", "A_VERSION", "CONNECT_VERSION", "MAX_PAYLOAD_V1", "CONNECT_MAXDATA", "INITIAL_DELAYED_ACK_BYTES", "FEATURE_DELAYED_ACK", "", "IMPLEMENTED_CONNECT_FEATURES", "", "connectFeatures", "delayedAckMode", "Lcom/flyfishxu/kadb/DelayedAckMode;", "connectPayload", "", "features", "getPayloadChecksum", "data", "offset", "length", "generateMessage", "command", "arg0", "arg1", "generateStls", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbProtocol {
    public static final int ADB_HEADER_LENGTH = 24;
    public static final int AUTH_TYPE_RSA_PUBLIC = 3;
    public static final int AUTH_TYPE_SIGNATURE = 2;
    public static final int AUTH_TYPE_TOKEN = 1;
    public static final int A_STLS = 0x534C5453;
    public static final int A_STLS_VERSION = 0x1000000;
    public static final int A_VERSION = 0x1000001;
    public static final int A_VERSION_MIN = 0x1000000;
    public static final int A_VERSION_SKIP_CHECKSUM = 0x1000001;
    public static final int CMD_AUTH = 1213486401;
    public static final int CMD_CLSE = 1163086915;
    public static final int CMD_CNXN = 1314410051;
    public static final int CMD_OKAY = 0x59414B4F;
    public static final int CMD_OPEN = 0x4E45504F;
    public static final int CMD_STLS = 0x534C5453;
    public static final int CMD_WRTE = 1163154007;
    public static final int CONNECT_MAXDATA = 0x100000;
    public static final int CONNECT_VERSION = 0x1000001;
    public static final String FEATURE_DELAYED_ACK = "delayed_ack";
    private static final List IMPLEMENTED_CONNECT_FEATURES = null;
    public static final int INITIAL_DELAYED_ACK_BYTES = 0x2000000;
    public static final AdbProtocol INSTANCE = null;
    public static final int MAX_PAYLOAD_V1 = 0x1000;

    static {
        AdbProtocol.INSTANCE = new AdbProtocol();
        AdbProtocol.IMPLEMENTED_CONNECT_FEATURES = CollectionsKt.listOf(new String[]{"shell_v2", "cmd", "abb_exec", "stat_v2", "ls_v2", "sendrecv_v2"});
    }

    private AdbProtocol() {
        super();
    }

    public final List connectFeatures(DelayedAckMode arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delayedAckMode");
        List v1 = CollectionsKt.toMutableList(AdbProtocol.IMPLEMENTED_CONNECT_FEATURES);
        if(HostFeaturePolicyKt.shouldAdvertiseDelayedAck(arg2)) {
            v1.add("delayed_ack");
        }

        return v1;
    }

    public static List connectFeatures$default(AdbProtocol arg0, DelayedAckMode arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = DelayedAckMode.AOSP_DEFAULT;
        }

        return arg0.connectFeatures(arg1);
    }

    public final byte[] connectPayload(List arg10) {
        Intrinsics.checkNotNullParameter(arg10, "features");
        byte[] v9 = "host::features=" + CollectionsKt.joinToString$default(CollectionsKt.distinct(((Iterable)arg10)), ",", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v9, "getBytes(...)");
        if(v9.length <= 0x1000) {
            return v9;
        }

        throw new IllegalArgumentException("ADB connect banner is too long: " + v9.length + " > 4096".toString());
    }

    private final byte[] generateMessage(int arg9, int arg10, int arg11, byte[] arg12) {
        int v0 = arg12 != null ? arg12.length : 0;
        return this.generateMessage(arg9, arg10, arg11, arg12, 0, v0);
    }

    private final byte[] generateMessage(int arg3, int arg4, int arg5, byte[] arg6, int arg7, int arg8) {
        ByteBuffer v0;
        if(arg6 != null) {
            v0 = ByteBuffer.allocate(arg8 + 24).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNull(v0);
        }
        else {
            v0 = ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNull(v0);
        }

        v0.putInt(arg3);
        v0.putInt(arg4);
        v0.putInt(arg5);
        if(arg6 != null) {
            v0.putInt(arg8);
            v0.putInt(this.getPayloadChecksum(arg6, arg7, arg8));
        }
        else {
            v0.putInt(0);
            v0.putInt(0);
        }

        v0.putInt(~arg3);
        if(arg6 != null) {
            v0.put(arg6, arg7, arg8);
        }

        byte[] v2 = v0.array();
        Intrinsics.checkNotNullExpressionValue(v2, "array(...)");
        return v2;
    }

    public final byte[] generateStls() {
        return this.generateMessage(0x534C5453, 0x1000000, 0, null);
    }

    private final int getPayloadChecksum(byte[] arg2, int arg3, int arg4) {
        arg4 += arg3;
        int v1 = 0;
        while(arg3 < arg4) {
            v1 += arg2[arg3] & 0xFF;
            ++arg3;
        }

        return v1;
    }
}

