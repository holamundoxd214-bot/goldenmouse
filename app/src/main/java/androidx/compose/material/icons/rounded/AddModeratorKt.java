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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addModerator", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddModerator", "Landroidx/compose/material/icons/Icons$Rounded;", "getAddModerator", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddModeratorKt {
    private static ImageVector _addModerator;

    static {
    }

    public static final ImageVector getAddModerator(Rounded arg19) {
        ImageVector v0 = AddModeratorKt._addModerator;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AddModerator", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 10f);
        v12.curveToRelative(1.08f, 0f, 2.09f, 0.25f, 3f, 0.68f);
        v12.verticalLineToRelative(-4.3f);
        v12.curveToRelative(0f, -0.83f, -0.52f, -1.58f, -1.3f, -1.87f);
        v12.lineToRelative(-6f, -2.25f);
        v12.curveToRelative(-0.45f, -0.17f, -0.95f, -0.17f, -1.4f, 0f);
        v12.lineToRelative(-6f, 2.25f);
        v12.curveTo(4.52f, 4.81f, 4f, 5.55f, 4f, 6.39f);
        v12.verticalLineToRelative(4.7f);
        v12.curveToRelative(0f, 5.05f, 3.41f, 9.76f, 8f, 10.91f);
        v12.curveToRelative(0.03f, -0.01f, 0.05f, -0.02f, 0.08f, -0.02f);
        v12.curveTo(10.8f, 20.709999f, 10f, 18.950001f, 10f, 17f);
        v12.curveTo(10f, 13.13f, 13.13f, 10f, 17f, 10f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(19.76f, 12f, 17f, 12f);
        v12.close();
        v12.moveTo(19.5f, 17.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(19.780001f, 17.5f, 19.5f, 17.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddModeratorKt._addModerator = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

