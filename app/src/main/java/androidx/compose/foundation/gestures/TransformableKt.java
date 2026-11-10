package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A&\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u001A:\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u001A(\u0010\f\u001A\u00020\r*\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001A\u001A\u0010\u0015\u001A\u00020\t*\u00020\u00162\u0006\u0010\u0012\u001A\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001A\u001C\u0010\u0018\u001A\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0012\u001A\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001A<\u0010\u0019\u001A\u00020\r*\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u00052\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001B\"\u000E\u0010\n\u001A\u00020\u000BX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectZoomByCtrlMouseScroll", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstCtrlMouseScroll", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCtrlMouseScrollOrNull", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545f;

    public static final Object access$awaitCtrlMouseScrollOrNull(AwaitPointerEventScope arg0, ScrollConfig arg1, Continuation arg2) {
        return TransformableKt.awaitCtrlMouseScrollOrNull(arg0, arg1, arg2);
    }

    public static final Object access$awaitFirstCtrlMouseScroll(AwaitPointerEventScope arg0, ScrollConfig arg1, Continuation arg2) {
        return TransformableKt.awaitFirstCtrlMouseScroll(arg0, arg1, arg2);
    }

    public static final Object access$detectZoom(AwaitPointerEventScope arg0, boolean arg1, Channel arg2, Function1 arg3, Continuation arg4) {
        return TransformableKt.detectZoom(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Object access$detectZoomByCtrlMouseScroll(PointerInputScope arg0, Channel arg1, ScrollConfig arg2, Continuation arg3) {
        return TransformableKt.detectZoomByCtrlMouseScroll(arg0, arg1, arg2, arg3);
    }

    private static final Object awaitCtrlMouseScrollOrNull(AwaitPointerEventScope arg5, ScrollConfig arg6, Continuation arg7) {
        Object v5;
        Object v6;
        TransformableKt$awaitCtrlMouseScrollOrNull$1 v0_1;
        int v2;
        if((arg7 instanceof TransformableKt$awaitCtrlMouseScrollOrNull$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((TransformableKt$awaitCtrlMouseScrollOrNull$1)v0).label & v2) != 0) {
                ((TransformableKt$awaitCtrlMouseScrollOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TransformableKt$awaitCtrlMouseScrollOrNull$1(arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        PointerEventPass v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v0_1.L$0 = arg5;
            v0_1.L$1 = arg6;
            v0_1.label = 1;
            v7 = AwaitPointerEventScope.awaitPointerEvent$default(arg5, v3, ((Continuation)v0_1), 1, v3);
            if(v7 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v6 = v0_1.L$1;
            v5 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(PointerEvent_androidKt.isCtrlPressed-5xRPYO0(((PointerEvent)v7).getKeyboardModifiers-k7X9c1A())) {
            if(!PointerEventType.equals-impl0(((PointerEvent)v7).getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk())) {
            }
            else {
                long v5_1 = ((ScrollConfig)v6).calculateMouseWheelScroll-8xgXZGE(((AwaitPointerEventScope)v5), ((PointerEvent)v7), ((AwaitPointerEventScope)v5).getSize-YbymL2g());
                if(Offset.equals-impl0(v5_1, Offset.Companion.getZero-F1C5BW0())) {
                    return v3;
                }
                else {
                    List v7_1 = ((PointerEvent)v7).getChanges();
                    int v0_2 = v7_1.size();
                    int v1_1;
                    for(v1_1 = 0; v1_1 < v0_2; ++v1_1) {
                        v7_1.get(v1_1).consume();
                    }

                    return Offset.box-impl(v5_1);
                }
            }
        }

        return v3;
    }

    private static final Object awaitFirstCtrlMouseScroll(AwaitPointerEventScope arg5, ScrollConfig arg6, Continuation arg7) {
        Object v6;
        Object v5;
        int v2;
        Continuation v0;
        if((arg7 instanceof TransformableKt$awaitFirstCtrlMouseScroll$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).label & v2) != 0) {
                ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TransformableKt$awaitFirstCtrlMouseScroll$1 v0_1 = new TransformableKt$awaitFirstCtrlMouseScroll$1(arg7);
        }

        Object v7 = ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            goto label_31;
        label_37:
            if(v7 != null) {
                return v7;
            }
        }
        else if(v2 == 1) {
            v5 = ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).L$1;
            v6 = ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
            Object v4 = v6;
            v6 = v5;
            v5 = v4;
            goto label_37;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_31:
        ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).L$0 = v5;
        ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).L$1 = v6;
        ((TransformableKt$awaitFirstCtrlMouseScroll$1)v0).label = 1;
        v7 = TransformableKt.awaitCtrlMouseScrollOrNull(((AwaitPointerEventScope)v5), ((ScrollConfig)v6), v0);
        if(v7 != v1) {
            goto label_37;
        }

        return v1;
    }

    private static final Object detectZoom(AwaitPointerEventScope arg28, boolean arg29, Channel arg30, Function1 arg31, Continuation arg32) {
        Object v9_2;
        boolean v12_1;
        Object v16_1;
        float v16;
        Object v11;
        Object v10;
        Object v12;
        Object v13;
        float v8_1;
        float v7;
        long v14;
        int v6;
        float v4;
        boolean v10_1;
        float v9_3;
        long v6_1;
        int v4_1;
        float v3_1;
        Object v26;
        List v6_2;
        long v16_2;
        long v26_1;
        int v20;
        float v15_1;
        float v30;
        TransformableKt$detectZoom$1 v1_1;
        int v3;
        Continuation v0 = arg32;
        if((v0 instanceof TransformableKt$detectZoom$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((TransformableKt$detectZoom$1)v1).label & v3) != 0) {
                ((TransformableKt$detectZoom$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new TransformableKt$detectZoom$1(v0);
        }

        Continuation v5 = ((Continuation)v1_1);
        Object v0_1 = ((TransformableKt$detectZoom$1)v5).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((TransformableKt$detectZoom$1)v5).label;
        int v8 = 3;
        int v9 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            long v8_2 = Offset.Companion.getZero-F1C5BW0();
            float v0_2 = arg28.getViewConfiguration().getTouchSlop();
            ((TransformableKt$detectZoom$1)v5).L$0 = arg28;
            Channel v10_2 = arg30;
            ((TransformableKt$detectZoom$1)v5).L$1 = v10_2;
            Function1 v11_1 = arg31;
            ((TransformableKt$detectZoom$1)v5).L$2 = v11_1;
            v12_1 = arg29;
            ((TransformableKt$detectZoom$1)v5).Z$0 = v12_1;
            ((TransformableKt$detectZoom$1)v5).F$0 = 0f;
            ((TransformableKt$detectZoom$1)v5).F$1 = 1f;
            ((TransformableKt$detectZoom$1)v5).J$0 = v8_2;
            ((TransformableKt$detectZoom$1)v5).I$0 = 0;
            ((TransformableKt$detectZoom$1)v5).F$2 = v0_2;
            ((TransformableKt$detectZoom$1)v5).I$1 = 0;
            ((TransformableKt$detectZoom$1)v5).label = 1;
            if(TapGestureDetectorKt.awaitFirstDown$default(arg28, false, null, v5, 2, null) == v1_2) {
                return v1_2;
            }
            else {
                v3_1 = v0_2;
                v6_1 = v8_2;
                v2 = 0;
                v4_1 = 0;
                v8_1 = 1f;
                v9_3 = 0f;
                AwaitPointerEventScope v13_1 = arg28;
            label_126:
                ((TransformableKt$detectZoom$1)v5).L$0 = v13_1;
                ((TransformableKt$detectZoom$1)v5).L$1 = v10;
                ((TransformableKt$detectZoom$1)v5).L$2 = v11;
                ((TransformableKt$detectZoom$1)v5).L$3 = null;
                ((TransformableKt$detectZoom$1)v5).Z$0 = v12_1;
                ((TransformableKt$detectZoom$1)v5).F$0 = v9_3;
                ((TransformableKt$detectZoom$1)v5).F$1 = v8_1;
                ((TransformableKt$detectZoom$1)v5).J$0 = v6_1;
                ((TransformableKt$detectZoom$1)v5).I$0 = v4_1;
                ((TransformableKt$detectZoom$1)v5).F$2 = v3_1;
                ((TransformableKt$detectZoom$1)v5).I$1 = v2;
                ((TransformableKt$detectZoom$1)v5).label = 2;
                v0_1 = AwaitPointerEventScope.awaitPointerEvent$default(v13_1, null, v5, 1, null);
                if(v0_1 == v1_2) {
                    return v1_2;
                }
                else {
                    v26 = v13_1;
                    v13 = v11;
                    v11 = v26;
                label_147:
                    List v14_2 = ((PointerEvent)v0_1).getChanges();
                    int v15 = v14_2.size();
                    int v29 = v2;
                    v2 = 0;
                    while(true) {
                        if(v2 >= v15) {
                            break;
                        }
                        else if(v14_2.get(v2).isConsumed()) {
                            v2 = 1;
                        }
                        else {
                            ++v2;
                            continue;
                        }

                        goto label_161;
                    }

                    v2 = 0;
                label_161:
                    if(v2 == 0) {
                        float v21 = TransformGestureDetectorKt.calculateZoom(((PointerEvent)v0_1));
                        float v14_3 = TransformGestureDetectorKt.calculateRotation(((PointerEvent)v0_1));
                        v30 = v8_1;
                        float v31 = v9_3;
                        v8_2 = TransformGestureDetectorKt.calculatePan(((PointerEvent)v0_1));
                        if(v4_1 == 0) {
                            v15_1 = v30 * v21;
                            v16 = v31 + v14_3;
                            v6_1 = Offset.plus-MK-Hz9U(v6_1, v8_2);
                            v20 = v4_1;
                            float v17 = TransformGestureDetectorKt.calculateCentroidSize(((PointerEvent)v0_1), false);
                            float v22 = Math.abs(1f - v15_1) * v17;
                            v17 = Math.abs(3.141593f * v16 * v17 / 180f);
                            float v23 = Offset.getDistance-impl(v6_1);
                            if(v22 <= v3_1 && v17 <= v3_1 && (v23 <= v3_1 || !((Function1)v13).invoke(Offset.box-impl(v8_2)).booleanValue())) {
                                v26_1 = v6_1;
                                v7 = v16;
                                v16_2 = v26_1;
                                v4_1 = v29;
                                v6 = v20;
                                goto label_218;
                            }

                            v29 = !v12_1 || v17 >= v3_1 ? 0 : 1;
                            ((Channel)v10).trySend-JP2dKIU(TransformStarted.INSTANCE);
                            v26_1 = v6_1;
                            v7 = v16;
                            v16_2 = v26_1;
                            v4_1 = v29;
                            v6 = 1;
                        }
                        else {
                            v20 = v4_1;
                            v4_1 = v29;
                            v15_1 = v30;
                            v16_2 = v6_1;
                            v6 = v20;
                            v7 = v31;
                        }

                    label_218:
                        if(v6 != 0) {
                            float v24 = v4_1 != 0 ? 0f : v14_3;
                            if(v24 != 0f) {
                                v29 = v6;
                                v30 = v7;
                            label_244:
                                ((Channel)v10).trySend-JP2dKIU(new TransformDelta(v21, v8_2, v24, null));
                            }
                            else if(v21 == 1f) {
                                v29 = v6;
                                v30 = v7;
                                if(!Offset.equals-impl0(v8_2, Offset.Companion.getZero-F1C5BW0()) && (((Function1)v13).invoke(Offset.box-impl(v8_2)).booleanValue())) {
                                    goto label_244;
                                }
                            }
                            else {
                                v29 = v6;
                                v30 = v7;
                                goto label_244;
                            }

                            v6_2 = ((PointerEvent)v0_1).getChanges();
                            int v7_1 = v6_2.size();
                            v8 = 0;
                            goto label_254;
                        }
                        else {
                            v29 = v6;
                            v30 = v7;
                        }

                        goto label_265;
                    }
                    else {
                        v20 = v4_1;
                        v30 = v8_1;
                        ChannelResult.box-impl(((Channel)v10).trySend-JP2dKIU(TransformStopped.INSTANCE));
                        v4_1 = v29;
                        v8_1 = v9_3;
                        v14 = v6_1;
                        v6 = v20;
                        v7 = v30;
                        goto label_283;
                    label_254:
                        while(v8 < v7_1) {
                            v9_2 = v6_2.get(v8);
                            if(PointerEventKt.positionChanged(((PointerInputChange)v9_2))) {
                                ((PointerInputChange)v9_2).consume();
                            }

                            ++v8;
                        }

                    label_265:
                        v6 = v29;
                        v8_1 = v30;
                        v7 = v15_1;
                        v14 = v16_2;
                    }

                label_283:
                    PointerEventPass v9_4 = PointerEventPass.Final;
                    ((TransformableKt$detectZoom$1)v5).L$0 = v11;
                    ((TransformableKt$detectZoom$1)v5).L$1 = v10;
                    ((TransformableKt$detectZoom$1)v5).L$2 = v13;
                    ((TransformableKt$detectZoom$1)v5).L$3 = v0_1;
                    ((TransformableKt$detectZoom$1)v5).Z$0 = v12_1;
                    ((TransformableKt$detectZoom$1)v5).F$0 = v8_1;
                    ((TransformableKt$detectZoom$1)v5).F$1 = v7;
                    ((TransformableKt$detectZoom$1)v5).J$0 = v14;
                    ((TransformableKt$detectZoom$1)v5).I$0 = v6;
                    ((TransformableKt$detectZoom$1)v5).F$2 = v3_1;
                    ((TransformableKt$detectZoom$1)v5).I$1 = v4_1;
                    ((TransformableKt$detectZoom$1)v5).I$2 = v2;
                    Object v29_1 = v0_1;
                    ((TransformableKt$detectZoom$1)v5).label = 3;
                    v9_2 = ((AwaitPointerEventScope)v11).awaitPointerEvent(v9_4, v5);
                    if(v9_2 != v1_2) {
                        int v16_3 = v4_1;
                        v4 = v3_1;
                        v3 = v16_3;
                        v16 = v8_1;
                        v8_1 = v7;
                        v7 = v16;
                        v16_1 = v11;
                        v11 = v13;
                        v13 = v29_1;
                        goto label_311;
                    }

                    return v1_2;
                }
            }
        }
        else if(v2 == 1) {
            v2 = ((TransformableKt$detectZoom$1)v5).I$1;
            v3_1 = ((TransformableKt$detectZoom$1)v5).F$2;
            v4_1 = ((TransformableKt$detectZoom$1)v5).I$0;
            v6_1 = ((TransformableKt$detectZoom$1)v5).J$0;
            v8_1 = ((TransformableKt$detectZoom$1)v5).F$1;
            v9_3 = ((TransformableKt$detectZoom$1)v5).F$0;
            v10_1 = ((TransformableKt$detectZoom$1)v5).Z$0;
            v11 = ((TransformableKt$detectZoom$1)v5).L$2;
            v12 = ((TransformableKt$detectZoom$1)v5).L$1;
            v13 = ((TransformableKt$detectZoom$1)v5).L$0;
            ResultKt.throwOnFailure(v0_1);
            v26 = v12;
            v12_1 = v10_1;
            v10 = v26;
            goto label_126;
        }
        else if(v2 == v9) {
            v2 = ((TransformableKt$detectZoom$1)v5).I$1;
            v3_1 = ((TransformableKt$detectZoom$1)v5).F$2;
            v4_1 = ((TransformableKt$detectZoom$1)v5).I$0;
            v6_1 = ((TransformableKt$detectZoom$1)v5).J$0;
            v8_1 = ((TransformableKt$detectZoom$1)v5).F$1;
            v9_3 = ((TransformableKt$detectZoom$1)v5).F$0;
            v10_1 = ((TransformableKt$detectZoom$1)v5).Z$0;
            v11 = ((TransformableKt$detectZoom$1)v5).L$2;
            v12 = ((TransformableKt$detectZoom$1)v5).L$1;
            v13 = ((TransformableKt$detectZoom$1)v5).L$0;
            ResultKt.throwOnFailure(v0_1);
            Object v14_1 = v12;
            v12_1 = v10_1;
            v10 = v14_1;
            v14_1 = v13;
            v13 = v11;
            v11 = v14_1;
            goto label_147;
        }
        else if(v2 == v8) {
            v2 = ((TransformableKt$detectZoom$1)v5).I$2;
            v3 = ((TransformableKt$detectZoom$1)v5).I$1;
            v4 = ((TransformableKt$detectZoom$1)v5).F$2;
            v6 = ((TransformableKt$detectZoom$1)v5).I$0;
            v14 = ((TransformableKt$detectZoom$1)v5).J$0;
            v7 = ((TransformableKt$detectZoom$1)v5).F$1;
            v8_1 = ((TransformableKt$detectZoom$1)v5).F$0;
            boolean v9_1 = ((TransformableKt$detectZoom$1)v5).Z$0;
            v13 = ((TransformableKt$detectZoom$1)v5).L$3;
            v12 = ((TransformableKt$detectZoom$1)v5).L$2;
            v10 = ((TransformableKt$detectZoom$1)v5).L$1;
            v11 = ((TransformableKt$detectZoom$1)v5).L$0;
            ResultKt.throwOnFailure(v0_1);
            v16 = v8_1;
            v8_1 = v7;
            v7 = v16;
            v16_1 = v11;
            v11 = v12;
            v12_1 = v9_1;
            v9_2 = v0_1;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_311:
        List v9_5 = ((PointerEvent)v9_2).getChanges();
        int v0_3 = v9_5.size();
        Object v17_1 = v1_2;
        int v1_3 = 0;
        while(true) {
            if(v1_3 >= v0_3) {
                break;
            }
            else if(!v9_5.get(v1_3).isConsumed()) {
                ++v1_3;
                continue;
            }
            else if(v6 == 0) {
                v0_3 = 1;
            }
            else {
                break;
            }

            goto label_326;
        }

        v0_3 = 0;
    label_326:
        if(v2 == 0 && v0_3 == 0) {
            List v0_4 = ((PointerEvent)v13).getChanges();
            v1_3 = v0_4.size();
            v2 = 0;
            while(v2 < v1_3) {
                if(v0_4.get(v2).getPressed()) {
                    v2 = v3;
                    v3_1 = v4;
                    v4_1 = v6;
                    v9_3 = v7;
                    v6_1 = v14;
                    v13 = v16_1;
                    v1_2 = v17_1;
                    goto label_126;
                }
                else {
                    ++v2;
                    continue;
                }
            }
        }

        return Unit.INSTANCE;
    }

    private static final Object detectZoomByCtrlMouseScroll(PointerInputScope arg3, Channel arg4, ScrollConfig arg5, Continuation arg6) {
        Object v3 = arg3.awaitPointerEventScope(new TransformableKt$detectZoomByCtrlMouseScroll$2(arg6.getContext(), arg5, arg4, null), arg6);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public static final Modifier transformable(Modifier arg1, TransformableState arg2, Function1 arg3, boolean arg4, boolean arg5) {
        return arg1.then(new TransformableElement(arg2, arg3, arg4, arg5));
    }

    public static final Modifier transformable(Modifier arg1, TransformableState arg2, boolean arg3, boolean arg4) {
        return TransformableKt.transformable(arg1, arg2, new TransformableKt$$ExternalSyntheticLambda0(), arg3, arg4);
    }

    public static Modifier transformable$default(Modifier arg0, TransformableState arg1, Function1 arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        return TransformableKt.transformable(arg0, arg1, arg2, false, true);
    }

    public static Modifier transformable$default(Modifier arg0, TransformableState arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return TransformableKt.transformable(arg0, arg1, false, true);
    }

    static final boolean transformable$lambda$0(Offset arg0) {
        return 1;
    }
}

