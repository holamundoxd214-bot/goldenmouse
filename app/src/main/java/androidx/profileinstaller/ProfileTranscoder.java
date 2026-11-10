package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.TreeMap;

class ProfileTranscoder {
    private static final int FIRST_FLAG = 1;
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int LAST_FLAG = 4;
    static final byte[] MAGIC_PROF = null;
    static final byte[] MAGIC_PROFM = null;
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    static {
        ProfileTranscoder.MAGIC_PROF = new byte[]{0x70, 0x72, 0x6F, 0};
        ProfileTranscoder.MAGIC_PROFM = new byte[]{0x70, 0x72, 109, 0};
    }

    private ProfileTranscoder() {
        super();
    }

    private static int computeMethodFlags(DexProfileData arg2) {
        Iterator v2 = arg2.methods.entrySet().iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 |= v2.next().getValue().intValue()) {
        }

        return v0;
    }

    private static byte[] createCompressibleBody(DexProfileData[] arg8, byte[] arg9) throws IOException {
        int v0 = arg8.length;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            v3 += Encoding.utf8Length(ProfileTranscoder.generateDexKey(arg8[v2].apkName, arg8[v2].dexName, arg9)) + 16 + arg8[v2].classSetSize * 2 + arg8[v2].hotMethodRegionSize + ProfileTranscoder.getMethodBitmapStorageSize(arg8[v2].numMethodIds);
            ++v2;
        }

        ByteArrayOutputStream v0_1 = new ByteArrayOutputStream(v3);
        if(Arrays.equals(arg9, ProfileVersion.V009_O_MR1)) {
            v2 = arg8.length;
            goto label_28;
        }
        else {
            v2 = arg8.length;
            int v4;
            for(v4 = 0; v4 < v2; ++v4) {
                ProfileTranscoder.writeLineHeader(((OutputStream)v0_1), arg8[v4], ProfileTranscoder.generateDexKey(arg8[v4].apkName, arg8[v4].dexName, arg9));
            }

            int v9 = arg8.length;
            while(true) {
                if(v1 < v9) {
                    ProfileTranscoder.writeLineData(((OutputStream)v0_1), arg8[v1]);
                    ++v1;
                    continue;
                }

                goto label_53;
            }

        label_28:
            while(v1 < v2) {
                DexProfileData v4_1 = arg8[v1];
                ProfileTranscoder.writeLineHeader(((OutputStream)v0_1), v4_1, ProfileTranscoder.generateDexKey(v4_1.apkName, v4_1.dexName, arg9));
                ProfileTranscoder.writeLineData(((OutputStream)v0_1), v4_1);
                ++v1;
            }
        }

    label_53:
        if(v0_1.size() == v3) {
            return v0_1.toByteArray();
        }

        throw Encoding.error("The bytes saved do not match expectation. actual=" + v0_1.size() + " expected=" + v3);
    }

    private static WritableFileSection createCompressibleClassSection(DexProfileData[] arg5) throws IOException {
        WritableFileSection v1_1;
        byte[] v5_1;
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        int v1 = 0;
        int v2 = 0;
        try {
            while(v1 < arg5.length) {
                DexProfileData v3 = arg5[v1];
                Encoding.writeUInt16(((OutputStream)v0), v1);
                Encoding.writeUInt16(((OutputStream)v0), v3.classSetSize);
                v2 = v2 + 4 + v3.classSetSize * 2;
                ProfileTranscoder.writeClasses(((OutputStream)v0), v3);
                ++v1;
            }

            v5_1 = v0.toByteArray();
            if(v2 != v5_1.length) {
                goto label_26;
            }

            v1_1 = new WritableFileSection(FileSectionType.CLASSES, v2, v5_1, true);
        }
        catch(Throwable v5) {
            goto label_39;
        }

        v0.close();
        return v1_1;
        try {
        label_26:
            throw Encoding.error("Expected size " + v2 + ", does not match actual size " + v5_1.length);
        }
        catch(Throwable v5) {
            try {
            label_39:
                v0.close();
            }
            catch(Throwable v0_1) {
                v5.addSuppressed(v0_1);
            }

            throw v5;
        }
    }

    private static WritableFileSection createCompressibleMethodsSection(DexProfileData[] arg9) throws IOException {
        WritableFileSection v1_1;
        byte[] v9_1;
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        int v1 = 0;
        int v2 = 0;
        try {
            while(v1 < arg9.length) {
                DexProfileData v3 = arg9[v1];
                int v4 = ProfileTranscoder.computeMethodFlags(v3);
                byte[] v5 = ProfileTranscoder.createMethodBitmapRegionForS(v4, v3);
                byte[] v3_1 = ProfileTranscoder.createMethodsWithInlineCaches(v3);
                Encoding.writeUInt16(((OutputStream)v0), v1);
                int v6 = v5.length + 2 + v3_1.length;
                Encoding.writeUInt32(((OutputStream)v0), ((long)v6));
                Encoding.writeUInt16(((OutputStream)v0), v4);
                v0.write(v5);
                v0.write(v3_1);
                v2 = v2 + 6 + v6;
                ++v1;
            }

            v9_1 = v0.toByteArray();
            if(v2 != v9_1.length) {
                goto label_33;
            }

            v1_1 = new WritableFileSection(FileSectionType.METHODS, v2, v9_1, true);
        }
        catch(Throwable v9) {
            goto label_46;
        }

        v0.close();
        return v1_1;
        try {
        label_33:
            throw Encoding.error("Expected size " + v2 + ", does not match actual size " + v9_1.length);
        }
        catch(Throwable v9) {
            try {
            label_46:
                v0.close();
            }
            catch(Throwable v0_1) {
                v9.addSuppressed(v0_1);
            }

            throw v9;
        }
    }

    private static byte[] createMethodBitmapRegionForS(int arg1, DexProfileData arg2) throws IOException {
        byte[] v1_1;
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        try {
            ProfileTranscoder.writeMethodBitmapForS(((OutputStream)v0), arg1, arg2);
            v1_1 = v0.toByteArray();
        }
        catch(Throwable v1) {
            try {
                v0.close();
            }
            catch(Throwable v2) {
                v1.addSuppressed(v2);
            }

            throw v1;
        }

        v0.close();
        return v1_1;
    }

    private static byte[] createMethodsWithInlineCaches(DexProfileData arg1) throws IOException {
        byte[] v1_1;
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        try {
            ProfileTranscoder.writeMethodsWithInlineCaches(((OutputStream)v0), arg1);
            v1_1 = v0.toByteArray();
        }
        catch(Throwable v1) {
            try {
                v0.close();
            }
            catch(Throwable v0_1) {
                v1.addSuppressed(v0_1);
            }

            throw v1;
        }

        v0.close();
        return v1_1;
    }

    private static String enforceSeparator(String arg3, String arg4) {
        String v0 = "!";
        String v2 = ":";
        if(v0.equals(arg4)) {
            return arg3.replace(((CharSequence)v2), ((CharSequence)v0));
        }

        if(v2.equals(arg4)) {
            arg3 = arg3.replace(((CharSequence)v0), ((CharSequence)v2));
        }

        return arg3;
    }

    private static String extractKey(String arg1) {
        int v0 = arg1.indexOf("!");
        if(v0 < 0) {
            v0 = arg1.indexOf(":");
        }

        if(v0 > 0) {
            arg1 = arg1.substring(v0 + 1);
        }

        return arg1;
    }

    private static DexProfileData findByDexName(DexProfileData[] arg3, String arg4) {
        DexProfileData v1 = null;
        if(arg3.length <= 0) {
            return v1;
        }

        arg4 = ProfileTranscoder.extractKey(arg4);
        int v0;
        for(v0 = 0; v0 < arg3.length; ++v0) {
            if(arg3[v0].dexName.equals(arg4)) {
                return arg3[v0];
            }
        }

        return v1;
    }

    private static String generateDexKey(String arg2, String arg3, byte[] arg4) {
        String v0 = ProfileVersion.dexKeySeparator(arg4);
        if(arg2.length() <= 0) {
            return ProfileTranscoder.enforceSeparator(arg3, v0);
        }

        if(arg3.equals("classes.dex")) {
            return arg2;
        }

        if(!arg3.contains("!")) {
            if(arg3.contains(":")) {
            }
            else if(arg3.endsWith(".apk")) {
                return arg3;
            }
            else {
                return arg2 + ProfileVersion.dexKeySeparator(arg4) + arg3;
            }
        }

        return ProfileTranscoder.enforceSeparator(arg3, v0);
    }

    private static int getMethodBitmapStorageSize(int arg0) {
        return ProfileTranscoder.roundUpToByte(arg0 * 2) / 8;
    }

    private static int getMethodBitmapStorageSizeForS(int arg0, int arg1) {
        return ProfileTranscoder.roundUpToByte(Integer.bitCount(arg0 & -2) * arg1) / 8;
    }

    private static int methodFlagBitmapIndex(int arg1, int arg2, int arg3) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 == 4) {
                    return arg2 + arg3;
                }

                throw Encoding.error("Unexpected flag: " + arg1);
            }

            return arg2;
        }

        throw Encoding.error("HOT methods are not stored in the bitmap");
    }

    private static int[] readClasses(InputStream arg4, int arg5) throws IOException {
        int[] v0 = new int[arg5];
        int v1 = 0;
        int v2 = 0;
        while(v1 < arg5) {
            v2 += Encoding.readUInt16(arg4);
            v0[v1] = v2;
            ++v1;
        }

        return v0;
    }

    private static int readFlagsFromBitmap(BitSet arg2, int arg3, int arg4) {
        int v0 = 2;
        if(arg2.get(ProfileTranscoder.methodFlagBitmapIndex(v0, arg3, arg4))) {
        }
        else {
            v0 = 0;
        }

        if(arg2.get(ProfileTranscoder.methodFlagBitmapIndex(4, arg3, arg4))) {
            return v0 | 4;
        }

        return v0;
    }

    static byte[] readHeader(InputStream arg1, byte[] arg2) throws IOException {
        if(Arrays.equals(arg2, Encoding.read(arg1, arg2.length))) {
            return Encoding.read(arg1, ProfileVersion.V010_P.length);
        }

        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(InputStream arg5, DexProfileData arg6) throws IOException {
        int v0 = arg5.available() - arg6.hotMethodRegionSize;
        int v1 = 0;
    label_4:
        if(arg5.available() > v0) {
            v1 += Encoding.readUInt16(arg5);
            arg6.methods.put(Integer.valueOf(v1), Integer.valueOf(1));
            int v2;
            for(v2 = Encoding.readUInt16(arg5); true; --v2) {
                if(v2 <= 0) {
                    goto label_4;
                }

                ProfileTranscoder.skipInlineCache(arg5);
            }
        }

        if(arg5.available() == v0) {
            return;
        }

        throw Encoding.error("Read too much data during profile line parse");
    }

    static DexProfileData[] readMeta(InputStream arg1, byte[] arg2, byte[] arg3, DexProfileData[] arg4) throws IOException {
        if(Arrays.equals(arg2, ProfileVersion.METADATA_V001_N)) {
            if(!Arrays.equals(ProfileVersion.V015_S, arg3)) {
                return ProfileTranscoder.readMetadata001(arg1, arg2, arg4);
            }

            throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }

        if(Arrays.equals(arg2, ProfileVersion.METADATA_V002)) {
            return ProfileTranscoder.readMetadataV002(arg1, arg3, arg4);
        }

        throw Encoding.error("Unsupported meta version");
    }

    static DexProfileData[] readMetadata001(InputStream arg4, byte[] arg5, DexProfileData[] arg6) throws IOException {
        DexProfileData[] v5_2;
        if(Arrays.equals(arg5, ProfileVersion.METADATA_V001_N)) {
            int v5 = Encoding.readUInt8(arg4);
            byte[] v0 = Encoding.readCompressed(arg4, ((int)Encoding.readUInt32(arg4)), ((int)Encoding.readUInt32(arg4)));
            if(arg4.read() <= 0) {
                ByteArrayInputStream v4 = new ByteArrayInputStream(v0);
                try {
                    v5_2 = ProfileTranscoder.readMetadataForNBody(((InputStream)v4), v5, arg6);
                }
                catch(Throwable v5_1) {
                    try {
                        ((InputStream)v4).close();
                    }
                    catch(Throwable v4_1) {
                        v5_1.addSuppressed(v4_1);
                    }

                    throw v5_1;
                }

                ((InputStream)v4).close();
                return v5_2;
            }

            throw Encoding.error("Content found after the end of file");
        }

        throw Encoding.error("Unsupported meta version");
    }

    private static DexProfileData[] readMetadataForNBody(InputStream arg6, int arg7, DexProfileData[] arg8) throws IOException {
        int v1 = 0;
        if(arg6.available() == 0) {
            return new DexProfileData[0];
        }

        if(arg7 != arg8.length) {
            goto label_35;
        }

        String[] v0 = new String[arg7];
        int[] v2 = new int[arg7];
        int v3;
        for(v3 = 0; v3 < arg7; ++v3) {
            int v4 = Encoding.readUInt16(arg6);
            v2[v3] = Encoding.readUInt16(arg6);
            v0[v3] = Encoding.readString(arg6, v4);
        }

        while(true) {
            if(v1 >= arg7) {
                return arg8;
            }

            DexProfileData v3_1 = arg8[v1];
            if(!v3_1.dexName.equals(v0[v1])) {
                break;
            }

            v3_1.classSetSize = v2[v1];
            v3_1.classes = ProfileTranscoder.readClasses(arg6, v3_1.classSetSize);
            ++v1;
        }

        throw Encoding.error("Order of dexfiles in metadata did not match baseline");
        return arg8;
    label_35:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    static DexProfileData[] readMetadataV002(InputStream arg5, byte[] arg6, DexProfileData[] arg7) throws IOException {
        DexProfileData[] v6_1;
        int v0 = Encoding.readUInt16(arg5);
        byte[] v1 = Encoding.readCompressed(arg5, ((int)Encoding.readUInt32(arg5)), ((int)Encoding.readUInt32(arg5)));
        if(arg5.read() <= 0) {
            ByteArrayInputStream v5 = new ByteArrayInputStream(v1);
            try {
                v6_1 = ProfileTranscoder.readMetadataV002Body(((InputStream)v5), arg6, v0, arg7);
            }
            catch(Throwable v6) {
                try {
                    ((InputStream)v5).close();
                }
                catch(Throwable v5_1) {
                    v6.addSuppressed(v5_1);
                }

                throw v6;
            }

            ((InputStream)v5).close();
            return v6_1;
        }

        throw Encoding.error("Content found after the end of file");
    }

    private static DexProfileData[] readMetadataV002Body(InputStream arg6, byte[] arg7, int arg8, DexProfileData[] arg9) throws IOException {
        String v0;
        int v1 = 0;
        if(arg6.available() == 0) {
            return new DexProfileData[0];
        }

        if(arg8 != arg9.length) {
            goto label_32;
        }

        while(true) {
            if(v1 >= arg8) {
                return arg9;
            }

            Encoding.readUInt16(arg6);
            v0 = Encoding.readString(arg6, Encoding.readUInt16(arg6));
            long v2 = Encoding.readUInt32(arg6);
            int v4 = Encoding.readUInt16(arg6);
            DexProfileData v5 = ProfileTranscoder.findByDexName(arg9, v0);
            if(v5 == null) {
                break;
            }

            v5.mTypeIdCount = v2;
            int[] v0_1 = ProfileTranscoder.readClasses(arg6, v4);
            if(Arrays.equals(arg7, ProfileVersion.V001_N)) {
                v5.classSetSize = v4;
                v5.classes = v0_1;
            }

            ++v1;
        }

        throw Encoding.error("Missing profile key: " + v0);
        return arg9;
    label_32:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(InputStream arg6, DexProfileData arg7) throws IOException {
        Integer v3_1;
        BitSet v6 = BitSet.valueOf(Encoding.read(arg6, Encoding.bitsToBytes(arg7.numMethodIds * 2)));
        int v1;
        for(v1 = 0; v1 < arg7.numMethodIds; ++v1) {
            int v2 = ProfileTranscoder.readFlagsFromBitmap(v6, v1, arg7.numMethodIds);
            if(v2 != 0) {
                Object v3 = arg7.methods.get(Integer.valueOf(v1));
                if(v3 == null) {
                    v3_1 = Integer.valueOf(0);
                }

                arg7.methods.put(Integer.valueOf(v1), Integer.valueOf(v2 | v3_1.intValue()));
            }
        }
    }

    static DexProfileData[] readProfile(InputStream arg4, byte[] arg5, String arg6) throws IOException {
        DexProfileData[] v5_2;
        if(Arrays.equals(arg5, ProfileVersion.V010_P)) {
            int v5 = Encoding.readUInt8(arg4);
            byte[] v0 = Encoding.readCompressed(arg4, ((int)Encoding.readUInt32(arg4)), ((int)Encoding.readUInt32(arg4)));
            if(arg4.read() <= 0) {
                ByteArrayInputStream v4 = new ByteArrayInputStream(v0);
                try {
                    v5_2 = ProfileTranscoder.readUncompressedBody(((InputStream)v4), arg6, v5);
                }
                catch(Throwable v5_1) {
                    try {
                        ((InputStream)v4).close();
                    }
                    catch(Throwable v4_1) {
                        v5_1.addSuppressed(v4_1);
                    }

                    throw v5_1;
                }

                ((InputStream)v4).close();
                return v5_2;
            }

            throw Encoding.error("Content found after the end of file");
        }

        throw Encoding.error("Unsupported version");
    }

    private static DexProfileData[] readUncompressedBody(InputStream arg18, String arg19, int arg20) throws IOException {
        InputStream v0 = arg18;
        int v1 = arg20;
        int v3 = 0;
        if(v0.available() == 0) {
            return new DexProfileData[0];
        }

        DexProfileData[] v2 = new DexProfileData[v1];
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            int v5 = Encoding.readUInt16(v0);
            int v13 = Encoding.readUInt16(v0);
            v2[v4] = new DexProfileData(arg19, Encoding.readString(v0, v5), Encoding.readUInt32(v0), 0, v13, ((int)Encoding.readUInt32(v0)), ((int)Encoding.readUInt32(v0)), new int[v13], new TreeMap());
        }

        while(v3 < v1) {
            DexProfileData v4_1 = v2[v3];
            ProfileTranscoder.readHotMethodRegion(v0, v4_1);
            ((DexProfileData)v4).classes = ProfileTranscoder.readClasses(v0, ((DexProfileData)v4).classSetSize);
            ProfileTranscoder.readMethodBitmap(v0, v4_1);
            ++v3;
        }

        return v2;
    }

    private static int roundUpToByte(int arg0) {
        return arg0 + 7 & -8;
    }

    private static void setMethodBitmapBit(byte[] arg1, int arg2, int arg3, DexProfileData arg4) {
        arg2 = ProfileTranscoder.methodFlagBitmapIndex(arg2, arg3, arg4.numMethodIds);
        arg3 = arg2 / 8;
        arg1[arg3] = ((byte)(1 << arg2 % 8 | arg1[arg3]));
    }

    private static void skipInlineCache(InputStream arg2) throws IOException {
        Encoding.readUInt16(arg2);
        int v0 = Encoding.readUInt8(arg2);
        if(v0 == 6) {
        }
        else {
            if(v0 == 7) {
                return;
            }

            while(v0 > 0) {
                Encoding.readUInt8(arg2);
                int v1;
                for(v1 = Encoding.readUInt8(arg2); v1 > 0; --v1) {
                    Encoding.readUInt16(arg2);
                }

                --v0;
            }
        }
    }

    static boolean transcodeAndWriteBody(OutputStream arg2, byte[] arg3, DexProfileData[] arg4) throws IOException {
        if(Arrays.equals(arg3, ProfileVersion.V015_S)) {
            ProfileTranscoder.writeProfileForS(arg2, arg4);
            return 1;
        }

        if(Arrays.equals(arg3, ProfileVersion.V010_P)) {
            ProfileTranscoder.writeProfileForP(arg2, arg4);
            return 1;
        }

        if(Arrays.equals(arg3, ProfileVersion.V005_O)) {
            ProfileTranscoder.writeProfileForO(arg2, arg4);
            return 1;
        }

        if(Arrays.equals(arg3, ProfileVersion.V009_O_MR1)) {
            ProfileTranscoder.writeProfileForO_MR1(arg2, arg4);
            return 1;
        }

        if(Arrays.equals(arg3, ProfileVersion.V001_N)) {
            ProfileTranscoder.writeProfileForN(arg2, arg4);
            return 1;
        }

        return 0;
    }

    private static void writeClasses(OutputStream arg5, DexProfileData arg6) throws IOException {
        int[] v6 = arg6.classes;
        int v0 = v6.length;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            Integer v3 = Integer.valueOf(v6[v1]);
            Encoding.writeUInt16(arg5, v3.intValue() - v2);
            v2 = v3.intValue();
            ++v1;
        }
    }

    private static WritableFileSection writeDexFileSection(DexProfileData[] arg7) throws IOException {
        WritableFileSection v3_1;
        byte[] v7_1;
        int v2;
        ByteArrayOutputStream v0 = new ByteArrayOutputStream();
        try {
            Encoding.writeUInt16(((OutputStream)v0), arg7.length);
            v2 = 2;
            int v3;
            for(v3 = 0; v3 < arg7.length; ++v3) {
                DexProfileData v4 = arg7[v3];
                Encoding.writeUInt32(((OutputStream)v0), v4.dexChecksum);
                Encoding.writeUInt32(((OutputStream)v0), v4.mTypeIdCount);
                Encoding.writeUInt32(((OutputStream)v0), ((long)v4.numMethodIds));
                String v4_1 = ProfileTranscoder.generateDexKey(v4.apkName, v4.dexName, ProfileVersion.V015_S);
                int v5 = Encoding.utf8Length(v4_1);
                Encoding.writeUInt16(((OutputStream)v0), v5);
                v2 = v2 + 14 + v5;
                Encoding.writeString(((OutputStream)v0), v4_1);
            }

            v7_1 = v0.toByteArray();
            if(v2 != v7_1.length) {
                goto label_36;
            }

            v3_1 = new WritableFileSection(FileSectionType.DEX_FILES, v2, v7_1, false);
        }
        catch(Throwable v7) {
            goto label_49;
        }

        v0.close();
        return v3_1;
        try {
        label_36:
            throw Encoding.error("Expected size " + v2 + ", does not match actual size " + v7_1.length);
        }
        catch(Throwable v7) {
            try {
            label_49:
                v0.close();
            }
            catch(Throwable v0_1) {
                v7.addSuppressed(v0_1);
            }

            throw v7;
        }
    }

    static void writeHeader(OutputStream arg1, byte[] arg2) throws IOException {
        arg1.write(ProfileTranscoder.MAGIC_PROF);
        arg1.write(arg2);
    }

    private static void writeLineData(OutputStream arg0, DexProfileData arg1) throws IOException {
        ProfileTranscoder.writeMethodsWithInlineCaches(arg0, arg1);
        ProfileTranscoder.writeClasses(arg0, arg1);
        ProfileTranscoder.writeMethodBitmap(arg0, arg1);
    }

    private static void writeLineHeader(OutputStream arg2, DexProfileData arg3, String arg4) throws IOException {
        Encoding.writeUInt16(arg2, Encoding.utf8Length(arg4));
        Encoding.writeUInt16(arg2, arg3.classSetSize);
        Encoding.writeUInt32(arg2, ((long)arg3.hotMethodRegionSize));
        Encoding.writeUInt32(arg2, arg3.dexChecksum);
        Encoding.writeUInt32(arg2, ((long)arg3.numMethodIds));
        Encoding.writeString(arg2, arg4);
    }

    private static void writeMethodBitmap(OutputStream arg5, DexProfileData arg6) throws IOException {
        byte[] v0 = new byte[ProfileTranscoder.getMethodBitmapStorageSize(arg6.numMethodIds)];
        Iterator v1 = arg6.methods.entrySet().iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            int v3 = ((Map$Entry)v2).getKey().intValue();
            int v2_1 = ((Map$Entry)v2).getValue().intValue();
            if((v2_1 & 2) != 0) {
                ProfileTranscoder.setMethodBitmapBit(v0, 2, v3, arg6);
            }

            if((v2_1 & 4) == 0) {
                continue;
            }

            ProfileTranscoder.setMethodBitmapBit(v0, 4, v3, arg6);
        }

        arg5.write(v0);
    }

    private static void writeMethodBitmapForS(OutputStream arg10, int arg11, DexProfileData arg12) throws IOException {
        byte[] v0 = new byte[ProfileTranscoder.getMethodBitmapStorageSizeForS(arg11, arg12.numMethodIds)];
        Iterator v1 = arg12.methods.entrySet().iterator();
    label_6:
        if(v1.hasNext()) {
            Object v2 = v1.next();
            int v3 = ((Map$Entry)v2).getKey().intValue();
            int v2_1 = ((Map$Entry)v2).getValue().intValue();
            int v5 = 0;
            int v6;
            for(v6 = 1; true; v6 <<= 1) {
                if(v6 > 4) {
                    goto label_6;
                }

                if(v6 != 1) {
                    if((v6 & arg11) == 0) {
                    }
                    else {
                        if((v6 & v2_1) == v6) {
                            int v7 = arg12.numMethodIds * v5 + v3;
                            int v8 = v7 / 8;
                            v0[v8] = ((byte)(1 << v7 % 8 | v0[v8]));
                        }

                        ++v5;
                    }
                }
            }
        }

        arg10.write(v0);
    }

    private static void writeMethodsWithInlineCaches(OutputStream arg4, DexProfileData arg5) throws IOException {
        Iterator v5 = arg5.methods.entrySet().iterator();
        int v1;
        for(v1 = 0; v5.hasNext(); v1 = v3) {
            Object v2 = v5.next();
            int v3 = ((Map$Entry)v2).getKey().intValue();
            if((((Map$Entry)v2).getValue().intValue() & 1) == 0) {
                continue;
            }

            Encoding.writeUInt16(arg4, v3 - v1);
            Encoding.writeUInt16(arg4, 0);
        }
    }

    private static void writeProfileForN(OutputStream arg7, DexProfileData[] arg8) throws IOException {
        Encoding.writeUInt16(arg7, arg8.length);
        int v0 = arg8.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            DexProfileData v3 = arg8[v2];
            String v4 = ProfileTranscoder.generateDexKey(v3.apkName, v3.dexName, ProfileVersion.V001_N);
            Encoding.writeUInt16(arg7, Encoding.utf8Length(v4));
            Encoding.writeUInt16(arg7, v3.methods.size());
            Encoding.writeUInt16(arg7, v3.classes.length);
            Encoding.writeUInt32(arg7, v3.dexChecksum);
            Encoding.writeString(arg7, v4);
            Iterator v4_1 = v3.methods.keySet().iterator();
            while(v4_1.hasNext()) {
                Encoding.writeUInt16(arg7, v4_1.next().intValue());
            }

            int[] v3_1 = v3.classes;
            int v4_2 = v3_1.length;
            int v5;
            for(v5 = 0; v5 < v4_2; ++v5) {
                Encoding.writeUInt16(arg7, v3_1[v5]);
            }
        }
    }

    private static void writeProfileForO(OutputStream arg8, DexProfileData[] arg9) throws IOException {
        Encoding.writeUInt8(arg8, arg9.length);
        int v0 = arg9.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            DexProfileData v3 = arg9[v2];
            int v4 = v3.methods.size() * 4;
            String v5 = ProfileTranscoder.generateDexKey(v3.apkName, v3.dexName, ProfileVersion.V005_O);
            Encoding.writeUInt16(arg8, Encoding.utf8Length(v5));
            Encoding.writeUInt16(arg8, v3.classes.length);
            Encoding.writeUInt32(arg8, ((long)v4));
            Encoding.writeUInt32(arg8, v3.dexChecksum);
            Encoding.writeString(arg8, v5);
            Iterator v4_1 = v3.methods.keySet().iterator();
            while(v4_1.hasNext()) {
                Encoding.writeUInt16(arg8, v4_1.next().intValue());
                Encoding.writeUInt16(arg8, 0);
            }

            int[] v3_1 = v3.classes;
            v4 = v3_1.length;
            int v5_1;
            for(v5_1 = 0; v5_1 < v4; ++v5_1) {
                Encoding.writeUInt16(arg8, v3_1[v5_1]);
            }
        }
    }

    private static void writeProfileForO_MR1(OutputStream arg1, DexProfileData[] arg2) throws IOException {
        byte[] v0 = ProfileTranscoder.createCompressibleBody(arg2, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(arg1, arg2.length);
        Encoding.writeCompressed(arg1, v0);
    }

    private static void writeProfileForP(OutputStream arg1, DexProfileData[] arg2) throws IOException {
        byte[] v0 = ProfileTranscoder.createCompressibleBody(arg2, ProfileVersion.V010_P);
        Encoding.writeUInt8(arg1, arg2.length);
        Encoding.writeCompressed(arg1, v0);
    }

    private static void writeProfileForS(OutputStream arg0, DexProfileData[] arg1) throws IOException {
        ProfileTranscoder.writeProfileSections(arg0, arg1);
    }

    private static void writeProfileSections(OutputStream arg10, DexProfileData[] arg11) throws IOException {
        int v5_2;
        ArrayList v0 = new ArrayList(3);
        ArrayList v2 = new ArrayList(3);
        ((List)v0).add(ProfileTranscoder.writeDexFileSection(arg11));
        ((List)v0).add(ProfileTranscoder.createCompressibleClassSection(arg11));
        ((List)v0).add(ProfileTranscoder.createCompressibleMethodsSection(arg11));
        long v3 = (((long)ProfileVersion.V015_S.length)) + (((long)ProfileTranscoder.MAGIC_PROF.length)) + 4 + (((long)(((List)v0).size() * 16)));
        Encoding.writeUInt32(arg10, ((long)((List)v0).size()));
        int v11 = 0;
        int v1;
        for(v1 = 0; v1 < ((List)v0).size(); ++v1) {
            Object v5 = ((List)v0).get(v1);
            Encoding.writeUInt32(arg10, ((WritableFileSection)v5).mType.getValue());
            Encoding.writeUInt32(arg10, v3);
            if(((WritableFileSection)v5).mNeedsCompression) {
                long v6 = ((long)((WritableFileSection)v5).mContents.length);
                byte[] v5_1 = Encoding.compress(((WritableFileSection)v5).mContents);
                ((List)v2).add(v5_1);
                Encoding.writeUInt32(arg10, ((long)v5_1.length));
                Encoding.writeUInt32(arg10, v6);
                v5_2 = v5_1.length;
            }
            else {
                ((List)v2).add(((WritableFileSection)v5).mContents);
                Encoding.writeUInt32(arg10, ((long)((WritableFileSection)v5).mContents.length));
                Encoding.writeUInt32(arg10, 0);
                v5_2 = ((WritableFileSection)v5).mContents.length;
            }

            v3 += ((long)v5_2);
        }

        while(v11 < ((List)v2).size()) {
            arg10.write(((List)v2).get(v11));
            ++v11;
        }
    }
}

