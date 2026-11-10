package com.flyfishxu.kadb.cert;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.UStringsKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path$Companion;
import okio.Path;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\u000BH\u0016J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\t2\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\u0018\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\tH\u0002J\u0010\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\u0018\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\tH\u0002J\u0018\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\u0010\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0003H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/flyfishxu/kadb/cert/OkioFilePrivateKeyStore;", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "privateKeyPath", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "<init>", "(Lokio/Path;Lokio/FileSystem;)V", "readPrivateKeyPem", "", "writePrivateKeyPemAtomic", "", "privateKeyPem", "clear", "readOrNull", "path", "writeAtomic", "payload", "deleteIfExists", "stageWrite", "commitStagedWrite", "tempPath", "cleanupTemp", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class OkioFilePrivateKeyStore implements KadbPrivateKeyStore {
    private final FileSystem fileSystem;
    private final Path privateKeyPath;

    public OkioFilePrivateKeyStore(Path arg1, FileSystem arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = FileSystem.SYSTEM;
        }

        this(arg1, arg2);
    }

    public OkioFilePrivateKeyStore(Path arg2, FileSystem arg3) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPath");
        Intrinsics.checkNotNullParameter(arg3, "fileSystem");
        super();
        this.privateKeyPath = arg2;
        this.fileSystem = arg3;
    }

    private final void cleanupTemp(Path arg2) {
        if(this.fileSystem.exists(arg2)) {
            try {
                this.fileSystem.delete(arg2);
                Result.constructor-impl(Unit.INSTANCE);
                return;
            }
            catch(Throwable v1) {
                Result.constructor-impl(ResultKt.createFailure(v1));
            }
        }
    }

    public void clear() {
        this.deleteIfExists(this.privateKeyPath);
    }

    private final void commitStagedWrite(Path arg1, Path arg2) {
        this.fileSystem.atomicMove(arg1, arg2);
    }

    private final void deleteIfExists(Path arg2) {
        if(this.fileSystem.exists(arg2)) {
            this.fileSystem.delete(arg2);
        }
    }

    private final byte[] readOrNull(Path arg4) {
        byte[] v4_1;
        byte[] v1 = null;
        if(!this.fileSystem.exists(arg4)) {
            return v1;
        }

        BufferedSource v3 = Okio.buffer(this.fileSystem.source(arg4));
        try {
            v4_1 = v3.readByteArray();
            if(v3 == null) {
                goto label_14;
            }
        }
        catch(Throwable v4) {
            if(v3 == null) {
                goto label_24;
            }

            try {
                ((Closeable)v3).close();
            }
            catch(Throwable v3_1) {
                ExceptionsKt.addSuppressed(v4, v3_1);
            }

            goto label_24;
        }

        try {
            ((Closeable)v3).close();
        }
        catch(Throwable v1_1) {
        }

    label_14:
        Throwable v2 = v1_1;
        v1 = v4_1;
        v4 = v2;
    label_24:
        if(v4 == null) {
            return v1;
        }

        throw v4;
    }

    public byte[] readPrivateKeyPem() {
        return this.readOrNull(this.privateKeyPath);
    }

    private final Path stageWrite(Path arg5, byte[] arg6) {
        Path v0 = arg5.parent();
        if(v0 != null && !this.fileSystem.exists(v0)) {
            this.fileSystem.createDirectories(v0);
        }

        String v5 = arg5.name() + ".tmp-" + UStringsKt.toString-V7xB4Y4(UInt.constructor-impl(Random.Default.nextInt()), 16);
        Object v1 = null;
        if(v0 != null) {
            v0 = Path.resolve$default(v0, v5, false, 2, v1);
            if(v0 == null) {
                goto label_26;
            }
        }
        else {
        label_26:
            v0 = Companion.get$default(Path.Companion, v5, false, 1, v1);
        }

        BufferedSink v4 = Okio.buffer(this.fileSystem.sink(v0, false));
        try {
            v4.write(arg6);
            if(v4 == null) {
                goto label_46;
            }
        }
        catch(Throwable v5_1) {
            Throwable v1_1 = v5_1;
            if(v4 == null) {
                goto label_46;
            }

            try {
                ((Closeable)v4).close();
            }
            catch(Throwable v4_1) {
                ExceptionsKt.addSuppressed(v1_1, v4_1);
            }

            goto label_46;
        }

        try {
            ((Closeable)v4).close();
        }
        catch(Throwable v1_1) {
        }

    label_46:
        if((((Throwable)v1)) == null) {
            return v0;
        }

        throw ((Throwable)v1);
    }

    private final void writeAtomic(Path arg1, byte[] arg2) {
        Path v2 = this.stageWrite(arg1, arg2);
        try {
            this.commitStagedWrite(v2, arg1);
        }
        catch(Throwable v1) {
            this.cleanupTemp(v2);
            throw v1;
        }

        this.cleanupTemp(v2);
    }

    public void writePrivateKeyPemAtomic(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPem");
        this.writeAtomic(this.privateKeyPath, arg2);
    }
}

