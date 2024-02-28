package io.echokk11.clashxcustomrulesautoupdater.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

@Slf4j
public class Config {
    private static final DumperOptions options = new DumperOptions();
    static {
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
    }
    private final String path;

    private final Yaml yaml;

    private final Map<String, Object> data;

    public Config(String configFilename) {
        if (StringUtils.startsWithIgnoreCase(configFilename, "/")) {
            this.path = configFilename;
        } else {
            this.path = System.getProperty("user.home") + "/.config/clash/" + configFilename;
        }
        this.yaml = new Yaml(options);
        try {
            this.data = this.yaml.load(new FileInputStream(this.path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public long lastModified() {
        return new File(path).lastModified();
    }

    public Map<String, Object> data() {
        return data;
    }

    public void flush() {
        try {
            yaml.dump(data, new FileWriter(path));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
