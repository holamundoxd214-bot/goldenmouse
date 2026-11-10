package androidx.savedstate.serialization;

import android.os.Bundle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001A.\u0010\u0000\u001A\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\b\u001A;\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000B2\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\f\u001A9\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000B2\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\f¨\u0006\r"}, d2={"decodeFromSavedState", "T", "", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "decodeFromSavedStateNullable", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateDecoderKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'decodeFromSavedState\' overload that supports both nullable and non-nullable types.") public static final Object decodeFromSavedState(Bundle arg3, SavedStateConfiguration arg4) {
        Intrinsics.checkNotNullParameter(arg3, "savedState");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        SerializersModule v0 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedStateNullable(SerializersKt.serializer(v0, null), arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'decodeFromSavedState\' overload that supports both nullable and non-nullable types.") public static final Object decodeFromSavedState(DeserializationStrategy arg2, Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "deserializer");
        Intrinsics.checkNotNullParameter(arg3, "savedState");
        return SavedStateDecoderKt.decodeFromSavedState$default(arg2, arg3, null, 4, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'decodeFromSavedState\' overload that supports both nullable and non-nullable types.") public static final Object decodeFromSavedState(DeserializationStrategy arg1, Bundle arg2, SavedStateConfiguration arg3) {
        Intrinsics.checkNotNullParameter(arg1, "deserializer");
        Intrinsics.checkNotNullParameter(arg2, "savedState");
        Intrinsics.checkNotNullParameter(arg3, "configuration");
        return new SavedStateDecoder(arg2, arg3).decodeSerializableValue(arg1);
    }

    public static Object decodeFromSavedState$default(DeserializationStrategy arg0, Bundle arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateDecoderKt.decodeFromSavedState(arg0, arg1, arg2);
    }

    public static Object decodeFromSavedState$default(Bundle arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg1, "savedState");
        Intrinsics.checkNotNullParameter(arg2, "configuration");
        SerializersModule v3 = arg2.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedStateNullable(SerializersKt.serializer(v3, null), arg1, arg2);
    }

    public static final Object decodeFromSavedStateNullable(DeserializationStrategy arg1, Bundle arg2, SavedStateConfiguration arg3) {
        Intrinsics.checkNotNullParameter(arg1, "deserializer");
        Intrinsics.checkNotNullParameter(arg2, "savedState");
        Intrinsics.checkNotNullParameter(arg3, "configuration");
        return new SavedStateDecoder(arg2, arg3).decodeSerializableValue(arg1);
    }

    public static final Object decodeFromSavedStateNullable(Bundle arg3, SavedStateConfiguration arg4) {
        Intrinsics.checkNotNullParameter(arg3, "savedState");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        SerializersModule v0 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedStateNullable(SerializersKt.serializer(v0, null), arg3, arg4);
    }

    public static final Object decodeFromSavedStateNullable(DeserializationStrategy arg2, Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "deserializer");
        Intrinsics.checkNotNullParameter(arg3, "savedState");
        return SavedStateDecoderKt.decodeFromSavedStateNullable$default(arg2, arg3, null, 4, null);
    }

    public static Object decodeFromSavedStateNullable$default(DeserializationStrategy arg0, Bundle arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateDecoderKt.decodeFromSavedStateNullable(arg0, arg1, arg2);
    }

    public static Object decodeFromSavedStateNullable$default(Bundle arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg1, "savedState");
        Intrinsics.checkNotNullParameter(arg2, "configuration");
        SerializersModule v3 = arg2.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateDecoderKt.decodeFromSavedStateNullable(SerializersKt.serializer(v3, null), arg1, arg2);
    }
}

