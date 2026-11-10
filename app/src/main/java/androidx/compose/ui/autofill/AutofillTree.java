package androidx.compose.ui.autofill;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Deprecated(message="\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ") @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0007H\u0086\u0002J\u001D\u0010\r\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0012"}, d2={"Landroidx/compose/ui/autofill/AutofillTree;", "", "<init>", "()V", "children", "", "", "Landroidx/compose/ui/autofill/AutofillNode;", "getChildren", "()Ljava/util/Map;", "plusAssign", "", "autofillNode", "performAutofill", "id", "value", "", "(ILjava/lang/String;)Lkotlin/Unit;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillTree {
    public static final int $stable = 8;
    private final Map children;

    static {
    }

    public AutofillTree() {
        super();
        this.children = new LinkedHashMap();
    }

    public final Map getChildren() {
        return this.children;
    }

    public final Unit performAutofill(int arg1, String arg2) {
        Object v0 = this.children.get(Integer.valueOf(arg1));
        if(v0 != null) {
            Function1 v0_1 = ((AutofillNode)v0).getOnFill();
            if(v0_1 != null) {
                v0_1.invoke(arg2);
                return Unit.INSTANCE;
            }
        }

        return null;
    }

    public final void plusAssign(AutofillNode arg2) {
        this.children.put(Integer.valueOf(arg2.getId()), arg2);
    }
}

