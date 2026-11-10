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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noteAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoteAlt", "Landroidx/compose/material/icons/Icons$Sharp;", "getNoteAlt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoteAltKt {
    private static ImageVector _noteAlt;

    static {
    }

    public static final ImageVector getNoteAlt(Sharp arg19) {
        ImageVector v0 = NoteAltKt._noteAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NoteAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 3f);
        v12.horizontalLineToRelative(-6.18f);
        v12.curveTo(14.4f, 1.84f, 13.3f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(9.6f, 1.84f, 9.18f, 3f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(18f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineTo(3f);
        v12.close();
        v12.moveTo(12f, 2.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.reflectiveCurveTo(12.41f, 4.25f, 12f, 4.25f);
        v12.reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f);
        v12.reflectiveCurveTo(11.59f, 2.75f, 12f, 2.75f);
        v12.close();
        v12.moveTo(9.1f, 17f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-2.14f);
        v12.lineToRelative(5.96f, -5.96f);
        v12.lineToRelative(2.12f, 2.12f);
        v12.lineTo(9.1f, 17f);
        v12.close();
        v12.moveTo(17.200001f, 8.91f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(13.66f, 8.2f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(17.200001f, 8.91f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoteAltKt._noteAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

