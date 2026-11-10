package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001A\u00020\u000BH\u0007J\u0018\u0010\f\u001A\u00020\u000B2\u000E\u0010\r\u001A\n\u0018\u00010\u000Ej\u0004\u0018\u0001`\u000FH\u0007J\u0014\u0010\u0010\u001A\u00020\u000B2\n\u0010\u0011\u001A\u00060\u000Ej\u0002`\u000FH\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0013"}, d2={"Landroidx/savedstate/SavedStateRegistryController;", "", "impl", "Landroidx/savedstate/internal/SavedStateRegistryImpl;", "<init>", "(Landroidx/savedstate/internal/SavedStateRegistryImpl;)V", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "performAttach", "", "performRestore", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "performSave", "outBundle", "Companion", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateRegistryController {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "<init>", "()V", "create", "Landroidx/savedstate/SavedStateRegistryController;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final SavedStateRegistryController create(SavedStateRegistryOwner arg2) {
            Intrinsics.checkNotNullParameter(arg2, "owner");
            return new SavedStateRegistryController(new SavedStateRegistryImpl(arg2, new SavedStateRegistryController$Companion$$ExternalSyntheticLambda0(arg2)), null);
        }

        static final Unit create$lambda$0(SavedStateRegistryOwner arg2) {
            arg2.getLifecycle().addObserver(new Recreator(arg2));
            return Unit.INSTANCE;
        }
    }

    public static final Companion Companion;
    private final SavedStateRegistryImpl impl;
    private final SavedStateRegistry savedStateRegistry;

    static {
        SavedStateRegistryController.Companion = new Companion(null);
    }

    private SavedStateRegistryController(SavedStateRegistryImpl arg2) {
        super();
        this.impl = arg2;
        this.savedStateRegistry = new SavedStateRegistry(arg2);
    }

    public SavedStateRegistryController(SavedStateRegistryImpl arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    @JvmStatic public static final SavedStateRegistryController create(SavedStateRegistryOwner arg1) {
        return SavedStateRegistryController.Companion.create(arg1);
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    public final void performAttach() {
        this.impl.performAttach();
    }

    public final void performRestore(Bundle arg1) {
        this.impl.performRestore$savedstate(arg1);
    }

    public final void performSave(Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg2, "outBundle");
        this.impl.performSave$savedstate(arg2);
    }
}

