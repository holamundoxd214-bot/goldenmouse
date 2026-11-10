package androidx.compose.ui.text.android;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas$EdgeType;
import android.graphics.Canvas$VertexMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0015\n\u0002\b\u000B\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00012\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0010H\u0086\bJ\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0012\u0010\u0015\u001A\u00020\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001A\u00020\rH\u0017J\b\u0010\u0019\u001A\u00020\rH\u0017J\b\u0010\u001A\u001A\u00020\u0012H\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010\u001D\u001A\u00020\u001CH\u0016J\b\u0010\u001E\u001A\u00020\u001CH\u0016J\u0010\u0010\u001F\u001A\u00020\r2\u0006\u0010 \u001A\u00020\u001CH\u0016J\b\u0010!\u001A\u00020\u001CH\u0016J\b\u0010\"\u001A\u00020\u001CH\u0016J\b\u0010#\u001A\u00020\u001CH\u0016J$\u0010$\u001A\u00020\u001C2\b\u0010\u0013\u001A\u0004\u0018\u00010%2\b\u0010&\u001A\u0004\u0018\u00010\'2\u0006\u0010(\u001A\u00020\u001CH\u0017J\u001C\u0010$\u001A\u00020\u001C2\b\u0010\u0013\u001A\u0004\u0018\u00010%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J:\u0010$\u001A\u00020\u001C2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\b\u0010&\u001A\u0004\u0018\u00010\'2\u0006\u0010(\u001A\u00020\u001CH\u0017J2\u0010$\u001A\u00020\u001C2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J\"\u0010.\u001A\u00020\u001C2\b\u0010\u0013\u001A\u0004\u0018\u00010%2\u0006\u0010/\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020\u001CH\u0017J\u001A\u0010.\u001A\u00020\u001C2\b\u0010\u0013\u001A\u0004\u0018\u00010%2\u0006\u0010/\u001A\u00020\u001CH\u0016J8\u0010.\u001A\u00020\u001C2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010/\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020\u001CH\u0017J0\u0010.\u001A\u00020\u001C2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010/\u001A\u00020\u001CH\u0016J\b\u00100\u001A\u00020\rH\u0016J\b\u00101\u001A\u00020\u001CH\u0016J\u0010\u00102\u001A\u00020\r2\u0006\u00103\u001A\u00020\u001CH\u0016J\u0018\u00104\u001A\u00020\r2\u0006\u00105\u001A\u00020*2\u0006\u00106\u001A\u00020*H\u0016J\u0018\u00107\u001A\u00020\r2\u0006\u00108\u001A\u00020*2\u0006\u00109\u001A\u00020*H\u0016J\u0010\u0010:\u001A\u00020\r2\u0006\u0010;\u001A\u00020*H\u0016J\u0018\u0010<\u001A\u00020\r2\u0006\u00108\u001A\u00020*2\u0006\u00109\u001A\u00020*H\u0016J\u0012\u0010=\u001A\u00020\r2\b\u0010>\u001A\u0004\u0018\u00010?H\u0016J\u0012\u0010@\u001A\u00020\r2\b\u0010>\u001A\u0004\u0018\u00010?H\u0016J\u0010\u0010A\u001A\u00020\r2\u0006\u0010B\u001A\u00020?H\u0017J\u0018\u0010C\u001A\u00020\u00122\u0006\u0010D\u001A\u00020%2\u0006\u0010E\u001A\u00020FH\u0017J\u0018\u0010C\u001A\u00020\u00122\u0006\u0010D\u001A\u00020\u00142\u0006\u0010E\u001A\u00020FH\u0017J\u0010\u0010C\u001A\u00020\u00122\u0006\u0010D\u001A\u00020%H\u0016J\u0010\u0010C\u001A\u00020\u00122\u0006\u0010D\u001A\u00020\u0014H\u0016J0\u0010C\u001A\u00020\u00122\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010E\u001A\u00020FH\u0017J(\u0010C\u001A\u00020\u00122\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*H\u0016J(\u0010C\u001A\u00020\u00122\u0006\u0010)\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C2\u0006\u0010,\u001A\u00020\u001C2\u0006\u0010-\u001A\u00020\u001CH\u0016J\u0010\u0010G\u001A\u00020\u00122\u0006\u0010D\u001A\u00020%H\u0017J\u0010\u0010G\u001A\u00020\u00122\u0006\u0010D\u001A\u00020\u0014H\u0017J(\u0010G\u001A\u00020\u00122\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*H\u0017J(\u0010G\u001A\u00020\u00122\u0006\u0010)\u001A\u00020\u001C2\u0006\u0010+\u001A\u00020\u001C2\u0006\u0010,\u001A\u00020\u001C2\u0006\u0010-\u001A\u00020\u001CH\u0017J\u0018\u0010H\u001A\u00020\u00122\u0006\u0010I\u001A\u00020J2\u0006\u0010E\u001A\u00020FH\u0017J\u0010\u0010H\u001A\u00020\u00122\u0006\u0010I\u001A\u00020JH\u0016J\u0010\u0010K\u001A\u00020\u00122\u0006\u0010I\u001A\u00020JH\u0017J\n\u0010L\u001A\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001A\u00020\r2\b\u0010O\u001A\u0004\u0018\u00010MH\u0016J\u0018\u0010P\u001A\u00020\u00122\u0006\u0010D\u001A\u00020%2\u0006\u0010Q\u001A\u00020RH\u0017J\u0010\u0010P\u001A\u00020\u00122\u0006\u0010D\u001A\u00020%H\u0017J\u0018\u0010P\u001A\u00020\u00122\u0006\u0010I\u001A\u00020J2\u0006\u0010Q\u001A\u00020RH\u0017J\u0010\u0010P\u001A\u00020\u00122\u0006\u0010I\u001A\u00020JH\u0017J0\u0010P\u001A\u00020\u00122\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010Q\u001A\u00020RH\u0017J(\u0010P\u001A\u00020\u00122\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*H\u0017J\u0010\u0010S\u001A\u00020\r2\u0006\u0010T\u001A\u00020UH\u0016J\u0018\u0010S\u001A\u00020\r2\u0006\u0010T\u001A\u00020U2\u0006\u0010V\u001A\u00020%H\u0016J\u0018\u0010S\u001A\u00020\r2\u0006\u0010T\u001A\u00020U2\u0006\u0010V\u001A\u00020\u0014H\u0016J0\u0010W\u001A\u00020\r2\u0006\u0010X\u001A\u00020%2\u0006\u0010Y\u001A\u00020*2\u0006\u0010Z\u001A\u00020*2\u0006\u0010[\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'H\u0016JH\u0010W\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010Y\u001A\u00020*2\u0006\u0010Z\u001A\u00020*2\u0006\u0010[\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'H\u0016J(\u0010\\\u001A\u00020\r2\u0006\u0010]\u001A\u00020\u001C2\u0006\u0010^\u001A\u00020\u001C2\u0006\u0010_\u001A\u00020\u001C2\u0006\u0010`\u001A\u00020\u001CH\u0016J*\u0010a\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J,\u0010a\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010b\u001A\u0004\u0018\u00010\u00142\u0006\u0010V\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J,\u0010a\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010b\u001A\u0004\u0018\u00010\u00142\u0006\u0010V\u001A\u00020\u00142\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016JR\u0010a\u001A\u00020\r2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020\u001C2\u0006\u0010f\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010i\u001A\u00020\u001C2\u0006\u0010j\u001A\u00020\u001C2\u0006\u0010k\u001A\u00020\u00122\b\u0010&\u001A\u0004\u0018\u00010\'H\u0017JR\u0010a\u001A\u00020\r2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020\u001C2\u0006\u0010f\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020\u001C2\u0006\u0010h\u001A\u00020\u001C2\u0006\u0010i\u001A\u00020\u001C2\u0006\u0010j\u001A\u00020\u001C2\u0006\u0010k\u001A\u00020\u00122\b\u0010&\u001A\u0004\u0018\u00010\'H\u0017J\"\u0010a\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010>\u001A\u00020?2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016JL\u0010l\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010m\u001A\u00020\u001C2\u0006\u0010n\u001A\u00020\u001C2\u0006\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020\u001C2\b\u0010c\u001A\u0004\u0018\u00010d2\u0006\u0010r\u001A\u00020\u001C2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J(\u0010s\u001A\u00020\r2\u0006\u0010t\u001A\u00020*2\u0006\u0010u\u001A\u00020*2\u0006\u0010v\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J\u0010\u0010w\u001A\u00020\r2\u0006\u0010x\u001A\u00020\u001CH\u0016J\u0010\u0010w\u001A\u00020\r2\u0006\u0010x\u001A\u00020yH\u0017J\u0018\u0010w\u001A\u00020\r2\u0006\u0010x\u001A\u00020\u001C2\u0006\u0010z\u001A\u00020{H\u0016J\u0018\u0010w\u001A\u00020\r2\u0006\u0010x\u001A\u00020\u001C2\u0006\u0010z\u001A\u00020|H\u0017J\u0018\u0010w\u001A\u00020\r2\u0006\u0010x\u001A\u00020y2\u0006\u0010z\u001A\u00020|H\u0017J2\u0010}\u001A\u00020\r2\u0006\u0010~\u001A\u00020*2\u0006\u0010\u007F\u001A\u00020*2\u0007\u0010\u0080\u0001\u001A\u00020*2\u0007\u0010\u0081\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J+\u0010\u0082\u0001\u001A\u00020\r2\u0007\u0010\u0083\u0001\u001A\u00020p2\u0006\u0010e\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0006\u0010&\u001A\u00020\'H\u0016J\u001A\u0010\u0082\u0001\u001A\u00020\r2\u0007\u0010\u0083\u0001\u001A\u00020p2\u0006\u0010&\u001A\u00020\'H\u0016J\u0019\u0010\u0085\u0001\u001A\u00020\r2\u0006\u0010X\u001A\u00020%2\u0006\u0010&\u001A\u00020\'H\u0016J1\u0010\u0085\u0001\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J\u0011\u0010\u0086\u0001\u001A\u00020\r2\u0006\u0010&\u001A\u00020\'H\u0016J%\u0010\u0087\u0001\u001A\u00020\r2\b\u0010\u0088\u0001\u001A\u00030\u0089\u00012\u0006\u0010V\u001A\u00020\u00142\b\u0010&\u001A\u0004\u0018\u00010\'H\u0017J%\u0010\u0087\u0001\u001A\u00020\r2\b\u0010\u0088\u0001\u001A\u00030\u0089\u00012\u0006\u0010V\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0017J\u0019\u0010\u008A\u0001\u001A\u00020\r2\u0006\u0010I\u001A\u00020J2\u0006\u0010&\u001A\u00020\'H\u0016J!\u0010\u008B\u0001\u001A\u00020\r2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J-\u0010\u008C\u0001\u001A\u00020\r2\t\u0010\u0083\u0001\u001A\u0004\u0018\u00010p2\u0006\u0010e\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0006\u0010&\u001A\u00020\'H\u0016J\u001A\u0010\u008C\u0001\u001A\u00020\r2\u0007\u0010\u0083\u0001\u001A\u00020p2\u0006\u0010&\u001A\u00020\'H\u0016J6\u0010\u008D\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\u0007\u0010\u0090\u0001\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0007\u0010\u0091\u0001\u001A\u00020p2\u0006\u0010&\u001A\u00020\'H\u0017J$\u0010\u008D\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u0092\u00012\u0007\u0010\u0091\u0001\u001A\u00020p2\u0006\u0010&\u001A\u00020\'H\u0017J\u0019\u0010\u0093\u0001\u001A\u00020\r2\u0006\u0010D\u001A\u00020%2\u0006\u0010&\u001A\u00020\'H\u0016J\u0019\u0010\u0093\u0001\u001A\u00020\r2\u0006\u0010^\u001A\u00020\u00142\u0006\u0010&\u001A\u00020\'H\u0016J1\u0010\u0093\u0001\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J!\u0010\u0094\u0001\u001A\u00020\r2\u0006\u0010^\u001A\u00020\u001C2\u0006\u0010_\u001A\u00020\u001C2\u0006\u0010`\u001A\u00020\u001CH\u0016J+\u0010\u0095\u0001\u001A\u00020\r2\u0006\u0010D\u001A\u00020%2\u0007\u0010\u0096\u0001\u001A\u00020*2\u0007\u0010\u0097\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016JC\u0010\u0095\u0001\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*2\u0006\u0010-\u001A\u00020*2\u0007\u0010\u0096\u0001\u001A\u00020*2\u0007\u0010\u0097\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016JG\u0010\u0098\u0001\u001A\u00020\r2\u0007\u0010\u0099\u0001\u001A\u00020%2\u0007\u0010\u009A\u0001\u001A\u00020*2\u0007\u0010\u009B\u0001\u001A\u00020*2\u0007\u0010\u009C\u0001\u001A\u00020%2\u0007\u0010\u009D\u0001\u001A\u00020*2\u0007\u0010\u009E\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0017J5\u0010\u0098\u0001\u001A\u00020\r2\u0007\u0010\u0099\u0001\u001A\u00020%2\u0007\u0010\u009F\u0001\u001A\u00020p2\u0007\u0010\u009C\u0001\u001A\u00020%2\u0007\u0010 \u0001\u001A\u00020p2\u0006\u0010&\u001A\u00020\'H\u0017JH\u0010¡\u0001\u001A\u00020\r2\u0007\u0010¢\u0001\u001A\u00020d2\u0007\u0010£\u0001\u001A\u00020\u001C2\u0007\u0010¤\u0001\u001A\u00020p2\u0007\u0010¥\u0001\u001A\u00020\u001C2\u0007\u0010¦\u0001\u001A\u00020\u001C2\b\u0010§\u0001\u001A\u00030¨\u00012\u0006\u0010&\u001A\u00020\'H\u0017J=\u0010©\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\u0007\u0010\u0090\u0001\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J+\u0010©\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u0092\u00012\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J=\u0010©\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u0092\u00012\u0007\u0010ª\u0001\u001A\u00020\u001C2\u0007\u0010«\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J=\u0010©\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030¬\u00012\u0007\u0010ª\u0001\u001A\u00020\u001C2\u0007\u0010«\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016JG\u0010­\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\u0007\u0010\u0090\u0001\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0006\u0010I\u001A\u00020J2\u0007\u0010®\u0001\u001A\u00020*2\u0007\u0010¯\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016J5\u0010­\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u0092\u00012\u0006\u0010I\u001A\u00020J2\u0007\u0010®\u0001\u001A\u00020*2\u0007\u0010¯\u0001\u001A\u00020*2\u0006\u0010&\u001A\u00020\'H\u0016JX\u0010°\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\u0007\u0010\u0090\u0001\u001A\u00020\u001C2\u0007\u0010\u0084\u0001\u001A\u00020\u001C2\u0007\u0010±\u0001\u001A\u00020\u001C2\u0007\u0010²\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0007\u0010³\u0001\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'H\u0017JX\u0010°\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030¬\u00012\u0007\u0010ª\u0001\u001A\u00020\u001C2\u0007\u0010«\u0001\u001A\u00020\u001C2\u0007\u0010´\u0001\u001A\u00020\u001C2\u0007\u0010µ\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0007\u0010³\u0001\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'H\u0017JX\u0010°\u0001\u001A\u00020\r2\b\u0010\u008E\u0001\u001A\u00030¶\u00012\u0007\u0010ª\u0001\u001A\u00020\u001C2\u0007\u0010«\u0001\u001A\u00020\u001C2\u0007\u0010´\u0001\u001A\u00020\u001C2\u0007\u0010µ\u0001\u001A\u00020\u001C2\u0006\u0010g\u001A\u00020*2\u0006\u0010h\u001A\u00020*2\u0007\u0010³\u0001\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'H\u0017Jw\u0010·\u0001\u001A\u00020\r2\u0007\u0010z\u001A\u00030¸\u00012\u0007\u0010¹\u0001\u001A\u00020\u001C2\u0006\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020\u001C2\t\u0010º\u0001\u001A\u0004\u0018\u00010p2\u0007\u0010»\u0001\u001A\u00020\u001C2\b\u0010c\u001A\u0004\u0018\u00010d2\u0006\u0010r\u001A\u00020\u001C2\n\u0010¼\u0001\u001A\u0005\u0018\u00010½\u00012\u0007\u0010¾\u0001\u001A\u00020\u001C2\u0007\u0010¿\u0001\u001A\u00020\u001C2\u0006\u0010&\u001A\u00020\'H\u0016J\u0013\u0010À\u0001\u001A\u00020\r2\b\u0010Á\u0001\u001A\u00030Â\u0001H\u0017R&\u0010\u0004\u001A\u0004\u0018\u00010\u00018\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007¨\u0006Ã\u0001"}, d2={"Landroidx/compose/ui/text/android/TextAndroidCanvas;", "Landroid/graphics/Canvas;", "<init>", "()V", "_nativeCanvas", "get_nativeCanvas$ui_text$annotations", "get_nativeCanvas$ui_text", "()Landroid/graphics/Canvas;", "set_nativeCanvas$ui_text", "(Landroid/graphics/Canvas;)V", "nativeCanvas", "getNativeCanvas", "withCanvas", "", "canvas", "block", "Lkotlin/Function1;", "getClipBounds", "", "bounds", "Landroid/graphics/Rect;", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "enableZ", "disableZ", "isOpaque", "getWidth", "", "getHeight", "getDensity", "setDensity", "density", "getMaximumBitmapWidth", "getMaximumBitmapHeight", "save", "saveLayer", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "saveFlags", "left", "", "top", "right", "bottom", "saveLayerAlpha", "alpha", "restore", "getSaveCount", "restoreToCount", "saveCount", "translate", "dx", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroid/graphics/Matrix;", "setMatrix", "getMatrix", "ctm", "clipRect", "rect", "op", "Landroid/graphics/Region$Op;", "clipOutRect", "clipPath", "path", "Landroid/graphics/Path;", "clipOutPath", "getDrawFilter", "Landroid/graphics/DrawFilter;", "setDrawFilter", "filter", "quickReject", "type", "Landroid/graphics/Canvas$EdgeType;", "drawPicture", "picture", "Landroid/graphics/Picture;", "dst", "drawArc", "oval", "startAngle", "sweepAngle", "useCenter", "drawARGB", "a", "r", "g", "b", "drawBitmap", "src", "colors", "", "offset", "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "", "mode", "Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/BlendMode;", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "drawPath", "drawPoint", "drawPoints", "drawPosText", "text", "", "index", "pos", "", "drawRect", "drawRGB", "drawRoundRect", "rx", "ry", "drawDoubleRoundRect", "outer", "outerRx", "outerRy", "inner", "innerRx", "innerRy", "outerRadii", "innerRadii", "drawGlyphs", "glyphIds", "glyphIdOffset", "positions", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "drawText", "start", "end", "", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "contextIndex", "contextCount", "isRtl", "contextStart", "contextEnd", "Landroid/graphics/text/MeasuredText;", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextAndroidCanvas extends Canvas {
    public static final int $stable = 8;
    private Canvas _nativeCanvas;

    static {
    }

    public TextAndroidCanvas() {
        super();
    }

    public boolean clipOutPath(Path arg2) {
        return CanvasCompatO.INSTANCE.clipOutPath(this.getNativeCanvas(), arg2);
    }

    public boolean clipOutRect(float arg7, float arg8, float arg9, float arg10) {
        return CanvasCompatO.INSTANCE.clipOutRect(this.getNativeCanvas(), arg7, arg8, arg9, arg10);
    }

    public boolean clipOutRect(int arg7, int arg8, int arg9, int arg10) {
        return CanvasCompatO.INSTANCE.clipOutRect(this.getNativeCanvas(), arg7, arg8, arg9, arg10);
    }

    public boolean clipOutRect(Rect arg2) {
        return CanvasCompatO.INSTANCE.clipOutRect(this.getNativeCanvas(), arg2);
    }

    public boolean clipOutRect(RectF arg2) {
        return CanvasCompatO.INSTANCE.clipOutRect(this.getNativeCanvas(), arg2);
    }

    public boolean clipPath(Path arg1) {
        return this.getNativeCanvas().clipPath(arg1);
    }

    @Deprecated(message="Deprecated in Java") public boolean clipPath(Path arg1, Region$Op arg2) {
        return this.getNativeCanvas().clipPath(arg1, arg2);
    }

    public boolean clipRect(float arg1, float arg2, float arg3, float arg4) {
        return this.getNativeCanvas().clipRect(arg1, arg2, arg3, arg4);
    }

    @Deprecated(message="Deprecated in Java") public boolean clipRect(float arg1, float arg2, float arg3, float arg4, Region$Op arg5) {
        return this.getNativeCanvas().clipRect(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean clipRect(int arg1, int arg2, int arg3, int arg4) {
        return this.getNativeCanvas().clipRect(arg1, arg2, arg3, arg4);
    }

    public boolean clipRect(Rect arg1) {
        return this.getNativeCanvas().clipRect(arg1);
    }

    @Deprecated(message="Deprecated in Java") public boolean clipRect(Rect arg1, Region$Op arg2) {
        return this.getNativeCanvas().clipRect(arg1, arg2);
    }

    public boolean clipRect(RectF arg1) {
        return this.getNativeCanvas().clipRect(arg1);
    }

    @Deprecated(message="Deprecated in Java") public boolean clipRect(RectF arg1, Region$Op arg2) {
        return this.getNativeCanvas().clipRect(arg1, arg2);
    }

    public void concat(Matrix arg1) {
        this.getNativeCanvas().concat(arg1);
    }

    public void disableZ() {
        CanvasCompatQ.INSTANCE.disableZ(this.getNativeCanvas());
    }

    public void drawARGB(int arg1, int arg2, int arg3, int arg4) {
        this.getNativeCanvas().drawARGB(arg1, arg2, arg3, arg4);
    }

    public void drawArc(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, Paint arg8) {
        this.getNativeCanvas().drawArc(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public void drawArc(RectF arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
        this.getNativeCanvas().drawArc(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawBitmap(Bitmap arg1, float arg2, float arg3, Paint arg4) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3, arg4);
    }

    public void drawBitmap(Bitmap arg1, Matrix arg2, Paint arg3) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3);
    }

    public void drawBitmap(Bitmap arg1, Rect arg2, Rect arg3, Paint arg4) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3, arg4);
    }

    public void drawBitmap(Bitmap arg1, Rect arg2, RectF arg3, Paint arg4) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3, arg4);
    }

    @Deprecated(message="Deprecated in Java") public void drawBitmap(int[] arg1, int arg2, int arg3, float arg4, float arg5, int arg6, int arg7, boolean arg8, Paint arg9) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Deprecated(message="Deprecated in Java") public void drawBitmap(int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, boolean arg8, Paint arg9) {
        this.getNativeCanvas().drawBitmap(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public void drawBitmapMesh(Bitmap arg1, int arg2, int arg3, float[] arg4, int arg5, int[] arg6, int arg7, Paint arg8) {
        this.getNativeCanvas().drawBitmapMesh(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public void drawCircle(float arg1, float arg2, float arg3, Paint arg4) {
        this.getNativeCanvas().drawCircle(arg1, arg2, arg3, arg4);
    }

    public void drawColor(int arg1) {
        this.getNativeCanvas().drawColor(arg1);
    }

    public void drawColor(int arg2, BlendMode arg3) {
        CanvasCompatQ.INSTANCE.drawColor(this.getNativeCanvas(), arg2, arg3);
    }

    public void drawColor(int arg1, PorterDuff$Mode arg2) {
        this.getNativeCanvas().drawColor(arg1, arg2);
    }

    public void drawColor(long arg2) {
        CanvasCompatQ.INSTANCE.drawColor(this.getNativeCanvas(), arg2);
    }

    public void drawColor(long arg2, BlendMode arg4) {
        CanvasCompatQ.INSTANCE.drawColor(this.getNativeCanvas(), arg2, arg4);
    }

    public void drawDoubleRoundRect(RectF arg10, float arg11, float arg12, RectF arg13, float arg14, float arg15, Paint arg16) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(this.getNativeCanvas(), arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public void drawDoubleRoundRect(RectF arg8, float[] arg9, RectF arg10, float[] arg11, Paint arg12) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(this.getNativeCanvas(), arg8, arg9, arg10, arg11, arg12);
    }

    public void drawGlyphs(int[] arg10, int arg11, float[] arg12, int arg13, int arg14, Font arg15, Paint arg16) {
        CanvasCompatS.INSTANCE.drawGlyphs(this.getNativeCanvas(), arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public void drawLine(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        this.getNativeCanvas().drawLine(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawLines(float[] arg1, int arg2, int arg3, Paint arg4) {
        this.getNativeCanvas().drawLines(arg1, arg2, arg3, arg4);
    }

    public void drawLines(float[] arg1, Paint arg2) {
        this.getNativeCanvas().drawLines(arg1, arg2);
    }

    public void drawOval(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        this.getNativeCanvas().drawOval(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawOval(RectF arg1, Paint arg2) {
        this.getNativeCanvas().drawOval(arg1, arg2);
    }

    public void drawPaint(Paint arg1) {
        this.getNativeCanvas().drawPaint(arg1);
    }

    public void drawPatch(NinePatch arg2, Rect arg3, Paint arg4) {
        CanvasCompatS.INSTANCE.drawPatch(this.getNativeCanvas(), arg2, arg3, arg4);
    }

    public void drawPatch(NinePatch arg2, RectF arg3, Paint arg4) {
        CanvasCompatS.INSTANCE.drawPatch(this.getNativeCanvas(), arg2, arg3, arg4);
    }

    public void drawPath(Path arg1, Paint arg2) {
        this.getNativeCanvas().drawPath(arg1, arg2);
    }

    public void drawPicture(Picture arg1) {
        this.getNativeCanvas().drawPicture(arg1);
    }

    public void drawPicture(Picture arg1, Rect arg2) {
        this.getNativeCanvas().drawPicture(arg1, arg2);
    }

    public void drawPicture(Picture arg1, RectF arg2) {
        this.getNativeCanvas().drawPicture(arg1, arg2);
    }

    public void drawPoint(float arg1, float arg2, Paint arg3) {
        this.getNativeCanvas().drawPoint(arg1, arg2, arg3);
    }

    public void drawPoints(float[] arg1, int arg2, int arg3, Paint arg4) {
        this.getNativeCanvas().drawPoints(arg1, arg2, arg3, arg4);
    }

    public void drawPoints(float[] arg1, Paint arg2) {
        this.getNativeCanvas().drawPoints(arg1, arg2);
    }

    @Deprecated(message="Deprecated in Java") public void drawPosText(String arg1, float[] arg2, Paint arg3) {
        this.getNativeCanvas().drawPosText(arg1, arg2, arg3);
    }

    @Deprecated(message="Deprecated in Java") public void drawPosText(char[] arg1, int arg2, int arg3, float[] arg4, Paint arg5) {
        this.getNativeCanvas().drawPosText(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawRGB(int arg1, int arg2, int arg3) {
        this.getNativeCanvas().drawRGB(arg1, arg2, arg3);
    }

    public void drawRect(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        this.getNativeCanvas().drawRect(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawRect(Rect arg1, Paint arg2) {
        this.getNativeCanvas().drawRect(arg1, arg2);
    }

    public void drawRect(RectF arg1, Paint arg2) {
        this.getNativeCanvas().drawRect(arg1, arg2);
    }

    public void drawRenderNode(RenderNode arg2) {
        CanvasCompatQ.INSTANCE.drawRenderNode(this.getNativeCanvas(), arg2);
    }

    public void drawRoundRect(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, Paint arg7) {
        this.getNativeCanvas().drawRoundRect(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public void drawRoundRect(RectF arg1, float arg2, float arg3, Paint arg4) {
        this.getNativeCanvas().drawRoundRect(arg1, arg2, arg3, arg4);
    }

    public void drawText(CharSequence arg1, int arg2, int arg3, float arg4, float arg5, Paint arg6) {
        this.getNativeCanvas().drawText(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void drawText(String arg1, float arg2, float arg3, Paint arg4) {
        this.getNativeCanvas().drawText(arg1, arg2, arg3, arg4);
    }

    public void drawText(String arg1, int arg2, int arg3, float arg4, float arg5, Paint arg6) {
        this.getNativeCanvas().drawText(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void drawText(char[] arg1, int arg2, int arg3, float arg4, float arg5, Paint arg6) {
        this.getNativeCanvas().drawText(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void drawTextOnPath(String arg1, Path arg2, float arg3, float arg4, Paint arg5) {
        this.getNativeCanvas().drawTextOnPath(arg1, arg2, arg3, arg4, arg5);
    }

    public void drawTextOnPath(char[] arg1, int arg2, int arg3, Path arg4, float arg5, float arg6, Paint arg7) {
        this.getNativeCanvas().drawTextOnPath(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public void drawTextRun(MeasuredText arg12, int arg13, int arg14, int arg15, int arg16, float arg17, float arg18, boolean arg19, Paint arg20) {
        CanvasCompatQ.INSTANCE.drawTextRun(this.getNativeCanvas(), arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    public void drawTextRun(CharSequence arg12, int arg13, int arg14, int arg15, int arg16, float arg17, float arg18, boolean arg19, Paint arg20) {
        CanvasCompatM.INSTANCE.drawTextRun(this.getNativeCanvas(), arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    public void drawTextRun(char[] arg12, int arg13, int arg14, int arg15, int arg16, float arg17, float arg18, boolean arg19, Paint arg20) {
        CanvasCompatM.INSTANCE.drawTextRun(this.getNativeCanvas(), arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    public void drawVertices(Canvas$VertexMode arg1, int arg2, float[] arg3, int arg4, float[] arg5, int arg6, int[] arg7, int arg8, short[] arg9, int arg10, int arg11, Paint arg12) {
        this.getNativeCanvas().drawVertices(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public void enableZ() {
        CanvasCompatQ.INSTANCE.enableZ(this.getNativeCanvas());
    }

    public boolean getClipBounds(Rect arg4) {
        boolean v3 = this.getNativeCanvas().getClipBounds(arg4);
        if(v3) {
            arg4.set(0, 0, arg4.width(), 0x7FFFFFFF);
        }

        return v3;
    }

    public int getDensity() {
        return this.getNativeCanvas().getDensity();
    }

    public DrawFilter getDrawFilter() {
        return this.getNativeCanvas().getDrawFilter();
    }

    public int getHeight() {
        return this.getNativeCanvas().getHeight();
    }

    @Deprecated(message="Deprecated in Java") public void getMatrix(Matrix arg1) {
        this.getNativeCanvas().getMatrix(arg1);
    }

    public int getMaximumBitmapHeight() {
        return this.getNativeCanvas().getMaximumBitmapHeight();
    }

    public int getMaximumBitmapWidth() {
        return this.getNativeCanvas().getMaximumBitmapWidth();
    }

    private final Canvas getNativeCanvas() {
        Canvas v0 = this._nativeCanvas;
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Text drawing wrapper is missing a Canvas!");
        throw new KotlinNothingValueException();
    }

    public int getSaveCount() {
        return this.getNativeCanvas().getSaveCount();
    }

    public int getWidth() {
        return this.getNativeCanvas().getWidth();
    }

    public final Canvas get_nativeCanvas$ui_text() {
        return this._nativeCanvas;
    }

    public static void get_nativeCanvas$ui_text$annotations() {
    }

    public boolean isOpaque() {
        return this.getNativeCanvas().isOpaque();
    }

    public boolean quickReject(float arg7, float arg8, float arg9, float arg10) {
        return CanvasCompatR.INSTANCE.quickReject(this.getNativeCanvas(), arg7, arg8, arg9, arg10);
    }

    @Deprecated(message="Deprecated in Java") public boolean quickReject(float arg1, float arg2, float arg3, float arg4, Canvas$EdgeType arg5) {
        return this.getNativeCanvas().quickReject(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean quickReject(Path arg2) {
        return CanvasCompatR.INSTANCE.quickReject(this.getNativeCanvas(), arg2);
    }

    @Deprecated(message="Deprecated in Java") public boolean quickReject(Path arg1, Canvas$EdgeType arg2) {
        return this.getNativeCanvas().quickReject(arg1, arg2);
    }

    public boolean quickReject(RectF arg2) {
        return CanvasCompatR.INSTANCE.quickReject(this.getNativeCanvas(), arg2);
    }

    @Deprecated(message="Deprecated in Java") public boolean quickReject(RectF arg1, Canvas$EdgeType arg2) {
        return this.getNativeCanvas().quickReject(arg1, arg2);
    }

    public void restore() {
        this.getNativeCanvas().restore();
    }

    public void restoreToCount(int arg1) {
        this.getNativeCanvas().restoreToCount(arg1);
    }

    public void rotate(float arg1) {
        this.getNativeCanvas().rotate(arg1);
    }

    public int save() {
        return this.getNativeCanvas().save();
    }

    public int saveLayer(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        return this.getNativeCanvas().saveLayer(arg1, arg2, arg3, arg4, arg5);
    }

    @Deprecated(message="Deprecated in Java") public int saveLayer(float arg1, float arg2, float arg3, float arg4, Paint arg5, int arg6) {
        return this.getNativeCanvas().saveLayer(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public int saveLayer(RectF arg1, Paint arg2) {
        return this.getNativeCanvas().saveLayer(arg1, arg2);
    }

    @Deprecated(message="Deprecated in Java") public int saveLayer(RectF arg1, Paint arg2, int arg3) {
        return this.getNativeCanvas().saveLayer(arg1, arg2, arg3);
    }

    public int saveLayerAlpha(float arg1, float arg2, float arg3, float arg4, int arg5) {
        return this.getNativeCanvas().saveLayerAlpha(arg1, arg2, arg3, arg4, arg5);
    }

    @Deprecated(message="Deprecated in Java") public int saveLayerAlpha(float arg1, float arg2, float arg3, float arg4, int arg5, int arg6) {
        return this.getNativeCanvas().saveLayerAlpha(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public int saveLayerAlpha(RectF arg1, int arg2) {
        return this.getNativeCanvas().saveLayerAlpha(arg1, arg2);
    }

    @Deprecated(message="Deprecated in Java") public int saveLayerAlpha(RectF arg1, int arg2, int arg3) {
        return this.getNativeCanvas().saveLayerAlpha(arg1, arg2, arg3);
    }

    public void scale(float arg1, float arg2) {
        this.getNativeCanvas().scale(arg1, arg2);
    }

    public void setBitmap(Bitmap arg1) {
        this.getNativeCanvas().setBitmap(arg1);
    }

    public void setDensity(int arg1) {
        this.getNativeCanvas().setDensity(arg1);
    }

    public void setDrawFilter(DrawFilter arg1) {
        this.getNativeCanvas().setDrawFilter(arg1);
    }

    public void setMatrix(Matrix arg1) {
        this.getNativeCanvas().setMatrix(arg1);
    }

    public final void set_nativeCanvas$ui_text(Canvas arg1) {
        this._nativeCanvas = arg1;
    }

    public void skew(float arg1, float arg2) {
        this.getNativeCanvas().skew(arg1, arg2);
    }

    public void translate(float arg1, float arg2) {
        this.getNativeCanvas().translate(arg1, arg2);
    }

    public final void withCanvas(Canvas arg1, Function1 arg2) {
        this.set_nativeCanvas$ui_text(arg1);
        arg1 = null;
        try {
            arg2.invoke(this);
        }
        catch(Throwable v2) {
            this.set_nativeCanvas$ui_text(arg1);
            throw v2;
        }

        this.set_nativeCanvas$ui_text(arg1);
    }
}

