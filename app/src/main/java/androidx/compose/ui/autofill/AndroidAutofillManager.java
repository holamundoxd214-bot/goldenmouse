package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsListener;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u0019H\u0016J\u001C\u0010\u001B\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0016J\u001A\u0010\u001F\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010#H\u0016J\u000E\u0010$\u001A\u00020\u00192\u0006\u0010%\u001A\u00020&J\u0014\u0010\'\u001A\u00020\u00192\f\u0010(\u001A\b\u0012\u0004\u0012\u00020*0)J\u0015\u0010-\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b0J\u001D\u00101\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!2\u0006\u00102\u001A\u000203H\u0000¢\u0006\u0002\b4J\u0015\u00105\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b6J\u0015\u00107\u001A\u00020\u00192\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b8J\r\u0010;\u001A\u00020\u0019H\u0000¢\u0006\u0002\b<R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020:X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006="}, d2={"Landroidx/compose/ui/autofill/AndroidAutofillManager;", "Landroidx/compose/ui/autofill/AutofillManager;", "Landroidx/compose/ui/semantics/SemanticsListener;", "Landroidx/compose/ui/focus/FocusListener;", "platformAutofillManager", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "view", "Landroid/view/View;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "packageName", "", "<init>", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;Landroidx/compose/ui/semantics/SemanticsOwner;Landroid/view/View;Landroidx/compose/ui/spatial/RectManager;Ljava/lang/String;)V", "getPlatformAutofillManager", "()Landroidx/compose/ui/autofill/PlatformAutofillManager;", "setPlatformAutofillManager", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;)V", "reusableRect", "Landroid/graphics/Rect;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "commit", "", "cancel", "onFocusChanged", "previous", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "current", "onSemanticsChanged", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "previousSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "populateViewStructure", "rootViewStructure", "Landroid/view/ViewStructure;", "performAutofill", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "currentlyDisplayedIDs", "Landroidx/collection/MutableIntSet;", "requestAutofill", "requestAutofill$ui", "onPostAttach", "onPostAttach$ui", "onPostLayoutNodeReused", "previousSemanticsId", "", "onPostLayoutNodeReused$ui", "onLayoutNodeDeactivated", "onLayoutNodeDeactivated$ui", "onDetach", "onDetach$ui", "pendingAutofillCommit", "", "onEndApplyChanges", "onEndApplyChanges$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidAutofillManager extends AutofillManager implements FocusListener, SemanticsListener {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ToggleableState.values().length];
            try {
                v0[ToggleableState.On.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ToggleableState.Off.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 8;
    private MutableIntSet currentlyDisplayedIDs;
    private final String packageName;
    private boolean pendingAutofillCommit;
    private PlatformAutofillManager platformAutofillManager;
    private final RectManager rectManager;
    private Rect reusableRect;
    private AutofillId rootAutofillId;
    private final SemanticsOwner semanticsOwner;
    private final View view;

    static {
    }

    public AndroidAutofillManager(PlatformAutofillManager arg1, SemanticsOwner arg2, View arg3, RectManager arg4, String arg5) {
        super();
        this.platformAutofillManager = arg1;
        this.semanticsOwner = arg2;
        this.view = arg3;
        this.rectManager = arg4;
        this.packageName = arg5;
        this.reusableRect = new Rect();
        arg3.setImportantForAutofill(1);
        AutofillIdCompat v2 = ViewCompatShims.getAutofillId(arg3);
        DefaultConstructorMarker v3 = null;
        AutofillId v2_1 = v2 != null ? v2.toAutofillId() : ((AutofillId)v3);
        if(v2_1 != null) {
            this.rootAutofillId = v2_1;
            this.currentlyDisplayedIDs = new MutableIntSet(0, 1, v3);
            return;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final Rect access$getReusableRect$p(AndroidAutofillManager arg0) {
        return arg0.reusableRect;
    }

    public static final View access$getView$p(AndroidAutofillManager arg0) {
        return arg0.view;
    }

    public void cancel() {
        this.platformAutofillManager.cancel();
    }

    public void commit() {
        this.platformAutofillManager.commit();
    }

    public final PlatformAutofillManager getPlatformAutofillManager() {
        return this.platformAutofillManager;
    }

    public final void onDetach$ui(SemanticsInfo arg3) {
        if(this.currentlyDisplayedIDs.remove(arg3.getSemanticsId())) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, arg3.getSemanticsId(), false);
        }
    }

    public final void onEndApplyChanges$ui() {
        if((this.currentlyDisplayedIDs.isEmpty()) && (this.pendingAutofillCommit)) {
            this.platformAutofillManager.commit();
            this.pendingAutofillCommit = false;
        }

        if(this.currentlyDisplayedIDs.isNotEmpty()) {
            this.pendingAutofillCommit = true;
        }
    }

    public void onFocusChanged(FocusTargetModifierNode arg4, FocusTargetModifierNode arg5) {
        SemanticsInfo v4;
        if(arg4 != null) {
            v4 = DelegatableNodeKt.requireSemanticsInfo(((DelegatableNode)arg4));
            if(v4 != null) {
                SemanticsConfiguration v1 = v4.getSemanticsConfiguration();
                if(v1 != null && (AndroidAutofillManager_androidKt.access$isAutofillable(v1))) {
                    this.platformAutofillManager.notifyViewExited(this.view, v4.getSemanticsId());
                }
            }
        }

        if(arg5 != null) {
            v4 = DelegatableNodeKt.requireSemanticsInfo(((DelegatableNode)arg5));
            if(v4 != null) {
                SemanticsConfiguration v5 = v4.getSemanticsConfiguration();
                if(v5 != null && (AndroidAutofillManager_androidKt.access$isAutofillable(v5))) {
                    int v4_1 = v4.getSemanticsId();
                    this.rectManager.getRects().withRect(v4_1, new AndroidAutofillManager$onFocusChanged$2$1(this, v4_1));
                }
            }
        }
    }

    public final void onLayoutNodeDeactivated$ui(SemanticsInfo arg3) {
        if(this.currentlyDisplayedIDs.remove(arg3.getSemanticsId())) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, arg3.getSemanticsId(), false);
        }
    }

    public final void onPostAttach$ui(SemanticsInfo arg4) {
        SemanticsConfiguration v0 = arg4.getSemanticsConfiguration();
        if(v0 != null && (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(v0))) {
            this.currentlyDisplayedIDs.add(arg4.getSemanticsId());
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, arg4.getSemanticsId(), true);
        }
    }

    public final void onPostLayoutNodeReused$ui(SemanticsInfo arg4, int arg5) {
        if(this.currentlyDisplayedIDs.remove(arg5)) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, arg5, false);
        }

        SemanticsConfiguration v5 = arg4.getSemanticsConfiguration();
        if(v5 != null && (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(v5))) {
            this.currentlyDisplayedIDs.add(arg4.getSemanticsId());
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, arg4.getSemanticsId(), true);
        }
    }

    public void onSemanticsChanged(SemanticsInfo arg9, SemanticsConfiguration arg10) {
        Boolean v2_3;
        String v3_1;
        Object v3;
        String v2_1;
        Object v2;
        SemanticsConfiguration v0 = arg9.getSemanticsConfiguration();
        int v9 = arg9.getSemanticsId();
        Object v1 = null;
        if(arg10 != null) {
            v2 = SemanticsConfigurationKt.getOrNull(arg10, SemanticsProperties.INSTANCE.getInputText());
            if(v2 != null) {
                v2_1 = ((AnnotatedString)v2).getText();
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v2_1 = ((String)v1);
        }

        if(v0 != null) {
            v3 = SemanticsConfigurationKt.getOrNull(v0, SemanticsProperties.INSTANCE.getInputText());
            if(v3 != null) {
                v3_1 = ((AnnotatedString)v3).getText();
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v3_1 = ((String)v1);
        }

        int v4 = 0;
        if(v2_1 != v3_1) {
            if(v2_1 == null) {
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, v9, true);
            }
            else if(v3_1 == null) {
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, v9, false);
            }
            else if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v0, SemanticsProperties.INSTANCE.getContentDataType()), ContentDataType.Companion.getText())) {
                this.platformAutofillManager.notifyValueChanged(this.view, v9, AutofillApi26Helper.INSTANCE.getAutofillTextValue(v3_1));
            }
        }

        v2 = arg10 != null ? SemanticsConfigurationKt.getOrNull(arg10, SemanticsProperties.INSTANCE.getToggleableState()) : v1;
        v3 = v0 != null ? SemanticsConfigurationKt.getOrNull(v0, SemanticsProperties.INSTANCE.getToggleableState()) : v1;
        if(v2 != v3) {
            if(v2 == null) {
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, v9, true);
            }
            else if(v3 == null) {
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, v9, false);
            }
            else if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v0, SemanticsProperties.INSTANCE.getContentDataType()), ContentDataType.Companion.getToggle())) {
                int v2_2 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v3).ordinal()];
                if(v2_2 == 1) {
                    v2_3 = Boolean.valueOf(true);
                }
                else if(v2_2 != 2) {
                    v2_3 = ((Boolean)v1);
                }
                else {
                    v2_3 = Boolean.valueOf(false);
                }

                if(v2_3 == null) {
                    goto label_92;
                }

                this.platformAutofillManager.notifyValueChanged(this.view, v9, AutofillApi26Helper.INSTANCE.getAutofillToggleValue(v2_3.booleanValue()));
            }
        }

    label_92:
        v2 = arg10 != null ? SemanticsConfigurationKt.getOrNull(arg10, SemanticsProperties.INSTANCE.getFillableData()) : v1;
        if(v0 != null) {
            v1 = SemanticsConfigurationKt.getOrNull(v0, SemanticsProperties.INSTANCE.getFillableData());
        }

        if(!Intrinsics.areEqual(v2, v1)) {
            if(v2 == null) {
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, v9, true);
            }
            else {
                PlatformAutofillManager v2_4 = this.platformAutofillManager;
                if(v1 == null) {
                    v2_4.notifyViewVisibilityChanged(this.view, v9, false);
                }
                else {
                    v2_4.notifyValueChanged(this.view, v9, ((AndroidFillableData)v1).getAutofillValue$ui());
                }
            }
        }

        int v10 = arg10 == null || !AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(arg10) ? 0 : 1;
        if(v0 != null && (AndroidAutofillManager_androidKt.access$isRelatedToAutoCommit(v0))) {
            v4 = 1;
        }

        if(v10 != v4) {
            MutableIntSet v8 = this.currentlyDisplayedIDs;
            if(v4 != 0) {
                v8.add(v9);
                return;
            }
            else {
                v8.remove(v9);
            }
        }
    }

    public final void performAutofill(SparseArray arg10) {
        int v0 = arg10.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg10.keyAt(v1);
            Object v3 = arg10.get(v2);
            SemanticsInfo v2_1 = this.semanticsOwner.get$ui(v2);
            if(v2_1 != null) {
                SemanticsConfiguration v2_2 = v2_1.getSemanticsConfiguration();
                if(v2_2 != null) {
                    Object v4 = SemanticsConfigurationKt.getOrNull(v2_2, SemanticsActions.INSTANCE.getOnAutofillText());
                    if(v4 != null) {
                        Function v4_1 = ((AccessibilityAction)v4).getAction();
                        if(v4_1 != null) {
                            ((Function1)v4_1).invoke(new AnnotatedString(AutofillApi26Helper.INSTANCE.textValue(((AutofillValue)v3)).toString(), null, 2, null));
                        }
                    }

                    Object v2_3 = SemanticsConfigurationKt.getOrNull(v2_2, SemanticsActions.INSTANCE.getOnFillData());
                    if(v2_3 == null) {
                        goto label_33;
                    }

                    Function v2_4 = ((AccessibilityAction)v2_3).getAction();
                    if(v2_4 == null) {
                        goto label_33;
                    }

                    ((Function1)v2_4).invoke(new AndroidFillableData(((AutofillValue)v3)));
                }
            }

        label_33:
        }
    }

    public final void populateViewStructure(ViewStructure arg12) {
        AutofillApi26Helper v0 = AutofillApi26Helper.INSTANCE;
        SemanticsInfo v1 = this.semanticsOwner.getRootInfo$ui();
        PopulateViewStructure_androidKt.populate(arg12, v1, this.rootAutofillId, this.packageName, this.rectManager);
        MutableObjectList v12 = ObjectListKt.mutableObjectListOf(v1, arg12);
    label_8:
        if(v12.isNotEmpty()) {
            Object v2 = v12.removeAt(v12._size - 1);
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.ViewStructure");
            Object v1_1 = v12.removeAt(v12._size - 1);
            Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
            List v1_2 = ((SemanticsInfo)v1_1).getChildrenInfo();
            int v4 = v1_2.size();
            int v5;
            for(v5 = 0; true; ++v5) {
                if(v5 >= v4) {
                    goto label_8;
                }

                Object v6 = v1_2.get(v5);
                if(!((SemanticsInfo)v6).isDeactivated() && (((SemanticsInfo)v6).isAttached())) {
                    if(!((SemanticsInfo)v6).isPlaced()) {
                    }
                    else {
                        SemanticsConfiguration v7 = ((SemanticsInfo)v6).getSemanticsConfiguration();
                        if(v7 != null && (AndroidAutofillManager_androidKt.access$isRelatedToAutofill(v7))) {
                            ViewStructure v7_1 = v0.newChild(((ViewStructure)v2), v0.addChildCount(((ViewStructure)v2), 1));
                            PopulateViewStructure_androidKt.populate(v7_1, ((SemanticsInfo)v6), this.rootAutofillId, this.packageName, this.rectManager);
                            v12.add(v6);
                            v12.add(v7_1);
                            goto label_50;
                        }

                        v12.add(v6);
                        v12.add(v2);
                    }
                }

            label_50:
            }
        }
    }

    public final void requestAutofill$ui(SemanticsInfo arg4) {
        this.rectManager.getRects().withRect(arg4.getSemanticsId(), new AndroidAutofillManager$requestAutofill$1(this, arg4));
    }

    public final void setPlatformAutofillManager(PlatformAutofillManager arg1) {
        this.platformAutofillManager = arg1;
    }
}

