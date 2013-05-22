package psu.team1.common;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

/**
 * @author Steve
 */
public class InstructionList {
	private List<String> instructions;

	/**
	 * @param instructions
	 */
	public InstructionList(List<String> instructions) {
		this.instructions = instructions;
	}

	/**
	 * @return
	 */
	public List<String> getInstructions() {
		return instructions;
	}

	/**
	 * @param document
	 * @return
	 */
	public static InstructionList parseFrom(Document document) {
		// TODO

		return new InstructionList(new ArrayList<String>());
	}
}
