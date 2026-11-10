package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 »\u00012\u00020\u0001:\u0002»\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010w\u001A\u00020\u000F2\u0006\u00105\u001A\u0002042\u0006\u0010;\u001A\u00020:H\u0002¢\u0006\u0004\bx\u0010yJ>\u0010z\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010;\u001A\u00020:2\u0017\u0010{\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010¢\u0006\u0004\b|\u0010}J\b\u0010~\u001A\u00020\u000FH\u0002J\f\u0010\u007F\u001A\u00020\u000F*\u00020\u000EH\u0002J\u0012\u0010\u0080\u0001\u001A\u00020\u000F2\u0007\u0010\u0081\u0001\u001A\u00020\u0000H\u0002J\u0013\u0010\u0082\u0001\u001A\u00020\u000F2\b\u0010\u0083\u0001\u001A\u00030\u0084\u0001H\u0002J\u0019\u0010\u0085\u0001\u001A\u00020\u000F2\b\u0010\u0086\u0001\u001A\u00030\u0087\u0001H\u0000¢\u0006\u0003\b\u0088\u0001J\t\u0010\u0089\u0001\u001A\u00020\u000FH\u0002J$\u0010\u008A\u0001\u001A\u00020\u000F2\b\u0010\u0086\u0001\u001A\u00030\u0087\u00012\t\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u008C\u0001J\t\u0010\u008D\u0001\u001A\u00020\u000FH\u0002J\t\u0010\u008E\u0001\u001A\u00020\u000FH\u0002J\n\u0010\u0091\u0001\u001A\u00030\u0090\u0001H\u0002J\t\u0010\u0092\u0001\u001A\u00020\u000FH\u0002J4\u0010\u0093\u0001\u001A\u0003H\u0094\u0001\"\u0005\b\u0000\u0010\u0094\u00012\u001A\u0010{\u001A\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001A\u0012\u0005\u0012\u0003H\u0094\u00010\u0095\u0001H\u0082\b¢\u0006\u0003\u0010\u0096\u0001J\u0014\u0010\u0097\u0001\u001A\u0004\u0018\u00010\u00132\u0007\u0010\u0098\u0001\u001A\u00020 H\u0002J\t\u0010\u0099\u0001\u001A\u00020\u0013H\u0002J\u000F\u0010\u009A\u0001\u001A\u00020\u000FH\u0000¢\u0006\u0003\b\u009B\u0001J\t\u0010\u009C\u0001\u001A\u00020\u000FH\u0002J\u000F\u0010\u009D\u0001\u001A\u00020\u000FH\u0000¢\u0006\u0003\b\u009E\u0001J\u000F\u0010\u009F\u0001\u001A\u00020\u000FH\u0001¢\u0006\u0003\b \u0001J\t\u0010©\u0001\u001A\u00020\u000FH\u0002J\u0010\u0010ª\u0001\u001A\u00020\u000F2\u0007\u0010\u0098\u0001\u001A\u00020 J/\u0010«\u0001\u001A\u00020\u000F2\b\b\u0002\u00105\u001A\u00020\u00172\b\b\u0002\u0010;\u001A\u00020\u001A2\t\b\u0002\u0010¬\u0001\u001A\u00020\u001C¢\u0006\u0006\b­\u0001\u0010®\u0001J#\u0010¯\u0001\u001A\u00020\u000F2\b\b\u0002\u00105\u001A\u00020\u00172\b\b\u0002\u0010;\u001A\u00020\u001A¢\u0006\u0005\b°\u0001\u0010yJ\u0011\u0010¸\u0001\u001A\u00030¹\u0001H\u0086@¢\u0006\u0003\u0010º\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0018R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010,\u001A\u00020\u00152\u0006\u0010+\u001A\u00020\u0015@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R$\u0010/\u001A\u00020.2\u0006\u0010+\u001A\u00020.8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b0\u00101\"\u0004\b2\u00103R&\u00105\u001A\u0002042\u0006\u0010+\u001A\u000204@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010;\u001A\u00020:2\u0006\u0010+\u001A\u00020:@BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b<\u00107\"\u0004\b=\u00109R$\u0010>\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001A\u00020C2\u0006\u0010+\u001A\u00020C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bE\u00101\"\u0004\bF\u00103R(\u0010H\u001A\u0004\u0018\u00010G2\b\u0010+\u001A\u0004\u0018\u00010G8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bI\u0010J\"\u0004\bK\u0010LR&\u0010M\u001A\u00020\u00172\u0006\u0010+\u001A\u00020\u0017@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\bN\u00107\"\u0004\bO\u00109R$\u0010P\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bQ\u0010@\"\u0004\bR\u0010BR$\u0010S\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bT\u0010@\"\u0004\bU\u0010BR$\u0010V\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bW\u0010@\"\u0004\bX\u0010BR$\u0010Y\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bZ\u0010@\"\u0004\b[\u0010BR$\u0010\\\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b]\u0010@\"\u0004\b^\u0010BR$\u0010_\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b`\u0010@\"\u0004\ba\u0010BR$\u0010b\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bc\u0010@\"\u0004\bd\u0010BR$\u0010e\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bf\u0010@\"\u0004\bg\u0010BR$\u0010h\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bi\u0010@\"\u0004\bj\u0010BR*\u0010k\u001A\u00020\u00152\u0006\u0010+\u001A\u00020\u0015@FX\u0086\u000E¢\u0006\u0014\n\u0000\u0012\u0004\bl\u0010m\u001A\u0004\bn\u0010-\"\u0004\bo\u0010pR(\u0010r\u001A\u0004\u0018\u00010q2\b\u0010+\u001A\u0004\u0018\u00010q8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0012\u0010\u008F\u0001\u001A\u0005\u0018\u00010\u0090\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010¡\u0001\u001A\u00030¢\u00018F¢\u0006\u0007\u001A\u0005\b£\u0001\u00107R\u0014\u0010¤\u0001\u001A\u00030¢\u00018F¢\u0006\u0007\u001A\u0005\b¥\u0001\u00107R\u0014\u0010¦\u0001\u001A\u00020\u001E8F¢\u0006\b\u001A\u0006\b§\u0001\u0010¨\u0001R)\u0010²\u0001\u001A\u00030±\u00012\u0007\u0010+\u001A\u00030±\u00018F@FX\u0086\u000E¢\u0006\u000E\u001A\u0005\b³\u0001\u00107\"\u0005\b´\u0001\u00109R)\u0010µ\u0001\u001A\u00030±\u00012\u0007\u0010+\u001A\u00030±\u00018F@FX\u0086\u000E¢\u0006\u000E\u001A\u0005\b¶\u0001\u00107\"\u0005\b·\u0001\u00109¨\u0006¼\u0001"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;)V", "getImpl$ui_graphics", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "clipDrawBlock", "androidOutline", "Landroid/graphics/Outline;", "outlineDirty", "", "roundRectOutlineTopLeft", "Landroidx/compose/ui/geometry/Offset;", "J", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectCornerRadius", "", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "softwareDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "parentLayerUsages", "", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "value", "isReleased", "()Z", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip$annotations", "()V", "getClip", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "drawWithChildTracking", "addSubLayer", "graphicsLayer", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "drawForPersistence", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "drawForPersistence$ui_graphics", "recreateDisplayListIfNeeded", "draw", "parentLayer", "draw$ui_graphics", "onAddedToParentLayer", "onRemovedFromParentLayer", "pathBounds", "Landroid/graphics/RectF;", "obtainPathBounds", "configureOutlineAndClip", "resolveOutlinePosition", "T", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "updatePathOutline", "path", "obtainAndroidOutline", "release", "release$ui_graphics", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics", "emulateTrimMemory", "emulateTrimMemory$ui_graphics", "layerId", "", "getLayerId", "ownerViewId", "getOwnerViewId", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "resetOutlineParams", "setPathOutline", "setRoundRectOutline", "cornerRadius", "setRoundRectOutline-TNW_H78", "(JJF)V", "setRectOutline", "setRectOutline-tz77jQw", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayer {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayer$Companion;", "", "<init>", "()V", "isRobolectric", "", "SnapshotImpl", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final LayerSnapshotImpl SnapshotImpl;
    private Outline androidOutline;
    private final ChildLayerDependenciesTracker childDependenciesTracker;
    private boolean clip;
    private final Function1 clipDrawBlock;
    private Density density;
    private Function1 drawBlock;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private static final boolean isRobolectric;
    private LayoutDirection layoutDirection;
    private boolean outlineDirty;
    private Path outlinePath;
    private int parentLayerUsages;
    private RectF pathBounds;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long roundRectOutlineSize;
    private long roundRectOutlineTopLeft;
    private long size;
    private CanvasDrawScope softwareDrawScope;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;

    static {
        LayerSnapshotV21 v0_2;
        GraphicsLayer.Companion = new Companion(null);
        GraphicsLayer.$stable = 8;
        String v0 = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
        boolean v0_1 = Intrinsics.areEqual(v0, "robolectric");
        GraphicsLayer.isRobolectric = v0_1;
        if(v0_1) {
            v0_2 = LayerSnapshotV21.INSTANCE;
        }
        else if(Build$VERSION.SDK_INT >= 28) {
            LayerSnapshotV28 v0_3 = LayerSnapshotV28.INSTANCE;
        }
        else if(SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            LayerSnapshotV22 v0_4 = LayerSnapshotV22.INSTANCE;
        }
        else {
            v0_2 = LayerSnapshotV21.INSTANCE;
        }

        GraphicsLayer.SnapshotImpl = ((LayerSnapshotImpl)v0_2);
    }

    public GraphicsLayer(GraphicsLayerImpl arg3) {
        super();
        this.impl = arg3;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayer$drawBlock$1.INSTANCE;
        this.clipDrawBlock = new GraphicsLayer$clipDrawBlock$1(this);
        this.outlineDirty = true;
        this.roundRectOutlineTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.roundRectOutlineSize = Size.Companion.getUnspecified-NH-jbRc();
        this.childDependenciesTracker = new ChildLayerDependenciesTracker();
        arg3.setClip(false);
        this.topLeft = IntOffset.Companion.getZero-nOcc-ac();
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
    }

    public static final void access$drawWithChildTracking(GraphicsLayer arg0, DrawScope arg1) {
        arg0.drawWithChildTracking(arg1);
    }

    public static final Path access$getOutlinePath$p(GraphicsLayer arg0) {
        return arg0.outlinePath;
    }

    public static final boolean access$getUsePathForClip$p(GraphicsLayer arg0) {
        return arg0.usePathForClip;
    }

    private final void addSubLayer(GraphicsLayer arg1) {
        if(this.childDependenciesTracker.onDependencyAdded(arg1)) {
            arg1.onAddedToParentLayer();
        }
    }

    private final void configureOutlineAndClip() {
        if(this.outlineDirty) {
            Outline v2 = null;
            if(!this.clip) {
                if(this.getShadowElevation() > 0f) {
                }
                else {
                    this.impl.setClip(false);
                    this.impl.setOutline-O0kMr_c(v2, IntSize.Companion.getZero-YbymL2g());
                    goto label_103;
                }
            }

            Path v0 = this.outlinePath;
            long v3 = 0xFFFFFFFFL;
            int v5 = 0x20;
            if(v0 != null) {
                RectF v6 = this.obtainPathBounds();
                if((v0 instanceof AndroidPath)) {
                    v0.getInternalPath().computeBounds(v6, false);
                    Outline v0_1 = this.updatePathOutline(v0);
                    if(v0_1 != null) {
                        v0_1.setAlpha(this.getAlpha());
                        v2 = v0_1;
                    }

                    this.impl.setOutline-O0kMr_c(v2, IntSize.constructor-impl(v3 & (((long)Math.round(v6.height()))) | (((long)Math.round(v6.width()))) << v5));
                    if((this.usePathForClip) && (this.clip)) {
                        this.impl.setClip(false);
                        this.impl.discardDisplayList();
                        goto label_103;
                    }

                    this.impl.setClip(this.clip);
                    goto label_103;
                }

                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }

            this.impl.setClip(this.clip);
            Size.Companion.getZero-NH-jbRc();
            Outline v6_1 = this.obtainAndroidOutline();
            long v7 = IntSizeKt.toSize-ozmzZPI(this.size);
            long v9 = this.roundRectOutlineTopLeft;
            long v11 = this.roundRectOutlineSize;
            long v12 = v11 == 0x7FC000007FC00000L ? v7 : v11;
            int v0_2 = ((int)(v9 >> v5));
            int v2_1 = ((int)(v9 & v3));
            v6_1.setRoundRect(Math.round(Float.intBitsToFloat(v0_2)), Math.round(Float.intBitsToFloat(v2_1)), Math.round(Float.intBitsToFloat(v0_2) + Float.intBitsToFloat(((int)(v12 >> v5)))), Math.round(Float.intBitsToFloat(v2_1) + Float.intBitsToFloat(((int)(v12 & v3)))), this.roundRectCornerRadius);
            v6_1.setAlpha(this.getAlpha());
            this.impl.setOutline-O0kMr_c(v6_1, IntSizeKt.roundToIntSize-uvyYCjk(v12));
        }

    label_103:
        this.outlineDirty = false;
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if((this.isReleased) && this.parentLayerUsages == 0) {
            this.discardDisplayList$ui_graphics();
        }
    }

    public final void discardDisplayList$ui_graphics() {
        ChildLayerDependenciesTracker v0 = this.childDependenciesTracker;
        GraphicsLayer v1 = v0.dependency;
        if(v1 != null) {
            v1.onRemovedFromParentLayer();
            v0.dependency = null;
        }

        MutableScatterSet v0_1 = v0.dependenciesSet;
        if(v0_1 != null) {
            Object[] v2 = v0_1.elements;
            long[] v1_1 = v0_1.metadata;
            int v3 = v1_1.length - 2;
            if(v3 >= 0) {
                int v5;
                for(v5 = 0; true; ++v5) {
                    long v6 = v1_1[v5];
                    if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                        int v9 = 8;
                        int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                        int v10;
                        for(v10 = 0; v10 < v8; ++v10) {
                            if((0xFF & v6) < 0x80) {
                                v2[(v5 << 3) + v10].onRemovedFromParentLayer();
                            }

                            v6 >>= v9;
                        }

                        if(v8 != v9) {
                            break;
                        }
                    }

                    if(v5 == v3) {
                        break;
                    }
                }
            }

            v0_1.clear();
        }

        this.impl.discardDisplayList();
    }

    public final void draw$ui_graphics(Canvas arg19, GraphicsLayer arg20) {
        int v16;
        int v17;
        GraphicsLayer v0 = this;
        Canvas v1 = arg19;
        GraphicsLayer v2 = arg20;
        if(v0.isReleased) {
        }
        else {
            v0.configureOutlineAndClip();
            v0.recreateDisplayListIfNeeded();
            int v4 = 1;
            int v3 = Float.compare(v0.getShadowElevation(), 0f) > 0 ? 1 : 0;
            if(v3 != 0) {
                v1.enableZ();
            }

            android.graphics.Canvas v6 = AndroidCanvas_androidKt.getNativeCanvas(v1);
            boolean v7 = v6.isHardwareAccelerated();
            if(!v7) {
                v0.transformCanvas(v6);
            }

            if((v7) || !v0.clip) {
                v4 = 0;
            }
            else {
            }

            if(v4 != 0) {
                v1.save();
                androidx.compose.ui.graphics.Outline v8 = v0.getOutline();
                int v10 = 2;
                Object v11 = null;
                if((v8 instanceof Rectangle)) {
                    Canvas.clipRect-mtrdD-E$default(v1, ((Rectangle)v8).getBounds(), 0, v10, v11);
                }
                else if((v8 instanceof Rounded)) {
                    Path v9 = v0.roundRectClipPath;
                    if(v9 != null) {
                        v9.rewind();
                    }
                    else {
                        v9 = AndroidPath_androidKt.Path();
                        v0.roundRectClipPath = v9;
                    }

                    Path.addRoundRect$default(v9, ((Rounded)v8).getRoundRect(), ((Direction)v11), v10, v11);
                    Canvas.clipPath-mtrdD-E$default(v1, v9, 0, v10, v11);
                }
                else {
                    if((v8 instanceof Generic)) {
                        Canvas.clipPath-mtrdD-E$default(v1, ((Generic)v8).getPath(), 0, v10, v11);
                        goto label_58;
                    }

                    throw new NoWhenBranchMatchedException();
                }
            }

        label_58:
            if(v2 != null) {
                v2.addSubLayer(v0);
            }

            if((AndroidCanvas_androidKt.getNativeCanvas(v1).isHardwareAccelerated()) || (v0.impl.getSupportsSoftwareRendering())) {
                v17 = v3;
                v16 = v4;
                v0.impl.draw(v1);
            }
            else {
                CanvasDrawScope v2_1 = v0.softwareDrawScope;
                if(v2_1 == null) {
                    v2_1 = new CanvasDrawScope();
                    v0.softwareDrawScope = v2_1;
                }

                Density v5 = v0.density;
                LayoutDirection v8_1 = v0.layoutDirection;
                long v9_1 = IntSizeKt.toSize-ozmzZPI(v0.size);
                Density v11_1 = ((DrawScope)v2_1).getDrawContext().getDensity();
                LayoutDirection v12 = ((DrawScope)v2_1).getDrawContext().getLayoutDirection();
                Canvas v13 = ((DrawScope)v2_1).getDrawContext().getCanvas();
                long v14 = ((DrawScope)v2_1).getDrawContext().getSize-NH-jbRc();
                v17 = v3;
                GraphicsLayer v3_1 = ((DrawScope)v2_1).getDrawContext().getGraphicsLayer();
                v16 = v4;
                DrawContext v4_1 = ((DrawScope)v2_1).getDrawContext();
                v4_1.setDensity(v5);
                v4_1.setLayoutDirection(v8_1);
                v4_1.setCanvas(v1);
                v4_1.setSize-uvyYCjk(v9_1);
                v4_1.setGraphicsLayer(v0);
                v1.save();
                try {
                    v0.drawWithChildTracking(((DrawScope)v2_1));
                }
                catch(Throwable v0_1) {
                    v1.restore();
                    DrawContext v1_1 = ((DrawScope)v2_1).getDrawContext();
                    v1_1.setDensity(v11_1);
                    v1_1.setLayoutDirection(v12);
                    v1_1.setCanvas(v13);
                    v1_1.setSize-uvyYCjk(v14);
                    v1_1.setGraphicsLayer(v3_1);
                    throw v0_1;
                }

                v1.restore();
                DrawContext v0_2 = ((DrawScope)v2_1).getDrawContext();
                v0_2.setDensity(v11_1);
                v0_2.setLayoutDirection(v12);
                v0_2.setCanvas(v13);
                v0_2.setSize-uvyYCjk(v14);
                v0_2.setGraphicsLayer(v3_1);
            }

            if(v16 != 0) {
                v1.restore();
            }

            if(v17 != 0) {
                v1.disableZ();
            }

            if(v7) {
                return;
            }

            v6.restore();
        }
    }

    public final void drawForPersistence$ui_graphics(Canvas arg2) {
        if(!AndroidCanvas_androidKt.getNativeCanvas(arg2).isHardwareAccelerated()) {
            if(this.impl.getSupportsSoftwareRendering()) {
            }
            else {
                return;
            }
        }

        this.recreateDisplayListIfNeeded();
        this.impl.draw(arg2);
    }

    private final void drawWithChildTracking(DrawScope arg14) {
        ChildLayerDependenciesTracker v0 = this.childDependenciesTracker;
        v0.oldDependency = v0.dependency;
        MutableScatterSet v1 = v0.dependenciesSet;
        if(v1 != null && (v1.isNotEmpty())) {
            MutableScatterSet v2 = v0.oldDependenciesSet;
            if(v2 == null) {
                v2 = ScatterSetKt.mutableScatterSetOf();
                v0.oldDependenciesSet = v2;
            }

            v2.addAll(v1);
            v1.clear();
        }

        v0.trackingInProgress = true;
        this.drawBlock.invoke(arg14);
        v0.trackingInProgress = false;
        GraphicsLayer v14 = v0.oldDependency;
        if(v14 != null) {
            v14.onRemovedFromParentLayer();
        }

        MutableScatterSet v14_1 = v0.oldDependenciesSet;
        if(v14_1 != null && (v14_1.isNotEmpty())) {
            Object[] v1_1 = v14_1.elements;
            long[] v0_1 = v14_1.metadata;
            int v2_1 = v0_1.length - 2;
            if(v2_1 >= 0) {
                int v3;
                for(v3 = 0; true; ++v3) {
                    long v4 = v0_1[v3];
                    if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                        int v7 = 8;
                        int v6 = 8 - (~(v3 - v2_1) >>> 0x1F);
                        int v8;
                        for(v8 = 0; v8 < v6; ++v8) {
                            if((0xFF & v4) < 0x80) {
                                v1_1[(v3 << 3) + v8].onRemovedFromParentLayer();
                            }

                            v4 >>= v7;
                        }

                        if(v6 != v7) {
                            break;
                        }
                    }

                    if(v3 == v2_1) {
                        break;
                    }
                }
            }

            v14_1.clear();
        }
    }

    public final void emulateTrimMemory$ui_graphics() {
        this.impl.discardDisplayList();
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final long getAmbientShadowColor-0d7_KjU() {
        return this.impl.getAmbientShadowColor-0d7_KjU();
    }

    public final int getBlendMode-0nO6VwU() {
        return this.impl.getBlendMode-0nO6VwU();
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final boolean getClip() {
        return this.clip;
    }

    public static void getClip$annotations() {
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final int getCompositingStrategy-ke2Ky5w() {
        return this.impl.getCompositingStrategy-ke2Ky5w();
    }

    public final GraphicsLayerImpl getImpl$ui_graphics() {
        return this.impl;
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        Rectangle v1_2;
        androidx.compose.ui.graphics.Outline v0 = this.internalOutline;
        Path v1 = this.outlinePath;
        if(v0 != null) {
            return v0;
        }

        if(v1 != null) {
            Generic v0_1 = new Generic(v1);
            this.internalOutline = ((androidx.compose.ui.graphics.Outline)v0_1);
            return ((androidx.compose.ui.graphics.Outline)v0_1);
        }

        long v0_2 = IntSizeKt.toSize-ozmzZPI(this.size);
        long v2 = this.roundRectOutlineTopLeft;
        long v4 = this.roundRectOutlineSize;
        if(v4 == 0x7FC000007FC00000L) {
        }
        else {
            v0_2 = v4;
        }

        int v4_1 = 0x20;
        float v6 = Float.intBitsToFloat(((int)(v2 >> v4_1)));
        long v7 = 0xFFFFFFFFL;
        float v2_1 = Float.intBitsToFloat(((int)(v2 & v7)));
        float v3 = Float.intBitsToFloat(((int)(v0_2 >> v4_1))) + v6;
        float v9 = v2_1 + Float.intBitsToFloat(((int)(v0_2 & v7)));
        float v0_3 = this.roundRectCornerRadius;
        if(v0_3 > 0f) {
            Rounded v1_1 = new Rounded(RoundRectKt.RoundRect-gG7oq9Y(v6, v2_1, v3, v9, CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v0_3))) << v4_1 | v7 & (((long)Float.floatToRawIntBits(v0_3))))));
        }
        else {
            v1_2 = new Rectangle(new Rect(v6, v2_1, v3, v9));
        }

        this.internalOutline = ((androidx.compose.ui.graphics.Outline)v1_2);
        return ((androidx.compose.ui.graphics.Outline)v1_2);
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final long getPivotOffset-F1C5BW0() {
        return this.pivotOffset;
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final long getSize-YbymL2g() {
        return this.size;
    }

    public final long getSpotShadowColor-0d7_KjU() {
        return this.impl.getSpotShadowColor-0d7_KjU();
    }

    public final long getTopLeft-nOcc-ac() {
        return this.topLeft;
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    private final Outline obtainAndroidOutline() {
        Outline v0 = this.androidOutline;
        if(v0 == null) {
            v0 = new Outline();
            this.androidOutline = v0;
        }

        return v0;
    }

    private final RectF obtainPathBounds() {
        RectF v0 = this.pathBounds;
        if(v0 == null) {
            v0 = new RectF();
            this.pathBounds = v0;
        }

        return v0;
    }

    private final void onAddedToParentLayer() {
        ++this.parentLayerUsages;
    }

    private final void onRemovedFromParentLayer() {
        --this.parentLayerUsages;
        this.discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    public final void record-mL-hObY(Density arg1, LayoutDirection arg2, long arg3, Function1 arg5) {
        this.setSize-ozmzZPI(arg3);
        this.density = arg1;
        this.layoutDirection = arg2;
        this.drawBlock = arg5;
        this.impl.setInvalidated(true);
        this.recordInternal();
    }

    private final void recordInternal() {
        this.impl.record(this.density, this.layoutDirection, this, this.clipDrawBlock);
    }

    private final void recreateDisplayListIfNeeded() {
        if(!this.impl.getHasDisplayList()) {
            try {
                this.recordInternal();
                return;
            }
            catch(Throwable ) {
                return;
            }
        }
    }

    public final void release$ui_graphics() {
        if(!this.isReleased) {
            this.isReleased = true;
            this.discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.Companion.getUnspecified-NH-jbRc();
        this.roundRectOutlineTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.roundRectCornerRadius = 0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    private final Object resolveOutlinePosition(Function2 arg9) {
        long v0 = IntSizeKt.toSize-ozmzZPI(this.size);
        long v2 = this.roundRectOutlineTopLeft;
        long v4 = this.roundRectOutlineSize;
        if(v4 == 0x7FC000007FC00000L) {
        }
        else {
            v0 = v4;
        }

        return arg9.invoke(Offset.box-impl(v2), Size.box-impl(v0));
    }

    public final void setAlpha(float arg2) {
        if(this.impl.getAlpha() == arg2) {
            return;
        }

        this.impl.setAlpha(arg2);
    }

    public final void setAmbientShadowColor-8_81llA(long arg3) {
        if(!Color.equals-impl0(arg3, this.impl.getAmbientShadowColor-0d7_KjU())) {
            this.impl.setAmbientShadowColor-8_81llA(arg3);
        }
    }

    public final void setBlendMode-s9anfk8(int arg2) {
        if(!BlendMode.equals-impl0(this.impl.getBlendMode-0nO6VwU(), arg2)) {
            this.impl.setBlendMode-s9anfk8(arg2);
        }
    }

    public final void setCameraDistance(float arg2) {
        if(this.impl.getCameraDistance() == arg2) {
            return;
        }

        this.impl.setCameraDistance(arg2);
    }

    public final void setClip(boolean arg2) {
        if(this.clip != arg2) {
            this.clip = arg2;
            this.outlineDirty = true;
            this.configureOutlineAndClip();
        }
    }

    public final void setColorFilter(ColorFilter arg2) {
        if(!Intrinsics.areEqual(this.impl.getColorFilter(), arg2)) {
            this.impl.setColorFilter(arg2);
        }
    }

    public final void setCompositingStrategy-Wpw9cng(int arg2) {
        if(!CompositingStrategy.equals-impl0(this.impl.getCompositingStrategy-ke2Ky5w(), arg2)) {
            this.impl.setCompositingStrategy-Wpw9cng(arg2);
        }
    }

    public final void setPathOutline(Path arg1) {
        this.resetOutlineParams();
        this.outlinePath = arg1;
        this.configureOutlineAndClip();
    }

    public final void setPivotOffset-k-4lQ0M(long arg3) {
        if(!Offset.equals-impl0(this.pivotOffset, arg3)) {
            this.pivotOffset = arg3;
            this.impl.setPivotOffset-k-4lQ0M(arg3);
        }
    }

    private final void setPosition-VbeCjmY(long arg2, long arg4) {
        this.impl.setPosition-H0pRuoY(IntOffset.getX-impl(arg2), IntOffset.getY-impl(arg2), arg4);
    }

    public final void setRectOutline-tz77jQw(long arg7, long arg9) {
        this.setRoundRectOutline-TNW_H78(arg7, arg9, 0f);
    }

    public static void setRectOutline-tz77jQw$default(GraphicsLayer arg0, long arg1, long arg3, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Offset.Companion.getZero-F1C5BW0();
        }

        if((arg5 & 2) != 0) {
            arg3 = Size.Companion.getUnspecified-NH-jbRc();
        }

        arg0.setRectOutline-tz77jQw(arg1, arg3);
    }

    public final void setRenderEffect(RenderEffect arg2) {
        if(!Intrinsics.areEqual(this.impl.getRenderEffect(), arg2)) {
            this.impl.setRenderEffect(arg2);
        }
    }

    public final void setRotationX(float arg2) {
        if(this.impl.getRotationX() == arg2) {
            return;
        }

        this.impl.setRotationX(arg2);
    }

    public final void setRotationY(float arg2) {
        if(this.impl.getRotationY() == arg2) {
            return;
        }

        this.impl.setRotationY(arg2);
    }

    public final void setRotationZ(float arg2) {
        if(this.impl.getRotationZ() == arg2) {
            return;
        }

        this.impl.setRotationZ(arg2);
    }

    public final void setRoundRectOutline-TNW_H78(long arg3, long arg5, float arg7) {
        if((Offset.equals-impl0(this.roundRectOutlineTopLeft, arg3)) && (Size.equals-impl0(this.roundRectOutlineSize, arg5)) && this.roundRectCornerRadius == arg7) {
            if(this.outlinePath != null) {
            }
            else {
                return;
            }
        }

        this.resetOutlineParams();
        this.roundRectOutlineTopLeft = arg3;
        this.roundRectOutlineSize = arg5;
        this.roundRectCornerRadius = arg7;
        this.configureOutlineAndClip();
    }

    public static void setRoundRectOutline-TNW_H78$default(GraphicsLayer arg6, long arg7, long arg9, float arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = Offset.Companion.getZero-F1C5BW0();
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = Size.Companion.getUnspecified-NH-jbRc();
        }

        arg6.setRoundRectOutline-TNW_H78(v1, arg9, 0f);
    }

    public final void setScaleX(float arg2) {
        if(this.impl.getScaleX() == arg2) {
            return;
        }

        this.impl.setScaleX(arg2);
    }

    public final void setScaleY(float arg2) {
        if(this.impl.getScaleY() == arg2) {
            return;
        }

        this.impl.setScaleY(arg2);
    }

    public final void setShadowElevation(float arg2) {
        if(this.impl.getShadowElevation() == arg2) {
            return;
        }

        this.impl.setShadowElevation(arg2);
        this.outlineDirty = true;
        this.configureOutlineAndClip();
    }

    private final void setSize-ozmzZPI(long arg3) {
        if(!IntSize.equals-impl0(this.size, arg3)) {
            this.size = arg3;
            this.setPosition-VbeCjmY(this.topLeft, arg3);
            if(this.roundRectOutlineSize == 0x7FC000007FC00000L) {
                this.outlineDirty = true;
                this.configureOutlineAndClip();
            }
        }
    }

    public final void setSpotShadowColor-8_81llA(long arg3) {
        if(!Color.equals-impl0(arg3, this.impl.getSpotShadowColor-0d7_KjU())) {
            this.impl.setSpotShadowColor-8_81llA(arg3);
        }
    }

    public final void setTopLeft--gyyYBs(long arg3) {
        if(!IntOffset.equals-impl0(this.topLeft, arg3)) {
            this.topLeft = arg3;
            this.setPosition-VbeCjmY(arg3, this.size);
        }
    }

    public final void setTranslationX(float arg2) {
        if(this.impl.getTranslationX() == arg2) {
            return;
        }

        this.impl.setTranslationX(arg2);
    }

    public final void setTranslationY(float arg2) {
        if(this.impl.getTranslationY() == arg2) {
            return;
        }

        this.impl.setTranslationY(arg2);
    }

    public final Object toImageBitmap(Continuation arg5) {
        GraphicsLayer$toImageBitmap$1 v0_1;
        int v2;
        if((arg5 instanceof GraphicsLayer$toImageBitmap$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((GraphicsLayer$toImageBitmap$1)v0).label & v2) != 0) {
                ((GraphicsLayer$toImageBitmap$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new GraphicsLayer$toImageBitmap$1(this, arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            LayerSnapshotImpl v5_1 = GraphicsLayer.SnapshotImpl;
            v0_1.label = 1;
            v5 = v5_1.toBitmap(this, ((Continuation)v0_1));
            if(v5 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return AndroidImageBitmap_androidKt.asImageBitmap(((Bitmap)v5));
    }

    private final void transformCanvas(android.graphics.Canvas arg10) {
        android.graphics.Canvas v1_1;
        float v2 = ((float)IntOffset.getX-impl(this.topLeft));
        float v3 = ((float)IntOffset.getY-impl(this.topLeft));
        float v4 = (((float)IntOffset.getX-impl(this.topLeft))) + (((float)(((int)(this.size >> 0x20)))));
        float v5 = (((float)IntOffset.getY-impl(this.topLeft))) + (((float)(((int)(this.size & 0xFFFFFFFFL)))));
        float v0 = this.getAlpha();
        ColorFilter v1 = this.getColorFilter();
        int v6 = this.getBlendMode-0nO6VwU();
        if(v0 < 1f || !BlendMode.equals-impl0(v6, BlendMode.Companion.getSrcOver-0nO6VwU()) || v1 != null || (CompositingStrategy.equals-impl0(this.getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w()))) {
            Paint v7 = this.softwareLayerPaint;
            if(v7 == null) {
                v7 = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = v7;
            }

            v7.setAlpha(v0);
            v7.setBlendMode-s9anfk8(v6);
            v7.setColorFilter(v1);
            v1_1 = arg10;
            v1_1.saveLayer(v2, v3, v4, v5, v7.asFrameworkPaint());
        }
        else {
            arg10.save();
            v1_1 = arg10;
        }

        v1_1.translate(v2, v3);
        v1_1.concat(this.impl.calculateMatrix());
    }

    private final Outline updatePathOutline(Path arg5) {
        Outline v0;
        if(Build$VERSION.SDK_INT > 28 || (arg5.isConvex())) {
            v0 = this.obtainAndroidOutline();
            if(Build$VERSION.SDK_INT >= 30) {
                OutlineVerificationHelper.INSTANCE.setPath(v0, arg5);
            }
            else if((arg5 instanceof AndroidPath)) {
                v0.setConvexPath(arg5.getInternalPath());
            }
            else {
                goto label_32;
            }

            this.usePathForClip = v0.canClip() ^ 1;
        }
        else {
            v0 = this.androidOutline;
            if(v0 != null) {
                v0.setEmpty();
            }

            this.usePathForClip = true;
            this.impl.setInvalidated(true);
            v0 = null;
        }

        this.outlinePath = arg5;
        return v0;
    label_32:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}

