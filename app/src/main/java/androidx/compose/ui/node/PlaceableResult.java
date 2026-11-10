package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/node/PlaceableResult;", "Landroidx/compose/ui/node/OwnerScope;", "result", "Landroidx/compose/ui/layout/MeasureResult;", "placeable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "<init>", "(Landroidx/compose/ui/layout/MeasureResult;Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "getResult", "()Landroidx/compose/ui/layout/MeasureResult;", "setResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "getPlaceable", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "isValidOwnerScope", "", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PlaceableResult implements OwnerScope {
    private final LookaheadCapablePlaceable placeable;
    private MeasureResult result;

    public PlaceableResult(MeasureResult arg1, LookaheadCapablePlaceable arg2) {
        super();
        this.result = arg1;
        this.placeable = arg2;
    }

    public final LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    public final MeasureResult getResult() {
        return this.result;
    }

    public boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }

    public final void setResult(MeasureResult arg1) {
        this.result = arg1;
    }
}

