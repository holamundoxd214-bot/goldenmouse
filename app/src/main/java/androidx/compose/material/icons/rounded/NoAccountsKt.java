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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noAccounts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoAccounts", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoAccounts", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoAccountsKt {
    private static ImageVector _noAccounts;

    static {
    }

    public static final ImageVector getNoAccounts(Rounded arg19) {
        ImageVector v0 = NoAccountsKt._noAccounts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoAccounts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.18f, 10.94f);
        v12.curveToRelative(0.2f, -0.44f, 0.32f, -0.92f, 0.32f, -1.44f);
        v12.curveTo(15.5f, 7.57f, 13.93f, 6f, 12f, 6f);
        v12.curveToRelative(-0.52f, 0f, -1f, 0.12f, -1.44f, 0.32f);
        v12.lineTo(15.18f, 10.94f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 15f);
        v12.curveToRelative(-2.32f, 0f, -4.45f, 0.8f, -6.14f, 2.12f);
        v12.curveTo(4.7f, 15.73f, 4f, 13.95f, 4f, 12f);
        v12.curveToRelative(0f, -1.85f, 0.63f, -3.55f, 1.69f, -4.9f);
        v12.lineToRelative(2.86f, 2.86f);
        v12.curveToRelative(0.21f, 1.56f, 1.43f, 2.79f, 2.99f, 2.99f);
        v12.lineToRelative(2.2f, 2.2f);
        v12.curveTo(13.17f, 15.05f, 12.59f, 15f, 12f, 15f);
        v12.close();
        v12.moveTo(18.309999f, 16.9f);
        v12.lineTo(7.1f, 5.69f);
        v12.curveTo(8.45f, 4.63f, 10.15f, 4f, 12f, 4f);
        v12.curveToRelative(4.42f, 0f, 8f, 3.58f, 8f, 8f);
        v12.curveTo(20f, 13.85f, 19.370001f, 15.54f, 18.309999f, 16.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoAccountsKt._noAccounts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

