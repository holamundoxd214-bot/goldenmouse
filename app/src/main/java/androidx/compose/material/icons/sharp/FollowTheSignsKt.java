package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_followTheSigns", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FollowTheSigns", "Landroidx/compose/material/icons/Icons$Sharp;", "getFollowTheSigns$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getFollowTheSigns", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FollowTheSignsKt {
    private static ImageVector _followTheSigns;

    static {
    }

    public static final ImageVector getFollowTheSigns(Sharp arg19) {
        ImageVector v0 = FollowTheSignsKt._followTheSigns;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FollowTheSigns", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.lineTo(3f, 23f);
        v12.horizontalLineToRelative(2.1f);
        v12.lineToRelative(1.75f, -8f);
        v12.lineTo(9f, 17f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-7.55f);
        v12.lineTo(8.95f, 13.4f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveTo(10.85f, 12f, 12.8f, 13f, 15f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.85f, 0f, -3.45f, -1f, -4.35f, -2.45f);
        v12.lineTo(9.7f, 6.95f);
        v12.curveTo(9.35f, 6.35f, 8.7f, 6f, 8f, 6f);
        v12.curveTo(7.75f, 6f, 7.5f, 6.05f, 7.25f, 6.15f);
        v12.lineTo(2f, 8.3f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.65f);
        v12.lineTo(5.75f, 8.9f);
        v12.moveTo(13f, 2f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(3.75f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(22f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(18.01f, 8f);
        v12.verticalLineTo(6.25f);
        v12.horizontalLineTo(14.5f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineToRelative(3.51f);
        v12.verticalLineTo(3f);
        v12.lineToRelative(2.49f, 2.5f);
        v12.lineTo(18.01f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FollowTheSignsKt._followTheSigns = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.FollowTheSigns", replaceWith="<_subannotation>") public static void getFollowTheSigns$annotations(Sharp arg0) {
    }
}

