
public abstract class Card {
	
	private String name;
	private String description;
	
	public Card(String newName, String newDescription) {
		
		setName(newName);
		setDescription(newDescription);
		
	}
	
	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
