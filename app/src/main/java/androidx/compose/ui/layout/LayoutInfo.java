package androidx.compose.ui.layout;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000E\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H&R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bR\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0012\u0010\u000F\u001A\u00020\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011R\u0014\u0010\u0012\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001A\u00020\u0016X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001A\u00020\u001AX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0012\u0010\u001D\u001A\u00020\u001EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0012\u0010!\u001A\u00020\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0011R\u0012\u0010\"\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\bR\u0014\u0010$\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2={"Landroidx/compose/ui/layout/LayoutInfo;", "", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "width", "", "getWidth", "()I", "height", "getHeight", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "()Z", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "isAttached", "semanticsId", "getSemanticsId", "isDeactivated", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LayoutInfo {
    LayoutCoordinates getCoordinates();

    Density getDensity();

    int getHeight();

    LayoutDirection getLayoutDirection();

    List getModifierInfo();

    LayoutInfo getParentInfo();

    int getSemanticsId();

    ViewConfiguration getViewConfiguration();

    int getWidth();

    boolean isAttached();

    default boolean isDeactivated() {
        return 0;
    }

    boolean isPlaced();
}

