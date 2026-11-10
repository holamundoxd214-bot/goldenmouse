package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0001\u001A\u001A\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¨\u0006\t"}, d2={"populateViewStructure", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", "root", "Landroid/view/ViewStructure;", "performAutofill", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidAutofill_androidKt {
    public static final void performAutofill(AndroidAutofill arg6, SparseArray arg7) {
        if(arg6.getAutofillTree().getChildren().isEmpty()) {
        }
        else {
            int v0 = arg7.size();
            int v1 = 0;
            while(true) {
                if(v1 < v0) {
                    int v2 = arg7.keyAt(v1);
                    Object v3 = arg7.get(v2);
                    if(AutofillApi26Helper.INSTANCE.isText(((AutofillValue)v3))) {
                        arg6.getAutofillTree().performAutofill(v2, AutofillApi26Helper.INSTANCE.textValue(((AutofillValue)v3)).toString());
                    }
                    else if(AutofillApi26Helper.INSTANCE.isDate(((AutofillValue)v3))) {
                        goto label_38;
                    }
                    else if(!AutofillApi26Helper.INSTANCE.isList(((AutofillValue)v3))) {
                        if(!AutofillApi26Helper.INSTANCE.isToggle(((AutofillValue)v3))) {
                            goto label_28;
                        }

                        break;
                    }
                    else {
                        goto label_34;
                    }

                label_28:
                    ++v1;
                    continue;
                }

                return;
            }

            throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
        label_34:
            throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
        label_38:
            throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
        }
    }

    public static final void populateViewStructure(AndroidAutofill arg16, ViewStructure arg17) {
        ViewStructure v0 = arg17;
        if(arg16.getAutofillTree().getChildren().isEmpty()) {
        }
        else {
            int v1 = AutofillApi26Helper.INSTANCE.addChildCount(v0, arg16.getAutofillTree().getChildren().size());
            Iterator v2 = arg16.getAutofillTree().getChildren().entrySet().iterator();
            while(v2.hasNext()) {
                Object v3 = v2.next();
                int v7 = ((Map$Entry)v3).getKey().intValue();
                v3 = ((Map$Entry)v3).getValue();
                ViewStructure v6 = AutofillApi26Helper.INSTANCE.newChild(v0, v1);
                AutofillApi26Helper.INSTANCE.setAutofillId(v6, arg16.getRootAutofillId(), v7);
                AutofillApi26Helper.INSTANCE.setId(v6, v7, arg16.getView().getContext().getPackageName(), null, null);
                AutofillApi26Helper.INSTANCE.setAutofillType(v6, ContentDataType_androidKt.getDataType(ContentDataType.Companion.getText()));
                AutofillApi26Helper v4 = AutofillApi26Helper.INSTANCE;
                List v5 = ((AutofillNode)v3).getAutofillTypes();
                ArrayList v7_1 = new ArrayList(v5.size());
                int v8 = v5.size();
                int v10;
                for(v10 = 0; v10 < v8; ++v10) {
                    v7_1.add(AndroidAutofillType_androidKt.getAndroidType(v5.get(v10)));
                }

                v4.setAutofillHints(v6, ((Collection)v7_1).toArray(new String[0]));
                Rect v3_1 = ((AutofillNode)v3).getBoundingBox();
                if(v3_1 == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                }
                else {
                    v10 = Math.round(v3_1.getLeft());
                    int v11 = Math.round(v3_1.getTop());
                    AutofillApi26Helper.INSTANCE.setDimens(v6, v10, v11, 0, 0, Math.round(v3_1.getRight()) - v10, Math.round(v3_1.getBottom()) - v11);
                }

                ++v1;
            }
        }
    }
}

