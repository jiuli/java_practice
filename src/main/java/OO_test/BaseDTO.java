package OO_test;

import java.time.ZonedDateTime;

public class BaseDTO extends SimpleBaseDTO{
	public BaseDTO(){
		//
	}
	public BaseDTO(String id, Long version, String createdBy) {
		super(id, version);
		this.createdBy = createdBy;
	}
	private ZonedDateTime createdTime;
    private String createdBy;
    private ZonedDateTime updatedTime;
    private String updatedBy;
    
    public void copy(BaseDTO baseDTO) {
        //this.id = tempTask.getId();//never setId, it must be generated
        super.setVersion(baseDTO.getVersion());
        this.createdBy = baseDTO.getCreatedBy();
    }

	public ZonedDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(ZonedDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public ZonedDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(ZonedDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
    
    
}
