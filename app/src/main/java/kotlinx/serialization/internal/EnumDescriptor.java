package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind$OBJECT;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0005H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u0003H\u0016J\b\u0010\u001A\u001A\u00020\u0005H\u0016R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR!\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "elementsCount", "", "<init>", "(Ljava/lang/String;I)V", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lkotlin/Lazy;", "getElementDescriptor", "index", "equals", "", "other", "", "toString", "hashCode", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {
    private final Lazy elementDescriptors$delegate;
    private final SerialKind kind;

    public EnumDescriptor(String arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg8, "name");
        super(arg8, null, arg9, 2, null);
        this.kind = ENUM.INSTANCE;
        this.elementDescriptors$delegate = LazyKt.lazy(new EnumDescriptor$$ExternalSyntheticLambda0(arg9, arg8, this));
    }

    static final SerialDescriptor[] elementDescriptors_delegate$lambda$0(int arg10, String arg11, EnumDescriptor arg12) {
        SerialDescriptor[] v0 = new SerialDescriptor[arg10];
        int v2;
        for(v2 = 0; v2 < arg10; ++v2) {
            v0[v2] = SerialDescriptorsKt.buildSerialDescriptor$default(arg11 + '.' + arg12.getElementName(v2), OBJECT.INSTANCE, new SerialDescriptor[0], null, 8, null);
        }

        return v0;
    }

    public boolean equals(Object arg5) {
        if(this == (((EnumDescriptor)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(!(arg5 instanceof SerialDescriptor)) {
            return 0;
        }

        if(((SerialDescriptor)arg5).getKind() != ENUM.INSTANCE) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getSerialName(), ((SerialDescriptor)arg5).getSerialName())) {
            return 0;
        }

        if(!Intrinsics.areEqual(Platform_commonKt.cachedSerialNames(((SerialDescriptor)this)), Platform_commonKt.cachedSerialNames(((SerialDescriptor)arg5)))) {
            return 0;
        }

        return 1;
    }

    public SerialDescriptor getElementDescriptor(int arg1) {
        return this.getElementDescriptors()[arg1];
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return this.elementDescriptors$delegate.getValue();
    }

    public SerialKind getKind() {
        return this.kind;
    }

    public int hashCode() {
        int v0 = this.getSerialName().hashCode();
        Iterator v3 = SerialDescriptorKt.getElementNames(((SerialDescriptor)this)).iterator();
        int v1;
        for(v1 = 1; v3.hasNext(); v1 += v2_1) {
            Object v2 = v3.next();
            v1 *= 0x1F;
            int v2_1 = v2 != null ? v2.hashCode() : 0;
        }

        return v0 * 0x1F + v1;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(SerialDescriptorKt.getElementNames(this), ", ", this.getSerialName() + '(', ")", 0, null, null, 56, null);
    }
}

