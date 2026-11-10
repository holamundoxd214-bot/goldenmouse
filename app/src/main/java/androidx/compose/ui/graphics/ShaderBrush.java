package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0011\u001A\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001A\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0005H\u0002J%\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D¢\u0006\u0004\b\u001E\u0010\u001FR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\bR*\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\t\u001A\u0004\u0018\u00010\n@FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0010\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006 "}, d2={"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "<init>", "()V", "internalTransformShader", "Landroidx/compose/ui/graphics/TransformShader;", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "value", "Landroidx/compose/ui/graphics/Matrix;", "transform", "getTransform-3i98HWw", "()[F", "setTransform-Q8lPUPs", "([F)V", "[F", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "obtainTransformShader", "applyTo", "", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ShaderBrush extends Brush {
    public static final int $stable;
    private long createdSize;
    private TransformShader internalTransformShader;
    private float[] transform;

    static {
    }

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public final void applyTo-Pq9zytI(long arg5, Paint arg7, float arg8) {
        TransformShader v0 = this.internalTransformShader;
        TransformShader v1 = null;
        if(v0 == null || !Size.equals-impl0(this.createdSize, arg5)) {
            if(Size.isEmpty-impl(arg5)) {
                this.internalTransformShader = v1;
                this.createdSize = Size.Companion.getUnspecified-NH-jbRc();
                v0 = v1;
            }
            else {
                v0 = this.obtainTransformShader();
                float[] v2 = this.transform;
                if(v2 != null) {
                    v0.transform-Q8lPUPs(v2);
                }

                v0.setShader(this.createShader-uvyYCjk(arg5));
                this.internalTransformShader = v0;
                this.createdSize = arg5;
            }
        }

        if(!Color.equals-impl0(arg7.getColor-0d7_KjU(), Color.Companion.getBlack-0d7_KjU())) {
            arg7.setColor-8_81llA(Color.Companion.getBlack-0d7_KjU());
        }

        Shader v4 = arg7.getShader();
        if(v0 != null) {
            Shader v5 = v0.getShader();
        }
        else {
            Object v5_1 = v1;
        }

        if(!Intrinsics.areEqual(v4, v5)) {
            if(v0 != null) {
                Shader v1_1 = v0.getShader();
            }

            arg7.setShader(((Shader)v1));
        }

        if(arg7.getAlpha() == arg8) {
            return;
        }

        arg7.setAlpha(arg8);
    }

    public abstract Shader createShader-uvyYCjk(long arg1);

    public final float[] getTransform-3i98HWw() {
        return this.transform;
    }

    private final TransformShader obtainTransformShader() {
        TransformShader v0 = this.internalTransformShader;
        if(v0 == null) {
            v0 = new TransformShader();
            this.internalTransformShader = v0;
        }

        return v0;
    }

    public final void setTransform-Q8lPUPs(float[] arg1) {
        this.transform = arg1;
        TransformShader v0 = this.internalTransformShader;
        if(v0 != null) {
            v0.transform-Q8lPUPs(arg1);
        }
    }
}

