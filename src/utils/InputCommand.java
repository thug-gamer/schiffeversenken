package utils;

public enum InputCommand {

	GETMAP("getmap"),
	CREATEUBOOT("createuboot");
	
	private String command;
	private InputCommand(String command) {
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
}
