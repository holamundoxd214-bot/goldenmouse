package androidx.core.view.inputmethod;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;

public final class EditorInfoCompat {
    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static CharSequence getInitialSelectedText(EditorInfo arg0, int arg1) {
            return arg0.getInitialSelectedText(arg1);
        }

        static CharSequence getInitialTextAfterCursor(EditorInfo arg0, int arg1, int arg2) {
            return arg0.getInitialTextAfterCursor(arg1, arg2);
        }

        static CharSequence getInitialTextBeforeCursor(EditorInfo arg0, int arg1, int arg2) {
            return arg0.getInitialTextBeforeCursor(arg1, arg2);
        }

        static void setInitialSurroundingSubText(EditorInfo arg0, CharSequence arg1, int arg2) {
            arg0.setInitialSurroundingSubText(arg1, arg2);
        }
    }

    class Api35Impl {
        private Api35Impl() {
            super();
        }

        static boolean isStylusHandwritingEnabled(EditorInfo arg0) {
            return arg0.isStylusHandwritingEnabled();
        }

        static void setStylusHandwritingEnabled(EditorInfo arg0, boolean arg1) {
            arg0.setStylusHandwritingEnabled(arg1);
        }
    }

    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = null;
    public static final int IME_FLAG_FORCE_ASCII = 0x80000000;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 0x1000000;
    static final int MAX_INITIAL_SELECTION_LENGTH = 0x400;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 0x800;
    static final String STYLUS_HANDWRITING_ENABLED_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";

    static {
        EditorInfoCompat.EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated public EditorInfoCompat() {
        super();
    }

    public static String[] getContentMimeTypes(EditorInfo arg0) {
        String[] v0 = arg0.contentMimeTypes;
        if(v0 != null) {
            return v0;
        }

        return EditorInfoCompat.EMPTY_STRING_ARRAY;
    }

    public static CharSequence getInitialSelectedText(EditorInfo arg6, int arg7) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialSelectedText(arg6, arg7);
        }

        CharSequence v1 = null;
        if(arg6.extras == null) {
            return v1;
        }

        int v0 = Math.min(arg6.initialSelStart, arg6.initialSelEnd);
        int v2 = Math.max(arg6.initialSelStart, arg6.initialSelEnd);
        int v3 = arg6.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        int v4 = arg6.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        v2 -= v0;
        if(arg6.initialSelStart >= 0 && arg6.initialSelEnd >= 0) {
            if(v4 - v3 != v2) {
            }
            else {
                CharSequence v6 = arg6.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
                if(v6 == null) {
                    return v1;
                }
                else if((arg7 & 1) != 0) {
                    return v6.subSequence(v3, v4);
                }
                else {
                    return TextUtils.substring(v6, v3, v4);
                }
            }
        }

        return v1;
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo arg3, int arg4, int arg5) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextAfterCursor(arg3, arg4, arg5);
        }

        CharSequence v1 = null;
        if(arg3.extras == null) {
            return v1;
        }

        CharSequence v0 = arg3.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if(v0 == null) {
            return v1;
        }

        int v3 = arg3.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        arg4 = Math.min(arg4, v0.length() - v3);
        if((arg5 & 1) != 0) {
            return v0.subSequence(v3, arg4 + v3);
        }

        return TextUtils.substring(v0, v3, arg4 + v3);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo arg3, int arg4, int arg5) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getInitialTextBeforeCursor(arg3, arg4, arg5);
        }

        CharSequence v1 = null;
        if(arg3.extras == null) {
            return v1;
        }

        CharSequence v0 = arg3.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if(v0 == null) {
            return v1;
        }

        int v3 = arg3.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        arg4 = Math.min(arg4, v3);
        if((arg5 & 1) != 0) {
            return v0.subSequence(v3 - arg4, v3);
        }

        return TextUtils.substring(v0, v3 - arg4, v3);
    }

    static int getProtocol(EditorInfo arg0) {
        return 1;
    }

    private static boolean isCutOnSurrogate(CharSequence arg1, int arg2, int arg3) {
        if(arg3 != 0) {
            if(arg3 != 1) {
                return 0;
            }

            return Character.isHighSurrogate(arg1.charAt(arg2));
        }

        return Character.isLowSurrogate(arg1.charAt(arg2));
    }

    private static boolean isPasswordInputType(int arg1) {
        arg1 &= 0xFFF;
        if(arg1 != 0x81 && arg1 != 0xE1) {
            if(arg1 == 18) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static boolean isStylusHandwritingEnabled(EditorInfo arg2) {
        if(arg2.extras != null) {
            String v1 = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";
            if(arg2.extras.containsKey(v1)) {
                return arg2.extras.getBoolean(v1);
            }
        }

        if(Build$VERSION.SDK_INT >= 35) {
            return Api35Impl.isStylusHandwritingEnabled(arg2);
        }

        return 0;
    }

    public static void setContentMimeTypes(EditorInfo arg0, String[] arg1) {
        arg0.contentMimeTypes = arg1;
    }

    public static void setInitialSurroundingSubText(EditorInfo arg5, CharSequence arg6, int arg7) {
        Preconditions.checkNotNull(arg6);
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(arg5, arg6, arg7);
            return;
        }

        int v0 = arg5.initialSelStart > arg5.initialSelEnd ? arg5.initialSelEnd : arg5.initialSelStart;
        v0 -= arg7;
        int v1 = arg5.initialSelStart > arg5.initialSelEnd ? arg5.initialSelStart : arg5.initialSelEnd;
        v1 -= arg7;
        int v2 = arg6.length();
        CharSequence v3 = null;
        if(arg7 >= 0 && v0 >= 0) {
            if(v1 > v2) {
            }
            else if(EditorInfoCompat.isPasswordInputType(arg5.inputType)) {
                EditorInfoCompat.setSurroundingText(arg5, v3, 0, 0);
                return;
            }
            else if(v2 <= 0x800) {
                EditorInfoCompat.setSurroundingText(arg5, arg6, v0, v1);
                return;
            }
            else {
                EditorInfoCompat.trimLongSurroundingText(arg5, arg6, v0, v1);
                return;
            }
        }

        EditorInfoCompat.setSurroundingText(arg5, v3, 0, 0);
    }

    public static void setInitialSurroundingText(EditorInfo arg3, CharSequence arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setInitialSurroundingSubText(arg3, arg4, 0);
            return;
        }

        EditorInfoCompat.setInitialSurroundingSubText(arg3, arg4, 0);
    }

    public static void setStylusHandwritingEnabled(EditorInfo arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 35) {
            Api35Impl.setStylusHandwritingEnabled(arg2, arg3);
        }

        if(arg2.extras == null) {
            arg2.extras = new Bundle();
        }

        arg2.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", arg3);
    }

    private static void setSurroundingText(EditorInfo arg2, CharSequence arg3, int arg4, int arg5) {
        CharSequence v0_1;
        if(arg2.extras == null) {
            arg2.extras = new Bundle();
        }

        if(arg3 != null) {
            SpannableStringBuilder v0 = new SpannableStringBuilder(arg3);
        }
        else {
            v0_1 = null;
        }

        arg2.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", v0_1);
        arg2.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", arg4);
        arg2.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", arg5);
    }

    private static void trimLongSurroundingText(EditorInfo arg9, CharSequence arg10, int arg11, int arg12) {
        int v0 = arg12 - arg11;
        int v1 = v0 > 0x400 ? 0 : v0;
        int v4 = 0x800 - v1;
        int v3 = Math.min(arg10.length() - arg12, v4 - Math.min(arg11, ((int)((((double)v4)) * 0.8))));
        v4 = Math.min(arg11, v4 - v3);
        arg11 -= v4;
        if(EditorInfoCompat.isCutOnSurrogate(arg10, arg11, 0)) {
            ++arg11;
            --v4;
        }

        if(EditorInfoCompat.isCutOnSurrogate(arg10, arg12 + v3 - 1, 1)) {
            --v3;
        }

        int v5 = v4 + v1 + v3;
        arg10 = v1 != v0 ? TextUtils.concat(new CharSequence[]{arg10.subSequence(arg11, arg11 + v4), arg10.subSequence(arg12, v3 + arg12)}) : arg10.subSequence(arg11, v5 + arg11);
        EditorInfoCompat.setSurroundingText(arg9, arg10, v4, v1 + v4);
    }
}

