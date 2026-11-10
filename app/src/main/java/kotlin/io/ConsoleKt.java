package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0010\u000B\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0005H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\bH\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\tH\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\nH\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u000BH\u0087\u0088\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\fH\u0087\u0088\u0004\u001A\u0014\u0010\r\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0005H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\bH\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\tH\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\nH\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u000BH\u0087\u0088\u0004\u001A\u0012\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\fH\u0087\u0088\u0004\u001A\n\u0010\r\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\n\u0010\u000E\u001A\u00020\u000FH\u0087\u0080\u0004\u001A\f\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0087\u0080\u0004\u001A\f\u0010\u0011\u001A\u0004\u0018\u00010\u000FH\u0086\u0080\u0004¨\u0006\u0012"}, d2={"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readln", "", "readlnOrNull", "readLine", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ConsoleKt {
    private static final void print(byte arg1) {
        System.out.print(Byte.valueOf(arg1));
    }

    private static final void print(char arg1) {
        System.out.print(arg1);
    }

    private static final void print(double arg1) {
        System.out.print(arg1);
    }

    private static final void print(float arg1) {
        System.out.print(arg1);
    }

    private static final void print(int arg1) {
        System.out.print(arg1);
    }

    private static final void print(long arg1) {
        System.out.print(arg1);
    }

    private static final void print(Object arg1) {
        System.out.print(arg1);
    }

    private static final void print(short arg1) {
        System.out.print(Short.valueOf(arg1));
    }

    private static final void print(boolean arg1) {
        System.out.print(arg1);
    }

    private static final void print(char[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        System.out.print(arg1);
    }

    private static final void println() {
        System.out.println();
    }

    private static final void println(byte arg1) {
        System.out.println(Byte.valueOf(arg1));
    }

    private static final void println(char arg1) {
        System.out.println(arg1);
    }

    private static final void println(double arg1) {
        System.out.println(arg1);
    }

    private static final void println(float arg1) {
        System.out.println(arg1);
    }

    private static final void println(int arg1) {
        System.out.println(arg1);
    }

    private static final void println(long arg1) {
        System.out.println(arg1);
    }

    private static final void println(Object arg1) {
        System.out.println(arg1);
    }

    private static final void println(short arg1) {
        System.out.println(Short.valueOf(arg1));
    }

    private static final void println(boolean arg1) {
        System.out.println(arg1);
    }

    private static final void println(char[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        System.out.println(arg1);
    }

    public static final String readLine() {
        LineReader v0 = LineReader.INSTANCE;
        InputStream v1 = System.in;
        Intrinsics.checkNotNullExpressionValue(v1, "in");
        Charset v2 = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(v2, "defaultCharset(...)");
        return v0.readLine(v1, v2);
    }

    public static final String readln() {
        String v0 = ConsoleKt.readlnOrNull();
        if(v0 != null) {
            return v0;
        }

        throw new ReadAfterEOFException("EOF has already been reached");
    }

    public static final String readlnOrNull() {
        return ConsoleKt.readLine();
    }
}

