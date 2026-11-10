package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0014J\b\u0010\u000B\u001A\u00020\tH\u0016J\u0010\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u0010H\u0016R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000F\u0010\u0019\u001A\u00020\u000EX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lkotlin/random/Random;", "<init>", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "next", "", "bits", "nextInt", "bound", "nextBoolean", "", "nextLong", "", "nextFloat", "", "nextDouble", "", "nextBytes", "", "bytes", "", "seedInitialized", "setSeed", "seed", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class KotlinRandom extends Random {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/random/KotlinRandom$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion;
    private final kotlin.random.Random impl;
    private boolean seedInitialized;
    private static final long serialVersionUID;

    static {
        KotlinRandom.Companion = new Companion(null);
    }

    public KotlinRandom(kotlin.random.Random arg2) {
        Intrinsics.checkNotNullParameter(arg2, "impl");
        super();
        this.impl = arg2;
    }

    public final kotlin.random.Random getImpl() {
        return this.impl;
    }

    protected int next(int arg1) {
        return this.impl.nextBits(arg1);
    }

    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    public void nextBytes(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bytes");
        this.impl.nextBytes(arg2);
    }

    public double nextDouble() {
        return this.impl.nextDouble();
    }

    public float nextFloat() {
        return this.impl.nextFloat();
    }

    public int nextInt() {
        return this.impl.nextInt();
    }

    public int nextInt(int arg1) {
        return this.impl.nextInt(arg1);
    }

    public long nextLong() {
        return this.impl.nextLong();
    }

    public void setSeed(long arg1) {
        if(!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }

        throw new UnsupportedOperationException("Setting seed is not supported.");
    }
}

