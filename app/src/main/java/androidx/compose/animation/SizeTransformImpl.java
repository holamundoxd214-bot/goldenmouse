package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012<\u0010\u0004\u001A8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B0\u0005¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FRG\u0010\u0004\u001A8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2={"Landroidx/compose/animation/SizeTransformImpl;", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(ZLkotlin/jvm/functions/Function2;)V", "getClip", "()Z", "getSizeAnimationSpec", "()Lkotlin/jvm/functions/Function2;", "createAnimationSpec", "createAnimationSpec-TemP2vQ", "(JJ)Landroidx/compose/animation/core/FiniteAnimationSpec;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeTransformImpl implements SizeTransform {
    private final boolean clip;
    private final Function2 sizeAnimationSpec;

    public SizeTransformImpl(boolean arg1, Function2 arg2) {
        super();
        this.clip = arg1;
        this.sizeAnimationSpec = arg2;
    }

    public SizeTransformImpl(boolean arg1, Function2 arg2, int arg3, DefaultConstructorMarker arg4) {
        this(true, arg2);
    }

    public FiniteAnimationSpec createAnimationSpec-TemP2vQ(long arg1, long arg3) {
        return this.sizeAnimationSpec.invoke(IntSize.box-impl(arg1), IntSize.box-impl(arg3));
    }

    public boolean getClip() {
        return this.clip;
    }

    public final Function2 getSizeAnimationSpec() {
        return this.sizeAnimationSpec;
    }
}

