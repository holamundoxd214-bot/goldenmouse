package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J$\u0010\u0019\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00060\u000BHÆ\u0003J\t\u0010\u001B\u001A\u00020\rHÆ\u0003JR\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032#\b\u0002\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00052\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B2\b\b\u0002\u0010\f\u001A\u00020\rHÆ\u0001J\u0013\u0010\u001D\u001A\u00020\r2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R,\u0010\u0004\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2={"Landroidx/compose/animation/ChangeSize;", "", "alignment", "Landroidx/compose/ui/Alignment;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "clip", "", "<init>", "(Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getSize", "()Lkotlin/jvm/functions/Function1;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getClip", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChangeSize {
    public static final int $stable;
    private final Alignment alignment;
    private final FiniteAnimationSpec animationSpec;
    private final boolean clip;
    private final Function1 size;

    static {
    }

    public ChangeSize(Alignment arg1, Function1 arg2, FiniteAnimationSpec arg3, boolean arg4) {
        super();
        this.alignment = arg1;
        this.size = arg2;
        this.animationSpec = arg3;
        this.clip = arg4;
    }

    public ChangeSize(Alignment arg1, Function1 arg2, FiniteAnimationSpec arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        androidx.compose.animation.ChangeSize$1 v2;
        if((arg5 & 2) != 0) {
            v2 = androidx.compose.animation.ChangeSize$1.INSTANCE;
        }

        this(arg1, ((Function1)v2), arg3, true);
    }

    public final Alignment component1() {
        return this.alignment;
    }

    public final Function1 component2() {
        return this.size;
    }

    public final FiniteAnimationSpec component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.clip;
    }

    public final ChangeSize copy(Alignment arg1, Function1 arg2, FiniteAnimationSpec arg3, boolean arg4) {
        return new ChangeSize(arg1, arg2, arg3, arg4);
    }

    public static ChangeSize copy$default(ChangeSize arg0, Alignment arg1, Function1 arg2, FiniteAnimationSpec arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.alignment;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.size;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.animationSpec;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.clip;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((ChangeSize)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ChangeSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.alignment, ((ChangeSize)arg5).alignment)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.size, ((ChangeSize)arg5).size)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((ChangeSize)arg5).animationSpec)) {
            return 0;
        }

        if(this.clip != ((ChangeSize)arg5).clip) {
            return 0;
        }

        return 1;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final Function1 getSize() {
        return this.size;
    }

    public int hashCode() {
        return ((this.alignment.hashCode() * 0x1F + this.size.hashCode()) * 0x1F + this.animationSpec.hashCode()) * 0x1F + Boolean.hashCode(this.clip);
    }

    public String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ')';
    }
}

