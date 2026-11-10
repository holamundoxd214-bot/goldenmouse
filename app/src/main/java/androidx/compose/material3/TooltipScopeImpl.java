package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\r\u001A\u00020\u000E*\u00020\u000E2\u001F\u0010\u000F\u001A\u001B\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013H\u0017J\u000E\u0010\u0014\u001A\u0004\u0018\u00010\u0004*\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0006H\u0016R\u0019\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2={"Landroidx/compose/material3/TooltipScopeImpl;", "Landroidx/compose/material3/TooltipScope;", "getAnchorBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;)V", "getGetAnchorBounds", "()Lkotlin/jvm/functions/Function0;", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "drawCaret", "Landroidx/compose/ui/Modifier;", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "obtainAnchorBounds", "Landroidx/compose/ui/layout/MeasureScope;", "obtainPositionProvider", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TooltipScopeImpl implements TooltipScope {
    public static final int $stable;
    private final Function0 getAnchorBounds;
    private final PopupPositionProvider positionProvider;

    static {
    }

    public TooltipScopeImpl(Function0 arg1, PopupPositionProvider arg2) {
        super();
        this.getAnchorBounds = arg1;
        this.positionProvider = arg2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public Modifier drawCaret(Modifier arg2, Function2 arg3) {
        return DrawModifierKt.drawWithCache(arg2, new TooltipScopeImpl$$ExternalSyntheticLambda0(arg3, this));
    }

    static final DrawResult drawCaret$lambda$0(Function2 arg0, TooltipScopeImpl arg1, CacheDrawScope arg2) {
        return arg0.invoke(arg2, arg1.getAnchorBounds.invoke());
    }

    public final Function0 getGetAnchorBounds() {
        return this.getAnchorBounds;
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public LayoutCoordinates obtainAnchorBounds(MeasureScope arg1) {
        return this.getAnchorBounds.invoke();
    }

    public PopupPositionProvider obtainPositionProvider() {
        return this.positionProvider;
    }
}

