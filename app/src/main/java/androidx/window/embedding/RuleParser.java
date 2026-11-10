package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import androidx.window.R$styleable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0001\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0002\b\u000BJ$\u0010\f\u001A\u00020\r*\u0012\u0012\u0004\u0012\u00020\u00060\u000Ej\b\u0012\u0004\u0012\u00020\u0006`\u000F2\u0006\u0010\u0010\u001A\u00020\u0006H\u0002J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u001A\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010$H\u0002¨\u0006%"}, d2={"Landroidx/window/embedding/RuleParser;", "", "<init>", "()V", "parseRules", "", "Landroidx/window/embedding/EmbeddingRule;", "context", "Landroid/content/Context;", "staticRuleResourceId", "", "parseRules$window_release", "addRuleWithDuplicatedTagCheck", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "rule", "parseSplitPairRule", "Landroidx/window/embedding/SplitPairRule;", "parser", "Landroid/content/res/XmlResourceParser;", "parseSplitPlaceholderRule", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitPairFilter", "Landroidx/window/embedding/SplitPairFilter;", "parseActivityRule", "Landroidx/window/embedding/ActivityRule;", "parseActivityFilter", "Landroidx/window/embedding/ActivityFilter;", "parseDividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "buildClassName", "Landroid/content/ComponentName;", "pkg", "", "clsSeq", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RuleParser {
    public static final RuleParser INSTANCE;

    static {
        RuleParser.INSTANCE = new RuleParser();
    }

    private RuleParser() {
        super();
    }

    private final void addRuleWithDuplicatedTagCheck(HashSet arg3, EmbeddingRule arg4) {
        String v2 = arg4.getTag();
        Iterator v0 = arg3.iterator();
        while(true) {
            if(!v0.hasNext()) {
                goto label_24;
            }

            Object v1 = v0.next();
            if(v2 == null) {
                continue;
            }

            if(Intrinsics.areEqual(v2, ((EmbeddingRule)v1).getTag())) {
                break;
            }
        }

        throw new IllegalArgumentException("Duplicated tag: " + v2 + " for " + arg4 + ". The tag must be unique in XML rule definition.");
    label_24:
        arg3.add(arg4);
    }

    private final ComponentName buildClassName(String arg9, CharSequence arg10) {
        if(arg10 != null && arg10.length() != 0) {
            String v8 = arg10.toString();
            char v1 = '.';
            if(v8.charAt(0) == v1) {
                return new ComponentName(arg9, arg9 + v8);
            }
            else {
                int v0 = StringsKt.indexOf$default(v8, '/', 0, false, 6, null);
                if(v0 > 0) {
                    arg9 = v8.substring(0, v0);
                    Intrinsics.checkNotNullExpressionValue(arg9, "substring(...)");
                    v8 = v8.substring(v0 + 1);
                    Intrinsics.checkNotNullExpressionValue(v8, "substring(...)");
                }

                if(!Intrinsics.areEqual(v8, "*") && StringsKt.indexOf$default(v8, '.', 0, false, 6, null) < 0) {
                    StringBuilder v10 = new StringBuilder(arg9);
                    v10.append(v1);
                    v10.append(v8);
                    return new ComponentName(arg9, v10.toString());
                }

                return new ComponentName(arg9, v8);
            }
        }

        throw new IllegalArgumentException("Activity name must not be null");
    }

    private final ActivityFilter parseActivityFilter(Context arg4, XmlResourceParser arg5) {
        TypedArray v5 = arg4.getTheme().obtainStyledAttributes(((AttributeSet)arg5), styleable.ActivityFilter, 0, 0);
        String v0 = v5.getString(styleable.ActivityFilter_activityName);
        String v5_1 = v5.getString(styleable.ActivityFilter_activityAction);
        String v4 = arg4.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(v4);
        return new ActivityFilter(this.buildClassName(v4, ((CharSequence)v0)), v5_1);
    }

    private final ActivityRule parseActivityRule(Context arg2, XmlResourceParser arg3) {
        TypedArray v1 = arg2.getTheme().obtainStyledAttributes(((AttributeSet)arg3), styleable.ActivityRule, 0, 0);
        String v2 = v1.getString(styleable.ActivityRule_tag);
        boolean v3 = v1.getBoolean(styleable.ActivityRule_alwaysExpand, false);
        v1.recycle();
        Builder v1_1 = new Builder(SetsKt.emptySet()).setAlwaysExpand(v3);
        if(v2 != null) {
            v1_1.setTag(v2);
        }

        return v1_1.build();
    }

    private final DividerAttributes parseDividerAttributes(Context arg9, XmlResourceParser arg10) {
        TypedArray v8 = arg9.getTheme().obtainStyledAttributes(((AttributeSet)arg10), styleable.DividerAttributes, 0, 0);
        int v2 = v8.getInt(styleable.DividerAttributes_embeddingDividerType, 0);
        DividerAttributes.Companion.validateXmlDividerAttributes$window_release(v2, v8.hasValue(styleable.DividerAttributes_dragRangeMinRatio), v8.hasValue(styleable.DividerAttributes_dragRangeMaxRatio), v8.hasValue(styleable.DividerAttributes_isDraggingToFullscreenAllowed));
        return DividerAttributes.Companion.createDividerAttributes$window_release(v2, v8.getInt(styleable.DividerAttributes_embeddingDividerWidthDp, -1), v8.getColor(styleable.DividerAttributes_embeddingDividerColor, 0xFF000000), v8.getFloat(styleable.DividerAttributes_dragRangeMinRatio, -1f), v8.getFloat(styleable.DividerAttributes_dragRangeMaxRatio, -1f), v8.getBoolean(styleable.DividerAttributes_isDraggingToFullscreenAllowed, false));
    }

    public final Set parseRules$window_release(Context arg10, int arg11) {
        ActivityRule v3_4;
        XmlResourceParser v11;
        Intrinsics.checkNotNullParameter(arg10, "context");
        Resources v0 = arg10.getResources();
        Set v1 = null;
        try {
            v11 = v0.getXml(arg11);
            Intrinsics.checkNotNullExpressionValue(v11, "getXml(...)");
        }
        catch(Resources$NotFoundException ) {
            return v1;
        }

        HashSet v0_1 = new HashSet();
        int v2 = v11.getDepth();
        int v3 = v11.next();
        SplitPairRule v4 = ((SplitPairRule)v1);
        ActivityRule v5 = ((ActivityRule)v4);
        SplitPlaceholderRule v6 = ((SplitPlaceholderRule)v5);
        while(v3 != 1) {
            if(v3 == 3 && v11.getDepth() <= v2) {
                break;
            }

            if(v11.getEventType() == 2) {
                if(Intrinsics.areEqual("split-config", v11.getName())) {
                }
                else {
                    String v3_1 = v11.getName();
                    if(v3_1 != null) {
                        switch(v3_1.hashCode()) {
                            case 304713008: {
                                goto label_105;
                            }
                            case 511422343: {
                                goto label_81;
                            }
                            case 520447504: {
                                goto label_70;
                            }
                            case 1579230604: {
                                goto label_55;
                            }
                            case 1793077963: {
                                goto label_44;
                            }
                            case 2050988213: {
                                goto label_33;
                            }
                        }

                        goto label_145;
                    label_33:
                        if(!v3_1.equals("SplitPlaceholderRule")) {
                        }
                        else {
                            SplitPlaceholderRule v3_2 = this.parseSplitPlaceholderRule(arg10, v11);
                            this.addRuleWithDuplicatedTagCheck(v0_1, v3_2);
                            v4 = ((SplitPairRule)v1);
                            v5 = ((ActivityRule)v4);
                            goto label_42;
                        label_81:
                            if(!v3_1.equals("ActivityFilter")) {
                            }
                            else {
                                if(v5 == null) {
                                    if(v6 != null) {
                                    }
                                    else {
                                        throw new IllegalArgumentException("Found orphaned ActivityFilter");
                                    }
                                }

                                ActivityFilter v3_3 = this.parseActivityFilter(arg10, v11);
                                if(v5 != null) {
                                    v0_1.remove(v5);
                                    v3_4 = v5.plus$window_release(v3_3);
                                    this.addRuleWithDuplicatedTagCheck(v0_1, v3_4);
                                    goto label_53;
                                }

                                if(v6 == null) {
                                    goto label_145;
                                }

                                v0_1.remove(v6);
                                v3_2 = v6.plus$window_release(v3_3);
                                this.addRuleWithDuplicatedTagCheck(v0_1, v3_2);
                                goto label_42;
                            label_70:
                                if(!v3_1.equals("SplitPairRule")) {
                                    goto label_145;
                                }

                                SplitPairRule v3_5 = this.parseSplitPairRule(arg10, v11);
                                this.addRuleWithDuplicatedTagCheck(v0_1, v3_5);
                                v5 = ((ActivityRule)v1);
                                v6 = ((SplitPlaceholderRule)v5);
                                goto label_79;
                            label_55:
                                if(!v3_1.equals("SplitPairFilter")) {
                                    goto label_145;
                                }

                                if(v4 != null) {
                                    SplitPairFilter v3_6 = this.parseSplitPairFilter(arg10, v11);
                                    v0_1.remove(v4);
                                    v3_5 = v4.plus$window_release(v3_6);
                                    this.addRuleWithDuplicatedTagCheck(v0_1, v3_5);
                                    goto label_79;
                                }

                                throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
                            label_105:
                                if(!v3_1.equals("DividerAttributes")) {
                                    goto label_145;
                                }

                                if(v4 == null) {
                                    if(v6 != null) {
                                    }
                                    else {
                                        throw new IllegalArgumentException("Found orphaned DividerAttributes");
                                    }
                                }

                                DividerAttributes v3_7 = this.parseDividerAttributes(arg10, v11);
                                if(v4 != null) {
                                    v0_1.remove(v4);
                                    v3_5 = new androidx.window.embedding.SplitPairRule$Builder(v4).setDefaultSplitAttributes(new androidx.window.embedding.SplitAttributes$Builder(v4.getDefaultSplitAttributes()).setDividerAttributes(v3_7).build()).build();
                                    this.addRuleWithDuplicatedTagCheck(v0_1, v3_5);
                                label_79:
                                    v4 = v3_5;
                                    goto label_145;
                                }

                                if(v6 == null) {
                                    goto label_145;
                                }

                                v0_1.remove(v6);
                                v3_2 = new androidx.window.embedding.SplitPlaceholderRule$Builder(v6).setDefaultSplitAttributes(new androidx.window.embedding.SplitAttributes$Builder(v6.getDefaultSplitAttributes()).setDividerAttributes(v3_7).build()).build();
                                this.addRuleWithDuplicatedTagCheck(v0_1, v3_2);
                            label_42:
                                v6 = v3_2;
                                goto label_145;
                            label_44:
                                if(!v3_1.equals("ActivityRule")) {
                                    goto label_145;
                                }

                                v3_4 = this.parseActivityRule(arg10, v11);
                                this.addRuleWithDuplicatedTagCheck(v0_1, v3_4);
                                v4 = ((SplitPairRule)v1);
                                v6 = ((SplitPlaceholderRule)v4);
                            label_53:
                                v5 = v3_4;
                            }
                        }
                    }

                label_145:
                    v3 = v11.next();
                    continue;
                }
            }

            v3 = v11.next();
        }

        return ((Set)v0_1);
    }

    private final SplitPairFilter parseSplitPairFilter(Context arg4, XmlResourceParser arg5) {
        TypedArray v5 = arg4.getTheme().obtainStyledAttributes(((AttributeSet)arg5), styleable.SplitPairFilter, 0, 0);
        String v0 = v5.getString(styleable.SplitPairFilter_primaryActivityName);
        String v1 = v5.getString(styleable.SplitPairFilter_secondaryActivityName);
        String v5_1 = v5.getString(styleable.SplitPairFilter_secondaryActivityAction);
        String v4 = arg4.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(v4);
        return new SplitPairFilter(this.buildClassName(v4, ((CharSequence)v0)), this.buildClassName(v4, ((CharSequence)v1)), v5_1);
    }

    private final SplitPairRule parseSplitPairRule(Context arg18, XmlResourceParser arg19) {
        TypedArray v0 = arg18.getTheme().obtainStyledAttributes(arg19, styleable.SplitPairRule, 0, 0);
        String v1 = v0.getString(styleable.SplitPairRule_tag);
        float v2 = v0.getFloat(styleable.SplitPairRule_splitRatio, 0.5f);
        int v4 = v0.getInteger(styleable.SplitPairRule_splitMinWidthDp, 600);
        int v6 = v0.getInteger(styleable.SplitPairRule_splitMinHeightDp, 600);
        int v5 = v0.getInteger(styleable.SplitPairRule_splitMinSmallestWidthDp, 600);
        float v7 = v0.getFloat(styleable.SplitPairRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
        float v8 = v0.getFloat(styleable.SplitPairRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
        int v9 = v0.getInt(styleable.SplitPairRule_splitLayoutDirection, LayoutDirection.LOCALE.getValue$window_release());
        int v10 = v0.getInt(styleable.SplitPairRule_finishPrimaryWithSecondary, FinishBehavior.NEVER.getValue$window_release());
        int v11 = v0.getInt(styleable.SplitPairRule_finishSecondaryWithPrimary, FinishBehavior.ALWAYS.getValue$window_release());
        boolean v12 = v0.getBoolean(styleable.SplitPairRule_clearTop, false);
        int v3 = v0.getColor(styleable.SplitPairRule_animationBackgroundColor, 0);
        int v13 = v0.getInt(styleable.SplitPairRule_splitOpenAnimation, AnimationSpec.DEFAULT.getValue$window_release());
        int v14 = v0.getInt(styleable.SplitPairRule_splitCloseAnimation, AnimationSpec.DEFAULT.getValue$window_release());
        boolean v17 = v12;
        int v12_1 = v0.getInt(styleable.SplitPairRule_splitChangeAnimation, AnimationSpec.DEFAULT.getValue$window_release());
        v0.recycle();
        return new androidx.window.embedding.SplitPairRule$Builder(SetsKt.emptySet()).setTag(v1).setMinWidthDp(v4).setMinHeightDp(v6).setMinSmallestWidthDp(v5).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(v7)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(v8)).setFinishPrimaryWithSecondary(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v10)).setFinishSecondaryWithPrimary(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v11)).setClearTop(v17).setDefaultSplitAttributes(new androidx.window.embedding.SplitAttributes$Builder().setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(v2)).setLayoutDirection(LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(v9)).setAnimationParams(new androidx.window.embedding.EmbeddingAnimationParams$Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(v3)).setOpenAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v13)).setCloseAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v14)).setChangeAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v12_1)).build()).build()).build();
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context arg18, XmlResourceParser arg19) {
        TypedArray v0 = arg18.getTheme().obtainStyledAttributes(arg19, styleable.SplitPlaceholderRule, 0, 0);
        String v1 = v0.getString(styleable.SplitPlaceholderRule_tag);
        String v2 = v0.getString(styleable.SplitPlaceholderRule_placeholderActivityName);
        boolean v4 = v0.getBoolean(styleable.SplitPlaceholderRule_stickyPlaceholder, false);
        int v5 = v0.getInt(styleable.SplitPlaceholderRule_finishPrimaryWithPlaceholder, FinishBehavior.ALWAYS.getValue$window_release());
        if(v5 != FinishBehavior.NEVER.getValue$window_release()) {
            float v6 = v0.getFloat(styleable.SplitPlaceholderRule_splitRatio, 0.5f);
            int v7 = v0.getInteger(styleable.SplitPlaceholderRule_splitMinWidthDp, 600);
            int v9 = v0.getInteger(styleable.SplitPlaceholderRule_splitMinHeightDp, 600);
            int v8 = v0.getInteger(styleable.SplitPlaceholderRule_splitMinSmallestWidthDp, 600);
            float v10 = v0.getFloat(styleable.SplitPlaceholderRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
            float v11 = v0.getFloat(styleable.SplitPlaceholderRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
            int v12 = v0.getInt(styleable.SplitPlaceholderRule_splitLayoutDirection, LayoutDirection.LOCALE.getValue$window_release());
            int v3 = v0.getColor(styleable.SplitPlaceholderRule_animationBackgroundColor, 0);
            int v13 = v0.getInt(styleable.SplitPlaceholderRule_splitOpenAnimation, AnimationSpec.DEFAULT.getValue$window_release());
            int v14 = v0.getInt(styleable.SplitPlaceholderRule_splitCloseAnimation, AnimationSpec.DEFAULT.getValue$window_release());
            String v17 = v2;
            int v2_1 = v0.getInt(styleable.SplitPlaceholderRule_splitChangeAnimation, AnimationSpec.DEFAULT.getValue$window_release());
            v0.recycle();
            SplitAttributes v0_1 = new androidx.window.embedding.SplitAttributes$Builder().setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(v6)).setLayoutDirection(LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(v12)).setAnimationParams(new androidx.window.embedding.EmbeddingAnimationParams$Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(v3)).setOpenAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v13)).setCloseAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v14)).setChangeAnimation(AnimationSpec.Companion.getAnimationSpecFromValue$window_release(v2_1)).build()).build();
            v2 = arg18.getApplicationContext().getPackageName();
            RuleParser v3_1 = RuleParser.INSTANCE;
            Intrinsics.checkNotNull(v2);
            ComponentName v2_2 = v3_1.buildClassName(v2, v17);
            Set v6_1 = SetsKt.emptySet();
            Intent v2_3 = new Intent().setComponent(v2_2);
            Intrinsics.checkNotNullExpressionValue(v2_3, "setComponent(...)");
            return new androidx.window.embedding.SplitPlaceholderRule$Builder(v6_1, v2_3).setTag(v1).setMinWidthDp(v7).setMinHeightDp(v9).setMinSmallestWidthDp(v8).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(v10)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(v11)).setSticky(v4).setFinishPrimaryWithPlaceholder(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v5)).setDefaultSplitAttributes(v0_1).build();
        }

        throw new IllegalArgumentException("Never is not a valid configuration for Placeholder activities. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API");
    }
}

