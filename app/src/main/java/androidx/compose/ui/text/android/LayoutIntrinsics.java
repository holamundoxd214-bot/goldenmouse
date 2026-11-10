package androidx.compose.ui.text.android;

import android.text.BoringLayout$Metrics;
import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001B\u001A\u00020\u000BH\u0002J\b\u0010\u001E\u001A\u00020\u000BH\u0002J\u001C\u0010\u001F\u001A\u00020\u000B2\b\b\u0002\u0010 \u001A\u00020\u00072\b\b\u0002\u0010!\u001A\u00020\u0007H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u000E8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001C\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001A¨\u0006\""}, d2={"Landroidx/compose/ui/text/android/LayoutIntrinsics;", "", "charSequence", "", "textPaint", "Landroid/text/TextPaint;", "textDirectionHeuristic", "", "<init>", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;I)V", "_maxIntrinsicWidth", "", "_minIntrinsicWidth", "_boringMetrics", "Landroid/text/BoringLayout$Metrics;", "boringMetricsIsInit", "", "_charSequenceForIntrinsicWidth", "charSequenceForIntrinsicWidth", "getCharSequenceForIntrinsicWidth", "()Ljava/lang/CharSequence;", "boringMetrics", "getBoringMetrics", "()Landroid/text/BoringLayout$Metrics;", "minIntrinsicWidth", "getMinIntrinsicWidth", "()F", "computeMinIntrinsicWidth", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "computeMaxIntrinsicWidth", "getDesiredWidth", "start", "end", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutIntrinsics {
    public static final int $stable = 8;
    private BoringLayout$Metrics _boringMetrics;
    private CharSequence _charSequenceForIntrinsicWidth;
    private float _maxIntrinsicWidth;
    private float _minIntrinsicWidth;
    private boolean boringMetricsIsInit;
    private final CharSequence charSequence;
    private final int textDirectionHeuristic;
    private final TextPaint textPaint;

    static {
    }

    public LayoutIntrinsics(CharSequence arg1, TextPaint arg2, int arg3) {
        super();
        this.charSequence = arg1;
        this.textPaint = arg2;
        this.textDirectionHeuristic = arg3;
        this._maxIntrinsicWidth = NaNf;
        this._minIntrinsicWidth = NaNf;
    }

    private final float computeMaxIntrinsicWidth() {
        BoringLayout$Metrics v0 = this.getBoringMetrics();
        int v0_1 = v0 != null ? v0.width : -1;
        float v0_2 = ((float)v0_1);
        if(v0_2 < 0f) {
            v0_2 = ((float)Math.ceil(((double)LayoutIntrinsics.getDesiredWidth$default(this, 0, 0, 3, null))));
        }

        if(LayoutIntrinsics_androidKt.access$shouldIncreaseMaxIntrinsic(v0_2, this.charSequence, this.textPaint)) {
            v0_2 += 0.5f;
        }

        return v0_2;
    }

    private final float computeMinIntrinsicWidth() {
        float v1_2;
        BreakIterator v0 = BreakIterator.getLineInstance(this.textPaint.getTextLocale());
        int v4 = 0;
        v0.setText(new CharSequenceCharacterIterator(this.charSequence, 0, this.charSequence.length()));
        int v3 = 10;
        PriorityQueue v1 = new PriorityQueue(v3, new LayoutIntrinsics$$ExternalSyntheticLambda0());
        int v2;
        for(v2 = v0.next(); true; v2 = v0.next()) {
            int v7 = v4;
            v4 = v2;
            v2 = v7;
            if(v4 == -1) {
                break;
            }

            if(v1.size() < v3) {
                v1.add(new Pair(Integer.valueOf(v2), Integer.valueOf(v4)));
            }
            else {
                Object v5 = v1.peek();
                if(v5 != null && ((Pair)v5).getSecond().intValue() - ((Pair)v5).getFirst().intValue() < v4 - v2) {
                    v1.poll();
                    v1.add(new Pair(Integer.valueOf(v2), Integer.valueOf(v4)));
                }
            }
        }

        if(v1.isEmpty()) {
            return 0;
        }

        Iterator v0_1 = ((Iterable)v1).iterator();
        if(v0_1.hasNext()) {
            Object v1_1 = v0_1.next();
            v1_2 = this.getDesiredWidth(((Pair)v1_1).component1().intValue(), ((Pair)v1_1).component2().intValue());
        }
        else {
            throw new NoSuchElementException();
        }

        while(v0_1.hasNext()) {
            Object v2_1 = v0_1.next();
            v1_2 = Math.max(v1_2, this.getDesiredWidth(((Pair)v2_1).component1().intValue(), ((Pair)v2_1).component2().intValue()));
        }

        return v1_2;
    }

    static final int computeMinIntrinsicWidth$lambda$0(Pair arg1, Pair arg2) {
        return arg1.getSecond().intValue() - arg1.getFirst().intValue() - (arg2.getSecond().intValue() - arg2.getFirst().intValue());
    }

    public final BoringLayout$Metrics getBoringMetrics() {
        if(!this.boringMetricsIsInit) {
            this._boringMetrics = BoringLayoutFactory.INSTANCE.measure(this.charSequence, this.textPaint, TextLayout_androidKt.getTextDirectionHeuristic(this.textDirectionHeuristic));
            this.boringMetricsIsInit = true;
        }

        return this._boringMetrics;
    }

    private final CharSequence getCharSequenceForIntrinsicWidth() {
        CharSequence v0 = this._charSequenceForIntrinsicWidth;
        if(v0 == null) {
            boolean v0_1 = LayoutIntrinsics_androidKt.access$getStripNonMetricAffectingCharSpans$p();
            CharSequence v1 = this.charSequence;
            if(v0_1) {
                v0 = LayoutIntrinsics_androidKt.access$stripNonMetricAffectingCharacterStyleSpans(v1);
                this._charSequenceForIntrinsicWidth = v0;
                return v0;
            }

            return v1;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private final float getDesiredWidth(int arg2, int arg3) {
        return Layout.getDesiredWidth(this.getCharSequenceForIntrinsicWidth(), arg2, arg3, this.textPaint);
    }

    static float getDesiredWidth$default(LayoutIntrinsics arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.getCharSequenceForIntrinsicWidth().length();
        }

        return arg0.getDesiredWidth(0, arg2);
    }

    public final float getMaxIntrinsicWidth() {
        if(!Float.isNaN(this._maxIntrinsicWidth)) {
            return this._maxIntrinsicWidth;
        }

        float v0 = this.computeMaxIntrinsicWidth();
        this._maxIntrinsicWidth = v0;
        return v0;
    }

    public final float getMinIntrinsicWidth() {
        if(!Float.isNaN(this._minIntrinsicWidth)) {
            return this._minIntrinsicWidth;
        }

        float v0 = this.computeMinIntrinsicWidth();
        this._minIntrinsicWidth = v0;
        return v0;
    }
}

