package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0014\u001A\u00020\u0015H\u0000\u001A\u0017\u0010\u0016\u001A\u00020\u00152\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0081\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t\"\u0014\u0010\n\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t\"\u001C\u0010\f\u001A\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\t\"\u0014\u0010\u0010\u001A\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2={"DEBUG_PROPERTY_NAME", "", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_ON", "DEBUG_PROPERTY_VALUE_OFF", "ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "DEBUG", "getDEBUG", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "()V", "getRECOVER_STACK_TRACES", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "resetCoroutineId", "", "assert", "value", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DebugKt {
    private static final boolean ASSERTIONS_ENABLED = false;
    private static final AtomicLong COROUTINE_ID = null;
    private static final boolean DEBUG = false;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    private static final boolean RECOVER_STACK_TRACES = false;
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    static {
        boolean v1_1;
        boolean v0 = false;
        DebugKt.ASSERTIONS_ENABLED = false;
        String v1 = SystemPropsKt.systemProp("kotlinx.coroutines.debug");
        if(v1 != null) {
            int v3 = v1.hashCode();
            if(v3 != 0) {
                if(v3 != 0xDDF) {
                    if(v3 != 0x1AD6F) {
                        if(v3 == 3005871 && (v1.equals("auto"))) {
                            goto label_43;
                        }
                    }
                    else if(v1.equals("off")) {
                        goto label_43;
                    }
                }
                else if(v1.equals("on")) {
                    goto label_30;
                }
            }
            else if(v1.equals("")) {
            label_30:
                v1_1 = true;
                goto label_44;
            }

            throw new IllegalStateException("System property \'kotlinx.coroutines.debug\' has unrecognized value \'" + v1 + '\''.toString());
        }
        else {
        label_43:
            v1_1 = false;
        }

    label_44:
        DebugKt.DEBUG = v1_1;
        if((v1_1) && (SystemPropsKt.systemProp("kotlinx.coroutines.stacktrace.recovery", true))) {
            v0 = true;
        }

        DebugKt.RECOVER_STACK_TRACES = v0;
        DebugKt.COROUTINE_ID = new AtomicLong(0);
    }

    private static final void assert(Function0 arg1) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg1.invoke().booleanValue()) {
            }
            else {
                throw new AssertionError();
            }
        }
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return DebugKt.ASSERTIONS_ENABLED;
    }

    public static final AtomicLong getCOROUTINE_ID() {
        return DebugKt.COROUTINE_ID;
    }

    public static final boolean getDEBUG() {
        return DebugKt.DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return DebugKt.RECOVER_STACK_TRACES;
    }

    public static void getRECOVER_STACK_TRACES$annotations() {
    }

    public static final void resetCoroutineId() {
        DebugKt.COROUTINE_ID.set(0);
    }
}

