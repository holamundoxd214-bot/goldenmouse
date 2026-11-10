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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$Rounded;", "getFace", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FaceKt {
    private static ImageVector _face;

    static {
    }

    public static final ImageVector getFace(Rounded arg19) {
        ImageVector v0 = FaceKt._face;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Face", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.25f, 13f);
        v12.curveToRelative(0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        v12.reflectiveCurveTo(7.75f, 13.69f, 7.75f, 13f);
        v12.reflectiveCurveTo(8.31f, 11.75f, 9f, 11.75f);
        v12.reflectiveCurveTo(10.25f, 12.31f, 10.25f, 13f);
        v12.close();
        v12.moveTo(15f, 11.75f);
        v12.curveToRelative(-0.69f, 0f, -1.25f, 0.56f, -1.25f, 1.25f);
        v12.reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f);
        v12.reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f);
        v12.reflectiveCurveTo(15.69f, 11.75f, 15f, 11.75f);
        v12.close();
        v12.moveTo(22f, 12f);
        v12.curveToRelative(0f, 5.52f, -4.48f, 10f, -10f, 10f);
        v12.reflectiveCurveTo(2f, 17.52f, 2f, 12f);
        v12.reflectiveCurveTo(6.48f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(22f, 6.48f, 22f, 12f);
        v12.close();
        v12.moveTo(20f, 12f);
        v12.curveToRelative(0f, -0.78f, -0.12f, -1.53f, -0.33f, -2.24f);
        v12.curveTo(18.969999f, 9.91f, 18.25f, 10f, 17.5f, 10f);
        v12.curveToRelative(-3.13f, 0f, -5.92f, -1.44f, -7.76f, -3.69f);
        v12.curveTo(8.69f, 8.87f, 6.6f, 10.88f, 4f, 11.86f);
        v12.curveTo(4.01f, 11.9f, 4f, 11.95f, 4f, 12f);
        v12.curveToRelative(0f, 4.41f, 3.59f, 8f, 8f, 8f);
        v12.reflectiveCurveTo(20f, 16.41f, 20f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FaceKt._face = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

