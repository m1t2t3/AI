package lab1; 

public class Percept {
	private String agentLocation;
	private lab1.Environment.LocationState state;

	public Percept(String agentLocation, lab1.Environment.LocationState locationState) {
		this.agentLocation = agentLocation;
		this.state = locationState;
	}

	public lab1.Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
}