package com.corpora.assesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.corpora.assesment.entity.User;
import com.corpora.assesment.entity.UserContact;
import com.corpora.assesment.service.UserService;
import com.corpora.model.UserContactVO;

@SpringBootApplication
public class AssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssesmentApplication.class, args);
	}
	
	@Component
	class DemoCommandLineRunner implements CommandLineRunner{
	
		@Autowired
		private UserService userService;
	
		@Override
		public void run(String... args) throws Exception {
			if(userService.getUsers().isEmpty()){
				User a = new User("abc", "dzaky", 24);
				UserContact aa = new UserContact((a.getName()+a.getId()),"Depok, Jawa Barat", a);
				UserContactVO aaa = new UserContactVO(a.getId(), a.getName(), a.getAge(), aa.getAddress());
				userService.saveUserAndContact(aaa);
				User b = new User("def", "syaddad", 21);
				UserContact bb = new UserContact((b.getName()+b.getId()),"Jakarta, DKI Jakarta", b);
				UserContactVO bbb = new UserContactVO(b.getId(), b.getName(), b.getAge(), bb.getAddress());
				userService.saveUserAndContact(bbb);
				User c = new User("gih", "ahmad", 19);
				UserContact cc = new UserContact((c.getName()+c.getId()),"Bogor, Jawa Barat", c);
				UserContactVO ccc = new UserContactVO(c.getId(), c.getName(), c.getAge(), cc.getAddress());
				userService.saveUserAndContact(ccc);
			}
			
		}
	}
}
