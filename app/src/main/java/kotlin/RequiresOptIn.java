package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Documented @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.ANNOTATION_TYPE}) @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\nB$\bF\u0012\u000E\b\u0002\u0010\u0002\u001A\u00020\u0003B\u0004\b\b(\u0004\u0012\u0010\b\u0002\u0010\u0005\u001A\u00020\u0006B\u0006\b\n0\u00068\u0007R\u0013\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0002\u0010\bR\u0013\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0005\u0010\t¨\u0006\u000B"}, d2={"Lkotlin/RequiresOptIn;", "", "message", "", "", "level", "Lkotlin/RequiresOptIn$Level;", "ERROR", "()Ljava/lang/String;", "()Lkotlin/RequiresOptIn$Level;", "Level", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS}) @public interface RequiresOptIn {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlin/RequiresOptIn$Level;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum Level {
        public static final enum Level ERROR;
        public static final enum Level WARNING;

        private static final Level[] $values() {
            return new Level[]{Level.WARNING, Level.ERROR};
        }

        static {
            Level.WARNING = new Level("WARNING", 0);
            Level.ERROR = new Level("ERROR", 1);
            Level[] v0 = Level.$values();
            Level.$VALUES = v0;
            Level.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Level(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Level.$ENTRIES;
        }

        public static Level valueOf(String arg1) {
            return Enum.valueOf(Level.class, arg1);
        }

        public static Level[] values() {
            return Level.$VALUES.clone();
        }
    }

    Level level();

    String message();
}

