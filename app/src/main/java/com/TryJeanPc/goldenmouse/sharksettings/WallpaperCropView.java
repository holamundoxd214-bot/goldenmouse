package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u000BJ(\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001E2\u0006\u0010!\u001A\u00020\u001EH\u0014J\b\u0010\"\u001A\u00020\u0019H\u0002J\b\u0010#\u001A\u00020\u0019H\u0002J\b\u0010$\u001A\u00020\u0019H\u0002J\u0010\u0010%\u001A\u00020\u00192\u0006\u0010&\u001A\u00020\'H\u0014J\u0010\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+H\u0016J\b\u0010,\u001A\u00020)H\u0016J\r\u0010-\u001A\u00020.H\u0000¢\u0006\u0002\b/R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/WallpaperCropView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "image", "Landroid/graphics/Bitmap;", "aspect", "", "frame", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "scale", "minimumScale", "x", "y", "lastX", "lastY", "detector", "Landroid/view/ScaleGestureDetector;", "setImage", "", "bitmap", "ratio", "onSizeChanged", "w", "", "h", "oldw", "oldh", "updateFrame", "fit", "clamp", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "performClick", "snapshot", "Lcom/TryJeanPc/goldenmouse/sharksettings/WallpaperCropView$Crop;", "snapshot$app", "Crop", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WallpaperCropView extends View {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001A\u00020\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J1\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u0007HÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/WallpaperCropView$Crop;", "", "source", "Landroid/graphics/Bitmap;", "transform", "Landroid/graphics/Matrix;", "width", "", "height", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;II)V", "getSource", "()Landroid/graphics/Bitmap;", "getTransform", "()Landroid/graphics/Matrix;", "getWidth", "()I", "getHeight", "render", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Crop {
        public static final int $stable = 8;
        private final int height;
        private final Bitmap source;
        private final Matrix transform;
        private final int width;

        static {
        }

        public Crop(Bitmap arg2, Matrix arg3, int arg4, int arg5) {
            Intrinsics.checkNotNullParameter(arg2, "source");
            Intrinsics.checkNotNullParameter(arg3, "transform");
            super();
            this.source = arg2;
            this.transform = arg3;
            this.width = arg4;
            this.height = arg5;
        }

        public final Bitmap component1() {
            return this.source;
        }

        public final Matrix component2() {
            return this.transform;
        }

        public final int component3() {
            return this.width;
        }

        public final int component4() {
            return this.height;
        }

        public final Crop copy(Bitmap arg1, Matrix arg2, int arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg1, "source");
            Intrinsics.checkNotNullParameter(arg2, "transform");
            return new Crop(arg1, arg2, arg3, arg4);
        }

        public static Crop copy$default(Crop arg0, Bitmap arg1, Matrix arg2, int arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.source;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.transform;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.width;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.height;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((Crop)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Crop)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.source, ((Crop)arg5).source)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.transform, ((Crop)arg5).transform)) {
                return 0;
            }

            if(this.width != ((Crop)arg5).width) {
                return 0;
            }

            if(this.height != ((Crop)arg5).height) {
                return 0;
            }

            return 1;
        }

        public final int getHeight() {
            return this.height;
        }

        public final Bitmap getSource() {
            return this.source;
        }

        public final Matrix getTransform() {
            return this.transform;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return ((this.source.hashCode() * 0x1F + this.transform.hashCode()) * 0x1F + Integer.hashCode(this.width)) * 0x1F + Integer.hashCode(this.height);
        }

        public final Bitmap render() {
            Bitmap v0 = Bitmap.createBitmap(this.width, this.height, Bitmap$Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(v0, "createBitmap(...)");
            new Canvas(v0).drawBitmap(this.source, this.transform, new Paint(2));
            return v0;
        }

        public String toString() {
            return "Crop(source=" + this.source + ", transform=" + this.transform + ", width=" + this.width + ", height=" + this.height + ")";
        }
    }

    public static final int $stable = 8;
    private float aspect;
    private final ScaleGestureDetector detector;
    private final RectF frame;
    private Bitmap image;
    private float lastX;
    private float lastY;
    private float minimumScale;
    private final Paint paint;
    private float scale;
    private float x;
    private float y;

    static {
    }

    public WallpaperCropView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public WallpaperCropView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public WallpaperCropView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.aspect = 2f;
        this.frame = new RectF();
        this.paint = new Paint(3);
        this.scale = 1f;
        this.minimumScale = 1f;
        this.detector = new ScaleGestureDetector(arg2, new WallpaperCropView$detector$1(this));
    }

    public static final void access$clamp(WallpaperCropView arg0) {
        arg0.clamp();
    }

    public static final float access$getMinimumScale$p(WallpaperCropView arg0) {
        return arg0.minimumScale;
    }

    public static final float access$getScale$p(WallpaperCropView arg0) {
        return arg0.scale;
    }

    public static final float access$getX$p(WallpaperCropView arg0) {
        return arg0.x;
    }

    public static final float access$getY$p(WallpaperCropView arg0) {
        return arg0.y;
    }

    public static final void access$setScale$p(WallpaperCropView arg0, float arg1) {
        arg0.scale = arg1;
    }

    public static final void access$setX$p(WallpaperCropView arg0, float arg1) {
        arg0.x = arg1;
    }

    public static final void access$setY$p(WallpaperCropView arg0, float arg1) {
        arg0.y = arg1;
    }

    private final void clamp() {
        Bitmap v0 = this.image;
        if(v0 == null) {
            return;
        }

        this.x = RangesKt.coerceIn(this.x, Math.min(this.frame.left, this.frame.right - (((float)v0.getWidth())) * this.scale), this.frame.left);
        this.y = RangesKt.coerceIn(this.y, Math.min(this.frame.top, this.frame.bottom - (((float)v0.getHeight())) * this.scale), this.frame.top);
    }

    private final void fit() {
        Bitmap v0 = this.image;
        if(v0 == null) {
        }
        else {
            if(this.frame.isEmpty()) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        float v1 = Math.max(this.frame.width() / (((float)v0.getWidth())), this.frame.height() / (((float)v0.getHeight())));
        this.minimumScale = v1;
        this.scale = v1;
        this.x = this.frame.centerX() - (((float)v0.getWidth())) * this.scale / 2f;
        this.y = this.frame.centerY() - (((float)v0.getHeight())) * this.scale / 2f;
    }

    protected void onDraw(Canvas arg14) {
        Intrinsics.checkNotNullParameter(arg14, "canvas");
        super.onDraw(arg14);
        Bitmap v0 = this.image;
        if(v0 == null) {
            return;
        }

        arg14.save();
        arg14.translate(this.x, this.y);
        arg14.scale(this.scale, this.scale);
        arg14.drawBitmap(v0, 0f, 0f, this.paint);
        arg14.restore();
        this.paint.setColor(0xA0000000);
        arg14.drawRect(0f, 0f, ((float)this.getWidth()), this.frame.top, this.paint);
        arg14.drawRect(0f, this.frame.bottom, ((float)this.getWidth()), ((float)this.getHeight()), this.paint);
        arg14.drawRect(0f, this.frame.top, this.frame.left, this.frame.bottom, this.paint);
        arg14.drawRect(this.frame.right, this.frame.top, ((float)this.getWidth()), this.frame.bottom, this.paint);
        this.paint.setStyle(Paint$Style.STROKE);
        this.paint.setStrokeWidth(this.getResources().getDisplayMetrics().density);
        this.paint.setColor(-1);
        arg14.drawRect(this.frame, this.paint);
        this.paint.setStyle(Paint$Style.FILL);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        this.updateFrame();
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        Intrinsics.checkNotNullParameter(arg5, "event");
        int v1 = 0;
        if(this.image == null) {
            return 0;
        }

        this.detector.onTouchEvent(arg5);
        int v0 = arg5.getActionMasked();
        if(v0 == 0) {
            this.lastX = arg5.getX();
            this.lastY = arg5.getY();
        }
        else if(v0 == 1) {
            this.performClick();
        }
        else if(v0 == 2) {
            if(!this.detector.isInProgress()) {
                this.x += arg5.getX() - this.lastX;
                this.y += arg5.getY() - this.lastY;
                this.clamp();
                this.invalidate();
            }

            this.lastX = arg5.getX();
            this.lastY = arg5.getY();
        }
        else if(v0 != 6) {
        }
        else {
            if(arg5.getActionIndex() == 0) {
                v1 = 1;
            }

            this.lastX = arg5.getX(v1);
            this.lastY = arg5.getY(v1);
        }

        return 1;
    }

    public boolean performClick() {
        super.performClick();
        return 1;
    }

    public final void setImage(Bitmap arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "bitmap");
        this.image = arg2;
        this.aspect = arg3;
        this.updateFrame();
        this.invalidate();
    }

    public final Crop snapshot$app() {
        Bitmap v0 = this.image;
        if(v0 != null) {
            if(!this.frame.isEmpty()) {
                int v1 = RangesKt.coerceAtLeast(MathKt.roundToInt(this.frame.width() / this.scale), 1);
                Pair v1_1 = GameSpaceWallpaperStore.INSTANCE.boundedSize(v1, RangesKt.coerceAtLeast(MathKt.roundToInt((((float)v1)) / this.aspect), 1));
                int v2 = v1_1.component1().intValue();
                v1 = v1_1.component2().intValue();
                Matrix v3 = new Matrix();
                v3.setScale(this.scale, this.scale);
                v3.postTranslate(this.x - this.frame.left, this.y - this.frame.top);
                v3.postScale((((float)v2)) / this.frame.width(), (((float)v1)) / this.frame.height());
                return new Crop(v0, v3, v2, v1);
            }

            throw new IllegalStateException("Check failed.");
        }

        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void updateFrame() {
        int v0 = this.getWidth();
        int v1 = this.getHeight();
        if(v0 != 0) {
            if(v1 == 0) {
            }
            else {
                float v0_1 = ((float)v0);
                float v3 = 16f * this.getResources().getDisplayMetrics().density * 2f;
                float v1_1 = ((float)v1);
                v3 = Math.min(RangesKt.coerceAtLeast(v0_1 - v3, 1f), RangesKt.coerceAtLeast(v1_1 - v3, 1f) * this.aspect);
                float v4 = v3 / this.aspect;
                this.frame.set((v0_1 - v3) / 2f, (v1_1 - v4) / 2f, (v0_1 + v3) / 2f, (v1_1 + v4) / 2f);
                this.fit();
            }
        }
    }
}

