package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A^\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u000626\u0010\u0007\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\bH\u0080@¢\u0006\u0004\b\u000F\u0010\u0010\u001AT\u0010\u0011\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000E0\b2\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H\u0082H¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u001B\u0010\u0017\u001A\u00020\u0018*\u00020\u00192\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u001B\u0010!\u001A\u00020\f*\u00020\"2\u0006\u0010\u0005\u001A\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001E\"\u0010\u0010\u001F\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001E\"\u000E\u0010 \u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float v0 = Dp.constructor-impl(0.125f);
        DragGestureDetectorCopyKt.mouseSlop = v0;
        float v1 = Dp.constructor-impl(18f);
        DragGestureDetectorCopyKt.defaultTouchSlop = v1;
        DragGestureDetectorCopyKt.mouseToTouchSlopRatio = v0 / v1;
    }

    public static final Object awaitHorizontalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope arg20, long arg21, int arg23, Function2 arg24, Continuation arg25) {
        Object v1_1;
        float v3_2;
        Continuation v10_1;
        Object v0_2;
        Object v18;
        float v2_2;
        Object v11;
        Object v10;
        Object v5_1;
        float v1;
        float v0_1;
        float v5_2;
        int v14;
        List v2_3;
        Object v16;
        int v5;
        Continuation v3;
        long v0 = arg21;
        Continuation v2 = arg25;
        if((v2 instanceof DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 v3_1 = new DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label;
        int v7 = 2;
        int v8 = 1;
        Object v9 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(DragGestureDetectorCopyKt.isPointerUp-DmW0f2w(arg20.getCurrentEvent(), v0)) {
                return v9;
            }
            else {
                v2_2 = DragGestureDetectorCopyKt.pointerSlop-E8SPZFQ(arg20.getViewConfiguration(), arg23);
                LongRef v5_3 = new LongRef();
                v5_3.element = v0;
                AwaitPointerEventScope v0_3 = arg20;
                Function2 v1_2 = arg24;
                LongRef v10_2 = v5_3;
                Continuation v5_4 = v3;
                v3_2 = v2_2;
                v2_2 = 0f;
            label_76:
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).L$0 = v1_2;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).L$1 = v0_2;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).L$2 = v10_2;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).L$3 = v9;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).F$0 = v3_2;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).F$1 = v2_2;
                ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v5_4).label = v8;
                v11 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v0_2), ((PointerEventPass)v9), v5_4, v8, v9);
                if(v11 == v4) {
                    return v4;
                }
                else {
                    float v19_2 = v3_2;
                    v3_2 = v2_2;
                    v2_1 = v11;
                    LongRef v11_1 = v10_2;
                    v10_1 = v5_4;
                    v5_2 = v19_2;
                    goto label_92;
                    return v4;
                label_92:
                    List v12_1 = ((PointerEvent)v2_1).getChanges();
                    int v13 = v12_1.size();
                    int v15 = 0;
                    while(true) {
                        if(v15 < v13) {
                            v16 = v12_1.get(v15);
                            v18 = v9;
                            int v17 = v15;
                            if(PointerId.equals-impl0(v16.getId-J3iCeTQ(), v11_1.element)) {
                            }
                            else {
                                v15 = v17 + 1;
                                v9 = v18;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_112;
                    }

                    v18 = v9;
                    v16 = v18;
                label_112:
                    Intrinsics.checkNotNull(v16);
                    Object v8_1 = v16;
                    if(((PointerInputChange)v8_1).isConsumed()) {
                        return v18;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v8_1))) {
                        v2_3 = ((PointerEvent)v2_1).getChanges();
                        v8 = v2_3.size();
                        v14 = 0;
                        goto label_123;
                    }

                    v2_2 = v3_2 + (Float.intBitsToFloat(((int)(((PointerInputChange)v8_1).getPosition-F1C5BW0() >> 0x20))) - Float.intBitsToFloat(((int)(((PointerInputChange)v8_1).getPreviousPosition-F1C5BW0() >> 0x20))));
                    if(Math.abs(v2_2) < v5_2) {
                        PointerEventPass v3_3 = PointerEventPass.Final;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).L$0 = v1_2;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).L$1 = v0_2;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).L$2 = v11_1;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).L$3 = v8_1;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).F$0 = v5_2;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).F$1 = v2_2;
                        ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v10_1).label = v7;
                        if(((AwaitPointerEventScope)v0_2).awaitPointerEvent(v3_3, v10_1) == v4) {
                            return v4;
                        }

                        v3_2 = v5_2;
                        v5_1 = v8_1;
                        goto label_165;
                    }

                    v1_2.invoke(v8_1, Boxing.boxFloat(v2_2 - Math.signum(v2_2) * v5_2));
                    if(((PointerInputChange)v8_1).isConsumed()) {
                        return v8_1;
                    }

                    v3_2 = v5_2;
                    v2_2 = 0f;
                    goto label_168;
                    while(true) {
                    label_123:
                        if(v14 < v8) {
                            v9 = v2_3.get(v14);
                            if(v9.getPressed()) {
                            }
                            else {
                                ++v14;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_132;
                    }

                    v9 = v18;
                label_132:
                    if(v9 == null) {
                        return v18;
                    }

                    v11_1.element = ((PointerInputChange)v9).getId-J3iCeTQ();
                    v2_2 = v3_2;
                    v3_2 = v5_2;
                label_168:
                    v5_4 = v10_1;
                    v10 = v11_1;
                    v9 = v18;
                    v8 = 1;
                    goto label_76;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$1;
            v1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0;
            v5_1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2;
            v10 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1;
            v11 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            Continuation v19 = v3;
            v3_2 = v0_1;
            v0_2 = v10;
            v10_1 = v19;
            Object v19_1 = v5_1;
            v5_2 = v1;
            v1_1 = v11;
            v11 = v19_1;
            goto label_92;
        }
        else if(v5 == v7) {
            v0_1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$1;
            v1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0;
            v5_1 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$3;
            v10 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2;
            v11 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1;
            Object v12 = ((DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_2 = v0_1;
            v18 = v9;
            v0_2 = v11;
            v11 = v10;
            v10_1 = v3;
            v3_2 = v1;
            v1_1 = v12;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_165:
        if(!((PointerInputChange)v5_1).isConsumed()) {
            goto label_168;
        }

        return v18;
    }

    private static final Object awaitPointerSlopOrCancellation-pn7EDYM(AwaitPointerEventScope arg16, long arg17, int arg19, Function2 arg20, Function1 arg21, Continuation arg22) {
        float v1_2;
        List v1_1;
        float v18;
        Object v13;
        AwaitPointerEventScope v0 = arg16;
        long v1 = arg17;
        Function1 v3 = arg21;
        Continuation v4 = arg22;
        Object v6 = null;
        if(DragGestureDetectorCopyKt.isPointerUp-DmW0f2w(v0.getCurrentEvent(), v1)) {
            return v6;
        }

        float v5 = DragGestureDetectorCopyKt.pointerSlop-E8SPZFQ(v0.getViewConfiguration(), arg19);
        LongRef v7 = new LongRef();
        v7.element = v1;
        float v2;
        for(v2 = 0f; true; v2 = v1_2) {
            Object v8 = AwaitPointerEventScope.awaitPointerEvent$default(v0, ((PointerEventPass)v6), v4, 1, v6);
            List v9 = ((PointerEvent)v8).getChanges();
            int v10 = v9.size();
            int v11 = 0;
            int v12 = 0;
            while(true) {
                if(v12 < v10) {
                    v13 = v9.get(v12);
                    v18 = v2;
                    if(Boolean.valueOf(PointerId.equals-impl0(v13.getId-J3iCeTQ(), v7.element)).booleanValue()) {
                    }
                    else {
                        ++v12;
                        v2 = v18;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_40;
            }

            v18 = v2;
            v13 = v6;
        label_40:
            Intrinsics.checkNotNull(v13);
            if(((PointerInputChange)v13).isConsumed()) {
                return v6;
            }

            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v13))) {
                v1_1 = ((PointerEvent)v8).getChanges();
                int v2_1 = v1_1.size();
                goto label_49;
            }
            else {
                v2 = v18 + (v3.invoke(Offset.box-impl(((PointerInputChange)v13).getPosition-F1C5BW0())).floatValue() - v3.invoke(Offset.box-impl(((PointerInputChange)v13).getPreviousPosition-F1C5BW0())).floatValue());
                if(Math.abs(v2) < v5) {
                    v0.awaitPointerEvent(PointerEventPass.Final, v4);
                    if(((PointerInputChange)v13).isConsumed()) {
                        return v6;
                    }
                    else {
                        v1_2 = v2;
                    }
                }
                else {
                    arg20.invoke(v13, Float.valueOf(v2 - Math.signum(v2) * v5));
                    if(((PointerInputChange)v13).isConsumed()) {
                        return v13;
                    }
                    else {
                        v1_2 = 0f;
                        goto label_97;
                        while(true) {
                        label_49:
                            if(v11 < v2_1) {
                                v8 = v1_1.get(v11);
                                if(Boolean.valueOf(v8.getPressed()).booleanValue()) {
                                }
                                else {
                                    ++v11;
                                    continue;
                                }
                            }
                            else {
                                break;
                            }

                            goto label_61;
                        }

                        v8 = v6;
                    label_61:
                        if(v8 == null) {
                            return v6;
                        }

                        v7.element = ((PointerInputChange)v8).getId-J3iCeTQ();
                        v1_2 = v18;
                    }
                }
            }

        label_97:
        }
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent arg6, long arg7) {
        Object v3;
        List v6 = arg6.getChanges();
        int v0 = v6.size();
        int v1 = 0;
        int v2 = 0;
        while(true) {
            if(v2 < v0) {
                v3 = v6.get(v2);
                if(PointerId.equals-impl0(v3.getId-J3iCeTQ(), arg7)) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_15;
        }

        v3 = null;
    label_15:
        if(v3 != null && (((PointerInputChange)v3).getPressed())) {
            v1 = 1;
        }

        return 1 ^ v1;
    }

    public static final float pointerSlop-E8SPZFQ(ViewConfiguration arg1, int arg2) {
        if(PointerType.equals-impl0(arg2, PointerType.Companion.getMouse-T8wyACA())) {
            return arg1.getTouchSlop() * DragGestureDetectorCopyKt.mouseToTouchSlopRatio;
        }

        return arg1.getTouchSlop();
    }
}

