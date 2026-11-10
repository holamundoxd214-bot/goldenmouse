package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000B\u001A\u00020\fH\u0016J4\u0010\r\u001A\u00020\f*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001C\u0010\u0016\u001A\u00020\f*\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u000EJ9\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000F\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\t\u001A\u00020\u001E2\b\u0010\u0019\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0004\b\u001F\u0010 J9\u0010!\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000F\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0019\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0004\b\"\u0010#Jd\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b5\u00106Jd\u0010$\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b9\u0010:JL\u0010;\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010<\u001A\u00020(2\u0006\u0010=\u001A\u00020-2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b>\u0010?JL\u0010;\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010<\u001A\u00020(2\u0006\u0010=\u001A\u00020-2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b@\u0010AJD\u0010B\u001A\u00020\f2\u0006\u0010C\u001A\u00020D2\u0006\u0010,\u001A\u00020-2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bE\u0010FJ\\\u0010B\u001A\u00020\f2\u0006\u0010C\u001A\u00020D2\u0006\u0010G\u001A\u00020H2\u0006\u0010I\u001A\u00020\u00102\u0006\u0010J\u001A\u00020H2\u0006\u0010K\u001A\u00020\u00102\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0097\u0001¢\u0006\u0004\bL\u0010MJd\u0010B\u001A\u00020\f2\u0006\u0010C\u001A\u00020D2\u0006\u0010G\u001A\u00020H2\u0006\u0010I\u001A\u00020\u00102\u0006\u0010J\u001A\u00020H2\u0006\u0010K\u001A\u00020\u00102\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u0002042\u0006\u0010N\u001A\u00020OH\u0096\u0001¢\u0006\u0004\bP\u0010QJ^\u0010R\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010S\u001A\u00020-2\u0006\u0010T\u001A\u00020-2\u0006\u0010U\u001A\u00020(2\u0006\u0010V\u001A\u00020W2\b\u0010X\u001A\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bZ\u0010[J^\u0010R\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010S\u001A\u00020-2\u0006\u0010T\u001A\u00020-2\u0006\u0010U\u001A\u00020(2\u0006\u0010V\u001A\u00020W2\b\u0010X\u001A\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b\\\u0010]JL\u0010^\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b_\u0010`JL\u0010^\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\ba\u0010bJD\u0010c\u001A\u00020\f2\u0006\u0010d\u001A\u00020e2\u0006\u0010%\u001A\u00020&2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bf\u0010gJD\u0010c\u001A\u00020\f2\u0006\u0010d\u001A\u00020e2\u0006\u00107\u001A\u0002082\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bh\u0010iJd\u0010j\u001A\u00020\f2\f\u0010k\u001A\b\u0012\u0004\u0012\u00020-0l2\u0006\u0010m\u001A\u00020n2\u0006\u0010%\u001A\u00020&2\u0006\u0010U\u001A\u00020(2\u0006\u0010V\u001A\u00020W2\b\u0010X\u001A\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bo\u0010pJd\u0010j\u001A\u00020\f2\f\u0010k\u001A\b\u0012\u0004\u0012\u00020-0l2\u0006\u0010m\u001A\u00020n2\u0006\u00107\u001A\u0002082\u0006\u0010U\u001A\u00020(2\u0006\u0010V\u001A\u00020W2\b\u0010X\u001A\u0004\u0018\u00010Y2\b\b\u0001\u0010.\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bq\u0010rJL\u0010s\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bt\u0010`JL\u0010s\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\bu\u0010bJT\u0010v\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\u0006\u0010w\u001A\u00020x2\b\b\u0001\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\by\u0010zJT\u0010v\u001A\u00020\f2\u0006\u00107\u001A\u0002082\u0006\u0010,\u001A\u00020-2\u0006\u0010\u000F\u001A\u00020\u001B2\u0006\u0010w\u001A\u00020x2\u0006\u0010/\u001A\u0002002\b\b\u0001\u0010.\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0096\u0001¢\u0006\u0004\b{\u0010|J\u0016\u0010}\u001A\u00020~*\u00020\u007FH\u0097\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0017\u0010}\u001A\u00020~*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0017\u0010\u0085\u0001\u001A\u00020\u007F*\u00020~H\u0097\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0017\u0010\u0085\u0001\u001A\u00020\u007F*\u00020(H\u0097\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0088\u0001J\u0018\u0010\u0085\u0001\u001A\u00020\u007F*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008A\u0001J\u0018\u0010\u008B\u0001\u001A\u00030\u008C\u0001*\u00020\u001BH\u0097\u0001¢\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u0017\u0010\u008F\u0001\u001A\u00020(*\u00020\u007FH\u0097\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u0088\u0001J\u0018\u0010\u008F\u0001\u001A\u00020(*\u00030\u0082\u0001H\u0097\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u008A\u0001J\u0010\u0010\u0092\u0001\u001A\u00030\u0093\u0001*\u00030\u0094\u0001H\u0097\u0001J\u0018\u0010\u0095\u0001\u001A\u00020\u001B*\u00030\u008C\u0001H\u0097\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u008E\u0001J\u0018\u0010\u0097\u0001\u001A\u00030\u0082\u0001*\u00020~H\u0097\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0018\u0010\u0097\u0001\u001A\u00030\u0082\u0001*\u00020(H\u0097\u0001¢\u0006\u0006\b\u0098\u0001\u0010\u009A\u0001J\u0018\u0010\u0097\u0001\u001A\u00030\u0082\u0001*\u00020\u007FH\u0097\u0001¢\u0006\u0006\b\u009B\u0001\u0010\u009A\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010=\u001A\u00020-8VX\u0096\u0005¢\u0006\b\u001A\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0017\u0010\u009E\u0001\u001A\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001A\u0006\b\u009F\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001A\u00030¢\u0001X\u0096\u0005¢\u0006\b\u001A\u0006\b£\u0001\u0010¤\u0001R\u0017\u0010¥\u0001\u001A\u00020(8\u0016X\u0097\u0005¢\u0006\b\u001A\u0006\b¦\u0001\u0010 \u0001R\u0016\u0010§\u0001\u001A\u00030¨\u0001X\u0096\u0005¢\u0006\b\u001A\u0006\b©\u0001\u0010ª\u0001R\u0016\u0010\u000F\u001A\u00020\u001B8VX\u0096\u0005¢\u0006\b\u001A\u0006\b«\u0001\u0010\u009D\u0001¨\u0006¬\u0001"}, d2={"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "<init>", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "drawContent", "", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "size", "Landroidx/compose/ui/unit/IntSize;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "layer", "draw", "Landroidx/compose/ui/geometry/Size;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-eZhPAX0$ui", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawDirect", "drawDirect-eZhPAX0$ui", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getCenter-F1C5BW0", "()J", "density", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getSize-NH-jbRc", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeDrawScope implements ContentDrawScope, DrawScope {
    public static final int $stable;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    static {
    }

    public LayoutNodeDrawScope() {
        this(null, 1, null);
    }

    public LayoutNodeDrawScope(CanvasDrawScope arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new CanvasDrawScope();
        }

        this(arg1);
    }

    public LayoutNodeDrawScope(CanvasDrawScope arg1) {
        super();
        this.canvasDrawScope = arg1;
    }

    public static final DrawModifierNode access$getDrawNode$p(LayoutNodeDrawScope arg0) {
        return arg0.drawNode;
    }

    public static final void access$setDrawNode$p(LayoutNodeDrawScope arg0, DrawModifierNode arg1) {
        arg0.drawNode = arg1;
    }

    public final void draw-eZhPAX0$ui(Canvas arg13, long arg14, NodeCoordinator arg16, Node arg17, GraphicsLayer arg18) {
        int v0 = NodeKind.constructor-impl(4);
        Node v1 = null;
        Node v2 = arg17;
        MutableVector v3 = ((MutableVector)v1);
        while(true) {
        label_5:
            if(v2 == null) {
                return;
            }

            if((v2 instanceof DrawModifierNode)) {
                this.drawDirect-eZhPAX0$ui(arg13, arg14, arg16, v2, arg18);
            }
            else if((v2.getKindSet$ui() & v0) != 0 && ((v2 instanceof DelegatingNode))) {
                Node v4 = v2.getDelegate$ui();
                int v6 = 0;
                while(v4 != null) {
                    if((v4.getKindSet$ui() & v0) != 0) {
                        ++v6;
                        if(v6 == 1) {
                            v2 = v4;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[16], 0);
                            }

                            if(v2 != null) {
                                if(v3 != null) {
                                    v3.add(v2);
                                }

                                v2 = v1;
                            }

                            if(v3 == null) {
                                goto label_45;
                            }

                            v3.add(v4);
                        }
                    }

                label_45:
                    v4 = v4.getChild$ui();
                }

                if(v6 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v2 = DelegatableNodeKt.pop(v3);
        goto label_5;
    }

    public void drawArc-illE91I(Brush arg1, float arg2, float arg3, boolean arg4, long arg5, long arg7, float arg9, DrawStyle arg10, ColorFilter arg11, int arg12) {
        this.canvasDrawScope.drawArc-illE91I(arg1, arg2, arg3, arg4, arg5, arg7, arg9, arg10, arg11, arg12);
    }

    public void drawArc-yD3GUKo(long arg1, float arg3, float arg4, boolean arg5, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13) {
        this.canvasDrawScope.drawArc-yD3GUKo(arg1, arg3, arg4, arg5, arg6, arg8, arg10, arg11, arg12, arg13);
    }

    public void drawCircle-V9BoPsw(Brush arg1, float arg2, long arg3, float arg5, DrawStyle arg6, ColorFilter arg7, int arg8) {
        this.canvasDrawScope.drawCircle-V9BoPsw(arg1, arg2, arg3, arg5, arg6, arg7, arg8);
    }

    public void drawCircle-VaOC9Bg(long arg1, float arg3, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9) {
        this.canvasDrawScope.drawCircle-VaOC9Bg(arg1, arg3, arg4, arg6, arg7, arg8, arg9);
    }

    public void drawContent() {
        Canvas v0 = this.getDrawContext().getCanvas();
        DrawModifierNode v1 = this.drawNode;
        if(v1 == null) {
            goto label_66;
        }

        DrawModifierNode v2 = v1;
        Node v3 = LayoutNodeDrawScopeKt.access$nextDrawNode(((DelegatableNode)v2));
        int v4 = 4;
        if(v3 == null) {
            goto label_55;
        }

        int v1_1 = NodeKind.constructor-impl(v4);
        Node v2_1 = null;
        MutableVector v4_1 = ((MutableVector)v2_1);
        while(true) {
        label_12:
            if(v3 == null) {
                return;
            }

            if((v3 instanceof DrawModifierNode)) {
                this.performDraw(((DrawModifierNode)v3), v0, this.getDrawContext().getGraphicsLayer());
            }
            else if((v3.getKindSet$ui() & v1_1) != 0 && ((v3 instanceof DelegatingNode))) {
                Node v5 = v3.getDelegate$ui();
                int v7 = 0;
                while(v5 != null) {
                    if((v5.getKindSet$ui() & v1_1) != 0) {
                        ++v7;
                        if(v7 == 1) {
                            v3 = v5;
                        }
                        else {
                            if(v4_1 == null) {
                                v4_1 = new MutableVector(new Node[16], 0);
                            }

                            if(v3 != null) {
                                if(v4_1 != null) {
                                    v4_1.add(v3);
                                }

                                v3 = v2_1;
                            }

                            if(v4_1 == null) {
                                goto label_48;
                            }

                            v4_1.add(v5);
                        }
                    }

                label_48:
                    v5 = v5.getChild$ui();
                }

                if(v7 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v3 = DelegatableNodeKt.pop(v4_1);
        goto label_12;
        return;
    label_55:
        NodeCoordinator v2_2 = DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)v2), NodeKind.constructor-impl(v4));
        if(v2_2.getTail() == v1.getNode()) {
            v2_2 = v2_2.getWrapped$ui();
            Intrinsics.checkNotNull(v2_2);
        }

        v2_2.performDraw(v0, this.getDrawContext().getGraphicsLayer());
        return;
    label_66:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        throw new KotlinNothingValueException();
    }

    public final void drawDirect-eZhPAX0$ui(Canvas arg15, long arg16, NodeCoordinator arg18, DrawModifierNode arg19, GraphicsLayer arg20) {
        DrawContext v0_2;
        DrawModifierNode v0 = arg19;
        DrawModifierNode v1 = this.drawNode;
        this.drawNode = v0;
        CanvasDrawScope v2 = this.canvasDrawScope;
        LayoutDirection v4 = arg18.getLayoutDirection();
        Density v5 = ((DrawScope)v2).getDrawContext().getDensity();
        LayoutDirection v6 = ((DrawScope)v2).getDrawContext().getLayoutDirection();
        Canvas v7 = ((DrawScope)v2).getDrawContext().getCanvas();
        long v8 = ((DrawScope)v2).getDrawContext().getSize-NH-jbRc();
        GraphicsLayer v10 = ((DrawScope)v2).getDrawContext().getGraphicsLayer();
        DrawContext v11 = ((DrawScope)v2).getDrawContext();
        v11.setDensity(arg18);
        v11.setLayoutDirection(v4);
        v11.setCanvas(arg15);
        v11.setSize-uvyYCjk(arg16);
        v11.setGraphicsLayer(arg20);
        arg15.save();
        try {
            v0.draw(this);
        }
        catch(Throwable v0_1) {
            Throwable v14 = v0_1;
            arg15.restore();
            v0_2 = ((DrawScope)v2).getDrawContext();
            v0_2.setDensity(v5);
            v0_2.setLayoutDirection(v6);
            v0_2.setCanvas(v7);
            v0_2.setSize-uvyYCjk(v8);
            v0_2.setGraphicsLayer(v10);
            throw v14;
        }

        arg15.restore();
        v0_2 = ((DrawScope)v2).getDrawContext();
        v0_2.setDensity(v5);
        v0_2.setLayoutDirection(v6);
        v0_2.setCanvas(v7);
        v0_2.setSize-uvyYCjk(v8);
        v0_2.setGraphicsLayer(v10);
        this.drawNode = v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith="<_subannotation>") public void drawImage-9jGpkUE(ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13) {
        this.canvasDrawScope.drawImage-9jGpkUE(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13);
    }

    public void drawImage-AZ2fEMs(ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14) {
        this.canvasDrawScope.drawImage-AZ2fEMs(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14);
    }

    public void drawImage-gbVJVH8(ImageBitmap arg1, long arg2, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7) {
        this.canvasDrawScope.drawImage-gbVJVH8(arg1, arg2, arg4, arg5, arg6, arg7);
    }

    public void drawLine-1RTmtNc(Brush arg1, long arg2, long arg4, float arg6, int arg7, PathEffect arg8, float arg9, ColorFilter arg10, int arg11) {
        this.canvasDrawScope.drawLine-1RTmtNc(arg1, arg2, arg4, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public void drawLine-NGM6Ib0(long arg1, long arg3, long arg5, float arg7, int arg8, PathEffect arg9, float arg10, ColorFilter arg11, int arg12) {
        this.canvasDrawScope.drawLine-NGM6Ib0(arg1, arg3, arg5, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public void drawOval-AsUm42w(Brush arg1, long arg2, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9) {
        this.canvasDrawScope.drawOval-AsUm42w(arg1, arg2, arg4, arg6, arg7, arg8, arg9);
    }

    public void drawOval-n-J9OG0(long arg1, long arg3, long arg5, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10) {
        this.canvasDrawScope.drawOval-n-J9OG0(arg1, arg3, arg5, arg7, arg8, arg9, arg10);
    }

    public void drawPath-GBMwjPU(Path arg1, Brush arg2, float arg3, DrawStyle arg4, ColorFilter arg5, int arg6) {
        this.canvasDrawScope.drawPath-GBMwjPU(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void drawPath-LG529CI(Path arg1, long arg2, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7) {
        this.canvasDrawScope.drawPath-LG529CI(arg1, arg2, arg4, arg5, arg6, arg7);
    }

    public void drawPoints-F8ZwMP8(List arg1, int arg2, long arg3, float arg5, int arg6, PathEffect arg7, float arg8, ColorFilter arg9, int arg10) {
        this.canvasDrawScope.drawPoints-F8ZwMP8(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public void drawPoints-Gsft0Ws(List arg1, int arg2, Brush arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9) {
        this.canvasDrawScope.drawPoints-Gsft0Ws(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public void drawRect-AsUm42w(Brush arg1, long arg2, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9) {
        this.canvasDrawScope.drawRect-AsUm42w(arg1, arg2, arg4, arg6, arg7, arg8, arg9);
    }

    public void drawRect-n-J9OG0(long arg1, long arg3, long arg5, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10) {
        this.canvasDrawScope.drawRect-n-J9OG0(arg1, arg3, arg5, arg7, arg8, arg9, arg10);
    }

    public void drawRoundRect-ZuiqVtQ(Brush arg1, long arg2, long arg4, long arg6, float arg8, DrawStyle arg9, ColorFilter arg10, int arg11) {
        this.canvasDrawScope.drawRoundRect-ZuiqVtQ(arg1, arg2, arg4, arg6, arg8, arg9, arg10, arg11);
    }

    public void drawRoundRect-u-Aw5IA(long arg1, long arg3, long arg5, long arg7, DrawStyle arg9, float arg10, ColorFilter arg11, int arg12) {
        this.canvasDrawScope.drawRoundRect-u-Aw5IA(arg1, arg3, arg5, arg7, arg9, arg10, arg11, arg12);
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    public long getCenter-F1C5BW0() {
        return this.canvasDrawScope.getCenter-F1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    public long getSize-NH-jbRc() {
        return this.canvasDrawScope.getSize-NH-jbRc();
    }

    public final void performDraw(DrawModifierNode arg9, Canvas arg10, GraphicsLayer arg11) {
        NodeCoordinator v5 = DelegatableNodeKt.requireCoordinator-64DMado(arg9, NodeKind.constructor-impl(4));
        v5.getLayoutNode().getMDrawScope$ui().drawDirect-eZhPAX0$ui(arg10, IntSizeKt.toSize-ozmzZPI(v5.getSize-YbymL2g()), v5, arg9, arg11);
    }

    public void record-JVtK1S4(GraphicsLayer arg8, long arg9, Function1 arg11) {
        arg8.record-mL-hObY(this, this.getLayoutDirection(), arg9, new LayoutNodeDrawScope$record$1(this, this.drawNode, arg11));
    }

    public int roundToPx--R2X_6o(long arg1) {
        return this.canvasDrawScope.roundToPx--R2X_6o(arg1);
    }

    public int roundToPx-0680j_4(float arg1) {
        return this.canvasDrawScope.roundToPx-0680j_4(arg1);
    }

    public float toDp-GaN1DYA(long arg1) {
        return this.canvasDrawScope.toDp-GaN1DYA(arg1);
    }

    public float toDp-u2uoSUM(float arg1) {
        return this.canvasDrawScope.toDp-u2uoSUM(arg1);
    }

    public float toDp-u2uoSUM(int arg1) {
        return this.canvasDrawScope.toDp-u2uoSUM(arg1);
    }

    public long toDpSize-k-rfVVM(long arg1) {
        return this.canvasDrawScope.toDpSize-k-rfVVM(arg1);
    }

    public float toPx--R2X_6o(long arg1) {
        return this.canvasDrawScope.toPx--R2X_6o(arg1);
    }

    public float toPx-0680j_4(float arg1) {
        return this.canvasDrawScope.toPx-0680j_4(arg1);
    }

    public Rect toRect(DpRect arg1) {
        return this.canvasDrawScope.toRect(arg1);
    }

    public long toSize-XkaWNTQ(long arg1) {
        return this.canvasDrawScope.toSize-XkaWNTQ(arg1);
    }

    public long toSp-0xMU5do(float arg1) {
        return this.canvasDrawScope.toSp-0xMU5do(arg1);
    }

    public long toSp-kPz2Gy4(float arg1) {
        return this.canvasDrawScope.toSp-kPz2Gy4(arg1);
    }

    public long toSp-kPz2Gy4(int arg1) {
        return this.canvasDrawScope.toSp-kPz2Gy4(arg1);
    }
}

