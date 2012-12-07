package todo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {
	private String Status;

	/**
	 * @param status
	 */
	public Status(String status) {
		
		Status = status;
	}

	/**
	 * 
	 */
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Status [Status=" + Status + "]";
	}
}
