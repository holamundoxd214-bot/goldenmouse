package androidx.core.content;

import java.util.ArrayList;

public final class MimeTypeFilter {
    private MimeTypeFilter() {
        super();
    }

    public static String matches(String arg6, String[] arg7) {
        String v0 = null;
        if(arg6 == null) {
            return v0;
        }

        String v1 = "/";
        String[] v6 = arg6.split(v1);
        int v2 = arg7.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            String v4 = arg7[v3];
            if(MimeTypeFilter.mimeTypeAgainstFilter(v6, v4.split(v1))) {
                return v4;
            }
        }

        return v0;
    }

    public static String matches(String[] arg6, String arg7) {
        String v0 = null;
        if(arg6 == null) {
            return v0;
        }

        String v1 = "/";
        String[] v7 = arg7.split(v1);
        int v2 = arg6.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            String v4 = arg6[v3];
            if(MimeTypeFilter.mimeTypeAgainstFilter(v4.split(v1), v7)) {
                return v4;
            }
        }

        return v0;
    }

    public static boolean matches(String arg1, String arg2) {
        if(arg1 == null) {
            return 0;
        }

        return MimeTypeFilter.mimeTypeAgainstFilter(arg1.split("/"), arg2.split("/"));
    }

    public static String[] matchesMany(String[] arg6, String arg7) {
        int v0 = 0;
        if(arg6 == null) {
            return new String[0];
        }

        ArrayList v1 = new ArrayList();
        String v2 = "/";
        String[] v7 = arg7.split(v2);
        int v3 = arg6.length;
        while(v0 < v3) {
            String v4 = arg6[v0];
            if(MimeTypeFilter.mimeTypeAgainstFilter(v4.split(v2), v7)) {
                v1.add(v4);
            }

            ++v0;
        }

        return v1.toArray(new String[v1.size()]);
    }

    private static boolean mimeTypeAgainstFilter(String[] arg5, String[] arg6) {
        int v1 = 2;
        if(arg6.length == v1) {
            if(!arg6[0].isEmpty() && !arg6[1].isEmpty()) {
                if(arg5.length != v1) {
                    return 0;
                }
                else {
                    String v3 = "*";
                    if(!v3.equals(arg6[0]) && !arg6[0].equals(arg5[0])) {
                        return 0;
                    }

                    if(!v3.equals(arg6[1]) && !arg6[1].equals(arg5[1])) {
                        return 0;
                    }

                    return 1;
                }
            }

            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }

        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }
}

