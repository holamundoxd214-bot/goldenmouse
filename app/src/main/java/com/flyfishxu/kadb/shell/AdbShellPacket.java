package com.flyfishxu.kadb.shell;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\f\r\u000EB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\u0082\u0001\u0003\u000F\u0010\u0011¨\u0006\u0012"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "", "payload", "", "<init>", "([B)V", "getPayload", "()[B", "id", "", "getId", "()I", "StdOut", "StdError", "Exit", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$Exit;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdError;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdOut;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AdbShellPacket {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacket$Exit;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", "", "<init>", "([B)V", "getPayload", "()[B", "id", "", "getId", "()I", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Exit extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        public Exit(byte[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "payload");
            super(arg2, null);
            this.payload = arg2;
            this.id = 3;
        }

        public int getId() {
            return this.id;
        }

        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "EXIT: " + this.getPayload()[0];
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdError;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", "", "<init>", "([B)V", "getPayload", "()[B", "id", "", "getId", "()I", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class StdError extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        public StdError(byte[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "payload");
            super(arg2, null);
            this.payload = arg2;
            this.id = 2;
        }

        public int getId() {
            return this.id;
        }

        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "STDERR: ".concat(new String(this.getPayload(), Charsets.UTF_8));
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellPacket$StdOut;", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "payload", "", "<init>", "([B)V", "getPayload", "()[B", "id", "", "getId", "()I", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class StdOut extends AdbShellPacket {
        private final int id;
        private final byte[] payload;

        public StdOut(byte[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "payload");
            super(arg2, null);
            this.payload = arg2;
            this.id = 1;
        }

        public int getId() {
            return this.id;
        }

        public byte[] getPayload() {
            return this.payload;
        }

        public String toString() {
            return "STDOUT: ".concat(new String(this.getPayload(), Charsets.UTF_8));
        }
    }

    private final byte[] payload;

    private AdbShellPacket(byte[] arg1) {
        super();
        this.payload = arg1;
    }

    public AdbShellPacket(byte[] arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public abstract int getId();

    public byte[] getPayload() {
        return this.payload;
    }
}

