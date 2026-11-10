package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001A$\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001A,\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001A.\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004¨\u0006\t"}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "mode", "Lkotlin/LazyThreadSafetyMode;", "lock", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/LazyKt") class LazyKt__LazyJVMKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LazyThreadSafetyMode.values().length];
            try {
                v0[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[LazyThreadSafetyMode.NONE.ordinal()] = 3;
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

    public LazyKt__LazyJVMKt() {
        super();
    }

    public static final Lazy lazy(Object arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializer");
        return new SynchronizedLazyImpl(arg2, arg1);
    }

    public static final Lazy lazy(LazyThreadSafetyMode arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "mode");
        Intrinsics.checkNotNullParameter(arg3, "initializer");
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        int v1 = 2;
        if(v2 != 1) {
            if(v2 != v1) {
                if(v2 == 3) {
                    return new UnsafeLazyImpl(arg3);
                }

                throw new NoWhenBranchMatchedException();
            }

            return new SafePublicationLazyImpl(arg3);
        }

        return new SynchronizedLazyImpl(arg3, null, v1, null);
    }

    public static final Lazy lazy(Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "initializer");
        return new SynchronizedLazyImpl(arg3, null, 2, null);
    }
}

