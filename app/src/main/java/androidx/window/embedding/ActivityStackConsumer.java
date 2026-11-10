package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/embedding/ActivityStackConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Landroidx/window/extensions/embedding/ActivityStack;", "callback", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "adapter", "Landroidx/window/embedding/EmbeddingAdapter;", "<init>", "(Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;Landroidx/window/embedding/EmbeddingAdapter;)V", "accept", "", "value", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityStackConsumer implements Consumer2 {
    private final EmbeddingAdapter adapter;
    private final EmbeddingCallbackInterface callback;

    public ActivityStackConsumer(EmbeddingCallbackInterface arg2, EmbeddingAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        super();
        this.callback = arg2;
        this.adapter = arg3;
    }

    public void accept(Object arg1) {
        this.accept(((List)arg1));
    }

    public void accept(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.callback.onActivityStackChanged(this.adapter.translate$window_release(arg2));
    }
}

