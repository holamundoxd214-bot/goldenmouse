package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJU\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u001E\u0010\u001FJ\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001A\u00020%H\u0016J\b\u0010&\u001A\u00020\'H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0016\u0010\u0013R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001C¨\u0006)"}, d2={"Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "padding", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getWidth-XSAIIZE", "()J", "J", "getHeight-XSAIIZE", "getPadding-XSAIIZE", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getAlpha", "()F", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "copy", "copy-w_4Rhrw", "(Landroidx/compose/ui/graphics/Shape;JJJLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/Bullet;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Bullet implements Annotation {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/Bullet$Companion;", "", "<init>", "()V", "DefaultIndentation", "Landroidx/compose/ui/unit/TextUnit;", "getDefaultIndentation-XSAIIZE", "()J", "J", "DefaultSize", "getDefaultSize-XSAIIZE", "DefaultPadding", "getDefaultPadding-XSAIIZE", "Default", "Landroidx/compose/ui/text/Bullet;", "getDefault", "()Landroidx/compose/ui/text/Bullet;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Bullet getDefault() {
            return Bullet.Default;
        }

        public final long getDefaultIndentation-XSAIIZE() {
            return Bullet.DefaultIndentation;
        }

        public final long getDefaultPadding-XSAIIZE() {
            return Bullet.DefaultPadding;
        }

        public final long getDefaultSize-XSAIIZE() {
            return Bullet.DefaultSize;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Bullet Default;
    private static final long DefaultIndentation;
    private static final long DefaultPadding;
    private static final long DefaultSize;
    private final float alpha;
    private final Brush brush;
    private final DrawStyle drawStyle;
    private final long height;
    private final long padding;
    private final Shape shape;
    private final long width;

    static {
        Bullet.Companion = new Companion(null);
        Bullet.$stable = DrawStyle.$stable;
        Bullet.DefaultIndentation = TextUnitKt.getEm(1);
        long v4 = TextUnitKt.getEm(0.25);
        Bullet.DefaultSize = v4;
        long v8 = TextUnitKt.getEm(0.25);
        Bullet.DefaultPadding = v8;
        Bullet.Default = new Bullet(CircleShape.INSTANCE, v4, v4, v8, null, 0f, null, 0x70, null);
    }

    public Bullet(Shape arg14, long arg15, long arg17, long arg19, Brush arg21, float arg22, DrawStyle arg23, int arg24, DefaultConstructorMarker arg25) {
        DrawStyle v11_1;
        Brush v9 = (arg24 & 16) != 0 ? null : arg21;
        float v10 = (arg24 & 0x20) != 0 ? NaNf : arg22;
        if((arg24 & 0x40) != 0) {
            Fill v11 = Fill.INSTANCE;
        }
        else {
            v11_1 = arg23;
        }

        this(arg14, arg15, arg17, arg19, v9, v10, v11_1, null);
    }

    private Bullet(Shape arg1, long arg2, long arg4, long arg6, Brush arg8, float arg9, DrawStyle arg10) {
        super();
        this.shape = arg1;
        this.width = arg2;
        this.height = arg4;
        this.padding = arg6;
        this.brush = arg8;
        this.alpha = arg9;
        this.drawStyle = arg10;
    }

    public Bullet(Shape arg1, long arg2, long arg4, long arg6, Brush arg8, float arg9, DrawStyle arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg4, arg6, arg8, arg9, arg10);
    }

    public static final Bullet access$getDefault$cp() {
        return Bullet.Default;
    }

    public static final long access$getDefaultIndentation$cp() {
        return Bullet.DefaultIndentation;
    }

    public static final long access$getDefaultPadding$cp() {
        return Bullet.DefaultPadding;
    }

    public static final long access$getDefaultSize$cp() {
        return Bullet.DefaultSize;
    }

    public final Bullet copy-w_4Rhrw(Shape arg13, long arg14, long arg16, long arg18, Brush arg20, float arg21, DrawStyle arg22) {
        return new Bullet(arg13, arg14, arg16, arg18, arg20, arg21, arg22, null);
    }

    public static Bullet copy-w_4Rhrw$default(Bullet arg0, Shape arg1, long arg2, long arg4, long arg6, Brush arg8, float arg9, DrawStyle arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = arg0.shape;
        }

        if((arg11 & 2) != 0) {
            arg2 = arg0.width;
        }

        if((arg11 & 4) != 0) {
            arg4 = arg0.height;
        }

        if((arg11 & 8) != 0) {
            arg6 = arg0.padding;
        }

        if((arg11 & 16) != 0) {
            arg8 = arg0.brush;
        }

        if((arg11 & 0x20) != 0) {
            arg9 = arg0.alpha;
        }

        if((arg11 & 0x40) != 0) {
            arg10 = arg0.drawStyle;
        }

        return arg0.copy-w_4Rhrw(arg1, arg2, arg4, arg6, arg8, arg9, arg10);
    }

    public boolean equals(Object arg7) {
        if(this == (((Bullet)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof Bullet)) {
            }
            else if(!Intrinsics.areEqual(this.shape, ((Bullet)arg7).shape)) {
                return 0;
            }
            else if(!TextUnit.equals-impl0(this.width, ((Bullet)arg7).width)) {
                return 0;
            }
            else if(!TextUnit.equals-impl0(this.height, ((Bullet)arg7).height)) {
                return 0;
            }
            else if(!TextUnit.equals-impl0(this.padding, ((Bullet)arg7).padding)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.brush, ((Bullet)arg7).brush)) {
                return 0;
            }
            else if(this.alpha == ((Bullet)arg7).alpha) {
                if(!Intrinsics.areEqual(this.drawStyle, ((Bullet)arg7).drawStyle)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public final long getHeight-XSAIIZE() {
        return this.height;
    }

    public final long getPadding-XSAIIZE() {
        return this.padding;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final long getWidth-XSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        int v0 = (((this.shape.hashCode() * 0x1F + TextUnit.hashCode-impl(this.width)) * 0x1F + TextUnit.hashCode-impl(this.height)) * 0x1F + TextUnit.hashCode-impl(this.padding)) * 0x1F;
        Brush v1 = this.brush;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return ((v0 + v1_1) * 0x1F + Float.hashCode(this.alpha)) * 0x1F + this.drawStyle.hashCode();
    }

    public String toString() {
        return "Bullet(shape=" + this.shape + ", size=(" + TextUnit.toString-impl(this.width) + ", " + TextUnit.toString-impl(this.height) + "), padding=" + TextUnit.toString-impl(this.padding) + ", brush=" + this.brush + ", alpha=" + this.alpha + ", drawStyle=" + this.drawStyle + ')';
    }
}

