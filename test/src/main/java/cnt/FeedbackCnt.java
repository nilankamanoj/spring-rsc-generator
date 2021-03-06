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
import com.github.nilankamanoj.system.model.Feedback;
import serv.FeedbackServ;

@Controller
@RequestMapping(path = "/feedback")
public class FeedbackCnt{
	@Autowired
	private FeedbackServ feedbackServ;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Feedback> feedbacks = feedbackServ.findAll();
		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Feedback feedback = feedbackServ.findOne(id);
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Feedback feedback) {
		Feedback newFeedback = feedbackServ.save(feedback);
		return new ResponseEntity<>( newFeedback, HttpStatus.OK);
	}
}