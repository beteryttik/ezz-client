# Ezz Client — MultiLoader каркас

Один общий код (common) + адаптеры под загрузчики: Fabric, Forge, NeoForge.
Quilt отдельно не нужен: Quilt умеет загружать Fabric-моды как есть.

## Сборка (GitHub Actions — рекомендую)
1. Загрузи всё в репозиторий на GitHub.
2. Actions запустится сам (workflow в .github/workflows/build.yml).
3. Во вкладке Actions открой запуск -> скачай артефакты EzzClient-fabric / -forge / -neoforge.
   Каждый артефакт — zip, внутри jar для соответствующего загрузчика.

Сборка локально: нужен JDK 21 и Gradle 8.10+ (`gradle build`).

## Версии Minecraft
- Каркас сейчас нацелен на 1.21.1 (fabric/forge/neoforge).
- Чтобы собрать под другую версию (1.20.1, 1.21.4, 26.x...):
  поменяй версии в gradle.properties (ссылки: fabricmc.net/develop, neoforged.net,
  files.architectury.dev). Модульная система сама разрулит совместимость:
  модули с полем minVersion выше текущей версии покажутся серыми с пометкой
  "НЕ ПОДХОДИТ ДЛЯ ДАННОЙ ВЕРСИИ".
- 1.7.10/1.8.9 — отдельная история: там нет Fabric/NeoForge, нужен отдельный
  код под Forge 1.8.9 (Java 8). Не пытайся впихнуть их в этот каркас.

## Структура
common/   — весь код клиента: модули, конфиги, темы, совместимость версий
fabric/   — точка входа Fabric
forge/    — точка входа Forge
neoforge/ — точка входа NeoForge
