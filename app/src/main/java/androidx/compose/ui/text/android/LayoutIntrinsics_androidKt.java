package androidx.compose.ui.text.android;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002\u001A \u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0002\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0082D¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2={"stripNonMetricAffectingCharSpans", "", "getStripNonMetricAffectingCharSpans$annotations", "()V", "stripNonMetricAffectingCharacterStyleSpans", "", "charSequence", "shouldIncreaseMaxIntrinsic", "desiredWidth", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutIntrinsics_androidKt {
    private static final boolean stripNonMetricAffectingCharSpans = true;

    static {
    }

    public static final boolean access$getStripNonMetricAffectingCharSpans$p() {
        return LayoutIntrinsics_androidKt.stripNonMetricAffectingCharSpans;
    }

    public static final boolean access$shouldIncreaseMaxIntrinsic(float arg0, CharSequence arg1, TextPaint arg2) {
        return LayoutIntrinsics_androidKt.shouldIncreaseMaxIntrinsic(arg0, arg1, arg2);
    }

    public static final CharSequence access$stripNonMetricAffectingCharacterStyleSpans(CharSequence arg0) {
        return LayoutIntrinsics_androidKt.stripNonMetricAffectingCharacterStyleSpans(arg0);
    }

    private static void getStripNonMetricAffectingCharSpans$annotations() {
    }

    private static final boolean shouldIncreaseMaxIntrinsic(float arg1, CharSequence arg2, TextPaint arg3) {
        if(arg1 == 0f) {
        }
        else {
            if((!(arg2 instanceof Spanned) || !SpannedExtensions_androidKt.hasSpan(((Spanned)arg2), LetterSpacingSpanPx.class) && !SpannedExtensions_androidKt.hasSpan(((Spanned)arg2), LetterSpacingSpanEm.class)) && arg3.getLetterSpacing() == 0f) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private static final CharSequence stripNonMetricAffectingCharacterStyleSpans(CharSequence arg6) {
        if((arg6 instanceof Spanned)) {
            CharSequence v0 = arg6;
            Class v1 = CharacterStyle.class;
            if(!SpannedExtensions_androidKt.hasSpan(((Spanned)v0), v1)) {
            }
            else {
                int v3 = 0;
                Object[] v0_1 = ((Spanned)v0).getSpans(0, arg6.length(), v1);
                if(v0_1 != null) {
                    if(v0_1.length == 0) {
                    }
                    else {
                        int v1_1 = v0_1.length;
                        SpannableString v2 = null;
                        while(v3 < v1_1) {
                            Object v4 = v0_1[v3];
                            if(!(v4 instanceof MetricAffectingSpan)) {
                                if(v2 == null) {
                                    v2 = new SpannableString(arg6);
                                }

                                v2.removeSpan(v4);
                            }

                            ++v3;
                        }

                        if(v2 == null) {
                            return arg6;
                        }

                        return ((CharSequence)v2);
                    }
                }
            }
        }

        return arg6;
    }
}

