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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doNotStep", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoNotStep", "Landroidx/compose/material/icons/Icons$Sharp;", "getDoNotStep", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoNotStepKt {
    private static ImageVector _doNotStep;

    static {
    }

    public static final ImageVector getDoNotStep(Sharp arg19) {
        ImageVector v0 = DoNotStepKt._doNotStep;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DoNotStep", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1.39f, 4.22f);
        v12.lineToRelative(8.24f, 8.24f);
        v12.lineToRelative(-0.69f, 0.72f);
        v12.lineTo(6.87f, 11.1f);
        v12.curveToRelative(-0.11f, 0.4f, -0.26f, 0.78f, -0.45f, 1.12f);
        v12.lineToRelative(1.75f, 1.75f);
        v12.lineToRelative(-0.69f, 0.72f);
        v12.lineToRelative(-1.63f, -1.63f);
        v12.curveToRelative(-0.24f, 0.29f, -0.5f, 0.56f, -0.77f, 0.8f);
        v12.lineToRelative(1.63f, 1.63f);
        v12.lineToRelative(-0.7f, 0.72f);
        v12.lineToRelative(-1.74f, -1.74f);
        v12.curveTo(2.83f, 15.43f, 1.34f, 15.82f, 1f, 15.92f);
        v12.lineTo(1f, 20f);
        v12.horizontalLineToRelative(9.5f);
        v12.lineToRelative(3.33f, -3.33f);
        v12.lineToRelative(5.94f, 5.94f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.close();
        v12.moveTo(18.51f, 15.68f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(4.48f, -4.48f);
        v12.lineTo(23f, 11.2f);
        v12.lineTo(18.51f, 15.68f);
        v12.close();
        v12.moveTo(20.879999f, 9.08f);
        v12.lineToRelative(-4.48f, 4.48f);
        v12.lineTo(9.3f, 6.47f);
        v12.lineTo(13.8f, 2f);
        v12.lineTo(20.879999f, 9.08f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoNotStepKt._doNotStep = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

