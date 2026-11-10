package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.composer.GroupSourceInformation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001E\u0010\"\u001A\u00020#2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0003J\u000E\u0010%\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0003J\u0016\u0010&\u001A\u00020#2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020\u0003J\u0016\u0010&\u001A\u00020#2\u0006\u0010*\u001A\u00020+2\u0006\u0010)\u001A\u00020\u0003J\u001E\u0010,\u001A\u00020#2\u0006\u0010\'\u001A\u00020(2\u0006\u0010-\u001A\u00020\u00032\u0006\u0010)\u001A\u00020\u0003J\u000E\u0010.\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0003J\b\u0010/\u001A\u00020\u0000H\u0002J\u0010\u00100\u001A\u00020#2\u0006\u0010)\u001A\u00020\u0012H\u0002J\u0010\u00101\u001A\u00020\u00192\u0006\u00102\u001A\u000203H\u0002J\u000E\u00104\u001A\u00020\u00192\u0006\u00102\u001A\u000203R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0014\u0010\u0006\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\nR.\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\n\"\u0004\b \u0010!¨\u00065"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "key", "", "sourceInformation", "", "dataStartOffset", "<init>", "(ILjava/lang/String;I)V", "getKey", "()I", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "getDataStartOffset", "groups", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "setDataEndOffset", "(I)V", "startGrouplessCall", "", "dataOffset", "endGrouplessCall", "reportGroup", "writer", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "group", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "addGroupAfter", "predecessor", "close", "openInformation", "add", "hasAnchor", "anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "removeAnchor", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GapGroupSourceInformation implements GroupSourceInformation {
    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList groups;
    private final int key;
    private String sourceInformation;

    static {
    }

    public GapGroupSourceInformation(int arg1, String arg2, int arg3) {
        super();
        this.key = arg1;
        this.sourceInformation = arg2;
        this.dataStartOffset = arg3;
    }

    private final void add(Object arg2) {
        ArrayList v0 = this.getGroups();
        if(v0 == null) {
            v0 = new ArrayList();
        }

        this.setGroups(v0);
        v0.add(arg2);
    }

    public final void addGroupAfter(SlotWriter arg5, int arg6, int arg7) {
        ArrayList v0 = this.getGroups();
        if(v0 == null) {
            v0 = new ArrayList();
            this.setGroups(v0);
        }

        int v4 = 0;
        if(arg6 >= 0) {
            GapAnchor v6 = arg5.tryAnchor$runtime(arg6);
            if(v6 != null) {
                int v1 = v0.size();
                while(true) {
                    if(v4 < v1) {
                        Object v2 = v0.get(v4);
                        if(!Intrinsics.areEqual(v2, v6)) {
                            if(((v2 instanceof GapGroupSourceInformation)) && (((GapGroupSourceInformation)v2).hasAnchor(v6))) {
                                goto label_22;
                            }

                            ++v4;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_22;
                }

                v4 = -1;
            }
        }

    label_22:
        v0.add(v4, arg5.anchor(arg7));
    }

    public final void close(int arg2) {
        this.setClosed(true);
        this.setDataEndOffset(arg2);
    }

    public final void endGrouplessCall(int arg1) {
        this.openInformation().close(arg1);
    }

    public boolean getClosed() {
        return this.closed;
    }

    public int getDataEndOffset() {
        return this.dataEndOffset;
    }

    public int getDataStartOffset() {
        return this.dataStartOffset;
    }

    public ArrayList getGroups() {
        return this.groups;
    }

    public int getKey() {
        return this.key;
    }

    public String getSourceInformation() {
        return this.sourceInformation;
    }

    private final boolean hasAnchor(GapAnchor arg6) {
        ArrayList v5 = this.getGroups();
        if(v5 != null) {
            int v1 = v5.size();
            int v2 = 0;
            while(true) {
                if(v2 < v1) {
                    Object v3 = ((List)v5).get(v2);
                    if(!Intrinsics.areEqual(v3, arg6)) {
                        if(((v3 instanceof GapGroupSourceInformation)) && (((GapGroupSourceInformation)v3).hasAnchor(arg6))) {
                            return 1;
                        }

                        ++v2;
                        continue;
                    }

                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final GapGroupSourceInformation openInformation() {
        Object v3;
        ArrayList v0 = this.getGroups();
        Object v1 = null;
        if(v0 != null) {
            int v2 = v0.size() - 1;
            while(true) {
                if(v2 >= 0) {
                    v3 = v0.get(v2);
                    if(((v3 instanceof GapGroupSourceInformation)) && !v3.getClosed()) {
                        break;
                    }

                    --v2;
                    continue;
                }
                else {
                    goto label_15;
                }
            }
        }
        else {
        label_15:
            v3 = v1;
        }

        if((v3 instanceof GapGroupSourceInformation)) {
            v1 = v3;
        }

        if(v1 != null) {
            GapGroupSourceInformation v0_1 = ((GapGroupSourceInformation)v1).openInformation();
            if(v0_1 != null) {
                return v0_1;
            }
        }

        return this;
    }

    public final boolean removeAnchor(GapAnchor arg6) {
        ArrayList v0 = this.getGroups();
        if(v0 != null) {
            int v2;
            for(v2 = v0.size() - 1; v2 >= 0; --v2) {
                Object v3 = v0.get(v2);
                if((v3 instanceof GapAnchor)) {
                    if(Intrinsics.areEqual(v3, arg6)) {
                        v0.remove(v2);
                    }
                }
                else if(((v3 instanceof GapGroupSourceInformation)) && !((GapGroupSourceInformation)v3).removeAnchor(arg6)) {
                    v0.remove(v2);
                }
            }

            if(!v0.isEmpty()) {
                return 1;
            }

            this.setGroups(null);
            return 0;
        }

        return 1;
    }

    public final void reportGroup(SlotTable arg1, int arg2) {
        this.openInformation().add(arg1.anchor(arg2));
    }

    public final void reportGroup(SlotWriter arg1, int arg2) {
        this.openInformation().add(arg1.anchor(arg2));
    }

    public void setClosed(boolean arg1) {
        this.closed = arg1;
    }

    public void setDataEndOffset(int arg1) {
        this.dataEndOffset = arg1;
    }

    public void setGroups(ArrayList arg1) {
        this.groups = arg1;
    }

    public void setSourceInformation(String arg1) {
        this.sourceInformation = arg1;
    }

    public final void startGrouplessCall(int arg2, String arg3, int arg4) {
        this.openInformation().add(new GapGroupSourceInformation(arg2, arg3, arg4));
    }
}

