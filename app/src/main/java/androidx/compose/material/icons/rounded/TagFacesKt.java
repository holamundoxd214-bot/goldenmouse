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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tagFaces", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TagFaces", "Landroidx/compose/material/icons/Icons$Rounded;", "getTagFaces", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TagFacesKt {
    private static ImageVector _tagFaces;

    static {
    }

    public static final ImageVector getTagFaces(Rounded arg19) {
        ImageVector v0 = TagFacesKt._tagFaces;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TagFaces", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.99f, 2f);
        v12.curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.47f, 10f, 9.99f, 10f);
        v12.curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f);
        v12.reflectiveCurveTo(17.52f, 2f, 11.99f, 2f);
        v12.close();
        v12.moveTo(8.5f, 8f);
        v12.curveTo(9.33f, 8f, 10f, 8.67f, 10f, 9.5f);
        v12.reflectiveCurveTo(9.33f, 11f, 8.5f, 11f);
        v12.reflectiveCurveTo(7f, 10.33f, 7f, 9.5f);
        v12.reflectiveCurveTo(7.67f, 8f, 8.5f, 8f);
        v12.close();
        v12.moveTo(16.75f, 14.75f);
        v12.curveTo(15.8f, 16.389999f, 14.03f, 17.5f, 12f, 17.5f);
        v12.reflectiveCurveToRelative(-3.8f, -1.11f, -4.75f, -2.75f);
        v12.curveTo(7.06f, 14.42f, 7.31f, 14f, 7.69f, 14f);
        v12.horizontalLineToRelative(8.62f);
        v12.curveTo(16.700001f, 14f, 16.940001f, 14.42f, 16.75f, 14.75f);
        v12.close();
        v12.moveTo(15.5f, 11f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(14.67f, 8f, 15.5f, 8f);
        v12.reflectiveCurveTo(17f, 8.67f, 17f, 9.5f);
        v12.reflectiveCurveTo(16.33f, 11f, 15.5f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TagFacesKt._tagFaces = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

