package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.DelayedAckMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004"}, d2={"shouldAdvertiseDelayedAck", "", "mode", "Lcom/flyfishxu/kadb/DelayedAckMode;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class HostFeaturePolicyKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[DelayedAckMode.values().length];
            try {
                v0[DelayedAckMode.AOSP_DEFAULT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[DelayedAckMode.ENABLED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[DelayedAckMode.DISABLED.ordinal()] = 3;
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

    public static final boolean shouldAdvertiseDelayedAck(DelayedAckMode arg2) {
        Intrinsics.checkNotNullParameter(arg2, "mode");
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 == 3) {
                    return 0;
                }

                throw new NoWhenBranchMatchedException();
            }

            return 1;
        }

        return HostFeaturePolicy_androidKt.aospDefaultDelayedAckEnabled();
    }
}

