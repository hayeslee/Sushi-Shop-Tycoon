/**
 * Keeps track of chef information including remaining sushi output.
 * 
 * @author Jeffrey Wang and Hayes Lee 
 * @version June 11, 2014 
 * 
 */
public class Chef
{
	int maxDailyOutput;
	int remainingOutput;

	/**
	 * Creates a Chef
	 * 
	 * @param dailyOutput
	 */
	public Chef(int dailyOutput)
	{
		this.maxDailyOutput = dailyOutput;
		this.remainingOutput = dailyOutput;
	}

	/**
	 * Chef makes a dish if has remaining output and loses a remaining output
	 * 
	 * @return whether or not the dish was made
	 */
	public boolean makeDish()
	{
		if (remainingOutput > 0)
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * Resets the chef's dailyOutput at the start of a new day
	 * 
	 */
	public void newDay()
	{
		this.remainingOutput = maxDailyOutput;
	}

	/**
	 * Upgrades the chef, giving it 10 more max daily output
	 * 
	 */
	public void upgrade()
	{
		this.maxDailyOutput += 10;
	}

}
