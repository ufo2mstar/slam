package slam.dao.support;

import java.util.Date;
import java.sql.Timestamp;

public class DaoDataMappingUtil {

	public static Timestamp toSqlTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
