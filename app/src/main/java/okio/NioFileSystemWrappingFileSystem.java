package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.path.PathsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001A\u00020\u0007*\u00020\bH\u0002J\u0010\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016J\u0012\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\n\u001A\u00020\bH\u0016J\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\b0\u000E2\u0006\u0010\u000F\u001A\u00020\bH\u0016J\u0018\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\bH\u0016J \u0010\r\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u0012H\u0002J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\bH\u0016J \u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0012H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\bH\u0016J\u0018\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u0012H\u0016J\u0018\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0012H\u0016J\u0018\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u0012H\u0016J\u0018\u0010 \u001A\u00020\u001F2\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010!\u001A\u00020\bH\u0016J\u0018\u0010\"\u001A\u00020\u001F2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0012H\u0016J\u0018\u0010#\u001A\u00020\u001F2\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010!\u001A\u00020\bH\u0016J\b\u0010$\u001A\u00020\u001FH\u0016J\b\u0010%\u001A\u00020&H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lokio/NioFileSystemWrappingFileSystem;", "Lokio/NioSystemFileSystem;", "nioFileSystem", "Ljava/nio/file/FileSystem;", "<init>", "(Ljava/nio/file/FileSystem;)V", "resolve", "Ljava/nio/file/Path;", "Lokio/Path;", "canonicalize", "path", "metadataOrNull", "Lokio/FileMetadata;", "list", "", "dir", "listOrNull", "throwOnFailure", "", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", "target", "delete", "createSymlink", "close", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    private final FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(FileSystem arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nioFileSystem");
        super();
        this.nioFileSystem = arg2;
    }

    public Sink appendingSink(Path arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "file");
        List v0 = CollectionsKt.createListBuilder();
        v0.add(StandardOpenOption.APPEND);
        if(!arg4) {
            v0.add(StandardOpenOption.CREATE);
        }

        List v4 = CollectionsKt.build(v0);
        java.nio.file.Path v2 = this.resolve(arg3);
        Object[] v3 = ((Collection)v4).toArray(new StandardOpenOption[0]);
        v3 = Arrays.copyOf(v3, v3.length);
        OutputStream v2_1 = Files.newOutputStream(v2, Arrays.copyOf(v3, v3.length));
        Intrinsics.checkNotNullExpressionValue(v2_1, "newOutputStream(...)");
        return Okio.sink(v2_1);
    }

    public void atomicMove(Path arg4, Path arg5) {
        Intrinsics.checkNotNullParameter(arg4, "source");
        Intrinsics.checkNotNullParameter(arg5, "target");
        try {
            Intrinsics.checkNotNullExpressionValue(Files.move(this.resolve(arg4), this.resolve(arg5), Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(...)");
            return;
        }
        catch(UnsupportedOperationException ) {
            throw new IOException("atomic move not supported");
        }
        catch(NoSuchFileException v3) {
            throw new FileNotFoundException(v3.getMessage());
        }
    }

    public Path canonicalize(Path arg5) {
        Intrinsics.checkNotNullParameter(arg5, "path");
        try {
            Companion v0 = Path.Companion;
            java.nio.file.Path v4 = this.resolve(arg5).toRealPath(new LinkOption[0]);
            Intrinsics.checkNotNullExpressionValue(v4, "toRealPath(...)");
            return Companion.get$default(v0, v4, false, 1, null);
        }
        catch(NoSuchFileException ) {
            throw new FileNotFoundException("no such file: " + arg5);
        }
    }

    public void close() {
        this.nioFileSystem.close();
    }

    public void createDirectory(Path arg4, boolean arg5) {
        int v2;
        Intrinsics.checkNotNullParameter(arg4, "dir");
        FileMetadata v0 = this.metadataOrNull(arg4);
        if(v0 != null) {
            v2 = 1;
            if(v0.isDirectory()) {
            }
            else {
                goto label_9;
            }
        }
        else {
        label_9:
            v2 = 0;
        }

        if(v2 != 0) {
            if(!arg5) {
            }
            else {
                throw new IOException(arg4 + " already exists.");
            }
        }

        try {
            Intrinsics.checkNotNullExpressionValue(Files.createDirectory(this.resolve(arg4), Arrays.copyOf(new FileAttribute[0], 0)), "createDirectory(...)");
            return;
        }
        catch(IOException v3) {
            if(v2 != 0) {
                return;
            }

            throw new IOException("failed to create directory: " + arg4, ((Throwable)v3));
        }
    }

    public void createSymlink(Path arg2, Path arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "target");
        Intrinsics.checkNotNullExpressionValue(Files.createSymbolicLink(this.resolve(arg2), this.resolve(arg3), Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(...)");
    }

    public void delete(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        if(Thread.interrupted()) {
            goto label_31;
        }

        java.nio.file.Path v1 = this.resolve(arg2);
        try {
            Files.delete(v1);
            return;
        }
        catch(IOException ) {
            if(Files.exists(v1, Arrays.copyOf(new LinkOption[0], 0))) {
                goto label_13;
            }
        }
        catch(NoSuchFileException ) {
            if(!arg3) {
                return;
            }

            throw new FileNotFoundException("no such file: " + arg2);
        }

        return;
    label_13:
        throw new IOException("failed to delete " + arg2);
    label_31:
        throw new InterruptedIOException("interrupted");
    }

    private final List list(Path arg5, boolean arg6) {
        List v4_1;
        java.nio.file.Path v4 = this.resolve(arg5);
        String v2 = null;
        try {
            v4_1 = PathsKt.listDirectoryEntries$default(v4, v2, 1, v2);
        }
        catch(Exception ) {
            if(arg6) {
                if(!Files.exists(((java.nio.file.Path)v4_1), Arrays.copyOf(new LinkOption[0], 0))) {
                    throw new FileNotFoundException("no such file: " + arg5);
                }

                throw new IOException("failed to list " + arg5);
            }

            return ((List)v2);
        }

        ArrayList v5 = new ArrayList();
        Iterator v4_2 = ((Iterable)v4_1).iterator();
        while(v4_2.hasNext()) {
            ((Collection)v5).add(Companion.get$default(Path.Companion, v4_2.next(), false, 1, v2));
        }

        CollectionsKt.sort(((List)v5));
        return ((List)v5);
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

    public FileMetadata metadataOrNull(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        return this.metadataOrNull(this.resolve(arg2));
    }

    public FileHandle openReadOnly(Path arg4) {
        FileChannel v3;
        Intrinsics.checkNotNullParameter(arg4, "file");
        try {
            v3 = FileChannel.open(this.resolve(arg4), new OpenOption[]{StandardOpenOption.READ});
        }
        catch(NoSuchFileException ) {
            throw new FileNotFoundException("no such file: " + arg4);
        }

        Intrinsics.checkNotNull(v3);
        return new NioFileSystemFileHandle(false, v3);
    }

    public FileHandle openReadWrite(Path arg3, boolean arg4, boolean arg5) {
        FileChannel v2_1;
        Intrinsics.checkNotNullParameter(arg3, "file");
        if(arg4) {
            if(!arg5) {
            }
            else {
                throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
            }
        }

        List v0 = CollectionsKt.createListBuilder();
        v0.add(StandardOpenOption.READ);
        v0.add(StandardOpenOption.WRITE);
        if(arg4) {
            v0.add(StandardOpenOption.CREATE_NEW);
        }
        else if(!arg5) {
            v0.add(StandardOpenOption.CREATE);
        }

        List v4 = CollectionsKt.build(v0);
        try {
            java.nio.file.Path v2 = this.resolve(arg3);
            Object[] v4_1 = ((Collection)v4).toArray(new StandardOpenOption[0]);
            v2_1 = FileChannel.open(v2, Arrays.copyOf(v4_1, v4_1.length));
        }
        catch(NoSuchFileException ) {
            throw new FileNotFoundException("no such file: " + arg3);
        }

        Intrinsics.checkNotNull(v2_1);
        return new NioFileSystemFileHandle(true, v2_1);
    }

    private final java.nio.file.Path resolve(Path arg2) {
        java.nio.file.Path v1 = this.nioFileSystem.getPath(arg2.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(v1, "getPath(...)");
        return v1;
    }

    public Sink sink(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        List v0 = CollectionsKt.createListBuilder();
        if(arg3) {
            v0.add(StandardOpenOption.CREATE_NEW);
        }

        List v3 = CollectionsKt.build(v0);
        try {
            java.nio.file.Path v1 = this.resolve(arg2);
            Object[] v3_1 = ((Collection)v3).toArray(new StandardOpenOption[0]);
            v3_1 = Arrays.copyOf(v3_1, v3_1.length);
            OutputStream v1_1 = Files.newOutputStream(v1, Arrays.copyOf(v3_1, v3_1.length));
            Intrinsics.checkNotNullExpressionValue(v1_1, "newOutputStream(...)");
            return Okio.sink(v1_1);
        }
        catch(NoSuchFileException ) {
            throw new FileNotFoundException("no such file: " + arg2);
        }
    }

    public Source source(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "file");
        try {
            InputStream v2 = Files.newInputStream(this.resolve(arg3), Arrays.copyOf(new OpenOption[0], 0));
            Intrinsics.checkNotNullExpressionValue(v2, "newInputStream(...)");
            return Okio.source(v2);
        }
        catch(NoSuchFileException ) {
            throw new FileNotFoundException("no such file: " + arg3);
        }
    }

    public String toString() {
        String v0 = Reflection.getOrCreateKotlinClass(this.nioFileSystem.getClass()).getSimpleName();
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

