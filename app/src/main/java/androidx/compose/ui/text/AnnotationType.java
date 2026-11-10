package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/AnnotationType;", "", "<init>", "(Ljava/lang/String;I)V", "Paragraph", "Span", "VerbatimTts", "Url", "Link", "Clickable", "String", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) enum AnnotationType {
    public static final enum AnnotationType Clickable;
    public static final enum AnnotationType Link;
    public static final enum AnnotationType Paragraph;
    public static final enum AnnotationType Span;
    public static final enum AnnotationType String;
    public static final enum AnnotationType Url;
    public static final enum AnnotationType VerbatimTts;

    private static final AnnotationType[] $values() {
        return new AnnotationType[]{AnnotationType.Paragraph, AnnotationType.Span, AnnotationType.VerbatimTts, AnnotationType.Url, AnnotationType.Link, AnnotationType.Clickable, AnnotationType.String};
    }

    static {
        AnnotationType.Paragraph = new AnnotationType("Paragraph", 0);
        AnnotationType.Span = new AnnotationType("Span", 1);
        AnnotationType.VerbatimTts = new AnnotationType("VerbatimTts", 2);
        AnnotationType.Url = new AnnotationType("Url", 3);
        AnnotationType.Link = new AnnotationType("Link", 4);
        AnnotationType.Clickable = new AnnotationType("Clickable", 5);
        AnnotationType.String = new AnnotationType("String", 6);
        AnnotationType[] v0 = AnnotationType.$values();
        AnnotationType.$VALUES = v0;
        AnnotationType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private AnnotationType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return AnnotationType.$ENTRIES;
    }

    public static AnnotationType valueOf(String arg1) {
        return Enum.valueOf(AnnotationType.class, arg1);
    }

    public static AnnotationType[] values() {
        return AnnotationType.$VALUES.clone();
    }
}

