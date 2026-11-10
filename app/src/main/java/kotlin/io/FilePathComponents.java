package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\b\u0080\b\u0018\u00002\u00020\u0001B\u001F\b@\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u0014H\u0086\u0080\u0004J\n\u0010\u001A\u001A\u00020\u0003HÆ\u0083\u0004J\u0010\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0083\u0004J)\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÀ\u0081\u0004¢\u0006\u0002\b\u001DJ\u0014\u0010\u001E\u001A\u00020\u00112\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001A\u00020\u0014HÖ\u0081\u0004J\n\u0010!\u001A\u00020\rHÖ\u0081\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001B\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\f\u001A\u00020\r8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0010\u001A\u00020\u00118FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u0015\u0010\u0013\u001A\u00020\u00148FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "getRoot", "()Ljava/io/File;", "getSegments", "()Ljava/util/List;", "rootName", "", "getRootName", "()Ljava/lang/String;", "isRooted", "", "()Z", "size", "", "getSize", "()I", "subPath", "beginIndex", "endIndex", "component1", "component2", "copy", "copy$kotlin_stdlib", "equals", "other", "hashCode", "toString", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FilePathComponents {
    private final File root;
    private final List segments;

    public FilePathComponents(File arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "root");
        Intrinsics.checkNotNullParameter(arg3, "segments");
        super();
        this.root = arg2;
        this.segments = arg3;
    }

    public final File component1() {
        return this.root;
    }

    public final List component2() {
        return this.segments;
    }

    public final FilePathComponents copy$kotlin_stdlib(File arg1, List arg2) {
        Intrinsics.checkNotNullParameter(arg1, "root");
        Intrinsics.checkNotNullParameter(arg2, "segments");
        return new FilePathComponents(arg1, arg2);
    }

    public static FilePathComponents copy$kotlin_stdlib$default(FilePathComponents arg0, File arg1, List arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.root;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.segments;
        }

        return arg0.copy$kotlin_stdlib(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((FilePathComponents)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FilePathComponents)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.root, ((FilePathComponents)arg5).root)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.segments, ((FilePathComponents)arg5).segments)) {
            return 0;
        }

        return 1;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String v1 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(v1, "getPath(...)");
        return v1;
    }

    public final List getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        return this.root.hashCode() * 0x1F + this.segments.hashCode();
    }

    public final boolean isRooted() {
        String v1 = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(v1, "getPath(...)");
        if(((CharSequence)v1).length() > 0) {
            return 1;
        }

        return 0;
    }

    public final File subPath(int arg11, int arg12) {
        if(arg11 >= 0 && arg11 <= arg12 && arg12 <= this.getSize()) {
            List v1 = this.segments.subList(arg11, arg12);
            String v10 = File.separator;
            Intrinsics.checkNotNullExpressionValue(v10, "separator");
            return new File(CollectionsKt.joinToString$default(((Iterable)v1), v10, null, null, 0, null, null, 62, null));
        }

        throw new IllegalArgumentException();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}

