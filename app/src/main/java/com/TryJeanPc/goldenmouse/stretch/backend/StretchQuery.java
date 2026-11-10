package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "", "<init>", "(Ljava/lang/String;I)V", "BACKEND_STATUS", "EFFECTIVE_UID", "DISPLAY_SIZE", "DISPLAY_DENSITY", "arguments", "", "", "getArguments$app", "()Ljava/util/List;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchQuery {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchQuery.values().length];
            try {
                v0[StretchQuery.BACKEND_STATUS.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchQuery.EFFECTIVE_UID.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchQuery.DISPLAY_SIZE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchQuery.DISPLAY_DENSITY.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final enum StretchQuery BACKEND_STATUS;
    public static final enum StretchQuery DISPLAY_DENSITY;
    public static final enum StretchQuery DISPLAY_SIZE;
    public static final enum StretchQuery EFFECTIVE_UID;

    private static final StretchQuery[] $values() {
        return new StretchQuery[]{StretchQuery.BACKEND_STATUS, StretchQuery.EFFECTIVE_UID, StretchQuery.DISPLAY_SIZE, StretchQuery.DISPLAY_DENSITY};
    }

    static {
        StretchQuery.BACKEND_STATUS = new StretchQuery("BACKEND_STATUS", 0);
        StretchQuery.EFFECTIVE_UID = new StretchQuery("EFFECTIVE_UID", 1);
        StretchQuery.DISPLAY_SIZE = new StretchQuery("DISPLAY_SIZE", 2);
        StretchQuery.DISPLAY_DENSITY = new StretchQuery("DISPLAY_DENSITY", 3);
        StretchQuery[] v0 = StretchQuery.$values();
        StretchQuery.$VALUES = v0;
        StretchQuery.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchQuery(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public final List getArguments$app() {
        String[] v5_1;
        int v5 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v5 != 1) {
            int v2 = 2;
            if(v5 != v2) {
                String v4 = "wm";
                if(v5 != 3) {
                    if(v5 == 4) {
                        v5_1 = new String[v2];
                        v5_1[0] = v4;
                        v5_1[1] = "density";
                        return CollectionsKt.listOf(((Object[])v5_1));
                    }

                    throw new NoWhenBranchMatchedException();
                }

                v5_1 = new String[v2];
                v5_1[0] = v4;
                v5_1[1] = "size";
                return CollectionsKt.listOf(((Object[])v5_1));
            }

            v5_1 = new String[v2];
            v5_1[0] = "id";
            v5_1[1] = "-u";
            return CollectionsKt.listOf(((Object[])v5_1));
        }

        return null;
    }

    public static EnumEntries getEntries() {
        return StretchQuery.$ENTRIES;
    }

    public static StretchQuery valueOf(String arg1) {
        return Enum.valueOf(StretchQuery.class, arg1);
    }

    public static StretchQuery[] values() {
        return StretchQuery.$VALUES.clone();
    }
}

