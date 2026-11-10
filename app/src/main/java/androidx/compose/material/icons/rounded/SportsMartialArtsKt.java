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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsMartialArts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsMartialArts", "Landroidx/compose/material/icons/Icons$Rounded;", "getSportsMartialArts", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsMartialArtsKt {
    private static ImageVector _sportsMartialArts;

    static {
    }

    public static final ImageVector getSportsMartialArts(Rounded arg20) {
        ImageVector v0 = SportsMartialArtsKt._sportsMartialArts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SportsMartialArts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.059999f, 2.6f);
        v12.lineTo(11.6f, 8.7f);
        v12.lineToRelative(-1.21f, -1.04f);
        v12.lineToRelative(2.48f, -1.43f);
        v12.curveToRelative(0.57f, -0.33f, 0.67f, -1.11f, 0.21f, -1.57f);
        v12.lineToRelative(-2.95f, -2.95f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.03f, 2.03f);
        v12.lineTo(5.35f, 8.26f);
        v12.curveToRelative(-0.23f, 0.13f, -0.39f, 0.35f, -0.46f, 0.6f);
        v12.lineToRelative(-0.96f, 3.49f);
        v12.curveToRelative(-0.07f, 0.26f, -0.04f, 0.53f, 0.1f, 0.77f);
        v12.lineToRelative(1.74f, 3.02f);
        v12.curveToRelative(0.28f, 0.48f, 0.89f, 0.64f, 1.37f, 0.37f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.48f, -0.28f, 0.64f, -0.89f, 0.37f, -1.37f);
        v12.lineToRelative(-1.53f, -2.66f);
        v12.lineToRelative(0.36f, -1.29f);
        v12.lineTo(9.5f, 13f);
        v12.lineToRelative(0.44f, 8f);
        v12.curveToRelative(0.03f, 0.56f, 0.49f, 1f, 1.05f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.56f, 0f, 1.02f, -0.44f, 1.05f, -1f);
        v12.lineToRelative(0.45f, -9f);
        v12.lineToRelative(7.87f, -7.96f);
        v12.curveToRelative(0.36f, -0.36f, 0.38f, -0.93f, 0.05f, -1.32f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(20.07f, 2.32f, 19.469999f, 2.27f, 19.059999f, 2.6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5f, 5f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsMartialArtsKt._sportsMartialArts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

