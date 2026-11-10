package androidx.core.widget;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    public TextViewOnReceiveContentListener() {
        super();
    }

    private static CharSequence coerceToText(Context arg0, ClipData$Item arg1, int arg2) {
        if((arg2 & 1) != 0) {
            CharSequence v0 = arg1.coerceToText(arg0);
            if((v0 instanceof Spanned)) {
                String v0_1 = v0.toString();
            }

            return v0;
        }

        return arg1.coerceToStyledText(arg0);
    }

    public ContentInfoCompat onReceiveContent(View arg7, ContentInfoCompat arg8) {
        String v0 = "ReceiveContent";
        if(Log.isLoggable(v0, 3)) {
            Log.d(v0, "onReceive: " + arg8);
        }

        if(arg8.getSource() == 2) {
            return arg8;
        }

        ClipData v6 = arg8.getClip();
        int v8 = arg8.getFlags();
        CharSequence v0_1 = ((TextView)arg7).getText();
        Context v7 = ((TextView)arg7).getContext();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v6.getItemCount()) {
            CharSequence v3 = TextViewOnReceiveContentListener.coerceToText(v7, v6.getItemAt(v1), v8);
            if(v3 != null) {
                if(v2 == 0) {
                    TextViewOnReceiveContentListener.replaceSelection(((Editable)v0_1), v3);
                    v2 = 1;
                }
                else {
                    ((Editable)v0_1).insert(Selection.getSelectionEnd(v0_1), "\n");
                    ((Editable)v0_1).insert(Selection.getSelectionEnd(v0_1), v3);
                }
            }

            ++v1;
        }

        return null;
    }

    private static void replaceSelection(Editable arg4, CharSequence arg5) {
        int v0 = Selection.getSelectionStart(((CharSequence)arg4));
        int v1 = Selection.getSelectionEnd(((CharSequence)arg4));
        int v2 = Math.max(0, Math.min(v0, v1));
        v0 = Math.max(0, Math.max(v0, v1));
        Selection.setSelection(((Spannable)arg4), v0);
        arg4.replace(v2, v0, arg5);
    }
}

