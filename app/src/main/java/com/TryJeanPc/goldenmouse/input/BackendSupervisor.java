package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0007H\u0016J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH\u0016¨\u0006\rÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/input/BackendSupervisor;", "", "isAvailable", "", "openStream", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "command", "", "openPassiveDeviceStream", "devicePath", "openDeviceStream", "captureMode", "Lcom/TryJeanPc/goldenmouse/input/CaptureMode;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface BackendSupervisor {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static CaptureStream openDeviceStream(BackendSupervisor arg1, String arg2, CaptureMode arg3) {
            Intrinsics.checkNotNullParameter(arg2, "devicePath");
            Intrinsics.checkNotNullParameter(arg3, "captureMode");
            return arg1.openDeviceStream(arg2, arg3);
        }

        @Deprecated public static CaptureStream openPassiveDeviceStream(BackendSupervisor arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "devicePath");
            return arg1.openPassiveDeviceStream(arg2);
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CaptureMode.values().length];
            try {
                v0[CaptureMode.SHARED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CaptureMode.EXCLUSIVE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    static CaptureStream access$openDeviceStream$jd(BackendSupervisor arg0, String arg1, CaptureMode arg2) {
        return super.openDeviceStream(arg1, arg2);
    }

    static CaptureStream access$openPassiveDeviceStream$jd(BackendSupervisor arg0, String arg1) {
        return super.openPassiveDeviceStream(arg1);
    }

    boolean isAvailable();

    default CaptureStream openDeviceStream(String arg2, CaptureMode arg3) {
        Intrinsics.checkNotNullParameter(arg2, "devicePath");
        Intrinsics.checkNotNullParameter(arg3, "captureMode");
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v3 == 1) {
            arg2 = "getevent -l " + arg2;
        }
        else if(v3 == 2) {
            arg2 = ExclusiveEvdevCapture.INSTANCE.command(arg2);
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        return this.openStream(arg2);
    }

    default CaptureStream openPassiveDeviceStream(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "devicePath");
        return this.openDeviceStream(arg2, CaptureMode.SHARED);
    }

    CaptureStream openStream(String arg1);
}

