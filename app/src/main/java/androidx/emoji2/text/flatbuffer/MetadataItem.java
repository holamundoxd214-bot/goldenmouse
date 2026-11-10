package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataItem extends Table {
    public final class Vector extends BaseVector {
        public Vector() {
            super();
        }

        public Vector __assign(int arg1, int arg2, ByteBuffer arg3) {
            this.__reset(arg1, arg2, arg3);
            return this;
        }

        public MetadataItem get(int arg2) {
            return this.get(new MetadataItem(), arg2);
        }

        public MetadataItem get(MetadataItem arg2, int arg3) {
            return arg2.__assign(MetadataItem.__indirect(this.__element(arg3), this.bb), this.bb);
        }
    }

    public MetadataItem() {
        super();
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public MetadataItem __assign(int arg1, ByteBuffer arg2) {
        this.__init(arg1, arg2);
        return this;
    }

    public void __init(int arg1, ByteBuffer arg2) {
        this.__reset(arg1, arg2);
    }

    static int access$000(int arg0, ByteBuffer arg1) {
        return MetadataItem.__indirect(arg0, arg1);
    }

    public static void addCodepoints(FlatBufferBuilder arg2, int arg3) {
        arg2.addOffset(6, arg3, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder arg2, short arg3) {
        arg2.addShort(3, arg3, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder arg2, boolean arg3) {
        arg2.addBoolean(1, arg3, false);
    }

    public static void addHeight(FlatBufferBuilder arg2, short arg3) {
        arg2.addShort(5, arg3, 0);
    }

    public static void addId(FlatBufferBuilder arg1, int arg2) {
        arg1.addInt(0, arg2, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder arg2, short arg3) {
        arg2.addShort(2, arg3, 0);
    }

    public static void addWidth(FlatBufferBuilder arg2, short arg3) {
        arg2.addShort(4, arg3, 0);
    }

    public int codepoints(int arg3) {
        int v0 = this.__offset(16);
        if(v0 != 0) {
            return this.bb.getInt(this.__vector(v0) + arg3 * 4);
        }

        return 0;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return this.__vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer arg3) {
        return this.__vector_in_bytebuffer(arg3, 16, 4);
    }

    public int codepointsLength() {
        int v0 = this.__offset(16);
        if(v0 != 0) {
            return this.__vector_len(v0);
        }

        return 0;
    }

    public IntVector codepointsVector() {
        return this.codepointsVector(new IntVector());
    }

    public IntVector codepointsVector(IntVector arg2) {
        int v0 = this.__offset(16);
        if(v0 != 0) {
            return arg2.__assign(this.__vector(v0), this.bb);
        }

        return null;
    }

    public short compatAdded() {
        int v0 = this.__offset(10);
        if(v0 != 0) {
            return this.bb.getShort(v0 + this.bb_pos);
        }

        return 0;
    }

    public static int createCodepointsVector(FlatBufferBuilder arg2, int[] arg3) {
        arg2.startVector(4, arg3.length, 4);
        int v0;
        for(v0 = arg3.length - 1; v0 >= 0; --v0) {
            arg2.addInt(arg3[v0]);
        }

        return arg2.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder arg1, int arg2, boolean arg3, short arg4, short arg5, short arg6, short arg7, int arg8) {
        arg1.startTable(7);
        MetadataItem.addCodepoints(arg1, arg8);
        MetadataItem.addId(arg1, arg2);
        MetadataItem.addHeight(arg1, arg7);
        MetadataItem.addWidth(arg1, arg6);
        MetadataItem.addCompatAdded(arg1, arg5);
        MetadataItem.addSdkAdded(arg1, arg4);
        MetadataItem.addEmojiStyle(arg1, arg3);
        return MetadataItem.endMetadataItem(arg1);
    }

    public boolean emojiStyle() {
        int v0 = this.__offset(6);
        if(v0 != 0 && this.bb.get(v0 + this.bb_pos) != 0) {
            return 1;
        }

        return 0;
    }

    public static int endMetadataItem(FlatBufferBuilder arg0) {
        return arg0.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer arg1) {
        return MetadataItem.getRootAsMetadataItem(arg1, new MetadataItem());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer arg2, MetadataItem arg3) {
        arg2.order(ByteOrder.LITTLE_ENDIAN);
        return arg3.__assign(arg2.getInt(arg2.position()) + arg2.position(), arg2);
    }

    public short height() {
        int v0 = this.__offset(14);
        if(v0 != 0) {
            return this.bb.getShort(v0 + this.bb_pos);
        }

        return 0;
    }

    public int id() {
        int v0 = this.__offset(4);
        if(v0 != 0) {
            return this.bb.getInt(v0 + this.bb_pos);
        }

        return 0;
    }

    public short sdkAdded() {
        int v0 = this.__offset(8);
        if(v0 != 0) {
            return this.bb.getShort(v0 + this.bb_pos);
        }

        return 0;
    }

    public static void startCodepointsVector(FlatBufferBuilder arg1, int arg2) {
        arg1.startVector(4, arg2, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder arg1) {
        arg1.startTable(7);
    }

    public short width() {
        int v0 = this.__offset(12);
        if(v0 != 0) {
            return this.bb.getShort(v0 + this.bb_pos);
        }

        return 0;
    }
}

