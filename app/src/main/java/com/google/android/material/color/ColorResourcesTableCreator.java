package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

final class ColorResourcesTableCreator {
    class com.google.android.material.color.ColorResourcesTableCreator$1 implements Comparator {
        com.google.android.material.color.ColorResourcesTableCreator$1() {
            super();
        }

        public int compare(ColorResource arg1, ColorResource arg2) {
            return ColorResource.access$000(arg1) - ColorResource.access$000(arg2);
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((ColorResource)arg1), ((ColorResource)arg2));
        }
    }

    class ColorResource {
        private final short entryId;
        private final String name;
        private final byte packageId;
        private final byte typeId;
        private final int value;

        ColorResource(int arg1, String arg2, int arg3) {
            super();
            this.name = arg2;
            this.value = arg3;
            this.entryId = ((short)(0xFFFF & arg1));
            this.typeId = ((byte)(arg1 >> 16 & 0xFF));
            this.packageId = ((byte)(arg1 >> 24 & 0xFF));
        }

        static short access$000(ColorResource arg0) {
            return arg0.entryId;
        }

        static String access$100(ColorResource arg0) {
            return arg0.name;
        }

        static int access$1400(ColorResource arg0) {
            return arg0.value;
        }

        static byte access$200(ColorResource arg0) {
            return arg0.typeId;
        }

        static byte access$300(ColorResource arg0) {
            return arg0.packageId;
        }
    }

    class PackageChunk {
        private static final short HEADER_SIZE = 0x120;
        private static final int PACKAGE_NAME_MAX_LENGTH = 0x80;
        private final ResChunkHeader header;
        private final StringPoolChunk keyStrings;
        private final PackageInfo packageInfo;
        private final TypeSpecChunk typeSpecChunk;
        private final StringPoolChunk typeStrings;

        PackageChunk(PackageInfo arg6, List arg7) {
            super();
            this.packageInfo = arg6;
            String[] v0 = new String[6];
            int v2 = 0;
            v0[0] = "?1";
            v0[1] = "?2";
            v0[2] = "?3";
            v0[3] = "?4";
            v0[4] = "?5";
            v0[5] = "color";
            this.typeStrings = new StringPoolChunk(false, v0);
            String[] v6 = new String[arg7.size()];
            while(v2 < arg7.size()) {
                v6[v2] = arg7.get(v2).name;
                ++v2;
            }

            this.keyStrings = new StringPoolChunk(true, v6);
            this.typeSpecChunk = new TypeSpecChunk(arg7);
            this.header = new ResChunkHeader(0x200, 0x120, this.getChunkSize());
        }

        int getChunkSize() {
            return this.typeStrings.getChunkSize() + 0x120 + this.keyStrings.getChunkSize() + this.typeSpecChunk.getChunkSizeWithTypeChunk();
        }

        void writeTo(ByteArrayOutputStream arg5) throws IOException {
            this.header.writeTo(arg5);
            arg5.write(ColorResourcesTableCreator.intToByteArray(PackageInfo.access$1000(this.packageInfo)));
            char[] v0 = PackageInfo.access$1100(this.packageInfo).toCharArray();
            int v2;
            for(v2 = 0; v2 < 0x80; ++v2) {
                if(v2 < v0.length) {
                    arg5.write(ColorResourcesTableCreator.charToByteArray(v0[v2]));
                }
                else {
                    arg5.write(ColorResourcesTableCreator.charToByteArray('\u0000'));
                }
            }

            arg5.write(ColorResourcesTableCreator.intToByteArray(0x120));
            arg5.write(ColorResourcesTableCreator.intToByteArray(0));
            arg5.write(ColorResourcesTableCreator.intToByteArray(this.typeStrings.getChunkSize() + 0x120));
            arg5.write(ColorResourcesTableCreator.intToByteArray(0));
            arg5.write(ColorResourcesTableCreator.intToByteArray(0));
            this.typeStrings.writeTo(arg5);
            this.keyStrings.writeTo(arg5);
            this.typeSpecChunk.writeTo(arg5);
        }
    }

    class PackageInfo {
        private final int id;
        private final String name;

        PackageInfo(int arg1, String arg2) {
            super();
            this.id = arg1;
            this.name = arg2;
        }

        static int access$1000(PackageInfo arg0) {
            return arg0.id;
        }

        static String access$1100(PackageInfo arg0) {
            return arg0.name;
        }
    }

    class ResChunkHeader {
        private final int chunkSize;
        private final short headerSize;
        private final short type;

        ResChunkHeader(short arg1, short arg2, int arg3) {
            super();
            this.type = arg1;
            this.headerSize = arg2;
            this.chunkSize = arg3;
        }

        void writeTo(ByteArrayOutputStream arg2) throws IOException {
            arg2.write(ColorResourcesTableCreator.shortToByteArray(this.type));
            arg2.write(ColorResourcesTableCreator.shortToByteArray(this.headerSize));
            arg2.write(ColorResourcesTableCreator.intToByteArray(this.chunkSize));
        }
    }

    class ResEntry {
        private static final byte DATA_TYPE_AARRGGBB = 28;
        private static final short ENTRY_SIZE = 8;
        private static final short FLAG_PUBLIC = 2;
        private static final int SIZE = 16;
        private static final short VALUE_SIZE = 8;
        private final int data;
        private final int keyStringIndex;

        ResEntry(int arg1, int arg2) {
            super();
            this.keyStringIndex = arg1;
            this.data = arg2;
        }

        void writeTo(ByteArrayOutputStream arg4) throws IOException {
            arg4.write(ColorResourcesTableCreator.shortToByteArray(8));
            arg4.write(ColorResourcesTableCreator.shortToByteArray(2));
            arg4.write(ColorResourcesTableCreator.intToByteArray(this.keyStringIndex));
            arg4.write(ColorResourcesTableCreator.shortToByteArray(8));
            arg4.write(new byte[]{0, 28});
            arg4.write(ColorResourcesTableCreator.intToByteArray(this.data));
        }
    }

    class ResTable {
        private static final short HEADER_SIZE = 12;
        private final ResChunkHeader header;
        private final List packageChunks;
        private final int packageCount;
        private final StringPoolChunk stringPool;

        ResTable(Map arg5) {
            super();
            this.packageChunks = new ArrayList();
            this.packageCount = arg5.size();
            this.stringPool = new StringPoolChunk(new String[0]);
            Iterator v5 = arg5.entrySet().iterator();
            while(v5.hasNext()) {
                Object v0 = v5.next();
                Object v1 = ((Map$Entry)v0).getValue();
                Collections.sort(((List)v1), ColorResourcesTableCreator.COLOR_RESOURCE_COMPARATOR);
                this.packageChunks.add(new PackageChunk(((Map$Entry)v0).getKey(), ((List)v1)));
            }

            this.header = new ResChunkHeader(2, 12, this.getOverallSize());
        }

        private int getOverallSize() {
            Iterator v0 = this.packageChunks.iterator();
            int v1;
            for(v1 = 0; v0.hasNext(); v1 += v0.next().getChunkSize()) {
            }

            return this.stringPool.getChunkSize() + 12 + v1;
        }

        void writeTo(ByteArrayOutputStream arg2) throws IOException {
            this.header.writeTo(arg2);
            arg2.write(ColorResourcesTableCreator.intToByteArray(this.packageCount));
            this.stringPool.writeTo(arg2);
            Iterator v1 = this.packageChunks.iterator();
            while(v1.hasNext()) {
                v1.next().writeTo(arg2);
            }
        }
    }

    class StringPoolChunk {
        private static final int FLAG_UTF8 = 0x100;
        private static final short HEADER_SIZE = 28;
        private static final int STYLED_SPAN_LIST_END = -1;
        private final int chunkSize;
        private final ResChunkHeader header;
        private final int stringCount;
        private final List stringIndex;
        private final List strings;
        private final int stringsPaddingSize;
        private final int stringsStart;
        private final int styledSpanCount;
        private final List styledSpanIndex;
        private final List styledSpans;
        private final int styledSpansStart;
        private final boolean utf8Encode;

        StringPoolChunk(boolean arg9, String[] arg10) {
            super();
            this.stringIndex = new ArrayList();
            this.styledSpanIndex = new ArrayList();
            this.strings = new ArrayList();
            this.styledSpans = new ArrayList();
            this.utf8Encode = arg9;
            int v9 = arg10.length;
            int v0 = 0;
            int v1 = 0;
            int v2 = 0;
            while(v1 < v9) {
                Pair v3 = this.processString(arg10[v1]);
                this.stringIndex.add(Integer.valueOf(v2));
                v2 += v3.first.length;
                this.strings.add(v3.first);
                this.styledSpans.add(v3.second);
                ++v1;
            }

            Iterator v9_1 = this.styledSpans.iterator();
            for(v1 = 0; v9_1.hasNext(); v1 += ((List)v3_1).size() * 12 + 4) {
                Object v3_1 = v9_1.next();
                Iterator v4 = ((List)v3_1).iterator();
                while(v4.hasNext()) {
                    Object v5 = v4.next();
                    this.stringIndex.add(Integer.valueOf(v2));
                    v2 += StringStyledSpan.access$700(((StringStyledSpan)v5)).length;
                    this.strings.add(StringStyledSpan.access$700(((StringStyledSpan)v5)));
                }

                this.styledSpanIndex.add(Integer.valueOf(v1));
            }

            v9 = v2 % 4;
            v9 = v9 == 0 ? 0 : 4 - v9;
            this.stringsPaddingSize = v9;
            int v3_2 = this.strings.size();
            this.stringCount = v3_2;
            this.styledSpanCount = this.strings.size() - arg10.length;
            int v4_1 = this.strings.size() - arg10.length > 0 ? 1 : 0;
            if(v4_1 == 0) {
                this.styledSpanIndex.clear();
                this.styledSpans.clear();
            }

            short v5_1 = 28;
            v3_2 = v3_2 * 4 + v5_1 + this.styledSpanIndex.size() * 4;
            this.stringsStart = v3_2;
            v2 += v9;
            v9 = v4_1 != 0 ? v3_2 + v2 : 0;
            this.styledSpansStart = v9;
            v3_2 += v2;
            if(v4_1 != 0) {
                v0 = v1;
            }

            v3_2 += v0;
            this.chunkSize = v3_2;
            this.header = new ResChunkHeader(1, v5_1, v3_2);
        }

        StringPoolChunk(String[] arg2) {
            this(false, arg2);
        }

        int getChunkSize() {
            return this.chunkSize;
        }

        private Pair processString(String arg2) {
            byte[] v1 = this.utf8Encode ? ColorResourcesTableCreator.stringToByteArrayUtf8(arg2) : ColorResourcesTableCreator.stringToByteArray(arg2);
            return new Pair(v1, Collections.emptyList());
        }

        void writeTo(ByteArrayOutputStream arg3) throws IOException {
            this.header.writeTo(arg3);
            arg3.write(ColorResourcesTableCreator.intToByteArray(this.stringCount));
            arg3.write(ColorResourcesTableCreator.intToByteArray(this.styledSpanCount));
            int v0 = this.utf8Encode ? 0x100 : 0;
            arg3.write(ColorResourcesTableCreator.intToByteArray(v0));
            arg3.write(ColorResourcesTableCreator.intToByteArray(this.stringsStart));
            arg3.write(ColorResourcesTableCreator.intToByteArray(this.styledSpansStart));
            Iterator v0_1 = this.stringIndex.iterator();
            while(v0_1.hasNext()) {
                arg3.write(ColorResourcesTableCreator.intToByteArray(v0_1.next().intValue()));
            }

            v0_1 = this.styledSpanIndex.iterator();
            while(v0_1.hasNext()) {
                arg3.write(ColorResourcesTableCreator.intToByteArray(v0_1.next().intValue()));
            }

            v0_1 = this.strings.iterator();
            while(v0_1.hasNext()) {
                arg3.write(v0_1.next());
            }

            v0 = this.stringsPaddingSize;
            if(v0 > 0) {
                arg3.write(new byte[v0]);
            }

            Iterator v2 = this.styledSpans.iterator();
            while(v2.hasNext()) {
                v0_1 = v2.next().iterator();
                while(v0_1.hasNext()) {
                    v0_1.next().writeTo(arg3);
                }

                arg3.write(ColorResourcesTableCreator.intToByteArray(-1));
            }
        }
    }

    class StringStyledSpan {
        private int firstCharacterIndex;
        private int lastCharacterIndex;
        private int nameReference;
        private byte[] styleString;

        private StringStyledSpan() {
            super();
        }

        static byte[] access$700(StringStyledSpan arg0) {
            return arg0.styleString;
        }

        void writeTo(ByteArrayOutputStream arg2) throws IOException {
            arg2.write(ColorResourcesTableCreator.intToByteArray(this.nameReference));
            arg2.write(ColorResourcesTableCreator.intToByteArray(this.firstCharacterIndex));
            arg2.write(ColorResourcesTableCreator.intToByteArray(this.lastCharacterIndex));
        }
    }

    class TypeChunk {
        private static final byte CONFIG_SIZE = 0x40;
        private static final short HEADER_SIZE = 84;
        private static final int OFFSET_NO_ENTRY = -1;
        private final byte[] config;
        private final int entryCount;
        private final ResChunkHeader header;
        private final int[] offsetTable;
        private final ResEntry[] resEntries;

        TypeChunk(List arg6, Set arg7, int arg8) {
            super();
            byte[] v1 = new byte[0x40];
            this.config = v1;
            this.entryCount = arg8;
            short v2 = 0;
            v1[0] = 0x40;
            this.resEntries = new ResEntry[arg6.size()];
            int v0;
            for(v0 = 0; v0 < arg6.size(); ++v0) {
                this.resEntries[v0] = new ResEntry(v0, arg6.get(v0).value);
            }

            this.offsetTable = new int[arg8];
            int v6 = 0;
            while(v2 < arg8) {
                boolean v0_1 = arg7.contains(Short.valueOf(v2));
                int[] v1_1 = this.offsetTable;
                if(v0_1) {
                    v1_1[v2] = v6;
                    v6 += 16;
                }
                else {
                    v1_1[v2] = -1;
                }

                v2 = ((short)(v2 + 1));
            }

            this.header = new ResChunkHeader(0x201, 84, this.getChunkSize());
        }

        int getChunkSize() {
            return this.getEntryStart() + this.resEntries.length * 16;
        }

        private int getEntryStart() {
            return this.getOffsetTableSize() + 84;
        }

        private int getOffsetTableSize() {
            return this.offsetTable.length * 4;
        }

        void writeTo(ByteArrayOutputStream arg6) throws IOException {
            this.header.writeTo(arg6);
            byte v0 = ColorResourcesTableCreator.typeIdColor;
            byte[] v1 = new byte[4];
            int v2 = 0;
            v1[0] = v0;
            v1[1] = 0;
            v1[2] = 0;
            v1[3] = 0;
            arg6.write(v1);
            arg6.write(ColorResourcesTableCreator.intToByteArray(this.entryCount));
            arg6.write(ColorResourcesTableCreator.intToByteArray(this.getEntryStart()));
            arg6.write(this.config);
            int[] v0_1 = this.offsetTable;
            int v1_1 = v0_1.length;
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                arg6.write(ColorResourcesTableCreator.intToByteArray(v0_1[v3]));
            }

            ResEntry[] v5 = this.resEntries;
            int v0_2 = v5.length;
            while(v2 < v0_2) {
                v5[v2].writeTo(arg6);
                ++v2;
            }
        }
    }

    class TypeSpecChunk {
        private static final short HEADER_SIZE = 16;
        private static final int SPEC_PUBLIC = 0x40000000;
        private final int entryCount;
        private final int[] entryFlags;
        private final ResChunkHeader header;
        private final TypeChunk typeChunk;

        TypeSpecChunk(List arg6) {
            super();
            this.entryCount = arg6.get(arg6.size() - 1).entryId + 1;
            HashSet v0 = new HashSet();
            Iterator v1 = arg6.iterator();
            while(v1.hasNext()) {
                ((Set)v0).add(Short.valueOf(v1.next().entryId));
            }

            this.entryFlags = new int[this.entryCount];
            short v1_1;
            for(v1_1 = 0; v1_1 < this.entryCount; v1_1 = ((short)(v1_1 + 1))) {
                if(((Set)v0).contains(Short.valueOf(v1_1))) {
                    this.entryFlags[v1_1] = 0x40000000;
                }
            }

            this.header = new ResChunkHeader(0x202, 16, this.getChunkSize());
            this.typeChunk = new TypeChunk(arg6, ((Set)v0), this.entryCount);
        }

        private int getChunkSize() {
            return this.entryCount * 4 + 16;
        }

        int getChunkSizeWithTypeChunk() {
            return this.getChunkSize() + this.typeChunk.getChunkSize();
        }

        void writeTo(ByteArrayOutputStream arg5) throws IOException {
            this.header.writeTo(arg5);
            byte v0 = ColorResourcesTableCreator.typeIdColor;
            byte[] v1 = new byte[4];
            int v2 = 0;
            v1[0] = v0;
            v1[1] = 0;
            v1[2] = 0;
            v1[3] = 0;
            arg5.write(v1);
            arg5.write(ColorResourcesTableCreator.intToByteArray(this.entryCount));
            int[] v0_1 = this.entryFlags;
            int v1_1 = v0_1.length;
            while(v2 < v1_1) {
                arg5.write(ColorResourcesTableCreator.intToByteArray(v0_1[v2]));
                ++v2;
            }

            this.typeChunk.writeTo(arg5);
        }
    }

    private static final byte ANDROID_PACKAGE_ID = 1;
    private static final PackageInfo ANDROID_PACKAGE_INFO = null;
    private static final byte APPLICATION_PACKAGE_ID = 0x7F;
    private static final Comparator COLOR_RESOURCE_COMPARATOR = null;
    private static final short HEADER_TYPE_PACKAGE = 0x200;
    private static final short HEADER_TYPE_RES_TABLE = 2;
    private static final short HEADER_TYPE_STRING_POOL = 1;
    private static final short HEADER_TYPE_TYPE = 0x201;
    private static final short HEADER_TYPE_TYPE_SPEC = 0x202;
    private static final String RESOURCE_TYPE_NAME_COLOR = "color";
    private static byte typeIdColor;

    static {
        ColorResourcesTableCreator.ANDROID_PACKAGE_INFO = new PackageInfo(1, "android");
        ColorResourcesTableCreator.COLOR_RESOURCE_COMPARATOR = new com.google.android.material.color.ColorResourcesTableCreator$1();
    }

    private ColorResourcesTableCreator() {
        super();
    }

    static byte[] access$1200(char arg0) {
        return ColorResourcesTableCreator.charToByteArray(arg0);
    }

    static byte access$1300() {
        return ColorResourcesTableCreator.typeIdColor;
    }

    static Comparator access$400() {
        return ColorResourcesTableCreator.COLOR_RESOURCE_COMPARATOR;
    }

    static byte[] access$500(int arg0) {
        return ColorResourcesTableCreator.intToByteArray(arg0);
    }

    static byte[] access$600(short arg0) {
        return ColorResourcesTableCreator.shortToByteArray(arg0);
    }

    static byte[] access$800(String arg0) {
        return ColorResourcesTableCreator.stringToByteArrayUtf8(arg0);
    }

    static byte[] access$900(String arg0) {
        return ColorResourcesTableCreator.stringToByteArray(arg0);
    }

    private static byte[] charToByteArray(char arg3) {
        return new byte[]{((byte)(arg3 & 0xFF)), ((byte)(arg3 >> 8 & 0xFF))};
    }

    static byte[] create(Context arg8, Map arg9) throws IOException {
        PackageInfo v3_2;
        ColorResource v4;
        if(arg9.entrySet().isEmpty()) {
            goto label_87;
        }

        int v2 = 0x7F;
        PackageInfo v0 = new PackageInfo(v2, arg8.getPackageName());
        HashMap v1 = new HashMap();
        Iterator v9 = arg9.entrySet().iterator();
        ColorResource v3;
        for(v3 = null; true; v3 = v4) {
            if(!v9.hasNext()) {
                goto label_73;
            }

            Object v3_1 = v9.next();
            v4 = new ColorResource(((Map$Entry)v3_1).getKey().intValue(), arg8.getResources().getResourceName(((Map$Entry)v3_1).getKey().intValue()), ((Map$Entry)v3_1).getValue().intValue());
            if(!arg8.getResources().getResourceTypeName(((Map$Entry)v3_1).getKey().intValue()).equals("color")) {
                goto label_58;
            }

            if(ColorResource.access$300(v4) == 1) {
                v3_2 = ColorResourcesTableCreator.ANDROID_PACKAGE_INFO;
            }
            else if(ColorResource.access$300(v4) == v2) {
                v3_2 = v0;
            }
            else {
                break;
            }

            if(!((Map)v1).containsKey(v3_2)) {
                ((Map)v1).put(v3_2, new ArrayList());
            }

            ((Map)v1).get(v3_2).add(v4);
        }

        throw new IllegalArgumentException("Not supported with unknown package id: " + ColorResource.access$300(v4));
    label_58:
        throw new IllegalArgumentException("Non color resource found: name=" + ColorResource.access$100(v4) + ", typeId=" + Integer.toHexString(ColorResource.access$200(v4) & 0xFF));
    label_73:
        byte v8 = ColorResource.access$200(v3);
        ColorResourcesTableCreator.typeIdColor = v8;
        if(v8 != 0) {
            ByteArrayOutputStream v8_1 = new ByteArrayOutputStream();
            new ResTable(((Map)v1)).writeTo(v8_1);
            return v8_1.toByteArray();
        }

        throw new IllegalArgumentException("No color resources found for harmonization.");
    label_87:
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    private static byte[] intToByteArray(int arg5) {
        return new byte[]{((byte)(arg5 & 0xFF)), ((byte)(arg5 >> 8 & 0xFF)), ((byte)(arg5 >> 16 & 0xFF)), ((byte)(arg5 >> 24 & 0xFF))};
    }

    private static byte[] shortToByteArray(short arg3) {
        return new byte[]{((byte)(arg3 & 0xFF)), ((byte)(arg3 >> 8 & 0xFF))};
    }

    private static byte[] stringToByteArray(String arg9) {
        char[] v9 = arg9.toCharArray();
        int v0 = v9.length * 2;
        byte[] v1 = new byte[v0 + 4];
        byte[] v2 = ColorResourcesTableCreator.shortToByteArray(((short)v9.length));
        v1[0] = v2[0];
        v1[1] = v2[1];
        int v2_1;
        for(v2_1 = 0; v2_1 < v9.length; ++v2_1) {
            byte[] v5 = ColorResourcesTableCreator.charToByteArray(v9[v2_1]);
            int v6 = v2_1 * 2;
            v1[v6 + 2] = v5[0];
            v1[v6 + 3] = v5[1];
        }

        v1[v0 + 2] = 0;
        v1[v0 + 3] = 0;
        return v1;
    }

    private static byte[] stringToByteArrayUtf8(String arg5) {
        byte[] v5 = arg5.getBytes(Charset.forName("UTF-8"));
        byte v0 = ((byte)v5.length);
        int v1 = v5.length;
        byte[] v2 = new byte[v1 + 3];
        System.arraycopy(v5, 0, v2, 2, v0);
        v2[1] = v0;
        v2[0] = v0;
        v2[v1 + 2] = 0;
        return v2;
    }
}

