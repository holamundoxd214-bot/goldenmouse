package androidx.core.text.method;

import android.os.Build$VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    private LinkMovementMethodCompat() {
        super();
    }

    public static LinkMovementMethodCompat getInstance() {
        LinkMovementMethodCompat v0 = LinkMovementMethodCompat.sInstance;
        if(v0 == null) {
            v0 = new LinkMovementMethodCompat();
            LinkMovementMethodCompat.sInstance = v0;
        }

        return v0;
    }

    public boolean onTouchEvent(TextView arg5, Spannable arg6, MotionEvent arg7) {
        if(Build$VERSION.SDK_INT < 35) {
            int v0 = arg7.getAction();
            if(v0 != 1 && v0 != 0) {
                goto label_33;
            }

            v0 = ((int)arg7.getX());
            int v1 = ((int)arg7.getY());
            v0 -= arg5.getTotalPaddingLeft();
            v1 -= arg5.getTotalPaddingTop();
            v0 += arg5.getScrollX();
            v1 += arg5.getScrollY();
            Layout v2 = arg5.getLayout();
            if(v1 >= 0) {
                if(v1 > v2.getHeight()) {
                }
                else {
                    v1 = v2.getLineForVertical(v1);
                    float v0_1 = ((float)v0);
                    if(v0_1 >= v2.getLineLeft(v1)) {
                        if(v0_1 > v2.getLineRight(v1)) {
                            goto label_30;
                        }

                        goto label_33;
                    }
                }
            }

        label_30:
            Selection.removeSelection(arg6);
            return Touch.onTouchEvent(arg5, arg6, arg7);
        }

    label_33:
        return super.onTouchEvent(arg5, arg6, arg7);
    }
}

