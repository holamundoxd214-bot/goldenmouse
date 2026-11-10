package androidx.compose.ui.platform.coreshims;

import android.os.Build$VERSION;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper;

public class ViewCompatShims {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        public static AutofillId getAutofillId(View arg0) {
            return arg0.getAutofillId();
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static ContentCaptureSession getContentCaptureSession(View arg0) {
            return arg0.getContentCaptureSession();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static void setImportantForContentCapture(View arg0, int arg1) {
            arg0.setImportantForContentCapture(arg1);
        }
    }

    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    private ViewCompatShims() {
        super();
    }

    public static AutofillIdCompat getAutofillId(View arg0) {
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(arg0));
    }

    public static ContentCaptureSessionWrapper getContentCaptureSession(View arg3) {
        ContentCaptureSessionWrapper v2 = null;
        if(Build$VERSION.SDK_INT >= 29) {
            ContentCaptureSession v0 = Api29Impl.getContentCaptureSession(arg3);
            if(v0 == null) {
                return v2;
            }

            return ContentCaptureSessionCompat.toContentCaptureSessionCompat(v0, arg3);
        }

        return v2;
    }

    public static void setImportantForContentCapture(View arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setImportantForContentCapture(arg2, arg3);
        }
    }
}

