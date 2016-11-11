package sla.manager.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.UUID;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Enumerated;
import sla.manager.type.StatusType;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Event {

    /**
     */
    private UUID id;

    /**
     */
    private UUID correlationId;

    /**
     */
    private String eventType;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date estimatedTimeOfArrival;

    /**
     */
    private UUID parentId;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date createdTime;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date modifiedTime;

    /**
     */
    @Enumerated
    private StatusType status;
}

