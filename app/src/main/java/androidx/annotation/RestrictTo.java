package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Documented @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE}) @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\u0014\u0012\u0012\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0005¨\u0006\u0007"}, d2={"Landroidx/annotation/RestrictTo;", "", "value", "", "Landroidx/annotation/RestrictTo$Scope;", "()[Landroidx/annotation/RestrictTo$Scope;", "Scope", "annotation"}, k=1, mv={2, 1, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.FILE}) @public interface RestrictTo {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Landroidx/annotation/RestrictTo$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "LIBRARY", "LIBRARY_GROUP", "LIBRARY_GROUP_PREFIX", "GROUP_ID", "TESTS", "SUBCLASSES", "annotation"}, k=1, mv={2, 1, 0}, xi=0x30) public enum Scope {
        @Deprecated(message="Use LIBRARY_GROUP_PREFIX instead.") public static final enum Scope GROUP_ID;
        public static final enum Scope LIBRARY;
        public static final enum Scope LIBRARY_GROUP;
        public static final enum Scope LIBRARY_GROUP_PREFIX;
        public static final enum Scope SUBCLASSES;
        public static final enum Scope TESTS;

        private static final Scope[] $values() {
            return new Scope[]{Scope.LIBRARY, Scope.LIBRARY_GROUP, Scope.LIBRARY_GROUP_PREFIX, Scope.GROUP_ID, Scope.TESTS, Scope.SUBCLASSES};
        }

        static {
            Scope.LIBRARY = new Scope("LIBRARY", 0);
            Scope.LIBRARY_GROUP = new Scope("LIBRARY_GROUP", 1);
            Scope.LIBRARY_GROUP_PREFIX = new Scope("LIBRARY_GROUP_PREFIX", 2);
            Scope.GROUP_ID = new Scope("GROUP_ID", 3);
            Scope.TESTS = new Scope("TESTS", 4);
            Scope.SUBCLASSES = new Scope("SUBCLASSES", 5);
            Scope[] v0 = Scope.$values();
            Scope.$VALUES = v0;
            Scope.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Scope(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Scope.$ENTRIES;
        }

        public static Scope valueOf(String arg1) {
            return Enum.valueOf(Scope.class, arg1);
        }

        public static Scope[] values() {
            return Scope.$VALUES.clone();
        }
    }

    Scope[] value();
}

