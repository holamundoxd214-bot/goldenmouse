package androidx.lifecycle;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u001A\u0010\b\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¨\u0006\u000B"}, d2={"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Landroidx/startup/Initializer;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ProcessLifecycleInitializer implements Initializer {
    public ProcessLifecycleInitializer() {
        super();
    }

    public LifecycleOwner create(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        AppInitializer v0 = AppInitializer.getInstance(arg3);
        Intrinsics.checkNotNullExpressionValue(v0, "getInstance(...)");
        if(v0.isEagerlyInitialized(this.getClass())) {
            LifecycleDispatcher.init(arg3);
            ProcessLifecycleOwner.Companion.init$lifecycle_process(arg3);
            return ProcessLifecycleOwner.Companion.get();
        }

        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name=\'androidx.lifecycle.ProcessLifecycleInitializer\'\n                   android:value=\'androidx.startup\' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    public Object create(Context arg1) {
        return this.create(arg1);
    }

    public List dependencies() {
        return CollectionsKt.emptyList();
    }
}

