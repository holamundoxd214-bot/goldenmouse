package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_FACTOR", "INVALID_DIMENSIONS", "INVALID_IDENTITY", "INVALID_ROTATION", "INVALID_RECTANGLE", "ARITHMETIC_OUT_OF_RANGE", "MISSING_IDENTITY", "MISSING_LOGICAL_SIZE", "MISSING_ROTATION", "MISSING_MODE_REFERENCE", "LONG_AXIS_COLLAPSED", "PROJECTION_ORIENTATION", "MODE_REFERENCE_ASPECT", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchIssue {
    public static final enum StretchIssue ARITHMETIC_OUT_OF_RANGE;
    public static final enum StretchIssue INVALID_DIMENSIONS;
    public static final enum StretchIssue INVALID_FACTOR;
    public static final enum StretchIssue INVALID_IDENTITY;
    public static final enum StretchIssue INVALID_RECTANGLE;
    public static final enum StretchIssue INVALID_ROTATION;
    public static final enum StretchIssue LONG_AXIS_COLLAPSED;
    public static final enum StretchIssue MISSING_IDENTITY;
    public static final enum StretchIssue MISSING_LOGICAL_SIZE;
    public static final enum StretchIssue MISSING_MODE_REFERENCE;
    public static final enum StretchIssue MISSING_ROTATION;
    public static final enum StretchIssue MODE_REFERENCE_ASPECT;
    public static final enum StretchIssue PROJECTION_ORIENTATION;

    private static final StretchIssue[] $values() {
        return new StretchIssue[]{StretchIssue.INVALID_FACTOR, StretchIssue.INVALID_DIMENSIONS, StretchIssue.INVALID_IDENTITY, StretchIssue.INVALID_ROTATION, StretchIssue.INVALID_RECTANGLE, StretchIssue.ARITHMETIC_OUT_OF_RANGE, StretchIssue.MISSING_IDENTITY, StretchIssue.MISSING_LOGICAL_SIZE, StretchIssue.MISSING_ROTATION, StretchIssue.MISSING_MODE_REFERENCE, StretchIssue.LONG_AXIS_COLLAPSED, StretchIssue.PROJECTION_ORIENTATION, StretchIssue.MODE_REFERENCE_ASPECT};
    }

    static {
        StretchIssue.INVALID_FACTOR = new StretchIssue("INVALID_FACTOR", 0);
        StretchIssue.INVALID_DIMENSIONS = new StretchIssue("INVALID_DIMENSIONS", 1);
        StretchIssue.INVALID_IDENTITY = new StretchIssue("INVALID_IDENTITY", 2);
        StretchIssue.INVALID_ROTATION = new StretchIssue("INVALID_ROTATION", 3);
        StretchIssue.INVALID_RECTANGLE = new StretchIssue("INVALID_RECTANGLE", 4);
        StretchIssue.ARITHMETIC_OUT_OF_RANGE = new StretchIssue("ARITHMETIC_OUT_OF_RANGE", 5);
        StretchIssue.MISSING_IDENTITY = new StretchIssue("MISSING_IDENTITY", 6);
        StretchIssue.MISSING_LOGICAL_SIZE = new StretchIssue("MISSING_LOGICAL_SIZE", 7);
        StretchIssue.MISSING_ROTATION = new StretchIssue("MISSING_ROTATION", 8);
        StretchIssue.MISSING_MODE_REFERENCE = new StretchIssue("MISSING_MODE_REFERENCE", 9);
        StretchIssue.LONG_AXIS_COLLAPSED = new StretchIssue("LONG_AXIS_COLLAPSED", 10);
        StretchIssue.PROJECTION_ORIENTATION = new StretchIssue("PROJECTION_ORIENTATION", 11);
        StretchIssue.MODE_REFERENCE_ASPECT = new StretchIssue("MODE_REFERENCE_ASPECT", 12);
        StretchIssue[] v0 = StretchIssue.$values();
        StretchIssue.$VALUES = v0;
        StretchIssue.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchIssue(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchIssue.$ENTRIES;
    }

    public static StretchIssue valueOf(String arg1) {
        return Enum.valueOf(StretchIssue.class, arg1);
    }

    public static StretchIssue[] values() {
        return StretchIssue.$VALUES.clone();
    }
}

