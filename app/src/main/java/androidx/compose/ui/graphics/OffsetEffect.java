package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001A\u00020\tH\u0015J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/graphics/OffsetEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/ui/graphics/RenderEffect;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OffsetEffect extends RenderEffect {
    public static final int $stable;
    private final long offset;
    private final RenderEffect renderEffect;

    static {
    }

    private OffsetEffect(RenderEffect arg2, long arg3) {
        super(null);
        this.renderEffect = arg2;
        this.offset = arg3;
    }

    public OffsetEffect(RenderEffect arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    protected android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.createOffsetEffect-Uv8p0NA(this.renderEffect, this.offset);
    }

    public boolean equals(Object arg6) {
        if(this == (((OffsetEffect)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof OffsetEffect)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.renderEffect, ((OffsetEffect)arg6).renderEffect)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.offset, ((OffsetEffect)arg6).offset)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        RenderEffect v0 = this.renderEffect;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        return v0_1 * 0x1F + Offset.hashCode-impl(this.offset);
    }

    public String toString() {
        return "OffsetEffect(renderEffect=" + this.renderEffect + ", offset=" + Offset.toString-impl(this.offset) + ')';
    }
}

