package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize$Companion;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1={"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001AJ\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006\u001A!\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0080\b\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\u0001*\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000E0\u0001*\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0014\"\u001A\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000E0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00198F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u001A\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u000E0\u0001*\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u001D\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001F0\u0001*\u00020 8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010!\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001F0\u0001*\u00020#8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010$\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001F0\u0001*\u00020&8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\'\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001F0\u0001*\u00020)8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010*\"!\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001F0\u0001*\u00020,8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010-\"\u001A\u0010.\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u000E0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010/\u001A\u000E\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001F0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00100\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001F0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00101\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001F0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00102\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001F0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00103\u001A\u000E\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001F0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u00104\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2={"TwoWayConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "lerp", "", "start", "stop", "fraction", "VectorConverter", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlin/Float$Companion;", "getVectorConverter", "(Lkotlin/jvm/internal/FloatCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "FloatToVector", "IntToVector", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "DpToVector", "DpOffsetToVector", "SizeToVector", "OffsetToVector", "IntOffsetToVector", "IntSizeToVector", "RectToVector", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VectorConvertersKt {
    private static final TwoWayConverter DpOffsetToVector;
    private static final TwoWayConverter DpToVector;
    private static final TwoWayConverter FloatToVector;
    private static final TwoWayConverter IntOffsetToVector;
    private static final TwoWayConverter IntSizeToVector;
    private static final TwoWayConverter IntToVector;
    private static final TwoWayConverter OffsetToVector;
    private static final TwoWayConverter RectToVector;
    private static final TwoWayConverter SizeToVector;

    static {
        VectorConvertersKt.FloatToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda0(), new VectorConvertersKt$$ExternalSyntheticLambda17());
        VectorConvertersKt.IntToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda1(), new VectorConvertersKt$$ExternalSyntheticLambda2());
        VectorConvertersKt.DpToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda3(), new VectorConvertersKt$$ExternalSyntheticLambda4());
        VectorConvertersKt.DpOffsetToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda5(), new VectorConvertersKt$$ExternalSyntheticLambda6());
        VectorConvertersKt.SizeToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda7(), new VectorConvertersKt$$ExternalSyntheticLambda8());
        VectorConvertersKt.OffsetToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda9(), new VectorConvertersKt$$ExternalSyntheticLambda10());
        VectorConvertersKt.IntOffsetToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda11(), new VectorConvertersKt$$ExternalSyntheticLambda12());
        VectorConvertersKt.IntSizeToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda13(), new VectorConvertersKt$$ExternalSyntheticLambda14());
        VectorConvertersKt.RectToVector = VectorConvertersKt.TwoWayConverter(new VectorConvertersKt$$ExternalSyntheticLambda15(), new VectorConvertersKt$$ExternalSyntheticLambda16());
    }

    static final AnimationVector2D DpOffsetToVector$lambda$0(DpOffset arg4) {
        return new AnimationVector2D(DpOffset.getX-D9Ej5fM(arg4.unbox-impl()), DpOffset.getY-D9Ej5fM(arg4.unbox-impl()));
    }

    static final DpOffset DpOffsetToVector$lambda$1(AnimationVector2D arg6) {
        return DpOffset.box-impl(DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(arg6.getV1())))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(arg6.getV2())))) & 0xFFFFFFFFL));
    }

    static final AnimationVector1D DpToVector$lambda$0(Dp arg1) {
        return new AnimationVector1D(arg1.unbox-impl());
    }

    static final Dp DpToVector$lambda$1(AnimationVector1D arg0) {
        return Dp.box-impl(Dp.constructor-impl(arg0.getValue()));
    }

    static final AnimationVector1D FloatToVector$lambda$0(float arg1) {
        return new AnimationVector1D(arg1);
    }

    static final float FloatToVector$lambda$1(AnimationVector1D arg0) {
        return arg0.getValue();
    }

    static final AnimationVector2D IntOffsetToVector$lambda$0(IntOffset arg4) {
        return new AnimationVector2D(((float)IntOffset.getX-impl(arg4.unbox-impl())), ((float)IntOffset.getY-impl(arg4.unbox-impl())));
    }

    static final IntOffset IntOffsetToVector$lambda$1(AnimationVector2D arg6) {
        return IntOffset.box-impl(IntOffset.constructor-impl((((long)Math.round(arg6.getV1()))) << 0x20 | (((long)Math.round(arg6.getV2()))) & 0xFFFFFFFFL));
    }

    static final AnimationVector2D IntSizeToVector$lambda$0(IntSize arg6) {
        return new AnimationVector2D(((float)(((int)(arg6.unbox-impl() >> 0x20)))), ((float)(((int)(arg6.unbox-impl() & 0xFFFFFFFFL)))));
    }

    static final IntSize IntSizeToVector$lambda$1(AnimationVector2D arg6) {
        int v0 = Math.round(arg6.getV1());
        int v1 = 0;
        if(v0 < 0) {
            v0 = 0;
        }

        int v6 = Math.round(arg6.getV2());
        if(v6 < 0) {
        }
        else {
            v1 = v6;
        }

        return IntSize.box-impl(IntSize.constructor-impl((((long)v1)) & 0xFFFFFFFFL | (((long)v0)) << 0x20));
    }

    static final AnimationVector1D IntToVector$lambda$0(int arg1) {
        return new AnimationVector1D(((float)arg1));
    }

    static final int IntToVector$lambda$1(AnimationVector1D arg0) {
        return ((int)arg0.getValue());
    }

    static final AnimationVector2D OffsetToVector$lambda$0(Offset arg6) {
        return new AnimationVector2D(Float.intBitsToFloat(((int)(arg6.unbox-impl() >> 0x20))), Float.intBitsToFloat(((int)(arg6.unbox-impl() & 0xFFFFFFFFL))));
    }

    static final Offset OffsetToVector$lambda$1(AnimationVector2D arg6) {
        return Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getV1()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getV2()))) & 0xFFFFFFFFL));
    }

    static final AnimationVector4D RectToVector$lambda$0(Rect arg4) {
        return new AnimationVector4D(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }

    static final Rect RectToVector$lambda$1(AnimationVector4D arg4) {
        return new Rect(arg4.getV1(), arg4.getV2(), arg4.getV3(), arg4.getV4());
    }

    static final AnimationVector2D SizeToVector$lambda$0(Size arg6) {
        return new AnimationVector2D(Float.intBitsToFloat(((int)(arg6.unbox-impl() >> 0x20))), Float.intBitsToFloat(((int)(arg6.unbox-impl() & 0xFFFFFFFFL))));
    }

    static final Size SizeToVector$lambda$1(AnimationVector2D arg6) {
        return Size.box-impl(Size.constructor-impl((((long)Float.floatToRawIntBits(arg6.getV1()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getV2()))) & 0xFFFFFFFFL));
    }

    public static final TwoWayConverter TwoWayConverter(Function1 arg1, Function1 arg2) {
        return new TwoWayConverterImpl(arg1, arg2);
    }

    public static final TwoWayConverter getVectorConverter(Companion arg0) {
        return VectorConvertersKt.IntSizeToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.geometry.Rect$Companion arg0) {
        return VectorConvertersKt.RectToVector;
    }

    public static final TwoWayConverter getVectorConverter(FloatCompanionObject arg0) {
        return VectorConvertersKt.FloatToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.unit.IntOffset$Companion arg0) {
        return VectorConvertersKt.IntOffsetToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.geometry.Offset$Companion arg0) {
        return VectorConvertersKt.OffsetToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.unit.Dp$Companion arg0) {
        return VectorConvertersKt.DpToVector;
    }

    public static final TwoWayConverter getVectorConverter(IntCompanionObject arg0) {
        return VectorConvertersKt.IntToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.geometry.Size$Companion arg0) {
        return VectorConvertersKt.SizeToVector;
    }

    public static final TwoWayConverter getVectorConverter(androidx.compose.ui.unit.DpOffset$Companion arg0) {
        return VectorConvertersKt.DpOffsetToVector;
    }

    public static final float lerp(float arg1, float arg2, float arg3) {
        return arg1 * (1f - arg3) + arg2 * arg3;
    }
}

