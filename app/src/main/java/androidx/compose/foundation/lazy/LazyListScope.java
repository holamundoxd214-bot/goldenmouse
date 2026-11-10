package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@LazyScopeMarker @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JC\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u000BJ7\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\fJ\u0096\u0001\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2%\b\u0002\u0010\u0004\u001A\u001F\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000721\u0010\u0013\u001A-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u0015Jo\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2%\b\u0002\u0010\u0004\u001A\u001F\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000721\u0010\u0013\u001A-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\u0016JC\u0010\u0017\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0017¢\u0006\u0002\u0010\u000BJI\u0010\u0017\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00012\"\u0010\u0006\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0016¢\u0006\u0002\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2={"Landroidx/compose/foundation/lazy/LazyListScope;", "", "item", "", "key", "contentType", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyListScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void item(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3) {
            arg0.item(arg1, arg2, arg3);
        }

        @Deprecated @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static void item(LazyListScope arg0, Object arg1, Function3 arg2) {
            arg0.item(arg1, arg2);
        }

        public static void item$default(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3, int arg4, Object arg5) {
            LazyListScope.item$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }

        public static void item$default(LazyListScope arg0, Object arg1, Function3 arg2, int arg3, Object arg4) {
            LazyListScope.item$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static void items(LazyListScope arg0, int arg1, Function1 arg2, Function1 arg3, Function4 arg4) {
            arg0.items(arg1, arg2, arg3, arg4);
        }

        @Deprecated @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static void items(LazyListScope arg0, int arg1, Function1 arg2, Function4 arg3) {
            arg0.items(arg1, arg2, arg3);
        }

        public static void items$default(LazyListScope arg0, int arg1, Function1 arg2, Function1 arg3, Function4 arg4, int arg5, Object arg6) {
            LazyListScope.items$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static void items$default(LazyListScope arg0, int arg1, Function1 arg2, Function4 arg3, int arg4, Object arg5) {
            LazyListScope.items$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }

        @Deprecated @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the overload with indexing capabilities.", replaceWith="<_subannotation>") public static void stickyHeader(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3) {
            arg0.stickyHeader(arg1, arg2, arg3);
        }

        @Deprecated public static void stickyHeader(LazyListScope arg0, Object arg1, Object arg2, Function4 arg3) {
            arg0.stickyHeader(arg1, arg2, arg3);
        }

        public static void stickyHeader$default(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3, int arg4, Object arg5) {
            LazyListScope.stickyHeader$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }

        public static void stickyHeader$default(LazyListScope arg0, Object arg1, Object arg2, Function4 arg3, int arg4, Object arg5) {
            LazyListScope.stickyHeader$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }
    }

    static void access$item$jd(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3) {
        super.item(arg1, arg2, arg3);
    }

    static void access$item$jd(LazyListScope arg0, Object arg1, Function3 arg2) {
        super.item(arg1, arg2);
    }

    static void access$items$jd(LazyListScope arg0, int arg1, Function1 arg2, Function1 arg3, Function4 arg4) {
        super.items(arg1, arg2, arg3, arg4);
    }

    static void access$items$jd(LazyListScope arg0, int arg1, Function1 arg2, Function4 arg3) {
        super.items(arg1, arg2, arg3);
    }

    static void access$stickyHeader$jd(LazyListScope arg0, Object arg1, Object arg2, Function3 arg3) {
        super.stickyHeader(arg1, arg2, arg3);
    }

    static void access$stickyHeader$jd(LazyListScope arg0, Object arg1, Object arg2, Function4 arg3) {
        super.stickyHeader(arg1, arg2, arg3);
    }

    default void item(Object arg1, Object arg2, Function3 arg3) {
        throw new IllegalStateException("The method is not implemented".toString());
    }

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") default void item(Object arg2, Function3 arg3) {
        this.item(arg2, null, arg3);
    }

    static void item$default(LazyListScope arg1, Object arg2, Object arg3, Function3 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            Object v0 = null;
            if((arg5 & 1) != 0) {
                arg2 = v0;
            }

            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            arg1.item(arg2, arg3, arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
    }

    static void item$default(LazyListScope arg0, Object arg1, Function3 arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = null;
            }

            arg0.item(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
    }

    default void items(int arg1, Function1 arg2, Function1 arg3, Function4 arg4) {
        throw new IllegalStateException("The method is not implemented".toString());
    }

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") default void items(int arg2, Function1 arg3, Function4 arg4) {
        this.items(arg2, arg3, new LazyListScope$$ExternalSyntheticLambda1(), arg4);
    }

    static void items$default(LazyListScope arg0, int arg1, Function1 arg2, Function1 arg3, Function4 arg4, int arg5, Object arg6) {
        LazyListScope$items$1 v3;
        if(arg6 == null) {
            if((arg5 & 2) != 0) {
                arg2 = null;
            }

            if((arg5 & 4) != 0) {
                v3 = LazyListScope$items$1.INSTANCE;
            }

            arg0.items(arg1, arg2, ((Function1)v3), arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
    }

    static void items$default(LazyListScope arg0, int arg1, Function1 arg2, Function4 arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = null;
            }

            arg0.items(arg1, arg2, arg3);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
    }

    static Object items$lambda$0(int arg0) {
        return null;
    }

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the overload with indexing capabilities.", replaceWith="<_subannotation>") default void stickyHeader(Object arg3, Object arg4, Function3 arg5) {
        this.stickyHeader(arg3, arg4, ComposableLambdaKt.composableLambdaInstance(0xD274EF3E, true, new LazyListScope$$ExternalSyntheticLambda0(arg5)));
    }

    default void stickyHeader(Object arg3, Object arg4, Function4 arg5) {
        this.item(arg3, arg4, ComposableLambdaKt.composableLambdaInstance(0x64D8A50B, true, new LazyListScope$$ExternalSyntheticLambda2(arg5)));
    }

    static void stickyHeader$default(LazyListScope arg1, Object arg2, Object arg3, Function3 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            Object v0 = null;
            if((arg5 & 1) != 0) {
                arg2 = v0;
            }

            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            arg1.stickyHeader(arg2, arg3, arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
    }

    static void stickyHeader$default(LazyListScope arg1, Object arg2, Object arg3, Function4 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            Object v0 = null;
            if((arg5 & 1) != 0) {
                arg2 = v0;
            }

            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            arg1.stickyHeader(arg2, arg3, arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
    }

    static Unit stickyHeader$lambda$0(Function3 arg2, LazyItemScope arg3, int arg4, Composer arg5, int arg6) {
        ComposerKt.sourceInformation(arg5, "C122@5845L9:LazyDsl.kt#428nma");
        if((arg6 & 6) == 0) {
            arg4 = arg5.changed(arg3) ? 4 : 2;
            arg6 |= arg4;
        }

        boolean v4 = (arg6 & 0x83) != 130 ? true : false;
        if(arg5.shouldExecute(v4, arg6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD274EF3E, arg6, -1, "androidx.compose.foundation.lazy.LazyListScope.stickyHeader.<anonymous> (LazyDsl.kt:122)");
            }

            arg2.invoke(arg3, arg5, Integer.valueOf(arg6 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_33;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_33:
        return Unit.INSTANCE;
    }

    static Unit stickyHeader$lambda$1(Function4 arg4, LazyItemScope arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C148@7423L15:LazyDsl.kt#428nma");
        if((arg7 & 6) == 0) {
            int v0 = arg6.changed(arg5) ? 4 : 2;
            arg7 |= v0;
        }

        boolean v0_1 = (arg7 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v0_1, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x64D8A50B, arg7, -1, "androidx.compose.foundation.lazy.LazyListScope.stickyHeader.<anonymous> (LazyDsl.kt:148)");
            }

            arg4.invoke(arg5, Integer.valueOf(0), arg6, Integer.valueOf(arg7 & 14 | 0x30));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_36;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_36:
        return Unit.INSTANCE;
    }
}

