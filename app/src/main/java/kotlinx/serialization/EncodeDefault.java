package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Documented @Retention(value=RetentionPolicy.RUNTIME) @Target(value={}) @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2={"Lkotlinx/serialization/EncodeDefault;", "", "mode", "Lkotlinx/serialization/EncodeDefault$Mode;", "()Lkotlinx/serialization/EncodeDefault$Mode;", "Mode", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Target(allowedTargets={AnnotationTarget.PROPERTY}) @ExperimentalSerializationApi @public interface EncodeDefault {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlinx/serialization/EncodeDefault$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "ALWAYS", "NEVER", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public enum Mode {
        public static final enum Mode ALWAYS;
        public static final enum Mode NEVER;

        private static final Mode[] $values() {
            return new Mode[]{Mode.ALWAYS, Mode.NEVER};
        }

        static {
            Mode.ALWAYS = new Mode("ALWAYS", 0);
            Mode.NEVER = new Mode("NEVER", 1);
            Mode[] v0 = Mode.$values();
            Mode.$VALUES = v0;
            Mode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Mode(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Mode.$ENTRIES;
        }

        public static Mode valueOf(String arg1) {
            return Enum.valueOf(Mode.class, arg1);
        }

        public static Mode[] values() {
            return Mode.$VALUES.clone();
        }
    }

    Mode mode();
}

