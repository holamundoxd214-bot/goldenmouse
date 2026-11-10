package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint$FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001D\u001A\u00020\u0013J\u000E\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\rJ(\u0010 \u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\"2\u0006\u0010%\u001A\u00020\"H\u0014J\b\u0010&\u001A\u00020\u001AH\u0002J\u0010\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020)H\u0014R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0013@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/MarkerLabelView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "paint", "Landroid/text/TextPaint;", "bounds", "Landroid/graphics/Rect;", "metrics", "Landroid/graphics/Paint$FontMetrics;", "preferredSize", "", "readableSize", "names", "Lcom/TryJeanPc/goldenmouse/controls/MarkerLabel;", "markerScale", "value", "", "visibleText", "getVisibleText", "()Ljava/lang/String;", "textX", "baseline", "setLabel", "", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "fallback", "setMarkerScale", "scale", "onSizeChanged", "w", "", "h", "oldw", "oldh", "updateTextLayout", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MarkerLabelView extends View {
    public static final int $stable = 8;
    private float baseline;
    private final Rect bounds;
    private float markerScale;
    private final Paint$FontMetrics metrics;
    private MarkerLabel names;
    private final TextPaint paint;
    private final float preferredSize;
    private final float readableSize;
    private float textX;
    private String visibleText;

    static {
    }

    public MarkerLabelView(Context arg4) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        super(arg4);
        TextPaint v4 = new TextPaint(1);
        v4.setColor(Color.parseColor("#111111"));
        v4.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.paint = v4;
        this.bounds = new Rect();
        this.metrics = new Paint$FontMetrics();
        this.preferredSize = TypedValue.applyDimension(2, 15f, this.getResources().getDisplayMetrics());
        this.readableSize = TypedValue.applyDimension(2, 9f, this.getResources().getDisplayMetrics());
        this.names = new MarkerLabel("", null, 2, null);
        this.markerScale = 1f;
        this.visibleText = "";
    }

    public final String getVisibleText() {
        return this.visibleText;
    }

    protected void onDraw(Canvas arg4) {
        Intrinsics.checkNotNullParameter(arg4, "canvas");
        super.onDraw(arg4);
        arg4.drawText(this.visibleText, this.textX, this.baseline, this.paint);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.updateTextLayout();
    }

    public final void setLabel(InputBinding arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "fallback");
        this.names = MarkerLabel.Companion.fromBinding(arg2, arg3);
        this.setContentDescription(((CharSequence)arg3));
        this.updateTextLayout();
    }

    public final void setMarkerScale(float arg1) {
        this.markerScale = arg1;
        this.updateTextLayout();
    }

    private final void updateTextLayout() {
        if(this.getWidth() > 0) {
            if(this.getHeight() <= 0) {
            }
            else {
                float v0 = ((float)Math.min(this.getWidth(), this.getHeight()));
                float v1 = 0.76f * v0;
                float v2 = 0.42f * v0;
                v0 = Math.min(this.readableSize / this.markerScale, v0 * 0.28f);
                String v3 = this.names.getNormal();
                this.visibleText = v3;
                float v3_1 = MarkerLabelView.updateTextLayout$fittedSize(this, v1, v2, v3);
                if(v3_1 < v0) {
                    v3 = this.names.getCompact();
                    this.visibleText = v3;
                    v3_1 = MarkerLabelView.updateTextLayout$fittedSize(this, v1, v2, v3);
                }

                if(v3_1 < v0) {
                    this.paint.setTextSize(v0);
                    String v0_1 = TextUtils.ellipsize(this.visibleText, this.paint, v1, TextUtils$TruncateAt.END).toString();
                    this.visibleText = v0_1;
                    v3_1 = MarkerLabelView.updateTextLayout$fittedSize(this, v1, v2, v0_1);
                }

                this.paint.setTextSize(v3_1);
                this.paint.getTextBounds(this.visibleText, 0, this.visibleText.length(), this.bounds);
                this.textX = (((float)this.getWidth())) / 2f - this.bounds.exactCenterX();
                this.baseline = (((float)this.getHeight())) / 2f - this.bounds.exactCenterY();
                this.invalidate();
            }
        }
    }

    private static final boolean updateTextLayout$fits(MarkerLabelView arg3, float arg4, float arg5, String arg6, float arg7) {
        arg3.paint.setTextSize(arg7);
        arg3.paint.getTextBounds(arg6, 0, arg6.length(), arg3.bounds);
        arg3.paint.getFontMetrics(arg3.metrics);
        float v6 = Math.max(arg3.paint.measureText(arg6), ((float)arg3.bounds.width()));
        arg7 = Math.max(arg3.metrics.descent, ((float)arg3.bounds.bottom)) - Math.min(arg3.metrics.ascent, ((float)arg3.bounds.top));
        if(v6 <= arg4 && arg7 <= arg5) {
            return 1;
        }

        return 0;
    }

    private static final float updateTextLayout$fittedSize(MarkerLabelView arg5, float arg6, float arg7, String arg8) {
        if(MarkerLabelView.updateTextLayout$fits(arg5, arg6, arg7, arg8, arg5.preferredSize)) {
            return arg5.preferredSize;
        }

        float v0 = arg5.preferredSize;
        float v1 = 0f;
        int v2;
        for(v2 = 0; v2 < 12; ++v2) {
            float v3 = (v1 + v0) / 2f;
            if(MarkerLabelView.updateTextLayout$fits(arg5, arg6, arg7, arg8, v3)) {
                v1 = v3;
            }
            else {
                v0 = v3;
            }
        }

        return v1;
    }
}

