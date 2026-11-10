package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout$Alignment;
import android.text.Layout;
import android.text.TextPaint;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0000\u001A\u001E\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0000\"\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "EllipsisChar", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IndentationFixSpan_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Layout$Alignment.values().length];
            try {
                v0[Layout$Alignment.ALIGN_CENTER.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                WhenMappings.$EnumSwitchMapping$0 = v0;
                return;
            }
        }
    }

    private static final String EllipsisChar = "…";

    public static final float getEllipsizedLeftPadding(Layout arg4, int arg5, Paint arg6) {
        float v4;
        float v5_1;
        float v0 = arg4.getLineLeft(arg5);
        if((TextLayout_androidKt.isLineEllipsized(arg4, arg5)) && arg4.getParagraphDirection(arg5) == 1 && v0 < 0f) {
            float v1 = arg4.getPrimaryHorizontal(arg4.getLineStart(arg5) + arg4.getEllipsisStart(arg5)) - v0 + arg6.measureText("…");
            Layout$Alignment v5 = arg4.getParagraphAlignment(arg5);
            arg5 = v5 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v5.ordinal()];
            if(arg5 == 1) {
                v5_1 = Math.abs(v0);
                v4 = ((((float)arg4.getWidth())) - v1) / 2f;
            }
            else {
                v5_1 = Math.abs(v0);
                v4 = (((float)arg4.getWidth())) - v1;
            }

            return v5_1 + v4;
        }

        return 0;
    }

    public static float getEllipsizedLeftPadding$default(Layout arg0, int arg1, Paint arg2, int arg3, Object arg4) {
        TextPaint v2;
        if((arg3 & 2) != 0) {
            v2 = arg0.getPaint();
        }

        return IndentationFixSpan_androidKt.getEllipsizedLeftPadding(arg0, arg1, ((Paint)v2));
    }

    public static final float getEllipsizedRightPadding(Layout arg3, int arg4, Paint arg5) {
        float v3;
        float v5_1;
        if(TextLayout_androidKt.isLineEllipsized(arg3, arg4)) {
            int v1 = -1;
            if(arg3.getParagraphDirection(arg4) == v1 && (((float)arg3.getWidth())) < arg3.getLineRight(arg4)) {
                float v2 = arg3.getLineRight(arg4) - arg3.getPrimaryHorizontal(arg3.getLineStart(arg4) + arg3.getEllipsisStart(arg4)) + arg5.measureText("…");
                Layout$Alignment v5 = arg3.getParagraphAlignment(arg4);
                if(v5 == null) {
                }
                else {
                    v1 = WhenMappings.$EnumSwitchMapping$0[v5.ordinal()];
                }

                if(v1 == 1) {
                    v5_1 = (((float)arg3.getWidth())) - arg3.getLineRight(arg4);
                    v3 = ((((float)arg3.getWidth())) - v2) / 2f;
                }
                else {
                    v5_1 = (((float)arg3.getWidth())) - arg3.getLineRight(arg4);
                    v3 = (((float)arg3.getWidth())) - v2;
                }

                return v5_1 - v3;
            }
        }

        return 0;
    }

    public static float getEllipsizedRightPadding$default(Layout arg0, int arg1, Paint arg2, int arg3, Object arg4) {
        TextPaint v2;
        if((arg3 & 2) != 0) {
            v2 = arg0.getPaint();
        }

        return IndentationFixSpan_androidKt.getEllipsizedRightPadding(arg0, arg1, ((Paint)v2));
    }
}

