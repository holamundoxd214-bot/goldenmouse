package androidx.window.embedding;

import android.content.Context;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\bJ\u000E\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\bJ\u0014\u0010\r\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\u000F\u001A\u00020\nR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/window/embedding/RuleController;", "", "embeddingBackend", "Landroidx/window/embedding/EmbeddingBackend;", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "getRules", "", "Landroidx/window/embedding/EmbeddingRule;", "addRule", "", "rule", "removeRule", "setRules", "rules", "clearRules", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RuleController {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J \u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0001\u0010\u000B\u001A\u00020\fH\u0007¨\u0006\r"}, d2={"Landroidx/window/embedding/RuleController$Companion;", "", "<init>", "()V", "getInstance", "Landroidx/window/embedding/RuleController;", "context", "Landroid/content/Context;", "parseRules", "", "Landroidx/window/embedding/EmbeddingRule;", "staticRuleResourceId", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final RuleController getInstance(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            Context v0 = arg1.getApplicationContext();
            androidx.window.embedding.EmbeddingBackend$Companion v1 = EmbeddingBackend.Companion;
            Intrinsics.checkNotNull(v0);
            return new RuleController(v1.getInstance(v0));
        }

        @JvmStatic public final Set parseRules(Context arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            RuleParser v1 = RuleParser.INSTANCE;
            arg2 = arg2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(arg2, "getApplicationContext(...)");
            Set v1_1 = v1.parseRules$window_release(arg2, arg3);
            if(v1_1 == null) {
                v1_1 = SetsKt.emptySet();
            }

            return v1_1;
        }
    }

    public static final Companion Companion;
    private final EmbeddingBackend embeddingBackend;

    static {
        RuleController.Companion = new Companion(null);
    }

    public RuleController(EmbeddingBackend arg2) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingBackend");
        super();
        this.embeddingBackend = arg2;
    }

    public final void addRule(EmbeddingRule arg2) {
        Intrinsics.checkNotNullParameter(arg2, "rule");
        this.embeddingBackend.addRule(arg2);
    }

    public final void clearRules() {
        this.embeddingBackend.setRules(SetsKt.emptySet());
    }

    @JvmStatic public static final RuleController getInstance(Context arg1) {
        return RuleController.Companion.getInstance(arg1);
    }

    public final Set getRules() {
        return this.embeddingBackend.getRules();
    }

    @JvmStatic public static final Set parseRules(Context arg1, int arg2) {
        return RuleController.Companion.parseRules(arg1, arg2);
    }

    public final void removeRule(EmbeddingRule arg2) {
        Intrinsics.checkNotNullParameter(arg2, "rule");
        this.embeddingBackend.removeRule(arg2);
    }

    public final void setRules(Set arg2) {
        Intrinsics.checkNotNullParameter(arg2, "rules");
        this.embeddingBackend.setRules(arg2);
    }
}

