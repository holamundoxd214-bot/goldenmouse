# Golden Mouse Pro - Rebuild

Proyecto reconstruido de Golden Mouse Pro con código descompilado usando JEB.

## 🔓 Modificaciones Aplicadas

### Patches de Licencia
1. **LicenseManager.isAuthorized()** - Siempre retorna `true`
2. **LicenseManager.authorizeSession()** - Siempre retorna `true`
3. **LicenseApplication** - Bypass de verificación al inicio
4. **GameStartKt** - Bypass al seleccionar juego
5. **FloatingService** - Bypass al iniciar servicio
6. **KadbInjectionBackend** - Bypass para inyector de input
7. **GoldenInputServiceConnection** - Bypass para servicio Shizuku

### Resultado
- ✅ App funciona sin licencia
- ✅ Mouse y teclado funcionan
- ✅ **Todas las features premium desbloqueadas**
- ✅ Botones de TEXTOX y DPI desbloqueados

## 🏗️ Compilar

### Localmente (Linux/Mac)
```bash
./gradlew assembleDebug
```

### Localmente (Windows)
```powershell
.\gradlew.bat assembleDebug
```

### GitHub Actions
El proyecto se compila automáticamente en cada push. Los APKs están disponibles en la sección **Actions** del repositorio.

## 📦 Estructura

```
GoldenMousePro_Rebuild/
├── app/
│   ├── src/main/
│   │   ├── java/              # Código fuente de JEB
│   │   ├── res/               # Recursos
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── .github/workflows/
│   └── build.yml              # GitHub Actions workflow
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## ⚙️ Requisitos

- JDK 17
- Android SDK API 34
- Gradle 8.0+

## 📝 Notas

- El código fue descompilado con JEB Decompiler para mejor calidad
- Algunos archivos pueden tener sintaxis incorrecta de JEB que necesitan corrección manual
- Los recursos fueron extraídos con APKTool
- Compilar en Linux/Mac es más confiable que en Windows

## 🚀 Instalación del APK

1. Descarga el APK de la sección **Actions** o compílalo localmente
2. Desinstala la versión original (si existe)
3. Instala el APK modificado
4. ¡Disfruta todas las features desbloqueadas!

## ⚠️ Advertencia

Este proyecto es solo para propósitos educativos. Respeta los derechos del desarrollador original.
