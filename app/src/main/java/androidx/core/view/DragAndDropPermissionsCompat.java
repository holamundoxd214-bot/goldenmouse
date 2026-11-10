package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class DragAndDropPermissionsCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void release(DragAndDropPermissions arg0) {
            arg0.release();
        }

        static DragAndDropPermissions requestDragAndDropPermissions(Activity arg0, DragEvent arg1) {
            return arg0.requestDragAndDropPermissions(arg1);
        }
    }

    private final DragAndDropPermissions mDragAndDropPermissions;

    private DragAndDropPermissionsCompat(DragAndDropPermissions arg1) {
        super();
        this.mDragAndDropPermissions = arg1;
    }

    public void release() {
        Api24Impl.release(this.mDragAndDropPermissions);
    }

    public static DragAndDropPermissionsCompat request(Activity arg0, DragEvent arg1) {
        DragAndDropPermissions v0 = Api24Impl.requestDragAndDropPermissions(arg0, arg1);
        if(v0 != null) {
            return new DragAndDropPermissionsCompat(v0);
        }

        return null;
    }
}

