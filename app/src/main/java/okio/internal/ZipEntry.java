package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010!\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\u000B\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\t\u0012\b\b\u0002\u0010\u000F\u001A\u00020\r\u0012\b\b\u0002\u0010\u0010\u001A\u00020\r\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J-\u00105\u001A\u00020\u00002\b\u0010\u0014\u001A\u0004\u0018\u00010\r2\b\u0010\u0015\u001A\u0004\u0018\u00010\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b6\u00107R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u001BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001FR\u0011\u0010\u000B\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001FR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001FR\u0011\u0010\u000F\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b%\u0010#R\u0011\u0010\u0010\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b&\u0010#R\u0015\u0010\u0011\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001A\u0004\b\'\u0010(R\u0015\u0010\u0012\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001A\u0004\b*\u0010(R\u0015\u0010\u0013\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001A\u0004\b+\u0010(R\u0015\u0010\u0014\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001A\u0004\b,\u0010-R\u0015\u0010\u0015\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001A\u0004\b/\u0010-R\u0015\u0010\u0016\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001A\u0004\b0\u0010-R\u0017\u00101\u001A\b\u0012\u0004\u0012\u00020\u000302¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0016\u00108\u001A\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b9\u0010(R\u0016\u0010:\u001A\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b;\u0010(R\u0016\u0010<\u001A\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b=\u0010(¨\u0006>"}, d2={"Lokio/internal/ZipEntry;", "", "canonicalPath", "Lokio/Path;", "isDirectory", "", "comment", "", "crc", "", "compressedSize", "size", "compressionMethod", "", "offset", "dosLastModifiedAtDate", "dosLastModifiedAtTime", "ntfsLastModifiedAtFiletime", "ntfsLastAccessedAtFiletime", "ntfsCreatedAtFiletime", "extendedLastModifiedAtSeconds", "extendedLastAccessedAtSeconds", "extendedCreatedAtSeconds", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJIJIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCanonicalPath", "()Lokio/Path;", "()Z", "getComment", "()Ljava/lang/String;", "getCrc", "()J", "getCompressedSize", "getSize", "getCompressionMethod", "()I", "getOffset", "getDosLastModifiedAtDate", "getDosLastModifiedAtTime", "getNtfsLastModifiedAtFiletime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNtfsLastAccessedAtFiletime", "getNtfsCreatedAtFiletime", "getExtendedLastModifiedAtSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtendedLastAccessedAtSeconds", "getExtendedCreatedAtSeconds", "children", "", "getChildren", "()Ljava/util/List;", "copy", "copy$okio", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lokio/internal/ZipEntry;", "lastAccessedAtMillis", "getLastAccessedAtMillis$okio", "lastModifiedAtMillis", "getLastModifiedAtMillis$okio", "createdAtMillis", "getCreatedAtMillis$okio", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ZipEntry {
    private final Path canonicalPath;
    private final List children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final int dosLastModifiedAtDate;
    private final int dosLastModifiedAtTime;
    private final Integer extendedCreatedAtSeconds;
    private final Integer extendedLastAccessedAtSeconds;
    private final Integer extendedLastModifiedAtSeconds;
    private final boolean isDirectory;
    private final Long ntfsCreatedAtFiletime;
    private final Long ntfsLastAccessedAtFiletime;
    private final Long ntfsLastModifiedAtFiletime;
    private final long offset;
    private final long size;

    public ZipEntry(Path arg2, boolean arg3, String arg4, long arg5, long arg7, long arg9, int arg11, long arg12, int arg14, int arg15, Long arg16, Long arg17, Long arg18, Integer arg19, Integer arg20, Integer arg21) {
        Intrinsics.checkNotNullParameter(arg2, "canonicalPath");
        Intrinsics.checkNotNullParameter(arg4, "comment");
        super();
        this.canonicalPath = arg2;
        this.isDirectory = arg3;
        this.comment = arg4;
        this.crc = arg5;
        this.compressedSize = arg7;
        this.size = arg9;
        this.compressionMethod = arg11;
        this.offset = arg12;
        this.dosLastModifiedAtDate = arg14;
        this.dosLastModifiedAtTime = arg15;
        this.ntfsLastModifiedAtFiletime = arg16;
        this.ntfsLastAccessedAtFiletime = arg17;
        this.ntfsCreatedAtFiletime = arg18;
        this.extendedLastModifiedAtSeconds = arg19;
        this.extendedLastAccessedAtSeconds = arg20;
        this.extendedCreatedAtSeconds = arg21;
        this.children = new ArrayList();
    }

    public ZipEntry(Path arg18, boolean arg19, String arg20, long arg21, long arg23, long arg25, int arg27, long arg28, int arg30, int arg31, Long arg32, Long arg33, Long arg34, Integer arg35, Integer arg36, Integer arg37, int arg38, DefaultConstructorMarker arg39) {
        Integer v39_1;
        boolean v21_1;
        int v0 = arg38;
        boolean v1 = (v0 & 2) != 0 ? false : arg19;
        String v2 = (v0 & 4) != 0 ? "" : arg20;
        long v4 = -1;
        long v6 = (v0 & 8) != 0 ? v4 : arg21;
        long v8 = (v0 & 16) != 0 ? v4 : arg23;
        long v10 = (v0 & 0x20) != 0 ? v4 : arg25;
        int v12 = -1;
        int v3 = (v0 & 0x40) != 0 ? v12 : arg27;
        if((v0 & 0x80) != 0) {
        }
        else {
            v4 = arg28;
        }

        int v13 = (v0 & 0x100) != 0 ? v12 : arg30;
        if((v0 & 0x200) != 0) {
        }
        else {
            v12 = arg31;
        }

        Long v14 = (v0 & 0x400) != 0 ? null : arg32;
        Long v15 = (v0 & 0x800) != 0 ? null : arg33;
        boolean v39 = v1;
        Long v1_1 = (v0 & 0x1000) != 0 ? null : arg34;
        Long v20 = v1_1;
        Integer v1_2 = (v0 & 0x2000) != 0 ? null : arg35;
        Integer v21 = v1_2;
        v1_2 = (v0 & 0x4000) != 0 ? null : arg36;
        if((v0 & 0x8000) != 0) {
            arg37 = v21;
            v21_1 = v39;
            v39_1 = null;
        }
        else {
            Integer v19 = arg37;
            arg37 = v21;
            v21_1 = v39;
            v39_1 = v19;
        }

        this(arg18, v21_1, v2, v6, v8, v10, v3, v4, v13, v12, v14, v15, v20, arg37, v1_2, v39_1);
    }

    public final ZipEntry copy$okio(Integer arg22, Integer arg23, Integer arg24) {
        return new ZipEntry(this.canonicalPath, this.isDirectory, this.comment, this.crc, this.compressedSize, this.size, this.compressionMethod, this.offset, this.dosLastModifiedAtDate, this.dosLastModifiedAtTime, this.ntfsLastModifiedAtFiletime, this.ntfsLastAccessedAtFiletime, this.ntfsCreatedAtFiletime, arg22, arg23, arg24);
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final List getChildren() {
        return this.children;
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final Long getCreatedAtMillis$okio() {
        Long v0 = this.ntfsCreatedAtFiletime;
        if(v0 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(v0.longValue()));
        }

        Integer v4 = this.extendedCreatedAtSeconds;
        if(v4 != null) {
            return Long.valueOf((((long)v4.intValue())) * 1000);
        }

        return null;
    }

    public final int getDosLastModifiedAtDate() {
        return this.dosLastModifiedAtDate;
    }

    public final int getDosLastModifiedAtTime() {
        return this.dosLastModifiedAtTime;
    }

    public final Integer getExtendedCreatedAtSeconds() {
        return this.extendedCreatedAtSeconds;
    }

    public final Integer getExtendedLastAccessedAtSeconds() {
        return this.extendedLastAccessedAtSeconds;
    }

    public final Integer getExtendedLastModifiedAtSeconds() {
        return this.extendedLastModifiedAtSeconds;
    }

    public final Long getLastAccessedAtMillis$okio() {
        Long v0 = this.ntfsLastAccessedAtFiletime;
        if(v0 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(v0.longValue()));
        }

        Integer v4 = this.extendedLastAccessedAtSeconds;
        if(v4 != null) {
            return Long.valueOf((((long)v4.intValue())) * 1000);
        }

        return null;
    }

    public final Long getLastModifiedAtMillis$okio() {
        Long v0 = this.ntfsLastModifiedAtFiletime;
        if(v0 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(v0.longValue()));
        }

        Integer v0_1 = this.extendedLastModifiedAtSeconds;
        if(v0_1 != null) {
            return Long.valueOf((((long)v0_1.intValue())) * 1000);
        }

        int v0_2 = this.dosLastModifiedAtTime;
        if(v0_2 != -1) {
            return ZipFilesKt.dosDateTimeToEpochMillis(this.dosLastModifiedAtDate, v0_2);
        }

        return null;
    }

    public final Long getNtfsCreatedAtFiletime() {
        return this.ntfsCreatedAtFiletime;
    }

    public final Long getNtfsLastAccessedAtFiletime() {
        return this.ntfsLastAccessedAtFiletime;
    }

    public final Long getNtfsLastModifiedAtFiletime() {
        return this.ntfsLastModifiedAtFiletime;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }
}

