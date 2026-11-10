package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000B\u001A\u00020\fH\u0015J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Landroidx/compose/ui/graphics/RenderEffect;FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BlurEffect extends RenderEffect {
    public static final int $stable;
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    private final RenderEffect renderEffect;

    static {
    }

    private BlurEffect(RenderEffect arg2, float arg3, float arg4, int arg5) {
        super(null);
        this.renderEffect = arg2;
        this.radiusX = arg3;
        this.radiusY = arg4;
        this.edgeTreatment = arg5;
    }

    public BlurEffect(RenderEffect arg1, float arg2, float arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg3 = arg2;
        }

        if((arg5 & 8) != 0) {
            arg4 = TileMode.Companion.getClamp-3opZhB0();
        }

        this(arg1, arg2, arg3, arg4, null);
    }

    public BlurEffect(RenderEffect arg1, float arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    protected android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.createBlurEffect-8A-3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(Object arg5) {
        if(this == (((BlurEffect)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BlurEffect)) {
            return 0;
        }

        if(this.radiusX == ((BlurEffect)arg5).radiusX && this.radiusY == ((BlurEffect)arg5).radiusY) {
            if(!TileMode.equals-impl0(this.edgeTreatment, ((BlurEffect)arg5).edgeTreatment)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.renderEffect, ((BlurEffect)arg5).renderEffect)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        RenderEffect v0 = this.renderEffect;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        return ((v0_1 * 0x1F + Float.hashCode(this.radiusX)) * 0x1F + Float.hashCode(this.radiusY)) * 0x1F + TileMode.hashCode-impl(this.edgeTreatment);
    }

    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + TileMode.toString-impl(this.edgeTreatment) + ')';
    }
}

