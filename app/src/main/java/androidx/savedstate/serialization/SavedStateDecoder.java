package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$LIST;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001B\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\b\u0010\u001E\u001A\u00020\u001FH\u0016J\b\u0010 \u001A\u00020!H\u0016J\b\u0010\"\u001A\u00020\u0012H\u0016J\b\u0010#\u001A\u00020$H\u0016J\b\u0010%\u001A\u00020&H\u0016J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010)\u001A\u00020*H\u0016J\b\u0010+\u001A\u00020\rH\u0016J\u0010\u0010,\u001A\u00020\u00122\u0006\u0010-\u001A\u00020\u001AH\u0016J\b\u0010.\u001A\u00020\u001DH\u0016J!\u0010/\u001A\u0002H0\"\u0004\b\u0000\u001002\f\u00101\u001A\b\u0012\u0004\u0012\u0002H002H\u0016¢\u0006\u0002\u00103R\u001A\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u00064"}, d2={"Landroidx/savedstate/serialization/SavedStateDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate", "()Ljava/lang/String;", "index", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeElementIndex", "decodeBoolean", "", "decodeByte", "", "decodeShort", "", "decodeInt", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeChar", "", "decodeString", "decodeEnum", "enumDescriptor", "decodeNotNullMark", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateDecoder extends AbstractDecoder {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key;
    private final Bundle savedState;

    public SavedStateDecoder(Bundle arg2, SavedStateConfiguration arg3) {
        Intrinsics.checkNotNullParameter(arg2, "savedState");
        Intrinsics.checkNotNullParameter(arg3, "configuration");
        super();
        this.savedState = arg2;
        this.configuration = arg3;
        this.key = "";
    }

    public CompositeDecoder beginStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(Intrinsics.areEqual(this.key, "")) {
            return this;
        }

        return new SavedStateDecoder(SavedStateReader.getSavedState-impl(SavedStateReader.constructor-impl(this.savedState), this.key), this.configuration);
    }

    public boolean decodeBoolean() {
        return SavedStateReader.getBoolean-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public byte decodeByte() {
        return ((byte)SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key));
    }

    public char decodeChar() {
        return SavedStateReader.getChar-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public double decodeDouble() {
        return SavedStateReader.getDouble-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public int decodeElementIndex(SerialDescriptor arg4) {
        String v1_1;
        Intrinsics.checkNotNullParameter(arg4, "descriptor");
        int v0 = (Intrinsics.areEqual(arg4.getKind(), LIST.INSTANCE)) || (Intrinsics.areEqual(arg4.getKind(), MAP.INSTANCE)) ? SavedStateReader.size-impl(SavedStateReader.constructor-impl(this.savedState)) : arg4.getElementsCount();
        while(true) {
            int v1 = this.index;
            if(v1 >= v0) {
                return -1;
            }

            v1_1 = arg4.getElementName(v1);
            if((arg4.isElementOptional(this.index)) && !SavedStateReader.contains-impl(SavedStateReader.constructor-impl(this.savedState), v1_1)) {
                ++this.index;
                continue;
            }

            break;
        }

        this.key = v1_1;
        int v4 = this.index;
        this.index = v4 + 1;
        return v4;
    }

    public int decodeEnum(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        return SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public float decodeFloat() {
        return SavedStateReader.getFloat-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public int decodeInt() {
        return SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public long decodeLong() {
        return SavedStateReader.getLong-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
    }

    public boolean decodeNotNullMark() {
        return SavedStateReader.isNull-impl(SavedStateReader.constructor-impl(this.savedState), this.key) ^ 1;
    }

    public Object decodeSerializableValue(DeserializationStrategy arg3) {
        Intrinsics.checkNotNullParameter(arg3, "deserializer");
        Object v0 = SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, arg3);
        if(v0 != null) {
            return v0;
        }

        SerialDescriptor v0_1 = arg3.getDescriptor();
        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            return SavedStateReader.getIntList-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            return SavedStateReader.getStringList-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            return SavedStateReader.getBooleanArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            return SavedStateReader.getCharArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            return SavedStateReader.getDoubleArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            return SavedStateReader.getFloatArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            return SavedStateReader.getIntArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            return SavedStateReader.getLongArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        if(Intrinsics.areEqual(v0_1, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return SavedStateReader.getStringArray-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
        }

        return super.decodeSerializableValue(arg3);
    }

    public short decodeShort() {
        return ((short)SavedStateReader.getInt-impl(SavedStateReader.constructor-impl(this.savedState), this.key));
    }

    public String decodeString() {
        return SavedStateReader.getString-impl(SavedStateReader.constructor-impl(this.savedState), this.key);
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
}

