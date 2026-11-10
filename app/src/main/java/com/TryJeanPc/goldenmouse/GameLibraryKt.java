package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u0016\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u001C\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001\u001A\"\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\n"}, d2={"loadInstalledGames", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "context", "Landroid/content/Context;", "saveGames", "", "games", "loadGames", "installedApps", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GameLibraryKt {
    public static final List loadGames(Context arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Intrinsics.checkNotNullParameter(arg4, "installedApps");
        Set v3 = arg3.getSharedPreferences("GoldenMousePrefs", 0).getStringSet("saved_games", SetsKt.emptySet());
        if(v3 == null) {
            v3 = SetsKt.emptySet();
        }

        ArrayList v0 = new ArrayList();
        Iterator v4 = ((Iterable)arg4).iterator();
        while(v4.hasNext()) {
            Object v1 = v4.next();
            if(!v3.contains(v1.getPackageName())) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        return ((List)v0);
    }

    public static final List loadInstalledGames(Context arg9) {
        Object v2_1;
        GameInfo v5;
        Intrinsics.checkNotNullParameter(arg9, "context");
        PackageManager v0 = arg9.getPackageManager();
        Uri v3 = null;
        Intent v1 = new Intent("android.intent.action.MAIN", v3);
        v1.addCategory("android.intent.category.LAUNCHER");
        List v1_1 = v0.queryIntentActivities(v1, 0x20000);
        Intrinsics.checkNotNullExpressionValue(v1_1, "queryIntentActivities(...)");
        ArrayList v2 = new ArrayList();
        Iterator v1_2 = ((Iterable)v1_1).iterator();
        while(v1_2.hasNext()) {
            Object v4 = v1_2.next();
            try {
                String v6 = ((ResolveInfo)v4).loadLabel(v0).toString();
                String v7 = ((ResolveInfo)v4).activityInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(v7, "packageName");
                Drawable v4_1 = ((ResolveInfo)v4).loadIcon(v0);
                Intrinsics.checkNotNullExpressionValue(v4_1, "loadIcon(...)");
                v5 = new GameInfo(v6, v7, v4_1);
            }
            catch(Exception ) {
                v5 = ((GameInfo)v3);
            }

            if(v5 == null) {
                continue;
            }

            ((Collection)v2).add(v5);
        }

        ArrayList v0_1 = new ArrayList();
        v1_2 = ((Iterable)v2).iterator();
        while(v1_2.hasNext()) {
            v2_1 = v1_2.next();
            if(Intrinsics.areEqual(v2_1.getPackageName(), arg9.getPackageName())) {
                continue;
            }

            ((Collection)v0_1).add(v2_1);
        }

        HashSet v9 = new HashSet();
        ArrayList v1_3 = new ArrayList();
        Iterator v0_2 = ((Iterable)v0_1).iterator();
        while(v0_2.hasNext()) {
            v2_1 = v0_2.next();
            if(!v9.add(v2_1.getPackageName())) {
                continue;
            }

            v1_3.add(v2_1);
        }

        return CollectionsKt.sortedWith(((Iterable)v1_3), new GameLibraryKt$loadInstalledGames$$inlined$sortedBy$1());
    }

    public static final boolean saveGames(Context arg4, List arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        Intrinsics.checkNotNullParameter(arg5, "games");
        SharedPreferences v4 = arg4.getSharedPreferences("GoldenMousePrefs", 0);
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg5), 10));
        Iterator v5 = ((Iterable)arg5).iterator();
        while(v5.hasNext()) {
            ((Collection)v0).add(v5.next().getPackageName());
        }

        Set v5_1 = CollectionsKt.toSet(((Iterable)v0));
        String v2 = "saved_games";
        Set v0_1 = v4.getStringSet(v2, SetsKt.emptySet());
        if(v0_1 == null) {
            v0_1 = SetsKt.emptySet();
        }

        v0_1 = CollectionsKt.toSet(((Iterable)v0_1));
        if(v4.edit().putStringSet(v2, v5_1).commit()) {
            return 1;
        }

        v4.edit().putStringSet(v2, v0_1).commit();
        return 0;
    }
}

