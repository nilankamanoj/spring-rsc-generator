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
import com.github.nilankamanoj.system.model.User;
import serv.UserServ;

@Controller
@RequestMapping(path = "/user")
public class UserCnt{
	@Autowired
	private UserServ userServ;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<User> users = userServ.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		User user = userServ.findOne(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody User user) {
		User newUser = userServ.save(user);
		return new ResponseEntity<>( newUser, HttpStatus.OK);
	}
}