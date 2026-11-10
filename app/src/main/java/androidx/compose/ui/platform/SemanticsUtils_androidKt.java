package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0017\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0006\u001A\u001C\u0010\u0007\u001A\u0004\u0018\u00010\b*\b\u0012\u0004\u0012\u00020\b0\t2\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A\u0015\u0010\f\u001A\u0004\u0018\u00010\r*\u00020\u000EH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\n\u001A\u00020\u000BH\u0000¨\u0006\u0014"}, d2={"getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getScrollViewportLength", "", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "toLegacyClassName", "", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsUtils_androidKt {
    public static final ScrollObservationScope findById(List arg3, int arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg3.get(v1).getSemanticsNodeId() == arg4) {
                return arg3.get(v1);
            }
        }

        return null;
    }

    public static final Float getScrollViewportLength(SemanticsConfiguration arg2) {
        ArrayList v0 = new ArrayList();
        Object v2 = SemanticsConfigurationKt.getOrNull(arg2, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        Float v1 = null;
        if(v2 != null) {
            Function v2_1 = ((AccessibilityAction)v2).getAction();
            if(v2_1 != null && (((Function1)v2_1).invoke(v0).booleanValue())) {
                return ((List)v0).get(0);
            }
        }

        return v1;
    }

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration arg2) {
        ArrayList v0 = new ArrayList();
        Object v2 = SemanticsConfigurationKt.getOrNull(arg2, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        TextLayoutResult v1 = null;
        if(v2 != null) {
            Function v2_1 = ((AccessibilityAction)v2).getAction();
            if(v2_1 != null && (((Function1)v2_1).invoke(v0).booleanValue())) {
                return ((List)v0).get(0);
            }
        }

        return v1;
    }

    public static final View semanticsIdToView(AndroidViewsHandler arg3, int arg4) {
        Object v1_1;
        Object v0;
        View v1;
        Iterator v3 = arg3.getLayoutNodeToHolder().entrySet().iterator();
        do {
            v1 = null;
            if(v3.hasNext()) {
                v0 = v3.next();
                if(v0.getKey().getSemanticsId() != arg4) {
                    continue;
                }

                break;
            }
            else {
                goto label_12;
            }
        }
        while(true);

        goto label_13;
    label_12:
        v0 = v1;
    label_13:
        if(v0 != null) {
            v1_1 = ((Map$Entry)v0).getValue();
        }

        return ((View)v1_1);
    }

    public static final String toLegacyClassName-V4PA4sw(int arg1) {
        if(Role.equals-impl0(arg1, Role.Companion.getButton-o7Vup1c())) {
            return "android.widget.Button";
        }

        if(Role.equals-impl0(arg1, Role.Companion.getCheckbox-o7Vup1c())) {
            return "android.widget.CheckBox";
        }

        if(Role.equals-impl0(arg1, Role.Companion.getRadioButton-o7Vup1c())) {
            return "android.widget.RadioButton";
        }

        if(Role.equals-impl0(arg1, Role.Companion.getImage-o7Vup1c())) {
            return "android.widget.ImageView";
        }

        if(Role.equals-impl0(arg1, Role.Companion.getDropdownList-o7Vup1c())) {
            return "android.widget.Spinner";
        }

        if(Role.equals-impl0(arg1, Role.Companion.getValuePicker-o7Vup1c())) {
            return "android.widget.NumberPicker";
        }

        return null;
    }
}

