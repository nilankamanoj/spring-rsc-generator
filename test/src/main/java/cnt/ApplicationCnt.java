package cnt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import com.github.nilankamanoj.system.model.Application;
import serv.ApplicationServ;

@Controller
@RequestMapping(path = "/application")
public class ApplicationCnt{
	@Autowired
	private ApplicationServ applicationServ;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Application> applications = applicationServ.findAll();
		return new ResponseEntity<>(applications, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Application application = applicationServ.findOne(id);
		return new ResponseEntity<>(application, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Application application) {
		Application newApplication = applicationServ.save(application);
		return new ResponseEntity<>( newApplication, HttpStatus.OK);
	}
}