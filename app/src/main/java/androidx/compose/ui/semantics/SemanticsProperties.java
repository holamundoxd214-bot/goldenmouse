package androidx.compose.ui.semantics;

import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\tR\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\tR\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\tR\u0017\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\tR\u0017\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00150\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\tR\u0017\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\tR\u0017\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001F0\u0005¢\u0006\b\n\u0000\u001A\u0004\b \u0010\tR\u0017\u0010!\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\tR\"\u0010$\u001A\b\u0012\u0004\u0012\u00020\"0\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b%\u0010\u0003\u001A\u0004\b&\u0010\tR\u0017\u0010\'\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\tR\u0017\u0010)\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\tR\"\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b,\u0010\u0003\u001A\u0004\b-\u0010\tR\u0017\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\b/\u0010\tR\u0017\u00100\u001A\b\u0012\u0004\u0012\u0002010\u0005¢\u0006\b\n\u0000\u001A\u0004\b2\u0010\tR\u0017\u00103\u001A\b\u0012\u0004\u0012\u0002040\u0005¢\u0006\b\n\u0000\u001A\u0004\b5\u0010\tR\u0017\u00106\u001A\b\u0012\u0004\u0012\u0002070\u0005¢\u0006\b\n\u0000\u001A\u0004\b8\u0010\tR\u0017\u00109\u001A\b\u0012\u0004\u0012\u00020:0\u0005¢\u0006\b\n\u0000\u001A\u0004\b;\u0010\tR\u0017\u0010<\u001A\b\u0012\u0004\u0012\u00020=0\u0005¢\u0006\b\n\u0000\u001A\u0004\b>\u0010\tR\u0017\u0010?\u001A\b\u0012\u0004\u0012\u00020=0\u0005¢\u0006\b\n\u0000\u001A\u0004\b@\u0010\tR\u0017\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\bB\u0010\tR\u0017\u0010C\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\bD\u0010\tR\u0017\u0010E\u001A\b\u0012\u0004\u0012\u00020F0\u0005¢\u0006\b\n\u0000\u001A\u0004\bG\u0010\tR\u0017\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\bI\u0010\tR\u0017\u0010J\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\bK\u0010\tR\u001D\u0010L\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bN\u0010\tR\u0017\u0010O\u001A\b\u0012\u0004\u0012\u00020M0\u0005¢\u0006\b\n\u0000\u001A\u0004\bP\u0010\tR\u0017\u0010Q\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\bR\u0010\tR\u0017\u0010S\u001A\b\u0012\u0004\u0012\u00020M0\u0005¢\u0006\b\n\u0000\u001A\u0004\bT\u0010\tR\u0017\u0010U\u001A\b\u0012\u0004\u0012\u00020M0\u0005¢\u0006\b\n\u0000\u001A\u0004\bV\u0010\tR\u0017\u0010W\u001A\b\u0012\u0004\u0012\u00020X0\u0005¢\u0006\b\n\u0000\u001A\u0004\bY\u0010\tR\u0017\u0010Z\u001A\b\u0012\u0004\u0012\u00020[0\u0005¢\u0006\b\n\u0000\u001A\u0004\b\\\u0010\tR\u0017\u0010]\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\b^\u0010\tR\u0017\u0010_\u001A\b\u0012\u0004\u0012\u00020`0\u0005¢\u0006\b\n\u0000\u001A\u0004\ba\u0010\tR\u0017\u0010b\u001A\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001A\u0004\bc\u0010\tR\u0017\u0010d\u001A\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\be\u0010\tR#\u0010f\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020h0g0\u0005¢\u0006\b\n\u0000\u001A\u0004\bi\u0010\tR\u0017\u0010j\u001A\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\b\n\u0000\u001A\u0004\bk\u0010\tR\u0017\u0010l\u001A\b\u0012\u0004\u0012\u00020h0\u0005¢\u0006\b\n\u0000\u001A\u0004\bm\u0010\tR\u0017\u0010n\u001A\b\u0012\u0004\u0012\u00020o0\u0005¢\u0006\b\n\u0000\u001A\u0004\bp\u0010\t¨\u0006q"}, d2={"Landroidx/compose/ui/semantics/SemanticsProperties;", "", "<init>", "()V", "ContentDescription", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "", "getContentDescription", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "StateDescription", "getStateDescription", "ProgressBarRangeInfo", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "PaneTitle", "getPaneTitle", "SelectableGroup", "", "getSelectableGroup", "CollectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "CollectionItemInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "Heading", "getHeading", "Disabled", "getDisabled", "LiveRegion", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "Focused", "", "getFocused", "IsContainer", "getIsContainer$annotations", "getIsContainer", "IsTraversalGroup", "getIsTraversalGroup", "IsSensitiveData", "getIsSensitiveData", "InvisibleToUser", "getInvisibleToUser$annotations", "getInvisibleToUser", "HideFromAccessibility", "getHideFromAccessibility", "ContentType", "Landroidx/compose/ui/autofill/ContentType;", "getContentType", "ContentDataType", "Landroidx/compose/ui/autofill/ContentDataType;", "getContentDataType", "FillableData", "Landroidx/compose/ui/autofill/FillableData;", "getFillableData", "TraversalIndex", "", "getTraversalIndex", "HorizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "IsPopup", "getIsPopup", "IsDialog", "getIsDialog", "Role", "Landroidx/compose/ui/semantics/Role;", "getRole", "TestTag", "getTestTag", "LinkTestMarker", "getLinkTestMarker", "Text", "Landroidx/compose/ui/text/AnnotatedString;", "getText", "TextSubstitution", "getTextSubstitution", "IsShowingTextSubstitution", "getIsShowingTextSubstitution", "InputText", "getInputText", "EditableText", "getEditableText", "TextSelectionRange", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "ImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "getImeAction", "Selected", "getSelected", "ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "Password", "getPassword", "Error", "getError", "IndexForKey", "Lkotlin/Function1;", "", "getIndexForKey", "IsEditable", "getIsEditable", "MaxTextLength", "getMaxTextLength", "Shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsProperties {
    public static final int $stable;
    private static final SemanticsPropertyKey CollectionInfo;
    private static final SemanticsPropertyKey CollectionItemInfo;
    private static final SemanticsPropertyKey ContentDataType;
    private static final SemanticsPropertyKey ContentDescription;
    private static final SemanticsPropertyKey ContentType;
    private static final SemanticsPropertyKey Disabled;
    private static final SemanticsPropertyKey EditableText;
    private static final SemanticsPropertyKey Error;
    private static final SemanticsPropertyKey FillableData;
    private static final SemanticsPropertyKey Focused;
    private static final SemanticsPropertyKey Heading;
    private static final SemanticsPropertyKey HideFromAccessibility;
    private static final SemanticsPropertyKey HorizontalScrollAxisRange;
    public static final SemanticsProperties INSTANCE;
    private static final SemanticsPropertyKey ImeAction;
    private static final SemanticsPropertyKey IndexForKey;
    private static final SemanticsPropertyKey InputText;
    private static final SemanticsPropertyKey InvisibleToUser;
    private static final SemanticsPropertyKey IsContainer;
    private static final SemanticsPropertyKey IsDialog;
    private static final SemanticsPropertyKey IsEditable;
    private static final SemanticsPropertyKey IsPopup;
    private static final SemanticsPropertyKey IsSensitiveData;
    private static final SemanticsPropertyKey IsShowingTextSubstitution;
    private static final SemanticsPropertyKey IsTraversalGroup;
    private static final SemanticsPropertyKey LinkTestMarker;
    private static final SemanticsPropertyKey LiveRegion;
    private static final SemanticsPropertyKey MaxTextLength;
    private static final SemanticsPropertyKey PaneTitle;
    private static final SemanticsPropertyKey Password;
    private static final SemanticsPropertyKey ProgressBarRangeInfo;
    private static final SemanticsPropertyKey Role;
    private static final SemanticsPropertyKey SelectableGroup;
    private static final SemanticsPropertyKey Selected;
    private static final SemanticsPropertyKey Shape;
    private static final SemanticsPropertyKey StateDescription;
    private static final SemanticsPropertyKey TestTag;
    private static final SemanticsPropertyKey Text;
    private static final SemanticsPropertyKey TextSelectionRange;
    private static final SemanticsPropertyKey TextSubstitution;
    private static final SemanticsPropertyKey ToggleableState;
    private static final SemanticsPropertyKey TraversalIndex;
    private static final SemanticsPropertyKey VerticalScrollAxisRange;

    static {
        SemanticsProperties.INSTANCE = new SemanticsProperties();
        SemanticsProperties.ContentDescription = new SemanticsPropertyKey("ContentDescription", true, SemanticsProperties$ContentDescription$1.INSTANCE, null, 8, null);
        SemanticsProperties.StateDescription = new SemanticsPropertyKey("StateDescription", true);
        SemanticsProperties.ProgressBarRangeInfo = new SemanticsPropertyKey("ProgressBarRangeInfo", true);
        SemanticsProperties.PaneTitle = new SemanticsPropertyKey("PaneTitle", true, SemanticsProperties$PaneTitle$1.INSTANCE, null, 8, null);
        SemanticsProperties.SelectableGroup = new SemanticsPropertyKey("SelectableGroup", true);
        SemanticsProperties.CollectionInfo = new SemanticsPropertyKey("CollectionInfo", true);
        SemanticsProperties.CollectionItemInfo = new SemanticsPropertyKey("CollectionItemInfo", true);
        SemanticsProperties.Heading = new SemanticsPropertyKey("Heading", true);
        SemanticsProperties.Disabled = new SemanticsPropertyKey("Disabled", true);
        SemanticsProperties.LiveRegion = new SemanticsPropertyKey("LiveRegion", true);
        SemanticsProperties.Focused = new SemanticsPropertyKey("Focused", true);
        SemanticsProperties.IsContainer = new SemanticsPropertyKey("IsContainer", true);
        SemanticsProperties.IsTraversalGroup = new SemanticsPropertyKey("IsTraversalGroup", null, 2, null);
        SemanticsProperties.IsSensitiveData = new SemanticsPropertyKey("IsSensitiveData", null, 2, null);
        SemanticsProperties.InvisibleToUser = new SemanticsPropertyKey("InvisibleToUser", SemanticsProperties$InvisibleToUser$1.INSTANCE);
        SemanticsProperties.HideFromAccessibility = new SemanticsPropertyKey("HideFromAccessibility", SemanticsProperties$HideFromAccessibility$1.INSTANCE);
        SemanticsProperties.ContentType = new SemanticsPropertyKey("ContentType", SemanticsProperties$ContentType$1.INSTANCE);
        SemanticsProperties.ContentDataType = new SemanticsPropertyKey("ContentDataType", SemanticsProperties$ContentDataType$1.INSTANCE);
        SemanticsProperties.FillableData = new SemanticsPropertyKey("FillableData", SemanticsProperties$FillableData$1.INSTANCE);
        SemanticsProperties.TraversalIndex = new SemanticsPropertyKey("TraversalIndex", SemanticsProperties$TraversalIndex$1.INSTANCE);
        SemanticsProperties.HorizontalScrollAxisRange = new SemanticsPropertyKey("HorizontalScrollAxisRange", true);
        SemanticsProperties.VerticalScrollAxisRange = new SemanticsPropertyKey("VerticalScrollAxisRange", true);
        SemanticsProperties.IsPopup = new SemanticsPropertyKey("IsPopup", true, SemanticsProperties$IsPopup$1.INSTANCE, null, 8, null);
        SemanticsProperties.IsDialog = new SemanticsPropertyKey("IsDialog", true, SemanticsProperties$IsDialog$1.INSTANCE, null, 8, null);
        SemanticsProperties.Role = new SemanticsPropertyKey("Role", true, SemanticsProperties$Role$1.INSTANCE, null, 8, null);
        SemanticsProperties.TestTag = new SemanticsPropertyKey("TestTag", false, SemanticsProperties$TestTag$1.INSTANCE, null, 8, null);
        SemanticsProperties.LinkTestMarker = new SemanticsPropertyKey("LinkTestMarker", false, SemanticsProperties$LinkTestMarker$1.INSTANCE, null, 8, null);
        SemanticsProperties.Text = new SemanticsPropertyKey("Text", true, SemanticsProperties$Text$1.INSTANCE, null, 8, null);
        SemanticsProperties.TextSubstitution = new SemanticsPropertyKey("TextSubstitution", null, 2, null);
        SemanticsProperties.IsShowingTextSubstitution = new SemanticsPropertyKey("IsShowingTextSubstitution", null, 2, null);
        SemanticsProperties.InputText = new SemanticsPropertyKey("InputText", true);
        SemanticsProperties.EditableText = new SemanticsPropertyKey("EditableText", true);
        SemanticsProperties.TextSelectionRange = new SemanticsPropertyKey("TextSelectionRange", true);
        SemanticsProperties.ImeAction = new SemanticsPropertyKey("ImeAction", true);
        SemanticsProperties.Selected = new SemanticsPropertyKey("Selected", true);
        SemanticsProperties.ToggleableState = new SemanticsPropertyKey("ToggleableState", true);
        SemanticsProperties.Password = new SemanticsPropertyKey("Password", true);
        SemanticsProperties.Error = new SemanticsPropertyKey("Error", true);
        SemanticsProperties.IndexForKey = new SemanticsPropertyKey("IndexForKey", null, 2, null);
        SemanticsProperties.IsEditable = new SemanticsPropertyKey("IsEditable", null, 2, null);
        SemanticsProperties.MaxTextLength = new SemanticsPropertyKey("MaxTextLength", null, 2, null);
        SemanticsProperties.Shape = new SemanticsPropertyKey("Shape", false, SemanticsProperties$Shape$1.INSTANCE, null, 8, null);
        SemanticsProperties.$stable = 8;
    }

    private SemanticsProperties() {
        super();
    }

    public final SemanticsPropertyKey getCollectionInfo() {
        return SemanticsProperties.CollectionInfo;
    }

    public final SemanticsPropertyKey getCollectionItemInfo() {
        return SemanticsProperties.CollectionItemInfo;
    }

    public final SemanticsPropertyKey getContentDataType() {
        return SemanticsProperties.ContentDataType;
    }

    public final SemanticsPropertyKey getContentDescription() {
        return SemanticsProperties.ContentDescription;
    }

    public final SemanticsPropertyKey getContentType() {
        return SemanticsProperties.ContentType;
    }

    public final SemanticsPropertyKey getDisabled() {
        return SemanticsProperties.Disabled;
    }

    public final SemanticsPropertyKey getEditableText() {
        return SemanticsProperties.EditableText;
    }

    public final SemanticsPropertyKey getError() {
        return SemanticsProperties.Error;
    }

    public final SemanticsPropertyKey getFillableData() {
        return SemanticsProperties.FillableData;
    }

    public final SemanticsPropertyKey getFocused() {
        return SemanticsProperties.Focused;
    }

    public final SemanticsPropertyKey getHeading() {
        return SemanticsProperties.Heading;
    }

    public final SemanticsPropertyKey getHideFromAccessibility() {
        return SemanticsProperties.HideFromAccessibility;
    }

    public final SemanticsPropertyKey getHorizontalScrollAxisRange() {
        return SemanticsProperties.HorizontalScrollAxisRange;
    }

    public final SemanticsPropertyKey getImeAction() {
        return SemanticsProperties.ImeAction;
    }

    public final SemanticsPropertyKey getIndexForKey() {
        return SemanticsProperties.IndexForKey;
    }

    public final SemanticsPropertyKey getInputText() {
        return SemanticsProperties.InputText;
    }

    public final SemanticsPropertyKey getInvisibleToUser() {
        return SemanticsProperties.InvisibleToUser;
    }

    @Deprecated(message="Use `hideFromAccessibility` instead.", replaceWith="<_subannotation>") public static void getInvisibleToUser$annotations() {
    }

    public final SemanticsPropertyKey getIsContainer() {
        return SemanticsProperties.IsContainer;
    }

    @Deprecated(message="Use `isTraversalGroup` instead.", replaceWith="<_subannotation>") public static void getIsContainer$annotations() {
    }

    public final SemanticsPropertyKey getIsDialog() {
        return SemanticsProperties.IsDialog;
    }

    public final SemanticsPropertyKey getIsEditable() {
        return SemanticsProperties.IsEditable;
    }

    public final SemanticsPropertyKey getIsPopup() {
        return SemanticsProperties.IsPopup;
    }

    public final SemanticsPropertyKey getIsSensitiveData() {
        return SemanticsProperties.IsSensitiveData;
    }

    public final SemanticsPropertyKey getIsShowingTextSubstitution() {
        return SemanticsProperties.IsShowingTextSubstitution;
    }

    public final SemanticsPropertyKey getIsTraversalGroup() {
        return SemanticsProperties.IsTraversalGroup;
    }

    public final SemanticsPropertyKey getLinkTestMarker() {
        return SemanticsProperties.LinkTestMarker;
    }

    public final SemanticsPropertyKey getLiveRegion() {
        return SemanticsProperties.LiveRegion;
    }

    public final SemanticsPropertyKey getMaxTextLength() {
        return SemanticsProperties.MaxTextLength;
    }

    public final SemanticsPropertyKey getPaneTitle() {
        return SemanticsProperties.PaneTitle;
    }

    public final SemanticsPropertyKey getPassword() {
        return SemanticsProperties.Password;
    }

    public final SemanticsPropertyKey getProgressBarRangeInfo() {
        return SemanticsProperties.ProgressBarRangeInfo;
    }

    public final SemanticsPropertyKey getRole() {
        return SemanticsProperties.Role;
    }

    public final SemanticsPropertyKey getSelectableGroup() {
        return SemanticsProperties.SelectableGroup;
    }

    public final SemanticsPropertyKey getSelected() {
        return SemanticsProperties.Selected;
    }

    public final SemanticsPropertyKey getShape() {
        return SemanticsProperties.Shape;
    }

    public final SemanticsPropertyKey getStateDescription() {
        return SemanticsProperties.StateDescription;
    }

    public final SemanticsPropertyKey getTestTag() {
        return SemanticsProperties.TestTag;
    }

    public final SemanticsPropertyKey getText() {
        return SemanticsProperties.Text;
    }

    public final SemanticsPropertyKey getTextSelectionRange() {
        return SemanticsProperties.TextSelectionRange;
    }

    public final SemanticsPropertyKey getTextSubstitution() {
        return SemanticsProperties.TextSubstitution;
    }

    public final SemanticsPropertyKey getToggleableState() {
        return SemanticsProperties.ToggleableState;
    }

    public final SemanticsPropertyKey getTraversalIndex() {
        return SemanticsProperties.TraversalIndex;
    }

    public final SemanticsPropertyKey getVerticalScrollAxisRange() {
        return SemanticsProperties.VerticalScrollAxisRange;
    }
}

