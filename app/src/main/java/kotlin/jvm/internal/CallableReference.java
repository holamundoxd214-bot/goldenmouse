package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;

public abstract class CallableReference implements Serializable, KotlinGenericDeclaration, KCallable {
    class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE;

        static {
            NoReceiver.INSTANCE = new NoReceiver();
        }

        private NoReceiver() {
            super();
        }

        static NoReceiver access$000() {
            return NoReceiver.INSTANCE;
        }

        private Object readResolve() throws ObjectStreamException {
            return NoReceiver.INSTANCE;
        }
    }

    public static final Object NO_RECEIVER;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    static {
        CallableReference.NO_RECEIVER = NoReceiver.access$000();
    }

    public CallableReference() {
        this(CallableReference.NO_RECEIVER);
    }

    protected CallableReference(Object arg7) {
        this(arg7, null, null, null, false);
    }

    protected CallableReference(Object arg1, Class arg2, String arg3, String arg4, boolean arg5) {
        super();
        this.receiver = arg1;
        this.owner = arg2;
        this.name = arg3;
        this.signature = arg4;
        this.isTopLevel = arg5;
    }

    public Object call(Object[] arg1) {
        return this.getReflected().call(arg1);
    }

    public Object callBy(Map arg1) {
        return this.getReflected().callBy(arg1);
    }

    public KCallable compute() {
        KCallable v0 = this.reflected;
        if(v0 == null) {
            v0 = this.computeReflected();
            this.reflected = v0;
        }

        return v0;
    }

    protected abstract KCallable computeReflected();

    public GenericDeclaration findJavaDeclaration() {
        return KotlinGenericDeclarationKt.findMethodBySignature(this.getOwner(), this.getSignature());
    }

    public List getAnnotations() {
        return this.getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Class v0 = this.owner;
        if(v0 == null) {
            return null;
        }

        if(this.isTopLevel) {
            return Reflection.getOrCreateKotlinPackage(v0);
        }

        return Reflection.getOrCreateKotlinClass(v0);
    }

    public List getParameters() {
        return this.getReflected().getParameters();
    }

    protected KCallable getReflected() {
        KCallable v0 = this.compute();
        if((((CallableReference)v0)) != this) {
            return v0;
        }

        throw new KotlinReflectionNotSupportedError();
    }

    public KType getReturnType() {
        return this.getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    public List getTypeParameters() {
        return this.getReflected().getTypeParameters();
    }

    public KVisibility getVisibility() {
        return this.getReflected().getVisibility();
    }

    public boolean isAbstract() {
        return this.getReflected().isAbstract();
    }

    public boolean isFinal() {
        return this.getReflected().isFinal();
    }

    public boolean isOpen() {
        return this.getReflected().isOpen();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }
}

