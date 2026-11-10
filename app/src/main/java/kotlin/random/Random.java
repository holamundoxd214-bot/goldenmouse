package kotlin.random;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\'\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H¦\u0080\u0004J\n\u0010\u0007\u001A\u00020\u0005H\u0096\u0080\u0004J\u0012\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005H\u0096\u0080\u0004J\u001A\u0010\u0007\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005H\u0096\u0080\u0004J\n\u0010\n\u001A\u00020\u000BH\u0096\u0080\u0004J\u0012\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u000BH\u0096\u0080\u0004J\u001A\u0010\n\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u000BH\u0096\u0080\u0004J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\u0012\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u000FH\u0096\u0080\u0004J\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u000FH\u0096\u0080\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J&\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u0005H\u0097\u0080\bJ\u0012\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0013H\u0097\u0080\bJ\u0012\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0019"}, d2={"Lkotlin/random/Random;", "", "<init>", "()V", "nextBits", "", "bitCount", "nextInt", "until", "from", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "Default", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class Random {
    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001#B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001A\u00020\bH\u0082\u0080\u0004J\u001B\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u00060\fj\u0002`\rH\u0082\u0080\u0004¢\u0006\u0002\u0010\u000EJ\u0012\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0012\u001A\u00020\u0010H\u0096\u0080\u0004J\u0012\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0010H\u0096\u0080\u0004J\u001A\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0015\u001A\u00020\u0016H\u0096\u0080\u0004J\u0012\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\u0016H\u0096\u0080\u0004J\u001A\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\u0012\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u001AH\u0096\u0080\u0004J\u001A\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u001AH\u0096\u0080\u0004J\n\u0010\u001B\u001A\u00020\u001CH\u0096\u0080\u0004J\u0012\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001EH\u0097\u0080\bJ\u0012\u0010\u001D\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u0010H\u0096\u0080\u0004J\"\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u0010H\u0096\u0080\bR\u000F\u0010\u0006\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "defaultRandom", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "nextBits", "", "bitCount", "nextInt", "until", "from", "nextLong", "", "nextBoolean", "", "nextDouble", "", "nextFloat", "", "nextBytes", "", "array", "size", "fromIndex", "toIndex", "Serialized", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Default extends Random implements Serializable {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001A\u00020\bH\u0082\u0080\u0004R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Serialized implements Serializable {
            public static final Serialized INSTANCE;
            private static final long serialVersionUID;

            static {
                Serialized.INSTANCE = new Serialized();
            }

            private Serialized() {
                super();
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public Default(DefaultConstructorMarker arg1) {
            this();
        }

        private Default() {
            super();
        }

        public int nextBits(int arg1) {
            return Random.defaultRandom.nextBits(arg1);
        }

        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        public byte[] nextBytes(int arg1) {
            return Random.defaultRandom.nextBytes(arg1);
        }

        @IgnorableReturnValue public byte[] nextBytes(byte[] arg1) {
            Intrinsics.checkNotNullParameter(arg1, "array");
            return Random.defaultRandom.nextBytes(arg1);
        }

        public byte[] nextBytes(byte[] arg1, int arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg1, "array");
            return Random.defaultRandom.nextBytes(arg1, arg2, arg3);
        }

        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        public double nextDouble(double arg1) {
            return Random.defaultRandom.nextDouble(arg1);
        }

        public double nextDouble(double arg1, double arg3) {
            return Random.defaultRandom.nextDouble(arg1, arg3);
        }

        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        public int nextInt(int arg1) {
            return Random.defaultRandom.nextInt(arg1);
        }

        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        public int nextInt(int arg1, int arg2) {
            return Random.defaultRandom.nextInt(arg1, arg2);
        }

        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        public long nextLong(long arg1) {
            return Random.defaultRandom.nextLong(arg1);
        }

        public long nextLong(long arg1, long arg3) {
            return Random.defaultRandom.nextLong(arg1, arg3);
        }

        private final void readObject(ObjectInputStream arg1) {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }
    }

    public static final Default Default;
    private static final Random defaultRandom;

    static {
        Random.Default = new Default(null);
        Random.defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public Random() {
        super();
    }

    public static final Random access$getDefaultRandom$cp() {
        return Random.defaultRandom;
    }

    public abstract int nextBits(int arg1);

    public boolean nextBoolean() {
        if(this.nextBits(1) != 0) {
            return 1;
        }

        return 0;
    }

    @IgnorableReturnValue public byte[] nextBytes(byte[] arg7, int arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg7, "array");
        String v0 = "fromIndex (";
        if(arg8 >= 0 && arg8 <= arg7.length && arg9 >= 0 && arg9 <= arg7.length) {
            if(arg8 <= arg9) {
                int v0_1 = (arg9 - arg8) / 4;
                int v1 = 0;
                int v2;
                for(v2 = 0; v2 < v0_1; ++v2) {
                    int v3 = this.nextInt();
                    arg7[arg8] = ((byte)v3);
                    arg7[arg8 + 1] = ((byte)(v3 >>> 8));
                    arg7[arg8 + 2] = ((byte)(v3 >>> 16));
                    arg7[arg8 + 3] = ((byte)(v3 >>> 24));
                    arg8 += 4;
                }

                arg9 -= arg8;
                int v6 = this.nextBits(arg9 * 8);
                while(v1 < arg9) {
                    arg7[arg8 + v1] = ((byte)(v6 >>> v1 * 8));
                    ++v1;
                }

                return arg7;
            }
            else {
                throw new IllegalArgumentException(v0 + arg8 + ") must be not greater than toIndex (" + arg9 + ").".toString());
            }
        }

        throw new IllegalArgumentException(v0 + arg8 + ") or toIndex (" + arg9 + ") are out of range: 0.." + arg7.length + '.'.toString());
    }

    public byte[] nextBytes(int arg1) {
        return this.nextBytes(new byte[arg1]);
    }

    @IgnorableReturnValue public byte[] nextBytes(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "array");
        return this.nextBytes(arg3, 0, arg3.length);
    }

    public static byte[] nextBytes$default(Random arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 4) != 0) {
                arg3 = arg1.length;
            }

            return arg0.nextBytes(arg1, 0, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(this.nextBits(26), this.nextBits(27));
    }

    public double nextDouble(double arg3) {
        return this.nextDouble(0, arg3);
    }

    public double nextDouble(double arg7, double arg9) {
        RandomKt.checkRangeBounds(arg7, arg9);
        double v0 = arg9 - arg7;
        if(Double.isInfinite(v0)) {
            double v4 = 1.797693E+308;
            if(Math.abs(arg7) > v4) {
                goto label_18;
            }
            else if(Math.abs(arg9) <= v4) {
                v0 = this.nextDouble() * (arg9 / 2 - arg7 / 2);
                arg7 = arg7 + v0 + v0;
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            arg7 += this.nextDouble() * v0;
        }

        if(arg7 >= arg9) {
            return Math.nextAfter(arg9, -Infinity);
        }

        return arg7;
    }

    public float nextFloat() {
        return (((float)this.nextBits(24))) / 16777216f;
    }

    public int nextInt(int arg2) {
        return this.nextInt(0, arg2);
    }

    public int nextInt() {
        return this.nextBits(0x20);
    }

    public int nextInt(int arg4, int arg5) {
        int v1;
        int v3;
        RandomKt.checkRangeBounds(arg4, arg5);
        int v0 = arg5 - arg4;
        if(v0 <= 0 && v0 != 0x80000000) {
            do {
            label_6:
                v0 = this.nextInt();
                if(arg4 > v0) {
                    goto label_6;
                }
            }
            while(v0 >= arg5);

            return v0;
        }

        if((-v0 & v0) == v0) {
            v3 = this.nextBits(RandomKt.fastLog2(v0));
        }
        else {
            do {
                arg5 = this.nextInt() >>> 1;
                v1 = arg5 % v0;
            }
            while(arg5 - v1 + (v0 - 1) < 0);

            v3 = v1;
        }

        return arg4 + v3;
    }

    public long nextLong() {
        return ((((long)this.nextInt())) << 0x20) + (((long)this.nextInt()));
    }

    public long nextLong(long arg3) {
        return this.nextLong(0, arg3);
    }

    public long nextLong(long arg10, long arg12) {
        long v5;
        int v9;
        RandomKt.checkRangeBounds(arg10, arg12);
        long v0 = arg12 - arg10;
        long v2 = 0;
        if(v0 > v2) {
            if(Long.compare(-v0 & v0, v0) == 0) {
                int v12 = ((int)v0);
                int v13 = 0x20;
                int v0_1 = ((int)(v0 >>> v13));
                long v1 = 0xFFFFFFFFL;
                if(v12 != 0) {
                    v9 = this.nextBits(RandomKt.fastLog2(v12));
                }
                else if(v0_1 == 1) {
                    v9 = this.nextInt();
                }
                else {
                    goto label_23;
                }

                arg12 = (((long)v9)) & v1;
                goto label_41;
            label_23:
                arg12 = ((((long)this.nextBits(RandomKt.fastLog2(v0_1)))) << v13) + ((((long)this.nextInt())) & v1);
            }
            else {
                do {
                    arg12 = this.nextLong() >>> 1;
                    v5 = arg12 % v0;
                }
                while(arg12 - v5 + (v0 - 1) < v2);

                arg12 = v5;
            }

        label_41:
            return arg10 + arg12;
        }

        do {
        label_43:
            v0 = this.nextLong();
            if(arg10 > v0) {
                goto label_43;
            }
        }
        while(v0 >= arg12);

        return v0;
    }
}

