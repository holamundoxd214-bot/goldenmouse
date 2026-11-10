package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\f\u0010\u000F\u001A\u00060\u0003j\u0002`\u0010H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u00188V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001E8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R$\u0010)\u001A\u00020(2\u0006\u0010\u0011\u001A\u00020(8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b*\u0010%\"\u0004\b+\u0010\'R$\u0010,\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R$\u00100\u001A\u00020/2\u0006\u0010\u0011\u001A\u00020/8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b1\u0010%\"\u0004\b2\u0010\'R$\u00104\u001A\u0002032\u0006\u0010\u0011\u001A\u0002038V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b5\u0010%\"\u0004\b6\u0010\'R$\u00107\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R$\u0010;\u001A\u00020:2\u0006\u0010\u0011\u001A\u00020:8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b<\u0010%\"\u0004\b=\u0010\'R4\u0010>\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f2\u000E\u0010\u0011\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010C\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u000E8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010I\u001A\u0004\u0018\u00010H2\b\u0010\u0011\u001A\u0004\u0018\u00010H@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006N"}, d2={"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "internalPaint", "Landroid/graphics/Paint;", "<init>", "(Landroid/graphics/Paint;)V", "()V", "_blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "internalColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "asFrameworkPaint", "Landroidx/compose/ui/graphics/NativePaint;", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "isAntiAlias", "()Z", "setAntiAlias", "(Z)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "Landroidx/compose/ui/graphics/PaintingStyle;", "style", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPaint implements Paint {
    public static final int $stable = 8;
    private int _blendMode;
    private ColorFilter internalColorFilter;
    private android.graphics.Paint internalPaint;
    private Shader internalShader;
    private PathEffect pathEffect;

    static {
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.makeNativePaint());
    }

    public AndroidPaint(android.graphics.Paint arg1) {
        super();
        this.internalPaint = arg1;
        this._blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    public android.graphics.Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    public int getBlendMode-0nO6VwU() {
        return this._blendMode;
    }

    public long getColor-0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    public ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    public int getFilterQuality-f-v9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public Shader getShader() {
        return this.internalShader;
    }

    public int getStrokeCap-KaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    public int getStrokeJoin-LxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    public int getStyle-TiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    public void setAlpha(float arg1) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, arg1);
    }

    public void setAntiAlias(boolean arg1) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, arg1);
    }

    public void setBlendMode-s9anfk8(int arg2) {
        if(!BlendMode.equals-impl0(this._blendMode, arg2)) {
            this._blendMode = arg2;
            AndroidPaint_androidKt.setNativeBlendMode-GB0RdKg(this.internalPaint, arg2);
        }
    }

    public void setColor-8_81llA(long arg1) {
        AndroidPaint_androidKt.setNativeColor-4WTKRHQ(this.internalPaint, arg1);
    }

    public void setColorFilter(ColorFilter arg1) {
        this.internalColorFilter = arg1;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, arg1);
    }

    public void setFilterQuality-vDHp3xo(int arg1) {
        AndroidPaint_androidKt.setNativeFilterQuality-50PEsBU(this.internalPaint, arg1);
    }

    public void setPathEffect(PathEffect arg2) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, arg2);
        this.pathEffect = arg2;
    }

    public void setShader(Shader arg1) {
        this.internalShader = arg1;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, arg1);
    }

    public void setStrokeCap-BeK7IIE(int arg1) {
        AndroidPaint_androidKt.setNativeStrokeCap-CSYIeUk(this.internalPaint, arg1);
    }

    public void setStrokeJoin-Ww9F2mQ(int arg1) {
        AndroidPaint_androidKt.setNativeStrokeJoin-kLtJ_vA(this.internalPaint, arg1);
    }

    public void setStrokeMiterLimit(float arg1) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, arg1);
    }

    public void setStrokeWidth(float arg1) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, arg1);
    }

    public void setStyle-k9PVt8s(int arg1) {
        AndroidPaint_androidKt.setNativeStyle--5YerkU(this.internalPaint, arg1);
    }
}

