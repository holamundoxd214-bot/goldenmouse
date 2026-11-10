package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\u001AH\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0000\u001AV\u0010\u000E\u001A\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u00112\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0012\u001A\u00020\rH\u0002\u001Af\u0010\u0013\u001A\u00020\n*\u00020\u00142\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0010\u001A\u00020\u00112\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u001Af\u0010\u001D\u001A\u00020\n*\u00020\u00142\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0010\u001A\u00020\u00112\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u001A \u0010\u001E\u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002\u001A \u0010 \u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002\u001A\u001C\u0010!\u001A\u00020\r*\u00020\b2\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020\u0019H\u0002¨\u0006$"}, d2={"getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "rect", "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "getStart", "getStartOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "lineStart", "lineTop", "lineBottom", "runLeft", "", "runRight", "horizontalBounds", "", "getEndOffsetForRectWithinRun", "getCharacterLeftBounds", "offset", "getCharacterRightBounds", "horizontalOverlap", "left", "right", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int arg0, int arg1, float[] arg2) {
        return arg2[(arg0 - arg1) * 2];
    }

    private static final float getCharacterRightBounds(int arg0, int arg1, float[] arg2) {
        return arg2[(arg0 - arg1) * 2 + 1];
    }

    private static final int getEndOffsetForRectWithinRun(BidiRun arg5, RectF arg6, int arg7, int arg8, int arg9, float arg10, float arg11, float[] arg12, SegmentFinder arg13, Function2 arg14) {
        int v11;
        int v10;
        int v1 = -1;
        if(!TextLayoutGetRangeForRectExtensions_androidKt.horizontalOverlap(arg6, arg10, arg11)) {
            return v1;
        }

        if((arg5.isRtl()) || arg6.right < arg11) {
            if((arg5.isRtl()) && arg6.left <= arg10) {
            label_13:
                v10 = arg5.getEnd() - 1;
                goto label_38;
            }

            v10 = arg5.getStart();
            v11 = arg5.getEnd();
            while(v11 - v10 > 1) {
                int v0 = (v11 + v10) / 2;
                float v3 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v0, arg7, arg12);
                if(!arg5.isRtl() && v3 > arg6.right || (arg5.isRtl()) && v3 < arg6.left) {
                    v11 = v0;
                    continue;
                }

                v10 = v0;
            }

            if(!arg5.isRtl()) {
                goto label_38;
            }

            v10 = v11;
        }
        else {
            goto label_13;
        }

    label_38:
        v10 = arg13.previousStartBoundary(v10 + 1);
        if(v10 == v1) {
            return v1;
        }

        v11 = arg13.nextEndBoundary(v10);
        if(v11 <= arg5.getStart()) {
            return v1;
        }

        v10 = RangesKt.coerceAtLeast(v10, arg5.getStart());
        v11 = RangesKt.coerceAtMost(v11, arg5.getEnd());
        RectF v0_1 = new RectF(0f, ((float)arg8), 0f, ((float)arg9));
        while(true) {
            float v8 = arg5.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v11 - 1, arg7, arg12) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v10, arg7, arg12);
            v0_1.left = v8;
            v8 = arg5.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v10, arg7, arg12) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v11 - 1, arg7, arg12);
            v0_1.right = v8;
            if(arg14.invoke(v0_1, arg6).booleanValue()) {
                return v11;
            }

            v11 = arg13.previousEndBoundary(v11);
            if(v11 != v1) {
                if(v11 <= arg5.getStart()) {
                }
                else {
                    v10 = RangesKt.coerceAtLeast(arg13.previousStartBoundary(v11), arg5.getStart());
                    continue;
                }
            }

            return v1;
        }

        return v1;
    }

    public static final int[] getRangeForRect(TextLayout arg10, Layout arg11, LayoutHelper arg12, RectF arg13, int arg14, Function2 arg15) {
        SegmentFinder v14_1;
        if(arg14 == 1) {
            WordSegmentFinder v14 = new WordSegmentFinder(arg10.getText(), arg10.getWordIterator());
        }
        else {
            v14_1 = SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(arg10.getText(), arg10.getTextPaint());
        }

        WordSegmentFinder v6 = ((WordSegmentFinder)v14_1);
        arg14 = arg11.getLineForVertical(((int)arg13.top));
        int[] v9 = null;
        if(Float.compare(arg13.top, arg10.getLineBottom(arg14)) > 0) {
            ++arg14;
            if(arg14 >= arg10.getLineCount()) {
                return v9;
            }
        }

        int v4 = arg14;
        arg14 = arg11.getLineForVertical(((int)arg13.bottom));
        if(arg14 == 0 && arg13.bottom < arg10.getLineTop(0)) {
            return v9;
        }

        TextLayout v1 = arg10;
        Layout v2 = arg11;
        LayoutHelper v3 = arg12;
        RectF v5 = arg13;
        Function2 v7 = arg15;
        int v10 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(v1, v2, v3, v4, v5, ((SegmentFinder)v6), v7, true);
        while(true) {
            int v11 = v4;
            int v12 = -1;
            if(v10 == v12 && v11 < arg14) {
                v4 = v11 + 1;
                v10 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(v1, v2, v3, v4, v5, ((SegmentFinder)v6), v7, true);
                continue;
            }

            break;
        }

        if(v10 == v12) {
            return v9;
        }

        int v13 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(v1, v2, v3, arg14, v5, ((SegmentFinder)v6), v7, false);
        while(v13 == v12) {
            if(v11 >= arg14) {
                break;
            }

            v4 = arg14 - 1;
            v13 = TextLayoutGetRangeForRectExtensions_androidKt.getStartOrEndOffsetForRectWithinLine(v1, v2, v3, v4, v5, ((SegmentFinder)v6), v7, false);
            arg14 = v4;
        }

        if(v13 == v12) {
            return v9;
        }

        return new int[]{((SegmentFinder)v6).previousStartBoundary(v10 + 1), ((SegmentFinder)v6).nextEndBoundary(v13 - 1)};
    }

    private static final int getStartOffsetForRectWithinRun(BidiRun arg4, RectF arg5, int arg6, int arg7, int arg8, float arg9, float arg10, float[] arg11, SegmentFinder arg12, Function2 arg13) {
        int v10;
        int v9;
        int v1 = -1;
        if(!TextLayoutGetRangeForRectExtensions_androidKt.horizontalOverlap(arg5, arg9, arg10)) {
            return v1;
        }

        if((arg4.isRtl()) || arg5.left > arg9) {
            if((arg4.isRtl()) && arg5.right >= arg10) {
            label_12:
                v9 = arg4.getStart();
                goto label_37;
            }

            v9 = arg4.getStart();
            v10 = arg4.getEnd();
            while(v10 - v9 > 1) {
                int v0 = (v10 + v9) / 2;
                float v2 = TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v0, arg6, arg11);
                if(!arg4.isRtl() && v2 > arg5.left || (arg4.isRtl()) && v2 < arg5.right) {
                    v10 = v0;
                    continue;
                }

                v9 = v0;
            }

            if(!arg4.isRtl()) {
                goto label_37;
            }

            v9 = v10;
        }
        else {
            goto label_12;
        }

    label_37:
        v9 = arg12.nextEndBoundary(v9);
        if(v9 == v1) {
            return v1;
        }

        v10 = arg12.previousStartBoundary(v9);
        if(v10 >= arg4.getEnd()) {
            return v1;
        }

        v10 = RangesKt.coerceAtLeast(v10, arg4.getStart());
        v9 = RangesKt.coerceAtMost(v9, arg4.getEnd());
        RectF v0_1 = new RectF(0f, ((float)arg7), 0f, ((float)arg8));
        while(true) {
            float v7 = arg4.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v9 - 1, arg6, arg11) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v10, arg6, arg11);
            v0_1.left = v7;
            v7 = arg4.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v10, arg6, arg11) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v9 - 1, arg6, arg11);
            v0_1.right = v7;
            if(arg13.invoke(v0_1, arg5).booleanValue()) {
                return v10;
            }

            v10 = arg12.nextStartBoundary(v10);
            if(v10 != v1) {
                if(v10 >= arg4.getEnd()) {
                }
                else {
                    v9 = RangesKt.coerceAtMost(arg12.nextEndBoundary(v10), arg4.getEnd());
                    continue;
                }
            }

            return v1;
        }

        return v1;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout arg14, Layout arg15, LayoutHelper arg16, int arg17, RectF arg18, SegmentFinder arg19, Function2 arg20, boolean arg21) {
        IntProgression v0_2;
        int v1 = arg17;
        int v3 = arg15.getLineTop(v1);
        int v4 = arg15.getLineBottom(v1);
        int v2 = arg15.getLineStart(v1);
        int v0 = arg15.getLineEnd(v1);
        int v10 = -1;
        if(v2 == v0) {
            return v10;
        }

        float[] v7 = new float[(v0 - v2) * 2];
        arg14.fillLineHorizontalBounds$ui_text(v1, v7);
        BidiRun[] v14 = arg16.getLineBidiRuns$ui_text(arg17);
        if(arg21) {
            IntRange v0_1 = ArraysKt.getIndices(((Object[])v14));
        }
        else {
            v0_2 = RangesKt.downTo(ArraysKt.getLastIndex(((Object[])v14)), 0);
        }

        v1 = v0_2.getFirst();
        int v11 = v0_2.getLast();
        int v12 = v0_2.getStep();
        if(v12 > 0 && v1 <= v11 || v12 < 0 && v11 <= v1) {
            int v13;
            for(v13 = v1; true; v13 += v12) {
                BidiRun v0_3 = v14[v13];
                float v1_1 = v0_3.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v0_3.getEnd() - 1, v2, v7) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterLeftBounds(v0_3.getStart(), v2, v7);
                float v5 = v1_1;
                v1_1 = v0_3.isRtl() ? TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v0_3.getStart(), v2, v7) : TextLayoutGetRangeForRectExtensions_androidKt.getCharacterRightBounds(v0_3.getEnd() - 1, v2, v7);
                float v6 = v1_1;
                v0 = arg21 ? TextLayoutGetRangeForRectExtensions_androidKt.getStartOffsetForRectWithinRun(v0_3, arg18, v2, v3, v4, v5, v6, v7, arg19, arg20) : TextLayoutGetRangeForRectExtensions_androidKt.getEndOffsetForRectWithinRun(v0_3, arg18, v2, v3, v4, v5, v6, v7, arg19, arg20);
                if(v0 >= 0) {
                    return v0;
                }

                if(v13 == v11) {
                    return v10;
                }
            }
        }

        return v10;
    }

    private static final boolean horizontalOverlap(RectF arg1, float arg2, float arg3) {
        if(arg3 >= arg1.left && arg2 <= arg1.right) {
            return 1;
        }

        return 0;
    }
}

