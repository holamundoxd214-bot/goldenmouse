package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u0006J9\u0010\u000F\u001A\u00020\u00102#\u0010\u0011\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0017\u001A\u00020\u0010J9\u0010\u0018\u001A\u00020\u00102#\u0010\u0011\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010\u0019\u001A\u00020\u00102\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "<init>", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "size", "", "getSize", "()I", "isEmpty", "", "enqueue", "request", "forEachFromSmallest", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "bounds", "resumeAndRemoveAll", "resumeAndRemoveWhile", "cancelAndRemoveAll", "cause", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewRequestPriorityQueue {
    public static final int $stable;
    private final MutableVector requests;

    static {
        BringIntoViewRequestPriorityQueue.$stable = MutableVector.$stable;
    }

    public BringIntoViewRequestPriorityQueue() {
        super();
        this.requests = new MutableVector(new Request[16], 0);
    }

    public static final MutableVector access$getRequests$p(BringIntoViewRequestPriorityQueue arg0) {
        return arg0.requests;
    }

    public final void cancelAndRemoveAll(Throwable arg7) {
        MutableVector v0 = this.requests;
        int v1 = v0.getSize();
        CancellableContinuation[] v2 = new CancellableContinuation[v1];
        int v3 = 0;
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            v2[v4] = v0.content[v4].getContinuation();
        }

        int v0_1;
        for(v0_1 = 0; v0_1 < v1; ++v0_1) {
            v2[v0_1].cancel(arg7);
        }

        if(this.requests.getSize() == 0) {
            v3 = 1;
        }

        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalStateException("uncancelled requests present");
        }
    }

    public final boolean enqueue(Request arg10) {
        Object v0 = arg10.getCurrentBounds().invoke();
        if(v0 == null) {
            arg10.getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return 0;
        }

        arg10.getContinuation().invokeOnCancellation(new BringIntoViewRequestPriorityQueue$$ExternalSyntheticLambda0(this, arg10));
        IntRange v2 = RangesKt.until(0, this.requests.getSize());
        int v3 = v2.getFirst();
        int v2_1 = v2.getLast();
        if(v3 <= v2_1) {
            while(true) {
                Object v5 = this.requests.content[v2_1].getCurrentBounds().invoke();
                if(v5 == null) {
                }
                else {
                    Rect v6 = ((Rect)v0).intersect(((Rect)v5));
                    if(Intrinsics.areEqual(v6, v0)) {
                        this.requests.add(v2_1 + 1, arg10);
                        return 1;
                    }
                    else if(!Intrinsics.areEqual(v6, v5)) {
                        CancellationException v5_1 = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int v6_1 = this.requests.getSize() - 1;
                        if(v6_1 > v2_1) {
                            goto label_53;
                        }

                        while(true) {
                            this.requests.content[v2_1].getContinuation().cancel(v5_1);
                            if(v6_1 == v2_1) {
                                break;
                            }

                            ++v6_1;
                        }
                    }
                }

            label_53:
                if(v2_1 == v3) {
                    break;
                }

                --v2_1;
            }
        }

        this.requests.add(0, arg10);
        return 1;
    }

    static final Unit enqueue$lambda$1(BringIntoViewRequestPriorityQueue arg0, Request arg1, Throwable arg2) {
        arg0.requests.remove(arg1);
        return Unit.INSTANCE;
    }

    public final void forEachFromSmallest(Function1 arg3) {
        MutableVector v2 = this.requests;
        int v0 = v2.getSize() - 1;
        Object[] v2_1 = v2.content;
        if(v0 < v2_1.length) {
            while(v0 >= 0) {
                arg3.invoke(v2_1[v0].getCurrentBounds().invoke());
                --v0;
            }
        }
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        if(this.requests.getSize() == 0) {
            return 1;
        }

        return 0;
    }

    public final void resumeAndRemoveAll() {
        IntRange v0 = RangesKt.until(0, this.requests.getSize());
        int v1 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v1 <= v0_1) {
            while(true) {
                this.requests.content[v1].getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
                if(v1 != v0_1) {
                    ++v1;
                    continue;
                }

                break;
            }
        }

        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(Function1 arg4) {
        while(this.requests.getSize() != 0) {
            if(!arg4.invoke(this.requests.last().getCurrentBounds().invoke()).booleanValue()) {
                return;
            }

            this.requests.removeAt(this.requests.getSize() - 1).getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}

