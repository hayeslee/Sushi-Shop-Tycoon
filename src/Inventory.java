/**
 * Keeps track of inventory data including, inventory bought, used and spoiled.
 * It keeps track of the next batch that will spoil and how long it will spoil
 * in. Items used by the chef will always be taken from the next batch about to
 * spoil.
 * 
 * @author Jeffrey Wang and Hayes Lee 
 * @version June 11, 2014
 * 
 */
public class Inventory
{
	private int amount; // how much the restaurant has in stock
	private int spoilTime; // time it takes to spoil
	private int nextBatchToSpoil;
	private int minDaysToSpoil;
	private int[] daysToSpoil = new int[1000];
	private int[] noInBatch = new int[1000];
	private int batchCounter = 0;
	private int amountSpoiled;

	/**
	 * Creates a new inventory item
	 * 
	 * @param name
	 */
	public Inventory(String INVENTORY_ITEMS, int spoilTime)
	{
		this.amount = 0;
		this.spoilTime = spoilTime;
		this.batchCounter = 0;
		this.nextBatchToSpoil = 0;
	}

	/**
	 * Adds bought batch to inventory and sets its days to spoil
	 * 
	 * @param noBought
	 */
	public void bought(int noBought)
	{
		this.amount += noBought;
		this.daysToSpoil[batchCounter] = spoilTime;
		this.noInBatch[batchCounter] = noBought;
		batchCounter++;
	}

	/**
	 * Spoils the amount of goods that have spoiled
	 * 
	 * @param spoiled
	 */
	public int spoil()
	{

		// Subtract one day from the days to spoil for each batch
		for (int batch = 0; batch < noInBatch.length; batch++)
		{
			if (noInBatch[batch] != 0)
				daysToSpoil[batch]--;
		}

		// For each batch, if it is spoiled (daysToSpoil = 0), subtract the
		// amount in the batch from the total
		// amount of the item and set the batch to 0
		for (int batch = 0; batch < batchCounter; batch++)
		{
			if (daysToSpoil[batch] == 0)
			{
				amount -= noInBatch[batch];
				amountSpoiled = noInBatch[batch];
				noInBatch[batch] = 0;
			}
		}
		return amountSpoiled;

	}

	/**
	 * Subtracts the items used by the chefs
	 * 
	 * @param referenceCode the reference code of the item used
	 * @param amountUsed the amount of items used
	 */
	public void used()
	{
		this.amount--;

		// Find next batch that will spoil
		this.minDaysToSpoil = Integer.MAX_VALUE;
		for (int batch = 0; batch < batchCounter; batch++)
			if (daysToSpoil[batch] < minDaysToSpoil && daysToSpoil[batch] != 0)
			{
				this.nextBatchToSpoil = batch;
				minDaysToSpoil = daysToSpoil[batch];
			}
		// Subtract used item from next batch that will spoil
		noInBatch[nextBatchToSpoil]--;
	}

	/**
	 * Check if there is sufficient inventory to make a dish
	 * 
	 * @return whether or not there is sufficient inventory
	 */
	public boolean sufficientInventory()
	{
		if (this.amount <= 0)
			return false;
		return true;
	}

	/**
	 * Checks to see if the inventory item is out of stock
	 * @return true if the amount is 0 (out of stock)
	 */
	public boolean outOfStock()
	{
		return amount == 0;
	}

	/**
	 * Finds the amount of the current inventory item 
	 * @return amount of the current inventory item
	 */
	public int getAmount()
	{
		return amount;
	}
}
