package lab1;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		 String currentLocation = Environment.LOCATION_A;
		 int score = 0;
		        // The agent's logic for decision-making based on perception goes here
		        if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {
		        	score += 500;
		        	return Environment.SUCK_DIRT;
		            
		        } else if (currentLocation.equals(Environment.LOCATION_A)) {
		            currentLocation = Environment.LOCATION_B;
		            score -=10;
		            return Environment.MOVE_RIGHT;
		        } else {
		            currentLocation = Environment.LOCATION_A;
		            score -=10;

		            return Environment.MOVE_LEFT;
		        }

		
	}
}