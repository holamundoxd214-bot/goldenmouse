package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u009B\u0001\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000E\u001A\u00020\f\u0012\b\b\u0002\u0010\u000F\u001A\u00020\f\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\f\u0012\b\b\u0002\u0010\u0015\u001A\u00020\f\u0012\b\b\u0002\u0010\u0016\u001A\u00020\f\u0012\b\b\u0002\u0010\u0017\u001A\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010.\u001A\u00020/2\b\u00100\u001A\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001A\u000203H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0013\u0010\r\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\"R\u0011\u0010\u000E\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b&\u0010$R\u0011\u0010\u000F\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010$R\u0013\u0010\u0010\u001A\u00020\u0011¢\u0006\n\n\u0002\u0010 \u001A\u0004\b(\u0010\u001FR\u0013\u0010\u0012\u001A\u00020\u0013¢\u0006\n\n\u0002\u0010 \u001A\u0004\b)\u0010\u001FR\u0011\u0010\u0014\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b*\u0010$R\u0011\u0010\u0015\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b+\u0010$R\u0011\u0010\u0016\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b,\u0010$R\u0011\u0010\u0017\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b-\u0010$¨\u00064"}, d2={"Landroidx/compose/ui/graphics/vector/VectorPath;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "name", "", "pathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "<init>", "(Ljava/lang/String;Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getPathData", "()Ljava/util/List;", "getPathFillType-Rg-k1Os", "()I", "I", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "getFillAlpha", "()F", "getStroke", "getStrokeAlpha", "getStrokeLineWidth", "getStrokeLineCap-KaPHkGw", "getStrokeLineJoin-LxFBmk8", "getStrokeLineMiter", "getTrimPathStart", "getTrimPathEnd", "getTrimPathOffset", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorPath extends VectorNode {
    public static final int $stable;
    private final Brush fill;
    private final float fillAlpha;
    private final String name;
    private final List pathData;
    private final int pathFillType;
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;

    static {
    }

    public VectorPath(String arg1, List arg2, int arg3, Brush arg4, float arg5, Brush arg6, float arg7, float arg8, int arg9, int arg10, float arg11, float arg12, float arg13, float arg14, DefaultConstructorMarker arg15) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    private VectorPath(String arg2, List arg3, int arg4, Brush arg5, float arg6, Brush arg7, float arg8, float arg9, int arg10, int arg11, float arg12, float arg13, float arg14, float arg15) {
        super(null);
        this.name = arg2;
        this.pathData = arg3;
        this.pathFillType = arg4;
        this.fill = arg5;
        this.fillAlpha = arg6;
        this.stroke = arg7;
        this.strokeAlpha = arg8;
        this.strokeLineWidth = arg9;
        this.strokeLineCap = arg10;
        this.strokeLineJoin = arg11;
        this.strokeLineMiter = arg12;
        this.trimPathStart = arg13;
        this.trimPathEnd = arg14;
        this.trimPathOffset = arg15;
    }

    public VectorPath(String arg19, List arg20, int arg21, Brush arg22, float arg23, Brush arg24, float arg25, float arg26, int arg27, int arg28, float arg29, float arg30, float arg31, float arg32, int arg33, DefaultConstructorMarker arg34) {
        int v0 = arg33;
        String v3 = (v0 & 1) != 0 ? "" : arg19;
        Brush v2 = null;
        Brush v6 = (v0 & 8) != 0 ? v2 : arg22;
        float v4 = 1f;
        float v7 = (v0 & 16) != 0 ? v4 : arg23;
        Brush v8 = (v0 & 0x20) != 0 ? v2 : arg24;
        float v9 = (v0 & 0x40) != 0 ? v4 : arg25;
        float v10 = (v0 & 0x80) != 0 ? 0f : arg26;
        int v11 = (v0 & 0x100) != 0 ? VectorKt.getDefaultStrokeLineCap() : arg27;
        int v12 = (v0 & 0x200) != 0 ? VectorKt.getDefaultStrokeLineJoin() : arg28;
        float v13 = (v0 & 0x400) != 0 ? 4f : arg29;
        float v14 = (v0 & 0x800) != 0 ? 0f : arg30;
        float v15 = (v0 & 0x1000) != 0 ? v4 : arg31;
        float v16 = (v0 & 0x2000) != 0 ? 0f : arg32;
        this(v3, arg20, arg21, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((VectorPath)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(!Intrinsics.areEqual(this.name, ((VectorPath)arg5).name)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.fill, ((VectorPath)arg5).fill)) {
                return 0;
            }
            else if(this.fillAlpha == ((VectorPath)arg5).fillAlpha) {
                if(!Intrinsics.areEqual(this.stroke, ((VectorPath)arg5).stroke)) {
                    return 0;
                }
                else if(this.strokeAlpha == ((VectorPath)arg5).strokeAlpha && this.strokeLineWidth == ((VectorPath)arg5).strokeLineWidth) {
                    if(!StrokeCap.equals-impl0(this.strokeLineCap, ((VectorPath)arg5).strokeLineCap)) {
                        return 0;
                    }
                    else if(!StrokeJoin.equals-impl0(this.strokeLineJoin, ((VectorPath)arg5).strokeLineJoin)) {
                        return 0;
                    }
                    else if(this.strokeLineMiter == ((VectorPath)arg5).strokeLineMiter && this.trimPathStart == ((VectorPath)arg5).trimPathStart && this.trimPathEnd == ((VectorPath)arg5).trimPathEnd && this.trimPathOffset == ((VectorPath)arg5).trimPathOffset) {
                        if(!PathFillType.equals-impl0(this.pathFillType, ((VectorPath)arg5).pathFillType)) {
                            return 0;
                        }
                        else if(!Intrinsics.areEqual(this.pathData, ((VectorPath)arg5).pathData)) {
                            return 0;
                        }
                        else {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    public final String getName() {
        return this.name;
    }

    public final List getPathData() {
        return this.pathData;
    }

    public final int getPathFillType-Rg-k1Os() {
        return this.pathFillType;
    }

    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public final int getStrokeLineCap-KaPHkGw() {
        return this.strokeLineCap;
    }

    public final int getStrokeLineJoin-LxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public int hashCode() {
        int v0 = (this.name.hashCode() * 0x1F + this.pathData.hashCode()) * 0x1F;
        Brush v1 = this.fill;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + Float.hashCode(this.fillAlpha)) * 0x1F;
        v1 = this.stroke;
        if(v1 != null) {
            v2 = v1.hashCode();
        }

        return (((((((((v0 + v2) * 0x1F + Float.hashCode(this.strokeAlpha)) * 0x1F + Float.hashCode(this.strokeLineWidth)) * 0x1F + StrokeCap.hashCode-impl(this.strokeLineCap)) * 0x1F + StrokeJoin.hashCode-impl(this.strokeLineJoin)) * 0x1F + Float.hashCode(this.strokeLineMiter)) * 0x1F + Float.hashCode(this.trimPathStart)) * 0x1F + Float.hashCode(this.trimPathEnd)) * 0x1F + Float.hashCode(this.trimPathOffset)) * 0x1F + PathFillType.hashCode-impl(this.pathFillType);
    }
}

