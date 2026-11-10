package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\u0007H\u0016J\u0015\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u000BJ\b\u0010\f\u001A\u00020\u0007H&J\u001D\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u000FH&J \u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u000FH&J\b\u0010\u0018\u001A\u00020\u0007H&J3\u0010\u0019\u001A\u00020\u00072\u001F\u0010\u001A\u001A\u001B\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u001B¢\u0006\u0002\b\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001E\u001A\u00020\u0007H\u0016R\u0012\u0010\u0003\u001A\u00028\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001FÀ\u0006\u0003"}, d2={"Landroidx/compose/runtime/Applier;", "N", "", "current", "getCurrent", "()Ljava/lang/Object;", "onBeginChanges", "", "onEndChanges", "down", "node", "(Ljava/lang/Object;)V", "up", "insertTopDown", "index", "", "instance", "(ILjava/lang/Object;)V", "insertBottomUp", "remove", "count", "move", "from", "to", "clear", "apply", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Applier {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void apply(Applier arg0, Function2 arg1, Object arg2) {
            arg0.apply(arg1, arg2);
        }

        @Deprecated public static void onBeginChanges(Applier arg0) {
            arg0.onBeginChanges();
        }

        @Deprecated public static void onEndChanges(Applier arg0) {
            arg0.onEndChanges();
        }

        @Deprecated public static void reuse(Applier arg0) {
            arg0.reuse();
        }
    }

    static void access$apply$jd(Applier arg0, Function2 arg1, Object arg2) {
        super.apply(arg1, arg2);
    }

    static void access$onBeginChanges$jd(Applier arg0) {
        super.onBeginChanges();
    }

    static void access$onEndChanges$jd(Applier arg0) {
        super.onEndChanges();
    }

    static void access$reuse$jd(Applier arg0) {
        super.reuse();
    }

    default void apply(Function2 arg1, Object arg2) {
        arg1.invoke(this.getCurrent(), arg2);
    }

    void clear();

    void down(Object arg1);

    Object getCurrent();

    void insertBottomUp(int arg1, Object arg2);

    void insertTopDown(int arg1, Object arg2);

    void move(int arg1, int arg2, int arg3);

    default void onBeginChanges() {
    }

    default void onEndChanges() {
    }

    void remove(int arg1, int arg2);

    default void reuse() {
        Object v1 = this.getCurrent();
        if((v1 instanceof ComposeNodeLifecycleCallback)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            ((ComposeNodeLifecycleCallback)v1).onReuse();
        }
    }

    void up();
}

