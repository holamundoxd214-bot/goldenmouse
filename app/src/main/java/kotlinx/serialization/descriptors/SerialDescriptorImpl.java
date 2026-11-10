package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010-\u001A\u00020\u00042\u0006\u0010.\u001A\u00020\bH\u0016J\u0010\u0010/\u001A\u00020\b2\u0006\u00100\u001A\u00020\u0004H\u0016J\u0016\u00101\u001A\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010.\u001A\u00020\bH\u0016J\u0010\u00102\u001A\u00020\u00012\u0006\u0010.\u001A\u00020\bH\u0016J\u0010\u00103\u001A\u0002042\u0006\u0010.\u001A\u00020\bH\u0016J\u0013\u00105\u001A\u0002042\b\u00106\u001A\u0004\u0018\u000107H\u0096\u0002J\b\u00108\u001A\u00020\bH\u0016J\b\u00109\u001A\u00020\u0004H\u0016R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00040\u001AX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00040\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001FR\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00010\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001C\u0010\"\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u000E\u0010$\u001A\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010&\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00010\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001B\u0010)\u001A\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b*\u0010\u0014¨\u0006:"}, d2={"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getElementsCount", "()I", "annotations", "", "getAnnotations", "()Ljava/util/List;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "elementNames", "", "[Ljava/lang/String;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "elementOptionality", "", "name2Index", "", "typeParametersDescriptors", "_hashCode", "get_hashCode", "_hashCode$delegate", "Lkotlin/Lazy;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", "", "equals", "other", "", "hashCode", "toString", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    private final Lazy _hashCode$delegate;
    private final List annotations;
    private final List[] elementAnnotations;
    private final SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final SerialKind kind;
    private final Map name2Index;
    private final String serialName;
    private final Set serialNames;
    private final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String arg2, SerialKind arg3, int arg4, List arg5, ClassSerialDescriptorBuilder arg6) {
        Intrinsics.checkNotNullParameter(arg2, "serialName");
        Intrinsics.checkNotNullParameter(arg3, "kind");
        Intrinsics.checkNotNullParameter(arg5, "typeParameters");
        Intrinsics.checkNotNullParameter(arg6, "builder");
        super();
        this.serialName = arg2;
        this.kind = arg3;
        this.elementsCount = arg4;
        this.annotations = arg6.getAnnotations();
        this.serialNames = CollectionsKt.toHashSet(arg6.getElementNames$kotlinx_serialization_core());
        Object[] v2 = arg6.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementNames = ((String[])v2);
        this.elementDescriptors = Platform_commonKt.compactArray(arg6.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = arg6.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        this.elementOptionality = CollectionsKt.toBooleanArray(arg6.getElementOptionality$kotlinx_serialization_core());
        Iterable v2_1 = ArraysKt.withIndex(v2);
        ArrayList v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v2_1, 10));
        Iterator v2_2 = v2_1.iterator();
        while(v2_2.hasNext()) {
            Object v4 = v2_2.next();
            ((Collection)v3).add(TuplesKt.to(((IndexedValue)v4).getValue(), Integer.valueOf(((IndexedValue)v4).getIndex())));
        }

        this.name2Index = MapsKt.toMap(((Iterable)v3));
        this.typeParametersDescriptors = Platform_commonKt.compactArray(arg5);
        this._hashCode$delegate = LazyKt.lazy(new SerialDescriptorImpl$$ExternalSyntheticLambda0(this));
    }

    static final int _hashCode_delegate$lambda$1(SerialDescriptorImpl arg1) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(arg1, arg1.typeParametersDescriptors);
    }

    public boolean equals(Object arg7) {
        SerialDescriptorImpl v0 = this;
        if(v0 == arg7) {
            return 1;
        }

        if(!(arg7 instanceof SerialDescriptorImpl)) {
            return 0;
        }

        Object v4 = arg7;
        if(!Intrinsics.areEqual(((SerialDescriptor)v0).getSerialName(), ((SerialDescriptor)v4).getSerialName())) {
            return 0;
        }

        if(!Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl)arg7).typeParametersDescriptors)) {
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
        return this.annotations;
    }

    public List getElementAnnotations(int arg1) {
        return this.elementAnnotations[arg1];
    }

    public SerialDescriptor getElementDescriptor(int arg1) {
        return this.elementDescriptors[arg1];
    }

    public int getElementIndex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Object v1 = this.name2Index.get(arg2);
        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        return -3;
    }

    public String getElementName(int arg1) {
        return this.elementNames[arg1];
    }

    public int getElementsCount() {
        return this.elementsCount;
    }

    public SerialKind getKind() {
        return this.kind;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public Set getSerialNames() {
        return this.serialNames;
    }

    private final int get_hashCode() {
        return this._hashCode$delegate.getValue().intValue();
    }

    public int hashCode() {
        return this.get_hashCode();
    }

    public boolean isElementOptional(int arg1) {
        return this.elementOptionality[arg1];
    }

    public boolean isInline() {
        return DefaultImpls.isInline(((SerialDescriptor)this));
    }

    public boolean isNullable() {
        return DefaultImpls.isNullable(((SerialDescriptor)this));
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.getElementsCount()), ", ", this.getSerialName() + '(', ")", 0, null, new SerialDescriptorImpl$$ExternalSyntheticLambda1(this), 24, null);
    }

    static final CharSequence toString$lambda$3(SerialDescriptorImpl arg2, int arg3) {
        return arg2.getElementName(arg3) + ": " + arg2.getElementDescriptor(arg3).getSerialName();
    }
}

