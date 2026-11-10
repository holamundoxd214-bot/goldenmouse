package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build$VERSION;
import android.text.Selection;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;

final class AppCompatReceiveContentHelper {
    final class OnDropApi24Impl {
        private OnDropApi24Impl() {
            super();
        }

        static boolean onDropForTextView(DragEvent arg1, TextView arg2, Activity arg3) {
            arg3.requestDragAndDropPermissions(arg1);
            int v3 = arg2.getOffsetForPosition(arg1.getX(), arg1.getY());
            arg2.beginBatchEdit();
            try {
                Selection.setSelection(arg2.getText(), v3);
                ViewCompat.performReceiveContent(((View)arg2), new Builder(arg1.getClipData(), 3).build());
            }
            catch(Throwable v1) {
                arg2.endBatchEdit();
                throw v1;
            }

            arg2.endBatchEdit();
            return 1;
        }

        static boolean onDropForView(DragEvent arg1, View arg2, Activity arg3) {
            arg3.requestDragAndDropPermissions(arg1);
            ViewCompat.performReceiveContent(arg2, new Builder(arg1.getClipData(), 3).build());
            return 1;
        }
    }

    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
        super();
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View arg4, DragEvent arg5) {
        if(Build$VERSION.SDK_INT < 0x1F && arg5.getLocalState() == null) {
            if(ViewCompat.getOnReceiveContentMimeTypes(arg4) == null) {
            }
            else {
                Activity v0 = AppCompatReceiveContentHelper.tryGetActivity(arg4);
                if(v0 == null) {
                    Log.i("ReceiveContent", "Can\'t handle drop: no activity: view=" + arg4);
                    return 0;
                }
                else if(arg5.getAction() == 1) {
                    return arg4 instanceof TextView ^ 1;
                }
                else if(arg5.getAction() == 3) {
                    if((arg4 instanceof TextView)) {
                        return OnDropApi24Impl.onDropForTextView(arg5, ((TextView)arg4), v0);
                    }
                    else {
                        return OnDropApi24Impl.onDropForView(arg5, arg4, v0);
                    }
                }
            }
        }

        return 0;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView arg5, int arg6) {
        int v2 = 0;
        if(Build$VERSION.SDK_INT < 0x1F && ViewCompat.getOnReceiveContentMimeTypes(((View)arg5)) != null) {
            int v0 = 0x1020022;
            if(arg6 != v0 && arg6 != 0x1020031) {
                return 0;
            }

            Object v1 = arg5.getContext().getSystemService("clipboard");
            ClipData v1_1 = v1 == null ? null : ((ClipboardManager)v1).getPrimaryClip();
            if(v1_1 != null && v1_1.getItemCount() > 0) {
                Builder v4 = new Builder(v1_1, 1);
                if(arg6 == v0) {
                }
                else {
                    v2 = 1;
                }

                ViewCompat.performReceiveContent(((View)arg5), v4.setFlags(v2).build());
            }

            return 1;
        }

        return 0;
    }

    static Activity tryGetActivity(View arg1) {
        Context v1;
        for(v1 = arg1.getContext(); (v1 instanceof ContextWrapper); v1 = ((ContextWrapper)v1).getBaseContext()) {
            if((v1 instanceof Activity)) {
                return ((Activity)v1);
            }
        }

        return null;
    }
}

