package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_followTheSigns", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FollowTheSigns", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFollowTheSigns$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getFollowTheSigns", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FollowTheSignsKt {
    private static ImageVector _followTheSigns;

    static {
    }

    public static final ImageVector getFollowTheSigns(TwoTone arg19) {
        ImageVector v0 = FollowTheSignsKt._followTheSigns;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.FollowTheSigns", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(17.639999f, 7.75f);
        v0_1.verticalLineTo(6f);
        v0_1.horizontalLineToRelative(-3.51f);
        v0_1.verticalLineTo(4.5f);
        v0_1.horizontalLineToRelative(3.51f);
        v0_1.verticalLineTo(2.75f);
        v0_1.lineToRelative(2.49f, 2.5f);
        v0_1.lineTo(17.639999f, 7.75f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.12f, 5.25f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(8.02f, 5.25f, 9.12f, 5.25f);
        v12.close();
        v12.moveTo(5.38f, 8.65f);
        v12.lineToRelative(-2.75f, 14.1f);
        v12.horizontalLineToRelative(2.1f);
        v12.lineToRelative(1.75f, -8f);
        v12.lineToRelative(2.15f, 2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(15.2f);
        v12.lineToRelative(-2.05f, -2.05f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1.3f, 1.6f, 3.25f, 2.6f, 5.45f, 2.6f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.85f, 0f, -3.45f, -1f, -4.35f, -2.45f);
        v12.lineTo(9.32f, 6.7f);
        v12.curveToRelative(-0.35f, -0.6f, -1f, -0.95f, -1.7f, -0.95f);
        v12.curveToRelative(-0.25f, 0f, -0.5f, 0.05f, -0.75f, 0.15f);
        v12.lineTo(1.62f, 8.05f);
        v12.verticalLineToRelative(4.7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.4f);
        v12.lineTo(5.38f, 8.65f);
        v12.moveTo(12.62f, 1.75f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(3.75f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-14f);
        v12.horizontalLineToRelative(3.75f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineTo(12.62f);
        v12.close();
        v12.moveTo(17.639999f, 7.75f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(-3.51f);
        v12.verticalLineTo(4.5f);
        v12.horizontalLineToRelative(3.51f);
        v12.verticalLineTo(2.75f);
        v12.lineToRelative(2.49f, 2.5f);
        v12.lineTo(17.639999f, 7.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FollowTheSignsKt._followTheSigns = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.FollowTheSigns", replaceWith="<_subannotation>") public static void getFollowTheSigns$annotations(TwoTone arg0) {
    }
}

