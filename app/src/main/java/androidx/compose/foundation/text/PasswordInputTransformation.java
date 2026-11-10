package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0012\u001A\u00020\u0004*\u00020\u0013H\u0016J\u0006\u0010\u0014\u001A\u00020\u0004R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR+\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8@@BX\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/text/PasswordInputTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "scheduleHide", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getScheduleHide", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "", "revealCodepointIndex", "getRevealCodepointIndex$foundation", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "hide", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PasswordInputTransformation implements InputTransformation {
    public static final int $stable;
    private final MutableIntState revealCodepointIndex$delegate;
    private final Function0 scheduleHide;

    static {
    }

    public PasswordInputTransformation(Function0 arg1) {
        super();
        this.scheduleHide = arg1;
        this.revealCodepointIndex$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
    }

    public final int getRevealCodepointIndex$foundation() {
        return this.revealCodepointIndex$delegate.getIntValue();
    }

    public final Function0 getScheduleHide() {
        return this.scheduleHide;
    }

    public final void hide() {
        this.setRevealCodepointIndex(-1);
    }

    private final void setRevealCodepointIndex(int arg1) {
        this.revealCodepointIndex$delegate.setIntValue(arg1);
    }

    public void transformInput(TextFieldBuffer arg6) {
        if(arg6.getChanges().getChangeCount() == 1 && TextRange.getLength-impl(arg6.getChanges().getRange--jx7JFs(0)) == 1) {
            if(arg6.hasSelection()) {
            }
            else {
                int v6 = TextRange.getMin-impl(arg6.getChanges().getRange--jx7JFs(0));
                if(this.getRevealCodepointIndex$foundation() != v6) {
                    this.scheduleHide.invoke();
                    this.setRevealCodepointIndex(v6);
                }

                return;
            }
        }

        this.setRevealCodepointIndex(-1);
    }
}

