package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0000\"\u001F\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000E"}, d2={"DefaultLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "DefaultConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "PlacementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCapablePlaceable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "owner", "Landroidx/compose/ui/node/Owner;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlaceableKt {
    private static final long DefaultConstraints;
    private static final Function1 DefaultLayerBlock;

    static {
        PlaceableKt.DefaultLayerBlock = PlaceableKt$DefaultLayerBlock$1.INSTANCE;
        PlaceableKt.DefaultConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    }

    public static final PlacementScope PlacementScope(LookaheadCapablePlaceable arg1) {
        return new LookaheadCapablePlacementScope(arg1);
    }

    public static final PlacementScope PlacementScope(Owner arg1) {
        return new OuterPlacementScope(arg1);
    }

    public static final long access$getDefaultConstraints$p() {
        return PlaceableKt.DefaultConstraints;
    }

    public static final Function1 access$getDefaultLayerBlock$p() {
        return PlaceableKt.DefaultLayerBlock;
    }
}

