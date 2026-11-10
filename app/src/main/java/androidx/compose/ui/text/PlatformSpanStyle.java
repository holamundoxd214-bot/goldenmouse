package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00002\b\u0010\u0005\u001A\u0004\u0018\u00010\u0000J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\r"}, d2={"Landroidx/compose/ui/text/PlatformSpanStyle;", "", "<init>", "()V", "merge", "other", "equals", "", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformSpanStyle {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/PlatformSpanStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/PlatformSpanStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PlatformSpanStyle getDefault() {
            return PlatformSpanStyle.Default;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PlatformSpanStyle Default;

    static {
        PlatformSpanStyle.Companion = new Companion(null);
        PlatformSpanStyle.Default = new PlatformSpanStyle();
    }

    public PlatformSpanStyle() {
        super();
    }

    public static final PlatformSpanStyle access$getDefault$cp() {
        return PlatformSpanStyle.Default;
    }

    public boolean equals(Object arg2) {
        if(this == (((PlatformSpanStyle)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof PlatformSpanStyle)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final PlatformSpanStyle merge(PlatformSpanStyle arg1) {
        return this;
    }

    public String toString() {
        return "PlatformSpanStyle()";
    }
}

