# Introduction

The logging module has one class <b>MLogger</b> that 
gets used in a static way to easily log application 
states during runtime by using the <i>java.util.logging</i>
package.

Without any further settings the usage results in a log file
in the sub folder <i>./logs</i> with name <b>Application.log</b>. Only
errors get reported. 

```
MLogger.getInstance().log(...);
```

To change that the log file and the trace level can be adjusted.

```
MLogger.getInstance().setLogFile("logs" + File.separator + "Test.log");
MLogger.getInstance().setTraceLevel(Level.ALL);
```
 
Now warnings and information gets logged as well and a new log file
gets used as storage.

A common usage is to log when an exception occurred. In this case
the error gets logged with type severe.

```
try {
    // Action
} catch(Exception e) {
    MLogger.getInstance().log(Level.SEVERE, e);
}
```

It is also possible to change the log file size in KB and number of
days to write to the same log file until it gets archived.

```
MLogger.getInstance().setLogSizeLimit(10000);
MLogger.getInstance().setLogKeepAge(10);
```

This sets a maximum file size of 10 MB that gets archived after 10 days in the parent directory with timestamp 
in its name.