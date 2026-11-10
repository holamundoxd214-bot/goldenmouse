package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001C2\u00020\u0001:\u0002\u001B\u001CB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001A\u00020\u0003H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\u000E\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\tJ\u001F\u0010\u0018\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0019\u0010\u001AR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\u000E\u0010\u0012\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/material/ripple/UnprojectedRipple;", "Landroid/graphics/drawable/RippleDrawable;", "bounded", "", "<init>", "(Z)V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "rippleRadius", "", "Ljava/lang/Integer;", "setColor", "", "color", "alpha", "", "setColor-DxMtmZc", "(JF)V", "projected", "isProjected", "getDirtyBounds", "Landroid/graphics/Rect;", "trySetRadius", "radius", "calculateRippleColor", "calculateRippleColor-5vOe2sY", "(JF)J", "MRadiusHelper", "Companion", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class UnprojectedRipple extends RippleDrawable {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/material/ripple/UnprojectedRipple$Companion;", "", "<init>", "()V", "setMaxRadiusMethod", "Ljava/lang/reflect/Method;", "setMaxRadiusFetched", "", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/compose/material/ripple/UnprojectedRipple$MRadiusHelper;", "", "<init>", "()V", "setRadius", "", "ripple", "Landroid/graphics/drawable/RippleDrawable;", "radius", "", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class MRadiusHelper {
        public static final MRadiusHelper INSTANCE;

        static {
            MRadiusHelper.INSTANCE = new MRadiusHelper();
        }

        private MRadiusHelper() {
            super();
        }

        public final void setRadius(RippleDrawable arg1, int arg2) {
            arg1.setRadius(arg2);
        }
    }

    public static final Companion Companion;
    private final boolean bounded;
    private boolean projected;
    private Color rippleColor;
    private Integer rippleRadius;
    private static boolean setMaxRadiusFetched;
    private static Method setMaxRadiusMethod;

    static {
        UnprojectedRipple.Companion = new Companion(null);
    }

    public UnprojectedRipple(boolean arg5) {
        Drawable v2_1;
        ColorStateList v0 = ColorStateList.valueOf(0xFF000000);
        Drawable v1 = null;
        if(arg5) {
            ColorDrawable v2 = new ColorDrawable(-1);
        }
        else {
            v2_1 = v1;
        }

        super(v0, v1, v2_1);
        this.bounded = arg5;
    }

    private final long calculateRippleColor-5vOe2sY(long arg9, float arg11) {
        if(Build$VERSION.SDK_INT < 28) {
            arg11 *= 2f;
        }

        return Color.copy-wmQWz5c$default(arg9, RangesKt.coerceAtMost(arg11, 1f), 0f, 0f, 0f, 14, null);
    }

    public Rect getDirtyBounds() {
        if(!this.bounded) {
            this.projected = true;
        }

        Rect v0 = super.getDirtyBounds();
        this.projected = false;
        return v0;
    }

    public boolean isProjected() {
        return this.projected;
    }

    public final void setColor-DxMtmZc(long arg3, float arg5) {
        arg3 = this.calculateRippleColor-5vOe2sY(arg3, arg5);
        Color v5 = this.rippleColor;
        boolean v5_1 = v5 == null ? false : Color.equals-impl0(v5.unbox-impl(), arg3);
        if(!v5_1) {
            this.rippleColor = Color.box-impl(arg3);
            this.setColor(ColorStateList.valueOf(ColorKt.toArgb-8_81llA(arg3)));
        }
    }

    public final void trySetRadius(int arg2) {
        Integer v0 = this.rippleRadius;
        if(v0 == null || v0.intValue() != arg2) {
            this.rippleRadius = Integer.valueOf(arg2);
            MRadiusHelper.INSTANCE.setRadius(((RippleDrawable)this), arg2);
        }
    }
}

