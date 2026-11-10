package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0082\b\u001A\u0014\u0010\f\u001A\u00020\u0006*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0000\u001A2\u0010\u0010\u001A\u00020\b*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\"\u0010\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"TargetDistance", "Landroidx/compose/ui/unit/Dp;", "F", "BoundDistance", "MinimumDistance", "DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "isItemVisible", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "index", "", "animateScrollToItem", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutScrollScopeKt {
    private static final float BoundDistance = 0f;
    private static final boolean DEBUG = false;
    private static final float MinimumDistance;
    private static final float TargetDistance;

    static {
        LazyLayoutScrollScopeKt.TargetDistance = Dp.constructor-impl(2500f);
        LazyLayoutScrollScopeKt.BoundDistance = Dp.constructor-impl(1500f);
        LazyLayoutScrollScopeKt.MinimumDistance = Dp.constructor-impl(50f);
    }

    public static final Object animateScrollToItem(LazyLayoutScrollScope arg37, int arg38, int arg39, int arg40, Density arg41, Continuation arg42) {
        Object v3_2;
        int v0_1;
        Object v1_2;
        float v3_3;
        Continuation v5_2;
        int v26;
        float v23;
        Object v8;
        Object v7_1;
        Object v6;
        float v42;
        int v14;
        int v13;
        float v11;
        float v5_1;
        float v1_1;
        Continuation v21_1;
        float v26_1;
        IntRef v15_1;
        LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0 v16_1;
        Object v27;
        Object v21;
        int v18;
        Object v17_1;
        boolean v22;
        Float v12_2;
        FloatRef v20;
        float v19;
        LazyLayoutScrollScope v2_4;
        IntRef v24;
        int v25;
        int v8_1;
        ObjectRef v7_2;
        BooleanRef v6_1;
        float v0_3;
        float v2_3;
        int v2_2;
        int v5;
        Continuation v3;
        int v1 = arg38;
        Density v0 = arg41;
        Continuation v2 = arg42;
        if((v2 instanceof LazyLayoutScrollScopeKt$animateScrollToItem$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).label & v5) != 0) {
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).label -= v5;
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            LazyLayoutScrollScopeKt$animateScrollToItem$1 v3_1 = new LazyLayoutScrollScopeKt$animateScrollToItem$1(v2);
        }

        Object v2_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).label;
        int v7 = 2;
        int v9 = 0;
        int v10 = 1;
        if(v5 == 0) {
            v42 = 0f;
            ResultKt.throwOnFailure(v2_1);
            v2_2 = (((float)v1)) >= 0f ? 1 : 0;
            if(v2_2 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
            }

            try {
                v2_3 = v0.toPx-0680j_4(LazyLayoutScrollScopeKt.TargetDistance);
                v5_1 = v0.toPx-0680j_4(LazyLayoutScrollScopeKt.BoundDistance);
                v0_3 = v0.toPx-0680j_4(LazyLayoutScrollScopeKt.MinimumDistance);
                v6_1 = new BooleanRef();
                v6_1.element = true;
                v7_2 = new ObjectRef();
                v7_2.element = AnimationStateKt.AnimationState$default(0f, 0f, 0, 0, false, 30, null);
                if(LazyLayoutScrollScopeKt.isItemVisible(arg37, arg38)) {
                    goto label_256;
                }
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_268;
            }

            try {
                v8_1 = v1 > arg37.getFirstVisibleItemIndex() ? 1 : 0;
                IntRef v11_1 = new IntRef();
                v11_1.element = 1;
                v26 = arg39;
                v25 = arg40;
                v23 = v5_1;
                v24 = v11_1;
                v11 = v2_3;
                v5_2 = v3;
                v3_3 = v0_3;
                v2_2 = v1;
                v0_1 = v8_1;
                LazyLayoutScrollScope v1_3 = arg37;
                goto label_113;
            }
            catch(ItemFoundInScroll v0_2) {
                v2_4 = arg37;
                v9 = arg39;
                v14 = v1;
                goto label_249;
            }

        label_256:
            v2_4 = arg37;
            v5 = 0;
            v8_1 = 2;
            Object v12_1 = null;
            try {
                throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(v2_4, v1, 0, v8_1, v12_1), v7_2.element);
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_270;
            }

        label_268:
            v2_4 = arg37;
            v5 = 0;
        label_270:
            v9 = arg39;
            v14 = v1;
            goto label_272;
        label_317:
            ((LazyLayoutScrollScope)v3_2).snapToItem(v1, v0_1);
        label_318:
            return Unit.INSTANCE;
        label_272:
            AnimationState v16 = AnimationStateKt.copy$default(v0_2.getPreviousAnimation(), 0f, 0f, 0, 0, false, 30, null);
            v0_3 = ((float)(v0_2.getItemOffset() + v9));
            FloatRef v1_4 = new FloatRef();
            Float v17 = Boxing.boxFloat(v0_3);
            v25 = v16.getVelocity().floatValue() == v42 ? 1 : v5;
            LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1 v5_3 = new LazyLayoutScrollScopeKt$$ExternalSyntheticLambda1(v0_3, v1_4, v2_4);
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).L$0 = v2_4;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).L$1 = null;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).L$2 = null;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).L$3 = null;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).I$0 = v14;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).I$1 = v9;
            ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3_3).label = 2;
            if(SuspendAnimationKt.animateTo$default(v16, v17, null, v25 ^ 1, v5_3, ((Continuation)v3_3), 2, null) != v4) {
                v3_2 = v2_4;
                v0_1 = v9;
                v1 = v14;
                goto label_317;
            }

            return v4;
        label_249:
            v5 = 0;
            goto label_272;
            try {
            label_113:
                if(!v6_1.element) {
                    goto label_318;
                }

                if(((LazyLayoutScrollScope)v1_2).getItemCount() <= 0) {
                    goto label_318;
                }

                v13 = LazyLayoutScrollScope.calculateDistanceTo$default(((LazyLayoutScrollScope)v1_2), v2_2, v9, 2, null) + v26;
                if((((float)Math.abs(v13))) < v11) {
                }
                else {
                    goto label_137;
                }
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_244;
            }

            float v8_2 = ((float)v13);
            try {
                v8_2 = Math.max(Math.abs(v8_2), v3_3);
                if(v0_1 != 0) {
                }
                else {
                    goto label_129;
                }
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_132;
            }

            goto label_141;
        label_129:
            v8_2 = -v8_2;
            goto label_141;
        label_132:
            v14 = v2_2;
            v3 = v5_2;
            v5 = v9;
            v9 = v26;
            goto label_230;
        label_137:
            if(v0_1 != 0) {
                v19 = v11;
            }
            else {
                v8_2 = -v11;
            label_141:
                v19 = v8_2;
            }

            try {
                v7_2.element = AnimationStateKt.copy$default(v7_2.element, 0f, 0f, 0, 0, false, 30, null);
                v20 = new FloatRef();
                v8 = v7_2.element;
                v12_2 = Boxing.boxFloat(v19);
                v13 = v7_2.element.getVelocity().floatValue() == v42 ? v10 : v9;
                v13 ^= v10;
                v22 = v0_1 != 0 ? ((boolean)v10) : ((boolean)v9);
                v17_1 = v1_2;
                v18 = v2_2;
                v21 = v6_1;
                v27 = v7_2;
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_244;
            }

            try {
                v16_1 = new LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0(((LazyLayoutScrollScope)v17_1), v18, v19, v20, ((BooleanRef)v21), v22, v23, v24, v25, v26, ((ObjectRef)v27));
                v2_1 = v17_1;
                v14 = v18;
                v7_1 = v21;
                v1_1 = v23;
                v15_1 = v24;
                v10 = v25;
                v9 = v26;
                v6 = v27;
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_238;
            }

            try {
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).L$0 = v2_1;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).L$1 = v7_1;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).L$2 = v6;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).L$3 = v15_1;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).I$0 = v14;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).I$1 = v9;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).I$2 = v10;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).F$0 = v11;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).F$1 = v1_1;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).F$2 = v3_3;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).I$3 = v0_1;
                v26_1 = v1_1;
                ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v5_2).label = 1;
                AnimationSpec v18_1 = null;
                int v22_1 = 2;
                Object v23_1 = null;
                v21_1 = v5_2;
                v17 = v12_2;
                int v19_1 = v13;
                LazyLayoutScrollScopeKt$$ExternalSyntheticLambda0 v20_1 = v16_1;
                Object v16_2 = v8;
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_235;
            }

            try {
                if(SuspendAnimationKt.animateTo$default(((AnimationState)v16_2), v17, v18_1, ((boolean)v19_1), ((Function1)v20_1), v21_1, v22_1, v23_1) != v4) {
                    goto label_208;
                }
            }
            catch(ItemFoundInScroll v0_2) {
                goto label_233;
            }

            return v4;
        label_208:
            v1_2 = v7_1;
            v7_1 = v6;
            v6 = v1_2;
            v1_2 = v2_1;
            v5_2 = v21_1;
            v23 = v26_1;
            v26 = v9;
            goto label_56;
        label_233:
            goto label_248;
        label_235:
            v21_1 = v5_2;
            goto label_248;
        label_238:
            v21_1 = v5_2;
            v2_1 = v17_1;
            v14 = v18;
            v9 = v26;
            goto label_248;
        label_244:
            v14 = v2_2;
            v21_1 = v5_2;
            v9 = v26;
            v2_1 = v1_2;
        label_248:
            v3 = v21_1;
            goto label_249;
        label_230:
            v2_1 = v1_2;
            goto label_272;
        }
        else if(v5 == 1) {
            v0_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$3;
            v1_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).F$2;
            v5_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).F$1;
            v11 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).F$0;
            int v12 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$2;
            v13 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$1;
            v14 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$0;
            Object v15 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).L$3;
            v42 = 0f;
            v6 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).L$2;
            v7_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).L$1;
            v8 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).L$0;
            try {
                ResultKt.throwOnFailure(v2_1);
                v2_1 = v7_1;
                v7_1 = v6;
                v6 = v2_1;
                v23 = v5_1;
                v10 = v12;
                v26 = v13;
                v5_2 = v3;
                v3_3 = v1_1;
                v1_2 = v8;
            }
            catch(ItemFoundInScroll v0_2) {
                v2_1 = v8;
                v5 = 0;
                v9 = v13;
                goto label_272;
            }
        }
        else if(v5 == v7) {
            v0_1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$1;
            v1 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).I$0;
            v3_2 = ((LazyLayoutScrollScopeKt$animateScrollToItem$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            goto label_317;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_56:
        v2_2 = v14;
        try {
            ++v15_1.element;
            v25 = v10;
            Object v24_1 = v15_1;
            v9 = 0;
            v10 = 1;
            goto label_113;
        }
        catch(ItemFoundInScroll v0_2) {
            v14 = v2_2;
            v3 = v5_2;
            v9 = v26;
            v5 = 0;
            goto label_230;
        }
    }

    private static final boolean animateScrollToItem$isOvershot(boolean arg2, LazyLayoutScrollScope arg3, int arg4, int arg5) {
        if(arg2) {
            if(arg3.getFirstVisibleItemIndex() > arg4) {
                return 1;
            }

            if(arg3.getFirstVisibleItemIndex() == arg4 && arg3.getFirstVisibleItemScrollOffset() > arg5) {
                return 1;
            }

            return 0;
        }

        if(arg3.getFirstVisibleItemIndex() < arg4) {
            return 1;
        }

        if(arg3.getFirstVisibleItemIndex() == arg4 && arg3.getFirstVisibleItemScrollOffset() < arg5) {
            return 1;
        }

        return 0;
    }

    static final Unit animateScrollToItem$lambda$5(LazyLayoutScrollScope arg4, int arg5, float arg6, FloatRef arg7, BooleanRef arg8, boolean arg9, float arg10, IntRef arg11, int arg12, int arg13, ObjectRef arg14, AnimationScope arg15) {
        int v1 = 2;
        if(!LazyLayoutScrollScopeKt.isItemVisible(arg4, arg5)) {
            arg6 = arg6 > 0f ? RangesKt.coerceAtMost(arg15.getValue().floatValue(), arg6) : RangesKt.coerceAtLeast(arg15.getValue().floatValue(), arg6);
            arg6 -= arg7.element;
            float v0 = arg4.scrollBy(arg6);
            if(LazyLayoutScrollScopeKt.isItemVisible(arg4, arg5)) {
                goto label_57;
            }

            if(LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(arg9, arg4, arg5, arg13)) {
                goto label_57;
            }

            if(arg6 == v0) {
                arg7.element += arg6;
                if(arg9) {
                    if(arg15.getValue().floatValue() > arg10) {
                        arg15.cancelAnimation();
                    }
                }
                else if(arg15.getValue().floatValue() < -arg10) {
                    arg15.cancelAnimation();
                }

                if(arg9) {
                    if(arg11.element < v1) {
                        goto label_57;
                    }

                    if(arg5 - arg4.getLastVisibleItemIndex() <= arg12) {
                        goto label_57;
                    }

                    arg4.snapToItem(arg5 - arg12, 0);
                    goto label_57;
                }

                if(arg11.element < v1) {
                    goto label_57;
                }

                if(arg4.getFirstVisibleItemIndex() - arg5 <= arg12) {
                    goto label_57;
                }

                arg4.snapToItem(arg12 + arg5, 0);
                goto label_57;
            }

            arg15.cancelAnimation();
            arg8.element = false;
            return Unit.INSTANCE;
        }

    label_57:
        if(LazyLayoutScrollScopeKt.animateScrollToItem$isOvershot(arg9, arg4, arg5, arg13)) {
            arg4.snapToItem(arg5, arg13);
            arg8.element = false;
            arg15.cancelAnimation();
            return Unit.INSTANCE;
        }

        if(!LazyLayoutScrollScopeKt.isItemVisible(arg4, arg5)) {
            return Unit.INSTANCE;
        }

        throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(arg4, arg5, 0, v1, null), arg14.element);
    }

    static final Unit animateScrollToItem$lambda$7(float arg2, FloatRef arg3, LazyLayoutScrollScope arg4, AnimationScope arg5) {
        float v0 = 0f;
        if(arg2 > 0f) {
            v0 = RangesKt.coerceAtMost(arg5.getValue().floatValue(), arg2);
        }
        else if(arg2 < 0f) {
            v0 = RangesKt.coerceAtLeast(arg5.getValue().floatValue(), arg2);
        }

        arg2 = v0 - arg3.element;
        if(arg2 != arg4.scrollBy(arg2) || v0 != arg5.getValue().floatValue()) {
            arg5.cancelAnimation();
        }
        else {
        }

        arg3.element += arg2;
        return Unit.INSTANCE;
    }

    private static final void debugLog(Function0 arg0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope arg2, int arg3) {
        int v0 = arg2.getFirstVisibleItemIndex();
        if(arg3 <= arg2.getLastVisibleItemIndex() && v0 <= arg3) {
            return 1;
        }

        return 0;
    }
}

