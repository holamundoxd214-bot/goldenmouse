package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
        super();
    }

    static int bitsToBytes(int arg0) {
        return (arg0 + 7 & -8) / 8;
    }

    static byte[] compress(byte[] arg3) throws IOException {
        DeflaterOutputStream v2;
        Deflater v0 = new Deflater(1);
        ByteArrayOutputStream v1 = new ByteArrayOutputStream();
        try {
            v2 = new DeflaterOutputStream(((OutputStream)v1), v0);
        }
        catch(Throwable v3) {
            goto label_19;
        }

        try {
            v2.write(arg3);
            goto label_8;
        }
        catch(Throwable v3) {
            try {
                v2.close();
                goto label_17;
            }
            catch(Throwable v1_1) {
                try {
                    v3.addSuppressed(v1_1);
                label_17:
                    throw v3;
                label_8:
                    v2.close();
                }
                catch(Throwable v3) {
                label_19:
                    v0.end();
                    throw v3;
                }
            }
        }

        v0.end();
        return v1.toByteArray();
    }

    static RuntimeException error(String arg1) {
        return new IllegalStateException(arg1);
    }

    static byte[] read(InputStream arg3, int arg4) throws IOException {
        byte[] v0 = new byte[arg4];
        int v1;
        for(v1 = 0; true; v1 += v2) {
            if(v1 >= arg4) {
                return v0;
            }

            int v2 = arg3.read(v0, v1, arg4 - v1);
            if(v2 < 0) {
                break;
            }
        }

        throw Encoding.error("Not enough bytes to read: " + arg4);
        return v0;
    }

    static byte[] readCompressed(InputStream arg8, int arg9, int arg10) throws IOException {
        int v4;
        byte[] v1;
        Inflater v0 = new Inflater();
        try {
            v1 = new byte[arg10];
            byte[] v2 = new byte[0x800];
            v4 = 0;
            int v5 = 0;
            while(true) {
                if(!v0.finished() && !v0.needsDictionary() && v4 < arg9) {
                    int v6 = arg8.read(v2);
                    if(v6 >= 0) {
                        v0.setInput(v2, 0, v6);
                        int v7 = arg10 - v5;
                        try {
                            v5 += v0.inflate(v1, v5, v7);
                            v4 += v6;
                            continue;
                        }
                        catch(DataFormatException v8_1) {
                            try {
                                throw Encoding.error(v8_1.getMessage());
                            label_25:
                                throw Encoding.error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + arg9 + " bytes");
                            label_35:
                                if(v4 != arg9) {
                                    goto label_43;
                                }

                                if(!v0.finished()) {
                                    goto label_40;
                                }

                                break;
                            }
                            catch(Throwable v8) {
                                goto label_55;
                            }
                        }
                    }
                    else {
                        goto label_25;
                    }
                }

                goto label_35;
            }
        }
        catch(Throwable v8) {
            goto label_55;
        }

        v0.end();
        return v1;
        try {
        label_40:
            throw Encoding.error("Inflater did not finish");
        label_43:
            throw Encoding.error("Didn\'t read enough bytes during decompression. expected=" + arg9 + " actual=" + v4);
        }
        catch(Throwable v8) {
        label_55:
            v0.end();
            throw v8;
        }
    }

    static String readString(InputStream arg1, int arg2) throws IOException {
        return new String(Encoding.read(arg1, arg2), StandardCharsets.UTF_8);
    }

    static long readUInt(InputStream arg6, int arg7) throws IOException {
        byte[] v6 = Encoding.read(arg6, arg7);
        long v0 = 0;
        int v2;
        for(v2 = 0; v2 < arg7; ++v2) {
            v0 += (((long)(v6[v2] & 0xFF))) << v2 * 8;
        }

        return v0;
    }

    static int readUInt16(InputStream arg2) throws IOException {
        return ((int)Encoding.readUInt(arg2, 2));
    }

    static long readUInt32(InputStream arg2) throws IOException {
        return Encoding.readUInt(arg2, 4);
    }

    static int readUInt8(InputStream arg2) throws IOException {
        return ((int)Encoding.readUInt(arg2, 1));
    }

    static int utf8Length(String arg1) {
        return arg1.getBytes(StandardCharsets.UTF_8).length;
    }

    static void writeAll(InputStream arg2, OutputStream arg3, FileLock arg4) throws IOException {
        if(arg4 != null && (arg4.isValid())) {
            byte[] v4 = new byte[0x200];
            while(true) {
                int v0 = arg2.read(v4);
                if(v0 <= 0) {
                    return;
                }

                arg3.write(v4, 0, v0);
            }

            return;
        }

        throw new IOException("Unable to acquire a lock on the underlying file channel.");
    }

    static void writeCompressed(OutputStream arg2, byte[] arg3) throws IOException {
        Encoding.writeUInt32(arg2, ((long)arg3.length));
        arg3 = Encoding.compress(arg3);
        Encoding.writeUInt32(arg2, ((long)arg3.length));
        arg2.write(arg3);
    }

    static void writeString(OutputStream arg1, String arg2) throws IOException {
        arg1.write(arg2.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(OutputStream arg6, long arg7, int arg9) throws IOException {
        byte[] v0 = new byte[arg9];
        int v1;
        for(v1 = 0; v1 < arg9; ++v1) {
            v0[v1] = ((byte)(((int)(arg7 >> v1 * 8 & 0xFF))));
        }

        arg6.write(v0);
    }

    static void writeUInt16(OutputStream arg2, int arg3) throws IOException {
        Encoding.writeUInt(arg2, ((long)arg3), 2);
    }

    static void writeUInt32(OutputStream arg1, long arg2) throws IOException {
        Encoding.writeUInt(arg1, arg2, 4);
    }

    static void writeUInt8(OutputStream arg2, int arg3) throws IOException {
        Encoding.writeUInt(arg2, ((long)arg3), 1);
    }
}

