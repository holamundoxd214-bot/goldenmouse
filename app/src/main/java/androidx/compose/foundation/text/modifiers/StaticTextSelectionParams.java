package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016J\u001E\u0010\u0015\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/text/TextLayoutResult;)V", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "", "end", "shouldClip", "", "getShouldClip", "()Z", "copy", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public class StaticTextSelectionParams {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "getEmpty", "()Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StaticTextSelectionParams getEmpty() {
            return StaticTextSelectionParams.Empty;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final StaticTextSelectionParams Empty;
    private final LayoutCoordinates layoutCoordinates;
    private final TextLayoutResult textLayoutResult;

    static {
        StaticTextSelectionParams.Companion = new Companion(null);
        StaticTextSelectionParams.$stable = 8;
        StaticTextSelectionParams.Empty = new StaticTextSelectionParams(null, null);
    }

    public StaticTextSelectionParams(LayoutCoordinates arg1, TextLayoutResult arg2) {
        super();
        this.layoutCoordinates = arg1;
        this.textLayoutResult = arg2;
    }

    public static final StaticTextSelectionParams access$getEmpty$cp() {
        return StaticTextSelectionParams.Empty;
    }

    public final StaticTextSelectionParams copy(LayoutCoordinates arg1, TextLayoutResult arg2) {
        return new StaticTextSelectionParams(arg1, arg2);
    }

    public static StaticTextSelectionParams copy$default(StaticTextSelectionParams arg0, LayoutCoordinates arg1, TextLayoutResult arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.layoutCoordinates;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.textLayoutResult;
            }

            return arg0.copy(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public Path getPathForRange(int arg1, int arg2) {
        TextLayoutResult v0 = this.textLayoutResult;
        if(v0 != null) {
            return v0.getPathForRange(arg1, arg2);
        }

        return null;
    }

    public boolean getShouldClip() {
        TextLayoutResult v3 = this.textLayoutResult;
        if(v3 != null && !TextOverflow.equals-impl0(v3.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8()) && (v3.getHasVisualOverflow())) {
            return 1;
        }

        return 0;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }
}

