package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002/0B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000BJ\u001E\u0010\u0012\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\u0014J\u0006\u0010\u001B\u001A\u00020\u0014J\u000E\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001B\u001A\u00020\u0014J&\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000BJ\u001E\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\u0014J\u0006\u0010 \u001A\u00020\u001DJ\u0010\u0010\u001F\u001A\u00020!2\b\b\u0002\u0010\u0013\u001A\u00020\u0014J\u000E\u0010\"\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020!J\u0016\u0010#\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0014J\u0010\u0010\u0019\u001A\u00020$2\b\b\u0002\u0010\u0013\u001A\u00020\u0014J\u0006\u0010%\u001A\u00020$J\u000E\u0010\"\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020$J\u0016\u0010#\u001A\u00020\u001D2\u0006\u0010\u0019\u001A\u00020$2\u0006\u0010\"\u001A\u00020\u0014J\u0006\u0010&\u001A\u00020\u001DJ(\u0010\'\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000BH$J(\u0010(\u001A\u00020\u001D2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000BH$J\b\u0010)\u001A\u00020\u001DH$J\u0010\u0010*\u001A\u00020\u001D2\u0006\u0010\u001B\u001A\u00020\u0014H$J\b\u0010+\u001A\u00020\u0014H$J\b\u0010,\u001A\u00020\u001DH$J \u0010-\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\u0014H\u0002J \u0010.\u001A\u00020\u001D2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\u0014H\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001A\u00060\rj\u0002`\u000E¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010¨\u00061"}, d2={"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "<init>", "(Z)V", "getReadWrite", "()Z", "closed", "openStreamCount", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "read", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "sink", "Lokio/Buffer;", "size", "resize", "", "write", "source", "flush", "Lokio/Source;", "position", "reposition", "Lokio/Sink;", "appendingSink", "close", "protectedRead", "protectedWrite", "protectedFlush", "protectedResize", "protectedSize", "protectedClose", "readNoCloseCheck", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class FileHandle implements Closeable {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0005H\u0016J\b\u0010\u0019\u001A\u00020\u0015H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u0015H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001D"}, d2={"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "<init>", "(Lokio/FileHandle;J)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "write", "", "source", "Lokio/Buffer;", "byteCount", "flush", "timeout", "Lokio/Timeout;", "close", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle arg2, long arg3) {
            Intrinsics.checkNotNullParameter(arg2, "fileHandle");
            super();
            this.fileHandle = arg2;
            this.position = arg3;
        }

        public void close() {
            if(this.closed) {
                return;
            }

            this.closed = true;
            ReentrantLock v0 = this.fileHandle.getLock();
            ((Lock)v0).lock();
            try {
                --this.fileHandle.openStreamCount;
                if(this.fileHandle.openStreamCount == 0) {
                    if(!this.fileHandle.closed) {
                    }
                    else {
                        goto label_20;
                    }
                }

                goto label_24;
            }
            catch(Throwable v3) {
                ((Lock)v0).unlock();
                throw v3;
            }

        label_20:
            ((Lock)v0).unlock();
            this.fileHandle.protectedClose();
            return;
        label_24:
            ((Lock)v0).unlock();
        }

        public void flush() {
            if(!this.closed) {
                this.fileHandle.protectedFlush();
                return;
            }

            throw new IllegalStateException("closed".toString());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean arg1) {
            this.closed = arg1;
        }

        public final void setPosition(long arg1) {
            this.position = arg1;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer arg8, long arg9) {
            Intrinsics.checkNotNullParameter(arg8, "source");
            if(!this.closed) {
                this.fileHandle.writeNoCloseCheck(this.position, arg8, arg9);
                this.position += arg9;
                return;
            }

            throw new IllegalStateException("closed".toString());
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0005H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001C"}, d2={"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "<init>", "(Lokio/FileHandle;J)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "close", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle arg2, long arg3) {
            Intrinsics.checkNotNullParameter(arg2, "fileHandle");
            super();
            this.fileHandle = arg2;
            this.position = arg3;
        }

        public void close() {
            if(this.closed) {
                return;
            }

            this.closed = true;
            ReentrantLock v0 = this.fileHandle.getLock();
            ((Lock)v0).lock();
            try {
                --this.fileHandle.openStreamCount;
                if(this.fileHandle.openStreamCount == 0) {
                    if(!this.fileHandle.closed) {
                    }
                    else {
                        goto label_20;
                    }
                }

                goto label_24;
            }
            catch(Throwable v3) {
                ((Lock)v0).unlock();
                throw v3;
            }

        label_20:
            ((Lock)v0).unlock();
            this.fileHandle.protectedClose();
            return;
        label_24:
            ((Lock)v0).unlock();
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public long read(Buffer arg8, long arg9) {
            Intrinsics.checkNotNullParameter(arg8, "sink");
            if(!this.closed) {
                long v8 = this.fileHandle.readNoCloseCheck(this.position, arg8, arg9);
                if(v8 != -1) {
                    this.position += v8;
                }

                return v8;
            }

            throw new IllegalStateException("closed".toString());
        }

        public final void setClosed(boolean arg1) {
            this.closed = arg1;
        }

        public final void setPosition(long arg1) {
            this.position = arg1;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    private boolean closed;
    private final ReentrantLock lock;
    private int openStreamCount;
    private final boolean readWrite;

    public FileHandle(boolean arg1) {
        super();
        this.readWrite = arg1;
        this.lock = _JvmPlatformKt.newLock();
    }

    public static final boolean access$getClosed$p(FileHandle arg0) {
        return arg0.closed;
    }

    public static final int access$getOpenStreamCount$p(FileHandle arg0) {
        return arg0.openStreamCount;
    }

    public static final long access$readNoCloseCheck(FileHandle arg0, long arg1, Buffer arg3, long arg4) {
        return arg0.readNoCloseCheck(arg1, arg3, arg4);
    }

    public static final void access$setOpenStreamCount$p(FileHandle arg0, int arg1) {
        arg0.openStreamCount = arg1;
    }

    public static final void access$writeNoCloseCheck(FileHandle arg0, long arg1, Buffer arg3, long arg4) {
        arg0.writeNoCloseCheck(arg1, arg3, arg4);
    }

    public final Sink appendingSink() throws IOException {
        return this.sink(this.size());
    }

    public final void close() throws IOException {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(!this.closed) {
                goto label_7;
            }
        }
        catch(Throwable v2) {
            goto label_17;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_7:
            this.closed = true;
            if(this.openStreamCount == 0) {
                goto label_12;
            }
        }
        catch(Throwable v2) {
            goto label_17;
        }

        ((Lock)v0).unlock();
        return;
    label_12:
        goto label_13;
    label_17:
        ((Lock)v0).unlock();
        throw v2;
    label_13:
        ((Lock)v0).unlock();
        this.protectedClose();
    }

    public final void flush() throws IOException {
        if(!this.readWrite) {
            goto label_18;
        }

        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.closed) {
                goto label_10;
            }
        }
        catch(Throwable v2) {
            goto label_16;
        }

        ((Lock)v0).unlock();
        this.protectedFlush();
        return;
        try {
        label_10:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v2) {
        label_16:
            ((Lock)v0).unlock();
            throw v2;
        }

    label_18:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Sink arg4) throws IOException {
        long v0;
        Intrinsics.checkNotNullParameter(arg4, "sink");
        if((arg4 instanceof RealBufferedSink)) {
            v0 = ((RealBufferedSink)arg4).bufferField.size();
            arg4 = ((RealBufferedSink)arg4).sink;
        }
        else {
            v0 = 0;
        }

        if(((arg4 instanceof FileHandleSink)) && arg4.getFileHandle() == this) {
            if(!((FileHandleSink)arg4).getClosed()) {
                return ((FileHandleSink)arg4).getPosition() + v0;
            }
            else {
                throw new IllegalStateException("closed".toString());
            }
        }

        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    public final long position(Source arg4) throws IOException {
        long v0;
        Intrinsics.checkNotNullParameter(arg4, "source");
        if((arg4 instanceof RealBufferedSource)) {
            v0 = ((RealBufferedSource)arg4).bufferField.size();
            arg4 = ((RealBufferedSource)arg4).source;
        }
        else {
            v0 = 0;
        }

        if(((arg4 instanceof FileHandleSource)) && arg4.getFileHandle() == this) {
            if(!((FileHandleSource)arg4).getClosed()) {
                return ((FileHandleSource)arg4).getPosition() - v0;
            }
            else {
                throw new IllegalStateException("closed".toString());
            }
        }

        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long arg1, byte[] arg2, int arg3, int arg4) throws IOException;

    protected abstract void protectedResize(long arg1) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long arg1, byte[] arg2, int arg3, int arg4) throws IOException;

    public final int read(long arg3, byte[] arg5, int arg6, int arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "array");
        ReentrantLock v1 = this.lock;
        ((Lock)v1).lock();
        try {
            if(this.closed) {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            goto label_18;
        }

        ((Lock)v1).unlock();
        return this.protectedRead(arg3, arg5, arg6, arg7);
        try {
        label_11:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v0) {
        label_18:
            ((Lock)v1).unlock();
            throw v0;
        }
    }

    public final long read(long arg3, Buffer arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        ReentrantLock v1 = this.lock;
        ((Lock)v1).lock();
        try {
            if(this.closed) {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            goto label_18;
        }

        ((Lock)v1).unlock();
        return this.readNoCloseCheck(arg3, arg5, arg6);
        try {
        label_11:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v0) {
        label_18:
            ((Lock)v1).unlock();
            throw v0;
        }
    }

    private final long readNoCloseCheck(long arg15, Buffer arg17, long arg18) {
        Buffer v0 = arg17;
        long v1 = arg18;
        if(v1 >= 0) {
            v1 += arg15;
            long v4 = arg15;
            while(v4 < v1) {
                Segment v9 = v0.writableSegment$okio(1);
                int v6 = this.protectedRead(v4, v9.data, v9.limit, ((int)Math.min(v1 - v4, ((long)(0x2000 - v9.limit)))));
                if(v6 == -1) {
                    if(v9.pos == v9.limit) {
                        v0.head = v9.pop();
                        SegmentPool.recycle(v9);
                    }

                    if(arg15 != v4) {
                        break;
                    }

                    return -1;
                }
                else {
                    v9.limit += v6;
                    long v6_1 = ((long)v6);
                    v4 += v6_1;
                    v0.setSize$okio(v0.size() + v6_1);
                    continue;
                }

                break;
            }

            return v4 - arg15;
        }

        throw new IllegalArgumentException("byteCount < 0: " + v1.toString());
    }

    public final void reposition(Sink arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        String v1 = "closed";
        String v2 = "sink was not created by this FileHandle";
        if((arg5 instanceof RealBufferedSink)) {
            Sink v0 = ((RealBufferedSink)arg5).sink;
            if(((v0 instanceof FileHandleSink)) && v0.getFileHandle() == this) {
                if(!((FileHandleSink)v0).getClosed()) {
                    ((RealBufferedSink)arg5).emit();
                    ((FileHandleSink)v0).setPosition(arg6);
                    return;
                }
                else {
                    throw new IllegalStateException(v1.toString());
                }
            }

            throw new IllegalArgumentException(v2.toString());
        }

        if(((arg5 instanceof FileHandleSink)) && arg5.getFileHandle() == this) {
            if(!((FileHandleSink)arg5).getClosed()) {
                ((FileHandleSink)arg5).setPosition(arg6);
                return;
            }
            else {
                throw new IllegalStateException(v1.toString());
            }
        }

        throw new IllegalArgumentException(v2.toString());
    }

    public final void reposition(Source arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "source");
        String v1 = "closed";
        String v2 = "source was not created by this FileHandle";
        if((arg8 instanceof RealBufferedSource)) {
            Source v0 = ((RealBufferedSource)arg8).source;
            if(((v0 instanceof FileHandleSource)) && v0.getFileHandle() == this) {
                if(!((FileHandleSource)v0).getClosed()) {
                    long v1_1 = ((RealBufferedSource)arg8).bufferField.size();
                    long v3 = arg9 - (((FileHandleSource)v0).getPosition() - v1_1);
                    if(0 <= v3 && v3 < v1_1) {
                        ((RealBufferedSource)arg8).skip(v3);
                        return;
                    }

                    ((RealBufferedSource)arg8).bufferField.clear();
                    ((FileHandleSource)v0).setPosition(arg9);
                    return;
                }
                else {
                    throw new IllegalStateException(v1.toString());
                }
            }

            throw new IllegalArgumentException(v2.toString());
        }

        if(((arg8 instanceof FileHandleSource)) && arg8.getFileHandle() == this) {
            if(!((FileHandleSource)arg8).getClosed()) {
                ((FileHandleSource)arg8).setPosition(arg9);
                return;
            }
            else {
                throw new IllegalStateException(v1.toString());
            }
        }

        throw new IllegalArgumentException(v2.toString());
    }

    public final void resize(long arg3) throws IOException {
        if(!this.readWrite) {
            goto label_18;
        }

        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.closed) {
                goto label_10;
            }
        }
        catch(Throwable v2) {
            goto label_16;
        }

        ((Lock)v0).unlock();
        this.protectedResize(arg3);
        return;
        try {
        label_10:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v2) {
        label_16:
            ((Lock)v0).unlock();
            throw v2;
        }

    label_18:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final Sink sink(long arg3) throws IOException {
        if(!this.readWrite) {
            goto label_21;
        }

        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.closed) {
                goto label_13;
            }

            ++this.openStreamCount;
        }
        catch(Throwable v2) {
            goto label_19;
        }

        ((Lock)v0).unlock();
        return new FileHandleSink(this, arg3);
        try {
        label_13:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v2) {
        label_19:
            ((Lock)v0).unlock();
            throw v2;
        }

    label_21:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public static Sink sink$default(FileHandle arg0, long arg1, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = 0;
            }

            return arg0.sink(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public final long size() throws IOException {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.closed) {
                goto label_8;
            }
        }
        catch(Throwable v2) {
            goto label_14;
        }

        ((Lock)v0).unlock();
        return this.protectedSize();
        try {
        label_8:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v2) {
        label_14:
            ((Lock)v0).unlock();
            throw v2;
        }
    }

    public final Source source(long arg3) throws IOException {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.closed) {
                goto label_11;
            }

            ++this.openStreamCount;
        }
        catch(Throwable v2) {
            goto label_17;
        }

        ((Lock)v0).unlock();
        return new FileHandleSource(this, arg3);
        try {
        label_11:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v2) {
        label_17:
            ((Lock)v0).unlock();
            throw v2;
        }
    }

    public static Source source$default(FileHandle arg0, long arg1, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = 0;
            }

            return arg0.source(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    public final void write(long arg3, Buffer arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "source");
        if(!this.readWrite) {
            goto label_22;
        }

        ReentrantLock v1 = this.lock;
        ((Lock)v1).lock();
        try {
            if(this.closed) {
                goto label_13;
            }
        }
        catch(Throwable v0) {
            goto label_20;
        }

        ((Lock)v1).unlock();
        this.writeNoCloseCheck(arg3, arg5, arg6);
        return;
        try {
        label_13:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v0) {
        label_20:
            ((Lock)v1).unlock();
            throw v0;
        }

    label_22:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    public final void write(long arg3, byte[] arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "array");
        if(!this.readWrite) {
            goto label_22;
        }

        ReentrantLock v1 = this.lock;
        ((Lock)v1).lock();
        try {
            if(this.closed) {
                goto label_13;
            }
        }
        catch(Throwable v0) {
            goto label_20;
        }

        ((Lock)v1).unlock();
        this.protectedWrite(arg3, arg5, arg6, arg7);
        return;
        try {
        label_13:
            throw new IllegalStateException("closed".toString());
        }
        catch(Throwable v0) {
        label_20:
            ((Lock)v1).unlock();
            throw v0;
        }

    label_22:
        throw new IllegalStateException("file handle is read-only".toString());
    }

    private final void writeNoCloseCheck(long arg8, Buffer arg10, long arg11) {
        -SegmentedByteString.checkOffsetAndCount(arg10.size(), 0, arg11);
        arg11 = arg8 + arg11;
        long v1 = arg8;
        while(v1 < arg11) {
            Segment v8 = arg10.head;
            Intrinsics.checkNotNull(v8);
            int v5 = ((int)Math.min(arg11 - v1, ((long)(v8.limit - v8.pos))));
            FileHandle v0 = this;
            v0.protectedWrite(v1, v8.data, v8.pos, v5);
            v8.pos += v5;
            long v3 = ((long)v5);
            v1 += v3;
            arg10.setSize$okio(arg10.size() - v3);
            if(v8.pos == v8.limit) {
                arg10.head = v8.pop();
                SegmentPool.recycle(v8);
            }

            this = v0;
        }
    }
}

