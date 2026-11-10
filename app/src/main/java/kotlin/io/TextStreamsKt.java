package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0018\u0010\u0000\u001A\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\"\u0010\u0007\u001A\u00020\b*\u00020\u00022\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\b0\nH\u0086\u0080\u0004\u001A\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\r*\u00020\u0002H\u0086\u0080\u0004\u001AC\u0010\u000E\u001A\u0002H\u000F\"\u0004\b\u0000\u0010\u000F*\u00020\u00022\u0018\u0010\u0010\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0011\u0012\u0004\u0012\u0002H\u000F0\nH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0012\u001A\u000E\u0010\u0013\u001A\u00020\u0014*\u00020\u000BH\u0087\u0088\u0004\u001A\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0011*\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\u0016\u001A\u00020\u000B*\u00020\u0002H\u0086\u0080\u0004\u001A \u0010\u0017\u001A\u00020\u0018*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u00062\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\b\u001A\u0018\u0010\u0016\u001A\u00020\u000B*\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001CH\u0087\u0088\u0004\u001A\u000E\u0010\u001D\u001A\u00020\u001E*\u00020\u001AH\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001F"}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "forEachLine", "", "action", "Lkotlin/Function1;", "", "readLines", "", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "reader", "Ljava/io/StringReader;", "lineSequence", "readText", "copyTo", "", "out", "Ljava/net/URL;", "charset", "Ljava/nio/charset/Charset;", "readBytes", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class TextStreamsKt {
    private static final BufferedReader buffered(Reader arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof BufferedReader)) {
            return arg1;
        }

        return new BufferedReader(arg1, arg2);
    }

    private static final BufferedWriter buffered(Writer arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof BufferedWriter)) {
            return arg1;
        }

        return new BufferedWriter(arg1, arg2);
    }

    static BufferedReader buffered$default(Reader arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        if((arg0 instanceof BufferedReader)) {
            return arg0;
        }

        return new BufferedReader(arg0, arg1);
    }

    static BufferedWriter buffered$default(Writer arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x2000;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        if((arg0 instanceof BufferedWriter)) {
            return arg0;
        }

        return new BufferedWriter(arg0, arg1);
    }

    @IgnorableReturnValue public static final long copyTo(Reader arg5, Writer arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "out");
        char[] v7 = new char[arg7];
        int v0 = arg5.read(v7);
        long v1 = 0;
        while(v0 >= 0) {
            arg6.write(v7, 0, v0);
            v1 += ((long)v0);
            v0 = arg5.read(v7);
        }

        return v1;
    }

    public static long copyTo$default(Reader arg0, Writer arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 0x2000;
        }

        return TextStreamsKt.copyTo(arg0, arg1, arg2);
    }

    public static final void forEachLine(Reader arg2, Function1 arg3) {
        BufferedReader v2;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        if((arg2 instanceof BufferedReader)) {
        }
        else {
            v2 = new BufferedReader(arg2, 0x2000);
        }

        try {
            Iterator v0 = TextStreamsKt.lineSequence(((Reader)v2)).iterator();
            while(v0.hasNext()) {
                arg3.invoke(v0.next());
            }
        }
        catch(Throwable v3) {
            goto label_24;
        }

        CloseableKt.closeFinally(((Closeable)v2), null);
        return;
        try {
        label_24:
            throw v3;
        }
        catch(Throwable v0_1) {
            CloseableKt.closeFinally(((Closeable)v2), v3);
            throw v0_1;
        }
    }

    public static final Sequence lineSequence(BufferedReader arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.constrainOnce(new LinesSequence(arg1));
    }

    public static final byte[] readBytes(URL arg2) {
        byte[] v0_1;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        InputStream v2 = arg2.openStream();
        try {
            Intrinsics.checkNotNull(v2);
            v0_1 = ByteStreamsKt.readBytes(v2);
        }
        catch(Throwable v0) {
            try {
                throw v0;
            }
            catch(Throwable v1) {
                CloseableKt.closeFinally(((Closeable)v2), v0);
                throw v1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v2), null);
        return v0_1;
    }

    public static final List readLines(Reader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        ArrayList v0 = new ArrayList();
        TextStreamsKt.forEachLine(arg2, new TextStreamsKt$$ExternalSyntheticLambda0(v0));
        return ((List)v0);
    }

    static final Unit readLines$lambda$0(ArrayList arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.add(arg2);
        return Unit.INSTANCE;
    }

    public static final String readText(Reader arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        StringWriter v0 = new StringWriter();
        TextStreamsKt.copyTo$default(arg5, v0, 0, 2, null);
        String v5 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }

    private static final String readText(URL arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new String(TextStreamsKt.readBytes(arg1), arg2);
    }

    static String readText$default(URL arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        return new String(TextStreamsKt.readBytes(arg0), arg1);
    }

    private static final StringReader reader(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StringReader(arg1);
    }

    @IgnorableReturnValue public static final Object useLines(Reader arg2, Function1 arg3) {
        Object v3_1;
        BufferedReader v2;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "block");
        if((arg2 instanceof BufferedReader)) {
        }
        else {
            v2 = new BufferedReader(arg2, 0x2000);
        }

        try {
            v3_1 = arg3.invoke(TextStreamsKt.lineSequence(((Reader)v2)));
        }
        catch(Throwable v3) {
            try {
                throw v3;
            }
            catch(Throwable v0) {
                CloseableKt.closeFinally(((Closeable)v2), v3);
                throw v0;
            }
        }

        CloseableKt.closeFinally(((Closeable)v2), null);
        return v3_1;
    }
}

