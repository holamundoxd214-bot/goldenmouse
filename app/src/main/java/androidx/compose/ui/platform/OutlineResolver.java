package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build$VERSION;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\'\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010(\u001A\u00020\u00162\u0006\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u00162\u0006\u0010+\u001A\u00020#¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001A\u00020\u00052\u0006\u0010/\u001A\u00020 ¢\u0006\u0004\b0\u00101J\u000E\u0010)\u001A\u0002022\u0006\u00103\u001A\u000204J\b\u00105\u001A\u000202H\u0002J\u0010\u00106\u001A\u0002022\u0006\u00107\u001A\u000208H\u0002J\u0010\u00109\u001A\u0002022\u0006\u0010:\u001A\u00020\u0014H\u0002J\u0010\u0010;\u001A\u0002022\u0006\u0010<\u001A\u00020\u000BH\u0002J-\u0010=\u001A\u00020\u0005*\u0004\u0018\u00010\u00142\u0006\u0010>\u001A\u00020 2\u0006\u0010+\u001A\u00020#2\u0006\u0010?\u001A\u00020\u0016H\u0002¢\u0006\u0004\b@\u0010AR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u000E\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0005@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0010R\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u000B8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0010\u0010\u001F\u001A\u00020 X\u0082\u000E¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0004\n\u0002\u0010!R\u000E\u0010$\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010&\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006B"}, d2={"Landroidx/compose/ui/platform/OutlineResolver;", "", "<init>", "()V", "isSupportedOutline", "", "cachedOutline", "Landroid/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "outlinePath", "value", "cacheIsDirty", "getCacheIsDirty$ui", "()Z", "usePathForClip", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "roundedCornerRadius", "", "androidOutline", "getAndroidOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "J", "rectSize", "Landroidx/compose/ui/geometry/Size;", "outlineNeeded", "tmpTouchPointPath", "tmpOpPath", "update", "alpha", "clipToOutline", "elevation", "size", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "updateCache", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "updateCacheWithPath", "composePath", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline;
    private androidx.compose.ui.graphics.Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    static {
    }

    public OutlineResolver() {
        super();
        this.isSupportedOutline = true;
        Outline v0 = new Outline();
        v0.setAlpha(1f);
        this.cachedOutline = v0;
        this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.rectSize = Size.Companion.getZero-NH-jbRc();
    }

    public final void clipToOutline(Canvas arg22) {
        OutlineResolver v0 = this;
        Canvas v7 = arg22;
        Path v1 = v0.getClipPath();
        int v9 = 2;
        Object v10 = null;
        if(v1 != null) {
            Canvas.clipPath-mtrdD-E$default(v7, v1, 0, v9, v10);
            return;
        }

        float v6 = v0.roundedCornerRadius;
        long v11 = 0xFFFFFFFFL;
        int v13 = 0x20;
        if(Float.compare(v6, 0f) > 0) {
            Path v14 = v0.tmpPath;
            RoundRect v1_1 = v0.tmpRoundRect;
            if(v14 == null || !v0.isSameBounds-4L21HEs(v1_1, v0.rectTopLeft, v0.rectSize, v6)) {
                v1_1 = RoundRectKt.RoundRect-gG7oq9Y(Float.intBitsToFloat(((int)(v0.rectTopLeft >> v13))), Float.intBitsToFloat(((int)(v0.rectTopLeft & v11))), Float.intBitsToFloat(((int)(v0.rectTopLeft >> v13))) + Float.intBitsToFloat(((int)(v0.rectSize >> v13))), Float.intBitsToFloat(((int)(v0.rectTopLeft & v11))) + Float.intBitsToFloat(((int)(v0.rectSize & v11))), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v0.roundedCornerRadius))) << v13 | (((long)Float.floatToRawIntBits(v0.roundedCornerRadius))) & v11));
                if(v14 == null) {
                    v14 = AndroidPath_androidKt.Path();
                }
                else {
                    v14.reset();
                }

                Path.addRoundRect$default(v14, v1_1, ((Direction)v10), v9, v10);
                v0.tmpRoundRect = v1_1;
                v0.tmpPath = v14;
            }

            Canvas.clipPath-mtrdD-E$default(v7, v14, 0, v9, v10);
            return;
        }

        Canvas.clipRect-N_I0leg$default(arg22, Float.intBitsToFloat(((int)(v0.rectTopLeft >> v13))), Float.intBitsToFloat(((int)(v0.rectTopLeft & v11))), Float.intBitsToFloat(((int)(v0.rectTopLeft >> v13))) + Float.intBitsToFloat(((int)(v0.rectSize >> v13))), Float.intBitsToFloat(((int)(v0.rectTopLeft & v11))) + Float.intBitsToFloat(((int)(v0.rectSize & v11))), 0, 16, null);
    }

    public final Outline getAndroidOutline() {
        this.updateCache();
        if(this.outlineNeeded) {
            if(!this.isSupportedOutline) {
            }
            else {
                return this.cachedOutline;
            }
        }

        return null;
    }

    public final boolean getCacheIsDirty$ui() {
        return this.cacheIsDirty;
    }

    public final Path getClipPath() {
        this.updateCache();
        return this.outlinePath;
    }

    public final boolean getOutlineClipSupported() {
        return this.usePathForClip ^ 1;
    }

    public final boolean isInOutline-k-4lQ0M(long arg5) {
        if(!this.outlineNeeded) {
            return 1;
        }

        androidx.compose.ui.graphics.Outline v0 = this.outline;
        if(v0 == null) {
            return 1;
        }

        return ShapeContainingUtilKt.isInOutline(v0, Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))), this.tmpTouchPointPath, this.tmpOpPath);
    }

    private final boolean isSameBounds-4L21HEs(RoundRect arg8, long arg9, long arg11, float arg13) {
        boolean v7 = false;
        if(arg8 != null) {
            if(!RoundRectKt.isSimple(arg8)) {
            }
            else {
                int v1 = 0x20;
                int v2 = ((int)(arg9 >> v1));
                if(arg8.getLeft() == Float.intBitsToFloat(v2)) {
                    long v3 = 0xFFFFFFFFL;
                    int v9 = ((int)(arg9 & v3));
                    if(arg8.getTop() == Float.intBitsToFloat(v9) && arg8.getRight() == Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg11 >> v1))) && arg8.getBottom() == Float.intBitsToFloat(v9) + Float.intBitsToFloat(((int)(arg11 & v3))) && Float.intBitsToFloat(((int)(arg8.getTopLeftCornerRadius-kKHJgLs() >> v1))) == arg13) {
                        v7 = true;
                    }
                }
            }
        }

        return v7;
    }

    public final boolean update-S_szKao(androidx.compose.ui.graphics.Outline arg3, float arg4, boolean arg5, float arg6, long arg7) {
        boolean v3;
        this.cachedOutline.setAlpha(arg4);
        boolean v4 = Intrinsics.areEqual(this.outline, arg3);
        int v0 = (((int)v4)) ^ 1;
        if(!v4) {
            this.outline = arg3;
            this.cacheIsDirty = true;
        }

        this.rectSize = arg7;
        if(arg3 != null) {
            if(!arg5 && arg6 <= 0f) {
                goto label_16;
            }

            v3 = true;
        }
        else {
        label_16:
            v3 = false;
        }

        if(this.outlineNeeded != v3) {
            this.outlineNeeded = v3;
            this.cacheIsDirty = true;
        }

        return ((boolean)v0);
    }

    private final void updateCache() {
        if(this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
            this.roundedCornerRadius = 0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            androidx.compose.ui.graphics.Outline v1 = this.outline;
            if(v1 != null && (this.outlineNeeded) && Float.intBitsToFloat(((int)(this.rectSize >> 0x20))) > 0f && Float.intBitsToFloat(((int)(this.rectSize & 0xFFFFFFFFL))) > 0f) {
                this.isSupportedOutline = true;
                if((v1 instanceof Rectangle)) {
                    this.updateCacheWithRect(((Rectangle)v1).getRect());
                    return;
                }
                else if((v1 instanceof Rounded)) {
                    this.updateCacheWithRoundRect(((Rounded)v1).getRoundRect());
                    return;
                }
                else if((v1 instanceof Generic)) {
                    this.updateCacheWithPath(((Generic)v1).getPath());
                    return;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            this.cachedOutline.setEmpty();
        }
    }

    private final void updateCacheWithPath(Path arg4) {
        if(Build$VERSION.SDK_INT > 28 || (arg4.isConvex())) {
            if(Build$VERSION.SDK_INT >= 30) {
                OutlineVerificationHelper.INSTANCE.setPath(this.cachedOutline, arg4);
            }
            else {
                Outline v0 = this.cachedOutline;
                if((arg4 instanceof AndroidPath)) {
                    v0.setConvexPath(arg4.getInternalPath());
                }
                else {
                    goto label_32;
                }
            }

            this.usePathForClip = this.cachedOutline.canClip() ^ 1;
        }
        else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }

        this.outlinePath = arg4;
        return;
    label_32:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    private final void updateCacheWithRect(Rect arg8) {
        this.rectTopLeft = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg8.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg8.getLeft()))) << 0x20);
        this.rectSize = Size.constructor-impl((((long)Float.floatToRawIntBits(arg8.getBottom() - arg8.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg8.getRight() - arg8.getLeft()))) << 0x20);
        this.cachedOutline.setRect(Math.round(arg8.getLeft()), Math.round(arg8.getTop()), Math.round(arg8.getRight()), Math.round(arg8.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect arg10) {
        float v8 = Float.intBitsToFloat(((int)(arg10.getTopLeftCornerRadius-kKHJgLs() >> 0x20)));
        this.rectTopLeft = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg10.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg10.getLeft()))) << 0x20);
        this.rectSize = Size.constructor-impl((((long)Float.floatToRawIntBits(arg10.getHeight()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg10.getWidth()))) << 0x20);
        if(RoundRectKt.isSimple(arg10)) {
            this.cachedOutline.setRoundRect(Math.round(arg10.getLeft()), Math.round(arg10.getTop()), Math.round(arg10.getRight()), Math.round(arg10.getBottom()), v8);
            this.roundedCornerRadius = v8;
            return;
        }

        Path v0 = this.cachedRrectPath;
        if(v0 == null) {
            v0 = AndroidPath_androidKt.Path();
            this.cachedRrectPath = v0;
        }

        v0.reset();
        Path.addRoundRect$default(v0, arg10, null, 2, null);
        this.updateCacheWithPath(v0);
    }
}

