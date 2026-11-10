package kotlin.io.path;

import java.nio.file.FileVisitor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001A\u00020\u000F26\u0010\u0010\u001A2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0080\u0004JB\u0010\t\u001A\u00020\u000F26\u0010\u0010\u001A2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0080\u0004JB\u0010\n\u001A\u00020\u000F26\u0010\u0010\u001A2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0080\u0004JD\u0010\f\u001A\u00020\u000F28\u0010\u0010\u001A4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b0\u0005H\u0096\u0080\u0004J\u0010\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\u0080\u0004J\n\u0010\u0019\u001A\u00020\u000FH\u0082\u0080\u0004J\u001C\u0010\u001A\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0012\u001A\u00020\u001CH\u0082\u0080\u0004R#\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R#\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R#\u0010\n\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R%\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u000EX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlin/io/path/FileVisitorBuilderImpl;", "Lkotlin/io/path/FileVisitorBuilder;", "<init>", "()V", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/Path;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "isBuilt", "", "", "function", "Lkotlin/ParameterName;", "name", "directory", "attributes", "file", "exception", "build", "Ljava/nio/file/FileVisitor;", "checkIsNotBuilt", "checkNotDefined", "", "", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FileVisitorBuilderImpl implements FileVisitorBuilder {
    private boolean isBuilt;
    private Function2 onPostVisitDirectory;
    private Function2 onPreVisitDirectory;
    private Function2 onVisitFile;
    private Function2 onVisitFileFailed;

    public FileVisitorBuilderImpl() {
        super();
    }

    public final FileVisitor build() {
        this.checkIsNotBuilt();
        this.isBuilt = true;
        return new FileVisitorImpl(this.onPreVisitDirectory, this.onVisitFile, this.onVisitFileFailed, this.onPostVisitDirectory);
    }

    private final void checkIsNotBuilt() {
        if(!this.isBuilt) {
            return;
        }

        throw new IllegalStateException("This builder was already built");
    }

    private final void checkNotDefined(Object arg1, String arg2) {
        if(arg1 == null) {
            return;
        }

        throw new IllegalStateException(arg2 + " was already defined");
    }

    public void onPostVisitDirectory(Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "function");
        this.checkIsNotBuilt();
        this.checkNotDefined(this.onPostVisitDirectory, "onPostVisitDirectory");
        this.onPostVisitDirectory = arg3;
    }

    public void onPreVisitDirectory(Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "function");
        this.checkIsNotBuilt();
        this.checkNotDefined(this.onPreVisitDirectory, "onPreVisitDirectory");
        this.onPreVisitDirectory = arg3;
    }

    public void onVisitFile(Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "function");
        this.checkIsNotBuilt();
        this.checkNotDefined(this.onVisitFile, "onVisitFile");
        this.onVisitFile = arg3;
    }

    public void onVisitFileFailed(Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "function");
        this.checkIsNotBuilt();
        this.checkNotDefined(this.onVisitFileFailed, "onVisitFileFailed");
        this.onVisitFileFailed = arg3;
    }
}

