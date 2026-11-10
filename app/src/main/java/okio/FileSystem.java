package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.internal.-FileSystem;
import okio.internal.ResourceFileSystem;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000B\b&\u0018\u0000 72\u00060\u0001j\u0002`\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H&J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u0006J\u0012\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001A\u00020\u0006H&J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\u0006J\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\u000E2\u0006\u0010\u000F\u001A\u00020\u0006H&J\u0018\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0006H&J \u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000F\u001A\u00020\u00062\b\b\u0002\u0010\u0013\u001A\u00020\fH\u0016J\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000F\u001A\u00020\u0006J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0006H&J$\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\f2\b\b\u0002\u0010\u0019\u001A\u00020\fH&J\u000E\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0006J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0016\u001A\u00020\u0006H&JG\u0010\u001C\u001A\u0002H\u001D\"\u0004\b\u0000\u0010\u001D2\u0006\u0010\u0016\u001A\u00020\u00062\u0017\u0010\u001E\u001A\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u001D0\u001F¢\u0006\u0002\b!H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\"\u0010#J\u001A\u0010$\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\fH&J\u000E\u0010$\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020\u0006JQ\u0010&\u001A\u0002H\u001D\"\u0004\b\u0000\u0010\u001D2\u0006\u0010\u0016\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\f2\u0017\u0010\'\u001A\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002H\u001D0\u001F¢\u0006\u0002\b!H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0004\b)\u0010*J\u001A\u0010+\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\fH&J\u000E\u0010+\u001A\u00020%2\u0006\u0010\u0016\u001A\u00020\u0006J\u001A\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\fH&J\u000E\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u0006J\u0018\u0010.\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\fJ\u000E\u0010.\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u0006J\u0018\u0010/\u001A\u00020-2\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u00100\u001A\u00020\u0006H&J\u0018\u00101\u001A\u00020-2\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u00100\u001A\u00020\u0006H\u0016J\u001A\u00102\u001A\u00020-2\u0006\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\fH&J\u000E\u00102\u001A\u00020-2\u0006\u0010\u0007\u001A\u00020\u0006J\u001A\u00103\u001A\u00020-2\u0006\u00104\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\fH\u0016J\u000E\u00103\u001A\u00020-2\u0006\u00104\u001A\u00020\u0006J\u0018\u00105\u001A\u00020-2\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u00100\u001A\u00020\u0006H&J\b\u00106\u001A\u00020-H\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2={"Lokio/FileSystem;", "Ljava/io/Closeable;", "Lokio/Closeable;", "<init>", "()V", "canonicalize", "Lokio/Path;", "path", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "exists", "", "list", "", "dir", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Sink;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "appendingSink", "createDirectory", "", "createDirectories", "atomicMove", "target", "copy", "delete", "deleteRecursively", "fileOrDirectory", "createSymlink", "close", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class FileSystem implements Closeable {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\t\u001A\u00020\u0005*\u00020\nH\u0007¢\u0006\u0002\b\u000BR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lokio/FileSystem$Companion;", "", "<init>", "()V", "SYSTEM", "Lokio/FileSystem;", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "RESOURCES", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final FileSystem get(java.nio.file.FileSystem arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            return new NioFileSystemWrappingFileSystem(arg1);
        }
    }

    public static final Companion Companion;
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    public final Object -read(Path arg3, Function1 arg4) throws IOException {
        Object v4_1;
        Intrinsics.checkNotNullParameter(arg3, "file");
        Intrinsics.checkNotNullParameter(arg4, "readerAction");
        BufferedSource v2 = Okio.buffer(this.source(arg3));
        Throwable v3 = null;
        try {
            v4_1 = arg4.invoke(v2);
            if(v2 == null) {
                goto label_13;
            }
        }
        catch(Throwable v4) {
            if(v2 == null) {
                goto label_23;
            }

            try {
                ((Closeable)v2).close();
            }
            catch(Throwable v2_1) {
                ExceptionsKt.addSuppressed(v4, v2_1);
            }

            goto label_23;
        }

        try {
            ((Closeable)v2).close();
        }
        catch(Throwable v3) {
        }

    label_13:
        Object v1 = v4_1;
        v4 = v3;
        Object v3_1 = v1;
    label_23:
        if(v4 == null) {
            return v3_1;
        }

        throw v4;
    }

    public final Object -write(Path arg3, boolean arg4, Function1 arg5) throws IOException {
        Object v4_1;
        Intrinsics.checkNotNullParameter(arg3, "file");
        Intrinsics.checkNotNullParameter(arg5, "writerAction");
        BufferedSink v2 = Okio.buffer(this.sink(arg3, arg4));
        Throwable v3 = null;
        try {
            v4_1 = arg5.invoke(v2);
            if(v2 == null) {
                goto label_13;
            }
        }
        catch(Throwable v4) {
            if(v2 == null) {
                goto label_23;
            }

            try {
                ((Closeable)v2).close();
            }
            catch(Throwable v2_1) {
                ExceptionsKt.addSuppressed(v4, v2_1);
            }

            goto label_23;
        }

        try {
            ((Closeable)v2).close();
        }
        catch(Throwable v3) {
        }

    label_13:
        Object v1 = v4_1;
        v4 = v3;
        Object v3_1 = v1;
    label_23:
        if(v4 == null) {
            return v3_1;
        }

        throw v4;
    }

    public static Object -write$default(FileSystem arg1, Path arg2, boolean arg3, Function1 arg4, int arg5, Object arg6) throws IOException {
        Object v3_1;
        if(arg6 == null) {
            Intrinsics.checkNotNullParameter(arg2, "file");
            Intrinsics.checkNotNullParameter(arg4, "writerAction");
            BufferedSink v1 = Okio.buffer(arg1.sink(arg2, false));
            Throwable v2 = null;
            try {
                v3_1 = arg4.invoke(v1);
                if(v1 == null) {
                    goto label_17;
                }
            }
            catch(Throwable v3) {
                if(v1 == null) {
                    goto label_27;
                }

                try {
                    ((Closeable)v1).close();
                }
                catch(Throwable v1_1) {
                    ExceptionsKt.addSuppressed(v3, v1_1);
                }

                goto label_27;
            }

            try {
                ((Closeable)v1).close();
            }
            catch(Throwable v2) {
            }

        label_17:
            Object v0 = v3_1;
            v3 = v2;
            Object v2_1 = v0;
        label_27:
            if(v3 == null) {
                return v2;
            }

            throw v3;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        NioSystemFileSystem v0;
        DefaultConstructorMarker v1 = null;
        FileSystem.Companion = new Companion(v1);
        try {
            Class.forName("java.nio.file.Files");
            v0 = new NioSystemFileSystem();
        }
        catch(ClassNotFoundException ) {
            JvmSystemFileSystem v0_1 = new JvmSystemFileSystem();
        }

        FileSystem.SYSTEM = ((FileSystem)v0);
        okio.Path$Companion v0_2 = Path.Companion;
        String v2 = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(v2, "getProperty(...)");
        FileSystem.SYSTEM_TEMPORARY_DIRECTORY = okio.Path$Companion.get$default(v0_2, v2, false, 1, v1);
        ClassLoader v2_1 = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(v2_1, "getClassLoader(...)");
        FileSystem.RESOURCES = new ResourceFileSystem(v2_1, false, null, 4, null);
    }

    public FileSystem() {
        super();
    }

    public abstract Sink appendingSink(Path arg1, boolean arg2) throws IOException;

    public final Sink appendingSink(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "file");
        return this.appendingSink(arg2, false);
    }

    public static Sink appendingSink$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            return arg0.appendingSink(arg1, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public abstract void atomicMove(Path arg1, Path arg2) throws IOException;

    public abstract Path canonicalize(Path arg1) throws IOException;

    public void close() throws IOException {
    }

    public void copy(Path arg2, Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "target");
        -FileSystem.commonCopy(this, arg2, arg3);
    }

    public final void createDirectories(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        this.createDirectories(arg2, false);
    }

    public final void createDirectories(Path arg2, boolean arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        -FileSystem.commonCreateDirectories(this, arg2, arg3);
    }

    public static void createDirectories$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            arg0.createDirectories(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public abstract void createDirectory(Path arg1, boolean arg2) throws IOException;

    public final void createDirectory(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        this.createDirectory(arg2, false);
    }

    public static void createDirectory$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            arg0.createDirectory(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public abstract void createSymlink(Path arg1, Path arg2) throws IOException;

    public final void delete(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "path");
        this.delete(arg2, false);
    }

    public abstract void delete(Path arg1, boolean arg2) throws IOException;

    public static void delete$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            arg0.delete(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public void deleteRecursively(Path arg2, boolean arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "fileOrDirectory");
        -FileSystem.commonDeleteRecursively(this, arg2, arg3);
    }

    public final void deleteRecursively(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "fileOrDirectory");
        this.deleteRecursively(arg2, false);
    }

    public static void deleteRecursively$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            arg0.deleteRecursively(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    public final boolean exists(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "path");
        return -FileSystem.commonExists(this, arg2);
    }

    @JvmStatic public static final FileSystem get(java.nio.file.FileSystem arg1) {
        return FileSystem.Companion.get(arg1);
    }

    public abstract List list(Path arg1) throws IOException;

    public abstract List listOrNull(Path arg1);

    public Sequence listRecursively(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        return -FileSystem.commonListRecursively(this, arg2, arg3);
    }

    public final Sequence listRecursively(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        return this.listRecursively(arg2, false);
    }

    public static Sequence listRecursively$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.listRecursively(arg1, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public final FileMetadata metadata(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "path");
        return -FileSystem.commonMetadata(this, arg2);
    }

    public abstract FileMetadata metadataOrNull(Path arg1) throws IOException;

    public abstract FileHandle openReadOnly(Path arg1) throws IOException;

    public abstract FileHandle openReadWrite(Path arg1, boolean arg2, boolean arg3) throws IOException;

    public final FileHandle openReadWrite(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "file");
        return this.openReadWrite(arg2, false, false);
    }

    public static FileHandle openReadWrite$default(FileSystem arg1, Path arg2, boolean arg3, boolean arg4, int arg5, Object arg6) throws IOException {
        if(arg6 == null) {
            return arg1.openReadWrite(arg2, false, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public abstract Sink sink(Path arg1, boolean arg2) throws IOException;

    public final Sink sink(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "file");
        return this.sink(arg2, false);
    }

    public static Sink sink$default(FileSystem arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        if(arg4 == null) {
            return arg0.sink(arg1, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public abstract Source source(Path arg1) throws IOException;
}

