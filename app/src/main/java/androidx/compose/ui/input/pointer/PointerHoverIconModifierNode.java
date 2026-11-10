package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0012\u0010\u0011\u001A\u00020\u00122\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/input/pointer/HoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "isRelevantPointerType", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isRelevantPointerType-uerMTgs", "(I)Z", "displayIcon", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerHoverIconModifierNode extends HoverIconModifierNode {
    public static final int $stable = 8;
    private final String traverseKey;

    static {
    }

    public PointerHoverIconModifierNode(PointerIcon arg7, boolean arg8) {
        super(arg7, arg8, null, 4, null);
        this.traverseKey = "androidx.compose.ui.input.pointer.PointerHoverIcon";
    }

    public PointerHoverIconModifierNode(PointerIcon arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, false);
    }

    public void displayIcon(PointerIcon arg1) {
        PointerIconService v0 = this.getPointerIconService();
        if(v0 != null) {
            v0.setIcon(arg1);
        }
    }

    public Object getTraverseKey() {
        return this.getTraverseKey();
    }

    public String getTraverseKey() {
        return this.traverseKey;
    }

    public boolean isRelevantPointerType-uerMTgs(int arg1) {
        if(!PointerType.equals-impl0(arg1, PointerType.Companion.getStylus-T8wyACA()) && !PointerType.equals-impl0(arg1, PointerType.Companion.getEraser-T8wyACA())) {
            return 1;
        }

        return 0;
    }
}

