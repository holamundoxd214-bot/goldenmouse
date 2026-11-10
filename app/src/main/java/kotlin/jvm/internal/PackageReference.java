package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001D\bF\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001A\u00020\u0005H\u0096\u0080\u0004R\u0019\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001F\u0010\n\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0016"}, d2={"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PackageReference implements ClassBasedDeclarationContainer {
    private final Class jClass;
    private final String moduleName;

    public PackageReference(Class arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "jClass");
        Intrinsics.checkNotNullParameter(arg3, "moduleName");
        super();
        this.jClass = arg2;
        this.moduleName = arg3;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof PackageReference)) && (Intrinsics.areEqual(this.getJClass(), ((PackageReference)arg2).getJClass()))) {
            return 1;
        }

        return 0;
    }

    public Class getJClass() {
        return this.jClass;
    }

    public Collection getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return this.getJClass().hashCode();
    }

    public String toString() {
        return this.getJClass().toString() + " (Kotlin reflection is not available)";
    }
}

