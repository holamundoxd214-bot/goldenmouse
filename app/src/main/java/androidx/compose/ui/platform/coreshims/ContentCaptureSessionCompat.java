package androidx.compose.ui.platform.coreshims;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper;
import java.util.List;
import java.util.Objects;

public class ContentCaptureSessionCompat implements ContentCaptureSessionWrapper {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static Bundle getExtras(ViewStructure arg0) {
            return arg0.getExtras();
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static AutofillId newAutofillId(ContentCaptureSession arg0, AutofillId arg1, long arg2) {
            return arg0.newAutofillId(arg1, arg2);
        }

        static ViewStructure newViewStructure(ContentCaptureSession arg0, View arg1) {
            return arg0.newViewStructure(arg1);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession arg0, AutofillId arg1, long arg2) {
            return arg0.newVirtualViewStructure(arg1, arg2);
        }

        static void notifyViewAppeared(ContentCaptureSession arg0, ViewStructure arg1) {
            arg0.notifyViewAppeared(arg1);
        }

        static void notifyViewDisappeared(ContentCaptureSession arg0, AutofillId arg1) {
            arg0.notifyViewDisappeared(arg1);
        }

        public static void notifyViewTextChanged(ContentCaptureSession arg0, AutofillId arg1, CharSequence arg2) {
            arg0.notifyViewTextChanged(arg1, arg2);
        }

        static void notifyViewsDisappeared(ContentCaptureSession arg0, AutofillId arg1, long[] arg2) {
            arg0.notifyViewsDisappeared(arg1, arg2);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static void notifyViewsAppeared(ContentCaptureSession arg0, List arg1) {
            arg0.notifyViewsAppeared(arg1);
        }
    }

    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private ContentCaptureSessionCompat(ContentCaptureSession arg1, View arg2) {
        super();
        this.mWrappedObj = arg1;
        this.mView = arg2;
    }

    public void flush() {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewsDisappeared(this.mWrappedObj, Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView)).toAutofillId(), new long[]{-9223372036854775808L});
        }
    }

    public AutofillId newAutofillId(long arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.newAutofillId(this.mWrappedObj, Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView)).toAutofillId(), arg3);
        }

        return null;
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId arg3, long arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure(this.mWrappedObj, arg3, arg4));
        }

        return null;
    }

    public void notifyViewAppeared(ViewStructure arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewAppeared(this.mWrappedObj, arg3);
        }
    }

    public void notifyViewDisappeared(AutofillId arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewDisappeared(this.mWrappedObj, arg3);
        }
    }

    public void notifyViewTextChanged(AutofillId arg3, CharSequence arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged(this.mWrappedObj, arg3, arg4);
        }
    }

    public void notifyViewsAppeared(List arg5) {
        Object v2;
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared(this.mWrappedObj, arg5);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            ViewStructure v0 = Api29Impl.newViewStructure(this.mWrappedObj, this.mView);
            Api23Impl.getExtras(v0).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            Api29Impl.notifyViewAppeared(this.mWrappedObj, v0);
            int v0_1;
            for(v0_1 = 0; true; ++v0_1) {
                int v1 = arg5.size();
                v2 = this.mWrappedObj;
                if(v0_1 >= v1) {
                    break;
                }

                Api29Impl.notifyViewAppeared(((ContentCaptureSession)v2), arg5.get(v0_1));
            }

            ViewStructure v5 = Api29Impl.newViewStructure(((ContentCaptureSession)v2), this.mView);
            Api23Impl.getExtras(v5).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            Api29Impl.notifyViewAppeared(this.mWrappedObj, v5);
        }
    }

    public void notifyViewsDisappeared(long[] arg5) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api29Impl.notifyViewsDisappeared(this.mWrappedObj, Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView)).toAutofillId(), arg5);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            ViewStructure v0 = Api29Impl.newViewStructure(this.mWrappedObj, this.mView);
            Api23Impl.getExtras(v0).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            Api29Impl.notifyViewAppeared(this.mWrappedObj, v0);
            Api29Impl.notifyViewsDisappeared(this.mWrappedObj, Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView)).toAutofillId(), arg5);
            ViewStructure v5 = Api29Impl.newViewStructure(this.mWrappedObj, this.mView);
            Api23Impl.getExtras(v5).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            Api29Impl.notifyViewAppeared(this.mWrappedObj, v5);
        }
    }

    public ContentCaptureSession toContentCaptureSession() {
        return this.mWrappedObj;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession arg1, View arg2) {
        return new ContentCaptureSessionCompat(arg1, arg2);
    }
}

