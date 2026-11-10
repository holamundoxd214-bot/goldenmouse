package kotlin.uuid;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.ULong;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Clock$System;
import kotlin.time.Clock;
import kotlin.time.Instant;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u00010B\u0019\bB\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ]\u0010\u000F\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J]\u0010\u0016\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J\n\u0010\u0018\u001A\u00020\u0019H\u0096\u0080\u0004J\n\u0010\u001A\u001A\u00020\u0019H\u0087\u0080\u0004J\n\u0010\u001B\u001A\u00020\u0019H\u0086\u0080\u0004J\n\u0010\u001C\u001A\u00020\u001DH\u0086\u0080\u0004J\u0011\u0010\u001E\u001A\u00020\u001FH\u0087\u0080\u0004¢\u0006\u0004\b \u0010!J\u0014\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%H\u0096\u0082\u0004J\u0012\u0010&\u001A\u00020\'2\u0006\u0010$\u001A\u00020\u0000H\u0097\u0082\u0004J\n\u0010(\u001A\u00020\'H\u0096\u0080\u0004J\n\u0010)\u001A\u00020%H\u0082\u0080\u0004J\u001B\u0010*\u001A\u00020+2\n\u0010,\u001A\u00060-j\u0002`.H\u0082\u0080\u0004¢\u0006\u0002\u0010/R\u001D\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fR\u001D\u0010\u0006\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\n\u001A\u0004\b\u000E\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, d2={"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toULongs", "Lkotlin/ULong;", "toString", "", "toHexDashString", "toHexString", "toByteArray", "", "toUByteArray", "Lkotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "equals", "", "other", "", "compareTo", "", "hashCode", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Uuid implements Serializable, Comparable {
    @Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0086\u0080\u0004J!\u0010\u000F\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u0010H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0015H\u0086\u0080\u0004J\u0019\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0018H\u0087\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u0012\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u001DH\u0086\u0080\u0004J\u0014\u0010\u001E\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001C\u001A\u00020\u001DH\u0087\u0080\u0004J\u0012\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u001DH\u0087\u0080\u0004J\u0014\u0010!\u001A\u0004\u0018\u00010\u00052\u0006\u0010 \u001A\u00020\u001DH\u0087\u0080\u0004J\u0012\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u001DH\u0086\u0080\u0004J\u0014\u0010$\u001A\u0004\u0018\u00010\u00052\u0006\u0010#\u001A\u00020\u001DH\u0087\u0080\u0004J\n\u0010%\u001A\u00020\u0005H\u0086\u0080\u0004J\n\u0010&\u001A\u00020\u0005H\u0087\u0080\u0004J\n\u0010\'\u001A\u00020\u0005H\u0087\u0080\u0004J\u0012\u0010(\u001A\u00020\u00052\u0006\u0010)\u001A\u00020*H\u0087\u0080\u0004J\u0017\u0010\'\u001A\u00020\u00052\u0006\u0010+\u001A\u00020,H\u0080\u0080\u0004¢\u0006\u0002\b-R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000F\u0010\b\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R+\u0010.\u001A\u0012\u0012\u0004\u0012\u00020\u00050/j\b\u0012\u0004\u0012\u00020\u0005`08FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b1\u0010\u0003\u001A\u0004\b2\u00103¨\u00064"}, d2={"Lkotlin/uuid/Uuid$Companion;", "", "<init>", "()V", "NIL", "Lkotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", "", "SIZE_BITS", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", "", "fromUByteArray", "ubyteArray", "Lkotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "parse", "uuidString", "", "parseOrNull", "parseHexDash", "hexDashString", "parseHexDashOrNull", "parseHex", "hexString", "parseHexOrNull", "random", "generateV4", "generateV7", "generateV7NonMonotonicAt", "timestamp", "Lkotlin/time/Instant;", "clock", "Lkotlin/time/Clock;", "generateV7$kotlin_stdlib", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Uuid fromByteArray(byte[] arg5) {
            Intrinsics.checkNotNullParameter(arg5, "byteArray");
            if(arg5.length == 16) {
                return this.fromLongs(UuidKt.getLongAt(arg5, 0), UuidKt.getLongAt(arg5, 8));
            }

            throw new IllegalArgumentException("Expected exactly 16 bytes, but was " + UuidKt__UuidKt.access$truncateForErrorMessage(arg5, 0x20) + " of size " + arg5.length.toString());
        }

        public final Uuid fromLongs(long arg7, long arg9) {
            long v0 = 0;
            if(arg7 == v0 && arg9 == v0) {
                return this.getNIL();
            }

            return new Uuid(arg7, arg9, null);
        }

        public final Uuid fromUByteArray-GBYM_sE(byte[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "ubyteArray");
            return this.fromByteArray(arg2);
        }

        public final Uuid fromULongs-eb3DHEI(long arg1, long arg3) {
            return this.fromLongs(arg1, arg3);
        }

        public final Uuid generateV4() {
            return UuidKt.secureRandomUuid();
        }

        public final Uuid generateV7() {
            return this.generateV7$kotlin_stdlib(System.INSTANCE);
        }

        public final Uuid generateV7$kotlin_stdlib(Clock arg1) {
            Intrinsics.checkNotNullParameter(arg1, "clock");
            return UuidV7Generator.INSTANCE.generate(arg1);
        }

        public final Uuid generateV7NonMonotonicAt(Instant arg7) {
            Intrinsics.checkNotNullParameter(arg7, "timestamp");
            byte[] v0 = new byte[10];
            UuidKt.secureRandomBytes(v0);
            long v1 = arg7.toEpochMilliseconds() << 16 | (((long)((v0[8] & 15 | 0x70) << 8 | v0[9] & 0xFF)));
            v0[0] = ((byte)((((byte)(v0[0] & 0x3F))) | 0xFFFFFF80));
            return this.fromLongs(v1, UuidKt.getLongAt(v0, 0));
        }

        public final Comparator getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }

        @Deprecated(message="Use naturalOrder<Uuid>() instead", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="2.1") public static void getLEXICAL_ORDER$annotations() {
        }

        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        public final Uuid parse(String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "uuidString");
            int v2 = arg3.length();
            if(v2 != 0x20) {
                if(v2 == 36) {
                    return UuidKt.uuidParseHexDash(arg3);
                }

                throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.access$truncateForErrorMessage(arg3, 0x40) + "\" of length " + arg3.length());
            }

            return UuidKt.uuidParseHex(arg3);
        }

        public final Uuid parseHex(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "hexString");
            if(arg2.length() == 0x20) {
                return UuidKt.uuidParseHex(arg2);
            }

            throw new IllegalArgumentException("Expected a 32-char hexadecimal string, but was \"" + UuidKt__UuidKt.access$truncateForErrorMessage(arg2, 0x40) + "\" of length " + arg2.length().toString());
        }

        public final Uuid parseHexDash(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "hexDashString");
            if(arg2.length() == 36) {
                return UuidKt.uuidParseHexDash(arg2);
            }

            throw new IllegalArgumentException("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"" + UuidKt__UuidKt.access$truncateForErrorMessage(arg2, 0x40) + "\" of length " + arg2.length().toString());
        }

        public final Uuid parseHexDashOrNull(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "hexDashString");
            if(arg2.length() != 36) {
                return null;
            }

            return UuidKt.uuidParseHexDashOrNull(arg2);
        }

        public final Uuid parseHexOrNull(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "hexString");
            if(arg2.length() != 0x20) {
                return null;
            }

            return UuidKt.uuidParseHexOrNull(arg2);
        }

        public final Uuid parseOrNull(String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "uuidString");
            int v0 = arg3.length();
            if(v0 != 0x20) {
                if(v0 != 36) {
                    return null;
                }

                return this.parseHexDashOrNull(arg3);
            }

            return this.parseHexOrNull(arg3);
        }

        public final Uuid random() {
            return this.generateV4();
        }
    }

    public static final Companion Companion = null;
    private static final Uuid NIL = null;
    public static final int SIZE_BITS = 0x80;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    static {
        Uuid.Companion = new Companion(null);
        Uuid.NIL = new Uuid(0, 0);
    }

    private Uuid(long arg1, long arg3) {
        super();
        this.mostSignificantBits = arg1;
        this.leastSignificantBits = arg3;
    }

    public Uuid(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    public static final Uuid access$getNIL$cp() {
        return Uuid.NIL;
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((Uuid)arg1));
    }

    public int compareTo(Uuid arg5) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        long v0 = this.mostSignificantBits;
        if(v0 != arg5.mostSignificantBits) {
            return Long.compareUnsigned(ULong.constructor-impl(v0), ULong.constructor-impl(arg5.mostSignificantBits));
        }

        return Long.compareUnsigned(ULong.constructor-impl(this.leastSignificantBits), ULong.constructor-impl(arg5.leastSignificantBits));
    }

    public boolean equals(Object arg8) {
        if(this == (((Uuid)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Uuid)) {
            return 0;
        }

        if(this.mostSignificantBits == ((Uuid)arg8).mostSignificantBits && this.leastSignificantBits == ((Uuid)arg8).leastSignificantBits) {
            return 1;
        }

        return 0;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public static void getLeastSignificantBits$annotations() {
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public static void getMostSignificantBits$annotations() {
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public final byte[] toByteArray() {
        byte[] v0 = new byte[16];
        UuidKt.setLongAt(v0, 0, this.mostSignificantBits);
        UuidKt.setLongAt(v0, 8, this.leastSignificantBits);
        return v0;
    }

    public final String toHexDashString() {
        byte[] v3 = new byte[36];
        UuidKt.formatBytesInto(this.mostSignificantBits, v3, 0, 0, 4);
        v3[8] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, v3, 9, 4, 6);
        v3[13] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, v3, 14, 6, 8);
        v3[18] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, v3, 19, 0, 2);
        v3[23] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, v3, 24, 2, 8);
        return StringsKt.decodeToString(v3);
    }

    public final String toHexString() {
        byte[] v3 = new byte[0x20];
        UuidKt.formatBytesInto(this.mostSignificantBits, v3, 0, 0, 8);
        UuidKt.formatBytesInto(this.leastSignificantBits, v3, 16, 0, 8);
        return StringsKt.decodeToString(v3);
    }

    private final Object toLongs(Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        return arg4.invoke(Long.valueOf(this.getMostSignificantBits()), Long.valueOf(this.getLeastSignificantBits()));
    }

    public String toString() {
        return this.toHexDashString();
    }

    public final byte[] toUByteArray-TcUX1vc() {
        return UByteArray.constructor-impl(this.toByteArray());
    }

    private final Object toULongs(Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        return arg4.invoke(ULong.box-impl(ULong.constructor-impl(this.getMostSignificantBits())), ULong.box-impl(ULong.constructor-impl(this.getLeastSignificantBits())));
    }

    private final Object writeReplace() {
        return UuidKt.serializedUuid(this);
    }
}

