package androidx.compose.ui.layout;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0096\u0002J:\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0019\u0010\u0010\u001A\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0011¢\u0006\u0002\b\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/ui/layout/FixedSizeIntrinsicsPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "width", "", "height", "<init>", "(II)V", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public FixedSizeIntrinsicsPlaceable(int arg5, int arg6) {
        super();
        this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)arg6)) & 0xFFFFFFFFL | (((long)arg5)) << 0x20));
    }

    public int get(AlignmentLine arg1) {
        return 0x80000000;
    }

    protected void placeAt-f8xVGno(long arg1, float arg3, Function1 arg4) {
    }
}

