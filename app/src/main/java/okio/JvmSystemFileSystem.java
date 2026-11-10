package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0016J\u0012\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001A\u00020\u0005H\u0016J\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J\u0018\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J \u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0002J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0005H\u0016J \u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u000EH\u0016J\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u0005H\u0016J\u0018\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u000EH\u0016J\u0018\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u000EH\u0016J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u000EH\u0016J\u0018\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u0005H\u0016J\u0018\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u000EH\u0016J\u0018\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u0005H\u0016J\b\u0010 \u001A\u00020!H\u0016J\f\u0010\"\u001A\u00020\u001B*\u00020\u0005H\u0002J\f\u0010#\u001A\u00020\u001B*\u00020\u0005H\u0002¨\u0006$"}, d2={"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "<init>", "()V", "canonicalize", "Lokio/Path;", "path", "metadataOrNull", "Lokio/FileMetadata;", "list", "", "dir", "listOrNull", "throwOnFailure", "", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", "target", "delete", "createSymlink", "toString", "", "requireExist", "requireCreate", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class JvmSystemFileSystem extends FileSystem {
    public JvmSystemFileSystem() {
        super();
    }

    public Sink appendingSink(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        if(arg3) {
            this.requireExist(arg2);
        }

        return Okio.sink(arg2.toFile(), true);
    }

    public void atomicMove(Path arg3, Path arg4) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "target");
        if(arg3.toFile().renameTo(arg4.toFile())) {
            return;
        }

        throw new IOException("failed to move " + arg3 + " to " + arg4);
    }

    public Path canonicalize(Path arg4) {
        Intrinsics.checkNotNullParameter(arg4, "path");
        File v3 = arg4.toFile().getCanonicalFile();
        if(v3.exists()) {
            Companion v4 = Path.Companion;
            Intrinsics.checkNotNull(v3);
            return Companion.get$default(v4, v3, false, 1, null);
        }

        throw new FileNotFoundException("no such file");
    }

    public void createDirectory(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        if(!arg2.toFile().mkdir()) {
            FileMetadata v1 = this.metadataOrNull(arg2);
            if(v1 != null && (v1.isDirectory())) {
                if(!arg3) {
                    return;
                }
                else {
                    throw new IOException(arg2 + " already exists.");
                }
            }

            throw new IOException("failed to create directory: " + arg2);
        }
    }

    public void createSymlink(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "target");
        throw new IOException("unsupported");
    }

    public void delete(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        if(!Thread.interrupted()) {
            File v1 = arg2.toFile();
            if(!v1.delete()) {
                if(v1.exists()) {
                    throw new IOException("failed to delete " + arg2);
                }
                else if(!arg3) {
                }
                else {
                    throw new FileNotFoundException("no such file: " + arg2);
                }
            }

            return;
        }

        throw new InterruptedIOException("interrupted");
    }

    private final List list(Path arg4, boolean arg5) {
        File v3 = arg4.toFile();
        String[] v0 = v3.list();
        if(v0 == null) {
            if(arg5) {
                if(!v3.exists()) {
                    throw new FileNotFoundException("no such file: " + arg4);
                }

                throw new IOException("failed to list " + arg4);
            }

            return null;
        }

        ArrayList v3_1 = new ArrayList();
        int v5 = v0.length;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            String v2 = v0[v1];
            Intrinsics.checkNotNull(v2);
            ((Collection)v3_1).add(arg4.resolve(v2));
        }

        CollectionsKt.sort(((List)v3_1));
        return ((List)v3_1);
    }

    public List list(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        List v1 = this.list(arg2, true);
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public List listOrNull(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        return this.list(arg2, false);
    }

    public FileMetadata metadataOrNull(Path arg12) {
        Intrinsics.checkNotNullParameter(arg12, "path");
        File v11 = arg12.toFile();
        boolean v1 = v11.isFile();
        boolean v2 = v11.isDirectory();
        long v3 = v11.lastModified();
        long v5 = v11.length();
        if(!v1 && !v2) {
            long v7 = 0;
            if(v3 == v7 && v5 == v7 && !v11.exists()) {
                return null;
            }
        }

        return new FileMetadata(v1, v2, null, Long.valueOf(v5), null, Long.valueOf(v3), null, null, 0x80, null);
    }

    public FileHandle openReadOnly(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return new JvmFileHandle(false, new RandomAccessFile(arg3.toFile(), "r"));
    }

    public FileHandle openReadWrite(Path arg2, boolean arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        if(arg3) {
            if(!arg4) {
            }
            else {
                throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
            }
        }

        if(arg3) {
            this.requireCreate(arg2);
        }

        if(arg4) {
            this.requireExist(arg2);
        }

        return new JvmFileHandle(true, new RandomAccessFile(arg2.toFile(), "rw"));
    }

    private final void requireCreate(Path arg2) {
        if(!this.exists(arg2)) {
            return;
        }

        throw new IOException(arg2 + " already exists.");
    }

    private final void requireExist(Path arg2) {
        if(this.exists(arg2)) {
            return;
        }

        throw new IOException(arg2 + " doesn\'t exist.");
    }

    public Sink sink(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        if(arg3) {
            this.requireCreate(arg2);
        }

        return Okio.sink$default(arg2.toFile(), false, 1, null);
    }

    public Source source(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        return Okio.source(arg1.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}

