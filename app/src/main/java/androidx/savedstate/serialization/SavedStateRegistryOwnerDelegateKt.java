package androidx.savedstate.serialization;

import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001AP\u0010\u0000\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0002*\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\u000E\b\b\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00030\nH\u0087\bø\u0001\u0000\u001AQ\u0010\u0000\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\u000E\b\b\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00030\nH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000B\u001AV\u0010\u0000\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0002*\u00020\u00042\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00030\r2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00030\nH\u0007\u001AW\u0010\u0000\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00030\r2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00030\nH\u0007¢\u0006\u0002\b\u000B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000E"}, d2={"saved", "Lkotlin/properties/ReadWriteProperty;", "", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "key", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "savedNullable", "serializer", "Lkotlinx/serialization/KSerializer;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateRegistryOwnerDelegateKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'saved\' overload that supports both nullable and non-nullable types.") public static final ReadWriteProperty saved(SavedStateRegistryOwner arg3, String arg4, SavedStateConfiguration arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "configuration");
        Intrinsics.checkNotNullParameter(arg6, "init");
        SerializersModule v0 = arg5.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.savedNullable(arg3, SerializersKt.serializer(v0, null), arg4, arg5, arg6);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'saved\' overload that supports both nullable and non-nullable types.") public static final ReadWriteProperty saved(SavedStateRegistryOwner arg7, KSerializer arg8, String arg9, SavedStateConfiguration arg10, Function0 arg11) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "serializer");
        Intrinsics.checkNotNullParameter(arg10, "configuration");
        Intrinsics.checkNotNullParameter(arg11, "init");
        return new SavedStateRegistryOwnerDelegate(arg7.getSavedStateRegistry(), arg8, arg9, arg10, arg11);
    }

    public static ReadWriteProperty saved$default(SavedStateRegistryOwner arg2, String arg3, SavedStateConfiguration arg4, Function0 arg5, int arg6, Object arg7) {
        KType v0 = null;
        if((arg6 & 1) != 0) {
            arg3 = ((String)v0);
        }

        if((arg6 & 2) != 0) {
            arg4 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        Intrinsics.checkNotNullParameter(arg5, "init");
        SerializersModule v6 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.savedNullable(arg2, SerializersKt.serializer(v6, v0), arg3, arg4, arg5);
    }

    public static ReadWriteProperty saved$default(SavedStateRegistryOwner arg0, KSerializer arg1, String arg2, SavedStateConfiguration arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = null;
        }

        if((arg5 & 4) != 0) {
            arg3 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateRegistryOwnerDelegateKt.saved(arg0, arg1, arg2, arg3, arg4);
    }

    public static final ReadWriteProperty savedNullable(SavedStateRegistryOwner arg7, KSerializer arg8, String arg9, SavedStateConfiguration arg10, Function0 arg11) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "serializer");
        Intrinsics.checkNotNullParameter(arg10, "configuration");
        Intrinsics.checkNotNullParameter(arg11, "init");
        return new SavedStateRegistryOwnerDelegate(arg7.getSavedStateRegistry(), arg8, arg9, arg10, arg11);
    }

    public static final ReadWriteProperty savedNullable(SavedStateRegistryOwner arg3, String arg4, SavedStateConfiguration arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "configuration");
        Intrinsics.checkNotNullParameter(arg6, "init");
        SerializersModule v0 = arg5.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.savedNullable(arg3, SerializersKt.serializer(v0, null), arg4, arg5, arg6);
    }

    public static ReadWriteProperty savedNullable$default(SavedStateRegistryOwner arg2, String arg3, SavedStateConfiguration arg4, Function0 arg5, int arg6, Object arg7) {
        KType v0 = null;
        if((arg6 & 1) != 0) {
            arg3 = ((String)v0);
        }

        if((arg6 & 2) != 0) {
            arg4 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        Intrinsics.checkNotNullParameter(arg5, "init");
        SerializersModule v6 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateRegistryOwnerDelegateKt.savedNullable(arg2, SerializersKt.serializer(v6, v0), arg3, arg4, arg5);
    }

    public static ReadWriteProperty savedNullable$default(SavedStateRegistryOwner arg0, KSerializer arg1, String arg2, SavedStateConfiguration arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = null;
        }

        if((arg5 & 4) != 0) {
            arg3 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateRegistryOwnerDelegateKt.savedNullable(arg0, arg1, arg2, arg3, arg4);
    }
}

