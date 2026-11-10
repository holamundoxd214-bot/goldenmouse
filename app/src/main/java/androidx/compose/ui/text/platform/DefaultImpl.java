package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/platform/DefaultImpl;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "<init>", "()V", "loadState", "Landroidx/compose/runtime/State;", "", "fontLoaded", "getFontLoaded", "()Landroidx/compose/runtime/State;", "getFontLoadState", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultImpl implements EmojiCompatStatusDelegate {
    private State loadState;

    public DefaultImpl() {
        super();
        State v0 = EmojiCompat.isConfigured() ? this.getFontLoadState() : null;
        this.loadState = v0;
    }

    public static final void access$setLoadState$p(DefaultImpl arg0, State arg1) {
        arg0.loadState = arg1;
    }

    private final State getFontLoadState() {
        EmojiCompat v0 = EmojiCompat.get();
        if(v0.getLoadState() == 1) {
            return new ImmutableBool(true);
        }

        MutableState v1 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        v0.registerInitCallback(new DefaultImpl$getFontLoadState$initCallback$1(v1, this));
        return ((State)v1);
    }

    public State getFontLoaded() {
        State v0 = this.loadState;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        if(EmojiCompat.isConfigured()) {
            v0 = this.getFontLoadState();
            this.loadState = v0;
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        return EmojiCompatStatus_androidKt.access$getFalsey$p();
    }
}

