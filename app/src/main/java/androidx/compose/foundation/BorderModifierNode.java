package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter$Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001A\u00020&*\u00020\'2\u0006\u0010\u0019\u001A\u00020\u00062\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020,H\u0002JC\u0010-\u001A\u00020&*\u00020\'2\u0006\u0010\u0019\u001A\u00020\u00062\u0006\u0010(\u001A\u00020.2\u0006\u0010/\u001A\u0002002\u0006\u00101\u001A\u0002022\u0006\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001A\u000206*\u000207H\u0016R\u0014\u0010\u000B\u001A\u00020\fX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\fX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u0004@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0006@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR$\u0010\u001E\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\b@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    static {
    }

    private BorderModifierNode(float arg1, Brush arg2, Shape arg3) {
        super();
        this.width = arg1;
        this.brush = arg2;
        this.shape = arg3;
        this.drawWithCacheModifierNode = this.delegate(DrawModifierKt.CacheDrawModifierNode(new BorderModifierNode$$ExternalSyntheticLambda4(this)));
    }

    public BorderModifierNode(float arg1, Brush arg2, Shape arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setShape(arg1, this.shape);
    }

    private final DrawResult drawGenericBorder(CacheDrawScope arg39, Brush arg40, Generic arg41, boolean arg42, float arg43) {
        Brush v3_5;
        long v13_2;
        LayoutDirection v16_2;
        DrawContext v41;
        DrawStyle v6_4;
        long v8_2;
        DrawContext v4_1;
        long v6_3;
        float v3_4;
        Stroke v11_3;
        Canvas v14_1;
        Density v12_1;
        ColorFilter v22;
        Canvas v21_1;
        Stroke v6_2;
        CanvasDrawScope v2_1;
        float v11_2;
        float v15_2;
        Path v24;
        ImageBitmap v25_1;
        ObjectRef v23_1;
        long v0_5;
        Path v3_3;
        Rect v42_1;
        LayoutDirection v13_1;
        ColorFilter v7_2;
        Object v10_2;
        int v9_4;
        long v7_1;
        ColorFilter v14;
        int v3;
        BorderModifierNode v0 = this;
        CacheDrawScope v1 = arg39;
        Brush v4 = arg40;
        if(arg42) {
            return v1.onDrawWithContent(new BorderModifierNode$$ExternalSyntheticLambda2(arg41, v4));
        }

        Generic v2 = arg41;
        Direction v5 = null;
        if((v4 instanceof SolidColor)) {
            v3 = ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
            v14 = Companion.tint-xETnrds$default(ColorFilter.Companion, Color.copy-wmQWz5c$default(v4.getValue-0d7_KjU(), 1f, 0f, 0f, 0f, 14, null), 0, 2, null);
        }
        else {
            v3 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
            v14 = ((ColorFilter)v5);
        }

        int v8 = v3;
        Rect v13 = v2.getPath().getBounds();
        BorderCache v3_1 = v0.borderCache;
        if(v3_1 == null) {
            BorderCache v15 = new BorderCache(null, null, null, null, 15, null);
            v0.borderCache = v15;
            v3_1 = v15;
        }

        Intrinsics.checkNotNull(v3_1);
        Path v15_1 = v3_1.obtainPath();
        v15_1.reset();
        Path.addRect$default(v15_1, v13, v5, 2, v5);
        v15_1.op-N5in7k0(v15_1, v2.getPath(), PathOperation.Companion.getDifference-b3I0S0c());
        ObjectRef v3_2 = new ObjectRef();
        int v16 = 0x20;
        long v17 = 0xFFFFFFFFL;
        long v19 = IntSize.constructor-impl((((long)(((int)(((float)Math.ceil(((double)(v13.getBottom() - v13.getTop()))))))))) & v17 | (((long)(((int)(((float)Math.ceil(((double)(v13.getRight() - v13.getLeft()))))))))) << v16);
        BorderCache v0_1 = v0.borderCache;
        Intrinsics.checkNotNull(v0_1);
        ImageBitmap v6 = v0_1.imageBitmap;
        Canvas v7 = v0_1.canvas;
        ImageBitmapConfig v9 = v6 != null ? ImageBitmapConfig.box-impl(v6.getConfig-_sVssgQ()) : ((ImageBitmapConfig)v5);
        int v10 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        int v11 = 0;
        boolean v9_1 = v9 == null ? false : ImageBitmapConfig.equals-impl0(v9.unbox-impl(), v10);
        if(!v9_1) {
            if(v6 != null) {
                ImageBitmapConfig v5_1 = ImageBitmapConfig.box-impl(v6.getConfig-_sVssgQ());
            }

            if(!ImageBitmapConfig.equals-impl(v8, v5_1)) {
                goto label_106;
            }

            goto label_105;
        }
        else {
        label_105:
            v11 = 1;
        }

    label_106:
        if(v6 == null || v7 == null || Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> v16))) > (((float)v6.getWidth())) || Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v17))) > (((float)v6.getHeight())) || v11 == 0) {
            v6 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(v19 >> v16)), ((int)(v19 & v17)), v8, false, null, 24, null);
            v0_1.imageBitmap = v6;
            v7 = CanvasKt.Canvas(v6);
            v0_1.canvas = v7;
        }

        ImageBitmap v11_1 = v6;
        Canvas v12 = v7;
        CanvasDrawScope v5_2 = v0_1.canvasDrawScope;
        if(v5_2 == null) {
            v5_2 = new CanvasDrawScope();
            v0_1.canvasDrawScope = v5_2;
        }

        CanvasDrawScope v0_2 = v5_2;
        long v5_3 = IntSizeKt.toSize-ozmzZPI(v19);
        LayoutDirection v8_1 = v1.getLayoutDirection();
        DrawParams v9_2 = v0_2.getDrawParams();
        Density v10_1 = v9_2.component1();
        LayoutDirection v42 = v9_2.component2();
        Canvas v35 = v9_2.component3();
        Density v34 = v10_1;
        long v9_3 = v9_2.component4-NH-jbRc();
        CanvasDrawScope v38 = v0_2;
        DrawParams v0_3 = v38.getDrawParams();
        v0_3.setDensity(v1);
        v0_3.setLayoutDirection(v8_1);
        v0_3.setCanvas(v12);
        v0_3.setSize-uvyYCjk(v5_3);
        v12.save();
        CanvasDrawScope v21 = v38;
        DrawScope.drawRect-n-J9OG0$default(((DrawScope)v21), Color.Companion.getBlack-0d7_KjU(), 0, v5_3, 0f, null, null, BlendMode.Companion.getClear-0nO6VwU(), 58, null);
        float v5_4 = -v13.getLeft();
        float v6_1 = -v13.getTop();
        ((DrawScope)v21).getDrawContext().getTransform().translate(v5_4, v6_1);
        try {
            v7_1 = v9_3;
            v9_4 = 52;
            v10_2 = null;
            long v23 = v7_1;
            v7_2 = null;
            Rect v1_1 = v13;
            v13_1 = v42;
            v42_1 = v1_1;
            ObjectRef v25 = v3_2;
            v3_3 = v2.getPath();
            v0_5 = v23;
            v23_1 = v25;
            v25_1 = v11_1;
            v24 = v15_1;
            v15_2 = v5_4;
            v11_2 = v6_1;
            v2_1 = v21;
            v6_2 = new Stroke(arg43 * 2f, 0f, 0, 0, null, 30, null);
            v21_1 = v12;
            v22 = v14;
            v12_1 = v34;
            v14_1 = v35;
        }
        catch(Throwable v0_4) {
            v15_2 = 0f;
            v11_3 = v6_2;
            Canvas v2_2 = v21_1;
            goto label_312;
        }

        try {
            DrawScope.drawPath-GBMwjPU$default(((DrawScope)v2_1), v3_3, v4, 0f, ((DrawStyle)v6_2), v7_2, 0, v9_4, v10_2);
            v3_4 = (Float.intBitsToFloat(((int)(((DrawScope)v2_1).getSize-NH-jbRc() >> v16))) + 1f) / Float.intBitsToFloat(((int)(((DrawScope)v2_1).getSize-NH-jbRc() >> v16)));
            v5_4 = (Float.intBitsToFloat(((int)(((DrawScope)v2_1).getSize-NH-jbRc() & v17))) + 1f) / Float.intBitsToFloat(((int)(((DrawScope)v2_1).getSize-NH-jbRc() & v17)));
            v6_3 = ((DrawScope)v2_1).getCenter-F1C5BW0();
            v4_1 = ((DrawScope)v2_1).getDrawContext();
            v8_2 = v4_1.getSize-NH-jbRc();
            v4_1.getCanvas().save();
        }
        catch(Throwable v0_4) {
            goto label_307;
        }

        try {
            v4_1.getTransform().scale-0AR0LA0(v3_4, v5_4, v6_3);
            v5_3 = v8_2;
            v9_4 = 28;
            v10_2 = null;
            v7_1 = v5_3;
            v6_4 = null;
            long v16_1 = v7_1;
            v7_2 = null;
            v8 = BlendMode.Companion.getClear-0nO6VwU();
            v41 = v4_1;
            v35 = v14_1;
            v3_3 = v24;
            v4 = arg40;
            long v36 = v16_1;
            v16_2 = v13_1;
            v13_2 = v36;
        }
        catch(Throwable v0_4) {
            v3_5 = v4;
            v13_2 = ((long)v8);
            goto label_302;
        }

        try {
            DrawScope.drawPath-GBMwjPU$default(((DrawScope)v2_1), v3_3, v4, 0f, v6_4, v7_2, v8, v9_4, v10_2);
            goto label_267;
        }
        catch(Throwable v0_4) {
            DrawContext v3_6 = v41;
        }

        try {
        label_302:
            ((DrawContext)v3_5).getCanvas().restore();
            ((DrawContext)v3_5).setSize-uvyYCjk(v13_2);
            throw v0_4;
        label_267:
            v41.getCanvas().restore();
            v41.setSize-uvyYCjk(v13_2);
            goto label_271;
        }
        catch(Throwable v0_4) {
        label_307:
        }

    label_312:
        ((DrawScope)v2_1).getDrawContext().getTransform().translate(-v15_2, -(((float)v11_3)));
        throw v0_4;
    label_271:
        ((DrawScope)v2_1).getDrawContext().getTransform().translate(-v15_2, -v11_2);
        v21_1.restore();
        DrawParams v2_3 = v38.getDrawParams();
        v2_3.setDensity(v12_1);
        v2_3.setLayoutDirection(v16_2);
        v2_3.setCanvas(v35);
        v2_3.setSize-uvyYCjk(v0_5);
        v25_1.prepareToDraw();
        v23_1.element = v25_1;
        return arg39.onDrawWithContent(new BorderModifierNode$$ExternalSyntheticLambda3(v42_1, v23_1, v19, v22));
    }

    static final Unit drawGenericBorder$lambda$0(Generic arg9, Brush arg10, ContentDrawScope arg11) {
        arg11.drawContent();
        DrawScope.drawPath-GBMwjPU$default(arg11, arg9.getPath(), arg10, 0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    static final Unit drawGenericBorder$lambda$3(Rect arg20, ObjectRef arg21, long arg22, ColorFilter arg24, ContentDrawScope arg25) {
        Object v2_1;
        long v5_1;
        float v19;
        float v18;
        ColorFilter v13;
        DrawStyle v12;
        long v9;
        long v7;
        long v3_1;
        float v5;
        Object v17;
        int v16;
        arg25.drawContent();
        ContentDrawScope v1 = arg25;
        float v2 = arg20.getLeft();
        float v3 = arg20.getTop();
        ((DrawScope)v1).getDrawContext().getTransform().translate(v2, v3);
        ObjectRef v0 = arg21;
        try {
            v16 = 890;
            v17 = null;
            v5 = v3;
            v3_1 = 0;
            v7 = 0;
            v9 = 0;
            v12 = null;
            v13 = arg24;
            v18 = v2;
            v19 = v5;
            v5_1 = arg22;
            v2_1 = v0.element;
        }
        catch(Throwable v0_1) {
            v5 = ((float)v3_1);
            goto label_40;
        }

        try {
            DrawScope.drawImage-AZ2fEMs$default(((DrawScope)v1), ((ImageBitmap)v2_1), v3_1, v5_1, v7, v9, 0f, v12, v13, 0, 0, v16, v17);
            goto label_25;
        }
        catch(Throwable v0_1) {
            v2 = v18;
            v5 = v19;
        }

    label_40:
        ((DrawScope)v1).getDrawContext().getTransform().translate(-(((float)v2_1)), -v5);
        throw v0_1;
    label_25:
        ((DrawScope)v1).getDrawContext().getTransform().translate(-v18, -v19);
        return Unit.INSTANCE;
    }

    private final DrawResult drawRoundRectBorder-JqoCqck(CacheDrawScope arg17, Brush arg18, Rounded arg19, long arg20, long arg22, boolean arg24, float arg25) {
        BorderModifierNode v0 = this;
        CacheDrawScope v1 = arg17;
        if(RoundRectKt.isSimple(arg19.getRoundRect())) {
            return v1.onDrawWithContent(new BorderModifierNode$$ExternalSyntheticLambda0(arg24, arg18, arg19.getRoundRect().getTopLeftCornerRadius-kKHJgLs(), arg25 / 2f, arg25, arg20, arg22, new Stroke(arg25, 0f, 0, 0, null, 30, null)));
        }

        float v8 = arg25;
        BorderCache v2 = v0.borderCache;
        if(v2 == null) {
            BorderCache v9 = new BorderCache(null, null, null, null, 15, null);
            v0.borderCache = v9;
            v2 = v9;
        }

        Intrinsics.checkNotNull(v2);
        return v1.onDrawWithContent(new BorderModifierNode$$ExternalSyntheticLambda1(BorderKt.createRoundRectPath(v2.obtainPath(), arg19.getRoundRect(), v8, arg24), arg18));
    }

    static final Unit drawRoundRectBorder_JqoCqck$lambda$0(boolean arg28, Brush arg29, long arg30, float arg32, float arg33, long arg34, long arg36, Stroke arg38, ContentDrawScope arg39) {
        arg39.drawContent();
        if(arg28) {
            DrawScope.drawRoundRect-ZuiqVtQ$default(arg39, arg29, 0, 0, arg30, 0f, null, null, 0, 0xF6, null);
        }
        else {
            int v0 = 0x20;
            if(Float.intBitsToFloat(((int)(arg30 >> v0))) < arg32) {
                ContentDrawScope v14 = arg39;
                float v0_1 = Float.intBitsToFloat(((int)(arg39.getSize-NH-jbRc() >> v0))) - arg33;
                float v1 = Float.intBitsToFloat(((int)(arg39.getSize-NH-jbRc() & 0xFFFFFFFFL))) - arg33;
                int v2 = ClipOp.Companion.getDifference-rtfAjoo();
                DrawContext v3 = ((DrawScope)v14).getDrawContext();
                long v4 = v3.getSize-NH-jbRc();
                v3.getCanvas().save();
                try {
                    v3.getTransform().clipRect-N_I0leg(arg33, arg33, v0_1, v1, v2);
                    DrawScope.drawRoundRect-ZuiqVtQ$default(((DrawScope)v14), arg29, 0, 0, arg30, 0f, null, null, 0, 0xF6, null);
                }
                catch(Throwable v0_2) {
                    v3.getCanvas().restore();
                    v3.setSize-uvyYCjk(v4);
                    throw v0_2;
                }

                v3.getCanvas().restore();
                v3.setSize-uvyYCjk(v4);
            }
            else {
                DrawScope.drawRoundRect-ZuiqVtQ$default(arg39, arg29, arg34, arg36, BorderKt.shrink-Kibmq7A(arg30, arg32), 0f, arg38, null, 0, 0xD0, null);
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit drawRoundRectBorder_JqoCqck$lambda$1(Path arg9, Brush arg10, ContentDrawScope arg11) {
        arg11.drawContent();
        DrawScope.drawPath-GBMwjPU$default(arg11, arg9, arg10, 0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode arg15, CacheDrawScope arg16) {
        CacheDrawScope v1 = arg16;
        if(v1.toPx-0680j_4(arg15.width) >= 0f && Size.getMinDimension-impl(v1.getSize-NH-jbRc()) > 0f) {
            float v2 = Dp.equals-impl0(arg15.width, Dp.Companion.getHairline-D9Ej5fM()) ? 1f : ((float)Math.ceil(((double)v1.toPx-0680j_4(arg15.width))));
            float v5 = Math.min(v2, ((float)Math.ceil(((double)(Size.getMinDimension-impl(v1.getSize-NH-jbRc()) / 2f)))));
            v2 = v5 / 2f;
            long v2_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v2))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v2))) << 0x20);
            long v6 = Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & 0xFFFFFFFFL))) - v5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() >> 0x20))) - v5))) << 0x20);
            boolean v4 = 2f * v5 > Size.getMinDimension-impl(v1.getSize-NH-jbRc()) ? true : false;
            Outline v8 = arg15.shape.createOutline-Pq9zytI(v1.getSize-NH-jbRc(), v1.getLayoutDirection(), v1);
            if((v8 instanceof Generic)) {
                return arg15.drawGenericBorder(v1, arg15.brush, v8, v4, v5);
            }

            if((v8 instanceof Rounded)) {
                return arg15.drawRoundRectBorder-JqoCqck(arg16, arg15.brush, v8, v2_1, v6, v4, v5);
            }

            if((v8 instanceof Rectangle)) {
                return BorderKt.drawRectBorder-NsqcLGU(arg16, arg15.brush, v2_1, v6, v4, v5);
            }

            throw new NoWhenBranchMatchedException();
        }

        return BorderKt.drawContentWithoutBorder(arg16);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    public final void setBrush(Brush arg2) {
        if(!Intrinsics.areEqual(this.brush, arg2)) {
            this.brush = arg2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final void setShape(Shape arg2) {
        if(!Intrinsics.areEqual(this.shape, arg2)) {
            this.shape = arg2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
            SemanticsModifierNodeKt.invalidateSemantics(((SemanticsModifierNode)this));
        }
    }

    public final void setWidth-0680j_4(float arg2) {
        if(!Dp.equals-impl0(this.width, arg2)) {
            this.width = arg2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }
}

