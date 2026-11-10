package okio;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0000\u001A\u00020\u0003*\u00020\u0004\u001A\r\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0002\b\u0006\u001AN\u0010\u0007\u001A\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000B\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000F"}, d2={"buffer", "Lokio/BufferedSource;", "Lokio/Source;", "Lokio/BufferedSink;", "Lokio/Sink;", "blackholeSink", "blackhole", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k=5, mv={2, 1, 0}, xi=0x30, xs="okio/Okio") final class Okio__OkioKt {
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSink buffer(Sink arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new RealBufferedSink(arg1);
    }

    public static final BufferedSource buffer(Source arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new RealBufferedSource(arg1);
    }

    public static final Object use(Closeable arg2, Function1 arg3) {
        Object v3_1;
        Intrinsics.checkNotNullParameter(arg3, "block");
        Throwable v0 = null;
        try {
            v3_1 = arg3.invoke(arg2);
            if(arg2 == null) {
                goto label_8;
            }
        }
        catch(Throwable v3) {
            if(arg2 == null) {
                goto label_18;
            }

            try {
                arg2.close();
            }
            catch(Throwable v2) {
                ExceptionsKt.addSuppressed(v3, v2);
            }

            goto label_18;
        }

        try {
            arg2.close();
        }
        catch(Throwable v0) {
        }

    label_8:
        Throwable v1 = v0;
        Object v0_1 = v3_1;
        v3 = v1;
    label_18:
        if(v3 == null) {
            return v0_1;
        }

        throw v3;
    }
}

