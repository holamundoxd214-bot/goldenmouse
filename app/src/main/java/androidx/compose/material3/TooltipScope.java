package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J-\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u001F\u0010\u0004\u001A\u001B\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\'J\u000E\u0010\n\u001A\u0004\u0018\u00010\u0007*\u00020\u000BH&J\b\u0010\f\u001A\u00020\rH&\u0082\u0001\u0001\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/TooltipScope;", "", "drawCaret", "Landroidx/compose/ui/Modifier;", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "obtainAnchorBounds", "Landroidx/compose/ui/layout/MeasureScope;", "obtainPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "Landroidx/compose/material3/TooltipScopeImpl;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TooltipScope {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") Modifier drawCaret(Modifier arg1, Function2 arg2);

    LayoutCoordinates obtainAnchorBounds(MeasureScope arg1);

    PopupPositionProvider obtainPositionProvider();
}

