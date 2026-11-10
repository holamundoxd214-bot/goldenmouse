package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\u001A*\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0001\u001A(\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A(\u0010\b\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A \u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A \u0010\n\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A \u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A \u0010\f\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\r"}, d2={"alignPopupAxis", "", "position", "popupLength", "windowLength", "closeAffinity", "", "popupFitsBetweenPositionAndStartEdge", "popupFitsBetweenPositionAndEndEdge", "alignPopupStartEdgeToPosition", "alignPopupEndEdgeToPosition", "alignStartEdges", "alignEndEdges", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuPopupPositionProviderKt {
    private static final int alignEndEdges(int arg0, int arg1, boolean arg2) {
        return ContextMenuPopupPositionProviderKt.alignStartEdges(arg0, arg1, (((int)arg2)) ^ 1);
    }

    public static final int alignPopupAxis(int arg1, int arg2, int arg3, boolean arg4) {
        if(arg2 >= arg3) {
            return ContextMenuPopupPositionProviderKt.alignStartEdges(arg2, arg3, arg4);
        }

        if(ContextMenuPopupPositionProviderKt.popupFitsBetweenPositionAndEndEdge(arg1, arg2, arg3, arg4)) {
            return ContextMenuPopupPositionProviderKt.alignPopupStartEdgeToPosition(arg1, arg2, arg4);
        }

        if(ContextMenuPopupPositionProviderKt.popupFitsBetweenPositionAndStartEdge(arg1, arg2, arg3, arg4)) {
            return ContextMenuPopupPositionProviderKt.alignPopupEndEdgeToPosition(arg1, arg2, arg4);
        }

        return ContextMenuPopupPositionProviderKt.alignEndEdges(arg2, arg3, arg4);
    }

    public static int alignPopupAxis$default(int arg0, int arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        return ContextMenuPopupPositionProviderKt.alignPopupAxis(arg0, arg1, arg2, true);
    }

    private static final int alignPopupEndEdgeToPosition(int arg0, int arg1, boolean arg2) {
        return ContextMenuPopupPositionProviderKt.alignPopupStartEdgeToPosition(arg0, arg1, (((int)arg2)) ^ 1);
    }

    private static final int alignPopupStartEdgeToPosition(int arg0, int arg1, boolean arg2) {
        if(arg2) {
            return arg0;
        }

        return arg0 - arg1;
    }

    private static final int alignStartEdges(int arg0, int arg1, boolean arg2) {
        if(arg2) {
            return 0;
        }

        return arg1 - arg0;
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int arg0, int arg1, int arg2, boolean arg3) {
        return ContextMenuPopupPositionProviderKt.popupFitsBetweenPositionAndStartEdge(arg0, arg1, arg2, (((int)arg3)) ^ 1);
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int arg2, int arg3, int arg4, boolean arg5) {
        if(arg5) {
            if(arg3 <= arg2) {
                return 1;
            }

            return 0;
        }

        if(arg4 - arg3 > arg2) {
            return 1;
        }

        return 0;
    }
}

