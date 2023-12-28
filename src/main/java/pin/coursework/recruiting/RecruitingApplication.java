package pin.coursework.recruiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RecruitingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitingApplication.class, args);
	}

}

@Component
class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Open the browser when the application is ready
		browse("http://localhost:8080");
	}

	private void browse(String url) {
		try {
			// Open the default web browser
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}