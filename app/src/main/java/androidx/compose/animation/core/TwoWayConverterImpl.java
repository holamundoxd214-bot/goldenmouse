package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B/\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tR \u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\r"}, d2={"Landroidx/compose/animation/core/TwoWayConverterImpl;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getConvertToVector", "()Lkotlin/jvm/functions/Function1;", "getConvertFromVector", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class TwoWayConverterImpl implements TwoWayConverter {
    private final Function1 convertFromVector;
    private final Function1 convertToVector;

    public TwoWayConverterImpl(Function1 arg1, Function1 arg2) {
        super();
        this.convertToVector = arg1;
        this.convertFromVector = arg2;
    }

    public Function1 getConvertFromVector() {
        return this.convertFromVector;
    }

    public Function1 getConvertToVector() {
        return this.convertToVector;
    }
}

