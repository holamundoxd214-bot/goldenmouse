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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_personRemoveAlt1", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PersonRemoveAlt1", "Landroidx/compose/material/icons/Icons$Sharp;", "getPersonRemoveAlt1", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PersonRemoveAlt1Kt {
    private static ImageVector _personRemoveAlt1;

    static {
    }

    public static final ImageVector getPersonRemoveAlt1(Sharp arg19) {
        ImageVector v0 = PersonRemoveAlt1Kt._personRemoveAlt1;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.PersonRemoveAlt1", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 8f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveTo(6f, 5.79f, 6f, 8f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveTo(14f, 10.21f, 14f, 8f);
        v12.close();
        v12.moveTo(17f, 10f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(17f);
        v12.close();
        v12.moveTo(2f, 18f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -2.66f, -5.33f, -4f, -8f, -4f);
        v12.reflectiveCurveTo(2f, 15.34f, 2f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PersonRemoveAlt1Kt._personRemoveAlt1 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

