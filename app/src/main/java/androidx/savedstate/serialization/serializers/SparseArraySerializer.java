package androidx.savedstate.serialization.serializers;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002:\u0001\u0015B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001A\u00020\u0014H\u0016R\u001A\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0016"}, d2={"Landroidx/savedstate/serialization/serializers/SparseArraySerializer;", "T", "Lkotlinx/serialization/KSerializer;", "Landroid/util/SparseArray;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "surrogateSerializer", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "SparseArraySurrogate", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SparseArraySerializer implements KSerializer {
    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001B*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\u001A\u001BB#\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0007\u0010\fJE\u0010\u0010\u001A\u00020\u0011\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0018H\u0001¢\u0006\u0002\b\u0019R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000E¨\u0006\u001C"}, d2={"Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "T", "", "keys", "", "", "values", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKeys", "()Ljava/util/List;", "getValues", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$savedstate", "$serializer", "Companion", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) @Serializable final class SparseArraySurrogate {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="This synthesized declaration should not be used directly") @Metadata(d1={"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0015\u0010\t\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\n¢\u0006\u0002\u0010\u000BJ\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\r\u001A\u00020\u000EJ\u001C\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00020\u0003J\u0015\u0010\u0014\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\n¢\u0006\u0002\u0010\u000BR\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"androidx/savedstate/serialization/serializers/SparseArraySerializer.SparseArraySurrogate.$serializer", "T", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "<init>", "()V", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "typeParametersSerializers", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class $serializer implements GeneratedSerializer {
            private final SerialDescriptor descriptor;

            private $serializer() {
                super();
                PluginGeneratedSerialDescriptor v0 = new PluginGeneratedSerialDescriptor("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
                v0.addElement("keys", false);
                v0.addElement("values", false);
                this.descriptor = ((SerialDescriptor)v0);
            }

            public $serializer(KSerializer arg2) {
                Intrinsics.checkNotNullParameter(arg2, "typeSerial0");
                this();
                this.typeSerial0 = arg2;
            }

            public final KSerializer[] childSerializers() {
                return new KSerializer[]{SparseArraySurrogate.$childSerializers[0].getValue(), new ArrayListSerializer(this.typeSerial0)};
            }

            public final SparseArraySurrogate deserialize(Decoder arg12) {
                int v2;
                Object v11;
                Object v1_1;
                Intrinsics.checkNotNullParameter(arg12, "decoder");
                SerialDescriptor v0 = this.descriptor;
                CompositeDecoder v12 = arg12.beginStructure(v0);
                Lazy[] v1 = SparseArraySurrogate.$childSerializers;
                Object v5 = null;
                if(v12.decodeSequentially()) {
                    v1_1 = v12.decodeSerializableElement(v0, 0, v1[0].getValue(), v5);
                    v11 = v12.decodeSerializableElement(v0, 1, new ArrayListSerializer(this.typeSerial0), v5);
                    v2 = 3;
                }
                else {
                    int v8 = 1;
                    int v7 = 0;
                    Object v2_1 = v5;
                    Object v6 = v2_1;
                    while(true) {
                        if(v8 != 0) {
                            int v9 = v12.decodeElementIndex(v0);
                            if(v9 == -1) {
                                v8 = 0;
                                continue;
                            }
                            else if(v9 == 0) {
                                v6 = v12.decodeSerializableElement(v0, 0, v1[0].getValue(), v6);
                                v7 |= 1;
                                continue;
                            }
                            else if(v9 == 1) {
                                v2_1 = v12.decodeSerializableElement(v0, 1, new ArrayListSerializer(this.typeSerial0), v2_1);
                                v7 |= 2;
                                continue;
                            }
                            else {
                                throw new UnknownFieldException(v9);
                            }
                        }
                        else {
                            break;
                        }

                        goto label_48;
                    }

                    v11 = v2_1;
                    v1_1 = v6;
                    v2 = v7;
                }

            label_48:
                v12.endStructure(v0);
                return new SparseArraySurrogate(v2, ((List)v1_1), ((List)v11), ((SerializationConstructorMarker)v5));
            }

            public Object deserialize(Decoder arg1) {
                return this.deserialize(arg1);
            }

            public final SerialDescriptor getDescriptor() {
                return this.descriptor;
            }

            private final KSerializer getTypeSerial0() {
                return this.typeSerial0;
            }

            public final void serialize(Encoder arg2, SparseArraySurrogate arg3) {
                Intrinsics.checkNotNullParameter(arg2, "encoder");
                Intrinsics.checkNotNullParameter(arg3, "value");
                SerialDescriptor v0 = this.descriptor;
                CompositeEncoder v2 = arg2.beginStructure(v0);
                SparseArraySurrogate.write$Self$savedstate(arg3, v2, v0, this.typeSerial0);
                v2.endStructure(v0);
            }

            public void serialize(Encoder arg1, Object arg2) {
                this.serialize(arg1, ((SparseArraySurrogate)arg2));
            }

            public final KSerializer[] typeParametersSerializers() {
                return new KSerializer[]{this.typeSerial0};
            }
        }

        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0002\u0010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2={"Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "T", "typeSerial0", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final KSerializer serializer(KSerializer arg1) {
                Intrinsics.checkNotNullParameter(arg1, "typeSerial0");
                return new $serializer(arg1);
            }
        }

        private static final SerialDescriptor $cachedDescriptor;
        private static final Lazy[] $childSerializers;
        public static final Companion Companion;
        private final List keys;
        private final List values;

        public static KSerializer $r8$lambda$Te6tq_6GXP9ROR7MsQbitRJE9jo() {
            return SparseArraySurrogate._childSerializers$_anonymous_();
        }

        static {
            SparseArraySurrogate.Companion = new Companion(null);
            SparseArraySurrogate.$childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new SparseArraySerializer$SparseArraySurrogate$$ExternalSyntheticLambda0()), null};
            PluginGeneratedSerialDescriptor v2 = new PluginGeneratedSerialDescriptor("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            v2.addElement("keys", false);
            v2.addElement("values", false);
            SparseArraySurrogate.$cachedDescriptor = ((SerialDescriptor)v2);
        }

        public SparseArraySurrogate(List arg2, List arg3) {
            Intrinsics.checkNotNullParameter(arg2, "keys");
            Intrinsics.checkNotNullParameter(arg3, "values");
            super();
            this.keys = arg2;
            this.values = arg3;
        }

        public SparseArraySurrogate(int arg2, List arg3, List arg4, SerializationConstructorMarker arg5) {
            int v0 = 3;
            if(v0 != (arg2 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(arg2, v0, SparseArraySurrogate.$cachedDescriptor);
            }

            super();
            this.keys = arg3;
            this.values = arg4;
        }

        private static final KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(IntSerializer.INSTANCE);
        }

        public static final Lazy[] access$get$childSerializers$cp() {
            return SparseArraySurrogate.$childSerializers;
        }

        public final List getKeys() {
            return this.keys;
        }

        public final List getValues() {
            return this.values;
        }

        @JvmStatic public static final void write$Self$savedstate(SparseArraySurrogate arg3, CompositeEncoder arg4, SerialDescriptor arg5, KSerializer arg6) {
            arg4.encodeSerializableElement(arg5, 0, SparseArraySurrogate.$childSerializers[0].getValue(), arg3.keys);
            arg4.encodeSerializableElement(arg5, 1, new ArrayListSerializer(arg6), arg3.values);
        }
    }

    private final SerialDescriptor descriptor;
    private final KSerializer surrogateSerializer;

    public SparseArraySerializer(KSerializer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elementSerializer");
        super();
        arg2 = SparseArraySurrogate.Companion.serializer(arg2);
        this.surrogateSerializer = arg2;
        this.descriptor = arg2.getDescriptor();
    }

    public SparseArray deserialize(Decoder arg5) {
        Intrinsics.checkNotNullParameter(arg5, "decoder");
        Object v4 = arg5.decodeSerializableValue(this.surrogateSerializer);
        if(((SparseArraySurrogate)v4).getKeys().size() == ((SparseArraySurrogate)v4).getValues().size()) {
            SparseArray v5 = new SparseArray(((SparseArraySurrogate)v4).getKeys().size());
            int v0 = ((SparseArraySurrogate)v4).getKeys().size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v5.append(((SparseArraySurrogate)v4).getKeys().get(v1).intValue(), ((SparseArraySurrogate)v4).getValues().get(v1));
            }

            return v5;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object deserialize(Decoder arg1) {
        return this.deserialize(arg1);
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder arg6, SparseArray arg7) {
        Intrinsics.checkNotNullParameter(arg6, "encoder");
        Intrinsics.checkNotNullParameter(arg7, "value");
        int v0 = arg7.size();
        ArrayList v1 = new ArrayList(v0);
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1.add(Integer.valueOf(arg7.keyAt(v3)));
        }

        v0 = arg7.size();
        ArrayList v3_1 = new ArrayList(v0);
        while(v2 < v0) {
            v3_1.add(arg7.valueAt(v2));
            ++v2;
        }

        arg6.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(((List)v1), ((List)v3_1)));
    }

    public void serialize(Encoder arg1, Object arg2) {
        this.serialize(arg1, ((SparseArray)arg2));
    }
}

