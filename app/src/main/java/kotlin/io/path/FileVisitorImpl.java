package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B{\bF\u0012\u001A\u0010\u0003\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001A\u0010\u0007\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001C\u0010\n\u001A\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0005H\u0016J\u0018\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0005H\u0016J\u0018\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\tH\u0016J\u001A\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00022\b\u0010\u0013\u001A\u0004\u0018\u00010\tH\u0016R#\u0010\u0003\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R#\u0010\u0007\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R#\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R%\u0010\n\u001A\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "preVisitDirectory", "dir", "attrs", "visitFile", "file", "visitFileFailed", "exc", "postVisitDirectory", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) final class FileVisitorImpl extends SimpleFileVisitor {
    private final Function2 onPostVisitDirectory;
    private final Function2 onPreVisitDirectory;
    private final Function2 onVisitFile;
    private final Function2 onVisitFileFailed;

    public FileVisitorImpl(Function2 arg1, Function2 arg2, Function2 arg3, Function2 arg4) {
        super();
        this.onPreVisitDirectory = arg1;
        this.onVisitFile = arg2;
        this.onVisitFileFailed = arg3;
        this.onPostVisitDirectory = arg4;
    }

    public FileVisitResult postVisitDirectory(Object arg1, IOException arg2) {
        return this.postVisitDirectory(((Path)arg1), arg2);
    }

    public FileVisitResult postVisitDirectory(Path arg2, IOException arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        Function2 v0 = this.onPostVisitDirectory;
        if(v0 != null) {
            Object v0_1 = v0.invoke(arg2, arg3);
            if(v0_1 == null) {
            }
            else {
                return ((FileVisitResult)v0_1);
            }
        }

        FileVisitResult v1 = super.postVisitDirectory(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "postVisitDirectory(...)");
        return v1;
    }

    public FileVisitResult preVisitDirectory(Object arg1, BasicFileAttributes arg2) {
        return this.preVisitDirectory(((Path)arg1), arg2);
    }

    public FileVisitResult preVisitDirectory(Path arg2, BasicFileAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dir");
        Intrinsics.checkNotNullParameter(arg3, "attrs");
        Function2 v0 = this.onPreVisitDirectory;
        if(v0 != null) {
            Object v0_1 = v0.invoke(arg2, arg3);
            if(v0_1 == null) {
            }
            else {
                return ((FileVisitResult)v0_1);
            }
        }

        FileVisitResult v1 = super.preVisitDirectory(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "preVisitDirectory(...)");
        return v1;
    }

    public FileVisitResult visitFile(Object arg1, BasicFileAttributes arg2) {
        return this.visitFile(((Path)arg1), arg2);
    }

    public FileVisitResult visitFile(Path arg2, BasicFileAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        Intrinsics.checkNotNullParameter(arg3, "attrs");
        Function2 v0 = this.onVisitFile;
        if(v0 != null) {
            Object v0_1 = v0.invoke(arg2, arg3);
            if(v0_1 == null) {
            }
            else {
                return ((FileVisitResult)v0_1);
            }
        }

        FileVisitResult v1 = super.visitFile(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "visitFile(...)");
        return v1;
    }

    public FileVisitResult visitFileFailed(Object arg1, IOException arg2) {
        return this.visitFileFailed(((Path)arg1), arg2);
    }

    public FileVisitResult visitFileFailed(Path arg2, IOException arg3) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        Intrinsics.checkNotNullParameter(arg3, "exc");
        Function2 v0 = this.onVisitFileFailed;
        if(v0 != null) {
            Object v0_1 = v0.invoke(arg2, arg3);
            if(v0_1 == null) {
            }
            else {
                return ((FileVisitResult)v0_1);
            }
        }

        FileVisitResult v1 = super.visitFileFailed(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "visitFileFailed(...)");
        return v1;
    }
}

