package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000¨\u0006\u0005"}, d2={"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint arg2, float arg3) {
        if(!Float.isNaN(arg3)) {
            if(arg3 < 0f) {
                arg3 = 0f;
            }

            float v0 = 1f;
            if(0f > v0) {
                arg3 = v0;
            }

            arg2.setAlpha(Math.round(arg3 * 255f));
        }
    }
}

