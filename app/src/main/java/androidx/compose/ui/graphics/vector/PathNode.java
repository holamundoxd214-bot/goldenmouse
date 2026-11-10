package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\b\t\n\u000B\f\r\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001AB\u001D\b\u0004\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007\u0082\u0001\u0013\u001B\u001C\u001D\u001E\u001F !\"#$%&\'()*+,-¨\u0006."}, d2={"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "<init>", "(ZZ)V", "()Z", "Close", "RelativeMoveTo", "MoveTo", "RelativeLineTo", "LineTo", "RelativeHorizontalTo", "HorizontalTo", "RelativeVerticalTo", "VerticalTo", "RelativeCurveTo", "CurveTo", "RelativeReflectiveCurveTo", "ReflectiveCurveTo", "RelativeQuadTo", "QuadTo", "RelativeReflectiveQuadTo", "ReflectiveQuadTo", "RelativeArcTo", "ArcTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PathNode {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003JO\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EHÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000E¨\u0006#"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "<init>", "(FFFZZFF)V", "getHorizontalEllipseRadius", "()F", "getVerticalEllipseRadius", "getTheta", "()Z", "getArcStartX", "getArcStartY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ArcTo extends PathNode {
        public static final int $stable;
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        static {
        }

        public ArcTo(float arg4, float arg5, float arg6, boolean arg7, boolean arg8, float arg9, float arg10) {
            super(false, false, 3, null);
            this.horizontalEllipseRadius = arg4;
            this.verticalEllipseRadius = arg5;
            this.theta = arg6;
            this.isMoreThanHalf = arg7;
            this.isPositiveArc = arg8;
            this.arcStartX = arg9;
            this.arcStartY = arg10;
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartX;
        }

        public final float component7() {
            return this.arcStartY;
        }

        public final ArcTo copy(float arg1, float arg2, float arg3, boolean arg4, boolean arg5, float arg6, float arg7) {
            return new ArcTo(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public static ArcTo copy$default(ArcTo arg0, float arg1, float arg2, float arg3, boolean arg4, boolean arg5, float arg6, float arg7, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.horizontalEllipseRadius;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.verticalEllipseRadius;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.theta;
            }

            if((arg8 & 8) != 0) {
                arg4 = arg0.isMoreThanHalf;
            }

            if((arg8 & 16) != 0) {
                arg5 = arg0.isPositiveArc;
            }

            if((arg8 & 0x20) != 0) {
                arg6 = arg0.arcStartX;
            }

            if((arg8 & 0x40) != 0) {
                arg7 = arg0.arcStartY;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public boolean equals(Object arg5) {
            if(this == (((ArcTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ArcTo)) {
                return 0;
            }

            if(Float.compare(this.horizontalEllipseRadius, ((ArcTo)arg5).horizontalEllipseRadius) != 0) {
                return 0;
            }

            if(Float.compare(this.verticalEllipseRadius, ((ArcTo)arg5).verticalEllipseRadius) != 0) {
                return 0;
            }

            if(Float.compare(this.theta, ((ArcTo)arg5).theta) != 0) {
                return 0;
            }

            if(this.isMoreThanHalf != ((ArcTo)arg5).isMoreThanHalf) {
                return 0;
            }

            if(this.isPositiveArc != ((ArcTo)arg5).isPositiveArc) {
                return 0;
            }

            if(Float.compare(this.arcStartX, ((ArcTo)arg5).arcStartX) != 0) {
                return 0;
            }

            if(Float.compare(this.arcStartY, ((ArcTo)arg5).arcStartY) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.horizontalEllipseRadius) * 0x1F + Float.hashCode(this.verticalEllipseRadius)) * 0x1F + Float.hashCode(this.theta)) * 0x1F + Boolean.hashCode(this.isMoreThanHalf)) * 0x1F + Boolean.hashCode(this.isPositiveArc)) * 0x1F + Float.hashCode(this.arcStartX)) * 0x1F + Float.hashCode(this.arcStartY);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "<init>", "()V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Close extends PathNode {
        public static final int $stable;
        public static final Close INSTANCE;

        static {
            Close.INSTANCE = new Close();
        }

        private Close() {
            super(false, false, 3, null);
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CHÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006!"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "<init>", "(FFFFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "getX3", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CurveTo extends PathNode {
        public static final int $stable;
        private final float x1;
        private final float x2;
        private final float x3;
        private final float y1;
        private final float y2;
        private final float y3;

        static {
        }

        public CurveTo(float arg5, float arg6, float arg7, float arg8, float arg9, float arg10) {
            super(true, false, 2, null);
            this.x1 = arg5;
            this.y1 = arg6;
            this.x2 = arg7;
            this.y2 = arg8;
            this.x3 = arg9;
            this.y3 = arg10;
        }

        public final float component1() {
            return this.x1;
        }

        public final float component2() {
            return this.y1;
        }

        public final float component3() {
            return this.x2;
        }

        public final float component4() {
            return this.y2;
        }

        public final float component5() {
            return this.x3;
        }

        public final float component6() {
            return this.y3;
        }

        public final CurveTo copy(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
            return new CurveTo(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static CurveTo copy$default(CurveTo arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, int arg7, Object arg8) {
            if((arg7 & 1) != 0) {
                arg1 = arg0.x1;
            }

            if((arg7 & 2) != 0) {
                arg2 = arg0.y1;
            }

            if((arg7 & 4) != 0) {
                arg3 = arg0.x2;
            }

            if((arg7 & 8) != 0) {
                arg4 = arg0.y2;
            }

            if((arg7 & 16) != 0) {
                arg5 = arg0.x3;
            }

            if((arg7 & 0x20) != 0) {
                arg6 = arg0.y3;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public boolean equals(Object arg5) {
            if(this == (((CurveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof CurveTo)) {
                return 0;
            }

            if(Float.compare(this.x1, ((CurveTo)arg5).x1) != 0) {
                return 0;
            }

            if(Float.compare(this.y1, ((CurveTo)arg5).y1) != 0) {
                return 0;
            }

            if(Float.compare(this.x2, ((CurveTo)arg5).x2) != 0) {
                return 0;
            }

            if(Float.compare(this.y2, ((CurveTo)arg5).y2) != 0) {
                return 0;
            }

            if(Float.compare(this.x3, ((CurveTo)arg5).x3) != 0) {
                return 0;
            }

            if(Float.compare(this.y3, ((CurveTo)arg5).y3) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getX3() {
            return this.x3;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public final float getY3() {
            return this.y3;
        }

        public int hashCode() {
            return ((((Float.hashCode(this.x1) * 0x1F + Float.hashCode(this.y1)) * 0x1F + Float.hashCode(this.x2)) * 0x1F + Float.hashCode(this.y2)) * 0x1F + Float.hashCode(this.x3)) * 0x1F + Float.hashCode(this.y3);
        }

        public String toString() {
            return "CurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", x3=" + this.x3 + ", y3=" + this.y3 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "<init>", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HorizontalTo extends PathNode {
        public static final int $stable;
        private final float x;

        static {
        }

        public HorizontalTo(float arg4) {
            super(false, false, 3, null);
            this.x = arg4;
        }

        public final float component1() {
            return this.x;
        }

        public final HorizontalTo copy(float arg1) {
            return new HorizontalTo(arg1);
        }

        public static HorizontalTo copy$default(HorizontalTo arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.x;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((HorizontalTo)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof HorizontalTo)) {
                return 0;
            }

            if(Float.compare(this.x, ((HorizontalTo)arg4).x) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public int hashCode() {
            return Float.hashCode(this.x);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.x + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineTo extends PathNode {
        public static final int $stable;
        private final float x;
        private final float y;

        static {
        }

        public LineTo(float arg4, float arg5) {
            super(false, false, 3, null);
            this.x = arg4;
            this.y = arg5;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final LineTo copy(float arg1, float arg2) {
            return new LineTo(arg1, arg2);
        }

        public static LineTo copy$default(LineTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((LineTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof LineTo)) {
                return 0;
            }

            if(Float.compare(this.x, ((LineTo)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((LineTo)arg5).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
        }

        public String toString() {
            return "LineTo(x=" + this.x + ", y=" + this.y + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MoveTo extends PathNode {
        public static final int $stable;
        private final float x;
        private final float y;

        static {
        }

        public MoveTo(float arg4, float arg5) {
            super(false, false, 3, null);
            this.x = arg4;
            this.y = arg5;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final MoveTo copy(float arg1, float arg2) {
            return new MoveTo(arg1, arg2);
        }

        public static MoveTo copy$default(MoveTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((MoveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof MoveTo)) {
                return 0;
            }

            if(Float.compare(this.x, ((MoveTo)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((MoveTo)arg5).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
        }

        public String toString() {
            return "MoveTo(x=" + this.x + ", y=" + this.y + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class QuadTo extends PathNode {
        public static final int $stable;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        static {
        }

        public QuadTo(float arg4, float arg5, float arg6, float arg7) {
            super(false, true, 1, null);
            this.x1 = arg4;
            this.y1 = arg5;
            this.x2 = arg6;
            this.y2 = arg7;
        }

        public final float component1() {
            return this.x1;
        }

        public final float component2() {
            return this.y1;
        }

        public final float component3() {
            return this.x2;
        }

        public final float component4() {
            return this.y2;
        }

        public final QuadTo copy(float arg1, float arg2, float arg3, float arg4) {
            return new QuadTo(arg1, arg2, arg3, arg4);
        }

        public static QuadTo copy$default(QuadTo arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.x1;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.y1;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.x2;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.y2;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((QuadTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof QuadTo)) {
                return 0;
            }

            if(Float.compare(this.x1, ((QuadTo)arg5).x1) != 0) {
                return 0;
            }

            if(Float.compare(this.y1, ((QuadTo)arg5).y1) != 0) {
                return 0;
            }

            if(Float.compare(this.x2, ((QuadTo)arg5).x2) != 0) {
                return 0;
            }

            if(Float.compare(this.y2, ((QuadTo)arg5).y2) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public int hashCode() {
            return ((Float.hashCode(this.x1) * 0x1F + Float.hashCode(this.y1)) * 0x1F + Float.hashCode(this.x2)) * 0x1F + Float.hashCode(this.y2);
        }

        public String toString() {
            return "QuadTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "getX1", "()F", "getY1", "getX2", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReflectiveCurveTo extends PathNode {
        public static final int $stable;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        static {
        }

        public ReflectiveCurveTo(float arg5, float arg6, float arg7, float arg8) {
            super(true, false, 2, null);
            this.x1 = arg5;
            this.y1 = arg6;
            this.x2 = arg7;
            this.y2 = arg8;
        }

        public final float component1() {
            return this.x1;
        }

        public final float component2() {
            return this.y1;
        }

        public final float component3() {
            return this.x2;
        }

        public final float component4() {
            return this.y2;
        }

        public final ReflectiveCurveTo copy(float arg1, float arg2, float arg3, float arg4) {
            return new ReflectiveCurveTo(arg1, arg2, arg3, arg4);
        }

        public static ReflectiveCurveTo copy$default(ReflectiveCurveTo arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.x1;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.y1;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.x2;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.y2;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((ReflectiveCurveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ReflectiveCurveTo)) {
                return 0;
            }

            if(Float.compare(this.x1, ((ReflectiveCurveTo)arg5).x1) != 0) {
                return 0;
            }

            if(Float.compare(this.y1, ((ReflectiveCurveTo)arg5).y1) != 0) {
                return 0;
            }

            if(Float.compare(this.x2, ((ReflectiveCurveTo)arg5).x2) != 0) {
                return 0;
            }

            if(Float.compare(this.y2, ((ReflectiveCurveTo)arg5).y2) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public int hashCode() {
            return ((Float.hashCode(this.x1) * 0x1F + Float.hashCode(this.y1)) * 0x1F + Float.hashCode(this.x2)) * 0x1F + Float.hashCode(this.y2);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReflectiveQuadTo extends PathNode {
        public static final int $stable;
        private final float x;
        private final float y;

        static {
        }

        public ReflectiveQuadTo(float arg4, float arg5) {
            super(false, true, 1, null);
            this.x = arg4;
            this.y = arg5;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final ReflectiveQuadTo copy(float arg1, float arg2) {
            return new ReflectiveQuadTo(arg1, arg2);
        }

        public static ReflectiveQuadTo copy$default(ReflectiveQuadTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((ReflectiveQuadTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ReflectiveQuadTo)) {
                return 0;
            }

            if(Float.compare(this.x, ((ReflectiveQuadTo)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((ReflectiveQuadTo)arg5).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.x + ", y=" + this.y + ')';
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003JO\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EHÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000E¨\u0006#"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "<init>", "(FFFZZFF)V", "getHorizontalEllipseRadius", "()F", "getVerticalEllipseRadius", "getTheta", "()Z", "getArcStartDx", "getArcStartDy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeArcTo extends PathNode {
        public static final int $stable;
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        static {
        }

        public RelativeArcTo(float arg4, float arg5, float arg6, boolean arg7, boolean arg8, float arg9, float arg10) {
            super(false, false, 3, null);
            this.horizontalEllipseRadius = arg4;
            this.verticalEllipseRadius = arg5;
            this.theta = arg6;
            this.isMoreThanHalf = arg7;
            this.isPositiveArc = arg8;
            this.arcStartDx = arg9;
            this.arcStartDy = arg10;
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartDx;
        }

        public final float component7() {
            return this.arcStartDy;
        }

        public final RelativeArcTo copy(float arg1, float arg2, float arg3, boolean arg4, boolean arg5, float arg6, float arg7) {
            return new RelativeArcTo(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public static RelativeArcTo copy$default(RelativeArcTo arg0, float arg1, float arg2, float arg3, boolean arg4, boolean arg5, float arg6, float arg7, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.horizontalEllipseRadius;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.verticalEllipseRadius;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.theta;
            }

            if((arg8 & 8) != 0) {
                arg4 = arg0.isMoreThanHalf;
            }

            if((arg8 & 16) != 0) {
                arg5 = arg0.isPositiveArc;
            }

            if((arg8 & 0x20) != 0) {
                arg6 = arg0.arcStartDx;
            }

            if((arg8 & 0x40) != 0) {
                arg7 = arg0.arcStartDy;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeArcTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeArcTo)) {
                return 0;
            }

            if(Float.compare(this.horizontalEllipseRadius, ((RelativeArcTo)arg5).horizontalEllipseRadius) != 0) {
                return 0;
            }

            if(Float.compare(this.verticalEllipseRadius, ((RelativeArcTo)arg5).verticalEllipseRadius) != 0) {
                return 0;
            }

            if(Float.compare(this.theta, ((RelativeArcTo)arg5).theta) != 0) {
                return 0;
            }

            if(this.isMoreThanHalf != ((RelativeArcTo)arg5).isMoreThanHalf) {
                return 0;
            }

            if(this.isPositiveArc != ((RelativeArcTo)arg5).isPositiveArc) {
                return 0;
            }

            if(Float.compare(this.arcStartDx, ((RelativeArcTo)arg5).arcStartDx) != 0) {
                return 0;
            }

            if(Float.compare(this.arcStartDy, ((RelativeArcTo)arg5).arcStartDy) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.horizontalEllipseRadius) * 0x1F + Float.hashCode(this.verticalEllipseRadius)) * 0x1F + Float.hashCode(this.theta)) * 0x1F + Boolean.hashCode(this.isMoreThanHalf)) * 0x1F + Boolean.hashCode(this.isPositiveArc)) * 0x1F + Float.hashCode(this.arcStartDx)) * 0x1F + Float.hashCode(this.arcStartDy);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CHÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006!"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "<init>", "(FFFFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "getDx3", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeCurveTo extends PathNode {
        public static final int $stable;
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        static {
        }

        public RelativeCurveTo(float arg5, float arg6, float arg7, float arg8, float arg9, float arg10) {
            super(true, false, 2, null);
            this.dx1 = arg5;
            this.dy1 = arg6;
            this.dx2 = arg7;
            this.dy2 = arg8;
            this.dx3 = arg9;
            this.dy3 = arg10;
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final float component5() {
            return this.dx3;
        }

        public final float component6() {
            return this.dy3;
        }

        public final RelativeCurveTo copy(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
            return new RelativeCurveTo(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static RelativeCurveTo copy$default(RelativeCurveTo arg0, float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, int arg7, Object arg8) {
            if((arg7 & 1) != 0) {
                arg1 = arg0.dx1;
            }

            if((arg7 & 2) != 0) {
                arg2 = arg0.dy1;
            }

            if((arg7 & 4) != 0) {
                arg3 = arg0.dx2;
            }

            if((arg7 & 8) != 0) {
                arg4 = arg0.dy2;
            }

            if((arg7 & 16) != 0) {
                arg5 = arg0.dx3;
            }

            if((arg7 & 0x20) != 0) {
                arg6 = arg0.dy3;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeCurveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeCurveTo)) {
                return 0;
            }

            if(Float.compare(this.dx1, ((RelativeCurveTo)arg5).dx1) != 0) {
                return 0;
            }

            if(Float.compare(this.dy1, ((RelativeCurveTo)arg5).dy1) != 0) {
                return 0;
            }

            if(Float.compare(this.dx2, ((RelativeCurveTo)arg5).dx2) != 0) {
                return 0;
            }

            if(Float.compare(this.dy2, ((RelativeCurveTo)arg5).dy2) != 0) {
                return 0;
            }

            if(Float.compare(this.dx3, ((RelativeCurveTo)arg5).dx3) != 0) {
                return 0;
            }

            if(Float.compare(this.dy3, ((RelativeCurveTo)arg5).dy3) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return ((((Float.hashCode(this.dx1) * 0x1F + Float.hashCode(this.dy1)) * 0x1F + Float.hashCode(this.dx2)) * 0x1F + Float.hashCode(this.dy2)) * 0x1F + Float.hashCode(this.dx3)) * 0x1F + Float.hashCode(this.dy3);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "<init>", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeHorizontalTo extends PathNode {
        public static final int $stable;
        private final float dx;

        static {
        }

        public RelativeHorizontalTo(float arg4) {
            super(false, false, 3, null);
            this.dx = arg4;
        }

        public final float component1() {
            return this.dx;
        }

        public final RelativeHorizontalTo copy(float arg1) {
            return new RelativeHorizontalTo(arg1);
        }

        public static RelativeHorizontalTo copy$default(RelativeHorizontalTo arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.dx;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((RelativeHorizontalTo)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof RelativeHorizontalTo)) {
                return 0;
            }

            if(Float.compare(this.dx, ((RelativeHorizontalTo)arg4).dx) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx() {
            return this.dx;
        }

        public int hashCode() {
            return Float.hashCode(this.dx);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.dx + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeLineTo extends PathNode {
        public static final int $stable;
        private final float dx;
        private final float dy;

        static {
        }

        public RelativeLineTo(float arg4, float arg5) {
            super(false, false, 3, null);
            this.dx = arg4;
            this.dy = arg5;
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        public final RelativeLineTo copy(float arg1, float arg2) {
            return new RelativeLineTo(arg1, arg2);
        }

        public static RelativeLineTo copy$default(RelativeLineTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.dx;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.dy;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeLineTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeLineTo)) {
                return 0;
            }

            if(Float.compare(this.dx, ((RelativeLineTo)arg5).dx) != 0) {
                return 0;
            }

            if(Float.compare(this.dy, ((RelativeLineTo)arg5).dy) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dx) * 0x1F + Float.hashCode(this.dy);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeMoveTo extends PathNode {
        public static final int $stable;
        private final float dx;
        private final float dy;

        static {
        }

        public RelativeMoveTo(float arg4, float arg5) {
            super(false, false, 3, null);
            this.dx = arg4;
            this.dy = arg5;
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        public final RelativeMoveTo copy(float arg1, float arg2) {
            return new RelativeMoveTo(arg1, arg2);
        }

        public static RelativeMoveTo copy$default(RelativeMoveTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.dx;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.dy;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeMoveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeMoveTo)) {
                return 0;
            }

            if(Float.compare(this.dx, ((RelativeMoveTo)arg5).dx) != 0) {
                return 0;
            }

            if(Float.compare(this.dy, ((RelativeMoveTo)arg5).dy) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dx) * 0x1F + Float.hashCode(this.dy);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "<init>", "(FFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeQuadTo extends PathNode {
        public static final int $stable;
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        static {
        }

        public RelativeQuadTo(float arg4, float arg5, float arg6, float arg7) {
            super(false, true, 1, null);
            this.dx1 = arg4;
            this.dy1 = arg5;
            this.dx2 = arg6;
            this.dy2 = arg7;
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final RelativeQuadTo copy(float arg1, float arg2, float arg3, float arg4) {
            return new RelativeQuadTo(arg1, arg2, arg3, arg4);
        }

        public static RelativeQuadTo copy$default(RelativeQuadTo arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.dx1;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.dy1;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.dx2;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.dy2;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeQuadTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeQuadTo)) {
                return 0;
            }

            if(Float.compare(this.dx1, ((RelativeQuadTo)arg5).dx1) != 0) {
                return 0;
            }

            if(Float.compare(this.dy1, ((RelativeQuadTo)arg5).dy1) != 0) {
                return 0;
            }

            if(Float.compare(this.dx2, ((RelativeQuadTo)arg5).dx2) != 0) {
                return 0;
            }

            if(Float.compare(this.dy2, ((RelativeQuadTo)arg5).dy2) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return ((Float.hashCode(this.dx1) * 0x1F + Float.hashCode(this.dy1)) * 0x1F + Float.hashCode(this.dx2)) * 0x1F + Float.hashCode(this.dy2);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "<init>", "(FFFF)V", "getDx1", "()F", "getDy1", "getDx2", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeReflectiveCurveTo extends PathNode {
        public static final int $stable;
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        static {
        }

        public RelativeReflectiveCurveTo(float arg5, float arg6, float arg7, float arg8) {
            super(true, false, 2, null);
            this.dx1 = arg5;
            this.dy1 = arg6;
            this.dx2 = arg7;
            this.dy2 = arg8;
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final RelativeReflectiveCurveTo copy(float arg1, float arg2, float arg3, float arg4) {
            return new RelativeReflectiveCurveTo(arg1, arg2, arg3, arg4);
        }

        public static RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.dx1;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.dy1;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.dx2;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.dy2;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeReflectiveCurveTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeReflectiveCurveTo)) {
                return 0;
            }

            if(Float.compare(this.dx1, ((RelativeReflectiveCurveTo)arg5).dx1) != 0) {
                return 0;
            }

            if(Float.compare(this.dy1, ((RelativeReflectiveCurveTo)arg5).dy1) != 0) {
                return 0;
            }

            if(Float.compare(this.dx2, ((RelativeReflectiveCurveTo)arg5).dx2) != 0) {
                return 0;
            }

            if(Float.compare(this.dy2, ((RelativeReflectiveCurveTo)arg5).dy2) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return ((Float.hashCode(this.dx1) * 0x1F + Float.hashCode(this.dy1)) * 0x1F + Float.hashCode(this.dx2)) * 0x1F + Float.hashCode(this.dy2);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "<init>", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeReflectiveQuadTo extends PathNode {
        public static final int $stable;
        private final float dx;
        private final float dy;

        static {
        }

        public RelativeReflectiveQuadTo(float arg4, float arg5) {
            super(false, true, 1, null);
            this.dx = arg4;
            this.dy = arg5;
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        public final RelativeReflectiveQuadTo copy(float arg1, float arg2) {
            return new RelativeReflectiveQuadTo(arg1, arg2);
        }

        public static RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.dx;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.dy;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((RelativeReflectiveQuadTo)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof RelativeReflectiveQuadTo)) {
                return 0;
            }

            if(Float.compare(this.dx, ((RelativeReflectiveQuadTo)arg5).dx) != 0) {
                return 0;
            }

            if(Float.compare(this.dy, ((RelativeReflectiveQuadTo)arg5).dy) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dx) * 0x1F + Float.hashCode(this.dy);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "<init>", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RelativeVerticalTo extends PathNode {
        public static final int $stable;
        private final float dy;

        static {
        }

        public RelativeVerticalTo(float arg4) {
            super(false, false, 3, null);
            this.dy = arg4;
        }

        public final float component1() {
            return this.dy;
        }

        public final RelativeVerticalTo copy(float arg1) {
            return new RelativeVerticalTo(arg1);
        }

        public static RelativeVerticalTo copy$default(RelativeVerticalTo arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.dy;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((RelativeVerticalTo)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof RelativeVerticalTo)) {
                return 0;
            }

            if(Float.compare(this.dy, ((RelativeVerticalTo)arg4).dy) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dy);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.dy + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "<init>", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VerticalTo extends PathNode {
        public static final int $stable;
        private final float y;

        static {
        }

        public VerticalTo(float arg4) {
            super(false, false, 3, null);
            this.y = arg4;
        }

        public final float component1() {
            return this.y;
        }

        public final VerticalTo copy(float arg1) {
            return new VerticalTo(arg1);
        }

        public static VerticalTo copy$default(VerticalTo arg0, float arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.y;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((VerticalTo)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof VerticalTo)) {
                return 0;
            }

            if(Float.compare(this.y, ((VerticalTo)arg4).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.y);
        }

        public String toString() {
            return "VerticalTo(y=" + this.y + ')';
        }
    }

    public static final int $stable;
    private final boolean isCurve;
    private final boolean isQuad;

    static {
    }

    private PathNode(boolean arg1, boolean arg2) {
        super();
        this.isCurve = arg1;
        this.isQuad = arg2;
    }

    public PathNode(boolean arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(false, false, null);
    }

    public PathNode(boolean arg1, boolean arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }
}

