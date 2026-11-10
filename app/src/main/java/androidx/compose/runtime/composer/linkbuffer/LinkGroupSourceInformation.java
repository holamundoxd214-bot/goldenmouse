package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.GroupSourceInformation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001E\u0010!\u001A\u00020\"2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u0003J\u000E\u0010$\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0003J\u000E\u0010%\u001A\u00020\"2\u0006\u0010&\u001A\u00020\'J\u0018\u0010(\u001A\u00020\"2\b\u0010)\u001A\u0004\u0018\u00010\'2\u0006\u0010*\u001A\u00020\'J\u000E\u0010+\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0003J\b\u0010,\u001A\u00020\u0000H\u0002J\u0010\u0010-\u001A\u00020\"2\u0006\u0010*\u001A\u00020\u0012H\u0002J\u0010\u0010.\u001A\u00020\u00182\u0006\u0010&\u001A\u00020\'H\u0002J\u000E\u0010/\u001A\u00020\u00182\u0006\u0010&\u001A\u00020\'R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0014\u0010\u0006\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\nRF\u0010\u0014\u001A\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u001A\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u0018X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\n\"\u0004\b\u001F\u0010 ¨\u00060"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "key", "", "sourceInformation", "", "dataStartOffset", "<init>", "(ILjava/lang/String;I)V", "getKey", "()I", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "getDataStartOffset", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "groups", "getGroups", "()Ljava/util/ArrayList;", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "setDataEndOffset", "(I)V", "startGrouplessCall", "", "dataOffset", "endGrouplessCall", "reportGroup", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "addGroupAfter", "predecessor", "group", "close", "openInformation", "add", "hasGroup", "removeGroup", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LinkGroupSourceInformation implements GroupSourceInformation {
    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList groups;
    private final int key;
    private String sourceInformation;

    static {
    }

    public LinkGroupSourceInformation(int arg1, String arg2, int arg3) {
        super();
        this.key = arg1;
        this.sourceInformation = arg2;
        this.dataStartOffset = arg3;
    }

    private final void add(Object arg2) {
        ArrayList v0 = this.getGroups();
        if(v0 == null) {
            v0 = new ArrayList();
            this.groups = v0;
        }

        v0.add(arg2);
    }

    public final void addGroupAfter(LinkAnchor arg5, LinkAnchor arg6) {
        ArrayList v0 = this.getGroups();
        if(v0 == null) {
            v0 = new ArrayList();
            this.groups = v0;
        }

        int v4 = 0;
        if(arg5 != null) {
            int v1 = v0.size();
            while(true) {
                if(v4 < v1) {
                    Object v2 = v0.get(v4);
                    if(!Intrinsics.areEqual(v2, arg5)) {
                        if(((v2 instanceof LinkGroupSourceInformation)) && (((LinkGroupSourceInformation)v2).hasGroup(arg5))) {
                            goto label_20;
                        }

                        ++v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_20;
            }

            v4 = -1;
        }

    label_20:
        v0.add(v4, arg6);
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

    private final boolean hasGroup(LinkAnchor arg6) {
        ArrayList v5 = this.getGroups();
        if(v5 != null) {
            int v1 = v5.size();
            int v2 = 0;
            while(true) {
                if(v2 < v1) {
                    Object v3 = ((List)v5).get(v2);
                    if(!Intrinsics.areEqual(v3, arg6)) {
                        if(((v3 instanceof LinkGroupSourceInformation)) && (((LinkGroupSourceInformation)v3).hasGroup(arg6))) {
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

    private final LinkGroupSourceInformation openInformation() {
        ArrayList v0 = this.getGroups();
        Object v1 = null;
        if(v0 != null) {
            int v2;
            for(v2 = v0.size() - 1; v2 >= 0; --v2) {
                Object v3 = v0.get(v2);
                if(((v3 instanceof LinkGroupSourceInformation)) && !v3.getClosed()) {
                    v1 = v3;
                    break;
                }
            }
        }

        if(v1 != null) {
            LinkGroupSourceInformation v0_1 = ((LinkGroupSourceInformation)v1).openInformation();
            if(v0_1 != null) {
                return v0_1;
            }
        }

        return this;
    }

    public final boolean removeGroup(LinkAnchor arg6) {
        ArrayList v0 = this.getGroups();
        if(v0 != null) {
            int v2;
            for(v2 = v0.size() - 1; v2 >= 0; --v2) {
                Object v3 = v0.get(v2);
                if((v3 instanceof LinkAnchor)) {
                    if(Intrinsics.areEqual(v3, arg6)) {
                        v0.remove(v2);
                    }
                }
                else if(((v3 instanceof LinkGroupSourceInformation)) && !((LinkGroupSourceInformation)v3).removeGroup(arg6)) {
                    v0.remove(v2);
                }
            }

            if(!v0.isEmpty()) {
                return 1;
            }

            this.groups = null;
            return 0;
        }

        return 1;
    }

    public final void reportGroup(LinkAnchor arg1) {
        this.openInformation().add(arg1);
    }

    public void setClosed(boolean arg1) {
        this.closed = arg1;
    }

    public void setDataEndOffset(int arg1) {
        this.dataEndOffset = arg1;
    }

    public void setSourceInformation(String arg1) {
        this.sourceInformation = arg1;
    }

    public final void startGrouplessCall(int arg2, String arg3, int arg4) {
        this.openInformation().add(new LinkGroupSourceInformation(arg2, arg3, arg4));
    }
}

