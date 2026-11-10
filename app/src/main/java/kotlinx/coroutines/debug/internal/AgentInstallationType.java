package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Lkotlinx/coroutines/debug/internal/AgentInstallationType;", "", "<init>", "()V", "isInstalledStatically", "", "isInstalledStatically$kotlinx_coroutines_core", "()Z", "setInstalledStatically$kotlinx_coroutines_core", "(Z)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AgentInstallationType {
    public static final AgentInstallationType INSTANCE;
    private static boolean isInstalledStatically;

    static {
        AgentInstallationType.INSTANCE = new AgentInstallationType();
    }

    private AgentInstallationType() {
        super();
    }

    public final boolean isInstalledStatically$kotlinx_coroutines_core() {
        return AgentInstallationType.isInstalledStatically;
    }

    public final void setInstalledStatically$kotlinx_coroutines_core(boolean arg1) {
        AgentInstallationType.isInstalledStatically = arg1;
    }
}

