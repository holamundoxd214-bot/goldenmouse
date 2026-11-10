package com.flyfishxu.kadb.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ&\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016J\u0016\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u0007J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0007J\u000E\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0007J\u000E\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u0007J\u0014\u0010 \u001A\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001C\u001A\u00020\u0007J\u0014\u0010#\u001A\b\u0012\u0004\u0012\u00020$0!2\u0006\u0010\u001C\u001A\u00020\u0007J(\u0010%\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J(\u0010&\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u0018\u0010\'\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\b\u0010(\u001A\u00020\u000FH\u0002J\u0018\u0010)\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u0007H\u0002J\u0018\u0010*\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u0007H\u0002J\u0010\u0010+\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J \u0010,\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010-\u001A\u00020\u00072\u0006\u0010.\u001A\u00020\u0007H\u0002J\u0010\u0010/\u001A\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u0007H\u0002J\u0016\u00100\u001A\b\u0012\u0004\u0012\u00020$0!2\u0006\u0010\u001C\u001A\u00020\u0007H\u0002J\u0016\u00101\u001A\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001C\u001A\u00020\u0007H\u0002J\b\u00102\u001A\u000203H\u0002J\u0018\u00104\u001A\u00020\u000F2\u0006\u00105\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u000206H\u0002J\u0018\u00107\u001A\u00020\u000F2\u0006\u00105\u001A\u00020\u00072\u0006\u00108\u001A\u00020\u0014H\u0002J\u001C\u00109\u001A\u00020\u000F*\u00020:2\u0006\u00105\u001A\u00020\u00072\u0006\u00108\u001A\u00020\u0014H\u0002J\b\u0010;\u001A\u00020<H\u0002J\u0010\u0010=\u001A\u00020\u00072\u0006\u0010>\u001A\u00020\u0014H\u0002J\u0010\u0010?\u001A\u00020\u000F2\u0006\u0010@\u001A\u00020\u0007H\u0002J\u0010\u0010A\u001A\u00020\r2\u0006\u0010B\u001A\u00020\u0007H\u0002J\u0018\u0010C\u001A\u00020\u000F2\u0006\u0010B\u001A\u00020\u00072\u0006\u0010.\u001A\u00020\u0007H\u0002J\u0018\u0010D\u001A\u00020\u000F2\u0006\u0010>\u001A\u00020\u00142\u0006\u00105\u001A\u00020\u0007H\u0002J\b\u0010E\u001A\u00020FH\u0002J\b\u0010G\u001A\u00020\u0007H\u0002J\b\u0010H\u001A\u00020\u0016H\u0002J\b\u0010I\u001A\u00020\u000FH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2={"Lcom/flyfishxu/kadb/stream/AdbSyncStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "stream", "Lcom/flyfishxu/kadb/stream/AdbStream;", "features", "", "", "<init>", "(Lcom/flyfishxu/kadb/stream/AdbStream;Ljava/util/Set;)V", "buffer", "Lokio/Buffer;", "isWindowsHost", "", "send", "", "source", "Lokio/Source;", "remotePath", "mode", "", "lastModifiedMs", "", "recv", "sink", "Lokio/Sink;", "statV2", "Lcom/flyfishxu/kadb/stream/AdbSyncStatV2;", "path", "lstatV2", "lstat", "Lcom/flyfishxu/kadb/stream/AdbSyncStat;", "listV2", "", "Lcom/flyfishxu/kadb/stream/AdbSyncDirEntryV2;", "list", "Lcom/flyfishxu/kadb/stream/AdbSyncDirEntry;", "sendV1", "sendV2", "writeSourcePayload", "readSendStatus", "recvV1", "recvV2", "readRecvPayload", "readStatV2", "requestId", "apiName", "readLstatV1", "readListV1", "readListV2", "readDentV2", "Lcom/flyfishxu/kadb/stream/DentV2Fields;", "writeRequest", "id", "", "writePacket", "arg", "writeFrameHeader", "Lokio/BufferedSink;", "readPacket", "Lcom/flyfishxu/kadb/stream/Packet;", "readSyncName", "length", "validateEntryName", "name", "supportsFeature", "feature", "requireFeature", "enforcePathLength", "readFailException", "Ljava/io/IOException;", "readSyncId", "readUInt32AsLong", "close", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbSyncStream implements AutoCloseable {
    private final Buffer buffer;
    private final Set features;
    private final boolean isWindowsHost;
    private final AdbStream stream;

    public AdbSyncStream(AdbStream arg3, Set arg4) {
        Intrinsics.checkNotNullParameter(arg3, "stream");
        Intrinsics.checkNotNullParameter(arg4, "features");
        super();
        this.stream = arg3;
        this.features = arg4;
        this.buffer = new Buffer();
        String v3 = System.getProperty("os.name");
        boolean v4 = false;
        if(v3 != null && (StringsKt.startsWith(v3, "Windows", true))) {
            v4 = true;
        }

        this.isWindowsHost = v4;
    }

    public AdbSyncStream(AdbStream arg1, Set arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SetsKt.emptySet();
        }

        this(arg1, arg2);
    }

    public void close() {
        this.writePacket("QUIT", 0);
        this.stream.close();
    }

    private final void enforcePathLength(int arg2, String arg3) {
        if(arg2 <= 0x400) {
            return;
        }

        throw new IllegalArgumentException("Sync path too long for " + arg3 + ": " + arg2 + " > 1024".toString());
    }

    public final List list(String arg10) throws IOException {
        Intrinsics.checkNotNullParameter(arg10, "path");
        if(this.supportsFeature("ls_v2")) {
            List v9 = this.readListV2(arg10);
            ArrayList v10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), 10));
            Iterator v9_1 = ((Iterable)v9).iterator();
            while(v9_1.hasNext()) {
                Object v0 = v9_1.next();
                String v2 = ((AdbSyncDirEntryV2)v0).getName();
                int v3 = ((AdbSyncDirEntryV2)v0).getMode();
                long v4 = ((AdbSyncDirEntryV2)v0).getSize();
                long v6 = ((AdbSyncDirEntryV2)v0).getMtimeSec();
                Integer v0_1 = Integer.valueOf(((AdbSyncDirEntryV2)v0).getErrorCode());
                if(v0_1.intValue() != 0) {
                }
                else {
                    v0_1 = null;
                }

                ((Collection)v10).add(new AdbSyncDirEntry(v2, v3, v4, v6, v0_1));
            }

            return ((List)v10);
        }

        return this.readListV1(arg10);
    }

    public final List listV2(String arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "path");
        this.requireFeature("ls_v2", "listV2");
        return this.readListV2(arg3);
    }

    public final AdbSyncStat lstat(String arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg7, "path");
        if(this.supportsFeature("stat_v2")) {
            AdbSyncStatV2 v6 = this.readStatV2(arg7, "LST2", "lstat");
            return new AdbSyncStat(v6.getMode(), v6.getSize(), v6.getMtimeSec());
        }

        return this.readLstatV1(arg7);
    }

    public final AdbSyncStatV2 lstatV2(String arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "path");
        this.requireFeature("stat_v2", "lstatV2");
        return this.readStatV2(arg3, "LST2", "lstatV2");
    }

    private final DentV2Fields readDentV2() throws IOException {
        int v3 = this.stream.getSource().readIntLe();
        long v4 = this.stream.getSource().readLongLe();
        long v6 = this.stream.getSource().readLongLe();
        int v8 = this.stream.getSource().readIntLe();
        int v9 = this.stream.getSource().readIntLe();
        int v10 = this.stream.getSource().readIntLe();
        int v11 = this.stream.getSource().readIntLe();
        long v12 = this.stream.getSource().readLongLe();
        long v14 = this.stream.getSource().readLongLe();
        long v16 = this.stream.getSource().readLongLe();
        long v18 = this.stream.getSource().readLongLe();
        String v1 = this.readSyncName(this.stream.getSource().readIntLe());
        this.validateEntryName(v1);
        return new DentV2Fields(v3, v4, v6, v8, v9, v10, v11, v12, v14, v16, v18, v1);
    }

    private final IOException readFailException() {
        int v0 = this.stream.getSource().readIntLe();
        if(v0 < 0) {
            return new IOException("Sync failed with invalid message length: " + v0);
        }

        BufferedSource v4 = this.stream.getSource();
        Charset v2 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v2, "UTF_8");
        return new IOException("Sync failed: " + v4.readString(((long)v0), v2));
    }

    private final List readListV1(String arg10) throws IOException {
        String v0_1;
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        byte[] v10 = arg10.getBytes(v0);
        Intrinsics.checkNotNullExpressionValue(v10, "getBytes(...)");
        this.enforcePathLength(v10.length, "LIST");
        this.writeRequest("LIST", v10);
        ArrayList v10_1 = new ArrayList();
        while(true) {
            v0_1 = this.readSyncId();
            int v1 = v0_1.hashCode();
            if(v1 != 0x1FF607) {
                break;
            }
            else if(v0_1.equals("DENT")) {
                int v3 = this.stream.getSource().readIntLe();
                long v4 = this.readUInt32AsLong();
                long v6 = this.readUInt32AsLong();
                String v2 = this.readSyncName(this.stream.getSource().readIntLe());
                this.validateEntryName(v2);
                v10_1.add(new AdbSyncDirEntry(v2, v3, v4, v6, null));
                continue;
            }

            goto label_53;
        }

        if(v1 != 0x201B82) {
            if(v1 == 0x20CF1E) {
                if(!v0_1.equals("FAIL")) {
                }
                else {
                    throw this.readFailException();
                }
            }
        }
        else if(v0_1.equals("DONE")) {
            this.stream.getSource().skip(16);
            return ((List)v10_1);
        }

    label_53:
        throw new IOException("Unexpected sync list id: " + v0_1);
    }

    private final List readListV2(String arg23) throws IOException {
        String v2;
        AdbSyncStream v0 = this;
        Charset v1 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v1, "UTF_8");
        byte[] v1_1 = arg23.getBytes(v1);
        Intrinsics.checkNotNullExpressionValue(v1_1, "getBytes(...)");
        v0.enforcePathLength(v1_1.length, "LIS2");
        v0.writeRequest("LIS2", v1_1);
        ArrayList v1_2 = new ArrayList();
        while(true) {
            v2 = v0.readSyncId();
            int v3 = v2.hashCode();
            if(v3 != 2103400) {
                break;
            }
            else if(v2.equals("DNT2")) {
                DentV2Fields v2_1 = v0.readDentV2();
                v1_2.add(new AdbSyncDirEntryV2(v2_1.getName(), v2_1.getErrorCode(), v2_1.getDev(), v2_1.getIno(), v2_1.getMode(), v2_1.getNlink(), v2_1.getUid(), v2_1.getGid(), v2_1.getSize(), v2_1.getAtimeSec(), v2_1.getMtimeSec(), v2_1.getCtimeSec()));
                continue;
            }

            goto label_57;
        }

        if(v3 != 0x201B82) {
            if(v3 == 0x20CF1E) {
                if(!v2.equals("FAIL")) {
                }
                else {
                    throw v0.readFailException();
                }
            }
        }
        else if(v2.equals("DONE")) {
            v0.stream.getSource().skip(72);
            return ((List)v1_2);
        }

    label_57:
        throw new IOException("Unexpected sync list id: " + v2);
    }

    private final AdbSyncStat readLstatV1(String arg7) throws IOException {
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        byte[] v7 = arg7.getBytes(v0);
        Intrinsics.checkNotNullExpressionValue(v7, "getBytes(...)");
        this.enforcePathLength(v7.length, "STAT");
        this.writeRequest("STAT", v7);
        arg7 = this.readSyncId();
        if(Intrinsics.areEqual(arg7, "STAT")) {
            int v1 = this.stream.getSource().readIntLe();
            long v2 = this.readUInt32AsLong();
            long v4 = this.readUInt32AsLong();
            if(v1 == 0) {
                long v6 = 0;
                if(v2 == v6) {
                    if(v4 != v6) {
                    }
                    else {
                        throw new IOException("Sync lstat failed: unknown error");
                    }
                }
            }

            return new AdbSyncStat(v1, v2, v4);
        }

        throw new IOException("Unexpected sync lstat id: " + arg7);
    }

    private final Packet readPacket() {
        return new Packet(this.readSyncId(), this.stream.getSource().readIntLe());
    }

    private final void readRecvPayload(Sink arg6) throws IOException {
        int v0_1;
        Packet v0;
        this.buffer.clear();
        while(true) {
            v0 = this.readPacket();
            String v1 = v0.getId();
            int v2 = v1.hashCode();
            if(v2 != 2090922) {
                goto label_7;
            }
            else if(v1.equals("DATA")) {
                v0_1 = v0.getArg();
                if(v0_1 >= 0 && v0_1 <= 0x10000) {
                    this.stream.getSource().readFully(this.buffer, ((long)v0_1));
                    this.buffer.readAll(arg6);
                    continue;
                }

                break;
            }

            goto label_61;
        }

        throw new IOException("Sync DATA chunk too large: " + v0_1 + " > 65536");
    label_7:
        if(v2 != 0x201B82) {
            if(v2 != 0x20CF1E) {
                goto label_61;
            }

            if(!v1.equals("FAIL")) {
                goto label_61;
            }

            BufferedSource v5 = this.stream.getSource();
            long v0_2 = ((long)v0.getArg());
            Charset v6 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(v6, "UTF_8");
            throw new IOException("Sync failed: " + v5.readString(v0_2, v6));
        }

        if(v1.equals("DONE")) {
            arg6.flush();
            return;
        }

    label_61:
        throw new IOException("Unexpected sync packet id: " + v0.getId());
    }

    private final void readSendStatus() throws IOException {
        Packet v0 = this.readPacket();
        String v1 = v0.getId();
        if(Intrinsics.areEqual(v1, "OKAY")) {
            return;
        }

        if(Intrinsics.areEqual(v1, "FAIL")) {
            BufferedSource v4 = this.stream.getSource();
            long v0_1 = ((long)v0.getArg());
            Charset v2 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(v2, "UTF_8");
            throw new IOException("Sync failed: " + v4.readString(v0_1, v2));
        }

        throw new IOException("Unexpected sync packet id: " + v0.getId());
    }

    private final AdbSyncStatV2 readStatV2(String arg21, String arg22, String arg23) throws IOException {
        AdbSyncStream v0 = this;
        Charset v2 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v2, "UTF_8");
        byte[] v2_1 = arg21.getBytes(v2);
        Intrinsics.checkNotNullExpressionValue(v2_1, "getBytes(...)");
        v0.enforcePathLength(v2_1.length, arg22);
        v0.writeRequest(arg22, v2_1);
        String v1 = v0.readSyncId();
        if(!Intrinsics.areEqual(v1, "STA2")) {
            if(Intrinsics.areEqual(v1, "LST2")) {
            }
            else {
                throw new IOException("Unexpected sync stat id: " + v1);
            }
        }

        AdbSyncStatV2 v2_2 = new AdbSyncStatV2(v0.stream.getSource().readIntLe(), v0.stream.getSource().readLongLe(), v0.stream.getSource().readLongLe(), v0.stream.getSource().readIntLe(), v0.stream.getSource().readIntLe(), v0.stream.getSource().readIntLe(), v0.stream.getSource().readIntLe(), v0.stream.getSource().readLongLe(), v0.stream.getSource().readLongLe(), v0.stream.getSource().readLongLe(), v0.stream.getSource().readLongLe());
        if(v2_2.getErrorCode() == 0) {
            return v2_2;
        }

        throw new IOException(arg23 + " failed with error code: " + v2_2.getErrorCode());
    }

    private final String readSyncId() {
        BufferedSource v3 = this.stream.getSource();
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        return v3.readString(4, v0);
    }

    private final String readSyncName(int arg4) throws IOException {
        if(arg4 >= 0 && arg4 <= 0xFF) {
            BufferedSource v3 = this.stream.getSource();
            long v0 = ((long)arg4);
            Charset v4 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(v4, "UTF_8");
            return v3.readString(v0, v4);
        }

        throw new IOException("Invalid sync name length: " + arg4);
    }

    private final long readUInt32AsLong() {
        return (((long)this.stream.getSource().readIntLe())) & 0xFFFFFFFFL;
    }

    public final void recv(Sink arg2, String arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        if(this.supportsFeature("sendrecv_v2")) {
            this.recvV2(arg2, arg3);
            return;
        }

        this.recvV1(arg2, arg3);
    }

    private final void recvV1(Sink arg3, String arg4) throws IOException {
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        byte[] v4 = arg4.getBytes(v0);
        Intrinsics.checkNotNullExpressionValue(v4, "getBytes(...)");
        this.enforcePathLength(v4.length, "RECV");
        this.writeRequest("RECV", v4);
        this.readRecvPayload(arg3);
    }

    private final void recvV2(Sink arg5, String arg6) throws IOException {
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        byte[] v6 = arg6.getBytes(v0);
        Intrinsics.checkNotNullExpressionValue(v6, "getBytes(...)");
        this.enforcePathLength(v6.length, "RCV2");
        BufferedSink v0_1 = this.stream.getSink();
        Charset v3 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v3, "UTF_8");
        v0_1.writeString("RCV2", v3);
        v0_1.writeIntLe(v6.length);
        v0_1.write(v6);
        Charset v6_1 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v6_1, "UTF_8");
        v0_1.writeString("RCV2", v6_1);
        v0_1.writeIntLe(0);
        v0_1.flush();
        this.readRecvPayload(arg5);
    }

    private final void requireFeature(String arg2, String arg3) {
        if(this.supportsFeature(arg2)) {
            return;
        }

        throw new UnsupportedOperationException(arg3 + " requires peer feature \'" + arg2 + "\'");
    }

    public final void send(Source arg2, String arg3, int arg4, long arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        if(this.supportsFeature("sendrecv_v2")) {
            this.sendV2(arg2, arg3, arg4, arg5);
            return;
        }

        this.sendV1(arg2, arg3, arg4, arg5);
    }

    private final void sendV1(Source arg2, String arg3, int arg4, long arg5) throws IOException {
        arg3 = arg3 + "," + arg4;
        Charset v4 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v4, "UTF_8");
        byte[] v3 = arg3.getBytes(v4);
        Intrinsics.checkNotNullExpressionValue(v3, "getBytes(...)");
        this.enforcePathLength(v3.length, "SEND");
        this.writeRequest("SEND", v3);
        this.writeSourcePayload(arg2, arg5);
        this.readSendStatus();
    }

    private final void sendV2(Source arg5, String arg6, int arg7, long arg8) throws IOException {
        Charset v0 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v0, "UTF_8");
        byte[] v6 = arg6.getBytes(v0);
        Intrinsics.checkNotNullExpressionValue(v6, "getBytes(...)");
        this.enforcePathLength(v6.length, "SND2");
        BufferedSink v0_1 = this.stream.getSink();
        Charset v3 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v3, "UTF_8");
        v0_1.writeString("SND2", v3);
        v0_1.writeIntLe(v6.length);
        v0_1.write(v6);
        Charset v6_1 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v6_1, "UTF_8");
        v0_1.writeString("SND2", v6_1);
        v0_1.writeIntLe(arg7);
        v0_1.writeIntLe(0);
        v0_1.flush();
        this.writeSourcePayload(arg5, arg8);
        this.readSendStatus();
    }

    public final AdbSyncStatV2 statV2(String arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "path");
        this.requireFeature("stat_v2", "statV2");
        return this.readStatV2(arg3, "STA2", "statV2");
    }

    private final boolean supportsFeature(String arg1) {
        return this.features.contains(arg1);
    }

    private final void validateEntryName(String arg7) {
        String v0 = arg7;
        int v3 = 2;
        Object v4 = null;
        String v5 = "Invalid sync entry name: ";
        if(!StringsKt.contains$default(((CharSequence)v0), '/', false, v3, v4)) {
            if(this.isWindowsHost) {
                if(!StringsKt.contains$default(((CharSequence)v0), '\\', false, v3, v4)) {
                }
                else {
                    throw new IOException(v5 + arg7);
                }
            }

            return;
        }

        throw new IOException(v5 + arg7);
    }

    private final void writeFrameHeader(BufferedSink arg2, String arg3, int arg4) {
        Charset v1 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(v1, "UTF_8");
        arg2.writeString(arg3, v1);
        arg2.writeIntLe(arg4);
    }

    private final void writePacket(String arg2, int arg3) {
        BufferedSink v0 = this.stream.getSink();
        this.writeFrameHeader(v0, arg2, arg3);
        v0.flush();
    }

    private final void writeRequest(String arg3, byte[] arg4) {
        BufferedSink v0 = this.stream.getSink();
        this.writeFrameHeader(v0, arg3, arg4.length);
        v0.write(arg4);
        v0.flush();
    }

    private final void writeSourcePayload(Source arg6, long arg7) throws IOException {
        AdbStream v3;
        this.buffer.clear();
        while(true) {
            long v0 = arg6.read(this.buffer, 0x10000);
            int v2 = Long.compare(v0, -1);
            v3 = this.stream;
            if(v2 == 0) {
                goto label_22;
            }

            BufferedSink v2_1 = v3.getSink();
            this.writeFrameHeader(v2_1, "DATA", ((int)v0));
            if(v0 != v2_1.writeAll(this.buffer)) {
                break;
            }

            v2_1.flush();
        }

        throw new IllegalStateException("Check failed.");
    label_22:
        BufferedSink v6 = v3.getSink();
        this.writeFrameHeader(v6, "DONE", ((int)(arg7 / 1000)));
        v6.flush();
    }
}

