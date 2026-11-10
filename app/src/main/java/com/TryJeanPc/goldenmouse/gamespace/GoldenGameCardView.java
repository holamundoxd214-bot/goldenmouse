package com.TryJeanPc.goldenmouse.gamespace;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020\"2\b\u0010-\u001A\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001A\u00020&J\u000E\u0010.\u001A\u00020+2\u0006\u0010\u001C\u001A\u00020\u001DJ\u000E\u0010/\u001A\u00020+2\u0006\u00100\u001A\u00020&J\b\u00101\u001A\u00020+H\u0014J\u0010\u00102\u001A\u00020&2\u0006\u00103\u001A\u000204H\u0016J\u0010\u00105\u001A\u00020+2\u0006\u00106\u001A\u000207H\u0014J\u0010\u00108\u001A\u00020+2\u0006\u00106\u001A\u000207H\u0002J\u0010\u00109\u001A\u00020+2\u0006\u00106\u001A\u000207H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u000E\u0010!\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006:"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameCardView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "camera", "Landroid/graphics/Camera;", "matrix", "Landroid/graphics/Matrix;", "matrixValues", "", "inverse", "touchPoint", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", "source", "Landroid/graphics/Rect;", "clip", "Landroid/graphics/Path;", "circuit", "border", "Landroid/graphics/LinearGradient;", "addFill", "addGlyph", "captionFill", "value", "", "offset", "getOffset", "()F", "label", "", "artwork", "Landroid/graphics/drawable/Drawable;", "fullArtwork", "", "captionLevel", "captionAnimator", "Landroid/animation/ValueAnimator;", "bind", "", "title", "image", "updateOffset", "showCaption", "show", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawAddCard", "drawCover", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGameCardView extends View {
    public static final int $stable = 8;
    private final LinearGradient addFill;
    private final LinearGradient addGlyph;
    private Drawable artwork;
    private final LinearGradient border;
    private final Camera camera;
    private ValueAnimator captionAnimator;
    private final LinearGradient captionFill;
    private float captionLevel;
    private final Path circuit;
    private final Path clip;
    private boolean fullArtwork;
    private final Matrix inverse;
    private String label;
    private final Matrix matrix;
    private final float[] matrixValues;
    private float offset;
    private final Paint paint;
    private final RectF rect;
    private final Rect source;
    private final float[] touchPoint;

    static {
    }

    public GoldenGameCardView(Context arg13) {
        Intrinsics.checkNotNullParameter(arg13, "context");
        super(arg13);
        this.camera = new Camera();
        this.matrix = new Matrix();
        this.matrixValues = new float[9];
        this.inverse = new Matrix();
        this.touchPoint = new float[2];
        this.paint = new Paint(3);
        RectF v13 = new RectF(3f, 3f, 1053f, 567f);
        this.rect = v13;
        this.source = new Rect();
        Path v1 = new Path();
        v1.addRoundRect(v13, 34f, 34f, Path$Direction.CW);
        this.clip = v1;
        this.circuit = new Path();
        this.border = new LinearGradient(188f, -127f, 916f, 697f, new int[]{-5733307, 0xFFE0CA91, 0xFFB59354}, new float[]{0f, 0.7f, 1f}, Shader$TileMode.CLAMP);
        this.addFill = new LinearGradient(0f, 0f, 1056f, 570f, new int[]{0xFF1D1B17, 0xFF101113, 0xFF171819}, null, Shader$TileMode.CLAMP);
        this.addGlyph = new LinearGradient(528f, 160f, 528f, 338f, new int[]{0xFFEAD7A4, 0xFFBFA05F, -7508680}, null, Shader$TileMode.CLAMP);
        this.captionFill = new LinearGradient(0f, 420f, 0f, 570f, 0, 0xDA08090B, Shader$TileMode.CLAMP);
        this.label = "";
        this.captionLevel = 1f;
        this.setFocusable(true);
        int v0;
        for(v0 = 0; v0 < 6; ++v0) {
            int v1_1;
            for(v1_1 = 0; v1_1 < 7; ++v1_1) {
                float v2 = (((float)v1_1)) * 184f - (((float)(v0 % 2))) * 92f;
                float v3 = (((float)v0)) * 101f - 25f;
                this.circuit.moveTo(v2, v3);
                this.circuit.lineTo(126f + v2, v3);
                v3 += 46f;
                this.circuit.lineTo(172f + v2, v3);
                this.circuit.lineTo(v2 + 280f, v3);
            }
        }
    }

    public final void bind(String arg2, Drawable arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "title");
        this.label = arg2;
        this.artwork = arg3;
        this.fullArtwork = arg4;
        this.setContentDescription(((CharSequence)arg2));
        this.invalidate();
    }

    public static void bind$default(GoldenGameCardView arg0, String arg1, Drawable arg2, boolean arg3, int arg4, Object arg5) {
        arg0.bind(arg1, arg2, false);
    }

    private final void drawAddCard(Canvas arg15) {
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setAlpha(0xFF);
        this.paint.setShader(this.addFill);
        arg15.drawRect(this.rect, this.paint);
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(5f);
        this.paint.setShader(this.border);
        this.paint.setAlpha(35);
        arg15.drawPath(this.circuit, this.paint);
        this.paint.setAlpha(0xFF);
        this.paint.setStrokeWidth(11f);
        this.paint.setShader(this.addGlyph);
        arg15.drawCircle(528f, 249f, 83f, this.paint);
        this.paint.setStrokeWidth(14f);
        arg15.drawLine(489f, 249f, 567f, 249f, this.paint);
        arg15.drawLine(528f, 210f, 528f, 288f, this.paint);
        this.paint.setShader(null);
        this.paint.setStyle(Paint$Style.FILL);
    }

    private final void drawCover(Canvas arg6) {
        Drawable v0 = this.artwork;
        if(v0 == null) {
            return;
        }

        if(this.fullArtwork) {
            this.source.set(v0.getBounds());
            v0.setBounds(0, 0, 0x420, 570);
            v0.draw(arg6);
            v0.setBounds(this.source);
            return;
        }

        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setShader(this.addFill);
        arg6.drawRect(this.rect, this.paint);
        this.paint.setShader(null);
        this.source.set(v0.getBounds());
        v0.setBounds(0x180, 0x8A, 0x2A0, 426);
        v0.draw(arg6);
        v0.setBounds(this.source);
    }

    public final float getOffset() {
        return this.offset;
    }

    protected void onDetachedFromWindow() {
        ValueAnimator v0 = this.captionAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg12) {
        Intrinsics.checkNotNullParameter(arg12, "canvas");
        super.onDraw(arg12);
        arg12.save();
        float v3 = 1056f;
        arg12.scale((((float)this.getWidth())) / v3, (((float)this.getHeight())) / 570f);
        this.camera.save();
        this.camera.rotateY(CarouselGeometry.INSTANCE.rotation(this.offset));
        this.camera.getMatrix(this.matrix);
        this.camera.restore();
        float v2 = CarouselGeometry.INSTANCE.scale(this.offset);
        this.matrix.postScale(v2, v2);
        this.matrix.getValues(this.matrixValues);
        float[] v2_1 = this.matrixValues;
        v2_1[6] /= 3f;
        v2_1[7] /= 3f;
        this.matrix.setValues(v2_1);
        if(this.offset > 0f) {
            v3 = 0f;
        }

        this.matrix.preTranslate(-v3, -285f);
        this.matrix.postTranslate(v3, 285f);
        arg12.concat(this.matrix);
        Shader v10 = null;
        this.paint.setShader(v10);
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setColor(0x90000000);
        arg12.drawRoundRect(0f, 9f, 1056f, 585f, 37f, 37f, this.paint);
        arg12.save();
        arg12.clipPath(this.clip);
        if(this.artwork == null) {
            this.drawAddCard(arg12);
        }
        else {
            this.drawCover(arg12);
        }

        this.paint.setShader(v10);
        this.paint.setStyle(Paint$Style.FILL);
        this.paint.setColor(0xFF000000);
        this.paint.setAlpha(((int)(RangesKt.coerceAtMost(Math.abs(this.offset), 1f) * 45f)));
        arg12.drawRect(this.rect, this.paint);
        int v7 = 0xFF;
        this.paint.setAlpha(v7);
        float v8 = this.captionLevel * RangesKt.coerceIn(1f - Math.abs(this.offset) * 2f, 0f, 1f);
        if(v8 > 0f && !this.fullArtwork) {
            if(this.artwork != null) {
                this.paint.setShader(this.captionFill);
                arg12.drawRect(0f, 420f, 1056f, 570f, this.paint);
                this.paint.setShader(v10);
            }

            this.paint.setColor(-1);
            this.paint.setAlpha(((int)(255f * v8)));
            this.paint.setTextSize(42f);
            this.paint.setTypeface(Typeface.create("sans-serif", 0));
            this.paint.setTextAlign(Paint$Align.CENTER);
            arg12.drawText(this.label, 528f, 507f, this.paint);
            this.paint.setAlpha(v7);
        }

        arg12.restore();
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(6f);
        this.paint.setShader(this.border);
        arg12.drawRoundRect(this.rect, 34f, 34f, this.paint);
        this.paint.setShader(v10);
        arg12.restore();
    }

    public boolean onTouchEvent(MotionEvent arg6) {
        Intrinsics.checkNotNullParameter(arg6, "event");
        if(arg6.getActionMasked() == 0) {
            ViewParent v0 = this.getParent();
            if((v0 instanceof RecyclerView)) {
            }
            else {
                v0 = null;
            }

            if(v0 != null) {
                if(((RecyclerView)v0).getScrollState() == 0) {
                    LayoutManager v2 = ((RecyclerView)v0).getLayoutManager();
                    Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
                    if(((GoldenCarouselLayoutManager)v2).getEntrance() == 0f) {
                        if(((RecyclerView)v0).hasPendingAdapterUpdates()) {
                            return 0;
                        }

                        goto label_22;
                    }
                }

                return 0;
            }

        label_22:
            this.touchPoint[0] = arg6.getX() * 1056f / (((float)RangesKt.coerceAtLeast(this.getWidth(), 1)));
            this.touchPoint[1] = arg6.getY() * 570f / (((float)RangesKt.coerceAtLeast(this.getHeight(), 1)));
            if(!this.matrix.invert(this.inverse)) {
                return 0;
            }

            this.inverse.mapPoints(this.touchPoint);
            if(this.rect.contains(this.touchPoint[0], this.touchPoint[1])) {
                goto label_56;
            }

            return 0;
        }

    label_56:
        return super.onTouchEvent(arg6);
    }

    public final void showCaption(boolean arg6) {
        ValueAnimator v0 = this.captionAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        if(arg6) {
            if(Math.abs(this.offset) >= 0.5f) {
            }
            else {
                float v6 = this.captionLevel;
                float v0_1 = 1f;
                if(v6 < v0_1) {
                    ValueAnimator v6_1 = ValueAnimator.ofFloat(new float[]{v6, v0_1});
                    v6_1.setDuration(285);
                    v6_1.setInterpolator(new PathInterpolator(0.3f, 0.13f, 0.58f, v0_1));
                    v6_1.addUpdateListener(new GoldenGameCardView$$ExternalSyntheticLambda0(this));
                    v6_1.start();
                    this.captionAnimator = v6_1;
                }

                return;
            }
        }

        this.captionLevel = 0f;
        this.invalidate();
    }

    static final void showCaption$lambda$2$lambda$1(GoldenGameCardView arg1, ValueAnimator arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        Object v2 = arg2.getAnimatedValue();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Float");
        arg1.captionLevel = ((Float)v2).floatValue();
        arg1.invalidate();
    }

    public final void updateOffset(float arg1) {
        this.offset = arg1;
        this.invalidate();
    }
}

