package Utilities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class Logs{

    public static Logger log = (Logger) LogManager.getLogger(Logs.class.getName());


    public static void startTestcase(String testcaseName){
        log.setLevel(Level.INFO);
        log.info("================================================Starting the testcase : "+testcaseName);
    }

    public static void EndTestcase(String testcaseName){
        log.setLevel(Level.INFO);
        log.info("==================================================Ending the testcase : "+testcaseName);
    }

    public static void info(String infoMessage){
        log.setLevel(Level.INFO);
        log.info(infoMessage);
    }

    public static void Warn(String WarningMessage){
        log.setLevel(Level.INFO);
        log.warn(WarningMessage);
    }

    public static void Debug(String DebugMessage){
        log.setLevel(Level.DEBUG);
        log.debug(DebugMessage);
    }

    public static void Error(String ErrorMessage){
        log.setLevel(Level.INFO);
        log.error(ErrorMessage);
    }

    public static void fatalError(String fatalErrorMessage){
        log.setLevel(Level.INFO);
        log.fatal(fatalErrorMessage);
    }

}
