package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016J\u0018\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0016J\u0010\u0010\r\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0016J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\b\u001A\u00020\u0007H\u0016J\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0012\u001A\u00020\u0007H\u0016J\u0018\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\u0007H\u0016J\u001E\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0007H\u0016J \u0010\u001B\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u0017H\u0016J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001A\u001A\u00020\u0007H\u0016J\u0018\u0010 \u001A\u00020!2\u0006\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0017H\u0016J\u0018\u0010\"\u001A\u00020!2\u0006\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u0017H\u0016J\u0018\u0010#\u001A\u00020$2\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0017H\u0016J\u0018\u0010%\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u0007H\u0016J\u0018\u0010\'\u001A\u00020$2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u0017H\u0016J\u0018\u0010(\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u0007H\u0016J\b\u0010)\u001A\u00020$H\u0016J\b\u0010*\u001A\u00020\nH\u0016R\u0013\u0010\u0002\u001A\u00020\u00018\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0005¨\u0006+"}, d2={"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "<init>", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "onPathParameter", "Lokio/Path;", "path", "functionName", "", "parameterName", "onPathResult", "canonicalize", "metadataOrNull", "Lokio/FileMetadata;", "list", "", "dir", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", "target", "delete", "createSymlink", "close", "toString", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super();
        this.delegate = arg2;
    }

    public Sink appendingSink(Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return this.delegate.appendingSink(this.onPathParameter(arg3, "appendingSink", "file"), arg4);
    }

    public void atomicMove(Path arg4, Path arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "source");
        Intrinsics.checkNotNullParameter(arg5, "target");
        this.delegate.atomicMove(this.onPathParameter(arg4, "atomicMove", "source"), this.onPathParameter(arg5, "atomicMove", "target"));
    }

    public Path canonicalize(Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "path");
        return this.onPathResult(this.delegate.canonicalize(this.onPathParameter(arg3, "canonicalize", "path")), "canonicalize");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public void createDirectory(Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "dir");
        this.delegate.createDirectory(this.onPathParameter(arg3, "createDirectory", "dir"), arg4);
    }

    public void createSymlink(Path arg4, Path arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "source");
        Intrinsics.checkNotNullParameter(arg5, "target");
        this.delegate.createSymlink(this.onPathParameter(arg4, "createSymlink", "source"), this.onPathParameter(arg5, "createSymlink", "target"));
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public void delete(Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "path");
        this.delegate.delete(this.onPathParameter(arg3, "delete", "path"), arg4);
    }

    public List list(Path arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "dir");
        String v1 = "list";
        List v4 = this.delegate.list(this.onPathParameter(arg4, v1, "dir"));
        ArrayList v0 = new ArrayList();
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            ((Collection)v0).add(this.onPathResult(v4_1.next(), v1));
        }

        CollectionsKt.sort(((List)v0));
        return ((List)v0);
    }

    public List listOrNull(Path arg4) {
        Intrinsics.checkNotNullParameter(arg4, "dir");
        String v1 = "listOrNull";
        List v4 = this.delegate.listOrNull(this.onPathParameter(arg4, v1, "dir"));
        if(v4 == null) {
            return null;
        }

        ArrayList v0 = new ArrayList();
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            ((Collection)v0).add(this.onPathResult(v4_1.next(), v1));
        }

        CollectionsKt.sort(((List)v0));
        return ((List)v0);
    }

    public Sequence listRecursively(Path arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "dir");
        return SequencesKt.map(this.delegate.listRecursively(this.onPathParameter(arg3, "listRecursively", "dir"), arg4), new ForwardingFileSystem$$ExternalSyntheticLambda0(this));
    }

    static final Path listRecursively$lambda$0(ForwardingFileSystem arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.onPathResult(arg2, "listRecursively");
    }

    public FileMetadata metadataOrNull(Path arg14) throws IOException {
        Intrinsics.checkNotNullParameter(arg14, "path");
        String v1 = "metadataOrNull";
        FileMetadata v2 = this.delegate.metadataOrNull(this.onPathParameter(arg14, v1, "path"));
        if(v2 == null) {
            return null;
        }

        if(v2.getSymlinkTarget() == null) {
            return v2;
        }

        return FileMetadata.copy$default(v2, false, false, this.onPathResult(v2.getSymlinkTarget(), v1), null, null, null, null, null, 0xFB, null);
    }

    public Path onPathParameter(Path arg1, String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        Intrinsics.checkNotNullParameter(arg2, "functionName");
        Intrinsics.checkNotNullParameter(arg3, "parameterName");
        return arg1;
    }

    public Path onPathResult(Path arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        Intrinsics.checkNotNullParameter(arg2, "functionName");
        return arg1;
    }

    public FileHandle openReadOnly(Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return this.delegate.openReadOnly(this.onPathParameter(arg3, "openReadOnly", "file"));
    }

    public FileHandle openReadWrite(Path arg3, boolean arg4, boolean arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return this.delegate.openReadWrite(this.onPathParameter(arg3, "openReadWrite", "file"), arg4, arg5);
    }

    public Sink sink(Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return this.delegate.sink(this.onPathParameter(arg3, "sink", "file"), arg4);
    }

    public Source source(Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "file");
        return this.delegate.source(this.onPathParameter(arg3, "source", "file"));
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}

