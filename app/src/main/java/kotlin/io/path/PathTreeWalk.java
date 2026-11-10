package kotlin.io.path;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0082\u0004JC\u0010\u0017\u001A\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0018\u0010\u001E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001B0 \u0012\u0004\u0012\u00020\u00180\u001FH\u0082È\u0004¢\u0006\u0002\u0010!J\u0010\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004J\u0010\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0082\u0080\u0004R\u000F\u0010\u0003\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\n\u001A\u00020\u000B8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00058BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001A\u00020\u000B8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001A\u00020\u000B8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0014\u0010\r¨\u0006$"}, d2={"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "[Lkotlin/io/path/PathWalkOption;", "followLinks", "", "getFollowLinks", "()Z", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "includeDirectories", "getIncludeDirectories", "isBFS", "iterator", "", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dfsIterator", "bfsIterator", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PathTreeWalk implements Sequence {
    private final PathWalkOption[] options;
    private final Path start;

    public PathTreeWalk(Path arg2, PathWalkOption[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "start");
        Intrinsics.checkNotNullParameter(arg3, "options");
        super();
        this.start = arg2;
        this.options = arg3;
    }

    public static final boolean access$getFollowLinks(PathTreeWalk arg0) {
        return arg0.getFollowLinks();
    }

    public static final boolean access$getIncludeDirectories(PathTreeWalk arg0) {
        return arg0.getIncludeDirectories();
    }

    public static final LinkOption[] access$getLinkOptions(PathTreeWalk arg0) {
        return arg0.getLinkOptions();
    }

    public static final Path access$getStart$p(PathTreeWalk arg0) {
        return arg0.start;
    }

    private final Iterator bfsIterator() {
        return SequencesKt.iterator(new PathTreeWalk$bfsIterator$1(this, null));
    }

    private final Iterator dfsIterator() {
        return SequencesKt.iterator(new PathTreeWalk$dfsIterator$1(this, null));
    }

    private final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    private final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(this.getFollowLinks());
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    public Iterator iterator() {
        if(this.isBFS()) {
            return this.bfsIterator();
        }

        return this.dfsIterator();
    }

    private final Object yieldIfNeeded(SequenceScope arg4, PathNode arg5, DirectoryEntriesReader arg6, Function1 arg7, Continuation arg8) {
        Path v0 = arg5.getPath();
        if(arg5.getParent() != null) {
            PathsKt.checkFileName(v0);
        }

        LinkOption[] v1 = this.getLinkOptions();
        Object[] v1_1 = Arrays.copyOf(((Object[])v1), v1.length);
        if(!Files.isDirectory(v0, Arrays.copyOf(v1_1, v1_1.length))) {
            if(!Files.exists(v0, Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                goto label_41;
            }

            arg4.yield(v0, arg8);
            return Unit.INSTANCE;
        }
        else if(!PathTreeWalkKt.access$createsCycle(arg5)) {
            if(this.getIncludeDirectories()) {
                arg4.yield(v0, arg8);
            }

            LinkOption[] v3 = this.getLinkOptions();
            Object[] v3_1 = Arrays.copyOf(((Object[])v3), v3.length);
            if(!Files.isDirectory(v0, Arrays.copyOf(v3_1, v3_1.length))) {
                goto label_41;
            }

            arg7.invoke(arg6.readEntries(arg5));
        }
        else {
            throw new FileSystemLoopException(v0.toString());
        }

    label_41:
        return Unit.INSTANCE;
    }
}

