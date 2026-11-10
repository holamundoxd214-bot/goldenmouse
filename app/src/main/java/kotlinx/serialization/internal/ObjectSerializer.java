package kotlinx.serialization.internal;

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
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind$OBJECT;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bB\'\b\u0011\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00028\u0000\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\u0007\u0010\fJ\u001D\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001BJ\u0015\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00020\u001EH\u0016¢\u0006\u0002\u0010\u001FR\u0010\u0010\u0006\u001A\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000B0\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0010\u001A\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2={"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "classAnnotations", "", "", "(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/annotation/Annotation;)V", "Ljava/lang/Object;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ObjectSerializer implements KSerializer {
    private List _annotations;
    private final Lazy descriptor$delegate;
    private final Object objectInstance;

    public ObjectSerializer(String arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "objectInstance");
        super();
        this.objectInstance = arg3;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ObjectSerializer$$ExternalSyntheticLambda0(arg2, this));
    }

    public ObjectSerializer(String arg2, Object arg3, Annotation[] arg4) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "objectInstance");
        Intrinsics.checkNotNullParameter(arg4, "classAnnotations");
        this(arg2, arg3);
        this._annotations = ArraysKt.asList(((Object[])arg4));
    }

    static final SerialDescriptor descriptor_delegate$lambda$1(String arg3, ObjectSerializer arg4) {
        return SerialDescriptorsKt.buildSerialDescriptor(arg3, OBJECT.INSTANCE, new SerialDescriptor[0], new ObjectSerializer$$ExternalSyntheticLambda1(arg4));
    }

    static final Unit descriptor_delegate$lambda$1$lambda$0(ObjectSerializer arg1, ClassSerialDescriptorBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$buildSerialDescriptor");
        arg2.setAnnotations(arg1._annotations);
        return Unit.INSTANCE;
    }

    public Object deserialize(Decoder arg4) {
        int v1;
        Intrinsics.checkNotNullParameter(arg4, "decoder");
        SerialDescriptor v0 = this.getDescriptor();
        CompositeDecoder v4 = arg4.beginStructure(v0);
        if(v4.decodeSequentially()) {
        }
        else {
            v1 = v4.decodeElementIndex(this.getDescriptor());
            if(v1 == -1) {
                goto label_11;
            }

            goto label_15;
        }

    label_11:
        v4.endStructure(v0);
        return this.objectInstance;
    label_15:
        throw new SerializationException("Unexpected index " + v1);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor$delegate.getValue();
    }

    public void serialize(Encoder arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "encoder");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg2.beginStructure(this.getDescriptor()).endStructure(this.getDescriptor());
    }
}

