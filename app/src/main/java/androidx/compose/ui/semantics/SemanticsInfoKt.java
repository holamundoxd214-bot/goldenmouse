package androidx.compose.ui.semantics;

import androidx.collection.MutableObjectList;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001A\u000E\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001A\u000E\u0010\u0003\u001A\u0004\u0018\u00010\u0004*\u00020\u0001H\u0000¨\u0006\u0005"}, d2={"nearestParentThatHasSemantics", "Landroidx/compose/ui/semantics/SemanticsInfo;", "findMergingSemanticsParent", "mergedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsInfoKt {
    public static final SemanticsInfo findMergingSemanticsParent(SemanticsInfo arg2) {
        for(arg2 = arg2.getParentInfo(); arg2 != null; arg2 = arg2.getParentInfo()) {
            SemanticsConfiguration v0 = arg2.getSemanticsConfiguration();
            if(v0 != null && (v0.isMergingSemanticsOfDescendants())) {
                return arg2;
            }
        }

        return null;
    }

    public static final SemanticsConfiguration mergedSemanticsConfiguration(SemanticsInfo arg4) {
        SemanticsConfiguration v0 = arg4.getSemanticsConfiguration();
        if(v0 != null && (v0.isMergingSemanticsOfDescendants())) {
            if(v0.isClearingSemantics()) {
            }
            else {
                v0 = v0.copy();
                MutableObjectList v1 = new MutableObjectList(arg4.getChildrenInfo().size());
                v1.addAll(arg4.getChildrenInfo());
                while(v1.isNotEmpty()) {
                    Object v4 = v1.removeAt(v1._size - 1);
                    SemanticsConfiguration v2 = ((SemanticsInfo)v4).getSemanticsConfiguration();
                    if(v2 == null) {
                        continue;
                    }

                    if(v2.isMergingSemanticsOfDescendants()) {
                    }
                    else {
                        v0.mergeChild$ui(v2);
                        if(v2.isClearingSemantics()) {
                            continue;
                        }

                        v1.addAll(((SemanticsInfo)v4).getChildrenInfo());
                    }
                }
            }
        }

        return v0;
    }

    public static final SemanticsInfo nearestParentThatHasSemantics(SemanticsInfo arg1) {
        for(arg1 = arg1.getParentInfo(); arg1 != null; arg1 = arg1.getParentInfo()) {
            if(arg1.getSemanticsConfiguration() != null) {
                return arg1;
            }
        }

        return null;
    }
}

