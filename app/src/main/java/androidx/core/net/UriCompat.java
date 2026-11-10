package androidx.core.net;

import android.net.Uri;

public final class UriCompat {
    private UriCompat() {
        super();
    }

    public static String toSafeString(Uri arg7) {
        StringBuilder v7;
        String v0 = arg7.getScheme();
        String v1 = arg7.getSchemeSpecificPart();
        char v2 = ':';
        int v3 = 0x40;
        if(v0 != null) {
            if(!v0.equalsIgnoreCase("tel") && !v0.equalsIgnoreCase("sip") && !v0.equalsIgnoreCase("sms") && !v0.equalsIgnoreCase("smsto") && !v0.equalsIgnoreCase("mailto")) {
                if(v0.equalsIgnoreCase("nfc")) {
                }
                else {
                    if(!v0.equalsIgnoreCase("http") && !v0.equalsIgnoreCase("https") && !v0.equalsIgnoreCase("ftp") && !v0.equalsIgnoreCase("rtsp")) {
                        goto label_83;
                    }

                    StringBuilder v1_1 = new StringBuilder("//");
                    String v5 = "";
                    String v4 = arg7.getHost() != null ? arg7.getHost() : v5;
                    v1_1 = v1_1.append(v4);
                    if(arg7.getPort() != -1) {
                        v5 = ":" + arg7.getPort();
                    }

                    v1 = v1_1.append(v5).append("/...").toString();
                    goto label_83;
                }
            }

            v7 = new StringBuilder(v3);
            v7.append(v0);
            v7.append(v2);
            if(v1 != null) {
                int v0_1;
                for(v0_1 = 0; v0_1 < v1.length(); ++v0_1) {
                    v2 = v1.charAt(v0_1);
                    if(v2 == 45 || v2 == v3 || v2 == 46) {
                        v7.append(v2);
                    }
                    else {
                        v7.append('x');
                    }
                }
            }

            return v7.toString();
        }

    label_83:
        v7 = new StringBuilder(v3);
        if(v0 != null) {
            v7.append(v0);
            v7.append(v2);
        }

        if(v1 != null) {
            v7.append(v1);
        }

        return v7.toString();
    }
}

