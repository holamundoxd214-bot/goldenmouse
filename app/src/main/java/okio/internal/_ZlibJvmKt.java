package okio.internal;

import java.util.GregorianCalendar;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\u001A8\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011*\f\b\u0000\u0010\u0004\"\u00020\u00052\u00020\u0005¨\u0006\u0012"}, d2={"DEFAULT_COMPRESSION", "", "getDEFAULT_COMPRESSION", "()I", "CRC32", "Ljava/util/zip/CRC32;", "datePartsToEpochMillis", "", "year", "month", "day", "hour", "minute", "second", "EMPTY_BYTE_ARRAY", "", "getEMPTY_BYTE_ARRAY", "()[B", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class _ZlibJvmKt {
    private static final int DEFAULT_COMPRESSION = -1;
    private static final byte[] EMPTY_BYTE_ARRAY;

    static {
        _ZlibJvmKt.EMPTY_BYTE_ARRAY = new byte[0];
    }

    public static final long datePartsToEpochMillis(int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        GregorianCalendar v0 = new GregorianCalendar();
        v0.set(14, 0);
        v0.set(arg7, arg8 - 1, arg9, arg10, arg11, arg12);
        return v0.getTime().getTime();
    }

    public static final int getDEFAULT_COMPRESSION() {
        return _ZlibJvmKt.DEFAULT_COMPRESSION;
    }

    public static final byte[] getEMPTY_BYTE_ARRAY() {
        return _ZlibJvmKt.EMPTY_BYTE_ARRAY;
    }
}

