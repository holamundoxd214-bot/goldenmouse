package com.flyfishxu.kadb.pair;

import com.flyfishxu.kadb.cert.AdbKeyPair;
import com.flyfishxu.kadb.cert.AndroidPubkey;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u00045678B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u001D\u001A\u00020\u001EJ\b\u0010\u001F\u001A\u00020\u001EH\u0002J\b\u0010 \u001A\u00020\u001EH\u0002J\u0018\u0010!\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0005H\u0002J\u0018\u0010%\u001A\u00020\u001E2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u0007H\u0002J\n\u0010)\u001A\u0004\u0018\u00010\'H\u0002J\u0018\u0010*\u001A\u00020\'2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u0005H\u0002J\u0018\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020,2\u0006\u00101\u001A\u00020,H\u0002J\b\u00102\u001A\u00020/H\u0002J\b\u00103\u001A\u00020/H\u0002J\b\u00104\u001A\u00020\u001EH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000¨\u00069"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx;", "Ljava/io/Closeable;", "host", "", "mPort", "", "pwd", "", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "deviceName", "<init>", "(Ljava/lang/String;I[BLcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/lang/String;)V", "mHost", "mPwd", "mPeerInfo", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", "mSslContext", "Ljavax/net/ssl/SSLContext;", "mRole", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$Role;", "mInputStream", "Ljava/io/DataInputStream;", "mOutputStream", "Ljava/io/DataOutputStream;", "mPairingAuthCtx", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "mState", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$State;", "start", "", "notifyResult", "setupTlsConnection", "exportKeyingMaterial", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "length", "writeHeader", "header", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", "payload", "readHeader", "createHeader", "type", "", "payloadSize", "checkHeaderType", "", "expected", "actual", "doExchangeMsgs", "doExchangePeerInfo", "close", "State", "Role", "PeerInfo", "PairingPacketHeader", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PairingConnectionCtx implements Closeable {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", "", "version", "", "type", "payloadSize", "", "<init>", "(BBI)V", "getType", "()B", "getPayloadSize", "()I", "writeTo", "", "buffer", "Ljava/nio/ByteBuffer;", "toString", "", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class PairingPacketHeader {
        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0010R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader$Companion;", "", "<init>", "()V", "CURRENT_KEY_HEADER_VERSION", "", "MIN_SUPPORTED_KEY_HEADER_VERSION", "MAX_SUPPORTED_KEY_HEADER_VERSION", "MAX_PAYLOAD_SIZE", "", "PAIRING_PACKET_HEADER_SIZE", "SPAKE2_MSG", "PEER_INFO", "readFrom", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PairingPacketHeader;", "buffer", "Ljava/nio/ByteBuffer;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final PairingPacketHeader readFrom(ByteBuffer arg4) {
                Intrinsics.checkNotNullParameter(arg4, "buffer");
                byte v3 = arg4.get();
                byte v0 = arg4.get();
                int v4 = arg4.getInt();
                PairingPacketHeader v1 = null;
                if(v3 >= 1) {
                    if(v3 > 1) {
                    }
                    else {
                        if(v0 != 0 && v0 != 1) {
                            return v1;
                        }

                        if(v4 <= 0) {
                            return v1;
                        }

                        if(v4 > 0x4000) {
                            return v1;
                        }

                        v1 = new PairingPacketHeader(v3, v0, v4);
                    }
                }

                return v1;
            }
        }

        public static final byte CURRENT_KEY_HEADER_VERSION = 1;
        public static final Companion Companion = null;
        public static final int MAX_PAYLOAD_SIZE = 0x4000;
        public static final byte MAX_SUPPORTED_KEY_HEADER_VERSION = 1;
        public static final byte MIN_SUPPORTED_KEY_HEADER_VERSION = 1;
        public static final byte PAIRING_PACKET_HEADER_SIZE = 6;
        public static final byte PEER_INFO = 1;
        public static final byte SPAKE2_MSG;
        private final int payloadSize;
        private final byte type;
        private final byte version;

        static {
            PairingPacketHeader.Companion = new Companion(null);
        }

        public PairingPacketHeader(byte arg1, byte arg2, int arg3) {
            super();
            this.version = arg1;
            this.type = arg2;
            this.payloadSize = arg3;
        }

        public final int getPayloadSize() {
            return this.payloadSize;
        }

        public final byte getType() {
            return this.type;
        }

        public String toString() {
            return "PairingPacketHeader{version=" + this.version + ", type=" + this.type + ", payloadSize=" + this.payloadSize + "}";
        }

        public final void writeTo(ByteBuffer arg2) {
            Intrinsics.checkNotNullParameter(arg2, "buffer");
            arg2.put(this.version).put(this.type).putInt(this.payloadSize);
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", "", "type", "", "data", "", "<init>", "(B[B)V", "writeTo", "", "buffer", "Ljava/nio/ByteBuffer;", "toString", "", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class PeerInfo {
        @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo$Companion;", "", "<init>", "()V", "MAX_PEER_INFO_SIZE", "", "ADB_RSA_PUB_KEY", "", "ADB_DEVICE_GUID", "readFrom", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$PeerInfo;", "buffer", "Ljava/nio/ByteBuffer;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion {
            public com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion() {
                super();
            }

            public final PeerInfo readFrom(ByteBuffer arg2) {
                Intrinsics.checkNotNullParameter(arg2, "buffer");
                byte v1 = arg2.get();
                byte[] v0 = new byte[0x1FFF];
                arg2.get(v0);
                return new PeerInfo(v1, v0);
            }
        }

        public static final byte ADB_DEVICE_GUID = 1;
        public static final byte ADB_RSA_PUB_KEY = 0;
        public static final com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion Companion = null;
        public static final int MAX_PEER_INFO_SIZE = 0x2000;
        private final byte[] data;
        private final byte type;

        static {
            PeerInfo.Companion = new com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion(null);
        }

        public PeerInfo(byte arg2, byte[] arg3) {
            Intrinsics.checkNotNullParameter(arg3, "data");
            super();
            this.type = arg2;
            byte[] v0 = new byte[0x1FFF];
            this.data = v0;
            System.arraycopy(arg3, 0, v0, 0, RangesKt.coerceAtMost(arg3.length, 0x1FFF));
        }

        public String toString() {
            byte v0 = this.type;
            String v3 = Arrays.toString(this.data);
            Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
            return "PeerInfo{type=" + v0 + ", data=" + v3 + "}";
        }

        public final void writeTo(ByteBuffer arg2) {
            Intrinsics.checkNotNullParameter(arg2, "buffer");
            arg2.put(this.type).put(this.data);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$Role;", "", "<init>", "(Ljava/lang/String;I)V", "Client", "Server", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public enum Role {
        public static final enum Role Client;
        public static final enum Role Server;

        private static final Role[] $values() {
            return new Role[]{Role.Client, Role.Server};
        }

        static {
            Role.Client = new Role("Client", 0);
            Role.Server = new Role("Server", 1);
            Role[] v0 = Role.$values();
            Role.$VALUES = v0;
            Role.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Role(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Role.$ENTRIES;
        }

        public static Role valueOf(String arg1) {
            return Enum.valueOf(Role.class, arg1);
        }

        public static Role[] values() {
            return Role.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/flyfishxu/kadb/pair/PairingConnectionCtx$State;", "", "<init>", "(Ljava/lang/String;I)V", "Ready", "ExchangingMsgs", "ExchangingPeerInfo", "Stopped", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) enum State {
        public static final enum State ExchangingMsgs;
        public static final enum State ExchangingPeerInfo;
        public static final enum State Ready;
        public static final enum State Stopped;

        private static final State[] $values() {
            return new State[]{State.Ready, State.ExchangingMsgs, State.ExchangingPeerInfo, State.Stopped};
        }

        static {
            State.Ready = new State("Ready", 0);
            State.ExchangingMsgs = new State("ExchangingMsgs", 1);
            State.ExchangingPeerInfo = new State("ExchangingPeerInfo", 2);
            State.Stopped = new State("Stopped", 3);
            State[] v0 = State.$values();
            State.$VALUES = v0;
            State.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return State.$ENTRIES;
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[State.values().length];
            try {
                v0[State.ExchangingMsgs.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[State.ExchangingPeerInfo.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[State.Ready.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[State.Stopped.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    private final String mHost;
    private DataInputStream mInputStream;
    private DataOutputStream mOutputStream;
    private PairingAuthCtx mPairingAuthCtx;
    private final PeerInfo mPeerInfo;
    private final int mPort;
    private final byte[] mPwd;
    private final Role mRole;
    private final SSLContext mSslContext;
    private State mState;

    public PairingConnectionCtx(String arg2, int arg3, byte[] arg4, AdbKeyPair arg5, String arg6) {
        Intrinsics.checkNotNullParameter(arg2, "host");
        Intrinsics.checkNotNullParameter(arg4, "pwd");
        Intrinsics.checkNotNullParameter(arg5, "keyPair");
        Intrinsics.checkNotNullParameter(arg6, "deviceName");
        super();
        this.mPort = arg3;
        Object v2 = Objects.requireNonNull(arg2);
        Intrinsics.checkNotNullExpressionValue(v2, "requireNonNull(...)");
        this.mHost = ((String)v2);
        v2 = Objects.requireNonNull(arg4);
        Intrinsics.checkNotNullExpressionValue(v2, "requireNonNull(...)");
        this.mPwd = ((byte[])v2);
        PublicKey v4 = arg5.getCertificate().getPublicKey();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
        Object v6 = Objects.requireNonNull(arg6);
        Intrinsics.checkNotNullExpressionValue(v6, "requireNonNull(...)");
        this.mPeerInfo = new PeerInfo(0, AndroidPubkey.encodeWithName(((RSAPublicKey)v4), ((String)v6)));
        this.mSslContext = SslUtils.INSTANCE.getSslContext(arg5);
        this.mRole = Role.Client;
        this.mState = State.Ready;
    }

    private final boolean checkHeaderType(byte arg1, byte arg2) {
        if(arg1 == arg2) {
            return 1;
        }

        return 0;
    }

    public void close() {
        Arrays.fill(this.mPwd, 0);
        try {
            DataInputStream v0 = this.mInputStream;
            if(v0 != null) {
                v0.close();
            }

            goto label_6;
        }
        catch(IOException ) {
            try {
            label_6:
                DataOutputStream v0_1 = this.mOutputStream;
                if(v0_1 != null) {
                    v0_1.close();
                }

                goto label_9;
            }
            catch(IOException ) {
            label_9:
                if(this.mState != State.Ready) {
                    PairingAuthCtx v2 = this.mPairingAuthCtx;
                    if(v2 != null) {
                        v2.destroy();
                    }
                }

                return;
            }
        }
    }

    private final PairingPacketHeader createHeader(byte arg2, int arg3) {
        return new PairingPacketHeader(1, arg2, arg3);
    }

    private final boolean doExchangeMsgs() throws IOException {
        PairingAuthCtx v0 = this.mPairingAuthCtx;
        Intrinsics.checkNotNull(v0);
        byte[] v0_1 = v0.getMsg();
        this.writeHeader(this.createHeader(0, v0_1.length), v0_1);
        PairingPacketHeader v0_2 = this.readHeader();
        if(v0_2 != null) {
            if(!this.checkHeaderType(0, v0_2.getType())) {
            }
            else {
                v0_1 = new byte[v0_2.getPayloadSize()];
                DataInputStream v1 = this.mInputStream;
                Intrinsics.checkNotNull(v1);
                v1.readFully(v0_1);
                try {
                    PairingAuthCtx v3_1 = this.mPairingAuthCtx;
                    Intrinsics.checkNotNull(v3_1);
                    return v3_1.initCipher(v0_1);
                }
                catch(Exception v3) {
                    Throwable v3_2 = new IOException().initCause(((Throwable)v3));
                    Intrinsics.checkNotNull(v3_2, "null cannot be cast to non-null type java.io.IOException");
                    throw v3_2;
                }
            }
        }

        return 0;
    }

    private final boolean doExchangePeerInfo() throws IOException {
        int v0 = 0x2000;
        ByteBuffer v1 = ByteBuffer.allocate(v0).order(ByteOrder.BIG_ENDIAN);
        PeerInfo v2 = this.mPeerInfo;
        Intrinsics.checkNotNull(v1);
        v2.writeTo(v1);
        PairingAuthCtx v2_1 = this.mPairingAuthCtx;
        Intrinsics.checkNotNull(v2_1);
        byte[] v1_1 = v1.array();
        Intrinsics.checkNotNullExpressionValue(v1_1, "array(...)");
        v1_1 = v2_1.encrypt(v1_1);
        if(v1_1 == null) {
            return 0;
        }

        this.writeHeader(this.createHeader(1, v1_1.length), v1_1);
        PairingPacketHeader v1_2 = this.readHeader();
        if(v1_2 != null) {
            if(!this.checkHeaderType(1, v1_2.getType())) {
            }
            else {
                v1_1 = new byte[v1_2.getPayloadSize()];
                DataInputStream v3 = this.mInputStream;
                Intrinsics.checkNotNull(v3);
                v3.readFully(v1_1);
                PairingAuthCtx v5 = this.mPairingAuthCtx;
                Intrinsics.checkNotNull(v5);
                byte[] v5_1 = v5.decrypt(v1_1);
                if(v5_1 == null) {
                    return 0;
                }
                else if(v5_1.length != v0) {
                    return 0;
                }
                else {
                    com.flyfishxu.kadb.pair.PairingConnectionCtx$PeerInfo$Companion v0_1 = PeerInfo.Companion;
                    ByteBuffer v5_2 = ByteBuffer.wrap(v5_1);
                    Intrinsics.checkNotNullExpressionValue(v5_2, "wrap(...)");
                    v0_1.readFrom(v5_2);
                    return 1;
                }
            }
        }

        return 0;
    }

    private final byte[] exportKeyingMaterial(SSLSocket arg5, int arg6) throws SSLException {
        try {
            Object v4_2 = PairingConnectionCtx_androidKt.getConscryptClass(this).getMethod("exportKeyingMaterial", SSLSocket.class, String.class, byte[].class, Integer.TYPE).invoke(null, arg5, "adb-label\u0000", null, Integer.valueOf(arg6));
            Intrinsics.checkNotNull(v4_2, "null cannot be cast to non-null type kotlin.ByteArray");
            return ((byte[])v4_2);
        }
        catch(Throwable v4) {
            throw new SSLException(v4);
        }
        catch(SSLException v4_1) {
            throw v4_1;
        }
    }

    private final void notifyResult() {
        this.mState = State.Stopped;
    }

    private final PairingPacketHeader readHeader() throws IOException {
        byte[] v0 = new byte[6];
        DataInputStream v1 = this.mInputStream;
        Intrinsics.checkNotNull(v1);
        v1.readFully(v0);
        ByteBuffer v1_1 = ByteBuffer.wrap(v0).order(ByteOrder.BIG_ENDIAN);
        Companion v0_1 = PairingPacketHeader.Companion;
        Intrinsics.checkNotNull(v1_1);
        return v0_1.readFrom(v1_1);
    }

    private final void setupTlsConnection() throws IOException {
        Socket v0_1;
        if(this.mRole == Role.Server) {
            ServerSocket v0 = this.mSslContext.getServerSocketFactory().createServerSocket(this.mPort);
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type javax.net.ssl.SSLServerSocket");
            v0_1 = ((SSLServerSocket)v0).accept();
            Intrinsics.checkNotNull(v0_1);
        }
        else {
            v0_1 = new Socket(this.mHost, this.mPort);
        }

        v0_1.setTcpNoDelay(true);
        v0_1 = this.mSslContext.getSocketFactory().createSocket(v0_1, this.mHost, this.mPort, true);
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        ((SSLSocket)v0_1).startHandshake();
        this.mInputStream = new DataInputStream(((SSLSocket)v0_1).getInputStream());
        this.mOutputStream = new DataOutputStream(((SSLSocket)v0_1).getOutputStream());
        byte[] v0_2 = this.exportKeyingMaterial(((SSLSocket)v0_1), 0x40);
        byte[] v1 = this.mPwd;
        byte[] v2 = new byte[v1.length + v0_2.length];
        System.arraycopy(v1, 0, v2, 0, v1.length);
        System.arraycopy(v0_2, 0, v2, this.mPwd.length, v0_2.length);
        PairingAuthCtx v0_3 = PairingAuthCtx_androidKt.createAlice(PairingAuthCtx.Companion, v2);
        if(v0_3 != null) {
            this.mPairingAuthCtx = v0_3;
            return;
        }

        throw new IOException("Unable to create PairingAuthCtx.");
    }

    public final void start() throws IOException {
        if(this.mState != State.Ready) {
            goto label_44;
        }

        this.mState = State.ExchangingMsgs;
        this.setupTlsConnection();
        while(true) {
            int v0 = WhenMappings.$EnumSwitchMapping$0[this.mState.ordinal()];
            if(v0 != 1) {
                goto label_12;
            }

            if(!this.doExchangeMsgs()) {
                break;
            }

            this.mState = State.ExchangingPeerInfo;
        }

        this.notifyResult();
        throw new IOException("Exchanging message wasn\'t successful.");
    label_12:
        if(v0 != 2) {
            if(v0 != 3 && v0 != 4) {
                throw new NoWhenBranchMatchedException();
            }

            throw new IOException("Connection closed with errors.");
        }

        if(this.doExchangePeerInfo()) {
            this.notifyResult();
            return;
        }

        this.notifyResult();
        throw new IOException("Could not exchange peer info.");
    label_44:
        throw new IOException("Connection is not ready yet.");
    }

    private final void writeHeader(PairingPacketHeader arg3, byte[] arg4) throws IOException {
        ByteBuffer v0 = ByteBuffer.allocate(6).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNull(v0);
        arg3.writeTo(v0);
        DataOutputStream v3 = this.mOutputStream;
        Intrinsics.checkNotNull(v3);
        v3.write(v0.array());
        DataOutputStream v2 = this.mOutputStream;
        Intrinsics.checkNotNull(v2);
        v2.write(arg4);
    }
}

