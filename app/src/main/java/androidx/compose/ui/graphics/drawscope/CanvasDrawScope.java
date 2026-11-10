package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0093\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b+\u0010,J]\u0010\u001A\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b/\u00100JK\u00101\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b7\u00108JK\u00101\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b9\u0010:JC\u0010;\u001A\u00020\u001B2\u0006\u0010<\u001A\u00020=2\u0006\u00102\u001A\u00020\u001F2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b>\u0010?J[\u0010;\u001A\u00020\u001B2\u0006\u0010<\u001A\u00020=2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020A2\u0006\u0010E\u001A\u00020C2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0017¢\u0006\u0004\bF\u0010GJc\u0010;\u001A\u00020\u001B2\u0006\u0010<\u001A\u00020=2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020A2\u0006\u0010E\u001A\u00020C2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*2\u0006\u0010H\u001A\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJS\u0010L\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\u0006\u0010M\u001A\u00020N2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bO\u0010PJS\u0010L\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\u0006\u0010M\u001A\u00020N2\u0006\u00105\u001A\u0002062\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bQ\u0010RJK\u0010S\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010T\u001A\u00020\u000E2\u0006\u0010U\u001A\u00020\u001F2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bV\u0010WJK\u0010S\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u0010T\u001A\u00020\u000E2\u0006\u0010U\u001A\u00020\u001F2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bX\u0010YJK\u0010Z\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b[\u00108JK\u0010Z\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\b\\\u0010:Jc\u0010]\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000E2\u0006\u0010`\u001A\u00020a2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bb\u0010cJc\u0010]\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020.2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000E2\u0006\u0010`\u001A\u00020a2\u0006\u00102\u001A\u00020\u001F2\u0006\u00103\u001A\u0002042\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bd\u0010eJC\u0010f\u001A\u00020\u001B2\u0006\u0010g\u001A\u00020h2\u0006\u0010-\u001A\u00020.2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bi\u0010jJC\u0010f\u001A\u00020\u001B2\u0006\u0010g\u001A\u00020h2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0001\u0010&\u001A\u00020\u000E2\u0006\u00105\u001A\u0002062\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bk\u0010lJc\u0010m\u001A\u00020\u001B2\f\u0010n\u001A\b\u0012\u0004\u0012\u00020\u001F0o2\u0006\u0010p\u001A\u00020q2\u0006\u0010-\u001A\u00020.2\u0006\u0010!\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\br\u0010sJc\u0010m\u001A\u00020\u001B2\f\u0010n\u001A\b\u0012\u0004\u0012\u00020\u001F0o2\u0006\u0010p\u001A\u00020q2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010!\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*H\u0016¢\u0006\u0004\bt\u0010uJI\u0010v\u001A\u00020\u001B2\u0006\u0010\r\u001A\u00020w2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010x\u001A\u00020y2\u0006\u00103\u001A\u0002042\u0017\u0010z\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001B0{¢\u0006\u0002\b|H\u0086\b¢\u0006\u0004\b}\u0010~J\b\u0010\u007F\u001A\u00020\u0018H\u0002J\t\u0010\u0080\u0001\u001A\u00020\u0018H\u0002J\u0012\u0010\u0081\u0001\u001A\u00020\u00182\u0007\u0010\u0082\u0001\u001A\u000206H\u0002JJ\u0010\u0083\u0001\u001A\u00020\u00182\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u00105\u001A\u0002062\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010H\u001A\u00020IH\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JH\u0010\u0083\u0001\u001A\u00020\u00182\u0006\u0010-\u001A\u00020.2\u0006\u00105\u001A\u0002062\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010H\u001A\u00020IH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001Jm\u0010\u0088\u0001\u001A\u00020\u00182\u0006\u0010-\u001A\u00020.2\u0006\u0010!\u001A\u00020\u000E2\u0007\u0010\u0089\u0001\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010\u008A\u0001\u001A\u00030\u008B\u00012\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010H\u001A\u00020IH\u0002¢\u0006\u0006\b\u008C\u0001\u0010\u008D\u0001Jo\u0010\u0088\u0001\u001A\u00020\u00182\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010!\u001A\u00020\u000E2\u0007\u0010\u0089\u0001\u001A\u00020\u000E2\u0006\u0010\"\u001A\u00020#2\b\u0010\u008A\u0001\u001A\u00030\u008B\u00012\b\u0010$\u001A\u0004\u0018\u00010%2\b\b\u0001\u0010&\u001A\u00020\u000E2\b\u0010\'\u001A\u0004\u0018\u00010(2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010H\u001A\u00020IH\u0002¢\u0006\u0006\b\u008E\u0001\u0010\u008F\u0001J\u001E\u0010\u0090\u0001\u001A\u00020.*\u00020.2\u0006\u0010&\u001A\u00020\u000EH\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001C\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001A\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2={"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "<init>", "()V", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "strokePaint", "drawLine", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "topLeft", "size", "Landroidx/compose/ui/geometry/Size;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "drawOval-n-J9OG0", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "draw", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "configurePaint", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "miter", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CanvasDrawScope implements DrawScope {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0007HÆ\u0003J\u0010\u0010 \u001A\u00020\tHÆ\u0003¢\u0006\u0004\b!\u0010\u0019J8\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001A\u00020)HÖ\u0001J\t\u0010*\u001A\u00020+HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001C\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006,"}, d2={"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawParams {
        public static final int $stable = 8;
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        static {
        }

        public DrawParams(Density arg8, LayoutDirection arg9, Canvas arg10, long arg11, int arg13, DefaultConstructorMarker arg14) {
            EmptyCanvas v10;
            if((arg13 & 1) != 0) {
                arg8 = DrawContextKt.getDefaultDensity();
            }

            Density v1 = arg8;
            if((arg13 & 2) != 0) {
                arg9 = LayoutDirection.Ltr;
            }

            LayoutDirection v2 = arg9;
            if((arg13 & 4) != 0) {
                v10 = EmptyCanvas.INSTANCE;
            }

            Canvas v3 = ((Canvas)v10);
            if((arg13 & 8) != 0) {
                arg11 = Size.Companion.getZero-NH-jbRc();
            }

            this(v1, v2, v3, arg11, null);
        }

        private DrawParams(Density arg1, LayoutDirection arg2, Canvas arg3, long arg4) {
            super();
            this.density = arg1;
            this.layoutDirection = arg2;
            this.canvas = arg3;
            this.size = arg4;
        }

        public DrawParams(Density arg1, LayoutDirection arg2, Canvas arg3, long arg4, DefaultConstructorMarker arg6) {
            this(arg1, arg2, arg3, arg4);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        public final long component4-NH-jbRc() {
            return this.size;
        }

        public final DrawParams copy-Ug5Nnss(Density arg8, LayoutDirection arg9, Canvas arg10, long arg11) {
            return new DrawParams(arg8, arg9, arg10, arg11, null);
        }

        public static DrawParams copy-Ug5Nnss$default(DrawParams arg0, Density arg1, LayoutDirection arg2, Canvas arg3, long arg4, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.density;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.layoutDirection;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.canvas;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.size;
            }

            return arg0.copy-Ug5Nnss(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg6) {
            if(this == (((DrawParams)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof DrawParams)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.density, ((DrawParams)arg6).density)) {
                return 0;
            }

            if(this.layoutDirection != ((DrawParams)arg6).layoutDirection) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.canvas, ((DrawParams)arg6).canvas)) {
                return 0;
            }

            if(!Size.equals-impl0(this.size, ((DrawParams)arg6).size)) {
                return 0;
            }

            return 1;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final long getSize-NH-jbRc() {
            return this.size;
        }

        public int hashCode() {
            return ((this.density.hashCode() * 0x1F + this.layoutDirection.hashCode()) * 0x1F + this.canvas.hashCode()) * 0x1F + Size.hashCode-impl(this.size);
        }

        public final void setCanvas(Canvas arg1) {
            this.canvas = arg1;
        }

        public final void setDensity(Density arg1) {
            this.density = arg1;
        }

        public final void setLayoutDirection(LayoutDirection arg1) {
            this.layoutDirection = arg1;
        }

        public final void setSize-uvyYCjk(long arg1) {
            this.size = arg1;
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.toString-impl(this.size) + ')';
        }
    }

    public static final int $stable;
    private final DrawContext drawContext;
    private final DrawParams drawParams;
    private Paint fillPaint;
    private Paint strokePaint;

    static {
    }

    public CanvasDrawScope() {
        super();
        this.drawParams = new DrawParams(null, null, null, 0, 15, null);
        this.drawContext = new CanvasDrawScope$drawContext$1(this);
    }

    private final Paint configurePaint-2qPWKa0(long arg3, DrawStyle arg5, float arg6, ColorFilter arg7, int arg8, int arg9) {
        Paint v5 = this.selectPaint(arg5);
        long v2 = this.modulate-5vOe2sY(arg3, arg6);
        if(!Color.equals-impl0(v5.getColor-0d7_KjU(), v2)) {
            v5.setColor-8_81llA(v2);
        }

        if(v5.getShader() != null) {
            v5.setShader(null);
        }

        if(!Intrinsics.areEqual(v5.getColorFilter(), arg7)) {
            v5.setColorFilter(arg7);
        }

        if(!BlendMode.equals-impl0(v5.getBlendMode-0nO6VwU(), arg8)) {
            v5.setBlendMode-s9anfk8(arg8);
        }

        if(!FilterQuality.equals-impl0(v5.getFilterQuality-f-v9h1I(), arg9)) {
            v5.setFilterQuality-vDHp3xo(arg9);
        }

        return v5;
    }

    static Paint configurePaint-2qPWKa0$default(CanvasDrawScope arg9, long arg10, DrawStyle arg12, float arg13, ColorFilter arg14, int arg15, int arg16, int arg17, Object arg18) {
        int v8 = (arg17 & 0x20) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : arg16;
        return arg9.configurePaint-2qPWKa0(arg10, arg12, arg13, arg14, arg15, v8);
    }

    private final Paint configurePaint-swdJneE(Brush arg3, DrawStyle arg4, float arg5, ColorFilter arg6, int arg7, int arg8) {
        Paint v4 = this.selectPaint(arg4);
        if(arg3 != null) {
            arg3.applyTo-Pq9zytI(this.getSize-NH-jbRc(), v4, arg5);
        }
        else {
            if(v4.getShader() != null) {
                v4.setShader(null);
            }

            if(!Color.equals-impl0(v4.getColor-0d7_KjU(), Color.Companion.getBlack-0d7_KjU())) {
                v4.setColor-8_81llA(Color.Companion.getBlack-0d7_KjU());
            }

            if(v4.getAlpha() == arg5) {
                goto label_21;
            }

            v4.setAlpha(arg5);
        }

    label_21:
        if(!Intrinsics.areEqual(v4.getColorFilter(), arg6)) {
            v4.setColorFilter(arg6);
        }

        if(!BlendMode.equals-impl0(v4.getBlendMode-0nO6VwU(), arg7)) {
            v4.setBlendMode-s9anfk8(arg7);
        }

        if(!FilterQuality.equals-impl0(v4.getFilterQuality-f-v9h1I(), arg8)) {
            v4.setFilterQuality-vDHp3xo(arg8);
        }

        return v4;
    }

    static Paint configurePaint-swdJneE$default(CanvasDrawScope arg7, Brush arg8, DrawStyle arg9, float arg10, ColorFilter arg11, int arg12, int arg13, int arg14, Object arg15) {
        if((arg14 & 0x20) != 0) {
            arg13 = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
        }

        return arg7.configurePaint-swdJneE(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    private final Paint configureStrokePaint-Q_0CZUI(long arg4, float arg6, float arg7, int arg8, int arg9, PathEffect arg10, float arg11, ColorFilter arg12, int arg13, int arg14) {
        Paint v0 = this.obtainStrokePaint();
        long v3 = this.modulate-5vOe2sY(arg4, arg11);
        if(!Color.equals-impl0(v0.getColor-0d7_KjU(), v3)) {
            v0.setColor-8_81llA(v3);
        }

        if(v0.getShader() != null) {
            v0.setShader(null);
        }

        if(!Intrinsics.areEqual(v0.getColorFilter(), arg12)) {
            v0.setColorFilter(arg12);
        }

        if(!BlendMode.equals-impl0(v0.getBlendMode-0nO6VwU(), arg13)) {
            v0.setBlendMode-s9anfk8(arg13);
        }

        if(v0.getStrokeWidth() == arg6) {
        }
        else {
            v0.setStrokeWidth(arg6);
        }

        if(v0.getStrokeMiterLimit() == arg7) {
        }
        else {
            v0.setStrokeMiterLimit(arg7);
        }

        if(!StrokeCap.equals-impl0(v0.getStrokeCap-KaPHkGw(), arg8)) {
            v0.setStrokeCap-BeK7IIE(arg8);
        }

        if(!StrokeJoin.equals-impl0(v0.getStrokeJoin-LxFBmk8(), arg9)) {
            v0.setStrokeJoin-Ww9F2mQ(arg9);
        }

        if(!Intrinsics.areEqual(v0.getPathEffect(), arg10)) {
            v0.setPathEffect(arg10);
        }

        if(!FilterQuality.equals-impl0(v0.getFilterQuality-f-v9h1I(), arg14)) {
            v0.setFilterQuality-vDHp3xo(arg14);
        }

        return v0;
    }

    static Paint configureStrokePaint-Q_0CZUI$default(CanvasDrawScope arg13, long arg14, float arg16, float arg17, int arg18, int arg19, PathEffect arg20, float arg21, ColorFilter arg22, int arg23, int arg24, int arg25, Object arg26) {
        int v12 = (arg25 & 0x200) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : arg24;
        return arg13.configureStrokePaint-Q_0CZUI(arg14, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, v12);
    }

    private final Paint configureStrokePaint-ho4zsrM(Brush arg4, float arg5, float arg6, int arg7, int arg8, PathEffect arg9, float arg10, ColorFilter arg11, int arg12, int arg13) {
        Paint v0 = this.obtainStrokePaint();
        if(arg4 != null) {
            arg4.applyTo-Pq9zytI(this.getSize-NH-jbRc(), v0, arg10);
        }
        else if(v0.getAlpha() == arg10) {
        }
        else {
            v0.setAlpha(arg10);
        }

        if(!Intrinsics.areEqual(v0.getColorFilter(), arg11)) {
            v0.setColorFilter(arg11);
        }

        if(!BlendMode.equals-impl0(v0.getBlendMode-0nO6VwU(), arg12)) {
            v0.setBlendMode-s9anfk8(arg12);
        }

        if(v0.getStrokeWidth() == arg5) {
        }
        else {
            v0.setStrokeWidth(arg5);
        }

        if(v0.getStrokeMiterLimit() == arg6) {
        }
        else {
            v0.setStrokeMiterLimit(arg6);
        }

        if(!StrokeCap.equals-impl0(v0.getStrokeCap-KaPHkGw(), arg7)) {
            v0.setStrokeCap-BeK7IIE(arg7);
        }

        if(!StrokeJoin.equals-impl0(v0.getStrokeJoin-LxFBmk8(), arg8)) {
            v0.setStrokeJoin-Ww9F2mQ(arg8);
        }

        if(!Intrinsics.areEqual(v0.getPathEffect(), arg9)) {
            v0.setPathEffect(arg9);
        }

        if(!FilterQuality.equals-impl0(v0.getFilterQuality-f-v9h1I(), arg13)) {
            v0.setFilterQuality-vDHp3xo(arg13);
        }

        return v0;
    }

    static Paint configureStrokePaint-ho4zsrM$default(CanvasDrawScope arg12, Brush arg13, float arg14, float arg15, int arg16, int arg17, PathEffect arg18, float arg19, ColorFilter arg20, int arg21, int arg22, int arg23, Object arg24) {
        int v11 = (arg23 & 0x200) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : arg22;
        return arg12.configureStrokePaint-ho4zsrM(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, v11);
    }

    public final void draw-yzxVdVo(Density arg7, LayoutDirection arg8, Canvas arg9, long arg10, Function1 arg12) {
        DrawParams v0 = this.getDrawParams();
        Density v1 = v0.component1();
        LayoutDirection v2 = v0.component2();
        Canvas v3 = v0.component3();
        long v4 = v0.component4-NH-jbRc();
        v0 = this.getDrawParams();
        v0.setDensity(arg7);
        v0.setLayoutDirection(arg8);
        v0.setCanvas(arg9);
        v0.setSize-uvyYCjk(arg10);
        arg9.save();
        arg12.invoke(this);
        arg9.restore();
        DrawParams v6 = this.getDrawParams();
        v6.setDensity(v1);
        v6.setLayoutDirection(v2);
        v6.setCanvas(v3);
        v6.setSize-uvyYCjk(v4);
    }

    public void drawArc-illE91I(Brush arg15, float arg16, float arg17, boolean arg18, long arg19, long arg21, float arg23, DrawStyle arg24, ColorFilter arg25, int arg26) {
        int v2 = ((int)(arg19 >> 0x20));
        int v5 = ((int)(arg19 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawArc(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg21 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg21 & 0xFFFFFFFFL))), arg16, arg17, arg18, CanvasDrawScope.configurePaint-swdJneE$default(this, arg15, arg24, arg23, arg25, arg26, 0, 0x20, null));
    }

    public void drawArc-yD3GUKo(long arg16, float arg18, float arg19, boolean arg20, long arg21, long arg23, float arg25, DrawStyle arg26, ColorFilter arg27, int arg28) {
        int v2 = ((int)(arg21 >> 0x20));
        int v5 = ((int)(arg21 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawArc(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg23 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg23 & 0xFFFFFFFFL))), arg18, arg19, arg20, CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg16, arg26, arg25, arg27, arg28, 0, 0x20, null));
    }

    public void drawCircle-V9BoPsw(Brush arg11, float arg12, long arg13, float arg15, DrawStyle arg16, ColorFilter arg17, int arg18) {
        this.drawParams.getCanvas().drawCircle-9KIMszo(arg13, arg12, CanvasDrawScope.configurePaint-swdJneE$default(this, arg11, arg16, arg15, arg17, arg18, 0, 0x20, null));
    }

    public void drawCircle-VaOC9Bg(long arg12, float arg14, long arg15, float arg17, DrawStyle arg18, ColorFilter arg19, int arg20) {
        this.drawParams.getCanvas().drawCircle-9KIMszo(arg15, arg14, CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg12, arg18, arg17, arg19, arg20, 0, 0x20, null));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith="<_subannotation>") public void drawImage-9jGpkUE(ImageBitmap arg13, long arg14, long arg16, long arg18, long arg20, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25) {
        this.drawParams.getCanvas().drawImageRect-HPBpro0(arg13, arg14, arg16, arg18, arg20, CanvasDrawScope.configurePaint-swdJneE$default(this, null, arg23, arg22, arg24, arg25, 0, 0x20, null));
    }

    public void drawImage-AZ2fEMs(ImageBitmap arg13, long arg14, long arg16, long arg18, long arg20, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25, int arg26) {
        this.drawParams.getCanvas().drawImageRect-HPBpro0(arg13, arg14, arg16, arg18, arg20, this.configurePaint-swdJneE(null, arg23, arg22, arg24, arg25, arg26));
    }

    public void drawImage-gbVJVH8(ImageBitmap arg11, long arg12, float arg14, DrawStyle arg15, ColorFilter arg16, int arg17) {
        this.drawParams.getCanvas().drawImage-d-4ec7I(arg11, arg12, CanvasDrawScope.configurePaint-swdJneE$default(this, null, arg15, arg14, arg16, arg17, 0, 0x20, null));
    }

    public void drawLine-1RTmtNc(Brush arg15, long arg16, long arg18, float arg20, int arg21, PathEffect arg22, float arg23, ColorFilter arg24, int arg25) {
        this.drawParams.getCanvas().drawLine-Wko1d7g(arg16, arg18, CanvasDrawScope.configureStrokePaint-ho4zsrM$default(this, arg15, arg20, 4f, arg21, StrokeJoin.Companion.getMiter-LxFBmk8(), arg22, arg23, arg24, arg25, 0, 0x200, null));
    }

    public void drawLine-NGM6Ib0(long arg16, long arg18, long arg20, float arg22, int arg23, PathEffect arg24, float arg25, ColorFilter arg26, int arg27) {
        this.drawParams.getCanvas().drawLine-Wko1d7g(arg18, arg20, CanvasDrawScope.configureStrokePaint-Q_0CZUI$default(this, arg16, arg22, 4f, arg23, StrokeJoin.Companion.getMiter-LxFBmk8(), arg24, arg25, arg26, arg27, 0, 0x200, null));
    }

    public void drawOval-AsUm42w(Brush arg15, long arg16, long arg18, float arg20, DrawStyle arg21, ColorFilter arg22, int arg23) {
        int v2 = ((int)(arg16 >> 0x20));
        int v5 = ((int)(arg16 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawOval(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg18 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg18 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-swdJneE$default(this, arg15, arg21, arg20, arg22, arg23, 0, 0x20, null));
    }

    public void drawOval-n-J9OG0(long arg16, long arg18, long arg20, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25) {
        int v2 = ((int)(arg18 >> 0x20));
        int v5 = ((int)(arg18 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawOval(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg20 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg20 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg16, arg23, arg22, arg24, arg25, 0, 0x20, null));
    }

    public void drawPath-GBMwjPU(Path arg11, Brush arg12, float arg13, DrawStyle arg14, ColorFilter arg15, int arg16) {
        this.drawParams.getCanvas().drawPath(arg11, CanvasDrawScope.configurePaint-swdJneE$default(this, arg12, arg14, arg13, arg15, arg16, 0, 0x20, null));
    }

    public void drawPath-LG529CI(Path arg12, long arg13, float arg15, DrawStyle arg16, ColorFilter arg17, int arg18) {
        this.drawParams.getCanvas().drawPath(arg12, CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg13, arg16, arg15, arg17, arg18, 0, 0x20, null));
    }

    public void drawPoints-F8ZwMP8(List arg16, int arg17, long arg18, float arg20, int arg21, PathEffect arg22, float arg23, ColorFilter arg24, int arg25) {
        this.drawParams.getCanvas().drawPoints-O7TthRY(arg17, arg16, CanvasDrawScope.configureStrokePaint-Q_0CZUI$default(this, arg18, arg20, 4f, arg21, StrokeJoin.Companion.getMiter-LxFBmk8(), arg22, arg23, arg24, arg25, 0, 0x200, null));
    }

    public void drawPoints-Gsft0Ws(List arg15, int arg16, Brush arg17, float arg18, int arg19, PathEffect arg20, float arg21, ColorFilter arg22, int arg23) {
        this.drawParams.getCanvas().drawPoints-O7TthRY(arg16, arg15, CanvasDrawScope.configureStrokePaint-ho4zsrM$default(this, arg17, arg18, 4f, arg19, StrokeJoin.Companion.getMiter-LxFBmk8(), arg20, arg21, arg22, arg23, 0, 0x200, null));
    }

    public void drawRect-AsUm42w(Brush arg15, long arg16, long arg18, float arg20, DrawStyle arg21, ColorFilter arg22, int arg23) {
        int v2 = ((int)(arg16 >> 0x20));
        int v5 = ((int)(arg16 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawRect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg18 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg18 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-swdJneE$default(this, arg15, arg21, arg20, arg22, arg23, 0, 0x20, null));
    }

    public void drawRect-n-J9OG0(long arg16, long arg18, long arg20, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25) {
        int v2 = ((int)(arg18 >> 0x20));
        int v5 = ((int)(arg18 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawRect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg20 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg20 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg16, arg23, arg22, arg24, arg25, 0, 0x20, null));
    }

    public void drawRoundRect-ZuiqVtQ(Brush arg17, long arg18, long arg20, long arg22, float arg24, DrawStyle arg25, ColorFilter arg26, int arg27) {
        int v2 = ((int)(arg18 >> 0x20));
        int v5 = ((int)(arg18 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawRoundRect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg20 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg20 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg22 >> 0x20))), Float.intBitsToFloat(((int)(arg22 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-swdJneE$default(this, arg17, arg25, arg24, arg26, arg27, 0, 0x20, null));
    }

    public void drawRoundRect-u-Aw5IA(long arg18, long arg20, long arg22, long arg24, DrawStyle arg26, float arg27, ColorFilter arg28, int arg29) {
        int v2 = ((int)(arg20 >> 0x20));
        int v5 = ((int)(arg20 & 0xFFFFFFFFL));
        this.drawParams.getCanvas().drawRoundRect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v5), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg22 >> 0x20))), Float.intBitsToFloat(v5) + Float.intBitsToFloat(((int)(arg22 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg24 >> 0x20))), Float.intBitsToFloat(((int)(arg24 & 0xFFFFFFFFL))), CanvasDrawScope.configurePaint-2qPWKa0$default(this, arg18, arg26, arg27, arg28, arg29, 0, 0x20, null));
    }

    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    public static void getDrawParams$annotations() {
    }

    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    private final long modulate-5vOe2sY(long arg9, float arg11) {
        if(arg11 == 1f) {
            return arg9;
        }

        return Color.copy-wmQWz5c$default(arg9, Color.getAlpha-impl(arg9) * arg11, 0f, 0f, 0f, 14, null);
    }

    private final Paint obtainFillPaint() {
        Paint v0 = this.fillPaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            v0.setStyle-k9PVt8s(PaintingStyle.Companion.getFill-TiuSbCo());
            this.fillPaint = v0;
        }

        return v0;
    }

    private final Paint obtainStrokePaint() {
        Paint v0 = this.strokePaint;
        if(v0 == null) {
            v0 = AndroidPaint_androidKt.Paint();
            v0.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
            this.strokePaint = v0;
        }

        return v0;
    }

    private final Paint selectPaint(DrawStyle arg3) {
        if(Intrinsics.areEqual(arg3, Fill.INSTANCE)) {
            return this.obtainFillPaint();
        }

        if((arg3 instanceof Stroke)) {
            Paint v2 = this.obtainStrokePaint();
            if(v2.getStrokeWidth() == ((Stroke)arg3).getWidth()) {
            }
            else {
                v2.setStrokeWidth(((Stroke)arg3).getWidth());
            }

            if(!StrokeCap.equals-impl0(v2.getStrokeCap-KaPHkGw(), ((Stroke)arg3).getCap-KaPHkGw())) {
                v2.setStrokeCap-BeK7IIE(((Stroke)arg3).getCap-KaPHkGw());
            }

            if(v2.getStrokeMiterLimit() == ((Stroke)arg3).getMiter()) {
            }
            else {
                v2.setStrokeMiterLimit(((Stroke)arg3).getMiter());
            }

            if(!StrokeJoin.equals-impl0(v2.getStrokeJoin-LxFBmk8(), ((Stroke)arg3).getJoin-LxFBmk8())) {
                v2.setStrokeJoin-Ww9F2mQ(((Stroke)arg3).getJoin-LxFBmk8());
            }

            if(!Intrinsics.areEqual(v2.getPathEffect(), ((Stroke)arg3).getPathEffect())) {
                v2.setPathEffect(((Stroke)arg3).getPathEffect());
            }

            return v2;
        }

        throw new NoWhenBranchMatchedException();
    }
}

