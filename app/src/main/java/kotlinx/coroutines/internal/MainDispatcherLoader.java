package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\u0007H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "<init>", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED;
    public static final MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;

    static {
        MainDispatcherLoader v0 = new MainDispatcherLoader();
        MainDispatcherLoader.INSTANCE = v0;
        MainDispatcherLoader.FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        MainDispatcherLoader.dispatcher = v0.loadMainDispatcher();
    }

    private MainDispatcherLoader() {
        super();
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        Object v2;
        Throwable v6 = null;
        try {
            List v0_1 = MainDispatcherLoader.FAST_SERVICE_LOADER_ENABLED ? FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core() : SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator v1 = v0_1.iterator();
            if(!v1.hasNext()) {
                v2 = v6;
            }
            else {
                v2 = v1.next();
                if(!v1.hasNext()) {
                }
                else {
                    int v3 = v2.getLoadPriority();
                    do {
                        Object v4 = v1.next();
                        int v5 = v4.getLoadPriority();
                        if(v3 < v5) {
                            v2 = v4;
                            v3 = v5;
                        }

                        if(v1.hasNext()) {
                            continue;
                        }

                        break;
                    }
                    while(true);
                }
            }

            if(v2 != null) {
                MainCoroutineDispatcher v0_2 = MainDispatchersKt.tryCreateDispatcher(((MainDispatcherFactory)v2), v0_1);
                if(v0_2 == null) {
                }
                else {
                    return v0_2;
                }
            }

            return MainDispatchersKt.createMissingDispatcher$default(v6, ((String)v6), 3, v6);
        }
        catch(Throwable v0) {
            return MainDispatchersKt.createMissingDispatcher$default(v0, ((String)v6), 2, v6);
        }
    }
}

