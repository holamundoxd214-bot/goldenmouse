package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public final class InputContentInfoCompat {
    final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        final InputContentInfo mObject;

        InputContentInfoCompatApi25Impl(Uri arg2, ClipDescription arg3, Uri arg4) {
            super();
            this.mObject = new InputContentInfo(arg2, arg3, arg4);
        }

        InputContentInfoCompatApi25Impl(Object arg1) {
            super();
            this.mObject = ((InputContentInfo)arg1);
        }

        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        public Object getInputContentInfo() {
            return this.mObject;
        }

        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        public void releasePermission() {
            this.mObject.releasePermission();
        }

        public void requestPermission() {
            this.mObject.requestPermission();
        }
    }

    final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        private final Uri mContentUri;
        private final ClipDescription mDescription;
        private final Uri mLinkUri;

        InputContentInfoCompatBaseImpl(Uri arg1, ClipDescription arg2, Uri arg3) {
            super();
            this.mContentUri = arg1;
            this.mDescription = arg2;
            this.mLinkUri = arg3;
        }

        public Uri getContentUri() {
            return this.mContentUri;
        }

        public ClipDescription getDescription() {
            return this.mDescription;
        }

        public Object getInputContentInfo() {
            return null;
        }

        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public void releasePermission() {
        }

        public void requestPermission() {
        }
    }

    interface InputContentInfoCompatImpl {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    private final InputContentInfoCompatImpl mImpl;

    public InputContentInfoCompat(Uri arg2, ClipDescription arg3, Uri arg4) {
        super();
        this.mImpl = new InputContentInfoCompatApi25Impl(arg2, arg3, arg4);
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl arg1) {
        super();
        this.mImpl = arg1;
    }

    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }

    public static InputContentInfoCompat wrap(Object arg2) {
        if(arg2 == null) {
            return null;
        }

        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(arg2));
    }
}

