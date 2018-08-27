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
import com.github.nilankamanoj.system.model.Job;
import serv.JobServ;

@Controller
@RequestMapping(path = "/job")
public class JobCnt{
	@Autowired
	private JobServ jobServ;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Job> jobs = jobServ.findAll();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Job job = jobServ.findOne(id);
		return new ResponseEntity<>(job, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Job job) {
		Job newJob = jobServ.save(job);
		return new ResponseEntity<>( newJob, HttpStatus.OK);
	}
}