package okio;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B7\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003H\u0016J\u0010\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003H\u0002J\u0012\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\r\u001A\u00020\u0003H\u0016J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0003H\u0016J \u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016H\u0016J\u0016\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001A\u001A\u00020\u0003H\u0016J\u0018\u0010\u001B\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u0003H\u0016J \u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u0016H\u0002J\u0010\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0013\u001A\u00020\u0003H\u0016J\u0018\u0010\u001F\u001A\u00020 2\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010!\u001A\u00020 2\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0016H\u0016J\u0018\u0010\"\u001A\u00020#2\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010$\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010%\u001A\u00020\u0003H\u0016J\u0018\u0010&\u001A\u00020#2\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0016H\u0016J\u0018\u0010\'\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010%\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", "comment", "", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "canonicalize", "path", "canonicalizeInternal", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "", "mustExist", "list", "", "dir", "listOrNull", "throwOnFailure", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", "target", "delete", "createSymlink", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ZipFileSystem extends FileSystem {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lokio/ZipFileSystem$Companion;", "", "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    private static final Companion Companion;
    private static final Path ROOT;
    private final String comment;
    private final Map entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    static {
        ZipFileSystem.Companion = new Companion(null);
        ZipFileSystem.ROOT = okio.Path$Companion.get$default(Path.Companion, "/", false, 1, null);
    }

    public ZipFileSystem(Path arg2, FileSystem arg3, Map arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg2, "zipPath");
        Intrinsics.checkNotNullParameter(arg3, "fileSystem");
        Intrinsics.checkNotNullParameter(arg4, "entries");
        super();
        this.zipPath = arg2;
        this.fileSystem = arg3;
        this.entries = arg4;
        this.comment = arg5;
    }

    public static final Path access$getROOT$cp() {
        return ZipFileSystem.ROOT;
    }

    public Sink appendingSink(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException("zip file systems are read-only");
    }

    public void atomicMove(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "target");
        throw new IOException("zip file systems are read-only");
    }

    public Path canonicalize(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        Path v0 = this.canonicalizeInternal(arg2);
        if(this.entries.containsKey(v0)) {
            return v0;
        }

        throw new FileNotFoundException(String.valueOf(arg2));
    }

    private final Path canonicalizeInternal(Path arg2) {
        return ZipFileSystem.ROOT.resolve(arg2, true);
    }

    public void createDirectory(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "dir");
        throw new IOException("zip file systems are read-only");
    }

    public void createSymlink(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "target");
        throw new IOException("zip file systems are read-only");
    }

    public void delete(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        throw new IOException("zip file systems are read-only");
    }

    private final List list(Path arg2, boolean arg3) {
        Object v1 = this.entries.get(this.canonicalizeInternal(arg2));
        if(v1 == null) {
            if(!arg3) {
                return null;
            }

            throw new IOException("not a directory: " + arg2);
        }

        return CollectionsKt.toList(((ZipEntry)v1).getChildren());
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

    public FileMetadata metadataOrNull(Path arg14) {
        Throwable v13_1;
        Throwable v14_2;
        ZipEntry v14_1;
        BufferedSource v2;
        Intrinsics.checkNotNullParameter(arg14, "path");
        Object v14 = this.entries.get(this.canonicalizeInternal(arg14));
        FileMetadata v1 = null;
        if(v14 == null) {
            return v1;
        }

        if(((ZipEntry)v14).getOffset() != -1) {
            FileHandle v13 = this.fileSystem.openReadOnly(this.zipPath);
            try {
                v2 = Okio.buffer(v13.source(((ZipEntry)v14).getOffset()));
            }
            catch(Throwable v0) {
                goto label_48;
            }

            BufferedSource v0_1 = v2;
            try {
                v14_1 = ZipFilesKt.readLocalHeader(v0_1, ((ZipEntry)v14));
                if(v2 == null) {
                    goto label_26;
                }
            }
            catch(Throwable v0) {
                v14_2 = v0;
                if(v2 != null) {
                    try {
                        ((Closeable)v2).close();
                        goto label_35;
                    }
                    catch(Throwable v0) {
                        try {
                            ExceptionsKt.addSuppressed(v14_2, v0);
                        label_35:
                            v0 = v14_2;
                            v14_1 = ((ZipEntry)v1);
                            goto label_37;
                        }
                        catch(Throwable v0) {
                            goto label_48;
                        }
                    }
                }
                else {
                    goto label_35;
                }

                goto label_26;
            }

            try {
                ((Closeable)v2).close();
            }
            catch(Throwable v0) {
                goto label_37;
            }

        label_26:
            v0 = ((Throwable)v1);
        label_37:
            if(v0 == null) {
                if(v13 != null) {
                    try {
                        ((Closeable)v13).close();
                    }
                    catch(Throwable v0) {
                        v13_1 = v0;
                        goto label_57;
                    }
                }

                v13_1 = ((Throwable)v1);
                goto label_57;
            }

            try {
                throw v0;
            }
            catch(Throwable v0) {
            label_48:
                v14_2 = v0;
                if(v13 != null) {
                    try {
                        ((Closeable)v13).close();
                    }
                    catch(Throwable v0) {
                        ExceptionsKt.addSuppressed(v14_2, v0);
                    }
                }

                v13_1 = v14_2;
                v14_1 = ((ZipEntry)v1);
            }

        label_57:
            if(v13_1 == null) {
            }
            else {
                throw v13_1;
            }
        }

        int v3 = v14_1.isDirectory() ^ 1;
        boolean v4 = v14_1.isDirectory();
        if(v14_1.isDirectory()) {
        }
        else {
            Long v1_1 = Long.valueOf(v14_1.getSize());
        }

        return new FileMetadata(((boolean)v3), v4, null, ((Long)v1), v14_1.getCreatedAtMillis$okio(), v14_1.getLastModifiedAtMillis$okio(), v14_1.getLastAccessedAtMillis$okio(), null, 0x80, null);
    }

    public FileHandle openReadOnly(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public FileHandle openReadWrite(Path arg1, boolean arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException("zip entries are not writable");
    }

    public Sink sink(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException("zip file systems are read-only");
    }

    public Source source(Path arg7) throws IOException {
        BufferedSource v1_1;
        Intrinsics.checkNotNullParameter(arg7, "file");
        Object v0 = this.entries.get(this.canonicalizeInternal(arg7));
        if(v0 != null) {
            FileHandle v6 = this.fileSystem.openReadOnly(this.zipPath);
            Throwable v7 = null;
            try {
                v1_1 = Okio.buffer(v6.source(((ZipEntry)v0).getOffset()));
                if(v6 == null) {
                    goto label_18;
                }
            }
            catch(Throwable v1) {
                if(v6 == null) {
                    goto label_28;
                }

                try {
                    ((Closeable)v6).close();
                }
                catch(Throwable v6_1) {
                    ExceptionsKt.addSuppressed(v1, v6_1);
                }

                goto label_28;
            }

            try {
                ((Closeable)v6).close();
            }
            catch(Throwable v7) {
            }

        label_18:
            BufferedSource v5 = v1_1;
            v1 = v7;
            BufferedSource v7_1 = v5;
        label_28:
            if(v1 == null) {
                ZipFilesKt.skipLocalHeader(((BufferedSource)v7));
                FixedLengthSource v6_2 = ((ZipEntry)v0).getCompressionMethod() == 0 ? new FixedLengthSource(((Source)v7), ((ZipEntry)v0).getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(((Source)v7), ((ZipEntry)v0).getCompressedSize(), true), new Inflater(true)), ((ZipEntry)v0).getSize(), false);
                return ((Source)v6_2);
            }

            throw v1;
        }

        throw new FileNotFoundException("no such file: " + arg7);
    }
}

