package androidx.savedstate.serialization.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0018\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¨\u0006\b"}, d2={"encoderErrorMessage", "", "serialName", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "decoderErrorMessage", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BuiltInSerializerKt {
    public static final String decoderErrorMessage(String arg2, Decoder arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "decoder");
        return "Cannot deserialize " + arg2 + " with \'" + Reflection.getOrCreateKotlinClass(arg3.getClass()).getSimpleName() + "\'. This serializer can only be used with SavedStateDecoder. Use \'decodeFromSavedState\' instead.";
    }

    public static final String encoderErrorMessage(String arg2, Encoder arg3) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "encoder");
        return "Cannot serialize " + arg2 + " with \'" + Reflection.getOrCreateKotlinClass(arg3.getClass()).getSimpleName() + "\'. This serializer can only be used with SavedStateEncoder. Use \'encodeToSavedState\' instead.";
    }
}

