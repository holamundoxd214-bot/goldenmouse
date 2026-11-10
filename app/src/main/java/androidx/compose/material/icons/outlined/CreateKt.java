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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_create", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Create", "Landroidx/compose/material/icons/Icons$Outlined;", "getCreate", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CreateKt {
    private static ImageVector _create;

    static {
    }

    public static final ImageVector getCreate(Outlined arg19) {
        ImageVector v0 = CreateKt._create;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Create", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 17.25f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(3.75f);
        v12.lineTo(17.809999f, 9.94f);
        v12.lineToRelative(-3.75f, -3.75f);
        v12.lineTo(3f, 17.25f);
        v12.close();
        v12.moveTo(5.92f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-0.92f);
        v12.lineToRelative(9.06f, -9.06f);
        v12.lineToRelative(0.92f, 0.92f);
        v12.lineTo(5.92f, 19f);
        v12.close();
        v12.moveTo(20.709999f, 5.63f);
        v12.lineToRelative(-2.34f, -2.34f);
        v12.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        v12.reflectiveCurveToRelative(-0.51f, 0.1f, -0.7f, 0.29f);
        v12.lineToRelative(-1.83f, 1.83f);
        v12.lineToRelative(3.75f, 3.75f);
        v12.lineToRelative(1.83f, -1.83f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CreateKt._create = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

