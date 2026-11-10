package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2={"repr", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DebugProbesImplKt {
    public static final String access$repr(String arg0) {
        return DebugProbesImplKt.repr(arg0);
    }

    private static final String repr(String arg6) {
        char v3;
        StringBuilder v0 = new StringBuilder("\"");
        int v1 = arg6.length();
        int v2;
        for(v2 = 0; true; ++v2) {
            v3 = '\"';
            if(v2 >= v1) {
                break;
            }

            char v4 = arg6.charAt(v2);
            if(v4 == 13) {
                v0.append("\\r");
            }
            else if(v4 == v3) {
                v0.append("\\\"");
            }
            else if(v4 != 92) {
                switch(v4) {
                    case 8: {
                        goto label_22;
                    }
                    case 9: {
                        goto label_19;
                    }
                    case 10: {
                        goto label_16;
                    }
                }

                v0.append(v4);
                goto label_33;
            label_19:
                v0.append("\\t");
                goto label_33;
            label_22:
                v0.append("\\b");
                goto label_33;
            label_16:
                v0.append("\\n");
            }
            else {
                v0.append("\\\\");
            }

        label_33:
        }

        v0.append(v3);
        return v0.toString();
    }
}

