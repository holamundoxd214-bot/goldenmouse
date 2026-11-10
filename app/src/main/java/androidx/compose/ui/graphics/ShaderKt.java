package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AK\u0010\u0000\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000E\u001AK\u0010\u000F\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\n2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013\u001A9\u0010\u0014\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001A\u00020\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001A-\u0010\u0017\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\f2\b\b\u0002\u0010\u001B\u001A\u00020\f¢\u0006\u0004\b\u001C\u0010\u001D\u001A1\u0010\u001E\u001A\u00060\u0001j\u0002`\u00022\n\u0010\u001F\u001A\u00060\u0001j\u0002`\u00022\n\u0010 \u001A\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001A\u00020\"¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2={"LinearGradientShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "CompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "CompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShaderKt {
    public static final Shader CompositeShader-7EN7VTw(Shader arg0, Shader arg1, int arg2) {
        return AndroidShader_androidKt.ActualCompositeShader-7EN7VTw(arg0, arg1, arg2);
    }

    public static final Shader ImageShader-F49vj9s(ImageBitmap arg0, int arg1, int arg2) {
        return AndroidShader_androidKt.ActualImageShader-F49vj9s(arg0, arg1, arg2);
    }

    public static Shader ImageShader-F49vj9s$default(ImageBitmap arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = TileMode.Companion.getClamp-3opZhB0();
        }

        if((arg3 & 4) != 0) {
            arg2 = TileMode.Companion.getClamp-3opZhB0();
        }

        return ShaderKt.ImageShader-F49vj9s(arg0, arg1, arg2);
    }

    public static final Shader LinearGradientShader-VjE6UOU(long arg0, long arg2, List arg4, List arg5, int arg6) {
        return AndroidShader_androidKt.ActualLinearGradientShader-VjE6UOU(arg0, arg2, arg4, arg5, arg6);
    }

    public static Shader LinearGradientShader-VjE6UOU$default(long arg7, long arg9, List arg11, List arg12, int arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg12 = null;
        }

        List v5 = arg12;
        if((arg14 & 16) != 0) {
            arg13 = TileMode.Companion.getClamp-3opZhB0();
        }

        return ShaderKt.LinearGradientShader-VjE6UOU(arg7, arg9, arg11, v5, arg13);
    }

    public static final Shader RadialGradientShader-8uybcMk(long arg0, float arg2, List arg3, List arg4, int arg5) {
        return AndroidShader_androidKt.ActualRadialGradientShader-8uybcMk(arg0, arg2, arg3, arg4, arg5);
    }

    public static Shader RadialGradientShader-8uybcMk$default(long arg6, float arg8, List arg9, List arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        List v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = TileMode.Companion.getClamp-3opZhB0();
        }

        return ShaderKt.RadialGradientShader-8uybcMk(arg6, arg8, arg9, v4, arg11);
    }

    public static final Shader SweepGradientShader-9KIMszo(long arg0, List arg2, List arg3) {
        return AndroidShader_androidKt.ActualSweepGradientShader-9KIMszo(arg0, arg2, arg3);
    }

    public static Shader SweepGradientShader-9KIMszo$default(long arg0, List arg2, List arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return ShaderKt.SweepGradientShader-9KIMszo(arg0, arg2, arg3);
    }
}

