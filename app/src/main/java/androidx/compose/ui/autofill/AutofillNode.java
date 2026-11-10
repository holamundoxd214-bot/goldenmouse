package androidx.compose.ui.autofill;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ") @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB9\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001C\u001A\u00020\u0016H\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001F\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001E"}, d2={"Landroidx/compose/ui/autofill/AutofillNode;", "", "autofillTypes", "", "Landroidx/compose/ui/autofill/AutofillType;", "boundingBox", "Landroidx/compose/ui/geometry/Rect;", "onFill", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)V", "getAutofillTypes", "()Ljava/util/List;", "getBoundingBox", "()Landroidx/compose/ui/geometry/Rect;", "setBoundingBox", "(Landroidx/compose/ui/geometry/Rect;)V", "getOnFill", "()Lkotlin/jvm/functions/Function1;", "id", "", "getId", "()I", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillNode {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00060\u0001j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/ui/autofill/AutofillNode$Companion;", "", "<init>", "()V", "previousId", "", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "generateId", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final int access$generateId(Companion arg0) {
            return arg0.generateId();
        }

        private final int generateId() {
            int v0_1;
            Object v1 = AutofillNode.lock;
            __monitor_enter(v1);
            try {
                ++AutofillNode.previousId;
                v0_1 = AutofillNode.previousId;
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            return v0_1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final List autofillTypes;
    private Rect boundingBox;
    private final int id;
    private static final Object lock;
    private final Function1 onFill;
    private static int previousId;

    static {
        Companion v0 = new Companion(null);
        AutofillNode.Companion = v0;
        AutofillNode.$stable = 8;
        AutofillNode.lock = v0;
    }

    public AutofillNode(List arg1, Rect arg2, Function1 arg3) {
        super();
        this.autofillTypes = arg1;
        this.boundingBox = arg2;
        this.onFill = arg3;
        int v1 = ComposeUiFlags.isSemanticAutofillEnabled ? SemanticsModifierKt.generateSemanticsId() : Companion.access$generateId(AutofillNode.Companion);
        this.id = v1;
    }

    public AutofillNode(List arg1, Rect arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = CollectionsKt.emptyList();
        }

        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, arg3);
    }

    public static final Object access$getLock$cp() {
        return AutofillNode.lock;
    }

    public static final int access$getPreviousId$cp() {
        return AutofillNode.previousId;
    }

    public static final void access$setPreviousId$cp(int arg0) {
        AutofillNode.previousId = arg0;
    }

    public boolean equals(Object arg5) {
        if(this == (((AutofillNode)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AutofillNode)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.autofillTypes, ((AutofillNode)arg5).autofillTypes)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.boundingBox, ((AutofillNode)arg5).boundingBox)) {
            return 0;
        }

        if(this.onFill != ((AutofillNode)arg5).onFill) {
            return 0;
        }

        return 1;
    }

    public final List getAutofillTypes() {
        return this.autofillTypes;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final int getId() {
        return this.id;
    }

    public final Function1 getOnFill() {
        return this.onFill;
    }

    public int hashCode() {
        int v0 = this.autofillTypes.hashCode() * 0x1F;
        Rect v1 = this.boundingBox;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        Function1 v3 = this.onFill;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public final void setBoundingBox(Rect arg1) {
        this.boundingBox = arg1;
    }
}

