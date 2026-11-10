package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0003\"\u001A\u0010\n\u001A\u00020\u0001X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u0003\"\u001A\u0010\u000E\u001A\u00020\u0001X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u0003\"\u0014\u0010\u0011\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0003\"\u0014\u0010\u0013\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0003\"\u001A\u0010\u0015\u001A\u00020\u0001X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0016\u0010\f\u001A\u0004\b\u0017\u0010\u0003\"\u001A\u0010\u0018\u001A\u00020\u0001X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0019\u0010\f\u001A\u0004\b\u001A\u0010\u0003\"\u0014\u0010\u001B\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0003\"\u0014\u0010\u001D\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0003\"\u0014\u0010\u001F\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0003\"\u0014\u0010!\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0003\"\u0014\u0010#\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0003¨\u0006%"}, d2={"polymorphicCharSequenceDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getPolymorphicCharSequenceDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "polymorphicParcelableDescriptor", "getPolymorphicParcelableDescriptor", "polymorphicJavaSerializableDescriptor", "getPolymorphicJavaSerializableDescriptor", "polymorphicIBinderDescriptor", "getPolymorphicIBinderDescriptor", "parcelableArrayDescriptor", "getParcelableArrayDescriptor$annotations", "()V", "getParcelableArrayDescriptor", "polymorphicParcelableArrayDescriptor", "getPolymorphicParcelableArrayDescriptor$annotations", "getPolymorphicParcelableArrayDescriptor", "parcelableListDescriptor", "getParcelableListDescriptor", "polymorphicParcelableListDescriptor", "getPolymorphicParcelableListDescriptor", "charSequenceArrayDescriptor", "getCharSequenceArrayDescriptor$annotations", "getCharSequenceArrayDescriptor", "polymorphicCharSequenceArrayDescriptor", "getPolymorphicCharSequenceArrayDescriptor$annotations", "getPolymorphicCharSequenceArrayDescriptor", "charSequenceListDescriptor", "getCharSequenceListDescriptor", "polymorphicCharSequenceListDescriptor", "getPolymorphicCharSequenceListDescriptor", "sparseParcelableArrayDescriptor", "getSparseParcelableArrayDescriptor", "polymorphicSparseParcelableArrayDescriptor", "getPolymorphicSparseParcelableArrayDescriptor", "nullablePolymorphicSparseParcelableArrayDescriptor", "getNullablePolymorphicSparseParcelableArrayDescriptor", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateCodecUtils_androidKt {
    private static final SerialDescriptor charSequenceArrayDescriptor;
    private static final SerialDescriptor charSequenceListDescriptor;
    private static final SerialDescriptor nullablePolymorphicSparseParcelableArrayDescriptor;
    private static final SerialDescriptor parcelableArrayDescriptor;
    private static final SerialDescriptor parcelableListDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceArrayDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceDescriptor;
    private static final SerialDescriptor polymorphicCharSequenceListDescriptor;
    private static final SerialDescriptor polymorphicIBinderDescriptor;
    private static final SerialDescriptor polymorphicJavaSerializableDescriptor;
    private static final SerialDescriptor polymorphicParcelableArrayDescriptor;
    private static final SerialDescriptor polymorphicParcelableDescriptor;
    private static final SerialDescriptor polymorphicParcelableListDescriptor;
    private static final SerialDescriptor polymorphicSparseParcelableArrayDescriptor;
    private static final SerialDescriptor sparseParcelableArrayDescriptor;

    static {
        Class v1 = CharSequence.class;
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceDescriptor = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v1)).getDescriptor();
        Class v2 = Parcelable.class;
        SavedStateCodecUtils_androidKt.polymorphicParcelableDescriptor = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v2)).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicJavaSerializableDescriptor = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Serializable.class)).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicIBinderDescriptor = new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(IBinder.class)).getDescriptor();
        SavedStateCodecUtils_androidKt.parcelableArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(v2), DefaultParcelableSerializer.INSTANCE).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicParcelableArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(v2), new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v2))).getDescriptor();
        SavedStateCodecUtils_androidKt.parcelableListDescriptor = BuiltinSerializersKt.ListSerializer(DefaultParcelableSerializer.INSTANCE).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicParcelableListDescriptor = BuiltinSerializersKt.ListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v2))).getDescriptor();
        SavedStateCodecUtils_androidKt.charSequenceArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(v1), CharSequenceSerializer.INSTANCE).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(v1), new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v1))).getDescriptor();
        SavedStateCodecUtils_androidKt.charSequenceListDescriptor = BuiltinSerializersKt.ListSerializer(CharSequenceSerializer.INSTANCE).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicCharSequenceListDescriptor = BuiltinSerializersKt.ListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v1))).getDescriptor();
        SavedStateCodecUtils_androidKt.sparseParcelableArrayDescriptor = new SparseArraySerializer(DefaultParcelableSerializer.INSTANCE).getDescriptor();
        SavedStateCodecUtils_androidKt.polymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v2))).getDescriptor();
        SavedStateCodecUtils_androidKt.nullablePolymorphicSparseParcelableArrayDescriptor = new SparseArraySerializer(BuiltinSerializersKt.getNullable(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(v2)))).getDescriptor();
    }

    public static final SerialDescriptor getCharSequenceArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.charSequenceArrayDescriptor;
    }

    public static void getCharSequenceArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getCharSequenceListDescriptor() {
        return SavedStateCodecUtils_androidKt.charSequenceListDescriptor;
    }

    public static final SerialDescriptor getNullablePolymorphicSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.nullablePolymorphicSparseParcelableArrayDescriptor;
    }

    public static final SerialDescriptor getParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.parcelableArrayDescriptor;
    }

    public static void getParcelableArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getParcelableListDescriptor() {
        return SavedStateCodecUtils_androidKt.parcelableListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicCharSequenceArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceArrayDescriptor;
    }

    public static void getPolymorphicCharSequenceArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getPolymorphicCharSequenceDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceDescriptor;
    }

    public static final SerialDescriptor getPolymorphicCharSequenceListDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicCharSequenceListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicIBinderDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicIBinderDescriptor;
    }

    public static final SerialDescriptor getPolymorphicJavaSerializableDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicJavaSerializableDescriptor;
    }

    public static final SerialDescriptor getPolymorphicParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableArrayDescriptor;
    }

    public static void getPolymorphicParcelableArrayDescriptor$annotations() {
    }

    public static final SerialDescriptor getPolymorphicParcelableDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableDescriptor;
    }

    public static final SerialDescriptor getPolymorphicParcelableListDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicParcelableListDescriptor;
    }

    public static final SerialDescriptor getPolymorphicSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.polymorphicSparseParcelableArrayDescriptor;
    }

    public static final SerialDescriptor getSparseParcelableArrayDescriptor() {
        return SavedStateCodecUtils_androidKt.sparseParcelableArrayDescriptor;
    }
}

