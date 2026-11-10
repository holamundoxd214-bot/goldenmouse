package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.Changes;
import androidx.compose.runtime.ComposerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"asLinkBufferChangeList", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "Landroidx/compose/runtime/Changes;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ChangeListKt {
    public static final ChangeList asLinkBufferChangeList(Changes arg1) {
        if((arg1 instanceof ChangeList)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }
}

