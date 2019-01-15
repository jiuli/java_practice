package OO_test;

public class SimpleBaseDTO {
    private String id;
    private Long version;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public SimpleBaseDTO() {}
	public SimpleBaseDTO(String id) {
        this.id = id;
    }
	
	public SimpleBaseDTO(String id, Long version) {
        this.id = id;
        this.version = version;
    }
}
