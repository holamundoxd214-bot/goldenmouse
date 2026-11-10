package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public abstract class Utf8 {
    class DecodeUtil {
        DecodeUtil() {
            super();
        }

        static void handleFourBytes(byte arg2, byte arg3, byte arg4, byte arg5, char[] arg6, int arg7) throws IllegalArgumentException {
            if(!DecodeUtil.isNotTrailingByte(arg3) && (arg2 << 28) + (arg3 + 0x70) >> 30 == 0 && !DecodeUtil.isNotTrailingByte(arg4) && !DecodeUtil.isNotTrailingByte(arg5)) {
                int v2 = (arg2 & 7) << 18 | DecodeUtil.trailingByteValue(arg3) << 12 | DecodeUtil.trailingByteValue(arg4) << 6 | DecodeUtil.trailingByteValue(arg5);
                arg6[arg7] = DecodeUtil.highSurrogate(v2);
                arg6[arg7 + 1] = DecodeUtil.lowSurrogate(v2);
                return;
            }

            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleOneByte(byte arg0, char[] arg1, int arg2) {
            arg1[arg2] = ((char)arg0);
        }

        static void handleThreeBytes(byte arg2, byte arg3, byte arg4, char[] arg5, int arg6) throws IllegalArgumentException {
            if(!DecodeUtil.isNotTrailingByte(arg3)) {
                int v1 = 0xFFFFFFA0;
                if(arg2 == 0xFFFFFFE0 && arg3 < v1) {
                    goto label_21;
                }

                if(arg2 == -19 && arg3 >= v1) {
                    goto label_21;
                }

                if(DecodeUtil.isNotTrailingByte(arg4)) {
                    goto label_21;
                }

                arg5[arg6] = ((char)((arg2 & 15) << 12 | DecodeUtil.trailingByteValue(arg3) << 6 | DecodeUtil.trailingByteValue(arg4)));
                return;
            }

        label_21:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleTwoBytes(byte arg1, byte arg2, char[] arg3, int arg4) throws IllegalArgumentException {
            if(arg1 >= -62) {
                if(!DecodeUtil.isNotTrailingByte(arg2)) {
                    arg3[arg4] = ((char)((arg1 & 0x1F) << 6 | DecodeUtil.trailingByteValue(arg2)));
                    return;
                }

                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }

            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        private static char highSurrogate(int arg1) {
            return ((char)((arg1 >>> 10) + 0xD7C0));
        }

        private static boolean isNotTrailingByte(byte arg1) {
            if(arg1 > -65) {
                return 1;
            }

            return 0;
        }

        static boolean isOneByte(byte arg0) {
            if(arg0 >= 0) {
                return 1;
            }

            return 0;
        }

        static boolean isThreeBytes(byte arg1) {
            if(arg1 < -16) {
                return 1;
            }

            return 0;
        }

        static boolean isTwoBytes(byte arg1) {
            if(arg1 < 0xFFFFFFE0) {
                return 1;
            }

            return 0;
        }

        private static char lowSurrogate(int arg1) {
            return ((char)((arg1 & 0x3FF) + 0xDC00));
        }

        private static int trailingByteValue(byte arg0) {
            return arg0 & 0x3F;
        }
    }

    class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int arg3, int arg4) {
            super("Unpaired surrogate at index " + arg3 + " of " + arg4);
        }
    }

    private static Utf8 DEFAULT;

    public Utf8() {
        super();
    }

    public abstract String decodeUtf8(ByteBuffer arg1, int arg2, int arg3);

    public abstract void encodeUtf8(CharSequence arg1, ByteBuffer arg2);

    public abstract int encodedLength(CharSequence arg1);

    public static Utf8 getDefault() {
        if(Utf8.DEFAULT == null) {
            Utf8.DEFAULT = new Utf8Safe();
        }

        return Utf8.DEFAULT;
    }

    public static void setDefault(Utf8 arg0) {
        Utf8.DEFAULT = arg0;
    }
}

