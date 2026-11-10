package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class MetadataListReader {
    class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(ByteBuffer arg1) {
            super();
            this.mByteBuffer = arg1;
            arg1.order(ByteOrder.BIG_ENDIAN);
        }

        public long getPosition() {
            return ((long)this.mByteBuffer.position());
        }

        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        public void skip(int arg2) throws IOException {
            this.mByteBuffer.position(this.mByteBuffer.position() + arg2);
        }
    }

    class InputStreamOpenTypeReader implements OpenTypeReader {
        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition;

        InputStreamOpenTypeReader(InputStream arg3) {
            super();
            this.mPosition = 0;
            this.mInputStream = arg3;
            byte[] v3 = new byte[4];
            this.mByteArray = v3;
            ByteBuffer v3_1 = ByteBuffer.wrap(v3);
            this.mByteBuffer = v3_1;
            v3_1.order(ByteOrder.BIG_ENDIAN);
        }

        public long getPosition() {
            return this.mPosition;
        }

        private void read(int arg5) throws IOException {
            if(this.mInputStream.read(this.mByteArray, 0, arg5) == arg5) {
                this.mPosition += ((long)arg5);
                return;
            }

            throw new IOException("read failed");
        }

        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            this.read(4);
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            this.read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            this.read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        public void skip(int arg6) throws IOException {
            while(true) {
                if(arg6 <= 0) {
                    return;
                }

                int v0 = ((int)this.mInputStream.skip(((long)arg6)));
                if(v0 < 1) {
                    break;
                }

                arg6 -= v0;
                this.mPosition += ((long)v0);
            }

            throw new IOException("Skip didn\'t move at least 1 byte forward");
        }
    }

    class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long arg1, long arg3) {
            super();
            this.mStartOffset = arg1;
            this.mLength = arg3;
        }

        long getLength() {
            return this.mLength;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }
    }

    interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int arg1) throws IOException;
    }

    private static final int EMJI_TAG = 0x456D6A69;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 0x6D657461;

    private MetadataListReader() {
        super();
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader arg12) throws IOException {
        long v10;
        long v8;
        long v5;
        int v0 = 4;
        arg12.skip(v0);
        int v1 = arg12.readUnsignedShort();
        String v3 = "Cannot read metadata.";
        if(v1 <= 100) {
            arg12.skip(6);
            int v2 = 0;
            int v4 = 0;
            while(true) {
                v5 = -1;
                if(v4 < v1) {
                    int v7 = arg12.readTag();
                    arg12.skip(v0);
                    v8 = arg12.readUnsignedInt();
                    arg12.skip(v0);
                    if(0x6D657461 == v7) {
                    }
                    else {
                        ++v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_22;
            }

            v8 = v5;
        label_22:
            if(v8 != v5) {
                arg12.skip(((int)(v8 - arg12.getPosition())));
                arg12.skip(12);
                long v0_1 = arg12.readUnsignedInt();
                while(true) {
                    if((((long)v2)) < v0_1) {
                        v4 = arg12.readTag();
                        v5 = arg12.readUnsignedInt();
                        v10 = arg12.readUnsignedInt();
                        if(0x456D6A69 != v4) {
                            if(1701669481 == v4) {
                            }
                            else {
                                ++v2;
                                continue;
                            }
                        }

                        break;
                    }

                    goto label_46;
                }

                return new OffsetInfo(v5 + v8, v10);
            }

        label_46:
            throw new IOException(v3);
        }

        throw new IOException(v3);
    }

    static MetadataList read(AssetManager arg0, String arg1) throws IOException {
        MetadataList v1_1;
        InputStream v0 = arg0.open(arg1);
        try {
            v1_1 = MetadataListReader.read(v0);
            if(v0 == null) {
                return v1_1;
            }
        }
        catch(Throwable v1) {
            if(v0 != null) {
                try {
                    v0.close();
                }
                catch(Throwable v0_1) {
                    v1.addSuppressed(v0_1);
                }

                goto label_11;
            }
            else {
            label_11:
                throw v1;
            }

            return v1_1;
        }

        v0.close();
        return v1_1;
    }

    static MetadataList read(InputStream arg6) throws IOException {
        InputStreamOpenTypeReader v0 = new InputStreamOpenTypeReader(arg6);
        OffsetInfo v1 = MetadataListReader.findOffsetInfo(((OpenTypeReader)v0));
        ((OpenTypeReader)v0).skip(((int)(v1.getStartOffset() - ((OpenTypeReader)v0).getPosition())));
        ByteBuffer v0_1 = ByteBuffer.allocate(((int)v1.getLength()));
        int v6 = arg6.read(v0_1.array());
        if((((long)v6)) == v1.getLength()) {
            return MetadataList.getRootAsMetadataList(v0_1);
        }

        throw new IOException("Needed " + v1.getLength() + " bytes, got " + v6);
    }

    static MetadataList read(ByteBuffer arg2) throws IOException {
        arg2 = arg2.duplicate();
        arg2.position(((int)MetadataListReader.findOffsetInfo(new ByteBufferReader(arg2)).getStartOffset()));
        return MetadataList.getRootAsMetadataList(arg2);
    }

    static long toUnsignedInt(int arg4) {
        return (((long)arg4)) & 0xFFFFFFFFL;
    }

    static int toUnsignedShort(short arg1) {
        return arg1 & 0xFFFF;
    }
}

