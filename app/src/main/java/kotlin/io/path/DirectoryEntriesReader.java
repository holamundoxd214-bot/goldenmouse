package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\r\u001A\b\u0012\u0004\u0012\u00020\n0\u000E2\u0006\u0010\t\u001A\u00020\nH\u0086\u0080\u0004J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0018\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u0015\u0010\u0003\u001A\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lkotlin/io/path/DirectoryEntriesReader;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "followLinks", "", "<init>", "(Z)V", "getFollowLinks", "()Z", "directoryNode", "Lkotlin/io/path/PathNode;", "entries", "Lkotlin/collections/ArrayDeque;", "readEntries", "", "preVisitDirectory", "Ljava/nio/file/FileVisitResult;", "dir", "attrs", "Ljava/nio/file/attribute/BasicFileAttributes;", "visitFile", "file", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) final class DirectoryEntriesReader extends SimpleFileVisitor {
    private PathNode directoryNode;
    private ArrayDeque entries;
    private final boolean followLinks;

    public DirectoryEntriesReader(boolean arg1) {
        super();
        this.followLinks = arg1;
        this.entries = new ArrayDeque();
    }

    public final boolean getFollowLinks() {
        return this.followLinks;
    }

    public FileVisitResult preVisitDirectory(Object arg1, BasicFileAttributes arg2) {
        return this.preVisitDirectory(((Path)arg1), arg2);
    }

    public FileVisitResult preVisitDirectory(Path arg4, BasicFileAttributes arg5) {
        Intrinsics.checkNotNullParameter(arg4, "dir");
        Intrinsics.checkNotNullParameter(arg5, "attrs");
        this.entries.add(new PathNode(arg4, arg5.fileKey(), this.directoryNode));
        FileVisitResult v3 = super.preVisitDirectory(arg4, arg5);
        Intrinsics.checkNotNullExpressionValue(v3, "preVisitDirectory(...)");
        return v3;
    }

    public final List readEntries(PathNode arg4) {
        Intrinsics.checkNotNullParameter(arg4, "directoryNode");
        this.directoryNode = arg4;
        Files.walkFileTree(arg4.getPath(), LinkFollowing.INSTANCE.toVisitOptions(this.followLinks), 1, this);
        this.entries.removeFirst();
        ArrayDeque v4 = this.entries;
        this.entries = new ArrayDeque();
        return ((List)v4);
    }

    public FileVisitResult visitFile(Object arg1, BasicFileAttributes arg2) {
        return this.visitFile(((Path)arg1), arg2);
    }

    public FileVisitResult visitFile(Path arg4, BasicFileAttributes arg5) {
        Intrinsics.checkNotNullParameter(arg4, "file");
        Intrinsics.checkNotNullParameter(arg5, "attrs");
        this.entries.add(new PathNode(arg4, null, this.directoryNode));
        FileVisitResult v3 = super.visitFile(arg4, arg5);
        Intrinsics.checkNotNullExpressionValue(v3, "visitFile(...)");
        return v3;
    }
}

