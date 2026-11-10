package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class FlexBuffers {
    public class Blob extends Sized {
        static final Blob EMPTY;

        static {
            Blob.EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);
        }

        Blob(ReadBuf arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
        }

        public ByteBuffer data() {
            ByteBuffer v0 = ByteBuffer.wrap(this.bb.data());
            v0.position(this.end);
            v0.limit(this.end + this.size());
            return v0.asReadOnlyBuffer().slice();
        }

        public static Blob empty() {
            return Blob.EMPTY;
        }

        public byte get(int arg2) {
            return this.bb.get(this.end + arg2);
        }

        public byte[] getBytes() {
            int v0 = this.size();
            byte[] v1 = new byte[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = this.bb.get(this.end + v2);
            }

            return v1;
        }

        public int size() {
            return super.size();
        }

        public String toString() {
            return this.bb.getString(this.end, this.size());
        }

        public StringBuilder toString(StringBuilder arg4) {
            arg4.append('\"');
            arg4.append(this.bb.getString(this.end, this.size()));
            return arg4.append('\"');
        }
    }

    public class FlexBufferException extends RuntimeException {
        FlexBufferException(String arg1) {
            super(arg1);
        }
    }

    public class Key extends Object {
        private static final Key EMPTY;

        static {
            Key.EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);
        }

        Key(ReadBuf arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
        }

        static Key access$700() {
            return Key.EMPTY;
        }

        int compareTo(byte[] arg6) {
            int v3;
            int v2;
            int v0 = this.end;
            int v1 = 0;
            do {
                v2 = this.bb.get(v0);
                v3 = arg6[v1];
                if(v2 == 0) {
                    goto label_6;
                }

                ++v0;
                ++v1;
                if(v1 == arg6.length) {
                    return v2 - v3;
                }
            }
            while(v2 == v3);

            return v2 - v3;
        label_6:
            return v2 - v3;
        }

        public static Key empty() {
            return Key.EMPTY;
        }

        public boolean equals(java.lang.Object arg4) {
            if(!(arg4 instanceof Key)) {
                return 0;
            }

            if(((Key)arg4).end == this.end && ((Key)arg4).byteWidth == this.byteWidth) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return this.byteWidth ^ this.end;
        }

        public String toString() {
            int v0;
            for(v0 = this.end; this.bb.get(v0) != 0; ++v0) {
            }

            return this.bb.getString(this.end, v0 - this.end);
        }

        public StringBuilder toString(StringBuilder arg1) {
            return arg1.append(this.toString());
        }
    }

    public class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector arg1) {
            super();
            this.vec = arg1;
        }

        public Key get(int arg4) {
            if(arg4 >= this.size()) {
                return Key.EMPTY;
            }

            return new Key(this.vec.bb, FlexBuffers.indirect(this.vec.bb, this.vec.end + arg4 * this.vec.byteWidth, this.vec.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder();
            v0.append('[');
            int v1;
            for(v1 = 0; v1 < this.vec.size(); ++v1) {
                this.vec.get(v1).toString(v0);
                if(v1 != this.vec.size() - 1) {
                    v0.append(", ");
                }
            }

            return v0.append("]").toString();
        }
    }

    public class Map extends Vector {
        private static final Map EMPTY_MAP;

        static {
            Map.EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);
        }

        Map(ReadBuf arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
        }

        private int binarySearch(KeyVector arg4, byte[] arg5) {
            int v1;
            int v3 = arg4.size() - 1;
            int v0 = 0;
            while(true) {
                if(v0 > v3) {
                    goto label_17;
                }

                v1 = v0 + v3 >>> 1;
                int v2 = arg4.get(v1).compareTo(arg5);
                if(v2 < 0) {
                    v0 = v1 + 1;
                    continue;
                }

                if(v2 <= 0) {
                    return v1;
                }

                v3 = v1 - 1;
            }

            return v1;
        label_17:
            return -(v0 + 1);
        }

        public static Map empty() {
            return Map.EMPTY_MAP;
        }

        public Reference get(String arg2) {
            return this.get(arg2.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] arg3) {
            KeyVector v0 = this.keys();
            int v1 = v0.size();
            int v3 = this.binarySearch(v0, arg3);
            if(v3 >= 0 && v3 < v1) {
                return this.get(v3);
            }

            return Reference.access$600();
        }

        public KeyVector keys() {
            int v0 = this.end - this.byteWidth * 3;
            return new KeyVector(new TypedVector(this.bb, FlexBuffers.indirect(this.bb, v0, this.byteWidth), FlexBuffers.readInt(this.bb, v0 + this.byteWidth, this.byteWidth), 4));
        }

        public StringBuilder toString(StringBuilder arg6) {
            arg6.append("{ ");
            KeyVector v0 = this.keys();
            int v1 = this.size();
            Vector v5 = this.values();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                arg6.append('\"').append(v0.get(v2).toString()).append("\" : ");
                arg6.append(v5.get(v2).toString());
                if(v2 != v1 - 1) {
                    arg6.append(", ");
                }
            }

            arg6.append(" }");
            return arg6;
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }
    }

    abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        Object(ReadBuf arg1, int arg2, int arg3) {
            super();
            this.bb = arg1;
            this.end = arg2;
            this.byteWidth = arg3;
        }

        public String toString() {
            return this.toString(new StringBuilder(0x80)).toString();
        }

        public abstract StringBuilder toString(StringBuilder arg1);
    }

    public class Reference {
        private static final Reference NULL_REFERENCE;
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        static {
            Reference.NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);
        }

        Reference(ReadBuf arg9, int arg10, int arg11, int arg12) {
            this(arg9, arg10, arg11, 1 << (arg12 & 3), arg12 >> 2);
        }

        Reference(ReadBuf arg1, int arg2, int arg3, int arg4, int arg5) {
            super();
            this.bb = arg1;
            this.end = arg2;
            this.parentWidth = arg3;
            this.byteWidth = arg4;
            this.type = arg5;
        }

        static Reference access$600() {
            return Reference.NULL_REFERENCE;
        }

        public Blob asBlob() {
            if(!this.isBlob()) {
                if(this.isString()) {
                }
                else {
                    return Blob.empty();
                }
            }

            return new Blob(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if(this.isBoolean()) {
                if(this.bb.get(this.end) != 0) {
                    return 1;
                }

                return 0;
            }

            if(this.asUInt() != 0) {
                return 1;
            }

            return 0;
        }

        public double asFloat() {
            int v0 = this.type;
            if(v0 == 3) {
                return FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }

            if(v0 != 1) {
                if(v0 != 2) {
                    if(v0 == 5) {
                        return Double.parseDouble(this.asString());
                    }
                    else if(v0 == 6) {
                        return ((double)FlexBuffers.readInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth));
                    }
                    else if(v0 == 7) {
                        return ((double)FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth));
                    }
                    else if(v0 == 8) {
                        return FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                    }
                    else if(v0 == 10) {
                        return ((double)this.asVector().size());
                    }
                    else if(v0 != 26) {
                        return 0;
                    }
                }

                return ((double)FlexBuffers.readUInt(this.bb, this.end, this.parentWidth));
            }

            return ((double)FlexBuffers.readInt(this.bb, this.end, this.parentWidth));
        }

        public int asInt() {
            int v0 = this.type;
            if(v0 == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }

            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 != 5) {
                        if(v0 != 6) {
                            if(v0 != 7) {
                                if(v0 != 8) {
                                    if(v0 != 10) {
                                        if(v0 != 26) {
                                            return 0;
                                        }

                                        return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                                    }

                                    return this.asVector().size();
                                }

                                return ((int)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth));
                            }

                            return ((int)FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth));
                        }

                        return FlexBuffers.readInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                    }

                    return Integer.parseInt(this.asString());
                }

                return ((int)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth));
            }

            return ((int)FlexBuffers.readUInt(this.bb, this.end, this.parentWidth));
        }

        public Key asKey() {
            if(this.isKey()) {
                return new Key(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }

            return Key.empty();
        }

        public long asLong() {
            int v0 = this.type;
            if(v0 == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }

            if(v0 != 2) {
                if(v0 != 3) {
                    long v2 = 0;
                    if(v0 != 5) {
                        if(v0 != 6) {
                            if(v0 != 7) {
                                if(v0 != 8) {
                                    if(v0 != 10) {
                                        if(v0 != 26) {
                                            return v2;
                                        }

                                        return ((long)FlexBuffers.readInt(this.bb, this.end, this.parentWidth));
                                    }

                                    return ((long)this.asVector().size());
                                }

                                return ((long)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth));
                            }

                            return FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth);
                        }

                        return FlexBuffers.readLong(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                    }

                    try {
                        return Long.parseLong(this.asString());
                    }
                    catch(NumberFormatException ) {
                        return v2;
                    }
                }

                return ((long)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth));
            }

            return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if(this.isMap()) {
                return new Map(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }

            return Map.empty();
        }

        public String asString() {
            int v0;
            if(this.isString()) {
                v0 = FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                return this.bb.getString(v0, ((int)FlexBuffers.readUInt(this.bb, v0 - this.byteWidth, this.byteWidth)));
            }

            if(this.isKey()) {
                v0 = FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
                int v1;
                for(v1 = v0; this.bb.get(v1) != 0; ++v1) {
                }

                return this.bb.getString(v0, v1 - v0);
            }

            return "";
        }

        public long asUInt() {
            int v0 = this.type;
            if(v0 == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }

            if(v0 != 1) {
                if(v0 != 3) {
                    if(v0 != 10) {
                        if(v0 != 26) {
                            if(v0 != 5) {
                                if(v0 != 6) {
                                    if(v0 != 7) {
                                        if(v0 != 8) {
                                            return 0;
                                        }

                                        return ((long)FlexBuffers.readDouble(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.parentWidth));
                                    }

                                    return FlexBuffers.readUInt(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                                }

                                return FlexBuffers.readLong(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
                            }

                            return Long.parseLong(this.asString());
                        }

                        return ((long)FlexBuffers.readInt(this.bb, this.end, this.parentWidth));
                    }

                    return ((long)this.asVector().size());
                }

                return ((long)FlexBuffers.readDouble(this.bb, this.end, this.parentWidth));
            }

            return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
        }

        public Vector asVector() {
            if(this.isVector()) {
                return new Vector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth);
            }

            int v0 = this.type;
            if(v0 == 15) {
                return new TypedVector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth, 4);
            }

            if(FlexBuffers.isTypedVector(v0)) {
                return new TypedVector(this.bb, FlexBuffers.indirect(this.bb, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
            }

            return Vector.empty();
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            if(this.type == 25) {
                return 1;
            }

            return 0;
        }

        public boolean isBoolean() {
            if(this.type == 26) {
                return 1;
            }

            return 0;
        }

        public boolean isFloat() {
            int v1 = this.type;
            if(v1 != 3) {
                if(v1 == 8) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isInt() {
            int v2 = this.type;
            if(v2 != 1) {
                if(v2 == 6) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isIntOrUInt() {
            if(!this.isInt()) {
                if(this.isUInt()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isKey() {
            if(this.type == 4) {
                return 1;
            }

            return 0;
        }

        public boolean isMap() {
            if(this.type == 9) {
                return 1;
            }

            return 0;
        }

        public boolean isNull() {
            if(this.type == 0) {
                return 1;
            }

            return 0;
        }

        public boolean isNumeric() {
            if(!this.isIntOrUInt()) {
                if(this.isFloat()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isString() {
            if(this.type == 5) {
                return 1;
            }

            return 0;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int v1 = this.type;
            if(v1 != 2) {
                if(v1 == 7) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean isVector() {
            int v1 = this.type;
            if(v1 != 10) {
                if(v1 == 9) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        StringBuilder toString(StringBuilder arg3) {
            int v0 = this.type;
            if(v0 != 36) {
                char v1 = '\"';
                switch(v0) {
                    case 0: {
                        goto label_46;
                    }
                    case 4: {
                        goto label_32;
                    }
                    case 5: {
                        goto label_27;
                    }
                    case 1: 
                    case 6: {
                        goto label_43;
                    }
                    case 2: 
                    case 7: {
                        goto label_40;
                    }
                    case 3: 
                    case 8: {
                        goto label_37;
                    }
                    case 9: {
                        goto label_24;
                    }
                    case 10: {
                        goto label_21;
                    }
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: {
                        goto label_49;
                    }
                    case 16: 
                    case 17: 
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: {
                        goto label_12;
                    }
                    case 25: {
                        goto label_9;
                    }
                    case 26: {
                        goto label_6;
                    }
                }

                return arg3;
            label_37:
                return arg3.append(this.asFloat());
            label_40:
                return arg3.append(this.asUInt());
            label_43:
                return arg3.append(this.asLong());
            label_46:
                return arg3.append("null");
            label_6:
                return arg3.append(this.asBoolean());
            label_9:
                return this.asBlob().toString(arg3);
            label_12:
                throw new FlexBufferException("not_implemented:" + this.type);
            label_21:
                return this.asVector().toString(arg3);
            label_24:
                return this.asMap().toString(arg3);
            label_27:
                return arg3.append(v1).append(this.asString()).append(v1);
            label_32:
                return this.asKey().toString(arg3.append(v1)).append(v1);
            }

        label_49:
            return arg3.append(this.asVector());
        }

        public String toString() {
            return this.toString(new StringBuilder(0x80)).toString();
        }
    }

    abstract class Sized extends Object {
        protected final int size;

        Sized(ReadBuf arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
            this.size = FlexBuffers.readInt(this.bb, arg2 - arg3, arg3);
        }

        public int size() {
            return this.size;
        }
    }

    public class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR;
        private final int elemType;

        static {
            TypedVector.EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        }

        TypedVector(ReadBuf arg1, int arg2, int arg3, int arg4) {
            super(arg1, arg2, arg3);
            this.elemType = arg4;
        }

        public static TypedVector empty() {
            return TypedVector.EMPTY_VECTOR;
        }

        public Reference get(int arg8) {
            if(arg8 >= this.size()) {
                return Reference.NULL_REFERENCE;
            }

            return new Reference(this.bb, this.end + arg8 * this.byteWidth, this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            if(this == TypedVector.EMPTY_VECTOR) {
                return 1;
            }

            return 0;
        }
    }

    class Unsigned {
        Unsigned() {
            super();
        }

        static int byteToUnsignedInt(byte arg0) {
            return arg0 & 0xFF;
        }

        static long intToUnsignedLong(int arg4) {
            return (((long)arg4)) & 0xFFFFFFFFL;
        }

        static int shortToUnsignedInt(short arg1) {
            return arg1 & 0xFFFF;
        }
    }

    public class Vector extends Sized {
        private static final Vector EMPTY_VECTOR;

        static {
            Vector.EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);
        }

        Vector(ReadBuf arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
        }

        public static Vector empty() {
            return Vector.EMPTY_VECTOR;
        }

        public Reference get(int arg10) {
            long v0 = ((long)this.size());
            long v2 = ((long)arg10);
            if(v2 >= v0) {
                return Reference.access$600();
            }

            return new Reference(this.bb, this.end + arg10 * this.byteWidth, this.byteWidth, Unsigned.byteToUnsignedInt(this.bb.get(((int)((((long)this.end)) + v0 * (((long)this.byteWidth)) + v2)))));
        }

        public boolean isEmpty() {
            if(this == Vector.EMPTY_VECTOR) {
                return 1;
            }

            return 0;
        }

        public int size() {
            return super.size();
        }

        public String toString() {
            return super.toString();
        }

        public StringBuilder toString(StringBuilder arg4) {
            arg4.append("[ ");
            int v0 = this.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.get(v1).toString(arg4);
                if(v1 != v0 - 1) {
                    arg4.append(", ");
                }
            }

            arg4.append(" ]");
            return arg4;
        }
    }

    private static final ReadBuf EMPTY_BB = null;
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    static {
        FlexBuffers.EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    }

    public FlexBuffers() {
        super();
    }

    static ReadBuf access$000() {
        return FlexBuffers.EMPTY_BB;
    }

    static int access$100(ReadBuf arg0, int arg1, int arg2) {
        return FlexBuffers.readInt(arg0, arg1, arg2);
    }

    static int access$200(ReadBuf arg0, int arg1, int arg2) {
        return FlexBuffers.indirect(arg0, arg1, arg2);
    }

    static long access$300(ReadBuf arg0, int arg1, int arg2) {
        return FlexBuffers.readUInt(arg0, arg1, arg2);
    }

    static double access$400(ReadBuf arg0, int arg1, int arg2) {
        return FlexBuffers.readDouble(arg0, arg1, arg2);
    }

    static long access$500(ReadBuf arg0, int arg1, int arg2) {
        return FlexBuffers.readLong(arg0, arg1, arg2);
    }

    public static Reference getRoot(ReadBuf arg4) {
        int v0 = arg4.limit();
        int v1 = arg4.get(v0 - 1);
        v0 += -2;
        return new Reference(arg4, v0 - v1, v1, Unsigned.byteToUnsignedInt(arg4.get(v0)));
    }

    @Deprecated public static Reference getRoot(ByteBuffer arg2) {
        ByteBufferReadWriteBuf v0_1;
        if(arg2.hasArray()) {
            ArrayReadWriteBuf v0 = new ArrayReadWriteBuf(arg2.array(), arg2.limit());
        }
        else {
            v0_1 = new ByteBufferReadWriteBuf(arg2);
        }

        return FlexBuffers.getRoot(((ReadBuf)v0_1));
    }

    private static int indirect(ReadBuf arg2, int arg3, int arg4) {
        return ((int)((((long)arg3)) - FlexBuffers.readUInt(arg2, arg3, arg4)));
    }

    static boolean isTypeInline(int arg1) {
        if(arg1 > 3) {
            if(arg1 == 26) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static boolean isTypedVector(int arg1) {
        if(arg1 >= 11 && arg1 <= 15 || arg1 == 36) {
            return 1;
        }

        return 0;
    }

    static boolean isTypedVectorElementType(int arg2) {
        if(arg2 >= 1 && arg2 <= 4 || arg2 == 26) {
            return 1;
        }

        return 0;
    }

    private static double readDouble(ReadBuf arg1, int arg2, int arg3) {
        if(arg3 != 4) {
            if(arg3 != 8) {
                return -1;
            }

            return arg1.getDouble(arg2);
        }

        return ((double)arg1.getFloat(arg2));
    }

    private static int readInt(ReadBuf arg0, int arg1, int arg2) {
        return ((int)FlexBuffers.readLong(arg0, arg1, arg2));
    }

    private static long readLong(ReadBuf arg1, int arg2, int arg3) {
        int v1;
        if(arg3 == 1) {
            v1 = arg1.get(arg2);
        }
        else if(arg3 == 2) {
            v1 = arg1.getShort(arg2);
        }
        else if(arg3 == 4) {
            v1 = arg1.getInt(arg2);
        }
        else if(arg3 != 8) {
            return -1;
        }
        else {
            return arg1.getLong(arg2);
        }

        return ((long)v1);
    }

    private static long readUInt(ReadBuf arg1, int arg2, int arg3) {
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 != 4) {
                    if(arg3 != 8) {
                        return -1;
                    }

                    return arg1.getLong(arg2);
                }

                return Unsigned.intToUnsignedLong(arg1.getInt(arg2));
            }

            return ((long)Unsigned.shortToUnsignedInt(arg1.getShort(arg2)));
        }

        return ((long)Unsigned.byteToUnsignedInt(arg1.get(arg2)));
    }

    static int toTypedVector(int arg1, int arg2) {
        if(arg2 != 0) {
            if(arg2 != 2) {
                if(arg2 != 3) {
                    if(arg2 != 4) {
                        return 0;
                    }

                    return arg1 + 21;
                }

                return arg1 + 18;
            }

            return arg1 + 15;
        }

        return arg1 + 10;
    }

    static int toTypedVectorElementType(int arg0) {
        return arg0 - 10;
    }
}

