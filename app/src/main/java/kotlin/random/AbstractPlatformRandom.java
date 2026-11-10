package kotlin.random;

import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\u000B\u001A\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0080\u0004J\u0012\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016H\u0097\u0080\bR\u0013\u0010\u0004\u001A\u00020\u0005X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "<init>", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextInt", "until", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractPlatformRandom extends Random {
    public AbstractPlatformRandom() {
        super();
    }

    public abstract java.util.Random getImpl();

    public int nextBits(int arg1) {
        return RandomKt.takeUpperBits(this.getImpl().nextInt(), arg1);
    }

    public boolean nextBoolean() {
        return this.getImpl().nextBoolean();
    }

    @IgnorableReturnValue public byte[] nextBytes(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        this.getImpl().nextBytes(arg2);
        return arg2;
    }

    public double nextDouble() {
        return this.getImpl().nextDouble();
    }

    public float nextFloat() {
        return this.getImpl().nextFloat();
    }

    public int nextInt() {
        return this.getImpl().nextInt();
    }

    public int nextInt(int arg1) {
        return this.getImpl().nextInt(arg1);
    }

    public long nextLong() {
        return this.getImpl().nextLong();
    }
}

