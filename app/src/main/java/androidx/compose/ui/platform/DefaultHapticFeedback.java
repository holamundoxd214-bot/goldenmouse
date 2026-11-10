package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/ui/platform/DefaultHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    static {
    }

    public DefaultHapticFeedback(View arg1) {
        super();
        this.view = arg1;
    }

    public void performHapticFeedback-CdsT49E(int arg2) {
        if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getConfirm-5zf0vsI())) {
            arg2 = 16;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getContextClick-5zf0vsI())) {
            arg2 = 6;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getGestureEnd-5zf0vsI())) {
            arg2 = 13;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getGestureThresholdActivate-5zf0vsI())) {
            arg2 = 23;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getKeyboardTap-5zf0vsI())) {
            arg2 = 3;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getLongPress-5zf0vsI())) {
            arg2 = 0;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getReject-5zf0vsI())) {
            arg2 = 17;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getSegmentFrequentTick-5zf0vsI())) {
            arg2 = 27;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getSegmentTick-5zf0vsI())) {
            arg2 = 26;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI())) {
            arg2 = 9;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getToggleOff-5zf0vsI())) {
            arg2 = 22;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getToggleOn-5zf0vsI())) {
            arg2 = 21;
        }
        else if(HapticFeedbackType.equals-impl0(arg2, HapticFeedbackType.Companion.getVirtualKey-5zf0vsI())) {
            arg2 = 1;
        }
        else {
            arg2 = -1;
        }

        ViewCompat.performHapticFeedback(this.view, arg2);
    }
}

