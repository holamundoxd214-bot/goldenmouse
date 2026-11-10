package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        super();
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object arg1) {
        super(arg1);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object arg10, Class arg11, String arg12, String arg13, int arg14) {
        boolean v1 = false;
        boolean v8 = (arg14 & 1) == 1 ? true : false;
        PropertyReference v3 = this;
        super(arg10, arg11, arg12, arg13, v8);
        if((arg14 & 2) == 2) {
            v1 = true;
        }

        v3.syntheticJavaProperty = v1;
    }

    public KCallable compute() {
        if(this.syntheticJavaProperty) {
            return this;
        }

        return super.compute();
    }

    public boolean equals(Object arg5) {
        if((((PropertyReference)arg5)) == this) {
            return 1;
        }

        if((arg5 instanceof PropertyReference)) {
            if((this.getOwner().equals(((PropertyReference)arg5).getOwner())) && (this.getName().equals(((PropertyReference)arg5).getName())) && (this.getSignature().equals(((PropertyReference)arg5).getSignature())) && (Intrinsics.areEqual(this.getBoundReceiver(), ((PropertyReference)arg5).getBoundReceiver()))) {
                return 1;
            }

            return 0;
        }

        if((arg5 instanceof KProperty)) {
            return arg5.equals(this.compute());
        }

        return 0;
    }

    protected KCallable getReflected() {
        return this.getReflected();
    }

    protected KProperty getReflected() {
        if(!this.syntheticJavaProperty) {
            return super.getReflected();
        }

        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }

    public int hashCode() {
        return (this.getOwner().hashCode() * 0x1F + this.getName().hashCode()) * 0x1F + this.getSignature().hashCode();
    }

    public boolean isConst() {
        return this.getReflected().isConst();
    }

    public boolean isLateinit() {
        return this.getReflected().isLateinit();
    }

    public String toString() {
        KCallable v0 = this.compute();
        if((((PropertyReference)v0)) != this) {
            return v0.toString();
        }

        return "property " + this.getName() + " (Kotlin reflection is not available)";
    }
}

