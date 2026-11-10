package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR$\u0010\u000E\u001A\u00028\u0000*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u00028\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/PairSerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "Lkotlin/Pair;", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Lkotlin/Pair;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PairSerializer extends KeyValueSerializer {
    private final SerialDescriptor descriptor;

    public PairSerializer(KSerializer arg3, KSerializer arg4) {
        Intrinsics.checkNotNullParameter(arg3, "keySerializer");
        Intrinsics.checkNotNullParameter(arg4, "valueSerializer");
        super(arg3, arg4, null);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Pair", new SerialDescriptor[0], new PairSerializer$$ExternalSyntheticLambda0(arg3, arg4));
    }

    static final Unit descriptor$lambda$0(KSerializer arg8, KSerializer arg9, ClassSerialDescriptorBuilder arg10) {
        Intrinsics.checkNotNullParameter(arg10, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(arg10, "first", arg8.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg10, "second", arg9.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public Object getKey(Object arg1) {
        return this.getKey(((Pair)arg1));
    }

    protected Object getKey(Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getFirst();
    }

    public Object getValue(Object arg1) {
        return this.getValue(((Pair)arg1));
    }

    protected Object getValue(Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getSecond();
    }

    public Object toResult(Object arg1, Object arg2) {
        return this.toResult(arg1, arg2);
    }

    protected Pair toResult(Object arg1, Object arg2) {
        return TuplesKt.to(arg1, arg2);
    }
}

