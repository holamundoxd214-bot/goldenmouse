package androidx.compose.material3;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\'\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/material3/DefaultTooltipCaretShape;", "Landroidx/compose/ui/graphics/Shape;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCaretSize-MYxV2XQ", "()J", "J", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultTooltipCaretShape implements Shape {
    public static final int $stable;
    private final long caretSize;

    static {
    }

    private DefaultTooltipCaretShape(long arg1) {
        super();
        this.caretSize = arg1;
    }

    public DefaultTooltipCaretShape(long arg1, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = TooltipDefaults.INSTANCE.getCaretSize-MYxV2XQ();
        }

        this(arg1, null);
    }

    public DefaultTooltipCaretShape(long arg1, DefaultConstructorMarker arg3) {
        this(arg1);
    }

    public Outline createOutline-Pq9zytI(long arg3, LayoutDirection arg5, Density arg6) {
        Path v3 = AndroidPath_androidKt.Path();
        float v4 = arg6.toPx-0680j_4(DpSize.getWidth-D9Ej5fM(this.caretSize));
        float v2 = arg6.toPx-0680j_4(DpSize.getHeight-D9Ej5fM(this.caretSize));
        v3.moveTo(0f, 0f);
        v3.lineTo(v4 / 2f, 0f);
        v3.lineTo(0f, v2);
        v3.lineTo(-v4 / 2f, 0f);
        v3.close();
        return new Generic(v3);
    }

    public final long getCaretSize-MYxV2XQ() {
        return this.caretSize;
    }
}

