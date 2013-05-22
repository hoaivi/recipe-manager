package psu.team1.recipescraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import psu.team1.common.Recipe;

/**
 * @author Steve
 */
public class USDAScraper {

	private static String baseUrl = "http://recipefinder.nal.usda.gov";
	private static String browseRecipeUrl = baseUrl + "/recipes";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<Recipe> recipes = new ArrayList<Recipe>();
			Document document = Jsoup.connect(browseRecipeUrl).get();
			Elements aboutElements = document.getElementsByAttribute("about");
			for (Element aboutElement : aboutElements) {
				try {
					String recipeUrlPiece = aboutElement.attr("about");
					recipes.add(scrapeRecipe(baseUrl + recipeUrlPiece));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param recipeUrl
	 * @throws IOException
	 */
	private static Recipe scrapeRecipe(String recipeUrl) throws IOException {
		Document document = Jsoup.connect(recipeUrl).get();

		return Recipe.parseFrom(document);
	}
}
