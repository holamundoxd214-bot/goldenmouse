package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0002¨\u0006\u0003"}, d2={"createMutuallyExclusiveErrorMessage", "", "key", "lifecycle-viewmodel-savedstate"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandle_androidKt {
    public static final String access$createMutuallyExclusiveErrorMessage(String arg0) {
        return SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(arg0);
    }

    private static final String createMutuallyExclusiveErrorMessage(String arg2) {
        return "StateFlow and LiveData are mutually exclusive for the same key. Please use either \'getMutableStateFlow\' or \'getLiveData\' for key \'" + arg2 + "\', but not both.";
    }
}

