package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000\u008C\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\"\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0087\u0088\u0004\u001A\u0018\u0010\t\u001A\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\"\u0010\u000B\u001A\u00020\f*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0087\u0088\u0004\u001A\u0018\u0010\r\u001A\u00020\u000E*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u000E\u0010\u000F\u001A\u00020\u0010*\u00020\u0002H\u0086\u0080\u0004\u001A\u0016\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0010H\u0086\u0080\u0004\u001A\u0016\u0010\u0014\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0010H\u0086\u0080\u0004\u001A\u0018\u0010\u0015\u001A\u00020\u0016*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0086\u0080\u0004\u001A \u0010\u0017\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00162\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0086\u0080\u0004\u001A \u0010\u0019\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00162\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0086\u0080\u0004\u001A\u001E\u0010\u001A\u001A\u00020\u0012*\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\u0080\u0004\u001A\u0016\u0010\u001C\u001A\n \u001E*\u0004\u0018\u00010\u001D0\u001D*\u00020\u0004H\u0080\u0080\u0004\u001A\u001A\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\u001DH\u0080\u0080\u0004\u001AF\u0010#\u001A\u00020\u0012*\u00020\u000226\u0010$\u001A2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%H\u0086\u0080\u0004\u001AN\u0010#\u001A\u00020\u0012*\u00020\u00022\u0006\u0010*\u001A\u00020\b26\u0010$\u001A2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\b¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00120%H\u0086\u0080\u0004\u001A;\u0010+\u001A\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042!\u0010$\u001A\u001D\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b&\u0012\b\b\'\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00120,H\u0086\u0080\u0004\u001A\u000E\u0010.\u001A\u00020/*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u00100\u001A\u000201*\u00020\u0002H\u0087\u0088\u0004\u001A\u001E\u00102\u001A\b\u0012\u0004\u0012\u00020\u001603*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0086\u0080\u0004\u001AM\u00104\u001A\u0002H5\"\u0004\b\u0000\u00105*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0018\u00106\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001607\u0012\u0004\u0012\u0002H50,H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00108\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2={"reader", "Ljava/io/InputStreamReader;", "Ljava/io/File;", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "", "writeBytes", "", "array", "appendBytes", "readText", "", "writeText", "text", "appendText", "writeTextImpl", "Ljava/io/OutputStream;", "newReplaceEncoder", "Ljava/nio/charset/CharsetEncoder;", "kotlin.jvm.PlatformType", "byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "encoder", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/FilesKt") class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static Unit $r8$lambda$hPJfgTK5s9M7mflij1tos8f0N40(ArrayList arg0, String arg1) {
        return FilesKt__FileReadWriteKt.readLines$lambda$0$FilesKt__FileReadWriteKt(arg0, arg1);
    }

    public FilesKt__FileReadWriteKt() {
        super();
    }

    public static final void appendBytes(File arg2, byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "array");
        FileOutputStream v0 = new FileOutputStream(arg2, true);
        try {
            v0.write(arg3);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v0), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
    }

    public static final void appendText(File arg2, String arg3, Charset arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "text");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        FileOutputStream v0 = new FileOutputStream(arg2, true);
        try {
            FilesKt.writeTextImpl(v0, arg3, arg4);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v0), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
    }

    public static void appendText$default(File arg0, String arg1, Charset arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        FilesKt.appendText(arg0, arg1, arg2);
    }

    private static final BufferedReader bufferedReader(File arg2, Charset arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        InputStreamReader v0 = new InputStreamReader(new FileInputStream(arg2), arg3);
        if((v0 instanceof BufferedReader)) {
            return ((BufferedReader)v0);
        }

        return new BufferedReader(((Reader)v0), arg4);
    }

    static BufferedReader bufferedReader$default(File arg0, Charset arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        if((arg3 & 2) != 0) {
            arg2 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        InputStreamReader v3 = new InputStreamReader(new FileInputStream(arg0), arg1);
        if((v3 instanceof BufferedReader)) {
            return ((BufferedReader)v3);
        }

        return new BufferedReader(((Reader)v3), arg2);
    }

    private static final BufferedWriter bufferedWriter(File arg2, Charset arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        OutputStreamWriter v0 = new OutputStreamWriter(new FileOutputStream(arg2), arg3);
        if((v0 instanceof BufferedWriter)) {
            return ((BufferedWriter)v0);
        }

        return new BufferedWriter(((Writer)v0), arg4);
    }

    static BufferedWriter bufferedWriter$default(File arg0, Charset arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        if((arg3 & 2) != 0) {
            arg2 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        OutputStreamWriter v3 = new OutputStreamWriter(new FileOutputStream(arg0), arg1);
        if((v3 instanceof BufferedWriter)) {
            return ((BufferedWriter)v3);
        }

        return new BufferedWriter(((Writer)v3), arg2);
    }

    public static final ByteBuffer byteBufferForEncoding(int arg2, CharsetEncoder arg3) {
        Intrinsics.checkNotNullParameter(arg3, "encoder");
        ByteBuffer v2 = ByteBuffer.allocate(arg2 * (((int)(((float)Math.ceil(((double)arg3.maxBytesPerChar())))))));
        Intrinsics.checkNotNullExpressionValue(v2, "allocate(...)");
        return v2;
    }

    public static final void forEachBlock(File arg2, int arg3, Function2 arg4) {
        int v1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        byte[] v3 = new byte[RangesKt.coerceAtLeast(arg3, 0x200)];
        FileInputStream v0 = new FileInputStream(arg2);
        try {
            FileInputStream v2_1 = v0;
            while(true) {
            label_10:
                v1 = v2_1.read(v3);
                if(v1 > 0) {
                    goto label_16;
                }

                break;
            }
        }
        catch(Throwable v2) {
            goto label_20;
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        return;
        try {
        label_16:
            arg4.invoke(v3, Integer.valueOf(v1));
            goto label_10;
        }
        catch(Throwable v2) {
            try {
            label_20:
                throw v2;
            }
            catch(Throwable v3_1) {
                CloseableKt.closeFinally(((Closeable)v0), v2);
                throw v3_1;
            }
        }
    }

    public static final void forEachBlock(File arg1, Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        FilesKt.forEachBlock(arg1, 0x1000, arg2);
    }

    public static final void forEachLine(File arg3, Charset arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        Intrinsics.checkNotNullParameter(arg5, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(arg3), arg4)), arg5);
    }

    public static void forEachLine$default(File arg0, Charset arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        FilesKt.forEachLine(arg0, arg1, arg2);
    }

    private static final FileInputStream inputStream(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new FileInputStream(arg1);
    }

    public static final CharsetEncoder newReplaceEncoder(Charset arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    private static final FileOutputStream outputStream(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new FileOutputStream(arg1);
    }

    private static final PrintWriter printWriter(File arg3, Charset arg4) {
        BufferedWriter v1_1;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        OutputStreamWriter v1 = new OutputStreamWriter(new FileOutputStream(arg3), arg4);
        if((v1 instanceof BufferedWriter)) {
        }
        else {
            v1_1 = new BufferedWriter(((Writer)v1), 0x2000);
        }

        return new PrintWriter(((Writer)v1_1));
    }

    static PrintWriter printWriter$default(File arg1, Charset arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        OutputStreamWriter v4 = new OutputStreamWriter(new FileOutputStream(arg1), arg2);
        if((v4 instanceof BufferedWriter)) {
        }
        else {
            BufferedWriter v4_1 = new BufferedWriter(((Writer)v4), 0x2000);
        }

        return new PrintWriter(((Writer)v4));
    }

    public static final byte[] readBytes(File arg11) {
        int v8;
        int v7;
        int v6;
        byte[] v3;
        long v2;
        FileInputStream v1;
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        FileInputStream v0 = new FileInputStream(arg11);
        try {
            v1 = v0;
            v2 = arg11.length();
        }
        catch(Throwable v11) {
            goto label_71;
        }

        String v5 = "File ";
        if(Long.compare(v2, 0x7FFFFFFF) > 0) {
            goto label_58;
        }

        int v2_1 = ((int)v2);
        try {
            v3 = new byte[v2_1];
            v6 = v2_1;
            v7 = 0;
            while(true) {
            label_15:
                if(v6 > 0) {
                    v8 = v1.read(v3, v7, v6);
                    if(v8 >= 0) {
                        break;
                    }
                }

                goto label_21;
            }
        }
        catch(Throwable v11) {
            goto label_71;
        }

        v6 -= v8;
        v7 += v8;
        goto label_15;
    label_21:
        String v8_1 = "copyOf(...)";
        Object v9 = null;
        if(v6 > 0) {
            try {
                v3 = Arrays.copyOf(v3, v7);
                Intrinsics.checkNotNullExpressionValue(v3, v8_1);
                goto label_46;
            label_27:
                v6 = v1.read();
                if(v6 == -1) {
                }
                else {
                    ExposingBufferByteArrayOutputStream v7_1 = new ExposingBufferByteArrayOutputStream(0x2001);
                    v7_1.write(v6);
                    ByteStreamsKt.copyTo$default(((InputStream)v1), v7_1, 0, 2, v9);
                    int v1_1 = v7_1.size() + v2_1;
                    if(v1_1 >= 0) {
                        byte[] v11_1 = v7_1.getBuffer();
                        byte[] v1_2 = Arrays.copyOf(v3, v1_1);
                        Intrinsics.checkNotNullExpressionValue(v1_2, v8_1);
                        v3 = ArraysKt.copyInto(v11_1, v1_2, v2_1, 0, v7_1.size());
                    }
                    else {
                        goto label_48;
                    }
                }
            }
            catch(Throwable v11) {
                goto label_71;
            }
        }
        else {
            goto label_27;
        }

    label_46:
        CloseableKt.closeFinally(((Closeable)v0), ((Throwable)v9));
        return v3;
        try {
        label_48:
            throw new OutOfMemoryError(v5 + arg11 + " is too big to fit in memory.");
        label_58:
            throw new OutOfMemoryError(v5 + arg11 + " is too big (" + v2 + " bytes) to fit in memory.");
        }
        catch(Throwable v11) {
            try {
            label_71:
                throw v11;
            }
            catch(Throwable v1_3) {
                CloseableKt.closeFinally(((Closeable)v0), v11);
                throw v1_3;
            }
        }
    }

    public static final List readLines(File arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        ArrayList v0 = new ArrayList();
        FilesKt.forEachLine(arg2, arg3, new FilesKt__FileReadWriteKt$$ExternalSyntheticLambda0(v0));
        return ((List)v0);
    }

    public static List readLines$default(File arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        return FilesKt.readLines(arg0, arg1);
    }

    private static final Unit readLines$lambda$0$FilesKt__FileReadWriteKt(ArrayList arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.add(arg2);
        return Unit.INSTANCE;
    }

    public static final String readText(File arg2, Charset arg3) {
        String v2_1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        InputStreamReader v0 = new InputStreamReader(new FileInputStream(arg2), arg3);
        try {
            v2_1 = TextStreamsKt.readText(v0);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v0), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        return v2_1;
    }

    public static String readText$default(File arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        return FilesKt.readText(arg0, arg1);
    }

    private static final InputStreamReader reader(File arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        return new InputStreamReader(new FileInputStream(arg2), arg3);
    }

    static InputStreamReader reader$default(File arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        return new InputStreamReader(new FileInputStream(arg0), arg1);
    }

    public static final Object useLines(File arg2, Charset arg3, Function1 arg4) {
        Object v2_1;
        BufferedReader v0_1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        Intrinsics.checkNotNullParameter(arg4, "block");
        InputStreamReader v0 = new InputStreamReader(new FileInputStream(arg2), arg3);
        if((v0 instanceof BufferedReader)) {
        }
        else {
            v0_1 = new BufferedReader(((Reader)v0), 0x2000);
        }

        try {
            v2_1 = arg4.invoke(TextStreamsKt.lineSequence(((InputStreamReader)v0_1)));
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v0_1), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0_1), null);
        return v2_1;
    }

    public static Object useLines$default(File arg0, Charset arg1, Function1 arg2, int arg3, Object arg4) {
        Object v0_1;
        BufferedReader v3_1;
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        Intrinsics.checkNotNullParameter(arg2, "block");
        InputStreamReader v3 = new InputStreamReader(new FileInputStream(arg0), arg1);
        if((v3 instanceof BufferedReader)) {
        }
        else {
            v3_1 = new BufferedReader(((Reader)v3), 0x2000);
        }

        try {
            v0_1 = arg2.invoke(TextStreamsKt.lineSequence(((InputStreamReader)v3_1)));
        }
        catch(Throwable v0) {
            try {
                throw v0;
            }
            catch(Throwable v1) {
                CloseableKt.closeFinally(((Closeable)v3_1), v0);
                throw v1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v3_1), null);
        return v0_1;
    }

    public static final void writeBytes(File arg1, byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "array");
        FileOutputStream v0 = new FileOutputStream(arg1);
        try {
            v0.write(arg2);
        }
        catch(Throwable v1) {
            try {
                throw v1;
            }
            catch(Throwable v2) {
                CloseableKt.closeFinally(((Closeable)v0), v1);
                throw v2;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
    }

    public static final void writeText(File arg1, String arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "text");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        FileOutputStream v0 = new FileOutputStream(arg1);
        try {
            FilesKt.writeTextImpl(v0, arg2, arg3);
        }
        catch(Throwable v1) {
            try {
                throw v1;
            }
            catch(Throwable v2) {
                CloseableKt.closeFinally(((Closeable)v0), v1);
                throw v2;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
    }

    public static void writeText$default(File arg0, String arg1, Charset arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        FilesKt.writeText(arg0, arg1, arg2);
    }

    public static final void writeTextImpl(OutputStream arg9, String arg10, Charset arg11) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        Intrinsics.checkNotNullParameter(arg10, "text");
        Intrinsics.checkNotNullParameter(arg11, "charset");
        if(arg10.length() < 0x4000) {
            byte[] v10 = arg10.getBytes(arg11);
            Intrinsics.checkNotNullExpressionValue(v10, "getBytes(...)");
            arg9.write(v10);
            return;
        }

        CharsetEncoder v11 = FilesKt.newReplaceEncoder(arg11);
        CharBuffer v1 = CharBuffer.allocate(0x2000);
        Intrinsics.checkNotNull(v11);
        ByteBuffer v0 = FilesKt.byteBufferForEncoding(0x2000, v11);
        int v3 = 0;
        int v4 = 0;
        while(true) {
            if(v3 >= arg10.length()) {
                return;
            }

            int v5 = Math.min(0x2000 - v4, arg10.length() - v3);
            int v6 = v3 + v5;
            char[] v7 = v1.array();
            Intrinsics.checkNotNullExpressionValue(v7, "array(...)");
            arg10.getChars(v3, v6, v7, v4);
            v1.limit(v5 + v4);
            v4 = 1;
            boolean v3_1 = v6 == arg10.length() ? true : false;
            if(!v11.encode(v1, v0, v3_1).isUnderflow()) {
                break;
            }

            arg9.write(v0.array(), 0, v0.position());
            if(v1.position() != v1.limit()) {
                v1.put(0, v1.get());
            }
            else {
                v4 = 0;
            }

            v1.clear();
            v0.clear();
            v3 = v6;
        }

        throw new IllegalStateException("Check failed.");
    }

    private static final OutputStreamWriter writer(File arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        return new OutputStreamWriter(new FileOutputStream(arg2), arg3);
    }

    static OutputStreamWriter writer$default(File arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        return new OutputStreamWriter(new FileOutputStream(arg0), arg1);
    }
}

