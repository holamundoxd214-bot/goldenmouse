package com.flyfishxu.kadb.cert.platform;

import android.os.Build;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u00020\u00012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0001¨\u0006\u0003"}, d2={"defaultDeviceName", "", "software", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DefaultDeviceName_androidKt {
    public static final String defaultDeviceName(String arg1) {
        if(arg1 != null) {
            arg1 = StringsKt.trim(((CharSequence)arg1)).toString();
            if(arg1 != null) {
                if(arg1.length() > 0) {
                }
                else {
                    arg1 = null;
                }

                if(arg1 == null) {
                    goto label_11;
                }

                return arg1;
            }
        }

    label_11:
        arg1 = System.getProperty("user.name");
        if(arg1 == null) {
            arg1 = System.getenv("USER");
        }

        String v0 = System.getenv("HOSTNAME");
        if(v0 == null) {
            v0 = Build.HOST;
            if(v0 == null) {
                v0 = Build.DEVICE;
            }
        }

        return DefaultDeviceNameKt.formatDefaultDeviceName(arg1, v0);
    }

    public static String defaultDeviceName$default(String arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return DefaultDeviceName_androidKt.defaultDeviceName(arg0);
    }
}

