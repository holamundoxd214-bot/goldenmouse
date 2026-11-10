package androidx.compose.runtime.retain;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0005H\u0016J\u001C\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\b2\b\u0010\n\u001A\u0004\u0018\u00010\bH\u0016J\u001A\u0010\u000B\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2={"Landroidx/compose/runtime/retain/ForgetfulRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "<init>", "()V", "onContentEnteredComposition", "", "onContentExitComposition", "consumeExitedValueOrDefault", "", "key", "defaultValue", "saveExitingValue", "value", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ForgetfulRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable;
    public static final ForgetfulRetainedValuesStore INSTANCE;

    static {
        ForgetfulRetainedValuesStore.INSTANCE = new ForgetfulRetainedValuesStore();
    }

    private ForgetfulRetainedValuesStore() {
        super();
    }

    public Object consumeExitedValueOrDefault(Object arg1, Object arg2) {
        return arg2;
    }

    public void onContentEnteredComposition() {
    }

    public void onContentExitComposition() {
    }

    public void saveExitingValue(Object arg1, Object arg2) {
        if((arg2 instanceof RetainObserver)) {
            ((RetainObserver)arg2).onRetired();
        }
    }
}

