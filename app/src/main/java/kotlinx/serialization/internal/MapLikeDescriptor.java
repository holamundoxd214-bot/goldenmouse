package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor$DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind$MAP;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0012H\u0016J\u0010\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0003H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0016\u001A\u00020\u0012H\u0016J\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C2\u0006\u0010\u0016\u001A\u00020\u0012H\u0016J\u0010\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0012H\u0016J\u0013\u0010\u001F\u001A\u00020\u001A2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020\u0012H\u0016J\b\u0010#\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014\u0082\u0001\u0002$%¨\u0006&"}, d2={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getValueDescriptor", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", "", "getElementAnnotations", "", "", "getElementDescriptor", "equals", "other", "", "hashCode", "toString", "Lkotlinx/serialization/internal/HashMapClassDesc;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class MapLikeDescriptor implements SerialDescriptor {
    private final int elementsCount;
    private final SerialDescriptor keyDescriptor;
    private final String serialName;
    private final SerialDescriptor valueDescriptor;

    private MapLikeDescriptor(String arg1, SerialDescriptor arg2, SerialDescriptor arg3) {
        super();
        this.serialName = arg1;
        this.keyDescriptor = arg2;
        this.valueDescriptor = arg3;
        this.elementsCount = 2;
    }

    public MapLikeDescriptor(String arg1, SerialDescriptor arg2, SerialDescriptor arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((MapLikeDescriptor)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MapLikeDescriptor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getSerialName(), ((MapLikeDescriptor)arg5).getSerialName())) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyDescriptor, ((MapLikeDescriptor)arg5).keyDescriptor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.valueDescriptor, ((MapLikeDescriptor)arg5).valueDescriptor)) {
            return 0;
        }

        return 1;
    }

    public List getAnnotations() {
        return DefaultImpls.getAnnotations(((SerialDescriptor)this));
    }

    public List getElementAnnotations(int arg3) {
        if(arg3 >= 0) {
            return CollectionsKt.emptyList();
        }

        throw new IllegalArgumentException("Illegal index " + arg3 + ", " + this.getSerialName() + " expects only non-negative indices".toString());
    }

    public SerialDescriptor getElementDescriptor(int arg3) {
        if(arg3 >= 0) {
            arg3 %= 2;
            if(arg3 != 0) {
                if(arg3 == 1) {
                    return this.valueDescriptor;
                }

                throw new IllegalStateException("Unreached".toString());
            }

            return this.keyDescriptor;
        }

        throw new IllegalArgumentException("Illegal index " + arg3 + ", " + this.getSerialName() + " expects only non-negative indices".toString());
    }

    public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Integer v1 = StringsKt.toIntOrNull(arg2);
        if(v1 != null) {
            return v1.intValue();
        }

        throw new IllegalArgumentException(arg2 + " is not a valid map index");
    }

    public String getElementName(int arg1) {
        return String.valueOf(arg1);
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    public final SerialDescriptor getKeyDescriptor() {
        return this.keyDescriptor;
    }

    public SerialKind getKind() {
        return MAP.INSTANCE;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public final SerialDescriptor getValueDescriptor() {
        return this.valueDescriptor;
    }

    public int hashCode() {
        return (this.getSerialName().hashCode() * 0x1F + this.keyDescriptor.hashCode()) * 0x1F + this.valueDescriptor.hashCode();
    }

    public boolean isElementOptional(int arg3) {
        if(arg3 >= 0) {
            return 0;
        }

        throw new IllegalArgumentException("Illegal index " + arg3 + ", " + this.getSerialName() + " expects only non-negative indices".toString());
    }

    public boolean isInline() {
        return DefaultImpls.isInline(((SerialDescriptor)this));
    }

    public boolean isNullable() {
        return DefaultImpls.isNullable(((SerialDescriptor)this));
    }

    public String toString() {
        return this.getSerialName() + '(' + this.keyDescriptor + ", " + this.valueDescriptor + ')';
    }
}

