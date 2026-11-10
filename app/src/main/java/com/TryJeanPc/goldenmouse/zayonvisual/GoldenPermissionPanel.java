package com.TryJeanPc.goldenmouse.zayonvisual;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.EvaluatedRequirement;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.RequirementAction;
import com.TryJeanPc.goldenmouse.RequirementDefinition;
import com.TryJeanPc.goldenmouse.RequirementType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\n0\u000FR\u0016\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenPermissionPanel;", "", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rows", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "render", "", "requirements", "", "Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "onRetry", "Lkotlin/Function0;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenPermissionPanel {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[RequirementType.values().length];
            try {
                v0[RequirementType.MANDATORY.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[RequirementType.OPTIONAL.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[RequirementType.RECOMMENDATION.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final LinearLayout rows;

    static {
    }

    public GoldenPermissionPanel(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "root");
        super();
        this.rows = arg2.findViewById(id.golden_permission_rows);
    }

    public final void render(List arg11, Function0 arg12) {
        String v7_1;
        String v6_1;
        Intrinsics.checkNotNullParameter(arg11, "requirements");
        Intrinsics.checkNotNullParameter(arg12, "onRetry");
        this.rows.removeAllViews();
        int v0 = 2;
        Function1[] v1 = new Function1[v0];
        v1[0] = new GoldenPermissionPanel$$ExternalSyntheticLambda0();
        v1[1] = new GoldenPermissionPanel$$ExternalSyntheticLambda1();
        Iterator v11 = CollectionsKt.sortedWith(((Iterable)arg11), ComparisonsKt.compareBy(v1)).iterator();
        while(v11.hasNext()) {
            Object v1_1 = v11.next();
            RequirementDefinition v2 = ((EvaluatedRequirement)v1_1).getDefinition();
            View v5 = LayoutInflater.from(this.rows.getContext()).inflate(layout.item_golden_requirement, this.rows, false);
            v5.setTag(v2.getId());
            v5.findViewById(id.golden_requirement_title).setText(v2.getName());
            int v6 = WhenMappings.$EnumSwitchMapping$0[v2.getType().ordinal()];
            if(v6 == 1) {
                v6_1 = "Necesario";
            }
            else if(v6 == v0) {
                v6_1 = "Opcional";
            }
            else if(v6 == 3) {
                v6_1 = "Recomendado";
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            v5.findViewById(id.golden_requirement_description).setText(v6_1 + " · " + v2.getDescription());
            v5.findViewById(id.golden_requirement_status).setText(((EvaluatedRequirement)v1_1).getStatus().getMessage());
            View v6_2 = v5.findViewById(id.golden_requirement_action);
            RequirementAction v7 = v2.getAction();
            if(v7 != null) {
                v7_1 = v7.getLabel();
                if(v7_1 != null) {
                }
                else {
                    goto label_73;
                }
            }
            else {
            label_73:
                v7_1 = "REINTENTAR";
            }

            ((TextView)v6_2).setText(((CharSequence)v7_1));
            boolean v1_2 = (((EvaluatedRequirement)v1_1).getApplicable()) || v2.getAction() != null ? true : false;
            ((TextView)v6_2).setEnabled(v1_2);
            ((TextView)v6_2).setContentDescription(((TextView)v6_2).getText() + ": " + v2.getName());
            ((TextView)v6_2).setOnClickListener(new GoldenPermissionPanel$$ExternalSyntheticLambda2(v2, arg12, ((TextView)v6_2)));
            this.rows.addView(v5);
        }
    }

    static final Comparable render$lambda$0(EvaluatedRequirement arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Integer.valueOf(arg1.getDefinition().getType().ordinal());
    }

    static final Comparable render$lambda$1(EvaluatedRequirement arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Integer.valueOf(arg1.getDefinition().getOrder());
    }

    static final void render$lambda$4$lambda$3$lambda$2(RequirementDefinition arg0, Function0 arg1, TextView arg2, View arg3) {
        boolean v0_1;
        RequirementAction v0 = arg0.getAction();
        if(v0 == null) {
            arg1.invoke();
            return;
        }

        try {
            v0_1 = v0.getOpen().invoke().booleanValue();
        }
        catch(RuntimeException ) {
            v0_1 = false;
        }

        if(!v0_1) {
            Toast.makeText(arg2.getContext(), "No se pudo abrir Ajustes en este dispositivo", 1).show();
        }
    }
}

