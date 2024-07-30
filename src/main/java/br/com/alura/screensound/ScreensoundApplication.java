package br.com.alura.screensound;

import br.com.alura.screensound.main.Main;
import br.com.alura.screensound.service.data.DataConverter;
import br.com.alura.screensound.service.data.IDataConverter;
import br.com.alura.screensound.service.repository.MusicRepository;
import br.com.alura.screensound.utils.PromptReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PromptReader promptReader = new PromptReader();
		IDataConverter dataConverter = new DataConverter();
		Main screenSoundApp = new Main(promptReader, dataConverter, musicRepository);
		screenSoundApp.run();
	}

}
