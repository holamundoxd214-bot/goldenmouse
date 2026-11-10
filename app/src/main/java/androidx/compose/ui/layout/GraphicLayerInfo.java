package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/layout/GraphicLayerInfo;", "", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface GraphicLayerInfo {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static long getOwnerViewId(GraphicLayerInfo arg2) {
            return arg2.getOwnerViewId();
        }
    }

    static long access$getOwnerViewId$jd(GraphicLayerInfo arg2) {
        return super.getOwnerViewId();
    }

    long getLayerId();

    default long getOwnerViewId() {
        return 0;
    }
}

