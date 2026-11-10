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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_offlineShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OfflineShare", "Landroidx/compose/material/icons/Icons$Rounded;", "getOfflineShare$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getOfflineShare", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OfflineShareKt {
    private static ImageVector _offlineShare;

    static {
    }

    public static final ImageVector getOfflineShare(Rounded arg19) {
        ImageVector v0 = OfflineShareKt._offlineShare;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.OfflineShare", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 5f);
        v12.lineTo(5f, 5f);
        v12.curveTo(4.45f, 5f, 4f, 5.45f, 4f, 6f);
        v12.verticalLineToRelative(15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(9f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(6f);
        v12.curveTo(6f, 5.45f, 5.55f, 5f, 5f, 5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 1f);
        v12.horizontalLineToRelative(-8f);
        v12.curveTo(8.9f, 1f, 8f, 1.9f, 8f, 3f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3f);
        v12.curveTo(20f, 1.9f, 19.1f, 1f, 18f, 1f);
        v12.close();
        v12.moveTo(18f, 15f);
        v12.horizontalLineToRelative(-8f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(15f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12.5f, 10.25f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(0.54f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(1.29f, -1.29f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-1.29f, -1.29f);
        v12.curveToRelative(-0.31f, -0.31f, -0.85f, -0.09f, -0.85f, 0.35f);
        v12.verticalLineToRelative(0.54f);
        v12.horizontalLineTo(12f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f);
        v12.verticalLineTo(10.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OfflineShareKt._offlineShare = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Rounded.OfflineShare", replaceWith="<_subannotation>") public static void getOfflineShare$annotations(Rounded arg0) {
    }
}

