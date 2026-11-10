package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$CLASS;
import kotlinx.serialization.descriptors.StructureKind$OBJECT;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001B\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J)\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00182\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010\u001FJ\u0018\u0010 \u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010!\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020\u0016H\u0016J\u0010\u0010\"\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020#H\u0016J\u0010\u0010$\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020%H\u0016J\u0010\u0010&\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020\u001AH\u0016J\u0010\u0010\'\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020(H\u0016J\u0010\u0010)\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020*H\u0016J\u0010\u0010+\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020,H\u0016J\u0010\u0010-\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020.H\u0016J\u0010\u0010/\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0018\u00100\u001A\u00020\u001E2\u0006\u00101\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u00102\u001A\u00020\u001EH\u0016J)\u00103\u001A\u00020\u001E\"\u0004\b\u0000\u001042\f\u00105\u001A\b\u0012\u0004\u0012\u0002H4062\u0006\u0010\f\u001A\u0002H4H\u0016¢\u0006\u0002\u00107R\u001A\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u00068"}, d2={"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeElement", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateEncoder extends AbstractEncoder {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;

    public SavedStateEncoder(Bundle arg2, SavedStateConfiguration arg3) {
        Intrinsics.checkNotNullParameter(arg2, "savedState");
        Intrinsics.checkNotNullParameter(arg3, "configuration");
        super();
        this.savedState = arg2;
        this.configuration = arg3;
        this.key = "";
    }

    public CompositeEncoder beginStructure(SerialDescriptor arg6) {
        Object[] v0_3;
        Intrinsics.checkNotNullParameter(arg6, "descriptor");
        if(Intrinsics.areEqual(this.key, "")) {
            this.putClassDiscriminatorIfRequired(this.configuration, arg6, this.savedState);
            return this;
        }

        Map v0 = MapsKt.emptyMap();
        if(v0.isEmpty()) {
            Pair[] v0_1 = new Pair[0];
        }
        else {
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_2 = v0.entrySet().iterator();
            while(v0_2.hasNext()) {
                Object v3 = v0_2.next();
                ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
            }

            v0_3 = ((Collection)v1).toArray(new Pair[0]);
        }

        Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(v0_3, ((Pair[])v0_3).length));
        SavedStateWriter.constructor-impl(v0_4);
        SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, v0_4);
        this.putClassDiscriminatorIfRequired(this.configuration, arg6, v0_4);
        return new SavedStateEncoder(v0_4, this.configuration);
    }

    public void encodeBoolean(boolean arg2) {
        SavedStateWriter.putBoolean-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeByte(byte arg2) {
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeChar(char arg2) {
        SavedStateWriter.putChar-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeDouble(double arg2) {
        SavedStateWriter.putDouble-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public boolean encodeElement(SerialDescriptor arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "descriptor");
        this.key = arg3.getElementName(arg4);
        if(this.configuration.getClassDiscriminatorMode() == 1) {
            String v0 = "type";
            boolean v3 = SavedStateReader.contains-impl(SavedStateReader.constructor-impl(this.savedState), v0);
            boolean v1 = Intrinsics.areEqual(this.key, v0);
            if(v3) {
                if(!v1) {
                }
                else {
                    throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.getString-impl(SavedStateReader.constructor-impl(this.savedState), v0) + " has property \'" + this.key + "\' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
                }
            }
        }

        return 1;
    }

    public void encodeEnum(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg3);
    }

    public void encodeFloat(float arg2) {
        SavedStateWriter.putFloat-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeInt(int arg2) {
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeLong(long arg2) {
        SavedStateWriter.putLong-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeNull() {
        SavedStateWriter.putNull-impl(SavedStateWriter.constructor-impl(this.savedState), this.key);
    }

    public void encodeSerializableValue(SerializationStrategy arg3, Object arg4) {
        String v2;
        Bundle v3;
        Intrinsics.checkNotNullParameter(arg3, "serializer");
        if(SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, arg3, arg4)) {
            return;
        }

        SerialDescriptor v0 = arg3.getDescriptor();
        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            SavedStateWriter.putIntList-impl(v3, v2, ((List)arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            SavedStateWriter.putStringList-impl(v3, v2, ((List)arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.BooleanArray");
            SavedStateWriter.putBooleanArray-impl(v3, v2, ((boolean[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.CharArray");
            SavedStateWriter.putCharArray-impl(v3, v2, ((char[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.DoubleArray");
            SavedStateWriter.putDoubleArray-impl(v3, v2, ((double[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.FloatArray");
            SavedStateWriter.putFloatArray-impl(v3, v2, ((float[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.IntArray");
            SavedStateWriter.putIntArray-impl(v3, v2, ((int[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.LongArray");
            SavedStateWriter.putLongArray-impl(v3, v2, ((long[])arg4));
            return;
        }

        if(Intrinsics.areEqual(v0, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            v3 = SavedStateWriter.constructor-impl(this.savedState);
            v2 = this.key;
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            SavedStateWriter.putStringArray-impl(v3, v2, ((String[])arg4));
            return;
        }

        super.encodeSerializableValue(arg3, arg4);
    }

    public void encodeShort(short arg2) {
        SavedStateWriter.putInt-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public void encodeString(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        SavedStateWriter.putString-impl(SavedStateWriter.constructor-impl(this.savedState), this.key, arg2);
    }

    public final String getKey$savedstate() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate() {
        return this.savedState;
    }

    public SerializersModule getSerializersModule() {
        return this.configuration.getSerializersModule();
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration arg2, SerialDescriptor arg3, Bundle arg4) {
        String v2;
        if(arg2.getClassDiscriminatorMode() != 1) {
        }
        else {
            v2 = "type";
            if(SavedStateReader.contains-impl(SavedStateReader.constructor-impl(arg4), v2)) {
            }
            else {
                if(!Intrinsics.areEqual(arg3.getKind(), CLASS.INSTANCE)) {
                    if(Intrinsics.areEqual(arg3.getKind(), OBJECT.INSTANCE)) {
                    }
                    else {
                        return;
                    }
                }

                goto label_19;
            }
        }

        return;
    label_19:
        SavedStateWriter.putString-impl(SavedStateWriter.constructor-impl(arg4), v2, arg3.getSerialName());
    }

    public boolean shouldEncodeElementDefault(SerialDescriptor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}

