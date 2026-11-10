package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@DrawScopeMarker @Metadata(d1={"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 u2\u00020\u0001:\u0001uJg\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00072\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b\"\u0010#Jg\u0010\u0011\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00072\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b&\u0010\'JU\u0010(\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b,\u0010-JU\u0010(\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b.\u0010/JK\u00100\u001A\u00020\u00122\u0006\u00101\u001A\u0002022\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b3\u00104Ji\u00100\u001A\u00020\u00122\u0006\u00101\u001A\u0002022\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u00107\u001A\u0002082\b\b\u0002\u00109\u001A\u0002062\b\b\u0002\u0010:\u001A\u0002082\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H\'¢\u0006\u0004\b;\u0010<Js\u00100\u001A\u00020\u00122\u0006\u00101\u001A\u0002022\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u00107\u001A\u0002082\b\b\u0002\u00109\u001A\u0002062\b\b\u0002\u0010:\u001A\u0002082\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010=\u001A\u00020>H\u0016¢\u0006\u0004\b?\u0010@J_\u0010A\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010B\u001A\u00020C2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bD\u0010EJ_\u0010A\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010B\u001A\u00020C2\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bF\u0010GJU\u0010H\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010I\u001A\u00020\u00182\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bJ\u0010KJU\u0010H\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010I\u001A\u00020\u00182\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bL\u0010MJU\u0010N\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bO\u0010-JU\u0010N\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bP\u0010/Jm\u0010Q\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010R\u001A\u00020\u00182\u0006\u0010S\u001A\u00020\u00182\u0006\u0010T\u001A\u00020U2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bV\u0010WJm\u0010Q\u001A\u00020\u00122\u0006\u0010$\u001A\u00020%2\u0006\u0010R\u001A\u00020\u00182\u0006\u0010S\u001A\u00020\u00182\u0006\u0010T\u001A\u00020U2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bX\u0010YJI\u0010Z\u001A\u00020\u00122\u0006\u0010[\u001A\u00020\\2\u0006\u0010$\u001A\u00020%2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b]\u0010^JI\u0010Z\u001A\u00020\u00122\u0006\u0010[\u001A\u00020\\2\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0003\u0010\u001D\u001A\u00020\u00182\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\b_\u0010`Jm\u0010a\u001A\u00020\u00122\f\u0010b\u001A\b\u0012\u0004\u0012\u00020\u00070c2\u0006\u0010d\u001A\u00020e2\u0006\u0010$\u001A\u00020%2\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bf\u0010gJm\u0010a\u001A\u00020\u00122\f\u0010b\u001A\b\u0012\u0004\u0012\u00020\u00070c2\u0006\u0010d\u001A\u00020e2\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\b\u0003\u0010\u001D\u001A\u00020\u00182\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!H&¢\u0006\u0004\bh\u0010iJ6\u0010j\u001A\u00020\u0012*\u00020k2\b\b\u0002\u0010\n\u001A\u0002082\u0017\u0010l\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120m¢\u0006\u0002\bnH\u0016¢\u0006\u0004\bo\u0010pJ\u001B\u0010q\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010r\u001A\u00020\u0007H\u0002¢\u0006\u0004\bs\u0010tR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\tR\u0012\u0010\r\u001A\u00020\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006vÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "drawLine", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "start", "end", "strokeWidth", "", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "topLeft", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "drawOval-n-J9OG0", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "offsetSize", "offset", "offsetSize-PENXr5M", "(JJ)J", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DrawScope extends Density {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\n¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000B\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "<init>", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final int DefaultBlendMode;
        private static final int DefaultFilterQuality;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.DefaultBlendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
            Companion.DefaultFilterQuality = FilterQuality.Companion.getLow-f-v9h1I();
        }

        private Companion() {
            super();
        }

        public final int getDefaultBlendMode-0nO6VwU() {
            return Companion.DefaultBlendMode;
        }

        public final int getDefaultFilterQuality-f-v9h1I() {
            return Companion.DefaultFilterQuality;
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void drawArc-illE91I$default(DrawScope arg0, Brush arg1, float arg2, float arg3, boolean arg4, long arg5, long arg7, float arg9, DrawStyle arg10, ColorFilter arg11, int arg12, int arg13, Object arg14) {
            DrawScope.drawArc-illE91I$default(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg9, arg10, arg11, arg12, arg13, arg14);
        }

        public static void drawArc-yD3GUKo$default(DrawScope arg0, long arg1, float arg3, float arg4, boolean arg5, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, Object arg15) {
            DrawScope.drawArc-yD3GUKo$default(arg0, arg1, arg3, arg4, arg5, arg6, arg8, arg10, arg11, arg12, arg13, arg14, arg15);
        }

        public static void drawCircle-V9BoPsw$default(DrawScope arg0, Brush arg1, float arg2, long arg3, float arg5, DrawStyle arg6, ColorFilter arg7, int arg8, int arg9, Object arg10) {
            DrawScope.drawCircle-V9BoPsw$default(arg0, arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
        }

        public static void drawCircle-VaOC9Bg$default(DrawScope arg0, long arg1, float arg3, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9, int arg10, Object arg11) {
            DrawScope.drawCircle-VaOC9Bg$default(arg0, arg1, arg3, arg4, arg6, arg7, arg8, arg9, arg10, arg11);
        }

        public static void drawImage-9jGpkUE$default(DrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, Object arg15) {
            DrawScope.drawImage-9jGpkUE$default(arg0, arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14, arg15);
        }

        @Deprecated public static void drawImage-AZ2fEMs(DrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14) {
            arg0.drawImage-AZ2fEMs(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14);
        }

        public static void drawImage-AZ2fEMs$default(DrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, int arg15, Object arg16) {
            DrawScope.drawImage-AZ2fEMs$default(arg0, arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
        }

        public static void drawImage-gbVJVH8$default(DrawScope arg0, ImageBitmap arg1, long arg2, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7, int arg8, Object arg9) {
            DrawScope.drawImage-gbVJVH8$default(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public static void drawLine-1RTmtNc$default(DrawScope arg0, Brush arg1, long arg2, long arg4, float arg6, int arg7, PathEffect arg8, float arg9, ColorFilter arg10, int arg11, int arg12, Object arg13) {
            DrawScope.drawLine-1RTmtNc$default(arg0, arg1, arg2, arg4, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
        }

        public static void drawLine-NGM6Ib0$default(DrawScope arg0, long arg1, long arg3, long arg5, float arg7, int arg8, PathEffect arg9, float arg10, ColorFilter arg11, int arg12, int arg13, Object arg14) {
            DrawScope.drawLine-NGM6Ib0$default(arg0, arg1, arg3, arg5, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
        }

        public static void drawOval-AsUm42w$default(DrawScope arg0, Brush arg1, long arg2, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9, int arg10, Object arg11) {
            DrawScope.drawOval-AsUm42w$default(arg0, arg1, arg2, arg4, arg6, arg7, arg8, arg9, arg10, arg11);
        }

        public static void drawOval-n-J9OG0$default(DrawScope arg0, long arg1, long arg3, long arg5, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10, int arg11, Object arg12) {
            DrawScope.drawOval-n-J9OG0$default(arg0, arg1, arg3, arg5, arg7, arg8, arg9, arg10, arg11, arg12);
        }

        public static void drawPath-GBMwjPU$default(DrawScope arg0, Path arg1, Brush arg2, float arg3, DrawStyle arg4, ColorFilter arg5, int arg6, int arg7, Object arg8) {
            DrawScope.drawPath-GBMwjPU$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }

        public static void drawPath-LG529CI$default(DrawScope arg0, Path arg1, long arg2, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7, int arg8, Object arg9) {
            DrawScope.drawPath-LG529CI$default(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public static void drawPoints-F8ZwMP8$default(DrawScope arg0, List arg1, int arg2, long arg3, float arg5, int arg6, PathEffect arg7, float arg8, ColorFilter arg9, int arg10, int arg11, Object arg12) {
            DrawScope.drawPoints-F8ZwMP8$default(arg0, arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
        }

        public static void drawPoints-Gsft0Ws$default(DrawScope arg0, List arg1, int arg2, Brush arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9, int arg10, Object arg11) {
            DrawScope.drawPoints-Gsft0Ws$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
        }

        public static void drawRect-AsUm42w$default(DrawScope arg0, Brush arg1, long arg2, long arg4, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9, int arg10, Object arg11) {
            DrawScope.drawRect-AsUm42w$default(arg0, arg1, arg2, arg4, arg6, arg7, arg8, arg9, arg10, arg11);
        }

        public static void drawRect-n-J9OG0$default(DrawScope arg0, long arg1, long arg3, long arg5, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10, int arg11, Object arg12) {
            DrawScope.drawRect-n-J9OG0$default(arg0, arg1, arg3, arg5, arg7, arg8, arg9, arg10, arg11, arg12);
        }

        public static void drawRoundRect-ZuiqVtQ$default(DrawScope arg0, Brush arg1, long arg2, long arg4, long arg6, float arg8, DrawStyle arg9, ColorFilter arg10, int arg11, int arg12, Object arg13) {
            DrawScope.drawRoundRect-ZuiqVtQ$default(arg0, arg1, arg2, arg4, arg6, arg8, arg9, arg10, arg11, arg12, arg13);
        }

        public static void drawRoundRect-u-Aw5IA$default(DrawScope arg0, long arg1, long arg3, long arg5, long arg7, DrawStyle arg9, float arg10, ColorFilter arg11, int arg12, int arg13, Object arg14) {
            DrawScope.drawRoundRect-u-Aw5IA$default(arg0, arg1, arg3, arg5, arg7, arg9, arg10, arg11, arg12, arg13, arg14);
        }

        @Deprecated public static long getCenter-F1C5BW0(DrawScope arg2) {
            return arg2.getCenter-F1C5BW0();
        }

        @Deprecated public static long getSize-NH-jbRc(DrawScope arg2) {
            return arg2.getSize-NH-jbRc();
        }

        @Deprecated public static void record-JVtK1S4(DrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4) {
            arg0.record-JVtK1S4(arg1, arg2, arg4);
        }

        public static void record-JVtK1S4$default(DrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4, int arg5, Object arg6) {
            DrawScope.record-JVtK1S4$default(arg0, arg1, arg2, arg4, arg5, arg6);
        }

        @Deprecated public static int roundToPx--R2X_6o(DrawScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(DrawScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(DrawScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(DrawScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(DrawScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(DrawScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(DrawScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(DrawScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(DrawScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(DrawScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(DrawScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(DrawScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(DrawScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    public static final Companion Companion;

    static {
        DrawScope.Companion = Companion.$$INSTANCE;
    }

    static void access$drawImage-AZ2fEMs$jd(DrawScope arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14) {
        super.drawImage-AZ2fEMs(arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12, arg13, arg14);
    }

    static long access$getCenter-F1C5BW0$jd(DrawScope arg2) {
        return super.getCenter-F1C5BW0();
    }

    static long access$getSize-NH-jbRc$jd(DrawScope arg2) {
        return super.getSize-NH-jbRc();
    }

    static void access$record-JVtK1S4$jd(DrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4) {
        super.record-JVtK1S4(arg1, arg2, arg4);
    }

    static int access$roundToPx--R2X_6o$jd(DrawScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(DrawScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(DrawScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(DrawScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(DrawScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(DrawScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(DrawScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(DrawScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(DrawScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(DrawScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(DrawScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(DrawScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(DrawScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    void drawArc-illE91I(Brush arg1, float arg2, float arg3, boolean arg4, long arg5, long arg6, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10);

    static void drawArc-illE91I$default(DrawScope arg16, Brush arg17, float arg18, float arg19, boolean arg20, long arg21, long arg23, float arg25, DrawStyle arg26, ColorFilter arg27, int arg28, int arg29, Object arg30) {
        Fill v13;
        long v10;
        DrawScope v3;
        int v0 = arg29;
        if(arg30 == null) {
            long v8 = (v0 & 16) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg21;
            if((v0 & 0x20) != 0) {
                v3 = arg16;
                v10 = v3.offsetSize-PENXr5M(arg16.getSize-NH-jbRc(), v8);
            }
            else {
                v3 = arg16;
                v10 = arg23;
            }

            float v12 = (v0 & 0x40) != 0 ? 1f : arg25;
            if((v0 & 0x80) != 0) {
                v13 = Fill.INSTANCE;
            }
            else {
                DrawStyle v13_1 = arg26;
            }

            ColorFilter v14 = (v0 & 0x100) != 0 ? null : arg27;
            int v15 = (v0 & 0x200) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg28;
            v3.drawArc-illE91I(arg17, arg18, arg19, arg20, v8, v10, v12, ((DrawStyle)v13), v14, v15);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
    }

    void drawArc-yD3GUKo(long arg1, float arg2, float arg3, boolean arg4, long arg5, long arg6, float arg7, DrawStyle arg8, ColorFilter arg9, int arg10);

    static void drawArc-yD3GUKo$default(DrawScope arg17, long arg18, float arg20, float arg21, boolean arg22, long arg23, long arg25, float arg27, DrawStyle arg28, ColorFilter arg29, int arg30, int arg31, Object arg32) {
        DrawStyle v14_1;
        long v11;
        DrawScope v3;
        int v0 = arg31;
        if(arg32 == null) {
            long v9 = (v0 & 16) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg23;
            if((v0 & 0x20) != 0) {
                v3 = arg17;
                v11 = v3.offsetSize-PENXr5M(arg17.getSize-NH-jbRc(), v9);
            }
            else {
                v3 = arg17;
                v11 = arg25;
            }

            float v13 = (v0 & 0x40) != 0 ? 1f : arg27;
            if((v0 & 0x80) != 0) {
                Fill v14 = Fill.INSTANCE;
            }
            else {
                v14_1 = arg28;
            }

            ColorFilter v15 = (v0 & 0x100) != 0 ? null : arg29;
            int v16 = (v0 & 0x200) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg30;
            v3.drawArc-yD3GUKo(arg18, arg20, arg21, arg22, v9, v11, v13, v14_1, v15, v16);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
    }

    void drawCircle-V9BoPsw(Brush arg1, float arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawCircle-V9BoPsw$default(DrawScope arg7, Brush arg8, float arg9, long arg10, float arg12, DrawStyle arg13, ColorFilter arg14, int arg15, int arg16, Object arg17) {
        Fill v4;
        if(arg17 == null) {
            float v0 = (arg16 & 2) != 0 ? Size.getMinDimension-impl(arg7.getSize-NH-jbRc()) / 2f : arg9;
            long v1 = (arg16 & 4) != 0 ? arg7.getCenter-F1C5BW0() : arg10;
            float v3 = (arg16 & 8) != 0 ? 1f : arg12;
            if((arg16 & 16) != 0) {
                v4 = Fill.INSTANCE;
            }
            else {
                DrawStyle v4_1 = arg13;
            }

            ColorFilter v5 = (arg16 & 0x20) != 0 ? null : arg14;
            int v17 = (arg16 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg15;
            arg7.drawCircle-V9BoPsw(arg8, v0, v1, v3, v4, v5, v17);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
    }

    void drawCircle-VaOC9Bg(long arg1, float arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawCircle-VaOC9Bg$default(DrawScope arg10, long arg11, float arg13, long arg14, float arg16, DrawStyle arg17, ColorFilter arg18, int arg19, int arg20, Object arg21) {
        DrawStyle v7_1;
        if(arg21 == null) {
            if((arg20 & 2) != 0) {
                arg13 = Size.getMinDimension-impl(arg10.getSize-NH-jbRc()) / 2f;
            }

            float v3 = arg13;
            long v4 = (arg20 & 4) != 0 ? arg10.getCenter-F1C5BW0() : arg14;
            float v6 = (arg20 & 8) != 0 ? 1f : arg16;
            if((arg20 & 16) != 0) {
                Fill v7 = Fill.INSTANCE;
            }
            else {
                v7_1 = arg17;
            }

            ColorFilter v8 = (arg20 & 0x20) != 0 ? null : arg18;
            int v9 = (arg20 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg19;
            arg10.drawCircle-VaOC9Bg(arg11, v3, v4, v6, v7_1, v8, v9);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
    }

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith="<_subannotation>") void drawImage-9jGpkUE(ImageBitmap arg1, long arg2, long arg3, long arg4, long arg5, float arg6, DrawStyle arg7, ColorFilter arg8, int arg9);

    static void drawImage-9jGpkUE$default(DrawScope arg12, ImageBitmap arg13, long arg14, long arg16, long arg18, long arg20, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25, int arg26, Object arg27) {
        Fill v10;
        int v0 = arg26;
        if(arg27 == null) {
            long v1 = (v0 & 2) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg14;
            long v3 = (v0 & 4) != 0 ? IntSize.constructor-impl((((long)arg13.getHeight())) & 0xFFFFFFFFL | (((long)arg13.getWidth())) << 0x20) : arg16;
            long v5 = (v0 & 8) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg18;
            long v7 = (v0 & 16) != 0 ? v3 : arg20;
            float v9 = (v0 & 0x20) != 0 ? 1f : arg22;
            if((v0 & 0x40) != 0) {
                v10 = Fill.INSTANCE;
            }
            else {
                DrawStyle v10_1 = arg23;
            }

            ColorFilter v11 = (v0 & 0x80) != 0 ? null : arg24;
            int v27 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg25;
            arg12.drawImage-9jGpkUE(arg13, v1, v3, v5, v7, v9, v10, v11, v27);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
    }

    default void drawImage-AZ2fEMs(ImageBitmap arg18, long arg19, long arg21, long arg23, long arg25, float arg27, DrawStyle arg28, ColorFilter arg29, int arg30, int arg31) {
        DrawScope.drawImage-AZ2fEMs$default(this, arg18, arg19, arg21, arg23, arg25, arg27, arg28, arg29, arg30, 0, 0x200, null);
    }

    static void drawImage-AZ2fEMs$default(DrawScope arg13, ImageBitmap arg14, long arg15, long arg17, long arg19, long arg21, float arg23, DrawStyle arg24, ColorFilter arg25, int arg26, int arg27, int arg28, Object arg29) {
        Fill v10;
        int v0 = arg28;
        if(arg29 == null) {
            long v1 = (v0 & 2) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg15;
            long v3 = (v0 & 4) != 0 ? IntSize.constructor-impl((((long)arg14.getHeight())) & 0xFFFFFFFFL | (((long)arg14.getWidth())) << 0x20) : arg17;
            long v5 = (v0 & 8) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg19;
            long v7 = (v0 & 16) != 0 ? v3 : arg21;
            float v9 = (v0 & 0x20) != 0 ? 1f : arg23;
            if((v0 & 0x40) != 0) {
                v10 = Fill.INSTANCE;
            }
            else {
                DrawStyle v10_1 = arg24;
            }

            ColorFilter v11 = (v0 & 0x80) != 0 ? null : arg25;
            int v12 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg26;
            int v29 = (v0 & 0x200) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : arg27;
            arg13.drawImage-AZ2fEMs(arg14, v1, v3, v5, v7, v9, v10, v11, v12, v29);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
    }

    void drawImage-gbVJVH8(ImageBitmap arg1, long arg2, float arg3, DrawStyle arg4, ColorFilter arg5, int arg6);

    static void drawImage-gbVJVH8$default(DrawScope arg6, ImageBitmap arg7, long arg8, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, Object arg15) {
        Fill v3;
        if(arg15 == null) {
            long v0 = (arg14 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg8;
            float v2 = (arg14 & 4) != 0 ? 1f : arg10;
            if((arg14 & 8) != 0) {
                v3 = Fill.INSTANCE;
            }
            else {
                DrawStyle v3_1 = arg11;
            }

            ColorFilter v4 = (arg14 & 16) != 0 ? null : arg12;
            int v15 = (arg14 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg13;
            arg6.drawImage-gbVJVH8(arg7, v0, v2, v3, v4, v15);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
    }

    void drawLine-1RTmtNc(Brush arg1, long arg2, long arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9);

    static void drawLine-1RTmtNc$default(DrawScope arg14, Brush arg15, long arg16, long arg18, float arg20, int arg21, PathEffect arg22, float arg23, ColorFilter arg24, int arg25, int arg26, Object arg27) {
        int v0 = arg26;
        if(arg27 == null) {
            float v8 = (v0 & 8) != 0 ? 0f : arg20;
            int v9 = (v0 & 16) != 0 ? Stroke.Companion.getDefaultCap-KaPHkGw() : arg21;
            PathEffect v2 = null;
            PathEffect v10 = (v0 & 0x20) != 0 ? v2 : arg22;
            float v11 = (v0 & 0x40) != 0 ? 1f : arg23;
            ColorFilter v12 = (v0 & 0x80) != 0 ? ((ColorFilter)v2) : arg24;
            int v13 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg25;
            arg14.drawLine-1RTmtNc(arg15, arg16, arg18, v8, v9, v10, v11, v12, v13);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
    }

    void drawLine-NGM6Ib0(long arg1, long arg2, long arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9);

    static void drawLine-NGM6Ib0$default(DrawScope arg15, long arg16, long arg18, long arg20, float arg22, int arg23, PathEffect arg24, float arg25, ColorFilter arg26, int arg27, int arg28, Object arg29) {
        int v0 = arg28;
        if(arg29 == null) {
            float v9 = (v0 & 8) != 0 ? 0f : arg22;
            int v10 = (v0 & 16) != 0 ? Stroke.Companion.getDefaultCap-KaPHkGw() : arg23;
            PathEffect v2 = null;
            PathEffect v11 = (v0 & 0x20) != 0 ? v2 : arg24;
            float v12 = (v0 & 0x40) != 0 ? 1f : arg25;
            ColorFilter v13 = (v0 & 0x80) != 0 ? ((ColorFilter)v2) : arg26;
            int v14 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg27;
            arg15.drawLine-NGM6Ib0(arg16, arg18, arg20, v9, v10, v11, v12, v13, v14);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
    }

    void drawOval-AsUm42w(Brush arg1, long arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawOval-AsUm42w$default(DrawScope arg8, Brush arg9, long arg10, long arg12, float arg14, DrawStyle arg15, ColorFilter arg16, int arg17, int arg18, Object arg19) {
        DrawStyle v5_1;
        if(arg19 == null) {
            long v0 = (arg18 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg10;
            long v2 = (arg18 & 4) != 0 ? arg8.offsetSize-PENXr5M(arg8.getSize-NH-jbRc(), v0) : arg12;
            float v4 = (arg18 & 8) != 0 ? 1f : arg14;
            if((arg18 & 16) != 0) {
                Fill v5 = Fill.INSTANCE;
            }
            else {
                v5_1 = arg15;
            }

            ColorFilter v6 = (arg18 & 0x20) != 0 ? null : arg16;
            int v19 = (arg18 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg17;
            arg8.drawOval-AsUm42w(arg9, v0, v2, v4, ((Fill)v5_1), v6, v19);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
    }

    void drawOval-n-J9OG0(long arg1, long arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawOval-n-J9OG0$default(DrawScope arg13, long arg14, long arg16, long arg18, float arg20, DrawStyle arg21, ColorFilter arg22, int arg23, int arg24, Object arg25) {
        DrawStyle v10_1;
        if(arg25 == null) {
            long v5 = (arg24 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg16;
            long v7 = (arg24 & 4) != 0 ? arg13.offsetSize-PENXr5M(arg13.getSize-NH-jbRc(), v5) : arg18;
            float v9 = (arg24 & 8) != 0 ? 1f : arg20;
            if((arg24 & 16) != 0) {
                Fill v10 = Fill.INSTANCE;
            }
            else {
                v10_1 = arg21;
            }

            ColorFilter v11 = (arg24 & 0x20) != 0 ? null : arg22;
            int v12 = (arg24 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg23;
            arg13.drawOval-n-J9OG0(arg14, v5, v7, v9, v10_1, v11, v12);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
    }

    void drawPath-GBMwjPU(Path arg1, Brush arg2, float arg3, DrawStyle arg4, ColorFilter arg5, int arg6);

    static void drawPath-GBMwjPU$default(DrawScope arg7, Path arg8, Brush arg9, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, Object arg15) {
        Fill v11;
        if(arg15 == null) {
            if((arg14 & 4) != 0) {
                arg10 = 1f;
            }

            float v3 = arg10;
            if((arg14 & 8) != 0) {
                v11 = Fill.INSTANCE;
            }

            DrawStyle v4 = ((DrawStyle)v11);
            if((arg14 & 16) != 0) {
                arg12 = null;
            }

            ColorFilter v5 = arg12;
            if((arg14 & 0x20) != 0) {
                arg13 = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            }

            arg7.drawPath-GBMwjPU(arg8, arg9, v3, v4, v5, arg13);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
    }

    void drawPath-LG529CI(Path arg1, long arg2, float arg3, DrawStyle arg4, ColorFilter arg5, int arg6);

    static void drawPath-LG529CI$default(DrawScope arg8, Path arg9, long arg10, float arg12, DrawStyle arg13, ColorFilter arg14, int arg15, int arg16, Object arg17) {
        Fill v13;
        if(arg17 == null) {
            if((arg16 & 4) != 0) {
                arg12 = 1f;
            }

            float v4 = arg12;
            if((arg16 & 8) != 0) {
                v13 = Fill.INSTANCE;
            }

            DrawStyle v5 = ((DrawStyle)v13);
            if((arg16 & 16) != 0) {
                arg14 = null;
            }

            ColorFilter v6 = arg14;
            int v7 = (arg16 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg15;
            arg8.drawPath-LG529CI(arg9, arg10, v4, v5, v6, v7);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
    }

    void drawPoints-F8ZwMP8(List arg1, int arg2, long arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9);

    static void drawPoints-F8ZwMP8$default(DrawScope arg13, List arg14, int arg15, long arg16, float arg18, int arg19, PathEffect arg20, float arg21, ColorFilter arg22, int arg23, int arg24, Object arg25) {
        int v0 = arg24;
        if(arg25 == null) {
            float v7 = (v0 & 8) != 0 ? 0f : arg18;
            int v8 = (v0 & 16) != 0 ? StrokeCap.Companion.getButt-KaPHkGw() : arg19;
            PathEffect v2 = null;
            PathEffect v9 = (v0 & 0x20) != 0 ? v2 : arg20;
            float v10 = (v0 & 0x40) != 0 ? 1f : arg21;
            ColorFilter v11 = (v0 & 0x80) != 0 ? ((ColorFilter)v2) : arg22;
            int v12 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg23;
            arg13.drawPoints-F8ZwMP8(arg14, arg15, arg16, v7, v8, v9, v10, v11, v12);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
    }

    void drawPoints-Gsft0Ws(List arg1, int arg2, Brush arg3, float arg4, int arg5, PathEffect arg6, float arg7, ColorFilter arg8, int arg9);

    static void drawPoints-Gsft0Ws$default(DrawScope arg12, List arg13, int arg14, Brush arg15, float arg16, int arg17, PathEffect arg18, float arg19, ColorFilter arg20, int arg21, int arg22, Object arg23) {
        int v0 = arg22;
        if(arg23 == null) {
            float v6 = (v0 & 8) != 0 ? 0f : arg16;
            int v7 = (v0 & 16) != 0 ? StrokeCap.Companion.getButt-KaPHkGw() : arg17;
            PathEffect v2 = null;
            PathEffect v8 = (v0 & 0x20) != 0 ? v2 : arg18;
            float v9 = (v0 & 0x40) != 0 ? 1f : arg19;
            ColorFilter v10 = (v0 & 0x80) != 0 ? ((ColorFilter)v2) : arg20;
            int v11 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg21;
            arg12.drawPoints-Gsft0Ws(arg13, arg14, arg15, v6, v7, v8, v9, v10, v11);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
    }

    void drawRect-AsUm42w(Brush arg1, long arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawRect-AsUm42w$default(DrawScope arg8, Brush arg9, long arg10, long arg12, float arg14, DrawStyle arg15, ColorFilter arg16, int arg17, int arg18, Object arg19) {
        Fill v5;
        if(arg19 == null) {
            long v0 = (arg18 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg10;
            long v2 = (arg18 & 4) != 0 ? arg8.offsetSize-PENXr5M(arg8.getSize-NH-jbRc(), v0) : arg12;
            float v4 = (arg18 & 8) != 0 ? 1f : arg14;
            if((arg18 & 16) != 0) {
                v5 = Fill.INSTANCE;
            }
            else {
                DrawStyle v5_1 = arg15;
            }

            ColorFilter v6 = (arg18 & 0x20) != 0 ? null : arg16;
            int v19 = (arg18 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg17;
            arg8.drawRect-AsUm42w(arg9, v0, v2, v4, v5, v6, v19);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
    }

    void drawRect-n-J9OG0(long arg1, long arg2, long arg3, float arg4, DrawStyle arg5, ColorFilter arg6, int arg7);

    static void drawRect-n-J9OG0$default(DrawScope arg13, long arg14, long arg16, long arg18, float arg20, DrawStyle arg21, ColorFilter arg22, int arg23, int arg24, Object arg25) {
        DrawStyle v10_1;
        if(arg25 == null) {
            long v5 = (arg24 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg16;
            long v7 = (arg24 & 4) != 0 ? arg13.offsetSize-PENXr5M(arg13.getSize-NH-jbRc(), v5) : arg18;
            float v9 = (arg24 & 8) != 0 ? 1f : arg20;
            if((arg24 & 16) != 0) {
                Fill v10 = Fill.INSTANCE;
            }
            else {
                v10_1 = arg21;
            }

            ColorFilter v11 = (arg24 & 0x20) != 0 ? null : arg22;
            int v12 = (arg24 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg23;
            arg13.drawRect-n-J9OG0(arg14, v5, v7, v9, v10_1, v11, v12);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
    }

    void drawRoundRect-ZuiqVtQ(Brush arg1, long arg2, long arg3, long arg4, float arg5, DrawStyle arg6, ColorFilter arg7, int arg8);

    static void drawRoundRect-ZuiqVtQ$default(DrawScope arg10, Brush arg11, long arg12, long arg14, long arg16, float arg18, DrawStyle arg19, ColorFilter arg20, int arg21, int arg22, Object arg23) {
        DrawStyle v8_1;
        int v0 = arg22;
        if(arg23 == null) {
            long v1 = (v0 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg12;
            long v3 = (v0 & 4) != 0 ? arg10.offsetSize-PENXr5M(arg10.getSize-NH-jbRc(), v1) : arg14;
            long v5 = (v0 & 8) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg16;
            float v7 = (v0 & 16) != 0 ? 1f : arg18;
            if((v0 & 0x20) != 0) {
                Fill v8 = Fill.INSTANCE;
            }
            else {
                v8_1 = arg19;
            }

            ColorFilter v9 = (v0 & 0x40) != 0 ? null : arg20;
            int v23 = (v0 & 0x80) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg21;
            arg10.drawRoundRect-ZuiqVtQ(arg11, v1, v3, v5, v7, ((Fill)v8_1), v9, v23);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
    }

    void drawRoundRect-u-Aw5IA(long arg1, long arg2, long arg3, long arg4, DrawStyle arg5, float arg6, ColorFilter arg7, int arg8);

    static void drawRoundRect-u-Aw5IA$default(DrawScope arg16, long arg17, long arg19, long arg21, long arg23, DrawStyle arg25, float arg26, ColorFilter arg27, int arg28, int arg29, Object arg30) {
        Fill v12;
        long v8;
        DrawScope v3;
        int v0 = arg29;
        if(arg30 == null) {
            long v6 = (v0 & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg19;
            if((v0 & 4) != 0) {
                v3 = arg16;
                v8 = v3.offsetSize-PENXr5M(arg16.getSize-NH-jbRc(), v6);
            }
            else {
                v3 = arg16;
                v8 = arg21;
            }

            long v10 = (v0 & 8) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg23;
            if((v0 & 16) != 0) {
                v12 = Fill.INSTANCE;
            }
            else {
                DrawStyle v12_1 = arg25;
            }

            float v13 = (v0 & 0x20) != 0 ? 1f : arg26;
            ColorFilter v14 = (v0 & 0x40) != 0 ? null : arg27;
            int v15 = (v0 & 0x80) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg28;
            v3.drawRoundRect-u-Aw5IA(arg17, v6, v8, v10, ((DrawStyle)v12), v13, v14, v15);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
    }

    default long getCenter-F1C5BW0() {
        return SizeKt.getCenter-uvyYCjk(this.getDrawContext().getSize-NH-jbRc());
    }

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    default long getSize-NH-jbRc() {
        return this.getDrawContext().getSize-NH-jbRc();
    }

    default private long offsetSize-PENXr5M(long arg6, long arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) - Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    default void record-JVtK1S4(GraphicsLayer arg7, long arg8, Function1 arg10) {
        arg7.record-mL-hObY(this, this.getLayoutDirection(), arg8, new DrawScope$record$1(this, arg10));
    }

    static void record-JVtK1S4$default(DrawScope arg0, GraphicsLayer arg1, long arg2, Function1 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            if((arg5 & 1) != 0) {
                arg2 = IntSizeKt.toIntSize-uvyYCjk(arg0.getSize-NH-jbRc());
            }

            arg0.record-JVtK1S4(arg1, arg2, arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
    }
}

