package kotlinx.coroutines.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001A\u00020\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0001H&J\u001A\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0001H¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H&J\u0014\u0010\u0011\u001A\u00020\b2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0001H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R(\u0010\n\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u000B8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/sync/Mutex;", "", "isLocked", "", "()Z", "tryLock", "owner", "lock", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "unlock", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Mutex {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.WARNING, message="Mutex.onLock deprecated without replacement. For additional details please refer to #2794") public static void getOnLock$annotations() {
        }

        public static Object lock$default(Mutex arg0, Object arg1, Continuation arg2, int arg3, Object arg4) {
            if(arg4 == null) {
                if((arg3 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.lock(arg1, arg2);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static boolean tryLock$default(Mutex arg0, Object arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.tryLock(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static void unlock$default(Mutex arg0, Object arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                arg0.unlock(arg1);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    SelectClause2 getOnLock();

    boolean holdsLock(Object arg1);

    boolean isLocked();

    Object lock(Object arg1, Continuation arg2);

    boolean tryLock(Object arg1);

    void unlock(Object arg1);
}

