package androidx.compose.foundation;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0018\u0010\t\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0018\u0010\u000B\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0018\u0010\r\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\u0003R\u0018\u0010\u000F\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0018\u0010\u0011\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0018\u0010\u0015\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003R\u0018\u0010\u0017\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/ComposeFoundationFlags;", "", "<init>", "()V", "isDetectTapGesturesImmediateCoroutineDispatchEnabled", "", "isDetectTapGesturesImmediateCoroutineDispatchEnabled$annotations", "isNewContextMenuEnabled", "isNewContextMenuEnabled$annotations", "isSmartSelectionEnabled", "isSmartSelectionEnabled$annotations", "isPausableCompositionInPrefetchEnabled", "isPausableCompositionInPrefetchEnabled$annotations", "isNonSuspendingPointerInputInClickableEnabled", "isNonSuspendingPointerInputInClickableEnabled$annotations", "isTextFieldDpadNavigationEnabled", "isTextFieldDpadNavigationEnabled$annotations", "isKeepInViewFocusObservationChangeEnabled", "isKeepInViewFocusObservationChangeEnabled$annotations", "isNonSuspendingPointerInputInDraggableEnabled", "isNonSuspendingPointerInputInDraggableEnabled$annotations", "isMouseWheel1DAxisLockingEnabled", "isMouseWheel1DAxisLockingEnabled$annotations", "isCacheWindowForPagerEnabled", "isCacheWindowForPagerEnabled$annotations", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ComposeFoundationFlags {
    public static final int $stable;
    public static final ComposeFoundationFlags INSTANCE;
    public static boolean isCacheWindowForPagerEnabled;
    public static boolean isDetectTapGesturesImmediateCoroutineDispatchEnabled;
    public static boolean isKeepInViewFocusObservationChangeEnabled;
    public static boolean isMouseWheel1DAxisLockingEnabled;
    public static boolean isNewContextMenuEnabled;
    public static boolean isNonSuspendingPointerInputInClickableEnabled;
    public static boolean isNonSuspendingPointerInputInDraggableEnabled;
    public static boolean isPausableCompositionInPrefetchEnabled;
    public static boolean isSmartSelectionEnabled;
    public static boolean isTextFieldDpadNavigationEnabled;

    static {
        ComposeFoundationFlags.INSTANCE = new ComposeFoundationFlags();
        ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled = true;
        ComposeFoundationFlags.isNewContextMenuEnabled = true;
        ComposeFoundationFlags.isSmartSelectionEnabled = true;
        ComposeFoundationFlags.isPausableCompositionInPrefetchEnabled = true;
        ComposeFoundationFlags.isNonSuspendingPointerInputInClickableEnabled = true;
        ComposeFoundationFlags.isTextFieldDpadNavigationEnabled = true;
        ComposeFoundationFlags.isKeepInViewFocusObservationChangeEnabled = true;
        ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled = true;
        ComposeFoundationFlags.isMouseWheel1DAxisLockingEnabled = true;
        ComposeFoundationFlags.$stable = 8;
    }

    private ComposeFoundationFlags() {
        super();
    }

    public static void isCacheWindowForPagerEnabled$annotations() {
    }

    public static void isDetectTapGesturesImmediateCoroutineDispatchEnabled$annotations() {
    }

    public static void isKeepInViewFocusObservationChangeEnabled$annotations() {
    }

    public static void isMouseWheel1DAxisLockingEnabled$annotations() {
    }

    public static void isNewContextMenuEnabled$annotations() {
    }

    public static void isNonSuspendingPointerInputInClickableEnabled$annotations() {
    }

    public static void isNonSuspendingPointerInputInDraggableEnabled$annotations() {
    }

    public static void isPausableCompositionInPrefetchEnabled$annotations() {
    }

    public static void isSmartSelectionEnabled$annotations() {
    }

    public static void isTextFieldDpadNavigationEnabled$annotations() {
    }
}

