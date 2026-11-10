package androidx.core.app;

import android.app.PictureInPictureUiState;
import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2={"Landroidx/core/app/PictureInPictureUiStateCompat;", "", "isStashed", "", "isTransitioningToPip", "<init>", "(ZZ)V", "()Z", "Companion", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PictureInPictureUiStateCompat {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/core/app/PictureInPictureUiStateCompat$Companion;", "", "<init>", "()V", "fromPictureInPictureUiState", "Landroidx/core/app/PictureInPictureUiStateCompat;", "uiState", "Landroid/app/PictureInPictureUiState;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final PictureInPictureUiStateCompat fromPictureInPictureUiState(PictureInPictureUiState arg3) {
            Intrinsics.checkNotNullParameter(arg3, "uiState");
            if(Build$VERSION.SDK_INT >= 35) {
                return new PictureInPictureUiStateCompat(arg3.isStashed(), arg3.isTransitioningToPip());
            }

            if(Build$VERSION.SDK_INT >= 0x1F) {
                return new PictureInPictureUiStateCompat(arg3.isStashed(), false);
            }

            return new PictureInPictureUiStateCompat(false, false);
        }
    }

    public static final Companion Companion;
    private final boolean isStashed;
    private final boolean isTransitioningToPip;

    static {
        PictureInPictureUiStateCompat.Companion = new Companion(null);
    }

    public PictureInPictureUiStateCompat(boolean arg1, boolean arg2) {
        super();
        this.isStashed = arg1;
        this.isTransitioningToPip = arg2;
    }

    @JvmStatic public static final PictureInPictureUiStateCompat fromPictureInPictureUiState(PictureInPictureUiState arg1) {
        return PictureInPictureUiStateCompat.Companion.fromPictureInPictureUiState(arg1);
    }

    public final boolean isStashed() {
        return this.isStashed;
    }

    public final boolean isTransitioningToPip() {
        return this.isTransitioningToPip;
    }
}

