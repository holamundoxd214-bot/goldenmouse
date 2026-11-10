package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.serializers.MutableStateFlowSerializer;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A+\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007\"\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"SavedStateConfiguration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "from", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "DEFAULT_SERIALIZERS_MODULE", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateConfigurationKt {
    private static final SerializersModule DEFAULT_SERIALIZERS_MODULE;

    static {
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        v0.contextual(Reflection.getOrCreateKotlinClass(Bundle.class), SavedStateSerializer.INSTANCE);
        v0.contextual(Reflection.getOrCreateKotlinClass(MutableStateFlow.class), new SavedStateConfigurationKt$$ExternalSyntheticLambda0());
        SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE = SerializersModuleKt.plus(v0.build(), SavedStateConfiguration_androidKt.getDefaultSerializersModuleOnPlatform());
    }

    static final KSerializer DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elementSerializers");
        return new MutableStateFlowSerializer(CollectionsKt.first(arg1));
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "from");
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Builder v0 = new Builder(arg1);
        arg2.invoke(v0);
        return v0.build$savedstate();
    }

    public static final SavedStateConfiguration SavedStateConfiguration(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        return SavedStateConfigurationKt.SavedStateConfiguration$default(null, arg2, 1, null);
    }

    public static SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration arg0, Function1 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = SavedStateConfiguration.DEFAULT;
        }

        return SavedStateConfigurationKt.SavedStateConfiguration(arg0, arg1);
    }

    public static final SerializersModule access$getDEFAULT_SERIALIZERS_MODULE$p() {
        return SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
    }
}

