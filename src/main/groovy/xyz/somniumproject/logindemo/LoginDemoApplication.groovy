package xyz.somniumproject.logindemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import xyz.somniumproject.logindemo.configuracion.BootStrap

@SpringBootApplication
class LoginDemoApplication implements ApplicationRunner{
	@Autowired
	BootStrap bootStrap;
	static void main(String[] args) {
		SpringApplication.run (LoginDemoApplication, args)
	}

	@Override
	void run(ApplicationArguments args) throws Exception {
		bootStrap.init()
	}
}
