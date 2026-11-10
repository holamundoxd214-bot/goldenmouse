package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal.-Path;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\rH\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0003H\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0002\b J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\r2\b\b\u0002\u0010!\u001A\u00020\u0013J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u0013J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010!\u001A\u00020\u0013J\u000E\u0010\"\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0000J\u0006\u0010$\u001A\u00020\u0000J\u0006\u0010%\u001A\u00020&J\u0006\u0010\'\u001A\u00020(J\u0011\u0010)\u001A\u00020*2\u0006\u0010#\u001A\u00020\u0000H\u0096\u0002J\u0013\u0010+\u001A\u00020\u00132\b\u0010#\u001A\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001A\u00020*H\u0016J\b\u0010.\u001A\u00020\rH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\f8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001A\u001A\u00020\r8G¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001A\u0004\b\u001C\u0010\nR\u0011\u0010\u001D\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0014¨\u00060"}, d2={"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "<init>", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "root", "getRoot", "()Lokio/Path;", "segments", "", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "isAbsolute", "", "()Z", "isRelative", "volumeLetter", "", "()Ljava/lang/Character;", "nameBytes", "name", "()Ljava/lang/String;", "parent", "isRoot", "div", "child", "resolve", "normalize", "relativeTo", "other", "normalized", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "compareTo", "", "equals", "", "hashCode", "toString", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Path implements Comparable {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0006\u001A\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001B\u0010\u000B\u001A\u00020\u0007*\u00020\f2\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001B\u0010\u000B\u001A\u00020\u0007*\u00020\r2\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lokio/Path$Companion;", "", "<init>", "()V", "DIRECTORY_SEPARATOR", "", "toPath", "Lokio/Path;", "normalize", "", "get", "toOkioPath", "Ljava/io/File;", "Ljava/nio/file/Path;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final Path get(File arg4) {
            Intrinsics.checkNotNullParameter(arg4, "<this>");
            return Companion.get$default(this, arg4, false, 1, null);
        }

        @JvmStatic public final Path get(File arg2, boolean arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            String v2 = arg2.toString();
            Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
            return this.get(v2, arg3);
        }

        @JvmStatic public final Path get(String arg4) {
            Intrinsics.checkNotNullParameter(arg4, "<this>");
            return Companion.get$default(this, arg4, false, 1, null);
        }

        @JvmStatic public final Path get(String arg1, boolean arg2) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            return -Path.commonToPath(arg1, arg2);
        }

        @JvmStatic public final Path get(java.nio.file.Path arg4) {
            Intrinsics.checkNotNullParameter(arg4, "<this>");
            return Companion.get$default(this, arg4, false, 1, null);
        }

        @JvmStatic public final Path get(java.nio.file.Path arg2, boolean arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            return this.get(arg2.toString(), arg3);
        }

        public static Path get$default(Companion arg0, String arg1, boolean arg2, int arg3, Object arg4) {
            return arg0.get(arg1, false);
        }

        public static Path get$default(Companion arg0, File arg1, boolean arg2, int arg3, Object arg4) {
            return arg0.get(arg1, false);
        }

        public static Path get$default(Companion arg0, java.nio.file.Path arg1, boolean arg2, int arg3, Object arg4) {
            return arg0.get(arg1, false);
        }
    }

    public static final Companion Companion;
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    static {
        Path.Companion = new Companion(null);
        String v0 = File.separator;
        Intrinsics.checkNotNullExpressionValue(v0, "separator");
        Path.DIRECTORY_SEPARATOR = v0;
    }

    public Path(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bytes");
        super();
        this.bytes = arg2;
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((Path)arg1));
    }

    public int compareTo(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.getBytes$okio().compareTo(arg2.getBytes$okio());
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof Path)) && (Intrinsics.areEqual(((Path)arg2).getBytes$okio(), this.getBytes$okio()))) {
            return 1;
        }

        return 0;
    }

    @JvmStatic public static final Path get(File arg1) {
        return Path.Companion.get(arg1);
    }

    @JvmStatic public static final Path get(File arg1, boolean arg2) {
        return Path.Companion.get(arg1, arg2);
    }

    @JvmStatic public static final Path get(String arg1) {
        return Path.Companion.get(arg1);
    }

    @JvmStatic public static final Path get(String arg1, boolean arg2) {
        return Path.Companion.get(arg1, arg2);
    }

    @JvmStatic public static final Path get(java.nio.file.Path arg1) {
        return Path.Companion.get(arg1);
    }

    @JvmStatic public static final Path get(java.nio.file.Path arg1, boolean arg2) {
        return Path.Companion.get(arg1, arg2);
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int v0 = -Path.access$rootLength(this);
        if(v0 == -1) {
            return null;
        }

        return new Path(this.getBytes$okio().substring(0, v0));
    }

    public final List getSegments() {
        ArrayList v0 = new ArrayList();
        int v1 = -Path.access$rootLength(this);
        int v3 = 92;
        if(v1 == -1) {
            v1 = 0;
        }
        else if(v1 < this.getBytes$okio().size() && this.getBytes$okio().getByte(v1) == v3) {
            ++v1;
        }

        int v2 = this.getBytes$okio().size();
        int v4 = v1;
        while(v1 < v2) {
            if(this.getBytes$okio().getByte(v1) == 0x2F || this.getBytes$okio().getByte(v1) == v3) {
                v0.add(this.getBytes$okio().substring(v4, v1));
                v4 = v1 + 1;
            }

            ++v1;
        }

        if(v4 < this.getBytes$okio().size()) {
            v0.add(this.getBytes$okio().substring(v4, this.getBytes$okio().size()));
        }

        ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            ((Collection)v7).add(v0_1.next().utf8());
        }

        return ((List)v7);
    }

    public final List getSegmentsBytes() {
        ArrayList v0 = new ArrayList();
        int v1 = -Path.access$rootLength(this);
        int v3 = 92;
        if(v1 == -1) {
            v1 = 0;
        }
        else if(v1 < this.getBytes$okio().size() && this.getBytes$okio().getByte(v1) == v3) {
            ++v1;
        }

        int v2 = this.getBytes$okio().size();
        int v4 = v1;
        while(v1 < v2) {
            if(this.getBytes$okio().getByte(v1) == 0x2F || this.getBytes$okio().getByte(v1) == v3) {
                v0.add(this.getBytes$okio().substring(v4, v1));
                v4 = v1 + 1;
            }

            ++v1;
        }

        if(v4 < this.getBytes$okio().size()) {
            v0.add(this.getBytes$okio().substring(v4, this.getBytes$okio().size()));
        }

        return ((List)v0);
    }

    public int hashCode() {
        return this.getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        if(-Path.access$rootLength(this) != -1) {
            return 1;
        }

        return 0;
    }

    public final boolean isRelative() {
        if(-Path.access$rootLength(this) == -1) {
            return 1;
        }

        return 0;
    }

    public final boolean isRoot() {
        if(-Path.access$rootLength(this) == this.getBytes$okio().size()) {
            return 1;
        }

        return 0;
    }

    public final String name() {
        return this.nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int v0 = -Path.access$getIndexOfLastSlash(this);
        int v2 = 2;
        if(v0 != -1) {
            return ByteString.substring$default(this.getBytes$okio(), v0 + 1, 0, v2, null);
        }

        if(this.volumeLetter() != null && this.getBytes$okio().size() == v2) {
            return ByteString.EMPTY;
        }

        return this.getBytes$okio();
    }

    public final Path normalized() {
        return Path.Companion.get(this.toString(), true);
    }

    public final Path parent() {
        Path v1 = null;
        if(!Intrinsics.areEqual(this.getBytes$okio(), -Path.access$getDOT$p()) && !Intrinsics.areEqual(this.getBytes$okio(), -Path.access$getSLASH$p()) && !Intrinsics.areEqual(this.getBytes$okio(), -Path.access$getBACKSLASH$p())) {
            if(-Path.access$lastSegmentIsDotDot(this)) {
            }
            else {
                int v0 = -Path.access$getIndexOfLastSlash(this);
                int v2 = 2;
                if(v0 == v2 && this.volumeLetter() != null) {
                    v2 = 3;
                    if(this.getBytes$okio().size() == v2) {
                        return v1;
                    }
                    else {
                        return new Path(ByteString.substring$default(this.getBytes$okio(), 0, v2, 1, v1));
                    }
                }

                if(v0 == 1 && (this.getBytes$okio().startsWith(-Path.access$getBACKSLASH$p()))) {
                    return v1;
                }

                int v5 = -1;
                if(v0 == v5 && this.volumeLetter() != null) {
                    if(this.getBytes$okio().size() == v2) {
                        return v1;
                    }
                    else {
                        return new Path(ByteString.substring$default(this.getBytes$okio(), 0, v2, 1, v1));
                    }
                }

                if(v0 == v5) {
                    return new Path(-Path.access$getDOT$p());
                }

                if(v0 == 0) {
                    return new Path(ByteString.substring$default(this.getBytes$okio(), 0, 1, 1, v1));
                }

                return new Path(ByteString.substring$default(this.getBytes$okio(), 0, v0, 1, v1));
            }
        }

        return v1;
    }

    public final Path relativeTo(Path arg9) {
        int v2_1;
        int v8;
        ByteString v9;
        Buffer v1_1;
        Intrinsics.checkNotNullParameter(arg9, "other");
        String v1 = " and ";
        if(Intrinsics.areEqual(this.getRoot(), arg9.getRoot())) {
            List v0 = this.getSegmentsBytes();
            List v2 = arg9.getSegmentsBytes();
            int v3 = Math.min(v0.size(), v2.size());
            int v5;
            for(v5 = 0; v5 < v3; ++v5) {
                if(!Intrinsics.areEqual(v0.get(v5), v2.get(v5))) {
                    break;
                }
            }

            if(v5 == v3 && this.getBytes$okio().size() == arg9.getBytes$okio().size()) {
                return Companion.get$default(Path.Companion, ".", false, 1, null);
            }

            if(v2.subList(v5, v2.size()).indexOf(-Path.access$getDOT_DOT$p()) == -1) {
                if(Intrinsics.areEqual(arg9.getBytes$okio(), -Path.access$getDOT$p())) {
                    return this;
                }

                v1_1 = new Buffer();
                v9 = -Path.access$getSlash(arg9);
                if(v9 == null) {
                    v9 = -Path.access$getSlash(this);
                    if(v9 == null) {
                        v9 = -Path.access$toSlash(Path.DIRECTORY_SEPARATOR);
                    }
                }

                v8 = v2.size();
                v2_1 = v5;
            }
            else {
                throw new IllegalArgumentException("Impossible relative path to resolve: " + this + v1 + arg9.toString());
            }

            while(v2_1 < v8) {
                v1_1.write(-Path.access$getDOT_DOT$p());
                v1_1.write(v9);
                ++v2_1;
            }

            v8 = v0.size();
            while(v5 < v8) {
                v1_1.write(v0.get(v5));
                v1_1.write(v9);
                ++v5;
            }

            return -Path.toPath(v1_1, false);
        }

        throw new IllegalArgumentException("Paths of different roots cannot be relative to each other: " + this + v1 + arg9.toString());
    }

    public final Path resolve(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().writeUtf8(arg2), false), false);
    }

    public final Path resolve(String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().writeUtf8(arg2), false), arg3);
    }

    public final Path resolve(ByteString arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().write(arg2), false), arg3);
    }

    public final Path resolve(Path arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, arg2, arg3);
    }

    public final Path resolve(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().write(arg2), false), false);
    }

    public final Path resolve(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(this, arg2, false);
    }

    public static Path resolve$default(Path arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.resolve(arg1, false);
    }

    public static Path resolve$default(Path arg0, ByteString arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.resolve(arg1, false);
    }

    public static Path resolve$default(Path arg0, Path arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.resolve(arg1, false);
    }

    public final File toFile() {
        return new File(this.toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path v1 = Paths.get(this.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
        return v1;
    }

    public String toString() {
        return this.getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        int v3 = 2;
        Object v4 = null;
        if(ByteString.indexOf$default(this.getBytes$okio(), -Path.access$getSLASH$p(), 0, v3, v4) != -1) {
            return ((Character)v4);
        }

        if(this.getBytes$okio().size() < v3) {
            return ((Character)v4);
        }

        if(this.getBytes$okio().getByte(1) != 58) {
            return ((Character)v4);
        }

        char v5 = ((char)this.getBytes$okio().getByte(0));
        if(97 > v5 || v5 >= 0x7B) {
            if(65 <= v5 && v5 < 91) {
                goto label_31;
            }

            goto label_33;
        }
        else {
        }

    label_31:
        return Character.valueOf(v5);
    label_33:
        return ((Character)v4);
    }
}

