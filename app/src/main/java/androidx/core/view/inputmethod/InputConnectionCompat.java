package androidx.core.view.inputmethod;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;

public final class InputConnectionCompat {
    class Api25Impl {
        private Api25Impl() {
            super();
        }

        static boolean commitContent(InputConnection arg0, InputContentInfo arg1, int arg2, Bundle arg3) {
            return arg0.commitContent(arg1, arg2, arg3);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat arg1, int arg2, Bundle arg3);
    }

    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    @Deprecated public InputConnectionCompat() {
        super();
    }

    public static boolean commitContent(InputConnection arg0, EditorInfo arg1, InputContentInfoCompat arg2, int arg3, Bundle arg4) {
        return Api25Impl.commitContent(arg0, arg2.unwrap(), arg3, arg4);
    }

    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(View arg1) {
        Preconditions.checkNotNull(arg1);
        return new InputConnectionCompat$$ExternalSyntheticLambda0(arg1);
    }

    public static InputConnection createWrapper(View arg0, InputConnection arg1, EditorInfo arg2) {
        return InputConnectionCompat.createWrapper(arg1, arg2, InputConnectionCompat.createOnCommitContentListenerUsingPerformReceiveContent(arg0));
    }

    @Deprecated public static InputConnection createWrapper(InputConnection arg1, EditorInfo arg2, OnCommitContentListener arg3) {
        ObjectsCompat.requireNonNull(arg1, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(arg2, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(arg3, "onCommitContentListener must be non-null");
        return new InputConnectionWrapper(arg1, false, arg3) {
            public boolean commitContent(InputContentInfo arg3, int arg4, Bundle arg5) {
                if(this.val$listener.onCommitContent(InputContentInfoCompat.wrap(arg3), arg4, arg5)) {
                    return 1;
                }

                return super.commitContent(arg3, arg4, arg5);
            }
        };
    }

    static boolean handlePerformPrivateCommand(String arg7, Bundle arg8, OnCommitContentListener arg9) {
        boolean v0_1;
        Parcelable v2_1;
        int v7;
        int v0 = 0;
        if(arg8 == null) {
            return 0;
        }

        if(TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", ((CharSequence)arg7))) {
            v7 = 0;
        }
        else if(TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", ((CharSequence)arg7))) {
            v7 = 1;
        }
        else {
            return 0;
        }

        Bundle v1 = null;
        if(v7 != 0) {
            try {
                String v2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
                goto label_17;
            label_16:
                v2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
            label_17:
                v2_1 = arg8.getParcelable(v2);
                if(v7 == 0) {
                    goto label_21;
                }

                goto label_19;
            }
            catch(Throwable v7_1) {
                v2_1 = ((Parcelable)v1);
                goto label_55;
            }
        }
        else {
            goto label_16;
        }

        goto label_17;
        try {
        label_19:
            String v3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            goto label_22;
        label_21:
            v3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        label_22:
            Parcelable v3_1 = arg8.getParcelable(v3);
            String v4 = v7 != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            Parcelable v4_1 = arg8.getParcelable(v4);
            String v5 = v7 != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            Parcelable v5_1 = arg8.getParcelable(v5);
            String v6 = v7 != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            int v6_1 = arg8.getInt(v6);
            arg7 = v7 != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            Parcelable v7_2 = arg8.getParcelable(arg7);
            if(v3_1 != null && v4_1 != null) {
                v0_1 = arg9.onCommitContent(new InputContentInfoCompat(((Uri)v3_1), ((ClipDescription)v4_1), ((Uri)v5_1)), v6_1, ((Bundle)v7_2));
            }

            goto label_48;
        }
        catch(Throwable v7_1) {
        }

    label_55:
        if(v2_1 != null) {
            ((ResultReceiver)v2_1).send(((int)v0_1), v1);
        }

        throw v7_1;
    label_48:
        if(v2_1 != null) {
            ((ResultReceiver)v2_1).send(((int)v0_1), v1);
        }

        return v0_1;
    }

    static boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View arg5, InputContentInfoCompat arg6, int arg7, Bundle arg8) {
        if((arg7 & 1) != 0) {
            try {
                arg6.requestPermission();
            }
            catch(Exception v5) {
                Log.w("InputConnectionCompat", "Can\'t insert content from IME; requestPermission() failed", ((Throwable)v5));
                return 0;
            }

            Object v7 = arg6.unwrap();
            arg8 = arg8 == null ? new Bundle() : new Bundle(arg8);
            arg8.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", ((Parcelable)v7));
        }

        if(ViewCompat.performReceiveContent(arg5, new Builder(new ClipData(arg6.getDescription(), new ClipData$Item(arg6.getContentUri())), 2).setLinkUri(arg6.getLinkUri()).setExtras(arg8).build()) == null) {
            return 1;
        }

        return 0;
    }
}

