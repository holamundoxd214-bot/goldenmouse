package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.sync.Mutex$DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000B\u001A\u00020\fJ\u0006\u0010\r\u001A\u00020\fJ\u000E\u0010\u000E\u001A\u00020\fH\u0086@¢\u0006\u0002\u0010\u000FJ\u000E\u0010\u0010\u001A\u00020\fH\u0096@¢\u0006\u0002\u0010\u000FJ\u000E\u0010\u0011\u001A\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000FJ\u0014\u0010\u0012\u001A\u00020\u0013*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0012\u001A\u00020\u0013*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001A\u001A\u00020\u0014*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b\u001B\u0010\u001CJ\u0014\u0010\u001A\u001A\u00020\u0014*\u00020\u001DH\u0097\u0001¢\u0006\u0004\b\u001B\u0010\u001EJ\u0014\u0010\u001A\u001A\u00020\u0014*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u001F\u0010 J\u0014\u0010!\u001A\u00020\"*\u00020#H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001A\u00020\u001D*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b\'\u0010\u001EJ\u0014\u0010&\u001A\u00020\u001D*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b(\u0010 J\r\u0010)\u001A\u00020**\u00020+H\u0097\u0001J\u0014\u0010,\u001A\u00020#*\u00020\"H\u0097\u0001¢\u0006\u0004\b-\u0010%J\u0014\u0010.\u001A\u00020\u0017*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b/\u00100J\u0014\u0010.\u001A\u00020\u0017*\u00020\u001DH\u0097\u0001¢\u0006\u0004\b/\u00101J\u0014\u0010.\u001A\u00020\u0017*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b2\u00101R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\u00020\u001D8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b3\u00104R\u0014\u00105\u001A\u00020\u001D8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b6\u00104¨\u00067"}, d2={"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "isReleased", "", "isCanceled", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cancel", "", "release", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRelease", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getDensity", "()F", "fontScale", "getFontScale", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PressGestureScopeImpl implements PressGestureScope, Density {
    public static final int $stable;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex;

    static {
    }

    public PressGestureScopeImpl(Density arg1) {
        super();
        this.$$delegate_0 = arg1;
        this.mutex = MutexKt.Mutex(false);
    }

    public Object awaitRelease(Continuation arg5) {
        int v2;
        Continuation v0;
        if((arg5 instanceof PressGestureScopeImpl$awaitRelease$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((PressGestureScopeImpl$awaitRelease$1)v0).label & v2) != 0) {
                ((PressGestureScopeImpl$awaitRelease$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PressGestureScopeImpl$awaitRelease$1 v0_1 = new PressGestureScopeImpl$awaitRelease$1(this, arg5);
        }

        Object v5 = ((PressGestureScopeImpl$awaitRelease$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PressGestureScopeImpl$awaitRelease$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            ((PressGestureScopeImpl$awaitRelease$1)v0).label = 1;
            v5 = this.tryAwaitRelease(v0);
            if(v5 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(((Boolean)v5).booleanValue()) {
            return Unit.INSTANCE;
        }

        throw new GestureCancellationException("The press gesture was canceled.");
    }

    public final void cancel() {
        this.isCanceled = true;
        if(this.mutex.isLocked()) {
            DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        if(this.mutex.isLocked()) {
            DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    public final Object reset(Continuation arg5) {
        int v2;
        Continuation v0;
        if((arg5 instanceof PressGestureScopeImpl$reset$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((PressGestureScopeImpl$reset$1)v0).label & v2) != 0) {
                ((PressGestureScopeImpl$reset$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PressGestureScopeImpl$reset$1 v0_1 = new PressGestureScopeImpl$reset$1(this, arg5);
        }

        Object v5 = ((PressGestureScopeImpl$reset$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PressGestureScopeImpl$reset$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            Mutex v5_1 = this.mutex;
            ((PressGestureScopeImpl$reset$1)v0).label = 1;
            if(DefaultImpls.lock$default(v5_1, null, v0, 1, null) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.isReleased = false;
        this.isCanceled = false;
        return Unit.INSTANCE;
    }

    public int roundToPx--R2X_6o(long arg1) {
        return this.$$delegate_0.roundToPx--R2X_6o(arg1);
    }

    public int roundToPx-0680j_4(float arg1) {
        return this.$$delegate_0.roundToPx-0680j_4(arg1);
    }

    public float toDp-GaN1DYA(long arg1) {
        return this.$$delegate_0.toDp-GaN1DYA(arg1);
    }

    public float toDp-u2uoSUM(float arg1) {
        return this.$$delegate_0.toDp-u2uoSUM(arg1);
    }

    public float toDp-u2uoSUM(int arg1) {
        return this.$$delegate_0.toDp-u2uoSUM(arg1);
    }

    public long toDpSize-k-rfVVM(long arg1) {
        return this.$$delegate_0.toDpSize-k-rfVVM(arg1);
    }

    public float toPx--R2X_6o(long arg1) {
        return this.$$delegate_0.toPx--R2X_6o(arg1);
    }

    public float toPx-0680j_4(float arg1) {
        return this.$$delegate_0.toPx-0680j_4(arg1);
    }

    public Rect toRect(DpRect arg1) {
        return this.$$delegate_0.toRect(arg1);
    }

    public long toSize-XkaWNTQ(long arg1) {
        return this.$$delegate_0.toSize-XkaWNTQ(arg1);
    }

    public long toSp-0xMU5do(float arg1) {
        return this.$$delegate_0.toSp-0xMU5do(arg1);
    }

    public long toSp-kPz2Gy4(float arg1) {
        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
    }

    public long toSp-kPz2Gy4(int arg1) {
        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
    }

    public Object tryAwaitRelease(Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof PressGestureScopeImpl$tryAwaitRelease$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((PressGestureScopeImpl$tryAwaitRelease$1)v0).label & v2) != 0) {
                ((PressGestureScopeImpl$tryAwaitRelease$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PressGestureScopeImpl$tryAwaitRelease$1 v0_1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, arg6);
        }

        Object v6 = ((PressGestureScopeImpl$tryAwaitRelease$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PressGestureScopeImpl$tryAwaitRelease$1)v0).label;
        Object v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            if(!this.isReleased && !this.isCanceled) {
                Mutex v6_1 = this.mutex;
                ((PressGestureScopeImpl$tryAwaitRelease$1)v0).label = 1;
                if(DefaultImpls.lock$default(v6_1, v3, v0, 1, v3) == v1) {
                    return v1;
                }
                else {
                label_36:
                    DefaultImpls.unlock$default(this.mutex, v3, 1, v3);
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v6);
            goto label_36;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxBoolean(this.isReleased);
    }
}

