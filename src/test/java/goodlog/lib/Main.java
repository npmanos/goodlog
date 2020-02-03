package goodlog.lib;

public class Main {
	public static void main(String[] args) {
		GoodLog log = GoodLog.init("test.bag");
		{
			GoodLog.createValue("Example Value", System.getProperty("os.version"));
			
			GoodLog.createTopic("Example Topic", "Bytes", () -> (double) Runtime.getRuntime().freeMemory());

			GoodLog.createTopic("Topic with attributes", GoodLog.UNITLESS, () -> 3.2, "attr1", "attr2");
			
			GoodLog.createTopicSubscriber("Subscribed topic", "s", DataInferMode.DEFAULT);
		}
		log.finishInitialization();
		
		for (int i = 0; i < 10; i++) {
			// Publish to subscribed topic
			GoodLog.publish("Subscribed topic", (double) System.nanoTime());

			log.updateTopics();
			log.log();
		}
	}
}
