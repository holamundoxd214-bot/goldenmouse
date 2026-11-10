package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u000E2\u0006\u0010!\u001A\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006$"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/MaintainWindowPositionPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "<init>", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "getPopupPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "previousWindowSize", "Landroidx/compose/ui/unit/IntSize;", "getPreviousWindowSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPreviousWindowSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "previousLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getPreviousLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setPreviousLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "previousPopupContentSize", "getPreviousPopupContentSize-bOM6tXw", "setPreviousPopupContentSize-fhxjrPA", "previousPosition", "Landroidx/compose/ui/unit/IntOffset;", "getPreviousPosition-JyOPPKE", "()Landroidx/compose/ui/unit/IntOffset;", "setPreviousPosition-fg0MpWk", "(Landroidx/compose/ui/unit/IntOffset;)V", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "layoutDirection", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MaintainWindowPositionPopupPositionProvider implements PopupPositionProvider {
    private final PopupPositionProvider popupPositionProvider;
    private LayoutDirection previousLayoutDirection;
    private IntSize previousPopupContentSize;
    private IntOffset previousPosition;
    private IntSize previousWindowSize;

    public MaintainWindowPositionPopupPositionProvider(PopupPositionProvider arg1) {
        super();
        this.popupPositionProvider = arg1;
    }

    public long calculatePosition-llwVHH4(IntRect arg8, long arg9, LayoutDirection arg11, long arg12) {
        IntOffset v0 = this.previousPosition;
        if(v0 != null) {
            IntSize v1 = this.previousWindowSize;
            boolean v2 = false;
            boolean v1_1 = v1 == null ? false : IntSize.equals-impl0(v1.unbox-impl(), arg9);
            if(!v1_1) {
                goto label_20;
            }

            if(this.previousLayoutDirection != arg11) {
                goto label_20;
            }

            v1 = this.previousPopupContentSize;
            if(v1 == null) {
            }
            else {
                v2 = IntSize.equals-impl0(v1.unbox-impl(), arg12);
            }

            if(!v2) {
                goto label_20;
            }

            return v0.unbox-impl();
        }

    label_20:
        long v2_1 = arg9;
        long v8 = this.popupPositionProvider.calculatePosition-llwVHH4(arg8, v2_1, arg11, arg12);
        this.previousWindowSize = IntSize.box-impl(v2_1);
        this.previousLayoutDirection = arg11;
        this.previousPopupContentSize = IntSize.box-impl(arg12);
        this.previousPosition = IntOffset.box-impl(v8);
        return v8;
    }

    public final PopupPositionProvider getPopupPositionProvider() {
        return this.popupPositionProvider;
    }

    public final LayoutDirection getPreviousLayoutDirection() {
        return this.previousLayoutDirection;
    }

    public final IntSize getPreviousPopupContentSize-bOM6tXw() {
        return this.previousPopupContentSize;
    }

    public final IntOffset getPreviousPosition-JyOPPKE() {
        return this.previousPosition;
    }

    public final IntSize getPreviousWindowSize-bOM6tXw() {
        return this.previousWindowSize;
    }

    public final void setPreviousLayoutDirection(LayoutDirection arg1) {
        this.previousLayoutDirection = arg1;
    }

    public final void setPreviousPopupContentSize-fhxjrPA(IntSize arg1) {
        this.previousPopupContentSize = arg1;
    }

    public final void setPreviousPosition-fg0MpWk(IntOffset arg1) {
        this.previousPosition = arg1;
    }

    public final void setPreviousWindowSize-fhxjrPA(IntSize arg1) {
        this.previousWindowSize = arg1;
    }
}

