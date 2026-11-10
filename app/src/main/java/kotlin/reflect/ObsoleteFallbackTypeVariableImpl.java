package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\bF\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\u0002H\u0016J\u0013\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0002\u0010\u000EJ\n\u0010\u000F\u001A\u00020\tH\u0096\u0080\u0004J\u0014\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0082\u0004J\n\u0010\u0014\u001A\u00020\u0015H\u0096\u0080\u0004J\n\u0010\u0016\u001A\u00020\tH\u0096\u0080\u0004J)\u0010\u0017\u001A\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001BH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001CJ\u0015\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00190\fH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001EJ\u0015\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00190\fH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001ER\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Lkotlin/reflect/ObsoleteFallbackTypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "<init>", "(Lkotlin/reflect/KTypeParameter;)V", "getName", "", "getGenericDeclaration", "getBounds", "", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getTypeName", "equals", "", "other", "", "hashCode", "", "toString", "getAnnotation", "T", "", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "()[Ljava/lang/annotation/Annotation;", "getDeclaredAnnotations", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ObsoleteFallbackTypeVariableImpl implements TypeVariable, TypeImpl {
    private final KTypeParameter typeParameter;

    public ObsoleteFallbackTypeVariableImpl(KTypeParameter arg2) {
        Intrinsics.checkNotNullParameter(arg2, "typeParameter");
        super();
        this.typeParameter = arg2;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof TypeVariable)) && (Intrinsics.areEqual(this.getName(), ((TypeVariable)arg3).getName())) && (Intrinsics.areEqual(this.getGenericDeclaration(), ((TypeVariable)arg3).getGenericDeclaration()))) {
            return 1;
        }

        return 0;
    }

    public final Annotation getAnnotation(Class arg1) {
        Intrinsics.checkNotNullParameter(arg1, "annotationClass");
        return null;
    }

    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public Type[] getBounds() {
        List v3 = this.typeParameter.getUpperBounds();
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), 10));
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            ((Collection)v0).add(TypesJVMKt.access$computeJavaType(v3_1.next(), true));
        }

        return ((Collection)v0).toArray(new Type[0]);
    }

    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }

    public GenericDeclaration getGenericDeclaration() {
        throw new UnsupportedOperationException("getGenericDeclaration() is not supported for type variables created from KType: " + this.typeParameter + ".\nUpdate kotlin-reflect dependency to 2.3.20+.");
    }

    public String getName() {
        return this.typeParameter.getName();
    }

    public String getTypeName() {
        return this.getName();
    }

    public int hashCode() {
        return this.getGenericDeclaration().hashCode() ^ this.getName().hashCode();
    }

    public String toString() {
        return this.getTypeName();
    }
}

