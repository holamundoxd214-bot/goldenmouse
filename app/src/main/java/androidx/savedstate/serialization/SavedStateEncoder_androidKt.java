package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A-\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001A\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"encodeFormatSpecificTypesOnPlatform", "", "T", "Landroidx/savedstate/serialization/SavedStateEncoder;", "strategy", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Landroidx/savedstate/serialization/SavedStateEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Z", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateEncoder_androidKt {
    public static final boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder arg1, SerializationStrategy arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "strategy");
        SerialDescriptor v2 = arg2.getDescriptor();
        if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer v2_1 = CharSequenceSerializer.INSTANCE;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.CharSequence");
            v2_1.serialize(((Encoder)arg1), ((CharSequence)arg3));
        }
        else if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer v2_2 = DefaultParcelableSerializer.INSTANCE;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type android.os.Parcelable");
            v2_2.serialize(((Encoder)arg1), ((Parcelable)arg3));
        }
        else if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer v2_3 = DefaultJavaSerializableSerializer.INSTANCE;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type java.io.Serializable");
            v2_3.serialize(((Encoder)arg1), ((Serializable)arg3));
        }
        else if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer v2_4 = IBinderSerializer.INSTANCE;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type android.os.IBinder");
            v2_4.serialize(((Encoder)arg1), ((IBinder)arg3));
        }
        else {
            if(!Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor())) {
                if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
                }
                else {
                    if(!Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor())) {
                        if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
                        }
                        else {
                            if(!Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
                                if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
                                }
                                else {
                                    if(!Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getParcelableListDescriptor())) {
                                        if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
                                        }
                                        else {
                                            if(!Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor())) {
                                                if(Intrinsics.areEqual(v2, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
                                                }
                                                else {
                                                    return 0;
                                                }
                                            }

                                            SparseParcelableArraySerializer v2_5 = SparseParcelableArraySerializer.INSTANCE;
                                            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
                                            v2_5.serialize(((Encoder)arg1), ((SparseArray)arg3));
                                            return 1;
                                        }
                                    }

                                    ParcelableListSerializer v2_6 = ParcelableListSerializer.INSTANCE;
                                    Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
                                    v2_6.serialize(((Encoder)arg1), ((List)arg3));
                                    return 1;
                                }
                            }

                            ParcelableArraySerializer v2_7 = ParcelableArraySerializer.INSTANCE;
                            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                            v2_7.serialize(((Encoder)arg1), ((Parcelable[])arg3));
                            return 1;
                        }
                    }

                    CharSequenceListSerializer v2_8 = CharSequenceListSerializer.INSTANCE;
                    Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
                    v2_8.serialize(((Encoder)arg1), ((List)arg3));
                    return 1;
                }
            }

            CharSequenceArraySerializer v2_9 = CharSequenceArraySerializer.INSTANCE;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            v2_9.serialize(((Encoder)arg1), ((CharSequence[])arg3));
        }

        return 1;
    }
}

