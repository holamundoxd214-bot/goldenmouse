package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A>\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2={"transaction", "T", "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SQLiteDatabaseKt {
    public static final Object transaction(SQLiteDatabase arg1, boolean arg2, Function1 arg3) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "body");
        if(arg2) {
            arg1.beginTransaction();
        }
        else {
            arg1.beginTransactionNonExclusive();
        }

        try {
            v2_1 = arg3.invoke(arg1);
            arg1.setTransactionSuccessful();
        }
        catch(Throwable v2) {
            arg1.endTransaction();
            throw v2;
        }

        arg1.endTransaction();
        return v2_1;
    }

    public static Object transaction$default(SQLiteDatabase arg0, boolean arg1, Function1 arg2, int arg3, Object arg4) {
        Object v1_1;
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "body");
        if(1 != 0) {
            arg0.beginTransaction();
        }
        else {
            arg0.beginTransactionNonExclusive();
        }

        try {
            v1_1 = arg2.invoke(arg0);
            arg0.setTransactionSuccessful();
        }
        catch(Throwable v1) {
            arg0.endTransaction();
            throw v1;
        }

        arg0.endTransaction();
        return v1_1;
    }
}

