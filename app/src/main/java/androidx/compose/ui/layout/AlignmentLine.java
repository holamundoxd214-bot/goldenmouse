package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \t2\u00020\u0001:\u0001\tB#\b\u0004\u0012\u0018\u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R&\u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\u0082\u0001\u0002\n\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/layout/AlignmentLine;", "", "merger", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getMerger$ui", "()Lkotlin/jvm/functions/Function2;", "Companion", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AlignmentLine {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/ui/layout/AlignmentLine$Companion;", "", "<init>", "()V", "Unspecified", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int Unspecified = 0x80000000;
    private final Function2 merger;

    static {
        AlignmentLine.Companion = new Companion(null);
    }

    private AlignmentLine(Function2 arg1) {
        super();
        this.merger = arg1;
    }

    public AlignmentLine(Function2 arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final Function2 getMerger$ui() {
        return this.merger;
    }
}

