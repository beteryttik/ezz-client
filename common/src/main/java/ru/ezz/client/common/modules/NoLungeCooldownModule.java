package ru.ezz.client.common.modules;

import ru.ezz.client.common.module.Module;

/** Ezz-эксклюзив: убирает кулдаун рывка (Lunge) копья. Только 1.21.11+.
 *  Работает в одиночке/на своих серверах; строгие сервера могут валидировать рывок сами. */
public class NoLungeCooldownModule extends Module {
    public NoLungeCooldownModule() {
        super("nolungecooldown", "No Lunge Cooldown", "OTHER",
                "Убирает кулдаун рывка копья (Lunge). Требуется 1.21.11+", "1.21.11");
    }
}
