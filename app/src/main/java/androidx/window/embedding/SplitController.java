package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001A\u00020\u000BJ\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0007J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u0013H\u0007J\u001C\u0010\u0018\u001A\u00020\u00172\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0\u001AH\u0007J\b\u0010\u001D\u001A\u00020\u0017H\u0007J\u0018\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\t2\u0006\u0010 \u001A\u00020\u001CH\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006#"}, d2={"Landroidx/window/embedding/SplitController;", "", "embeddingBackend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "splitInfoList", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/embedding/SplitInfo;", "activity", "Landroid/app/Activity;", "splitSupportStatus", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "pinTopActivityStack", "", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "updateSplitAttributes", "splitInfo", "splitAttributes", "SplitSupportStatus", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitController {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/window/embedding/SplitController$Companion;", "", "<init>", "()V", "sDebug", "", "getInstance", "Landroidx/window/embedding/SplitController;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final SplitController getInstance(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return new SplitController(EmbeddingBackend.Companion.getInstance(arg1));
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/window/embedding/SplitController$SplitSupportStatus;", "", "rawValue", "", "<init>", "(I)V", "toString", "", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitSupportStatus {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/embedding/SplitController$SplitSupportStatus$Companion;", "", "<init>", "()V", "SPLIT_AVAILABLE", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "SPLIT_UNAVAILABLE", "SPLIT_ERROR_PROPERTY_NOT_DECLARED", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.SplitController$SplitSupportStatus$Companion {
            public androidx.window.embedding.SplitController$SplitSupportStatus$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.SplitController$SplitSupportStatus$Companion() {
                super();
            }
        }

        public static final androidx.window.embedding.SplitController$SplitSupportStatus$Companion Companion;
        public static final SplitSupportStatus SPLIT_AVAILABLE;
        public static final SplitSupportStatus SPLIT_ERROR_PROPERTY_NOT_DECLARED;
        public static final SplitSupportStatus SPLIT_UNAVAILABLE;
        private final int rawValue;

        static {
            SplitSupportStatus.Companion = new androidx.window.embedding.SplitController$SplitSupportStatus$Companion(null);
            SplitSupportStatus.SPLIT_AVAILABLE = new SplitSupportStatus(0);
            SplitSupportStatus.SPLIT_UNAVAILABLE = new SplitSupportStatus(1);
            SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED = new SplitSupportStatus(2);
        }

        private SplitSupportStatus(int arg1) {
            super();
            this.rawValue = arg1;
        }

        public String toString() {
            int v1 = this.rawValue;
            if(v1 != 0) {
                if(v1 != 1) {
                    if(v1 != 2) {
                        return "UNKNOWN";
                    }

                    return "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED";
                }

                return "SplitSupportStatus: UNAVAILABLE";
            }

            return "SplitSupportStatus: AVAILABLE";
        }
    }

    public static final Companion Companion = null;
    private final EmbeddingBackend embeddingBackend;
    public static final boolean sDebug = false;

    static {
        SplitController.Companion = new Companion(null);
    }

    public SplitController(EmbeddingBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingBackend");
        super();
        this.embeddingBackend = arg2;
    }

    public static final EmbeddingBackend access$getEmbeddingBackend$p(SplitController arg0) {
        return arg0.embeddingBackend;
    }

    public final void clearSplitAttributesCalculator() {
        this.embeddingBackend.clearSplitAttributesCalculator();
    }

    @JvmStatic public static final SplitController getInstance(Context arg1) {
        return SplitController.Companion.getInstance(arg1);
    }

    public final SplitSupportStatus getSplitSupportStatus() {
        return this.embeddingBackend.getSplitSupportStatus();
    }

    public final boolean pinTopActivityStack(int arg2, SplitPinRule arg3) {
        Intrinsics.checkNotNullParameter(arg3, "splitPinRule");
        return this.embeddingBackend.pinTopActivityStack(arg2, arg3);
    }

    public final void setSplitAttributesCalculator(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "calculator");
        this.embeddingBackend.setSplitAttributesCalculator(arg2);
    }

    public final Flow splitInfoList(Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        return FlowKt.callbackFlow(new SplitController$splitInfoList$1(this, arg3, null));
    }

    public final void unpinTopActivityStack(int arg1) {
        this.embeddingBackend.unpinTopActivityStack(arg1);
    }

    public final void updateSplitAttributes(SplitInfo arg2, SplitAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "splitInfo");
        Intrinsics.checkNotNullParameter(arg3, "splitAttributes");
        this.embeddingBackend.updateSplitAttributes(arg2, arg3);
    }
}

