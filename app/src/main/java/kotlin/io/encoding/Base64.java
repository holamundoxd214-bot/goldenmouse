package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\t\b\u0017\u0018\u0000 B2\u00020\u0001:\u0002ABB)\bB\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\bH\u0087\u0080\u0004J&\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J8\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\b\b\u0002\u0010\u001C\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J&\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0017\u001A\u00020\u00162\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004JA\u0010\u001F\u001A\u0002H \"\f\b\u0000\u0010 *\u00060!j\u0002`\"2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u0002H 2\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0087\u0080\b¢\u0006\u0002\u0010#J&\u0010$\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J8\u0010%\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\b\b\u0002\u0010\u001C\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J&\u0010$\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020&2\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J8\u0010%\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020&2\u0006\u0010\u001B\u001A\u00020\u00162\b\b\u0002\u0010\u001C\u001A\u00020\u00062\b\b\u0002\u0010\u0018\u001A\u00020\u00062\b\b\u0002\u0010\u0019\u001A\u00020\u0006H\u0086\u0080\u0004J\'\u0010\'\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b(J7\u0010)\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b*J\u0017\u0010+\u001A\u00020\u00062\u0006\u0010,\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b-J\n\u0010.\u001A\u00020\u0003H\u0082\u0080\u0004J2\u0010/\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0082\u0080\u0004J\'\u00100\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b1J\'\u00102\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020&2\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b3J\u0017\u00104\u001A\u00020\u001E2\u0006\u0010\u0017\u001A\u00020\u0016H\u0080\u0080\u0004¢\u0006\u0002\b5J*\u00106\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u00107\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u0006H\u0082\u0080\u0004J\u0012\u00109\u001A\u00020:2\u0006\u00107\u001A\u00020\u0006H\u0082\u0080\u0004J\"\u0010;\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0082\u0080\u0004J\'\u0010<\u001A\u00020:2\u0006\u0010,\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0002\b=J\"\u0010>\u001A\u00020:2\u0006\u0010?\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010@\u001A\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0015\u0010\u0004\u001A\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001A\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0007\u001A\u00020\bX\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u000F\u0010\u0012\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006C"}, d2={"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "mimeLineLength", "", "paddingOption", "Lkotlin/io/encoding/Base64$PaddingOption;", "<init>", "(ZZILkotlin/io/encoding/Base64$PaddingOption;)V", "isUrlSafe$kotlin_stdlib", "()Z", "isMimeScheme$kotlin_stdlib", "getMimeLineLength$kotlin_stdlib", "()I", "getPaddingOption$kotlin_stdlib", "()Lkotlin/io/encoding/Base64$PaddingOption;", "mimeGroupsPerLine", "withPadding", "option", "encodeToByteArray", "", "source", "startIndex", "endIndex", "encodeIntoByteArray", "destination", "destinationOffset", "encode", "", "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "decode", "decodeIntoByteArray", "", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "sourceSize", "encodeSize$kotlin_stdlib", "shouldPadOnEncode", "decodeImpl", "decodeSize", "decodeSize$kotlin_stdlib", "charsToBytesImpl", "charsToBytesImpl$kotlin_stdlib", "bytesToStringImpl", "bytesToStringImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "checkPaddingIsAllowed", "", "skipIllegalSymbolsIfMime", "checkSourceBounds", "checkSourceBounds$kotlin_stdlib", "checkDestinationBounds", "destinationSize", "capacityNeeded", "PaddingOption", "Default", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class Base64 {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\nX\u0080Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001A\u00020\u000EX\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\u0011\u001A\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001A\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0016\u001A\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2={"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "<init>", "()V", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "symbolsPerGroup", "padSymbol", "", "lineLengthMime", "lineLengthPem", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "UrlSafe", "getUrlSafe", "()Lkotlin/io/encoding/Base64;", "Mime", "getMime", "Pem", "getPem", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Default extends Base64 {
        public Default(DefaultConstructorMarker arg1) {
            this();
        }

        private Default() {
            super(false, false, -1, PaddingOption.PRESENT, null);
        }

        public final Base64 getMime() {
            return Base64.Mime;
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.mimeLineSeparatorSymbols;
        }

        public final Base64 getPem() {
            return Base64.Pem;
        }

        public final Base64 getUrlSafe() {
            return Base64.UrlSafe;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lkotlin/io/encoding/Base64$PaddingOption;", "", "<init>", "(Ljava/lang/String;I)V", "PRESENT", "ABSENT", "PRESENT_OPTIONAL", "ABSENT_OPTIONAL", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum PaddingOption {
        public static final enum PaddingOption ABSENT;
        public static final enum PaddingOption ABSENT_OPTIONAL;
        public static final enum PaddingOption PRESENT;
        public static final enum PaddingOption PRESENT_OPTIONAL;

        private static final PaddingOption[] $values() {
            return new PaddingOption[]{PaddingOption.PRESENT, PaddingOption.ABSENT, PaddingOption.PRESENT_OPTIONAL, PaddingOption.ABSENT_OPTIONAL};
        }

        static {
            PaddingOption.PRESENT = new PaddingOption("PRESENT", 0);
            PaddingOption.ABSENT = new PaddingOption("ABSENT", 1);
            PaddingOption.PRESENT_OPTIONAL = new PaddingOption("PRESENT_OPTIONAL", 2);
            PaddingOption.ABSENT_OPTIONAL = new PaddingOption("ABSENT_OPTIONAL", 3);
            PaddingOption[] v0 = PaddingOption.$values();
            PaddingOption.$VALUES = v0;
            PaddingOption.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private PaddingOption(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return PaddingOption.$ENTRIES;
        }

        public static PaddingOption valueOf(String arg1) {
            return Enum.valueOf(PaddingOption.class, arg1);
        }

        public static PaddingOption[] values() {
            return PaddingOption.$VALUES.clone();
        }
    }

    public static final Default Default = null;
    private static final Base64 Mime = null;
    private static final Base64 Pem = null;
    private static final Base64 UrlSafe = null;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;
    private static final int lineLengthMime = 76;
    private static final int lineLengthPem = 0x40;
    private final int mimeGroupsPerLine;
    private final int mimeLineLength;
    private static final byte[] mimeLineSeparatorSymbols = null;
    public static final byte padSymbol = 61;
    private final PaddingOption paddingOption;
    public static final int symbolsPerGroup = 4;

    static {
        Base64.Default = new Default(null);
        Base64.mimeLineSeparatorSymbols = new byte[]{13, 10};
        Base64.UrlSafe = new Base64(true, false, -1, PaddingOption.PRESENT);
        Base64.Mime = new Base64(false, true, 76, PaddingOption.PRESENT);
        Base64.Pem = new Base64(false, true, 0x40, PaddingOption.PRESENT);
    }

    private Base64(boolean arg1, boolean arg2, int arg3, PaddingOption arg4) {
        super();
        this.isUrlSafe = arg1;
        this.isMimeScheme = arg2;
        this.mimeLineLength = arg3;
        this.paddingOption = arg4;
        if(arg1) {
            if(!arg2) {
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        this.mimeGroupsPerLine = arg3 / 4;
    }

    public Base64(boolean arg1, boolean arg2, int arg3, PaddingOption arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final Base64 access$getMime$cp() {
        return Base64.Mime;
    }

    public static final byte[] access$getMimeLineSeparatorSymbols$cp() {
        return Base64.mimeLineSeparatorSymbols;
    }

    public static final Base64 access$getPem$cp() {
        return Base64.Pem;
    }

    public static final Base64 access$getUrlSafe$cp() {
        return Base64.UrlSafe;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "source");
        StringBuilder v3 = new StringBuilder(arg4.length);
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v3.append(((char)arg4[v1]));
        }

        return v3.toString();
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence arg4, int arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "source");
        this.checkSourceBounds$kotlin_stdlib(arg4.length(), arg5, arg6);
        byte[] v3 = new byte[arg6 - arg5];
        int v0 = 0;
        while(arg5 < arg6) {
            int v1 = arg4.charAt(arg5);
            if(v1 <= 0xFF) {
                v3[v0] = ((byte)v1);
                ++v0;
            }
            else {
                v3[v0] = 0x3F;
                ++v0;
            }

            ++arg5;
        }

        return v3;
    }

    private final void checkDestinationBounds(int arg4, int arg5, int arg6) {
        String v3 = ", destination size: ";
        if(arg5 >= 0 && arg5 <= arg4) {
            int v0 = arg5 + arg6;
            if(v0 >= 0 && v0 <= arg4) {
                return;
            }

            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + arg5 + v3 + arg4 + ", capacity needed: " + arg6);
        }

        throw new IndexOutOfBoundsException("destination offset: " + arg5 + v3 + arg4);
    }

    private final void checkPaddingIsAllowed(int arg3) {
        if(this.paddingOption != PaddingOption.ABSENT) {
            return;
        }

        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + arg3);
    }

    public final void checkSourceBounds$kotlin_stdlib(int arg1, int arg2, int arg3) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg2, arg3, arg1);
    }

    public final byte[] decode(CharSequence arg7, int arg8, int arg9) {
        byte[] v7_1;
        Intrinsics.checkNotNullParameter(arg7, "source");
        if((arg7 instanceof String)) {
            this.checkSourceBounds$kotlin_stdlib(((String)arg7).length(), arg8, arg9);
            String v7 = ((String)arg7).substring(arg8, arg9);
            Intrinsics.checkNotNullExpressionValue(v7, "substring(...)");
            Charset v8 = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type java.lang.String");
            v7_1 = v7.getBytes(v8);
            Intrinsics.checkNotNullExpressionValue(v7_1, "getBytes(...)");
        }
        else {
            v7_1 = this.charsToBytesImpl$kotlin_stdlib(arg7, arg8, arg9);
        }

        return Base64.decode$default(this, v7_1, 0, 0, 6, null);
    }

    public final byte[] decode(byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "source");
        this.checkSourceBounds$kotlin_stdlib(arg8.length, arg9, arg10);
        int v0 = this.decodeSize$kotlin_stdlib(arg8, arg9, arg10);
        byte[] v3 = new byte[v0];
        if(this.decodeImpl(arg8, v3, 0, arg9, arg10) == v0) {
            return v3;
        }

        throw new IllegalStateException("Check failed.");
    }

    public static byte[] decode$default(Base64 arg0, CharSequence arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg1.length();
            }

            return arg0.decode(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static byte[] decode$default(Base64 arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg1.length;
            }

            return arg0.decode(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    private final int decodeImpl(byte[] arg20, byte[] arg21, int arg22, int arg23, int arg24) {
        int v4;
        int v18;
        String v12;
        String v11;
        String v10;
        Base64 v0 = this;
        byte[] v1 = arg20;
        int v2 = arg24;
        int[] v3 = v0.isUrlSafe ? Base64Kt.access$getBase64UrlDecodeMap$p() : Base64Kt.access$getBase64DecodeMap$p();
        int v5 = -8;
        int v9 = arg22;
        int v6 = arg23;
        int v7 = v5;
        int v8 = 0;
        while(true) {
            v10 = ") at index ";
            v11 = "toString(...)";
            v12 = "\'(";
            int v14 = -2;
            if(v6 >= v2) {
                break;
            }

            if(v7 != v5 || v6 + 3 >= v2) {
                arg23 = 8;
                v18 = 1;
            label_61:
                v4 = v1[v6] & 0xFF;
                v5 = v3[v4];
                if(v5 >= 0) {
                    ++v6;
                    v8 = v8 << 6 | v5;
                    v4 = v7 + 6;
                    if(v4 >= 0) {
                        arg21[v9] = ((byte)(v8 >>> v4));
                        v8 &= (v18 << v4) - 1;
                        v7 += -2;
                        ++v9;
                    }
                    else {
                        v7 = v4;
                    }
                }
                else if(v5 == v14) {
                    v6 = v0.handlePaddingSymbol(v1, v6, v2, v7);
                    v4 = v18;
                    goto label_110;
                }
                else if(v0.isMimeScheme) {
                    ++v6;
                }
                else {
                    StringBuilder v1_1 = new StringBuilder("Invalid symbol \'").append(((char)v4)).append(v12);
                    String v2_1 = Integer.toString(v4, CharsKt.checkRadix(arg23));
                    Intrinsics.checkNotNullExpressionValue(v2_1, v11);
                    throw new IllegalArgumentException(v1_1.append(v2_1).append(v10).append(v6).toString());
                }
            }
            else {
                arg23 = 8;
                v18 = 1;
                int v16 = v6 + 4;
                v4 = v3[v1[v6 + 1] & 0xFF] << 12 | v3[v1[v6] & 0xFF] << 18 | v3[v1[v6 + 2] & 0xFF] << 6 | v3[v1[v6 + 3] & 0xFF];
                if(v4 >= 0) {
                    arg21[v9] = ((byte)(v4 >> 16));
                    v6 = v9 + 2;
                    arg21[v9 + 1] = ((byte)(v4 >> 8));
                    v9 += 3;
                    arg21[v6] = ((byte)v4);
                    v6 = v16;
                }
                else {
                    goto label_61;
                }
            }

            v5 = -8;
        }

        arg23 = 8;
        v4 = 0;
    label_110:
        if(v7 != v14) {
            if(v7 != -8 && v4 == 0) {
                if(v0.paddingOption != PaddingOption.PRESENT) {
                }
                else {
                    throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
                }
            }

            if(v8 == 0) {
                int v0_1 = v0.skipIllegalSymbolsIfMime(v1, v6, v2);
                if(v0_1 >= v2) {
                    return v9 - arg22;
                }

                int v1_2 = v1[v0_1] & 0xFF;
                StringBuilder v3_1 = new StringBuilder("Symbol \'").append(((char)v1_2)).append(v12);
                String v1_3 = Integer.toString(v1_2, CharsKt.checkRadix(arg23));
                Intrinsics.checkNotNullExpressionValue(v1_3, v11);
                throw new IllegalArgumentException(v3_1.append(v1_3).append(v10).append(v0_1 - 1).append(" is prohibited after the pad character").toString());
            }

            throw new IllegalArgumentException("The pad bits must be zeros");
        }

        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    }

    public final int decodeIntoByteArray(CharSequence arg9, byte[] arg10, int arg11, int arg12, int arg13) {
        byte[] v9_1;
        Intrinsics.checkNotNullParameter(arg9, "source");
        Intrinsics.checkNotNullParameter(arg10, "destination");
        if((arg9 instanceof String)) {
            this.checkSourceBounds$kotlin_stdlib(((String)arg9).length(), arg12, arg13);
            String v9 = ((String)arg9).substring(arg12, arg13);
            Intrinsics.checkNotNullExpressionValue(v9, "substring(...)");
            Charset v12 = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type java.lang.String");
            v9_1 = v9.getBytes(v12);
            Intrinsics.checkNotNullExpressionValue(v9_1, "getBytes(...)");
        }
        else {
            v9_1 = this.charsToBytesImpl$kotlin_stdlib(arg9, arg12, arg13);
        }

        return Base64.decodeIntoByteArray$default(this, v9_1, arg10, arg11, 0, 0, 24, null);
    }

    public final int decodeIntoByteArray(byte[] arg3, byte[] arg4, int arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "destination");
        this.checkSourceBounds$kotlin_stdlib(arg3.length, arg6, arg7);
        this.checkDestinationBounds(arg4.length, arg5, this.decodeSize$kotlin_stdlib(arg3, arg6, arg7));
        return this.decodeImpl(arg3, arg4, arg5, arg6, arg7);
    }

    public static int decodeIntoByteArray$default(Base64 arg1, CharSequence arg2, byte[] arg3, int arg4, int arg5, int arg6, int arg7, Object arg8) {
        if(arg8 == null) {
            if((arg7 & 16) != 0) {
                arg6 = arg2.length();
            }

            return arg1.decodeIntoByteArray(arg2, arg3, 0, 0, arg6);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static int decodeIntoByteArray$default(Base64 arg1, byte[] arg2, byte[] arg3, int arg4, int arg5, int arg6, int arg7, Object arg8) {
        if(arg8 == null) {
            if((arg7 & 16) != 0) {
                arg6 = arg2.length;
            }

            return arg1.decodeIntoByteArray(arg2, arg3, 0, 0, arg6);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeSize$kotlin_stdlib(byte[] arg3, int arg4, int arg5) {
        int v2;
        Intrinsics.checkNotNullParameter(arg3, "source");
        int v0 = arg5 - arg4;
        if(v0 == 0) {
            return 0;
        }

        if(v0 != 1) {
            if(this.isMimeScheme) {
                while(arg4 < arg5) {
                    v2 = Base64Kt.access$getBase64DecodeMap$p()[arg3[arg4] & 0xFF];
                    if(v2 < 0) {
                        if(v2 == -2) {
                            v0 -= arg5 - arg4;
                            break;
                        }
                        else {
                            --v0;
                        }
                    }

                    ++arg4;
                }
            }
            else {
                arg4 = 61;
                if(arg3[arg5 - 1] != arg4) {
                    goto label_35;
                }

                v2 = v0 - 1;
                if(arg3[arg5 - 2] == arg4) {
                    v0 += -2;
                    goto label_35;
                }

                v0 = v2;
            }

        label_35:
            return ((int)((((long)v0)) * 6 / 8));
        }

        throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + arg4 + ", endIndex: " + arg5);
    }

    public final String encode(byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        return new String(this.encodeToByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4), Charsets.ISO_8859_1);
    }

    public static String encode$default(Base64 arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg1.length;
            }

            return arg0.encode(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public final int encodeIntoByteArray(byte[] arg2, byte[] arg3, int arg4, int arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        return this.encodeIntoByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4, arg5, arg6);
    }

    public static int encodeIntoByteArray$default(Base64 arg1, byte[] arg2, byte[] arg3, int arg4, int arg5, int arg6, int arg7, Object arg8) {
        if(arg8 == null) {
            if((arg7 & 16) != 0) {
                arg6 = arg2.length;
            }

            return arg1.encodeIntoByteArray(arg2, arg3, 0, 0, arg6);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] arg18, byte[] arg19, int arg20, int arg21, int arg22) {
        int v1_1;
        int v10;
        Base64 v0 = this;
        byte[] v1 = arg18;
        byte[] v2 = arg19;
        int v3 = arg20;
        int v4 = arg21;
        int v5 = arg22;
        Intrinsics.checkNotNullParameter(v1, "source");
        Intrinsics.checkNotNullParameter(v2, "destination");
        v0.checkSourceBounds$kotlin_stdlib(v1.length, v4, v5);
        v0.checkDestinationBounds(v2.length, v3, v0.encodeSize$kotlin_stdlib(v5 - v4));
        byte[] v6 = v0.isUrlSafe ? Base64Kt.access$getBase64UrlEncodeMap$p() : Base64Kt.access$getBase64EncodeMap$p();
        int v7 = v0.isMimeScheme ? v0.mimeGroupsPerLine : 0x7FFFFFFF;
        int v8 = v3;
        while(v4 + 2 < v5) {
            int v9 = Math.min((v5 - v4) / 3, v7);
            int v12;
            for(v12 = 0; v12 < v9; ++v12) {
                int v14 = v1[v4] & 0xFF;
                int v15 = v4 + 2;
                int v13 = v1[v4 + 1] & 0xFF;
                v4 += 3;
                v13 = v13 << 8 | v14 << 16 | v1[v15] & 0xFF;
                v2[v8] = v6[v13 >>> 18];
                v2[v8 + 1] = v6[v13 >>> 12 & 0x3F];
                v14 = v8 + 3;
                v2[v8 + 2] = v6[v13 >>> 6 & 0x3F];
                v8 += 4;
                v2[v14] = v6[v13 & 0x3F];
            }

            if(v9 != v7) {
                continue;
            }

            if(v4 == v5) {
                continue;
            }

            v9 = v8 + 1;
            byte[] v12_1 = Base64.mimeLineSeparatorSymbols;
            v2[v8] = v12_1[0];
            v8 += 2;
            v2[v9] = v12_1[1];
        }

        v7 = v5 - v4;
        byte v9_1 = 61;
        if(v7 != 1) {
            v10 = 2;
            if(v7 != v10) {
            }
            else {
                v7 = v4 + 1;
                int v11 = v1[v4] & 0xFF;
                v4 += 2;
                v1_1 = (v1[v7] & 0xFF) << v10 | v11 << 10;
                v2[v8] = v6[v1_1 >>> 12];
                v2[v8 + 1] = v6[v1_1 >>> 6 & 0x3F];
                v7 = v8 + 3;
                v2[v8 + 2] = v6[v1_1 & 0x3F];
                if(v0.shouldPadOnEncode()) {
                    v8 += 4;
                    v2[v7] = v9_1;
                }
                else {
                    v8 = v7;
                }
            }
        }
        else {
            v7 = v4 + 1;
            v1_1 = (v1[v4] & 0xFF) << 4;
            v2[v8] = v6[v1_1 >>> 6];
            v10 = v8 + 2;
            v2[v8 + 1] = v6[v1_1 & 0x3F];
            if(v0.shouldPadOnEncode()) {
                int v0_1 = v8 + 3;
                v2[v10] = v9_1;
                v8 += 4;
                v2[v0_1] = v9_1;
                v4 = v7;
            }
            else {
                v4 = v7;
                v8 = v10;
            }
        }

        if(v4 == v5) {
            return v8 - v3;
        }

        throw new IllegalStateException("Check failed.");
    }

    public final int encodeSize$kotlin_stdlib(int arg4) {
        int v0 = arg4 / 3;
        arg4 %= 3;
        int v1 = 4;
        v0 *= v1;
        if(arg4 != 0) {
            if(this.shouldPadOnEncode()) {
            }
            else {
                v1 = arg4 + 1;
            }

            v0 += v1;
        }

        String v4 = "Input is too big";
        if(v0 >= 0) {
            if(this.isMimeScheme) {
                v0 += (v0 - 1) / this.mimeLineLength * 2;
            }

            if(v0 >= 0) {
                return v0;
            }

            throw new IllegalArgumentException(v4);
        }

        throw new IllegalArgumentException(v4);
    }

    @IgnorableReturnValue public final Appendable encodeToAppendable(byte[] arg2, Appendable arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        arg3.append(new String(this.encodeToByteArrayImpl$kotlin_stdlib(arg2, arg4, arg5), Charsets.ISO_8859_1));
        return arg3;
    }

    public static Appendable encodeToAppendable$default(Base64 arg0, byte[] arg1, Appendable arg2, int arg3, int arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 8) != 0) {
                arg4 = arg1.length;
            }

            return arg0.encodeToAppendable(arg1, arg2, 0, arg4);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public final byte[] encodeToByteArray(byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        return this.encodeToByteArrayImpl$kotlin_stdlib(arg2, arg3, arg4);
    }

    public static byte[] encodeToByteArray$default(Base64 arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg1.length;
            }

            return arg0.encodeToByteArray(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "source");
        this.checkSourceBounds$kotlin_stdlib(arg8.length, arg9, arg10);
        byte[] v3 = new byte[this.encodeSize$kotlin_stdlib(arg10 - arg9)];
        this.encodeIntoByteArrayImpl$kotlin_stdlib(arg8, v3, 0, arg9, arg10);
        return v3;
    }

    public final int getMimeLineLength$kotlin_stdlib() {
        return this.mimeLineLength;
    }

    public final PaddingOption getPaddingOption$kotlin_stdlib() {
        return this.paddingOption;
    }

    private final int handlePaddingSymbol(byte[] arg2, int arg3, int arg4, int arg5) {
        if(arg5 != -8) {
            if(arg5 != -6) {
                if(arg5 != -4) {
                    if(arg5 == -2) {
                        return arg3 + 1;
                    }

                    throw new IllegalStateException("Unreachable".toString());
                }

                this.checkPaddingIsAllowed(arg3);
                int v1 = this.skipIllegalSymbolsIfMime(arg2, arg3 + 1, arg4);
                if(v1 != arg4 && arg2[v1] == 61) {
                    return v1 + 1;
                }

                throw new IllegalArgumentException("Missing one pad character at index " + v1);
            }

            this.checkPaddingIsAllowed(arg3);
            return arg3 + 1;
        }

        throw new IllegalArgumentException("Redundant pad character at index " + arg3);
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    private final boolean shouldPadOnEncode() {
        if(this.paddingOption != PaddingOption.PRESENT) {
            if(this.paddingOption == PaddingOption.PRESENT_OPTIONAL) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final int skipIllegalSymbolsIfMime(byte[] arg2, int arg3, int arg4) {
        if(!this.isMimeScheme) {
            return arg3;
        }

        while(arg3 < arg4) {
            if(Base64Kt.access$getBase64DecodeMap$p()[arg2[arg3] & 0xFF] != -1) {
            }
            else {
                ++arg3;
                continue;
            }

            return arg3;
        }

        return arg3;
    }

    public final Base64 withPadding(PaddingOption arg4) {
        Intrinsics.checkNotNullParameter(arg4, "option");
        if(this.paddingOption == arg4) {
            return this;
        }

        return new Base64(this.isUrlSafe, this.isMimeScheme, this.mimeLineLength, arg4);
    }
}

