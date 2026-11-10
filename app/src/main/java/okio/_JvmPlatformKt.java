package okio;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0000\u001A\f\u0010\b\u001A\u00060\u0007j\u0002`\tH\u0000\u001A:\u0010\n\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B*\u00060\u0007j\u0002`\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000E*\n\u0010\u0004\"\u00020\u00052\u00020\u0005*\n\u0010\u0006\"\u00020\u00072\u00020\u0007*\n\u0010\u000F\"\u00020\u00102\u00020\u0010*\n\u0010\u0011\"\u00020\u00122\u00020\u0012*\n\u0010\u0013\"\u00020\u00142\u00020\u0014*\n\u0010\u0015\"\u00020\u00162\u00020\u0016*\n\u0010\u0017\"\u00020\u00182\u00020\u0018*\n\u0010\u0019\"\u00020\u001A2\u00020\u001A*\n\u0010\u001B\"\u00020\u001C2\u00020\u001C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001D"}, d2={"toUtf8String", "", "", "asUtf8ToByteArray", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Lock", "Ljava/util/concurrent/locks/ReentrantLock;", "newLock", "Lokio/Lock;", "withLock", "T", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "IOException", "Ljava/io/IOException;", "ProtocolException", "Ljava/net/ProtocolException;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "Closeable", "Ljava/io/Closeable;", "Deflater", "Ljava/util/zip/Deflater;", "Inflater", "Ljava/util/zip/Inflater;", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = arg1.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
        return v1;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final String toUtf8String(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new String(arg2, Charsets.UTF_8);
    }

    public static final Object withLock(ReentrantLock arg1, Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        ((Lock)arg1).lock();
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            ((Lock)arg1).unlock();
            throw v2;
        }

        ((Lock)arg1).unlock();
        return v2_1;
    }
}

