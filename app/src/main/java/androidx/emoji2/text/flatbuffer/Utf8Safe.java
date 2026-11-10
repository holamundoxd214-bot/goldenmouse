package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {
    class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int arg3, int arg4) {
            super("Unpaired surrogate at index " + arg3 + " of " + arg4);
        }
    }

    public Utf8Safe() {
        super();
    }

    private static int computeEncodedLength(CharSequence arg5) {
        int v0 = arg5.length();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg5.charAt(v1) >= 0x80) {
                break;
            }
        }

        int v2 = v0;
        while(true) {
            if(v1 < v0) {
                int v3 = arg5.charAt(v1);
                if(v3 < 0x800) {
                    v2 += 0x7F - v3 >>> 0x1F;
                    ++v1;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_20;
        }

        v2 += Utf8Safe.encodedLengthGeneral(arg5, v1);
    label_20:
        if(v2 >= v0) {
            return v2;
        }

        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + ((((long)v2)) + 0x100000000L));
    }

    public String decodeUtf8(ByteBuffer arg1, int arg2, int arg3) throws IllegalArgumentException {
        if(arg1.hasArray()) {
            return Utf8Safe.decodeUtf8Array(arg1.array(), arg1.arrayOffset() + arg2, arg3);
        }

        return Utf8Safe.decodeUtf8Buffer(arg1, arg2, arg3);
    }

    public static String decodeUtf8Array(byte[] arg7, int arg8, int arg9) {
        String v4;
        byte v2;
        if((arg8 | arg9 | arg7.length - arg8 - arg9) < 0) {
            goto label_88;
        }

        int v0 = arg8 + arg9;
        char[] v5 = new char[arg9];
        int v1 = 0;
        while(arg8 < v0) {
            v2 = arg7[arg8];
            if(!DecodeUtil.isOneByte(v2)) {
            }
            else {
                ++arg8;
                DecodeUtil.handleOneByte(v2, v5, v1);
                ++v1;
                continue;
            }

            break;
        }

        int v6;
        for(v6 = v1; true; v6 += 2) {
        label_21:
            if(arg8 >= v0) {
                goto label_85;
            }

            int v2_1 = arg8 + 1;
            byte v1_1 = arg7[arg8];
            if(DecodeUtil.isOneByte(v1_1)) {
                arg8 = v6 + 1;
                DecodeUtil.handleOneByte(v1_1, v5, v6);
                v1 = v2_1;
                goto label_30;
            }

            v4 = "Invalid UTF-8";
            if(DecodeUtil.isTwoBytes(v1_1)) {
                if(v2_1 < v0) {
                    arg8 += 2;
                    DecodeUtil.handleTwoBytes(v1_1, arg7[v2_1], v5, v6);
                    ++v6;
                    goto label_21;
                }

                throw new IllegalArgumentException(v4);
            }

            if(DecodeUtil.isThreeBytes(v1_1)) {
                if(v2_1 < v0 - 1) {
                    int v3 = arg8 + 2;
                    arg8 += 3;
                    DecodeUtil.handleThreeBytes(v1_1, arg7[v2_1], arg7[v3], v5, v6);
                    ++v6;
                    goto label_21;
                }

                throw new IllegalArgumentException(v4);
            }

            if(v2_1 >= v0 - 2) {
                break;
            }

            v2 = arg7[v2_1];
            int v4_1 = arg8 + 3;
            byte v3_1 = arg7[arg8 + 2];
            arg8 += 4;
            DecodeUtil.handleFourBytes(v1_1, v2, v3_1, arg7[v4_1], v5, v6);
        }

        throw new IllegalArgumentException(v4);
    label_85:
        return new String(v5, 0, v6);
    label_30:
        while(v1 < v0) {
            v2 = arg7[v1];
            if(!DecodeUtil.isOneByte(v2)) {
            }
            else {
                ++v1;
                DecodeUtil.handleOneByte(v2, v5, arg8);
                ++arg8;
                continue;
            }

            break;
        }

        v6 = arg8;
        arg8 = v1;
        goto label_21;
    label_88:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(arg7.length), Integer.valueOf(arg8), Integer.valueOf(arg9)));
    }

    public static String decodeUtf8Buffer(ByteBuffer arg7, int arg8, int arg9) {
        String v4;
        byte v2;
        if((arg8 | arg9 | arg7.limit() - arg8 - arg9) < 0) {
            goto label_88;
        }

        int v0 = arg8 + arg9;
        char[] v5 = new char[arg9];
        int v1 = 0;
        while(arg8 < v0) {
            v2 = arg7.get(arg8);
            if(!DecodeUtil.isOneByte(v2)) {
            }
            else {
                ++arg8;
                DecodeUtil.handleOneByte(v2, v5, v1);
                ++v1;
                continue;
            }

            break;
        }

        int v6;
        for(v6 = v1; true; v6 += 2) {
        label_21:
            if(arg8 >= v0) {
                goto label_85;
            }

            int v2_1 = arg8 + 1;
            byte v1_1 = arg7.get(arg8);
            if(DecodeUtil.isOneByte(v1_1)) {
                arg8 = v6 + 1;
                DecodeUtil.handleOneByte(v1_1, v5, v6);
                v1 = v2_1;
                goto label_30;
            }

            v4 = "Invalid UTF-8";
            if(DecodeUtil.isTwoBytes(v1_1)) {
                if(v2_1 < v0) {
                    arg8 += 2;
                    DecodeUtil.handleTwoBytes(v1_1, arg7.get(v2_1), v5, v6);
                    ++v6;
                    goto label_21;
                }

                throw new IllegalArgumentException(v4);
            }

            if(DecodeUtil.isThreeBytes(v1_1)) {
                if(v2_1 < v0 - 1) {
                    int v3 = arg8 + 2;
                    arg8 += 3;
                    DecodeUtil.handleThreeBytes(v1_1, arg7.get(v2_1), arg7.get(v3), v5, v6);
                    ++v6;
                    goto label_21;
                }

                throw new IllegalArgumentException(v4);
            }

            if(v2_1 >= v0 - 2) {
                break;
            }

            v2 = arg7.get(v2_1);
            int v4_1 = arg8 + 3;
            byte v3_1 = arg7.get(arg8 + 2);
            arg8 += 4;
            DecodeUtil.handleFourBytes(v1_1, v2, v3_1, arg7.get(v4_1), v5, v6);
        }

        throw new IllegalArgumentException(v4);
    label_85:
        return new String(v5, 0, v6);
    label_30:
        while(v1 < v0) {
            v2 = arg7.get(v1);
            if(!DecodeUtil.isOneByte(v2)) {
            }
            else {
                ++v1;
                DecodeUtil.handleOneByte(v2, v5, arg8);
                ++arg8;
                continue;
            }

            break;
        }

        v6 = arg8;
        arg8 = v1;
        goto label_21;
    label_88:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(arg7.limit()), Integer.valueOf(arg8), Integer.valueOf(arg9)));
    }

    public void encodeUtf8(CharSequence arg4, ByteBuffer arg5) {
        if(arg5.hasArray()) {
            int v3 = arg5.arrayOffset();
            arg5.position(Utf8Safe.encodeUtf8Array(arg4, arg5.array(), arg5.position() + v3, arg5.remaining()) - v3);
            return;
        }

        Utf8Safe.encodeUtf8Buffer(arg4, arg5);
    }

    private static int encodeUtf8Array(CharSequence arg7, byte[] arg8, int arg9, int arg10) {
        char v3_1;
        int v4;
        int v3;
        int v2;
        int v0 = arg7.length();
        arg10 += arg9;
        int v1 = 0;
        while(true) {
            v2 = 0x80;
            if(v1 < v0) {
                v3 = v1 + arg9;
                if(v3 < arg10) {
                    v4 = arg7.charAt(v1);
                    if(v4 < v2) {
                        arg8[v3] = ((byte)v4);
                        ++v1;
                        continue;
                    }
                }
            }

            break;
        }

        if(v1 == v0) {
            return arg9 + v0;
        }

        arg9 += v1;
        while(true) {
            if(v1 >= v0) {
                return arg9;
            }

            v3_1 = arg7.charAt(v1);
            if(v3_1 >= v2 || arg9 >= arg10) {
                if(v3_1 < 0x800 && arg9 <= arg10 - 2) {
                    v4 = arg9 + 1;
                    arg8[arg9] = ((byte)(v3_1 >>> 6 | 960));
                    arg9 += 2;
                    arg8[v4] = ((byte)(v3_1 & 0x3F | v2));
                    goto label_96;
                }

                v4 = 0xDFFF;
                int v5 = 0xD800;
                if((v3_1 < v5 || v4 < v3_1) && arg9 <= arg10 - 3) {
                    arg8[arg9] = ((byte)(v3_1 >>> 12 | 480));
                    v5 = arg9 + 2;
                    arg8[arg9 + 1] = ((byte)(v3_1 >>> 6 & 0x3F | v2));
                    arg9 += 3;
                    arg8[v5] = ((byte)(v3_1 & 0x3F | v2));
                    goto label_96;
                }

                if(arg9 > arg10 - 4) {
                    goto label_103;
                }

                v4 = v1 + 1;
                if(v4 != arg7.length()) {
                    char v1_1 = arg7.charAt(v4);
                    if(Character.isSurrogatePair(v3_1, v1_1)) {
                        v1 = Character.toCodePoint(v3_1, v1_1);
                        arg8[arg9] = ((byte)(v1 >>> 18 | 0xF0));
                        arg8[arg9 + 1] = ((byte)(v1 >>> 12 & 0x3F | v2));
                        v3 = arg9 + 3;
                        arg8[arg9 + 2] = ((byte)(v1 >>> 6 & 0x3F | v2));
                        arg9 += 4;
                        arg8[v3] = ((byte)(v1 & 0x3F | v2));
                        v1 = v4;
                        goto label_96;
                    }
                    else {
                        break;
                    }
                }

                goto label_99;
            }
            else {
                arg8[arg9] = ((byte)v3_1);
                ++arg9;
            }

        label_96:
            ++v1;
        }

        v1 = v4;
    label_99:
        throw new UnpairedSurrogateException(v1 - 1, v0);
    label_103:
        if(v5 <= v3_1 && v3_1 <= v4) {
            int v8 = v1 + 1;
            if(v8 != arg7.length() && (Character.isSurrogatePair(v3_1, arg7.charAt(v8)))) {
                goto label_114;
            }

            throw new UnpairedSurrogateException(v1, v0);
        }

    label_114:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + v3_1 + " at index " + arg9);
        return arg9;
    }

    private static void encodeUtf8Buffer(CharSequence arg8, ByteBuffer arg9) {
        byte v4_2;
        byte v7;
        int v6_1;
        byte v6;
        int v5;
        char v4_1;
        int v4;
        int v3;
        int v0 = arg8.length();
        int v1 = arg9.position();
        int v2 = 0;
        while(true) {
            v3 = 0x80;
            if(v2 < v0) {
                try {
                    v4 = arg8.charAt(v2);
                    if(v4 < v3) {
                        arg9.put(v1 + v2, ((byte)v4));
                        ++v2;
                        continue;
                    }

                label_12:
                    if(v2 == v0) {
                        arg9.position(v1 + v2);
                        return;
                    }

                    v1 += v2;
                    while(true) {
                    label_17:
                        if(v2 >= v0) {
                            goto label_102;
                        }

                        v4_1 = arg8.charAt(v2);
                        if(v4_1 < v3) {
                            arg9.put(v1, ((byte)v4_1));
                        }
                        else {
                            goto label_23;
                        }

                        goto label_99;
                    }
                }
                catch(IndexOutOfBoundsException ) {
                    goto label_104;
                }
            }

            goto label_12;
        }

    label_23:
        if(v4_1 < 0x800) {
            v5 = v1 + 1;
            v6 = ((byte)(v4_1 >>> 6 | 0xC0));
            try {
                arg9.put(v1, v6);
                arg9.put(v5, ((byte)(v4_1 & 0x3F | v3)));
                v1 = v5;
                goto label_99;
            }
            catch(IndexOutOfBoundsException ) {
                goto label_36;
            }
        }
        else {
            if(v4_1 >= 0xD800) {
                if(0xDFFF < v4_1) {
                }
                else {
                    v5 = v2 + 1;
                    if(v5 != v0) {
                        try {
                            char v2_1 = arg8.charAt(v5);
                            if(Character.isSurrogatePair(v4_1, v2_1)) {
                                v2 = Character.toCodePoint(v4_1, v2_1);
                                v4 = v1 + 1;
                                v6 = ((byte)(v2 >>> 18 | 0xF0));
                            }
                            else {
                                goto label_77;
                            }
                        }
                        catch(IndexOutOfBoundsException ) {
                            goto label_79;
                        }

                        try {
                            arg9.put(v1, v6);
                            v6_1 = v1 + 2;
                            v7 = ((byte)(v2 >>> 12 & 0x3F | v3));
                        }
                        catch(IndexOutOfBoundsException ) {
                            v1 = v4;
                            goto label_79;
                        }

                        try {
                            arg9.put(v4, v7);
                            v1 += 3;
                            v4_2 = ((byte)(v2 >>> 6 & 0x3F | v3));
                        }
                        catch(IndexOutOfBoundsException ) {
                            v2 = v5;
                            v1 = v6_1;
                            goto label_104;
                        }

                        try {
                            arg9.put(v6_1, v4_2);
                            arg9.put(v1, ((byte)(v2 & 0x3F | v3)));
                            v2 = v5;
                            goto label_99;
                        }
                        catch(IndexOutOfBoundsException ) {
                        label_79:
                            v2 = v5;
                            goto label_104;
                        }

                    label_77:
                        v2 = v5;
                    }

                    try {
                        throw new UnpairedSurrogateException(v2, v0);
                    }
                    catch(IndexOutOfBoundsException ) {
                        goto label_104;
                    }
                }
            }

            v5 = v1 + 1;
            v6 = ((byte)(v4_1 >>> 12 | 0xE0));
            try {
                arg9.put(v1, v6);
                v1 += 2;
                v6 = ((byte)(v4_1 >>> 6 & 0x3F | v3));
            }
            catch(IndexOutOfBoundsException ) {
            label_36:
                v1 = v5;
                goto label_104;
            }

            try {
                arg9.put(v5, v6);
                arg9.put(v1, ((byte)(v4_1 & 0x3F | v3)));
            label_99:
                ++v2;
                ++v1;
                goto label_17;
            label_102:
                arg9.position(v1);
                return;
            }
            catch(IndexOutOfBoundsException ) {
            label_104:
                throw new ArrayIndexOutOfBoundsException("Failed writing " + arg8.charAt(v2) + " at index " + (arg9.position() + Math.max(v2, v1 - arg9.position() + 1)));
            }
        }

        goto label_99;
    }

    public int encodedLength(CharSequence arg1) {
        return Utf8Safe.computeEncodedLength(arg1);
    }

    private static int encodedLengthGeneral(CharSequence arg4, int arg5) {
        int v0 = arg4.length();
        int v1 = 0;
        while(arg5 < v0) {
            int v2 = arg4.charAt(arg5);
            if(v2 < 0x800) {
                v1 += 0x7F - v2 >>> 0x1F;
            }
            else {
                v1 += 2;
                if(0xD800 <= v2 && v2 <= 0xDFFF) {
                    if(Character.codePointAt(arg4, arg5) >= 0x10000) {
                        ++arg5;
                    }
                    else {
                        throw new UnpairedSurrogateException(arg5, v0);
                    }
                }
            }

            ++arg5;
        }

        return v1;
    }
}

