package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A2\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001A\u00020\tH\u0000\u001A8\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\tH\u0000\u001A2\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\'\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u0017\u0010\u0010\u001A\u00020\u00012\n\u0010\u0011\u001A\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"toShaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "lerpColorList", "", "Landroidx/compose/ui/graphics/Color;", "left", "right", "t", "", "lerpNullableFloatList", "lerpFloatList", "lerpSafe", "Landroidx/compose/ui/geometry/Offset;", "lerpSafe-Wko1d7g", "(JJF)J", "ShaderBrush", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "(Landroid/graphics/Shader;)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BrushKt {
    public static final ShaderBrush ShaderBrush(Shader arg1) {
        return new BrushKt$ShaderBrush$1(arg1);
    }

    public static final List lerpColorList(List arg7, List arg8, float arg9) {
        int v0 = Math.max(arg7.size(), arg8.size());
        ArrayList v1 = new ArrayList(v0);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1.add(Color.box-impl(ColorKt.lerp-jxsXWHM(arg7.get(Math.min(v2, arg7.size() - 1)).unbox-impl(), arg8.get(Math.min(v2, arg8.size() - 1)).unbox-impl(), arg9)));
        }

        return ((List)v1);
    }

    public static final List lerpFloatList(List arg5, List arg6, float arg7) {
        int v0 = Math.max(arg5.size(), arg6.size());
        ArrayList v1 = new ArrayList(v0);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1.add(Float.valueOf(MathHelpersKt.lerp(arg5.get(Math.min(v2, arg5.size() - 1)).floatValue(), arg6.get(Math.min(v2, arg6.size() - 1)).floatValue(), arg7)));
        }

        return ((List)v1);
    }

    public static final List lerpNullableFloatList(List arg0, List arg1, float arg2) {
        if(arg1 != null) {
            if(arg0 == null) {
            }
            else {
                return BrushKt.lerpFloatList(arg0, arg1, arg2);
            }
        }

        return null;
    }

    public static final long lerpSafe-Wko1d7g(long arg10, long arg12, float arg14) {
        long v0 = 0x7F8000007F800000L;
        long v4 = 0x100000001L;
        long v6 = -9223372034707292160L;
        long v8 = 0;
        if(((arg10 & v0 ^ v0) - v4 & v6) == v8 && ((v0 ^ arg12 & v0) - v4 & v6) == v8) {
            return OffsetKt.lerp-Wko1d7g(arg10, arg12, arg14);
        }

        if(arg14 < 0.5f) {
            return arg10;
        }

        return arg12;
    }

    public static final ShaderBrush toShaderBrush(Brush arg8) {
        if((arg8 instanceof ShaderBrush)) {
            return arg8;
        }

        if((arg8 instanceof SolidColor)) {
            arg8 = Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(((SolidColor)arg8).getValue-0d7_KjU()), Color.box-impl(((SolidColor)arg8).getValue-0d7_KjU())}), 0f, 0f, 0, 14, null);
            Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type androidx.compose.ui.graphics.ShaderBrush");
            return ((ShaderBrush)arg8);
        }

        throw new NoWhenBranchMatchedException();
    }
}

