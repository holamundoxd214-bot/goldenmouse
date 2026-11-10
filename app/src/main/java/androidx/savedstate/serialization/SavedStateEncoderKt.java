package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001A\u0002H\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001A.\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002\"\u0006\b\u0000\u0010\u0003\u0018\u00012\u0006\u0010\u0005\u001A\u0002H\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\b\u001A;\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\u0005\u001A\u0002H\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\f\u001A9\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002\"\u0004\b\u0000\u0010\u00032\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\u0005\u001A\u0002H\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\f¨\u0006\r"}, d2={"encodeToSavedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "T", "", "value", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "(Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroid/os/Bundle;", "encodeToSavedStateNullable", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Landroidx/savedstate/serialization/SavedStateConfiguration;)Landroid/os/Bundle;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateEncoderKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'encodeToSavedState\' overload that supports both nullable and non-nullable types.") public static final Bundle encodeToSavedState(Object arg3, SavedStateConfiguration arg4) {
        Intrinsics.checkNotNullParameter(arg3, "value");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        SerializersModule v0 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateEncoderKt.encodeToSavedStateNullable(SerializersKt.serializer(v0, null), arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'encodeToSavedState\' overload that supports both nullable and non-nullable types.") public static final Bundle encodeToSavedState(SerializationStrategy arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        Intrinsics.checkNotNullParameter(arg3, "value");
        return SavedStateEncoderKt.encodeToSavedState$default(arg2, arg3, null, 4, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new \'encodeToSavedState\' overload that supports both nullable and non-nullable types.") public static final Bundle encodeToSavedState(SerializationStrategy arg5, Object arg6, SavedStateConfiguration arg7) {
        Object[] v0_3;
        Intrinsics.checkNotNullParameter(arg5, "serializer");
        Intrinsics.checkNotNullParameter(arg6, "value");
        Intrinsics.checkNotNullParameter(arg7, "configuration");
        Map v0 = MapsKt.emptyMap();
        if(v0.isEmpty()) {
            Pair[] v0_1 = new Pair[0];
        }
        else {
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_2 = v0.entrySet().iterator();
            while(v0_2.hasNext()) {
                Object v3 = v0_2.next();
                ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
            }

            v0_3 = ((Collection)v1).toArray(new Pair[0]);
        }

        Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(v0_3, ((Pair[])v0_3).length));
        SavedStateWriter.constructor-impl(v0_4);
        new SavedStateEncoder(v0_4, arg7).encodeSerializableValue(arg5, arg6);
        return v0_4;
    }

    public static Bundle encodeToSavedState$default(SerializationStrategy arg0, Object arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateEncoderKt.encodeToSavedState(arg0, arg1, arg2);
    }

    public static Bundle encodeToSavedState$default(Object arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg1, "value");
        Intrinsics.checkNotNullParameter(arg2, "configuration");
        SerializersModule v3 = arg2.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateEncoderKt.encodeToSavedStateNullable(SerializersKt.serializer(v3, null), arg1, arg2);
    }

    public static final Bundle encodeToSavedStateNullable(SerializationStrategy arg5, Object arg6, SavedStateConfiguration arg7) {
        Object[] v0_3;
        Intrinsics.checkNotNullParameter(arg5, "serializer");
        Intrinsics.checkNotNullParameter(arg7, "configuration");
        Map v0 = MapsKt.emptyMap();
        if(v0.isEmpty()) {
            Pair[] v0_1 = new Pair[0];
        }
        else {
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_2 = v0.entrySet().iterator();
            while(v0_2.hasNext()) {
                Object v3 = v0_2.next();
                ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
            }

            v0_3 = ((Collection)v1).toArray(new Pair[0]);
        }

        Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(v0_3, ((Pair[])v0_3).length));
        SavedStateWriter.constructor-impl(v0_4);
        new SavedStateEncoder(v0_4, arg7).encodeSerializableValue(arg5, arg6);
        return v0_4;
    }

    public static final Bundle encodeToSavedStateNullable(Object arg3, SavedStateConfiguration arg4) {
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        SerializersModule v0 = arg4.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateEncoderKt.encodeToSavedStateNullable(SerializersKt.serializer(v0, null), arg3, arg4);
    }

    public static final Bundle encodeToSavedStateNullable(SerializationStrategy arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serializer");
        return SavedStateEncoderKt.encodeToSavedStateNullable$default(arg2, arg3, null, 4, null);
    }

    public static Bundle encodeToSavedStateNullable$default(SerializationStrategy arg0, Object arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateEncoderKt.encodeToSavedStateNullable(arg0, arg1, arg2);
    }

    public static Bundle encodeToSavedStateNullable$default(Object arg1, SavedStateConfiguration arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SavedStateConfiguration.DEFAULT;
        }

        Intrinsics.checkNotNullParameter(arg2, "configuration");
        SerializersModule v3 = arg2.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SavedStateEncoderKt.encodeToSavedStateNullable(SerializersKt.serializer(v3, null), arg1, arg2);
    }
}

