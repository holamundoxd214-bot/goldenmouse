package kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0080\u0080\u0004\u001A\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0081\u0080\u0004\u001A\u0016\u0010\b\u001A\u00020\t*\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0081\u0080\u0004\u001A.\u0010\f\u001A\u00020\u0001*\u00020\t2\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000BH\u0081\u0080\u0004\u001A\u001E\u0010\u0011\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\tH\u0081\u0080\u0004\u001A\u0012\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0014\u0010\u0016\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0012\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0014\u0010\u0019\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u000E\u0010\u001A\u001A\u00020\u0007*\u00020\u001BH\u0087\u0088\u0004\u001A\u000E\u0010\u001C\u001A\u00020\u001B*\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u001D\u001A\u00020\u0007*\u00020\u001EH\u0087\u0080\u0004\u001A\u0016\u0010\u001D\u001A\u00020\u0007*\u00020\u001E2\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0080\u0004\u001A\u0016\u0010\u001F\u001A\u00020\u001E*\u00020\u001E2\u0006\u0010\u0006\u001A\u00020\u0007H\u0087\u0080\b\u001A\u001E\u0010\u001F\u001A\u00020\u001E*\u00020\u001E2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0007H\u0087\u0080\b\u001A\u000E\u0010 \u001A\u00020\t*\u00020\tH\u0080\u0088\u0004¨\u0006!"}, d2={"secureRandomBytes", "", "destination", "", "serializedUuid", "", "uuid", "Lkotlin/uuid/Uuid;", "getLongAt", "", "index", "", "formatBytesInto", "dst", "dstOffset", "startIndex", "endIndex", "setLongAt", "value", "uuidParseHexDash", "hexDashString", "", "uuidParseHexDashOrNull", "uuidParseHex", "hexString", "uuidParseHexOrNull", "toKotlinUuid", "Ljava/util/UUID;", "toJavaUuid", "getUuid", "Ljava/nio/ByteBuffer;", "putUuid", "reverseBytes", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/uuid/UuidKt") class UuidKt__UuidJVMKt {
    public UuidKt__UuidJVMKt() {
        super();
    }

    public static final void formatBytesInto(long arg1, byte[] arg3, int arg4, int arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg3, "dst");
        UuidKt.formatBytesIntoCommonImpl(arg1, arg3, arg4, arg5, arg6);
    }

    public static final long getLongAt(byte[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UuidKt.getLongAtCommonImpl(arg1, arg2);
    }

    public static final Uuid getUuid(ByteBuffer arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        if(arg5.position() + 15 < arg5.limit()) {
            long v0 = arg5.getLong();
            long v2 = arg5.getLong();
            if(Intrinsics.areEqual(arg5.order(), ByteOrder.LITTLE_ENDIAN)) {
                v0 = Long.reverseBytes(v0);
                v2 = Long.reverseBytes(v2);
            }

            return Uuid.Companion.fromLongs(v0, v2);
        }

        throw new BufferUnderflowException();
    }

    public static final Uuid getUuid(ByteBuffer arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg5 >= 0) {
            if(arg5 + 15 < arg4.limit()) {
                long v0 = arg4.getLong(arg5);
                long v2 = arg4.getLong(arg5 + 8);
                if(Intrinsics.areEqual(arg4.order(), ByteOrder.LITTLE_ENDIAN)) {
                    v0 = Long.reverseBytes(v0);
                    v2 = Long.reverseBytes(v2);
                }

                return Uuid.Companion.fromLongs(v0, v2);
            }

            throw new IndexOutOfBoundsException("Not enough bytes to read a uuid at index: " + arg5 + ", with limit: " + arg4.limit() + ' ');
        }

        throw new IndexOutOfBoundsException("Negative index: " + arg5);
    }

    @IgnorableReturnValue public static final ByteBuffer putUuid(ByteBuffer arg5, int arg6, Uuid arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "uuid");
        long v0 = arg7.getMostSignificantBits();
        long v2 = arg7.getLeastSignificantBits();
        if(arg6 >= 0) {
            if(arg6 + 15 < arg5.limit()) {
                if(Intrinsics.areEqual(arg5.order(), ByteOrder.BIG_ENDIAN)) {
                    arg5.putLong(arg6, v0);
                    arg5 = arg5.putLong(arg6 + 8, v2);
                }
                else {
                    arg5.putLong(arg6, Long.reverseBytes(v0));
                    arg5 = arg5.putLong(arg6 + 8, Long.reverseBytes(v2));
                }

                Intrinsics.checkNotNullExpressionValue(arg5, "toLongs(...)");
                return arg5;
            }

            throw new IndexOutOfBoundsException("Not enough capacity to write a uuid at index: " + arg6 + ", with limit: " + arg5.limit() + ' ');
        }

        throw new IndexOutOfBoundsException("Negative index: " + arg6);
    }

    @IgnorableReturnValue public static final ByteBuffer putUuid(ByteBuffer arg5, Uuid arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "uuid");
        long v0 = arg6.getMostSignificantBits();
        long v2 = arg6.getLeastSignificantBits();
        if(arg5.position() + 15 < arg5.limit()) {
            if(Intrinsics.areEqual(arg5.order(), ByteOrder.BIG_ENDIAN)) {
                arg5.putLong(v0);
                arg5 = arg5.putLong(v2);
            }
            else {
                arg5.putLong(Long.reverseBytes(v0));
                arg5 = arg5.putLong(Long.reverseBytes(v2));
            }

            Intrinsics.checkNotNullExpressionValue(arg5, "toLongs(...)");
            return arg5;
        }

        throw new BufferOverflowException();
    }

    public static final long reverseBytes(long arg0) {
        return Long.reverseBytes(arg0);
    }

    public static final void secureRandomBytes(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "destination");
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(arg1);
    }

    public static final Object serializedUuid(Uuid arg5) {
        Intrinsics.checkNotNullParameter(arg5, "uuid");
        return new UuidSerialized(arg5.getMostSignificantBits(), arg5.getLeastSignificantBits());
    }

    public static final void setLongAt(byte[] arg1, int arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        UuidKt.setLongAtCommonImpl(arg1, arg2, arg3);
    }

    public static final UUID toJavaUuid(Uuid arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        return new UUID(arg4.getMostSignificantBits(), arg4.getLeastSignificantBits());
    }

    public static final Uuid toKotlinUuid(UUID arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        return Uuid.Companion.fromLongs(arg5.getMostSignificantBits(), arg5.getLeastSignificantBits());
    }

    public static final Uuid uuidParseHex(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "hexString");
        return UuidKt.uuidParseHexCommonImpl(arg1);
    }

    public static final Uuid uuidParseHexDash(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "hexDashString");
        return UuidKt.uuidParseHexDashCommonImpl(arg1);
    }

    public static final Uuid uuidParseHexDashOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "hexDashString");
        return UuidKt.uuidParseHexDashOrNullCommonImpl(arg1);
    }

    public static final Uuid uuidParseHexOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "hexString");
        return UuidKt.uuidParseHexOrNullCommonImpl(arg1);
    }
}

