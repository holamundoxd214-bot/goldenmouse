package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!BA\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BJX\u0010\u0014\u001A\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001A\u00020\u000326\u0010\u0017\u001A2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u0002H\u00150\u0018H\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001EJ\n\u0010\u001F\u001A\u00020 H\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0015\u0010\u0005\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0015\u0010\u0006\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0015\u0010\b\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0015\u0010\t\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2={"Lkotlin/time/UnboundLocalDateTime;", "", "year", "", "month", "day", "hour", "minute", "second", "nanosecond", "<init>", "(IIIIIII)V", "getYear", "()I", "getMonth", "getDay", "getHour", "getMinute", "getSecond", "getNanosecond", "toInstant", "T", "offsetSeconds", "buildInstant", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "epochSeconds", "nanosecondOfSecond", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class UnboundLocalDateTime {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004¨\u0006\b"}, d2={"Lkotlin/time/UnboundLocalDateTime$Companion;", "", "<init>", "()V", "fromInstant", "Lkotlin/time/UnboundLocalDateTime;", "instant", "Lkotlin/time/Instant;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final UnboundLocalDateTime fromInstant(Instant arg25) {
            Instant v1 = arg25;
            Intrinsics.checkNotNullParameter(v1, "instant");
            long v2 = v1.getEpochSeconds();
            long v4 = 86400;
            long v6 = v2 / v4;
            long v10 = 0;
            long v8 = -1;
            if(Long.compare(v2 ^ v4, v10) < 0 && v6 * v4 != v2) {
                v6 += v8;
            }

            v2 %= v4;
            int v0 = ((int)(v2 + (v4 & ((v2 ^ v4) & (-v2 | v2)) >> 0x3F)));
            v2 = 0xAFA6C + v6;
            long v12 = 146097;
            long v14 = 400;
            if(Long.compare(v2, v10) < 0) {
                v6 = (v6 + 0xAFA6D) / v12 - 1;
                v4 = v6 * v14;
                v2 += -v6 * v12;
            }
            else {
                v4 = v10;
            }

            v6 = (v14 * v2 + 0x24F) / v12;
            v12 = 365;
            long v18 = 4;
            long v20 = 100;
            long v16 = v2 - (v12 * v6 + v6 / v18 - v6 / v20 + v6 / v14);
            if(v16 < v10) {
                v6 += v8;
                v16 = v2 - (v12 * v6 + v6 / v18 - v6 / v20 + v6 / v14);
            }

            int v2_1 = ((int)v16);
            int v3 = (v2_1 * 5 + 2) / 0x99;
            int v12_1 = v0 / 3600;
            v0 -= v12_1 * 3600;
            int v13 = v0 / 60;
            return new UnboundLocalDateTime(((int)(v6 + v4 + (((long)(v3 / 10))))), (v3 + 2) % 12 + 1, v2_1 - (v3 * 306 + 5) / 10 + 1, v12_1, v13, v0 - v13 * 60, v1.getNanosecondsOfSecond());
        }
    }

    public static final Companion Companion;
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanosecond;
    private final int second;
    private final int year;

    static {
        UnboundLocalDateTime.Companion = new Companion(null);
    }

    public UnboundLocalDateTime(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        super();
        this.year = arg1;
        this.month = arg2;
        this.day = arg3;
        this.hour = arg4;
        this.minute = arg5;
        this.second = arg6;
        this.nanosecond = arg7;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getYear() {
        return this.year;
    }

    public final Object toInstant(int arg11, Function2 arg12) {
        Intrinsics.checkNotNullParameter(arg12, "buildInstant");
        long v0 = ((long)this.getYear());
        long v2 = 365 * v0;
        if(v0 >= 0) {
            v2 += (3 + v0) / 4 - (99 + v0) / 100 + (v0 + 0x18F) / 400;
        }
        else {
            v2 -= v0 / -4 - v0 / -100 + v0 / -400;
        }

        v2 = v2 + (((long)((this.getMonth() * 0x16F - 362) / 12))) + (((long)(this.getDay() - 1)));
        if(this.getMonth() > 2) {
            v0 = -1 + v2;
            if(!InstantKt.isLeapYear(this.getYear())) {
                v2 += -2;
            }
            else {
                v2 = v0;
            }
        }

        return arg12.invoke(Long.valueOf((v2 - 0xAFAA8) * 86400 + (((long)(this.getHour() * 3600 + this.getMinute() * 60 + this.getSecond()))) - (((long)arg11))), Integer.valueOf(this.getNanosecond()));
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.year + '-' + this.month + '-' + this.day + ' ' + this.hour + ':' + this.minute + ':' + this.second + '.' + this.nanosecond + ')';
    }
}

