package refactoring;

import java.util.logging.Logger;

class Page {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Registry {
    public boolean deleteReference(String name) {
        return true;
    }
}

class ConfigKeys {
    public boolean deleteKey(String name) {
        return true;
    }
}

class Processor {
//    private static final int E_OK = 1;
//    private static final int E_ERROR = 2;
    private final Registry registry = new Registry();
    private final ConfigKeys configKeys = new ConfigKeys();
    private final Logger logger = Logger.getLogger(Processor.class.getName());

    public void delete(Page page) {
        if (deletePage(page)) {
            if (registry.deleteReference(page.getName())) {
                if (configKeys.deleteKey(page.getName())) {
                    logger.info("page deleted");
                } else {
                    logger.info("configKey not deleted");
                }
            } else {
                logger.info("deleteReference from registry failed");
            }
        } else {
            logger.info("delete failed");
        }


    }

    private boolean deletePage(Page page) {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%4$s %2$s %5$s%6$s%n");
        Page page = new Page();
        page.setName("Some info");
        Processor processor = new Processor();
        processor.delete(page);
    }
}