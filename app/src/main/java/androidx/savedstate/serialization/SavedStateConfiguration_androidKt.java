package androidx.savedstate.serialization;

import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000¨\u0006\u0002"}, d2={"getDefaultSerializersModuleOnPlatform", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SavedStateConfiguration_androidKt {
    public static final SerializersModule getDefaultSerializersModuleOnPlatform() {
        SerializersModuleBuilder v0 = new SerializersModuleBuilder();
        v0.contextual(Reflection.getOrCreateKotlinClass(Size.class), SizeSerializer.INSTANCE);
        v0.contextual(Reflection.getOrCreateKotlinClass(SizeF.class), SizeFSerializer.INSTANCE);
        v0.contextual(Reflection.getOrCreateKotlinClass(SparseArray.class), new SavedStateConfiguration_androidKt$$ExternalSyntheticLambda0());
        return v0.build();
    }

    static final KSerializer getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "argSerializers");
        return new SparseArraySerializer(CollectionsKt.first(arg1));
    }
}

