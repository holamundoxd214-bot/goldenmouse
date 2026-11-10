package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001A+\u0010\u0000\u001A\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001A=\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0003\"\u0004\b\u0000\u0010\u00072\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0002\u0010\b\u001AO\u0010\u0000\u001A\u0019\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\u0003\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B2\u001D\u0010\u0004\u001A\u0019\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0002\u0010\f\u001Aa\u0010\u0000\u001A\u001F\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0002\b\u0003\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B\"\u0004\b\u0002\u0010\u000E2#\u0010\u0004\u001A\u001F\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0002\u0010\u000F\u001As\u0010\u0000\u001A%\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0002\b\u0003\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B\"\u0004\b\u0002\u0010\u000E\"\u0004\b\u0003\u0010\u00112)\u0010\u0004\u001A%\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001AG\u0010\u0013\u001A\u0018\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015\"\u0004\b\u0000\u0010\u00142\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\b\u001AY\u0010\u0013\u001A\u001E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00072\"\u0010\u0004\u001A\u001E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\f\u001Ak\u0010\u0013\u001A$\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000B2(\u0010\u0004\u001A$\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u000F\u001A}\u0010\u0013\u001A*\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000B\"\u0004\b\u0003\u0010\u000E2.\u0010\u0004\u001A*\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u000E\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0002\b\u0003¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0012\"\u000E\u0010\u0016\u001A\u00020\u0017X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"movableContentOf", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "P", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "P1", "P2", "(Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function4;", "Lkotlin/Function3;", "P3", "(Lkotlin/jvm/functions/Function5;)Lkotlin/jvm/functions/Function5;", "Lkotlin/Function4;", "P4", "(Lkotlin/jvm/functions/Function6;)Lkotlin/jvm/functions/Function6;", "movableContentWithReceiverOf", "R", "Lkotlin/ExtensionFunctionType;", "movableContentKey", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MovableContentKt {
    public static final int movableContentKey = 0x78CC281;

    public static final Function2 movableContentOf(Function2 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(-328108779, true, new MovableContentKt$$ExternalSyntheticLambda1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-703201834, true, new MovableContentKt$movableContentOf$movableContent$1(arg3)))));
    }

    public static final Function3 movableContentOf(Function3 arg2) {
        return ComposableLambdaKt.composableLambdaInstance(0x3D8E5091, true, new MovableContentKt$$ExternalSyntheticLambda4(new MovableContent(arg2)));
    }

    public static final Function4 movableContentOf(Function4 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0xE0A95410, true, new MovableContentKt$$ExternalSyntheticLambda6(new MovableContent(ComposableLambdaKt.composableLambdaInstance(0x21775197, true, new MovableContentKt$$ExternalSyntheticLambda5(arg3)))));
    }

    public static final Function5 movableContentOf(Function5 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0x580F207D, true, new MovableContentKt$$ExternalSyntheticLambda7(new MovableContent(ComposableLambdaKt.composableLambdaInstance(0xCD9148D5, true, new MovableContentKt$$ExternalSyntheticLambda0(arg3)))));
    }

    public static final Function6 movableContentOf(Function6 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(-1304803723, true, new MovableContentKt$$ExternalSyntheticLambda9(new MovableContent(ComposableLambdaKt.composableLambdaInstance(0x2C50A092, true, new MovableContentKt$$ExternalSyntheticLambda8(arg3)))));
    }

    static final Unit movableContentOf$lambda$0(MovableContent arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "C:MovableContent.kt#9igjgp");
        boolean v0 = (arg5 & 3) != 2 ? true : false;
        if(arg4.shouldExecute(v0, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328108779, arg5, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:40)");
            }

            arg4.insertMovableContent(arg3, null);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_24;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg4.skipToGroupEnd();
        }

    label_24:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$1(MovableContent arg3, Object arg4, Composer arg5, int arg6) {
        boolean v0;
        ComposerKt.sourceInformation(arg5, "CN(it):MovableContent.kt#9igjgp");
        if((arg6 & 6) == 0) {
            v0 = (arg6 & 8) == 0 ? arg5.changed(arg4) : arg5.changedInstance(arg4);
            int v0_1 = v0 ? 4 : 2;
            arg6 |= v0_1;
        }

        v0 = (arg6 & 19) != 18 ? true : false;
        if(arg5.shouldExecute(v0, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x3D8E5091, arg6, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:63)");
            }

            arg5.insertMovableContent(arg3, arg4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_35;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_35:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$2(Function4 arg4, Pair arg5, Composer arg6, int arg7) {
        boolean v0;
        ComposerKt.sourceInformation(arg6, "CN(it)87@3550L28:MovableContent.kt#9igjgp");
        if((arg7 & 6) == 0) {
            v0 = (arg7 & 8) == 0 ? arg6.changed(arg5) : arg6.changedInstance(arg5);
            int v0_1 = v0 ? 4 : 2;
            arg7 |= v0_1;
        }

        v0 = (arg7 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x21775197, arg7, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:87)");
            }

            arg4.invoke(arg5.getFirst(), arg5.getSecond(), arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_39;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_39:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$3(MovableContent arg3, Object arg4, Object arg5, Composer arg6, int arg7) {
        boolean v7;
        int v0_1;
        ComposerKt.sourceInformation(arg6, "CN(p1,p2):MovableContent.kt#9igjgp");
        if((arg7 & 6) == 0) {
            boolean v0 = (arg7 & 8) == 0 ? arg6.changed(arg4) : arg6.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg7;
        }
        else {
            v0_1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            v7 = (arg7 & 0x40) == 0 ? arg6.changed(arg5) : arg6.changedInstance(arg5);
            arg7 = v7 ? 0x20 : 16;
            v0_1 |= arg7;
        }

        v7 = (v0_1 & 0x93) != 0x92 ? true : false;
        if(arg6.shouldExecute(v7, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE0A95410, v0_1, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
            }

            arg6.insertMovableContent(arg3, TuplesKt.to(arg4, arg5));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_50:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$4(Function5 arg10, Triple arg11, Composer arg12, int arg13) {
        boolean v0;
        ComposerKt.sourceInformation(arg12, "CN(it)113@4607L38:MovableContent.kt#9igjgp");
        if((arg13 & 6) == 0) {
            v0 = (arg13 & 8) == 0 ? arg12.changed(arg11) : arg12.changedInstance(arg11);
            int v0_1 = v0 ? 4 : 2;
            arg13 |= v0_1;
        }

        v0 = (arg13 & 19) != 18 ? true : false;
        if(arg12.shouldExecute(v0, arg13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCD9148D5, arg13, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:113)");
            }

            arg10.invoke(arg11.getFirst(), arg11.getSecond(), arg11.getThird(), arg12, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_43;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_43:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$5(MovableContent arg3, Object arg4, Object arg5, Object arg6, Composer arg7, int arg8) {
        boolean v8;
        int v0_1;
        ComposerKt.sourceInformation(arg7, "CN(p1,p2,p3):MovableContent.kt#9igjgp");
        if((arg8 & 6) == 0) {
            boolean v0 = (arg8 & 8) == 0 ? arg7.changed(arg4) : arg7.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg8;
        }
        else {
            v0_1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            boolean v1 = (arg8 & 0x40) == 0 ? arg7.changed(arg5) : arg7.changedInstance(arg5);
            int v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg8 & 0x180) == 0) {
            v8 = (arg8 & 0x200) == 0 ? arg7.changed(arg6) : arg7.changedInstance(arg6);
            arg8 = v8 ? 0x100 : 0x80;
            v0_1 |= arg8;
        }

        v8 = (v0_1 & 0x493) != 1170 ? true : false;
        if(arg7.shouldExecute(v8, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x580F207D, v0_1, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:115)");
            }

            arg7.insertMovableContent(arg3, new Triple(arg4, arg5, arg6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_63;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_63:
        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$6(Function6 arg7, Object[] arg8, Composer arg9, int arg10) {
        ComposerKt.sourceInformation(arg9, "C143@5808L47:MovableContent.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x2C50A092, arg10, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:142)");
        }

        arg7.invoke(arg8[0], arg8[1], arg8[2], arg8[3], arg9, Integer.valueOf(0));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        return Unit.INSTANCE;
    }

    static final Unit movableContentOf$lambda$7(MovableContent arg3, Object arg4, Object arg5, Object arg6, Object arg7, Composer arg8, int arg9) {
        boolean v9;
        int v1_1;
        boolean v1;
        int v0_1;
        ComposerKt.sourceInformation(arg8, "CN(p1,p2,p3,p4):MovableContent.kt#9igjgp");
        if((arg9 & 6) == 0) {
            boolean v0 = (arg9 & 8) == 0 ? arg8.changed(arg4) : arg8.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg9;
        }
        else {
            v0_1 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            v1 = (arg9 & 0x40) == 0 ? arg8.changed(arg5) : arg8.changedInstance(arg5);
            v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg9 & 0x180) == 0) {
            v1 = (arg9 & 0x200) == 0 ? arg8.changed(arg6) : arg8.changedInstance(arg6);
            v1_1 = v1 ? 0x100 : 0x80;
            v0_1 |= v1_1;
        }

        if((arg9 & 0xC00) == 0) {
            v9 = (arg9 & 0x1000) == 0 ? arg8.changed(arg7) : arg8.changedInstance(arg7);
            arg9 = v9 ? 0x800 : 0x400;
            v0_1 |= arg9;
        }

        v9 = (v0_1 & 9363) != 9362 ? true : false;
        if(arg8.shouldExecute(v9, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304803723, v0_1, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
            }

            arg8.insertMovableContent(arg3, new Object[]{arg4, arg5, arg6, arg7});
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_74:
        return Unit.INSTANCE;
    }

    public static final Function3 movableContentWithReceiverOf(Function3 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0x9D568468, true, new MovableContentKt$$ExternalSyntheticLambda11(new MovableContent(ComposableLambdaKt.composableLambdaInstance(0x27D8C608, true, new MovableContentKt$$ExternalSyntheticLambda10(arg3)))));
    }

    public static final Function4 movableContentWithReceiverOf(Function4 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0x5070312C, true, new MovableContentKt$$ExternalSyntheticLambda13(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-95003188, true, new MovableContentKt$$ExternalSyntheticLambda12(arg3)))));
    }

    public static final Function5 movableContentWithReceiverOf(Function5 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0x7E740F2B, true, new MovableContentKt$$ExternalSyntheticLambda15(new MovableContent(ComposableLambdaKt.composableLambdaInstance(0xC68C1B0A, true, new MovableContentKt$$ExternalSyntheticLambda14(arg3)))));
    }

    public static final Function6 movableContentWithReceiverOf(Function6 arg3) {
        return ComposableLambdaKt.composableLambdaInstance(0x221D10D0, true, new MovableContentKt$$ExternalSyntheticLambda3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-346590649, true, new MovableContentKt$$ExternalSyntheticLambda2(arg3)))));
    }

    static final Unit movableContentWithReceiverOf$lambda$0(Function3 arg3, Object arg4, Composer arg5, int arg6) {
        boolean v0;
        ComposerKt.sourceInformation(arg5, "CN(it)171@6908L9:MovableContent.kt#9igjgp");
        if((arg6 & 6) == 0) {
            v0 = (arg6 & 8) == 0 ? arg5.changed(arg4) : arg5.changedInstance(arg4);
            int v0_1 = v0 ? 4 : 2;
            arg6 |= v0_1;
        }

        v0 = (arg6 & 19) != 18 ? true : false;
        if(arg5.shouldExecute(v0, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x27D8C608, arg6, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:171)");
            }

            arg3.invoke(arg4, arg5, Integer.valueOf(arg6 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_37;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_37:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$1(MovableContent arg3, Object arg4, Composer arg5, int arg6) {
        boolean v0;
        ComposerKt.sourceInformation(arg5, "C:MovableContent.kt#9igjgp");
        if((arg6 & 6) == 0) {
            v0 = (arg6 & 8) == 0 ? arg5.changed(arg4) : arg5.changedInstance(arg4);
            int v0_1 = v0 ? 4 : 2;
            arg6 |= v0_1;
        }

        v0 = (arg6 & 19) != 18 ? true : false;
        if(arg5.shouldExecute(v0, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x9D568468, arg6, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:172)");
            }

            arg5.insertMovableContent(arg3, arg4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_35;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_35:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$2(Function4 arg4, Pair arg5, Composer arg6, int arg7) {
        boolean v0;
        ComposerKt.sourceInformation(arg6, "CN(it)196@7934L18:MovableContent.kt#9igjgp");
        if((arg7 & 6) == 0) {
            v0 = (arg7 & 8) == 0 ? arg6.changed(arg5) : arg6.changedInstance(arg5);
            int v0_1 = v0 ? 4 : 2;
            arg7 |= v0_1;
        }

        v0 = (arg7 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-95003188, arg7, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:196)");
            }

            arg4.invoke(arg5.getFirst(), arg5.getSecond(), arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_39;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_39:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$3(MovableContent arg3, Object arg4, Object arg5, Composer arg6, int arg7) {
        boolean v7;
        int v0_1;
        ComposerKt.sourceInformation(arg6, "CN(it):MovableContent.kt#9igjgp");
        if((arg7 & 6) == 0) {
            boolean v0 = (arg7 & 8) == 0 ? arg6.changed(arg4) : arg6.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg7;
        }
        else {
            v0_1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            v7 = (arg7 & 0x40) == 0 ? arg6.changed(arg5) : arg6.changedInstance(arg5);
            arg7 = v7 ? 0x20 : 16;
            v0_1 |= arg7;
        }

        v7 = (v0_1 & 0x93) != 0x92 ? true : false;
        if(arg6.shouldExecute(v7, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x5070312C, v0_1, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:197)");
            }

            arg6.insertMovableContent(arg3, TuplesKt.to(arg4, arg5));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_50:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$4(Function5 arg10, Triple arg11, Composer arg12, int arg13) {
        boolean v0;
        ComposerKt.sourceInformation(arg12, "CN(it)221@8997L28:MovableContent.kt#9igjgp");
        if((arg13 & 6) == 0) {
            v0 = (arg13 & 8) == 0 ? arg12.changed(arg11) : arg12.changedInstance(arg11);
            int v0_1 = v0 ? 4 : 2;
            arg13 |= v0_1;
        }

        v0 = (arg13 & 19) != 18 ? true : false;
        if(arg12.shouldExecute(v0, arg13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xC68C1B0A, arg13, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:221)");
            }

            arg10.invoke(arg11.getFirst(), arg11.getSecond(), arg11.getThird(), arg12, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_43;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_43:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$5(MovableContent arg3, Object arg4, Object arg5, Object arg6, Composer arg7, int arg8) {
        boolean v8;
        int v0_1;
        ComposerKt.sourceInformation(arg7, "CN(p1,p2):MovableContent.kt#9igjgp");
        if((arg8 & 6) == 0) {
            boolean v0 = (arg8 & 8) == 0 ? arg7.changed(arg4) : arg7.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg8;
        }
        else {
            v0_1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            boolean v1 = (arg8 & 0x40) == 0 ? arg7.changed(arg5) : arg7.changedInstance(arg5);
            int v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg8 & 0x180) == 0) {
            v8 = (arg8 & 0x200) == 0 ? arg7.changed(arg6) : arg7.changedInstance(arg6);
            arg8 = v8 ? 0x100 : 0x80;
            v0_1 |= arg8;
        }

        v8 = (v0_1 & 0x493) != 1170 ? true : false;
        if(arg7.shouldExecute(v8, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7E740F2B, v0_1, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:222)");
            }

            arg7.insertMovableContent(arg3, new Triple(arg4, arg5, arg6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_63;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_63:
        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$6(Function6 arg7, Object[] arg8, Composer arg9, int arg10) {
        ComposerKt.sourceInformation(arg9, "C249@10205L37:MovableContent.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-346590649, arg10, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:248)");
        }

        arg7.invoke(arg8[0], arg8[1], arg8[2], arg8[3], arg9, Integer.valueOf(0));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        return Unit.INSTANCE;
    }

    static final Unit movableContentWithReceiverOf$lambda$7(MovableContent arg3, Object arg4, Object arg5, Object arg6, Object arg7, Composer arg8, int arg9) {
        boolean v9;
        int v1_1;
        boolean v1;
        int v0_1;
        ComposerKt.sourceInformation(arg8, "CN(p1,p2,p3):MovableContent.kt#9igjgp");
        if((arg9 & 6) == 0) {
            boolean v0 = (arg9 & 8) == 0 ? arg8.changed(arg4) : arg8.changedInstance(arg4);
            v0_1 = v0 ? 4 : 2;
            v0_1 |= arg9;
        }
        else {
            v0_1 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            v1 = (arg9 & 0x40) == 0 ? arg8.changed(arg5) : arg8.changedInstance(arg5);
            v1_1 = v1 ? 0x20 : 16;
            v0_1 |= v1_1;
        }

        if((arg9 & 0x180) == 0) {
            v1 = (arg9 & 0x200) == 0 ? arg8.changed(arg6) : arg8.changedInstance(arg6);
            v1_1 = v1 ? 0x100 : 0x80;
            v0_1 |= v1_1;
        }

        if((arg9 & 0xC00) == 0) {
            v9 = (arg9 & 0x1000) == 0 ? arg8.changed(arg7) : arg8.changedInstance(arg7);
            arg9 = v9 ? 0x800 : 0x400;
            v0_1 |= arg9;
        }

        v9 = (v0_1 & 9363) != 9362 ? true : false;
        if(arg8.shouldExecute(v9, v0_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x221D10D0, v0_1, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:252)");
            }

            arg8.insertMovableContent(arg3, new Object[]{arg4, arg5, arg6, arg7});
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_74:
        return Unit.INSTANCE;
    }
}

