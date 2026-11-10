package androidx.core.text;

import android.text.Html$ImageGetter;
import android.text.Html$TagHandler;
import android.text.Html;
import android.text.Spanned;

public final class HtmlCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static Spanned fromHtml(String arg0, int arg1) {
            return Html.fromHtml(arg0, arg1);
        }

        static Spanned fromHtml(String arg0, int arg1, Html$ImageGetter arg2, Html$TagHandler arg3) {
            return Html.fromHtml(arg0, arg1, arg2, arg3);
        }

        static String toHtml(Spanned arg0, int arg1) {
            return Html.toHtml(arg0, arg1);
        }
    }

    public static final int FROM_HTML_MODE_COMPACT = 0x3F;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 0x100;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 0x20;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    private HtmlCompat() {
        super();
    }

    public static Spanned fromHtml(String arg0, int arg1, Html$ImageGetter arg2, Html$TagHandler arg3) {
        return Api24Impl.fromHtml(arg0, arg1, arg2, arg3);
    }

    public static Spanned fromHtml(String arg0, int arg1) {
        return Api24Impl.fromHtml(arg0, arg1);
    }

    public static String toHtml(Spanned arg0, int arg1) {
        return Api24Impl.toHtml(arg0, arg1);
    }
}

