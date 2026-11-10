package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u000EH\u0096@¢\u0006\u0004\b\u000F\u0010\u0010J \u0010\u0011\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u000EH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface NestedScrollConnection {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Object onPostFling-RZ2iAVY(NestedScrollConnection arg0, long arg1, long arg3, Continuation arg5) {
            return arg0.onPostFling-RZ2iAVY(arg1, arg3, arg5);
        }

        @Deprecated public static long onPostScroll-DzOQY0M(NestedScrollConnection arg0, long arg1, long arg3, int arg5) {
            return arg0.onPostScroll-DzOQY0M(arg1, arg3, arg5);
        }

        @Deprecated public static Object onPreFling-QWom1Mo(NestedScrollConnection arg0, long arg1, Continuation arg3) {
            return arg0.onPreFling-QWom1Mo(arg1, arg3);
        }

        @Deprecated public static long onPreScroll-OzD1aCk(NestedScrollConnection arg0, long arg1, int arg3) {
            return arg0.onPreScroll-OzD1aCk(arg1, arg3);
        }
    }

    static Object access$onPostFling-RZ2iAVY$jd(NestedScrollConnection arg0, long arg1, long arg3, Continuation arg5) {
        return super.onPostFling-RZ2iAVY(arg1, arg3, arg5);
    }

    static long access$onPostScroll-DzOQY0M$jd(NestedScrollConnection arg0, long arg1, long arg3, int arg5) {
        return super.onPostScroll-DzOQY0M(arg1, arg3, arg5);
    }

    static Object access$onPreFling-QWom1Mo$jd(NestedScrollConnection arg0, long arg1, Continuation arg3) {
        return super.onPreFling-QWom1Mo(arg1, arg3);
    }

    static long access$onPreScroll-OzD1aCk$jd(NestedScrollConnection arg0, long arg1, int arg3) {
        return super.onPreScroll-OzD1aCk(arg1, arg3);
    }

    default Object onPostFling-RZ2iAVY(long arg1, long arg3, Continuation arg5) {
        return NestedScrollConnection.onPostFling-RZ2iAVY$suspendImpl(this, arg1, arg3, arg5);
    }

    static Object onPostFling-RZ2iAVY$suspendImpl(NestedScrollConnection arg0, long arg1, long arg3, Continuation arg5) {
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    default long onPostScroll-DzOQY0M(long arg1, long arg3, int arg5) {
        return Offset.Companion.getZero-F1C5BW0();
    }

    default Object onPreFling-QWom1Mo(long arg1, Continuation arg3) {
        return NestedScrollConnection.onPreFling-QWom1Mo$suspendImpl(this, arg1, arg3);
    }

    static Object onPreFling-QWom1Mo$suspendImpl(NestedScrollConnection arg0, long arg1, Continuation arg3) {
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    default long onPreScroll-OzD1aCk(long arg1, int arg3) {
        return Offset.Companion.getZero-F1C5BW0();
    }
}

