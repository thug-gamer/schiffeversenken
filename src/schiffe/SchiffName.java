package schiffe;

public enum SchiffName {
	
	SCHIFF("Schiff"),
	KREUZER("Kreuzer"),
	SCHLACHTSCHIFF("Schlachtschiff"),
	UBOOT("U-Boot"),
	ZERSTOERER("Zerst�rer");
	
	private String name;
	
	private SchiffName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
