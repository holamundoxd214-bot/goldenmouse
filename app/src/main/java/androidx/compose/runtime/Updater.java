package androidx.compose.runtime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JH\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2.\b\b\u0010\r\u001A(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0011H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013JI\u0010\t\u001A\u00020\n\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000B\u001A\u0002H\u00142,\u0010\r\u001A(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0015JH\u0010\u0016\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2.\b\b\u0010\r\u001A(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0011H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0013JI\u0010\u0016\u001A\u00020\n\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000B\u001A\u0002H\u00142,\u0010\r\u001A(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0017\u0010\u0015J&\u0010\u0018\u001A\u00020\n2\u0017\u0010\r\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0019¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u001A\u0010\u001BJ:\u0010\u0018\u001A\u00020\n\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000B\u001A\u0002H\u00142\u001D\u0010\r\u001A\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u001A\u0010\u0015J&\u0010\u001C\u001A\u00020\n2\u0017\u0010\r\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0019¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u001D\u0010\u001BJ\u0014\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010!\u001A\u00020\fHÖ\u0081\u0004J\n\u0010\"\u001A\u00020#HÖ\u0081\u0004R\u0016\u0010\u0003\u001A\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006$"}, d2={"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "set", "", "value", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "set-impl", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "V", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "update", "update-impl", "init", "Lkotlin/Function1;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class Updater {
    private final Composer composer;

    private Updater(Composer arg1) {
        super();
        this.composer = arg1;
    }

    public static final Updater box-impl(Composer arg1) {
        return new Updater(arg1);
    }

    public static Composer constructor-impl(Composer arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Updater.equals-impl(this.composer, arg1);
    }

    public static boolean equals-impl(Composer arg2, Object arg3) {
        if(!(arg3 instanceof Updater)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((Updater)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Composer arg0, Composer arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static void getComposer$annotations() {
    }

    public int hashCode() {
        return Updater.hashCode-impl(this.composer);
    }

    public static int hashCode-impl(Composer arg0) {
        return arg0.hashCode();
    }

    public static final void init-impl(Composer arg1, Object arg2, Function2 arg3) {
        if(arg1.getInserting()) {
            arg1.apply(arg2, arg3);
        }
    }

    public static final void init-impl(Composer arg2, Function1 arg3) {
        if(arg2.getInserting()) {
            arg2.apply(Unit.INSTANCE, new Updater$$ExternalSyntheticLambda0(arg3));
        }
    }

    static final Unit init_impl$lambda$0(Function1 arg0, Object arg1, Unit arg2) {
        arg0.invoke(arg1);
        return Unit.INSTANCE;
    }

    public static final void reconcile-impl(Composer arg2, Function1 arg3) {
        arg2.apply(Unit.INSTANCE, new Updater$$ExternalSyntheticLambda1(arg3));
    }

    static final Unit reconcile_impl$lambda$0(Function1 arg0, Object arg1, Unit arg2) {
        arg0.invoke(arg1);
        return Unit.INSTANCE;
    }

    public static final void set-impl(Composer arg1, Object arg2, Function2 arg3) {
        if(!arg1.getInserting()) {
            if(!Intrinsics.areEqual(arg1.rememberedValue(), arg2)) {
            }
            else {
                return;
            }
        }

        arg1.updateRememberedValue(arg2);
        arg1.apply(arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Boxes more than than the generic overload") public static final void set-impl(Composer arg2, int arg3, Function2 arg4) {
        if(!arg2.getInserting()) {
            if(!Intrinsics.areEqual(arg2.rememberedValue(), Integer.valueOf(arg3))) {
            }
            else {
                return;
            }
        }

        arg2.updateRememberedValue(Integer.valueOf(arg3));
        arg2.apply(Integer.valueOf(arg3), arg4);
    }

    public String toString() {
        return Updater.toString-impl(this.composer);
    }

    public static String toString-impl(Composer arg2) {
        return "Updater(composer=" + arg2 + ')';
    }

    public final Composer unbox-impl() {
        return this.composer;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Boxes more than the generic overload") public static final void update-impl(Composer arg3, int arg4, Function2 arg5) {
        boolean v0 = arg3.getInserting();
        if((v0) || !Intrinsics.areEqual(arg3.rememberedValue(), Integer.valueOf(arg4))) {
            arg3.updateRememberedValue(Integer.valueOf(arg4));
            if(!v0) {
                arg3.apply(Integer.valueOf(arg4), arg5);
            }
        }
    }

    public static final void update-impl(Composer arg2, Object arg3, Function2 arg4) {
        boolean v0 = arg2.getInserting();
        if((v0) || !Intrinsics.areEqual(arg2.rememberedValue(), arg3)) {
            arg2.updateRememberedValue(arg3);
            if(!v0) {
                arg2.apply(arg3, arg4);
            }
        }
    }
}

