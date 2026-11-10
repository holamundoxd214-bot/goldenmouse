package androidx.compose.runtime.tooling;

import androidx.compose.runtime.internal.Utils_androidKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0002\u001A\u0012\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001A\u0012\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002\u001A\u0012\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\t*\u00020\u0007H\u0002\u001A\f\u0010\u000E\u001A\u00020\u0003*\u00020\u0003H\u0002¨\u0006\u000F"}, d2={"parseSourceInformation", "Landroidx/compose/runtime/tooling/SourceInformation;", "data", "", "parseSourceInformationInternal", "hasSection", "", "Landroidx/compose/runtime/tooling/SourceInfoParserState;", "parseParameterIndex", "", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "parseParameterNames", "parseLocations", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "replaceComposePrefix", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SourceInformationKt {
    private static final boolean hasSection(SourceInfoParserState arg3) {
        if(arg3.getI() < arg3.getData().length() - 1 && (Character.isLetter(arg3.getData().charAt(arg3.getI()))) && arg3.getData().charAt(arg3.getI() + 1) == 40) {
            return 1;
        }

        return 0;
    }

    private static final List parseLocations(SourceInfoParserState arg10) {
        Integer v7;
        boolean v1;
        Object v3;
        ArrayList v0 = new ArrayList();
        while(true) {
            v3 = null;
            if(!arg10.atEnd() && !arg10.matches(':')) {
                if(arg10.matches('*')) {
                    SourceInfoParserState.advance$default(arg10, 0, 1, v3);
                    v1 = true;
                }
                else {
                    v1 = false;
                }

                Integer v5 = !arg10.matches('@') ? Integer.valueOf(arg10.takeIntUntil("@") + 1) : ((Integer)v3);
                SourceInfoParserState.advance$default(arg10, 0, 1, v3);
                int v6 = arg10.takeIntUntil("L,:");
                if(arg10.matches('L')) {
                    SourceInfoParserState.advance$default(arg10, 0, 1, v3);
                    v7 = Integer.valueOf(arg10.takeIntUntil(",:"));
                }
                else {
                    v7 = ((Integer)v3);
                }

                int v9 = -1;
                int v5_1 = v5 != null ? v5.intValue() : v9;
                if(v7 != null) {
                    v9 = v7.intValue();
                }

                ((List)v0).add(new LocationSourceInformation(v5_1, v6, v9, v1));
                if(!arg10.matches(',')) {
                    continue;
                }

                SourceInfoParserState.advance$default(arg10, 0, 1, v3);
                continue;
            }

            break;
        }

        SourceInfoParserState.advance$default(arg10, 0, 1, v3);
        return ((List)v0);
    }

    private static final List parseParameterIndex(SourceInfoParserState arg18) {
        String v11;
        int v9;
        int v4_1;
        Object v6;
        char v5;
        SourceInfoParserState v0 = arg18;
        v0.advance(2);
        ArrayList v1 = new ArrayList();
        int v3 = 0;
        while(true) {
            v5 = ')';
            v6 = null;
            if(!v0.atEnd() && !v0.matches(v5)) {
                String v5_1 = "!,)";
                if(v0.matches('!')) {
                    SourceInfoParserState.advance$default(v0, 0, 1, v6);
                    String v4 = v0.takeUntil(v5_1);
                    if(v4.length() == 0) {
                        v3 = 1;
                    }
                    else {
                        v4_1 = Integer.parseInt(v4);
                        v9 = 0;
                    label_27:
                        while(v4_1 > 0) {
                            int v5_2 = v1.size();
                            int v8 = 0;
                            while(true) {
                                if(v8 >= v5_2) {
                                    break;
                                }
                                else if(((List)v1).get(v8).getSortedIndex() == v9) {
                                    ++v9;
                                    goto label_27;
                                }
                                else {
                                    ++v8;
                                    continue;
                                }
                            }

                            ((List)v1).add(new ParameterSourceInformation(v9, null, null, 6, null));
                            --v4_1;
                        }
                    }
                }
                else {
                    v9 = v0.takeIntUntil("!:,)");
                    if(v0.matches(':')) {
                        SourceInfoParserState.advance$default(v0, 0, 1, v6);
                        v11 = SourceInformationKt.replaceComposePrefix(v0.takeUntil(v5_1));
                    }
                    else {
                        v11 = ((String)v6);
                    }

                    if(v3 != 0) {
                        int v13 = 0;
                    label_61:
                        while(v13 < v9) {
                            v3 = v1.size();
                            v4_1 = 0;
                            while(true) {
                                if(v4_1 >= v3) {
                                    break;
                                }
                                else if(((List)v1).get(v4_1).getSortedIndex() == v13) {
                                    ++v13;
                                    goto label_61;
                                }
                                else {
                                    ++v4_1;
                                    continue;
                                }
                            }

                            ((List)v1).add(new ParameterSourceInformation(v13, null, null, 6, null));
                        }

                        v3 = 0;
                    }

                    ((List)v1).add(new ParameterSourceInformation(v9, null, v11, 2, null));
                }

                if(!v0.matches(',')) {
                    continue;
                }

                SourceInfoParserState.advance$default(v0, 0, 1, v6);
                continue;
            }

            break;
        }

        v0.expect(v5);
        SourceInfoParserState.advance$default(v0, 0, 1, v6);
        return ((List)v1);
    }

    private static final List parseParameterNames(SourceInfoParserState arg8) {
        String v2_1;
        Object v5;
        char v2;
        arg8.advance(2);
        ArrayList v0 = new ArrayList();
        while(true) {
            v2 = ')';
            v5 = null;
            if(!arg8.atEnd() && !arg8.matches(v2)) {
                String v1 = arg8.takeUntil(":,)");
                if(arg8.matches(':')) {
                    SourceInfoParserState.advance$default(arg8, 0, 1, v5);
                    v2_1 = SourceInformationKt.replaceComposePrefix(arg8.takeUntil(",)"));
                }
                else {
                    v2_1 = ((String)v5);
                }

                ((List)v0).add(new ParameterSourceInformation(((List)v0).size(), v1, v2_1));
                if(!arg8.matches(',')) {
                    continue;
                }

                SourceInfoParserState.advance$default(arg8, 0, 1, v5);
                continue;
            }

            break;
        }

        arg8.expect(v2);
        SourceInfoParserState.advance$default(arg8, 0, 1, v5);
        return ((List)v0);
    }

    public static final SourceInformation parseSourceInformation(String arg2) {
        SourceInformation v1 = null;
        if(arg2.length() == 0) {
            return v1;
        }

        try {
            return SourceInformationKt.parseSourceInformationInternal(arg2);
        }
        catch(ParseException v2) {
            Utils_androidKt.logError(v2.getMessage(), ((Throwable)v2));
            return v1;
        }
    }

    public static final SourceInformation parseSourceInformationInternal(String arg13) {
        String v7_1;
        int v11;
        boolean v8;
        String v2;
        boolean v1_1;
        SourceInfoParserState v0 = new SourceInfoParserState(arg13);
        char v1 = 'C';
        char v3 = '(';
        char v4 = ')';
        Object v7 = null;
        if(v0.matches(v1)) {
            SourceInfoParserState.advance$default(v0, 0, 1, v7);
            if(v0.matches(v1)) {
                SourceInfoParserState.advance$default(v0, 0, 1, v7);
                v1_1 = true;
            }
            else {
                v1_1 = false;
            }

            if(v0.matches(v3)) {
                SourceInfoParserState.advance$default(v0, 0, 1, v7);
                v2 = v0.takeUntil(")");
                v0.expect(v4);
                SourceInfoParserState.advance$default(v0, 0, 1, v7);
                v8 = true;
                goto label_31;
            }

            v8 = true;
            goto label_30;
        }
        else {
            v1_1 = false;
            v8 = false;
        label_30:
            v2 = ((String)v7);
        }

    label_31:
        List v10 = CollectionsKt.emptyList();
    label_32:
        while(SourceInformationKt.hasSection(v0)) {
            v11 = v0.current();
            if(v11 != 78) {
                if(v11 != 80) {
                    v0.advance(2);
                    v11 = 0;
                    goto label_42;
                }

                v10 = SourceInformationKt.parseParameterIndex(v0);
                continue;
            }

            v10 = SourceInformationKt.parseParameterNames(v0);
        }

        List v3_1 = CollectionsKt.emptyList();
        if(!v0.matches(':')) {
            v3_1 = SourceInformationKt.parseLocations(v0);
        }
        else {
            SourceInfoParserState.advance$default(v0, 0, 1, v7);
        }

        String v4_1 = v0.takeUntil("#");
        if(v4_1.length() > 0) {
        }
        else {
            v4_1 = ((String)v7);
        }

        if(v0.matches('#')) {
            SourceInfoParserState.advance$default(v0, 0, 1, v7);
            v7_1 = v0.takeUntilEnd();
        }

        return new SourceInformation(v8, v1_1, v2, v4_1, v10, v7_1, v3_1, arg13);
        while(true) {
        label_42:
            if(v11 <= 0) {
                if(!v0.matches(v4)) {
                }
                else {
                    v0.expect(v4);
                    SourceInfoParserState.advance$default(v0, 0, 1, v7);
                    goto label_32;
                }
            }

            if(v0.atEnd()) {
                break;
            }

            if(v0.matches(v3)) {
                ++v11;
            }
            else if(v0.matches(v4)) {
                --v11;
            }

            SourceInfoParserState.advance$default(v0, 0, 1, v7);
        }

        v0.throwParseError("unexpected end");
        throw new KotlinNothingValueException();
    }

    private static final String replaceComposePrefix(String arg6) {
        return StringsKt.replaceFirst$default(arg6, "c#", "androidx.compose.", false, 4, null);
    }
}

