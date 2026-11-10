package androidx.savedstate.serialization;

import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;

@Metadata(d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\'\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001A$\u0010\u0006\u001A\u0012\u0012\u000E\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b0\u00072\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u000B"}, d2={"decodeFormatSpecificTypesOnPlatform", "T", "Landroidx/savedstate/serialization/SavedStateDecoder;", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Landroidx/savedstate/serialization/SavedStateDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "getArrayKClass", "Lkotlin/reflect/KClass;", "", "", "referenceArraySerializer", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateDecoder_androidKt {
    public static final Object decodeFormatSpecificTypesOnPlatform(SavedStateDecoder arg2, DeserializationStrategy arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "strategy");
        SerialDescriptor v0 = arg3.getDescriptor();
        if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return CharSequenceSerializer.INSTANCE.deserialize(((Decoder)arg2));
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return DefaultParcelableSerializer.INSTANCE.deserialize(((Decoder)arg2));
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return DefaultJavaSerializableSerializer.INSTANCE.deserialize(((Decoder)arg2));
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return IBinderSerializer.INSTANCE.deserialize(((Decoder)arg2));
        }

        if(!Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor())) {
            if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            }
            else {
                if(!Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor())) {
                    if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
                    }
                    else if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
                        Parcelable[] v2 = ParcelableArraySerializer.INSTANCE.deserialize(((Decoder)arg2));
                        return Arrays.copyOf(((Object[])v2), v2.length, JvmClassMappingKt.getJavaClass(SavedStateDecoder_androidKt.getArrayKClass(arg3)));
                    }
                    else if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
                        return ParcelableArraySerializer.INSTANCE.deserialize(((Decoder)arg2));
                    }
                    else {
                        if(!Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getParcelableListDescriptor())) {
                            if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
                            }
                            else {
                                if(!Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor())) {
                                    if(Intrinsics.areEqual(v0, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                                    }
                                    else {
                                        return null;
                                    }
                                }

                                return SparseParcelableArraySerializer.INSTANCE.deserialize(((Decoder)arg2));
                            }
                        }

                        return ParcelableListSerializer.INSTANCE.deserialize(((Decoder)arg2));
                    }
                }

                return CharSequenceListSerializer.INSTANCE.deserialize(((Decoder)arg2));
            }
        }

        return CharSequenceArraySerializer.INSTANCE.deserialize(((Decoder)arg2));
    }

    private static final KClass getArrayKClass(DeserializationStrategy arg1) {
        Object v1 = arg1.deserialize(EmptyArrayDecoder.INSTANCE);
        Intrinsics.checkNotNull(v1);
        return Reflection.getOrCreateKotlinClass(v1.getClass());
    }
}

