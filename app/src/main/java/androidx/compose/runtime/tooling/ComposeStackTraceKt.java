package androidx.compose.runtime.tooling;

import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0000\u001A\u001C\u0010\u0006\u001A\u00020\u0002*\u00020\u00022\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0000\u001A\u0018\u0010\u0007\u001A\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001A\u00020\u0005H\u0000\u001A\u0018\u0010\u000B\u001A\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001A\u00020\u0005H\u0000\u001A\u0012\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r*\u00020\u0005H\u0000\u001A\u0018\u0010\u000F\u001A\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001A\u00020\u0005H\u0000\"\u000E\u0010\u0010\u001A\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"tryAttachComposeStackTrace", "", "", "trace", "Lkotlin/Function0;", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "attachComposeStackTrace", "appendStackTrace", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendSourceInformationStackTrace", "filterInternalFramesByGroupKey", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "appendGroupKeyStackTrace", "RuntimePackageHash", "", "IncludeDebugInfo", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposeStackTraceKt {
    private static final boolean IncludeDebugInfo = false;
    private static final String RuntimePackageHash = "9igjgp";

    public static final void appendGroupKeyStackTrace(StringBuilder arg4, ComposeStackTrace arg5) {
        List v5 = ComposeStackTraceKt.filterInternalFramesByGroupKey(arg5);
        int v0 = v5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v5.get(v1);
            arg4.append("\tat $$compose.m$");
            arg4.append(((ComposeStackTraceFrame)v2).getGroupKey());
            arg4.append("(SourceFile:1)");
            arg4.append('\n');
        }
    }

    public static final void appendSourceInformationStackTrace(StringBuilder arg12, ComposeStackTrace arg13) {
        List v0 = CollectionsKt.createListBuilder();
        List v13 = CollectionsKt.asReversed(arg13.getFrames());
        int v1 = v13.size();
        String v2 = null;
        int v3 = 0;
        String v5 = v2;
        String v6 = v5;
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            Object v7 = v13.get(v4);
            SourceInformation v8 = ((ComposeStackTraceFrame)v7).getSourceInfo();
            if(v8 != null) {
                String v9 = v8.getFunctionName();
                if(v9 == null) {
                    v9 = v8.isCall() ? "<lambda>" : v2;
                    if(v9 != null) {
                        goto label_25;
                    }

                    if(v5 != null) {
                        goto label_26;
                    }

                    v5 = "<unknown function>";
                }
                else {
                label_25:
                    v5 = v9;
                }

            label_26:
                v9 = v8.getSourceFile();
                if(v9 != null) {
                    v6 = v9;
                }
                else if(v6 == null) {
                    v6 = "<unknown file>";
                }

                List v9_1 = v8.getLocations();
                String v7_1 = ((ComposeStackTraceFrame)v7).getGroupOffset() == null || ((ComposeStackTraceFrame)v7).getGroupOffset().intValue() >= v9_1.size() ? "<unknown line>" : String.valueOf(v9_1.get(((ComposeStackTraceFrame)v7).getGroupOffset().intValue()).getLineNumber());
                v7_1 = v5 + '(' + v6 + ':' + v7_1 + ')';
                if(!v8.isCall()) {
                    CollectionsKt.removeLastOrNull(v0);
                }

                if((Intrinsics.areEqual(v8.getFunctionName(), "rememberCompositionContext")) && (Intrinsics.areEqual(v8.getPackageHash(), "9igjgp"))) {
                    goto label_71;
                }

                v0.add(v7_1);
            }

        label_71:
        }

        v13 = CollectionsKt.asReversed(CollectionsKt.build(v0));
        int v0_1 = v13.size();
        while(v3 < v0_1) {
            Object v1_1 = v13.get(v3);
            arg12.append("\tat ");
            arg12.append(((String)v1_1)).append('\n');
            ++v3;
        }
    }

    public static final void appendStackTrace(StringBuilder arg1, ComposeStackTrace arg2) {
        if(arg2.getHasSourceInformation()) {
            ComposeStackTraceKt.appendSourceInformationStackTrace(arg1, arg2);
            return;
        }

        ComposeStackTraceKt.appendGroupKeyStackTrace(arg1, arg2);
    }

    public static final Throwable attachComposeStackTrace(Throwable arg0, Function0 arg1) {
        ComposeStackTraceKt.tryAttachComposeStackTrace(arg0, arg1);
        return arg0;
    }

    public static final List filterInternalFramesByGroupKey(ComposeStackTrace arg8) {
        int[] v0 = new int[]{201, 202, 204, 206, 0xCF, 0x7D, 0xFFFFFF81, 0x78CC281, 200};
        int v1 = arg8.getFrames().size();
        ArrayList v2 = new ArrayList();
        int v3;
        for(v3 = 0; v3 < v1; v3 = v5) {
            int v5 = v3 + 1;
            Object v4 = arg8.getFrames().get(v3);
            if(!ArraysKt.contains(v0, ((ComposeStackTraceFrame)v4).getGroupKey())) {
                if(((ComposeStackTraceFrame)v4).getGroupKey() == 100) {
                    v3 += 2;
                    if(v3 < v1 && arg8.getFrames().get(v3).getGroupKey() == 1000) {
                        break;
                    }

                    CollectionsKt.removeLastOrNull(((List)v2));
                }
                else {
                    v2.add(v4);
                }
            }
        }

        return ((List)v2);
    }

    public static final boolean tryAttachComposeStackTrace(Throwable arg5, Function0 arg6) {
        DiagnosticComposeException v0_1;
        List v0 = ExceptionsKt.getSuppressedExceptions(arg5);
        int v1 = v0.size();
        boolean v2 = false;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if((v0.get(v3) instanceof DiagnosticComposeException)) {
                return 0;
            }
        }

        try {
            Object v6_1 = arg6.invoke();
            if(v6_1 != null) {
                if(((ComposeStackTrace)v6_1).getHasSourceInformation()) {
                    v0 = ((ComposeStackTrace)v6_1).getFrames();
                    v1 = v0.size();
                    v3 = 0;
                    goto label_20;
                }
                else {
                    if(((ComposeStackTrace)v6_1).getFrames().isEmpty()) {
                        goto label_32;
                    }

                    goto label_30;
                    while(true) {
                    label_20:
                        if(v3 >= v1) {
                            goto label_32;
                        }
                        else if(v0.get(v3).getSourceInfo() != null) {
                        }
                        else {
                            ++v3;
                            continue;
                        }

                        break;
                    }
                }

            label_30:
                v2 = true;
            }

        label_32:
            if(v2) {
                Intrinsics.checkNotNull(v6_1);
                v0_1 = new DiagnosticComposeException(((ComposeStackTrace)v6_1));
            }
            else {
                v0_1 = null;
            }
        }
        catch(Throwable v6) {
            Throwable v0_2 = v6;
        }

        if(v0_1 != null) {
            ExceptionsKt.addSuppressed(arg5, ((Throwable)v0_1));
        }

        return v2;
    }
}

