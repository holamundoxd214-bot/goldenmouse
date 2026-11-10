package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u0019J\b\u0010\'\u001A\u00020%H\u0002J\b\u0010(\u001A\u00020%H\u0002J\b\u0010)\u001A\u00020%H\u0014J\b\u0010*\u001A\u00020%H\u0014J\u0010\u0010+\u001A\u00020%2\u0006\u0010,\u001A\u00020\tH\u0014J\u000E\u0010-\u001A\u00020%2\u0006\u0010.\u001A\u00020\tJ\u0010\u0010/\u001A\u00020\u001E2\u0006\u00100\u001A\u00020\u001EH\u0002J\u0010\u00101\u001A\u00020%2\u0006\u00102\u001A\u000203H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenPlatformView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gold", "", "amber", "rings", "", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenPlatformView$Ring;", "camera", "Landroid/graphics/Camera;", "matrix", "Landroid/graphics/Matrix;", "values", "", "easing", "Landroid/view/animation/PathInterpolator;", "random", "Ljava/util/Random;", "active", "", "scheduled", "previousFrame", "", "elapsedMs", "", "arcVelocity", "liftStart", "liftDuration", "frame", "Landroid/view/Choreographer$FrameCallback;", "setRunning", "", "running", "schedule", "stopFrames", "onAttachedToWindow", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "scrollImpulse", "dx", "liftDistance", "time", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Ring", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenPlatformView extends View {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u0012\b\b\u0002\u0010\r\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0014R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0014R\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0014R\u0011\u0010\f\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0014R\u0011\u0010\r\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0014R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u001A\u0010\u0010\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u0014\"\u0004\b\"\u0010#R\u0011\u0010$\u001A\u00020%¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001A\u0010(\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0014\"\u0004\b*\u0010#R\u001A\u0010+\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0014\"\u0004\b-\u0010#R\u001A\u0010.\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0014\"\u0004\b0\u0010#¨\u00061"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenPlatformView$Ring;", "", "radius", "", "stroke", "color", "", "dash", "", "y", "enterDistance", "delay", "velocity", "pendulum", "lift", "", "angle", "<init>", "(FFI[FFFFFFZF)V", "getRadius", "()F", "getStroke", "getColor", "()I", "getDash", "()[F", "getY", "getEnterDistance", "getDelay", "getVelocity", "getPendulum", "getLift", "()Z", "getAngle", "setAngle", "(F)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "startAngle", "getStartAngle", "setStartAngle", "endAngle", "getEndAngle", "setEndAngle", "cycleStart", "getCycleStart", "setCycleStart", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Ring {
        private float angle;
        private final int color;
        private float cycleStart;
        private final float[] dash;
        private final float delay;
        private float endAngle;
        private final float enterDistance;
        private final boolean lift;
        private final Paint paint;
        private final float pendulum;
        private final float radius;
        private float startAngle;
        private final float stroke;
        private final float velocity;
        private final float y;

        public Ring(float arg2, float arg3, int arg4, float[] arg5, float arg6, float arg7, float arg8, float arg9, float arg10, boolean arg11, float arg12, int arg13, DefaultConstructorMarker arg14) {
            this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, 0f, 0f, false, 0f);
        }

        public Ring(float arg1, float arg2, int arg3, float[] arg4, float arg5, float arg6, float arg7, float arg8, float arg9, boolean arg10, float arg11) {
            super();
            this.radius = arg1;
            this.stroke = arg2;
            this.color = arg3;
            this.dash = arg4;
            this.y = arg5;
            this.enterDistance = arg6;
            this.delay = arg7;
            this.velocity = arg8;
            this.pendulum = arg9;
            this.lift = arg10;
            this.angle = arg11;
            Paint v5 = new Paint(1);
            v5.setStyle(Paint$Style.STROKE);
            v5.setStrokeWidth(arg2);
            v5.setColor(arg3);
            if(arg4 != null) {
                v5.setPathEffect(new DashPathEffect(arg4, 5f));
                if(arg4[1] < arg1) {
                    v5.setStrokeCap(Paint$Cap.ROUND);
                }
            }

            this.paint = v5;
            arg1 = this.angle;
            this.startAngle = arg1;
            this.endAngle = arg1;
            this.cycleStart = -arg9;
        }

        public final float getAngle() {
            return this.angle;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getCycleStart() {
            return this.cycleStart;
        }

        public final float[] getDash() {
            return this.dash;
        }

        public final float getDelay() {
            return this.delay;
        }

        public final float getEndAngle() {
            return this.endAngle;
        }

        public final float getEnterDistance() {
            return this.enterDistance;
        }

        public final boolean getLift() {
            return this.lift;
        }

        public final Paint getPaint() {
            return this.paint;
        }

        public final float getPendulum() {
            return this.pendulum;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getStartAngle() {
            return this.startAngle;
        }

        public final float getStroke() {
            return this.stroke;
        }

        public final float getVelocity() {
            return this.velocity;
        }

        public final float getY() {
            return this.y;
        }

        public final void setAngle(float arg1) {
            this.angle = arg1;
        }

        public final void setCycleStart(float arg1) {
            this.cycleStart = arg1;
        }

        public final void setEndAngle(float arg1) {
            this.endAngle = arg1;
        }

        public final void setStartAngle(float arg1) {
            this.startAngle = arg1;
        }
    }

    public static final int $stable = 8;
    private boolean active;
    private final int amber;
    private float arcVelocity;
    private final Camera camera;
    private final PathInterpolator easing;
    private float elapsedMs;
    private final Choreographer$FrameCallback frame;
    private final int gold;
    private float liftDuration;
    private float liftStart;
    private final Matrix matrix;
    private long previousFrame;
    private final Random random;
    private final List rings;
    private boolean scheduled;
    private final float[] values;

    static {
    }

    public GoldenPlatformView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenPlatformView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenPlatformView(Context arg36, AttributeSet arg37) {
        Intrinsics.checkNotNullParameter(arg36, "context");
        super(arg36, arg37);
        this.gold = 0xFFE2C78D;
        this.amber = 0xFFB18B4D;
        this.rings = CollectionsKt.listOf(new Ring[]{new Ring(728.5f, 8f, 0xFFE2C78D, null, 295f, 30f, 0f, 0f, 0f, false, 0f, 0x780, null), new Ring(712.5f, 34f, 0xFFB18B4D, new float[]{260f, 5700f}, 295f, 30f, 0f, -2f, 0f, false, 0f, 0x700, null), new Ring(500f, 26f, 0xFFB18B4D, new float[]{800f, 4000f}, 315f, 30f, 0f, 0f, 2400f, false, 100f, 640, null), new Ring(500f, 26f, 0xFFB18B4D, new float[]{200f, 4000f}, 315f, 30f, 0f, 2f, 0f, false, 200f, 0x300, null), new Ring(276.5f, 9f, 0xFFE2C78D, null, 315f, 0f, 150f, 0f, 0f, false, 0f, 0x780, null), new Ring(154f, 9f, 0xFFE2C78D, new float[]{20f, 40f}, 315f, 0f, 250f, 1.8f, 0f, false, 0f, 0x700, null), new Ring(97.5f, 11f, 0xFFFFEFD0, null, 315f, 42f, 350f, 0f, 0f, true, 0f, 0x580, null), new Ring(107.5f, 42f, 0xFFFFEFD0, new float[]{15f, 4000f}, 315f, 42f, 350f, 0f, 1400f, true, 0f, 0x480, null), new Ring(107.5f, 42f, 0xFFFFEFD0, new float[]{15f, 4000f}, 315f, 42f, 350f, 0f, 5400f, true, 0f, 0x480, null)});
        this.camera = new Camera();
        this.matrix = new Matrix();
        this.values = new float[9];
        this.easing = new PathInterpolator(0.3f, 0f, 0.3f, 1f);
        this.random = new Random(318);
        this.arcVelocity = -2f;
        this.liftDuration = 1000f;
        this.frame = new GoldenPlatformView$$ExternalSyntheticLambda0(this);
    }

    static final void frame$lambda$1(GoldenPlatformView arg5, long arg6) {
        int v0 = 0;
        arg5.scheduled = false;
        if((arg5.active) && (arg5.isAttachedToWindow()) && arg5.getWindowVisibility() == 0 && (arg5.isShown())) {
            long v1 = arg5.previousFrame;
            float v1_1 = v1 == 0 ? 0f : RangesKt.coerceAtMost((((float)(arg6 - v1))) / 1000000f, 50f);
            arg5.previousFrame = arg6;
            arg5.elapsedMs += v1_1;
            Iterator v6 = arg5.rings.iterator();
            while(v6.hasNext()) {
                Object v7 = v6.next();
                int v2 = v0 + 1;
                if(v0 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                float v0_1 = v0 == 1 ? arg5.arcVelocity : ((Ring)v7).getVelocity();
                ((Ring)v7).setAngle((((Ring)v7).getAngle() + v0_1 * v1_1 / 16.666666f) % 360f);
                v0 = v2;
            }

            arg5.invalidate();
            arg5.schedule();
        }
    }

    private final float liftDistance(float arg7) {
        float v0 = arg7 - this.liftStart;
        if(v0 < 0f) {
            return 0;
        }

        float v2 = this.liftDuration;
        float v4 = 42f;
        if(Float.compare(v0, v2) < 0) {
            return this.easing.getInterpolation(v0 / v2) * v4;
        }

        float v3 = 50f;
        if(v0 < v2 + v3) {
            return v4;
        }

        if(v0 < 3f * v2 + v3) {
            return (1f - this.easing.getInterpolation((v0 - v2 - v3) / (v2 * 2f))) * v4;
        }

        this.liftStart = arg7 + (((float)this.random.nextInt(12000))) + 200f;
        this.liftDuration = (((float)this.random.nextInt(3000))) + 800f;
        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.schedule();
    }

    protected void onDetachedFromWindow() {
        this.stopFrames();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg12) {
        float v3_1;
        Intrinsics.checkNotNullParameter(arg12, "canvas");
        super.onDraw(arg12);
        float v0 = this.isInEditMode() ? 3000f : this.elapsedMs;
        float v1 = this.liftDistance(v0);
        arg12.save();
        arg12.scale((((float)this.getWidth())) / 2340f, (((float)this.getHeight())) / 1080f);
        Iterator v2 = this.rings.iterator();
        int v3;
        for(v3 = 0; v2.hasNext(); v3 = v5) {
            Object v4 = v2.next();
            int v5 = v3 + 1;
            if(v3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            if(v3 != 0 || v0 < 1350f) {
                float v7 = 1f;
                if(Float.compare(((Ring)v4).getPendulum(), 0f) > 0) {
                    if(v0 - ((Ring)v4).getCycleStart() >= ((Ring)v4).getPendulum()) {
                        ((Ring)v4).setStartAngle(((Ring)v4).getEndAngle());
                        v3_1 = ((Ring)v4).getStartAngle() > 270f ? 90f : 360f;
                        ((Ring)v4).setEndAngle(v3_1 + (((float)this.random.nextInt(180))));
                        ((Ring)v4).setCycleStart(v0);
                    }

                    ((Ring)v4).setAngle(((Ring)v4).getStartAngle() + (((Ring)v4).getEndAngle() - ((Ring)v4).getStartAngle()) * this.easing.getInterpolation(RangesKt.coerceIn((v0 - ((Ring)v4).getCycleStart()) / ((Ring)v4).getPendulum(), 0f, v7)));
                }

                v3_1 = this.easing.getInterpolation(RangesKt.coerceIn((v0 - ((Ring)v4).getDelay()) / 1000f, 0f, v7));
                float v8 = ((Ring)v4).getY() + 540f;
                v7 = ((Ring)v4).getLift() ? v1 : ((Ring)v4).getEnterDistance() * v3_1;
                v8 -= v7;
                this.camera.save();
                this.camera.translate(0f, 0f, 25f);
                this.camera.rotateX(83.839996f);
                this.camera.rotateZ(((Ring)v4).getAngle());
                this.camera.getMatrix(this.matrix);
                this.camera.restore();
                this.matrix.getValues(this.values);
                float[] v3_2 = this.values;
                v3_2[6] /= 3f;
                v3_2[7] /= 3f;
                this.matrix.setValues(v3_2);
                this.matrix.preTranslate(-1170f, -v8);
                this.matrix.postTranslate(1170f, v8);
                arg12.save();
                arg12.concat(this.matrix);
                ((Ring)v4).getPaint().setStrokeWidth(((Ring)v4).getStroke() + 14f);
                ((Ring)v4).getPaint().setAlpha(25);
                arg12.drawCircle(1170f, v8, ((Ring)v4).getRadius(), ((Ring)v4).getPaint());
                ((Ring)v4).getPaint().setStrokeWidth(((Ring)v4).getStroke() + 6f);
                ((Ring)v4).getPaint().setAlpha(62);
                arg12.drawCircle(1170f, v8, ((Ring)v4).getRadius(), ((Ring)v4).getPaint());
                ((Ring)v4).getPaint().setStrokeWidth(((Ring)v4).getStroke());
                ((Ring)v4).getPaint().setAlpha(0xEB);
                arg12.drawCircle(1170f, v8, ((Ring)v4).getRadius(), ((Ring)v4).getPaint());
                arg12.restore();
            }
        }

        arg12.restore();
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        if(arg1 == 0) {
            this.schedule();
            return;
        }

        this.stopFrames();
    }

    private final void schedule() {
        if(!this.scheduled && (this.active) && (this.isAttachedToWindow()) && this.getWindowVisibility() == 0 && !this.isInEditMode()) {
            this.scheduled = true;
            Choreographer.getInstance().postFrameCallback(this.frame);
        }
    }

    public final void scrollImpulse(int arg4) {
        float v4 = arg4 == 0 ? -2f : RangesKt.coerceIn((((float)Math.abs(arg4))) / 40f, 2f, 8f) * -Math.signum(((float)arg4));
        this.arcVelocity = v4;
    }

    public final void setRunning(boolean arg3) {
        this.active = arg3;
        this.previousFrame = 0;
        if(arg3) {
            this.schedule();
            return;
        }

        this.stopFrames();
    }

    private final void stopFrames() {
        Choreographer.getInstance().removeFrameCallback(this.frame);
        this.scheduled = false;
        this.previousFrame = 0;
    }
}

