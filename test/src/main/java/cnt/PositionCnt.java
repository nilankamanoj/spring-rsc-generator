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
import com.github.nilankamanoj.system.model.Position;
import serv.PositionServ;

@Controller
@RequestMapping(path = "/position")
public class PositionCnt{
	@Autowired
	private PositionServ positionServ;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Position> positions = positionServ.findAll();
		return new ResponseEntity<>(positions, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Position position = positionServ.findOne(id);
		return new ResponseEntity<>(position, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Position position) {
		Position newPosition = positionServ.save(position);
		return new ResponseEntity<>( newPosition, HttpStatus.OK);
	}
}