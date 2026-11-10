package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB-\bF\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\u001A\u001A\u00020\u001B2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0015\u0010\u0007\u001A\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\t\u001A\u00020\nX\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0011R\u0017\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u008E\b¢\u0006\u0002\n\u0000R!\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0084\b¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001D"}, d2={"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/jvm/internal/KTypeParameterBase;", "container", "", "Lkotlin/jvm/internal/TypeParameterContainer;", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "getName", "()Ljava/lang/String;", "getVariance", "()Lkotlin/reflect/KVariance;", "()Z", "bounds", "", "Lkotlin/reflect/KType;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "setUpperBounds", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TypeParameterReference extends KTypeParameterBase {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004¨\u0006\b"}, d2={"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "<init>", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
            static {
                int[] v0 = new int[KVariance.values().length];
                try {
                    v0[KVariance.INVARIANT.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[KVariance.IN.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_11:
                            v0[KVariance.OUT.ordinal()] = 3;
                            goto label_15;
                        }
                        catch(NoSuchFieldError ) {
                        label_15:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String toString(KTypeParameter arg3) {
            Intrinsics.checkNotNullParameter(arg3, "typeParameter");
            StringBuilder v2 = new StringBuilder();
            int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getVariance().ordinal()];
            if(v0 != 1) {
                if(v0 == 2) {
                    v2.append("in ");
                }
                else if(v0 == 3) {
                    v2.append("out ");
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            v2.append(arg3.getName());
            return v2.toString();
        }
    }

    public static final Companion Companion;
    private volatile List bounds;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    static {
        TypeParameterReference.Companion = new Companion(null);
    }

    public TypeParameterReference(Object arg2, String arg3, KVariance arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "container");
        Intrinsics.checkNotNullParameter(arg3, "name");
        Intrinsics.checkNotNullParameter(arg4, "variance");
        super(arg2);
        this.name = arg3;
        this.variance = arg4;
        this.isReified = arg5;
    }

    public String getName() {
        return this.name;
    }

    public List getUpperBounds() {
        List v0 = this.bounds;
        if(v0 == null) {
            v0 = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
            this.bounds = v0;
        }

        return v0;
    }

    public static void getUpperBounds$annotations() {
    }

    public KVariance getVariance() {
        return this.variance;
    }

    public boolean isReified() {
        return this.isReified;
    }

    public final void setUpperBounds(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "upperBounds");
        if(this.bounds == null) {
            this.bounds = arg3;
            return;
        }

        throw new IllegalStateException("Upper bounds of type parameter \'" + this + "\' have already been initialized.".toString());
    }
}

