package com.flyfishxu.kadb.cert.platform;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u001C\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, d2={"formatDefaultDeviceName", "", "loginName", "hostName", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DefaultDeviceNameKt {
    public static final String formatDefaultDeviceName(String arg1, String arg2) {
        return DefaultDeviceNameKt.formatDefaultDeviceName$normalize(arg1) + "@" + DefaultDeviceNameKt.formatDefaultDeviceName$normalize(arg2);
    }

    private static final String formatDefaultDeviceName$normalize(String arg1) {
        if(arg1 != null) {
            arg1 = StringsKt.trim(((CharSequence)arg1)).toString();
            if(arg1 != null) {
                if(arg1.length() > 0) {
                }
                else {
                    arg1 = null;
                }

                if(arg1 == null) {
                    return "unknown";
                }

                return arg1;
            }
        }

        return "unknown";
    }
}

