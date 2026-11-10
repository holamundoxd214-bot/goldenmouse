package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0003\"\u0014\u0010\f\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0003\"\u0014\u0010\u000E\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0003\"\u0014\u0010\u0010\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0003\"\u001A\u0010\u0012\u001A\u00020\u0001X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, d2={"intListDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getIntListDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "stringListDescriptor", "getStringListDescriptor", "booleanArrayDescriptor", "getBooleanArrayDescriptor", "charArrayDescriptor", "getCharArrayDescriptor", "doubleArrayDescriptor", "getDoubleArrayDescriptor", "floatArrayDescriptor", "getFloatArrayDescriptor", "intArrayDescriptor", "getIntArrayDescriptor", "longArrayDescriptor", "getLongArrayDescriptor", "stringArrayDescriptor", "getStringArrayDescriptor$annotations", "()V", "getStringArrayDescriptor", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateCodecUtilsKt {
    private static final SerialDescriptor booleanArrayDescriptor;
    private static final SerialDescriptor charArrayDescriptor;
    private static final SerialDescriptor doubleArrayDescriptor;
    private static final SerialDescriptor floatArrayDescriptor;
    private static final SerialDescriptor intArrayDescriptor;
    private static final SerialDescriptor intListDescriptor;
    private static final SerialDescriptor longArrayDescriptor;
    private static final SerialDescriptor stringArrayDescriptor;
    private static final SerialDescriptor stringListDescriptor;

    static {
        SavedStateCodecUtilsKt.intListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)).getDescriptor();
        SavedStateCodecUtilsKt.stringListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)).getDescriptor();
        SavedStateCodecUtilsKt.booleanArrayDescriptor = BuiltinSerializersKt.BooleanArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.charArrayDescriptor = BuiltinSerializersKt.CharArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.doubleArrayDescriptor = BuiltinSerializersKt.DoubleArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.floatArrayDescriptor = BuiltinSerializersKt.FloatArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.intArrayDescriptor = BuiltinSerializersKt.IntArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.longArrayDescriptor = BuiltinSerializersKt.LongArraySerializer().getDescriptor();
        SavedStateCodecUtilsKt.stringArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE)).getDescriptor();
    }

    public static final SerialDescriptor getBooleanArrayDescriptor() {
        return SavedStateCodecUtilsKt.booleanArrayDescriptor;
    }

    public static final SerialDescriptor getCharArrayDescriptor() {
        return SavedStateCodecUtilsKt.charArrayDescriptor;
    }

    public static final SerialDescriptor getDoubleArrayDescriptor() {
        return SavedStateCodecUtilsKt.doubleArrayDescriptor;
    }

    public static final SerialDescriptor getFloatArrayDescriptor() {
        return SavedStateCodecUtilsKt.floatArrayDescriptor;
    }

    public static final SerialDescriptor getIntArrayDescriptor() {
        return SavedStateCodecUtilsKt.intArrayDescriptor;
    }

    public static final SerialDescriptor getIntListDescriptor() {
        return SavedStateCodecUtilsKt.intListDescriptor;
    }

    public static final SerialDescriptor getLongArrayDescriptor() {
        return SavedStateCodecUtilsKt.longArrayDescriptor;
    }

    public static final SerialDescriptor getStringArrayDescriptor() {
        return SavedStateCodecUtilsKt.stringArrayDescriptor;
    }

    public static void getStringArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getStringListDescriptor() {
        return SavedStateCodecUtilsKt.stringListDescriptor;
    }
}

