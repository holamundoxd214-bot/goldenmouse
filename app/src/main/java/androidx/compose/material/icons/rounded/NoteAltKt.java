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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noteAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoteAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoteAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoteAltKt {
    private static ImageVector _noteAlt;

    static {
    }

    public static final ImageVector getNoteAlt(Rounded arg19) {
        ImageVector v0 = NoteAltKt._noteAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoteAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineToRelative(-4.18f);
        v12.curveTo(14.4f, 1.84f, 13.3f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(9.6f, 1.84f, 9.18f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(12f, 2.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(12.41f, 4.25f, 12f, 4.25f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 2.75f, 12f, 2.75f);
        v12.close();
        v12.moveTo(8.9f, 17f);
        v12.horizontalLineTo(7.5f);
        v12.curveTo(7.22f, 17f, 7f, 16.780001f, 7f, 16.5f);
        v12.verticalLineToRelative(-1.43f);
        v12.curveToRelative(0f, -0.13f, 0.05f, -0.26f, 0.15f, -0.35f);
        v12.lineToRelative(5.81f, -5.81f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineToRelative(-5.83f, 5.83f);
        v12.curveTo(9.16f, 16.950001f, 9.03f, 17f, 8.9f, 17f);
        v12.close();
        v12.moveTo(16.85f, 9.27f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveTo(17.049999f, 8.76f, 17.049999f, 9.07f, 16.85f, 9.27f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoteAltKt._noteAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

