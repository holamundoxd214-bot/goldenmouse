package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.stream.AdbSyncStreamKt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\n\u0010\u0016\u001A\u00020\u0017H\u0096\u0080\u0004J\b\u0010\u0018\u001A\u00020\u0017H\u0002J\b\u0010\u0019\u001A\u00020\u0017H\u0002J\n\u0010\u001A\u001A\u0004\u0018\u00010\u0017H\u0002J\n\u0010\u001B\u001A\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001C\u001A\u00020\u001DH\u0002J\u0010\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\u0003H\u0002J\b\u0010 \u001A\u00020\u0017H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000ER\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2={"Lcom/flyfishxu/kadb/core/AdbMessage;", "", "command", "", "arg0", "arg1", "payloadLength", "checksum", "magic", "payload", "", "<init>", "(IIIIII[B)V", "getCommand", "()I", "getArg0", "getArg1", "getPayloadLength", "getChecksum", "getMagic", "getPayload", "()[B", "toString", "", "payloadStr", "writePayloadStr", "shellPayloadStr", "syncPayloadStr", "getSource", "Lokio/BufferedSource;", "argStr", "arg", "commandStr", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbMessage {
    private final int arg0;
    private final int arg1;
    private final int checksum;
    private final int command;
    private final int magic;
    private final byte[] payload;
    private final int payloadLength;

    public AdbMessage(int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte[] arg8) {
        Intrinsics.checkNotNullParameter(arg8, "payload");
        super();
        this.command = arg2;
        this.arg0 = arg3;
        this.arg1 = arg4;
        this.payloadLength = arg5;
        this.checksum = arg6;
        this.magic = arg7;
        this.payload = arg8;
    }

    private final String argStr(int arg1) {
        String v0 = String.format("%X", Arrays.copyOf(new Object[]{Integer.valueOf(arg1)}, 1));
        Intrinsics.checkNotNullExpressionValue(v0, "format(...)");
        return v0;
    }

    private final String commandStr() {
        switch(this.command) {
            case 1163086915: {
                return "CLSE";
            }
            case 1163154007: {
                return "WRTE";
            }
            case 1213486401: {
                return "AUTH";
            }
            case 1313165391: {
                return "OPEN";
            }
            case 1314410051: {
                return "CNXN";
            }
            case 1497451343: {
                return "OKAY";
            }
        }

        return "????";
    }

    public final int getArg0() {
        return this.arg0;
    }

    public final int getArg1() {
        return this.arg1;
    }

    public final int getChecksum() {
        return this.checksum;
    }

    public final int getCommand() {
        return this.command;
    }

    public final int getMagic() {
        return this.magic;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final int getPayloadLength() {
        return this.payloadLength;
    }

    private final BufferedSource getSource() {
        Buffer v0 = new Buffer();
        v0.write(this.payload, 0, this.payloadLength);
        return ((BufferedSource)v0);
    }

    private final String payloadStr() {
        int v0 = this.payloadLength;
        if(v0 == 0) {
            return "";
        }

        int v1 = this.command;
        if(v1 != 1163154007) {
            String v3 = "]";
            if(v1 != 1213486401) {
                if(v1 != 0x4E45504F) {
                    return "payload[" + v0 + v3;
                }

                return new String(this.payload, 0, this.payloadLength - 1, Charsets.UTF_8);
            }

            if(this.arg0 == 3) {
                return new String(this.payload, Charsets.UTF_8);
            }

            return "auth[" + v0 + v3;
        }

        return this.writePayloadStr();
    }

    private final String shellPayloadStr() {
        BufferedSource v0 = this.getSource();
        String v2 = null;
        if(Long.compare(v0.getBuffer().size(), 5) < 0) {
            return v2;
        }

        int v1 = v0.readByte();
        if(v1 >= 0) {
            int v3 = 3;
            if(v1 > v3) {
            }
            else if(v0.readIntLe() != (((int)v0.getBuffer().size()))) {
                return v2;
            }
            else if(v1 == v3) {
                return "[shell] exit(" + v0.readByte() + ")";
            }
            else {
                return "[shell] ".concat(new String(this.payload, 5, this.payloadLength - 5, Charsets.UTF_8));
            }
        }

        return v2;
    }

    private final String syncPayloadStr() {
        BufferedSource v4 = this.getSource();
        String v1 = null;
        if(Long.compare(v4.getBuffer().size(), 8) < 0) {
            return v1;
        }

        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        String v0_1 = v4.readString(4, v0);
        if(!AdbSyncStreamKt.getSYNC_IDS().contains(v0_1)) {
            return v1;
        }

        return "[sync] " + v0_1 + "(" + v4.readIntLe() + ")";
    }

    public String toString() {
        return this.commandStr() + "[" + this.argStr(this.arg0) + ", " + this.argStr(this.arg1) + "] " + this.payloadStr();
    }

    private final String writePayloadStr() {
        String v0 = this.shellPayloadStr();
        if(v0 != null) {
            return v0;
        }

        v0 = this.syncPayloadStr();
        if(v0 != null) {
            return v0;
        }

        return "payload[" + this.payloadLength + "]";
    }
}

