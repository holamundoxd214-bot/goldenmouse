package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0001\u0012\u0006\u0010\u0006\u001A\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u000F\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\f¨\u0006\u001B"}, d2={"Landroidx/compose/material3/TooltipCaretShape;", "Landroidx/compose/ui/graphics/Shape;", "transformationMatrix", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/Matrix;", "tooltipShape", "caretShape", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "tooltipPath", "Landroidx/compose/ui/graphics/Path;", "getTooltipPath", "()Landroidx/compose/ui/graphics/Path;", "combinedPath", "getCombinedPath", "caretPath", "getCaretPath", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TooltipCaretShape implements Shape {
    private final Path caretPath;
    private final Shape caretShape;
    private final Path combinedPath;
    private final Path tooltipPath;
    private final Shape tooltipShape;
    private final MutableState transformationMatrix;

    public TooltipCaretShape(MutableState arg1, Shape arg2, Shape arg3) {
        super();
        this.transformationMatrix = arg1;
        this.tooltipShape = arg2;
        this.caretShape = arg3;
        this.tooltipPath = AndroidPath_androidKt.Path();
        this.combinedPath = AndroidPath_androidKt.Path();
        this.caretPath = AndroidPath_androidKt.Path();
    }

    public Outline createOutline-Pq9zytI(long arg8, LayoutDirection arg10, Density arg11) {
        this.tooltipPath.reset();
        this.combinedPath.reset();
        this.caretPath.reset();
        Outline v0 = this.tooltipShape.createOutline-Pq9zytI(arg8, arg10, arg11);
        Outline v8 = this.caretShape.createOutline-Pq9zytI(arg8, arg10, arg11);
        int v10 = 2;
        Direction v11 = null;
        if((v0 instanceof Generic)) {
            Path.addPath-Uv8p0NA$default(this.tooltipPath, ((Generic)v0).getPath(), 0, 2, null);
        }
        else if((v0 instanceof Rounded)) {
            Path.addRoundRect$default(this.tooltipPath, ((Rounded)v0).getRoundRect(), v11, v10, v11);
        }
        else if((v0 instanceof Rectangle)) {
            Path.addRect$default(this.tooltipPath, ((Rectangle)v0).getRect(), v11, v10, v11);
        }
        else {
            goto label_70;
        }

        if((v8 instanceof Generic)) {
            Path.addPath-Uv8p0NA$default(this.caretPath, ((Generic)v8).getPath(), 0, 2, null);
        }
        else if((v8 instanceof Rounded)) {
            Path.addRoundRect$default(this.caretPath, ((Rounded)v8).getRoundRect(), v11, v10, v11);
        }
        else if((v8 instanceof Rectangle)) {
            Path.addRect$default(this.caretPath, ((Rectangle)v8).getRect(), v11, v10, v11);
        }
        else {
            goto label_67;
        }

        this.caretPath.transform-58bKbWc(this.transformationMatrix.getValue().unbox-impl());
        this.combinedPath.op-N5in7k0(this.tooltipPath, this.caretPath, PathOperation.Companion.getUnion-b3I0S0c());
        return new Generic(this.combinedPath);
    label_67:
        throw new NoWhenBranchMatchedException();
    label_70:
        throw new NoWhenBranchMatchedException();
    }

    public final Path getCaretPath() {
        return this.caretPath;
    }

    public final Path getCombinedPath() {
        return this.combinedPath;
    }

    public final Path getTooltipPath() {
        return this.tooltipPath;
    }
}

