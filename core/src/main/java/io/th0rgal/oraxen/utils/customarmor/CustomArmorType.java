package io.th0rgal.oraxen.utils.customarmor;

import io.th0rgal.oraxen.config.Settings;
import io.th0rgal.oraxen.utils.VersionUtil;
import io.th0rgal.oraxen.utils.logs.Logs;

public enum CustomArmorType {
    NONE, SHADER, TRIMS, COMPONENT;

    public static CustomArmorType getSetting() {
        return fromString(Settings.CUSTOM_ARMOR_TYPE.toString());
    }

    public static CustomArmorType fromString(String type) {
        try {
            CustomArmorType customArmorType = CustomArmorType.valueOf(type.toUpperCase());
            if (!VersionUtil.atOrAbove("1.21.2") && customArmorType == COMPONENT) {
                Logs.logError("Component based custom armor is only supported in 1.21.2 and above.");
                throw new IllegalArgumentException();
            } else if (!VersionUtil.atOrAbove("1.20") && customArmorType == CustomArmorType.TRIMS) {
                Logs.logError("Trim based custom armor is only supported in 1.20 and above.");
                throw new IllegalArgumentException();
            } else if (VersionUtil.atOrAbove("1.21.2") && customArmorType == CustomArmorType.SHADER) {
                Logs.logError("SHADER based CustomArmor is currently not supported on 1.21.2 and above.");
                throw new IllegalArgumentException();
            }
            return customArmorType;
        } catch (IllegalArgumentException e) {
            CustomArmorType defaultType = VersionUtil.atOrAbove("1.21.2") ? COMPONENT : VersionUtil.atOrAbove("1.20") ? TRIMS : NONE;
            Logs.logError("Invalid custom armor type: " + type);
            Logs.logError("Defaulting to %s.".formatted(defaultType));
            return defaultType;
        }
    }
}
