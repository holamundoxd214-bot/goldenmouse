package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\n\u0010\b¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextIndent {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextIndent getNone() {
            return TextIndent.None;
        }

        public static void getNone$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextIndent None;
    private final long firstLine;
    private final long restLine;

    static {
        TextIndent.Companion = new Companion(null);
        TextIndent.None = new TextIndent(0, 0, 3, null);
    }

    public TextIndent(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    public TextIndent(long arg8, long arg10, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 1) != 0) {
            arg8 = TextUnitKt.getSp(0);
        }

        long v2 = arg8;
        if((arg12 & 2) != 0) {
            arg10 = TextUnitKt.getSp(0);
        }

        this(v2, arg10, null);
    }

    private TextIndent(long arg1, long arg3) {
        super();
        this.firstLine = arg1;
        this.restLine = arg3;
    }

    public static final TextIndent access$getNone$cp() {
        return TextIndent.None;
    }

    public final TextIndent copy-NB67dxo(long arg7, long arg9) {
        return new TextIndent(arg7, arg9, null);
    }

    public static TextIndent copy-NB67dxo$default(TextIndent arg0, long arg1, long arg3, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.firstLine;
        }

        if((arg5 & 2) != 0) {
            arg3 = arg0.restLine;
        }

        return arg0.copy-NB67dxo(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextIndent)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextIndent)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.firstLine, ((TextIndent)arg8).firstLine)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.restLine, ((TextIndent)arg8).restLine)) {
            return 0;
        }

        return 1;
    }

    public final long getFirstLine-XSAIIZE() {
        return this.firstLine;
    }

    public final long getRestLine-XSAIIZE() {
        return this.restLine;
    }

    public int hashCode() {
        return TextUnit.hashCode-impl(this.firstLine) * 0x1F + TextUnit.hashCode-impl(this.restLine);
    }

    public String toString() {
        return "TextIndent(firstLine=" + TextUnit.toString-impl(this.firstLine) + ", restLine=" + TextUnit.toString-impl(this.restLine) + ')';
    }
}

