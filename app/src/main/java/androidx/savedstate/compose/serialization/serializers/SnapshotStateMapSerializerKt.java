package androidx.savedstate.compose.serialization.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A%\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001H\u0086\b¨\u0006\u0004"}, d2={"SnapshotStateMapSerializer", "Landroidx/savedstate/compose/serialization/serializers/SnapshotStateMapSerializer;", "K", "V", "savedstate-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SnapshotStateMapSerializerKt {
    public static final SnapshotStateMapSerializer SnapshotStateMapSerializer() {
        Intrinsics.reifiedOperationMarker(6, "K");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        KSerializer v4 = SerializersKt.serializer(null);
        Intrinsics.reifiedOperationMarker(6, "V");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new SnapshotStateMapSerializer(v4, SerializersKt.serializer(null));
    }
}

