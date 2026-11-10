package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A\u0012\u0010\t\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000B\u001A\u001C\u0010\f\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u001A\r\u0010\u0011\u001A\u00020\u000B*\u00020\u0002H\u0086\b\u001A\u0014\u0010\u0012\u001A\u00020\u000E*\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2={"tryWrite", "", "Landroid/util/AtomicFile;", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "", "writeText", "text", "", "charset", "Ljava/nio/charset/Charset;", "readBytes", "readText", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = arg1.readFully();
        Intrinsics.checkNotNullExpressionValue(v1, "readFully(...)");
        return v1;
    }

    public static final String readText(AtomicFile arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        byte[] v1 = arg1.readFully();
        Intrinsics.checkNotNullExpressionValue(v1, "readFully(...)");
        return new String(v1, arg2);
    }

    public static String readText$default(AtomicFile arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        return AtomicFileKt.readText(arg0, arg1);
    }

    public static final void tryWrite(AtomicFile arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        FileOutputStream v0 = arg1.startWrite();
        try {
            Intrinsics.checkNotNull(v0);
            arg2.invoke(v0);
        }
        catch(Throwable v2) {
            arg1.failWrite(v0);
            throw v2;
        }

        arg1.finishWrite(v0);
    }

    public static final void writeBytes(AtomicFile arg1, byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "array");
        FileOutputStream v0 = arg1.startWrite();
        try {
            Intrinsics.checkNotNull(v0);
            v0.write(arg2);
        }
        catch(Throwable v2) {
            arg1.failWrite(v0);
            throw v2;
        }

        arg1.finishWrite(v0);
    }

    public static final void writeText(AtomicFile arg1, String arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "text");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        byte[] v2 = arg2.getBytes(arg3);
        Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
        AtomicFileKt.writeBytes(arg1, v2);
    }

    public static void writeText$default(AtomicFile arg0, String arg1, Charset arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = Charsets.UTF_8;
        }

        AtomicFileKt.writeText(arg0, arg1, arg2);
    }
}

