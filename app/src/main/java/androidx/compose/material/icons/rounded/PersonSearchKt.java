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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personSearch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonSearch", "Landroidx/compose/material/icons/Icons$Rounded;", "getPersonSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonSearchKt {
    private static ImageVector _personSearch;

    static {
    }

    public static final ImageVector getPersonSearch(Rounded arg20) {
        ImageVector v0 = PersonSearchKt._personSearch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PersonSearch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 8f);
        v12.moveToRelative(-4f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, 8f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, -8f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10.35f, 14.01f);
        v12.curveTo(7.62f, 13.91f, 2f, 15.27f, 2f, 18f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(8.54f);
        v12.curveTo(9.07f, 17.24f, 10.31f, 14.11f, 10.35f, 14.01f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.43f, 18.02f);
        v12.curveToRelative(0.47f, -0.8f, 0.7f, -1.77f, 0.48f, -2.82f);
        v12.curveToRelative(-0.34f, -1.64f, -1.72f, -2.95f, -3.38f, -3.16f);
        v12.curveToRelative(-2.63f, -0.34f, -4.85f, 1.87f, -4.5f, 4.5f);
        v12.curveToRelative(0.22f, 1.66f, 1.52f, 3.04f, 3.16f, 3.38f);
        v12.curveToRelative(1.05f, 0.22f, 2.02f, -0.01f, 2.82f, -0.48f);
        v12.lineToRelative(1.86f, 1.86f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(19.43f, 18.02f);
        v12.close();
        v12.moveTo(16f, 18f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveTo(18f, 17.1f, 17.1f, 18f, 16f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonSearchKt._personSearch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

