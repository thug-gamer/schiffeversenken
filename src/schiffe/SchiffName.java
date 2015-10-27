package schiffe;

public enum SchiffName {
	
	SCHIFF("Schiff"),
	KREUZER("Kreuzer"),
	SCHLACHTSCHIFF("Schlachtschiff"),
	UBOOT("U-Boot"),
	ZERSTOERER("Zerstörer");
	
	private String name;
	
	private SchiffName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
