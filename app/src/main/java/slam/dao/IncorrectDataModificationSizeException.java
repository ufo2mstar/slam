package slam.dao;

import org.springframework.dao.DataAccessException;

/**
 * Created by github.com/ufo2mstar for Project:slam on 05/30/2016.
 */
public class IncorrectDataModificationSizeException extends DataAccessException {

	public IncorrectDataModificationSizeException(int expected, int actual) {
		super(String.format(
				"The wrong number of records were modified. Expected\t:%d, But Got\t: %d",
				expected, actual));
	}

	public IncorrectDataModificationSizeException(String msg) {
		super(msg);
	}

	public IncorrectDataModificationSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
