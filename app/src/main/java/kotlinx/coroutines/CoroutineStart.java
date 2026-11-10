package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2\'\u0010\f\u001A#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\r¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001A\u0002H\n2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0087\u0002¢\u0006\u0002\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0014\u0010\u0018j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0019"}, d2={"Lkotlinx/coroutines/CoroutineStart;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "invoke", "", "R", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum CoroutineStart {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CoroutineStart.values().length];
            try {
                v0[CoroutineStart.DEFAULT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CoroutineStart.ATOMIC.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[CoroutineStart.LAZY.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final enum CoroutineStart ATOMIC;
    public static final enum CoroutineStart DEFAULT;
    public static final enum CoroutineStart LAZY;
    public static final enum CoroutineStart UNDISPATCHED;

    private static final CoroutineStart[] $values() {
        return new CoroutineStart[]{CoroutineStart.DEFAULT, CoroutineStart.LAZY, CoroutineStart.ATOMIC, CoroutineStart.UNDISPATCHED};
    }

    static {
        CoroutineStart.DEFAULT = new CoroutineStart("DEFAULT", 0);
        CoroutineStart.LAZY = new CoroutineStart("LAZY", 1);
        CoroutineStart.ATOMIC = new CoroutineStart("ATOMIC", 2);
        CoroutineStart.UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);
        CoroutineStart[] v0 = CoroutineStart.$values();
        CoroutineStart.$VALUES = v0;
        CoroutineStart.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CoroutineStart(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CoroutineStart.$ENTRIES;
    }

    public final void invoke(Function2 arg2, Object arg3, Continuation arg4) {
        int v1 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v1 != 1) {
            if(v1 != 2) {
                if(v1 != 3) {
                    if(v1 == 4) {
                        return;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                UndispatchedKt.startCoroutineUndispatched(arg2, arg3, arg4);
                return;
            }

            ContinuationKt.startCoroutine(arg2, arg3, arg4);
            return;
        }

        CancellableKt.startCoroutineCancellable(arg2, arg3, arg4);
    }

    public final boolean isLazy() {
        if(this == CoroutineStart.LAZY) {
            return 1;
        }

        return 0;
    }

    public static void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String arg1) {
        return Enum.valueOf(CoroutineStart.class, arg1);
    }

    public static CoroutineStart[] values() {
        return CoroutineStart.$VALUES.clone();
    }
}

