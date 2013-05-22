package psu.team1.common;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Steve
 */
public class IngredientList {
	private List<IngredientItem> ingredients;

	/**
	 * @param ingredients
	 */
	public IngredientList(List<IngredientItem> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return
	 */
	public List<IngredientItem> getIngredients() {
		return ingredients;
	}

	/**
	 * @param document
	 * @return
	 */
	public static IngredientList parseFrom(Document document) {
		List<IngredientItem> ingredients = new ArrayList<IngredientItem>();
		Elements ingredientRows = document.getElementsByAttributeValue("rel",
				"v:ingredient");
		for (Element ingredientRow : ingredientRows) {
			Element quantityElement = ingredientRow
					.getElementsByAttributeValue("class", "quantity-unit").get(
							0);
			Element ingredientNameElement = ingredientRow
					.getElementsByAttributeValue("class", "ingredient-name")
					.get(0);

			String name = ingredientNameElement.text();
			Unit unit = null;
			double quantity = 0;
			String quantityText = quantityElement.text();
			for (Unit unitItem : Unit.values()) {
				if (quantityText.contains(unitItem.toString())) {
					unit = unitItem;
					break;
				}
			}

			if (unit == null) {
				quantity = Double.parseDouble(quantityText.trim());
			}

			IngredientItem item = new IngredientItem(name, quantity, unit);
			ingredients.add(item);
		}

		return new IngredientList(ingredients);
	}
}
