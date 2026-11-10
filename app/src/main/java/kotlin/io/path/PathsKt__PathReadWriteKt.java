package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000\u008E\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001C\n\u0002\b\u0004\u001A1\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010\b\u001A;\u0010\t\u001A\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010\r\u001A1\u0010\u000E\u001A\u00020\u000F*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0010\u001A;\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0013\u001A\u000E\u0010\u0014\u001A\u00020\u0015*\u00020\u0002H\u0087\u0088\u0004\u001A/\u0010\u0016\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00152\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0019\u001A\u0016\u0010\u001A\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0015H\u0087\u0088\u0004\u001A\u0018\u0010\u001B\u001A\u00020\u001C*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A9\u0010\u001D\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010 \u001A \u0010!\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A>\u0010\"\u001A\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042!\u0010#\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00170$H\u0087\u0088\u0004ø\u0001\u0000\u001A\'\u0010(\u001A\u00020)*\u00020\u00022\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010*\u001A\'\u0010+\u001A\u00020,*\u00020\u00022\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\u0004¢\u0006\u0002\u0010-\u001A\u001E\u0010.\u001A\b\u0012\u0004\u0012\u00020\u001C0/*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001AM\u00100\u001A\u0002H1\"\u0004\b\u0000\u00101*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0018\u00102\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001C03\u0012\u0004\u0012\u0002H10$H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00104\u001A?\u00105\u001A\u00020\u0002*\u00020\u00022\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u001F072\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\b¢\u0006\u0002\u00108\u001A?\u00105\u001A\u00020\u0002*\u00020\u00022\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u001F032\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\u0088\b¢\u0006\u0002\u00109\u001A&\u0010:\u001A\u00020\u0002*\u00020\u00022\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u001F072\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\b\u001A&\u0010:\u001A\u00020\u0002*\u00020\u00022\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u001F032\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2={"reader", "Ljava/io/InputStreamReader;", "Ljava/nio/file/Path;", "charset", "Ljava/nio/charset/Charset;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "readBytes", "", "writeBytes", "", "array", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "appendBytes", "readText", "", "writeText", "text", "", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "appendText", "forEachLine", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeLines", "lines", "", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "appendLines", "kotlin-stdlib-jdk7"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/path/PathsKt") class PathsKt__PathReadWriteKt {
    public PathsKt__PathReadWriteKt() {
        super();
    }

    private static final void appendBytes(Path arg3, byte[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "array");
        Files.write(arg3, arg4, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @IgnorableReturnValue private static final Path appendLines(Path arg3, Iterable arg4, Charset arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "lines");
        Intrinsics.checkNotNullParameter(arg5, "charset");
        arg3 = Files.write(arg3, arg4, arg5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(arg3, "write(...)");
        return arg3;
    }

    @IgnorableReturnValue private static final Path appendLines(Path arg3, Sequence arg4, Charset arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "lines");
        Intrinsics.checkNotNullParameter(arg5, "charset");
        arg3 = Files.write(arg3, SequencesKt.asIterable(arg4), arg5, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(arg3, "write(...)");
        return arg3;
    }

    static Path appendLines$default(Path arg1, Iterable arg2, Charset arg3, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg3 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "lines");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        arg1 = Files.write(arg1, arg2, arg3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(arg1, "write(...)");
        return arg1;
    }

    static Path appendLines$default(Path arg1, Sequence arg2, Charset arg3, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg3 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "lines");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        arg1 = Files.write(arg1, SequencesKt.asIterable(arg2), arg3, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.checkNotNullExpressionValue(arg1, "write(...)");
        return arg1;
    }

    public static final void appendText(Path arg3, CharSequence arg4, Charset arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "text");
        Intrinsics.checkNotNullParameter(arg5, "charset");
        PathsKt.writeText(arg3, arg4, arg5, new OpenOption[]{StandardOpenOption.APPEND});
    }

    public static void appendText$default(Path arg0, CharSequence arg1, Charset arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        PathsKt.appendText(arg0, arg1, arg2);
    }

    private static final BufferedReader bufferedReader(Path arg3, Charset arg4, int arg5, OpenOption[] arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        Intrinsics.checkNotNullParameter(arg6, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(arg3, Arrays.copyOf(((Object[])arg6), arg6.length)), arg4), arg5);
    }

    static BufferedReader bufferedReader$default(Path arg1, Charset arg2, int arg3, OpenOption[] arg4, int arg5, Object arg6) throws IOException {
        if((arg5 & 1) != 0) {
            arg2 = Charsets.UTF_8;
        }

        if((arg5 & 2) != 0) {
            arg3 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(arg1, Arrays.copyOf(((Object[])arg4), arg4.length)), arg2), arg3);
    }

    private static final BufferedWriter bufferedWriter(Path arg3, Charset arg4, int arg5, OpenOption[] arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        Intrinsics.checkNotNullParameter(arg6, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(arg3, Arrays.copyOf(((Object[])arg6), arg6.length)), arg4), arg5);
    }

    static BufferedWriter bufferedWriter$default(Path arg1, Charset arg2, int arg3, OpenOption[] arg4, int arg5, Object arg6) throws IOException {
        if((arg5 & 1) != 0) {
            arg2 = Charsets.UTF_8;
        }

        if((arg5 & 2) != 0) {
            arg3 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(arg1, Arrays.copyOf(((Object[])arg4), arg4.length)), arg2), arg3);
    }

    private static final void forEachLine(Path arg1, Charset arg2, Function1 arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg3, "action");
        BufferedReader v1 = Files.newBufferedReader(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "newBufferedReader(...)");
        try {
            Iterator v2_1 = TextStreamsKt.lineSequence(v1).iterator();
            while(v2_1.hasNext()) {
                arg3.invoke(v2_1.next());
            }
        }
        catch(Throwable v2) {
            goto label_22;
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return;
        try {
        label_22:
            throw v2;
        }
        catch(Throwable v3) {
            CloseableKt.closeFinally(((Closeable)v1), v2);
            throw v3;
        }
    }

    static void forEachLine$default(Path arg0, Charset arg1, Function1 arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        Intrinsics.checkNotNullParameter(arg2, "action");
        BufferedReader v0 = Files.newBufferedReader(arg0, arg1);
        Intrinsics.checkNotNullExpressionValue(v0, "newBufferedReader(...)");
        try {
            Iterator v1_1 = TextStreamsKt.lineSequence(v0).iterator();
            while(v1_1.hasNext()) {
                arg2.invoke(v1_1.next());
            }
        }
        catch(Throwable v1) {
            goto label_25;
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        return;
        try {
        label_25:
            throw v1;
        }
        catch(Throwable v2) {
            CloseableKt.closeFinally(((Closeable)v0), v1);
            throw v2;
        }
    }

    private static final InputStream inputStream(Path arg1, OpenOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        InputStream v1 = Files.newInputStream(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "newInputStream(...)");
        return v1;
    }

    private static final OutputStream outputStream(Path arg1, OpenOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        OutputStream v1 = Files.newOutputStream(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "newOutputStream(...)");
        return v1;
    }

    private static final byte[] readBytes(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = Files.readAllBytes(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "readAllBytes(...)");
        return v1;
    }

    private static final List readLines(Path arg1, Charset arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        List v1 = Files.readAllLines(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "readAllLines(...)");
        return v1;
    }

    static List readLines$default(Path arg0, Charset arg1, int arg2, Object arg3) throws IOException {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        List v0 = Files.readAllLines(arg0, arg1);
        Intrinsics.checkNotNullExpressionValue(v0, "readAllLines(...)");
        return v0;
    }

    public static final String readText(Path arg3, Charset arg4) throws IOException {
        String v3_1;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        InputStreamReader v2 = new InputStreamReader(Files.newInputStream(arg3, Arrays.copyOf(new OpenOption[0], 0)), arg4);
        try {
            v3_1 = TextStreamsKt.readText(v2);
        }
        catch(Throwable v3) {
            try {
                throw v3;
            }
            catch(Throwable v4) {
                CloseableKt.closeFinally(((Closeable)v2), v3);
                throw v4;
            }
        }

        CloseableKt.closeFinally(((Closeable)v2), null);
        return v3_1;
    }

    public static String readText$default(Path arg0, Charset arg1, int arg2, Object arg3) throws IOException {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        return PathsKt.readText(arg0, arg1);
    }

    private static final InputStreamReader reader(Path arg2, Charset arg3, OpenOption[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        return new InputStreamReader(Files.newInputStream(arg2, Arrays.copyOf(((Object[])arg4), arg4.length)), arg3);
    }

    static InputStreamReader reader$default(Path arg0, Charset arg1, OpenOption[] arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return new InputStreamReader(Files.newInputStream(arg0, Arrays.copyOf(((Object[])arg2), arg2.length)), arg1);
    }

    @IgnorableReturnValue private static final Object useLines(Path arg1, Charset arg2, Function1 arg3) throws IOException {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg3, "block");
        BufferedReader v1 = Files.newBufferedReader(arg1, arg2);
        try {
            Intrinsics.checkNotNull(v1);
            v2_1 = arg3.invoke(TextStreamsKt.lineSequence(v1));
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v1), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return v2_1;
    }

    static Object useLines$default(Path arg0, Charset arg1, Function1 arg2, int arg3, Object arg4) throws IOException {
        Object v1_1;
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        Intrinsics.checkNotNullParameter(arg2, "block");
        BufferedReader v0 = Files.newBufferedReader(arg0, arg1);
        try {
            Intrinsics.checkNotNull(v0);
            v1_1 = arg2.invoke(TextStreamsKt.lineSequence(v0));
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
        return v1_1;
    }

    private static final void writeBytes(Path arg1, byte[] arg2, OpenOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "array");
        Intrinsics.checkNotNullParameter(arg3, "options");
        Files.write(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    @IgnorableReturnValue private static final Path writeLines(Path arg1, Iterable arg2, Charset arg3, OpenOption[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "lines");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        arg1 = Files.write(arg1, arg2, arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "write(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final Path writeLines(Path arg1, Sequence arg2, Charset arg3, OpenOption[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "lines");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        arg1 = Files.write(arg1, SequencesKt.asIterable(arg2), arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "write(...)");
        return arg1;
    }

    static Path writeLines$default(Path arg0, Iterable arg1, Charset arg2, OpenOption[] arg3, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "lines");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg3, "options");
        arg0 = Files.write(arg0, arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg0, "write(...)");
        return arg0;
    }

    static Path writeLines$default(Path arg0, Sequence arg1, Charset arg2, OpenOption[] arg3, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "lines");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        Intrinsics.checkNotNullParameter(arg3, "options");
        arg0 = Files.write(arg0, SequencesKt.asIterable(arg1), arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg0, "write(...)");
        return arg0;
    }

    public static final void writeText(Path arg4, CharSequence arg5, Charset arg6, OpenOption[] arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "text");
        Intrinsics.checkNotNullParameter(arg6, "charset");
        Intrinsics.checkNotNullParameter(arg7, "options");
        OutputStream v4 = Files.newOutputStream(arg4, Arrays.copyOf(((Object[])arg7), arg7.length));
        try {
            OutputStream v7 = v4;
            if((arg5 instanceof String)) {
                Intrinsics.checkNotNull(v7);
                FilesKt.writeTextImpl(v7, ((String)arg5), arg6);
            }
            else {
                CharsetEncoder v6 = FilesKt.newReplaceEncoder(arg6);
                CharBuffer v0 = (arg5 instanceof CharBuffer) ? arg5.asReadOnlyBuffer() : CharBuffer.wrap(arg5);
                int v5_1 = Math.min(arg5.length(), 0x2000);
                Intrinsics.checkNotNull(v6);
                ByteBuffer v5_2 = FilesKt.byteBufferForEncoding(v5_1, v6);
                while(true) {
                    if(!v0.hasRemaining()) {
                        goto label_45;
                    }

                    if(v6.encode(v0, v5_2, true).isError()) {
                        break;
                    }

                    v7.write(v5_2.array(), 0, v5_2.position());
                    v5_2.clear();
                }

                throw new IllegalStateException("Check failed.");
            }

        label_45:
        }
        catch(Throwable v5) {
            try {
                throw v5;
            }
            catch(Throwable v6_1) {
                CloseableKt.closeFinally(((Closeable)v4), v5);
                throw v6_1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v4), null);
    }

    public static void writeText$default(Path arg0, CharSequence arg1, Charset arg2, OpenOption[] arg3, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        PathsKt.writeText(arg0, arg1, arg2, arg3);
    }

    private static final OutputStreamWriter writer(Path arg2, Charset arg3, OpenOption[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        Intrinsics.checkNotNullParameter(arg4, "options");
        return new OutputStreamWriter(Files.newOutputStream(arg2, Arrays.copyOf(((Object[])arg4), arg4.length)), arg3);
    }

    static OutputStreamWriter writer$default(Path arg0, Charset arg1, OpenOption[] arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return new OutputStreamWriter(Files.newOutputStream(arg0, Arrays.copyOf(((Object[])arg2), arg2.length)), arg1);
    }
}

