package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001SB\u0015\bF\u0012\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010\u0002H\u0097\u0080\u0004J\n\u0010J\u001A\u00020KH\u0082\u0080\u0004J\n\u0010L\u001A\u00020MH\u0096\u0080\u0004J\u0014\u0010N\u001A\u00020$2\b\u0010O\u001A\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010P\u001A\u00020QH\u0096\u0080\u0004J\n\u0010R\u001A\u00020\fH\u0096\u0080\u0004R\u0019\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000ER\u001F\u0010\u0011\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00128VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0015R\u001F\u0010\u0019\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00128VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0015R\u001B\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010 \u001A\u0004\u0018\u00010\u00028VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b!\u0010\"R!\u0010&\u001A\b\u0012\u0004\u0012\u00020\'0\u001C8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b(\u0010)\u001A\u0004\b*\u0010\u001FR!\u0010+\u001A\b\u0012\u0004\u0012\u00020,0\u001C8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b-\u0010)\u001A\u0004\b.\u0010\u001FR)\u0010/\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001C8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b0\u0010)\u001A\u0004\b1\u0010\u001FR\u001D\u00102\u001A\u0004\u0018\u0001038VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b4\u0010)\u001A\u0004\b5\u00106R\u001B\u00107\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b8\u0010)\u001A\u0004\b7\u00109R\u001B\u0010:\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b;\u0010)\u001A\u0004\b:\u00109R\u001B\u0010<\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b=\u0010)\u001A\u0004\b<\u00109R\u001B\u0010>\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\b?\u0010)\u001A\u0004\b>\u00109R\u001B\u0010@\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\bA\u0010)\u001A\u0004\b@\u00109R\u001B\u0010B\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\bC\u0010)\u001A\u0004\bB\u00109R\u001B\u0010D\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\bE\u0010)\u001A\u0004\bD\u00109R\u001B\u0010F\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\bG\u0010)\u001A\u0004\bF\u00109R\u001B\u0010H\u001A\u00020$8VX\u0097\u0084\b¢\u0006\f\u0012\u0004\bI\u0010)\u001A\u0004\bH\u00109¨\u0006T"}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lkotlin/jvm/internal/KotlinGenericDeclaration;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "findJavaDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "equals", "other", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ClassReference implements ClassBasedDeclarationContainer, KotlinGenericDeclaration, KClass {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH\u0082\u0080\u0004J\u0014\u0010\f\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH\u0082\u0080\u0004J\u0018\u0010\r\u001A\u0004\u0018\u00010\n2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J\u0018\u0010\u000F\u001A\u0004\u0018\u00010\n2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J \u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00012\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004R\'\u0010\u0004\u001A\u001A\u0012\u0010\u0012\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNameOf", "", "type", "simpleNameOf", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final String classFqNameOf(String arg9) {
            int v8 = arg9.hashCode();
            String v0 = "kotlin.Boolean";
            String v1 = "kotlin.Long";
            String v2 = "kotlin.Char";
            String v3 = "kotlin.Byte";
            String v4 = "kotlin.Short";
            String v5 = "kotlin.Float";
            String v6 = "kotlin.Double";
            String v7 = "kotlin.Int";
            switch(v8) {
                case -2056817302: {
                    goto label_383;
                }
                case -1571515090: {
                    goto label_365;
                }
                case -1383349348: {
                    goto label_359;
                }
                case -1383343454: {
                    goto label_353;
                }
                case -1325958191: {
                    goto label_348;
                }
                case -1182275604: {
                    goto label_342;
                }
                case -1062240117: {
                    goto label_336;
                }
                case -688322466: {
                    goto label_330;
                }
                case -527879800: {
                    goto label_325;
                }
                case -515992664: {
                    goto label_320;
                }
                case -246476834: {
                    goto label_314;
                }
                case -207262728: {
                    goto label_308;
                }
                case -165139126: {
                    goto label_302;
                }
                case 104431: {
                    goto label_297;
                }
                case 3039496: {
                    goto label_292;
                }
                case 3052374: {
                    goto label_287;
                }
                case 3327612: {
                    goto label_282;
                }
                case 64711720: {
                    goto label_277;
                }
                case 65821278: {
                    goto label_271;
                }
                case 77230534: {
                    goto label_265;
                }
                case 97526364: {
                    goto label_260;
                }
                case 109413500: {
                    goto label_255;
                }
                case 155276373: {
                    goto label_250;
                }
                case 226173651: {
                    goto label_244;
                }
                case 344809556: {
                    goto label_239;
                }
                case 398507100: {
                    goto label_234;
                }
                case 398585941: {
                    goto label_228;
                }
                case 398795216: {
                    goto label_223;
                }
                case 482629606: {
                    goto label_217;
                }
                case 499831342: {
                    goto label_211;
                }
                case 577341676: {
                    goto label_205;
                }
                case 599019395: {
                    goto label_199;
                }
                case 761287205: {
                    goto label_194;
                }
                case 1052881309: {
                    goto label_188;
                }
                case 1063877011: {
                    goto label_182;
                }
                case 1195259493: {
                    goto label_176;
                }
                case 1275614662: {
                    goto label_170;
                }
                case 1383693018: {
                    goto label_164;
                }
                case 1630335596: {
                    goto label_158;
                }
                case 1877171123: {
                    goto label_152;
                }
                case -2061550653: {
                    goto label_388;
                }
                case -2034166429: {
                    goto label_377;
                }
                case -1979556166: {
                    goto label_371;
                }
                default: {
                    switch(v8) {
                        case -1811142716: {
                            goto label_146;
                        }
                        case -1811142715: {
                            goto label_140;
                        }
                        case -1811142714: {
                            goto label_134;
                        }
                        case -1811142713: {
                            goto label_128;
                        }
                        case -1811142712: {
                            goto label_122;
                        }
                        case -1811142711: {
                            goto label_116;
                        }
                        case -1811142710: {
                            goto label_110;
                        }
                        case -1811142709: {
                            goto label_104;
                        }
                        case -1811142708: {
                            goto label_98;
                        }
                        case -1811142707: {
                            goto label_92;
                        }
                        default: {
                            switch(v8) {
                                case -1811142685: {
                                    goto label_86;
                                }
                                case -1811142684: {
                                    goto label_80;
                                }
                                case -1811142683: {
                                    goto label_74;
                                }
                                default: {
                                    switch(v8) {
                                        case 80123371: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function0")) {
                                                return null;
                                            }

                                            return "kotlin.Function0";
                                        }
                                        case 80123372: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function1")) {
                                                return null;
                                            }

                                            return "kotlin.Function1";
                                        }
                                        case 80123373: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function2")) {
                                                return null;
                                            }

                                            return "kotlin.Function2";
                                        }
                                        case 80123374: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function3")) {
                                                return null;
                                            }

                                            return "kotlin.Function3";
                                        }
                                        case 80123375: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function4")) {
                                                return null;
                                            }

                                            return "kotlin.Function4";
                                        }
                                        case 80123376: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function5")) {
                                                return null;
                                            }

                                            return "kotlin.Function5";
                                        }
                                        case 80123377: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function6")) {
                                                return null;
                                            }

                                            return "kotlin.Function6";
                                        label_86:
                                            if(!arg9.equals("kotlin.jvm.functions.Function20")) {
                                                return null;
                                            }

                                            return "kotlin.Function20";
                                        label_74:
                                            if(!arg9.equals("kotlin.jvm.functions.Function22")) {
                                                return null;
                                            }

                                            return "kotlin.Function22";
                                        label_80:
                                            if(!arg9.equals("kotlin.jvm.functions.Function21")) {
                                                return null;
                                            }

                                            return "kotlin.Function21";
                                        label_98:
                                            if(!arg9.equals("kotlin.jvm.functions.Function18")) {
                                                return null;
                                            }

                                            return "kotlin.Function18";
                                        label_146:
                                            if(!arg9.equals("kotlin.jvm.functions.Function10")) {
                                                return null;
                                            }

                                            return "kotlin.Function10";
                                        label_116:
                                            if(!arg9.equals("kotlin.jvm.functions.Function15")) {
                                                return null;
                                            }

                                            return "kotlin.Function15";
                                        label_134:
                                            if(!arg9.equals("kotlin.jvm.functions.Function12")) {
                                                return null;
                                            }

                                            return "kotlin.Function12";
                                        label_104:
                                            if(!arg9.equals("kotlin.jvm.functions.Function17")) {
                                                return null;
                                            }

                                            return "kotlin.Function17";
                                        label_122:
                                            if(!arg9.equals("kotlin.jvm.functions.Function14")) {
                                                return null;
                                            }

                                            return "kotlin.Function14";
                                        label_92:
                                            if(!arg9.equals("kotlin.jvm.functions.Function19")) {
                                                return null;
                                            }

                                            return "kotlin.Function19";
                                        label_140:
                                            if(!arg9.equals("kotlin.jvm.functions.Function11")) {
                                                return null;
                                            }

                                            return "kotlin.Function11";
                                        label_110:
                                            if(!arg9.equals("kotlin.jvm.functions.Function16")) {
                                                return null;
                                            }

                                            return "kotlin.Function16";
                                        label_128:
                                            if(!arg9.equals("kotlin.jvm.functions.Function13")) {
                                                return null;
                                            }

                                            return "kotlin.Function13";
                                        label_353:
                                            if(!arg9.equals("java.util.Set")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Set";
                                        label_228:
                                            if(!arg9.equals("java.lang.Enum")) {
                                                return null;
                                            }

                                            return "kotlin.Enum";
                                        label_164:
                                            if(!arg9.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Boolean.Companion";
                                        label_292:
                                            if(!arg9.equals("byte")) {
                                                return null;
                                            }

                                            return v3;
                                        label_359:
                                            if(!arg9.equals("java.util.Map")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Map";
                                        label_297:
                                            if(!arg9.equals("int")) {
                                                return null;
                                            }

                                            return v7;
                                        label_170:
                                            if(!arg9.equals("java.lang.Iterable")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Iterable";
                                        label_234:
                                            if(!arg9.equals("java.lang.Byte")) {
                                                return null;
                                            }

                                            return v3;
                                        label_365:
                                            if(!arg9.equals("java.lang.Comparable")) {
                                                return null;
                                            }

                                            return "kotlin.Comparable";
                                        label_302:
                                            if(!arg9.equals("java.util.Map$Entry")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Map.Entry";
                                        label_239:
                                            if(!arg9.equals("java.lang.Boolean")) {
                                                return null;
                                            }

                                            return v0;
                                        label_176:
                                            if(!arg9.equals("java.lang.String")) {
                                                return null;
                                            }

                                            return "kotlin.String";
                                        label_371:
                                            if(!arg9.equals("java.lang.annotation.Annotation")) {
                                                return null;
                                            }

                                            return "kotlin.Annotation";
                                        label_308:
                                            if(!arg9.equals("kotlin.jvm.internal.LongCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Long.Companion";
                                        label_244:
                                            if(!arg9.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Enum.Companion";
                                        label_182:
                                            if(!arg9.equals("java.lang.Object")) {
                                                return null;
                                            }

                                            return "kotlin.Any";
                                        label_377:
                                            if(!arg9.equals("java.lang.Cloneable")) {
                                                return null;
                                            }

                                            return "kotlin.Cloneable";
                                        label_314:
                                            if(!arg9.equals("kotlin.jvm.internal.CharCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Char.Companion";
                                        label_250:
                                            if(!arg9.equals("java.lang.Character")) {
                                                return null;
                                            }

                                            return v2;
                                        label_188:
                                            if(!arg9.equals("java.lang.Number")) {
                                                return null;
                                            }

                                            return "kotlin.Number";
                                        label_383:
                                            if(!arg9.equals("java.lang.Integer")) {
                                                return null;
                                            }

                                            return v7;
                                        label_255:
                                            if(!arg9.equals("short")) {
                                                return null;
                                            }

                                            return v4;
                                        label_320:
                                            if(!arg9.equals("java.lang.Short")) {
                                                return null;
                                            }

                                            return v4;
                                        label_194:
                                            if(!arg9.equals("java.lang.Double")) {
                                                return null;
                                            }

                                            return v6;
                                        label_260:
                                            if(!arg9.equals("float")) {
                                                return null;
                                            }

                                            return v5;
                                        label_388:
                                            if(!arg9.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Double.Companion";
                                        label_325:
                                            if(!arg9.equals("java.lang.Float")) {
                                                return null;
                                            }

                                            return v5;
                                        label_199:
                                            if(!arg9.equals("kotlin.jvm.internal.StringCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.String.Companion";
                                        label_265:
                                            if(!arg9.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Short.Companion";
                                        label_330:
                                            if(!arg9.equals("java.util.Collection")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Collection";
                                        label_205:
                                            if(!arg9.equals("java.util.ListIterator")) {
                                                return null;
                                            }

                                            return "kotlin.collections.ListIterator";
                                        label_271:
                                            if(!arg9.equals("java.util.List")) {
                                                return null;
                                            }

                                            return "kotlin.collections.List";
                                        label_336:
                                            if(!arg9.equals("java.lang.CharSequence")) {
                                                return null;
                                            }

                                            return "kotlin.CharSequence";
                                        label_211:
                                            if(!arg9.equals("java.util.Iterator")) {
                                                return null;
                                            }

                                            return "kotlin.collections.Iterator";
                                        label_277:
                                            if(!arg9.equals("boolean")) {
                                                return null;
                                            }

                                            return v0;
                                        label_342:
                                            if(!arg9.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Byte.Companion";
                                        label_152:
                                            if(!arg9.equals("kotlin.jvm.internal.IntCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Int.Companion";
                                        label_217:
                                            if(!arg9.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                                                return null;
                                            }

                                            return "kotlin.Float.Companion";
                                        label_282:
                                            if(!arg9.equals("long")) {
                                                return null;
                                            }

                                            return v1;
                                        label_348:
                                            if(!arg9.equals("double")) {
                                                return null;
                                            }

                                            return v6;
                                        label_158:
                                            if(!arg9.equals("java.lang.Throwable")) {
                                                return null;
                                            }

                                            return "kotlin.Throwable";
                                        label_223:
                                            if(!arg9.equals("java.lang.Long")) {
                                                return null;
                                            }

                                            return v1;
                                        label_287:
                                            if(arg9.equals("char")) {
                                                return v2;
                                            }

                                            return null;
                                        }
                                        case 80123378: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function7")) {
                                                return null;
                                            }

                                            return "kotlin.Function7";
                                        }
                                        case 80123379: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function8")) {
                                                return null;
                                            }

                                            return "kotlin.Function8";
                                        }
                                        case 80123380: {
                                            if(!arg9.equals("kotlin.jvm.functions.Function9")) {
                                                return null;
                                            }

                                            return "kotlin.Function9";
                                        }
                                        default: {
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return null;
        }

        public final String getClassQualifiedName(Class arg4) {
            String v3;
            Intrinsics.checkNotNullParameter(arg4, "jClass");
            String v1 = null;
            if(arg4.isAnonymousClass()) {
                return v1;
            }

            if(arg4.isLocalClass()) {
                return v1;
            }

            String v2 = "getName(...)";
            if(arg4.isArray()) {
                arg4 = arg4.getComponentType();
                if(arg4.isPrimitive()) {
                    String v4 = arg4.getName();
                    Intrinsics.checkNotNullExpressionValue(v4, v2);
                    v3 = this.classFqNameOf(v4);
                    if(v3 != null) {
                        v1 = v3 + "Array";
                    }
                }

                if(v1 == null) {
                    return "kotlin.Array";
                }

                return v1;
            }

            String v0 = arg4.getName();
            Intrinsics.checkNotNullExpressionValue(v0, v2);
            v3 = this.classFqNameOf(v0);
            if(v3 == null) {
                v3 = arg4.getCanonicalName();
            }

            return v3;
        }

        public final String getClassSimpleName(Class arg6) {
            String v0_1;
            String v5;
            Intrinsics.checkNotNullParameter(arg6, "jClass");
            String v1 = null;
            if(arg6.isAnonymousClass()) {
                return v1;
            }

            if(arg6.isLocalClass()) {
                v5 = arg6.getSimpleName();
                Method v0 = arg6.getEnclosingMethod();
                int v2 = 2;
                char v3 = '$';
                if(v0 != null) {
                    Intrinsics.checkNotNull(v5);
                    v0_1 = StringsKt.substringAfter$default(v5, v0.getName() + v3, v1, v2, v1);
                    if(v0_1 == null) {
                    }
                    else {
                        return v0_1;
                    }
                }

                Constructor v6 = arg6.getEnclosingConstructor();
                if(v6 != null) {
                    Intrinsics.checkNotNull(v5);
                    return StringsKt.substringAfter$default(v5, v6.getName() + v3, v1, v2, v1);
                }

                Intrinsics.checkNotNull(v5);
                return StringsKt.substringAfter$default(v5, v3, v1, v2, v1);
            }

            String v2_1 = "getName(...)";
            if(arg6.isArray()) {
                arg6 = arg6.getComponentType();
                String v3_1 = "Array";
                if(arg6.isPrimitive()) {
                    String v6_1 = arg6.getName();
                    Intrinsics.checkNotNullExpressionValue(v6_1, v2_1);
                    v5 = this.simpleNameOf(v6_1);
                    if(v5 != null) {
                        v1 = v5 + v3_1;
                    }
                }

                if(v1 == null) {
                    return v3_1;
                }

                return v1;
            }

            v0_1 = arg6.getName();
            Intrinsics.checkNotNullExpressionValue(v0_1, v2_1);
            v5 = this.simpleNameOf(v0_1);
            if(v5 == null) {
                v5 = arg6.getSimpleName();
            }

            return v5;
        }

        public final boolean isInstance(Object arg2, Class arg3) {
            Intrinsics.checkNotNullParameter(arg3, "jClass");
            Map v1 = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Object v1_1 = v1.get(arg3);
            if(v1_1 != null) {
                return TypeIntrinsics.isFunctionOfArity(arg2, ((Number)v1_1).intValue());
            }

            if(arg3.isPrimitive()) {
                arg3 = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(arg3));
            }

            return arg3.isInstance(arg2);
        }

        private final String simpleNameOf(String arg10) {
            int v9 = arg10.hashCode();
            String v0 = "Boolean";
            String v1 = "Long";
            String v2 = "Char";
            String v3 = "Byte";
            String v4 = "Short";
            String v5 = "Float";
            String v6 = "Double";
            String v7 = "Int";
            String v8 = "Companion";
            switch(v9) {
                case -1571515090: {
                    goto label_357;
                }
                case -246476834: {
                    goto label_308;
                }
                case 1275614662: {
                    goto label_169;
                }
                case -2056817302: {
                    goto label_375;
                }
                case -1383349348: {
                    goto label_351;
                }
                case -1383343454: {
                    goto label_345;
                }
                case -1325958191: {
                    goto label_340;
                }
                case -1182275604: {
                    goto label_335;
                }
                case -1062240117: {
                    goto label_329;
                }
                case -688322466: {
                    goto label_323;
                }
                case -527879800: {
                    goto label_318;
                }
                case -515992664: {
                    goto label_313;
                }
                case -207262728: {
                    goto label_303;
                }
                case -165139126: {
                    goto label_297;
                }
                case 104431: {
                    goto label_292;
                }
                case 3039496: {
                    goto label_287;
                }
                case 3052374: {
                    goto label_282;
                }
                case 3327612: {
                    goto label_277;
                }
                case 64711720: {
                    goto label_272;
                }
                case 65821278: {
                    goto label_266;
                }
                case 77230534: {
                    goto label_261;
                }
                case 97526364: {
                    goto label_256;
                }
                case 109413500: {
                    goto label_251;
                }
                case 155276373: {
                    goto label_246;
                }
                case 226173651: {
                    goto label_241;
                }
                case 344809556: {
                    goto label_236;
                }
                case 398507100: {
                    goto label_231;
                }
                case 398585941: {
                    goto label_225;
                }
                case 398795216: {
                    goto label_220;
                }
                case 482629606: {
                    goto label_215;
                }
                case 499831342: {
                    goto label_209;
                }
                case 577341676: {
                    goto label_203;
                }
                case 599019395: {
                    goto label_198;
                }
                case 761287205: {
                    goto label_193;
                }
                case 1052881309: {
                    goto label_187;
                }
                case 1063877011: {
                    goto label_181;
                }
                case 1195259493: {
                    goto label_175;
                }
                case 1383693018: {
                    goto label_164;
                }
                case 1630335596: {
                    goto label_158;
                }
                case 1877171123: {
                    goto label_153;
                }
                case -2061550653: {
                    goto label_380;
                }
                case -2034166429: {
                    goto label_369;
                }
                case -1979556166: {
                    goto label_363;
                }
                default: {
                    switch(v9) {
                        case -1811142716: {
                            goto label_147;
                        }
                        case -1811142715: {
                            goto label_141;
                        }
                        case -1811142714: {
                            goto label_135;
                        }
                        case -1811142713: {
                            goto label_129;
                        }
                        case -1811142712: {
                            goto label_123;
                        }
                        case -1811142711: {
                            goto label_117;
                        }
                        case -1811142710: {
                            goto label_111;
                        }
                        case -1811142709: {
                            goto label_105;
                        }
                        case -1811142708: {
                            goto label_99;
                        }
                        case -1811142707: {
                            goto label_93;
                        }
                        default: {
                            switch(v9) {
                                case -1811142685: {
                                    goto label_87;
                                }
                                case -1811142684: {
                                    goto label_81;
                                }
                                case -1811142683: {
                                    goto label_75;
                                }
                                default: {
                                    switch(v9) {
                                        case 80123371: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function0")) {
                                                return null;
                                            }

                                            return "Function0";
                                        }
                                        case 80123372: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function1")) {
                                                return null;
                                            }

                                            return "Function1";
                                        label_81:
                                            if(!arg10.equals("kotlin.jvm.functions.Function21")) {
                                                return null;
                                            }

                                            return "Function21";
                                        label_87:
                                            if(!arg10.equals("kotlin.jvm.functions.Function20")) {
                                                return null;
                                            }

                                            return "Function20";
                                        label_75:
                                            if(!arg10.equals("kotlin.jvm.functions.Function22")) {
                                                return null;
                                            }

                                            return "Function22";
                                        label_129:
                                            if(!arg10.equals("kotlin.jvm.functions.Function13")) {
                                                return null;
                                            }

                                            return "Function13";
                                        label_99:
                                            if(!arg10.equals("kotlin.jvm.functions.Function18")) {
                                                return null;
                                            }

                                            return "Function18";
                                        label_147:
                                            if(!arg10.equals("kotlin.jvm.functions.Function10")) {
                                                return null;
                                            }

                                            return "Function10";
                                        label_117:
                                            if(!arg10.equals("kotlin.jvm.functions.Function15")) {
                                                return null;
                                            }

                                            return "Function15";
                                        label_135:
                                            if(!arg10.equals("kotlin.jvm.functions.Function12")) {
                                                return null;
                                            }

                                            return "Function12";
                                        label_105:
                                            if(!arg10.equals("kotlin.jvm.functions.Function17")) {
                                                return null;
                                            }

                                            return "Function17";
                                        label_123:
                                            if(!arg10.equals("kotlin.jvm.functions.Function14")) {
                                                return null;
                                            }

                                            return "Function14";
                                        label_93:
                                            if(!arg10.equals("kotlin.jvm.functions.Function19")) {
                                                return null;
                                            }

                                            return "Function19";
                                        label_141:
                                            if(!arg10.equals("kotlin.jvm.functions.Function11")) {
                                                return null;
                                            }

                                            return "Function11";
                                        label_111:
                                            if(!arg10.equals("kotlin.jvm.functions.Function16")) {
                                                return null;
                                            }

                                            return "Function16";
                                        label_225:
                                            if(!arg10.equals("java.lang.Enum")) {
                                                return null;
                                            }

                                            return "Enum";
                                        label_164:
                                            if(!arg10.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_292:
                                            if(!arg10.equals("int")) {
                                                return null;
                                            }

                                            return v7;
                                        label_357:
                                            if(!arg10.equals("java.lang.Comparable")) {
                                                return null;
                                            }

                                            return "Comparable";
                                        label_231:
                                            if(!arg10.equals("java.lang.Byte")) {
                                                return null;
                                            }

                                            return v3;
                                        label_169:
                                            if(!arg10.equals("java.lang.Iterable")) {
                                                return null;
                                            }

                                            return "Iterable";
                                        label_297:
                                            if(!arg10.equals("java.util.Map$Entry")) {
                                                return null;
                                            }

                                            return "Entry";
                                        label_363:
                                            if(!arg10.equals("java.lang.annotation.Annotation")) {
                                                return null;
                                            }

                                            return "Annotation";
                                        label_236:
                                            if(!arg10.equals("java.lang.Boolean")) {
                                                return null;
                                            }

                                            return v0;
                                        label_175:
                                            if(!arg10.equals("java.lang.String")) {
                                                return null;
                                            }

                                            return "String";
                                        label_303:
                                            if(!arg10.equals("kotlin.jvm.internal.LongCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_369:
                                            if(!arg10.equals("java.lang.Cloneable")) {
                                                return null;
                                            }

                                            return "Cloneable";
                                        label_241:
                                            if(!arg10.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_308:
                                            if(!arg10.equals("kotlin.jvm.internal.CharCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_181:
                                            if(!arg10.equals("java.lang.Object")) {
                                                return null;
                                            }

                                            return "Any";
                                        label_246:
                                            if(!arg10.equals("java.lang.Character")) {
                                                return null;
                                            }

                                            return v2;
                                        label_375:
                                            if(!arg10.equals("java.lang.Integer")) {
                                                return null;
                                            }

                                            return v7;
                                        label_313:
                                            if(!arg10.equals("java.lang.Short")) {
                                                return null;
                                            }

                                            return v4;
                                        label_187:
                                            if(!arg10.equals("java.lang.Number")) {
                                                return null;
                                            }

                                            return "Number";
                                        label_251:
                                            if(!arg10.equals("short")) {
                                                return null;
                                            }

                                            return v4;
                                        label_380:
                                            if(!arg10.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_318:
                                            if(!arg10.equals("java.lang.Float")) {
                                                return null;
                                            }

                                            return v5;
                                        label_256:
                                            if(!arg10.equals("float")) {
                                                return null;
                                            }

                                            return v5;
                                        label_193:
                                            if(!arg10.equals("java.lang.Double")) {
                                                return null;
                                            }

                                            return v6;
                                        label_323:
                                            if(!arg10.equals("java.util.Collection")) {
                                                return null;
                                            }

                                            return "Collection";
                                        label_261:
                                            if(!arg10.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_198:
                                            if(!arg10.equals("kotlin.jvm.internal.StringCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_329:
                                            if(!arg10.equals("java.lang.CharSequence")) {
                                                return null;
                                            }

                                            return "CharSequence";
                                        label_266:
                                            if(!arg10.equals("java.util.List")) {
                                                return null;
                                            }

                                            return "List";
                                        label_203:
                                            if(!arg10.equals("java.util.ListIterator")) {
                                                return null;
                                            }

                                            return "ListIterator";
                                        label_335:
                                            if(!arg10.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_272:
                                            if(!arg10.equals("boolean")) {
                                                return null;
                                            }

                                            return v0;
                                        label_209:
                                            if(!arg10.equals("java.util.Iterator")) {
                                                return null;
                                            }

                                            return "Iterator";
                                        label_340:
                                            if(!arg10.equals("double")) {
                                                return null;
                                            }

                                            return v6;
                                        label_277:
                                            if(!arg10.equals("long")) {
                                                return null;
                                            }

                                            return v1;
                                        label_215:
                                            if(!arg10.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_153:
                                            if(!arg10.equals("kotlin.jvm.internal.IntCompanionObject")) {
                                                return null;
                                            }

                                            return v8;
                                        label_345:
                                            if(!arg10.equals("java.util.Set")) {
                                                return null;
                                            }

                                            return "Set";
                                        label_282:
                                            if(!arg10.equals("char")) {
                                                return null;
                                            }

                                            return v2;
                                        label_220:
                                            if(!arg10.equals("java.lang.Long")) {
                                                return null;
                                            }

                                            return v1;
                                        label_158:
                                            if(!arg10.equals("java.lang.Throwable")) {
                                                return null;
                                            }

                                            return "Throwable";
                                        label_351:
                                            if(!arg10.equals("java.util.Map")) {
                                                return null;
                                            }

                                            return "Map";
                                        label_287:
                                            if(arg10.equals("byte")) {
                                                return v3;
                                            }

                                            return null;
                                        }
                                        case 80123373: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function2")) {
                                                return null;
                                            }

                                            return "Function2";
                                        }
                                        case 80123374: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function3")) {
                                                return null;
                                            }

                                            return "Function3";
                                        }
                                        case 80123375: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function4")) {
                                                return null;
                                            }

                                            return "Function4";
                                        }
                                        case 80123376: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function5")) {
                                                return null;
                                            }

                                            return "Function5";
                                        }
                                        case 80123377: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function6")) {
                                                return null;
                                            }

                                            return "Function6";
                                        }
                                        case 80123378: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function7")) {
                                                return null;
                                            }

                                            return "Function7";
                                        }
                                        case 80123379: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function8")) {
                                                return null;
                                            }

                                            return "Function8";
                                        }
                                        case 80123380: {
                                            if(!arg10.equals("kotlin.jvm.functions.Function9")) {
                                                return null;
                                            }

                                            return "Function9";
                                        }
                                        default: {
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return null;
        }
    }

    public static final Companion Companion;
    private static final Map FUNCTION_CLASSES;
    private final Class jClass;

    static {
        ClassReference.Companion = new Companion(null);
        Class[] v0 = new Class[23];
        int v2 = 0;
        v0[0] = Function0.class;
        v0[1] = Function1.class;
        v0[2] = Function2.class;
        v0[3] = Function3.class;
        v0[4] = Function4.class;
        v0[5] = Function5.class;
        v0[6] = Function6.class;
        v0[7] = Function7.class;
        v0[8] = Function8.class;
        v0[9] = Function9.class;
        v0[10] = Function10.class;
        v0[11] = Function11.class;
        v0[12] = Function12.class;
        v0[13] = Function13.class;
        v0[14] = Function14.class;
        v0[15] = Function15.class;
        v0[16] = Function16.class;
        v0[17] = Function17.class;
        v0[18] = Function18.class;
        v0[19] = Function19.class;
        v0[20] = Function20.class;
        v0[21] = Function21.class;
        v0[22] = Function22.class;
        List v0_1 = CollectionsKt.listOf(((Object[])v0));
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), 10));
        Iterator v0_2 = ((Iterable)v0_1).iterator();
        while(v0_2.hasNext()) {
            Object v3 = v0_2.next();
            int v4 = v2 + 1;
            if(v2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            ((Collection)v1).add(TuplesKt.to(v3, Integer.valueOf(v2)));
            v2 = v4;
        }

        ClassReference.FUNCTION_CLASSES = MapsKt.toMap(((Iterable)v1));
    }

    public ClassReference(Class arg2) {
        Intrinsics.checkNotNullParameter(arg2, "jClass");
        super();
        this.jClass = arg2;
    }

    public static final Map access$getFUNCTION_CLASSES$cp() {
        return ClassReference.FUNCTION_CLASSES;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof ClassReference)) && (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(((KClass)this)), JvmClassMappingKt.getJavaObjectType(((KClass)arg2))))) {
            return 1;
        }

        return 0;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    public GenericDeclaration findJavaDeclaration() {
        return this.getJClass();
    }

    public List getAnnotations() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Collection getConstructors() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Class getJClass() {
        return this.jClass;
    }

    public Collection getMembers() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Collection getNestedClasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public Object getObjectInstance() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public String getQualifiedName() {
        return ClassReference.Companion.getClassQualifiedName(this.getJClass());
    }

    public List getSealedSubclasses() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getSealedSubclasses$annotations() {
    }

    public String getSimpleName() {
        return ClassReference.Companion.getClassSimpleName(this.getJClass());
    }

    public List getSupertypes() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getSupertypes$annotations() {
    }

    public List getTypeParameters() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getTypeParameters$annotations() {
    }

    public KVisibility getVisibility() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void getVisibility$annotations() {
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(((KClass)this)).hashCode();
    }

    public boolean isAbstract() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isAbstract$annotations() {
    }

    public boolean isCompanion() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isCompanion$annotations() {
    }

    public boolean isData() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isData$annotations() {
    }

    public boolean isFinal() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isFinal$annotations() {
    }

    public boolean isFun() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isFun$annotations() {
    }

    public boolean isInner() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isInner$annotations() {
    }

    public boolean isInstance(Object arg2) {
        return ClassReference.Companion.isInstance(arg2, this.getJClass());
    }

    public boolean isOpen() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isOpen$annotations() {
    }

    public boolean isSealed() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isSealed$annotations() {
    }

    public boolean isValue() {
        this.error();
        throw new KotlinNothingValueException();
    }

    public static void isValue$annotations() {
    }

    public String toString() {
        return this.getJClass().toString() + " (Kotlin reflection is not available)";
    }
}

