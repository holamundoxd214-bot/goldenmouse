package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u001D2\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\'\u001A\u00020\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R$\u0010\b\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000ER*\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000B\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00030\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001D0\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0014R \u0010\u001F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0014R\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00020\t0\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0014¨\u0006("}, d2={"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "<init>", "(Ljava/lang/String;)V", "getSerialName", "()Ljava/lang/String;", "isNullable", "", "isNullable$annotations", "()V", "()Z", "setNullable", "(Z)V", "annotations", "", "", "getAnnotations$annotations", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementNames", "", "getElementNames$kotlinx_serialization_core", "uniqueNames", "", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementAnnotations", "getElementAnnotations$kotlinx_serialization_core", "elementOptionality", "getElementOptionality$kotlinx_serialization_core", "element", "", "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClassSerialDescriptorBuilder {
    private List annotations;
    private final List elementAnnotations;
    private final List elementDescriptors;
    private final List elementNames;
    private final List elementOptionality;
    private boolean isNullable;
    private final String serialName;
    private final Set uniqueNames;

    public ClassSerialDescriptorBuilder(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        super();
        this.serialName = arg2;
        this.annotations = CollectionsKt.emptyList();
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    public final void element(String arg2, SerialDescriptor arg3, List arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "elementName");
        Intrinsics.checkNotNullParameter(arg3, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "annotations");
        if(this.uniqueNames.add(arg2)) {
            this.elementNames.add(arg2);
            this.elementDescriptors.add(arg3);
            this.elementAnnotations.add(arg4);
            this.elementOptionality.add(Boolean.valueOf(arg5));
            return;
        }

        throw new IllegalArgumentException("Element with name \'" + arg2 + "\' is already registered in " + this.serialName.toString());
    }

    public static void element$default(ClassSerialDescriptorBuilder arg0, String arg1, SerialDescriptor arg2, List arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = CollectionsKt.emptyList();
        }

        arg0.element(arg1, arg2, arg3, false);
    }

    public final List getAnnotations() {
        return this.annotations;
    }

    @ExperimentalSerializationApi public static void getAnnotations$annotations() {
    }

    public final List getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    public final List getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    public final List getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    public final List getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final String getSerialName() {
        return this.serialName;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="isNullable inside buildSerialDescriptor is deprecated. Please use SerialDescriptor.nullable extension on a builder result.") @ExperimentalSerializationApi public static void isNullable$annotations() {
    }

    public final void setAnnotations(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.annotations = arg2;
    }

    public final void setNullable(boolean arg1) {
        this.isNullable = arg1;
    }
}

