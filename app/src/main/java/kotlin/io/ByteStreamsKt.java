package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\u0082\u0004\u001A\u0018\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\b\u001A\u00020\u0004*\u00020\tH\u0087\u0088\u0004\u001A\u001E\u0010\b\u001A\u00020\u0004*\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0087\u0088\u0004\u001A\u0018\u0010\r\u001A\u00020\u0002*\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000BH\u0087\u0088\u0004\u001A\u0018\u0010\u0010\u001A\u00020\u0011*\u00020\u000E2\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u0018\u0010\u0012\u001A\u00020\u0013*\u00020\u000E2\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u0018\u0010\r\u001A\u00020\u0014*\u00020\u00152\b\b\u0002\u0010\u000F\u001A\u00020\u000BH\u0087\u0088\u0004\u001A\u0018\u0010\u0016\u001A\u00020\u0017*\u00020\u00152\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u0018\u0010\u0018\u001A\u00020\u0019*\u00020\u00152\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\u0088\u0004\u001A \u0010\u001A\u001A\u00020\u001B*\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u00152\b\b\u0002\u0010\u000F\u001A\u00020\u000BH\u0087\u0080\b\u001A\u0018\u0010\u001D\u001A\u00020\t*\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000BH\u0087\u0080\u0004\u001A\u000E\u0010\u001D\u001A\u00020\t*\u00020\u000EH\u0087\u0080\u0004¨\u0006\u001F"}, d2={"iterator", "Lkotlin/collections/ByteIterator;", "Ljava/io/BufferedInputStream;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "charset", "Ljava/nio/charset/Charset;", "inputStream", "", "offset", "", "length", "buffered", "Ljava/io/InputStream;", "bufferSize", "reader", "Ljava/io/InputStreamReader;", "bufferedReader", "Ljava/io/BufferedReader;", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "copyTo", "", "out", "readBytes", "estimatedSize", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ByteStreamsKt {
    private static final BufferedInputStream buffered(InputStream arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof BufferedInputStream)) {
            return arg1;
        }

        return new BufferedInputStream(arg1, arg2);
    }

    private static final BufferedOutputStream buffered(OutputStream arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof BufferedOutputStream)) {
            return arg1;
        }

        return new BufferedOutputStream(arg1, arg2);
    }

    static BufferedInputStream buffered$default(InputStream arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        if((arg0 instanceof BufferedInputStream)) {
            return arg0;
        }

        return new BufferedInputStream(arg0, arg1);
    }

    static BufferedOutputStream buffered$default(OutputStream arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        if((arg0 instanceof BufferedOutputStream)) {
            return arg0;
        }

        return new BufferedOutputStream(arg0, arg1);
    }

    private static final BufferedReader bufferedReader(InputStream arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        InputStreamReader v0 = new InputStreamReader(arg1, arg2);
        if((v0 instanceof BufferedReader)) {
            return ((BufferedReader)v0);
        }

        return new BufferedReader(((Reader)v0), 0x2000);
    }

    static BufferedReader bufferedReader$default(InputStream arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        InputStreamReader v2 = new InputStreamReader(arg0, arg1);
        if((v2 instanceof BufferedReader)) {
            return ((BufferedReader)v2);
        }

        return new BufferedReader(((Reader)v2), 0x2000);
    }

    private static final BufferedWriter bufferedWriter(OutputStream arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        OutputStreamWriter v0 = new OutputStreamWriter(arg1, arg2);
        if((v0 instanceof BufferedWriter)) {
            return ((BufferedWriter)v0);
        }

        return new BufferedWriter(((Writer)v0), 0x2000);
    }

    static BufferedWriter bufferedWriter$default(OutputStream arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        OutputStreamWriter v2 = new OutputStreamWriter(arg0, arg1);
        if((v2 instanceof BufferedWriter)) {
            return ((BufferedWriter)v2);
        }

        return new BufferedWriter(((Writer)v2), 0x2000);
    }

    private static final ByteArrayInputStream byteInputStream(String arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        byte[] v1 = arg1.getBytes(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
        return new ByteArrayInputStream(v1);
    }

    static ByteArrayInputStream byteInputStream$default(String arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        byte[] v0 = arg0.getBytes(arg1);
        Intrinsics.checkNotNullExpressionValue(v0, "getBytes(...)");
        return new ByteArrayInputStream(v0);
    }

    @IgnorableReturnValue public static final long copyTo(InputStream arg5, OutputStream arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "out");
        byte[] v7 = new byte[arg7];
        int v0 = arg5.read(v7);
        long v1 = 0;
        while(v0 >= 0) {
            arg6.write(v7, 0, v0);
            v1 += ((long)v0);
            v0 = arg5.read(v7);
        }

        return v1;
    }

    public static long copyTo$default(InputStream arg0, OutputStream arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 0x2000;
        }

        return ByteStreamsKt.copyTo(arg0, arg1, arg2);
    }

    private static final ByteArrayInputStream inputStream(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ByteArrayInputStream(arg1);
    }

    private static final ByteArrayInputStream inputStream(byte[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ByteArrayInputStream(arg1, arg2, arg3);
    }

    public static final ByteIterator iterator(BufferedInputStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ByteStreamsKt$iterator$1(arg1);
    }

    public static final byte[] readBytes(InputStream arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        ByteArrayOutputStream v0 = new ByteArrayOutputStream(Math.max(0x2000, arg5.available()));
        ByteStreamsKt.copyTo$default(arg5, v0, 0, 2, null);
        byte[] v5 = v0.toByteArray();
        Intrinsics.checkNotNullExpressionValue(v5, "toByteArray(...)");
        return v5;
    }

    @Deprecated(message="Use readBytes() overload without estimatedSize parameter", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="2.3", warningSince="1.3") public static final byte[] readBytes(InputStream arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        ByteArrayOutputStream v0 = new ByteArrayOutputStream(Math.max(arg5, arg4.available()));
        ByteStreamsKt.copyTo$default(arg4, v0, 0, 2, null);
        byte[] v4 = v0.toByteArray();
        Intrinsics.checkNotNullExpressionValue(v4, "toByteArray(...)");
        return v4;
    }

    public static byte[] readBytes$default(InputStream arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x2000;
        }

        return ByteStreamsKt.readBytes(arg0, arg1);
    }

    private static final InputStreamReader reader(InputStream arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new InputStreamReader(arg1, arg2);
    }

    static InputStreamReader reader$default(InputStream arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        return new InputStreamReader(arg0, arg1);
    }

    private static final OutputStreamWriter writer(OutputStream arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new OutputStreamWriter(arg1, arg2);
    }

    static OutputStreamWriter writer$default(OutputStream arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        return new OutputStreamWriter(arg0, arg1);
    }
}

