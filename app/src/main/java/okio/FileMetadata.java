package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u001C\u001A\u0004\u0018\u0001H\u001D\"\b\b\u0000\u0010\u001D*\u00020\u00012\u000E\u0010\u001E\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u001D0\u000E¢\u0006\u0002\u0010\u001FJu\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\u0010!J\b\u0010\"\u001A\u00020#H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0017\u0010\u0015R\u0015\u0010\n\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0018\u0010\u0015R\u0015\u0010\u000B\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0019\u0010\u0015R!\u0010\f\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006$"}, d2={"Lokio/FileMetadata;", "", "isRegularFile", "", "isDirectory", "symlinkTarget", "Lokio/Path;", "size", "", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", "", "Lkotlin/reflect/KClass;", "<init>", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "()Z", "getSymlinkTarget", "()Lokio/Path;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatedAtMillis", "getLastModifiedAtMillis", "getLastAccessedAtMillis", "getExtras", "()Ljava/util/Map;", "extra", "T", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 0xFF, null);
    }

    public FileMetadata(boolean arg2, boolean arg3, Path arg4, Long arg5, Long arg6, Long arg7, Long arg8, Map arg9, int arg10, DefaultConstructorMarker arg11) {
        Path v0 = null;
        if((arg10 & 4) != 0) {
            arg4 = v0;
        }

        if((arg10 & 8) != 0) {
            arg5 = ((Long)v0);
        }

        if((arg10 & 16) != 0) {
            arg6 = ((Long)v0);
        }

        if((arg10 & 0x20) != 0) {
            arg7 = ((Long)v0);
        }

        if((arg10 & 0x40) != 0) {
            arg8 = ((Long)v0);
        }

        if((arg10 & 0x80) != 0) {
            arg9 = MapsKt.emptyMap();
        }

        this(false, false, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public FileMetadata(boolean arg2, boolean arg3, Path arg4, Long arg5, Long arg6, Long arg7, Long arg8, Map arg9) {
        Intrinsics.checkNotNullParameter(arg9, "extras");
        super();
        this.isRegularFile = arg2;
        this.isDirectory = arg3;
        this.symlinkTarget = arg4;
        this.size = arg5;
        this.createdAtMillis = arg6;
        this.lastModifiedAtMillis = arg7;
        this.lastAccessedAtMillis = arg8;
        this.extras = MapsKt.toMap(arg9);
    }

    public final FileMetadata copy(boolean arg10, boolean arg11, Path arg12, Long arg13, Long arg14, Long arg15, Long arg16, Map arg17) {
        Intrinsics.checkNotNullParameter(arg17, "extras");
        return new FileMetadata(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public static FileMetadata copy$default(FileMetadata arg0, boolean arg1, boolean arg2, Path arg3, Long arg4, Long arg5, Long arg6, Long arg7, Map arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.isRegularFile;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.isDirectory;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.symlinkTarget;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.size;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.createdAtMillis;
        }

        if((arg9 & 0x20) != 0) {
            arg6 = arg0.lastModifiedAtMillis;
        }

        if((arg9 & 0x40) != 0) {
            arg7 = arg0.lastAccessedAtMillis;
        }

        if((arg9 & 0x80) != 0) {
            arg8 = arg0.extras;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final Object extra(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "type");
        Object v1 = this.extras.get(arg2);
        if(v1 == null) {
            return null;
        }

        return KClasses.cast(arg2, v1);
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        ArrayList v0 = new ArrayList();
        if(this.isRegularFile) {
            v0.add("isRegularFile");
        }

        if(this.isDirectory) {
            v0.add("isDirectory");
        }

        if(this.size != null) {
            v0.add("byteCount=" + this.size.longValue());
        }

        if(this.createdAtMillis != null) {
            v0.add("createdAt=" + this.createdAtMillis.longValue());
        }

        if(this.lastModifiedAtMillis != null) {
            v0.add("lastModifiedAt=" + this.lastModifiedAtMillis.longValue());
        }

        if(this.lastAccessedAtMillis != null) {
            v0.add("lastAccessedAt=" + this.lastAccessedAtMillis.longValue());
        }

        if(!this.extras.isEmpty()) {
            v0.add("extras=" + this.extras);
        }

        return CollectionsKt.joinToString$default(v0, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}

