package androidx.core.text.util;

import android.os.Build$VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify$MatchFilter;
import android.text.util.Linkify$TransformFilter;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void addLinks(TextView arg0, Pattern arg1, String arg2, String[] arg3, Linkify$MatchFilter arg4, Linkify$TransformFilter arg5) {
            Linkify.addLinks(arg0, arg1, arg2, arg3, arg4, arg5);
        }

        static boolean addLinks(Spannable arg0, Pattern arg1, String arg2, String[] arg3, Linkify$MatchFilter arg4, Linkify$TransformFilter arg5) {
            return Linkify.addLinks(arg0, arg1, arg2, arg3, arg4, arg5);
        }
    }

    class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface LinkifyMask {
    }

    private static final Comparator COMPARATOR;
    private static final String[] EMPTY_STRING;

    static {
        LinkifyCompat.EMPTY_STRING = new String[0];
        LinkifyCompat.COMPARATOR = new LinkifyCompat$$ExternalSyntheticLambda0();
    }

    private LinkifyCompat() {
        super();
    }

    private static void addLinkMovementMethod(TextView arg1) {
        if(!(arg1.getMovementMethod() instanceof LinkMovementMethod) && (arg1.getLinksClickable())) {
            arg1.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void addLinks(TextView arg7, Pattern arg8, String arg9) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(arg7, arg8, arg9);
            return;
        }

        LinkifyCompat.addLinks(arg7, arg8, arg9, null, null, null);
    }

    public static void addLinks(TextView arg6, Pattern arg7, String arg8, String[] arg9, Linkify$MatchFilter arg10, Linkify$TransformFilter arg11) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Api24Impl.addLinks(arg6, arg7, arg8, arg9, arg10, arg11);
            return;
        }

        SpannableString v0 = SpannableString.valueOf(arg6.getText());
        if(LinkifyCompat.addLinks(((Spannable)v0), arg7, arg8, arg9, arg10, arg11)) {
            arg6.setText(((CharSequence)v0));
            LinkifyCompat.addLinkMovementMethod(arg6);
        }
    }

    public static void addLinks(TextView arg7, Pattern arg8, String arg9, Linkify$MatchFilter arg10, Linkify$TransformFilter arg11) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(arg7, arg8, arg9, arg10, arg11);
            return;
        }

        LinkifyCompat.addLinks(arg7, arg8, arg9, null, arg10, arg11);
    }

    public static boolean addLinks(Spannable arg6, Pattern arg7, String arg8, String[] arg9, Linkify$MatchFilter arg10, Linkify$TransformFilter arg11) {
        String v4;
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Api24Impl.addLinks(arg6, arg7, arg8, arg9, arg10, arg11);
        }

        String v0 = "";
        if(arg8 == null) {
            arg8 = v0;
        }

        if(arg9 == null || arg9.length < 1) {
            arg9 = LinkifyCompat.EMPTY_STRING;
        }

        String[] v2 = new String[arg9.length + 1];
        v2[0] = arg8.toLowerCase(Locale.ROOT);
        int v8 = 0;
        while(v8 < arg9.length) {
            v4 = arg9[v8];
            ++v8;
            v4 = v4 == null ? v0 : v4.toLowerCase(Locale.ROOT);
            v2[v8] = v4;
        }

        Matcher v7 = arg7.matcher(((CharSequence)arg6));
        boolean v8_1;
        for(v8_1 = false; v7.find(); v8_1 = true) {
            int v9 = v7.start();
            int v0_1 = v7.end();
            v4 = v7.group(0);
            boolean v5 = arg10 != null ? arg10.acceptMatch(((CharSequence)arg6), v9, v0_1) : true;
            if(!v5) {
                continue;
            }

            if(v4 == null) {
                continue;
            }

            LinkifyCompat.applyLink(LinkifyCompat.makeUrl(v4, v2, v7, arg11), v9, v0_1, arg6);
        }

        return v8_1;
    }

    public static boolean addLinks(Spannable arg10, int arg11) {
        Spannable v5;
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(arg10, arg11);
        }

        if(arg11 == 0) {
            return 0;
        }

        Object[] v1 = arg10.getSpans(0, arg10.length(), URLSpan.class);
        int v2;
        for(v2 = v1.length - 1; v2 >= 0; --v2) {
            arg10.removeSpan(v1[v2]);
        }

        if((arg11 & 4) != 0) {
            Linkify.addLinks(arg10, 4);
        }

        ArrayList v4 = new ArrayList();
        if((arg11 & 1) != 0) {
            v5 = arg10;
            LinkifyCompat.gatherLinks(v4, v5, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        else {
            v5 = arg10;
        }

        if((arg11 & 2) != 0) {
            LinkifyCompat.gatherLinks(v4, v5, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }

        if((arg11 & 8) != 0) {
            LinkifyCompat.gatherMapLinks(v4, v5);
        }

        LinkifyCompat.pruneOverlaps(v4, v5);
        if(v4.size() == 0) {
            return 0;
        }

        Iterator v10 = v4.iterator();
        while(v10.hasNext()) {
            Object v11 = v10.next();
            if(((LinkSpec)v11).frameworkAddedSpan != null) {
                continue;
            }

            LinkifyCompat.applyLink(((LinkSpec)v11).url, ((LinkSpec)v11).start, ((LinkSpec)v11).end, v5);
        }

        return 1;
    }

    public static boolean addLinks(Spannable arg6, Pattern arg7, String arg8) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(arg6, arg7, arg8);
        }

        return LinkifyCompat.addLinks(arg6, arg7, arg8, null, null, null);
    }

    public static boolean addLinks(Spannable arg6, Pattern arg7, String arg8, Linkify$MatchFilter arg9, Linkify$TransformFilter arg10) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(arg6, arg7, arg8, arg9, arg10);
        }

        return LinkifyCompat.addLinks(arg6, arg7, arg8, null, arg9, arg10);
    }

    public static boolean addLinks(TextView arg4, int arg5) {
        if(LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(arg4, arg5);
        }

        if(arg5 == 0) {
            return 0;
        }

        CharSequence v1 = arg4.getText();
        if(!(v1 instanceof Spannable)) {
            SpannableString v1_1 = SpannableString.valueOf(v1);
            if(LinkifyCompat.addLinks(((Spannable)v1_1), arg5)) {
                LinkifyCompat.addLinkMovementMethod(arg4);
                arg4.setText(((CharSequence)v1_1));
                return 1;
            }
        }
        else if(LinkifyCompat.addLinks(((Spannable)v1), arg5)) {
            LinkifyCompat.addLinkMovementMethod(arg4);
            return 1;
        }

        return 0;
    }

    private static void applyLink(String arg1, int arg2, int arg3, Spannable arg4) {
        arg4.setSpan(new URLSpan(arg1), arg2, arg3, 33);
    }

    private static String findAddress(String arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return WebView.findAddress(arg2);
        }

        return FindAddress.findAddress(arg2);
    }

    private static void gatherLinks(ArrayList arg4, Spannable arg5, Pattern arg6, String[] arg7, Linkify$MatchFilter arg8, Linkify$TransformFilter arg9) {
        Matcher v6 = arg6.matcher(((CharSequence)arg5));
        while(v6.find()) {
            int v0 = v6.start();
            int v1 = v6.end();
            String v2 = v6.group(0);
            if(arg8 != null && !arg8.acceptMatch(((CharSequence)arg5), v0, v1)) {
                continue;
            }

            if(v2 == null) {
                continue;
            }

            LinkSpec v3 = new LinkSpec();
            v3.url = LinkifyCompat.makeUrl(v2, arg7, v6, arg9);
            v3.start = v0;
            v3.end = v1;
            arg4.add(v3);
        }
    }

    private static void gatherMapLinks(ArrayList arg5, Spannable arg6) {
        String v6 = arg6.toString();
        int v0 = 0;
        try {
            while(true) {
                String v1 = LinkifyCompat.findAddress(v6);
                if(v1 != null) {
                    int v2 = v6.indexOf(v1);
                    if(v2 < 0) {
                    }
                    else {
                        LinkSpec v3 = new LinkSpec();
                        int v4 = v1.length() + v2;
                        v3.start = v2 + v0;
                        v0 += v4;
                        v3.end = v0;
                        v6 = v6.substring(v4);
                        try {
                            v1 = URLEncoder.encode(v1, "UTF-8");
                        }
                        catch(UnsupportedEncodingException ) {
                            continue;
                        }

                        v3.url = "geo:0,0?q=" + v1;
                        arg5.add(v3);
                        continue;
                    }
                }

                return;
            }
        }
        catch(UnsupportedOperationException ) {
            return;
        }
    }

    static int lambda$static$0(LinkSpec arg2, LinkSpec arg3) {
        if(arg2.start < arg3.start) {
            return -1;
        }

        if(arg2.start > arg3.start) {
            return 1;
        }

        return Integer.compare(arg3.end, arg2.end);
    }

    private static String makeUrl(String arg6, String[] arg7, Matcher arg8, Linkify$TransformFilter arg9) {
        if(arg9 != null) {
            arg6 = arg9.transformUrl(arg8, arg6);
        }

        String v0 = arg6;
        int v6 = arg7.length;
        int v9 = 0;
        while(true) {
            if(v9 < v6) {
                String v3 = arg7[v9];
                if(v0.regionMatches(true, 0, v3, 0, v3.length())) {
                    v9 = 1;
                    if(!v0.regionMatches(false, 0, v3, 0, v3.length())) {
                        v0 = v3 + v0.substring(v3.length());
                    }
                }
                else {
                    ++v9;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_32;
        }

        v9 = 0;
    label_32:
        if(v9 == 0 && arg7.length > 0) {
            return arg7[0] + v0;
        }

        return v0;
    }

    private static void pruneOverlaps(ArrayList arg9, Spannable arg10) {
        Object v4;
        int v2 = 0;
        Object[] v0 = arg10.getSpans(0, arg10.length(), URLSpan.class);
        int v1 = v0.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v4 = v0[v3];
            LinkSpec v5 = new LinkSpec();
            v5.frameworkAddedSpan = ((URLSpan)v4);
            v5.start = arg10.getSpanStart(v4);
            v5.end = arg10.getSpanEnd(v4);
            arg9.add(v5);
        }

        Collections.sort(((List)arg9), LinkifyCompat.COMPARATOR);
        int v0_1 = arg9.size();
        while(v2 < v0_1 - 1) {
            Object v1_1 = arg9.get(v2);
            v3 = v2 + 1;
            v4 = arg9.get(v3);
            if(((LinkSpec)v1_1).start <= ((LinkSpec)v4).start && ((LinkSpec)v1_1).end > ((LinkSpec)v4).start) {
                int v7 = -1;
                if(((LinkSpec)v4).end <= ((LinkSpec)v1_1).end || ((LinkSpec)v1_1).end - ((LinkSpec)v1_1).start > ((LinkSpec)v4).end - ((LinkSpec)v4).start) {
                    v1 = v3;
                    goto label_56;
                label_46:
                    v1 = ((LinkSpec)v1_1).end - ((LinkSpec)v1_1).start < ((LinkSpec)v4).end - ((LinkSpec)v4).start ? v2 : v7;
                }
                else {
                    goto label_46;
                }

            label_56:
                if(v1 == v7) {
                    goto label_64;
                }

                URLSpan v3_1 = arg9.get(v1).frameworkAddedSpan;
                if(v3_1 != null) {
                    arg10.removeSpan(v3_1);
                }

                arg9.remove(v1);
                --v0_1;
                continue;
            }

        label_64:
            v2 = v3;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if(Build$VERSION.SDK_INT >= 28) {
            return 1;
        }

        return 0;
    }
}

