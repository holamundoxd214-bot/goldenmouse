package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001A\"\u0010\b\u001A\u00020\u0007*\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0080@¢\u0006\u0002\u0010\u000E\u001A\"\u0010\u000F\u001A\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001A*\u0010\u0015\u001A\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0017\u001A*\u0010\u0018\u001A\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u001C\u001A\u0012\u0010\u001D\u001A\u00020\u0013*\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001E\u001A \u0010\u001F\u001A\u00020\u00062\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020#H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "awaitSelectionGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "downEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionSubsequentPress", "clicks", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 0x845FED;

    public static final Object access$awaitDown(AwaitPointerEventScope arg0, Continuation arg1) {
        return SelectionGesturesKt.awaitDown(arg0, arg1);
    }

    public static final boolean access$distanceIsTolerable(ViewConfiguration arg0, PointerInputChange arg1, PointerInputChange arg2) {
        return SelectionGesturesKt.distanceIsTolerable(arg0, arg1, arg2);
    }

    public static final Object access$touchSelectionSubsequentPress(AwaitPointerEventScope arg0, TextDragObserver arg1, PointerEvent arg2, int arg3, Continuation arg4) {
        return SelectionGesturesKt.touchSelectionSubsequentPress(arg0, arg1, arg2, arg3, arg4);
    }

    private static final Object awaitDown(AwaitPointerEventScope arg7, Continuation arg8) {
        Object v7;
        SelectionGesturesKt$awaitDown$1 v0_1;
        int v2;
        if((arg8 instanceof SelectionGesturesKt$awaitDown$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((SelectionGesturesKt$awaitDown$1)v0).label & v2) != 0) {
                ((SelectionGesturesKt$awaitDown$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SelectionGesturesKt$awaitDown$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
        label_27:
            PointerEventPass v8_1 = PointerEventPass.Main;
            v0_1.L$0 = v7;
            v0_1.label = 1;
            v8 = ((AwaitPointerEventScope)v7).awaitPointerEvent(v8_1, ((Continuation)v0_1));
            if(v8 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v7 = v0_1.L$0;
            ResultKt.throwOnFailure(v8);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v2_1 = ((PointerEvent)v8).getChanges();
        int v4 = v2_1.size();
        int v5;
        for(v5 = 0; v5 < v4; ++v5) {
            if(!PointerEventKt.changedToDown(v2_1.get(v5))) {
                goto label_27;
            }
        }

        return v8;
    }

    public static final Object awaitSelectionGestures(PointerInputScope arg3, MouseSelectionObserver arg4, TextDragObserver arg5, Continuation arg6) {
        Object v3 = ForEachGestureKt.awaitEachGesture(arg3, new SelectionGesturesKt$awaitSelectionGestures$2(new ClicksCounter(arg3.getViewConfiguration()), arg4, arg5, null), arg6);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    private static final boolean distanceIsTolerable(ViewConfiguration arg2, PointerInputChange arg3, PointerInputChange arg4) {
        if(Offset.getDistance-impl(Offset.minus-MK-Hz9U(arg3.getPosition-F1C5BW0(), arg4.getPosition-F1C5BW0())) < DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg2, arg3.getType-T8wyACA())) {
            return 1;
        }

        return 0;
    }

    public static final Object mouseSelection(AwaitPointerEventScope arg9, MouseSelectionObserver arg10, ClicksCounter arg11, PointerEvent arg12, Continuation arg13) {
        Object v11;
        Object v10;
        Object v9;
        SelectionAdjustment v12_2;
        Object v12;
        int v11_2;
        List v9_2;
        SelectionGesturesKt$mouseSelection$1 v0_1;
        int v2;
        if((arg13 instanceof SelectionGesturesKt$mouseSelection$1)) {
            Continuation v0 = arg13;
            v2 = 0x80000000;
            if((((SelectionGesturesKt$mouseSelection$1)v0).label & v2) != 0) {
                ((SelectionGesturesKt$mouseSelection$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SelectionGesturesKt$mouseSelection$1(arg13);
        }

        Object v13 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 0;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v13);
            v13 = arg12.getChanges().get(0);
            if(PointerEvent_androidKt.isShiftPressed-5xRPYO0(arg12.getKeyboardModifiers-k7X9c1A())) {
                if(arg10.onExtend-k-4lQ0M(((PointerInputChange)v13).getPosition-F1C5BW0())) {
                    try {
                        ((PointerInputChange)v13).consume();
                        long v11_1 = ((PointerInputChange)v13).getId-J3iCeTQ();
                        SelectionGesturesKt$$ExternalSyntheticLambda0 v13_1 = new SelectionGesturesKt$$ExternalSyntheticLambda0(arg10);
                        v0_1.L$0 = arg9;
                        v0_1.L$1 = arg10;
                        v0_1.label = 1;
                        v13 = DragGestureDetectorKt.drag-jO51t88(arg9, v11_1, ((Function1)v13_1), ((Continuation)v0_1));
                        if(v13 == v1) {
                        }
                        else {
                        label_59:
                            if(((Boolean)v13).booleanValue()) {
                                v9_2 = ((AwaitPointerEventScope)v9).getCurrentEvent().getChanges();
                                v11_2 = v9_2.size();
                                while(true) {
                                label_65:
                                    if(v3 < v11_2) {
                                        v12 = v9_2.get(v3);
                                        if(PointerEventKt.changedToUp(((PointerInputChange)v12))) {
                                            ((PointerInputChange)v12).consume();
                                        }

                                        goto label_70;
                                    }

                                    goto label_72;
                                }
                            }

                            goto label_72;
                        }

                        return v1;
                    }
                    catch(Throwable v9_1) {
                        goto label_74;
                    }

                label_70:
                    ++v3;
                    goto label_65;
                label_74:
                    ((MouseSelectionObserver)v10).onDragDone();
                    throw v9_1;
                label_72:
                    ((MouseSelectionObserver)v10).onDragDone();
                }
                else {
                }

                goto label_130;
            }
            else {
                int v12_1 = arg11.getClicks();
                if(v12_1 == 1) {
                    v12_2 = SelectionAdjustment.Companion.getNone();
                }
                else if(v12_1 != v4) {
                    v12_2 = SelectionAdjustment.Companion.getParagraph();
                }
                else {
                    v12_2 = SelectionAdjustment.Companion.getWord();
                }

                if(!arg10.onStart-9KIMszo(((PointerInputChange)v13).getPosition-F1C5BW0(), v12_2, arg11.getClicks())) {
                    goto label_130;
                }

                try {
                    BooleanRef v11_3 = new BooleanRef();
                    v11_3.element = Intrinsics.areEqual(v12_2, SelectionAdjustment.Companion.getNone()) ^ 1;
                    long v5 = ((PointerInputChange)v13).getId-J3iCeTQ();
                    SelectionGesturesKt$$ExternalSyntheticLambda1 v13_2 = new SelectionGesturesKt$$ExternalSyntheticLambda1(arg10, v12_2, v11_3);
                    v0_1.L$0 = arg9;
                    v0_1.L$1 = arg10;
                    v0_1.L$2 = v11_3;
                    v0_1.label = v4;
                    v13 = DragGestureDetectorKt.drag-jO51t88(arg9, v5, ((Function1)v13_2), ((Continuation)v0_1));
                    if(v13 == v1) {
                        return v1;
                    }

                    BooleanRef v8 = v11_3;
                    AwaitPointerEventScope v11_4 = arg9;
                    BooleanRef v9_3 = v8;
                label_111:
                    if((((Boolean)v13).booleanValue()) && (v9_3.element)) {
                        v9_2 = ((AwaitPointerEventScope)v11).getCurrentEvent().getChanges();
                        v11_2 = v9_2.size();
                        while(true) {
                        label_119:
                            if(v3 < v11_2) {
                                v12 = v9_2.get(v3);
                                if(PointerEventKt.changedToUp(((PointerInputChange)v12))) {
                                    ((PointerInputChange)v12).consume();
                                }

                                goto label_124;
                            }

                            goto label_126;
                        }
                    }

                    goto label_126;
                }
                catch(Throwable v9_1) {
                    goto label_128;
                }
            }

            return v1;
        label_124:
            ++v3;
            goto label_119;
        label_128:
            ((MouseSelectionObserver)v10).onDragDone();
            throw v9_1;
        label_126:
            ((MouseSelectionObserver)v10).onDragDone();
        }
        else if(v2 == 1) {
            v10 = v0_1.L$1;
            v9 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v13);
                goto label_59;
            }
            catch(Throwable v9_1) {
                goto label_74;
            }
        }
        else if(v2 == v4) {
            v9 = v0_1.L$2;
            v10 = v0_1.L$1;
            v11 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v13);
                goto label_111;
            }
            catch(Throwable v9_1) {
                goto label_128;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_130:
        return Unit.INSTANCE;
    }

    static final Unit mouseSelection$lambda$0(MouseSelectionObserver arg2, PointerInputChange arg3) {
        if(arg2.onExtendDrag-k-4lQ0M(arg3.getPosition-F1C5BW0())) {
            arg3.consume();
        }

        return Unit.INSTANCE;
    }

    static final Unit mouseSelection$lambda$2(MouseSelectionObserver arg2, SelectionAdjustment arg3, BooleanRef arg4, PointerInputChange arg5) {
        if(arg2.onDrag-3MmeM6k(arg5.getPosition-F1C5BW0(), arg3)) {
            arg5.consume();
            arg4.element = true;
        }

        return Unit.INSTANCE;
    }

    public static final Object touchSelectionFirstPress(AwaitPointerEventScope arg8, TextDragObserver arg9, PointerEvent arg10, Continuation arg11) {
        Object v8;
        Object v9;
        Object v10;
        SelectionGesturesKt$touchSelectionFirstPress$1 v0_1;
        int v2;
        if((arg11 instanceof SelectionGesturesKt$touchSelectionFirstPress$1)) {
            Continuation v0 = arg11;
            v2 = 0x80000000;
            if((((SelectionGesturesKt$touchSelectionFirstPress$1)v0).label & v2) != 0) {
                ((SelectionGesturesKt$touchSelectionFirstPress$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SelectionGesturesKt$touchSelectionFirstPress$1(arg11);
        }

        Object v11 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v11);
            try {
                v10 = CollectionsKt.first(arg10.getChanges());
                long v5 = ((PointerInputChange)v10).getId-J3iCeTQ();
                v0_1.L$0 = arg8;
                v0_1.L$1 = arg9;
                v0_1.L$2 = v10;
                v0_1.label = 1;
                v11 = DragGestureDetectorKt.awaitLongPressOrCancellation-rnUCldI(arg8, v5, ((Continuation)v0_1));
                if(v11 == v1) {
                    return v1;
                }
                else {
                label_49:
                    if(v11 != null && (SelectionGesturesKt.distanceIsTolerable(((AwaitPointerEventScope)v8).getViewConfiguration(), ((PointerInputChange)v10), ((PointerInputChange)v11)))) {
                        ((TextDragObserver)v9).onStart-3MmeM6k(((PointerInputChange)v11).getPosition-F1C5BW0(), SelectionAdjustment.Companion.getWord());
                        long v10_1 = ((PointerInputChange)v11).getId-J3iCeTQ();
                        SelectionGesturesKt$$ExternalSyntheticLambda2 v2_1 = new SelectionGesturesKt$$ExternalSyntheticLambda2(((TextDragObserver)v9));
                        v0_1.L$0 = v8;
                        v0_1.L$1 = v9;
                        v0_1.L$2 = null;
                        v0_1.label = v3;
                        v11 = DragGestureDetectorKt.drag-jO51t88(((AwaitPointerEventScope)v8), v10_1, ((Function1)v2_1), ((Continuation)v0_1));
                        if(v11 == v1) {
                            return v1;
                        }
                        else {
                        label_68:
                            if(((Boolean)v11).booleanValue()) {
                                List v8_2 = ((AwaitPointerEventScope)v8).getCurrentEvent().getChanges();
                                int v10_2 = v8_2.size();
                                int v11_1;
                                for(v11_1 = 0; v11_1 < v10_2; ++v11_1) {
                                    Object v0_2 = v8_2.get(v11_1);
                                    if(PointerEventKt.changedToUp(((PointerInputChange)v0_2))) {
                                        ((PointerInputChange)v0_2).consume();
                                    }
                                }

                                ((TextDragObserver)v9).onStop();
                            }
                            else {
                                ((TextDragObserver)v9).onCancel();
                            }
                        }
                    }
                }
            }
            catch(CancellationException v8_1) {
            label_88:
                ((TextDragObserver)v9).onCancel();
                throw v8_1;
            }
        }
        else if(v2 == 1) {
            v8 = v0_1.L$2;
            v9 = v0_1.L$1;
            v10 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v11);
                Object v7 = v10;
                v10 = v8;
                v8 = v7;
                goto label_49;
            }
            catch(CancellationException v8_1) {
                goto label_88;
            }
        }
        else if(v2 == v3) {
            v9 = v0_1.L$1;
            v8 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v11);
                goto label_68;
            }
            catch(CancellationException v8_1) {
                goto label_88;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    static final Unit touchSelectionFirstPress$lambda$0(TextDragObserver arg2, PointerInputChange arg3) {
        arg2.onDrag-k-4lQ0M(PointerEventKt.positionChange(arg3));
        arg3.consume();
        return Unit.INSTANCE;
    }

    private static final Object touchSelectionSubsequentPress(AwaitPointerEventScope arg10, TextDragObserver arg11, PointerEvent arg12, int arg13, Continuation arg14) {
        Object v10;
        Object v11;
        long v6;
        Object v12;
        SelectionGesturesKt$touchSelectionSubsequentPress$1 v0_1;
        int v2;
        if((arg14 instanceof SelectionGesturesKt$touchSelectionSubsequentPress$1)) {
            Continuation v0 = arg14;
            v2 = 0x80000000;
            if((((SelectionGesturesKt$touchSelectionSubsequentPress$1)v0).label & v2) != 0) {
                ((SelectionGesturesKt$touchSelectionSubsequentPress$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SelectionGesturesKt$touchSelectionSubsequentPress$1(arg14);
        }

        Object v14 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Continuation v3 = null;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            try {
                v12 = CollectionsKt.first(arg12.getChanges());
                v6 = ((PointerInputChange)v12).getId-J3iCeTQ();
                long v8 = ((PointerInputChange)v12).getPosition-F1C5BW0();
                SelectionAdjustment v12_1 = arg13 > v4 ? SelectionAdjustment.Companion.getParagraph() : SelectionAdjustment.Companion.getWord();
                arg11.onStart-3MmeM6k(v8, v12_1);
                LongRef v12_2 = new LongRef();
                v12_2.element = Offset.Companion.getUnspecified-F1C5BW0();
                long v13_1 = arg10.getViewConfiguration().getLongPressTimeoutMillis();
                SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 v2_2 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(v6, v12_2, v3);
                v0_1.L$0 = arg10;
                v0_1.L$1 = arg11;
                v0_1.L$2 = v12_2;
                v0_1.J$0 = v6;
                v0_1.label = 1;
                v14 = arg10.withTimeoutOrNull(v13_1, ((Function2)v2_2), ((Continuation)v0_1));
                if(v14 == v1) {
                    return v1;
                }

            label_72:
                if(v14 == null) {
                    DownResolution v14_1 = DownResolution.Timeout;
                }

                if(v14_1 == DownResolution.Cancel) {
                    ((TextDragObserver)v11).onCancel();
                    return Unit.INSTANCE;
                }

                if(v14_1 == DownResolution.Up) {
                    ((TextDragObserver)v11).onStop();
                    return Unit.INSTANCE;
                }

                if(v14_1 == DownResolution.Drag) {
                    ((TextDragObserver)v11).onDrag-k-4lQ0M(((LongRef)v12).element);
                }

                SelectionGesturesKt$$ExternalSyntheticLambda3 v12_3 = new SelectionGesturesKt$$ExternalSyntheticLambda3(((TextDragObserver)v11));
                v0_1.L$0 = v10;
                v0_1.L$1 = v11;
                v0_1.L$2 = v3;
                v0_1.label = v4;
                v14 = DragGestureDetectorKt.drag-jO51t88(((AwaitPointerEventScope)v10), v6, ((Function1)v12_3), ((Continuation)v0_1));
                if(v14 == v1) {
                    return v1;
                }

            label_97:
                if(((Boolean)v14).booleanValue()) {
                    List v10_3 = ((AwaitPointerEventScope)v10).getCurrentEvent().getChanges();
                    int v12_4 = v10_3.size();
                    for(arg13 = 0; arg13 < v12_4; ++arg13) {
                        v14 = v10_3.get(arg13);
                        if(PointerEventKt.changedToUp(((PointerInputChange)v14))) {
                            ((PointerInputChange)v14).consume();
                        }
                    }

                    ((TextDragObserver)v11).onStop();
                }
                else {
                    ((TextDragObserver)v11).onCancel();
                }

                goto label_114;
            }
            catch(CancellationException v10_1) {
                goto label_117;
            }
        }
        else if(v2 == 1) {
            long v10_2 = v0_1.J$0;
            v12 = v0_1.L$2;
            Object v13 = v0_1.L$1;
            Object v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v14);
                v6 = v10_2;
                v11 = v13;
                v10 = v2_1;
                goto label_72;
            }
            catch(CancellationException v10_1) {
                v11 = v13;
                goto label_117;
            }
        }
        else if(v2 == v4) {
            v11 = v0_1.L$1;
            v10 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v14);
                goto label_97;
            }
            catch(CancellationException v10_1) {
                goto label_117;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_97;
    label_117:
        ((TextDragObserver)v11).onCancel();
        throw v10_1;
    label_114:
        return Unit.INSTANCE;
    }

    static final Unit touchSelectionSubsequentPress$lambda$0(TextDragObserver arg2, PointerInputChange arg3) {
        arg2.onDrag-k-4lQ0M(PointerEventKt.positionChange(arg3));
        arg3.consume();
        return Unit.INSTANCE;
    }

    public static final Modifier updateSelectionTouchMode(Modifier arg2, Function1 arg3) {
        return SuspendingPointerInputFilterKt.pointerInput(arg2, Integer.valueOf(0x845FED), new SelectionGesturesKt$updateSelectionTouchMode$1(arg3));
    }
}

