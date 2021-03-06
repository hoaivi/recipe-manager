package psu.team1.common;

import org.jsoup.nodes.Document;

/**
 * @author Steve
 */
public class Recipe {
	private String name;
	private int numServings;
	private IngredientList ingredients;
	private InstructionList instructions;

	// TODO cost
	// TODO nutrition

	/**
	 * @param name
	 * @param numServings
	 * @param ingredients
	 * @param instructions
	 */
	public Recipe(String name, int numServings, IngredientList ingredients,
			InstructionList instructions) {
		this.name = name;
		this.numServings = numServings;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the numServings
	 */
	public int getNumServings() {
		return numServings;
	}

	/**
	 * @return the ingredients
	 */
	public IngredientList getIngredients() {
		return ingredients;
	}

	/**
	 * @return the instructions
	 */
	public InstructionList getInstructions() {
		return instructions;
	}

	/**
	 * @param document
	 * @return
	 */
	public static Recipe parseFrom(Document document) {
		int numServings = 0; // TODO temporary

		String name = document.getElementsByAttributeValue("id", "page-title")
				.get(0).text();
		IngredientList ingredients = IngredientList.parseFrom(document);
		InstructionList instructions = InstructionList.parseFrom(document);

		return new Recipe(name, numServings, ingredients, instructions);
	}
}
