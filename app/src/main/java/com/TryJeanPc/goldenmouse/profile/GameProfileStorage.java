package com.TryJeanPc.goldenmouse.profile;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.util.Log;
import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.macro.MacroValidationPolicy;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditAction;
import com.TryJeanPc.goldenmouse.macro.editor.MacroRunMode;
import com.TryJeanPc.goldenmouse.mapper.FreeLookBindings;
import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u0000 e2\u00020\u0001:\u0002deB\u001B\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u001B\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u0012\u0010\u0010J+\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001F¢\u0006\u0004\b \u0010!J+\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010#\u001A\u00020$¢\u0006\u0004\b%\u0010&J#\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002J$\u0010+\u001A\u00020\f2\u0006\u0010,\u001A\u00020\u00152\b\u0010-\u001A\u0004\u0018\u00010\u00152\b\u0010.\u001A\u0004\u0018\u00010\u0015H\u0002J\u000E\u0010/\u001A\u0002002\u0006\u0010,\u001A\u00020\u0015Ja\u00101\u001A\b\u0012\u0004\u0012\u0002020\u000B2\u0006\u0010,\u001A\u00020\u00152\b\u00103\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u00104\u001A\u0004\u0018\u00010\u000E2\u0010\b\u0002\u00105\u001A\n\u0012\u0006\u0012\u0004\u0018\u000107062\u0010\b\u0002\u00108\u001A\n\u0012\u0006\u0012\u0004\u0018\u000107062\n\b\u0002\u00109\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b:\u0010;J\u001B\u0010<\u001A\b\u0012\u0004\u0012\u00020\u00150\u000B2\u0006\u0010=\u001A\u000202¢\u0006\u0004\b>\u0010?J\u000E\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020\u0015J%\u0010C\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010B\u001A\u00020\u00152\b\u00103\u001A\u0004\u0018\u00010\u0015¢\u0006\u0004\bD\u0010EJ\u000E\u0010F\u001A\u00020G2\u0006\u0010,\u001A\u00020\u0015J\u0010\u0010H\u001A\u0004\u0018\u00010\u000E2\u0006\u0010,\u001A\u00020\u0015J\u000E\u0010I\u001A\u00020\u00152\u0006\u0010\r\u001A\u00020\u000EJ\u0010\u0010J\u001A\u00020\u00152\u0006\u0010\r\u001A\u00020\u000EH\u0002J\u0016\u0010K\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\u00152\u0006\u0010,\u001A\u00020\u0015J\u0010\u0010L\u001A\u00020A2\u0006\u0010M\u001A\u00020NH\u0002J\u0010\u0010O\u001A\u00020\u00012\u0006\u0010P\u001A\u00020QH\u0002J$\u0010R\u001A\u0004\u0018\u00010N2\u0006\u0010S\u001A\u00020A2\u0006\u0010T\u001A\u0002072\b\u0010U\u001A\u0004\u0018\u00010\u001FH\u0002J\u0018\u0010V\u001A\u00020Q2\u0006\u0010W\u001A\u00020\u00152\u0006\u0010-\u001A\u00020AH\u0002J\u0010\u0010X\u001A\u00020Y2\u0006\u0010-\u001A\u00020AH\u0002J\u0012\u0010Z\u001A\u0004\u0018\u00010\u001F2\u0006\u0010[\u001A\u00020AH\u0002J\u0010\u0010\\\u001A\u00020\u00152\u0006\u0010]\u001A\u00020\u0015H\u0002J\u0013\u0010^\u001A\u0004\u0018\u00010\u001C*\u00020_H\u0002¢\u0006\u0002\u0010`J\u0014\u0010a\u001A\u00020\u001C*\u00020_2\u0006\u0010b\u001A\u00020\u001CH\u0002J\u0010\u0010c\u001A\u00020\u00152\u0006\u0010,\u001A\u00020\u0015H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage;", "", "preferences", "Landroid/content/SharedPreferences;", "backups", "<init>", "(Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "save", "Lkotlin/Result;", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "save-IoAF18A", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;)Ljava/lang/Object;", "saveFreeLookProfile", "saveFreeLookProfile-IoAF18A", "saveVistaPrimary", "componentId", "", "input", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "saveVistaPrimary-0E7RQCE", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;)Ljava/lang/Object;", "saveVistaSettings", "x", "", "y", "settings", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "saveVistaSettings-yxL6bBk", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;FFLcom/TryJeanPc/goldenmouse/profile/ViewComponent;)Ljava/lang/Object;", "saveMacro", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "saveMacro-0E7RQCE", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;)Ljava/lang/Object;", "deleteMacroComponent", "deleteMacroComponent-gIAlu-s", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;)Ljava/lang/Object;", "writeConfirmed", "writeRawConfirmed", "targetPackage", "json", "previous", "hasIdentityConflicts", "", "prepareIdRepair", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$IdRepairPlan;", "expectedJson", "pending", "controlOrigins", "", "", "visualOrigins", "editorBaseline", "prepareIdRepair-hUnOzRk", "(Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/util/List;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/profile/GameProfile;)Ljava/lang/Object;", "repairIds", "plan", "repairIds-IoAF18A", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$IdRepairPlan;)Ljava/lang/Object;", "readIdentityBackup", "Lorg/json/JSONObject;", "backupKey", "restoreIdentityBackup", "restoreIdentityBackup-gIAlu-s", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "loadResult", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileLoadResult;", "load", "export", "encode", "importProfile", "serializeControl", "control", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "serializeSettings", "component", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "deserializeControl", "item", "index", "legacyCamera", "deserializeSettings", "type", "deserializeTapSettings", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "parseLegacyCamera", "root", "normalizeType", "value", "safeFloat", "", "(D)Ljava/lang/Float;", "safePositiveFloat", "default", "key", "IdRepairPlan", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameProfileStorage {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b@\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00108\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010;\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010<\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010=\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010>\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010C\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006H"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$Companion;", "", "<init>", "()V", "TAG", "", "PREFERENCES_NAME", "VERSION", "", "MIN_SUPPORTED_VERSION", "KEY_VERSION", "KEY_TARGET_PACKAGE", "KEY_NAME", "KEY_CONTROLS", "KEY_VISUAL_CONTROLS", "KEY_VISUAL_SENSITIVITY", "KEY_RESET_ON_EDGE", "KEY_ID", "KEY_TYPE", "KEY_X", "KEY_Y", "KEY_WIDTH", "KEY_HEIGHT", "KEY_BINDINGS", "KEY_SLOT", "KEY_SOURCE", "KEY_CODE", "KEY_SETTINGS", "KEY_TAP_TIMING_VERSION", "KEY_ADVANCED_TIMING_ENABLED", "KEY_MODE", "KEY_TOUCH_DURATION", "KEY_INTERVAL", "KEY_REPEAT_ENABLED", "KEY_REPEAT_COUNT", "KEY_REPEATS_PER_SECOND", "KEY_RADIUS", "KEY_SPEED_MODIFIER_1", "KEY_RADIUS_1", "KEY_SPEED_MODIFIER_2", "KEY_RADIUS_2", "KEY_MOVEMENT_SPEED", "KEY_ACTIVATION_TIME", "KEY_ACTIVATION_SPEED", "KEY_MOBA_MODE", "KEY_DIAGONAL_ANGLE", "KEY_JOYSTICK_SMOOTHING", "KEY_SPRINT_ENABLED", "KEY_SPRINT_BINDING", "KEY_SPRINT_EXPANSION", "KEY_SOCD_ENABLED", "KEY_ENABLED", "KEY_SENSITIVITY_X", "KEY_SENSITIVITY_Y", "KEY_GOLDEN_PRECISION_PLUS", "KEY_INVERT_Y", "KEY_MOUSE_ACCELERATION", "KEY_ACCELERATION", "KEY_SPEED", "KEY_SMOOTHING", "KEY_MAX_DELTA", "KEY_TWEAKS", "KEY_SNIPER_ENABLED", "KEY_SNIPER_KEY", "KEY_SNIPER_MULTIPLIER", "KEY_TOGGLE_CURSOR_KEY", "KEY_SUSPEND_CURSOR_KEY", "KEY_QUICK_CHANGE_BINDING", "KEY_QUICK_CHANGE_DELAY_MS", "KEY_LINKED_SENSITIVITIES", "KEY_CONTINUOUS", "KEY_CAMERA", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\bHÆ\u0003J=\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\bHÖ\u0001J\t\u0010\u001C\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$IdRepairPlan;", "", "targetPackage", "", "originalJson", "pendingJson", "repairedJson", "changedIds", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getTargetPackage", "()Ljava/lang/String;", "getOriginalJson", "getPendingJson", "getRepairedJson", "getChangedIds", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class IdRepairPlan {
        public static final int $stable;
        private final int changedIds;
        private final String originalJson;
        private final String pendingJson;
        private final String repairedJson;
        private final String targetPackage;

        static {
        }

        public IdRepairPlan(String arg2, String arg3, String arg4, String arg5, int arg6) {
            Intrinsics.checkNotNullParameter(arg2, "targetPackage");
            Intrinsics.checkNotNullParameter(arg4, "pendingJson");
            Intrinsics.checkNotNullParameter(arg5, "repairedJson");
            super();
            this.targetPackage = arg2;
            this.originalJson = arg3;
            this.pendingJson = arg4;
            this.repairedJson = arg5;
            this.changedIds = arg6;
        }

        public final String component1() {
            return this.targetPackage;
        }

        public final String component2() {
            return this.originalJson;
        }

        public final String component3() {
            return this.pendingJson;
        }

        public final String component4() {
            return this.repairedJson;
        }

        public final int component5() {
            return this.changedIds;
        }

        public final IdRepairPlan copy(String arg7, String arg8, String arg9, String arg10, int arg11) {
            Intrinsics.checkNotNullParameter(arg7, "targetPackage");
            Intrinsics.checkNotNullParameter(arg9, "pendingJson");
            Intrinsics.checkNotNullParameter(arg10, "repairedJson");
            return new IdRepairPlan(arg7, arg8, arg9, arg10, arg11);
        }

        public static IdRepairPlan copy$default(IdRepairPlan arg0, String arg1, String arg2, String arg3, String arg4, int arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.targetPackage;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.originalJson;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.pendingJson;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.repairedJson;
            }

            if((arg6 & 16) != 0) {
                arg5 = arg0.changedIds;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean equals(Object arg5) {
            if(this == (((IdRepairPlan)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof IdRepairPlan)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.targetPackage, ((IdRepairPlan)arg5).targetPackage)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.originalJson, ((IdRepairPlan)arg5).originalJson)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.pendingJson, ((IdRepairPlan)arg5).pendingJson)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.repairedJson, ((IdRepairPlan)arg5).repairedJson)) {
                return 0;
            }

            if(this.changedIds != ((IdRepairPlan)arg5).changedIds) {
                return 0;
            }

            return 1;
        }

        public final int getChangedIds() {
            return this.changedIds;
        }

        public final String getOriginalJson() {
            return this.originalJson;
        }

        public final String getPendingJson() {
            return this.pendingJson;
        }

        public final String getRepairedJson() {
            return this.repairedJson;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public int hashCode() {
            int v0 = this.targetPackage.hashCode() * 0x1F;
            String v1 = this.originalJson;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (((v0 + v1_1) * 0x1F + this.pendingJson.hashCode()) * 0x1F + this.repairedJson.hashCode()) * 0x1F + Integer.hashCode(this.changedIds);
        }

        public String toString() {
            return "IdRepairPlan(targetPackage=" + this.targetPackage + ", originalJson=" + this.originalJson + ", pendingJson=" + this.pendingJson + ", repairedJson=" + this.repairedJson + ", changedIds=" + this.changedIds + ")";
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String KEY_ACCELERATION = "acceleration";
    @Deprecated public static final String KEY_ACTIVATION_SPEED = "activationSpeed";
    @Deprecated public static final String KEY_ACTIVATION_TIME = "activationTimeMs";
    @Deprecated public static final String KEY_ADVANCED_TIMING_ENABLED = "advancedTimingEnabled";
    @Deprecated public static final String KEY_BINDINGS = "bindings";
    @Deprecated public static final String KEY_CAMERA = "camera";
    @Deprecated public static final String KEY_CODE = "code";
    @Deprecated public static final String KEY_CONTINUOUS = "continuous";
    @Deprecated public static final String KEY_CONTROLS = "controls";
    @Deprecated public static final String KEY_DIAGONAL_ANGLE = "diagonalAngleDeg";
    @Deprecated public static final String KEY_ENABLED = "enabled";
    @Deprecated public static final String KEY_GOLDEN_PRECISION_PLUS = "goldenPrecisionPlus";
    @Deprecated public static final String KEY_HEIGHT = "height";
    @Deprecated public static final String KEY_ID = "id";
    @Deprecated public static final String KEY_INTERVAL = "intervalMs";
    @Deprecated public static final String KEY_INVERT_Y = "invertY";
    @Deprecated public static final String KEY_JOYSTICK_SMOOTHING = "smoothingMs";
    @Deprecated public static final String KEY_LINKED_SENSITIVITIES = "linkedSensitivities";
    @Deprecated public static final String KEY_MAX_DELTA = "maxDelta";
    @Deprecated public static final String KEY_MOBA_MODE = "mobaMode";
    @Deprecated public static final String KEY_MODE = "mode";
    @Deprecated public static final String KEY_MOUSE_ACCELERATION = "mouseAcceleration";
    @Deprecated public static final String KEY_MOVEMENT_SPEED = "movementSpeed";
    @Deprecated public static final String KEY_NAME = "name";
    @Deprecated public static final String KEY_QUICK_CHANGE_BINDING = "quickChangeBinding";
    @Deprecated public static final String KEY_QUICK_CHANGE_DELAY_MS = "quickChangeDelayMs";
    @Deprecated public static final String KEY_RADIUS = "radius";
    @Deprecated public static final String KEY_RADIUS_1 = "radius1";
    @Deprecated public static final String KEY_RADIUS_2 = "radius2";
    @Deprecated public static final String KEY_REPEATS_PER_SECOND = "repeatsPerSecond";
    @Deprecated public static final String KEY_REPEAT_COUNT = "repeatCount";
    @Deprecated public static final String KEY_REPEAT_ENABLED = "repeatEnabled";
    @Deprecated public static final String KEY_RESET_ON_EDGE = "resetOnEdge";
    @Deprecated public static final String KEY_SENSITIVITY_X = "sensitivityX";
    @Deprecated public static final String KEY_SENSITIVITY_Y = "sensitivityY";
    @Deprecated public static final String KEY_SETTINGS = "settings";
    @Deprecated public static final String KEY_SLOT = "slot";
    @Deprecated public static final String KEY_SMOOTHING = "smoothing";
    @Deprecated public static final String KEY_SNIPER_ENABLED = "sniperEnabled";
    @Deprecated public static final String KEY_SNIPER_KEY = "sniperKey";
    @Deprecated public static final String KEY_SNIPER_MULTIPLIER = "sniperMultiplier";
    @Deprecated public static final String KEY_SOCD_ENABLED = "socdEnabled";
    @Deprecated public static final String KEY_SOURCE = "source";
    @Deprecated public static final String KEY_SPEED = "speed";
    @Deprecated public static final String KEY_SPEED_MODIFIER_1 = "speedModifier1";
    @Deprecated public static final String KEY_SPEED_MODIFIER_2 = "speedModifier2";
    @Deprecated public static final String KEY_SPRINT_BINDING = "sprintBinding";
    @Deprecated public static final String KEY_SPRINT_ENABLED = "sprintEnabled";
    @Deprecated public static final String KEY_SPRINT_EXPANSION = "sprintExpansion";
    @Deprecated public static final String KEY_SUSPEND_CURSOR_KEY = "suspendCursorKey";
    @Deprecated public static final String KEY_TAP_TIMING_VERSION = "timingVersion";
    @Deprecated public static final String KEY_TARGET_PACKAGE = "targetPackage";
    @Deprecated public static final String KEY_TOGGLE_CURSOR_KEY = "toggleCursorKey";
    @Deprecated public static final String KEY_TOUCH_DURATION = "touchDurationMs";
    @Deprecated public static final String KEY_TWEAKS = "tweaks";
    @Deprecated public static final String KEY_TYPE = "type";
    @Deprecated public static final String KEY_VERSION = "version";
    @Deprecated public static final String KEY_VISUAL_CONTROLS = "visualControls";
    @Deprecated public static final String KEY_VISUAL_SENSITIVITY = "sensitivity";
    @Deprecated public static final String KEY_WIDTH = "width";
    @Deprecated public static final String KEY_X = "x";
    @Deprecated public static final String KEY_Y = "y";
    @Deprecated public static final int MIN_SUPPORTED_VERSION = 1;
    @Deprecated public static final String PREFERENCES_NAME = "GoldenMouseGameProfiles";
    @Deprecated public static final String TAG = "GOLDEN_PROFILE";
    @Deprecated public static final int VERSION = 3;
    private final SharedPreferences backups;
    private final SharedPreferences preferences;

    static {
        GameProfileStorage.Companion = new Companion(null);
        GameProfileStorage.$stable = 8;
    }

    public GameProfileStorage(Context arg5) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        SharedPreferences v0 = arg5.getSharedPreferences("GoldenMouseGameProfiles", 0);
        Intrinsics.checkNotNullExpressionValue(v0, "getSharedPreferences(...)");
        SharedPreferences v5 = arg5.getSharedPreferences("GoldenMouseProfileIdBackups", 0);
        Intrinsics.checkNotNullExpressionValue(v5, "getSharedPreferences(...)");
        this(v0, v5);
    }

    public GameProfileStorage(SharedPreferences arg2, SharedPreferences arg3) {
        Intrinsics.checkNotNullParameter(arg2, "preferences");
        Intrinsics.checkNotNullParameter(arg3, "backups");
        super();
        this.preferences = arg2;
        this.backups = arg3;
    }

    public GameProfileStorage(SharedPreferences arg1, SharedPreferences arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg1;
        }

        this(arg1, arg2);
    }

    public final Object deleteMacroComponent-gIAlu-s(GameProfile arg8, String arg9) {
        ArrayList v1_2;
        Intrinsics.checkNotNullParameter(arg8, "profile");
        Intrinsics.checkNotNullParameter(arg9, "componentId");
        try {
            Iterator v0_1 = arg8.getControls().iterator();
            ProfileControl v1 = null;
            int v2 = 0;
            while(true) {
                if(!v0_1.hasNext()) {
                    goto label_25;
                }

                Object v3 = v0_1.next();
                if(!Intrinsics.areEqual(v3.getId(), arg9)) {
                    continue;
                }

                if(v2 != 0) {
                    break;
                }

                v2 = 1;
                Object v1_1 = v3;
            }

            throw new IllegalArgumentException("Collection contains more than one matching element.");
        label_25:
            if(v2 == 0) {
                goto label_61;
            }

            if((v1.getComponent() instanceof MacroScriptComponent)) {
                List v0_2 = arg8.getControls();
                v1_2 = new ArrayList();
                v0_1 = ((Iterable)v0_2).iterator();
            }
            else {
                throw new IllegalArgumentException("El componente no es Macro-Script".toString());
            label_61:
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }

            while(v0_1.hasNext()) {
                Object v2_1 = v0_1.next();
                if(Intrinsics.areEqual(v2_1.getId(), arg9)) {
                    continue;
                }

                ((Collection)v1_2).add(v2_1);
            }

            GameProfile v0_3 = arg8;
            arg8 = GameProfile.copy$default(v0_3, null, null, v1_2, null, 11, null);
            this.loadResult(v0_3.getTargetPackage()).requireWritable$app(arg8, arg9);
            this.writeConfirmed(arg8);
            return Result.constructor-impl(arg8);
        }
        catch(Throwable v0) {
            return Result.constructor-impl(ResultKt.createFailure(v0));
        }
    }

    private final ProfileControl deserializeControl(JSONObject arg18, int arg19, ViewComponent arg20) {
        ViewComponent v1_2;
        Object v0_4;
        GameProfileStorage v1 = this;
        JSONObject v2 = arg18;
        String v0 = v2.optString("type");
        String v3 = "optString(...)";
        Intrinsics.checkNotNullExpressionValue(v0, v3);
        String v4 = v1.normalizeType(v0);
        double v5 = NaN;
        Float v0_1 = v1.safeFloat(v2.optDouble("x", v5));
        ProfileControl v7 = null;
        if(v0_1 != null) {
            float v11 = v0_1.floatValue();
            v0_1 = v1.safeFloat(v2.optDouble("y", v5));
            if(v0_1 != null) {
                float v12 = v0_1.floatValue();
                if(v4.length() == 0) {
                    return v7;
                }
                else {
                    JSONArray v0_2 = v2.optJSONArray("bindings");
                    if(v0_2 == null) {
                        v0_2 = new JSONArray();
                    }

                    JSONArray v5_1 = v0_2;
                    Map v6 = MapsKt.createMapBuilder();
                    int v8 = v5_1.length();
                    int v10;
                    for(v10 = 0; v10 < v8; ++v10) {
                        JSONObject v13 = v5_1.optJSONObject(v10);
                        if(v13 != null) {
                            v0 = v13.optString("slot");
                            Intrinsics.checkNotNullExpressionValue(v0, v3);
                            String v14 = StringsKt.trim(((CharSequence)v0)).toString().toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(v14, "toUpperCase(...)");
                            try {
                                v0 = v13.optString("source");
                                Intrinsics.checkNotNullExpressionValue(v0, v3);
                                v0_4 = Result.constructor-impl(InputBindingSource.valueOf(v0));
                            }
                            catch(Throwable v0_3) {
                                v0_4 = Result.constructor-impl(ResultKt.createFailure(v0_3));
                            }

                            if(Result.isFailure-impl(v0_4)) {
                                v0_4 = v7;
                            }

                            if(v0_4 == null) {
                                goto label_76;
                            }

                            String v13_1 = v13.optString("code");
                            Intrinsics.checkNotNullExpressionValue(v13_1, v3);
                            v13_1 = StringsKt.trim(((CharSequence)v13_1)).toString();
                            if(v14.length() > 0 && v13_1.length() > 0) {
                                v6.put(v14, new InputBinding(((InputBindingSource)v0_4), v13_1));
                            }
                        }

                    label_76:
                    }

                    Map v0_5 = MapsKt.build(v6);
                    String v5_2 = "settings";
                    JSONObject v6_1 = v2.optJSONObject(v5_2);
                    if(Intrinsics.areEqual(v4, "MACRO_SCRIPT")) {
                        MacroScriptComponent v1_1 = MacroDraftJson.INSTANCE.decodeComponent(v2.opt(v5_2));
                    }
                    else {
                        if(v6_1 == null && (Intrinsics.areEqual(v4, "CAMARA")) && arg20 != null) {
                            v1_2 = arg20;
                            goto label_87;
                        }

                        if(v6_1 == null) {
                            v6_1 = new JSONObject();
                        }

                        ControlComponent v1_3 = v1.deserializeSettings(v4, v6_1);
                    }

                label_87:
                    MacroScriptComponent v16 = ((MacroScriptComponent)v1_2);
                    if(Intrinsics.areEqual(v4, "DISPARO")) {
                        String v1_4 = "PRIMARY";
                        if(!v0_5.containsKey(v1_4)) {
                            v0_5 = MapsKt.plus(v0_5, TuplesKt.to(v1_4, InputBinding.Companion.mouse(Button.LEFT)));
                        }
                    }

                    Map v15 = v0_5;
                    v0 = v2.optString("id");
                    Intrinsics.checkNotNullExpressionValue(v0, v3);
                    return new ProfileControl(v0, ((ControlComponent)v16).getType(), v11, v12, RangesKt.coerceAtLeast(v2.optInt("width"), 0), RangesKt.coerceAtLeast(v2.optInt("height"), 0), v15, ((ControlComponent)v16));
                }
            }
        }

        return v7;
    }

    private final ControlComponent deserializeSettings(String arg38, JSONObject arg39) {
        ViewComponent v16;
        InputBinding v33;
        InputBinding v9_1;
        Object v0_4;
        float v25;
        float v19;
        float v18;
        float v0_2;
        String v7;
        float v22;
        Float v0_1;
        GameProfileStorage v1 = this;
        String v0 = arg38;
        JSONObject v2 = arg39;
        String v4 = "code";
        String v5 = "source";
        String v8 = "optString(...)";
        float v12 = 1f;
        double v13 = 1;
        switch(v0.hashCode()) {
            case -1905230500: {
                if(!v0.equals("DISPARO")) {
                    goto label_288;
                }

                return new FireComponent(v2.optBoolean("continuous", true));
            }
            case -854989634: {
                if(!v0.equals("MACRO_SCRIPT")) {
                    goto label_288;
                }

                return MacroDraftJson.INSTANCE.decodeComponent(v2);
            }
            case -155485892: {
                v7 = v4;
                if(v0.equals("JOYSTICK")) {
                    goto label_181;
                }

                break;
            }
            case 82819: {
                if(!v0.equals("TAP")) {
                    goto label_288;
                }

                return v1.deserializeTapSettings(v2);
            }
            case 1980540961: {
                if(!v0.equals("CAMARA")) {
                    goto label_288;
                }

                v0 = "acceleration";
                double v6 = 0;
                boolean v3 = v2.optDouble(v0, v6) > v6 ? true : false;
                boolean v21 = v2.optBoolean("mouseAcceleration", v3);
                if(v21) {
                    v6 = v13;
                }

                v0_1 = v1.safeFloat(v2.optDouble(v0, v6));
                v22 = v0_1 != null ? RangesKt.coerceIn(v0_1.floatValue(), 0f, v12) : 0f;
                boolean v6_1 = v2.optBoolean("enabled", true);
                boolean v36 = v2.optBoolean("goldenPrecisionPlus", false);
                double v9 = 2;
                v7 = v4;
                v0_1 = v1.safeFloat(v2.optDouble("sensitivityX", v9));
                float v3_1 = 2f;
                v0_2 = v0_1 != null ? v0_1.floatValue() : v3_1;
                v18 = GameProfileKt.normalizeViewSensitivity(v0_2);
                v0_1 = v1.safeFloat(v2.optDouble("sensitivityY", v9));
                if(v0_1 != null) {
                    v3_1 = v0_1.floatValue();
                }

                v19 = GameProfileKt.normalizeViewSensitivity(v3_1);
                boolean v20 = v2.optBoolean("invertY", false);
                float v23 = v1.safePositiveFloat(v2.optDouble("speed", v13), v12);
                v0_1 = v1.safeFloat(v2.optDouble("smoothing", 0));
                float v24 = v0_1 != null ? RangesKt.coerceIn(v0_1.floatValue(), 0f, 0.95f) : 0f;
                v25 = v1.safePositiveFloat(v2.optDouble("maxDelta", 96), 96f);
                String v3_2 = "16450";
                v0 = v2.optString("tweaks", v3_2);
                if(StringsKt.isBlank(((CharSequence)v0))) {
                }
                else {
                    v3_2 = v0;
                }

                v0 = "ifBlank(...)";
                Intrinsics.checkNotNullExpressionValue(v3_2, v0);
                String v26 = v3_2;
                boolean v27 = v2.optBoolean("sniperEnabled", false);
                v4 = "MOUSE_RIGHT";
                v3_2 = v2.optString("sniperKey", v4);
                if(StringsKt.isBlank(((CharSequence)v3_2))) {
                }
                else {
                    v4 = v3_2;
                }

                Intrinsics.checkNotNullExpressionValue(v4, v0);
                String v28 = v4;
                float v29 = v1.safePositiveFloat(v2.optDouble("sniperMultiplier", 0.5), 0.5f);
                v4 = "F1";
                v3_2 = v2.optString("toggleCursorKey", v4);
                if(StringsKt.isBlank(((CharSequence)v3_2))) {
                }
                else {
                    v4 = v3_2;
                }

                Intrinsics.checkNotNullExpressionValue(v4, v0);
                String v30 = v4;
                v4 = "ALT";
                v3_2 = v2.optString("suspendCursorKey", v4);
                if(StringsKt.isBlank(((CharSequence)v3_2))) {
                }
                else {
                    v4 = v3_2;
                }

                Intrinsics.checkNotNullExpressionValue(v4, v0);
                String v31 = v4;
                boolean v32 = v2.optBoolean("linkedSensitivities", false);
                long v34 = RangesKt.coerceIn(v2.optLong("quickChangeDelayMs", 0), 0, 5000);
                v2 = v2.optJSONObject("quickChangeBinding");
                if(v2 != null) {
                    try {
                        v0 = v2.optString(v5);
                        Intrinsics.checkNotNullExpressionValue(v0, v8);
                        v0_4 = Result.constructor-impl(InputBindingSource.valueOf(v0));
                    }
                    catch(Throwable v0_3) {
                        v0_4 = Result.constructor-impl(ResultKt.createFailure(v0_3));
                    }

                    if(Result.isFailure-impl(v0_4)) {
                        v0_4 = null;
                    }

                    String v1_1 = v2.optString(v7);
                    Intrinsics.checkNotNullExpressionValue(v1_1, v8);
                    v1_1 = StringsKt.trim(((CharSequence)v1_1)).toString();
                    v9_1 = v0_4 == null || v1_1.length() <= 0 ? null : new InputBinding(((InputBindingSource)v0_4), v1_1);
                    v33 = v9_1;
                }
                else {
                    v33 = null;
                }

                v16 = new ViewComponent(v6_1, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v36);
                goto label_271;
            }
            default: {
                break;
            }
        }

    label_288:
        return new TapComponent(null, 0, 0, false, 0, 0f, false, 0x7F, null);
    label_181:
        float v17 = v1.safePositiveFloat(v2.optDouble("radius", 52), 52f);
        v18 = v1.safePositiveFloat(v2.optDouble("speedModifier1", v13), v12);
        v19 = v1.safePositiveFloat(v2.optDouble("radius1", 0.55), 0.55f);
        float v20_1 = v1.safePositiveFloat(v2.optDouble("speedModifier2", v13), v12);
        float v21_1 = v1.safePositiveFloat(v2.optDouble("radius2", v13), v12);
        v22 = v1.safePositiveFloat(v2.optDouble("movementSpeed", v13), v12);
        long v23_1 = RangesKt.coerceIn(v2.optLong("activationTimeMs", 0), 0, 10000);
        v25 = v1.safePositiveFloat(v2.optDouble("activationSpeed", v13), v12);
        boolean v26_1 = v2.optBoolean("mobaMode", false);
        v0_1 = v1.safeFloat(v2.optDouble("diagonalAngleDeg", 45));
        v0_2 = v0_1 != null ? v0_1.floatValue() : 45f;
        float v27_1 = v0_2;
        long v28_1 = v2.optLong("smoothingMs", 0);
        boolean v30_1 = v2.optBoolean("sprintEnabled", false);
        JSONObject v0_5 = v2.optJSONObject("sprintBinding");
        if(v0_5 != null) {
            try {
                v4 = v0_5.optString(v5);
                Intrinsics.checkNotNullExpressionValue(v4, v8);
                InputBindingSource v4_1 = InputBindingSource.valueOf(v4);
                v0 = v0_5.optString(v7);
                Intrinsics.checkNotNullExpressionValue(v0, v8);
                v0_4 = Result.constructor-impl(new InputBinding(v4_1, v0));
            }
            catch(Throwable v0_3) {
                v0_4 = Result.constructor-impl(ResultKt.createFailure(v0_3));
            }

            Object v9_2 = Result.isFailure-impl(v0_4) ? null : v0_4;
            if(v9_2 != null) {
                goto label_255;
            }
        }

        v9_1 = InputBinding.Companion.keyboard("SHIFT");
    label_255:
        Object v31_1 = v9_1;
        v0_1 = v1.safeFloat(v2.optDouble("sprintExpansion", 1.25));
        v0_2 = v0_1 != null ? v0_1.floatValue() : 1.25f;
        JoystickComponent v16_1 = new JoystickComponent(v17, v18, v19, v20_1, v21_1, v22, v23_1, v25, v26_1, v27_1, v28_1, v30_1, ((InputBinding)v31_1), v0_2, v2.optBoolean("socdEnabled", true)).normalized();
    label_271:
        return ((ControlComponent)v16);
    }

    private final TapComponent deserializeTapSettings(JSONObject arg14) {
        Object v0_2;
        int v2 = arg14.optInt("timingVersion", 0);
        if(v2 >= 0 && v2 < 2) {
            try {
                String v0_1 = arg14.optString("mode");
                Intrinsics.checkNotNullExpressionValue(v0_1, "optString(...)");
                v0_2 = Result.constructor-impl(TapMode.valueOf(v0_1));
            }
            catch(Throwable v0) {
                v0_2 = Result.constructor-impl(ResultKt.createFailure(v0));
            }

            TapMode v3 = TapMode.SINGLE;
            if(Result.isFailure-impl(v0_2)) {
                TapMode v0_3 = v3;
            }

            TapComponent v3_1 = new TapComponent(v0_2, arg14.optLong("touchDurationMs", 45), arg14.optLong("intervalMs", 120), arg14.optBoolean("repeatEnabled", false), arg14.optInt("repeatCount", 1), this.safePositiveFloat(arg14.optDouble("repeatsPerSecond", 8), 8f), arg14.optBoolean("advancedTimingEnabled", false));
            TapTimingPolicy v13 = TapTimingPolicy.INSTANCE;
            TapComponent v13_1 = v2 == 0 ? v13.migrateLegacy(v3_1) : v13.normalize(v3_1);
            return v13_1;
        }

        throw new IllegalArgumentException("Versión de tiempos de Tocar no soportada: " + v2.toString());
    }

    private final String encode(GameProfile arg8) {
        int v1_2;
        JSONObject v0 = new JSONObject();
        List v1 = arg8.getVisualControls();
        if(!(v1 instanceof Collection) || !v1.isEmpty()) {
            Iterator v1_1 = ((Iterable)v1).iterator();
            do {
                if(v1_1.hasNext()) {
                    if(v1_1.next().getActivationBinding() == null) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_17;
                }
            }
            while(true);

            v1_2 = 3;
            goto label_18;
        label_17:
            v1_2 = 2;
        }
        else {
            goto label_17;
        }

    label_18:
        v0.put("version", v1_2);
        v0.put("targetPackage", arg8.getTargetPackage());
        v0.put("name", arg8.getName());
        JSONArray v1_3 = new JSONArray();
        Iterator v2 = arg8.getControls().iterator();
        while(v2.hasNext()) {
            v1_3.put(this.serializeControl(v2.next()));
        }

        v0.put("controls", v1_3);
        if(!arg8.getVisualControls().isEmpty()) {
            JSONArray v7 = new JSONArray();
            Iterator v8 = arg8.getVisualControls().iterator();
            while(true) {
                if(v8.hasNext()) {
                    Object v1_4 = v8.next();
                    float v3 = 3.402823E+38f;
                    if(Math.abs(((VistaLibreMarker)v1_4).getX()) <= v3 && Math.abs(((VistaLibreMarker)v1_4).getY()) <= v3) {
                        JSONObject v2_1 = new JSONObject();
                        v2_1.put("type", "VISTA_LIBRE_VISUAL");
                        v2_1.put("id", ((VistaLibreMarker)v1_4).getId());
                        v2_1.put("x", ((double)((VistaLibreMarker)v1_4).getX()));
                        v2_1.put("y", ((double)((VistaLibreMarker)v1_4).getY()));
                        v2_1.put("width", RangesKt.coerceAtLeast(((VistaLibreMarker)v1_4).getWidth(), 0));
                        v2_1.put("height", RangesKt.coerceAtLeast(((VistaLibreMarker)v1_4).getHeight(), 0));
                        InputBinding v3_1 = ((VistaLibreMarker)v1_4).getActivationBinding();
                        if(v3_1 != null) {
                            if(FreeLookBindings.INSTANCE.isAllowed(v3_1)) {
                                v2_1.put("activationBinding", new JSONObject().put("source", v3_1.getSource().name()).put("code", v3_1.getNormalizedCode()));
                            }
                            else {
                                throw new IllegalArgumentException("Tecla Vista libre inválida".toString());
                            }
                        }

                        JSONObject v3_2 = new JSONObject();
                        v3_2.put("sensitivity", RangesKt.coerceIn(((VistaLibreMarker)v1_4).getSensitivity(), 50, 1000));
                        v3_2.put("resetOnEdge", ((VistaLibreMarker)v1_4).getResetOnEdge());
                        v2_1.put("settings", v3_2);
                        v7.put(v2_1);
                        continue;
                    }

                    break;
                }
                else {
                    goto label_124;
                }
            }

            throw new IllegalArgumentException("Marcador Vista libre inválido".toString());
        label_124:
            v0.put("visualControls", v7);
        }

        String v7_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v7_1, "toString(...)");
        return v7_1;
    }

    public final String export(GameProfile arg2) {
        Intrinsics.checkNotNullParameter(arg2, "profile");
        ProfileIdentities.INSTANCE.requireUnique(arg2);
        return this.encode(arg2);
    }

    public final boolean hasIdentityConflicts(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "targetPackage");
        String v1 = this.preferences.getString(this.key(arg2), null);
        if(v1 != null) {
            return ProfileIdentities.INSTANCE.conflicts(new JSONObject(v1)).isEmpty() ^ 1;
        }

        return 0;
    }

    public final GameProfile importProfile(String arg27, String arg28) {
        InputBinding v25_1;
        Object v0_6;
        String v16;
        GameProfileStorage v1 = this;
        String v2 = arg28;
        String v3 = "getString(...)";
        Intrinsics.checkNotNullParameter(arg27, "json");
        Intrinsics.checkNotNullParameter(v2, "targetPackage");
        JSONObject v4 = new JSONObject(arg27);
        int v0 = v4.optInt("version");
        if(1 <= v0 && v0 < 4) {
            ViewComponent v0_1 = v0 == 1 ? v1.parseLegacyCamera(v4) : null;
            JSONArray v5 = v4.optJSONArray("controls");
            if(v5 == null) {
                v5 = new JSONArray();
            }

            List v7 = CollectionsKt.createListBuilder();
            int v8 = v5.length();
            int v10;
            for(v10 = 0; v10 < v8; ++v10) {
                JSONObject v11 = v5.optJSONObject(v10);
                if(v11 != null) {
                    ProfileControl v11_1 = v1.deserializeControl(v11, v10, v0_1);
                    if(v11_1 != null) {
                        v7.add(v11_1);
                    }
                }
            }

            List v5_1 = CollectionsKt.build(v7);
            String v0_2 = v4.optString("name");
            if(StringsKt.isBlank(((CharSequence)v0_2))) {
                v0_2 = v2;
            }

            Intrinsics.checkNotNullExpressionValue(v0_2, "ifBlank(...)");
            String v7_1 = v0_2;
            List v8_1 = CollectionsKt.createListBuilder();
            JSONArray v0_3 = v4.optJSONArray("visualControls");
            if(v0_3 == null) {
                v0_3 = new JSONArray();
            }

            JSONArray v10_1 = v0_3;
            int v11_2 = v10_1.length();
            int v12 = 0;
            while(v12 < v11_2) {
                JSONObject v0_4 = v10_1.optJSONObject(v12);
                if(v0_4 == null) {
                }
                else if(Intrinsics.areEqual(v0_4.optString("type"), "VISTA_LIBRE_VISUAL")) {
                    double v14 = NaN;
                    v16 = v7_1;
                    Float v6 = v1.safeFloat(v0_4.optDouble("x", v14));
                    if(v6 != null) {
                        float v19 = v6.floatValue();
                        v6 = v1.safeFloat(v0_4.optDouble("y", v14));
                        if(v6 != null) {
                            float v20 = v6.floatValue();
                            String v18 = v0_4.optString("id");
                            JSONObject v6_1 = v0_4.optJSONObject("settings");
                            if(v6_1 == null) {
                                v6_1 = new JSONObject();
                            }

                            Intrinsics.checkNotNull(v18);
                            int v21 = RangesKt.coerceAtLeast(v0_4.optInt("width"), 0);
                            int v22 = RangesKt.coerceAtLeast(v0_4.optInt("height"), 0);
                            int v23 = RangesKt.coerceIn(v6_1.optInt("sensitivity", 320), 50, 1000);
                            boolean v24 = v6_1.optBoolean("resetOnEdge", false);
                            v0_4 = v0_4.optJSONObject("activationBinding");
                            if(v0_4 != null) {
                                try {
                                    v7_1 = v0_4.getString("source");
                                    Intrinsics.checkNotNullExpressionValue(v7_1, v3);
                                    InputBindingSource v7_2 = InputBindingSource.valueOf(v7_1);
                                    v0_2 = v0_4.getString("code");
                                    Intrinsics.checkNotNullExpressionValue(v0_2, v3);
                                    v0_6 = Result.constructor-impl(new InputBinding(v7_2, v0_2));
                                }
                                catch(Throwable v0_5) {
                                    v0_6 = Result.constructor-impl(ResultKt.createFailure(v0_5));
                                }

                                if(Result.isFailure-impl(v0_6)) {
                                    v0_6 = null;
                                }

                                if(v0_6 == null || !FreeLookBindings.INSTANCE.isAllowed(((InputBinding)v0_6))) {
                                    v0_6 = null;
                                }
                                else {
                                }

                                Object v25 = v0_6;
                            }
                            else {
                                v25_1 = null;
                            }

                            v8_1.add(new VistaLibreMarker(v18, v19, v20, v21, v22, v23, v24, v25_1));
                        }
                        else {
                        }
                    }
                    else {
                    }

                    goto label_135;
                }

                v16 = v7_1;
            label_135:
                ++v12;
                v7_1 = v16;
            }

            GameProfile v1_1 = new GameProfile(v2, v7_1, v5_1, CollectionsKt.build(v8_1));
            if((ProfileIdentities.INSTANCE.conflicts(v4).isEmpty()) && FreeLookBindings.INSTANCE.reservationCount(v1_1) != 0) {
                GameProfileCompiler.requireMacroContactBudgets$default(GameProfileCompiler.INSTANCE, v1_1, null, 2, null);
            }

            return v1_1;
        }

        throw new IllegalArgumentException("Versión de perfil no soportada: " + v0.toString());
    }

    private final String key(String arg2) {
        return "profile:" + arg2;
    }

    public final GameProfile load(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "targetPackage");
        return this.loadResult(arg2).getProfile();
    }

    public final GameProfileLoadResult loadResult(String arg11) {
        Object v3_1;
        Object v10;
        Intrinsics.checkNotNullParameter(arg11, "targetPackage");
        String v2 = null;
        String v1 = this.preferences.getString(this.key(arg11), v2);
        if(v1 == null) {
            return new GameProfileLoadResult(null, null, null, 7, null);
        }

        try {
            v10 = Result.constructor-impl(this.importProfile(v1, arg11));
        }
        catch(Throwable v0) {
            v10 = Result.constructor-impl(ResultKt.createFailure(v0));
        }

        if(Result.isFailure-impl(v10)) {
            GameProfile v3 = ((GameProfile)v2);
        }
        else {
            v3_1 = v10;
        }

        Throwable v10_1 = Result.exceptionOrNull-impl(v10);
        if(v10_1 != null) {
            v2 = v10_1.getMessage();
        }

        GameProfileLoadResult v0_1 = new GameProfileLoadResult(((GameProfile)v3_1), v1, v2);
        if(v0_1.getStatus() == Status.INVALID_PROFILE || !v0_1.getMacroErrors().isEmpty()) {
            String v10_2 = v0_1.getError();
            if(v10_2 == null) {
                v10_2 = CollectionsKt.joinToString$default(v0_1.getMacroErrors(), null, null, null, 0, null, null, 0x3F, null);
            }

            Log.e("GOLDEN_PROFILE", "Perfil protegido package=" + arg11 + ": " + v10_2);
        }

        return v0_1;
    }

    private final String normalizeType(String arg3) {
        String v2 = StringsKt.trim(((CharSequence)arg3)).toString().toUpperCase(Locale.ROOT);
        String v0 = "toUpperCase(...)";
        Intrinsics.checkNotNullExpressionValue(v2, v0);
        if(Intrinsics.areEqual(v2, "TOCAR")) {
            return "TAP";
        }

        if(Intrinsics.areEqual(v2, "VISTA")) {
            return "CAMARA";
        }

        v2 = StringsKt.trim(((CharSequence)arg3)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v2, v0);
        return v2;
    }

    private final ViewComponent parseLegacyCamera(JSONObject arg25) {
        GameProfileStorage v0 = this;
        JSONObject v1 = arg25.optJSONObject("camera");
        if(v1 == null) {
            return null;
        }

        ViewComponent v2 = null;
        boolean v3 = v1.optBoolean("enabled", true);
        double v5 = 2;
        Float v4 = v0.safeFloat(v1.optDouble("sensitivityX", v5));
        float v7 = 2f;
        float v4_1 = v4 != null ? v4.floatValue() : v7;
        v4_1 = GameProfileKt.normalizeViewSensitivity(v4_1);
        Float v5_1 = v0.safeFloat(v1.optDouble("sensitivityY", v5));
        if(v5_1 != null) {
            v7 = v5_1.floatValue();
        }

        float v5_2 = GameProfileKt.normalizeViewSensitivity(v7);
        boolean v6 = v1.optBoolean("invertY", false);
        float v8 = v0.safePositiveFloat(v1.optDouble("speed", 1), 1f);
        Float v7_1 = v0.safeFloat(v1.optDouble("smoothing", 0));
        float v9 = 0f;
        if(v7_1 != null) {
            v9 = RangesKt.coerceIn(v7_1.floatValue(), 0f, 0.95f);
        }

        super(v3, v4_1, v5_2, v6, false, 0f, v8, v9, v0.safePositiveFloat(v1.optDouble("maxDelta", 96), 96f), null, false, null, 0f, null, null, false, null, 0, false, 0x7FE30, null);
        return v2;
    }

    public final Object prepareIdRepair-hUnOzRk(String arg12, String arg13, GameProfile arg14, List arg15, List arg16, GameProfile arg17) {
        IdRepairPlan v0_2;
        String v2;
        String v3;
        SharedPreferences v10;
        Intrinsics.checkNotNullParameter(arg12, "targetPackage");
        List v8 = arg15;
        Intrinsics.checkNotNullParameter(arg15, "controlOrigins");
        List v9 = arg16;
        Intrinsics.checkNotNullParameter(v9, "visualOrigins");
        try {
            v10 = this.preferences;
            __monitor_enter(v10);
        }
        catch(Throwable v0) {
            goto label_113;
        }

        try {
            String v5 = this.preferences.getString(this.key(arg12), null);
            if(!Intrinsics.areEqual(v5, arg13)) {
                goto label_101;
            }

            if(v5 != null) {
                ProfileIdentities.INSTANCE.requireLosslessNumbers(v5);
            }

            if(v5 != null) {
                if(Intrinsics.areEqual(new JSONObject(v5).optString("targetPackage", arg12), arg12)) {
                }
                else {
                    throw new IllegalArgumentException("El JSON no pertenece al perfil seleccionado".toString());
                }
            }

            if(arg14 == null) {
                if(v5 != null) {
                    v3 = v5;
                }
                else {
                    throw new IllegalStateException("No hay perfil para recuperar".toString());
                }
            }
            else if(Intrinsics.areEqual(arg14.getTargetPackage(), arg12)) {
                if(v5 == null) {
                    v2 = this.encode(arg14);
                }
                else {
                    ProfileIdentities v4 = ProfileIdentities.INSTANCE;
                    GameProfile v3_1 = arg17 == null ? this.importProfile(v5, arg12) : arg17;
                    v2 = v4.editorSnapshot(v5, new JSONObject(this.encode(v3_1)), new JSONObject(this.encode(arg14)), v8, v9);
                }

                v3 = v2;
            }
            else {
                goto label_96;
            }

            Pair v2_1 = ProfileIdentities.INSTANCE.repair(v3);
            Object v4_1 = v2_1.component1();
            int v2_2 = v2_1.component2().intValue();
            GameProfile v0_1 = this.importProfile(((String)v4_1), arg12);
            if(v0_1.getControls().size() + v0_1.getVisualControls().size() != ProfileIdentities.INSTANCE.entries(new JSONObject(((String)v4_1))).size()) {
                goto label_91;
            }

            ProfileIdentities.INSTANCE.requireUnique(v0_1);
            v0_2 = new IdRepairPlan(arg12, v5, v3, ((String)v4_1), v2_2);
        }
        catch(Throwable v0) {
            goto label_107;
        }

        try {
            __monitor_exit(v10);
            return Result.constructor-impl(v0_2);
        }
        catch(Throwable v0) {
            goto label_113;
        }

        try {
        label_91:
            throw new IllegalArgumentException("La carga omitiría controles; reparación cancelada".toString());
        label_96:
            throw new IllegalArgumentException("El paquete de la edición cambió".toString());
        label_101:
            throw new IllegalArgumentException("El perfil guardado cambió; vuelve a abrir la recuperación".toString());
        }
        catch(Throwable v0) {
            try {
            label_107:
                __monitor_exit(v10);
                throw v0;
            }
            catch(Throwable v0) {
            label_113:
                return Result.constructor-impl(ResultKt.createFailure(v0));
            }
        }
    }

    public static Object prepareIdRepair-hUnOzRk$default(GameProfileStorage arg1, String arg2, String arg3, GameProfile arg4, List arg5, List arg6, GameProfile arg7, int arg8, Object arg9) {
        GameProfile v0 = null;
        if((arg8 & 4) != 0) {
            arg4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = CollectionsKt.emptyList();
        }

        if((arg8 & 16) != 0) {
            arg6 = CollectionsKt.emptyList();
        }

        if((arg8 & 0x20) != 0) {
            arg7 = v0;
        }

        return arg1.prepareIdRepair-hUnOzRk(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public final JSONObject readIdentityBackup(String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "backupKey");
        arg5 = this.backups.getString(arg5, null);
        if(arg5 != null) {
            JSONObject v0 = new JSONObject(arg5);
            arg5 = v0.getString("profileKey");
            String v1 = v0.getString("targetPackage");
            String v2 = "getString(...)";
            Intrinsics.checkNotNullExpressionValue(v1, v2);
            if(Intrinsics.areEqual(arg5, this.key(v1))) {
                String v4 = v0.getString("originalSha256");
                ProfileIdentities v5 = ProfileIdentities.INSTANCE;
                v1 = "original";
                v1 = v0.isNull(v1) ? "" : v0.getString(v1);
                Intrinsics.checkNotNull(v1);
                if(Intrinsics.areEqual(v4, v5.checksum(v1))) {
                    v4 = v0.getString("pendingSha256");
                    v5 = ProfileIdentities.INSTANCE;
                    v1 = v0.getString("pending");
                    Intrinsics.checkNotNullExpressionValue(v1, v2);
                    if(Intrinsics.areEqual(v4, v5.checksum(v1))) {
                        return v0;
                    }

                    throw new IllegalStateException("Checksum de la edición incorrecto".toString());
                }

                throw new IllegalStateException("Checksum del original incorrecto".toString());
            }

            throw new IllegalStateException("Check failed.");
        }

        throw new IllegalStateException("Respaldo no disponible".toString());
    }

    public final Object repairIds-IoAF18A(IdRepairPlan arg8) {
        Object v5_1;
        SharedPreferences v1;
        String v0 = "ids:";
        Intrinsics.checkNotNullParameter(arg8, "plan");
        try {
            v1 = this.preferences;
            __monitor_enter(v1);
        }
        catch(Throwable v7) {
            goto label_139;
        }

        try {
            String v4 = null;
            if(!Intrinsics.areEqual(this.preferences.getString(this.key(arg8.getTargetPackage()), v4), arg8.getOriginalJson())) {
                goto label_127;
            }

            if(arg8.getChangedIds() <= 0) {
                goto label_122;
            }

            if(ProfileIdentities.INSTANCE.verifyRepair(arg8.getPendingJson(), arg8.getRepairedJson()) != arg8.getChangedIds()) {
                goto label_118;
            }

            v0 = v0 + arg8.getTargetPackage() + ":" + UUID.randomUUID();
            JSONObject v2 = new JSONObject().put("targetPackage", arg8.getTargetPackage()).put("createdAt", System.currentTimeMillis()).put("profileKey", this.key(arg8.getTargetPackage()));
            String v3 = "original";
            String v5 = arg8.getOriginalJson();
            if(v5 == null) {
                v5_1 = JSONObject.NULL;
            }

            v2 = v2.put(v3, v5_1);
            v3 = "originalSha256";
            ProfileIdentities v5_2 = ProfileIdentities.INSTANCE;
            String v6 = arg8.getOriginalJson();
            if(v6 == null) {
                v6 = "";
            }

            String v2_1 = v2.put(v3, v5_2.checksum(v6)).put("pending", arg8.getPendingJson()).put("pendingSha256", ProfileIdentities.INSTANCE.checksum(arg8.getPendingJson())).put("repairedSha256", ProfileIdentities.INSTANCE.checksum(arg8.getRepairedJson())).toString();
            Intrinsics.checkNotNullExpressionValue(v2_1, "toString(...)");
            if((this.backups.edit().putString(v0, v2_1).commit()) && (Intrinsics.areEqual(this.backups.getString(v0, v4), v2_1))) {
                this.readIdentityBackup(v0);
                if(Intrinsics.areEqual(this.preferences.getString(this.key(arg8.getTargetPackage()), v4), arg8.getOriginalJson())) {
                    try {
                        this.writeRawConfirmed(arg8.getTargetPackage(), arg8.getRepairedJson(), arg8.getOriginalJson());
                        goto label_93;
                    }
                    catch(Exception v7_1) {
                        try {
                            throw new IOException(v7_1.getMessage() + "; respaldo verificado: " + v0, ((Throwable)v7_1));
                        }
                        catch(Throwable v7) {
                            goto label_133;
                        }
                    }
                }
                else {
                    goto label_108;
                }
            }

            goto label_113;
        }
        catch(Throwable v7) {
            goto label_133;
        }

        try {
        label_93:
            __monitor_exit(v1);
            return Result.constructor-impl(v0);
        }
        catch(Throwable v7) {
            goto label_139;
        }

        try {
        label_108:
            throw new IllegalArgumentException("El perfil cambió durante el respaldo".toString());
        label_113:
            throw new IllegalStateException("No se pudo confirmar el respaldo; perfil intacto".toString());
        label_118:
            throw new IllegalStateException("Check failed.");
        label_122:
            throw new IllegalArgumentException("El perfil ya tiene identidades únicas".toString());
        label_127:
            throw new IllegalArgumentException("El perfil cambió durante la confirmación".toString());
        }
        catch(Throwable v7) {
            try {
            label_133:
                __monitor_exit(v1);
                throw v7;
            }
            catch(Throwable v7) {
            label_139:
                return Result.constructor-impl(ResultKt.createFailure(v7));
            }
        }
    }

    public final Object restoreIdentityBackup-gIAlu-s(String arg6, String arg7) {
        SharedPreferences v0;
        Intrinsics.checkNotNullParameter(arg6, "backupKey");
        try {
            v0 = this.preferences;
            __monitor_enter(v0);
        }
        catch(Throwable v5) {
            goto label_55;
        }

        try {
            JSONObject v6 = this.readIdentityBackup(arg6);
            String v1 = v6.getString("targetPackage");
            SharedPreferences v2 = this.preferences;
            Intrinsics.checkNotNull(v1);
            String v4 = null;
            if(!Intrinsics.areEqual(v2.getString(this.key(v1), v4), arg7)) {
                goto label_43;
            }

            if(v6.isNull("original")) {
            }
            else {
                v4 = v6.getString("original");
            }

            if(!Intrinsics.areEqual(arg7, v4) && (arg7 == null || !Intrinsics.areEqual(ProfileIdentities.INSTANCE.checksum(arg7), v6.getString("repairedSha256")))) {
                throw new IllegalArgumentException("El perfil ya no coincide con el resultado de esta reparación".toString());
            }

            this.writeRawConfirmed(v1, v4, arg7);
        }
        catch(Throwable v5) {
            goto label_49;
        }

        try {
            __monitor_exit(v0);
            return Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v5) {
            goto label_55;
        }

        try {
        label_43:
            throw new IllegalArgumentException("El perfil cambió; no se sobrescribió".toString());
        }
        catch(Throwable v5) {
            try {
            label_49:
                __monitor_exit(v0);
                throw v5;
            }
            catch(Throwable v5) {
            label_55:
                return Result.constructor-impl(ResultKt.createFailure(v5));
            }
        }
    }

    private final Float safeFloat(double arg3) {
        Double v2 = Double.valueOf(arg3);
        Float v4 = null;
        if(Double.compare(Math.abs(v2.doubleValue()), 1.797693E+308) <= 0) {
        }
        else {
            v2 = ((Double)v4);
        }

        if(v2 != null) {
            Float v2_1 = Float.valueOf(((float)v2.doubleValue()));
            if(Math.abs(v2_1.floatValue()) <= 3.402823E+38f) {
                return v2_1;
            }
        }

        return v4;
    }

    private final float safePositiveFloat(double arg1, float arg3) {
        Float v0 = this.safeFloat(arg1);
        if(v0 != null) {
            if(v0.floatValue() > 0f) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                return arg3;
            }

            return v0.floatValue();
        }

        return arg3;
    }

    public final Object save-IoAF18A(GameProfile arg5) {
        String v0 = "Perfil guardado package=";
        Intrinsics.checkNotNullParameter(arg5, "profile");
        try {
            GameProfileLoadResult.requireWritable$app$default(this.loadResult(arg5.getTargetPackage()), arg5, null, 2, null);
            GameProfileCompiler.requireMacroContactBudgets$default(GameProfileCompiler.INSTANCE, arg5, null, 2, null);
            this.writeConfirmed(arg5);
            Log.i("GOLDEN_PROFILE", v0 + arg5.getTargetPackage() + " controles=" + arg5.getControls().size());
            return Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v4) {
            return Result.constructor-impl(ResultKt.createFailure(v4));
        }
    }

    public final Object saveFreeLookProfile-IoAF18A(GameProfile arg4) {
        Intrinsics.checkNotNullParameter(arg4, "profile");
        try {
            GameProfileLoadResult.requireWritable$app$default(this.loadResult(arg4.getTargetPackage()), arg4, null, 2, null);
            GameProfileCompiler.requireMacroContactBudgets$default(GameProfileCompiler.INSTANCE, arg4, null, 2, null);
            this.writeConfirmed(arg4);
            return Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v3) {
            return Result.constructor-impl(ResultKt.createFailure(v3));
        }
    }

    public final Object saveMacro-0E7RQCE(GameProfile arg28, String arg29, MacroDraft arg30) {
        ProfileControl v14_2;
        ArrayList v4_1;
        int v14;
        List v3_2;
        List v8;
        long v6_2;
        GameProfileStorage v0 = this;
        String v1 = arg29;
        MacroDraft v2 = arg30;
        GameProfile v12 = arg28;
        Intrinsics.checkNotNullParameter(v12, "profile");
        Intrinsics.checkNotNullParameter(v1, "componentId");
        Intrinsics.checkNotNullParameter(v2, "draft");
        try {
            int v4 = 1;
            MacroValidationPolicy.INSTANCE.requireValid(v2, true);
            Iterator v3 = v12.getControls().iterator();
            RejectedMacroPayload v13 = null;
            int v5 = 0;
            ProfileControl v6 = ((ProfileControl)v13);
            while(true) {
                if(!v3.hasNext()) {
                    goto label_35;
                }

                Object v7 = v3.next();
                if(!Intrinsics.areEqual(v7.getId(), v1)) {
                    continue;
                }

                if(v5 != 0) {
                    break;
                }

                v5 = 1;
                Object v6_1 = v7;
            }

            throw new IllegalArgumentException("Collection contains more than one matching element.");
        label_35:
            if(v5 == 0) {
                goto label_130;
            }

            if((v6.getComponent() instanceof MacroScriptComponent)) {
                if(v2.getMode() == MacroRunMode.LOOP) {
                    v4 = v2.getRepetitions();
                }

                v5 = v4;
                long v3_1 = v2.getMode() == MacroRunMode.LOOP ? v2.getIntervalMs() : 0;
                v6_2 = v3_1;
                v8 = CollectionsKt.toList(v2.getTracks());
                v3_2 = v2.getActions();
                v14 = 10;
                v4_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_2), v14));
                v3 = ((Iterable)v3_2).iterator();
            }
            else {
                throw new IllegalArgumentException("El componente no es Macro-Script".toString());
            label_130:
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }

            while(v3.hasNext()) {
                Object v15 = v3.next();
                ((Collection)v4_1).add(MacroEditAction.copy$default(((MacroEditAction)v15), 0, null, 0, 0, null, CollectionsKt.toList(((MacroEditAction)v15).getPoints()), 0x1F, null));
            }

            v2 = MacroDraft.copy$default(v2, null, null, v5, v6_2, v8, v4_1, 3, null);
            v3_2 = v12.getControls();
            v4_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_2), v14));
            v3 = ((Iterable)v3_2).iterator();
            while(v3.hasNext()) {
                Object v14_1 = v3.next();
                if(Intrinsics.areEqual(((ProfileControl)v14_1).getId(), v1)) {
                    v14_2 = ProfileControl.copy$default(((ProfileControl)v14_1), null, null, 0f, 0f, 0, 0, null, new MacroScriptComponent(v2, v13, 2, ((DefaultConstructorMarker)v13)), 0x7F, null);
                }

                ((Collection)v4_1).add(v14_2);
            }

            GameProfile v2_1 = GameProfile.copy$default(v12, null, null, v4_1, null, 11, null);
            v0.loadResult(arg28.getTargetPackage()).requireWritable$app(v2_1, v1);
            GameProfileCompiler.INSTANCE.requireMacroContactBudgets(v2_1, v1);
            v0.writeConfirmed(v2_1);
            return Result.constructor-impl(v2_1);
        }
        catch(Throwable v0_1) {
            return Result.constructor-impl(ResultKt.createFailure(v0_1));
        }
    }

    public final Object saveVistaPrimary-0E7RQCE(GameProfile arg36, String arg37, InputBinding arg38) {
        ArrayList v5_1;
        ControlComponent v12;
        Object v6_1;
        GameProfileStorage v0 = this;
        String v1 = arg37;
        InputBinding v2 = arg38;
        GameProfile v4 = arg36;
        Intrinsics.checkNotNullParameter(v4, "profile");
        Intrinsics.checkNotNullParameter(v1, "componentId");
        Intrinsics.checkNotNullParameter(v2, "input");
        try {
            if((GameProfileCompiler.INSTANCE.isVistaInputAllowed(v2)) && (Intrinsics.areEqual(InputBinding.Companion.fromDisplayName(v2.displayName()), v2))) {
                Iterator v3 = v4.getControls().iterator();
                String v11 = null;
                int v5 = 0;
                ProfileControl v6 = ((ProfileControl)v11);
                while(true) {
                    if(v3.hasNext()) {
                        Object v7 = v3.next();
                        if(!Intrinsics.areEqual(v7.getId(), v1)) {
                            continue;
                        }

                        if(v5 == 0) {
                            v5 = 1;
                            v6_1 = v7;
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        goto label_40;
                    }

                    goto label_127;
                }

                throw new IllegalArgumentException("Collection contains more than one matching element.");
            label_40:
                if(v5 != 0) {
                    ControlComponent v3_1 = v6.getComponent();
                    v12 = (v3_1 instanceof ViewComponent) ? v3_1 : ((ControlComponent)v11);
                    if(v12 != null) {
                        List v3_2 = v4.getControls();
                        v5_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_2), 10));
                        v3 = ((Iterable)v3_2).iterator();
                        goto label_54;
                    }

                    throw new IllegalStateException("El componente no es VISTA".toString());
                }
                else {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                label_54:
                    while(v3.hasNext()) {
                        v6_1 = v3.next();
                        if(Intrinsics.areEqual(((ProfileControl)v6_1).getId(), v1)) {
                            v6 = ProfileControl.copy$default(v6_1, null, null, 0f, 0f, 0, 0, MapsKt.plus(((ProfileControl)v6_1).getBindings(), TuplesKt.to("PRIMARY", v2)), ViewComponent.copy$default(((ViewComponent)v12), false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, false, null, 0f, v2.displayName(), null, false, null, 0, false, 0x7DFFF, null), 0x3F, null);
                        }
                        else {
                        }

                        ((Collection)v5_1).add(v6);
                    }

                    GameProfile v1_1 = GameProfile.copy$default(v4, null, null, v5_1, null, 11, null);
                    GameProfileLoadResult.requireWritable$app$default(v0.loadResult(arg36.getTargetPackage()), v1_1, v11, 2, v11);
                    GameProfileCompiler.requireMacroContactBudgets$default(GameProfileCompiler.INSTANCE, v1_1, v11, 2, v11);
                    v0.writeConfirmed(v1_1);
                    return Result.constructor-impl(v1_1);
                }
            }

        label_127:
            throw new IllegalArgumentException("Entrada no permitida para VISTA".toString());
        }
        catch(Throwable v0_1) {
            return Result.constructor-impl(ResultKt.createFailure(v0_1));
        }
    }

    public final Object saveVistaSettings-yxL6bBk(GameProfile arg35, String arg36, float arg37, float arg38, ViewComponent arg39) {
        Iterator v4_2;
        ArrayList v5_2;
        ViewComponent v2_2;
        Object v6_2;
        GameProfileStorage v0 = this;
        String v1 = arg36;
        GameProfile v3 = arg35;
        Intrinsics.checkNotNullParameter(v3, "profile");
        Intrinsics.checkNotNullParameter(v1, "componentId");
        ViewComponent v4 = arg39;
        Intrinsics.checkNotNullParameter(v4, "settings");
        try {
            float v5 = 3.402823E+38f;
            if(Math.abs(arg37) <= v5 && Math.abs(arg38) <= v5) {
                long v6 = v4.getQuickChangeDelayMs();
                if(0 <= v6 && v6 < 5001) {
                    if(Math.abs(v4.getSniperMultiplier()) <= v5 && v4.getSniperMultiplier() > 0f) {
                        Iterator v2 = v3.getControls().iterator();
                        String v10 = null;
                        int v5_1 = 0;
                        ProfileControl v6_1 = ((ProfileControl)v10);
                        while(true) {
                            if(v2.hasNext()) {
                                Object v7 = v2.next();
                                if(!Intrinsics.areEqual(v7.getId(), v1)) {
                                    continue;
                                }

                                if(v5_1 == 0) {
                                    v5_1 = 1;
                                    v6_2 = v7;
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                goto label_48;
                            }

                            goto label_131;
                        }

                        throw new IllegalArgumentException("Collection contains more than one matching element.");
                    label_48:
                        if(v5_1 == 0) {
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        label_86:
                            while(v4_2.hasNext()) {
                                Object v11 = v4_2.next();
                                if(Intrinsics.areEqual(((ProfileControl)v11).getId(), v1)) {
                                    ProfileControl v11_1 = ProfileControl.copy$default(((ProfileControl)v11), null, null, arg37, arg38, 0, 0, null, v2_2, 0x73, null);
                                }

                                ((Collection)v5_2).add(v11);
                            }

                            GameProfile v1_1 = GameProfile.copy$default(v3, null, null, v5_2, null, 11, null);
                            GameProfileLoadResult.requireWritable$app$default(v0.loadResult(arg35.getTargetPackage()), v1_1, v10, 2, v10);
                            GameProfileCompiler.requireMacroContactBudgets$default(GameProfileCompiler.INSTANCE, v1_1, v10, 2, v10);
                            v0.writeConfirmed(v1_1);
                            return Result.constructor-impl(v1_1);
                        }
                        else if((((ProfileControl)v6_2).getComponent() instanceof ViewComponent)) {
                            ControlComponent v2_1 = ((ProfileControl)v6_2).getComponent();
                            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.profile.ViewComponent");
                            v2_2 = ViewComponent.copy$default(v2_1, false, GameProfileKt.normalizeViewSensitivity(v4.getSensitivityX()), GameProfileKt.normalizeViewSensitivity(v4.getSensitivityY()), false, false, 0f, 0f, 0f, 0f, null, v4.getSniperEnabled(), v4.getSniperKey(), v4.getSniperMultiplier(), null, null, false, v4.getQuickChangeBinding(), v4.getQuickChangeDelayMs(), v4.getGoldenPrecisionPlus(), 0xE3F9, null);
                            List v4_1 = v3.getControls();
                            v5_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4_1), 10));
                            v4_2 = ((Iterable)v4_1).iterator();
                            goto label_86;
                        }
                        else {
                            throw new IllegalArgumentException("El componente no es VISTA".toString());
                        }
                    }

                label_131:
                    throw new IllegalArgumentException("Multiplicador Sniper inválido".toString());
                }

                throw new IllegalArgumentException("Intervalo VISTA inválido".toString());
            }

            throw new IllegalArgumentException("Coordenadas VISTA inválidas".toString());
        }
        catch(Throwable v0_1) {
            return Result.constructor-impl(ResultKt.createFailure(v0_1));
        }
    }

    private final JSONObject serializeControl(ProfileControl arg8) {
        JSONObject v0 = new JSONObject();
        v0.put("id", arg8.getId());
        v0.put("type", arg8.getComponent().getType());
        v0.put("x", ((double)arg8.getX()));
        v0.put("y", ((double)arg8.getY()));
        v0.put("width", arg8.getWidth());
        v0.put("height", arg8.getHeight());
        JSONArray v1 = new JSONArray();
        Iterator v2 = arg8.getBindings().entrySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            Object v4 = ((Map$Entry)v3).getKey();
            v3 = ((Map$Entry)v3).getValue();
            JSONObject v5 = new JSONObject();
            v5.put("slot", v4);
            v5.put("source", ((InputBinding)v3).getSource().name());
            v5.put("code", ((InputBinding)v3).getNormalizedCode());
            v1.put(v5);
        }

        v0.put("bindings", v1);
        v0.put("settings", this.serializeSettings(arg8.getComponent()));
        return v0;
    }

    private final Object serializeSettings(ControlComponent arg9) {
        boolean v8 = arg9 instanceof MacroScriptComponent;
        if(v8) {
            return MacroDraftJson.INSTANCE.encodeComponent(((MacroScriptComponent)arg9));
        }

        JSONObject v0 = new JSONObject();
        if((arg9 instanceof TapComponent)) {
            v0.put("timingVersion", 1);
            v0.put("mode", ((TapComponent)arg9).getMode().name());
            v0.put("touchDurationMs", ((TapComponent)arg9).getTouchDurationMs());
            v0.put("intervalMs", ((TapComponent)arg9).getIntervalMs());
            v0.put("repeatEnabled", ((TapComponent)arg9).getRepeatEnabled());
            v0.put("repeatCount", ((TapComponent)arg9).getRepeatCount());
            v0.put("repeatsPerSecond", ((double)((TapComponent)arg9).getRepeatsPerSecond()));
            v0.put("advancedTimingEnabled", ((TapComponent)arg9).getAdvancedTimingEnabled());
            return v0;
        }

        String v2 = "code";
        String v3 = "source";
        if((arg9 instanceof JoystickComponent)) {
            v0.put("radius", ((double)((JoystickComponent)arg9).getRadius()));
            v0.put("speedModifier1", ((double)((JoystickComponent)arg9).getSpeedModifier1()));
            v0.put("radius1", ((double)((JoystickComponent)arg9).getRadius1()));
            v0.put("speedModifier2", ((double)((JoystickComponent)arg9).getSpeedModifier2()));
            v0.put("radius2", ((double)((JoystickComponent)arg9).getRadius2()));
            v0.put("movementSpeed", ((double)((JoystickComponent)arg9).getMovementSpeed()));
            v0.put("activationTimeMs", ((JoystickComponent)arg9).getActivationTimeMs());
            v0.put("activationSpeed", ((double)((JoystickComponent)arg9).getActivationSpeed()));
            v0.put("mobaMode", ((JoystickComponent)arg9).getMobaMode());
            JoystickComponent v8_1 = ((JoystickComponent)arg9).normalized();
            v0.put("diagonalAngleDeg", ((double)v8_1.getDiagonalAngleDeg()));
            v0.put("smoothingMs", v8_1.getSmoothingMs());
            v0.put("sprintEnabled", v8_1.getSprintEnabled());
            JSONObject v9 = new JSONObject();
            v9.put(v3, v8_1.getSprintBinding().getSource().name());
            v9.put(v2, v8_1.getSprintBinding().getNormalizedCode());
            v0.put("sprintBinding", v9);
            v0.put("sprintExpansion", ((double)v8_1.getSprintExpansion()));
            v0.put("socdEnabled", v8_1.getSocdEnabled());
            return v0;
        }

        if((arg9 instanceof ViewComponent)) {
            v0.put("enabled", ((ViewComponent)arg9).getEnabled());
            v0.put("goldenPrecisionPlus", ((ViewComponent)arg9).getGoldenPrecisionPlus());
            v0.put("sensitivityX", ((double)GameProfileKt.normalizeViewSensitivity(((ViewComponent)arg9).getSensitivityX())));
            v0.put("sensitivityY", ((double)GameProfileKt.normalizeViewSensitivity(((ViewComponent)arg9).getSensitivityY())));
            v0.put("invertY", ((ViewComponent)arg9).getInvertY());
            v0.put("mouseAcceleration", ((ViewComponent)arg9).getMouseAcceleration());
            v0.put("acceleration", ((double)((ViewComponent)arg9).getAcceleration()));
            v0.put("speed", ((double)((ViewComponent)arg9).getSpeed()));
            v0.put("smoothing", ((double)((ViewComponent)arg9).getSmoothing()));
            v0.put("maxDelta", ((double)((ViewComponent)arg9).getMaxDelta()));
            v0.put("tweaks", ((ViewComponent)arg9).getTweaks());
            v0.put("sniperEnabled", ((ViewComponent)arg9).getSniperEnabled());
            v0.put("sniperKey", ((ViewComponent)arg9).getSniperKey());
            v0.put("sniperMultiplier", ((double)((ViewComponent)arg9).getSniperMultiplier()));
            v0.put("toggleCursorKey", ((ViewComponent)arg9).getToggleCursorKey());
            v0.put("suspendCursorKey", ((ViewComponent)arg9).getSuspendCursorKey());
            InputBinding v8_2 = ((ViewComponent)arg9).getQuickChangeBinding();
            if(v8_2 != null) {
                JSONObject v1 = new JSONObject();
                v1.put(v3, v8_2.getSource().name());
                v1.put(v2, v8_2.getNormalizedCode());
                v0.put("quickChangeBinding", v1);
            }

            v0.put("quickChangeDelayMs", RangesKt.coerceIn(((ViewComponent)arg9).getQuickChangeDelayMs(), 0, 5000));
            v0.put("linkedSensitivities", ((ViewComponent)arg9).getLinkedSensitivities());
            return v0;
        }

        if((arg9 instanceof FireComponent)) {
            v0.put("continuous", ((FireComponent)arg9).getContinuous());
            return v0;
        }

        if(v8) {
            return v0;
        }

        throw new NoWhenBranchMatchedException();
    }

    private final void writeConfirmed(GameProfile arg8) {
        String v2_1;
        SharedPreferences v0 = this.preferences;
        __monitor_enter(v0);
        try {
            String v1 = this.preferences.getString(this.key(arg8.getTargetPackage()), null);
            if(v1 != null) {
                if(ProfileIdentities.INSTANCE.conflicts(new JSONObject(v1)).isEmpty()) {
                }
                else {
                    throw new IllegalArgumentException("El perfil guardado necesita confirmar la reparación de identificadores".toString());
                }
            }

            JSONObject v2 = new JSONObject(this.export(arg8));
            if(v1 == null) {
                v2_1 = v2.toString();
            }
            else {
                ProfileIdentities.INSTANCE.requireLosslessNumbers(v1);
                GameProfile v3 = this.importProfile(v1, arg8.getTargetPackage());
                if(v3.getControls().size() + v3.getVisualControls().size() == ProfileIdentities.INSTANCE.entries(new JSONObject(v1)).size()) {
                    Object v2_2 = ProfileIdentities.INSTANCE.merge(new JSONObject(v1), new JSONObject(this.encode(v3)), v2);
                    Intrinsics.checkNotNull(v2_2, "null cannot be cast to non-null type org.json.JSONObject");
                    v2_1 = ((JSONObject)v2_2).toString();
                }
                else {
                    goto label_57;
                }
            }

            Intrinsics.checkNotNull(v2_1);
            this.writeRawConfirmed(arg8.getTargetPackage(), v2_1, v1);
        }
        catch(Throwable v7) {
            goto label_63;
        }

        __monitor_exit(v0);
        return;
        try {
        label_57:
            throw new IllegalArgumentException("El perfil contiene datos que esta versión no puede reconstruir; original protegido".toString());
        }
        catch(Throwable v7) {
        label_63:
            __monitor_exit(v0);
            throw v7;
        }
    }

    private final void writeRawConfirmed(String arg4, String arg5, String arg6) {
        Object v3_2;
        boolean v3_1;
        arg4 = this.key(arg4);
        String v0 = null;
        try {
            SharedPreferences$Editor v1_1 = this.preferences.edit();
            if(arg5 == null) {
                v1_1.remove(arg4);
            }
            else {
                v1_1.putString(arg4, arg5);
            }

            if((v1_1.commit()) && (Intrinsics.areEqual(this.preferences.getString(arg4, v0), arg5))) {
                return;
            }

            throw new IllegalStateException("El almacenamiento no confirmó la escritura".toString());
        }
        catch(Exception v1) {
            String v2 = this.preferences.getString(arg4, v0);
            if(!Intrinsics.areEqual(v2, arg5)) {
                if(Intrinsics.areEqual(v2, arg6)) {
                }
                else {
                    throw new IOException("El perfil cambió durante la escritura; no se sobrescribió el cambio concurrente", ((Throwable)v1));
                }
            }

            try {
                SharedPreferences$Editor v2_1 = this.preferences.edit();
                if(arg6 == null) {
                    v2_1.remove(arg4);
                }
                else {
                    v2_1.putString(arg4, arg6);
                }

                v3_1 = !v2_1.commit() || !Intrinsics.areEqual(this.preferences.getString(arg4, v0), arg6) ? false : true;
                v3_2 = Result.constructor-impl(Boolean.valueOf(v3_1));
            }
            catch(Throwable v3) {
                v3_2 = Result.constructor-impl(ResultKt.createFailure(v3));
            }

            Boolean v4 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v3_2)) {
                Boolean v3_3 = v4;
            }

            v3_1 = ((Boolean)v3_2).booleanValue();
            arg5 = v1.getMessage();
            String v3_4 = v3_1 ? "; original restaurado" : "; restaura el respaldo antes de continuar";
            throw new IOException("No se pudo guardar el perfil: " + arg5 + v3_4, ((Throwable)v1));
        }
    }
}

