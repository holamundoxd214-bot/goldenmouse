package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "", "<init>", "(Ljava/lang/String;I)V", "Untransformed", "Insertion", "Replacement", "Deletion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum IndexTransformationType {
    public static final enum IndexTransformationType Deletion;
    public static final enum IndexTransformationType Insertion;
    public static final enum IndexTransformationType Replacement;
    public static final enum IndexTransformationType Untransformed;

    private static final IndexTransformationType[] $values() {
        return new IndexTransformationType[]{IndexTransformationType.Untransformed, IndexTransformationType.Insertion, IndexTransformationType.Replacement, IndexTransformationType.Deletion};
    }

    static {
        IndexTransformationType.Untransformed = new IndexTransformationType("Untransformed", 0);
        IndexTransformationType.Insertion = new IndexTransformationType("Insertion", 1);
        IndexTransformationType.Replacement = new IndexTransformationType("Replacement", 2);
        IndexTransformationType.Deletion = new IndexTransformationType("Deletion", 3);
        IndexTransformationType[] v0 = IndexTransformationType.$values();
        IndexTransformationType.$VALUES = v0;
        IndexTransformationType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private IndexTransformationType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return IndexTransformationType.$ENTRIES;
    }

    public static IndexTransformationType valueOf(String arg1) {
        return Enum.valueOf(IndexTransformationType.class, arg1);
    }

    public static IndexTransformationType[] values() {
        return IndexTransformationType.$VALUES.clone();
    }
}

