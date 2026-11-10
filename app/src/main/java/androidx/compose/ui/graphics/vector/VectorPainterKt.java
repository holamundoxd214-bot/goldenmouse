package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0093\u0001\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2@\u0010\u000F\u001A<\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u009D\u0001\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u00182@\u0010\u000F\u001A<\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u0015\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u001CH\u0007¢\u0006\u0002\u0010\u001D\u001A&\u0010\u001E\u001A\u00020\u0012*\u00020\u001F2\u0017\u0010 \u001A\u0013\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00120!¢\u0006\u0002\b\"H\u0082\b\u001A#\u0010#\u001A\u00020$*\u00020%2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\'\u001A\'\u0010(\u001A\u00020$2\u0006\u0010)\u001A\u00020$2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b*\u0010+\u001A!\u0010,\u001A\u0004\u0018\u00010-2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002¢\u0006\u0004\b.\u0010/\u001AA\u00100\u001A\u00020\u0003*\u00020\u00032\u0006\u0010)\u001A\u00020$2\u0006\u00101\u001A\u00020$2\b\b\u0002\u0010\n\u001A\u00020\u00012\b\u00102\u001A\u0004\u0018\u00010-2\b\b\u0002\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0004\b3\u00104\u001A \u00105\u001A\u00020\u00032\u0006\u00106\u001A\u00020%2\u0006\u00107\u001A\u00020\u001C2\u0006\u00108\u001A\u000209H\u0000\u001A\u0014\u0010:\u001A\u000209*\u0002092\u0006\u0010;\u001A\u00020<H\u0000\u001A+\u0010=\u001A\u00020\u00122\u0006\u0010>\u001A\u00020<2\u0014\b\u0002\u0010?\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020A0@H\u0007¢\u0006\u0002\u0010B\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006C"}, d2={"RootGroupName", "", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/Density;", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "obtainViewportSize", "defaultSize", "obtainViewportSize-Pq9zytI", "(JFF)J", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createVectorPainterFromImageVector", "density", "imageVector", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "createGroupComponent", "currentGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "RenderVectorGroup", "group", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    public static final void RenderVectorGroup(VectorGroup arg23, Map arg24, Composer arg25, int arg26, int arg27) {
        VectorPainterKt$RenderVectorGroup$config$2 v6_3;
        Map v3_3;
        Iterator v24;
        VectorPainterKt$RenderVectorGroup$config$1 v6_2;
        Object v6_1;
        Map v6;
        int v4;
        VectorGroup v0 = arg23;
        int v1 = arg26;
        int v2 = arg27;
        int v3 = 0xE567D85F;
        Composer v14 = arg25.startRestartGroup(v3);
        ComposerKt.sourceInformation(v14, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        if((v1 & 6) == 0) {
            v4 = v14.changed(v0) ? 4 : 2;
            v4 |= v1;
        }
        else {
            v4 = v1;
        }

        int v5 = v2 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_32;
        }
        else if((v1 & 0x30) == 0) {
            v6 = arg24;
            int v7 = v14.changedInstance(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_32:
            v6 = arg24;
        }

        boolean v7_1 = (v4 & 19) != 18 ? true : false;
        if(v14.shouldExecute(v7_1, v4 & 1)) {
            Map v5_1 = v5 != 0 ? MapsKt.emptyMap() : v6;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v4, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:423)");
            }

            Iterator v3_1;
            for(v3_1 = v0.iterator(); v3_1.hasNext(); v3_1 = v24) {
                Object v4_1 = v3_1.next();
                if((v4_1 instanceof VectorPath)) {
                    v14.startReplaceGroup(0x2F97786B);
                    ComposerKt.sourceInformation(v14, "427@16156L1298");
                    v6_1 = v5_1.get(((VectorPath)v4_1).getName());
                    if(v6_1 == null) {
                        v6_2 = new VectorPainterKt$RenderVectorGroup$config$1();
                    }

                    Object v7_2 = ((VectorConfig)v6_2).getOrDefault(PathData.INSTANCE, ((VectorPath)v4_1).getPathData());
                    Map v8 = v5_1;
                    v5 = ((VectorPath)v4_1).getPathFillType-Rg-k1Os();
                    String v10 = ((VectorPath)v4_1).getName();
                    Object v11 = ((VectorConfig)v6_2).getOrDefault(Fill.INSTANCE, ((VectorPath)v4_1).getFill());
                    float v12 = ((VectorConfig)v6_2).getOrDefault(FillAlpha.INSTANCE, Float.valueOf(((VectorPath)v4_1).getFillAlpha())).floatValue();
                    Object v13 = ((VectorConfig)v6_2).getOrDefault(Stroke.INSTANCE, ((VectorPath)v4_1).getStroke());
                    float v9 = ((VectorConfig)v6_2).getOrDefault(StrokeAlpha.INSTANCE, Float.valueOf(((VectorPath)v4_1).getStrokeAlpha())).floatValue();
                    v24 = v3_1;
                    float v3_2 = ((VectorConfig)v6_2).getOrDefault(StrokeLineWidth.INSTANCE, Float.valueOf(((VectorPath)v4_1).getStrokeLineWidth())).floatValue();
                    Map v15 = v8;
                    float v8_1 = v12;
                    int v12_1 = ((VectorPath)v4_1).getStrokeLineCap-KaPHkGw();
                    String v16 = v10;
                    float v10_1 = v9;
                    Object v9_1 = v13;
                    int v13_1 = ((VectorPath)v4_1).getStrokeLineJoin-LxFBmk8();
                    Composer v18 = v14;
                    float v14_1 = ((VectorPath)v4_1).getStrokeLineMiter();
                    float v19 = v3_2;
                    Object v20 = v4_1;
                    float v21 = ((VectorConfig)v6_2).getOrDefault(TrimPathStart.INSTANCE, Float.valueOf(((VectorPath)v4_1).getTrimPathStart())).floatValue();
                    v3_2 = ((VectorConfig)v6_2).getOrDefault(TrimPathEnd.INSTANCE, Float.valueOf(((VectorPath)v20).getTrimPathEnd())).floatValue();
                    TrimPathOffset v4_2 = TrimPathOffset.INSTANCE;
                    float v17 = ((VectorPath)v20).getTrimPathOffset();
                    float v20_1 = v3_2;
                    v3_3 = v15;
                    VectorComposeKt.Path-9cdaXJ4(v7_2, v5, v16, v11, v8_1, ((Brush)v9_1), v10_1, v19, v12_1, v13_1, v14_1, v21, v20_1, ((VectorConfig)v6_2).getOrDefault(((VectorProperty)v4_2), Float.valueOf(v17)).floatValue(), v18, 0, 0, 0);
                    v14 = v18;
                    v14.endReplaceGroup();
                }
                else {
                    v24 = v3_1;
                    v3_3 = v5_1;
                    if((v4_1 instanceof VectorGroup)) {
                        v14.startReplaceGroup(0x2FAD0E0C);
                        ComposerKt.sourceInformation(v14, "462@18450L88,450@17593L945");
                        Object v5_2 = v4_1;
                        v6_1 = v3_3.get(((VectorGroup)v5_2).getName());
                        if(v6_1 == null) {
                            v6_3 = new VectorPainterKt$RenderVectorGroup$config$2();
                        }

                        VectorComposeKt.Group(((VectorGroup)v5_2).getName(), ((VectorConfig)v6_3).getOrDefault(Rotation.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getRotation())).floatValue(), ((VectorConfig)v6_3).getOrDefault(PivotX.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getPivotX())).floatValue(), ((VectorConfig)v6_3).getOrDefault(PivotY.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getPivotY())).floatValue(), ((VectorConfig)v6_3).getOrDefault(ScaleX.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getScaleX())).floatValue(), ((VectorConfig)v6_3).getOrDefault(ScaleY.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getScaleY())).floatValue(), ((VectorConfig)v6_3).getOrDefault(TranslateX.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getTranslationX())).floatValue(), ((VectorConfig)v6_3).getOrDefault(TranslateY.INSTANCE, Float.valueOf(((VectorGroup)v5_2).getTranslationY())).floatValue(), ((VectorConfig)v6_3).getOrDefault(PathData.INSTANCE, ((VectorGroup)v5_2).getClipPathData()), ComposableLambdaKt.rememberComposableLambda(1450046638, true, new VectorPainterKt$RenderVectorGroup$1(((VectorNode)v4_1), v3_3), v14, 54), v14, 0x30000000, 0);
                    }
                    else {
                        v14.startReplaceGroup(0x2EA3A303);
                    }

                    v14.endReplaceGroup();
                }

                v5_1 = v3_3;
            }

            v3_3 = v5_1;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_228;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14.skipToGroupEnd();
            v3_3 = v6;
        }

    label_228:
        ScopeUpdateScope v0_1 = v14.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new VectorPainterKt$RenderVectorGroup$2(arg23, v3_3, v1, v2));
        }
    }

    public static final VectorPainter configureVectorPainter-T4PVSW8(VectorPainter arg0, long arg1, long arg3, String arg5, ColorFilter arg6, boolean arg7) {
        arg0.setSize-uvyYCjk$ui(arg1);
        arg0.setAutoMirror$ui(arg7);
        arg0.setIntrinsicColorFilter$ui(arg6);
        arg0.setViewportSize-uvyYCjk$ui(arg3);
        arg0.setName$ui(arg5);
        return arg0;
    }

    public static VectorPainter configureVectorPainter-T4PVSW8$default(VectorPainter arg8, long arg9, long arg11, String arg13, ColorFilter arg14, boolean arg15, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg13 = "VectorRootGroup";
        }

        String v5 = arg13;
        boolean v7 = (arg16 & 16) != 0 ? false : arg15;
        return VectorPainterKt.configureVectorPainter-T4PVSW8(arg8, arg9, arg11, v5, arg14, v7);
    }

    private static final ColorFilter createColorFilter-xETnrds(long arg2, int arg4) {
        if(arg2 != 16) {
            return ColorFilter.Companion.tint-xETnrds(arg2, arg4);
        }

        return null;
    }

    public static final GroupComponent createGroupComponent(GroupComponent arg5, VectorGroup arg6) {
        int v0 = arg6.getSize();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            VectorNode v2 = arg6.get(v1);
            if((v2 instanceof VectorPath)) {
                PathComponent v3 = new PathComponent();
                v3.setPathData(((VectorPath)v2).getPathData());
                v3.setPathFillType-oQ8Xj4U(((VectorPath)v2).getPathFillType-Rg-k1Os());
                v3.setName(((VectorPath)v2).getName());
                v3.setFill(((VectorPath)v2).getFill());
                v3.setFillAlpha(((VectorPath)v2).getFillAlpha());
                v3.setStroke(((VectorPath)v2).getStroke());
                v3.setStrokeAlpha(((VectorPath)v2).getStrokeAlpha());
                v3.setStrokeLineWidth(((VectorPath)v2).getStrokeLineWidth());
                v3.setStrokeLineCap-BeK7IIE(((VectorPath)v2).getStrokeLineCap-KaPHkGw());
                v3.setStrokeLineJoin-Ww9F2mQ(((VectorPath)v2).getStrokeLineJoin-LxFBmk8());
                v3.setStrokeLineMiter(((VectorPath)v2).getStrokeLineMiter());
                v3.setTrimPathStart(((VectorPath)v2).getTrimPathStart());
                v3.setTrimPathEnd(((VectorPath)v2).getTrimPathEnd());
                v3.setTrimPathOffset(((VectorPath)v2).getTrimPathOffset());
                arg5.insertAt(v1, ((VNode)v3));
            }
            else if((v2 instanceof VectorGroup)) {
                GroupComponent v3_1 = new GroupComponent();
                v3_1.setName(((VectorGroup)v2).getName());
                v3_1.setRotation(((VectorGroup)v2).getRotation());
                v3_1.setScaleX(((VectorGroup)v2).getScaleX());
                v3_1.setScaleY(((VectorGroup)v2).getScaleY());
                v3_1.setTranslationX(((VectorGroup)v2).getTranslationX());
                v3_1.setTranslationY(((VectorGroup)v2).getTranslationY());
                v3_1.setPivotX(((VectorGroup)v2).getPivotX());
                v3_1.setPivotY(((VectorGroup)v2).getPivotY());
                v3_1.setClipPathData(((VectorGroup)v2).getClipPathData());
                VectorPainterKt.createGroupComponent(v3_1, ((VectorGroup)v2));
                arg5.insertAt(v1, ((VNode)v3_1));
            }
        }

        return arg5;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density arg10, ImageVector arg11, GroupComponent arg12) {
        long v3 = VectorPainterKt.obtainSizePx-VpY3zN4(arg10, arg11.getDefaultWidth-D9Ej5fM(), arg11.getDefaultHeight-D9Ej5fM());
        return VectorPainterKt.configureVectorPainter-T4PVSW8(new VectorPainter(arg12), v3, VectorPainterKt.obtainViewportSize-Pq9zytI(v3, arg11.getViewportWidth(), arg11.getViewportHeight()), arg11.getName(), VectorPainterKt.createColorFilter-xETnrds(arg11.getTintColor-0d7_KjU(), arg11.getTintBlendMode-0nO6VwU()), arg11.getAutoMirror());
    }

    private static final void mirror(DrawScope arg8, Function1 arg9) {
        long v0 = arg8.getCenter-F1C5BW0();
        DrawContext v2 = arg8.getDrawContext();
        long v3 = v2.getSize-NH-jbRc();
        v2.getCanvas().save();
        try {
            v2.getTransform().scale-0AR0LA0(-1f, 1f, v0);
            arg9.invoke(arg8);
        }
        catch(Throwable v8) {
            v2.getCanvas().restore();
            v2.setSize-uvyYCjk(v3);
            throw v8;
        }

        v2.getCanvas().restore();
        v2.setSize-uvyYCjk(v3);
    }

    private static final long obtainSizePx-VpY3zN4(Density arg4, float arg5, float arg6) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg4.toPx-0680j_4(arg5)))) << 0x20 | (((long)Float.floatToRawIntBits(arg4.toPx-0680j_4(arg6)))) & 0xFFFFFFFFL);
    }

    private static final long obtainViewportSize-Pq9zytI(long arg4, float arg6, float arg7) {
        int v1 = 0x20;
        if(Float.isNaN(arg6)) {
            arg6 = Float.intBitsToFloat(((int)(arg4 >> v1)));
        }

        long v2 = 0xFFFFFFFFL;
        if(Float.isNaN(arg7)) {
            arg7 = Float.intBitsToFloat(((int)(arg4 & v2)));
        }

        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg6))) << v1 | (((long)Float.floatToRawIntBits(arg7))) & v2);
    }

    public static final VectorPainter rememberVectorPainter(ImageVector arg6, Composer arg7, int arg8) {
        VectorPainter v1_2;
        int v1 = 0x544566B0;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberVectorPainter)170@7434L7,172@7518L188:VectorPainter.kt#huu6hf");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }

        ProvidableCompositionLocal v8 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v8_1 = arg7.consume(((CompositionLocal)v8));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        long v0 = (((long)Float.floatToRawIntBits(((Density)v8_1).getDensity()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)arg6.getGenId$ui())))) << 0x20;
        ComposerKt.sourceInformationMarkerStart(arg7, 0x588691AC, "CC(remember):VectorPainter.kt#9igjgp");
        boolean v0_1 = arg7.changed(v0);
        Object v1_1 = arg7.rememberedValue();
        if((v0_1) || v1_1 == Composer.Companion.getEmpty()) {
            GroupComponent v0_2 = new GroupComponent();
            VectorPainterKt.createGroupComponent(v0_2, arg6.getRoot());
            v1_2 = VectorPainterKt.createVectorPainterFromImageVector(((Density)v8_1), arg6, v0_2);
            arg7.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return v1_2;
    }

    @Deprecated(message="Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith="<_subannotation>") public static final VectorPainter rememberVectorPainter-mlNsNFs(float arg16, float arg17, float arg18, float arg19, String arg20, long arg21, int arg23, Function4 arg24, Composer arg25, int arg26, int arg27) {
        int v0 = arg26;
        int v2 = 411310745;
        Composer v13 = arg25;
        ComposerKt.sourceInformationMarkerStart(v13, v2, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)85@3806L208:VectorPainter.kt#huu6hf");
        float v3 = NaNf;
        float v5 = (arg27 & 4) != 0 ? v3 : arg18;
        float v6 = (arg27 & 8) != 0 ? v3 : arg19;
        String v7 = (arg27 & 16) != 0 ? "VectorRootGroup" : arg20;
        long v8 = (arg27 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        int v10 = (arg27 & 0x40) != 0 ? BlendMode.Companion.getSrcIn-0nO6VwU() : arg23;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:85)");
        }

        VectorPainter v0_1 = VectorPainterKt.rememberVectorPainter-vIP8VLU(arg16, arg17, v5, v6, v7, v8, v10, false, arg24, v13, v0 & 14 | 0xC00000 | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | 0x70000 & v0 | 0x380000 & v0 | v0 << 3 & 0xE000000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg25);
        return v0_1;
    }

    public static final VectorPainter rememberVectorPainter-vIP8VLU(float arg17, float arg18, float arg19, float arg20, String arg21, long arg22, int arg24, boolean arg25, Function4 arg26, Composer arg27, int arg28, int arg29) {
        Composition v4_3;
        VectorPainter v3_3;
        Function4 v0 = arg26;
        Composer v1 = arg27;
        int v2 = arg28;
        int v3 = arg29;
        int v5 = 0x647A49F5;
        ComposerKt.sourceInformationMarkerStart(v1, v5, "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)130@5714L7,134@5915L82,135@6009L28:VectorPainter.kt#huu6hf");
        float v6 = NaNf;
        float v4 = (v3 & 4) != 0 ? v6 : arg19;
        if((v3 & 8) != 0) {
        }
        else {
            v6 = arg20;
        }

        String v7 = (v3 & 16) != 0 ? "VectorRootGroup" : arg21;
        long v8 = (v3 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        int v10 = (v3 & 0x40) != 0 ? BlendMode.Companion.getSrcIn-0nO6VwU() : arg24;
        boolean v3_1 = (v3 & 0x80) != 0 ? false : arg25;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:129)");
        }

        ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_2 = v1.consume(((CompositionLocal)v5_1));
        ComposerKt.sourceInformationMarkerEnd(v1);
        long v12 = VectorPainterKt.obtainSizePx-VpY3zN4(((Density)v5_2), arg17, arg18);
        long v14 = VectorPainterKt.obtainViewportSize-Pq9zytI(v12, v4, v6);
        String v11 = "CC(remember):VectorPainter.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v1, 0x2F0FF2E7, v11);
        int v16 = 0x30000;
        boolean v24 = v3_1;
        v3 = 0x20000;
        String v19 = v7;
        v3 = (0x70000 & v2 ^ v16) > v3 && (v1.changed(v8)) || (v2 & v16) == v3 ? 1 : 0;
        v16 = 0x180000;
        int v7_1 = 0x100000;
        v5 = (0x380000 & v2 ^ v16) > v7_1 && (v1.changed(v10)) || (v2 & v16) == v7_1 ? 1 : 0;
        v3 |= v5;
        v5_2 = v1.rememberedValue();
        if(v3 != 0 || v5_2 == Composer.Companion.getEmpty()) {
            ColorFilter v5_3 = VectorPainterKt.createColorFilter-xETnrds(v8, v10);
            v1.updateRememberedValue(v5_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        v1.startReplaceGroup(0x2F100717);
        ComposerKt.sourceInformation(v1, "*144@6357L28,146@6432L513,158@7024L39,158@7001L62");
        ComposerKt.sourceInformationMarkerStart(v1, 0x2F0FFE71, v11);
        Object v3_2 = v1.rememberedValue();
        if(v3_2 == Composer.Companion.getEmpty()) {
            v3_3 = new VectorPainter(null, 1, null);
            v1.updateRememberedValue(v3_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        VectorPainterKt.configureVectorPainter-T4PVSW8(v3_3, v12, v14, v19, v5_2, v24);
        long v7_2 = v14;
        CompositionContext v9 = ComposablesKt.rememberCompositionContext(v1, 0);
        ComposerKt.sourceInformationMarkerStart(v1, 0x765ED6CD, v11);
        v10 = 0x100;
        int v4_1 = (v2 & 0x380 ^ 0x180) > v10 && (v1.changed(v4)) || (v2 & 0x180) == v10 ? 1 : 0;
        v10 = 0x800;
        v5 = (v2 & 0x1C00 ^ 0xC00) > v10 && (v1.changed(v6)) || (v2 & 0xC00) == v10 ? 1 : 0;
        v4_1 |= v5;
        int v6_1 = 0x6000000;
        v10 = 0x4000000;
        v2 = (0xE000000 & v2 ^ v6_1) > v10 && (v1.changed(v0)) || (v2 & v6_1) == v10 ? 1 : 0;
        v2 |= v4_1;
        Object v4_2 = v1.rememberedValue();
        if(v2 != 0 || v4_2 == Composer.Companion.getEmpty()) {
            Composition v2_1 = v3_3.getComposition$ui();
            if(v2_1 == null || (v2_1.isDisposed())) {
                v2_1 = CompositionKt.Composition(new VectorApplier(v3_3.getVector$ui().getRoot()), v9);
            }

            v4_3 = v2_1;
            v4_3.setContent(ComposableLambdaKt.composableLambdaInstance(1749374910, true, new VectorPainterKt$rememberVectorPainter$2$composition$1$1(v0, v7_2)));
            v1.updateRememberedValue(v4_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        v3_3.setComposition$ui(v4_3);
        ComposerKt.sourceInformationMarkerStart(v1, 0x765F1EF3, v11);
        boolean v0_1 = v1.changedInstance(v4_3);
        Object v2_2 = v1.rememberedValue();
        if((v0_1) || v2_2 == Composer.Companion.getEmpty()) {
            VectorPainterKt$rememberVectorPainter$2$1$1 v2_3 = new VectorPainterKt$rememberVectorPainter$2$1$1(v4_3);
            v1.updateRememberedValue(v2_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        EffectsKt.DisposableEffect(v3_3, ((Function1)v2_2), v1, 0);
        v1.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v3_3;
    }
}

