package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0096\u0080\u0004J\u0012\u0010\f\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\rH\u0096\u0080\u0004J\u001A\u0010\f\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\u000FH\u0096\u0080\u0004R\u0015\u0010\u0004\u001A\u00020\u00058VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Lkotlin/random/jdk8/PlatformThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "<init>", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextInt", "", "from", "until", "nextLong", "", "nextDouble", "", "kotlin-stdlib-jdk8"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    public PlatformThreadLocalRandom() {
        super();
    }

    public Random getImpl() {
        ThreadLocalRandom v1 = ThreadLocalRandom.current();
        Intrinsics.checkNotNullExpressionValue(v1, "current(...)");
        return ((Random)v1);
    }

    public double nextDouble(double arg1) {
        return ThreadLocalRandom.current().nextDouble(arg1);
    }

    public int nextInt(int arg1, int arg2) {
        return ThreadLocalRandom.current().nextInt(arg1, arg2);
    }

    public long nextLong(long arg1) {
        return ThreadLocalRandom.current().nextLong(arg1);
    }

    public long nextLong(long arg1, long arg3) {
        return ThreadLocalRandom.current().nextLong(arg1, arg3);
    }
}

