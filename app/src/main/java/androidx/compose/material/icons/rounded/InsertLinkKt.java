package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_insertLink", "Landroidx/compose/ui/graphics/vector/ImageVector;", "InsertLink", "Landroidx/compose/material/icons/Icons$Rounded;", "getInsertLink", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class InsertLinkKt {
    private static ImageVector _insertLink;

    static {
    }

    public static final ImageVector getInsertLink(Rounded arg19) {
        ImageVector v0 = InsertLinkKt._insertLink;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.InsertLink", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.96f, 11.38f);
        v12.curveTo(4.24f, 9.91f, 5.62f, 8.9f, 7.12f, 8.9f);
        v12.horizontalLineToRelative(2.93f);
        v12.curveToRelative(0.52f, 0f, 0.95f, -0.43f, 0.95f, -0.95f);
        v12.reflectiveCurveTo(10.57f, 7f, 10.05f, 7f);
        v12.lineTo(7.22f, 7f);
        v12.curveToRelative(-2.61f, 0f, -4.94f, 1.91f, -5.19f, 4.51f);
        v12.curveTo(1.74f, 14.49f, 4.08f, 17f, 7f, 17f);
        v12.horizontalLineToRelative(3.05f);
        v12.curveToRelative(0.52f, 0f, 0.95f, -0.43f, 0.95f, -0.95f);
        v12.reflectiveCurveToRelative(-0.43f, -0.95f, -0.95f, -0.95f);
        v12.lineTo(7f, 15.1f);
        v12.curveToRelative(-1.91f, 0f, -3.42f, -1.74f, -3.04f, -3.72f);
        v12.close();
        v12.moveTo(9f, 13f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.lineTo(9f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.close();
        v12.moveTo(16.780001f, 7f);
        v12.horizontalLineToRelative(-2.83f);
        v12.curveToRelative(-0.52f, 0f, -0.95f, 0.43f, -0.95f, 0.95f);
        v12.reflectiveCurveToRelative(0.43f, 0.95f, 0.95f, 0.95f);
        v12.horizontalLineToRelative(2.93f);
        v12.curveToRelative(1.5f, 0f, 2.88f, 1.01f, 3.16f, 2.48f);
        v12.curveToRelative(0.38f, 1.98f, -1.13f, 3.72f, -3.04f, 3.72f);
        v12.horizontalLineToRelative(-3.05f);
        v12.curveToRelative(-0.52f, 0f, -0.95f, 0.43f, -0.95f, 0.95f);
        v12.reflectiveCurveToRelative(0.43f, 0.95f, 0.95f, 0.95f);
        v12.lineTo(17f, 17f);
        v12.curveToRelative(2.92f, 0f, 5.26f, -2.51f, 4.98f, -5.49f);
        v12.curveToRelative(-0.25f, -2.6f, -2.59f, -4.51f, -5.2f, -4.51f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        InsertLinkKt._insertLink = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

