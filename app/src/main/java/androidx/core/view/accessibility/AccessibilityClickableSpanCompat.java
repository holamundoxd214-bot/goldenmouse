package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final AccessibilityNodeInfoCompat mNodeInfoCompat;
    private final int mOriginalClickableSpanId;

    public AccessibilityClickableSpanCompat(int arg1, AccessibilityNodeInfoCompat arg2, int arg3) {
        super();
        this.mOriginalClickableSpanId = arg1;
        this.mNodeInfoCompat = arg2;
        this.mClickableSpanActionId = arg3;
    }

    public void onClick(View arg3) {
        Bundle v3 = new Bundle();
        v3.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.performAction(this.mClickableSpanActionId, v3);
    }
}

