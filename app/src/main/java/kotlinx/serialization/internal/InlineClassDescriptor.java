package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\n¨\u0006\u0010"}, d2={"Lkotlinx/serialization/internal/InlineClassDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;)V", "isInline", "", "()Z", "hashCode", "", "equals", "other", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {
    private final boolean isInline;

    public InlineClassDescriptor(String arg2, GeneratedSerializer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Intrinsics.checkNotNullParameter(arg3, "generatedSerializer");
        super(arg2, arg3, 1);
        this.isInline = true;
    }

    public boolean equals(Object arg7) {
        InlineClassDescriptor v0 = this;
        if(v0 == arg7) {
            return 1;
        }

        if(!(arg7 instanceof InlineClassDescriptor)) {
            return 0;
        }

        Object v4 = arg7;
        if(!Intrinsics.areEqual(((SerialDescriptor)v0).getSerialName(), ((SerialDescriptor)v4).getSerialName())) {
            return 0;
        }

        if((((InlineClassDescriptor)arg7).isInline()) && (Arrays.equals(this.getTypeParameterDescriptors$kotlinx_serialization_core(), ((InlineClassDescriptor)arg7).getTypeParameterDescriptors$kotlinx_serialization_core()))) {
            if(((SerialDescriptor)v0).getElementsCount() != ((SerialDescriptor)v4).getElementsCount()) {
                return 0;
            }
            else {
                int v6 = ((SerialDescriptor)v0).getElementsCount();
                int v7 = 0;
                while(true) {
                    if(v7 >= v6) {
                        return 1;
                    }
                    else if(!Intrinsics.areEqual(((SerialDescriptor)v0).getElementDescriptor(v7).getSerialName(), ((SerialDescriptor)v4).getElementDescriptor(v7).getSerialName())) {
                        return 0;
                    }
                    else if(!Intrinsics.areEqual(((SerialDescriptor)v0).getElementDescriptor(v7).getKind(), ((SerialDescriptor)v4).getElementDescriptor(v7).getKind())) {
                        return 0;
                    }
                    else {
                        ++v7;
                        continue;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        return super.hashCode() * 0x1F;
    }

    public boolean isInline() {
        return this.isInline;
    }
}

