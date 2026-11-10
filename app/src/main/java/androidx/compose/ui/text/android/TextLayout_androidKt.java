package androidx.compose.ui.text.android;

import android.graphics.Paint$FontMetricsInt;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0000\u001A\u001D\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0000¢\u0006\u0002\u0010\u000F\u001A\u0011\u0010\u0010\u001A\u00020\f*\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012\u001A\u0017\u0010\u0015\u001A\u00020\f*\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0002\u0010\u0018\u001A3\u0010\u0019\u001A\u0004\u0018\u00010\u001A*\u00020\u00112\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\b2\u000E\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001F\u001A\u0019\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016*\u00020\u0011H\u0002¢\u0006\u0002\u0010!\u001A\u0014\u0010\"\u001A\u00020#*\u00020$2\u0006\u0010%\u001A\u00020\nH\u0000\"\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u0010\u0010\u0013\u001A\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006&"}, d2={"SharedTextAndroidCanvas", "Ljava/lang/ThreadLocal;", "Landroidx/compose/ui/text/android/TextAndroidCanvas;", "getSharedTextAndroidCanvas$annotations", "()V", "getSharedTextAndroidCanvas", "()Ljava/lang/ThreadLocal;", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "", "VerticalPaddings", "Landroidx/compose/ui/text/android/VerticalPaddings;", "topPadding", "bottomPadding", "(II)J", "getVerticalPaddings", "Landroidx/compose/ui/text/android/TextLayout;", "(Landroidx/compose/ui/text/android/TextLayout;)J", "ZeroVerticalPadding", "J", "getLineHeightPaddings", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "([Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)J", "getLastLineMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "textPaint", "Landroid/text/TextPaint;", "frameworkTextDir", "lineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Landroid/graphics/Paint$FontMetricsInt;", "getLineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "isLineEllipsized", "", "Landroid/text/Layout;", "lineIndex", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLayout_androidKt {
    private static final ThreadLocal SharedTextAndroidCanvas;
    private static final long ZeroVerticalPadding;

    static {
        TextLayout_androidKt.SharedTextAndroidCanvas = new ThreadLocal();
        TextLayout_androidKt.ZeroVerticalPadding = TextLayout_androidKt.VerticalPaddings(0, 0);
    }

    public static final long VerticalPaddings(int arg4, int arg5) {
        return VerticalPaddings.constructor-impl((((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20);
    }

    public static final Paint$FontMetricsInt access$getLastLineMetrics(TextLayout arg0, TextPaint arg1, TextDirectionHeuristic arg2, LineHeightStyleSpan[] arg3) {
        return TextLayout_androidKt.getLastLineMetrics(arg0, arg1, arg2, arg3);
    }

    public static final long access$getLineHeightPaddings(LineHeightStyleSpan[] arg2) {
        return TextLayout_androidKt.getLineHeightPaddings(arg2);
    }

    public static final LineHeightStyleSpan[] access$getLineHeightSpans(TextLayout arg0) {
        return TextLayout_androidKt.getLineHeightSpans(arg0);
    }

    public static final long access$getVerticalPaddings(TextLayout arg2) {
        return TextLayout_androidKt.getVerticalPaddings(arg2);
    }

    public static final long access$getZeroVerticalPadding$p() {
        return TextLayout_androidKt.ZeroVerticalPadding;
    }

    private static final Paint$FontMetricsInt getLastLineMetrics(TextLayout arg29, TextPaint arg30, TextDirectionHeuristic arg31, LineHeightStyleSpan[] arg32) {
        LineHeightStyleSpan[] v0 = arg32;
        int v1 = arg29.getLineCount() - 1;
        if(arg29.getLayout().getLineStart(v1) == arg29.getLayout().getLineEnd(v1) && v0 != null) {
            if(v0.length == 0) {
            }
            else {
                SpannableString v2 = new SpannableString("​");
                Object v0_1 = ArraysKt.first(((Object[])v0));
                int v3 = v2.length();
                boolean v1_1 = v1 == 0 || !((LineHeightStyleSpan)v0_1).getTrimLastLineBottom() ? ((LineHeightStyleSpan)v0_1).getTrimLastLineBottom() : false;
                v2.setSpan(((LineHeightStyleSpan)v0_1).copy$ui_text(0, v3, v1_1), 0, v2.length(), 33);
                StaticLayout v0_2 = StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, v2, arg30, 0x7FFFFFFF, 0, v2.length(), arg31, null, 0, null, 0, 0f, 0f, 0, arg29.getIncludePadding(), arg29.getFallbackLineSpacing(), 0, 0, 0, 0, null, null, 0x1F9FC0, null);
                Paint$FontMetricsInt v1_2 = new Paint$FontMetricsInt();
                v1_2.ascent = v0_2.getLineAscent(0);
                v1_2.descent = v0_2.getLineDescent(0);
                v1_2.top = v0_2.getLineTop(0);
                v1_2.bottom = v0_2.getLineBottom(0);
                return v1_2;
            }
        }

        return null;
    }

    private static final long getLineHeightPaddings(LineHeightStyleSpan[] arg6) {
        int v0 = arg6.length;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v1 < v0) {
            LineHeightStyleSpan v4 = arg6[v1];
            if(v4.getFirstAscentDiff() < 0) {
                v2 = Math.max(v2, Math.abs(v4.getFirstAscentDiff()));
            }

            if(v4.getLastDescentDiff() < 0) {
                v3 = Math.max(v2, Math.abs(v4.getLastDescentDiff()));
            }

            ++v1;
        }

        if(v2 == 0 && v3 == 0) {
            return TextLayout_androidKt.ZeroVerticalPadding;
        }

        return TextLayout_androidKt.VerticalPaddings(v2, v3);
    }

    private static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout arg4) {
        LineHeightStyleSpan[] v1 = null;
        if(!(arg4.getText() instanceof Spanned)) {
            return v1;
        }

        CharSequence v0 = arg4.getText();
        String v2 = "null cannot be cast to non-null type android.text.Spanned";
        Intrinsics.checkNotNull(v0, v2);
        Class v3 = LineHeightStyleSpan.class;
        if(!SpannedExtensions_androidKt.hasSpan(((Spanned)v0), v3) && arg4.getText().length() > 0) {
            return v1;
        }

        v0 = arg4.getText();
        Intrinsics.checkNotNull(v0, v2);
        return ((Spanned)v0).getSpans(0, arg4.getText().length(), v3);
    }

    public static final ThreadLocal getSharedTextAndroidCanvas() {
        return TextLayout_androidKt.SharedTextAndroidCanvas;
    }

    public static void getSharedTextAndroidCanvas$annotations() {
    }

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        if(arg1 != 4) {
                            if(arg1 != 5) {
                                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            }

                            return TextDirectionHeuristics.LOCALE;
                        }

                        return TextDirectionHeuristics.ANYRTL_LTR;
                    }

                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }

                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            return TextDirectionHeuristics.RTL;
        }

        return TextDirectionHeuristics.LTR;
    }

    private static final long getVerticalPaddings(TextLayout arg7) {
        if(!arg7.getIncludePadding()) {
            if(arg7.isFallbackLinespacingApplied$ui_text()) {
            }
            else {
                TextPaint v0 = arg7.getLayout().getPaint();
                CharSequence v1 = arg7.getLayout().getText();
                Rect v2 = PaintExtensions_androidKt.getCharSequenceBounds(v0, v1, arg7.getLayout().getLineStart(0), arg7.getLayout().getLineEnd(0));
                int v3 = arg7.getLayout().getLineAscent(0);
                if(v2.top < v3) {
                    v3 -= v2.top;
                }
                else {
                    v3 = arg7.getLayout().getTopPadding();
                }

                if(arg7.getLineCount() == 1) {
                }
                else {
                    int v2_1 = arg7.getLineCount() - 1;
                    v2 = PaintExtensions_androidKt.getCharSequenceBounds(v0, v1, arg7.getLayout().getLineStart(v2_1), arg7.getLayout().getLineEnd(v2_1));
                }

                int v0_1 = arg7.getLayout().getLineDescent(arg7.getLineCount() - 1);
                int v7 = v2.bottom > v0_1 ? v2.bottom - v0_1 : arg7.getLayout().getBottomPadding();
                if(v3 == 0 && v7 == 0) {
                    return TextLayout_androidKt.ZeroVerticalPadding;
                }

                return TextLayout_androidKt.VerticalPaddings(v3, v7);
            }
        }

        return TextLayout_androidKt.ZeroVerticalPadding;
    }

    public static final boolean isLineEllipsized(Layout arg0, int arg1) {
        if(arg0.getEllipsisCount(arg1) > 0) {
            return 1;
        }

        return 0;
    }
}

