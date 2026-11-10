package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR \u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/AnimationDataConverter;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/foundation/gestures/AnimationData;", "Landroidx/compose/animation/core/AnimationVector4D;", "<init>", "()V", "convertToVector", "Lkotlin/Function1;", "getConvertToVector", "()Lkotlin/jvm/functions/Function1;", "convertFromVector", "getConvertFromVector", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimationDataConverter implements TwoWayConverter {
    public static final AnimationDataConverter INSTANCE;

    static {
        AnimationDataConverter.INSTANCE = new AnimationDataConverter();
    }

    private AnimationDataConverter() {
        super();
    }

    static final AnimationData _get_convertFromVector_$lambda$0(AnimationVector4D arg8) {
        return new AnimationData(arg8.getV1(), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg8.getV3()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg8.getV2()))) << 0x20), arg8.getV4(), null);
    }

    static final AnimationVector4D _get_convertToVector_$lambda$0(AnimationData arg7) {
        return new AnimationVector4D(arg7.getZoom(), Float.intBitsToFloat(((int)(arg7.getOffset-F1C5BW0() >> 0x20))), Float.intBitsToFloat(((int)(arg7.getOffset-F1C5BW0() & 0xFFFFFFFFL))), arg7.getDegrees());
    }

    public Function1 getConvertFromVector() {
        return new AnimationDataConverter$$ExternalSyntheticLambda1();
    }

    public Function1 getConvertToVector() {
        return new AnimationDataConverter$$ExternalSyntheticLambda0();
    }
}

