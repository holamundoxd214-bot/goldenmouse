package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_addReaction", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AddReaction", "Landroidx/compose/material/icons/Icons$Filled;", "getAddReaction", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AddReactionKt {
    private static ImageVector _addReaction;

    static {
    }

    public static final ImageVector getAddReaction(Filled arg19) {
        ImageVector v0 = AddReactionKt._addReaction;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AddReaction", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 9f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(2.84f);
        v12.curveTo(14.77f, 2.3f, 13.42f, 2f, 11.99f, 2f);
        v12.curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.47f, 10f, 9.99f, 10f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.curveToRelative(0f, -1.05f, -0.17f, -2.05f, -0.47f, -3f);
        v12.horizontalLineTo(18f);
        v12.close();
        v12.moveTo(15.5f, 8f);
        v12.curveTo(16.33f, 8f, 17f, 8.67f, 17f, 9.5f);
        v12.reflectiveCurveTo(16.33f, 11f, 15.5f, 11f);
        v12.reflectiveCurveTo(14f, 10.33f, 14f, 9.5f);
        v12.reflectiveCurveTo(14.67f, 8f, 15.5f, 8f);
        v12.close();
        v12.moveTo(8.5f, 8f);
        v12.curveTo(9.33f, 8f, 10f, 8.67f, 10f, 9.5f);
        v12.reflectiveCurveTo(9.33f, 11f, 8.5f, 11f);
        v12.reflectiveCurveTo(7f, 10.33f, 7f, 9.5f);
        v12.reflectiveCurveTo(7.67f, 8f, 8.5f, 8f);
        v12.close();
        v12.moveTo(12f, 17.5f);
        v12.curveToRelative(-2.33f, 0f, -4.31f, -1.46f, -5.11f, -3.5f);
        v12.horizontalLineToRelative(10.22f);
        v12.curveTo(16.309999f, 16.040001f, 14.33f, 17.5f, 12f, 17.5f);
        v12.close();
        v12.moveTo(22f, 3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AddReactionKt._addReaction = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

