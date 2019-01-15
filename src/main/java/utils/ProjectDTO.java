package utils;
import java.io.Serializable;
import java.util.Date;

public class ProjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1773397794586931548L;
	private Date endDate;
    private Date startDate;
	private String projectId;
    private String projectName;
    private Double designNumber;
    
    public ProjectDTO(String projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ProjectDTO(String projectId, String projectName, Date startDate, Date endDate,Double designNumber) {
		super();
		this.endDate = endDate;
		this.startDate = startDate;
		this.projectId = projectId;
		this.projectName = projectName;
		this.designNumber = designNumber;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Double getDesignNumber() {
		return designNumber;
	}

	public void setDesignNumber(Double designNumber) {
		this.designNumber = designNumber;
	}
	
}
