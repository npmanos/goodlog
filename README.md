# goodlog
A data logging system for FRC Robots. Based on [badlog](https://github.com/dominikWin/badlog).

Pairs with [badlogvis](https://github.com/dominikWin/badlogvis), a visualization tool.

## Setup

**WIP**

### ~~Manual~~
~~Place `goodlog.jar` (found on GitHub release page) into a lib folder with [`json-simple-1.1.1.jar`](http://central.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar).~~

### ~~Gradle~~
**COMING SOON**

## Example
```java
public class Main {
	public static void main(String[] args) {
	
		// Init
		GoodLog log = BadLog.init("test.bag");
		{
			GoodLog.createValue("Example Value", System.getProperty("os.version"));
			
			GoodLog.createTopic("Example Topic", "Bytes", () -> (double) Runtime.getRuntime().freeMemory());
			
			GoodLog.createTopic("Topic with attributes", BadLog.UNITLESS, () -> 3.2, "attr1", "attr2");
			
			GoodLog.createTopicSubscriber("Subscribed topic", "s", DataInferMode.DEFAULT);
		}
		log.finishInitialization();
		
		// Execution
		
		for (int i = 0; i < 10; i++) {
			
			// Publish to subscribed topic
			GoodLog.publish("Subscribed topic", (double) System.nanoTime());
			
			
			log.updateTopics();
			log.log();
		}
	}
}
```

## Whitepaper
[Link](https://www.chiefdelphi.com/media/papers/3505)
