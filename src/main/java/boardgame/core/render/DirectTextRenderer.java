package boardgame.core.render;


import boardgame.core.Renderer;

/**
 * Renders a string as the object representation. An example would be using a single character to represent
 * an entity.
 */
public class DirectTextRenderer implements Renderer {
	private String value;

	public DirectTextRenderer(String value) {
		this.value = value;
	}

	@Override
	public String getResourceString() {
		return value;
	}
}
