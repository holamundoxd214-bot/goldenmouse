package kotlin.random;

import java.io.InvalidObjectException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0017B9\b@\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\fB\u0019\bP\u0012\u0006\u0010\r\u001A\u00020\u0005\u0012\u0006\u0010\u000E\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\u000FJ\n\u0010\u0010\u001A\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0082\u0080\u0004J\n\u0010\u0014\u001A\u00020\u0005H\u0096\u0080\u0004J\u0012\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005H\u0096\u0080\u0004R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "x", "", "y", "z", "w", "v", "addend", "<init>", "(IIIIII)V", "seed1", "seed2", "(II)V", "checkInvariants", "", "readResolve", "", "nextInt", "nextBits", "bitCount", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class XorWowRandom extends Random implements Serializable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/random/XorWowRandom$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion;
    private int addend;
    private static final long serialVersionUID;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        XorWowRandom.Companion = new Companion(null);
    }

    public XorWowRandom(int arg8, int arg9) {
        this(arg8, arg9, 0, 0, ~arg8, arg8 << 10 ^ arg9 >>> 4);
    }

    public XorWowRandom(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        super();
        this.x = arg1;
        this.y = arg2;
        this.z = arg3;
        this.w = arg4;
        this.v = arg5;
        this.addend = arg6;
        this.checkInvariants();
        for(arg1 = 0; arg1 < 0x40; ++arg1) {
            this.nextInt();
        }
    }

    private final void checkInvariants() {
        if((this.v | (this.x | this.y | this.z | this.w)) != 0) {
            return;
        }

        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    public int nextBits(int arg1) {
        return RandomKt.takeUpperBits(this.nextInt(), arg1);
    }

    public int nextInt() {
        int v0 = this.x ^ this.x >>> 2;
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int v1 = this.v;
        this.w = v1;
        v0 = v0 ^ v0 << 1 ^ v1 ^ v1 << 4;
        this.v = v0;
        v1 = this.addend + 0x587C5;
        this.addend = v1;
        return v0 + v1;
    }

    private final Object readResolve() {
        try {
            this.checkInvariants();
            return this;
        }
        catch(Throwable v2) {
            v2 = new InvalidObjectException(v2.getMessage()).initCause(v2);
            Intrinsics.checkNotNullExpressionValue(v2, "initCause(...)");
            throw v2;
        }
    }
}

