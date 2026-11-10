package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b`\u0018\u00002\u00020\u0001J!\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0002\b\fJ7\u0010\r\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\u0019\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u001CH&J/\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b$\u0010%J\b\u0010 \u001A\u00020\u001CH&J\n\u0010&\u001A\u0004\u0018\u00010\u000BH&J\b\u0010\'\u001A\u00020\u0007H&J\b\u0010(\u001A\u00020\u0007H&J\'\u0010)\u001A\u00020\u00072\u0006\u0010*\u001A\u00020+2\u000E\b\u0002\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00070-H&¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001A\u00020\u00072\u0006\u0010*\u001A\u00020+H&¢\u0006\u0004\b1\u00102J \u00103\u001A\u00020\u00072\u0006\u00104\u001A\u0002052\u000E\b\u0002\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00070-H&J\u0010\u00106\u001A\u00020\u00072\u0006\u00104\u001A\u000207H&J\b\u00108\u001A\u00020\u001CH&J\b\u00109\u001A\u00020\u001CH&J\u0010\u0010:\u001A\u00020\u001C2\u0006\u0010;\u001A\u00020\u0011H&J\u0010\u0010:\u001A\u00020\u001C2\u0006\u0010;\u001A\u00020<H&J\b\u0010=\u001A\u00020\u001CH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0018\u0010>\u001A\b\u0012\u0004\u0012\u00020@0?X¦\u0004¢\u0006\u0006\u001A\u0004\bA\u0010BR\u0012\u0010C\u001A\u00020DX¦\u0004¢\u0006\u0006\u001A\u0004\bE\u0010FR\u001A\u0010G\u001A\u0004\u0018\u00010\u0011X¦\u000E¢\u0006\f\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0018\u0010L\u001A\u00020\u0007X¦\u000E¢\u0006\f\u001A\u0004\bL\u0010M\"\u0004\bN\u0010Oø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006PÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/focus/FocusManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "moveFocus", "wrapAroundForOneDimensionalFocus", "moveFocus-aToIllA", "(IZ)Z", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearFocus", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "resetFocus", "resetFocus-3ESFkO8", "(I)Z", "getFocusRect", "hasFocusableContent", "hasNonInteropFocusableContent", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchIndirectPointerCancel", "focusTargetAvailable", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "activeFocusTargetNode", "getActiveFocusTargetNode", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setActiveFocusTargetNode", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FocusOwner extends FocusManager {
    boolean clearFocus-I7lrPNg(boolean arg1, boolean arg2, boolean arg3, int arg4);

    void clearOwnerFocus();

    void dispatchIndirectPointerCancel();

    boolean dispatchIndirectPointerEvent(IndirectPointerEvent arg1);

    boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo(KeyEvent arg1);

    boolean dispatchKeyEvent-YhN2O0w(KeyEvent arg1, Function0 arg2);

    static boolean dispatchKeyEvent-YhN2O0w$default(FocusOwner arg0, KeyEvent arg1, Function0 arg2, int arg3, Object arg4) {
        FocusOwner$dispatchKeyEvent$1 v2;
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                v2 = FocusOwner$dispatchKeyEvent$1.INSTANCE;
            }

            return arg0.dispatchKeyEvent-YhN2O0w(arg1, ((Function0)v2));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
    }

    boolean dispatchRotaryEvent(RotaryScrollEvent arg1, Function0 arg2);

    static boolean dispatchRotaryEvent$default(FocusOwner arg0, RotaryScrollEvent arg1, Function0 arg2, int arg3, Object arg4) {
        FocusOwner$dispatchRotaryEvent$1 v2;
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                v2 = FocusOwner$dispatchRotaryEvent$1.INSTANCE;
            }

            return arg0.dispatchRotaryEvent(arg1, ((Function0)v2));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchRotaryEvent");
    }

    Boolean focusSearch-ULY8qGw(int arg1, Rect arg2, Function1 arg3);

    void focusTargetAvailable();

    FocusTargetNode getActiveFocusTargetNode();

    Rect getFocusRect();

    MutableObjectList getListeners();

    Modifier getModifier();

    FocusState getRootState();

    boolean hasFocusableContent();

    boolean hasNonInteropFocusableContent();

    boolean isFocusCaptured();

    boolean moveFocus-aToIllA(int arg1, boolean arg2);

    void releaseFocus();

    boolean requestOwnerFocus-7o62pno(FocusDirection arg1, Rect arg2);

    boolean resetFocus-3ESFkO8(int arg1);

    void scheduleInvalidation(FocusEventModifierNode arg1);

    void scheduleInvalidation(FocusTargetNode arg1);

    void scheduleInvalidationForOwner();

    void setActiveFocusTargetNode(FocusTargetNode arg1);

    void setFocusCaptured(boolean arg1);

    boolean takeFocus-aToIllA(int arg1, Rect arg2);
}

