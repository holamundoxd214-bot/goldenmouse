package androidx.compose.foundation;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/foundation/BasicTooltipDefaults;", "", "<init>", "()V", "GlobalMutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "getGlobalMutatorMutex", "()Landroidx/compose/foundation/MutatorMutex;", "TooltipDuration", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BasicTooltipDefaults {
    public static final int $stable = 0;
    private static final MutatorMutex GlobalMutatorMutex = null;
    public static final BasicTooltipDefaults INSTANCE = null;
    public static final long TooltipDuration = 1500;

    static {
        BasicTooltipDefaults.INSTANCE = new BasicTooltipDefaults();
        BasicTooltipDefaults.GlobalMutatorMutex = new MutatorMutex();
    }

    private BasicTooltipDefaults() {
        super();
    }

    public final MutatorMutex getGlobalMutatorMutex() {
        return BasicTooltipDefaults.GlobalMutatorMutex;
    }
}

