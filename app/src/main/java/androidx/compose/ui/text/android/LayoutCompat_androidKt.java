package androidx.compose.ui.text.android;

import android.text.Layout;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"getLineForOffset", "", "Landroid/text/Layout;", "offset", "upstream", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutCompat_androidKt {
    public static final int getLineForOffset(Layout arg2, int arg3, boolean arg4) {
        if(arg3 <= 0) {
            return 0;
        }

        if(arg3 >= arg2.getText().length()) {
            return arg2.getLineCount() - 1;
        }

        int v0 = arg2.getLineForOffset(arg3);
        int v1 = arg2.getLineStart(v0);
        int v2 = arg2.getLineEnd(v0);
        if(v1 != arg3 && v2 != arg3) {
        }
        else if(v1 != arg3) {
            if(arg4) {
                return v0;
            }

            goto label_21;
        }
        else if(arg4) {
            return v0 - 1;
        }

        return v0;
    label_21:
        return v0 + 1;
    }
}

