package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0011\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0006\u0010\u000BJ\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\n0\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0010\u001A\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "classAnnotations", "", "", "(Lkotlin/reflect/KClass;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "toString", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PolymorphicSerializer extends AbstractPolymorphicSerializer {
    private List _annotations;
    private final KClass baseClass;
    private final Lazy descriptor$delegate;

    public PolymorphicSerializer(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        super();
        this.baseClass = arg2;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PolymorphicSerializer$$ExternalSyntheticLambda1(this));
    }

    public PolymorphicSerializer(KClass arg2, Annotation[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        Intrinsics.checkNotNullParameter(arg3, "classAnnotations");
        this(arg2);
        this._annotations = ArraysKt.asList(((Object[])arg3));
    }

    static final SerialDescriptor descriptor_delegate$lambda$1(PolymorphicSerializer arg4) {
        return ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", OPEN.INSTANCE, new SerialDescriptor[0], new PolymorphicSerializer$$ExternalSyntheticLambda0(arg4)), arg4.getBaseClass());
    }

    static final Unit descriptor_delegate$lambda$1$lambda$0(PolymorphicSerializer arg7, ClassSerialDescriptorBuilder arg8) {
        Intrinsics.checkNotNullParameter(arg8, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(arg8, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg8, "value", SerialDescriptorsKt.buildSerialDescriptor$default("kotlinx.serialization.Polymorphic<" + arg7.getBaseClass().getSimpleName() + '>', CONTEXTUAL.INSTANCE, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        arg8.setAnnotations(arg7._annotations);
        return Unit.INSTANCE;
    }

    public KClass getBaseClass() {
        return this.baseClass;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor$delegate.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.getBaseClass() + ')';
    }
}

