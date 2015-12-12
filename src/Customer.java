import java.awt.Color;

/**
 * Keeps track of customer's information including their likeliness to buy a
 * more expensive item and buy a second item. One class to represent all
 * customers, values will be randomly generated.
 * 
 * @author Jeffrey Wang and Hayes Lee
 * @version June 11, 2014
 * 
 */
public class Customer
{
	// Variables
	private int[] items = { 0, 1, 2, 3, 4 };
	private int[] rebuy = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int maxPrice = 15;
	private int rebuyIncreaseCounter; 
	private Color shirtColor;

	/**
	 * Constructs a customer
	 * 
	 */
	public Customer()
	{
		this.rebuyIncreaseCounter = 1;
	}

	/**
	 * Makes the customer randomly choose an item to buy
	 * 
	 * @return the number code of the item to buy
	 */
	public int chooseItem()
	{
		return items[(int) (Math.random() * 5)];
	}

	/**
	 * Determines whether or not the customer thinks the price is too expensive
	 * 
	 * @param price
	 * @return whether or not the price is too expensive
	 */
	public boolean tooExpensive(int price)
	{
		if (price > this.maxPrice)
			return true;
		else
			return false;
	}

	/**
	 * Increases the maximum price a customer will buy at
	 */
	public void maxPriceIncrease()
	{
		this.maxPrice++;
	}

	/**
	 * Makes the customer randomly choose whether or not to buy another item
	 * 
	 * @return 1 if the customer is buying another item, 0 if not
	 */
	public boolean buyAgain()
	{
		if (rebuy[(int) (Math.random() * 10)] == 1)
			return true;
		return false;
	}

	/**
	 * Increases the chance that the customer will buy another dish
	 * 
	 */
	public void increaseRebuy()
	{
		rebuy[rebuyIncreaseCounter] = 1;
		rebuyIncreaseCounter++;
	}

}
