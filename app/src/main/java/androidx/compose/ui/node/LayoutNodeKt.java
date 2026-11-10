package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A*\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00050\tH\u0080\b¢\u0006\u0002\u0010\n\u001A\f\u0010\u000B\u001A\u00020\f*\u00020\u0007H\u0000\u001A\u0014\u0010\r\u001A\u00020\u000E*\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"DebugChanges", "", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "withComposeStackTrace", "T", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/node/LayoutNode;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "add", "", "child", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;
    private static final Density DefaultDensity;

    static {
        LayoutNodeKt.DefaultDensity = DensityKt.Density$default(1f, 0f, 2, null);
    }

    public static final Density access$getDefaultDensity$p() {
        return LayoutNodeKt.DefaultDensity;
    }

    public static final void add(LayoutNode arg1, LayoutNode arg2) {
        arg1.insertAt$ui(arg1.getChildren$ui().size(), arg2);
    }

    public static final Owner requireOwner(LayoutNode arg0) {
        Owner v0 = arg0.getOwner$ui();
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("LayoutNode should be attached to an owner");
        throw new KotlinNothingValueException();
    }

    public static final Object withComposeStackTrace(LayoutNode arg0, Function0 arg1) {
        Object v0;
        try {
            v0 = arg1.invoke();
            return v0;
        }
        catch(Throwable v1) {
            ((LayoutNode)v0).rethrowWithComposeStackTrace(v1);
            throw new KotlinNothingValueException();
        }
    }
}

