package androidx.annotation.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.ANNOTATION_TYPE}) @Deprecated(message="This annotation has been replaced by `@RequiresOptIn`", replaceWith="<_subannotation>") @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2={"Landroidx/annotation/experimental/Experimental;", "", "level", "Landroidx/annotation/experimental/Experimental$Level;", "()Landroidx/annotation/experimental/Experimental$Level;", "Level", "annotation-experimental_release"}, k=1, mv={1, 7, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS}) @public interface Experimental {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2={"Landroidx/annotation/experimental/Experimental$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "annotation-experimental_release"}, k=1, mv={1, 7, 0}, xi=0x30) public enum Level {
        public static final enum Level ERROR;
        public static final enum Level WARNING;

        private static final Level[] $values() {
            return new Level[]{Level.WARNING, Level.ERROR};
        }

        static {
            Level.WARNING = new Level("WARNING", 0);
            Level.ERROR = new Level("ERROR", 1);
            Level.$VALUES = Level.$values();
        }

        private Level(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Level valueOf(String arg1) {
            return Enum.valueOf(Level.class, arg1);
        }

        public static Level[] values() {
            return Level.$VALUES.clone();
        }
    }

    Level level();
}

