package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BJ\u0012A\u0010\u0002\u001A=\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u000F\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016RI\u0010\u0002\u001A=\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003¢\u0006\u0002\b\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/shape/GenericShape;", "Landroidx/compose/ui/graphics/Shape;", "builder", "Lkotlin/Function3;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GenericShape implements Shape {
    public static final int $stable;
    private final Function3 builder;

    static {
    }

    public GenericShape(Function3 arg1) {
        super();
        this.builder = arg1;
    }

    public Outline createOutline-Pq9zytI(long arg1, LayoutDirection arg3, Density arg4) {
        Path v4 = AndroidPath_androidKt.Path();
        this.builder.invoke(v4, Size.box-impl(arg1), arg3);
        v4.close();
        return new Generic(v4);
    }

    public boolean equals(Object arg4) {
        if(this == (((GenericShape)arg4))) {
            return 1;
        }

        Function3 v2 = null;
        if((arg4 instanceof GenericShape)) {
        }
        else {
            arg4 = v2;
        }

        if(arg4 != null) {
            v2 = ((GenericShape)arg4).builder;
        }

        if(v2 == this.builder) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }
}

