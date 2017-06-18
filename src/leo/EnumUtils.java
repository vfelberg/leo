package leo;

import java.util.HashMap;
import java.util.Map;

public class EnumUtils {
    public static <E extends Enum<E>> Map<String,E> getEnumMap(Class<E> enumClass) {
        /*
        der plan
        1. erzeuge eine map
        2. hole alle enums aus enumClass -> array
        3. iteriere über das array; laufvariable ist vom typ Enum, dieser typ hat einen namen
        Enum e;
        map.put(e.name(), e)
        4. put in die map, name als schlüssel, enum als value
        5. return die map
         */
        Map<String, E> map = new HashMap<>();
        E[] enums = enumClass.getEnumConstants();
        for(Enum e : enums){
            map.put(e.name(), (E) e);
        }
        return map;
    }
}
