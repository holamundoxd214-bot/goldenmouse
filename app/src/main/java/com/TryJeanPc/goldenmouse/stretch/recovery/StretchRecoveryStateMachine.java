package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStateMachine;", "", "<init>", "()V", "canTransition", "", "from", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "to", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryStateMachine {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[RecoveryPhase.values().length];
            try {
                v0[RecoveryPhase.IDLE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[RecoveryPhase.PREPARING.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[RecoveryPhase.BASELINE_CAPTURED.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[RecoveryPhase.RECOVERY_READY.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[RecoveryPhase.APPLYING.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[RecoveryPhase.VERIFYING.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[RecoveryPhase.AWAITING_CONFIRMATION.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[RecoveryPhase.CONFIRMED.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[RecoveryPhase.RESTORE_REQUESTED.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[RecoveryPhase.RESTORING.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[RecoveryPhase.VERIFYING_RESTORE.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[RecoveryPhase.RECOVERY_PENDING.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[RecoveryPhase.RECOVERED.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[RecoveryPhase.FAILED.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[RecoveryPhase.NOT_RECOVERABLE.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                    label_63:
                                                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable;
    public static final StretchRecoveryStateMachine INSTANCE;

    static {
        StretchRecoveryStateMachine.INSTANCE = new StretchRecoveryStateMachine();
    }

    private StretchRecoveryStateMachine() {
        super();
    }

    public final boolean canTransition(RecoveryPhase arg5, RecoveryPhase arg6) {
        Intrinsics.checkNotNullParameter(arg5, "from");
        Intrinsics.checkNotNullParameter(arg6, "to");
        if(arg5 == arg6) {
            return 1;
        }

        int v0 = 4;
        int v1 = 3;
        int v2 = 2;
        switch(WhenMappings.$EnumSwitchMapping$0[arg5.ordinal()]) {
            case 1: {
                goto label_127;
            }
            case 2: {
                goto label_118;
            }
            case 3: {
                goto label_107;
            }
            case 4: {
                goto label_96;
            }
            case 5: {
                goto label_87;
            }
            case 6: {
                goto label_76;
            }
            case 7: {
                goto label_67;
            }
            case 8: {
                goto label_60;
            }
            case 9: {
                goto label_51;
            }
            case 10: {
                goto label_44;
            }
            case 11: {
                goto label_37;
            }
            case 12: {
                goto label_30;
            }
            case 13: {
                goto label_27;
            }
            case 14: 
            case 15: {
                goto label_18;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_67:
        RecoveryPhase[] v5 = new RecoveryPhase[v1];
        v5[0] = RecoveryPhase.CONFIRMED;
        v5[1] = RecoveryPhase.RESTORE_REQUESTED;
        v5[v2] = RecoveryPhase.RECOVERY_PENDING;
        Set v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_37:
        v5 = new RecoveryPhase[v2];
        v5[0] = RecoveryPhase.RECOVERED;
        v5[1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_107:
        v5 = new RecoveryPhase[v0];
        v5[0] = RecoveryPhase.RECOVERY_READY;
        v5[1] = RecoveryPhase.NOT_RECOVERABLE;
        v5[v2] = RecoveryPhase.FAILED;
        v5[v1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_76:
        v5 = new RecoveryPhase[v0];
        v5[0] = RecoveryPhase.APPLYING;
        v5[1] = RecoveryPhase.AWAITING_CONFIRMATION;
        v5[v2] = RecoveryPhase.RESTORE_REQUESTED;
        v5[v1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_44:
        v5 = new RecoveryPhase[v2];
        v5[0] = RecoveryPhase.VERIFYING_RESTORE;
        v5[1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_18:
        v5 = new RecoveryPhase[v1];
        v5[0] = RecoveryPhase.PREPARING;
        v5[1] = RecoveryPhase.RESTORE_REQUESTED;
        v5[v2] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_51:
        v5 = new RecoveryPhase[v1];
        v5[0] = RecoveryPhase.RESTORING;
        v5[1] = RecoveryPhase.RECOVERED;
        v5[v2] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_118:
        v5 = new RecoveryPhase[v1];
        v5[0] = RecoveryPhase.BASELINE_CAPTURED;
        v5[1] = RecoveryPhase.FAILED;
        v5[v2] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_87:
        v5 = new RecoveryPhase[v1];
        v5[0] = RecoveryPhase.VERIFYING;
        v5[1] = RecoveryPhase.RESTORE_REQUESTED;
        v5[v2] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_27:
        v4 = SetsKt.setOf(RecoveryPhase.PREPARING);
        goto label_129;
    label_60:
        v5 = new RecoveryPhase[v2];
        v5[0] = RecoveryPhase.RESTORE_REQUESTED;
        v5[1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_30:
        v5 = new RecoveryPhase[v2];
        v5[0] = RecoveryPhase.RESTORE_REQUESTED;
        v5[1] = RecoveryPhase.VERIFYING_RESTORE;
        v4 = SetsKt.setOf(((Object[])v5));
        goto label_129;
    label_127:
        v4 = SetsKt.setOf(RecoveryPhase.PREPARING);
        goto label_129;
    label_96:
        v5 = new RecoveryPhase[v0];
        v5[0] = RecoveryPhase.APPLYING;
        v5[1] = RecoveryPhase.RESTORE_REQUESTED;
        v5[v2] = RecoveryPhase.FAILED;
        v5[v1] = RecoveryPhase.RECOVERY_PENDING;
        v4 = SetsKt.setOf(((Object[])v5));
    label_129:
        return v4.contains(arg6);
    }
}

