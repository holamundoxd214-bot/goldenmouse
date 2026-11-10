package kotlinx.serialization.internal;

import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind$MAP;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0015B#\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR$\u0010\u000E\u001A\u00028\u0000*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u00028\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2={"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MapEntrySerializer extends KeyValueSerializer {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00028\u0002\u0012\u0006\u0010\u0005\u001A\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\f\u001A\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\tJ\u000E\u0010\r\u001A\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001A\u00028\u00022\b\b\u0002\u0010\u0005\u001A\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0016\u0010\u0004\u001A\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001A\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0018"}, d2={"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class MapEntry implements Map$Entry, KMappedMarker {
        private final Object key;
        private final Object value;

        public MapEntry(Object arg1, Object arg2) {
            super();
            this.key = arg1;
            this.value = arg2;
        }

        public final Object component1() {
            return this.key;
        }

        public final Object component2() {
            return this.value;
        }

        public final MapEntry copy(Object arg1, Object arg2) {
            return new MapEntry(arg1, arg2);
        }

        public static MapEntry copy$default(MapEntry arg0, Object arg1, Object arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.key;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.value;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((MapEntry)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof MapEntry)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.key, ((MapEntry)arg5).key)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.value, ((MapEntry)arg5).value)) {
                return 0;
            }

            return 1;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            Object v0 = this.key;
            int v1 = 0;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            v0_1 *= 0x1F;
            Object v2 = this.value;
            if(v2 == null) {
            }
            else {
                v1 = v2.hashCode();
            }

            return v0_1 + v1;
        }

        public Object setValue(Object arg1) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
        }
    }

    private final SerialDescriptor descriptor;

    public MapEntrySerializer(KSerializer arg4, KSerializer arg5) {
        Intrinsics.checkNotNullParameter(arg4, "keySerializer");
        Intrinsics.checkNotNullParameter(arg5, "valueSerializer");
        super(arg4, arg5, null);
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlin.collections.Map.Entry", MAP.INSTANCE, new SerialDescriptor[0], new MapEntrySerializer$$ExternalSyntheticLambda0(arg4, arg5));
    }

    static final Unit descriptor$lambda$0(KSerializer arg8, KSerializer arg9, ClassSerialDescriptorBuilder arg10) {
        Intrinsics.checkNotNullParameter(arg10, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(arg10, "key", arg8.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(arg10, "value", arg9.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public Object getKey(Object arg1) {
        return this.getKey(((Map$Entry)arg1));
    }

    protected Object getKey(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getKey();
    }

    public Object getValue(Object arg1) {
        return this.getValue(((Map$Entry)arg1));
    }

    protected Object getValue(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getValue();
    }

    public Object toResult(Object arg1, Object arg2) {
        return this.toResult(arg1, arg2);
    }

    protected Map$Entry toResult(Object arg1, Object arg2) {
        return new MapEntry(arg1, arg2);
    }
}

