package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001A\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u0002*\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0007\u001A\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u000B*\u00020\b2\u0006\u0010\t\u001A\u00020\u0002H\u0007\u001A\u0018\u0010\f\u001A\u00020\u0002*\u00020\u00022\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0001H\u0000\"$\u0010\u0000\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2={"capturedKClass", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlin/reflect/KClass;", "getContextualDescriptor", "Lkotlinx/serialization/modules/SerializersModule;", "descriptor", "getPolymorphicDescriptors", "", "withContext", "context", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextAwareKt {
    public static final KClass getCapturedKClass(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof ContextDescriptor)) {
            return ((ContextDescriptor)arg1).kClass;
        }

        if((arg1 instanceof SerialDescriptorForNullable)) {
            return ContextAwareKt.getCapturedKClass(((SerialDescriptorForNullable)arg1).getOriginal$kotlinx_serialization_core());
        }

        return null;
    }

    @ExperimentalSerializationApi public static void getCapturedKClass$annotations(SerialDescriptor arg0) {
    }

    @ExperimentalSerializationApi public static final SerialDescriptor getContextualDescriptor(SerializersModule arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "descriptor");
        KClass v3 = ContextAwareKt.getCapturedKClass(arg3);
        List v0 = null;
        if(v3 != null) {
            KSerializer v2 = SerializersModule.getContextual$default(arg2, v3, v0, 2, v0);
            if(v2 != null) {
                return v2.getDescriptor();
            }
        }

        return ((SerialDescriptor)v0);
    }

    @ExperimentalSerializationApi public static final List getPolymorphicDescriptors(SerializersModule arg1, SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        KClass v2 = ContextAwareKt.getCapturedKClass(arg2);
        if(v2 == null) {
            return CollectionsKt.emptyList();
        }

        Object v1 = ((SerialModuleImpl)arg1).polyBase2Serializers.get(v2);
        Collection v1_1 = v1 != null ? ((Map)v1).values() : null;
        if(v1_1 == null) {
            List v1_2 = CollectionsKt.emptyList();
        }

        ArrayList v2_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1_1), 10));
        Iterator v1_3 = ((Iterable)v1_1).iterator();
        while(v1_3.hasNext()) {
            ((Collection)v2_1).add(v1_3.next().getDescriptor());
        }

        return ((List)v2_1);
    }

    public static final SerialDescriptor withContext(SerialDescriptor arg1, KClass arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "context");
        return new ContextDescriptor(arg1, arg2);
    }
}

