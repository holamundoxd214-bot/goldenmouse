package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_rule", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Rule", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRule$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getRule", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RuleKt {
    private static ImageVector _rule;

    static {
    }

    public static final ImageVector getRule(TwoTone arg18) {
        ImageVector v0 = RuleKt._rule;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Rule", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(16.540001f, 11f);
        v0_1.lineTo(13f, 7.46f);
        v0_1.lineToRelative(1.41f, -1.41f);
        v0_1.lineToRelative(2.12f, 2.12f);
        v0_1.lineToRelative(4.24f, -4.24f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineTo(16.540001f, 11f);
        v0_1.close();
        v0_1.moveTo(11f, 7f);
        v0_1.horizontalLineTo(2f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(9f);
        v0_1.verticalLineTo(7f);
        v0_1.close();
        v0_1.moveTo(21f, 13.41f);
        v0_1.lineTo(19.59f, 12f);
        v0_1.lineTo(17f, 14.59f);
        v0_1.lineTo(14.41f, 12f);
        v0_1.lineTo(13f, 13.41f);
        v0_1.lineTo(15.59f, 16f);
        v0_1.lineTo(13f, 18.59f);
        v0_1.lineTo(14.41f, 20f);
        v0_1.lineTo(17f, 17.41f);
        v0_1.lineTo(19.59f, 20f);
        v0_1.lineTo(21f, 18.59f);
        v0_1.lineTo(18.41f, 16f);
        v0_1.lineTo(21f, 13.41f);
        v0_1.close();
        v0_1.moveTo(11f, 15f);
        v0_1.horizontalLineTo(2f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(9f);
        v0_1.verticalLineTo(15f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RuleKt._rule = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.Rule", replaceWith="<_subannotation>") public static void getRule$annotations(TwoTone arg0) {
    }
}

