package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor$DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind$CLASS;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u00105\u001A\u0002062\u0006\u00107\u001A\u00020\u00042\b\b\u0002\u00108\u001A\u000209J\u000E\u0010:\u001A\u0002062\u0006\u0010;\u001A\u00020\u0015J\u000E\u0010<\u001A\u0002062\u0006\u0010=\u001A\u00020\u0015J\u0010\u0010>\u001A\u00020\u00012\u0006\u0010?\u001A\u00020\bH\u0016J\u0010\u0010@\u001A\u0002092\u0006\u0010?\u001A\u00020\bH\u0016J\u0016\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010?\u001A\u00020\bH\u0016J\u0010\u0010B\u001A\u00020\u00042\u0006\u0010?\u001A\u00020\bH\u0016J\u0010\u0010C\u001A\u00020\b2\u0006\u00107\u001A\u00020\u0004H\u0016J\u0014\u0010D\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\'H\u0002J\u0013\u0010E\u001A\u0002092\b\u0010F\u001A\u0004\u0018\u00010GH\u0096\u0002J\b\u0010H\u001A\u00020\bH\u0016J\b\u0010I\u001A\u00020\u0004H\u0016R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0005\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00040\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001BR\u001E\u0010\u001C\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001D0\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001ER\u0016\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%R\u001A\u0010&\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\'X\u0082\u000E¢\u0006\u0002\n\u0000R%\u0010(\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\u001A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b*\u0010+R!\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00010\u001A8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b1\u0010-\u001A\u0004\b/\u00100R\u001B\u00102\u001A\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010-\u001A\u0004\b3\u0010\u000E¨\u0006J"}, d2={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "getSerialName", "()Ljava/lang/String;", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "added", "names", "", "[Ljava/lang/String;", "propertiesAnnotations", "", "[Ljava/util/List;", "classAnnotations", "elementsOptionality", "", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "indices", "", "childSerializers", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "Lkotlin/Lazy;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "_hashCode", "get_hashCode", "_hashCode$delegate", "addElement", "", "name", "isOptional", "", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "getElementDescriptor", "index", "isElementOptional", "getElementAnnotations", "getElementName", "getElementIndex", "buildIndices", "equals", "other", "", "hashCode", "toString", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    private final Lazy _hashCode$delegate;
    private int added;
    private final Lazy childSerializers$delegate;
    private List classAnnotations;
    private final int elementsCount;
    private final boolean[] elementsOptionality;
    private final GeneratedSerializer generatedSerializer;
    private Map indices;
    private final String[] names;
    private final List[] propertiesAnnotations;
    private final String serialName;
    private final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String arg2, GeneratedSerializer arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        super();
        this.serialName = arg2;
        this.generatedSerializer = arg3;
        this.elementsCount = arg4;
        this.added = -1;
        String[] v2 = new String[arg4];
        int v3;
        for(v3 = 0; v3 < arg4; ++v3) {
            v2[v3] = "[UNINITIALIZED]";
        }

        this.names = v2;
        int v2_1 = this.elementsCount;
        this.propertiesAnnotations = new List[v2_1];
        this.elementsOptionality = new boolean[v2_1];
        this.indices = MapsKt.emptyMap();
        this.childSerializers$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1(this));
        this.typeParameterDescriptors$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda2(this));
        this._hashCode$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda3(this));
    }

    public PluginGeneratedSerialDescriptor(String arg1, GeneratedSerializer arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, arg3);
    }

    static final int _hashCode_delegate$lambda$3(PluginGeneratedSerialDescriptor arg1) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(arg1, arg1.getTypeParameterDescriptors$kotlinx_serialization_core());
    }

    public final void addElement(String arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "name");
        String[] v0 = this.names;
        int v1 = this.added + 1;
        this.added = v1;
        v0[v1] = arg3;
        this.elementsOptionality[v1] = arg4;
        this.propertiesAnnotations[v1] = null;
        if(v1 == this.elementsCount - 1) {
            this.indices = this.buildIndices();
        }
    }

    public static void addElement$default(PluginGeneratedSerialDescriptor arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.addElement(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final Map buildIndices() {
        HashMap v0 = new HashMap();
        int v1 = this.names.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.put(this.names[v2], Integer.valueOf(v2));
        }

        return ((Map)v0);
    }

    static final KSerializer[] childSerializers_delegate$lambda$0(PluginGeneratedSerialDescriptor arg0) {
        GeneratedSerializer v0 = arg0.generatedSerializer;
        if(v0 != null) {
            KSerializer[] v0_1 = v0.childSerializers();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
    }

    public boolean equals(Object arg7) {
        PluginGeneratedSerialDescriptor v0 = this;
        if(v0 == arg7) {
            return 1;
        }

        if(!(arg7 instanceof PluginGeneratedSerialDescriptor)) {
            return 0;
        }

        Object v4 = arg7;
        if(!Intrinsics.areEqual(((SerialDescriptor)v0).getSerialName(), ((SerialDescriptor)v4).getSerialName())) {
            return 0;
        }

        if(!Arrays.equals(this.getTypeParameterDescriptors$kotlinx_serialization_core(), ((PluginGeneratedSerialDescriptor)arg7).getTypeParameterDescriptors$kotlinx_serialization_core())) {
            return 0;
        }

        if(((SerialDescriptor)v0).getElementsCount() != ((SerialDescriptor)v4).getElementsCount()) {
            return 0;
        }

        int v6 = ((SerialDescriptor)v0).getElementsCount();
        int v7;
        for(v7 = 0; v7 < v6; ++v7) {
            if(!Intrinsics.areEqual(((SerialDescriptor)v0).getElementDescriptor(v7).getSerialName(), ((SerialDescriptor)v4).getElementDescriptor(v7).getSerialName())) {
                return 0;
            }

            if(!Intrinsics.areEqual(((SerialDescriptor)v0).getElementDescriptor(v7).getKind(), ((SerialDescriptor)v4).getElementDescriptor(v7).getKind())) {
                return 0;
            }
        }

        return 1;
    }

    public List getAnnotations() {
        List v0 = this.classAnnotations;
        if(v0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return v0;
    }

    private final KSerializer[] getChildSerializers() {
        return this.childSerializers$delegate.getValue();
    }

    public List getElementAnnotations(int arg1) {
        List v0 = this.propertiesAnnotations[arg1];
        if(v0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return v0;
    }

    public SerialDescriptor getElementDescriptor(int arg1) {
        return this.getChildSerializers()[arg1].getDescriptor();
    }

    public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Object v1 = this.indices.get(arg2);
        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        return -3;
    }

    public String getElementName(int arg1) {
        return this.names[arg1];
    }

    public final int getElementsCount() {
        return this.elementsCount;
    }

    public SerialKind getKind() {
        return CLASS.INSTANCE;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public Set getSerialNames() {
        return this.indices.keySet();
    }

    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return this.typeParameterDescriptors$delegate.getValue();
    }

    private final int get_hashCode() {
        return this._hashCode$delegate.getValue().intValue();
    }

    public int hashCode() {
        return this.get_hashCode();
    }

    public boolean isElementOptional(int arg1) {
        return this.elementsOptionality[arg1];
    }

    public boolean isInline() {
        return DefaultImpls.isInline(((SerialDescriptor)this));
    }

    public boolean isNullable() {
        return DefaultImpls.isNullable(((SerialDescriptor)this));
    }

    public final void pushAnnotation(Annotation arg3) {
        ArrayList v0_1;
        Intrinsics.checkNotNullParameter(arg3, "annotation");
        List v0 = this.propertiesAnnotations[this.added];
        if(v0 == null) {
            v0_1 = new ArrayList(1);
            this.propertiesAnnotations[this.added] = v0_1;
        }

        ((List)v0_1).add(arg3);
    }

    public final void pushClassAnnotation(Annotation arg3) {
        Intrinsics.checkNotNullParameter(arg3, "a");
        List v0 = this.classAnnotations;
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList(1);
            this.classAnnotations = ((List)v0_1);
        }

        Intrinsics.checkNotNull(v0);
        v0.add(arg3);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.elementsCount), ", ", this.getSerialName() + '(', ")", 0, null, new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0(this), 24, null);
    }

    static final CharSequence toString$lambda$6(PluginGeneratedSerialDescriptor arg2, int arg3) {
        return arg2.getElementName(arg3) + ": " + arg2.getElementDescriptor(arg3).getSerialName();
    }

    static final SerialDescriptor[] typeParameterDescriptors_delegate$lambda$2(PluginGeneratedSerialDescriptor arg4) {
        List v0_1;
        GeneratedSerializer v4 = arg4.generatedSerializer;
        if(v4 != null) {
            KSerializer[] v4_1 = v4.typeParametersSerializers();
            if(v4_1 != null) {
                ArrayList v0 = new ArrayList(v4_1.length);
                int v1 = v4_1.length;
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    ((Collection)v0).add(v4_1[v2].getDescriptor());
                }
            }
            else {
                goto label_16;
            }
        }
        else {
        label_16:
            v0_1 = null;
        }

        return Platform_commonKt.compactArray(v0_1);
    }
}

