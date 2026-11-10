package androidx.core.net;

import android.net.Uri;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Map;

public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap mHeaders;

    private MailTo() {
        super();
        this.mHeaders = new HashMap();
    }

    public String getBcc() {
        return this.mHeaders.get("bcc");
    }

    public String getBody() {
        return this.mHeaders.get("body");
    }

    public String getCc() {
        return this.mHeaders.get("cc");
    }

    public Map getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return this.mHeaders.get("subject");
    }

    public String getTo() {
        return this.mHeaders.get("to");
    }

    public static boolean isMailTo(Uri arg1) {
        if(arg1 != null && ("mailto".equals(arg1.getScheme()))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMailTo(String arg1) {
        if(arg1 != null && (arg1.startsWith("mailto:"))) {
            return 1;
        }

        return 0;
    }

    public static MailTo parse(Uri arg0) throws ParseException {
        return MailTo.parse(arg0.toString());
    }

    public static MailTo parse(String arg10) throws ParseException {
        String v7_1;
        String v1_1;
        Preconditions.checkNotNull(arg10);
        if(MailTo.isMailTo(arg10)) {
            int v0 = arg10.indexOf(35);
            int v1 = -1;
            if(v0 != v1) {
                arg10 = arg10.substring(0, v0);
            }

            v0 = arg10.indexOf(0x3F);
            String v3 = null;
            String v4 = "mailto:";
            if(v0 == v1) {
                v1_1 = Uri.decode(arg10.substring(v4.length()));
                arg10 = v3;
            }
            else {
                v1_1 = Uri.decode(arg10.substring(v4.length(), v0));
                arg10 = arg10.substring(v0 + 1);
            }

            MailTo v0_1 = new MailTo();
            if(arg10 != null) {
                String[] v10 = arg10.split("&");
                int v4_1 = v10.length;
                int v6;
                for(v6 = 0; v6 < v4_1; ++v6) {
                    String[] v7 = v10[v6].split("=", 2);
                    if(v7.length == 0) {
                    }
                    else {
                        String v8 = Uri.decode(v7[0]).toLowerCase(Locale.ROOT);
                        if(v7.length > 1) {
                            v7_1 = Uri.decode(v7[1]);
                        }
                        else {
                            Object v7_2 = v3;
                        }

                        v0_1.mHeaders.put(v8, v7_1);
                    }
                }
            }

            arg10 = v0_1.getTo();
            if(arg10 != null) {
                v1_1 = v1_1 + ", " + arg10;
            }

            v0_1.mHeaders.put("to", v1_1);
            return v0_1;
        }

        throw new ParseException("Not a mailto scheme");
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("mailto:?");
        Iterator v3 = this.mHeaders.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            v0.append(Uri.encode(((Map$Entry)v1).getKey()));
            v0.append('=');
            v0.append(Uri.encode(((Map$Entry)v1).getValue()));
            v0.append('&');
        }

        return v0.toString();
    }
}

