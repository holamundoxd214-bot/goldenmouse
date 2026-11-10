package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\ba\u0018\u0000 ,2\u00020\u0001:\u0001,R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\tX¦\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0018\u0010\u000E\u001A\u00020\u000FX¦\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001A\u00020\u0015X¦\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001A\u001A\u00020\u001BX¦\u000E¢\u0006\f\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0018\u0010 \u001A\u00020!X¦\u000E¢\u0006\f\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001A\u00020\'X¦\u000E¢\u0006\f\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/ComposeUiNode;", "", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "compositeKeyHash", "", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ComposeUiNode {
    @Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\bR(\u0010\u000B\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0011R(\u0010\u0015\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0011R(\u0010\u0018\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0011R(\u0010\u001B\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0011R(\u0010\u001E\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0011R(\u0010!\u001A\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0011R\"\u0010$\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000E0%¢\u0006\u0002\b\u000F¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'¨\u0006("}, d2={"Landroidx/compose/ui/node/ComposeUiNode$Companion;", "", "<init>", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/ComposeUiNode;", "getConstructor", "()Lkotlin/jvm/functions/Function0;", "VirtualConstructor", "getVirtualConstructor", "SetModifier", "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier;", "", "Lkotlin/ExtensionFunctionType;", "getSetModifier", "()Lkotlin/jvm/functions/Function2;", "SetDensity", "Landroidx/compose/ui/unit/Density;", "getSetDensity", "SetResolvedCompositionLocals", "Landroidx/compose/runtime/CompositionLocalMap;", "getSetResolvedCompositionLocals", "SetMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getSetMeasurePolicy", "SetLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getSetLayoutDirection", "SetViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getSetViewConfiguration", "SetCompositeKeyHash", "", "getSetCompositeKeyHash", "ApplyOnDeactivatedNodeAssertion", "Lkotlin/Function1;", "getApplyOnDeactivatedNodeAssertion", "()Lkotlin/jvm/functions/Function1;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final Function1 ApplyOnDeactivatedNodeAssertion;
        private static final Function0 Constructor;
        private static final Function2 SetCompositeKeyHash;
        private static final Function2 SetDensity;
        private static final Function2 SetLayoutDirection;
        private static final Function2 SetMeasurePolicy;
        private static final Function2 SetModifier;
        private static final Function2 SetResolvedCompositionLocals;
        private static final Function2 SetViewConfiguration;
        private static final Function0 VirtualConstructor;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Constructor = LayoutNode.Companion.getConstructor$ui();
            Companion.VirtualConstructor = ComposeUiNode$Companion$VirtualConstructor$1.INSTANCE;
            Companion.SetModifier = ComposeUiNode$Companion$SetModifier$1.INSTANCE;
            Companion.SetDensity = ComposeUiNode$Companion$SetDensity$1.INSTANCE;
            Companion.SetResolvedCompositionLocals = ComposeUiNode$Companion$SetResolvedCompositionLocals$1.INSTANCE;
            Companion.SetMeasurePolicy = ComposeUiNode$Companion$SetMeasurePolicy$1.INSTANCE;
            Companion.SetLayoutDirection = ComposeUiNode$Companion$SetLayoutDirection$1.INSTANCE;
            Companion.SetViewConfiguration = ComposeUiNode$Companion$SetViewConfiguration$1.INSTANCE;
            Companion.SetCompositeKeyHash = ComposeUiNode$Companion$SetCompositeKeyHash$1.INSTANCE;
            Companion.ApplyOnDeactivatedNodeAssertion = ComposeUiNode$Companion$ApplyOnDeactivatedNodeAssertion$1.INSTANCE;
        }

        private Companion() {
            super();
        }

        public final Function1 getApplyOnDeactivatedNodeAssertion() {
            return Companion.ApplyOnDeactivatedNodeAssertion;
        }

        public final Function0 getConstructor() {
            return Companion.Constructor;
        }

        public final Function2 getSetCompositeKeyHash() {
            return Companion.SetCompositeKeyHash;
        }

        public final Function2 getSetDensity() {
            return Companion.SetDensity;
        }

        public final Function2 getSetLayoutDirection() {
            return Companion.SetLayoutDirection;
        }

        public final Function2 getSetMeasurePolicy() {
            return Companion.SetMeasurePolicy;
        }

        public final Function2 getSetModifier() {
            return Companion.SetModifier;
        }

        public final Function2 getSetResolvedCompositionLocals() {
            return Companion.SetResolvedCompositionLocals;
        }

        public final Function2 getSetViewConfiguration() {
            return Companion.SetViewConfiguration;
        }

        public final Function0 getVirtualConstructor() {
            return Companion.VirtualConstructor;
        }
    }

    public static final Companion Companion;

    static {
        ComposeUiNode.Companion = Companion.$$INSTANCE;
    }

    int getCompositeKeyHash();

    CompositionLocalMap getCompositionLocalMap();

    Density getDensity();

    LayoutDirection getLayoutDirection();

    MeasurePolicy getMeasurePolicy();

    Modifier getModifier();

    ViewConfiguration getViewConfiguration();

    void setCompositeKeyHash(int arg1);

    void setCompositionLocalMap(CompositionLocalMap arg1);

    void setDensity(Density arg1);

    void setLayoutDirection(LayoutDirection arg1);

    void setMeasurePolicy(MeasurePolicy arg1);

    void setModifier(Modifier arg1);

    void setViewConfiguration(ViewConfiguration arg1);
}

