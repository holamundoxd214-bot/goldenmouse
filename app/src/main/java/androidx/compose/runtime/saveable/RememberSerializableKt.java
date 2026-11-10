package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.serialization.SerializableSaverKt;
import androidx.savedstate.serialization.SavedStateConfiguration;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000,\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AL\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u000E\b\b\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00010\bH\u0087\b¢\u0006\u0002\u0010\t\u001AU\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000B2\b\b\u0002\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00010\bH\u0007¢\u0006\u0002\u0010\f\u001AX\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00010\r\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0014\b\b\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\r0\bH\u0087\b¢\u0006\u0002\u0010\u000E\u001Aa\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00010\r\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000B2\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\r0\bH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"rememberSerializable", "T", "", "inputs", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "serializer", "Lkotlinx/serialization/KSerializer;", "([Ljava/lang/Object;Lkotlinx/serialization/KSerializer;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "Landroidx/compose/runtime/MutableState;", "([Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "stateSerializer", "([Ljava/lang/Object;Lkotlinx/serialization/KSerializer;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RememberSerializableKt {
    public static final MutableState rememberSerializable(Object[] arg7, SavedStateConfiguration arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        ComposerKt.sourceInformationMarkerStart(arg10, 0x85D01ECE, "CC(rememberSerializable)N(inputs,configuration,init)127@6064L187:RememberSerializable.kt#r2ddri");
        if((arg12 & 2) != 0) {
            arg8 = SavedStateConfiguration.DEFAULT;
        }

        Object[] v0 = Arrays.copyOf(arg7, arg7.length);
        SerializersModule v7 = arg8.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        MutableState v7_1 = RememberSerializableKt.rememberSerializable(v0, SerializersKt.serializer(v7, null), arg8, arg9, arg10, arg11 << 3 & 0x1F80, 0);
        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v7_1;
    }

    public static final MutableState rememberSerializable(Object[] arg7, KSerializer arg8, SavedStateConfiguration arg9, Function0 arg10, Composer arg11, int arg12, int arg13) {
        int v1 = 0x4A6F949F;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(rememberSerializable)N(inputs,stateSerializer,configuration,init)166@7984L65:RememberSerializable.kt#r2ddri");
        if((arg13 & 4) != 0) {
            arg9 = SavedStateConfiguration.DEFAULT;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.runtime.saveable.rememberSerializable (RememberSerializable.kt:163)");
        }

        Composer v4 = arg11;
        Object v7 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg7, arg7.length), RememberSaveableKt.mutableStateSaver(SerializableSaverKt.serializableSaver(arg8, arg9)), null, arg10, v4, arg12 & 0x1C00 | 0x180, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return ((MutableState)v7);
    }

    public static final Object rememberSerializable(Object[] arg7, SavedStateConfiguration arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        ComposerKt.sourceInformationMarkerStart(arg10, 0xE5E29629, "CC(rememberSerializable)N(inputs,configuration,init)54@2511L182:RememberSerializable.kt#r2ddri");
        if((arg12 & 2) != 0) {
            arg8 = SavedStateConfiguration.DEFAULT;
        }

        Object[] v0 = Arrays.copyOf(arg7, arg7.length);
        SerializersModule v7 = arg8.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        Object v7_1 = RememberSerializableKt.rememberSerializable(v0, SerializersKt.serializer(v7, null), arg8, arg9, arg10, arg11 << 3 & 0x1F80, 0);
        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v7_1;
    }

    public static final Object rememberSerializable(Object[] arg9, KSerializer arg10, SavedStateConfiguration arg11, Function0 arg12, Composer arg13, int arg14, int arg15) {
        int v1 = 1261607160;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(rememberSerializable)N(inputs,serializer,configuration,init)96@4465L65:RememberSerializable.kt#r2ddri");
        if((arg15 & 4) != 0) {
            arg11 = SavedStateConfiguration.DEFAULT;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.runtime.saveable.rememberSerializable (RememberSerializable.kt:93)");
        }

        Composer v6 = arg13;
        Object v9 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg9, arg9.length), SerializableSaverKt.serializableSaver(arg10, arg11), null, arg12, v6, arg14 & 0x1C00 | 0x180, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return v9;
    }
}

