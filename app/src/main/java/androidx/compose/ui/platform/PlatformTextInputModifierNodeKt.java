package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A;\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\'\u0010\u0003\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@¢\u0006\u0002\u0010\t\u001A(\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u000B0\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001AE\u0010\u0015\u001A\u00020\u0001*\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u00142\'\u0010\u0018\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0082@¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InterceptPlatformTextInput", "", "interceptor", "Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/PlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "LocalChainedPlatformTextInputInterceptor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;", "interceptedTextInputSession", "Landroidx/compose/ui/node/Owner;", "chainedInterceptor", "session", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/ChainedPlatformTextInputInterceptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal LocalChainedPlatformTextInputInterceptor;

    static {
        PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor = CompositionLocalKt.staticCompositionLocalOf(PlatformTextInputModifierNodeKt$LocalChainedPlatformTextInputInterceptor$1.INSTANCE);
    }

    public static final void InterceptPlatformTextInput(PlatformTextInputInterceptor arg5, Function2 arg6, Composer arg7, int arg8) {
        ChainedPlatformTextInputInterceptor v4_1;
        int v1_1;
        int v0 = 0x8F361FF1;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(InterceptPlatformTextInput)P(1)156@7639L7,162@8034L77,168@8332L136:PlatformTextInputModifierNode.kt#itgzvw");
        if((arg8 & 6) == 0) {
            boolean v1 = (arg8 & 8) == 0 ? arg7.changed(arg5) : arg7.changedInstance(arg5);
            v1_1 = v1 ? 4 : 2;
            v1_1 |= arg8;
        }
        else {
            v1_1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            int v2 = arg7.changedInstance(arg6) ? 0x20 : 16;
            v1_1 |= v2;
        }

        boolean v2_1 = (v1_1 & 19) != 18 ? true : false;
        if(arg7.shouldExecute(v2_1, v1_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.ui.platform.InterceptPlatformTextInput (PlatformTextInputModifierNode.kt:155)");
            }

            ProvidableCompositionLocal v0_1 = PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor;
            ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = arg7.consume(v0_1);
            ComposerKt.sourceInformationMarkerEnd(arg7);
            ComposerKt.sourceInformationMarkerStart(arg7, 0x9A2E2F9E, "CC(remember):PlatformTextInputModifierNode.kt#9igjgp");
            boolean v3 = arg7.changed(v2_2);
            Object v4 = arg7.rememberedValue();
            if((v3) || v4 == Composer.Companion.getEmpty()) {
                v4_1 = new ChainedPlatformTextInputInterceptor(arg5, ((ChainedPlatformTextInputInterceptor)v2_2));
                arg7.updateRememberedValue(v4_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            v4_1.updateInterceptor(arg5);
            CompositionLocalKt.CompositionLocalProvider(v0_1.provides(v4_1), arg6, arg7, v1_1 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_71;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_71:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new PlatformTextInputModifierNodeKt$InterceptPlatformTextInput$1(arg5, arg6, arg8));
        }
    }

    public static final Object access$interceptedTextInputSession(Owner arg0, ChainedPlatformTextInputInterceptor arg1, Function2 arg2, Continuation arg3) {
        return PlatformTextInputModifierNodeKt.interceptedTextInputSession(arg0, arg1, arg2, arg3);
    }

    public static final Object establishTextInputSession(PlatformTextInputModifierNode arg4, Function2 arg5, Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof PlatformTextInputModifierNodeKt$establishTextInputSession$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((PlatformTextInputModifierNodeKt$establishTextInputSession$1)v0).label & v2) != 0) {
                ((PlatformTextInputModifierNodeKt$establishTextInputSession$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PlatformTextInputModifierNodeKt$establishTextInputSession$1 v0_1 = new PlatformTextInputModifierNodeKt$establishTextInputSession$1(arg6);
        }

        Object v6 = ((PlatformTextInputModifierNodeKt$establishTextInputSession$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PlatformTextInputModifierNodeKt$establishTextInputSession$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            if(arg4.getNode().isAttached()) {
                Owner v6_1 = DelegatableNodeKt.requireOwner(((DelegatableNode)arg4));
                Object v4 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg4)).getCompositionLocalMap().get(PlatformTextInputModifierNodeKt.LocalChainedPlatformTextInputInterceptor);
                ((PlatformTextInputModifierNodeKt$establishTextInputSession$1)v0).label = 1;
                if(PlatformTextInputModifierNodeKt.interceptedTextInputSession(v6_1, ((ChainedPlatformTextInputInterceptor)v4), arg5, v0) == v1) {
                    return v1;
                }
            }
            else {
                goto label_41;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v6);
        }

        throw new KotlinNothingValueException();
    label_41:
        throw new IllegalArgumentException("establishTextInputSession called from an unattached node".toString());
    }

    private static final Object interceptedTextInputSession(Owner arg5, ChainedPlatformTextInputInterceptor arg6, Function2 arg7, Continuation arg8) {
        int v2;
        Continuation v0;
        if((arg8 instanceof PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).label & v2) != 0) {
                ((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PlatformTextInputModifierNodeKt$interceptedTextInputSession$1 v0_1 = new PlatformTextInputModifierNodeKt$interceptedTextInputSession$1(arg8);
        }

        Object v8 = ((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            if(arg6 == null) {
                ((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).label = 1;
                if(arg5.textInputSession(arg7, v0) == v1) {
                }
                else {
                label_35:
                    throw new KotlinNothingValueException();
                }
            }
            else {
                ((PlatformTextInputModifierNodeKt$interceptedTextInputSession$1)v0).label = v3;
                if(arg6.textInputSession(arg5, arg7, v0) == v1) {
                    return v1;
                }

                goto label_42;
            }

            return v1;
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v8);
            goto label_35;
        }
        else if(v2 != v3) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v8);
        }

    label_42:
        throw new KotlinNothingValueException();
    }
}

