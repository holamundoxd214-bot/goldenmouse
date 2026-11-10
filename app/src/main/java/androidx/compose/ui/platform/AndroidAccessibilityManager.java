package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "Landroidx/compose/ui/platform/AccessibilityManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidAccessibilityManager implements AccessibilityManager {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/AndroidAccessibilityManager$Companion;", "", "<init>", "()V", "FlagContentIcons", "", "FlagContentText", "FlagContentControls", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final int FlagContentControls = 4;
    @Deprecated public static final int FlagContentIcons = 1;
    @Deprecated public static final int FlagContentText = 2;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    static {
        AndroidAccessibilityManager.Companion = new Companion(null);
        AndroidAccessibilityManager.$stable = 8;
    }

    public AndroidAccessibilityManager(Context arg2) {
        super();
        Object v2 = arg2.getSystemService("accessibility");
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = ((android.view.accessibility.AccessibilityManager)v2);
    }

    public long calculateRecommendedTimeoutMillis(long arg4, boolean arg6, boolean arg7, boolean arg8) {
        int v6;
        if(arg4 >= 0x7FFFFFFF) {
        }
        else {
            if(arg7) {
                v6 = (((int)arg6)) | 2;
            }

            if(arg8) {
                v6 |= 4;
            }

            long v1 = 0x7FFFFFFFFFFFFFFFL;
            if(Build$VERSION.SDK_INT >= 29) {
                int v3 = Api29Impl.INSTANCE.getRecommendedTimeoutMillis(this.accessibilityManager, ((int)arg4), v6);
                if(v3 == 0x7FFFFFFF) {
                    return v1;
                }

                return ((long)v3);
            }

            if(!arg8) {
                return arg4;
            }

            if(!this.accessibilityManager.isTouchExplorationEnabled()) {
                return arg4;
            }

            return v1;
        }

        return arg4;
    }
}

