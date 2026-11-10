package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010U\u001A\u00020VH\u0002J\b\u0010W\u001A\u00020VH\u0002J\f\u0010X\u001A\u00020V*\u00020YH\u0016J\b\u0010Z\u001A\u00020\u0005H\u0016R$\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0004\u001A\u0004\u0018\u00010\u000B@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR&\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0004\u001A\u00020\u001E@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0014\"\u0004\b\'\u0010\u0016R$\u0010(\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R(\u0010+\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0004\u001A\u0004\u0018\u00010\u000B@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u000E\"\u0004\b-\u0010\u0010R&\u0010/\u001A\u00020.2\u0006\u0010\u0004\u001A\u00020.@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\b0\u0010!\"\u0004\b1\u0010#R&\u00103\u001A\u0002022\u0006\u0010\u0004\u001A\u000202@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\b4\u0010!\"\u0004\b5\u0010#R$\u00106\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u0016R$\u00109\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R$\u0010<\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R$\u0010?\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016R\u000E\u0010B\u001A\u00020CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010F\u001A\u0004\u0018\u00010GX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010H\u001A\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010J\u001A\u00020IX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010K\u001A\u0004\u0018\u00010IX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010L\u001A\u00020I8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bM\u0010NR\u001B\u0010O\u001A\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001A\u0004\bQ\u0010R¨\u0006["}, d2={"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "<init>", "()V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "stroke", "getStroke", "setStroke", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "path", "Landroidx/compose/ui/graphics/Path;", "renderPath", "_tmpPath", "tmpPath", "getTmpPath", "()Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathComponent extends VNode {
    public static final int $stable = 8;
    private Path _tmpPath;
    private Brush fill;
    private float fillAlpha;
    private boolean isPathDirty;
    private boolean isStrokeDirty;
    private boolean isTrimPathDirty;
    private String name;
    private final Path path;
    private List pathData;
    private int pathFillType;
    private final Lazy pathMeasure$delegate;
    private Path renderPath;
    private Brush stroke;
    private float strokeAlpha;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter;
    private float strokeLineWidth;
    private Stroke strokeStyle;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    static {
    }

    public PathComponent() {
        super(null);
        this.name = "";
        this.fillAlpha = 1f;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeAlpha = 1f;
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        this.strokeLineMiter = 4f;
        this.trimPathEnd = 1f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        Path v0 = AndroidPath_androidKt.Path();
        this.path = v0;
        this.renderPath = v0;
        this.pathMeasure$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, PathComponent$pathMeasure$2.INSTANCE);
    }

    public void draw(DrawScope arg21) {
        PathComponent v0 = this;
        if(v0.isPathDirty) {
            v0.updatePath();
        }
        else if(v0.isTrimPathDirty) {
            v0.updateRenderPath();
        }

        v0.isPathDirty = false;
        v0.isTrimPathDirty = false;
        Brush v4 = v0.fill;
        if(v4 != null) {
            DrawScope.drawPath-GBMwjPU$default(arg21, v0.renderPath, v4, v0.fillAlpha, null, null, 0, 56, null);
        }

        Brush v13 = v0.stroke;
        if(v13 != null) {
            Stroke v2 = v0.strokeStyle;
            if((v0.isStrokeDirty) || v2 == null) {
                Stroke v4_1 = new Stroke(v0.strokeLineWidth, v0.strokeLineMiter, v0.strokeLineCap, v0.strokeLineJoin, null, 16, null);
                v0.strokeStyle = v4_1;
                v0.isStrokeDirty = false;
                v2 = v4_1;
            }

            DrawScope.drawPath-GBMwjPU$default(arg21, v0.renderPath, v13, v0.strokeAlpha, v2, null, 0, 0x30, null);
        }
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

    private final PathMeasure getPathMeasure() {
        return this.pathMeasure$delegate.getValue();
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

    private final Path getTmpPath() {
        Path v0 = this._tmpPath;
        if(v0 != null) {
            return v0;
        }

        v0 = AndroidPath_androidKt.Path();
        this._tmpPath = v0;
        return v0;
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

    public final void setFill(Brush arg1) {
        this.fill = arg1;
        this.invalidate();
    }

    public final void setFillAlpha(float arg1) {
        this.fillAlpha = arg1;
        this.invalidate();
    }

    public final void setName(String arg1) {
        this.name = arg1;
        this.invalidate();
    }

    public final void setPathData(List arg1) {
        this.pathData = arg1;
        this.isPathDirty = true;
        this.invalidate();
    }

    public final void setPathFillType-oQ8Xj4U(int arg2) {
        this.pathFillType = arg2;
        this.renderPath.setFillType-oQ8Xj4U(arg2);
        this.invalidate();
    }

    public final void setStroke(Brush arg1) {
        this.stroke = arg1;
        this.invalidate();
    }

    public final void setStrokeAlpha(float arg1) {
        this.strokeAlpha = arg1;
        this.invalidate();
    }

    public final void setStrokeLineCap-BeK7IIE(int arg1) {
        this.strokeLineCap = arg1;
        this.isStrokeDirty = true;
        this.invalidate();
    }

    public final void setStrokeLineJoin-Ww9F2mQ(int arg1) {
        this.strokeLineJoin = arg1;
        this.isStrokeDirty = true;
        this.invalidate();
    }

    public final void setStrokeLineMiter(float arg1) {
        this.strokeLineMiter = arg1;
        this.isStrokeDirty = true;
        this.invalidate();
    }

    public final void setStrokeLineWidth(float arg1) {
        this.strokeLineWidth = arg1;
        this.isStrokeDirty = true;
        this.invalidate();
    }

    public final void setTrimPathEnd(float arg1) {
        this.trimPathEnd = arg1;
        this.isTrimPathDirty = true;
        this.invalidate();
    }

    public final void setTrimPathOffset(float arg1) {
        this.trimPathOffset = arg1;
        this.isTrimPathDirty = true;
        this.invalidate();
    }

    public final void setTrimPathStart(float arg1) {
        this.trimPathStart = arg1;
        this.isTrimPathDirty = true;
        this.invalidate();
    }

    public String toString() {
        return this.path.toString();
    }

    private final void updatePath() {
        PathParserKt.toPath(this.pathData, this.path);
        this.updateRenderPath();
    }

    private final void updateRenderPath() {
        float v2 = 1f;
        if(Float.compare(this.trimPathStart, 0f) == 0 && this.trimPathEnd == v2) {
            this.renderPath = this.path;
            return;
        }

        if(Intrinsics.areEqual(this.renderPath, this.path)) {
            this.renderPath = AndroidPath_androidKt.Path();
        }
        else {
            int v0 = this.renderPath.getFillType-Rg-k1Os();
            this.renderPath.rewind();
            this.renderPath.setFillType-oQ8Xj4U(v0);
        }

        this.getPathMeasure().setPath(this.path, false);
        float v0_1 = this.getPathMeasure().getLength();
        float v3 = (this.trimPathStart + this.trimPathOffset) % v2 * v0_1;
        float v5 = (this.trimPathEnd + this.trimPathOffset) % v2 * v0_1;
        if(Float.compare(v3, v5) > 0) {
            Path v7 = this.getTmpPath();
            v7.reset();
            this.getPathMeasure().getSegment(v3, v0_1, v7, true);
            Path.addPath-Uv8p0NA$default(this.renderPath, v7, 0, 2, null);
            v7.reset();
            this.getPathMeasure().getSegment(0f, v5, v7, true);
            Path.addPath-Uv8p0NA$default(this.renderPath, v7, 0, 2, null);
            return;
        }

        this.getPathMeasure().getSegment(v3, v5, this.renderPath, true);
    }
}

