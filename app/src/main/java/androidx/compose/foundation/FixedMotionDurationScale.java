package androidx.compose.foundation;

import androidx.compose.ui.MotionDurationScale$DefaultImpls;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/FixedMotionDurationScale;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "scaleFactor", "", "getScaleFactor", "()F", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FixedMotionDurationScale implements MotionDurationScale {
    public static final FixedMotionDurationScale INSTANCE;

    static {
        FixedMotionDurationScale.INSTANCE = new FixedMotionDurationScale();
    }

    private FixedMotionDurationScale() {
        super();
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((MotionDurationScale)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((MotionDurationScale)this), arg1);
    }

    public float getScaleFactor() {
        return 1f;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((MotionDurationScale)this), arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((MotionDurationScale)this), arg1);
    }
}

