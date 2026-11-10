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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_followTheSigns", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FollowTheSigns", "Landroidx/compose/material/icons/Icons$Rounded;", "getFollowTheSigns$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getFollowTheSigns", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FollowTheSignsKt {
    private static ImageVector _followTheSigns;

    static {
    }

    public static final ImageVector getFollowTheSigns(Rounded arg19) {
        ImageVector v0 = FollowTheSignsKt._followTheSigns;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FollowTheSigns", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(8.4f, 5.5f, 9.5f, 5.5f);
        v12.close();
        v12.moveTo(5.75f, 8.9f);
        v12.lineTo(3.23f, 21.809999f);
        v12.curveTo(3.11f, 22.43f, 3.58f, 23f, 4.21f, 23f);
        v12.horizontalLineTo(4.3f);
        v12.curveToRelative(0.47f, 0f, 0.88f, -0.33f, 0.98f, -0.79f);
        v12.lineTo(6.85f, 15f);
        v12.lineTo(9f, 17f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-6.14f);
        v12.curveToRelative(0f, -0.27f, -0.11f, -0.52f, -0.29f, -0.71f);
        v12.lineTo(8.95f, 13.4f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1.07f, 1.32f, 2.58f, 2.23f, 4.31f, 2.51f);
        v12.curveToRelative(0.6f, 0.1f, 1.14f, -0.39f, 1.14f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.49f, -0.36f, -0.9f, -0.84f, -0.98f);
        v12.curveToRelative(-1.49f, -0.25f, -2.75f, -1.15f, -3.51f, -2.38f);
        v12.lineTo(9.7f, 6.95f);
        v12.curveTo(9.35f, 6.35f, 8.7f, 6f, 8f, 6f);
        v12.curveTo(7.75f, 6f, 7.5f, 6.05f, 7.25f, 6.15f);
        v12.lineToRelative(-4.63f, 1.9f);
        v12.curveTo(2.25f, 8.2f, 2f, 8.57f, 2f, 8.97f);
        v12.verticalLineTo(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(9.65f);
        v12.lineTo(5.75f, 8.9f);
        v12.moveTo(21f, 2f);
        v12.horizontalLineToRelative(-7f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.75f);
        v12.verticalLineToRelative(13.25f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(21f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(3f);
        v12.curveTo(22f, 2.45f, 21.549999f, 2f, 21f, 2f);
        v12.close();
        v12.moveTo(20.15f, 5.85f);
        v12.lineToRelative(-1.28f, 1.29f);
        v12.curveToRelative(-0.31f, 0.32f, -0.85f, 0.09f, -0.85f, -0.35f);
        v12.verticalLineTo(6.25f);
        v12.horizontalLineToRelative(-2.76f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(2.76f);
        v12.verticalLineTo(4.21f);
        v12.curveToRelative(0f, -0.45f, 0.54f, -0.67f, 0.85f, -0.35f);
        v12.lineToRelative(1.28f, 1.29f);
        v12.curveTo(20.34f, 5.34f, 20.34f, 5.66f, 20.15f, 5.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FollowTheSignsKt._followTheSigns = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.FollowTheSigns", replaceWith="<_subannotation>") public static void getFollowTheSigns$annotations(Rounded arg0) {
    }
}

