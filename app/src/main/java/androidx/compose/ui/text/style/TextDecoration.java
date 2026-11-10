package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0086\u0002J\u0011\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0000H\u0086\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/TextDecoration;", "", "mask", "", "<init>", "(I)V", "getMask", "()I", "plus", "decoration", "contains", "", "other", "toString", "", "equals", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextDecoration {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000F\u001A\u00020\u00052\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00050\u0011J\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0014R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/style/TextDecoration$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextDecoration;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextDecoration;", "Underline", "getUnderline$annotations", "getUnderline", "LineThrough", "getLineThrough$annotations", "getLineThrough", "combine", "decorations", "", "valueOf", "mask", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextDecoration combine(List arg4) {
            int v3 = 0;
            Integer v0 = Integer.valueOf(0);
            int v1 = arg4.size();
            while(v3 < v1) {
                v0 = Integer.valueOf(((Number)v0).intValue() | arg4.get(v3).getMask());
                ++v3;
            }

            return new TextDecoration(((Number)v0).intValue());
        }

        public final TextDecoration getLineThrough() {
            return TextDecoration.LineThrough;
        }

        public static void getLineThrough$annotations() {
        }

        public final TextDecoration getNone() {
            return TextDecoration.None;
        }

        public static void getNone$annotations() {
        }

        public final TextDecoration getUnderline() {
            return TextDecoration.Underline;
        }

        public static void getUnderline$annotations() {
        }

        public final TextDecoration valueOf(int arg4) {
            int v0 = (arg4 | 3) == 3 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("The given mask=" + arg4 + " is not recognized by TextDecoration.");
            }

            if(arg4 != 0) {
                if(arg4 != 1) {
                    if(arg4 != 2) {
                        return new TextDecoration(arg4);
                    }

                    return this.getLineThrough();
                }

                return this.getUnderline();
            }

            return this.getNone();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextDecoration LineThrough;
    private static final TextDecoration None;
    private static final TextDecoration Underline;
    private final int mask;

    static {
        TextDecoration.Companion = new Companion(null);
        TextDecoration.None = new TextDecoration(0);
        TextDecoration.Underline = new TextDecoration(1);
        TextDecoration.LineThrough = new TextDecoration(2);
    }

    public TextDecoration(int arg1) {
        super();
        this.mask = arg1;
    }

    public static final TextDecoration access$getLineThrough$cp() {
        return TextDecoration.LineThrough;
    }

    public static final TextDecoration access$getNone$cp() {
        return TextDecoration.None;
    }

    public static final TextDecoration access$getUnderline$cp() {
        return TextDecoration.Underline;
    }

    public final boolean contains(TextDecoration arg1) {
        if((arg1.mask | this.mask) == this.mask) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object arg4) {
        if(this == (((TextDecoration)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof TextDecoration)) {
            return 0;
        }

        if(this.mask != ((TextDecoration)arg4).mask) {
            return 0;
        }

        return 1;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public final TextDecoration plus(TextDecoration arg2) {
        return new TextDecoration(this.mask | arg2.mask);
    }

    public String toString() {
        if(this.mask == 0) {
            return "TextDecoration.None";
        }

        ArrayList v1 = new ArrayList();
        if((this.mask & TextDecoration.Underline.mask) != 0) {
            ((List)v1).add("Underline");
        }

        if((this.mask & TextDecoration.LineThrough.mask) != 0) {
            ((List)v1).add("LineThrough");
        }

        if(((List)v1).size() == 1) {
            return "TextDecoration." + ((List)v1).get(0);
        }

        return "TextDecoration[" + ListUtilsKt.fastJoinToString$default(((List)v1), ", ", null, null, 0, null, null, 62, null) + ']';
    }
}

