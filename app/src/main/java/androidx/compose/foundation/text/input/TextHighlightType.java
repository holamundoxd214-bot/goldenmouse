package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001A\u00020\u0003HÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/input/TextHighlightType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextHighlightType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/text/input/TextHighlightType$Companion;", "", "<init>", "()V", "HandwritingSelectPreview", "Landroidx/compose/foundation/text/input/TextHighlightType;", "getHandwritingSelectPreview-s-xJuwY", "()I", "I", "HandwritingDeletePreview", "getHandwritingDeletePreview-s-xJuwY", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getHandwritingDeletePreview-s-xJuwY() {
            return TextHighlightType.HandwritingDeletePreview;
        }

        public final int getHandwritingSelectPreview-s-xJuwY() {
            return TextHighlightType.HandwritingSelectPreview;
        }
    }

    public static final Companion Companion;
    private static final int HandwritingDeletePreview;
    private static final int HandwritingSelectPreview;
    private final int value;

    static {
        TextHighlightType.Companion = new Companion(null);
        TextHighlightType.HandwritingSelectPreview = TextHighlightType.constructor-impl(0);
        TextHighlightType.HandwritingDeletePreview = TextHighlightType.constructor-impl(1);
    }

    private TextHighlightType(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getHandwritingDeletePreview$cp() {
        return TextHighlightType.HandwritingDeletePreview;
    }

    public static final int access$getHandwritingSelectPreview$cp() {
        return TextHighlightType.HandwritingSelectPreview;
    }

    public static final TextHighlightType box-impl(int arg1) {
        return new TextHighlightType(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextHighlightType.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextHighlightType)) {
            return 0;
        }

        if(arg2 != ((TextHighlightType)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return TextHighlightType.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextHighlightType.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "TextHighlightType(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

