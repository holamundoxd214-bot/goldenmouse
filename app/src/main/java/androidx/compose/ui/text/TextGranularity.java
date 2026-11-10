package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001A\u00020\u0003HÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2={"Landroidx/compose/ui/text/TextGranularity;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextGranularity {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/TextGranularity$Companion;", "", "<init>", "()V", "Character", "Landroidx/compose/ui/text/TextGranularity;", "getCharacter-DRrd7Zo", "()I", "I", "Word", "getWord-DRrd7Zo", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getCharacter-DRrd7Zo() {
            return TextGranularity.Character;
        }

        public final int getWord-DRrd7Zo() {
            return TextGranularity.Word;
        }
    }

    private static final int Character;
    public static final Companion Companion;
    private static final int Word;
    private final int value;

    static {
        TextGranularity.Companion = new Companion(null);
        TextGranularity.Character = TextGranularity.constructor-impl(0);
        TextGranularity.Word = TextGranularity.constructor-impl(1);
    }

    private TextGranularity(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getCharacter$cp() {
        return TextGranularity.Character;
    }

    public static final int access$getWord$cp() {
        return TextGranularity.Word;
    }

    public static final TextGranularity box-impl(int arg1) {
        return new TextGranularity(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextGranularity.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextGranularity)) {
            return 0;
        }

        if(arg2 != ((TextGranularity)arg3).unbox-impl()) {
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
        return TextGranularity.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextGranularity.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "TextGranularity(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

