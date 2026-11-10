package kotlin.uuid;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Clock;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0087\u0080\u0004R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\nX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u0010"}, d2={"Lkotlin/uuid/UuidV7Generator;", "", "<init>", "()V", "TIMESTAMP_BIAS_BITS", "", "VERSION_MASK", "OVERFLOW_MASK", "", "timestampAndCounter", "Lkotlin/concurrent/atomics/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "generate", "Lkotlin/uuid/Uuid;", "clock", "Lkotlin/time/Clock;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class UuidV7Generator {
    public static final UuidV7Generator INSTANCE = null;
    private static final long OVERFLOW_MASK = 0x8000;
    private static final int TIMESTAMP_BIAS_BITS = 16;
    private static final int VERSION_MASK = 0x7000;
    private static final AtomicLong timestampAndCounter;

    static {
        UuidV7Generator.INSTANCE = new UuidV7Generator();
        UuidV7Generator.timestampAndCounter = new AtomicLong(0);
    }

    private UuidV7Generator() {
        super();
    }

    public final Uuid generate(Clock arg18) {
        long v6;
        Clock v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "clock");
        byte[] v0 = new byte[10];
        UuidKt.secureRandomBytes(v0);
        int v2 = (v0[8] & 7) << 8 | v0[9] & 0xFF | 0x7000;
        do {
            AtomicLong v3 = UuidV7Generator.timestampAndCounter;
            long v4 = v3.get();
            v6 = v1.now().toEpochMilliseconds();
            int v8 = 16;
            long v9 = v4 >>> v8;
            if(v9 < v6) {
                v6 = v6 << v8 | (((long)v2));
                if(!v3.compareAndSet(v4, v6)) {
                    continue;
                }
            }
            else {
                v6 = 1;
                long v11 = v4 + v6;
                v6 = (0x8000 & v11) != 0 ? v9 + v6 << v8 | (((long)v2)) : v11;
                if(!v3.compareAndSet(v4, v6)) {
                    continue;
                }
            }

            break;
        }
        while(true);

        v0[0] = ((byte)((((byte)(v0[0] & 0x3F))) | 0xFFFFFF80));
        return Uuid.Companion.fromLongs(v6, UuidKt.getLongAt(v0, 0));
    }
}

