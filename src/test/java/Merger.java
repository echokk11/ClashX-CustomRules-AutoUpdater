import io.echokk11.clashxcustomrulesautoupdater.boot.Config;

import java.util.List;

public class Merger {
    public static void main(String[] args) {
        Config config = new Config("myRules.yaml");
        List rules = (List) config.data().get("rules");
        System.out.println(rules.size());

        Config config1 = new Config("myRules1.yaml");
        List rules1 = (List) config1.data().get("rules");
        rules1.forEach(r -> {
            if (!rules.contains(r)) {
                rules.add(r);
            }
        });
        System.out.println(rules.size());
        rules.forEach(r -> {
            System.out.println("- '" + r + "'");
        });
    }
}
