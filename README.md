# sample

issue link: https://github.com/jenkinsci/remoting-opentelemetry-plugin/issues/21

## Reproduce error

1.

```
mvn hpi:run
```

2. Connect node with JNLP


3. Disconnect the node

- kill server or push disconnect button on the node page.

### Expected result

Print the following string to the agent stdout

```
(1.0, 4.0)
```

### Actual

We will get this error and the agent will stop

```
SEVERE: org/apache/commons/math3/complex/Complex
java.lang.NoClassDefFoundError: org/apache/commons/math3/complex/Complex
	at io.jenkins.plugins.SampleCommand$SampleListener.status(SampleCommand.java:28)
	at hudson.remoting.EngineListenerSplitter.status(EngineListenerSplitter.java:26)
	at hudson.remoting.Engine.innerRun(Engine.java:774)
	at hudson.remoting.Engine.run(Engine.java:514)
Caused by: java.lang.ClassNotFoundException: org.apache.commons.math3.complex.Complex
	at java.base/java.net.URLClassLoader.findClass(URLClassLoader.java:471)
	at hudson.remoting.RemoteClassLoader.findClass(RemoteClassLoader.java:176)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:589)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 4 more
```
