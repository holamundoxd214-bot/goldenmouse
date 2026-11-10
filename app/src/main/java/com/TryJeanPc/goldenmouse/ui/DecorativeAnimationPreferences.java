package com.TryJeanPc.goldenmouse.ui;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "isEnabled", "", "effect", "Lcom/TryJeanPc/goldenmouse/ui/DecorativeEffect;", "setEnabled", "", "enabled", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class DecorativeAnimationPreferences {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences$Companion;", "", "<init>", "()V", "FILE", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String FILE = "decorative_animations";
    private final SharedPreferences preferences;

    static {
        DecorativeAnimationPreferences.Companion = new Companion(null);
        DecorativeAnimationPreferences.$stable = 8;
    }

    public DecorativeAnimationPreferences(SharedPreferences arg2) {
        Intrinsics.checkNotNullParameter(arg2, "preferences");
        super();
        this.preferences = arg2;
    }

    public final boolean isEnabled(DecorativeEffect arg2) {
        Intrinsics.checkNotNullParameter(arg2, "effect");
        return this.preferences.getBoolean(arg2.getKey(), true);
    }

    public final void setEnabled(DecorativeEffect arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "effect");
        this.preferences.edit().putBoolean(arg2.getKey(), arg3).apply();
    }
}

