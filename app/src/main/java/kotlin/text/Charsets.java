package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000B\u001A\u00020\u00058GX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u0004\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000F\u001A\u00020\u00058GX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001A\u00020\u00058GX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001A\u0004\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lkotlin/text/Charsets;", "", "<init>", "()V", "UTF_8", "Ljava/nio/charset/Charset;", "UTF_16", "UTF_16BE", "UTF_16LE", "US_ASCII", "ISO_8859_1", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "utf_32", "UTF_32LE", "UTF32_LE", "utf_32le", "UTF_32BE", "UTF32_BE", "utf_32be", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Charsets {
    public static final Charsets INSTANCE;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static volatile Charset utf_32;
    private static volatile Charset utf_32be;
    private static volatile Charset utf_32le;

    static {
        Charsets.INSTANCE = new Charsets();
        Charset v0 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.UTF_8 = v0;
        v0 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.UTF_16 = v0;
        v0 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.UTF_16BE = v0;
        v0 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.UTF_16LE = v0;
        v0 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.US_ASCII = v0;
        v0 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        Charsets.ISO_8859_1 = v0;
    }

    private Charsets() {
        super();
    }

    public final Charset UTF32() {
        Charset v0 = Charsets.utf_32;
        if(v0 == null) {
            Charset v1 = Charset.forName("UTF-32");
            Intrinsics.checkNotNullExpressionValue(v1, "forName(...)");
            Charsets.utf_32 = v1;
            return v1;
        }

        return v0;
    }

    public final Charset UTF32_BE() {
        Charset v0 = Charsets.utf_32be;
        if(v0 == null) {
            Charset v1 = Charset.forName("UTF-32BE");
            Intrinsics.checkNotNullExpressionValue(v1, "forName(...)");
            Charsets.utf_32be = v1;
            return v1;
        }

        return v0;
    }

    public final Charset UTF32_LE() {
        Charset v0 = Charsets.utf_32le;
        if(v0 == null) {
            Charset v1 = Charset.forName("UTF-32LE");
            Intrinsics.checkNotNullExpressionValue(v1, "forName(...)");
            Charsets.utf_32le = v1;
            return v1;
        }

        return v0;
    }
}

