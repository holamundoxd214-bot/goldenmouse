package kotlin.io;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001B\u001C\u001DB\u008B\u0001\bB\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u00128\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u001B\bP\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0016J\u0010\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0082\u0004J\u001E\u0010\u0006\u001A\u00020\u00002\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0086\u0080\u0004J\u001E\u0010\t\u001A\u00020\u00002\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0007H\u0086\u0080\u0004J$\u0010\u000B\u001A\u00020\u00002\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\fH\u0086\u0080\u0004J\u0012\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\u0013H\u0086\u0080\u0004R\u000F\u0010\u0003\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001D\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000RA\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0012\u001A\u00020\u0013X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "iterator", "", "function", "depth", "WalkState", "DirectoryState", "FileTreeWalkIterator", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FileTreeWalk implements Sequence {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) abstract class DirectoryState extends WalkState {
        public DirectoryState(File arg2) {
            Intrinsics.checkNotNullParameter(arg2, "rootDir");
            super(arg2);
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000E\u000F\u0010B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\b\u001A\u00020\tH\u0094\u0080\u0004J\u0012\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0082\u0080\u0004J\f\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0082\u0090\u0004R\u0015\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "TopDownDirectoryState", "SingleFileState", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class FileTreeWalkIterator extends AbstractIterator {
        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u000E\u001A\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\nR\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", "", "fileList", "", "[Ljava/io/File;", "fileIndex", "", "failed", "step", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;

            public BottomUpDirectoryState(FileTreeWalkIterator arg2, File arg3) {
                Intrinsics.checkNotNullParameter(arg3, "rootDir");
                FileTreeWalkIterator.this = arg2;
                super(arg3);
            }

            public File step() {
                File[] v0_1;
                Function1 v0;
                File v1 = null;
                if(!this.failed && this.fileList == null) {
                    v0 = FileTreeWalkIterator.this.this$0.onEnter;
                    if(v0 != null && !v0.invoke(this.getRoot()).booleanValue()) {
                        return v1;
                    }

                    v0_1 = this.getRoot().listFiles();
                    this.fileList = v0_1;
                    if(v0_1 != null) {
                        goto label_33;
                    }

                    Function2 v0_2 = FileTreeWalkIterator.this.this$0.onFail;
                    if(v0_2 != null) {
                        v0_2.invoke(this.getRoot(), new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                    }

                    this.failed = true;
                }

            label_33:
                v0_1 = this.fileList;
                if(v0_1 != null) {
                    int v3 = this.fileIndex;
                    Intrinsics.checkNotNull(v0_1);
                    if(v3 < v0_1.length) {
                        v0_1 = this.fileList;
                        Intrinsics.checkNotNull(v0_1);
                        int v1_1 = this.fileIndex;
                        this.fileIndex = v1_1 + 1;
                        return v0_1[v1_1];
                    }
                }

                if(!this.rootVisited) {
                    this.rootVisited = true;
                    return this.getRoot();
                }

                v0 = FileTreeWalkIterator.this.this$0.onLeave;
                if(v0 != null) {
                    v0.invoke(this.getRoot());
                }

                return v1;
            }
        }

        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SingleFileState extends WalkState {
            private boolean visited;

            public SingleFileState(FileTreeWalkIterator arg2, File arg3) {
                Intrinsics.checkNotNullParameter(arg3, "rootFile");
                FileTreeWalkIterator.this = arg2;
                super(arg3);
            }

            public File step() {
                if(this.visited) {
                    return null;
                }

                this.visited = true;
                return this.getRoot();
            }
        }

        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\r\u001A\u0004\u0018\u00010\u0003H\u0096\u0080\u0004R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\nR\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", "", "fileList", "", "[Ljava/io/File;", "fileIndex", "", "step", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;

            public TopDownDirectoryState(FileTreeWalkIterator arg2, File arg3) {
                Intrinsics.checkNotNullParameter(arg3, "rootDir");
                FileTreeWalkIterator.this = arg2;
                super(arg3);
            }

            public File step() {
                Function1 v0;
                File v1 = null;
                if(!this.rootVisited) {
                    v0 = FileTreeWalkIterator.this.this$0.onEnter;
                    if(v0 != null && !v0.invoke(this.getRoot()).booleanValue()) {
                        return v1;
                    }

                    this.rootVisited = true;
                    return this.getRoot();
                }

                File[] v0_1 = this.fileList;
                if(v0_1 != null) {
                    int v2 = this.fileIndex;
                    Intrinsics.checkNotNull(v0_1);
                    if(v2 < v0_1.length) {
                    }
                    else {
                        v0 = FileTreeWalkIterator.this.this$0.onLeave;
                        if(v0 != null) {
                            v0.invoke(this.getRoot());
                        }

                        return v1;
                    }
                }

                if(this.fileList == null) {
                    v0_1 = this.getRoot().listFiles();
                    this.fileList = v0_1;
                    if(v0_1 == null) {
                        Function2 v0_2 = FileTreeWalkIterator.this.this$0.onFail;
                        if(v0_2 != null) {
                            v0_2.invoke(this.getRoot(), new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                    }

                    v0_1 = this.fileList;
                    if(v0_1 != null) {
                        Intrinsics.checkNotNull(v0_1);
                        if(v0_1.length == 0) {
                            goto label_54;
                        }

                        goto label_61;
                    }

                label_54:
                    v0 = FileTreeWalkIterator.this.this$0.onLeave;
                    if(v0 != null) {
                        v0.invoke(this.getRoot());
                    }

                    return v1;
                }

            label_61:
                v0_1 = this.fileList;
                Intrinsics.checkNotNull(v0_1);
                int v1_1 = this.fileIndex;
                this.fileIndex = v1_1 + 1;
                return v0_1[v1_1];
            }
        }

        @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
            static {
                int[] v0 = new int[FileWalkDirection.values().length];
                try {
                    v0[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                    label_11:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }

        private final ArrayDeque state;

        public FileTreeWalkIterator(FileTreeWalk arg3) {
            FileTreeWalk.this = arg3;
            super();
            ArrayDeque v0 = new ArrayDeque();
            this.state = v0;
            if(arg3.start.isDirectory()) {
                v0.push(this.directoryState(arg3.start));
                return;
            }

            if(arg3.start.isFile()) {
                v0.push(new SingleFileState(this, arg3.start));
                return;
            }

            this.done();
        }

        protected void computeNext() {
            File v0 = this.gotoNext();
            if(v0 != null) {
                this.setNext(v0);
                return;
            }

            this.done();
        }

        private final DirectoryState directoryState(File arg3) {
            int v0 = WhenMappings.$EnumSwitchMapping$0[FileTreeWalk.this.direction.ordinal()];
            if(v0 != 1) {
                if(v0 == 2) {
                    return new BottomUpDirectoryState(this, arg3);
                }

                throw new NoWhenBranchMatchedException();
            }

            return new TopDownDirectoryState(this, arg3);
        }

        private final File gotoNext() {
            File v1;
            while(true) {
                Object v0 = this.state.peek();
                if(v0 == null) {
                    return null;
                }

                v1 = ((WalkState)v0).step();
                if(v1 == null) {
                    this.state.pop();
                    continue;
                }

                if(!Intrinsics.areEqual(v1, ((WalkState)v0).getRoot()) && (v1.isDirectory())) {
                    if(this.state.size() >= FileTreeWalk.this.maxDepth) {
                    }
                    else {
                        this.state.push(this.directoryState(v1));
                        continue;
                    }
                }

                return v1;
            }

            return v1;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001A\u0004\u0018\u00010\u0003H¦\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) abstract class WalkState {
        private final File root;

        public WalkState(File arg2) {
            Intrinsics.checkNotNullParameter(arg2, "root");
            super();
            this.root = arg2;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1 onEnter;
    private final Function2 onFail;
    private final Function1 onLeave;
    private final File start;

    public FileTreeWalk(File arg11, FileWalkDirection arg12) {
        Intrinsics.checkNotNullParameter(arg11, "start");
        Intrinsics.checkNotNullParameter(arg12, "direction");
        this(arg11, arg12, null, null, null, 0, 0x20, null);
    }

    FileTreeWalk(File arg8, FileWalkDirection arg9, Function1 arg10, Function1 arg11, Function2 arg12, int arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 2) != 0) {
            arg9 = FileWalkDirection.TOP_DOWN;
        }

        FileWalkDirection v2 = arg9;
        if((arg14 & 0x20) != 0) {
            arg13 = 0x7FFFFFFF;
        }

        this(arg8, v2, arg10, arg11, arg12, arg13);
    }

    public FileTreeWalk(File arg1, FileWalkDirection arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = FileWalkDirection.TOP_DOWN;
        }

        this(arg1, arg2);
    }

    private FileTreeWalk(File arg1, FileWalkDirection arg2, Function1 arg3, Function1 arg4, Function2 arg5, int arg6) {
        super();
        this.start = arg1;
        this.direction = arg2;
        this.onEnter = arg3;
        this.onLeave = arg4;
        this.onFail = arg5;
        this.maxDepth = arg6;
    }

    public static final FileWalkDirection access$getDirection$p(FileTreeWalk arg0) {
        return arg0.direction;
    }

    public static final int access$getMaxDepth$p(FileTreeWalk arg0) {
        return arg0.maxDepth;
    }

    public static final Function1 access$getOnEnter$p(FileTreeWalk arg0) {
        return arg0.onEnter;
    }

    public static final Function2 access$getOnFail$p(FileTreeWalk arg0) {
        return arg0.onFail;
    }

    public static final Function1 access$getOnLeave$p(FileTreeWalk arg0) {
        return arg0.onLeave;
    }

    public static final File access$getStart$p(FileTreeWalk arg0) {
        return arg0.start;
    }

    public Iterator iterator() {
        return new FileTreeWalkIterator(this);
    }

    public final FileTreeWalk maxDepth(int arg8) {
        if(arg8 > 0) {
            return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, arg8);
        }

        throw new IllegalArgumentException("depth must be positive, but was " + arg8 + '.');
    }

    public final FileTreeWalk onEnter(Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg9, "function");
        return new FileTreeWalk(this.start, this.direction, arg9, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2 arg9) {
        Intrinsics.checkNotNullParameter(arg9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, arg9, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, arg9, this.onFail, this.maxDepth);
    }
}

