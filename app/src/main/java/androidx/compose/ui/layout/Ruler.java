package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B*\b\u0004\u0012\u001F\u0010\u0002\u001A\u001B\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH ¢\u0006\u0002\b\u0010R-\u0010\u0002\u001A\u001B\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/layout/Ruler;", "", "calculate", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getCalculate$ui", "()Lkotlin/jvm/functions/Function2;", "calculateCoordinate", "coordinate", "sourceCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "targetCoordinates", "calculateCoordinate$ui", "Landroidx/compose/ui/layout/HorizontalRuler;", "Landroidx/compose/ui/layout/VerticalRuler;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Ruler {
    public static final int $stable;
    private final Function2 calculate;

    static {
    }

    private Ruler(Function2 arg1) {
        super();
        this.calculate = arg1;
    }

    public Ruler(Function2 arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public abstract float calculateCoordinate$ui(float arg1, LayoutCoordinates arg2, LayoutCoordinates arg3);

    public final Function2 getCalculate$ui() {
        return this.calculate;
    }
}

