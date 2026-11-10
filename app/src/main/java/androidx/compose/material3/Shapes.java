package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001BY\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fB;\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\rJ]\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003H\u0000¢\u0006\u0002\b\u0018J8\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u0003J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001A\u00020#H\u0016J\b\u0010$\u001A\u00020%H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0014\u0010\b\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000FR\u0014\u0010\t\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000FR\u0014\u0010\n\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000FR\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006&"}, d2={"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "largeIncreased", "extraLargeIncreased", "extraExtraLarge", "<init>", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getSmall", "getMedium", "getLarge", "getExtraLarge", "getLargeIncreased$material3", "getExtraLargeIncreased$material3", "getExtraExtraLarge$material3", "copy", "copy$material3", "defaultVerticalDragHandleShapesCached", "Landroidx/compose/material3/DragHandleShapes;", "getDefaultVerticalDragHandleShapesCached$material3", "()Landroidx/compose/material3/DragHandleShapes;", "setDefaultVerticalDragHandleShapesCached$material3", "(Landroidx/compose/material3/DragHandleShapes;)V", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Shapes {
    public static final int $stable;
    private DragHandleShapes defaultVerticalDragHandleShapesCached;
    private final CornerBasedShape extraExtraLarge;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraLargeIncreased;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape largeIncreased;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    static {
    }

    public Shapes() {
        this(null, null, null, null, null, null, null, null, 0xFF, null);
    }

    public Shapes(CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, CornerBasedShape arg6, CornerBasedShape arg7, CornerBasedShape arg8, int arg9, DefaultConstructorMarker arg10) {
        if((arg9 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getExtraSmall();
        }

        if((arg9 & 2) != 0) {
            arg2 = ShapeDefaults.INSTANCE.getSmall();
        }

        if((arg9 & 4) != 0) {
            arg3 = ShapeDefaults.INSTANCE.getMedium();
        }

        if((arg9 & 8) != 0) {
            arg4 = ShapeDefaults.INSTANCE.getLarge();
        }

        if((arg9 & 16) != 0) {
            arg5 = ShapeDefaults.INSTANCE.getExtraLarge();
        }

        if((arg9 & 0x20) != 0) {
            arg6 = ShapeDefaults.INSTANCE.getLargeIncreased$material3();
        }

        if((arg9 & 0x40) != 0) {
            arg7 = ShapeDefaults.INSTANCE.getExtraLargeIncreased$material3();
        }

        if((arg9 & 0x80) != 0) {
            arg8 = ShapeDefaults.INSTANCE.getExtraExtraLarge$material3();
        }

        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public Shapes(CornerBasedShape arg11, CornerBasedShape arg12, CornerBasedShape arg13, CornerBasedShape arg14, CornerBasedShape arg15) {
        this(arg11, arg12, arg13, arg14, arg15, ShapeDefaults.INSTANCE.getLargeIncreased$material3(), ShapeDefaults.INSTANCE.getExtraLargeIncreased$material3(), ShapeDefaults.INSTANCE.getExtraExtraLarge$material3());
    }

    public Shapes(CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, CornerBasedShape arg6, CornerBasedShape arg7, CornerBasedShape arg8) {
        super();
        this.extraSmall = arg1;
        this.small = arg2;
        this.medium = arg3;
        this.large = arg4;
        this.extraLarge = arg5;
        this.largeIncreased = arg6;
        this.extraLargeIncreased = arg7;
        this.extraExtraLarge = arg8;
    }

    public Shapes(CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getExtraSmall();
        }

        if((arg6 & 2) != 0) {
            arg2 = ShapeDefaults.INSTANCE.getSmall();
        }

        if((arg6 & 4) != 0) {
            arg3 = ShapeDefaults.INSTANCE.getMedium();
        }

        if((arg6 & 8) != 0) {
            arg4 = ShapeDefaults.INSTANCE.getLarge();
        }

        if((arg6 & 16) != 0) {
            arg5 = ShapeDefaults.INSTANCE.getExtraLarge();
        }

        this(arg1, arg2, arg3, arg4, arg5);
    }

    public final Shapes copy(CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5) {
        return new Shapes(arg1, arg2, arg3, arg4, arg5);
    }

    public static Shapes copy$default(Shapes arg0, CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.extraSmall;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.small;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.medium;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.large;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.extraLarge;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public final Shapes copy$material3(CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, CornerBasedShape arg6, CornerBasedShape arg7, CornerBasedShape arg8) {
        return new Shapes(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static Shapes copy$material3$default(Shapes arg0, CornerBasedShape arg1, CornerBasedShape arg2, CornerBasedShape arg3, CornerBasedShape arg4, CornerBasedShape arg5, CornerBasedShape arg6, CornerBasedShape arg7, CornerBasedShape arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.extraSmall;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.small;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.medium;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.large;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.extraLarge;
        }

        if((arg9 & 0x20) != 0) {
            arg6 = arg0.largeIncreased;
        }

        if((arg9 & 0x40) != 0) {
            arg7 = arg0.extraLargeIncreased;
        }

        if((arg9 & 0x80) != 0) {
            arg8 = arg0.extraExtraLarge;
        }

        return arg0.copy$material3(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public boolean equals(Object arg5) {
        if(this == (((Shapes)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Shapes)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.extraSmall, ((Shapes)arg5).extraSmall)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.small, ((Shapes)arg5).small)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.medium, ((Shapes)arg5).medium)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.large, ((Shapes)arg5).large)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.extraLarge, ((Shapes)arg5).extraLarge)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.largeIncreased, ((Shapes)arg5).largeIncreased)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.extraLargeIncreased, ((Shapes)arg5).extraLargeIncreased)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.extraExtraLarge, ((Shapes)arg5).extraExtraLarge)) {
            return 0;
        }

        return 1;
    }

    public final DragHandleShapes getDefaultVerticalDragHandleShapesCached$material3() {
        return this.defaultVerticalDragHandleShapesCached;
    }

    public final CornerBasedShape getExtraExtraLarge$material3() {
        return this.extraExtraLarge;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public final CornerBasedShape getExtraLargeIncreased$material3() {
        return this.extraLargeIncreased;
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getLargeIncreased$material3() {
        return this.largeIncreased;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public int hashCode() {
        return ((((((this.extraSmall.hashCode() * 0x1F + this.small.hashCode()) * 0x1F + this.medium.hashCode()) * 0x1F + this.large.hashCode()) * 0x1F + this.extraLarge.hashCode()) * 0x1F + this.largeIncreased.hashCode()) * 0x1F + this.extraLargeIncreased.hashCode()) * 0x1F + this.extraExtraLarge.hashCode();
    }

    public final void setDefaultVerticalDragHandleShapesCached$material3(DragHandleShapes arg1) {
        this.defaultVerticalDragHandleShapesCached = arg1;
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", largeIncreased=" + this.largeIncreased + ", extraLarge=" + this.extraLarge + ", extralargeIncreased=" + this.extraLargeIncreased + ", extraExtraLarge=" + this.extraExtraLarge + ')';
    }
}

