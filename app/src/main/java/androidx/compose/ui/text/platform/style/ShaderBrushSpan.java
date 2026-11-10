package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "shaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "<init>", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getShaderBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", "getAlpha", "()F", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    public static final int $stable = 8;
    private final float alpha;
    private final ShaderBrush shaderBrush;
    private final State shaderState;
    private final MutableState size$delegate;

    static {
    }

    public ShaderBrushSpan(ShaderBrush arg2, float arg3) {
        super();
        this.shaderBrush = arg2;
        this.alpha = arg3;
        this.size$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getUnspecified-NH-jbRc()), null, 2, null);
        this.shaderState = SnapshotStateKt.derivedStateOf(new ShaderBrushSpan$$ExternalSyntheticLambda0(this));
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    public final long getSize-NH-jbRc() {
        return this.size$delegate.getValue().unbox-impl();
    }

    public final void setSize-uvyYCjk(long arg1) {
        this.size$delegate.setValue(Size.box-impl(arg1));
    }

    static final Shader shaderState$lambda$0(ShaderBrushSpan arg4) {
        if(arg4.getSize-NH-jbRc() == 0x7FC000007FC00000L) {
        }
        else {
            if(Size.isEmpty-impl(arg4.getSize-NH-jbRc())) {
                return null;
            }

            goto label_9;
        }

        return null;
    label_9:
        return arg4.shaderBrush.createShader-uvyYCjk(arg4.getSize-NH-jbRc());
    }

    public void updateDrawState(TextPaint arg2) {
        AndroidTextPaint_androidKt.setAlpha(arg2, this.alpha);
        arg2.setShader(this.shaderState.getValue());
    }
}

