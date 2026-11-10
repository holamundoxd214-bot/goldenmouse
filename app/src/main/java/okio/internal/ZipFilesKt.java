package okio.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path$Companion;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A.\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0014\b\u0002\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0000\u001A\"\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00170\u001CH\u0002\u001A\f\u0010\u001D\u001A\u00020\u0017*\u00020\u001EH\u0000\u001A\f\u0010\u001F\u001A\u00020 *\u00020\u001EH\u0002\u001A\u0014\u0010!\u001A\u00020 *\u00020\u001E2\u0006\u0010\"\u001A\u00020 H\u0002\u001A.\u0010#\u001A\u00020$*\u00020\u001E2\u0006\u0010%\u001A\u00020\u00012\u0018\u0010&\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020$0\'H\u0002\u001A\f\u0010(\u001A\u00020$*\u00020\u001EH\u0000\u001A\u0014\u0010)\u001A\u00020\u0017*\u00020\u001E2\u0006\u0010*\u001A\u00020\u0017H\u0000\u001A\u0018\u0010+\u001A\u0004\u0018\u00010\u0017*\u00020\u001E2\b\u0010*\u001A\u0004\u0018\u00010\u0017H\u0002\u001A\u0010\u0010,\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020\u000BH\u0000\u001A\u001F\u0010.\u001A\u0004\u0018\u00010\u000B2\u0006\u0010/\u001A\u00020\u00012\u0006\u00100\u001A\u00020\u0001H\u0000¢\u0006\u0002\u00101\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u00102\u001A\u000203*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b4\u00105¨\u00066"}, d2={"LOCAL_FILE_HEADER_SIGNATURE", "", "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_EXTENDED_TIMESTAMP", "openZip", "Lokio/ZipFileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "buildIndex", "", "entries", "", "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readZip64EocdRecord", "regularRecord", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "skipLocalHeader", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "filetimeToEpochMillis", "filetime", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "hex", "", "getHex", "(I)Ljava/lang/String;", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 0x2014B50;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 0x5455;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 0x4034B50;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 0xFFFFFFFFL;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 0x6064B50;
    private static final int ZIP64_LOCATOR_SIGNATURE = 0x7064B50;

    public static Unit $r8$lambda$BY2EJxV3DltaiT8Wp4_9EammrI8(ObjectRef arg0, BufferedSource arg1, ObjectRef arg2, ObjectRef arg3, int arg4, long arg5) {
        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    private static final Map buildIndex(List arg28) {
        Object v2;
        Path v6 = Companion.get$default(Path.Companion, "/", false, 1, null);
        Map v0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(v6, new ZipEntry(v6, true, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0xFFFC, null))});
        Iterator v1 = CollectionsKt.sortedWith(arg28, new ZipFilesKt$buildIndex$$inlined$sortedBy$1()).iterator();
        do {
        label_34:
            if(!v1.hasNext()) {
                return v0;
            }

            v2 = v1.next();
            if(v0.put(((ZipEntry)v2).getCanonicalPath(), v2) != null) {
                continue;
            }

            goto label_40;
        }
        while(true);

        return v0;
        while(true) {
        label_40:
            Path v5 = ((ZipEntry)v2).getCanonicalPath().parent();
            if(v5 == null) {
                break;
            }

            Object v3 = v0.get(v5);
            if(v3 != null) {
                ((ZipEntry)v3).getChildren().add(((ZipEntry)v2).getCanonicalPath());
                goto label_34;
            }

            ZipEntry v4 = new ZipEntry(v5, true, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0xFFFC, null);
            v0.put(v5, v4);
            v4.getChildren().add(((ZipEntry)v2).getCanonicalPath());
            ZipEntry v2_1 = v4;
        }

        goto label_34;
    }

    public static final Long dosDateTimeToEpochMillis(int arg7, int arg8) {
        if(arg8 == -1) {
            return null;
        }

        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis((arg7 >> 9 & 0x7F) + 1980, arg7 >> 5 & 15, arg7 & 0x1F, arg8 >> 11 & 0x1F, arg8 >> 5 & 0x3F, (arg8 & 0x1F) << 1));
    }

    public static final long filetimeToEpochMillis(long arg2) {
        return arg2 / 10000 - 11644473600000L;
    }

    private static final String getHex(int arg2) {
        StringBuilder v0 = new StringBuilder("0x");
        String v2 = Integer.toString(arg2, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        return v0.append(v2).toString();
    }

    public static final ZipFileSystem openZip(Path arg21, FileSystem arg22, Function1 arg23) throws IOException {
        ZipFileSystem v3_3;
        long v16;
        BufferedSource v5_1;
        ArrayList v8_2;
        Throwable v6_2;
        EocdRecord v10_1;
        int v14;
        int v13_1;
        BufferedSource v9_1;
        BufferedSource v8_1;
        Throwable v12_1;
        String v7;
        EocdRecord v6_1;
        BufferedSource v12;
        long v10;
        long v8;
        FileHandle v5;
        Path v1 = arg21;
        FileSystem v2 = arg22;
        Function1 v3 = arg23;
        String v0 = "not a zip: size=";
        Intrinsics.checkNotNullParameter(v1, "zipPath");
        Intrinsics.checkNotNullParameter(v2, "fileSystem");
        Intrinsics.checkNotNullParameter(v3, "predicate");
        FileHandle v4 = v2.openReadOnly(v1);
        try {
            v5 = v4;
            long v6 = v5.size();
            v8 = v6 - 22;
            v10 = 0;
            if(v8 < v10) {
                goto label_193;
            }

            v6 = Math.max(v6 - 0x10016, v10);
            while(true) {
            label_20:
                v12 = Okio.buffer(v5.source(v8));
                break;
            }
        }
        catch(Throwable v0_1) {
            goto label_202;
        }

        try {
            if(v12.readIntLe() != 101010256) {
                goto label_180;
            }

            v6_1 = ZipFilesKt.readEocdRecord(v12);
            v7 = v12.readUtf8(((long)v6_1.getCommentByteCount()));
            goto label_29;
        }
        catch(Throwable v0_1) {
            try {
                v12.close();
                throw v0_1;
            label_29:
                v12.close();
                v8 -= 20;
                v12_1 = null;
                if(Long.compare(v8, v10) <= 0) {
                    goto label_125;
                }

                v8_1 = Okio.buffer(v5.source(v8));
            }
            catch(Throwable v0_1) {
                goto label_202;
            }
        }

        BufferedSource v0_2 = v8_1;
        try {
            if(v0_2.readIntLe() != 0x7064B50) {
                goto label_101;
            }

            int v9 = v0_2.readIntLe();
            long v13 = v0_2.readLongLe();
            if(v0_2.readIntLe() == 1 && v9 == 0) {
                v9_1 = Okio.buffer(v5.source(v13));
                goto label_51;
            }

            goto label_97;
        }
        catch(Throwable v0_1) {
            goto label_111;
        }

    label_51:
        v0_2 = v9_1;
        try {
            v13_1 = v0_2.readIntLe();
            v14 = 0x6064B50;
            if(v13_1 == v14) {
                v6_1 = ZipFilesKt.readZip64EocdRecord(v0_2, v6_1);
                if(v9_1 != null) {
                    goto label_58;
                }

                goto label_63;
            }
            else {
                goto label_65;
            }
        }
        catch(Throwable v0_1) {
            goto label_80;
        }

        try {
        label_58:
            ((Closeable)v9_1).close();
        }
        catch(Throwable v0_1) {
            goto label_94;
        }

    label_63:
        v0_1 = v12_1;
        goto label_94;
        try {
        label_65:
            throw new IOException("bad zip: expected " + ZipFilesKt.getHex(v14) + " but was " + ZipFilesKt.getHex(v13_1));
        }
        catch(Throwable v0_1) {
        label_80:
            v10_1 = v6_1;
            v6_2 = v0_1;
            if(v9_1 != null) {
                try {
                    ((Closeable)v9_1).close();
                }
                catch(Throwable v0_1) {
                    try {
                        ExceptionsKt.addSuppressed(v6_2, v0_1);
                    }
                    catch(Throwable v0_1) {
                        goto label_112;
                    }
                }
            }

            v0_1 = v6_2;
            v6_1 = v10_1;
        }

    label_94:
        if(v0_1 != null) {
            goto label_96;
        }

        try {
            goto label_101;
        label_96:
            throw v0_1;
        label_97:
            throw new IOException("unsupported zip: spanned");
        label_101:
            if(v8_1 == null) {
                goto label_108;
            }

            goto label_103;
        }
        catch(Throwable v0_1) {
        label_111:
            v10_1 = v6_1;
        }

    label_112:
        v6_2 = v0_1;
        if(v8_1 != null) {
            try {
                ((Closeable)v8_1).close();
                goto label_119;
            }
            catch(Throwable v0_1) {
                try {
                    ExceptionsKt.addSuppressed(v6_2, v0_1);
                label_119:
                    v0_1 = v6_2;
                    v6_1 = v10_1;
                    goto label_122;
                }
                catch(Throwable v0_1) {
                    goto label_202;
                }
            }
        }
        else {
            goto label_119;
            try {
            label_103:
                ((Closeable)v8_1).close();
            }
            catch(Throwable v0_1) {
                goto label_122;
            }
        }

    label_108:
        v0_1 = v12_1;
        try {
        label_122:
            if(v0_1 == null) {
            }
            else {
                throw v0_1;
            }

        label_125:
            v8_2 = new ArrayList();
            v5_1 = Okio.buffer(v5.source(v6_1.getCentralDirectoryOffset()));
        }
        catch(Throwable v0_1) {
            goto label_202;
        }

        v0_2 = v5_1;
        try {
            long v9_2 = v6_1.getEntryCount();
            v16 = 0;
            goto label_135;
        }
        catch(Throwable v0_1) {
            goto label_164;
        }

        try {
        label_180:
            v12.close();
            --v8;
            if(v8 >= v6) {
                v10 = 0;
                goto label_20;
            }

            throw new IOException("not a zip: end of central directory signature not found");
        }
        catch(Throwable v0_1) {
            goto label_202;
        }

        try {
            while(true) {
            label_135:
                if(v16 >= v9_2) {
                    goto label_152;
                }

                ZipEntry v11 = ZipFilesKt.readCentralDirectoryZipEntry(v0_2);
                if(v11.getOffset() >= v6_1.getCentralDirectoryOffset()) {
                    break;
                }

                if(v3.invoke(v11).booleanValue()) {
                    v8_2.add(v11);
                }

                ++v16;
            }

            throw new IOException("bad zip: local file header offset >= central directory offset");
        label_152:
            Unit v3_1 = Unit.INSTANCE;
            if(v5_1 == null) {
                goto label_159;
            }
        }
        catch(Throwable v0_1) {
            goto label_164;
        }

        try {
            ((Closeable)v5_1).close();
        }
        catch(Throwable v0_1) {
            v12_1 = v0_1;
        }

    label_159:
        Throwable v3_2 = v12_1;
        goto label_171;
    label_164:
        v3_2 = v0_1;
        if(v5_1 == null) {
            goto label_171;
        }

        try {
            ((Closeable)v5_1).close();
            goto label_171;
        }
        catch(Throwable v0_1) {
            try {
                ExceptionsKt.addSuppressed(v3_2, v0_1);
            label_171:
                if(v3_2 != null) {
                    goto label_179;
                }

                v3_3 = new ZipFileSystem(v1, v2, ZipFilesKt.buildIndex(((List)v8_2)), v7);
                if(v4 != null) {
                    goto label_176;
                }

                return v3_3;
            }
            catch(Throwable v0_1) {
                goto label_202;
            }
        }

        try {
        label_176:
            ((Closeable)v4).close();
            return v3_3;
        }
        catch(Throwable ) {
            return v3_3;
        }

        try {
        label_179:
            throw v3_2;
        label_193:
            throw new IOException(v0 + v5.size());
        }
        catch(Throwable v0_1) {
        label_202:
            Throwable v1_1 = v0_1;
            if(v4 != null) {
                try {
                    ((Closeable)v4).close();
                }
                catch(Throwable v0_1) {
                    ExceptionsKt.addSuppressed(v1_1, v0_1);
                }
            }

            throw v1_1;
        }
    }

    public static ZipFileSystem openZip$default(Path arg0, FileSystem arg1, Function1 arg2, int arg3, Object arg4) throws IOException {
        ZipFilesKt$$ExternalSyntheticLambda0 v2;
        if((arg3 & 4) != 0) {
            v2 = new ZipFilesKt$$ExternalSyntheticLambda0();
        }

        return ZipFilesKt.openZip(arg0, arg1, ((Function1)v2));
    }

    static final boolean openZip$lambda$0(ZipEntry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return 1;
    }

    public static final ZipEntry readCentralDirectoryZipEntry(BufferedSource arg36) throws IOException {
        BufferedSource v5 = arg36;
        Intrinsics.checkNotNullParameter(v5, "<this>");
        int v0 = v5.readIntLe();
        int v1 = 0x2014B50;
        if(v0 == v1) {
            v5.skip(4);
            v0 = v5.readShortLe();
            v1 = 0xFFFF;
            int v2 = v0 & v1;
            if((v0 & 1) == 0) {
                int v22 = v5.readShortLe() & v1;
                int v26 = v5.readShortLe() & v1;
                int v25 = v5.readShortLe() & v1;
                long v16 = (((long)v5.readIntLe())) & 0xFFFFFFFFL;
                long v2_1 = 0xFFFFFFFFL;
                LongRef v6 = new LongRef();
                v6.element = (((long)v5.readIntLe())) & v2_1;
                LongRef v4 = new LongRef();
                v4.element = (((long)v5.readIntLe())) & v2_1;
                v0 = v5.readShortLe() & v1;
                int v12 = v5.readShortLe() & v1;
                int v13 = v5.readShortLe() & v1;
                v5.skip(8);
                long v8 = 8;
                LongRef v7 = new LongRef();
                v7.element = (((long)v5.readIntLe())) & v2_1;
                String v14 = v5.readUtf8(((long)v0));
                Object v10 = null;
                if(!StringsKt.contains$default(v14, '\u0000', false, 2, v10)) {
                    long v18 = v2_1;
                    long v20 = 0;
                    long v23 = Long.compare(v4.element, v18) == 0 ? v8 : v20;
                    long v1_1 = v6.element == v18 ? v23 + v8 : v23;
                    LongRef v0_1 = v4;
                    if(v7.element == v18) {
                        v1_1 += v8;
                    }

                    v2_1 = v1_1;
                    ObjectRef v8_1 = new ObjectRef();
                    ObjectRef v9 = new ObjectRef();
                    Object v1_2 = v10;
                    ObjectRef v10_1 = new ObjectRef();
                    Object v4_1 = v1_2;
                    BooleanRef v1_3 = new BooleanRef();
                    Object v18_1 = v4_1;
                    v4 = v0_1;
                    Object v35 = v18_1;
                    String v18_2 = v14;
                    Object v14_1 = v35;
                    ZipFilesKt.readExtra(v5, v12, new ZipFilesKt$$ExternalSyntheticLambda3(v1_3, v2_1, v4, v5, v6, v7, v8_1, v9, v10_1));
                    if(v2_1 > v20) {
                        if(v1_3.element) {
                        }
                        else {
                            throw new IOException("bad zip: zip64 extra required but absent");
                        }
                    }

                    return new ZipEntry(Companion.get$default(Path.Companion, "/", false, 1, v14_1).resolve(v18_2), StringsKt.endsWith$default(v18_2, "/", false, 2, v14_1), v5.readUtf8(((long)v13)), v16, v6.element, v4.element, v22, v7.element, v25, v26, v8_1.element, v9.element, v10_1.element, null, null, null, 0xE000, null);
                }

                throw new IOException("bad zip: filename contains 0x00");
            }

            throw new IOException("unsupported zip: general purpose bit flag=" + ZipFilesKt.getHex(v2));
        }

        throw new IOException("bad zip: expected " + ZipFilesKt.getHex(v1) + " but was " + ZipFilesKt.getHex(v0));
    }

    static final Unit readCentralDirectoryZipEntry$lambda$1(BooleanRef arg1, long arg2, LongRef arg4, BufferedSource arg5, LongRef arg6, LongRef arg7, ObjectRef arg8, ObjectRef arg9, ObjectRef arg10, int arg11, long arg12) {
        long v1;
        if(arg11 != 1) {
            if(arg11 != 10) {
            }
            else {
                v1 = 4;
                if(arg12 >= v1) {
                    arg5.skip(v1);
                    ZipFilesKt.readExtra(arg5, ((int)(arg12 - v1)), new ZipFilesKt$$ExternalSyntheticLambda1(arg8, arg5, arg9, arg10));
                }
                else {
                    throw new IOException("bad zip: NTFS extra too short");
                }
            }
        }
        else if(!arg1.element) {
            arg1.element = true;
            if(arg12 >= arg2) {
                long v8 = 0xFFFFFFFFL;
                v1 = arg4.element == v8 ? arg5.readLongLe() : arg4.element;
                arg4.element = v1;
                arg2 = 0;
                long v10 = Long.compare(arg6.element, v8) == 0 ? arg5.readLongLe() : arg2;
                arg6.element = v10;
                if(arg7.element == v8) {
                    arg2 = arg5.readLongLe();
                }

                arg7.element = arg2;
            }
            else {
                goto label_43;
            }
        }
        else {
            goto label_47;
        }

        return Unit.INSTANCE;
    label_43:
        throw new IOException("bad zip: zip64 extra too short");
    label_47:
        throw new IOException("bad zip: zip64 extra repeated");
    }

    private static final Unit readCentralDirectoryZipEntry$lambda$1$0(ObjectRef arg2, BufferedSource arg3, ObjectRef arg4, ObjectRef arg5, int arg6, long arg7) {
        if(arg6 == 1) {
            if(arg2.element != null) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            else if(arg7 == 24) {
                arg2.element = Long.valueOf(arg3.readLongLe());
                arg4.element = Long.valueOf(arg3.readLongLe());
                arg5.element = Long.valueOf(arg3.readLongLe());
            }
            else {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
        }

        return Unit.INSTANCE;
    }

    private static final EocdRecord readEocdRecord(BufferedSource arg10) throws IOException {
        int v1 = 0xFFFF;
        int v0 = arg10.readShortLe() & v1;
        int v2 = arg10.readShortLe() & v1;
        long v5 = ((long)(arg10.readShortLe() & v1));
        if(v5 == (((long)(arg10.readShortLe() & v1))) && v0 == 0 && v2 == 0) {
            arg10.skip(4);
            return new EocdRecord(v5, 0xFFFFFFFFL & (((long)arg10.readIntLe())), arg10.readShortLe() & v1);
        }

        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource arg10, int arg11, Function2 arg12) {
        long v0;
        for(v0 = ((long)arg11); true; v0 -= v6) {
            long v2 = 0;
            if(v0 == v2) {
                return;
            }

            long v4 = 4;
            if(v0 < v4) {
                goto label_43;
            }

            arg11 = arg10.readShortLe() & 0xFFFF;
            long v6 = (((long)arg10.readShortLe())) & 0xFFFF;
            v0 -= v4;
            if(v0 < v6) {
                goto label_39;
            }

            arg10.require(v6);
            v4 = arg10.getBuffer().size();
            arg12.invoke(Integer.valueOf(arg11), Long.valueOf(v6));
            long v8 = arg10.getBuffer().size() + v6 - v4;
            int v2_1 = Long.compare(v8, v2);
            if(v2_1 < 0) {
                break;
            }

            if(v2_1 > 0) {
                arg10.getBuffer().skip(v8);
            }
        }

        throw new IOException("unsupported zip: too many bytes processed for " + arg11);
    label_39:
        throw new IOException("bad zip: truncated value in extra field");
    label_43:
        throw new IOException("bad zip: truncated header in extra field");
    }

    public static final ZipEntry readLocalHeader(BufferedSource arg1, ZipEntry arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "centralDirectoryZipEntry");
        ZipEntry v1 = ZipFilesKt.readOrSkipLocalHeader(arg1, arg2);
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    private static final ZipEntry readOrSkipLocalHeader(BufferedSource arg6, ZipEntry arg7) {
        int v0 = arg6.readIntLe();
        int v1 = 0x4034B50;
        if(v0 == v1) {
            arg6.skip(2);
            v0 = arg6.readShortLe();
            v1 = 0xFFFF;
            int v2 = v0 & v1;
            if((v0 & 1) == 0) {
                arg6.skip(18);
                long v2_1 = (((long)arg6.readShortLe())) & 0xFFFF;
                v0 = arg6.readShortLe() & v1;
                arg6.skip(v2_1);
                if(arg7 == null) {
                    arg6.skip(((long)v0));
                    return null;
                }

                ObjectRef v1_1 = new ObjectRef();
                ObjectRef v2_2 = new ObjectRef();
                ObjectRef v3 = new ObjectRef();
                ZipFilesKt.readExtra(arg6, v0, new ZipFilesKt$$ExternalSyntheticLambda2(arg6, v1_1, v2_2, v3));
                return arg7.copy$okio(v1_1.element, v2_2.element, v3.element);
            }

            throw new IOException("unsupported zip: general purpose bit flag=" + ZipFilesKt.getHex(v2));
        }

        throw new IOException("bad zip: expected " + ZipFilesKt.getHex(v1) + " but was " + ZipFilesKt.getHex(v0));
    }

    static final Unit readOrSkipLocalHeader$lambda$0(BufferedSource arg9, ObjectRef arg10, ObjectRef arg11, ObjectRef arg12, int arg13, long arg14) {
        if(arg13 == 0x5455) {
            long v0 = 1;
            String v2 = "bad zip: extended timestamp extra too short";
            if(Long.compare(arg14, v0) >= 0) {
                arg13 = arg9.readByte();
                int v4 = 0;
                int v3 = (arg13 & 1) == 1 ? 1 : 0;
                int v6 = (arg13 & 2) == 2 ? 1 : 0;
                if((arg13 & 4) == 4) {
                    v4 = 1;
                }

                if(v3 != 0) {
                    v0 = 5;
                }

                long v7 = 4;
                if(v6 != 0) {
                    v0 += v7;
                }

                if(v4 != 0) {
                    v0 += v7;
                }

                if(arg14 >= v0) {
                    if(v3 != 0) {
                        arg10.element = Integer.valueOf(arg9.readIntLe());
                    }

                    if(v6 != 0) {
                        arg11.element = Integer.valueOf(arg9.readIntLe());
                    }

                    if(v4 == 0) {
                        goto label_51;
                    }

                    arg12.element = Integer.valueOf(arg9.readIntLe());
                    goto label_51;
                }

                throw new IOException(v2);
            }
            else {
                throw new IOException(v2);
            }
        }

    label_51:
        return Unit.INSTANCE;
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource arg8, EocdRecord arg9) throws IOException {
        arg8.skip(12);
        int v0 = arg8.readIntLe();
        int v1 = arg8.readIntLe();
        long v3 = arg8.readLongLe();
        if(v3 == arg8.readLongLe() && v0 == 0 && v1 == 0) {
            arg8.skip(8);
            return new EocdRecord(v3, arg8.readLongLe(), arg9.getCommentByteCount());
        }

        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(BufferedSource arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ZipFilesKt.readOrSkipLocalHeader(arg1, null);
    }
}

