package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.MotionDurationScale$DefaultImpls;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2={"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "<set-?>", "", "scaleFactor", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor$delegate", "Landroidx/compose/runtime/MutableFloatState;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class MotionDurationScaleImpl implements MotionDurationScale {
    private final MutableFloatState scaleFactor$delegate;

    public MotionDurationScaleImpl() {
        super();
        this.scaleFactor$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1f);
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MotionDurationScale)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MotionDurationScale)this), arg1);
    }

    public float getScaleFactor() {
        return this.scaleFactor$delegate.getFloatValue();
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MotionDurationScale)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MotionDurationScale)this), arg1);
    }

    public void setScaleFactor(float arg1) {
        this.scaleFactor$delegate.setFloatValue(arg1);
    }
}

