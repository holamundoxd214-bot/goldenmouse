package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import kotlin.Metadata;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b*\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0007J\u0018\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\bH\u0007J6\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u000FH\u0007J@\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\bH\u0007J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0006\u001A\u00020\u0005H\u0007J\u0010\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010\u001F\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010 \u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010!\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0018\u0010\"\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010#\u001A\u00020$H\u0007J#\u0010%\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\f\u0010&\u001A\b\u0012\u0004\u0012\u00020\u000F0\'H\u0007¢\u0006\u0002\u0010(J \u0010)\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u001A2\u0006\u0010+\u001A\u00020\bH\u0007J\u0018\u0010,\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010-\u001A\u00020\bH\u0007J\u0018\u0010.\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0018\u0010/\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u00100\u001A\u00020\u001CH\u0007J\u0018\u00101\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u00102\u001A\u00020\u001CH\u0007J\u0018\u00103\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u00104\u001A\u00020\bH\u0007J\u0018\u00105\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u00106\u001A\u00020\u000FH\u0007J\u0018\u00107\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u00108\u001A\u00020\u001CH\u0007J\u0018\u00109\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010:\u001A\u00020\u001CH\u0007J\u0018\u0010;\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010<\u001A\u00020\u001CH\u0007J\u0018\u0010=\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010>\u001A\u00020\u001CH\u0007J\u0018\u0010?\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010@\u001A\u00020\u001CH\u0007J\u0018\u0010A\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010-\u001A\u00020\bH\u0007J\u0018\u0010B\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010C\u001A\u00020\u001CH\u0007J\u0018\u0010D\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010E\u001A\u00020\u001CH\u0007J\u0018\u0010F\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010G\u001A\u00020\u001CH\u0007J\u0018\u0010H\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010I\u001A\u00020$H\u0007J\u0018\u0010J\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010K\u001A\u00020\bH\u0007J\u0010\u0010L\u001A\u00020$2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010M\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010N\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u001EH\u0007J\u0010\u0010O\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u000FH\u0007J\u0010\u0010P\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0007¨\u0006Q"}, d2={"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", "<init>", "()V", "newChild", "Landroid/view/ViewStructure;", "structure", "index", "", "addChildCount", "num", "setId", "", "id", "packageName", "", "typeName", "entryName", "setDimens", "left", "top", "scrollX", "scrollY", "width", "height", "getAutofillId", "Landroid/view/autofill/AutofillId;", "isDate", "", "value", "Landroid/view/autofill/AutofillValue;", "isList", "isText", "isToggle", "setContentDescription", "contentDescription", "", "setAutofillHints", "hints", "", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "setAutofillId", "parent", "virtualId", "setAutofillType", "type", "setAutofillValue", "setCheckable", "checkable", "setChecked", "checked", "setChildCount", "numChildren", "setClassName", "classname", "setClickable", "clickable", "setDataIsSensitive", "isSensitive", "setEnabled", "enabled", "setFocusable", "focusable", "setFocused", "focused", "setInputType", "setLongClickable", "longClickable", "setOpaque", "isOpaque", "setSelected", "isSelected", "setText", "text", "setVisibility", "visibility", "textValue", "booleanValue", "listValue", "getAutofillTextValue", "getAutofillToggleValue", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillApi26Helper {
    public static final int $stable;
    public static final AutofillApi26Helper INSTANCE;

    static {
        AutofillApi26Helper.INSTANCE = new AutofillApi26Helper();
    }

    private AutofillApi26Helper() {
        super();
    }

    public final int addChildCount(ViewStructure arg1, int arg2) {
        return arg1.addChildCount(arg2);
    }

    public final boolean booleanValue(AutofillValue arg1) {
        return arg1.getToggleValue();
    }

    public final AutofillId getAutofillId(ViewStructure arg1) {
        return arg1.getAutofillId();
    }

    public final AutofillValue getAutofillTextValue(String arg1) {
        return AutofillValue.forText(((CharSequence)arg1));
    }

    public final AutofillValue getAutofillToggleValue(boolean arg1) {
        return AutofillValue.forToggle(arg1);
    }

    public final boolean isDate(AutofillValue arg1) {
        return arg1.isDate();
    }

    public final boolean isList(AutofillValue arg1) {
        return arg1.isList();
    }

    public final boolean isText(AutofillValue arg1) {
        return arg1.isText();
    }

    public final boolean isToggle(AutofillValue arg1) {
        return arg1.isToggle();
    }

    public final int listValue(AutofillValue arg1) {
        return arg1.getListValue();
    }

    public final ViewStructure newChild(ViewStructure arg1, int arg2) {
        return arg1.newChild(arg2);
    }

    public final void setAutofillHints(ViewStructure arg1, String[] arg2) {
        arg1.setAutofillHints(arg2);
    }

    public final void setAutofillId(ViewStructure arg1, AutofillId arg2, int arg3) {
        arg1.setAutofillId(arg2, arg3);
    }

    public final void setAutofillType(ViewStructure arg1, int arg2) {
        arg1.setAutofillType(arg2);
    }

    public final void setAutofillValue(ViewStructure arg1, AutofillValue arg2) {
        arg1.setAutofillValue(arg2);
    }

    public final void setCheckable(ViewStructure arg1, boolean arg2) {
        arg1.setCheckable(arg2);
    }

    public final void setChecked(ViewStructure arg1, boolean arg2) {
        arg1.setChecked(arg2);
    }

    public final void setChildCount(ViewStructure arg1, int arg2) {
        arg1.setChildCount(arg2);
    }

    public final void setClassName(ViewStructure arg1, String arg2) {
        arg1.setClassName(arg2);
    }

    public final void setClickable(ViewStructure arg1, boolean arg2) {
        arg1.setClickable(arg2);
    }

    public final void setContentDescription(ViewStructure arg1, CharSequence arg2) {
        arg1.setContentDescription(arg2);
    }

    public final void setDataIsSensitive(ViewStructure arg1, boolean arg2) {
        arg1.setDataIsSensitive(arg2);
    }

    public final void setDimens(ViewStructure arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        arg1.setDimens(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public final void setEnabled(ViewStructure arg1, boolean arg2) {
        arg1.setEnabled(arg2);
    }

    public final void setFocusable(ViewStructure arg1, boolean arg2) {
        arg1.setFocusable(arg2);
    }

    public final void setFocused(ViewStructure arg1, boolean arg2) {
        arg1.setFocused(arg2);
    }

    public final void setId(ViewStructure arg1, int arg2, String arg3, String arg4, String arg5) {
        arg1.setId(arg2, arg3, arg4, arg5);
    }

    public final void setInputType(ViewStructure arg1, int arg2) {
        arg1.setInputType(arg2);
    }

    public final void setLongClickable(ViewStructure arg1, boolean arg2) {
        arg1.setLongClickable(arg2);
    }

    public final void setOpaque(ViewStructure arg1, boolean arg2) {
        arg1.setOpaque(arg2);
    }

    public final void setSelected(ViewStructure arg1, boolean arg2) {
        arg1.setSelected(arg2);
    }

    public final void setText(ViewStructure arg1, CharSequence arg2) {
        arg1.setText(arg2);
    }

    public final void setVisibility(ViewStructure arg1, int arg2) {
        arg1.setVisibility(arg2);
    }

    public final CharSequence textValue(AutofillValue arg1) {
        return arg1.getTextValue();
    }
}

