package androidx.compose.ui.autofill;

import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H\u0002\u001A\f\u0010\u0005\u001A\u00020\u0003*\u00020\u0004H\u0002\u001A\f\u0010\u0006\u001A\u00020\u0003*\u00020\u0004H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"logTag", "", "isAutofillable", "", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isRelatedToAutoCommit", "isRelatedToAutofill", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidAutofillManager_androidKt {
    private static final String logTag = "ComposeAutofillManager";

    public static final boolean access$isAutofillable(SemanticsConfiguration arg0) {
        return AndroidAutofillManager_androidKt.isAutofillable(arg0);
    }

    public static final boolean access$isRelatedToAutoCommit(SemanticsConfiguration arg0) {
        return AndroidAutofillManager_androidKt.isRelatedToAutoCommit(arg0);
    }

    public static final boolean access$isRelatedToAutofill(SemanticsConfiguration arg0) {
        return AndroidAutofillManager_androidKt.isRelatedToAutofill(arg0);
    }

    private static final boolean isAutofillable(SemanticsConfiguration arg2) {
        if(!arg2.getProps$ui().contains(SemanticsActions.INSTANCE.getOnAutofillText())) {
            if(arg2.getProps$ui().contains(SemanticsActions.INSTANCE.getOnFillData())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isRelatedToAutoCommit(SemanticsConfiguration arg1) {
        return arg1.getProps$ui().contains(SemanticsProperties.INSTANCE.getContentType());
    }

    private static final boolean isRelatedToAutofill(SemanticsConfiguration arg2) {
        if(!arg2.getProps$ui().contains(SemanticsActions.INSTANCE.getOnAutofillText()) && !arg2.getProps$ui().contains(SemanticsActions.INSTANCE.getOnFillData()) && !arg2.getProps$ui().contains(SemanticsProperties.INSTANCE.getContentType())) {
            if(arg2.getProps$ui().contains(SemanticsProperties.INSTANCE.getContentDataType())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

