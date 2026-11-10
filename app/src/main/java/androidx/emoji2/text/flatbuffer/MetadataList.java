package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {
    public final class Vector extends BaseVector {
        public Vector() {
            super();
        }

        public Vector __assign(int arg1, int arg2, ByteBuffer arg3) {
            this.__reset(arg1, arg2, arg3);
            return this;
        }

        public MetadataList get(int arg2) {
            return this.get(new MetadataList(), arg2);
        }

        public MetadataList get(MetadataList arg2, int arg3) {
            return arg2.__assign(MetadataList.__indirect(this.__element(arg3), this.bb), this.bb);
        }
    }

    public MetadataList() {
        super();
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public MetadataList __assign(int arg1, ByteBuffer arg2) {
        this.__init(arg1, arg2);
        return this;
    }

    public void __init(int arg1, ByteBuffer arg2) {
        this.__reset(arg1, arg2);
    }

    static int access$000(int arg0, ByteBuffer arg1) {
        return MetadataList.__indirect(arg0, arg1);
    }

    public static void addList(FlatBufferBuilder arg2, int arg3) {
        arg2.addOffset(1, arg3, 0);
    }

    public static void addSourceSha(FlatBufferBuilder arg2, int arg3) {
        arg2.addOffset(2, arg3, 0);
    }

    public static void addVersion(FlatBufferBuilder arg1, int arg2) {
        arg1.addInt(0, arg2, 0);
    }

    public static int createListVector(FlatBufferBuilder arg2, int[] arg3) {
        arg2.startVector(4, arg3.length, 4);
        int v0;
        for(v0 = arg3.length - 1; v0 >= 0; --v0) {
            arg2.addOffset(arg3[v0]);
        }

        return arg2.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder arg1, int arg2, int arg3, int arg4) {
        arg1.startTable(3);
        MetadataList.addSourceSha(arg1, arg4);
        MetadataList.addList(arg1, arg3);
        MetadataList.addVersion(arg1, arg2);
        return MetadataList.endMetadataList(arg1);
    }

    public static int endMetadataList(FlatBufferBuilder arg0) {
        return arg0.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder arg0, int arg1) {
        arg0.finish(arg1);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder arg0, int arg1) {
        arg0.finishSizePrefixed(arg1);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer arg1) {
        return MetadataList.getRootAsMetadataList(arg1, new MetadataList());
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer arg2, MetadataList arg3) {
        arg2.order(ByteOrder.LITTLE_ENDIAN);
        return arg3.__assign(arg2.getInt(arg2.position()) + arg2.position(), arg2);
    }

    public MetadataItem list(MetadataItem arg2, int arg3) {
        int v0 = this.__offset(6);
        if(v0 != 0) {
            return arg2.__assign(this.__indirect(this.__vector(v0) + arg3 * 4), this.bb);
        }

        return null;
    }

    public MetadataItem list(int arg2) {
        return this.list(new MetadataItem(), arg2);
    }

    public int listLength() {
        int v0 = this.__offset(6);
        if(v0 != 0) {
            return this.__vector_len(v0);
        }

        return 0;
    }

    public androidx.emoji2.text.flatbuffer.MetadataItem$Vector listVector() {
        return this.listVector(new androidx.emoji2.text.flatbuffer.MetadataItem$Vector());
    }

    public androidx.emoji2.text.flatbuffer.MetadataItem$Vector listVector(androidx.emoji2.text.flatbuffer.MetadataItem$Vector arg3) {
        int v0 = this.__offset(6);
        if(v0 != 0) {
            return arg3.__assign(this.__vector(v0), 4, this.bb);
        }

        return null;
    }

    public String sourceSha() {
        int v0 = this.__offset(8);
        if(v0 != 0) {
            return this.__string(v0 + this.bb_pos);
        }

        return null;
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return this.__vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer arg3) {
        return this.__vector_in_bytebuffer(arg3, 8, 1);
    }

    public static void startListVector(FlatBufferBuilder arg1, int arg2) {
        arg1.startVector(4, arg2, 4);
    }

    public static void startMetadataList(FlatBufferBuilder arg1) {
        arg1.startTable(3);
    }

    public int version() {
        int v0 = this.__offset(4);
        if(v0 != 0) {
            return this.bb.getInt(v0 + this.bb_pos);
        }

        return 0;
    }
}

