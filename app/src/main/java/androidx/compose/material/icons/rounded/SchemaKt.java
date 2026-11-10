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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_schema", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Schema", "Landroidx/compose/material/icons/Icons$Rounded;", "getSchema", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SchemaKt {
    private static ImageVector _schema;

    static {
    }

    public static final ImageVector getSchema(Rounded arg19) {
        ImageVector v0 = SchemaKt._schema;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Schema", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 10.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveTo(11f, 9.67f, 10.33f, 9f, 9.5f, 9f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(1f);
        v12.curveTo(10.33f, 7f, 11f, 6.33f, 11f, 5.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(11f, 1.67f, 10.33f, 1f, 9.5f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(4.67f, 1f, 4f, 1.67f, 4f, 2.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(4f, 6.33f, 4.67f, 7f, 5.5f, 7f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-1f);
        v12.curveTo(4.67f, 9f, 4f, 9.67f, 4f, 10.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(4f, 14.33f, 4.67f, 15f, 5.5f, 15f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-1f);
        v12.curveTo(4.67f, 17f, 4f, 17.67f, 4f, 18.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(4f, 22.33f, 4.67f, 23f, 5.5f, 23f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(0.5f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(21f, 9.67f, 20.33f, 9f, 19.5f, 9f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(14.67f, 9f, 14f, 9.67f, 14f, 10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SchemaKt._schema = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

