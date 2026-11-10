package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\bB\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001A\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u000F"}, d2={"Lkotlin/time/DurationUnit;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "<init>", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "getTimeUnit$kotlin_stdlib", "()Ljava/util/concurrent/TimeUnit;", "NANOSECONDS", "MICROSECONDS", "MILLISECONDS", "SECONDS", "MINUTES", "HOURS", "DAYS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum DurationUnit {
    public static final enum DurationUnit DAYS;
    public static final enum DurationUnit HOURS;
    public static final enum DurationUnit MICROSECONDS;
    public static final enum DurationUnit MILLISECONDS;
    public static final enum DurationUnit MINUTES;
    public static final enum DurationUnit NANOSECONDS;
    public static final enum DurationUnit SECONDS;
    private final TimeUnit timeUnit;

    private static final DurationUnit[] $values() {
        return new DurationUnit[]{DurationUnit.NANOSECONDS, DurationUnit.MICROSECONDS, DurationUnit.MILLISECONDS, DurationUnit.SECONDS, DurationUnit.MINUTES, DurationUnit.HOURS, DurationUnit.DAYS};
    }

    static {
        DurationUnit.NANOSECONDS = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        DurationUnit.MICROSECONDS = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        DurationUnit.MILLISECONDS = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        DurationUnit.SECONDS = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
        DurationUnit.MINUTES = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
        DurationUnit.HOURS = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
        DurationUnit.DAYS = new DurationUnit("DAYS", 6, TimeUnit.DAYS);
        DurationUnit[] v0 = DurationUnit.$values();
        DurationUnit.$VALUES = v0;
        DurationUnit.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DurationUnit(String arg1, int arg2, TimeUnit arg3) {
        super(arg1, arg2);
        this.timeUnit = arg3;
    }

    public static EnumEntries getEntries() {
        return DurationUnit.$ENTRIES;
    }

    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }

    public static DurationUnit valueOf(String arg1) {
        return Enum.valueOf(DurationUnit.class, arg1);
    }

    public static DurationUnit[] values() {
        return DurationUnit.$VALUES.clone();
    }
}

