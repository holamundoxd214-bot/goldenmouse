package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001B\u0010\u000E\u001A\u00060\u000Fj\u0002`\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\f¨\u0006\u001D"}, d2={"Landroidx/compose/ui/graphics/CompositeShaderBrush;", "Landroidx/compose/ui/graphics/ShaderBrush;", "dstBrush", "srcBrush", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "<init>", "(Landroidx/compose/ui/graphics/ShaderBrush;Landroidx/compose/ui/graphics/ShaderBrush;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDstBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", "getSrcBrush", "getBlendMode-0nO6VwU", "()I", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CompositeShaderBrush extends ShaderBrush {
    public static final int $stable;
    private final int blendMode;
    private final ShaderBrush dstBrush;
    private final ShaderBrush srcBrush;

    static {
    }

    public CompositeShaderBrush(ShaderBrush arg1, ShaderBrush arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private CompositeShaderBrush(ShaderBrush arg1, ShaderBrush arg2, int arg3) {
        super();
        this.dstBrush = arg1;
        this.srcBrush = arg2;
        this.blendMode = arg3;
    }

    public Shader createShader-uvyYCjk(long arg3) {
        return ShaderKt.CompositeShader-7EN7VTw(this.dstBrush.createShader-uvyYCjk(arg3), this.srcBrush.createShader-uvyYCjk(arg3), this.blendMode);
    }

    public boolean equals(Object arg5) {
        if(this == (((CompositeShaderBrush)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CompositeShaderBrush)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.dstBrush, ((CompositeShaderBrush)arg5).dstBrush)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.srcBrush, ((CompositeShaderBrush)arg5).srcBrush)) {
            return 0;
        }

        if(!BlendMode.equals-impl0(this.blendMode, ((CompositeShaderBrush)arg5).blendMode)) {
            return 0;
        }

        return 1;
    }

    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public final ShaderBrush getDstBrush() {
        return this.dstBrush;
    }

    public final ShaderBrush getSrcBrush() {
        return this.srcBrush;
    }

    public int hashCode() {
        return (this.dstBrush.hashCode() * 0x1F + this.srcBrush.hashCode()) * 0x1F + BlendMode.hashCode-impl(this.blendMode);
    }

    public String toString() {
        return "CompositeShaderBrush(dstBrush=" + this.dstBrush + ", srcBrush=" + this.srcBrush + ", blendMode=" + BlendMode.toString-impl(this.blendMode) + ')';
    }
}

