package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.composer.GroupSourceInformation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\bJ$\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0002J&\u0010\u0010\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0013\u001A\u00020\u0001H\u0002J\f\u0010\u0014\u001A\u00020\u0015*\u00020\u000EH\u0002J,\u0010\u0016\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00012\b\u0010\u0018\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001J \u0010\u001A\u001A\u00020\u00152\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u0001H\u0002J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u001C\u001A\u00020\u001DH&J\u0010\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u001DH&R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "", "<init>", "()V", "_trace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "trace", "", "appendTraceFrame", "", "groupKey", "", "groupSourceInformation", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "child", "extractTraceFrame", "targetChild", "sourceInformationOf", "group", "isCall", "", "processEdge", "objectKey", "sourceInformation", "childData", "appendGroupSourceInformation", "target", "anchor", "Landroidx/compose/runtime/Anchor;", "groupKeyOf", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ComposeStackTraceBuilder {
    public static final int $stable = 8;
    private final List _trace;

    static {
    }

    public ComposeStackTraceBuilder() {
        super();
        this._trace = new ArrayList();
    }

    private final boolean appendGroupSourceInformation(int arg8, GroupSourceInformation arg9, Object arg10) {
        Object v5_1;
        ArrayList v0 = arg9.getGroups();
        boolean v1 = false;
        if(v0 == null) {
            Object v3 = null;
            if(!arg9.getClosed()) {
                this.appendTraceFrame(arg8, arg9, v3);
                return 1;
            }

            arg8 = arg9.getDataStartOffset();
            int v0_1 = arg9.getDataEndOffset();
            boolean v4 = arg10 instanceof Integer;
            if(v4) {
                int v5 = ((Number)arg10).intValue();
                if(arg8 <= v5 && v5 < v0_1) {
                    goto label_22;
                }
                else if(arg8 == v0_1) {
                    if(!v4) {
                    }
                    else if(arg8 == ((Number)arg10).intValue()) {
                    label_22:
                        v1 = true;
                    }
                }

                if(!v1) {
                    return v1;
                }

                this.appendTraceFrame(arg9.getKey(), arg9, v3);
            }

            return v1;
        }

        int v3_1 = v0.size();
        int v4_1;
        for(v4_1 = 0; true; ++v4_1) {
            if(v4_1 >= v3_1) {
                return 0;
            }

            v5_1 = ((List)v0).get(v4_1);
            if((v5_1 instanceof Anchor)) {
                if(Intrinsics.areEqual(v5_1, arg10)) {
                    this.appendTraceFrame(arg9.getKey(), arg9, v5_1);
                    return 1;
                }
            }
            else if(!(v5_1 instanceof GroupSourceInformation)) {
                break;
            }
            else if(this.appendGroupSourceInformation(arg8, v5_1, arg10)) {
                this.appendTraceFrame(arg9.getKey(), arg9, v5_1);
                return 1;
            }
        }

        throw new IllegalStateException("Unexpected child source info " + v5_1.toString());
        return 0;
    }

    private final void appendTraceFrame(int arg1, GroupSourceInformation arg2, Object arg3) {
        ComposeStackTraceFrame v1 = this.extractTraceFrame(arg1, arg2, arg3);
        if(v1 != null) {
            this._trace.add(v1);
        }
    }

    private final ComposeStackTraceFrame extractTraceFrame(int arg12, GroupSourceInformation arg13, Object arg14) {
        SourceInformation v1_1;
        Integer v0 = null;
        if(arg13 != null) {
            String v1 = arg13.getSourceInformation();
            if(v1 != null) {
                v1_1 = SourceInformationKt.parseSourceInformation(v1);
            }
            else {
                goto label_6;
            }
        }
        else {
        label_6:
            v1_1 = ((SourceInformation)v0);
        }

        if(v1_1 != null) {
            if(arg14 == null) {
                return new ComposeStackTraceFrame(arg12, v1_1, v0);
            }

            ArrayList v13 = arg13.getGroups();
            int v2 = 0;
            if(v13 != null) {
                int v3 = v13.size();
                int v4 = 0;
                int v5 = 0;
                while(v4 < v3) {
                    Object v6 = v13.get(v4);
                    if(Intrinsics.areEqual(v6, arg14)) {
                        break;
                    }

                    GroupSourceInformation v7 = this.sourceInformationOf(v6);
                    if(v7 != null) {
                        int v10 = 0xFFFFFF81;
                        if(v7.getKey() != v10) {
                            if(v7.getKey() != 0) {
                            }
                            else if(!(v6 instanceof Anchor)) {
                            }
                            else if(this.groupKeyOf(((Anchor)v6)) == v10) {
                                goto label_35;
                            }

                            goto label_55;
                        }

                    label_35:
                        String v6_1 = v7 != null ? v7.getSourceInformation() : ((String)v0);
                        if(v6_1 != null) {
                            goto label_55;
                        }

                        if(v7 == null) {
                            goto label_59;
                        }

                        ArrayList v6_2 = v7.getGroups();
                        if(v6_2 == null) {
                            goto label_59;
                        }

                        int v7_1 = v6_2.size();
                        int v9;
                        for(v9 = 0; v9 < v7_1; ++v9) {
                            GroupSourceInformation v10_1 = this.sourceInformationOf(((List)v6_2).get(v9));
                            if(v10_1 != null && (this.isCall(v10_1))) {
                                ++v5;
                            }
                        }
                    }
                    else {
                    label_55:
                        if(v7 == null) {
                            goto label_59;
                        }

                        if(!this.isCall(v7)) {
                            goto label_59;
                        }

                        ++v5;
                    }

                label_59:
                    ++v4;
                }

                v2 = v5;
            }

            return new ComposeStackTraceFrame(arg12, v1_1, Integer.valueOf(v2));
        }

        return new ComposeStackTraceFrame(arg12, ((SourceInformation)v0), v0);
    }

    public abstract int groupKeyOf(Anchor arg1);

    private final boolean isCall(GroupSourceInformation arg4) {
        String v3 = arg4.getSourceInformation();
        if(v3 != null && (StringsKt.startsWith$default(v3, "C", false, 2, null))) {
            return 1;
        }

        return 0;
    }

    public final void processEdge(int arg2, Object arg3, GroupSourceInformation arg4, Object arg5) {
        if(arg4 != null || (Intrinsics.areEqual(arg3, Composer.Companion.getEmpty()))) {
            if(arg5 != null) {
                if(arg4 == null) {
                }
                else {
                    if(this.appendGroupSourceInformation(arg2, arg4, arg5)) {
                    }
                    else if(!arg4.getClosed()) {
                        this.appendTraceFrame(arg2, arg4, arg5);
                    }
                    else {
                    }

                    return;
                }
            }

            goto label_15;
        }
        else {
        }

        return;
    label_15:
        this.appendTraceFrame(arg2, arg4, null);
    }

    private final GroupSourceInformation sourceInformationOf(Object arg3) {
        if((arg3 instanceof Anchor)) {
            return this.sourceInformationOf(((Anchor)arg3));
        }

        if((arg3 instanceof GroupSourceInformation)) {
            return arg3;
        }

        throw new IllegalStateException("Unexpected child source info " + arg3.toString());
    }

    public abstract GroupSourceInformation sourceInformationOf(Anchor arg1);

    public final List trace() {
        return this._trace;
    }
}

