package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¨\u0006\u0004"}, d2={"shouldApplySecureFlag", "", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SecureFlagPolicy_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SecureFlagPolicy.values().length];
            try {
                v0[SecureFlagPolicy.SecureOff.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SecureFlagPolicy.SecureOn.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[SecureFlagPolicy.Inherit.ordinal()] = 3;
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

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy arg2, boolean arg3) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 == 3) {
                    return arg3;
                }

                throw new NoWhenBranchMatchedException();
            }

            return 1;
        }

        return 0;
    }
}

