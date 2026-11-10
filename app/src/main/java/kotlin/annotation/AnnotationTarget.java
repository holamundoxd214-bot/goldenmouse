package kotlin.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2={"Lkotlin/annotation/AnnotationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum AnnotationTarget {
    public static final enum AnnotationTarget ANNOTATION_CLASS;
    public static final enum AnnotationTarget CLASS;
    public static final enum AnnotationTarget CONSTRUCTOR;
    public static final enum AnnotationTarget EXPRESSION;
    public static final enum AnnotationTarget FIELD;
    public static final enum AnnotationTarget FILE;
    public static final enum AnnotationTarget FUNCTION;
    public static final enum AnnotationTarget LOCAL_VARIABLE;
    public static final enum AnnotationTarget PROPERTY;
    public static final enum AnnotationTarget PROPERTY_GETTER;
    public static final enum AnnotationTarget PROPERTY_SETTER;
    public static final enum AnnotationTarget TYPE;
    public static final enum AnnotationTarget TYPEALIAS;
    public static final enum AnnotationTarget TYPE_PARAMETER;
    public static final enum AnnotationTarget VALUE_PARAMETER;

    private static final AnnotationTarget[] $values() {
        return new AnnotationTarget[]{AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPE, AnnotationTarget.EXPRESSION, AnnotationTarget.FILE, AnnotationTarget.TYPEALIAS};
    }

    static {
        AnnotationTarget.CLASS = new AnnotationTarget("CLASS", 0);
        AnnotationTarget.ANNOTATION_CLASS = new AnnotationTarget("ANNOTATION_CLASS", 1);
        AnnotationTarget.TYPE_PARAMETER = new AnnotationTarget("TYPE_PARAMETER", 2);
        AnnotationTarget.PROPERTY = new AnnotationTarget("PROPERTY", 3);
        AnnotationTarget.FIELD = new AnnotationTarget("FIELD", 4);
        AnnotationTarget.LOCAL_VARIABLE = new AnnotationTarget("LOCAL_VARIABLE", 5);
        AnnotationTarget.VALUE_PARAMETER = new AnnotationTarget("VALUE_PARAMETER", 6);
        AnnotationTarget.CONSTRUCTOR = new AnnotationTarget("CONSTRUCTOR", 7);
        AnnotationTarget.FUNCTION = new AnnotationTarget("FUNCTION", 8);
        AnnotationTarget.PROPERTY_GETTER = new AnnotationTarget("PROPERTY_GETTER", 9);
        AnnotationTarget.PROPERTY_SETTER = new AnnotationTarget("PROPERTY_SETTER", 10);
        AnnotationTarget.TYPE = new AnnotationTarget("TYPE", 11);
        AnnotationTarget.EXPRESSION = new AnnotationTarget("EXPRESSION", 12);
        AnnotationTarget.FILE = new AnnotationTarget("FILE", 13);
        AnnotationTarget.TYPEALIAS = new AnnotationTarget("TYPEALIAS", 14);
        AnnotationTarget[] v0 = AnnotationTarget.$values();
        AnnotationTarget.$VALUES = v0;
        AnnotationTarget.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private AnnotationTarget(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return AnnotationTarget.$ENTRIES;
    }

    public static AnnotationTarget valueOf(String arg1) {
        return Enum.valueOf(AnnotationTarget.class, arg1);
    }

    public static AnnotationTarget[] values() {
        return AnnotationTarget.$VALUES.clone();
    }
}

