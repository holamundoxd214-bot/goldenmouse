package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor$DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind$LIST;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u0010\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0010H\u0016J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u0016\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u0010\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\fH\u0016J\u0013\u0010\u0019\u001A\u00020\u00152\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\fH\u0016J\b\u0010\u001D\u001A\u00020\u0010H\u0016R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\fX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E\u0082\u0001\u0005\u001E\u001F !\"¨\u0006#"}, d2={"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "", "index", "getElementIndex", "name", "isElementOptional", "", "getElementAnnotations", "", "", "equals", "other", "", "hashCode", "toString", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @ExperimentalSerializationApi public abstract class ListLikeDescriptor implements SerialDescriptor {
    private final SerialDescriptor elementDescriptor;
    private final int elementsCount;

    private ListLikeDescriptor(SerialDescriptor arg1) {
        super();
        this.elementDescriptor = arg1;
        this.elementsCount = 1;
    }

    public ListLikeDescriptor(SerialDescriptor arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public boolean equals(Object arg5) {
        if(this == (((ListLikeDescriptor)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ListLikeDescriptor)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.elementDescriptor, ((ListLikeDescriptor)arg5).elementDescriptor)) && (Intrinsics.areEqual(this.getSerialName(), ((ListLikeDescriptor)arg5).getSerialName()))) {
            return 1;
        }

        return 0;
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

    public final SerialDescriptor getElementDescriptor() {
        return this.elementDescriptor;
    }

    public SerialDescriptor getElementDescriptor(int arg3) {
        if(arg3 >= 0) {
            return this.elementDescriptor;
        }

        throw new IllegalArgumentException("Illegal index " + arg3 + ", " + this.getSerialName() + " expects only non-negative indices".toString());
    }

    public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Integer v1 = StringsKt.toIntOrNull(arg2);
        if(v1 != null) {
            return v1.intValue();
        }

        throw new IllegalArgumentException(arg2 + " is not a valid list index");
    }

    public String getElementName(int arg1) {
        return String.valueOf(arg1);
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    public SerialKind getKind() {
        return LIST.INSTANCE;
    }

    public int hashCode() {
        return this.elementDescriptor.hashCode() * 0x1F + this.getSerialName().hashCode();
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
        return this.getSerialName() + '(' + this.elementDescriptor + ')';
    }
}

