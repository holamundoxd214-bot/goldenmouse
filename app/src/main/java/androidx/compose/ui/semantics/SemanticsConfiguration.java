package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u001A\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0014\u001A\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001A\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00150\u001A¢\u0006\u0002\u0010\u001BJ1\u0010\u001C\u001A\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00150\u00042\u000E\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\u001A¢\u0006\u0002\u0010\u001BJ!\u0010\u001D\u001A\u001A\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u001EH\u0096\u0002J*\u0010\u001F\u001A\u00020 \"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010!\u001A\u0002H\u0015H\u0096\u0002¢\u0006\u0002\u0010\"J\u001D\u0010#\u001A\u00020$\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002J\r\u0010%\u001A\u00020$H\u0000¢\u0006\u0002\b&J\u0015\u0010-\u001A\u00020 2\u0006\u0010.\u001A\u00020\u0000H\u0000¢\u0006\u0002\b/J\u0015\u00100\u001A\u00020 2\u0006\u00101\u001A\u00020\u0000H\u0000¢\u0006\u0002\b2J\u0006\u00103\u001A\u00020\u0000J\u0013\u00104\u001A\u00020$2\b\u00105\u001A\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u00106\u001A\u000207H\u0016J\b\u00108\u001A\u000209H\u0016R&\u0010\b\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0010\u001A\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\'\u001A\u00020$X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001A\u0010+\u001A\u00020$X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010(\"\u0004\b,\u0010*¨\u0006:"}, d2={"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "<init>", "()V", "props", "Landroidx/collection/MutableScatterMap;", "getProps$ui", "()Landroidx/collection/MutableScatterMap;", "mapWrapper", "", "_accessibilityExtraKeys", "Landroidx/collection/MutableScatterSet;", "accessibilityExtraKeys", "Landroidx/collection/ScatterSet;", "getAccessibilityExtraKeys$ui", "()Landroidx/collection/ScatterSet;", "get", "T", "key", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "iterator", "", "set", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "contains", "", "containsImportantForAccessibility", "containsImportantForAccessibility$ui", "isMergingSemanticsOfDescendants", "()Z", "setMergingSemanticsOfDescendants", "(Z)V", "isClearingSemantics", "setClearingSemantics", "mergeChild", "child", "mergeChild$ui", "collapsePeer", "peer", "collapsePeer$ui", "copy", "equals", "other", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable, KMappedMarker {
    public static final int $stable = 8;
    private MutableScatterSet _accessibilityExtraKeys;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private Map mapWrapper;
    private final MutableScatterMap props;

    static {
    }

    public SemanticsConfiguration() {
        super();
        this.props = ScatterMapKt.mutableScatterMapOf();
    }

    public final void collapsePeer$ui(SemanticsConfiguration arg19) {
        int v17;
        SemanticsConfiguration v0 = this;
        SemanticsConfiguration v1 = arg19;
        if(v1.isMergingSemanticsOfDescendants) {
            v0.isMergingSemanticsOfDescendants = true;
        }

        if(v1.isClearingSemantics) {
            v0.isClearingSemantics = true;
        }

        MutableScatterMap v1_1 = v1.props;
        Object[] v2 = ((ScatterMap)v1_1).keys;
        Object[] v3 = ((ScatterMap)v1_1).values;
        long[] v1_2 = ((ScatterMap)v1_1).metadata;
        int v4 = v1_2.length - 2;
        if(v4 >= 0) {
            int v6;
            for(v6 = 0; true; ++v6) {
                long v7 = v1_2[v6];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v11 = 0;
                    while(v11 < v9) {
                        if((0xFF & v7) < 0x80) {
                            int v12 = (v6 << 3) + v11;
                            Object v13 = v2[v12];
                            Object v12_1 = v3[v12];
                            if(!v0.props.contains(v13)) {
                                v0.props.set(v13, v12_1);
                                goto label_66;
                            }
                            else if((v12_1 instanceof AccessibilityAction)) {
                                Object v14 = v0.props.get(v13);
                                Intrinsics.checkNotNull(v14, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                MutableScatterMap v15 = v0.props;
                                String v16 = ((AccessibilityAction)v14).getLabel();
                                if(v16 == null) {
                                    v16 = v12_1.getLabel();
                                }

                                v17 = v10;
                                String v10_1 = v16;
                                Function v14_1 = ((AccessibilityAction)v14).getAction();
                                if(v14_1 == null) {
                                    v14_1 = ((AccessibilityAction)v12_1).getAction();
                                }

                                v15.set(v13, new AccessibilityAction(v10_1, v14_1));
                            }
                            else {
                                goto label_66;
                            }
                        }
                        else {
                        label_66:
                            v17 = v10;
                        }

                        v7 >>= v17;
                        ++v11;
                        v10 = v17;
                    }

                    if(v9 != v10) {
                        return;
                    }
                }

                if(v6 == v4) {
                    return;
                }
            }
        }
    }

    public final boolean contains(SemanticsPropertyKey arg1) {
        return this.props.containsKey(arg1);
    }

    public final boolean containsImportantForAccessibility$ui() {
        MutableScatterMap v14 = this.props;
        Object[] v0 = ((ScatterMap)v14).keys;
        Object[] v1 = ((ScatterMap)v14).values;
        long[] v14_1 = ((ScatterMap)v14).metadata;
        int v2 = v14_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80 && (v0[(v4 << 3) + v9].isImportantForAccessibility$ui())) {
                            return 1;
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 0;
                    }
                }

                if(v4 == v2) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration v0 = new SemanticsConfiguration();
        v0.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        v0.isClearingSemantics = this.isClearingSemantics;
        v0.props.putAll(this.props);
        return v0;
    }

    public boolean equals(Object arg5) {
        if(this == (((SemanticsConfiguration)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SemanticsConfiguration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.props, ((SemanticsConfiguration)arg5).props)) {
            return 0;
        }

        if(this.isMergingSemanticsOfDescendants != ((SemanticsConfiguration)arg5).isMergingSemanticsOfDescendants) {
            return 0;
        }

        if(this.isClearingSemantics != ((SemanticsConfiguration)arg5).isClearingSemantics) {
            return 0;
        }

        return 1;
    }

    public final Object get(SemanticsPropertyKey arg3) {
        Object v2 = this.props.get(arg3);
        if(v2 != null) {
            return v2;
        }

        throw new IllegalStateException("Key not present: " + arg3 + " - consider getOrElse or getOrNull");
    }

    public final ScatterSet getAccessibilityExtraKeys$ui() {
        return this._accessibilityExtraKeys;
    }

    public final Object getOrElse(SemanticsPropertyKey arg1, Function0 arg2) {
        Object v0 = this.props.get(arg1);
        if(v0 == null) {
            v0 = arg2.invoke();
        }

        return v0;
    }

    public final Object getOrElseNullable(SemanticsPropertyKey arg1, Function0 arg2) {
        Object v0 = this.props.get(arg1);
        if(v0 == null) {
            v0 = arg2.invoke();
        }

        return v0;
    }

    public final MutableScatterMap getProps$ui() {
        return this.props;
    }

    public int hashCode() {
        return (this.props.hashCode() * 0x1F + Boolean.hashCode(this.isMergingSemanticsOfDescendants)) * 0x1F + Boolean.hashCode(this.isClearingSemantics);
    }

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public Iterator iterator() {
        Map v0 = this.mapWrapper;
        if(v0 == null) {
            v0 = this.props.asMap();
            this.mapWrapper = v0;
        }

        return v0.entrySet().iterator();
    }

    public final void mergeChild$ui(SemanticsConfiguration arg15) {
        MutableScatterMap v15 = arg15.props;
        Object[] v0 = ((ScatterMap)v15).keys;
        Object[] v1 = ((ScatterMap)v15).values;
        long[] v15_1 = ((ScatterMap)v15).metadata;
        int v2 = v15_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v15_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v0[v10];
                            Object v10_1 = v1[v10];
                            Object v12 = this.props.get(v11);
                            Intrinsics.checkNotNull(v11, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                            v10_1 = ((SemanticsPropertyKey)v11).merge(v12, v10_1);
                            if(v10_1 != null) {
                                this.props.set(v11, v10_1);
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    public void set(SemanticsPropertyKey arg5, Object arg6) {
        if(!(arg6 instanceof AccessibilityAction) || !this.contains(arg5)) {
            this.props.set(arg5, arg6);
        }
        else {
            Object v0 = this.props.get(arg5);
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            MutableScatterMap v1 = this.props;
            String v3 = ((AccessibilityAction)arg6).getLabel();
            if(v3 == null) {
                v3 = ((AccessibilityAction)v0).getLabel();
            }

            Function v6 = ((AccessibilityAction)arg6).getAction();
            if(v6 == null) {
                v6 = ((AccessibilityAction)v0).getAction();
            }

            v1.set(arg5, new AccessibilityAction(v3, v6));
        }

        if(arg5.getAccessibilityExtraKey$ui() != null) {
            MutableScatterSet v6_1 = this._accessibilityExtraKeys;
            if(v6_1 == null) {
                v6_1 = ScatterSetKt.mutableScatterSetOf();
                this._accessibilityExtraKeys = v6_1;
            }

            if(v6_1 == null) {
                return;
            }

            v6_1.add(arg5);
        }
    }

    public final void setClearingSemantics(boolean arg1) {
        this.isClearingSemantics = arg1;
    }

    public final void setMergingSemanticsOfDescendants(boolean arg1) {
        this.isMergingSemanticsOfDescendants = arg1;
    }

    public String toString() {
        String v2;
        SemanticsConfiguration v0 = this;
        StringBuilder v1 = new StringBuilder();
        String v3 = ", ";
        if(v0.isMergingSemanticsOfDescendants) {
            v1.append("mergeDescendants=true");
            v2 = v3;
        }
        else {
            v2 = "";
        }

        if(v0.isClearingSemantics) {
            v1.append(v2);
            v1.append("isClearingSemantics=true");
            v2 = v3;
        }

        MutableScatterMap v4 = v0.props;
        Object[] v5 = ((ScatterMap)v4).keys;
        Object[] v6 = ((ScatterMap)v4).values;
        long[] v4_1 = ((ScatterMap)v4).metadata;
        int v7 = v4_1.length - 2;
        if(v7 >= 0) {
            int v9;
            for(v9 = 0; true; ++v9) {
                long v10 = v4_1[v9];
                if((~v10 << 7 & v10 & -9187201950435737472L) != -9187201950435737472L) {
                    int v13 = 8;
                    int v12 = 8 - (~(v9 - v7) >>> 0x1F);
                    int v14;
                    for(v14 = 0; v14 < v12; ++v14) {
                        if((0xFF & v10) < 0x80) {
                            int v15 = (v9 << 3) + v14;
                            Object v16 = v5[v15];
                            Object v15_1 = v6[v15];
                            v1.append(v2);
                            v1.append(((SemanticsPropertyKey)v16).getName());
                            v1.append(" : ");
                            v1.append(v15_1);
                            v2 = v3;
                        }

                        v10 >>= v13;
                    }

                    if(v12 != v13) {
                        break;
                    }
                }

                if(v9 == v7) {
                    break;
                }
            }
        }

        return JvmActuals_jvmKt.simpleIdentityToString(v0, null) + "{ " + v1 + " }";
    }
}

