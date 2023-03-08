package io.echokk11.clashxcustomrulesautoupdater.boot;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AutoUpdater {
    @Value("${clashx.main}")
    public String main;
    @Value("${clashx.custom}")
    public String custom;

    private static final long SLEEP = 15L;
    private long mainLastModified;
    private long customLastModified;

    @PostConstruct
    public void onload() throws InterruptedException {
        while (true) {
            if (mainLastModified > 0 && mainLastModified != new Config(main).lastModified()) {
                merge();
            }
            mainLastModified = new Config(main).lastModified();

            if (customLastModified > 0 && customLastModified != new Config(custom).lastModified()) {
                merge();
            }
            customLastModified = new Config(custom).lastModified();

            TimeUnit.SECONDS.sleep(SLEEP);
        }

    }

    public void merge() {
        log.info("start merging");
        List<String> myRules = (List<String>) new Config(custom).data().get("rules");
        log.info("find custom rules {}", myRules.size());
        Config config = new Config(main);
        List<String> rules = (List<String>) config.data().get("rules");
        log.info("find official rules {}", rules.size());
        Iterator<String> it = myRules.iterator();
        while (it.hasNext()) {
            String r = it.next();
            if (rules.contains(r)) {
                it.remove();
            }
        }
        rules.addAll(0, myRules);
        config.data().put("rules", rules);
        config.flush();
        log.info("merging completed {} rules", rules.size());
    }

}
