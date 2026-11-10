package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B!\u0012\u0018\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001A\u00020\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R \u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/window/embedding/OverlayControllerActivityStackConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Landroidx/window/extensions/embedding/ActivityStack;", "block", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "accept", "value", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverlayControllerActivityStackConsumer implements Consumer2 {
    private final Function1 block;

    public OverlayControllerActivityStackConsumer(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        super();
        this.block = arg2;
    }

    public void accept(Object arg1) {
        this.accept(((List)arg1));
    }

    public void accept(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.block.invoke(arg2);
    }
}

