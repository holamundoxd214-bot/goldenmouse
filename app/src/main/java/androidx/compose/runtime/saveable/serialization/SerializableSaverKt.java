package androidx.compose.runtime.saveable.serialization;

import android.os.Bundle;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A/\u0010\u0000\u001A\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0080\b\u001A:\u0010\u0000\u001A\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00052\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\t2\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0000¨\u0006\n"}, d2={"serializableSaver", "Landroidx/compose/runtime/saveable/Saver;", "Serializable", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "serializer", "Lkotlinx/serialization/KSerializer;", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SerializableSaverKt {
    public static final Saver serializableSaver(KSerializer arg2, SavedStateConfiguration arg3) {
        return SaverKt.Saver(new SerializableSaverKt$$ExternalSyntheticLambda0(arg2, arg3), new SerializableSaverKt$$ExternalSyntheticLambda1(arg2, arg3));
    }

    public static final Saver serializableSaver(SavedStateConfiguration arg3) {
        SerializersModule v0 = arg3.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "Serializable");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerializableSaverKt.serializableSaver(SerializersKt.serializer(v0, null), arg3);
    }

    public static Saver serializableSaver$default(SavedStateConfiguration arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = SavedStateConfiguration.DEFAULT;
        }

        SerializersModule v2 = arg1.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "Serializable");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerializableSaverKt.serializableSaver(SerializersKt.serializer(v2, null), arg1);
    }

    public static Saver serializableSaver$default(KSerializer arg0, SavedStateConfiguration arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = SavedStateConfiguration.DEFAULT;
        }

        return SerializableSaverKt.serializableSaver(arg0, arg1);
    }

    static final Bundle serializableSaver$lambda$0(KSerializer arg0, SavedStateConfiguration arg1, SaverScope arg2, Object arg3) {
        return SavedStateEncoderKt.encodeToSavedState(((SerializationStrategy)arg0), arg3, arg1);
    }

    static final Object serializableSaver$lambda$1(KSerializer arg0, SavedStateConfiguration arg1, Bundle arg2) {
        return SavedStateDecoderKt.decodeFromSavedState(((DeserializationStrategy)arg0), arg2, arg1);
    }
}

