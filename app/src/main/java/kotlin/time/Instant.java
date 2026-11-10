package kotlin.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\'B\u0019\b@\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u000E\u001A\u00020\u0005H\u0086\u0080\u0004J\u0019\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0000H\u0096\u0082\u0004J\u0014\u0010\u001A\u001A\u00020\u001B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u001CH\u0096\u0082\u0004J\n\u0010\u001D\u001A\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001E\u001A\u00020\u001FH\u0096\u0080\u0004J\n\u0010 \u001A\u00020\u001CH\u0082\u0080\u0004J\u001B\u0010!\u001A\u00020\"2\n\u0010#\u001A\u00060$j\u0002`%H\u0082\u0080\u0004¢\u0006\u0002\u0010&R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\u0006\u001A\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006("}, d2={"Lkotlin/time/Instant;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "epochSeconds", "", "nanosecondsOfSecond", "", "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/Instant;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/Instant;)J", "compareTo", "equals", "", "", "hashCode", "toString", "", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Instant implements Serializable, Comparable {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001A\u00020\u0005H\u0087\u0080\u0004J\u0012\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0086\u0080\u0004J\u001C\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bH\u0086\u0080\u0004J\u001A\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0086\u0080\u0004J\u0012\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\u0080\u0004J\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\u0080\u0004R\u0015\u0010\u0011\u001A\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001A\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0016\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013R\u0015\u0010\u0018\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013¨\u0006\u001A"}, d2={"Lkotlin/time/Instant$Companion;", "", "<init>", "()V", "now", "Lkotlin/time/Instant;", "fromEpochMilliseconds", "epochMilliseconds", "", "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", "", "parse", "input", "", "parseOrNull", "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlin/time/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlin_stdlib", "MAX", "getMAX$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Instant fromEpochMilliseconds(long arg9) {
            long v0 = 1000;
            long v2 = arg9 / v0;
            if((arg9 ^ v0) < 0 && v2 * v0 != arg9) {
                --v2;
            }

            arg9 %= v0;
            int v9 = ((int)((arg9 + (v0 & ((arg9 ^ v0) & (-arg9 | arg9)) >> 0x3F)) * 1000000));
            if(v2 < -31557014167219200L) {
                return this.getMIN$kotlin_stdlib();
            }

            if(v2 > 0x701CD2FA9578FFL) {
                return this.getMAX$kotlin_stdlib();
            }

            return this.fromEpochSeconds(v2, v9);
        }

        public final Instant fromEpochSeconds(long arg3, int arg5) {
            return this.fromEpochSeconds(arg3, ((long)arg5));
        }

        public final Instant fromEpochSeconds(long arg11, long arg13) {
            long v0 = 1000000000;
            long v2 = arg13 / v0;
            long v6 = 0;
            if((arg13 ^ v0) < v6 && v2 * v0 != arg13) {
                --v2;
            }

            long v4 = arg11 + v2;
            if((arg11 ^ v4) < v6 && (v2 ^ arg11) >= v6) {
                if(arg11 > v6) {
                    return Instant.Companion.getMAX$kotlin_stdlib();
                }
                else {
                    return Instant.Companion.getMIN$kotlin_stdlib();
                }
            }

            if(v4 < -31557014167219200L) {
                return this.getMIN$kotlin_stdlib();
            }

            if(v4 > 0x701CD2FA9578FFL) {
                return this.getMAX$kotlin_stdlib();
            }

            arg13 %= v0;
            return new Instant(v4, ((int)(arg13 + (((arg13 ^ v0) & (-arg13 | arg13)) >> 0x3F & v0))));
        }

        public static Instant fromEpochSeconds$default(Companion arg0, long arg1, long arg3, int arg5, Object arg6) {
            if((arg5 & 2) != 0) {
                arg3 = 0;
            }

            return arg0.fromEpochSeconds(arg1, arg3);
        }

        public final Instant getDISTANT_FUTURE() {
            return this.fromEpochSeconds(3093527980800L, 0);
        }

        public final Instant getDISTANT_PAST() {
            return this.fromEpochSeconds(-3217862419201L, 0x3B9AC9FF);
        }

        public final Instant getMAX$kotlin_stdlib() {
            return Instant.MAX;
        }

        public final Instant getMIN$kotlin_stdlib() {
            return Instant.MIN;
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Use Clock.System.now() instead", replaceWith="<_subannotation>") public final Instant now() {
            throw new NotImplementedError(null, 1, null);
        }

        public final Instant parse(CharSequence arg1) {
            Intrinsics.checkNotNullParameter(arg1, "input");
            return InstantKt.access$parseIso(arg1).toInstant();
        }

        public final Instant parseOrNull(CharSequence arg1) {
            Intrinsics.checkNotNullParameter(arg1, "input");
            return InstantKt.access$parseIso(arg1).toInstantOrNull();
        }
    }

    public static final Companion Companion;
    private static final Instant MAX;
    private static final Instant MIN;
    private final long epochSeconds;
    private final int nanosecondsOfSecond;

    static {
        Instant.Companion = new Companion(null);
        Instant.MIN = new Instant(-31557014167219200L, 0);
        Instant.MAX = new Instant(0x701CD2FA9578FFL, 0x3B9AC9FF);
    }

    public Instant(long arg3, int arg5) {
        super();
        this.epochSeconds = arg3;
        this.nanosecondsOfSecond = arg5;
        if(-31557014167219200L <= arg3 && arg3 < 0x701CD2FA957900L) {
            return;
        }

        throw new IllegalArgumentException("Instant exceeds minimum or maximum instant".toString());
    }

    public static final Instant access$getMAX$cp() {
        return Instant.MAX;
    }

    public static final Instant access$getMIN$cp() {
        return Instant.MIN;
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((Instant)arg1));
    }

    public int compareTo(Instant arg5) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        int v0 = Intrinsics.compare(this.epochSeconds, arg5.epochSeconds);
        if(v0 != 0) {
            return v0;
        }

        return Intrinsics.compare(this.nanosecondsOfSecond, arg5.nanosecondsOfSecond);
    }

    public boolean equals(Object arg5) {
        if(this != (((Instant)arg5)) && (!(arg5 instanceof Instant) || this.epochSeconds != ((Instant)arg5).epochSeconds || this.nanosecondsOfSecond != ((Instant)arg5).nanosecondsOfSecond)) {
            return 0;
        }

        return 1;
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + this.nanosecondsOfSecond * 51;
    }

    public final Instant minus-LRDsOJo(long arg1) {
        return this.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(arg1));
    }

    public final long minus-UwyO8pc(Instant arg5) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        return Duration.plus-LRDsOJo(DurationKt.toDuration(this.epochSeconds - arg5.epochSeconds, DurationUnit.SECONDS), DurationKt.toDuration(this.nanosecondsOfSecond - arg5.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    public final Instant plus-LRDsOJo(long arg12) {
        long v0 = Duration.getInWholeSeconds-impl(arg12);
        int v2 = Duration.getNanosecondsComponent-impl(arg12);
        long v3 = 0;
        if(v0 == v3 && v2 == 0) {
            return this;
        }

        long v5 = this.epochSeconds;
        long v7 = v5 + v0;
        if((v5 ^ v7) < v3 && (v0 ^ v5) >= v3) {
            if(Duration.isPositive-impl(arg12)) {
                return Instant.MAX;
            }
            else {
                return Instant.MIN;
            }
        }

        return Instant.Companion.fromEpochSeconds(v7, this.nanosecondsOfSecond + v2);
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public final long toEpochMilliseconds() {
        long v4_1;
        long v10;
        int v4;
        long v0 = this.epochSeconds;
        long v2 = 0;
        int v5 = 1000000;
        long v6 = 1000;
        long v8 = 1;
        if(Long.compare(v0, v2) >= 0) {
            v4 = Long.compare(v0, v8);
            v8 = 0x7FFFFFFFFFFFFFFFL;
            if(v4 == 0) {
            }
            else if(v0 != v2) {
                v10 = v0 * v6;
                if(v10 / v6 == v0) {
                    v6 = v10;
                }
                else {
                    return v8;
                }
            }
            else {
                v6 = v2;
            }

            v0 = ((long)(this.nanosecondsOfSecond / v5));
            v4_1 = v6 + v0;
            if((v6 ^ v4_1) < v2 && (v0 ^ v6) >= v2) {
                return v8;
            }

            return v4_1;
        }

        v0 += v8;
        v4 = Long.compare(v0, v8);
        v8 = -9223372036854775808L;
        if(v4 == 0) {
        }
        else if(v0 != v2) {
            v10 = v0 * v6;
            if(v10 / v6 == v0) {
                v6 = v10;
            }
            else {
                return v8;
            }
        }
        else {
            v6 = v2;
        }

        v0 = ((long)(this.nanosecondsOfSecond / v5 - 1000));
        v4_1 = v6 + v0;
        if((v6 ^ v4_1) < v2 && (v0 ^ v6) >= v2) {
            return v8;
        }

        return v4_1;
    }

    public String toString() {
        return InstantKt.access$formatIso(this);
    }

    private final Object writeReplace() {
        return InstantJvmKt.serializedInstant(this);
    }
}

