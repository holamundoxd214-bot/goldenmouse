package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Landroidx/savedstate/serialization/EmptyArrayDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "<init>", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) final class EmptyArrayDecoder extends AbstractDecoder {
    public static final EmptyArrayDecoder INSTANCE;
    private static final SerializersModule serializersModule;

    static {
        EmptyArrayDecoder.INSTANCE = new EmptyArrayDecoder();
        EmptyArrayDecoder.serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();
    }

    private EmptyArrayDecoder() {
        super();
    }

    public int decodeElementIndex(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return -1;
    }

    public SerializersModule getSerializersModule() {
        return EmptyArrayDecoder.serializersModule;
    }
}

