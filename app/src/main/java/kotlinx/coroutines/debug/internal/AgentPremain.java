package kotlinx.coroutines.debug.internal;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sun.misc.Signal;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\b\u0010\f\u001A\u00020\u0007H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/debug/internal/AgentPremain;", "", "<init>", "()V", "enableCreationStackTraces", "", "premain", "", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "installSignalHandler", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AgentPremain {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/debug/internal/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "<init>", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugProbesTransformer implements ClassFileTransformer {
        public static final DebugProbesTransformer INSTANCE;

        static {
            DebugProbesTransformer.INSTANCE = new DebugProbesTransformer();
        }

        private DebugProbesTransformer() {
            super();
        }

        public byte[] transform(ClassLoader arg1, String arg2, Class arg3, ProtectionDomain arg4, byte[] arg5) {
            if(arg1 != null) {
                if(!Intrinsics.areEqual(arg2, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                }
                else {
                    AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
                    return ByteStreamsKt.readBytes(arg1.getResourceAsStream("DebugProbesKt.bin"));
                }
            }

            return null;
        }
    }

    public static final AgentPremain INSTANCE;
    private static final boolean enableCreationStackTraces;

    static {
        Object v1_3;
        AgentPremain.INSTANCE = new AgentPremain();
        Object v0 = null;
        try {
            String v1_1 = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            if(v1_1 != null) {
                Boolean v1_2 = Boolean.valueOf(Boolean.parseBoolean(v1_1));
            }
            else {
                v1_3 = v0;
            }

            v1_3 = Result.constructor-impl(v1_3);
        }
        catch(Throwable v1) {
            v1_3 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        if(Result.isFailure-impl(v1_3)) {
        }
        else {
            v0 = v1_3;
        }

        boolean v0_1 = v0 != null ? ((Boolean)v0).booleanValue() : DebugProbesImpl.INSTANCE.getEnableCreationStackTraces$kotlinx_coroutines_core();
        AgentPremain.enableCreationStackTraces = v0_1;
    }

    private AgentPremain() {
        super();
    }

    private final void installSignalHandler() {
        try {
            Signal.handle(new Signal("TRAP"), new AgentPremain$$ExternalSyntheticLambda0());
            return;
        }
        catch(Throwable ) {
            return;
        }
    }

    static final void installSignalHandler$lambda$1(Signal arg1) {
        if(DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_debug()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
            return;
        }

        System.out.println("Cannot perform coroutines dump, debug probes are disabled");
    }

    @JvmStatic public static final void premain(String arg1, Instrumentation arg2) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        arg2.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces$kotlinx_coroutines_core(AgentPremain.enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install$kotlinx_coroutines_core();
        AgentPremain.INSTANCE.installSignalHandler();
    }
}

