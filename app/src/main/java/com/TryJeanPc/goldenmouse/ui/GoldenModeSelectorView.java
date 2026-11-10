package com.TryJeanPc.goldenmouse.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader$TileMode;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\'H\u0014J \u0010(\u001A\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*H\u0002J \u0010,\u001A\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u0010-\u001A\u00020\u001B2\u0006\u0010.\u001A\u00020\u000FH\u0002J(\u0010/\u001A\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u0010-\u001A\u00020\u001B2\u0006\u00100\u001A\u00020*2\u0006\u00101\u001A\u00020\u000FH\u0002J@\u00102\u001A\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u00103\u001A\u00020*2\u0006\u00104\u001A\u00020*2\u0006\u00105\u001A\u00020*2\u0006\u00106\u001A\u00020*2\u0006\u00100\u001A\u00020*2\u0006\u00101\u001A\u00020\u000FH\u0002R$\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u000F@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u000F@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/GoldenModeSelectorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation$Frame;", "frame", "getFrame$app", "()Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation$Frame;", "setFrame$app", "(Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation$Frame;)V", "", "accentColor", "getAccentColor$app", "()I", "setAccentColor$app", "(I)V", "selectedMode", "getSelectedMode$app", "setSelectedMode$app", "paint", "Landroid/graphics/Paint;", "body", "Landroid/graphics/Path;", "topPlate", "bottomPlate", "detail", "perimeter", "Landroid/graphics/PathMeasure;", "circuit", "graphite", "Landroid/graphics/LinearGradient;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawCircuit", "progress", "", "energy", "fill", "path", "color", "stroke", "width", "alpha", "line", "x1", "y1", "x2", "y2", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenModeSelectorView extends View {
    public static final int $stable = 8;
    private int accentColor;
    private final Path body;
    private final Path bottomPlate;
    private final Path circuit;
    private final Path detail;
    private Frame frame;
    private final LinearGradient graphite;
    private final Paint paint;
    private final PathMeasure perimeter;
    private int selectedMode;
    private final Path topPlate;

    static {
    }

    public GoldenModeSelectorView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenModeSelectorView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenModeSelectorView(Context arg9, AttributeSet arg10) {
        Intrinsics.checkNotNullParameter(arg9, "context");
        super(arg9, arg10);
        this.frame = BlueMagicModeAnimation.INSTANCE.frameAt(900);
        this.accentColor = BlueMagicVisualMode.POWER_SAVING.getTint();
        Paint v9 = new Paint(1);
        v9.setStrokeJoin(Paint$Join.ROUND);
        this.paint = v9;
        Path v9_1 = new Path();
        v9_1.moveTo(13f, 3f);
        v9_1.lineTo(125f, 3f);
        v9_1.lineTo(137f, 15f);
        v9_1.lineTo(137f, 29f);
        v9_1.lineTo(125f, 41f);
        v9_1.lineTo(13f, 41f);
        v9_1.lineTo(3f, 31f);
        v9_1.lineTo(3f, 13f);
        v9_1.close();
        this.body = v9_1;
        Path v1 = new Path();
        v1.moveTo(7f, 13f);
        v1.lineTo(7f, 12f);
        v1.lineTo(14f, 6f);
        v1.lineTo(124f, 6f);
        v1.lineTo(131f, 13f);
        v1.close();
        this.topPlate = v1;
        Path v0 = new Path();
        v0.moveTo(7f, 31f);
        v0.lineTo(131f, 31f);
        v0.lineTo(124f, 38f);
        v0.lineTo(14f, 38f);
        v0.lineTo(7f, 31f);
        v0.close();
        this.bottomPlate = v0;
        this.detail = new Path();
        this.perimeter = new PathMeasure(v9_1, true);
        this.circuit = new Path();
        this.graphite = new LinearGradient(0f, 3f, 0f, 41f, new int[]{0xFF1B2935, 0xFF080E15, 0xFF101C26}, null, Shader$TileMode.CLAMP);
    }

    private final void drawCircuit(Canvas arg9, float arg10, float arg11) {
        float v0 = this.perimeter.getLength();
        int v1;
        for(v1 = 0; v1 < 2; ++v1) {
            float v2 = ((((float)v1)) * 0.5f + arg10) % 1f * v0;
            float v3 = 0.16f * v0 + v2;
            this.circuit.rewind();
            this.perimeter.getSegment(v2, RangesKt.coerceAtMost(v3, v0), this.circuit, true);
            if(v3 > v0) {
                this.perimeter.getSegment(0f, v3 - v0, this.circuit, true);
            }

            this.stroke(arg9, this.circuit, 4.5f, ((int)(30f * arg11)));
            this.stroke(arg9, this.circuit, 2.2f, ((int)(120f * arg11)));
            this.stroke(arg9, this.circuit, 0.9f, ((int)(255f * arg11)));
        }
    }

    private final void fill(Canvas arg3, Path arg4, int arg5) {
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setColor(arg5);
        arg3.drawPath(arg4, this.paint);
    }

    public final int getAccentColor$app() {
        return this.accentColor;
    }

    public final Frame getFrame$app() {
        return this.frame;
    }

    public final int getSelectedMode$app() {
        return this.selectedMode;
    }

    private final void line(Canvas arg4, float arg5, float arg6, float arg7, float arg8, float arg9, int arg10) {
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(arg9);
        this.paint.setColor(arg10 << 24 | this.accentColor & 0xFFFFFF);
        arg4.drawLine(arg5, arg6, arg7, arg8, this.paint);
    }

    protected void onDraw(Canvas arg22) {
        float v11;
        float v19;
        float v6;
        float v2;
        int v14;
        GoldenModeSelectorView v0 = this;
        Intrinsics.checkNotNullParameter(arg22, "canvas");
        super.onDraw(arg22);
        int v9 = arg22.save();
        arg22.scale((((float)v0.getWidth())) / 140f, (((float)v0.getHeight())) / 44f);
        v0.paint.setShader(v0.graphite);
        v0.fill(arg22, v0.body, -1);
        v0.paint.setShader(null);
        float v8 = 0.9f;
        v0.stroke(arg22, v0.body, v8, 0x7D);
        arg22.save();
        arg22.clipPath(v0.body);
        float v10 = v0.frame.getOpening() * 7.5f;
        arg22.save();
        arg22.translate(0f, -v10);
        v0.fill(arg22, v0.topPlate, 0xFF17212B);
        float v12 = 0.7f;
        v0.stroke(arg22, v0.topPlate, v12, 80);
        v0.line(arg22, 18f, 7.5f, 120f, 7.5f, 0.7f, 110);
        v0.line(arg22, 12f, 13f, 128f, 13f, 1.1f, 220);
        arg22.restore();
        arg22.save();
        arg22.translate(0f, v10);
        v0.fill(arg22, v0.bottomPlate, 0xFF111B25);
        v0.stroke(arg22, v0.bottomPlate, v12, 80);
        v0.line(arg22, 12f, 31f, 128f, 31f, 1.1f, 220);
        int v13;
        for(v13 = 0; true; ++v13) {
            v14 = 0xFF;
            if(v13 >= 3) {
                break;
            }

            v2 = 56f + (((float)v13)) * 10f;
            float v4 = v2 + 7f;
            if(v13 == v0.selectedMode) {
            }
            else {
                v14 = 45;
            }

            v0.line(arg22, v2, 35f, v4, 35f, 1.6f, v14);
        }

        Canvas v1 = arg22;
        v1.restore();
        float v13_1 = v0.frame.getScanProgress();
        float v15 = 4f;
        float v3 = 1f;
        v2 = v13_1 * v15 * (v3 - v13_1);
        int v7 = ((int)(190f * v2));
        int v16 = 0xFFFFFF;
        float v17 = 180f;
        if(v7 > 0) {
            float v5 = v13_1 * v17 - 20f;
            v0.detail.rewind();
            v0.detail.moveTo(v5, v15);
            v6 = 12f + v5;
            v0.detail.lineTo(v6, v15);
            v3 = v5 - 8f;
            v0.detail.lineTo(v3, 40f);
            v0.detail.lineTo(v5 - 20f, 40f);
            v0.detail.close();
            v0.fill(v1, v0.detail, v0.accentColor & v16 | v7 / 5 << 24);
            v10 = v2;
            v19 = 0f;
            v11 = 1f;
            v0.line(v1, v6, 4f, v3, 40f, 1.4f, v7);
        }
        else {
            v10 = v2;
            v19 = 0f;
            v11 = v3;
        }

        v1.restore();
        v0.detail.rewind();
        v0.detail.moveTo(24f, 3f);
        v0.detail.lineTo(13f, 3f);
        v0.detail.lineTo(3f, 13f);
        v0.detail.lineTo(3f, 31f);
        v0.detail.lineTo(13f, 41f);
        v0.detail.lineTo(24f, 41f);
        v0.detail.moveTo(116f, 3f);
        v0.detail.lineTo(125f, 3f);
        v0.detail.lineTo(137f, 15f);
        v0.detail.lineTo(137f, 29f);
        v0.detail.lineTo(125f, 41f);
        v0.detail.lineTo(116f, 41f);
        v0.stroke(v1, v0.detail, v15, 22);
        v15 = 2f;
        v0.stroke(v1, v0.detail, v15, 65);
        v0.stroke(v1, v0.detail, v8, v14);
        if(v10 > v19) {
            v0.drawCircuit(v1, v13_1, v10);
        }

        v1.save();
        v0.paint.setStyle(Paint$Style.STROKE);
        v0.paint.setStrokeWidth(v12);
        v0.paint.setColor(v0.accentColor & v16 | (((int)(150f * v10))) << 24);
        GoldenModeSelectorView v12_1 = v0;
        float v20 = 3f;
        arg22.drawArc(8f, 16f, 20f, 28f, 360f * v13_1 - 90f, 240f, false, v0.paint);
        float v0_1 = v12_1.frame.getOpening() * 0.3f + v11;
        v6 = 22f;
        arg22.scale(v0_1, v0_1, 14f, v6);
        arg22.rotate(v17 * v13_1 + 45f, 14f, v6);
        v12_1.paint.setStyle(Paint$Style.STROKE);
        v12_1.paint.setStrokeWidth(1.2f);
        v12_1.paint.setColor(v12_1.accentColor);
        arg22.drawRect(11.5f, 19.5f, 16.5f, 24.5f, v12_1.paint);
        v12_1.paint.setStyle(Paint$Style.FILL);
        arg22.drawRect(13f, 21f, 15f, 23f, v12_1.paint);
        v1 = arg22;
        v1.restore();
        int v0_2;
        for(v0_2 = 0; v0_2 < 2; ++v0_2) {
            v3 = ((float)v0_2);
            v2 = RangesKt.coerceIn(v11 - Math.abs(v13_1 * v15 - 0.5f - 0.45f * v3), v19, v11) * v10;
            v3 = v3 * 5f + 123f + 1.2f * v2;
            v12_1.detail.rewind();
            v12_1.detail.moveTo(v3, 19f);
            v12_1.detail.lineTo(v3 + v20, v6);
            v12_1.detail.lineTo(v3, 25f);
            v12_1.stroke(v1, v12_1.detail, 0.35f * v2 + v11, (((int)(v2 * 75f))) + 180);
        }

        v1.restoreToCount(v9);
    }

    public final void setAccentColor$app(int arg2) {
        if(this.accentColor != arg2) {
            this.accentColor = arg2;
            this.invalidate();
        }
    }

    public final void setFrame$app(Frame arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        if(!Intrinsics.areEqual(this.frame, arg2)) {
            this.frame = arg2;
            this.invalidate();
        }
    }

    public final void setSelectedMode$app(int arg2) {
        if(this.selectedMode != arg2) {
            this.selectedMode = arg2;
            this.invalidate();
        }
    }

    private final void stroke(Canvas arg3, Path arg4, float arg5, int arg6) {
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(arg5);
        this.paint.setColor(arg6 << 24 | this.accentColor & 0xFFFFFF);
        arg3.drawPath(arg4, this.paint);
    }
}

