package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\fHÖ\u0001J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2={"Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "constructor-impl", "(Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class BlurredEdgeTreatment {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/draw/BlurredEdgeTreatment$Companion;", "", "<init>", "()V", "Rectangle", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "getRectangle---Goahg", "()Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Shape;", "Unbounded", "getUnbounded---Goahg", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Shape getRectangle---Goahg() {
            return BlurredEdgeTreatment.Rectangle;
        }

        public final Shape getUnbounded---Goahg() {
            return BlurredEdgeTreatment.Unbounded;
        }
    }

    public static final Companion Companion;
    private static final Shape Rectangle;
    private static final Shape Unbounded;
    private final Shape shape;

    static {
        BlurredEdgeTreatment.Companion = new Companion(null);
        BlurredEdgeTreatment.Rectangle = BlurredEdgeTreatment.constructor-impl(RectangleShapeKt.getRectangleShape());
        BlurredEdgeTreatment.Unbounded = BlurredEdgeTreatment.constructor-impl(null);
    }

    private BlurredEdgeTreatment(Shape arg1) {
        super();
        this.shape = arg1;
    }

    public static final Shape access$getRectangle$cp() {
        return BlurredEdgeTreatment.Rectangle;
    }

    public static final Shape access$getUnbounded$cp() {
        return BlurredEdgeTreatment.Unbounded;
    }

    public static final BlurredEdgeTreatment box-impl(Shape arg1) {
        return new BlurredEdgeTreatment(arg1);
    }

    public static Shape constructor-impl(Shape arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return BlurredEdgeTreatment.equals-impl(this.shape, arg1);
    }

    public static boolean equals-impl(Shape arg2, Object arg3) {
        if(!(arg3 instanceof BlurredEdgeTreatment)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((BlurredEdgeTreatment)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Shape arg0, Shape arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return BlurredEdgeTreatment.hashCode-impl(this.shape);
    }

    public static int hashCode-impl(Shape arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public String toString() {
        return BlurredEdgeTreatment.toString-impl(this.shape);
    }

    public static String toString-impl(Shape arg2) {
        return "BlurredEdgeTreatment(shape=" + arg2 + ')';
    }

    public final Shape unbox-impl() {
        return this.shape;
    }
}

