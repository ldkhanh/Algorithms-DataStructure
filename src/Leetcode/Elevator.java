package Elevator;
public class Constants {}

package Elevator;
public interface IElevatorController {
	public void status();
	public Elevator getElevator(int elevatorID);
	public void update(int elevatorId, int floor);
	public void pickup(int floor, boolean direction);
	public void reset(int elevatorId, int floor);
	public void step();
}

package Elevator;
public interface ElevatorEventListener {
	public void onStopped(Object sender);
}

package Elevator;
public class Elevator {
	public enum DIRECTION {NONE, UP, DOWN}
	private DIRECTION direction = DIRECTION.NONE;
	private boolean move = false;

	private boolean[] floors;
	private int countUp = 0;
	private int countDown = 0;
	private int cf = 0;
	private int min = Constants.MIN_FLOOR;
	private int max = Constants.MAX_FLOOR;
	private int numFloors;

	private ElevatorEventListener elEventListener;

	public Elevator(int numFloors) {}
	public int getCurrentFloor() {}
	public int getGoalFloor() {}
	public void moveNext() {}
	public void setGoalFloor(int goalfloor) {}
	public void reset() {}
	public void moveToFloor() {int floor}
	public boolean getMove() {}
	public DIRECTION getDirection() {}
	public void setElEventListener(ElevatorEventListener elV) {}
}

package Elevator;

public class ElevatorController implements IElevatorController, ElevatorEventListener {
	private int numElevators;
	private int numFloors;
	private Elevator[] elevators = null;
	private ArrayList<Queue<Integer>> passengers = null;

	private void initElevators(int numElevators, int numFloors) {}
	private void initFloors(int numFloors) {}
	public ElevatorController (int numElevators, int numFloors) {}
	private int calculateRoute(int afloor, int bfloor) {}
	private int calculateRoute(int xfloor, int xefloor, int tfloor){}
	public Queue<Integer> getPassengers(int floor) {}
	public void setPassengers(Queue<Integer> passgrs, int floor) {}
	@Override
	public void status() {}
	@Override
	public Elevator getElevator(int elavatorId) {}
	@Override
	public void reset(int elevatorId, int floor) {}
	@Override
	public void pickup(int floor, boolean direction) {}
	@Override
	public void update(int elevatorId, int floor) {}
	@Override
	public void step() {}
	@Override
	public void onStopped(Object sender) {}
}

















