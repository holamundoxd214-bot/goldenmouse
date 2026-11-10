package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012:\b\u0002\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000EBM\b\u0016\u0012\u0006\u0010\u000F\u001A\u00020\u0004\u0012:\b\u0002\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u0010J/\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "anchorPositionBlock", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "onPositionCalculated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "anchorPosition", "(JLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "calculatePosition", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextMenuPopupPositionProvider implements PopupPositionProvider {
    public static final int $stable;
    private final Function0 anchorPositionBlock;
    private final Function2 onPositionCalculated;

    static {
    }

    public ContextMenuPopupPositionProvider(long arg1, Function2 arg3, int arg4, DefaultConstructorMarker arg5) {
        arg5 = null;
        if((arg4 & 2) != 0) {
            arg3 = ((Function2)arg5);
        }

        this(arg1, arg3, arg5);
    }

    private ContextMenuPopupPositionProvider(long arg2, Function2 arg4) {
        this(new ContextMenuPopupPositionProvider$$ExternalSyntheticLambda0(arg2), arg4);
    }

    public ContextMenuPopupPositionProvider(Function0 arg1, Function2 arg2) {
        super();
        this.anchorPositionBlock = arg1;
        this.onPositionCalculated = arg2;
    }

    public ContextMenuPopupPositionProvider(long arg1, Function2 arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg3);
    }

    public ContextMenuPopupPositionProvider(Function0 arg1, Function2 arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    static final IntOffset _init_$lambda$0(long arg0) {
        return IntOffset.box-impl(arg0);
    }

    public long calculatePosition-llwVHH4(IntRect arg15, long arg16, LayoutDirection arg18, long arg19) {
        long v0 = arg19;
        long v2 = this.anchorPositionBlock.invoke().unbox-impl();
        int v4 = arg15.getLeft() + IntOffset.getX-impl(v2);
        int v5 = 0x20;
        int v6 = ((int)(v0 >> v5));
        int v7 = ((int)(arg16 >> v5));
        boolean v8 = arg18 == LayoutDirection.Ltr ? true : false;
        long v4_1 = IntOffset.constructor-impl((((long)ContextMenuPopupPositionProviderKt.alignPopupAxis(v4, v6, v7, v8))) << v5 | 0xFFFFFFFFL & (((long)ContextMenuPopupPositionProviderKt.alignPopupAxis$default(arg15.getTop() + IntOffset.getY-impl(v2), ((int)(v0 & 0xFFFFFFFFL)), ((int)(arg16 & 0xFFFFFFFFL)), false, 8, null))));
        Function2 v14 = this.onPositionCalculated;
        if(v14 != null) {
            v14.invoke(IntOffset.box-impl(v2), IntRectKt.IntRect-VbeCjmY(v4_1, v0));
        }

        return v4_1;
    }
}

