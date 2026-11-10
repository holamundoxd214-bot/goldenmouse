package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0016J\b\u0010\b\u001A\u00020\tH\u0016R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "<init>", "()V", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "loadPriority", "", "getLoadPriority", "()I", "kotlinx-coroutines-android"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    public AndroidDispatcherFactory() {
        super();
    }

    public MainCoroutineDispatcher createDispatcher(List arg3) {
        Looper v2 = Looper.getMainLooper();
        if(v2 != null) {
            return new HandlerContext(HandlerDispatcherKt.asHandler(v2, true), null, 2, null);
        }

        throw new IllegalStateException("The main looper is not available");
    }

    public int getLoadPriority() {
        return 0x3FFFFFFF;
    }

    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

