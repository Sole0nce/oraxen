package io.th0rgal.oraxen.utils;

import net.kyori.adventure.key.Key;
import org.apache.commons.lang3.RegExUtils;

public class KeyUtils {

    public static final Key MALFORMED_KEY_PLACEHOLDER = Key.key("item/barrier");

    public static Key dropExtension(Key key) {
        return dropExtension(key.asString());
    }

    public static Key dropExtension(String key) {
        if (!Key.parseable(key)) return MALFORMED_KEY_PLACEHOLDER;
        return Key.key(RegExUtils.replacePattern(key, ".*(.json|.png)", ""));
    }
}
