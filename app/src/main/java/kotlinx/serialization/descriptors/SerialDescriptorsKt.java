package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.HashSetClassDesc;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000B\n\u0000\u001AB\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000B\u001A\u0016\u0010\f\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E\u001A\u0018\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0001H\u0007\u001AL\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00122\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0013\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0014\u001A\u0011\u0010\u0015\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0086\b\u001A\u000E\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u0018\u001A\u0010\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u0001H\u0007\u001A\u0011\u0010\u0019\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\b\u001A\u0018\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0007\u001A\u0019\u0010\u001B\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u001E\u0018\u0001\"\u0006\b\u0001\u0010\u001F\u0018\u0001H\u0087\b\u001A\u0010\u0010 \u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u0001H\u0007\u001A\u0011\u0010 \u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\b\u001A7\u0010)\u001A\u00020\t\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\b2\u0006\u0010*\u001A\u00020\u00032\u000E\b\u0002\u0010+\u001A\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u0010.\u001A\u00020/H\u0086\b\"\u001B\u0010!\u001A\u00020\u0001*\u00020\u00018F¢\u0006\f\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u001E\u0010&\u001A\u00020\u0001*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\'\u0010#\u001A\u0004\b(\u0010%¨\u00060"}, d2={"buildClassSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "typeParameters", "", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "SerialDescriptor", "original", "buildSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDescriptor", "T", "type", "Lkotlin/reflect/KType;", "listSerialDescriptor", "elementDescriptor", "mapSerialDescriptor", "keyDescriptor", "valueDescriptor", "K", "V", "setSerialDescriptor", "nullable", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "nonNullOriginal", "getNonNullOriginal$annotations", "getNonNullOriginal", "element", "elementName", "annotations", "", "", "isOptional", "", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerialDescriptorsKt {
    public static final SerialDescriptor PrimitiveSerialDescriptor(String arg1, PrimitiveKind arg2) {
        Intrinsics.checkNotNullParameter(arg1, "serialName");
        Intrinsics.checkNotNullParameter(arg2, "kind");
        if(!StringsKt.isBlank(arg1)) {
            return PrimitivesKt.PrimitiveDescriptorSafe(arg1, arg2);
        }

        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @ExperimentalSerializationApi public static final SerialDescriptor SerialDescriptor(String arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "original");
        if(!StringsKt.isBlank(arg2)) {
            if(!(arg3.getKind() instanceof PrimitiveKind)) {
                if(!Intrinsics.areEqual(arg2, arg3.getSerialName())) {
                    return new WrappedSerialDescriptor(arg2, arg3);
                }

                throw new IllegalArgumentException("The name of the wrapped descriptor (" + arg2 + ") cannot be the same as the name of the original descriptor (" + arg3.getSerialName() + ')'.toString());
            }

            throw new IllegalArgumentException("For primitive descriptors please use \'PrimitiveSerialDescriptor\' instead".toString());
        }

        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String arg7, SerialDescriptor[] arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg7, "serialName");
        Intrinsics.checkNotNullParameter(arg8, "typeParameters");
        Intrinsics.checkNotNullParameter(arg9, "builderAction");
        if(!StringsKt.isBlank(arg7)) {
            ClassSerialDescriptorBuilder v6 = new ClassSerialDescriptorBuilder(arg7);
            arg9.invoke(v6);
            return new SerialDescriptorImpl(arg7, CLASS.INSTANCE, v6.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(((Object[])arg8)), v6);
        }

        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static SerialDescriptor buildClassSerialDescriptor$default(String arg0, SerialDescriptor[] arg1, Function1 arg2, int arg3, Object arg4) {
        SerialDescriptorsKt$$ExternalSyntheticLambda0 v2;
        if((arg3 & 4) != 0) {
            v2 = new SerialDescriptorsKt$$ExternalSyntheticLambda0();
        }

        return SerialDescriptorsKt.buildClassSerialDescriptor(arg0, arg1, ((Function1)v2));
    }

    static final Unit buildClassSerialDescriptor$lambda$0(ClassSerialDescriptorBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Unit.INSTANCE;
    }

    @InternalSerializationApi public static final SerialDescriptor buildSerialDescriptor(String arg7, SerialKind arg8, SerialDescriptor[] arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg7, "serialName");
        Intrinsics.checkNotNullParameter(arg8, "kind");
        Intrinsics.checkNotNullParameter(arg9, "typeParameters");
        Intrinsics.checkNotNullParameter(arg10, "builder");
        if(!StringsKt.isBlank(arg7)) {
            if(!Intrinsics.areEqual(arg8, CLASS.INSTANCE)) {
                ClassSerialDescriptorBuilder v6 = new ClassSerialDescriptorBuilder(arg7);
                arg10.invoke(v6);
                return new SerialDescriptorImpl(arg7, arg8, v6.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(((Object[])arg9)), v6);
            }

            throw new IllegalArgumentException("For StructureKind.CLASS please use \'buildClassSerialDescriptor\' instead".toString());
        }

        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static SerialDescriptor buildSerialDescriptor$default(String arg0, SerialKind arg1, SerialDescriptor[] arg2, Function1 arg3, int arg4, Object arg5) {
        SerialDescriptorsKt$$ExternalSyntheticLambda1 v3;
        if((arg4 & 8) != 0) {
            v3 = new SerialDescriptorsKt$$ExternalSyntheticLambda1();
        }

        return SerialDescriptorsKt.buildSerialDescriptor(arg0, arg1, arg2, ((Function1)v3));
    }

    static final Unit buildSerialDescriptor$lambda$6(ClassSerialDescriptorBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Unit.INSTANCE;
    }

    public static final void element(ClassSerialDescriptorBuilder arg2, String arg3, List arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elementName");
        Intrinsics.checkNotNullParameter(arg4, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        arg2.element(arg3, SerializersKt.serializer(null).getDescriptor(), arg4, arg5);
    }

    public static void element$default(ClassSerialDescriptorBuilder arg0, String arg1, List arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "elementName");
        Intrinsics.checkNotNullParameter(arg2, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        arg0.element(arg1, SerializersKt.serializer(null).getDescriptor(), arg2, false);
    }

    public static final SerialDescriptor getNonNullOriginal(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof SerialDescriptorForNullable)) {
            arg1 = ((SerialDescriptorForNullable)arg1).getOriginal$kotlinx_serialization_core();
        }

        return arg1;
    }

    @ExperimentalSerializationApi public static void getNonNullOriginal$annotations(SerialDescriptor arg0) {
    }

    public static final SerialDescriptor getNullable(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNullable()) {
            return arg1;
        }

        return new SerialDescriptorForNullable(arg1);
    }

    public static void getNullable$annotations(SerialDescriptor arg0) {
    }

    @ExperimentalSerializationApi public static final SerialDescriptor listSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerialDescriptorsKt.listSerialDescriptor(SerializersKt.serializer(null).getDescriptor());
    }

    @ExperimentalSerializationApi public static final SerialDescriptor listSerialDescriptor(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elementDescriptor");
        return new ArrayListClassDesc(arg1);
    }

    @ExperimentalSerializationApi public static final SerialDescriptor mapSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "K");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        SerialDescriptor v3 = SerializersKt.serializer(null).getDescriptor();
        Intrinsics.reifiedOperationMarker(6, "V");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerialDescriptorsKt.mapSerialDescriptor(v3, SerializersKt.serializer(null).getDescriptor());
    }

    @ExperimentalSerializationApi public static final SerialDescriptor mapSerialDescriptor(SerialDescriptor arg1, SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg1, "keyDescriptor");
        Intrinsics.checkNotNullParameter(arg2, "valueDescriptor");
        return new HashMapClassDesc(arg1, arg2);
    }

    public static final SerialDescriptor serialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerializersKt.serializer(null).getDescriptor();
    }

    public static final SerialDescriptor serialDescriptor(KType arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return SerializersKt.serializer(arg1).getDescriptor();
    }

    @ExperimentalSerializationApi public static final SerialDescriptor setSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerialDescriptorsKt.setSerialDescriptor(SerializersKt.serializer(null).getDescriptor());
    }

    @ExperimentalSerializationApi public static final SerialDescriptor setSerialDescriptor(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elementDescriptor");
        return new HashSetClassDesc(arg1);
    }
}

