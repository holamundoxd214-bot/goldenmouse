package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_partyMode", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PartyMode", "Landroidx/compose/material/icons/Icons$Outlined;", "getPartyMode", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PartyModeKt {
    private static ImageVector _partyMode;

    static {
    }

    public static final ImageVector getPartyMode(Outlined arg19) {
        ImageVector v0 = PartyModeKt._partyMode;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PartyMode", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 4f);
        v12.horizontalLineToRelative(-3.17f);
        v12.lineTo(15f, 2f);
        v12.lineTo(9f, 2f);
        v12.lineTo(7.17f, 4f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(22f, 6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.lineTo(4f, 18f);
        v12.lineTo(4f, 6f);
        v12.horizontalLineToRelative(4.05f);
        v12.lineToRelative(0.59f, -0.65f);
        v12.lineTo(9.88f, 4f);
        v12.horizontalLineToRelative(4.24f);
        v12.lineToRelative(1.24f, 1.35f);
        v12.lineToRelative(0.59f, 0.65f);
        v12.lineTo(20f, 6f);
        v12.verticalLineToRelative(12f);
        v12.close();
        v12.moveTo(9f, 12f);
        v12.curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f);
        v12.horizontalLineToRelative(3.98f);
        v12.curveToRelative(-0.92f, -1.21f, -2.35f, -2f, -3.98f, -2f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.curveToRelative(0f, 0.34f, 0.04f, 0.68f, 0.1f, 1f);
        v12.horizontalLineToRelative(2.08f);
        v12.curveToRelative(-0.11f, -0.31f, -0.18f, -0.65f, -0.18f, -1f);
        v12.close();
        v12.moveTo(15f, 12f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.lineTo(8.02f, 15f);
        v12.curveToRelative(0.92f, 1.21f, 2.35f, 2f, 3.98f, 2f);
        v12.curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f);
        v12.curveToRelative(0f, -0.34f, -0.03f, -0.68f, -0.1f, -1f);
        v12.horizontalLineToRelative(-2.08f);
        v12.curveToRelative(0.11f, 0.31f, 0.18f, 0.65f, 0.18f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PartyModeKt._partyMode = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

