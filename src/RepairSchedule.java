import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        /* to be implemented in part (a) */
        numberOfMechanics = n;
        schedule = new ArrayList<CarRepair>();

    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        /* to be implemented in part (b) */
        for(CarRepair time : schedule){
            if(time.getMechanicNum() == m || time.getBayNum() == b){
                return false;
            }
        }
        schedule.add(new CarRepair(m,b));
        return true;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        /* to be implemented in part (c) */
        ArrayList<Integer> mecNums = new ArrayList<Integer>();
        for (int i = 0; i < numberOfMechanics; i++) {
            boolean notFound = true;
            for (CarRepair event: schedule) {
                if (event.getMechanicNum() == i){
                    notFound = false;
                }
            }
            if (notFound){
                mecNums.add(i);
            }

        }
        return mecNums; // STUB VALUE
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}