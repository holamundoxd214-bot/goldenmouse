package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001A\u001F\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\t\u001A\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000BH\u0081\b\u001A\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\r\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\rH\u0081\b\u001A\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000E\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000EH\u0081\b\u001A\u0010\u0010\u000F\u001A\u00020\u0010*\u0006\u0012\u0002\b\u00030\u0011H\u0000\u001A\u0010\u0010\u0012\u001A\u00020\u0002*\u0006\u0012\u0002\b\u00030\u0011H\u0000\u001A\u0010\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0002H\u0000\u001A\u0012\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u0011*\u00020\u0016H\u0000\u001A\f\u0010\u0017\u001A\u00020\u0016*\u00020\u0018H\u0000\u001A6\u0010\u0019\u001A\u00020\u001A\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001B*\b\u0012\u0004\u0012\u0002H\f0\u001C2\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u001B0\u001EH\u0080\bø\u0001\u0000\"\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001F"}, d2={"cachedSerialNames", "", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", "", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cast", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializerNotRegistered", "", "Lkotlin/reflect/KClass;", "notRegisteredMessage", "className", "kclass", "", "Lkotlin/reflect/KType;", "typeOrThrow", "Lkotlin/reflect/KTypeProjection;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Platform_commonKt {
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY;

    static {
        Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];
    }

    public static final Set cachedSerialNames(SerialDescriptor arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        if((arg5 instanceof CachedNames)) {
            return ((CachedNames)arg5).getSerialNames();
        }

        HashSet v0 = new HashSet(arg5.getElementsCount());
        int v1 = arg5.getElementsCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg5.getElementName(v2));
        }

        return ((Set)v0);
    }

    public static final DeserializationStrategy cast(DeserializationStrategy arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final KSerializer cast(KSerializer arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final SerializationStrategy cast(SerializationStrategy arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final SerialDescriptor[] compactArray(List arg1) {
        Collection v1;
        List v0 = arg1;
        if(v0 == null || (((Collection)v0).isEmpty())) {
            v1 = null;
        }

        if(0 != 0) {
            Object[] v1_1 = v1.toArray(new SerialDescriptor[0]);
            if(v1_1 == null) {
            }
            else {
                return ((SerialDescriptor[])v1_1);
            }
        }

        return Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY;
    }

    public static final int elementsHashCodeBy(Iterable arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 1; v2.hasNext(); v0 += v1_1) {
            v0 *= 0x1F;
            Object v1 = arg3.invoke(v2.next());
            int v1_1 = v1 != null ? v1.hashCode() : 0;
        }

        return v0;
    }

    public static final KClass kclass(KType arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        KClassifier v3 = arg3.getClassifier();
        if((v3 instanceof KClass)) {
            return ((KClass)v3);
        }

        if((v3 instanceof KTypeParameter)) {
            throw new IllegalArgumentException("Captured type parameter " + v3 + " from generic non-reified function. Such functionality cannot be supported because " + v3 + " is erased, either specify serializer explicitly or make calling function inline with reified " + v3 + '.');
        }

        throw new IllegalArgumentException("Only KClass supported as classifier, got " + v3);
    }

    public static final String notRegisteredMessage(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "className");
        return "Serializer for class \'" + arg2 + "\' is not found.\nPlease ensure that class is marked as \'@Serializable\' and that the serialization compiler plugin is applied.\n";
    }

    public static final String notRegisteredMessage(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        String v1 = arg1.getSimpleName();
        if(v1 == null) {
            v1 = "<local class name not available>";
        }

        return Platform_commonKt.notRegisteredMessage(v1);
    }

    public static final Void serializerNotRegistered(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(arg1));
    }

    public static final KType typeOrThrow(KTypeProjection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        KType v0 = arg2.getType();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalArgumentException("Star projections in type arguments are not allowed, but had " + arg2.getType().toString());
    }
}

