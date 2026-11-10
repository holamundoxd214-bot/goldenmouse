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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_mergeType", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MergeType", "Landroidx/compose/material/icons/Icons$Rounded;", "getMergeType$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getMergeType", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MergeTypeKt {
    private static ImageVector _mergeType;

    static {
    }

    public static final ImageVector getMergeType(Rounded arg19) {
        ImageVector v0 = MergeTypeKt._mergeType;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MergeType", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.700001f, 19.700001f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.7f, -2.7f);
        v12.lineTo(13.59f, 17f);
        v12.lineToRelative(2.7f, 2.7f);
        v12.curveToRelative(0.39f, 0.39f, 1.03f, 0.39f, 1.41f, 0f);
        v12.close();
        v12.moveTo(8.71f, 8f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(5.59f);
        v12.lineToRelative(-4.71f, 4.7f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(4.71f, -4.7f);
        v12.curveToRelative(0.38f, -0.38f, 0.59f, -0.88f, 0.59f, -1.41f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2.29f);
        v12.curveToRelative(0.45f, 0f, 0.67f, -0.54f, 0.35f, -0.85f);
        v12.lineToRelative(-3.29f, -3.29f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineTo(8.35f, 7.15f);
        v12.curveToRelative(-0.31f, 0.31f, -0.09f, 0.85f, 0.36f, 0.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MergeTypeKt._mergeType = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.MergeType", replaceWith="<_subannotation>") public static void getMergeType$annotations(Rounded arg0) {
    }
}

